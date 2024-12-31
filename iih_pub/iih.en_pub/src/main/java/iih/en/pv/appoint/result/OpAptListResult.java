package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 患者预约明细-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpAptListResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 预约记录ID
	 */
	private String id_apt;
	/**
	 * 病人姓名
	 */
	private String patName;
	/**
	 * 病人ID
	 */
	private String patCode;
	/**
	 * 科室编码
	 */
	private String deptCode;
	/**
	 * 科室名称
	 */
	private String deptName;
	/**
	 * 预约码
	 */
	private String aptCode;
	/**
	 * 就诊时间
	 */
	private String entTime;
	/**
	 * 操作时间
	 */
	private String oprTime;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 午别
	 */
	private String dayslottp;
	/**
	 * 上下午
	 */
	private String ampm;
	/**
	 * 预计候诊时间
	 */
	private String expectedWaitTime;
	/**
	 * 排班资源编码
	 */
	private String resName;
	/**
	 * 排班资源名称
	 */
	private String resCode;
	/**
	 * 就诊顺序号
	 */
	private String ticketno;
	/**
	 * 号别编码
	 */
	private String srvCode;
	/**
	 * 号别名称
	 */
	private String srvName;
	/**
	 * 号别类型
	 */
	private String srvType;
	/**
	 * 号别类型名称
	 */
	private String srvTpName;
	/**
	 * 渠道类型
	 */
	private String chlType;
	/**
	 * 渠道类型名称
	 */
	private String chlTypeName;
	/**
	 * 挂号状态
	 */
	private String status;
	/**
	 * 付费标准
	 */
	private String fgPayment;
	/**
	 * 挂号状态编码
	 */
	private String statusCode;
	/**
	 * 外部预约码
	 */
	private String exCodeApt;
	
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getAptCode() {
		return aptCode;
	}
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
	public String getEntTime() {
		return entTime;
	}
	public void setEntTime(String entTime) {
		this.entTime = entTime;
	}
	public String getOprTime() {
		return oprTime;
	}
	public void setOprTime(String oprTime) {
		this.oprTime = oprTime;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDayslottp() {
		return dayslottp;
	}
	public void setDayslottp(String dayslottp) {
		this.dayslottp = dayslottp;
	}
	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public String getExpectedWaitTime() {
		return expectedWaitTime;
	}
	public void setExpectedWaitTime(String expectedWaitTime) {
		this.expectedWaitTime = expectedWaitTime;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getTicketno() {
		return ticketno;
	}
	public void setTicketno(String ticketno) {
		this.ticketno = ticketno;
	}
	public String getSrvCode() {
		return srvCode;
	}
	public void setSrvCode(String srvCode) {
		this.srvCode = srvCode;
	}
	public String getSrvName() {
		return srvName;
	}
	public void setSrvName(String srvName) {
		this.srvName = srvName;
	}
	public String getSrvType() {
		return srvType;
	}
	public void setSrvType(String srvType) {
		this.srvType = srvType;
	}
	public String getSrvTpName() {
		return srvTpName;
	}
	public void setSrvTpName(String srvTpName) {
		this.srvTpName = srvTpName;
	}
	public String getChlType() {
		return chlType;
	}
	public void setChlType(String chlType) {
		this.chlType = chlType;
	}
	public String getChlTypeName() {
		return chlTypeName;
	}
	public void setChlTypeName(String chlTypeName) {
		this.chlTypeName = chlTypeName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFgPayment() {
		return fgPayment;
	}
	public void setFgPayment(String fgPayment) {
		this.fgPayment = fgPayment;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getExCodeApt() {
		return exCodeApt;
	}
	public void setExCodeApt(String exCodeApt) {
		this.exCodeApt = exCodeApt;
	}

}
