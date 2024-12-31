package iih.mp.mb.dto.orexec.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱执行参数 DTO数据 
 * 
 */
public class OrExecDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exec() {
		return ((FDateTime) getAttrVal("Dt_exec"));
	}
	/**
	 * 执行时间
	 * @param Dt_exec
	 */
	public void setDt_exec(FDateTime Dt_exec) {
		setAttrVal("Dt_exec", Dt_exec);
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
	 * 执行人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 执行人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_user() {
		return ((String) getAttrVal("Code_user"));
	}
	/**
	 * 用户编码
	 * @param Code_user
	 */
	public void setCode_user(String Code_user) {
		setAttrVal("Code_user", Code_user);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 执行科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 执行科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 多通路标识
	 * @return FBoolean
	 */
	public FBoolean getFg_multi() {
		return ((FBoolean) getAttrVal("Fg_multi"));
	}
	/**
	 * 多通路标识
	 * @param Fg_multi
	 */
	public void setFg_multi(FBoolean Fg_multi) {
		setAttrVal("Fg_multi", Fg_multi);
	}
	/**
	 * 滴速
	 * @return String
	 */
	public String getIvgtt() {
		return ((String) getAttrVal("Ivgtt"));
	}
	/**
	 * 滴速
	 * @param Ivgtt
	 */
	public void setIvgtt(String Ivgtt) {
		setAttrVal("Ivgtt", Ivgtt);
	}
	/**
	 * 输液状态ID
	 * @return String
	 */
	public String getId_prtp() {
		return ((String) getAttrVal("Id_prtp"));
	}
	/**
	 * 输液状态ID
	 * @param Id_prtp
	 */
	public void setId_prtp(String Id_prtp) {
		setAttrVal("Id_prtp", Id_prtp);
	}
	/**
	 * 输液状态编码
	 * @return String
	 */
	public String getSd_prtp() {
		return ((String) getAttrVal("Sd_prtp"));
	}
	/**
	 * 输液状态编码
	 * @param Sd_prtp
	 */
	public void setSd_prtp(String Sd_prtp) {
		setAttrVal("Sd_prtp", Sd_prtp);
	}
	/**
	 * 执行类别
	 * @return String
	 */
	public String getExectp() {
		return ((String) getAttrVal("Exectp"));
	}
	/**
	 * 执行类别
	 * @param Exectp
	 */
	public void setExectp(String Exectp) {
		setAttrVal("Exectp", Exectp);
	}
	/**
	 * 不执行原因ID
	 * @return String
	 */
	public String getId_skip_reason() {
		return ((String) getAttrVal("Id_skip_reason"));
	}
	/**
	 * 不执行原因ID
	 * @param Id_skip_reason
	 */
	public void setId_skip_reason(String Id_skip_reason) {
		setAttrVal("Id_skip_reason", Id_skip_reason);
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
	 * 是否是皮试医嘱
	 * @return String
	 */
	public String getFg_skin() {
		return ((String) getAttrVal("Fg_skin"));
	}
	/**
	 * 是否是皮试医嘱
	 * @param Fg_skin
	 */
	public void setFg_skin(String Fg_skin) {
		setAttrVal("Fg_skin", Fg_skin);
	}
}