package iih.bl.itf.std.bean.input.inc.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;

/**
 * 门诊自助发票查询入参数据
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamGetPatIncInfo extends WsParamInfoWithCustom {

	private static final long serialVersionUID = 1L;

	// 患者编码
	@XmlElement(name = "patCode")
	private String patCode;

	// 住院编号
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

	// 登记流水号
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

	// 操作员编码
	@XmlElement(name = "operaCode")
	private String operaCode;

	// 缴费来源 01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
	@XmlElement(name = "terminalType")
	private String terminalType;

	// 终端编码
	@XmlElement(name = "terminalNO")
	private String terminalNO;

	// 开始日期 建议可打印时间范围由自助机控制
	@XmlElement(name = "startDate")
	private String startDate;

	// 结束日期
	@XmlElement(name = "endDate")
	private String endDate;

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

	public String getOperaCode() {
		return operaCode;
	}

	public void setOperaCode(String operaCode) {
		this.operaCode = operaCode;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getTerminalNO() {
		return terminalNO;
	}

	public void setTerminalNO(String terminalNO) {
		this.terminalNO = terminalNO;
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
