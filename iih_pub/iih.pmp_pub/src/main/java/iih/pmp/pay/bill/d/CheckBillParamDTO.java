package iih.pmp.pay.bill.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 对账参数 DTO数据 
 * 
 */
public class CheckBillParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 请求日期
	 * @return FDateTime
	 */
	public FDateTime getDt_req() {
		return ((FDateTime) getAttrVal("Dt_req"));
	}
	/**
	 * 请求日期
	 * @param Dt_req
	 */
	public void setDt_req(FDateTime Dt_req) {
		setAttrVal("Dt_req", Dt_req);
	}
	/**
	 * 交易表主键
	 * @return String
	 */
	public String getId_trade() {
		return ((String) getAttrVal("Id_trade"));
	}
	/**
	 * 交易表主键
	 * @param Id_trade
	 */
	public void setId_trade(String Id_trade) {
		setAttrVal("Id_trade", Id_trade);
	}
	/**
	 * 订单表主键
	 * @return String
	 */
	public String getId_ord() {
		return ((String) getAttrVal("Id_ord"));
	}
	/**
	 * 订单表主键
	 * @param Id_ord
	 */
	public void setId_ord(String Id_ord) {
		setAttrVal("Id_ord", Id_ord);
	}
	/**
	 * 第三方主键
	 * @return String
	 */
	public String getId_channel_bill_item() {
		return ((String) getAttrVal("Id_channel_bill_item"));
	}
	/**
	 * 第三方主键
	 * @param Id_channel_bill_item
	 */
	public void setId_channel_bill_item(String Id_channel_bill_item) {
		setAttrVal("Id_channel_bill_item", Id_channel_bill_item);
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
	 * 交易号
	 * @return String
	 */
	public String getMch_trade_no() {
		return ((String) getAttrVal("Mch_trade_no"));
	}
	/**
	 * 交易号
	 * @param Mch_trade_no
	 */
	public void setMch_trade_no(String Mch_trade_no) {
		setAttrVal("Mch_trade_no", Mch_trade_no);
	}
	/**
	 * 渠道
	 * @return String
	 */
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}
	/**
	 * 渠道
	 * @param Id_chl
	 */
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	/**
	 * 渠道编码
	 * @return String
	 */
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}
	/**
	 * 渠道编码
	 * @param Sd_chl
	 */
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	/**
	 * 第三方交易状态
	 * @return String
	 */
	public String getAtrade_status() {
		return ((String) getAttrVal("Atrade_status"));
	}
	/**
	 * 第三方交易状态
	 * @param Atrade_status
	 */
	public void setAtrade_status(String Atrade_status) {
		setAttrVal("Atrade_status", Atrade_status);
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
	 * 交易表订单号
	 * @return String
	 */
	public String getBord_no() {
		return ((String) getAttrVal("Bord_no"));
	}
	/**
	 * 交易表订单号
	 * @param Bord_no
	 */
	public void setBord_no(String Bord_no) {
		setAttrVal("Bord_no", Bord_no);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getTotal_fee() {
		return ((FDouble) getAttrVal("Total_fee"));
	}
	/**
	 * 总金额
	 * @param Total_fee
	 */
	public void setTotal_fee(FDouble Total_fee) {
		setAttrVal("Total_fee", Total_fee);
	}
	/**
	 * 交易表总金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 交易表总金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 订单表总金额
	 * @return FDouble
	 */
	public FDouble getCamount() {
		return ((FDouble) getAttrVal("Camount"));
	}
	/**
	 * 订单表总金额
	 * @param Camount
	 */
	public void setCamount(FDouble Camount) {
		setAttrVal("Camount", Camount);
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
	 * 第三方对账状态
	 * @return Integer
	 */
	public Integer getCheck_rst() {
		return ((Integer) getAttrVal("Check_rst"));
	}
	/**
	 * 第三方对账状态
	 * @param Check_rst
	 */
	public void setCheck_rst(Integer Check_rst) {
		setAttrVal("Check_rst", Check_rst);
	}
	/**
	 * 交易表对账状态
	 * @return Integer
	 */
	public Integer getTcheck_rst() {
		return ((Integer) getAttrVal("Tcheck_rst"));
	}
	/**
	 * 交易表对账状态
	 * @param Tcheck_rst
	 */
	public void setTcheck_rst(Integer Tcheck_rst) {
		setAttrVal("Tcheck_rst", Tcheck_rst);
	}
	/**
	 * 订单表对账状态
	 * @return Integer
	 */
	public Integer getAckeckrst() {
		return ((Integer) getAttrVal("Ackeckrst"));
	}
	/**
	 * 订单表对账状态
	 * @param Ackeckrst
	 */
	public void setAckeckrst(Integer Ackeckrst) {
		setAttrVal("Ackeckrst", Ackeckrst);
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
	 * 异常表
	 * @return String
	 */
	public String getFailed_table() {
		return ((String) getAttrVal("Failed_table"));
	}
	/**
	 * 异常表
	 * @param Failed_table
	 */
	public void setFailed_table(String Failed_table) {
		setAttrVal("Failed_table", Failed_table);
	}
	/**
	 * 交易状态是否正确
	 * @return FBoolean
	 */
	public FBoolean getIs_status_checked() {
		return ((FBoolean) getAttrVal("Is_status_checked"));
	}
	/**
	 * 交易状态是否正确
	 * @param Is_status_checked
	 */
	public void setIs_status_checked(FBoolean Is_status_checked) {
		setAttrVal("Is_status_checked", Is_status_checked);
	}
	/**
	 * 交易金额是否正确
	 * @return FBoolean
	 */
	public FBoolean getIs_amaout_ckecked() {
		return ((FBoolean) getAttrVal("Is_amaout_ckecked"));
	}
	/**
	 * 交易金额是否正确
	 * @param Is_amaout_ckecked
	 */
	public void setIs_amaout_ckecked(FBoolean Is_amaout_ckecked) {
		setAttrVal("Is_amaout_ckecked", Is_amaout_ckecked);
	}
	/**
	 * 交易类型
	 * @return Integer
	 */
	public Integer getTrade_type() {
		return ((Integer) getAttrVal("Trade_type"));
	}
	/**
	 * 交易类型
	 * @param Trade_type
	 */
	public void setTrade_type(Integer Trade_type) {
		setAttrVal("Trade_type", Trade_type);
	}
	/**
	 * 渠道流水
	 * @return String
	 */
	public String getChanneltradeno() {
		return ((String) getAttrVal("Channeltradeno"));
	}
	/**
	 * 渠道流水
	 * @param Channeltradeno
	 */
	public void setChanneltradeno(String Channeltradeno) {
		setAttrVal("Channeltradeno", Channeltradeno);
	}
	/**
	 * 流水号
	 * @return String
	 */
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}
	/**
	 * 流水号
	 * @param Trade_no
	 */
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	/**
	 * 第三方交易号
	 * @return String
	 */
	public String getBanktradeno() {
		return ((String) getAttrVal("Banktradeno"));
	}
	/**
	 * 第三方交易号
	 * @param Banktradeno
	 */
	public void setBanktradeno(String Banktradeno) {
		setAttrVal("Banktradeno", Banktradeno);
	}
	
	public String getBill_type() {
		return ((String) getAttrVal("Bill_type"));
	}
	/**
	 * 对账单类型
	 * @param Banktradeno
	 */
	public void setBill_type(String Bill_type) {
		setAttrVal("Bill_type", Bill_type);
	}
}