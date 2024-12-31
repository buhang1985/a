package iih.ci.mrfp.hospitalfirstpagedto.d;

import xap.mw.core.data.BaseDTO;

/**
 * pathologydto DTO数据 
 * 
 */
public class MrfpPathologyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * dtoid
	 * @return String
	 */
	public String getId_pathology() {
		return ((String) getAttrVal("Id_pathology"));
	}	
	/**
	 * dtoid
	 * @param Id_pathology
	 */
	public void setId_pathology(String Id_pathology) {
		setAttrVal("Id_pathology", Id_pathology);
	}
	/**
	 * 疾病描述
	 * @return String
	 */
	public String getName_pathology() {
		return ((String) getAttrVal("Name_pathology"));
	}	
	/**
	 * 疾病描述
	 * @param Name_pathology
	 */
	public void setName_pathology(String Name_pathology) {
		setAttrVal("Name_pathology", Name_pathology);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getCode_pathology() {
		return ((String) getAttrVal("Code_pathology"));
	}	
	/**
	 * 疾病编码
	 * @param Code_pathology
	 */
	public void setCode_pathology(String Code_pathology) {
		setAttrVal("Code_pathology", Code_pathology);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getNumber_pathology() {
		return ((String) getAttrVal("Number_pathology"));
	}	
	/**
	 * 病历号
	 * @param Number_pathology
	 */
	public void setNumber_pathology(String Number_pathology) {
		setAttrVal("Number_pathology", Number_pathology);
	}
}