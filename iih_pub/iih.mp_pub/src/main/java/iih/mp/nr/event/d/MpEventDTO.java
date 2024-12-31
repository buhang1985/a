package iih.mp.nr.event.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行确认触发事件DTO DTO数据 
 * 
 */
public class MpEventDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行计划ID
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划ID
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
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
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医嘱用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 医嘱用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public Integer getEu_su() {
		return ((Integer) getAttrVal("Eu_su"));
	}
	/**
	 * 执行状态
	 * @param Eu_su
	 */
	public void setEu_su(Integer Eu_su) {
		setAttrVal("Eu_su", Eu_su);
	}
	/**
	 * 不执行原因编码
	 * @return String
	 */
	public String getSd_skip_reason() {
		return ((String) getAttrVal("Sd_skip_reason"));
	}
	/**
	 * 不执行原因编码
	 * @param Sd_skip_reason
	 */
	public void setSd_skip_reason(String Sd_skip_reason) {
		setAttrVal("Sd_skip_reason", Sd_skip_reason);
	}
	/**
	 * 不执行原因描述
	 * @return String
	 */
	public String getSkip_reason() {
		return ((String) getAttrVal("Skip_reason"));
	}
	/**
	 * 不执行原因描述
	 * @param Skip_reason
	 */
	public void setSkip_reason(String Skip_reason) {
		setAttrVal("Skip_reason", Skip_reason);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp_confirm() {
		return ((String) getAttrVal("Id_emp_confirm"));
	}
	/**
	 * 执行人
	 * @param Id_emp_confirm
	 */
	public void setId_emp_confirm(String Id_emp_confirm) {
		setAttrVal("Id_emp_confirm", Id_emp_confirm);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_confirm() {
		return ((String) getAttrVal("Id_dep_confirm"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_confirm
	 */
	public void setId_dep_confirm(String Id_dep_confirm) {
		setAttrVal("Id_dep_confirm", Id_dep_confirm);
	}
}