package iih.pi.reg.ws.parambean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 自助机发卡返回值JavaBean明细
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PatRegAndDistrResultBeanInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String patCode;
	private String oepCode;
	private String balance;

	/**
	 * 患者编号
	 * 
	 * @return
	 */
	public String getPatCode() {
		return patCode;
	}

	/**
	 * 患者编号
	 * 
	 * @param patCode
	 */
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	/**
	 * 门诊号 (发卡时返回空)
	 * 
	 * @return
	 */
	public String getOepCode() {
		return oepCode;
	}

	/**
	 * 门诊号(发卡时返回空)
	 * 
	 * @param oepCode
	 */
	public void setOepCode(String oepCode) {
		this.oepCode = oepCode;
	}

	/**
	 * 账户余额，单位分(发卡时返回空)
	 * 
	 * @return
	 */
	public String getBalance() {
		return balance;
	}

	/**
	 * 账户余额，单位分(发卡时返回空)
	 * 
	 * @param balance
	 */
	public void setBalance(String balance) {
		this.balance = balance;
	}

}
