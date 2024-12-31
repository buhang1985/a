package iih.pmp.pay.bill.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信对账单 DTO数据 
 * 
 */
public class WXBillDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 公众号ID
	 * @return String
	 */
	public String getAppid() {
		return ((String) getAttrVal("Appid"));
	}
	/**
	 * 公众号ID
	 * @param Appid
	 */
	public void setAppid(String Appid) {
		setAttrVal("Appid", Appid);
	}
	/**
	 * 商户号
	 * @return String
	 */
	public String getMchid() {
		return ((String) getAttrVal("Mchid"));
	}
	/**
	 * 商户号
	 * @param Mchid
	 */
	public void setMchid(String Mchid) {
		setAttrVal("Mchid", Mchid);
	}
	/**
	 * 子商户号
	 * @return String
	 */
	public String getCmchid() {
		return ((String) getAttrVal("Cmchid"));
	}
	/**
	 * 子商户号
	 * @param Cmchid
	 */
	public void setCmchid(String Cmchid) {
		setAttrVal("Cmchid", Cmchid);
	}
	/**
	 * 设备号
	 * @return String
	 */
	public String getDeviceno() {
		return ((String) getAttrVal("Deviceno"));
	}
	/**
	 * 设备号
	 * @param Deviceno
	 */
	public void setDeviceno(String Deviceno) {
		setAttrVal("Deviceno", Deviceno);
	}
	/**
	 * 渠道订单号
	 * @return String
	 */
	public String getChanneltradeno() {
		return ((String) getAttrVal("Channeltradeno"));
	}
	/**
	 * 渠道订单号
	 * @param Channeltradeno
	 */
	public void setChanneltradeno(String Channeltradeno) {
		setAttrVal("Channeltradeno", Channeltradeno);
	}
	/**
	 * 商户订单号
	 * @return String
	 */
	public String getMch_trade_no() {
		return ((String) getAttrVal("Mch_trade_no"));
	}
	/**
	 * 商户订单号
	 * @param Mch_trade_no
	 */
	public void setMch_trade_no(String Mch_trade_no) {
		setAttrVal("Mch_trade_no", Mch_trade_no);
	}
	/**
	 * 用户标识
	 * @return String
	 */
	public String getUser_identify() {
		return ((String) getAttrVal("User_identify"));
	}
	/**
	 * 用户标识
	 * @param User_identify
	 */
	public void setUser_identify(String User_identify) {
		setAttrVal("User_identify", User_identify);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getTrade_type() {
		return ((String) getAttrVal("Trade_type"));
	}
	/**
	 * 交易类型
	 * @param Trade_type
	 */
	public void setTrade_type(String Trade_type) {
		setAttrVal("Trade_type", Trade_type);
	}
	/**
	 * 交易状态
	 * @return String
	 */
	public String getTrade_status() {
		return ((String) getAttrVal("Trade_status"));
	}
	/**
	 * 交易状态
	 * @param Trade_status
	 */
	public void setTrade_status(String Trade_status) {
		setAttrVal("Trade_status", Trade_status);
	}
	/**
	 * 付款银行
	 * @return String
	 */
	public String getBank() {
		return ((String) getAttrVal("Bank"));
	}
	/**
	 * 付款银行
	 * @param Bank
	 */
	public void setBank(String Bank) {
		setAttrVal("Bank", Bank);
	}
	/**
	 * 货币种类
	 * @return String
	 */
	public String getCurrency_type() {
		return ((String) getAttrVal("Currency_type"));
	}
	/**
	 * 货币种类
	 * @param Currency_type
	 */
	public void setCurrency_type(String Currency_type) {
		setAttrVal("Currency_type", Currency_type);
	}
	/**
	 * 总金额
	 * @return String
	 */
	public String getTotal_fee() {
		return ((String) getAttrVal("Total_fee"));
	}
	/**
	 * 总金额
	 * @param Total_fee
	 */
	public void setTotal_fee(String Total_fee) {
		setAttrVal("Total_fee", Total_fee);
	}
	/**
	 * 代金券金额
	 * @return String
	 */
	public String getVouchers_fee() {
		return ((String) getAttrVal("Vouchers_fee"));
	}
	/**
	 * 代金券金额
	 * @param Vouchers_fee
	 */
	public void setVouchers_fee(String Vouchers_fee) {
		setAttrVal("Vouchers_fee", Vouchers_fee);
	}
	/**
	 * 渠道退款单号
	 * @return String
	 */
	public String getChannel_refund_no() {
		return ((String) getAttrVal("Channel_refund_no"));
	}
	/**
	 * 渠道退款单号
	 * @param Channel_refund_no
	 */
	public void setChannel_refund_no(String Channel_refund_no) {
		setAttrVal("Channel_refund_no", Channel_refund_no);
	}
	/**
	 * 商户退款单号 
	 * @return String
	 */
	public String getMch_refund_no() {
		return ((String) getAttrVal("Mch_refund_no"));
	}
	/**
	 * 商户退款单号 
	 * @param Mch_refund_no
	 */
	public void setMch_refund_no(String Mch_refund_no) {
		setAttrVal("Mch_refund_no", Mch_refund_no);
	}
	/**
	 * 退款金额
	 * @return String
	 */
	public String getRefund_fee() {
		return ((String) getAttrVal("Refund_fee"));
	}
	/**
	 * 退款金额
	 * @param Refund_fee
	 */
	public void setRefund_fee(String Refund_fee) {
		setAttrVal("Refund_fee", Refund_fee);
	}
	/**
	 * 退款类型
	 * @return String
	 */
	public String getRefund_type() {
		return ((String) getAttrVal("Refund_type"));
	}
	/**
	 * 退款类型
	 * @param Refund_type
	 */
	public void setRefund_type(String Refund_type) {
		setAttrVal("Refund_type", Refund_type);
	}
	/**
	 * 退款状态
	 * @return String
	 */
	public String getRefund_status() {
		return ((String) getAttrVal("Refund_status"));
	}
	/**
	 * 退款状态
	 * @param Refund_status
	 */
	public void setRefund_status(String Refund_status) {
		setAttrVal("Refund_status", Refund_status);
	}
	/**
	 * 商品名
	 * @return String
	 */
	public String getProduct_name() {
		return ((String) getAttrVal("Product_name"));
	}
	/**
	 * 商品名
	 * @param Product_name
	 */
	public void setProduct_name(String Product_name) {
		setAttrVal("Product_name", Product_name);
	}
	/**
	 * 商户数据包
	 * @return String
	 */
	public String getMch_data() {
		return ((String) getAttrVal("Mch_data"));
	}
	/**
	 * 商户数据包
	 * @param Mch_data
	 */
	public void setMch_data(String Mch_data) {
		setAttrVal("Mch_data", Mch_data);
	}
	/**
	 * 手续费
	 * @return String
	 */
	public String getPoundage() {
		return ((String) getAttrVal("Poundage"));
	}
	/**
	 * 手续费
	 * @param Poundage
	 */
	public void setPoundage(String Poundage) {
		setAttrVal("Poundage", Poundage);
	}
	/**
	 * 费率
	 * @return String
	 */
	public String getRate() {
		return ((String) getAttrVal("Rate"));
	}
	/**
	 * 费率
	 * @param Rate
	 */
	public void setRate(String Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 渠道名称
	 * @return String
	 */
	public String getChalel_name() {
		return ((String) getAttrVal("Chalel_name"));
	}
	/**
	 * 渠道名称
	 * @param Chalel_name
	 */
	public void setChalel_name(String Chalel_name) {
		setAttrVal("Chalel_name", Chalel_name);
	}
	/**
	 * 平台ID
	 * @return String
	 */
	public String getPlatformid() {
		return ((String) getAttrVal("Platformid"));
	}
	/**
	 * 平台ID
	 * @param Platformid
	 */
	public void setPlatformid(String Platformid) {
		setAttrVal("Platformid", Platformid);
	}
	/**
	 * 银行流水
	 * @return String
	 */
	public String getBanktradeno() {
		return ((String) getAttrVal("Banktradeno"));
	}
	/**
	 * 银行流水
	 * @param Banktradeno
	 */
	public void setBanktradeno(String Banktradeno) {
		setAttrVal("Banktradeno", Banktradeno);
	}
}