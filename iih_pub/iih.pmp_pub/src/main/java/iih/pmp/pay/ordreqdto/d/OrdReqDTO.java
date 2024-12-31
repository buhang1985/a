package iih.pmp.pay.ordreqdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 订单请求 DTO数据 
 * 
 */
public class OrdReqDTO extends BaseDTO {
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
	 * 退款请求号
	 * @return String
	 */
	public String getRefund_req_no() {
		return ((String) getAttrVal("Refund_req_no"));
	}
	/**
	 * 退款请求号
	 * @param Refund_req_no
	 */
	public void setRefund_req_no(String Refund_req_no) {
		setAttrVal("Refund_req_no", Refund_req_no);
	}
	/**
	 * 请求名称
	 * @return String
	 */
	public String getSubject() {
		return ((String) getAttrVal("Subject"));
	}
	/**
	 * 请求名称
	 * @param Subject
	 */
	public void setSubject(String Subject) {
		setAttrVal("Subject", Subject);
	}
	/**
	 * 请求内容
	 * @return String
	 */
	public String getBody() {
		return ((String) getAttrVal("Body"));
	}
	/**
	 * 请求内容
	 * @param Body
	 */
	public void setBody(String Body) {
		setAttrVal("Body", Body);
	}
	/**
	 * 请求金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 请求金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
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
	 * 退款标志
	 * @return FBoolean
	 */
	public FBoolean getFg_refund() {
		return ((FBoolean) getAttrVal("Fg_refund"));
	}
	/**
	 * 退款标志
	 * @param Fg_refund
	 */
	public void setFg_refund(FBoolean Fg_refund) {
		setAttrVal("Fg_refund", Fg_refund);
	}
	/**
	 * 预下单标志
	 * @return FBoolean
	 */
	public FBoolean getFg_precreate() {
		return ((FBoolean) getAttrVal("Fg_precreate"));
	}
	/**
	 * 预下单标志
	 * @param Fg_precreate
	 */
	public void setFg_precreate(FBoolean Fg_precreate) {
		setAttrVal("Fg_precreate", Fg_precreate);
	}
	/**
	 * 支付场景
	 * @return String
	 */
	public String getId_scene() {
		return ((String) getAttrVal("Id_scene"));
	}
	/**
	 * 支付场景
	 * @param Id_scene
	 */
	public void setId_scene(String Id_scene) {
		setAttrVal("Id_scene", Id_scene);
	}
	/**
	 * 支付渠道
	 * @return String
	 */
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}
	/**
	 * 支付渠道
	 * @param Id_chl
	 */
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	/**
	 * 支付授权码
	 * @return String
	 */
	public String getAuth_code() {
		return ((String) getAttrVal("Auth_code"));
	}
	/**
	 * 支付授权码
	 * @param Auth_code
	 */
	public void setAuth_code(String Auth_code) {
		setAttrVal("Auth_code", Auth_code);
	}
	/**
	 * 买家用户号
	 * @return String
	 */
	public String getBuyer_id() {
		return ((String) getAttrVal("Buyer_id"));
	}
	/**
	 * 买家用户号
	 * @param Buyer_id
	 */
	public void setBuyer_id(String Buyer_id) {
		setAttrVal("Buyer_id", Buyer_id);
	}
	/**
	 * 终端IP
	 * @return String
	 */
	public String getSpbill_create_ip() {
		return ((String) getAttrVal("Spbill_create_ip"));
	}
	/**
	 * 终端IP
	 * @param Spbill_create_ip
	 */
	public void setSpbill_create_ip(String Spbill_create_ip) {
		setAttrVal("Spbill_create_ip", Spbill_create_ip);
	}
	/**
	 * 支付场景编码
	 * @return String
	 */
	public String getSd_scene() {
		return ((String) getAttrVal("Sd_scene"));
	}
	/**
	 * 支付场景编码
	 * @param Sd_scene
	 */
	public void setSd_scene(String Sd_scene) {
		setAttrVal("Sd_scene", Sd_scene);
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
	 * 渠道名称
	 * @return String
	 */
	public String getName_chl() {
		return ((String) getAttrVal("Name_chl"));
	}
	/**
	 * 渠道名称
	 * @param Name_chl
	 */
	public void setName_chl(String Name_chl) {
		setAttrVal("Name_chl", Name_chl);
	}
	/**
	 * 场景名称
	 * @return String
	 */
	public String getName_scene() {
		return ((String) getAttrVal("Name_scene"));
	}
	/**
	 * 场景名称
	 * @param Name_scene
	 */
	public void setName_scene(String Name_scene) {
		setAttrVal("Name_scene", Name_scene);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_user() {
		return ((String) getAttrVal("Name_user"));
	}
	/**
	 * 用户名称
	 * @param Name_user
	 */
	public void setName_user(String Name_user) {
		setAttrVal("Name_user", Name_user);
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
	 * 设备信息
	 * @return String
	 */
	public String getDeviceinfo() {
		return ((String) getAttrVal("Deviceinfo"));
	}
	/**
	 * 设备信息
	 * @param Deviceinfo
	 */
	public void setDeviceinfo(String Deviceinfo) {
		setAttrVal("Deviceinfo", Deviceinfo);
	}
	/**
	 * 支付类型（民生银行使用）
	 * @return String
	 */
	public String getTradetype() {
		return ((String) getAttrVal("Tradetype"));
	}
	/**
	 * 支付类型（民生银行使用）
	 * @param Tradetype
	 */
	public void setTradetype(String Tradetype) {
		setAttrVal("Tradetype", Tradetype);
	}
	/**
	 * 操作人员是否参与查询
	 * @return FBoolean
	 */
	public FBoolean getFg_operator() {
		return ((FBoolean) getAttrVal("Fg_operator"));
	}
	/**
	 * 操作人员是否参与查询
	 * @param Fg_operator
	 */
	public void setFg_operator(FBoolean Fg_operator) {
		setAttrVal("Fg_operator", Fg_operator);
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
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 业务场景
	 * @return String
	 */
	public String getBiz_scene() {
		return ((String) getAttrVal("Biz_scene"));
	}
	/**
	 * 业务场景
	 * @param Biz_scene
	 */
	public void setBiz_scene(String Biz_scene) {
		setAttrVal("Biz_scene", Biz_scene);
	}
	/**
	 * 退款人员
	 * @return String
	 */
	public String getId_refund_user() {
		return ((String) getAttrVal("Id_refund_user"));
	}
	/**
	 * 退款人员
	 * @param Id_refund_user
	 */
	public void setId_refund_user(String Id_refund_user) {
		setAttrVal("Id_refund_user", Id_refund_user);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getId_pri_pm() {
		return ((String) getAttrVal("Id_pri_pm"));
	}
	/**
	 * 付款方式
	 * @param Id_pri_pm
	 */
	public void setId_pri_pm(String Id_pri_pm) {
		setAttrVal("Id_pri_pm", Id_pri_pm);
	}
	
	/* 订单ID
	 * @return String
	 */
	public String getId_ord() {
		return ((String) getAttrVal("Id_ord"));
	}
	/**

	 * 订单ID
	 * @param Id_ord
	 */
	public void setId_ord(String Id_ord) {
		setAttrVal("Id_ord", Id_ord);
	}
	
}