package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 支付方式明细DTO DTO数据 
 * 
 */
public class PayPmItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 收付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}
	/**
	 * 收付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 收付款方式编码
	 * @return String
	 */
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}
	/**
	 * 收付款方式编码
	 * @param Sd_pm
	 */
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	/**
	 * 支付方
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}
	/**
	 * 支付方
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 银行
	 * @return String
	 */
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}
	/**
	 * 银行
	 * @param Id_bank
	 */
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
	/**
	 * 银行卡号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 银行卡号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 收款方信息
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}
	/**
	 * 收款方信息
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 收付款方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 收付款方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 是否为找零
	 * @return FBoolean
	 */
	public FBoolean getFg_charge() {
		return ((FBoolean) getAttrVal("Fg_charge"));
	}
	/**
	 * 是否为找零
	 * @param Fg_charge
	 */
	public void setFg_charge(FBoolean Fg_charge) {
		setAttrVal("Fg_charge", Fg_charge);
	}
	/**
	 * 是否手工退账
	 * @return FBoolean
	 */
	public FBoolean getFg_refund_manual() {
		return ((FBoolean) getAttrVal("Fg_refund_manual"));
	}
	/**
	 * 是否手工退账
	 * @param Fg_refund_manual
	 */
	public void setFg_refund_manual(FBoolean Fg_refund_manual) {
		setAttrVal("Fg_refund_manual", Fg_refund_manual);
	}
	/**
	 * 预交金消费id
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}
	/**
	 * 预交金消费id
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 是否结存
	 * @return FBoolean
	 */
	public FBoolean getFg_transfer() {
		return ((FBoolean) getAttrVal("Fg_transfer"));
	}
	/**
	 * 是否结存
	 * @param Fg_transfer
	 */
	public void setFg_transfer(FBoolean Fg_transfer) {
		setAttrVal("Fg_transfer", Fg_transfer);
	}
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
}
    
