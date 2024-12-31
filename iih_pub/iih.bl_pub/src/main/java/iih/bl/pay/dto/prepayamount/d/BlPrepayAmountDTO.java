package iih.bl.pay.dto.prepayamount.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金金额dto DTO数据 
 * 
 */
public class BlPrepayAmountDTO extends BaseDTO {
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
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 预交金总金额
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 预交金总金额
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 预交金余额
	 * @return FDouble
	 */
	public FDouble getAmt_bal() {
		return ((FDouble) getAttrVal("Amt_bal"));
	}
	/**
	 * 预交金余额
	 * @param Amt_bal
	 */
	public void setAmt_bal(FDouble Amt_bal) {
		setAttrVal("Amt_bal", Amt_bal);
	}
	/**
	 * 可用余额(实际)
	 * @return FDouble
	 */
	public FDouble getAmt_available_act() {
		return ((FDouble) getAttrVal("Amt_available_act"));
	}
	/**
	 * 可用余额(实际)
	 * @param Amt_available_act
	 */
	public void setAmt_available_act(FDouble Amt_available_act) {
		setAttrVal("Amt_available_act", Amt_available_act);
	}
	/**
	 * 可用余额(校验用)
	 * @return FDouble
	 */
	public FDouble getAmt_available_check() {
		return ((FDouble) getAttrVal("Amt_available_check"));
	}
	/**
	 * 可用余额(校验用)
	 * @param Amt_available_check
	 */
	public void setAmt_available_check(FDouble Amt_available_check) {
		setAttrVal("Amt_available_check", Amt_available_check);
	}
}