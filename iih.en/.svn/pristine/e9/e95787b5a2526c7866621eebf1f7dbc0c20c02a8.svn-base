package iih.en.er.bp.rescue;

import iih.en.er.dto.d.UrgNurBlInfoDTO;
import iih.en.er.dto.d.UrgNurErInfoDTO;
import iih.en.er.dto.d.UrgNurPatInfoDTO;
import iih.en.er.dto.d.UrgNurRightDTO;
import xap.mw.core.data.BizException;

public class GetRescueRightInfoByIdEntBP {
	/***
	 * 获取急诊留观护士站床位卡右侧信息
	 * 
	 * @param id_ent 就诊id
	 * @return
	 * @throws BizException 
	 */
	public UrgNurRightDTO exec(String id_ent) throws BizException{
		GetRescueNurPatInfoBP patbl = new GetRescueNurPatInfoBP();
		GetRescueNurBlInfoBP blbp = new GetRescueNurBlInfoBP();
		GetRescueNurErInfoBP erbp = new GetRescueNurErInfoBP();
		UrgNurRightDTO urgNurRightDTO = new UrgNurRightDTO();
		UrgNurPatInfoDTO patInfoDTO = patbl.getNurPatInfo(id_ent);
		UrgNurBlInfoDTO blInfoDTO = blbp.getNurBlInfo(id_ent);
		UrgNurErInfoDTO erInfoDTO = erbp.getNurErInfo(id_ent);
		urgNurRightDTO.setUrgNurPatInfoDTO(patInfoDTO);
		urgNurRightDTO.setUrgNurBlInfoDTO(blInfoDTO);
		urgNurRightDTO.setUrgNurErInfoDTO(erInfoDTO);
		return urgNurRightDTO;
	}
}
