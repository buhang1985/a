package iih.bl.itf.std.bean.input.charge.sub;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 费用清单查询入参--患者信息
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamBillPatInfo extends WsParamInfoWithCustom {

	private static final long serialVersionUID = 1L;

	//患者编号
	@XmlElement(name = "patCode")
	private String patCode;
	
	//住院编号 住院号+住院次数
	@XmlElement(name = "IPCode")
	private String IPCode;
	
	//就诊次数
	@XmlElement(name = "enTimes")
	private String enTimes;
	
	//就诊卡号
	@XmlElement(name = "cardCode")
	private String cardCode;
	
	//身份证号
	@XmlElement(name = "sdCode")
	private String sdCode;
	
	//住院登记流水号
	@XmlElement(name = "enCode")
	private String enCode;
	
	//体检流水号
	@XmlElement(name = "peCode")
	private String peCode;

	//医院编码
	@XmlElement(name = "hospitalCode")
	private String hospitalCode;
	
	//就诊类型 01门诊 02住院
	@XmlElement(name = "entpCode")
	private String entpCode;
	
	//开始日期
	@XmlElement(name = "startDate")
	private String startDate;
	
	//结束日期
	@XmlElement(name = "endDate")
	private String endDate;
	
	public String getPeCode() {
		return peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}
	
	public String getPatCode() {
		return patCode;
	}

	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	public String getIPCode() {
		return IPCode;
	}

	public void setIPCode(String iPCode) {
		IPCode = iPCode;
	}

	public String getEnTimes() {
		return enTimes;
	}

	public void setEnTimes(String enTimes) {
		this.enTimes = enTimes;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getSdCode() {
		return sdCode;
	}

	public void setSdCode(String sdCode) {
		this.sdCode = sdCode;
	}

	public String getEnCode() {
		return enCode;
	}

	public void setEnCode(String enCode) {
		this.enCode = enCode;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public String getEntpCode() {
		return entpCode;
	}

	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
