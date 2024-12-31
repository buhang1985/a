package iih.bd.srv.dto.d;

import xap.mw.core.data.*;

/**
 * 人员、科室、全院 、就诊类型 DTO数据 
 * 
 */
public class Emp2Dep2GroupDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	public void setId_emp(String id_emp) {
		setAttrVal("Id_emp", id_emp);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	public void setName_emp(String name_emp) {
		setAttrVal("Name_emp", name_emp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	public void setId_dep(String id_dep) {
		setAttrVal("Id_dep", id_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	public void setName_dep(String name_dep) {
		setAttrVal("Name_dep", name_dep);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	public void setId_org(String id_org) {
		setAttrVal("Id_org", id_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	public void setName_org(String name_org) {
		setAttrVal("Name_org", name_org);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
}