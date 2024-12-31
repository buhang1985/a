package iih.bl.itf.std.bean.input.ippay.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 自助机住院收付款找零信息
 * @author shaokx 2020.03.18
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamIpChange implements Serializable{

	private static final long serialVersionUID = -4791633753800839535L;
	
	//支付交易流水凭证号
	@XmlElement(name = "documentNumber")
	private String documentNumber;
	
	//收单机构订单流水号
	@XmlElement(name = "orderNumber")
	private String orderNumber;
	
	//找零金额 (分) 单位为分便于数据处理
	@XmlElement(name = "changeMoney")
	private String changeMoney;
	
	//找零支付方式 便于对照和退款
	@XmlElement(name = "changeMethod")
	private String changeMethod;
	
	//银行卡号
	@XmlElement(name = "bankCardNo")
	private String bankCardNo;

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getChangeMoney() {
		return changeMoney;
	}

	public void setChangeMoney(String changeMoney) {
		this.changeMoney = changeMoney;
	}

	public String getChangeMethod() {
		return changeMethod;
	}

	public void setChangeMethod(String changeMethod) {
		this.changeMethod = changeMethod;
	}

	public String getBankCardNo() {
		return bankCardNo;
	}

	public void setBankCardNo(String bankCardNo) {
		this.bankCardNo = bankCardNo;
	}
	
	
}
