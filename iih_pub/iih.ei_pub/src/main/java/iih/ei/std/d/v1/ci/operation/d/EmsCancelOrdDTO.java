package iih.ei.std.d.v1.ci.operation.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方医嘱作废入参 DTO数据 
 * 
 */
public class EmsCancelOrdDTO extends BaseDTO {
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
	 * 作废医生
	 * @return String
	 */
	public String getCode_emp_canc() {
		return ((String) getAttrVal("Code_emp_canc"));
	}
	/**
	 * 作废医生
	 * @param Code_emp_canc
	 */
	public void setCode_emp_canc(String Code_emp_canc) {
		setAttrVal("Code_emp_canc", Code_emp_canc);
	}
	/**
	 * 作废科室
	 * @return String
	 */
	public String getCode_dep_canc() {
		return ((String) getAttrVal("Code_dep_canc"));
	}
	/**
	 * 作废科室
	 * @param Code_dep_canc
	 */
	public void setCode_dep_canc(String Code_dep_canc) {
		setAttrVal("Code_dep_canc", Code_dep_canc);
	}
	/**
	 * 作废操作时间
	 * @return String
	 */
	public String getDt_canc() {
		return ((String) getAttrVal("Dt_canc"));
	}
	/**
	 * 作废操作时间
	 * @param Dt_canc
	 */
	public void setDt_canc(String Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 操作类型
	 * @return String
	 */
	public String getEu_actiontp() {
		return ((String) getAttrVal("Eu_actiontp"));
	}
	/**
	 * 操作类型
	 * @param Eu_actiontp
	 */
	public void setEu_actiontp(String Eu_actiontp) {
		setAttrVal("Eu_actiontp", Eu_actiontp);
	}
}