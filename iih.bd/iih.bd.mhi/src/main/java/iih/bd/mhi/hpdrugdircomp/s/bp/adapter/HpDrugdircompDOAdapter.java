package iih.bd.mhi.hpdrugdircomp.s.bp.adapter;

import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDTO;
import xap.mw.core.data.Context;

/**
 * 
 * 适配器
 * 
 * @author hexx
 * 
 */
public class HpDrugdircompDOAdapter {

	public HpDrugDirCompDO getHpDrugDirCompDO(String hpId, HpDrugDirCompDTO compDTO) {
		HpDrugDirCompDO drugdircompDO = new HpDrugDirCompDO();
		drugdircompDO.setId_comp_drug(compDTO.getId_drugcomp());
		drugdircompDO.setId_grp(Context.get().getGroupId());
		drugdircompDO.setId_org(Context.get().getOrgId());
		drugdircompDO.setId_hp(hpId);
		drugdircompDO.setId_drug(compDTO.getId_drug());
		drugdircompDO.setCode(compDTO.getCode());
		drugdircompDO.setDt_approved(compDTO.getDt_approved());
		drugdircompDO.setCreatedby(compDTO.getCreatedby());
		drugdircompDO.setCreatedtime(compDTO.getCreatedtime());
		drugdircompDO.setModifiedby(compDTO.getModifiedby());
		drugdircompDO.setModifiedtime(compDTO.getModifiedtime());
		drugdircompDO.setSv(compDTO.getSv());
		return drugdircompDO;
	}
}
