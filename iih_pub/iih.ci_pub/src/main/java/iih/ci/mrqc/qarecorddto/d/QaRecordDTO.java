package iih.ci.mrqc.qarecorddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控工作记录dto DTO数据 
 * 
 */
public class QaRecordDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * dto主键
	 * @return String
	 */
	public String getId_recorddto() {
		return ((String) getAttrVal("Id_recorddto"));
	}
	/**
	 * dto主键
	 * @param Id_recorddto
	 */
	public void setId_recorddto(String Id_recorddto) {
		setAttrVal("Id_recorddto", Id_recorddto);
	}
	/**
	 * 质控日期
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 质控日期
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_hospital() {
		return ((String) getAttrVal("Code_hospital"));
	}
	/**
	 * 住院号
	 * @param Code_hospital
	 */
	public void setCode_hospital(String Code_hospital) {
		setAttrVal("Code_hospital", Code_hospital);
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
	 * 主诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 主诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 通知书主键
	 * @return String
	 */
	public String getId_revision() {
		return ((String) getAttrVal("Id_revision"));
	}
	/**
	 * 通知书主键
	 * @param Id_revision
	 */
	public void setId_revision(String Id_revision) {
		setAttrVal("Id_revision", Id_revision);
	}
	/**
	 * 通知书状态
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 通知书状态
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 通知书状态名称
	 * @return String
	 */
	public String getStatus_name() {
		return ((String) getAttrVal("Status_name"));
	}
	/**
	 * 通知书状态名称
	 * @param Status_name
	 */
	public void setStatus_name(String Status_name) {
		setAttrVal("Status_name", Status_name);
	}
	/**
	 * 质控医生id
	 * @return String
	 */
	public String getId_exec_user() {
		return ((String) getAttrVal("Id_exec_user"));
	}
	/**
	 * 质控医生id
	 * @param Id_exec_user
	 */
	public void setId_exec_user(String Id_exec_user) {
		setAttrVal("Id_exec_user", Id_exec_user);
	}
	/**
	 * 质控医生
	 * @return String
	 */
	public String getExec_user_name() {
		return ((String) getAttrVal("Exec_user_name"));
	}
	/**
	 * 质控医生
	 * @param Exec_user_name
	 */
	public void setExec_user_name(String Exec_user_name) {
		setAttrVal("Exec_user_name", Exec_user_name);
	}
	/**
	 * 质控科室id
	 * @return String
	 */
	public String getId_exec_dept() {
		return ((String) getAttrVal("Id_exec_dept"));
	}
	/**
	 * 质控科室id
	 * @param Id_exec_dept
	 */
	public void setId_exec_dept(String Id_exec_dept) {
		setAttrVal("Id_exec_dept", Id_exec_dept);
	}
	/**
	 * 质控科室
	 * @return String
	 */
	public String getExec_dept_name() {
		return ((String) getAttrVal("Exec_dept_name"));
	}
	/**
	 * 质控科室
	 * @param Exec_dept_name
	 */
	public void setExec_dept_name(String Exec_dept_name) {
		setAttrVal("Exec_dept_name", Exec_dept_name);
	}
	/**
	 * 缺陷次数
	 * @return String
	 */
	public String getDeduct_times() {
		return ((String) getAttrVal("Deduct_times"));
	}
	/**
	 * 缺陷次数
	 * @param Deduct_times
	 */
	public void setDeduct_times(String Deduct_times) {
		setAttrVal("Deduct_times", Deduct_times);
	}
	/**
	 * 整改说明
	 * @return String
	 */
	public String getRes() {
		return ((String) getAttrVal("Res"));
	}
	/**
	 * 整改说明
	 * @param Res
	 */
	public void setRes(String Res) {
		setAttrVal("Res", Res);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 质控类型id
	 * @return String
	 */
	public String getId_qa_ty() {
		return ((String) getAttrVal("Id_qa_ty"));
	}
	/**
	 * 质控类型id
	 * @param Id_qa_ty
	 */
	public void setId_qa_ty(String Id_qa_ty) {
		setAttrVal("Id_qa_ty", Id_qa_ty);
	}
	/**
	 * 质控类型sd
	 * @return String
	 */
	public String getSd_qa_ty() {
		return ((String) getAttrVal("Sd_qa_ty"));
	}
	/**
	 * 质控类型sd
	 * @param Sd_qa_ty
	 */
	public void setSd_qa_ty(String Sd_qa_ty) {
		setAttrVal("Sd_qa_ty", Sd_qa_ty);
	}
	/**
	 * 评分
	 * @return FDouble
	 */
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 住院编码
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 住院编码
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 整改医生
	 * @return String
	 */
	public String getName_rfm_doctor() {
		return ((String) getAttrVal("Name_rfm_doctor"));
	}
	/**
	 * 整改医生
	 * @param Name_rfm_doctor
	 */
	public void setName_rfm_doctor(String Name_rfm_doctor) {
		setAttrVal("Name_rfm_doctor", Name_rfm_doctor);
	}
	/**
	 * 整改医生id
	 * @return String
	 */
	public String getId_rfm_doctor() {
		return ((String) getAttrVal("Id_rfm_doctor"));
	}
	/**
	 * 整改医生id
	 * @param Id_rfm_doctor
	 */
	public void setId_rfm_doctor(String Id_rfm_doctor) {
		setAttrVal("Id_rfm_doctor", Id_rfm_doctor);
	}
	/**
	 * 整改科室id
	 * @return String
	 */
	public String getId_rfm_dept() {
		return ((String) getAttrVal("Id_rfm_dept"));
	}
	/**
	 * 整改科室id
	 * @param Id_rfm_dept
	 */
	public void setId_rfm_dept(String Id_rfm_dept) {
		setAttrVal("Id_rfm_dept", Id_rfm_dept);
	}
	/**
	 * 整改科室
	 * @return String
	 */
	public String getName_rfm_dept() {
		return ((String) getAttrVal("Name_rfm_dept"));
	}
	/**
	 * 整改科室
	 * @param Name_rfm_dept
	 */
	public void setName_rfm_dept(String Name_rfm_dept) {
		setAttrVal("Name_rfm_dept", Name_rfm_dept);
	}
	/**
	 * 质控记录表主键
	 * @return String
	 */
	public String getId_qa() {
		return ((String) getAttrVal("Id_qa"));
	}
	/**
	 * 质控记录表主键
	 * @param Id_qa
	 */
	public void setId_qa(String Id_qa) {
		setAttrVal("Id_qa", Id_qa);
	}
	/**
	 * 通知表记录主键
	 * @return String
	 */
	public String getId_qa_record() {
		return ((String) getAttrVal("Id_qa_record"));
	}
	/**
	 * 通知表记录主键
	 * @param Id_qa_record
	 */
	public void setId_qa_record(String Id_qa_record) {
		setAttrVal("Id_qa_record", Id_qa_record);
	}
}