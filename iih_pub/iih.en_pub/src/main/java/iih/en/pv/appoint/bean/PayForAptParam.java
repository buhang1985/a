package iih.en.pv.appoint.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 付费-入参解析
 * 
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayForAptParam extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/***
	 * 是否打印发票
	 */
	private String fg_printInvoice;
	/***
	 * 第三方交易时间
	 */
	private String dt_st;
	/***
	 * 第三方交易号
	 */
	private String business_code;
	/**
	 * 预约ID
	 */
	private String id_apt;
	/**
	 * 患者ID
	 */
	private String patCode;
	/**
	 * 渠道类型
	 */
	private String chlType;
	/**
	 * 第三方支付订单号
	 */
	private String orderNo;
	/**
	 * 第三方支付账号
	 */
	private String accNo;
	/**
	 * 第三方支付方式
	 */
	private String payType;
	/**
	 * 患者卡号
	 */
	private String patCardNo;
	/**
	 * 患者卡密码
	 */
	private String patCardPwd;
	/**
	 * 金额
	 */
	private String money;
	/**
	 * 操作员
	 */
	private String oprCode;
	/**
	 * 患者医保类型
	 */
	private String patHpTp;
	/**
	 * 医保费用数据
	 */
	private String hpPriceData;
	/**
	 * 医保卡号
	 */
	private String patHpNo;
	/**
	 * 医保信息XML
	 */
	private String hpPatInfXml;
	
	public String getDt_st() {
		return dt_st;
	}
	public void setDt_st(String dt_st) {
		this.dt_st = dt_st;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getChlType() {
		return chlType;
	}
	public void setChlType(String chlType) {
		this.chlType = chlType;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPatCardNo() {
		return patCardNo;
	}
	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}
	public String getPatCardPwd() {
		return patCardPwd;
	}
	public void setPatCardPwd(String patCardPwd) {
		this.patCardPwd = patCardPwd;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}
	public String getPatHpTp() {
		return patHpTp;
	}
	public void setPatHpTp(String patHpTp) {
		this.patHpTp = patHpTp;
	}
	public String getHpPriceData() {
		return hpPriceData;
	}
	public void setHpPriceData(String hpPriceData) {
		this.hpPriceData = hpPriceData;
	}
	public String getPatHpNo() {
		return patHpNo;
	}
	public void setPatHpNo(String patHpNo) {
		this.patHpNo = patHpNo;
	}
	public String getHpPatInfXml() {
		return hpPatInfXml;
	}
	public void setHpPatInfXml(String hpPatInfXml) {
		this.hpPatInfXml = hpPatInfXml;
	}
	public String getFg_printInvoice() {
		return fg_printInvoice;
	}
	public void setFg_printInvoice(String fg_printInvoice) {
		this.fg_printInvoice = fg_printInvoice;
	}

}
