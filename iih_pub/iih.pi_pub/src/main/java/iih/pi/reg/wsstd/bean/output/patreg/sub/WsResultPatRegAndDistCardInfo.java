package iih.pi.reg.wsstd.bean.output.patreg.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 患者注册发卡或患者注册出参明细
 * 
 * @author shaokx 2019/01/31
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPatRegAndDistCardInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 患者编号
	@XmlElement(name = "patCode")
	private String patCode;

	// 门诊号 （发卡时返回空）
	@XmlElement(name = "oepCode")
	private String oepCode;

	// 账户余额，单位分 （发卡时返回空）
	@XmlElement(name = "balance")
	private String balance;

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getOepCode() {
		return oepCode;
	}

	public void setOepCode(String oepCode) {
		this.oepCode = oepCode;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
