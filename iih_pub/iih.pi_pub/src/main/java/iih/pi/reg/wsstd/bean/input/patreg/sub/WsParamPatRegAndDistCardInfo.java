package iih.pi.reg.wsstd.bean.input.patreg.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 患者注册发卡或者患者注册入参明细
 * 
 * @author shaokx 2019/01/31
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamPatRegAndDistCardInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 用户姓名
	@XmlElement(name = "patName")
	private String patName;

	// 住院编号
	@XmlElement(name = "IPCode")
	private String IPCode;

	// 就诊卡号
	@XmlElement(name = "cardCode")
	private String cardCode;

	// 证件类型
	@XmlElement(name = "sdType")
	private String sdType;
	
	// 证件号
	@XmlElement(name = "sdCode")
	private String sdCode;

	// 手机号
	@XmlElement(name = "phoneCode")
	private String phoneCode;

	// 性别 1男 2女
	@XmlElement(name = "patSex")
	private String patSex;

	// 出生日期
	@XmlElement(name = "patBorthday")
	private String patBorthday;

	// 医保卡号
	@XmlElement(name = "hpCode")
	private String hpCode;

	// 银行卡号
	@XmlElement(name = "bankCode")
	private String bankCode;

	// 就诊卡印刷号
	@XmlElement(name = "faceCode")
	private String faceCode;

	// 是否购买病历本 Y：购买 N：不够买
	@XmlElement(name = "mrbook")
	private String mrbook;

	// 卡类型：01卡不收钱 02 卡扣费用 03卡收押金 04 其他
	@XmlElement(name = "cardType")
	private String cardType;

	// 操作动作：01发卡 02 绑定 03取消绑定 04 建档
	@XmlElement(name = "doType")
	private String doType;

	// 支付交易流水凭证号
	@XmlElement(name = "documentNumber")
	private String documentNumber;

	// 支付方式 便于对照和退款
	@XmlElement(name = "paymentMethod")
	private String paymentMethod;

	// 支付金额 (分) 单位为分便于数据处理
	@XmlElement(name = "payMoney")
	private String payMoney;

	// 收单机构订单流水号
	@XmlElement(name = "orderNumber")
	private String orderNumber;

	// 支付时间
	@XmlElement(name = "payTime")
	private String payTime;

	// 操作员编码
	@XmlElement(name = "operaCode")
	private String operaCode;

	// 缴费来源手机 01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
	@XmlElement(name = "terminalType")
	private String terminalType;

	// 终端编码
	@XmlElement(name = "terminalNO")
	private String terminalNO;
	
    //患者编码
	@XmlElement(name = "patCode")
	private String patCode;
	
	//应通知家属名称
	@XmlElement(name = "relationName")
	private String relationName;
	
	//应通知家属关系编码
	@XmlElement(name = "relationCode")
	private String relationCode;
	
	//家属身份编码
	@XmlElement(name = "roleCode")
	private String roleCode;
	
	//应通知家属地址
	@XmlElement(name = "relationStreet")
	private String relationStreet;
	
	//应通知家属电话
	@XmlElement(name = "relationTel")
	private String relationTel;
	
	//证件类型
	@XmlElement(name = "sdidType")
	private String sdidType;
	
	//证件号
	@XmlElement(name = "socialNo")
	private String socialNo;
	
	//工作单位
    @XmlElement(name = "workUnit")
	private String workUnit;
    
    //现住址区县码
    @XmlElement(name = "nowDistrict")
	private String nowDistrict;
    
    //现住址详细地址
    @XmlElement(name = "nowStreet")
	private String nowStreet;
    
	
	public String getSdType() {
		return sdType;
	}

	public void setSdType(String sdType) {
		this.sdType = sdType;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getNowDistrict() {
		return nowDistrict;
	}

	public void setNowDistrict(String nowDistrict) {
		this.nowDistrict = nowDistrict;
	}

	public String getNowStreet() {
		return nowStreet;
	}

	public void setNowStreet(String nowStreet) {
		this.nowStreet = nowStreet;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getRelationCode() {
		return relationCode;
	}

	public void setRelationCode(String relationCode) {
		this.relationCode = relationCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRelationStreet() {
		return relationStreet;
	}

	public void setRelationStreet(String relationStreet) {
		this.relationStreet = relationStreet;
	}

	public String getRelationTel() {
		return relationTel;
	}

	public void setRelationTel(String relationTel) {
		this.relationTel = relationTel;
	}

	public String getSdidType() {
		return sdidType;
	}

	public void setSdidType(String sdidType) {
		this.sdidType = sdidType;
	}

	public String getSocialNo() {
		return socialNo;
	}

	public void setSocialNo(String socialNo) {
		this.socialNo = socialNo;
	}

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getIPCode() {
		return IPCode;
	}

	public void setIPCode(String iPCode) {
		IPCode = iPCode;
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

	public String getPhoneCode() {
		return phoneCode;
	}

	public void setPhoneCode(String phoneCode) {
		this.phoneCode = phoneCode;
	}

	public String getPatSex() {
		return patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	public String getPatBorthday() {
		return patBorthday;
	}

	public void setPatBorthday(String patBorthday) {
		this.patBorthday = patBorthday;
	}

	public String getHpCode() {
		return hpCode;
	}

	public void setHpCode(String hpCode) {
		this.hpCode = hpCode;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getFaceCode() {
		return faceCode;
	}

	public void setFaceCode(String faceCode) {
		this.faceCode = faceCode;
	}

	public String getMrbook() {
		return mrbook;
	}

	public void setMrbook(String mrbook) {
		this.mrbook = mrbook;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getDoType() {
		return doType;
	}

	public void setDoType(String doType) {
		this.doType = doType;
	}

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
	}

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
