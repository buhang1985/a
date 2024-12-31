package iih.en.pv.appoint.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 患者候诊列表-入参解析
 * 
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class WaitQueParam extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 就诊次数
	 */
	private Integer opTimes;
	/**
	 * 科室编码
	 */
	private String deptCode;
	/**
	 * 站点编码
	 */
	private String siteCode;
	/**
	 * 操作员
	 */
	private String oprCode;
	
	/**
	 * 是否获取队列所有数据
	 */
	private String isGetAllData;
	
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
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getSiteCode() {
		return siteCode;
	}
	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}
	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}
	public String getIsGetAllData() {
		return isGetAllData;
	}
	public void setIsGetAllData(String isGetAllData) {
		this.isGetAllData = isGetAllData;
	}

}
