package iih.bl.itf.std.bean.output.settle.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfo;

/**
 * 住院总费用汇总
 * @author hanjq 下午5:27:40
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIPTotalcostInfo extends WsResultInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3337839916385392237L;

	//住院费用总金额（单位分）
	@XmlElement(name = "totalAmt")
	private String totalAmt;
	
	//预交金总额（单位分）
	@XmlElement(name = "prepayment")
	private String prepayment;
	
	//预交金可用总额（单位分）
	@XmlElement(name = "balance")
	private String balance;
	
	//未结算总额（单位分）
	@XmlElement(name = "unsettled")
	private String unsettled;
	
	//已结算总额（单位分）
	@XmlElement(name = "settled")
	private String settled;
	
	//当日总金额（单位分）
	@XmlElement(name = "dayAmt")
	private String dayAmt;
	
	//备注
	@XmlElement(name = "note")
	private String note;

	public String getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getPrepayment() {
		return prepayment;
	}

	public void setPrepayment(String prepayment) {
		this.prepayment = prepayment;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getUnsettled() {
		return unsettled;
	}

	public void setUnsettled(String unsettled) {
		this.unsettled = unsettled;
	}

	public String getSettled() {
		return settled;
	}

	public void setSettled(String settled) {
		this.settled = settled;
	}

	public String getDayAmt() {
		return dayAmt;
	}

	public void setDayAmt(String dayAmt) {
		this.dayAmt = dayAmt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
