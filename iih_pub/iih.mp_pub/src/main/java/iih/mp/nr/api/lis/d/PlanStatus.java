package iih.mp.nr.api.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Lis合管状态接口 DTO数据 
 * 
 */
public class PlanStatus extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 执行人编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}
	/**
	 * 执行人编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
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
}