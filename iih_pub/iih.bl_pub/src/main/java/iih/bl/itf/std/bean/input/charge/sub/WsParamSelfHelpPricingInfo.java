package iih.bl.itf.std.bean.input.charge.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;
import iih.bl.itf.std.bean.output.charge.sub.WsResultSingleEntInfo;

/**
 * 门诊自助划价入参明细
 * 
 * @author shaokx 2019/01/17
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamSelfHelpPricingInfo extends WsParamInfoWithCustom {

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
	
	// 体检流水号
	@XmlElement(name = "peCode")
	private String peCode;

	// 患者类型 医保类型根据当地维护定义规则 是否医保 Y ：医保 N：自费
	@XmlElement(name = "patType")
	private String patType;
	
	// 患者分类编码
	@XmlElement(name = "patCaCode")
	private String patCaCode;

	// 医保卡号
	@XmlElement(name = "hpCode")
	private String hpCode;
	
	// 电子社保卡二维码
	@XmlElement(name = "Essc_qr")
	private String Essc_qr;
	
	// 电子社保卡接口返回令牌
	@XmlElement(name = "Essc_token")
	private String Essc_token;

	// 医院编码
	@XmlElement(name = "hospitalCode")
	private String hospitalCode;
	
	// 操作员编码 
	@XmlElement(name = "operaCode")
	private String operaCode;

	// 就诊类型 01门诊 02住院
	@XmlElement(name = "entpCode")
	private String entpCode;

	// 开始时间
	@XmlElement(name = "startDate")
	private String startDate;

	// 结束时间
	@XmlElement(name = "endDate")
	private String endDate;

	// 就诊信息
	@XmlElementWrapper(name = "OEPEntList")
	@XmlElement(name = "entInfo")
	private List<WsResultSingleEntInfo> oepEntList;
	
	// 医保产品编码
	@XmlElement(name = "codeHp")
	private String codeHp;
	
	// 医保信息
	@XmlElement(name = "hpInfo")
	private WsParamHpTransactionOutInfo hpInfo;

	public String getPatCaCode() {
		return patCaCode;
	}

	public void setPatCaCode(String patCaCode) {
		this.patCaCode = patCaCode;
	}

	public String getPeCode() {
		return peCode;
	}

	public void setPeCode(String peCode) {
		this.peCode = peCode;
	}

	public String getOperaCode() {
		return operaCode;
	}

	public void setOperaCode(String operaCode) {
		this.operaCode = operaCode;
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

	public String getEssc_qr() {
		return Essc_qr;
	}

	public void setEssc_qr(String essc_qr) {
		Essc_qr = essc_qr;
	}

	public String getEssc_token() {
		return Essc_token;
	}

	public void setEssc_token(String essc_token) {
		Essc_token = essc_token;
	}

	public List<WsResultSingleEntInfo> getOepEntList() {
		return oepEntList;
	}

	public void setOepEntList(List<WsResultSingleEntInfo> oepEntList) {
		this.oepEntList = oepEntList;
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

	public String getCodeHp() {
		return codeHp;
	}

	public void setCodeHp(String codeHp) {
		this.codeHp = codeHp;
	}

	public WsParamHpTransactionOutInfo getHpInfo() {
		return hpInfo;
	}

	public void setHpInfo(WsParamHpTransactionOutInfo hpInfo) {
		this.hpInfo = hpInfo;
	}
}
