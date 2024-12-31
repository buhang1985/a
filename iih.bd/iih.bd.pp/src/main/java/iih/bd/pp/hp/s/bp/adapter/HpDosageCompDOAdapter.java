package iih.bd.pp.hp.s.bp.adapter;

import iih.bd.mhi.dto.d.HpDosageCompDTO;
import iih.bd.pp.hp.d.HpDosageDO;
import xap.mw.core.data.Context;

/**
 * 适配器
 * 
 * @author dj.zhang
 *
 */
public class HpDosageCompDOAdapter {

	public HpDosageDO getDosageCompDO(String hpId, HpDosageCompDTO compDTO) {
		HpDosageDO hpDosageDO = new HpDosageDO();
		hpDosageDO.setId_hp_dosage(compDTO.getId_hp_dosage());
		hpDosageDO.setId_hp(hpId);
		hpDosageDO.setId_dosage(compDTO.getId_dosage());
		hpDosageDO.setCode_hp(compDTO.getCode_hp());
		hpDosageDO.setName_hp(compDTO.getName_hp());
		hpDosageDO.setId_grp(Context.get().getGroupId());
		hpDosageDO.setId_org(Context.get().getOrgId());
		hpDosageDO.setPycode(compDTO.getPycode());
		hpDosageDO.setWbcode(compDTO.getWbcode());
		hpDosageDO.setMnecode(compDTO.getMnecode());
		hpDosageDO.setSv(compDTO.getSv());
		hpDosageDO.setId_hpdosage(compDTO.getId_hpdosage());
		
		return hpDosageDO;
	}

}
