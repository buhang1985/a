package iih.bl.itf.std.bean.output.prepay.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 充值记录查询明细
 * @author shaokx 2020/02/11
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoRechargeItmQry implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//支付时间
    @XmlElement(name = "payTime")
	private String payTime;
    
    //支付方式
    @XmlElement(name = "paymentMethod")
	private String paymentMethod;
    
    //收单机构订单流水号
    @XmlElement(name = "orderNumber")
	private String orderNumber;
    
    //支付交易流水凭证号
    @XmlElement(name = "documentNumber")
	private String documentNumber;
    
    //发票号
    @XmlElement(name = "incCode")
	private String incCode;
    
    //金额
    @XmlElement(name = "payMoney")
	private String payMoney;
    
    //缴费来源手机APP/微信 01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP 
    @XmlElement(name = "terminalType")
	private String terminalType;
    
    //payStatus为1时：正向，为-1时：负向【只返回正向数据】
    @XmlElement(name = "payStatus")
	private String payStatus;

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getIncCode() {
		return incCode;
	}

	public void setIncCode(String incCode) {
		this.incCode = incCode;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}	
}
