package iih.bl.itf.payplatform.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 调用支付平台出参 DTO数据 
 * 
 */
public class BlOrdQryRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 外部订单号
	 * @return String
	 */
	public String getOrd_no() {
		return ((String) getAttrVal("Ord_no"));
	}
	/**
	 * 外部订单号
	 * @param Ord_no
	 */
	public void setOrd_no(String Ord_no) {
		setAttrVal("Ord_no", Ord_no);
	}
	/**
	 * 订单状态
	 * @return Integer
	 */
	public Integer getOrd_status() {
		return ((Integer) getAttrVal("Ord_status"));
	}
	/**
	 * 订单状态
	 * @param Ord_status
	 */
	public void setOrd_status(Integer Ord_status) {
		setAttrVal("Ord_status", Ord_status);
	}
	/**
	 * 订单时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ord() {
		return ((FDateTime) getAttrVal("Dt_ord"));
	}
	/**
	 * 订单时间
	 * @param Dt_ord
	 */
	public void setDt_ord(FDateTime Dt_ord) {
		setAttrVal("Dt_ord", Dt_ord);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 可退金额
	 * @return FDouble
	 */
	public FDouble getAmt_ret() {
		return ((FDouble) getAttrVal("Amt_ret"));
	}
	/**
	 * 可退金额
	 * @param Amt_ret
	 */
	public void setAmt_ret(FDouble Amt_ret) {
		setAttrVal("Amt_ret", Amt_ret);
	}
	/**
	 * 支付时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}
	/**
	 * 支付时间
	 * @param Dt_pay
	 */
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 订单标题
	 * @return String
	 */
	public String getSubject() {
		return ((String) getAttrVal("Subject"));
	}
	/**
	 * 订单标题
	 * @param Subject
	 */
	public void setSubject(String Subject) {
		setAttrVal("Subject", Subject);
	}
	/**
	 * 交易号
	 * @return String
	 */
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}
	/**
	 * 交易号
	 * @param Trade_no
	 */
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	/**
	 * 交易时间
	 * @return FDateTime
	 */
	public FDateTime getTradetime() {
		return ((FDateTime) getAttrVal("Tradetime"));
	}
	/**
	 * 交易时间
	 * @param Tradetime
	 */
	public void setTradetime(FDateTime Tradetime) {
		setAttrVal("Tradetime", Tradetime);
	}
	/**
	 * 错误代码
	 * @return String
	 */
	public String getErr_code() {
		return ((String) getAttrVal("Err_code"));
	}
	/**
	 * 错误代码
	 * @param Err_code
	 */
	public void setErr_code(String Err_code) {
		setAttrVal("Err_code", Err_code);
	}
	/**
	 * 错误描述
	 * @return String
	 */
	public String getErr_code_des() {
		return ((String) getAttrVal("Err_code_des"));
	}
	/**
	 * 错误描述
	 * @param Err_code_des
	 */
	public void setErr_code_des(String Err_code_des) {
		setAttrVal("Err_code_des", Err_code_des);
	}
	/**
	 * 是否查询成功
	 * @return Integer
	 */
	public Integer getBiz_status() {
		return ((Integer) getAttrVal("Biz_status"));
	}
	/**
	 * 是否查询成功
	 * @param Biz_status
	 */
	public void setBiz_status(Integer Biz_status) {
		setAttrVal("Biz_status", Biz_status);
	}
	/**
	 * 银行订单号
	 * @return String
	 */
	public String getBankorderno() {
		return ((String) getAttrVal("Bankorderno"));
	}
	/**
	 * 银行订单号
	 * @param Bankorderno
	 */
	public void setBankorderno(String Bankorderno) {
		setAttrVal("Bankorderno", Bankorderno);
	}
	/**
	 * 渠道交易号
	 * @return String
	 */
	public String getTrade_no_chl() {
		return ((String) getAttrVal("Trade_no_chl"));
	}
	/**
	 * 渠道交易号
	 * @param Trade_no_chl
	 */
	public void setTrade_no_chl(String Trade_no_chl) {
		setAttrVal("Trade_no_chl", Trade_no_chl);
	}
	/**
	 * 交易状态
	 * @return Integer
	 */
	public Integer getTrade_status() {
		return ((Integer) getAttrVal("Trade_status"));
	}
	/**
	 * 交易状态
	 * @param Trade_status
	 */
	public void setTrade_status(Integer Trade_status) {
		setAttrVal("Trade_status", Trade_status);
	}
	/**
	 * 退款交易号
	 * @return String
	 */
	public String getRefund_no() {
		return ((String) getAttrVal("Refund_no"));
	}
	/**
	 * 退款交易号
	 * @param Refund_no
	 */
	public void setRefund_no(String Refund_no) {
		setAttrVal("Refund_no", Refund_no);
	}
	/**
	 * 退款金额
	 * @return FDouble
	 */
	public FDouble getRefund_fee() {
		return ((FDouble) getAttrVal("Refund_fee"));
	}
	/**
	 * 退款金额
	 * @param Refund_fee
	 */
	public void setRefund_fee(FDouble Refund_fee) {
		setAttrVal("Refund_fee", Refund_fee);
	}
	/**
	 * 银行交易号
	 * @return String
	 */
	public String getBanktradeno() {
		return ((String) getAttrVal("Banktradeno"));
	}
	/**
	 * 银行交易号
	 * @param Banktradeno
	 */
	public void setBanktradeno(String Banktradeno) {
		setAttrVal("Banktradeno", Banktradeno);
	}
	/**
	 * IIH支付平台渠道交易号
	 * @return String
	 */
	public String getMch_order_no() {
		return ((String) getAttrVal("Mch_order_no"));
	}
	/**
	 * IIH支付平台渠道交易号
	 * @param Mch_order_no
	 */
	public void setMch_order_no(String Mch_order_no) {
		setAttrVal("Mch_order_no", Mch_order_no);
	}
}