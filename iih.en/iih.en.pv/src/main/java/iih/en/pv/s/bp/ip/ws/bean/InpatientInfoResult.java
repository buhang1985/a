package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/***
 * 查询患者能够(打印病案信息)的历次住院基本信息-出参解析
 * @author zhangpp
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InpatientInfoResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 住院患者唯一ID
	 */
	private String patientId;
	/**
	 * 院区Id
	 */
	private String hospitalId;
	/**
	 * 院区名称
	 */
	private String hospitalName;
	/**
	 * 科室Id
	 */
	private String deptId;
	/**
	 * 科室名称
	 */
	private String deptName;
	/**
	 * 姓名
	 */
	private String patientName;
	/**
	 * 入院日期
	 */
	private String inTime;
	/**
	 * 出院日期
	 */
	private String outTime;
	/**
	 * 住院号
	 */
	private String inpatientId;
	/**
	 * 身份证号码
	 */
	private String idCardNo;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否允许复印 0：否，1：是
	 */
	private String isReadyCopy;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getInpatientId() {
		return inpatientId;
	}
	public void setInpatientId(String inpatientId) {
		this.inpatientId = inpatientId;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIsReadyCopy() {
		return isReadyCopy;
	}
	public void setIsReadyCopy(String isReadyCopy) {
		this.isReadyCopy = isReadyCopy;
	}
	
	
}
