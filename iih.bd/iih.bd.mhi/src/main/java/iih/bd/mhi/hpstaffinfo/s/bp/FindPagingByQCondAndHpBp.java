package iih.bd.mhi.hpstaffinfo.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpstaffinfo.d.HpStaffInfoDO;
import iih.bd.mhi.hpstaffinfo.d.desc.HpStaffInfoDODesc;
import iih.bd.mhi.hpstaffinfo.i.IHpstaffinfoRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据医保产品主键和查询方案查询操作员权限分页数据业务逻辑
 * 
 * @author gaoxn
 *
 */
public class FindPagingByQCondAndHpBp {

	public PagingRtnData<HpStaffInfoDO> exec(QryRootNodeDTO qryRootNodeDTO, String hpId, String orderStr,
			PaginationInfo pg) throws BizException {

		String wherePart = getWherePart(qryRootNodeDTO, hpId);
		PagingRtnData<HpStaffInfoDO> result = findPagingByWherePart(wherePart, orderStr, pg);
		return result;
	}

	private String getWherePart(QryRootNodeDTO qryRootNodeDTO, String hpId) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder("1 = 1");
		// 1.如果医保产品主键不空，则拼接到条件语句中
		if (StringUtils.isNotEmpty(hpId)) {
			String wherePart = String.format(" AND ID_HP = '%s'", hpId);
			sqlBuilder.append(wherePart);
		}

		// 2.将查询方案转换为条件语句，如果不为空，则拼接到条件语句中
		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, HpStaffInfoDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

	// 根据条件查询并分页
	private PagingRtnData<HpStaffInfoDO> findPagingByWherePart(String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		// 1.调用基础服务查询分页数据
		IHpstaffinfoRService iHpopepermapplyRService = ServiceFinder.find(IHpstaffinfoRService.class);
		PagingRtnData<HpStaffInfoDO> result = iHpopepermapplyRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

}