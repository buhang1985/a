package iih.bl.itf.std.bean.input.ippay.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
/**
 * 自助机住院交易支付信息
 * @author hanjq 下午4:37:01
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamIpPayment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4791633753800839535L;

	//支付交易流水凭证号
	@XmlElement(name = "documentNumber")
	private String documentNumber;
	
	//支付方式 便于对照和退款
	@XmlElement(name = "paymentMethod")
	private String paymentMethod;
	
	//支付金额 (分) 单位为分便于数据处理
	@XmlElement(name = "payMoney")
	private String payMoney;
	
	//收单机构订单流水号
	@XmlElement(name = "orderNumber")
	private String orderNumber;
	
	//支付时间
	@XmlElement(name = "payTime")
	private String payTime;
	
	//操作员编码
	@XmlElement(name = "operaCode")
	private String operaCode;

	
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
	
}
