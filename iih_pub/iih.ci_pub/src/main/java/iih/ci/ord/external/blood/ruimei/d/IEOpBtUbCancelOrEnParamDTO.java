package iih.ci.ord.external.blood.ruimei.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 备用血医嘱作废 DTO数据 
 * 
 */
public class IEOpBtUbCancelOrEnParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 作废医生代码
	 * @return String
	 */
	public String getCode_emp_canc() {
		return ((String) getAttrVal("Code_emp_canc"));
	}
	/**
	 * 作废医生代码
	 * @param Code_emp_canc
	 */
	public void setCode_emp_canc(String Code_emp_canc) {
		setAttrVal("Code_emp_canc", Code_emp_canc);
	}
	/**
	 * 作废时间
	 * @return String
	 */
	public String getDt_canc() {
		return ((String) getAttrVal("Dt_canc"));
	}
	/**
	 * 作废时间
	 * @param Dt_canc
	 */
	public void setDt_canc(String Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
}