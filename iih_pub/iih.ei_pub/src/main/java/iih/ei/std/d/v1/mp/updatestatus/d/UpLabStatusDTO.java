package iih.ei.std.d.v1.mp.updatestatus.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本维度修改医嘱状态 DTO数据 
 * 
 */
public class UpLabStatusDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 标本号
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 标本号
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 状态编号
	 * @return String
	 */
	public String getCode_status() {
		return ((String) getAttrVal("Code_status"));
	}	
	/**
	 * 状态编号
	 * @param Code_status
	 */
	public void setCode_status(String Code_status) {
		setAttrVal("Code_status", Code_status);
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