package iih.pi.dic.patcate.s.bp.adapter;

import iih.pi.dic.patcate.d.PatCateUIDTO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.Context;

/**
 * 适配器
 * 
 * @author dj.zhang
 *
 */
public class PiPatCaDOAdapter {

	public PiPatCaDO getPiPatCaDO(PatCateUIDTO patCateUIDTO, PiPatCaDO piPatCaDo) {
		PiPatCaDO piPatCaDO = piPatCaDo;
		if (piPatCaDo == null) {
			piPatCaDO = new PiPatCaDO();
		}
		piPatCaDO.setId_grp(Context.get().getGroupId());
		piPatCaDO.setId_org(Context.get().getOrgId());
		piPatCaDO.setCode(patCateUIDTO.getCode());
		piPatCaDO.setName(patCateUIDTO.getName());
		piPatCaDO.setWbcode(patCateUIDTO.getWbcode());
		piPatCaDO.setPycode(patCateUIDTO.getPycode());
		piPatCaDO.setMnecode(patCateUIDTO.getMnecode());
		piPatCaDO.setDes(patCateUIDTO.getDes());
		piPatCaDO.setId_patcrettp(patCateUIDTO.getId_patcrettp());
		piPatCaDO.setId_patpritp(patCateUIDTO.getId_patpritp());
		piPatCaDO.setId_parent(patCateUIDTO.getId_parent());
		piPatCaDO.setFg_def(patCateUIDTO.getFg_def());
		piPatCaDO.setCode_chis(patCateUIDTO.getCode_chis());
		piPatCaDO.setFg_op(patCateUIDTO.getFg_op());
		piPatCaDO.setFg_er(patCateUIDTO.getFg_er());
		piPatCaDO.setFg_ip(patCateUIDTO.getFg_ip());
		piPatCaDO.setFg_pe(patCateUIDTO.getFg_pe());
		piPatCaDO.setFg_fm(patCateUIDTO.getFg_fm());
		piPatCaDO.setSortno(patCateUIDTO.getSortno());
		piPatCaDO.setFg_use_er1(patCateUIDTO.getFg_use_er1());
		piPatCaDO.setFg_use_er2(patCateUIDTO.getFg_use_er2());
		return piPatCaDO;
	}

}
