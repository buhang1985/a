package iih.bd.mhi.hptreatdircomp.s.bp.adapter;

import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDO;
import iih.bd.mhi.hptreatdircomp.d.HpTreatDirCompDTO;
import xap.mw.core.data.Context;

/**
 * 适配器
 * @author dj.zhang
 *
 */
public class HpTreatDirCompDOAdapter {

	public HpTreatDirCompDO getTreatdircompDO(String hpId, HpTreatDirCompDTO compDTO) {
		HpTreatDirCompDO hpTreatDirCompDO = new HpTreatDirCompDO();
		hpTreatDirCompDO.setId_comp_treat(compDTO.getId_treatcomp());
		hpTreatDirCompDO.setId_grp(Context.get().getGroupId());
		hpTreatDirCompDO.setId_org(Context.get().getOrgId());
		hpTreatDirCompDO.setId_hp(hpId);
		hpTreatDirCompDO.setId_treat(compDTO.getId_treat());
		hpTreatDirCompDO.setCode(compDTO.getCode());
		hpTreatDirCompDO.setDt_approved(compDTO.getDt_approved());
		hpTreatDirCompDO.setCreatedby(compDTO.getCreatedby());
		hpTreatDirCompDO.setCreatedtime(compDTO.getCreatedtime());
		hpTreatDirCompDO.setModifiedby(compDTO.getModifiedby());
		hpTreatDirCompDO.setModifiedtime(compDTO.getModifiedtime());
		hpTreatDirCompDO.setSv(compDTO.getSv());
		return hpTreatDirCompDO;
	}

}
