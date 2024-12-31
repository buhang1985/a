package iih.pis.ivx.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * lis月结参数 DTO数据 
 * 
 */
public class MonStateParam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_b() {
		return ((String) getAttrVal("Dt_b"));
	}
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(String Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_e() {
		return ((String) getAttrVal("Dt_e"));
	}
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(String Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 执行科室
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
}