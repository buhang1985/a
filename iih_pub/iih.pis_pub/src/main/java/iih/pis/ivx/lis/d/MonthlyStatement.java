package iih.pis.ivx.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * lis月结返回结果 DTO数据 
 * 
 */
public class MonthlyStatement extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 门诊收入
	 * @return String
	 */
	public String getMonthly_oep() {
		return ((String) getAttrVal("Monthly_oep"));
	}
	/**
	 * 门诊收入
	 * @param Monthly_oep
	 */
	public void setMonthly_oep(String Monthly_oep) {
		setAttrVal("Monthly_oep", Monthly_oep);
	}
	/**
	 * 住院收入
	 * @return String
	 */
	public String getMonthly_ip() {
		return ((String) getAttrVal("Monthly_ip"));
	}
	/**
	 * 住院收入
	 * @param Monthly_ip
	 */
	public void setMonthly_ip(String Monthly_ip) {
		setAttrVal("Monthly_ip", Monthly_ip);
	}
}