package iih.bl.itf.std.bean.input.ippay.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;
import iih.bl.itf.std.bean.input.ipsettle.sub.WsParamHpCardInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPTotalcostInfo;
/**
 * 自助机住院结算支付信息
 * @author hanjq 下午4:37:01
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamIpPayInfo extends WsParamInfoWithCustom{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1122454763848031105L;

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
//		@XmlElement(name = "incPayNo")
//		private String incPayNo;
	
	//支付交易流水凭证号
//		@XmlElement(name = "documentNumber")
//		private String documentNumber;
//	
//		//支付方式
//		@XmlElement(name = "paymentMethod")
//		private String paymentMethod;
//	
//		//支付金额
//		@XmlElement(name = "payMoney")
//		private String payMoney;
//	
//		//收单机构订单流水号
//		@XmlElement(name = "orderNumber")
//		private String orderNumber;
//	
//		//支付时间
//		@XmlElement(name = "payTime")
//		private String payTime;
	
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
	//医保产品编码
	/*@XmlElement(name = "hpType")
	private String hpType;*/
	
	//支付顺序号码
	@XmlElement(name = "payNO")
	private String payNO;
	
	//找零是否结转 Y：结转  N：不结转
	@XmlElement(name = "fgChangeTf")
	private String fgChangeTf;
	
	//交易支付信息
	@XmlElementWrapper(name = "paymentList")
	@XmlElement(name = "paymentInfo")
	private List<WsParamIpPayment> paymentList;
	
	//找零信息
	@XmlElementWrapper(name = "changeList")
	@XmlElement(name = "changeInfo")
	private List<WsParamIpChange> changeList;
	
	//住院总费用待结算支付汇总
	@XmlElement(name = "IPTotalcostInfo")
	private WsResultIPTotalcostInfo IPTotalcostInfo;

	public String getFgChangeTf() {
		return fgChangeTf;
	}

	public void setFgChangeTf(String fgChangeTf) {
		this.fgChangeTf = fgChangeTf;
	}

	public List<WsParamIpChange> getChangeList() {
		return changeList;
	}

	public void setChangeList(List<WsParamIpChange> changeList) {
		this.changeList = changeList;
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

	public String getPayNO() {
		return payNO;
	}

	public void setPayNO(String payNO) {
		this.payNO = payNO;
	}

	public List<WsParamIpPayment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<WsParamIpPayment> paymentList) {
		this.paymentList = paymentList;
	}

	public WsResultIPTotalcostInfo getIPTotalcostInfo() {
		return IPTotalcostInfo;
	}

	public void setIPTotalcostInfo(WsResultIPTotalcostInfo iPTotalcostInfo) {
		IPTotalcostInfo = iPTotalcostInfo;
	}
	
}
