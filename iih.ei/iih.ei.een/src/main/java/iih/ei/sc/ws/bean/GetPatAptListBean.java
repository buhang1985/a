package iih.ei.sc.ws.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsParam;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetPatAptListBean extends BaseWsParam implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 预约ID
	 */
	private String  idApt;
	/**
	 * 患者姓名
	 */
	private String  patName;
	/**
	 * 患者编码
	 */
	private String  patCode;
	/**
	 * 就诊类型
	 */
	private String  enTpCode;
	/**
	 * 患者类型
	 */
	private String  patCa;
	/**
	 * 科室编码
	 */
	private String  deptCode;
	/**
	 * 科室名称
	 */
	private String  deptName;
	/**
	 * 服务编码
	 */
	private String  srvCode;
	/**
	 * 服务名称
	 */
	private String  srvName;
	/**
	 * 资源编码
	 */
	private String  resCode;
	/**
	 * 资源名称
	 */
	private String  resName;
	/**
	 * 检查日期
	 */
	private String  entTime;
	/**
	 * 操作日期
	 */
	private String  oprTime;
	/**
	 * 午别
	 */
	private String  dayslottp;
	/**
	 * 顺序号
	 */
	private String  seqNo;
	/**
	 * 费用状态
	 */
	private String  feeStatus;
	/**
	 * 预约状态
	 */
	private String  status;
	/**
	 * 预约编号
	 */
	private String  aptCode;
	/**
	 * 检查地址
	 */
	private String  address;
	/**
	 * 电话
	 */
	private String  mobile;
	/**
	 * 预约渠道名
	 */
	private String  chlTypeName;
	/**
	 * 预约渠道编码
	 */
	private String  chlTypeCaode;
	/**
	 * 预约申请单id
	 */
	private String idAptappl;
	/**
	 * 预约号位结束时间
	 */
	private String endTime;
	/**
	 * 申请单开单时间
	 */
	private String dtEffeOr;
	/**
	 * 申请单号
	 */
	private String applyNo;
	/**
	 * 申请单名称
	 */
	private String applName;
	/**
	 * 预约号位开始时间
	 */
	private String beginTime;
	/**
	 * 服务部位
	 */
	private String applSrvName;

	public String getIdApt() {
		return idApt;
	}
	public void setIdApt(String idApt) {
		this.idApt = idApt;
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
	public String getEnTpCode() {
		return enTpCode;
	}
	public void setEnTpCode(String enTpCode) {
		this.enTpCode = enTpCode;
	}
	public String getPatCa() {
		return patCa;
	}
	public void setPatCa(String patCa) {
		this.patCa = patCa;
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
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
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
	public String getDayslottp() {
		return dayslottp;
	}
	public void setDayslottp(String dayslottp) {
		this.dayslottp = dayslottp;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getFeeStatus() {
		return feeStatus;
	}
	public void setFeeStatus(String feeStatus) {
		this.feeStatus = feeStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAptCode() {
		return aptCode;
	}
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getChlTypeName() {
		return chlTypeName;
	}
	public void setChlTypeName(String chlTypeName) {
		this.chlTypeName = chlTypeName;
	}
	public String getChlTypeCaode() {
		return chlTypeCaode;
	}
	public void setChlTypeCaode(String chlTypeCaode) {
		this.chlTypeCaode = chlTypeCaode;
	}
	public String getIdAptappl() {
		return idAptappl;
	}
	public void setIdAptappl(String idAptappl) {
		this.idAptappl = idAptappl;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getDtEffeOr() {
		return dtEffeOr;
	}
	public void setDtEffeOr(String dtEffeOr) {
		this.dtEffeOr = dtEffeOr;
	}
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	public String getApplName() {
		return applName;
	}
	public void setApplName(String applName) {
		this.applName = applName;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getApplSrvName() {
		return applSrvName;
	}
	public void setApplSrvName(String applSrvName) {
		this.applSrvName = applSrvName;
	}
}
