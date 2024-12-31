package iih.bl.itf.std.bean.output.prepay.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 门诊账户信息
 * @author ly 2018/07/21
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpAccount implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//IIH患者编号
	@XmlElement(name = "patCode")
	private String patCode;
		
	//姓名
	@XmlElement(name = "patName")
	private String patName;
	
	//性别  1男 2女
	@XmlElement(name = "patSex")
	private String patSex;
	
	//出生日期
	@XmlElement(name = "patBorthday")
	private String patBorthday;

	//身份证号
	@XmlElement(name = "sdCode")
	private String sdCode;
		
	//卡状态 0空白 1在用 2挂失 3注销
	@XmlElement(name = "cardStatus")
	private String cardStatus;
		
	//账户余额 单位分
	@XmlElement(name = "balance")
	private String balance;
	
	public String getNeedPaid() {
		return needPaid;
	}

	public void setNeedPaid(String needPaid) {
		this.needPaid = needPaid;
	}

	//需待缴金额 单位分
	@XmlElement(name = "needPaid")
	private String needPaid;

	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getPatName() {
		return patName;
	}

	public void setPatName(String patName) {
		this.patName = patName;
	}

	public String getPatSex() {
		return patSex;
	}

	public void setPatSex(String patSex) {
		this.patSex = patSex;
	}

	public String getPatBorthday() {
		return patBorthday;
	}

	public void setPatBorthday(String patBorthday) {
		this.patBorthday = patBorthday;
	}

	public String getSdCode() {
		return sdCode;
	}

	public void setSdCode(String sdCode) {
		this.sdCode = sdCode;
	}

	public String getCardStatus() {
		return cardStatus;
	}

	public void setCardStatus(String cardStatus) {
		this.cardStatus = cardStatus;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}
	
}
