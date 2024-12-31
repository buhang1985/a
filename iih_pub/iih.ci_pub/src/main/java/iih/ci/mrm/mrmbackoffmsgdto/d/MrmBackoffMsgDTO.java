package iih.ci.mrm.mrmbackoffmsgdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案退回消息 DTO数据 
 * 
 */
public class MrmBackoffMsgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 回退消息主键id
	 * @return String
	 */
	public String getId_backoff() {
		return ((String) getAttrVal("Id_backoff"));
	}
	/**
	 * 回退消息主键id
	 * @param Id_backoff
	 */
	public void setId_backoff(String Id_backoff) {
		setAttrVal("Id_backoff", Id_backoff);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 患者科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 患者科室名
	 * @return String
	 */
	public String getDep_phy_name() {
		return ((String) getAttrVal("Dep_phy_name"));
	}
	/**
	 * 患者科室名
	 * @param Dep_phy_name
	 */
	public void setDep_phy_name(String Dep_phy_name) {
		setAttrVal("Dep_phy_name", Dep_phy_name);
	}
	/**
	 * 操作人员id
	 * @return String
	 */
	public String getId_dep_doc() {
		return ((String) getAttrVal("Id_dep_doc"));
	}
	/**
	 * 操作人员id
	 * @param Id_dep_doc
	 */
	public void setId_dep_doc(String Id_dep_doc) {
		setAttrVal("Id_dep_doc", Id_dep_doc);
	}
	/**
	 * 操作人员名称
	 * @return String
	 */
	public String getName_dep_doc() {
		return ((String) getAttrVal("Name_dep_doc"));
	}
	/**
	 * 操作人员名称
	 * @param Name_dep_doc
	 */
	public void setName_dep_doc(String Name_dep_doc) {
		setAttrVal("Name_dep_doc", Name_dep_doc);
	}
	/**
	 * 退回原因
	 * @return String
	 */
	public String getBackoff_reason() {
		return ((String) getAttrVal("Backoff_reason"));
	}
	/**
	 * 退回原因
	 * @param Backoff_reason
	 */
	public void setBackoff_reason(String Backoff_reason) {
		setAttrVal("Backoff_reason", Backoff_reason);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 责任医师id
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}
	/**
	 * 责任医师id
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 责任医师
	 * @return String
	 */
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}
	/**
	 * 责任医师
	 * @param Emp_phy_name
	 */
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
	}
}