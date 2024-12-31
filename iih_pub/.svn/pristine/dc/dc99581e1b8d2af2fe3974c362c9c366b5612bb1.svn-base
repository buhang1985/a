package iih.bl.itf.std.bean.output.prepay.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import xap.mw.coreitf.d.FDouble;

/**
 * 门诊充值记录数据模型
 * @author shaokx 2018/07/23
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPayInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//支付票据编码
	@XmlElement(name = "incCode")
	private String incCode;
	
	//支付方式
	@XmlElement(name = "payMethod")
	private String payMethod;
	
	//金额状态（取消标志）
	@XmlElement(name = "status")
	private String status;
	
	//交易时间
	@XmlElement(name = "tradeTime")
	private String tradeTime;
	
	//账户余额
	@XmlElement(name = "amt")
	private String amt;
	
	//备注
	@XmlElement(name = "note")
	private String note;

	public String getIncCode() {
		return incCode;
	}

	public void setIncCode(String incCode) {
		this.incCode = incCode;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
