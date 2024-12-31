package iih.bl.itf.std.bean.output.prepay;

import iih.bl.itf.std.bean.output.WsResultInfoWithCustom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 预交金充值数据结果
 * 
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoPrepay extends WsResultInfoWithCustom {

	private static final long serialVersionUID = 1L;

	// 支付票据编码
	@XmlElement(name = "incCode")
	private String incCode;

	// 账户余额 单位分
	@XmlElement(name = "balance")
	private String balance;

	public String getIncCode() {
		return incCode;
	}

	public void setIncCode(String incCode) {
		this.incCode = incCode;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
