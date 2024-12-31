package iih.en.itf.bean.input.opapt;

import iih.en.itf.bean.input.WsEnParam;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 预约门诊号Ws入参 
 * 
 * @author liubin
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsEnParamMakeApt extends WsEnParam {

	private static final long serialVersionUID = 1L;
	/**
	 * 患者编码
	 */
	@XmlElement(name = "patCode")
	private String patCode;
	/**
	 * 预约码
	 */
	@XmlElement(name = "aptCode")
	private String aptCode;
	/**
	 * 渠道类型
	 */
	@XmlElement(name = "chlType")
	private String chlType;
	/**
	 * 代办人编码
	 */
	@XmlElement(name = "agentPatCode")
	private String agentPatCode;
	/**
	 * 排班id
	 */
	@XmlElement(name = "id_sch")
	private String id_sch;
	/**
	 * 操作员编码
	 */
	@XmlElement(name = "oprCode")
	private String oprCode;
	/**
	 * 申请机构名称
	 */
	@XmlElement(name = "orgName_apply")
	private String orgName_apply;
	/**
	 * 转诊标志
	 */
	@XmlElement(name = "transFlag")
	private String transFlag;
	/**
	 * 号位顺序号
	 */
	@XmlElement(name = "tickNo")
	private String tickNo;
	/**
	 * 号段ID
	 */
	@XmlElement(name = "id_ticks")
	private String id_ticks;
	
	public String getPatCode() {
		return patCode;
	}
	
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	
	public String getAptCode() {
		return aptCode;
	}
	
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
	
	public String getChlType() {
		return chlType;
	}
	
	public void setChlType(String chlType) {
		this.chlType = chlType;
	}
	
	public String getAgentPatCode() {
		return agentPatCode;
	}
	
	public void setAgentPatCode(String agentPatCode) {
		this.agentPatCode = agentPatCode;
	}
	
	public String getId_sch() {
		return id_sch;
	}
	
	public void setId_sch(String id_sch) {
		this.id_sch = id_sch;
	}
	
	public String getOprCode() {
		return oprCode;
	}
	
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}
	
	public String getOrgName_apply() {
		return orgName_apply;
	}
	
	public void setOrgName_apply(String orgName_apply) {
		this.orgName_apply = orgName_apply;
	}
	
	public String getTransFlag() {
		return transFlag;
	}
	
	public void setTransFlag(String transFlag) {
		this.transFlag = transFlag;
	}
	
	public String getTickNo() {
		return tickNo;
	}
	
	public void setTickNo(String tickNo) {
		this.tickNo = tickNo;
	}

	public String getId_ticks() {
		return id_ticks;
	}

	public void setId_ticks(String id_ticks) {
		this.id_ticks = id_ticks;
	}
	
	
}
