package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 通用的医保分摊字段 DTO数据 
 * 
 */
public class CommonPropDataDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 费用总金额
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}
	/**
	 * 费用总金额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 现金
	 * @return FDouble
	 */
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}
	/**
	 * 现金
	 * @param Amt_cash
	 */
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	/**
	 * 个人 账户
	 * @return FDouble
	 */
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}
	/**
	 * 个人 账户
	 * @param Amt_psn
	 */
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	/**
	 * 医保基金
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保基金
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 统筹基金
	 * @return FDouble
	 */
	public FDouble getAmt_hpact() {
		return ((FDouble) getAttrVal("Amt_hpact"));
	}
	/**
	 * 统筹基金
	 * @param Amt_hpact
	 */
	public void setAmt_hpact(FDouble Amt_hpact) {
		setAttrVal("Amt_hpact", Amt_hpact);
	}
	/**
	 * 门诊发票对应的其他医保支付
	 * @return FDouble
	 */
	public FDouble getAmt_other() {
		return ((FDouble) getAttrVal("Amt_other"));
	}
	/**
	 * 门诊发票对应的其他医保支付
	 * @param Amt_other
	 */
	public void setAmt_other(FDouble Amt_other) {
		setAttrVal("Amt_other", Amt_other);
	}
	/**
	 * 医院承担
	 * @return FDouble
	 */
	public FDouble getAmt_hosbear() {
		return ((FDouble) getAttrVal("Amt_hosbear"));
	}
	/**
	 * 医院承担
	 * @param Amt_hosbear
	 */
	public void setAmt_hosbear(FDouble Amt_hosbear) {
		setAttrVal("Amt_hosbear", Amt_hosbear);
	}
}