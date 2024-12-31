package iih.en.pv.appoint.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 获取代办人预约记录-入参解析
 * 
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpAptListByAgentPatCodeParam extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 代办人编码
	 */
	private String agentPatCode;
	/**
	 * 开始日期
	 */
	private String beginDate;
	/**
	 * 结束日期
	 */
	private String endDate;
	
	public String getAgentPatCode() {
		return agentPatCode;
	}
	public void setAgentPatCode(String agentPatCode) {
		this.agentPatCode = agentPatCode;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
