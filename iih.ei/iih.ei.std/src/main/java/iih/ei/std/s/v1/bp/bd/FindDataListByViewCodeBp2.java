package iih.ei.std.s.v1.bp.bd;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.ArrayListUtil;
import iih.ei.std.d.v1.bd.comm.d.EiBdQryWsParamDTO;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据视图编码查询数据列表
 * 
 * @author hao_wu 2019-12-6
 *
 * @param <LT>
 * @param <T>
 */
public class FindDataListByViewCodeBp2<LT extends BaseDTO, T extends BaseDTO> {

	private Class<LT> _listClass;
	private Class<T> _dataClass;
	private String _arrayFieldName;

	public FindDataListByViewCodeBp2(Class<LT> listClass, Class<T> dataClass, String arrayFieldName) {
		this._listClass = listClass;
		this._dataClass = dataClass;
		this._arrayFieldName = arrayFieldName;
	}

	public LT exec(String dbViewCode, EiBdQryWsParamDTO paramDto) throws BizException {

		LT listData = this.getInstance(this._listClass);

		String sql = String.format("select * from %s", dbViewCode);

		if (paramDto.getQuerynode() != null) {
			BuildWherePartByQueryNodeDtoBP bp = new BuildWherePartByQueryNodeDtoBP();
			String wherePart = bp.exec(paramDto.getQuerynode());
			if (StringUtils.isNotBlank(wherePart)) {
				sql = String.format("%s where %s", sql, wherePart);
			}
		}

		PageInfoDTO pageInfoDto = paramDto.getPageinfo();
		if (pageInfoDto != null && pageInfoDto.getPagesize() != null && pageInfoDto.getPageindex() != null) {
			PagingRtnData<T> pagingRtnData = this.findByPageInfo(sql, pageInfoDto);

			listData.setAttrVal(this._arrayFieldName, pagingRtnData.getPageData());

			PaginationInfo pageInfo = pagingRtnData.getPagingInfo();
			pageInfoDto = (PageInfoDTO) pageInfoDto.clone();
			pageInfoDto.setPagecount(pageInfo.getPageCount());
			pageInfoDto.setRecordscount(pageInfo.getRecordsCount());
			pageInfoDto.setPageindex(pageInfo.getPageIndex() + 1);
			listData.setAttrVal("Pageinfo", pageInfoDto);
		} else {
			List<T> dataList = this.find(sql);
			FArrayList fList = ArrayListUtil.ConvertToFArrayList(dataList);

			listData.setAttrVal(this._arrayFieldName, fList);
		}

		return listData;
	}

	private PagingRtnData<T> findByPageInfo(String sql, PageInfoDTO pageInfoDTO) throws BizException {
		T nullData = getInstance(this._dataClass);

		PaginationInfo pageInfo = new PaginationInfo();
		pageInfo.setPageSize(pageInfoDTO.getPagesize());
		pageInfo.setPageIndex(pageInfoDTO.getPageindex() - 1);

		PagingServiceImpl<T> pagingService = new PagingServiceImpl<T>();
		PagingRtnData<T> rtnData = pagingService.findByPageInfo(nullData, pageInfo, sql, "", null);

		return rtnData;
	}

	@SuppressWarnings("unchecked")
	private List<T> find(String sql) throws BizException {

		DAFacade daFacade = new DAFacade();
		List<T> dataList = (List<T>) daFacade.execQuery(sql, new BeanListHandler(this._dataClass));
		return dataList;
	}

	private <RT> RT getInstance(Class<RT> dataClass) throws BizException {
		RT data = null;
		try {
			data = dataClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			String msg = String.format("创建实例失败,全类名:%s", dataClass.getName());
			throw new BizException(msg, e);
		}
		return data;
	}
}
