package iih.bd.pp.hp.s.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.d.desc.BdHpPatcaDODesc;
import iih.bd.pp.hp.i.IBdHpPatcaDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据医保计划主键和查询方案查询医保患者身份分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByHpAndQCondBp {

	public PagingRtnData<BdHpPatcaDO> exec(String hpId, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		if (StringUtil.isEmpty(hpId)) {
			throw new BizException("医保计划主键不允许为空。");
		}

		PagingRtnData<BdHpPatcaDO> result = findPagingByHpAndQCondBp(hpId, qryRootNodeDTO, orderStr, pg);
		return result;
	}

	/**
	 * 根据医保计划主键和查询方案查询医保患者身份分页数据
	 * 
	 * @param hpId
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpPatcaDO> findPagingByHpAndQCondBp(String hpId, QryRootNodeDTO qryRootNodeDTO,
			String orderStr, PaginationInfo pg) throws BizException {
		String wherePart = getWherePart(hpId, qryRootNodeDTO);
		PagingRtnData<BdHpPatcaDO> result = findPagingByWherePart(wherePart, orderStr, pg);
		return result;
	}

	/**
	 * 根据条件语句查询医保患者身份分页数据
	 * 
	 * @param wherePart
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpPatcaDO> findPagingByWherePart(String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		IBdHpPatcaDORService bdHpPatcaDORService = ServiceFinder.find(IBdHpPatcaDORService.class);
		PagingRtnData<BdHpPatcaDO> result = bdHpPatcaDORService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param hpId
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(String hpId, QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("id_hp = '%s'", hpId);
		wherePartBuilder.append(wherePart);

		if (qryRootNodeDTO != null) {
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, BdHpPatcaDODesc.CLASS_FULLNAME);
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}
}
