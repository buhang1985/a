package iih.bl.itf.std.bean.output.balacc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 对账数据模型
 * @author shaokx 2019/07/04
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOrderPayInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//支付时间
	@XmlElement(name = "payTime")
	private String payTime;
		
	//支付方式
	@XmlElement(name = "paymentMethod")
	private String paymentMethod;
		
	//订单号(取Paymodenode)
	@XmlElement(name = "orderNumber")
	private String orderNumber;
		
	//交易凭证号（取bankno）
	@XmlElement(name = "documentNumber")
	private String documentNumber;
		
	//票据号
	@XmlElement(name = "stCode")
	private String stCode;
		
	//支付金额
	@XmlElement(name = "payMoney")
	private String payMoney;

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


	public String getStCode() {
		return stCode;
	}

	public void setStCode(String stCode) {
		this.stCode = stCode;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}
	
}
