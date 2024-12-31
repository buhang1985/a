package iih.mp.ne.ntransfusiondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输血执行 DTO数据 
 * 
 */
public class TransfusionDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 输血记录编号
	 * @return String
	 */
	public String getNo_transfusion() {
		return ((String) getAttrVal("No_transfusion"));
	}
	/**
	 * 输血记录编号
	 * @param No_transfusion
	 */
	public void setNo_transfusion(String No_transfusion) {
		setAttrVal("No_transfusion", No_transfusion);
	}
	/**
	 * 输血开始时间
	 * @return FDateTime
	 */
	public FDateTime getB_actual() {
		return ((FDateTime) getAttrVal("B_actual"));
	}
	/**
	 * 输血开始时间
	 * @param B_actual
	 */
	public void setB_actual(FDateTime B_actual) {
		setAttrVal("B_actual", B_actual);
	}
	/**
	 * 体温
	 * @return FDouble
	 */
	public FDouble getB_temperature() {
		return ((FDouble) getAttrVal("B_temperature"));
	}
	/**
	 * 体温
	 * @param B_temperature
	 */
	public void setB_temperature(FDouble B_temperature) {
		setAttrVal("B_temperature", B_temperature);
	}
	/**
	 * 脉搏
	 * @return Integer
	 */
	public Integer getB_pulse() {
		return ((Integer) getAttrVal("B_pulse"));
	}
	/**
	 * 脉搏
	 * @param B_pulse
	 */
	public void setB_pulse(Integer B_pulse) {
		setAttrVal("B_pulse", B_pulse);
	}
	/**
	 * 高压
	 * @return FDouble
	 */
	public FDouble getB_highpressure() {
		return ((FDouble) getAttrVal("B_highpressure"));
	}
	/**
	 * 高压
	 * @param B_highpressure
	 */
	public void setB_highpressure(FDouble B_highpressure) {
		setAttrVal("B_highpressure", B_highpressure);
	}
	/**
	 * 低压
	 * @return FDouble
	 */
	public FDouble getB_lowpressure() {
		return ((FDouble) getAttrVal("B_lowpressure"));
	}
	/**
	 * 低压
	 * @param B_lowpressure
	 */
	public void setB_lowpressure(FDouble B_lowpressure) {
		setAttrVal("B_lowpressure", B_lowpressure);
	}
	/**
	 * 呼吸
	 * @return Integer
	 */
	public Integer getB_breathing() {
		return ((Integer) getAttrVal("B_breathing"));
	}
	/**
	 * 呼吸
	 * @param B_breathing
	 */
	public void setB_breathing(Integer B_breathing) {
		setAttrVal("B_breathing", B_breathing);
	}
	/**
	 * 体温服务
	 * @return String
	 */
	public String getB_id_srv_temperature() {
		return ((String) getAttrVal("B_id_srv_temperature"));
	}
	/**
	 * 体温服务
	 * @param B_id_srv_temperature
	 */
	public void setB_id_srv_temperature(String B_id_srv_temperature) {
		setAttrVal("B_id_srv_temperature", B_id_srv_temperature);
	}
	/**
	 * 脉搏服务
	 * @return String
	 */
	public String getB_id_srv_pulse() {
		return ((String) getAttrVal("B_id_srv_pulse"));
	}
	/**
	 * 脉搏服务
	 * @param B_id_srv_pulse
	 */
	public void setB_id_srv_pulse(String B_id_srv_pulse) {
		setAttrVal("B_id_srv_pulse", B_id_srv_pulse);
	}
	/**
	 * 血压服务
	 * @return String
	 */
	public String getB_id_srv_pressure() {
		return ((String) getAttrVal("B_id_srv_pressure"));
	}
	/**
	 * 血压服务
	 * @param B_id_srv_pressure
	 */
	public void setB_id_srv_pressure(String B_id_srv_pressure) {
		setAttrVal("B_id_srv_pressure", B_id_srv_pressure);
	}
	/**
	 * 呼吸服务
	 * @return String
	 */
	public String getB_id_srv_breathing() {
		return ((String) getAttrVal("B_id_srv_breathing"));
	}
	/**
	 * 呼吸服务
	 * @param B_id_srv_breathing
	 */
	public void setB_id_srv_breathing(String B_id_srv_breathing) {
		setAttrVal("B_id_srv_breathing", B_id_srv_breathing);
	}
	/**
	 * 体温服务名称
	 * @return String
	 */
	public String getB_id_srv_temperature_name() {
		return ((String) getAttrVal("B_id_srv_temperature_name"));
	}
	/**
	 * 体温服务名称
	 * @param B_id_srv_temperature_name
	 */
	public void setB_id_srv_temperature_name(String B_id_srv_temperature_name) {
		setAttrVal("B_id_srv_temperature_name", B_id_srv_temperature_name);
	}
	/**
	 * 脉搏服务名称
	 * @return String
	 */
	public String getB_name_srv_pulse() {
		return ((String) getAttrVal("B_name_srv_pulse"));
	}
	/**
	 * 脉搏服务名称
	 * @param B_name_srv_pulse
	 */
	public void setB_name_srv_pulse(String B_name_srv_pulse) {
		setAttrVal("B_name_srv_pulse", B_name_srv_pulse);
	}
	/**
	 * 血压服务名称
	 * @return String
	 */
	public String getB_name_srv_pressure() {
		return ((String) getAttrVal("B_name_srv_pressure"));
	}
	/**
	 * 血压服务名称
	 * @param B_name_srv_pressure
	 */
	public void setB_name_srv_pressure(String B_name_srv_pressure) {
		setAttrVal("B_name_srv_pressure", B_name_srv_pressure);
	}
	/**
	 * 呼吸服务名称
	 * @return String
	 */
	public String getB_name_srv_breathing() {
		return ((String) getAttrVal("B_name_srv_breathing"));
	}
	/**
	 * 呼吸服务名称
	 * @param B_name_srv_breathing
	 */
	public void setB_name_srv_breathing(String B_name_srv_breathing) {
		setAttrVal("B_name_srv_breathing", B_name_srv_breathing);
	}
	/**
	 * 是否生理盐水冲管
	 * @return FBoolean
	 */
	public FBoolean getB_fg_ns() {
		return ((FBoolean) getAttrVal("B_fg_ns"));
	}
	/**
	 * 是否生理盐水冲管
	 * @param B_fg_ns
	 */
	public void setB_fg_ns(FBoolean B_fg_ns) {
		setAttrVal("B_fg_ns", B_fg_ns);
	}
	/**
	 * 录入者ID
	 * @return String
	 */
	public String getB_id_emp_ee_nur() {
		return ((String) getAttrVal("B_id_emp_ee_nur"));
	}
	/**
	 * 录入者ID
	 * @param B_id_emp_ee_nur
	 */
	public void setB_id_emp_ee_nur(String B_id_emp_ee_nur) {
		setAttrVal("B_id_emp_ee_nur", B_id_emp_ee_nur);
	}
	/**
	 * 录入者
	 * @return String
	 */
	public String getB_name_emp_ee_nur() {
		return ((String) getAttrVal("B_name_emp_ee_nur"));
	}
	/**
	 * 录入者
	 * @param B_name_emp_ee_nur
	 */
	public void setB_name_emp_ee_nur(String B_name_emp_ee_nur) {
		setAttrVal("B_name_emp_ee_nur", B_name_emp_ee_nur);
	}
	/**
	 * 审核者ID
	 * @return String
	 */
	public String getB_id_emp_re_nur() {
		return ((String) getAttrVal("B_id_emp_re_nur"));
	}
	/**
	 * 审核者ID
	 * @param B_id_emp_re_nur
	 */
	public void setB_id_emp_re_nur(String B_id_emp_re_nur) {
		setAttrVal("B_id_emp_re_nur", B_id_emp_re_nur);
	}
	/**
	 * 审核者
	 * @return String
	 */
	public String getB_name_emp_re_nur() {
		return ((String) getAttrVal("B_name_emp_re_nur"));
	}
	/**
	 * 审核者
	 * @param B_name_emp_re_nur
	 */
	public void setB_name_emp_re_nur(String B_name_emp_re_nur) {
		setAttrVal("B_name_emp_re_nur", B_name_emp_re_nur);
	}
	/**
	 * 输血完成时间
	 * @return FDateTime
	 */
	public FDateTime getE_actual() {
		return ((FDateTime) getAttrVal("E_actual"));
	}
	/**
	 * 输血完成时间
	 * @param E_actual
	 */
	public void setE_actual(FDateTime E_actual) {
		setAttrVal("E_actual", E_actual);
	}
	/**
	 * 输血完成体温
	 * @return FDouble
	 */
	public FDouble getE_temperture() {
		return ((FDouble) getAttrVal("E_temperture"));
	}
	/**
	 * 输血完成体温
	 * @param E_temperture
	 */
	public void setE_temperture(FDouble E_temperture) {
		setAttrVal("E_temperture", E_temperture);
	}
	/**
	 * 输血完成脉搏
	 * @return Integer
	 */
	public Integer getE_pulse() {
		return ((Integer) getAttrVal("E_pulse"));
	}
	/**
	 * 输血完成脉搏
	 * @param E_pulse
	 */
	public void setE_pulse(Integer E_pulse) {
		setAttrVal("E_pulse", E_pulse);
	}
	/**
	 * 输血完成高压
	 * @return FDouble
	 */
	public FDouble getE_highpressure() {
		return ((FDouble) getAttrVal("E_highpressure"));
	}
	/**
	 * 输血完成高压
	 * @param E_highpressure
	 */
	public void setE_highpressure(FDouble E_highpressure) {
		setAttrVal("E_highpressure", E_highpressure);
	}
	/**
	 * 输血完成低压
	 * @return FDouble
	 */
	public FDouble getE_lowpressure() {
		return ((FDouble) getAttrVal("E_lowpressure"));
	}
	/**
	 * 输血完成低压
	 * @param E_lowpressure
	 */
	public void setE_lowpressure(FDouble E_lowpressure) {
		setAttrVal("E_lowpressure", E_lowpressure);
	}
	/**
	 * 输血完成呼吸
	 * @return Integer
	 */
	public Integer getE_breathing() {
		return ((Integer) getAttrVal("E_breathing"));
	}
	/**
	 * 输血完成呼吸
	 * @param E_breathing
	 */
	public void setE_breathing(Integer E_breathing) {
		setAttrVal("E_breathing", E_breathing);
	}
	/**
	 * 输血完成体温服务
	 * @return String
	 */
	public String getE_id_srv_temperature() {
		return ((String) getAttrVal("E_id_srv_temperature"));
	}
	/**
	 * 输血完成体温服务
	 * @param E_id_srv_temperature
	 */
	public void setE_id_srv_temperature(String E_id_srv_temperature) {
		setAttrVal("E_id_srv_temperature", E_id_srv_temperature);
	}
	/**
	 * 输血完成脉搏服务
	 * @return String
	 */
	public String getE_id_srv_pulse() {
		return ((String) getAttrVal("E_id_srv_pulse"));
	}
	/**
	 * 输血完成脉搏服务
	 * @param E_id_srv_pulse
	 */
	public void setE_id_srv_pulse(String E_id_srv_pulse) {
		setAttrVal("E_id_srv_pulse", E_id_srv_pulse);
	}
	/**
	 * 输血完成血压服务
	 * @return String
	 */
	public String getE_id_srv_pressure() {
		return ((String) getAttrVal("E_id_srv_pressure"));
	}
	/**
	 * 输血完成血压服务
	 * @param E_id_srv_pressure
	 */
	public void setE_id_srv_pressure(String E_id_srv_pressure) {
		setAttrVal("E_id_srv_pressure", E_id_srv_pressure);
	}
	/**
	 * 输血完成呼吸服务
	 * @return String
	 */
	public String getE_id_srv_breathing() {
		return ((String) getAttrVal("E_id_srv_breathing"));
	}
	/**
	 * 输血完成呼吸服务
	 * @param E_id_srv_breathing
	 */
	public void setE_id_srv_breathing(String E_id_srv_breathing) {
		setAttrVal("E_id_srv_breathing", E_id_srv_breathing);
	}
	/**
	 * 输血完成体温服务名称
	 * @return String
	 */
	public String getE_name_srv_temperature() {
		return ((String) getAttrVal("E_name_srv_temperature"));
	}
	/**
	 * 输血完成体温服务名称
	 * @param E_name_srv_temperature
	 */
	public void setE_name_srv_temperature(String E_name_srv_temperature) {
		setAttrVal("E_name_srv_temperature", E_name_srv_temperature);
	}
	/**
	 * 输血完成脉搏服务名称
	 * @return String
	 */
	public String getE_name_srv_pulse() {
		return ((String) getAttrVal("E_name_srv_pulse"));
	}
	/**
	 * 输血完成脉搏服务名称
	 * @param E_name_srv_pulse
	 */
	public void setE_name_srv_pulse(String E_name_srv_pulse) {
		setAttrVal("E_name_srv_pulse", E_name_srv_pulse);
	}
	/**
	 * 输血完成高压服务名称
	 * @return String
	 */
	public String getE_name_srv_pressure() {
		return ((String) getAttrVal("E_name_srv_pressure"));
	}
	/**
	 * 输血完成高压服务名称
	 * @param E_name_srv_pressure
	 */
	public void setE_name_srv_pressure(String E_name_srv_pressure) {
		setAttrVal("E_name_srv_pressure", E_name_srv_pressure);
	}
	/**
	 * 输血完成呼吸服务名称
	 * @return String
	 */
	public String getE_name_srv_breathing() {
		return ((String) getAttrVal("E_name_srv_breathing"));
	}
	/**
	 * 输血完成呼吸服务名称
	 * @param E_name_srv_breathing
	 */
	public void setE_name_srv_breathing(String E_name_srv_breathing) {
		setAttrVal("E_name_srv_breathing", E_name_srv_breathing);
	}
	/**
	 * 完成是否生理盐水冲管
	 * @return FBoolean
	 */
	public FBoolean getE_fg_ns() {
		return ((FBoolean) getAttrVal("E_fg_ns"));
	}
	/**
	 * 完成是否生理盐水冲管
	 * @param E_fg_ns
	 */
	public void setE_fg_ns(FBoolean E_fg_ns) {
		setAttrVal("E_fg_ns", E_fg_ns);
	}
	/**
	 * 输血反应
	 * @return FBoolean
	 */
	public FBoolean getFg_rea() {
		return ((FBoolean) getAttrVal("Fg_rea"));
	}
	/**
	 * 输血反应
	 * @param Fg_rea
	 */
	public void setFg_rea(FBoolean Fg_rea) {
		setAttrVal("Fg_rea", Fg_rea);
	}
	/**
	 * 反应时间
	 * @return FDateTime
	 */
	public FDateTime getRea_date() {
		return ((FDateTime) getAttrVal("Rea_date"));
	}
	/**
	 * 反应时间
	 * @param Rea_date
	 */
	public void setRea_date(FDateTime Rea_date) {
		setAttrVal("Rea_date", Rea_date);
	}
	/**
	 * 反应描述
	 * @return String
	 */
	public String getDes_rstbt() {
		return ((String) getAttrVal("Des_rstbt"));
	}
	/**
	 * 反应描述
	 * @param Des_rstbt
	 */
	public void setDes_rstbt(String Des_rstbt) {
		setAttrVal("Des_rstbt", Des_rstbt);
	}
	/**
	 * 完成录入者ID
	 * @return String
	 */
	public String getE_id_emp_eb_nur() {
		return ((String) getAttrVal("E_id_emp_eb_nur"));
	}
	/**
	 * 完成录入者ID
	 * @param E_id_emp_eb_nur
	 */
	public void setE_id_emp_eb_nur(String E_id_emp_eb_nur) {
		setAttrVal("E_id_emp_eb_nur", E_id_emp_eb_nur);
	}
	/**
	 * 完成录入者
	 * @return String
	 */
	public String getE_name_emp_eb_nur() {
		return ((String) getAttrVal("E_name_emp_eb_nur"));
	}
	/**
	 * 完成录入者
	 * @param E_name_emp_eb_nur
	 */
	public void setE_name_emp_eb_nur(String E_name_emp_eb_nur) {
		setAttrVal("E_name_emp_eb_nur", E_name_emp_eb_nur);
	}
	/**
	 * 完成审核ID
	 * @return String
	 */
	public String getE_id_emp_rb_nur() {
		return ((String) getAttrVal("E_id_emp_rb_nur"));
	}
	/**
	 * 完成审核ID
	 * @param E_id_emp_rb_nur
	 */
	public void setE_id_emp_rb_nur(String E_id_emp_rb_nur) {
		setAttrVal("E_id_emp_rb_nur", E_id_emp_rb_nur);
	}
	/**
	 * 完成审核者
	 * @return String
	 */
	public String getE_name_emp_rb_nur() {
		return ((String) getAttrVal("E_name_emp_rb_nur"));
	}
	/**
	 * 完成审核者
	 * @param E_name_emp_rb_nur
	 */
	public void setE_name_emp_rb_nur(String E_name_emp_rb_nur) {
		setAttrVal("E_name_emp_rb_nur", E_name_emp_rb_nur);
	}
	/**
	 * 按钮点击状态
	 * @return String
	 */
	public String getBtnstatus() {
		return ((String) getAttrVal("Btnstatus"));
	}
	/**
	 * 按钮点击状态
	 * @param Btnstatus
	 */
	public void setBtnstatus(String Btnstatus) {
		setAttrVal("Btnstatus", Btnstatus);
	}
	/**
	 * 状态控制开关
	 * @return String
	 */
	public String getUistate() {
		return ((String) getAttrVal("Uistate"));
	}
	/**
	 * 状态控制开关
	 * @param Uistate
	 */
	public void setUistate(String Uistate) {
		setAttrVal("Uistate", Uistate);
	}
	/**
	 * 血袋集合
	 * @return FArrayList
	 */
	public FArrayList getBloodlist() {
		return ((FArrayList) getAttrVal("Bloodlist"));
	}
	/**
	 * 血袋集合
	 * @param Bloodlist
	 */
	public void setBloodlist(FArrayList Bloodlist) {
		setAttrVal("Bloodlist", Bloodlist);
	}
	/**
	 * 反应集合
	 * @return FArrayList
	 */
	public FArrayList getReactionlist() {
		return ((FArrayList) getAttrVal("Reactionlist"));
	}
	/**
	 * 反应集合
	 * @param Reactionlist
	 */
	public void setReactionlist(FArrayList Reactionlist) {
		setAttrVal("Reactionlist", Reactionlist);
	}
	/**
	 * 用血医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 用血医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 执行计划
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 时间戳
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间戳
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}