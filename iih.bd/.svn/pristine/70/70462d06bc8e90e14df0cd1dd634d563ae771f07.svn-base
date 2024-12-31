package iih.bd.pp.anhuiinsur.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpZlOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IBdhpzlorginalRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据医保产品逐主键和查询方案查询医保产品诊疗目录分页数据
 * 
 * @author hao_wu
 *
 */
public class FindTreatPagingByHpIdAndQCondBp {

	public PagingRtnData<BdHpZlOrginalDO> exec(String hpId, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {

		if (StringUtils.isEmpty(hpId)) {
			throw new BizException("医保产品主键不允许为空。");
		}

		String wherePart = getWherePart(hpId, qryRootNodeDTO);

		IBdhpzlorginalRService bdhpzlorginalRService = ServiceFinder.find(IBdhpzlorginalRService.class);
		PagingRtnData<BdHpZlOrginalDO> result = bdhpzlorginalRService.findByPageInfo(pg, wherePart, orderStr);
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

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, BdHpZlOrginalDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
