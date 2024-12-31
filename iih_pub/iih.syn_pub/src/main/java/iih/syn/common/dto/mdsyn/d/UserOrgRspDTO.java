package iih.syn.common.dto.mdsyn.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 用户组织职责关系 DTO数据 
 * 
 */
public class UserOrgRspDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户id
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}
	/**
	 * 用户id
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	/**
	 * 人员id
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}
	/**
	 * 人员id
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 职责id
	 * @return String
	 */
	public String getId_resp() {
		return ((String) getAttrVal("Id_resp"));
	}
	/**
	 * 职责id
	 * @param Id_resp
	 */
	public void setId_resp(String Id_resp) {
		setAttrVal("Id_resp", Id_resp);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
}