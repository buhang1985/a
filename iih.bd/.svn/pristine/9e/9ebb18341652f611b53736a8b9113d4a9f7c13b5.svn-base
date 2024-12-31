package iih.bd.pp.anhuiinsur.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.anhuiinsur.d.BdHpDiOrginalDO;
import iih.bd.pp.anhuiinsur.d.desc.BdHpDiOrginalDODesc;
import iih.bd.pp.anhuiinsur.i.IBdhpdiorginalRService;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.hp.i.IHpRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据医保产品逐主键和查询方案查询医保产品药品目录分页数据
 * 
 * @author hao_wu
 *
 */
public class FindDiPagingByHpIdAndQCondBp {

	public PagingRtnData<BdHpDiOrginalDO> exec(String hpId, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		if (StringUtils.isEmpty(hpId)) {
			throw new BizException("医保产品主键不允许为空。");
		}

		String wherePart = getWherePart(hpId, qryRootNodeDTO);

		IBdhpdiorginalRService bdhpdiorginalRService = ServiceFinder.find(IBdhpdiorginalRService.class);
		PagingRtnData<BdHpDiOrginalDO> result = bdhpdiorginalRService.findByPageInfo(pg, wherePart, orderStr);
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
		IHpMDORService hpService = ServiceFinder.find(IHpMDORService.class);
		HPDO hp = hpService.findById(hpId);
		if(hp != null && StringUtils.isNotBlank(hp.getId_refhp())){
			wherePart = String.format(" (id_hp = '%s' or id_hp = '%s' ) ", hpId,hp.getId_refhp());
		}
		wherePartBuilder.append(wherePart);
		
		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, BdHpDiOrginalDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
