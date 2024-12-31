package iih.bl.itf.std.bean.input.ipsettle.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;
/**
 * 自助机住院结算信息
 * @author hanjq 下午4:37:01
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamIpSettleInfo extends WsParamInfoWithCustom{

	private static final long serialVersionUID = -4550584677516347355L;
	

	//患者编码
	@XmlElement(name = "patCode")
	private String patCode;
	
	//住院编号
	@XmlElement(name = "IPCode")
	private String IPCode;
	
	//就诊次数
	@XmlElement(name = "enTimes")
	private String enTimes;
	
	//就诊卡号
	@XmlElement(name = "cardCode")
	private String cardCode;
	
	//身份证号
	@XmlElement(name = "sdCode")
	private String sdCode;
	
	//登记流水号
	@XmlElement(name = "enCode")
	private String enCode;
	
	//患者类型 医保类型根据当地维护定义规则 是否医保 Y ：医保 N：自费
	@XmlElement(name = "patType")
	private String patType;
	
	//医保卡号
	@XmlElement(name = "hpCode")
	private String hpCode;
	
	// 电子社保卡二维码
	@XmlElement(name = "Essc_qr")
	private String Essc_qr;
	
	// 电子社保卡接口返回令牌
	@XmlElement(name = "Essc_token")
	private String Essc_token;
	
	//医保身份患者返回
	@XmlElement(name = "hpInfo")
	private WsParamHpCardInfo hpInfo;
	
	//医院编码
	@XmlElement(name = "hospitalCode")
	private String hospitalCode;
	
	//就诊类型
	@XmlElement(name = "entpCode")
	private String entpCode;
	
	
	//票据类型为01时，由自助机传入票据号，如果有值，这个号就是小票凭证号，如果没值，则凭证号自动生成
//	@XmlElement(name = "incPayNo")
//	private String incPayNo;
	
	//支付交易流水凭证号
//	@XmlElement(name = "documentNumber")
//	private String documentNumber;
//	
//	//支付方式
//	@XmlElement(name = "paymentMethod")
//	private String paymentMethod;
//	
//	//支付金额
//	@XmlElement(name = "payMoney")
//	private String payMoney;
//	
//	//收单机构订单流水号
//	@XmlElement(name = "orderNumber")
//	private String orderNumber;
//	
//	//支付时间
//	@XmlElement(name = "payTime")
//	private String payTime;
	
	//操作员编码
	@XmlElement(name = "operaCode")
	private String operaCode;
	
	//缴费来源
	@XmlElement(name = "terminalType")
	private String terminalType;
	
	//终端编码
	@XmlElement(name = "terminalNO")
	private String terminalNO;

	//票据类型(票据类型 01：小票凭证[自助机打印，不走IIH票据管理] 02：纸质押金凭证 3：电子发票凭证)
	@XmlElement(name = "inctype")
	private String inctype;
	
//	public String getIncPayNo() {
//		return incPayNo;
//	}
//
//	public void setIncPayNo(String incPayNo) {
//		this.incPayNo = incPayNo;
//	}	

	public String getPatCode() {
		return patCode;
	}

	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
	}

	public String getHpCode() {
		return hpCode;
	}

	public void setHpCode(String hpCode) {
		this.hpCode = hpCode;
	}

	public String getEssc_qr() {
		return Essc_qr;
	}

	public void setEssc_qr(String essc_qr) {
		Essc_qr = essc_qr;
	}

	public String getEssc_token() {
		return Essc_token;
	}

	public void setEssc_token(String essc_token) {
		Essc_token = essc_token;
	}

	public WsParamHpCardInfo getHpInfo() {
		return hpInfo;
	}

	public void setHpInfo(WsParamHpCardInfo hpInfo) {
		this.hpInfo = hpInfo;
	}

	public String getInctype() {
		return inctype;
	}

	public void setInctype(String inctype) {
		this.inctype = inctype;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getIPCode() {
		return IPCode;
	}

	public void setIPCode(String iPCode) {
		IPCode = iPCode;
	}

	public String getEnTimes() {
		return enTimes;
	}

	public void setEnTimes(String enTimes) {
		this.enTimes = enTimes;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getSdCode() {
		return sdCode;
	}

	public void setSdCode(String sdCode) {
		this.sdCode = sdCode;
	}

	public String getEnCode() {
		return enCode;
	}

	public void setEnCode(String enCode) {
		this.enCode = enCode;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getEntpCode() {
		return entpCode;
	}

	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}
/*
	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}*/

	public String getOperaCode() {
		return operaCode;
	}

	public void setOperaCode(String operaCode) {
		this.operaCode = operaCode;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getTerminalNO() {
		return terminalNO;
	}

	public void setTerminalNO(String terminalNO) {
		this.terminalNO = terminalNO;
	}
}
