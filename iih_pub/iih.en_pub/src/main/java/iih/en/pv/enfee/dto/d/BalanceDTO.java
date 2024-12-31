package iih.en.pv.enfee.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 余额DTO DTO数据 
 * 
 */
public class BalanceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 团检id
	 * @return String
	 */
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}
	/**
	 * 团检id
	 * @param Id_pecmpy
	 */
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	/**
	 * 预交金总额
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 预交金总额
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 信用分类就诊信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred_pripat() {
		return ((FDouble) getAttrVal("Amt_cred_pripat"));
	}
	/**
	 * 信用分类就诊信用额度
	 * @param Amt_cred_pripat
	 */
	public void setAmt_cred_pripat(FDouble Amt_cred_pripat) {
		setAttrVal("Amt_cred_pripat", Amt_cred_pripat);
	}
	/**
	 * 就诊账户信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred_acc() {
		return ((FDouble) getAttrVal("Amt_cred_acc"));
	}
	/**
	 * 就诊账户信用额度
	 * @param Amt_cred_acc
	 */
	public void setAmt_cred_acc(FDouble Amt_cred_acc) {
		setAttrVal("Amt_cred_acc", Amt_cred_acc);
	}
	/**
	 * 信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}
	/**
	 * 信用额度
	 * @param Amt_cred
	 */
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	/**
	 * 未结算总额
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 未结算总额
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 账户余额
	 * @return FDouble
	 */
	public FDouble getAmt_bal() {
		return ((FDouble) getAttrVal("Amt_bal"));
	}
	/**
	 * 账户余额
	 * @param Amt_bal
	 */
	public void setAmt_bal(FDouble Amt_bal) {
		setAttrVal("Amt_bal", Amt_bal);
	}
	/**
	 * 可用余额
	 * @return FDouble
	 */
	public FDouble getAvailable() {
		return ((FDouble) getAttrVal("Available"));
	}
	/**
	 * 可用余额
	 * @param Available
	 */
	public void setAvailable(FDouble Available) {
		setAttrVal("Available", Available);
	}
	/**
	 * 医保预支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保预支付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
}