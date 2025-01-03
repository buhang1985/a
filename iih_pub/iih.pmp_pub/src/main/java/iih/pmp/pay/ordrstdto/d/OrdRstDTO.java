package iih.pmp.pay.ordrstdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 订单结果 DTO数据 
 * 
 */
public class OrdRstDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务状态
	 * @return Integer
	 */
	public Integer getBiz_status() {
		return ((Integer) getAttrVal("Biz_status"));
	}
	/**
	 * 业务状态
	 * @param Biz_status
	 */
	public void setBiz_status(Integer Biz_status) {
		setAttrVal("Biz_status", Biz_status);
	}
	/**
	 * 预下单二维码
	 * @return byte[]
	 */
	public byte[] getQr_code() {
		return ((byte[]) getAttrVal("Qr_code"));
	}
	/**
	 * 预下单二维码
	 * @param Qr_code
	 */
	public void setQr_code(byte[] Qr_code) {
		setAttrVal("Qr_code", Qr_code);
	}
	/**
	 * 返回消息
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	/**
	 * 返回消息
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
	/**
	 * 交易金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 交易金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 可退款金额
	 * @return FDouble
	 */
	public FDouble getAmount_bk() {
		return ((FDouble) getAttrVal("Amount_bk"));
	}
	/**
	 * 可退款金额
	 * @param Amount_bk
	 */
	public void setAmount_bk(FDouble Amount_bk) {
		setAttrVal("Amount_bk", Amount_bk);
	}
	/**
	 * 业务结果
	 * @return String
	 */
	public String getResult_code() {
		return ((String) getAttrVal("Result_code"));
	}
	/**
	 * 业务结果
	 * @param Result_code
	 */
	public void setResult_code(String Result_code) {
		setAttrVal("Result_code", Result_code);
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
	 * 错误代码描述
	 * @return String
	 */
	public String getErr_code_des() {
		return ((String) getAttrVal("Err_code_des"));
	}
	/**
	 * 错误代码描述
	 * @param Err_code_des
	 */
	public void setErr_code_des(String Err_code_des) {
		setAttrVal("Err_code_des", Err_code_des);
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
	 * 预支付交易会话标识
	 * @return String
	 */
	public String getPrepay_id() {
		return ((String) getAttrVal("Prepay_id"));
	}
	/**
	 * 预支付交易会话标识
	 * @param Prepay_id
	 */
	public void setPrepay_id(String Prepay_id) {
		setAttrVal("Prepay_id", Prepay_id);
	}
	/**
	 * 签名
	 * @return String
	 */
	public String getSign() {
		return ((String) getAttrVal("Sign"));
	}
	/**
	 * 签名
	 * @param Sign
	 */
	public void setSign(String Sign) {
		setAttrVal("Sign", Sign);
	}
	/**
	 * 公众号名称
	 * @return String
	 */
	public String getAppid() {
		return ((String) getAttrVal("Appid"));
	}
	/**
	 * 公众号名称
	 * @param Appid
	 */
	public void setAppid(String Appid) {
		setAttrVal("Appid", Appid);
	}
	/**
	 * 签名方式
	 * @return String
	 */
	public String getSigntype() {
		return ((String) getAttrVal("Signtype"));
	}
	/**
	 * 签名方式
	 * @param Signtype
	 */
	public void setSigntype(String Signtype) {
		setAttrVal("Signtype", Signtype);
	}
	/**
	 * 时间戳
	 * @return String
	 */
	public String getTimestamp() {
		return ((String) getAttrVal("Timestamp"));
	}
	/**
	 * 时间戳
	 * @param Timestamp
	 */
	public void setTimestamp(String Timestamp) {
		setAttrVal("Timestamp", Timestamp);
	}
	/**
	 * 随机字符串
	 * @return String
	 */
	public String getNoncestr() {
		return ((String) getAttrVal("Noncestr"));
	}
	/**
	 * 随机字符串
	 * @param Noncestr
	 */
	public void setNoncestr(String Noncestr) {
		setAttrVal("Noncestr", Noncestr);
	}
	/**
	 * 预支付标志
	 * @return String
	 */
	public String getPackage() {
		return ((String) getAttrVal("Package"));
	}
	/**
	 * 预支付标志
	 * @param Package
	 */
	public void setPackage(String Package) {
		setAttrVal("Package", Package);
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
	 * sv
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
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
	 * 退款订单号
	 * @return String
	 */
	public String getRefund_no() {
		return ((String) getAttrVal("Refund_no"));
	}
	/**
	 * 退款订单号
	 * @param Refund_no
	 */
	public void setRefund_no(String Refund_no) {
		setAttrVal("Refund_no", Refund_no);
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