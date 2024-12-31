package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记返回值 DTO数据 
 * 
 */
public class InpRegisterRtnValDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 本年度累计报销金额
	 * @return FDouble
	 */
	public FDouble getAccumulamt_hp() {
		return ((FDouble) getAttrVal("Accumulamt_hp"));
	}
	/**
	 * 本年度累计报销金额
	 * @param Accumulamt_hp
	 */
	public void setAccumulamt_hp(FDouble Accumulamt_hp) {
		setAttrVal("Accumulamt_hp", Accumulamt_hp);
	}
	/**
	 * 本年度累计报销次数
	 * @return Integer
	 */
	public Integer getTimes_hp() {
		return ((Integer) getAttrVal("Times_hp"));
	}
	/**
	 * 本年度累计报销次数
	 * @param Times_hp
	 */
	public void setTimes_hp(Integer Times_hp) {
		setAttrVal("Times_hp", Times_hp);
	}
	/**
	 * 医保登记流水号
	 * @return String
	 */
	public String getInpno_hp() {
		return ((String) getAttrVal("Inpno_hp"));
	}
	/**
	 * 医保登记流水号
	 * @param Inpno_hp
	 */
	public void setInpno_hp(String Inpno_hp) {
		setAttrVal("Inpno_hp", Inpno_hp);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getIp_times() {
		return ((Integer) getAttrVal("Ip_times"));
	}
	/**
	 * 住院次数
	 * @param Ip_times
	 */
	public void setIp_times(Integer Ip_times) {
		setAttrVal("Ip_times", Ip_times);
	}
	/**
	 * 起付线
	 * @return FDouble
	 */
	public FDouble getAmt_deductible() {
		return ((FDouble) getAttrVal("Amt_deductible"));
	}
	/**
	 * 起付线
	 * @param Amt_deductible
	 */
	public void setAmt_deductible(FDouble Amt_deductible) {
		setAttrVal("Amt_deductible", Amt_deductible);
	}
}