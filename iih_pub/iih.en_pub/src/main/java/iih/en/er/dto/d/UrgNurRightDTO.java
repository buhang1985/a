package iih.en.er.dto.d;

import xap.mw.core.data.BaseDTO;
/***
 * 急诊留观护士站-右侧信息DTO
 * 
 * @author fanlq
 *
 */
public class UrgNurRightDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 急诊留观护士站-患者就诊信息 DTO数据
	 * 
	 * @return UrgNurPatInfoDTO
	 */
	public UrgNurPatInfoDTO getUrgNurPatInfoDTO() {
		return ((UrgNurPatInfoDTO) getAttrVal("UrgNurPatInfoDTO"));
	}
	/**
	 * 急诊留观护士站-患者就诊信息 DTO数据
	 * 
	 * @param UrgNurPatInfoDTO
	 */
	public void setUrgNurPatInfoDTO(UrgNurPatInfoDTO UrgNurPatInfoDTO) {
		setAttrVal("UrgNurPatInfoDTO", UrgNurPatInfoDTO);
	}
	
	/**
	 * 急诊留观护士站-患者费用信息 DTO数据 
	 * 
	 * @return UrgNurBlInfoDTO
	 */
	public UrgNurBlInfoDTO getUrgNurBlInfoDTO() {
		return ((UrgNurBlInfoDTO) getAttrVal("UrgNurBlInfoDTO"));
	}
	/**
	 * 急诊留观护士站-患者费用信息 DTO数据 
	 * 
	 * @param UrgNurBlInfoDTO
	 */
	public void setUrgNurBlInfoDTO(UrgNurBlInfoDTO UrgNurBlInfoDTO) {
		setAttrVal("UrgNurBlInfoDTO", UrgNurBlInfoDTO);
	}
	/**
	 * 急诊留观护士站-急诊信息 DTO数据
	 * 
	 * @return UrgNurErInfoDTO
	 */
	public UrgNurErInfoDTO getUrgNurErInfoDTO() {
		return ((UrgNurErInfoDTO) getAttrVal("UrgNurErInfoDTO"));
	}
	/**
	 * 急诊留观护士站-急诊信息 DTO数据
	 * 
	 * @param UrgNurErInfoDTO
	 */
	public void setUrgNurErInfoDTO(UrgNurErInfoDTO UrgNurErInfoDTO) {
		setAttrVal("UrgNurErInfoDTO", UrgNurErInfoDTO);
	}
}
