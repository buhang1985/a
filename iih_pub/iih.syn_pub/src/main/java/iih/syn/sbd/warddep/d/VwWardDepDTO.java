package iih.syn.sbd.warddep.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病区科室对照 DTO数据 
 * 
 */
public class VwWardDepDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区ID
	 * @return String
	 */
	public String getId_ward() {
		return ((String) getAttrVal("Id_ward"));
	}
	/**
	 * 病区ID
	 * @param Id_ward
	 */
	public void setId_ward(String Id_ward) {
		setAttrVal("Id_ward", Id_ward);
	}
	/**
	 * 病区编号
	 * @return String
	 */
	public String getCode_ward() {
		return ((String) getAttrVal("Code_ward"));
	}
	/**
	 * 病区编号
	 * @param Code_ward
	 */
	public void setCode_ward(String Code_ward) {
		setAttrVal("Code_ward", Code_ward);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_ward() {
		return ((String) getAttrVal("Name_ward"));
	}
	/**
	 * 病区名称
	 * @param Name_ward
	 */
	public void setName_ward(String Name_ward) {
		setAttrVal("Name_ward", Name_ward);
	}
	/**
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室编号
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 科室编号
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
}