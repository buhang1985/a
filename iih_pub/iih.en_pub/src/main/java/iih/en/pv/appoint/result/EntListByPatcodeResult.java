package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 获取患者就诊记录-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntListByPatcodeResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 门诊就诊次数
	 */
	private Integer opTimes;
	/**
	 * 住院就诊次数
	 */
	private Integer ipTimes;
	/**
	 * 接诊时间
	 */
	private String dtAcpt;
	/**
	 * 就诊ID
	 */
	private String entId;
	/**
	 * 就诊类型
	 */
	private String entpCode;
	/**
	 * 患者姓名
	 */
	private String patName;
	/**
	 * 就诊科室
	 */
	private String phyDepId;
	/**
	 * 就诊科室编码
	 */
	private String phyDepCode;
	/**
	 * 状态
	 */
	private String statusCode;
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public Integer getOpTimes() {
		return opTimes;
	}
	public void setOpTimes(Integer opTimes) {
		this.opTimes = opTimes;
	}
	public Integer getIpTimes() {
		return ipTimes;
	}
	public void setIpTimes(Integer ipTimes) {
		this.ipTimes = ipTimes;
	}
	public String getDtAcpt() {
		return dtAcpt;
	}
	public void setDtAcpt(String dtAcpt) {
		this.dtAcpt = dtAcpt;
	}
	public String getEntId() {
		return entId;
	}
	public void setEntId(String entId) {
		this.entId = entId;
	}
	public String getEntpCode() {
		return entpCode;
	}
	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getPhyDepId() {
		return phyDepId;
	}
	public void setPhyDepId(String phyDepId) {
		this.phyDepId = phyDepId;
	}
	public String getPhyDepCode() {
		return phyDepCode;
	}
	public void setPhyDepCode(String phyDepCode) {
		this.phyDepCode = phyDepCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
