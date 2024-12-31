package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技检查申请DTO DTO数据 
 * 
 */
public class MedTechAppDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 计划日期
	 * @return FDate
	 */
	public FDate getDt_plan() {
		return ((FDate) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划日期
	 * @param Dt_plan
	 */
	public void setDt_plan(FDate Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 检查项目
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}
	/**
	 * 检查项目
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}
	/**
	 * 检查项目编码
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}
	/**
	 * 检查部位
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}
	/**
	 * 检查部位
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}
	/**
	 * 检查部位编码
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}
	/**
	 * 检查部位编码
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 患者性别
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 患者性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 分诊台id
	 * @return String
	 */
	public String getId_ben() {
		return ((String) getAttrVal("Id_ben"));
	}
	/**
	 * 分诊台id
	 * @param Id_ben
	 */
	public void setId_ben(String Id_ben) {
		setAttrVal("Id_ben", Id_ben);
	}
	/**
	 * 队列主键
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}
	/**
	 * 队列主键
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 队列名称
	 * @return String
	 */
	public String getQue_name() {
		return ((String) getAttrVal("Que_name"));
	}
	/**
	 * 队列名称
	 * @param Que_name
	 */
	public void setQue_name(String Que_name) {
		setAttrVal("Que_name", Que_name);
	}
	/**
	 * 分诊序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 分诊序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDep_mp_name() {
		return ((String) getAttrVal("Dep_mp_name"));
	}
	/**
	 * 科室名称
	 * @param Dep_mp_name
	 */
	public void setDep_mp_name(String Dep_mp_name) {
		setAttrVal("Dep_mp_name", Dep_mp_name);
	}
	/**
	 * 队列状态
	 * @return String
	 */
	public String getSd_status_acpt() {
		return ((String) getAttrVal("Sd_status_acpt"));
	}
	/**
	 * 队列状态
	 * @param Sd_status_acpt
	 */
	public void setSd_status_acpt(String Sd_status_acpt) {
		setAttrVal("Sd_status_acpt", Sd_status_acpt);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getAppointment() {
		return ((FDateTime) getAttrVal("Appointment"));
	}
	/**
	 * 预约时间
	 * @param Appointment
	 */
	public void setAppointment(FDateTime Appointment) {
		setAttrVal("Appointment", Appointment);
	}
	/**
	 * 到达日期
	 * @return FDateTime
	 */
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}
	/**
	 * 到达日期
	 * @param Dt_in
	 */
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 诊台名称
	 * @return String
	 */
	public String getQuesite_name() {
		return ((String) getAttrVal("Quesite_name"));
	}
	/**
	 * 诊台名称
	 * @param Quesite_name
	 */
	public void setQuesite_name(String Quesite_name) {
		setAttrVal("Quesite_name", Quesite_name);
	}
	/**
	 * 诊台id
	 * @return String
	 */
	public String getId_que_site() {
		return ((String) getAttrVal("Id_que_site"));
	}
	/**
	 * 诊台id
	 * @param Id_que_site
	 */
	public void setId_que_site(String Id_que_site) {
		setAttrVal("Id_que_site", Id_que_site);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 申请人id
	 * @return String
	 */
	public String getId_emp_ap() {
		return ((String) getAttrVal("Id_emp_ap"));
	}
	/**
	 * 申请人id
	 * @param Id_emp_ap
	 */
	public void setId_emp_ap(String Id_emp_ap) {
		setAttrVal("Id_emp_ap", Id_emp_ap);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getName_emp_ap() {
		return ((String) getAttrVal("Name_emp_ap"));
	}
	/**
	 * 申请人
	 * @param Name_emp_ap
	 */
	public void setName_emp_ap(String Name_emp_ap) {
		setAttrVal("Name_emp_ap", Name_emp_ap);
	}
	/**
	 * 检查医嘱
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 检查医嘱
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getSd_su() {
		return ((String) getAttrVal("Sd_su"));
	}
	/**
	 * 申请状态
	 * @param Sd_su
	 */
	public void setSd_su(String Sd_su) {
		setAttrVal("Sd_su", Sd_su);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_dep_apply() {
		return ((String) getAttrVal("Id_dep_apply"));
	}
	/**
	 * 申请科室
	 * @param Id_dep_apply
	 */
	public void setId_dep_apply(String Id_dep_apply) {
		setAttrVal("Id_dep_apply", Id_dep_apply);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getDep_apply_name() {
		return ((String) getAttrVal("Dep_apply_name"));
	}
	/**
	 * 申请科室名称
	 * @param Dep_apply_name
	 */
	public void setDep_apply_name(String Dep_apply_name) {
		setAttrVal("Dep_apply_name", Dep_apply_name);
	}
	/**
	 * 类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 到达时间
	 * @return FDate
	 */
	public FDate getDt_regist() {
		return ((FDate) getAttrVal("Dt_regist"));
	}
	/**
	 * 到达时间
	 * @param Dt_regist
	 */
	public void setDt_regist(FDate Dt_regist) {
		setAttrVal("Dt_regist", Dt_regist);
	}
	/**
	 * entque主键
	 * @return String
	 */
	public String getId_ent_que() {
		return ((String) getAttrVal("Id_ent_que"));
	}
	/**
	 * entque主键
	 * @param Id_ent_que
	 */
	public void setId_ent_que(String Id_ent_que) {
		setAttrVal("Id_ent_que", Id_ent_que);
	}
	/**
	 * string
	 * @return String
	 */
	public String getFg_drag() {
		return ((String) getAttrVal("Fg_drag"));
	}
	/**
	 * string
	 * @param Fg_drag
	 */
	public void setFg_drag(String Fg_drag) {
		setAttrVal("Fg_drag", Fg_drag);
	}
	/**
	 * 状态值
	 * @return String
	 */
	public String getTriage_status() {
		return ((String) getAttrVal("Triage_status"));
	}
	/**
	 * 状态值
	 * @param Triage_status
	 */
	public void setTriage_status(String Triage_status) {
		setAttrVal("Triage_status", Triage_status);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getName_triage_status() {
		return ((String) getAttrVal("Name_triage_status"));
	}
	/**
	 * 状态
	 * @param Name_triage_status
	 */
	public void setName_triage_status(String Name_triage_status) {
		setAttrVal("Name_triage_status", Name_triage_status);
	}
	/**
	 * 预约ID
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约ID
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * apt预约时间
	 * @return FDateTime
	 */
	public FDateTime getApt_dt_b() {
		return ((FDateTime) getAttrVal("Apt_dt_b"));
	}
	/**
	 * apt预约时间
	 * @param Apt_dt_b
	 */
	public void setApt_dt_b(FDateTime Apt_dt_b) {
		setAttrVal("Apt_dt_b", Apt_dt_b);
	}
	/**
	 * apt预约午别
	 * @return String
	 */
	public String getApt_id_dateslot() {
		return ((String) getAttrVal("Apt_id_dateslot"));
	}
	/**
	 * apt预约午别
	 * @param Apt_id_dateslot
	 */
	public void setApt_id_dateslot(String Apt_id_dateslot) {
		setAttrVal("Apt_id_dateslot", Apt_id_dateslot);
	}
	/**
	 * 申请状态名称
	 * @return String
	 */
	public String getName_sd_su() {
		return ((String) getAttrVal("Name_sd_su"));
	}
	/**
	 * 申请状态名称
	 * @param Name_sd_su
	 */
	public void setName_sd_su(String Name_sd_su) {
		setAttrVal("Name_sd_su", Name_sd_su);
	}
	/**
	 * 排班ID
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班ID
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 优先级别
	 * @return Integer
	 */
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}
	/**
	 * 优先级别
	 * @param Level_pri
	 */
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 优先原因
	 * @return String
	 */
	public String getLevel_reason() {
		return ((String) getAttrVal("Level_reason"));
	}
	/**
	 * 优先原因
	 * @param Level_reason
	 */
	public void setLevel_reason(String Level_reason) {
		setAttrVal("Level_reason", Level_reason);
	}
	/**
	 * 医嘱是否核对
	 * @return FBoolean
	 */
	public FBoolean getFg_chk() {
		return ((FBoolean) getAttrVal("Fg_chk"));
	}
	/**
	 * 医嘱是否核对
	 * @param Fg_chk
	 */
	public void setFg_chk(FBoolean Fg_chk) {
		setAttrVal("Fg_chk", Fg_chk);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}
	/**
	 * 就诊类型名称
	 * @param Entp_name
	 */
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	/**
	 * 患者管家计划日期
	 * @return FDateTime
	 */
	public FDateTime getDt_pis_plan() {
		return ((FDateTime) getAttrVal("Dt_pis_plan"));
	}
	/**
	 * 患者管家计划日期
	 * @param Dt_pis_plan
	 */
	public void setDt_pis_plan(FDateTime Dt_pis_plan) {
		setAttrVal("Dt_pis_plan", Dt_pis_plan);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getDayslotsec() {
		return ((String) getAttrVal("Dayslotsec"));
	}
	/**
	 * 午别
	 * @param Dayslotsec
	 */
	public void setDayslotsec(String Dayslotsec) {
		setAttrVal("Dayslotsec", Dayslotsec);
	}
	/**
	 * 叫号
	 * @return String
	 */
	public String getCall() {
		return ((String) getAttrVal("Call"));
	}
	/**
	 * 叫号
	 * @param Call
	 */
	public void setCall(String Call) {
		setAttrVal("Call", Call);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 申请单id
	 * @return String
	 */
	public String getId_apt_appl() {
		return ((String) getAttrVal("Id_apt_appl"));
	}
	/**
	 * 申请单id
	 * @param Id_apt_appl
	 */
	public void setId_apt_appl(String Id_apt_appl) {
		setAttrVal("Id_apt_appl", Id_apt_appl);
	}
	/**
	 * 号位id
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}
	/**
	 * 号位id
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
}