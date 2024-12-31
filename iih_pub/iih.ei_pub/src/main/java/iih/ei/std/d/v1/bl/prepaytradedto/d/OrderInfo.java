package iih.ei.std.d.v1.bl.prepaytradedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金对账出参对账明细信息 DTO数据 
 * 
 */
public class OrderInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 支付时间
	 * @return String
	 */
	public String getDt_pay() {
		return ((String) getAttrVal("Dt_pay"));
	}	
	/**
	 * 支付时间
	 * @param Dt_pay
	 */
	public void setDt_pay(String Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 支付方式
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}	
	/**
	 * 支付方式
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 交易凭证号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	/**
	 * 交易凭证号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 订单流水号
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 订单流水号
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 票据号
	 * @return String
	 */
	public String getCode_rep() {
		return ((String) getAttrVal("Code_rep"));
	}	
	/**
	 * 票据号
	 * @param Code_rep
	 */
	public void setCode_rep(String Code_rep) {
		setAttrVal("Code_rep", Code_rep);
	}
	/**
	 * 支付金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}	
	/**
	 * 支付金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
}