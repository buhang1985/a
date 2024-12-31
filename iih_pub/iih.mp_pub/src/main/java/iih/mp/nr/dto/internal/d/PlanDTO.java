package iih.mp.nr.dto.internal.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行计划 DTO数据 
 * 
 */
public class PlanDTO extends BaseDTO {
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
	 * displaynam7
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * displaynam7
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 执行类别
	 * @return Integer
	 */
	public Integer getEu_tp() {
		return ((Integer) getAttrVal("Eu_tp"));
	}
	/**
	 * 执行类别
	 * @param Eu_tp
	 */
	public void setEu_tp(Integer Eu_tp) {
		setAttrVal("Eu_tp", Eu_tp);
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
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exe() {
		return ((FDateTime) getAttrVal("Dt_exe"));
	}
	/**
	 * 执行时间
	 * @param Dt_exe
	 */
	public void setDt_exe(FDateTime Dt_exe) {
		setAttrVal("Dt_exe", Dt_exe);
	}
	/**
	 * 不执行原因
	 * @return String
	 */
	public String getSd_skip_reason() {
		return ((String) getAttrVal("Sd_skip_reason"));
	}
	/**
	 * 不执行原因
	 * @param Sd_skip_reason
	 */
	public void setSd_skip_reason(String Sd_skip_reason) {
		setAttrVal("Sd_skip_reason", Sd_skip_reason);
	}
}