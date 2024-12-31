package iih.mi.bd.s.dp;

import java.util.ArrayList;

import iih.bd.pp.hp.d.HPDO;
import iih.mi.bd.d.HpDTO;

/**
 * 转换医保产品DO到医保产品DTO数据逻辑
 * 
 * @author hao_wu
 *
 */
public class ConvertHpDoToHpDTODp {

	public HpDTO[] exec(HPDO[] hpDos) {
		if (hpDos == null || hpDos.length <= 0) {
			return null;
		}

		ArrayList<HpDTO> hpDtoList = new ArrayList<HpDTO>();
		for (HPDO hpdo : hpDos) {
			HpDTO hpDTO = convertToHpDTO(hpdo);
			hpDtoList.add(hpDTO);
		}
		return hpDtoList.toArray(new HpDTO[0]);
	}

	/**
	 * 转换HpDo为HpDto
	 * 
	 * @param hpdo
	 * @return
	 */
	private HpDTO convertToHpDTO(HPDO hpdo) {
		HpDTO hpDto = new HpDTO();
		hpDto.setId_hp(hpdo.getId_hp());
		hpDto.setId_grp(hpdo.getId_grp());
		hpDto.setId_org(hpdo.getId_org());
		hpDto.setCode(hpdo.getCode());
		hpDto.setName(hpdo.getName());
		hpDto.setFg_active(hpdo.getFg_active());
		hpDto.setFg_prepay(hpdo.getFg_prepay());
		hpDto.setFg_cardst(hpdo.getFg_cardst());
		hpDto.setFg_hpcg(hpdo.getFg_hpcg());
		hpDto.setDes(hpdo.getDes());
		return hpDto;
	}
}
