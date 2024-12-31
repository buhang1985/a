package iih.ci.mrfp.hospitalfirstpagedto.d;

import xap.mw.core.data.BaseDTO;

/**
 * mrfpqcdto DTO数据 
 * 
 */
public class MrfpQcDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	/**
	 * id
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 质控医生/护士编码
	 * @return String
	 */
	public String getCode_empqc() {
		return ((String) getAttrVal("Code_empqc"));
	}	
	/**
	 * 质控医生/护士编码
	 * @param Code_empqc
	 */
	public void setCode_empqc(String Code_empqc) {
		setAttrVal("Code_empqc", Code_empqc);
	}
	/**
	 * 质控角色编码
	 * @return String
	 */
	public String getCode_role_empqc() {
		return ((String) getAttrVal("Code_role_empqc"));
	}	
	/**
	 * 质控角色编码
	 * @param Code_role_empqc
	 */
	public void setCode_role_empqc(String Code_role_empqc) {
		setAttrVal("Code_role_empqc", Code_role_empqc);
	}
	/**
	 * 质控角色名称
	 * @return String
	 */
	public String getName_role_empqc() {
		return ((String) getAttrVal("Name_role_empqc"));
	}	
	/**
	 * 质控角色名称
	 * @param Name_role_empqc
	 */
	public void setName_role_empqc(String Name_role_empqc) {
		setAttrVal("Name_role_empqc", Name_role_empqc);
	}
	/**
	 * 质控医生/护士名称
	 * @return String
	 */
	public String getName_empqc() {
		return ((String) getAttrVal("Name_empqc"));
	}	
	/**
	 * 质控医生/护士名称
	 * @param Name_empqc
	 */
	public void setName_empqc(String Name_empqc) {
		setAttrVal("Name_empqc", Name_empqc);
	}
}