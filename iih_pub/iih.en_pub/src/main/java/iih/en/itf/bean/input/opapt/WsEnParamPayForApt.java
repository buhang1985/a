package iih.en.itf.bean.input.opapt;

import iih.en.itf.bean.input.WsEnParam;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 收取预约费 Ws入参 
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsEnParamPayForApt extends WsEnParam {

	private static final long serialVersionUID = 1L;
	/**
	 * 预约ID
	 */
	@XmlElement(name = "id_apt")
	private String id_apt;
	/**
	 * 患者ID
	 */
	@XmlElement(name = "patCode")
	private String patCode;
	/**
	 * 渠道类型
	 */
	@XmlElement(name = "chlType")
	private String chlType;
	/**
	 * 支付订单号
	 */
	@XmlElement(name = "orderNo")
	private String orderNo;
	/**
	 * 支付账号
	 */
	@XmlElement(name = "accNo")
	private String accNo;
	/**
	 * 支付方式
	 */
	@XmlElement(name = "payType")
	private String payType;
	/**
	 * 患者卡号
	 */
	@XmlElement(name = "patCardNo")
	private String patCardNo;
	/**
	 * 患者卡密码
	 */
	@XmlElement(name = "patCardPwd")
	private String patCardPwd;
	/**
	 * 金额
	 */
	@XmlElement(name = "money")
	private String money;
	/**
	 * 操作员
	 */
	@XmlElement(name = "oprCode")
	private String oprCode;
	/***
	 * 结算Id
	 */
	@XmlElement(name = "id_stoep")
	private String id_stoep;
	/***
	 * 结算时间
	 */
	@XmlElement(name = "dt_st")
	private String dt_st;
	/***
	 * 交易流水号
	 */
	@XmlElement(name = "business_code")
	private String business_code;
	/***
	 * 是否打印发票
	 */
	@XmlElement(name = "fg_printInvoice")
	private String fg_printInvoice;
	/**
	 * 是否取号
	 */
	@XmlElement(name = "fg_takeAptNo")
	private String fg_takeAptNo;
	/**
	 * 医保编码
	 */
	@XmlElement(name = "code_hp")
	private String code_hp;
	/**
	 * 医保信息
	 */
	@XmlElement(name = "hpInfo")
	private WsEnParamPayForAptHpItem hpInfo;
	
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
	
	public String getFg_printInvoice() {
		return fg_printInvoice;
	}
	
	public void setFg_printInvoice(String fg_printInvoice) {
		this.fg_printInvoice = fg_printInvoice;
	}

	public String getFg_takeAptNo() {
		return fg_takeAptNo;
	}

	public void setFg_takeAptNo(String fg_takeAptNo) {
		this.fg_takeAptNo = fg_takeAptNo;
	}

	public String getId_stoep() {
		return id_stoep;
	}

	public void setId_stoep(String id_stoep) {
		this.id_stoep = id_stoep;
	}

	public WsEnParamPayForAptHpItem getHpInfo() {
		return hpInfo;
	}

	public void setHpInfo(WsEnParamPayForAptHpItem hpInfo) {
		this.hpInfo = hpInfo;
	}

	public String getCode_hp() {
		return code_hp;
	}

	public void setCode_hp(String code_hp) {
		this.code_hp = code_hp;
	}
}
