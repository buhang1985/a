package iih.pi.reg.wsstd.bean.input.patinfo.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 患者信息查询入参--患者信息
 * 
 * @author shaokx 2019/01/28
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamPatInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 患者编号
	@XmlElement(name = "patCode")
	private String patCode;

	// 住院编号 住院号+住院次数
	@XmlElement(name = "IPCode")
	private String IPCode;

	// 就诊次数
	@XmlElement(name = "enTimes")
	private String enTimes;

	// 就诊卡号
	@XmlElement(name = "cardCode")
	private String cardCode;

	// 身份证号
	@XmlElement(name = "sdCode")
	private String sdCode;

	// 住院登记流水号
	@XmlElement(name = "enCode")
	private String enCode;

	// 患者类型 医保类型根据当地维护定义规则 是否医保 Y ：医保 N：自费
	@XmlElement(name = "patType")
	private String patType;

	// 医保卡号
	@XmlElement(name = "hpCode")
	private String hpCode;

	// 医院编码
	@XmlElement(name = "hospitalCode")
	private String hospitalCode;

	// 就诊类型 01门诊 02住院
	@XmlElement(name = "entpCode")
	private String entpCode;

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

	public String getPatType() {
		return patType;
	}

	public void setPatType(String patType) {
		this.patType = patType;
	}

	public String getHpCode() {
		return hpCode;
	}

	public void setHpCode(String hpCode) {
		this.hpCode = hpCode;
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
	
	
}
