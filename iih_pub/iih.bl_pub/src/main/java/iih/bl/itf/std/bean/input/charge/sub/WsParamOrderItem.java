package iih.bl.itf.std.bean.input.charge.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;

/**
 * 门诊补退费新入参明细
 * @author shaokx
 * 2019.10.24
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamOrderItem extends  WsParamInfoWithCustom {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者ID号
	 */
	@XmlElement(name = "patCode")
	private String patCode;
	
	/**
	 * 体检流水号
	 */
	@XmlElement(name = "peCode")
	private String peCode;
	
	/**
	 * 门诊就诊次数
	 */
	@XmlElement(name = "timesOP")
	private String timesOP;
	
	/**
	 * 医嘱编码
	 */
	@XmlElement(name = "codeApply")
	private String codeApply;
	
	/**
	 * 开立人员编码
	 */
	@XmlElement(name = "operaOR")
	private String operaOR;
	
	/**
	 * 记账人编码
	 */
	@XmlElement(name = "operaCG")
	private String operaCG;
	
	/**
	 * 执行人编码
	 */
	@XmlElement(name = "operaMP")
	private String operaMP;
	
	/**
	 * 执行时间
	 */
	@XmlElement(name = "operaTime")
	private String  operaTime;
	
	/**
	 * 执行人科室编码
	 */
	@XmlElement(name = "mpDepCode")
	private String mpDepCode;
	
	/**
	 * 开立科室
	 */
	@XmlElement(name = "orDepCode")
	private String orDepCode;
	
	/**
	 * 计费方向
	 */
	@XmlElement(name = "directFlag")
	private String directFlag;
	
	/**
	 * 补费方式
	 */
	@XmlElement(name = "additmFlag")
	private String additmFlag;
	
	/**
	 * 备注
	 */
	@XmlElement(name = "sourceDesc")
	private String sourceDesc;
	
	/**
	 * 记账明细
	 */
	@XmlElementWrapper(name = "chargeItems")
	@XmlElement(name = "chargeItem")
	private List<WsParamCgItm> chargeItem;

	public String getTimesOP() {
		return timesOP;
	}

	public void setTimesOP(String timesOP) {
		this.timesOP = timesOP;
	}

	public String getOrDepCode() {
		return orDepCode;
	}

	public void setOrDepCode(String orDepCode) {
		this.orDepCode = orDepCode;
	}

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

	public String getCodeApply() {
		return codeApply;
	}

	public void setCodeApply(String codeApply) {
		this.codeApply = codeApply;
	}

	public String getOperaOR() {
		return operaOR;
	}

	public void setOperaOR(String operaOR) {
		this.operaOR = operaOR;
	}

	public String getOperaCG() {
		return operaCG;
	}

	public void setOperaCG(String operaCG) {
		this.operaCG = operaCG;
	}

	public String getOperaMP() {
		return operaMP;
	}

	public void setOperaMP(String operaMP) {
		this.operaMP = operaMP;
	}

	public String getOperaTime() {
		return operaTime;
	}

	public void setOperaTime(String operaTime) {
		this.operaTime = operaTime;
	}

	public String getMpDepCode() {
		return mpDepCode;
	}

	public void setMpDepCode(String mpDepCode) {
		this.mpDepCode = mpDepCode;
	}

	public String getDirectFlag() {
		return directFlag;
	}

	public void setDirectFlag(String directFlag) {
		this.directFlag = directFlag;
	}

	public String getAdditmFlag() {
		return additmFlag;
	}

	public void setAdditmFlag(String additmFlag) {
		this.additmFlag = additmFlag;
	}

	public String getSourceDesc() {
		return sourceDesc;
	}

	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}

	public List<WsParamCgItm> getChargeItem() {
		return chargeItem;
	}

	public void setChargeItem(List<WsParamCgItm> chargeItem) {
		this.chargeItem = chargeItem;
	}

	
}
