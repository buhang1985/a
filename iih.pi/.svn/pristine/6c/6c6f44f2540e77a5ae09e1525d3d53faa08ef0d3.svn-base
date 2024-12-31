package iih.pi.dic.patcate.s.bp.adapter;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.Context;

/**
 * 适配器
 * 
 * @author dj.zhang
 *
 */
public class PiPatCaHpDOAdapter {

	public PiPatCaHpDO getPiPatCaHpDO(PatCateUIDTO patCateUIDTO, PiPatCaDO patCaDO, PiPatCaHpDO piPatCaHpDo) {
		PiPatCaHpDO piPatCaHpDO = piPatCaHpDo;
		if (piPatCaHpDo == null) {
			piPatCaHpDO = new PiPatCaHpDO();
		}
		piPatCaHpDO.setId_grp(Context.get().getGroupId());
		piPatCaHpDO.setId_org(Context.get().getOrgId());
		piPatCaHpDO.setId_hp(patCateUIDTO.getId_hp());
		piPatCaHpDO.setName_hp(patCateUIDTO.getHp_name());
		piPatCaHpDO.setId_patca(patCaDO.getId_patca());
		piPatCaHpDO.setId_hpkind(patCateUIDTO.getId_hpkind());
		piPatCaHpDO.setName_hpkind(patCateUIDTO.getHpkind_name());
		piPatCaHpDO.setFg_fundpay(patCateUIDTO.getFg_fundpay());
		piPatCaHpDO.setFg_hp_card(patCateUIDTO.getFg_hp_card());
		piPatCaHpDO.setId_hppatsource(patCateUIDTO.getId_hppatsource());
		piPatCaHpDO.setSd_hppatsource(patCateUIDTO.getSd_hppatsource());
		piPatCaHpDO.setId_medkind_oepdft(patCateUIDTO.getId_medkind_oepdft());
		piPatCaHpDO.setFg_self_upload(patCateUIDTO.getFg_self_upload());
		piPatCaHpDO.setEu_ident_read(patCateUIDTO.getEu_ident_read());
		return piPatCaHpDO;
	}

}
