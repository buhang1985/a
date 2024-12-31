package iih.bd.srv.mrbasetpl.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.mrbasetpl.d.EmrBaseTplDO;
import iih.bd.srv.mrbasetpl.d.desc.EmrBaseTplDODesc;
import iih.bd.srv.mrbasetpl.i.IMrbasetplRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据条件语句、查询模板、分页信息查询分页数据集合业务逻辑
 * 
 * @author dj.zhang
 *
 */
public class FindPagingDataByQCondAndWherePartBp {

	public PagingRtnData<EmrBaseTplDO> exec(String wherePart, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		String wherePart1 = getWherePart(wherePart, qryRootNodeDTO);
		PagingRtnData<EmrBaseTplDO> result = findPagingByWherePart(wherePart1, orderStr, pg);
		return result;
	}

	/**
	 * 根据条件语句查询分页数据
	 * 
	 * @param wherePart
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<EmrBaseTplDO> findPagingByWherePart(String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		IMrbasetplRService mrbasetplRService = ServiceFinder.find(IMrbasetplRService.class);
		PagingRtnData<EmrBaseTplDO> result = mrbasetplRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param wherPart
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(String wherPart, QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotEmpty(wherPart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherPart);
		}

		if (qryRootNodeDTO != null) {
			String wherePart1 = SqlUtils.getWherePartByQCond(qryRootNodeDTO, EmrBaseTplDODesc.CLASS_FULLNAME);
			if (StringUtils.isNotEmpty(wherePart1)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart1);
			}
		}
		return wherePartBuilder.toString();
	}

}
