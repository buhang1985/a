package iih.ci.ord.i.mqmsg.meta;

import iih.ci.ord.i.common.b.BaseCiDTO;

/**
 * 护士待确认消息
 * @author HUMS
 *
 */
public class NurseWaitConfirmMsgDTO extends BaseCiDTO{

	private static final long serialVersionUID = 1L;	
	
	/**
	 * 待确认消息类型，签署确认、作废确认、停止确认
	 * @return String
	 */
	public String getWait_config_msgtype() {
		return ((String) getAttrVal("Wait_config_msgtype"));
	}
	/**
	 * 待确认消息类型
	 * @param Name_dep_ns
	 */
	public void setWait_config_msgtype(String Wait_config_msgtype) {
		setAttrVal("Wait_config_msgtype", Wait_config_msgtype);
	}
	
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_ns() {
		return ((String) getAttrVal("Id_dep_ns"));
	}
	/**
	 * 病区
	 * @param Id_dep_ns
	 */
	public void setId_dep_ns(String Id_dep_ns) {
		setAttrVal("Id_dep_ns", Id_dep_ns);
	}
	
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_ns() {
		return ((String) getAttrVal("Name_dep_ns"));
	}
	/**
	 * 病区
	 * @param Name_dep_ns
	 */
	public void setName_dep_ns(String Name_dep_ns) {
		setAttrVal("Name_dep_ns", Name_dep_ns);
	}
	
	/**
	 * 床号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床号
	 * @param Bed_NO
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Bed_NO
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	
	/**
	 * 患者
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	
	/**
	 * 医嘱内容
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	
	/**
	 * 开立医生
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	
	/**
	 * 开立科室
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	
	/**
	 * 诊断
	 * @return String
	 */
	public String getDiag_name() {
		return ((String) getAttrVal("Diag_name"));
	}
	/**
	 * 诊断
	 * @param Diag_name
	 */
	public void setDiag_name(String Diag_name) {
		setAttrVal("Diag_name", Diag_name);
	}
}
