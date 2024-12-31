package iih.bl.itf.std.bean.output.settle.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfo;

/**
 * 住院预交金汇总
 * @author hanjq 下午5:27:40
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIPPrepayInfo extends WsResultInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3282600442649341402L;

	//预交金收据号
	@XmlElement(name = "prepayNO")
	private String prepayNO;
	
	//预交金金额（单位分）
	@XmlElement(name = "prepayment")
	private String prepayment;
	
	//支付交易流水凭证号
	@XmlElement(name = "documentNumber")
	private String documentNumber;
	
	//支付方式 便于对照和退款
	@XmlElement(name = "paymentMethod")
	private String paymentMethod;
	
	//收单机构订单流水号
	@XmlElement(name = "orderNumber")
	private String orderNumber;
	
	//支付时间
	@XmlElement(name = "payTime")
	private String payTime;
	
	//操作员编码
	@XmlElement(name = "operaCode")
	private String operaCode;

	public String getPrepayNO() {
		return prepayNO;
	}

	public void setPrepayNO(String prepayNO) {
		this.prepayNO = prepayNO;
	}

	public String getPrepayment() {
		return prepayment;
	}

	public void setPrepayment(String prepayment) {
		this.prepayment = prepayment;
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
	
}
