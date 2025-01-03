package iih.bl.itf.std.bean.input.charge.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;
import iih.bl.itf.std.bean.output.charge.sub.WsResultSingleEntInfo;

/**
 * 门诊自助支付待缴费项目入参--自助支付信息
 * 
 * @author shaokx 2019/01/14
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamSelfHelpPayInfo extends WsParamInfoWithCustom {

	private static final long serialVersionUID = 1L;

	// 患者编号
	@XmlElement(name = "patCode")
	private String patCode;

	// 住院编号 住院号+住院次数
	@XmlElement(name = "IPCode")
	private String IPCode;

	// 就诊次数
	@XmlElement(name = "enTimes")
	private String enTimes;

	// 就诊卡号
	@XmlElement(name = "cardCode")
	private String cardCode;

	// 身份证号
	@XmlElement(name = "sdCode")
	private String sdCode;

	// 住院登记流水号
	@XmlElement(name = "enCode")
	private String enCode;

	// 患者类型 医保类型根据当地维护定义规则 是否医保 Y ：医保 N：自费
	@XmlElement(name = "patType")
	private String patType;
	
	// 患者分类编码
	@XmlElement(name = "patCaCode")
	private String patCaCode;

	// 医院编码
	@XmlElement(name = "hospitalCode")
	private String hospitalCode;

	// 就诊类型 01门诊 02住院
	@XmlElement(name = "entpCode")
	private String entpCode;

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

	// 缴费来源
	// 01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
	@XmlElement(name = "terminalType")
	private String terminalType;

	// 终端编码
	@XmlElement(name = "terminalNO")
	private String terminalNO;

	// 票据类型 01：小票凭证 02：发票
	@XmlElement(name = "inctype")
	private String inctype;

	// 门诊本次所有医疗单据 就诊总费用 单位分
	@XmlElement(name = "entAmout")
	private String entAmout;

	// 结算id
	@XmlElement(name = "payNO")
	private String payNO;
	
	// 计算机标识
    @XmlElement(name = "pcId")
	private String pcId;

	// 就诊信息
	@XmlElementWrapper(name = "OEPEntList")
	@XmlElement(name = "entInfo")
	private List<WsResultSingleEntInfo> oepEntList;
	
	// 医保产品编码
	@XmlElement(name = "codeHp")
	private String codeHp;
	
	// 医保信息
	@XmlElement(name = "hpInfo")
	private WsParamHpTransactionOutInfo hpInfo;

	//银行卡号
	@XmlElement(name = "bankCardNo")
	private String bankCardNo;
	
	public String getPatCaCode() {
		return patCaCode;
	}

	public void setPatCaCode(String patCaCode) {
		this.patCaCode = patCaCode;
	}

	public String getPcId() {
		return pcId;
	}

	public void setPcId(String pcId) {
		this.pcId = pcId;
	}

	public String getPatCode() {
		return patCode;
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
	
	public String getPayNO() {
		return payNO;
	}

	public void setPayNO(String payNO) {
		this.payNO = payNO;
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

	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
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

	public String getInctype() {
		return inctype;
	}

	public void setInctype(String inctype) {
		this.inctype = inctype;
	}

	public String getEntAmout() {
		return entAmout;
	}

	public void setEntAmout(String entAmout) {
		this.entAmout = entAmout;
	}
	
	public List<WsResultSingleEntInfo> getOepEntList() {
		return oepEntList;
	}

	public void setOepEntList(List<WsResultSingleEntInfo> oepEntList) {
		this.oepEntList = oepEntList;
	}

	public String getCodeHp() {
		return codeHp;
	}

	public void setCodeHp(String codeHp) {
		this.codeHp = codeHp;
	}
	
	public WsParamHpTransactionOutInfo getHpInfo() {
		return hpInfo;
	}

	public void setHpInfo(WsParamHpTransactionOutInfo hpInfo) {
		this.hpInfo = hpInfo;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
}
