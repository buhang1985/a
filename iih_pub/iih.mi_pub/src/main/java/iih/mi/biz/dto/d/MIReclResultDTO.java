package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 对账结果 DTO数据 
 * 
 */
public class MIReclResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 对账总金额
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}
	/**
	 * 对账总金额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 个人账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}
	/**
	 * 个人账户支付
	 * @param Amt_psn
	 */
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	/**
	 * 个人现金支付
	 * @return FDouble
	 */
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}
	/**
	 * 个人现金支付
	 * @param Amt_cash
	 */
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	/**
	 * 统筹实际支付
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 统筹实际支付
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 账单数(人次)
	 * @return Integer
	 */
	public Integer getNum_bill() {
		return ((Integer) getAttrVal("Num_bill"));
	}
	/**
	 * 账单数(人次)
	 * @param Num_bill
	 */
	public void setNum_bill(Integer Num_bill) {
		setAttrVal("Num_bill", Num_bill);
	}
	/**
	 * 开始日期
	 * @return String
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 开始日期
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束日期
	 * @return String
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 结束日期
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 业务周期号
	 * @return String
	 */
	public String getBusiness_code() {
		return ((String) getAttrVal("Business_code"));
	}
	/**
	 * 业务周期号
	 * @param Business_code
	 */
	public void setBusiness_code(String Business_code) {
		setAttrVal("Business_code", Business_code);
	}
	/**
	 * 其他参数
	 * @return FMap2
	 */
	public FMap2 getOth_para() {
		return ((FMap2) getAttrVal("Oth_para"));
	}
	/**
	 * 其他参数
	 * @param Oth_para
	 */
	public void setOth_para(FMap2 Oth_para) {
		setAttrVal("Oth_para", Oth_para);
	}
}