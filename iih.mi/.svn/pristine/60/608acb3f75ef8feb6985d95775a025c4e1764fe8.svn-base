package iih.mi.mibd.drug.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.drug.d.DrugDO;
import iih.mi.mibd.drug.d.desc.DrugDODesc;
import iih.mi.mibd.drug.i.IDrugRService;
import iih.mi.mibd.mis.d.MisDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保平台_项目AggDO数据扩展服务实现对应bp
 * 
 * @author hexx
 *
 */
public class FindPagingByMisAndQCondBp {

	public PagingRtnData<DrugDO> exec(MisDO mis, QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg)
			throws BizException {

		String wherePart = getWherePart(mis, qryRootNodeDto);
		PagingRtnData<DrugDO> result = findPagingByWherePart(wherePart, orderStr, pg);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param oppDimen
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(MisDO mis, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		String wherePart;
		if (mis != null) {
			wherePart = String.format(" and Id_mis = '%s'", mis.getId_mis());
			wherePartBuilder.append(wherePart);
		}
		if (qryRootNodeDto != null) {
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, DrugDODesc.CLASS_FULLNAME);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" and ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
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
	private PagingRtnData<DrugDO> findPagingByWherePart(String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		IDrugRService drugRService = ServiceFinder.find(IDrugRService.class);
		PagingRtnData<DrugDO> result = drugRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}
}
