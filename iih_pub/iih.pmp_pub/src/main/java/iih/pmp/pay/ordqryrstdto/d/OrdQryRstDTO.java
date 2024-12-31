package iih.pmp.pay.ordqryrstdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 订单查询结果DTO DTO数据 
 * 
 */
public class OrdQryRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单号
	 * @return String
	 */
	public String getOrd_no() {
		return ((String) getAttrVal("Ord_no"));
	}
	/**
	 * 订单号
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
	 * 建立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ord() {
		return ((FDateTime) getAttrVal("Dt_ord"));
	}
	/**
	 * 建立时间
	 * @param Dt_ord
	 */
	public void setDt_ord(FDateTime Dt_ord) {
		setAttrVal("Dt_ord", Dt_ord);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 总金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 可退金额
	 * @return FDouble
	 */
	public FDouble getAmount_bk() {
		return ((FDouble) getAttrVal("Amount_bk"));
	}
	/**
	 * 可退金额
	 * @param Amount_bk
	 */
	public void setAmount_bk(FDouble Amount_bk) {
		setAttrVal("Amount_bk", Amount_bk);
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
	 * 订单内容
	 * @return String
	 */
	public String getBody() {
		return ((String) getAttrVal("Body"));
	}
	/**
	 * 订单内容
	 * @param Body
	 */
	public void setBody(String Body) {
		setAttrVal("Body", Body);
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
	 * 商户订单号
	 * @return String
	 */
	public String getMch_order_no() {
		return ((String) getAttrVal("Mch_order_no"));
	}
	/**
	 * 商户订单号
	 * @param Mch_order_no
	 */
	public void setMch_order_no(String Mch_order_no) {
		setAttrVal("Mch_order_no", Mch_order_no);
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
	 * 交易类型
	 * @return String
	 */
	public String getTradetype() {
		return ((String) getAttrVal("Tradetype"));
	}
	/**
	 * 交易类型
	 * @param Tradetype
	 */
	public void setTradetype(String Tradetype) {
		setAttrVal("Tradetype", Tradetype);
	}
	
	/**
	 * 支付渠道编码
	 * @return String
	 */
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}
	/**
	 * 支付渠道编码
	 * @param Sd_chl
	 */
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	
	/**
	 * 请求来源用户id
	 * @return String
	 */
	public String getId_user_req() {
		return ((String) getAttrVal("Id_user_req"));
	}
	/**
	 * 请求来源用户id
	 * @param Id_user_req
	 */
	public void setId_user_req(String Id_user_req) {
		setAttrVal("Id_user_req", Id_user_req);
	}
	
	/**
	 * 支付交易金额
	 * @return String
	 */
	public FDouble getTrade_amount() {
		return ((FDouble) getAttrVal("Trade_amount"));
	}
	/**
	 * 支付 交易金额
	 * @param Id_user_req
	 */
	public void setTrade_amount(FDouble Trade_amount) {
		setAttrVal("Trade_amount", Trade_amount);
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
}