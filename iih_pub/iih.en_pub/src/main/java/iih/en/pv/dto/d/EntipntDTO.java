package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 入院通知单DTO DTO数据 
 * 
 */
public class EntipntDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 病人编号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 病人编号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}
	/**
	 * 电话
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 家庭地址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 家庭地址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getSd_patcardtp() {
		return ((String) getAttrVal("Sd_patcardtp"));
	}
	/**
	 * 证件类型
	 * @param Sd_patcardtp
	 */
	public void setSd_patcardtp(String Sd_patcardtp) {
		setAttrVal("Sd_patcardtp", Sd_patcardtp);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getSd_patcardtp_code() {
		return ((String) getAttrVal("Sd_patcardtp_code"));
	}
	/**
	 * 证件号
	 * @param Sd_patcardtp_code
	 */
	public void setSd_patcardtp_code(String Sd_patcardtp_code) {
		setAttrVal("Sd_patcardtp_code", Sd_patcardtp_code);
	}
	/**
	 * 病情状况id
	 * @return String
	 */
	public String getId_status_pat() {
		return ((String) getAttrVal("Id_status_pat"));
	}
	/**
	 * 病情状况id
	 * @param Id_status_pat
	 */
	public void setId_status_pat(String Id_status_pat) {
		setAttrVal("Id_status_pat", Id_status_pat);
	}
	/**
	 * 病情状况
	 * @return String
	 */
	public String getSd_status_pat() {
		return ((String) getAttrVal("Sd_status_pat"));
	}
	/**
	 * 病情状况
	 * @param Sd_status_pat
	 */
	public void setSd_status_pat(String Sd_status_pat) {
		setAttrVal("Sd_status_pat", Sd_status_pat);
	}
	/**
	 * 病情状况名称
	 * @return String
	 */
	public String getName_status_pat() {
		return ((String) getAttrVal("Name_status_pat"));
	}
	/**
	 * 病情状况名称
	 * @param Name_status_pat
	 */
	public void setName_status_pat(String Name_status_pat) {
		setAttrVal("Name_status_pat", Name_status_pat);
	}
	/**
	 * 主要诊断
	 * @return String
	 */
	public String getId_diag() {
		return ((String) getAttrVal("Id_diag"));
	}
	/**
	 * 主要诊断
	 * @param Id_diag
	 */
	public void setId_diag(String Id_diag) {
		setAttrVal("Id_diag", Id_diag);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDesc_diag() {
		return ((String) getAttrVal("Desc_diag"));
	}
	/**
	 * 诊断描述
	 * @param Desc_diag
	 */
	public void setDesc_diag(String Desc_diag) {
		setAttrVal("Desc_diag", Desc_diag);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phy_ip() {
		return ((String) getAttrVal("Id_dep_phy_ip"));
	}
	/**
	 * 入院科室
	 * @param Id_dep_phy_ip
	 */
	public void setId_dep_phy_ip(String Id_dep_phy_ip) {
		setAttrVal("Id_dep_phy_ip", Id_dep_phy_ip);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}
	/**
	 * 入院科室名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 计划入院日期
	 * @return FDate
	 */
	public FDate getDt_admit_plan() {
		return ((FDate) getAttrVal("Dt_admit_plan"));
	}
	/**
	 * 计划入院日期
	 * @param Dt_admit_plan
	 */
	public void setDt_admit_plan(FDate Dt_admit_plan) {
		setAttrVal("Dt_admit_plan", Dt_admit_plan);
	}
	/**
	 * 预计预交金额度
	 * @return FDouble
	 */
	public FDouble getAmt_deposit() {
		return ((FDouble) getAttrVal("Amt_deposit"));
	}
	/**
	 * 预计预交金额度
	 * @param Amt_deposit
	 */
	public void setAmt_deposit(FDouble Amt_deposit) {
		setAttrVal("Amt_deposit", Amt_deposit);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 就诊转归id
	 * @return String
	 */
	public String getId_gowhere() {
		return ((String) getAttrVal("Id_gowhere"));
	}
	/**
	 * 就诊转归id
	 * @param Id_gowhere
	 */
	public void setId_gowhere(String Id_gowhere) {
		setAttrVal("Id_gowhere", Id_gowhere);
	}
	/**
	 * 就诊转归状态
	 * @return String
	 */
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}
	/**
	 * 就诊转归状态
	 * @param Sd_gowhere
	 */
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
	}
	/**
	 * 门诊就诊科室
	 * @return String
	 */
	public String getId_dep_op() {
		return ((String) getAttrVal("Id_dep_op"));
	}
	/**
	 * 门诊就诊科室
	 * @param Id_dep_op
	 */
	public void setId_dep_op(String Id_dep_op) {
		setAttrVal("Id_dep_op", Id_dep_op);
	}
	/**
	 * 门诊就诊科室名称
	 * @return String
	 */
	public String getName_dep_op() {
		return ((String) getAttrVal("Name_dep_op"));
	}
	/**
	 * 门诊就诊科室名称
	 * @param Name_dep_op
	 */
	public void setName_dep_op(String Name_dep_op) {
		setAttrVal("Name_dep_op", Name_dep_op);
	}
	/**
	 * 门诊医生
	 * @return String
	 */
	public String getId_emp_phy_op() {
		return ((String) getAttrVal("Id_emp_phy_op"));
	}
	/**
	 * 门诊医生
	 * @param Id_emp_phy_op
	 */
	public void setId_emp_phy_op(String Id_emp_phy_op) {
		setAttrVal("Id_emp_phy_op", Id_emp_phy_op);
	}
	/**
	 * 门诊医生名称
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}
	/**
	 * 门诊医生名称
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getId_dep_nur_ip() {
		return ((String) getAttrVal("Id_dep_nur_ip"));
	}
	/**
	 * 入院病区
	 * @param Id_dep_nur_ip
	 */
	public void setId_dep_nur_ip(String Id_dep_nur_ip) {
		setAttrVal("Id_dep_nur_ip", Id_dep_nur_ip);
	}
	/**
	 * 床位类型
	 * @return String
	 */
	public String getSd_bedtype() {
		return ((String) getAttrVal("Sd_bedtype"));
	}
	/**
	 * 床位类型
	 * @param Sd_bedtype
	 */
	public void setSd_bedtype(String Sd_bedtype) {
		setAttrVal("Sd_bedtype", Sd_bedtype);
	}
	/**
	 * 诊断类型名称
	 * @return String
	 */
	public String getDiag_name() {
		return ((String) getAttrVal("Diag_name"));
	}
	/**
	 * 诊断类型名称
	 * @param Diag_name
	 */
	public void setDiag_name(String Diag_name) {
		setAttrVal("Diag_name", Diag_name);
	}
	/**
	 * 入院通知单id
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}
	/**
	 * 入院通知单id
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	/**
	 * 患者Id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者Id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 主要诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 主要诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
}