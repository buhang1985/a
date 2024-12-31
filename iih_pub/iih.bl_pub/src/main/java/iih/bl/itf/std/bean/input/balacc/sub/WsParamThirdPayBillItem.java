package iih.bl.itf.std.bean.input.balacc.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamThirdPayBillItem extends WsParamInfoWithCustom{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
    * 交易时间
    */
   @XmlElement(name = "payTime")
   private String payTime;
   /**
    * 患者id
    */
   @XmlElement(name = "patientID")
   private String patientID;
   /**
    * 交易号
    */
   @XmlElement(name = "payNum")
   private String payNum;
   /**
    * 订单号
    */
   @XmlElement(name = "payOrderID")
   private String payOrderID;
   /**
    * 交易金额
    */
   @XmlElement(name = "amount")
   private String amount;
   /**
    * 患者姓名
    */
   @XmlElement(name = "patientName")
   private String patientName;
   /**
    * 缴费备注
    */
   @XmlElement(name = "receiptRegisterInfo")
   private String  receiptRegisterInfo;
   /**
    * 支付类型描述
    */
   @XmlElement(name = "payModeDesc")
   private String payModeDesc;
   /**
    * 业务类型描述
    */
   @XmlElement(name = "typeDesc")
   private String typeDesc;
   /**
    * 收据ID
    */
   @XmlElement(name = "receiptID")
   private String receiptID;
   /**
    * 支付类型值
    */
   @XmlElement(name = "payMode")
   private String payMode;
   /**
    * 业务类型值
    */
   @XmlElement(name = "typeFlag")
   private String typeFlag;
   /**
    * 外部订单来源描述
    */
   @XmlElement(name = "outPreOrderTypeDesc")
   private String outPreOrderTypeDesc;
   /**
    * 订单来源终端编码
    */
   @XmlElement(name = "sourceCode")
   private String sourceCode;
   /**
    * 订单来源终端名称
    */
   @XmlElement(name = "source")
   private String source;
   /**
    * 订单渠道类型
    */
   @XmlElement(name = "type")
   private String type;
public String getPayTime() {
	return payTime;
}
public void setPayTime(String payTime) {
	this.payTime = payTime;
}
public String getPatientID() {
	return patientID;
}
public void setPatientID(String patientID) {
	this.patientID = patientID;
}
public String getPayNum() {
	return payNum;
}
public void setPayNum(String payNum) {
	this.payNum = payNum;
}
public String getPayOrderID() {
	return payOrderID;
}
public void setPayOrderID(String payOrderID) {
	this.payOrderID = payOrderID;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public String getReceiptRegisterInfo() {
	return receiptRegisterInfo;
}
public void setReceiptRegisterInfo(String receiptRegisterInfo) {
	this.receiptRegisterInfo = receiptRegisterInfo;
}
public String getPayModeDesc() {
	return payModeDesc;
}
public void setPayModeDesc(String payModeDesc) {
	this.payModeDesc = payModeDesc;
}
public String getTypeDesc() {
	return typeDesc;
}
public void setTypeDesc(String typeDesc) {
	this.typeDesc = typeDesc;
}
public String getReceiptID() {
	return receiptID;
}
public void setReceiptID(String receiptID) {
	this.receiptID = receiptID;
}
public String getPayMode() {
	return payMode;
}
public void setPayMode(String payMode) {
	this.payMode = payMode;
}
public String getTypeFlag() {
	return typeFlag;
}
public void setTypeFlag(String typeFlag) {
	this.typeFlag = typeFlag;
}
public String getOutPreOrderTypeDesc() {
	return outPreOrderTypeDesc;
}
public void setOutPreOrderTypeDesc(String outPreOrderTypeDesc) {
	this.outPreOrderTypeDesc = outPreOrderTypeDesc;
}
public String getSourceCode() {
	return sourceCode;
}
public void setSourceCode(String sourceCode) {
	this.sourceCode = sourceCode;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
   
}
