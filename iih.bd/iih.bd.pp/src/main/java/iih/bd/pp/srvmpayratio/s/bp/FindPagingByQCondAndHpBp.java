package iih.bd.pp.srvmpayratio.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.srvmpayratio.d.SrvMPayRatioDO;
import iih.bd.pp.srvmpayratio.d.desc.SrvMPayRatioDODesc;
import iih.bd.pp.srvmpayratio.i.ISrvmpayratioRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和医保计划查询医保项目多支付比例分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQCondAndHpBp {

	public PagingRtnData<SrvMPayRatioDO> exec(HPDO hpdo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(hpdo, qryRootNodeDto);
		PagingRtnData<SrvMPayRatioDO> result = FindPagingByWherePart(wherePart, pg);
		return result;
	}

	/**
	 * 根据医保计划和查询方案获取条件语句
	 * 
	 * @param hpdo
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(HPDO hpdo, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart;
		if (hpdo != null) {
			wherePart = String.format(" and id_hp = '%s'", hpdo.getId_hp());
			wherePartBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, SrvMPayRatioDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 根据条件语句查询医保项目多支付比例分页数据
	 * 
	 * @param wherePart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SrvMPayRatioDO> FindPagingByWherePart(String wherePart, PaginationInfo pg)
			throws BizException {
		String orderByPart = "id_srv";

		ISrvmpayratioRService srvmpayratioRService = ServiceFinder.find(ISrvmpayratioRService.class);
		PagingRtnData<SrvMPayRatioDO> result = srvmpayratioRService.findByPageInfo(pg, wherePart, orderByPart);
		return result;
	}

}
