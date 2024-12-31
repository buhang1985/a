package iih.pis.ivx.account.d;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PayOEPInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "patCode")
	private String patCode;
	
	@XmlElement(name = "patName")
	private String patName;
	
	@XmlElement(name = "patSex")
	private String patSex;
	
	@XmlElement(name = "patBorthday")
	private String patBorthday;
	
	@XmlElement(name = "sdCode")
	private String sdCode;
	
	@XmlElement(name = "cardStatus")
	private String cardStatus;
	
	@XmlElement(name = "balance")
	private String balance;
	
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

	public String getNeedPaid() {
		return needPaid;
	}

	public void setNeedPaid(String needPaid) {
		this.needPaid = needPaid;
	}
	

}
