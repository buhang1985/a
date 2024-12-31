package iih.en.pv.appoint.result;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

/***
 * 门诊停诊列表-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpStopSchListResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 门诊排班ID
	 */
	private String id_sch;
	/**
	 * 排班日期
	 */
	private String schDate;
	/**
	 * 科室编码
	 */
	private String deptCode;
	/**
	 * 科室名称
	 */
	private String deptName;
	/**
	 * 医生名称
	 */
	private String resName;
	/**
	 * 医生编码
	 */
	private String resCode;
	/**
	 * 午别
	 */
	private String dayslottp;
	/**
	 * 上下午
	 */
	private String ampm;
	/**
	 * 价格
	 */
	private Float price;
	/**
	 * 剩余号源数
	 */
	private Integer remain;
	/**
	 * 特长
	 */
	private String speciality;
	/**
	 * 开放标志
	 */
	private String isOpen;
	/**
	 * 号别名称
	 */
	private String srvName;
	/**
	 * 号别编码
	 */
	private String srvCode;
	
	public String getId_sch() {
		return id_sch;
	}
	public void setId_sch(String id_sch) {
		this.id_sch = id_sch;
	}
	public String getSchDate() {
		return schDate;
	}
	public void setSchDate(String schDate) {
		this.schDate = schDate;
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
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getRemain() {
		return remain;
	}
	public void setRemain(Integer remain) {
		this.remain = remain;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	public String getSrvName() {
		return srvName;
	}
	public void setSrvName(String srvName) {
		this.srvName = srvName;
	}
	public String getSrvCode() {
		return srvCode;
	}
	public void setSrvCode(String srvCode) {
		this.srvCode = srvCode;
	}

}