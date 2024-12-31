package iih.ei.std.d.v1.mp.updatebycodeor.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱执行计划 DTO数据 
 * 
 */
public class WOrPlanDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 计划执行时间
	 * @return String
	 */
	public String getDt_mp_plan() {
		return ((String) getAttrVal("Dt_mp_plan"));
	}	
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(String Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 闭环状态编码
	 * @return String
	 */
	public String getCode_status() {
		return ((String) getAttrVal("Code_status"));
	}	
	/**
	 * 闭环状态编码
	 * @param Code_status
	 */
	public void setCode_status(String Code_status) {
		setAttrVal("Code_status", Code_status);
	}
	/**
	 * 执行人编码
	 * @return String
	 */
	public String getCode_emp_exec() {
		return ((String) getAttrVal("Code_emp_exec"));
	}	
	/**
	 * 执行人编码
	 * @param Code_emp_exec
	 */
	public void setCode_emp_exec(String Code_emp_exec) {
		setAttrVal("Code_emp_exec", Code_emp_exec);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep_exec() {
		return ((String) getAttrVal("Code_dep_exec"));
	}	
	/**
	 * 执行科室编码
	 * @param Code_dep_exec
	 */
	public void setCode_dep_exec(String Code_dep_exec) {
		setAttrVal("Code_dep_exec", Code_dep_exec);
	}
	/**
	 * 实际执行时间
	 * @return String
	 */
	public String getDt_exec() {
		return ((String) getAttrVal("Dt_exec"));
	}	
	/**
	 * 实际执行时间
	 * @param Dt_exec
	 */
	public void setDt_exec(String Dt_exec) {
		setAttrVal("Dt_exec", Dt_exec);
	}
}