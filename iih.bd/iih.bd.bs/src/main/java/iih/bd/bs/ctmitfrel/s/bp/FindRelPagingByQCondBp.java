package iih.bd.bs.ctmitfrel.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bs.ctmitfrel.d.CtmItfRelDO;
import iih.bd.bs.ctmitfrel.s.bp.qry.FindRelByItfsQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案查询自定义接口和实现类关系分页数据
 * 
 * @author hao_wu 2019-6-14
 *
 */
public class FindRelPagingByQCondBp {

	public PagingRtnData<CtmItfRelDO> exec(QryRootNodeDTO qryRootNodeDto, String orderPart, String wherePart,
			PaginationInfo pg) throws BizException {

		String whereStr = getWherePart(wherePart, qryRootNodeDto);

		FindRelByItfsQry qry = new FindRelByItfsQry(whereStr);
		PagingServiceImpl<CtmItfRelDO> pagingServiceImpl = new PagingServiceImpl<CtmItfRelDO>();
		PagingRtnData<CtmItfRelDO> pagingRtnData = pagingServiceImpl.findByPageInfo(new CtmItfRelDO(), pg,
				qry.getQrySQLStr(), orderPart, qry.getQryParameter(null));

		FArrayList pageDataList = pagingRtnData.getPageData();
		if (pageDataList != null) {
			for (Object obj : pageDataList) {
				CtmItfRelDO relDo = (CtmItfRelDO) obj;
				if (StringUtils.isBlank(relDo.getId_ctmitfrel())) {
					relDo.setStatus(DOStatus.NEW);
				}
			}
		}

		return pagingRtnData;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param wherePart
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(String wherePart, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotBlank(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (qryRootNodeDto != null) {
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto);
			if (StringUtils.isNotBlank(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}

}
