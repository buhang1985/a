package iih.en.pv.appoint.result;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/***
 * 患者挂号记录列表-出参解析
 * @author zhangpp
 *
 */
@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatOpEntListResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 预约ID
	 */
	private String id_apt;
	/**
	 * 就诊ID
	 */
	private String id_ent;
	/**
	 * 患者姓名
	 */
	private String patName;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 就诊类型
	 */
	private String entpCode;
	/**
	 * 患者类型
	 */
	private String patCa;
	/**
	 * 科室编码
	 */
	private String deptCode;
	/**
	 * 科室名称
	 */
	private String deptName;
	/**
	 * 号别
	 */
	private String srvCode;
	/**
	 * 号别名称
	 */
	private String srvName;
	/**
	 * 医生编码
	 */
	private String resCode;
	/**
	 * 医生名称
	 */
	private String resName;
	/**
	 * 挂号日期
	 */
	private String entTime;
	/**
	 * 操作日期
	 */
	private String oprTime;
	/**
	 * 午别
	 */
	private String dayslottp;
	/**
	 * 上下午
	 */
	private String ampm;
	/**
	 * 挂号顺序号
	 */
	private String seqNo;
	/**
	 * 支付订单号
	 */
	private String paymodeno;
	/**
	 * 支付账户
	 */
	private String bankno;
	/**
	 * 支付方式
	 */
	private String pmCode;
	/**
	 * 预约号
	 */
	private String aptno;
	/**
	 * 费用状态
	 */
	private String feeStatus;
	/**
	 * 预约状态
	 */
	private String status;
	/**
	 * 患者支付金额
	 */
	private Double amtPat;
	/**
	 * 预约编码
	 */
	private String aptCode;
	/**
	 * 就诊分诊地址
	 */
	private String address;
	/**
	 * 总费用
	 */
	private Double amt;
	/**
	 * 门诊就诊次数
	 */
	private Integer timesOp;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 预约渠道
	 */
	private String aptChl;
	/**
	 * 号位开始时间
	 */
	private String t_b_tick;
	/**
	 * 号位结束时间
	 */
	private String t_e_tick;
	
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
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
	public String getEntpCode() {
		return entpCode;
	}
	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
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
	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public String getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}
	public String getPaymodeno() {
		return paymodeno;
	}
	public void setPaymodeno(String paymodeno) {
		this.paymodeno = paymodeno;
	}
	public String getBankno() {
		return bankno;
	}
	public void setBankno(String bankno) {
		this.bankno = bankno;
	}
	public String getPmCode() {
		return pmCode;
	}
	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}
	public String getAptno() {
		return aptno;
	}
	public void setAptno(String aptno) {
		this.aptno = aptno;
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
	public Double getAmtPat() {
		return amtPat;
	}
	public void setAmtPat(Double amtPat) {
		this.amtPat = amtPat;
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
	public Double getAmt() {
		return amt;
	}
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	public Integer getTimesOp() {
		return timesOp;
	}
	public void setTimesOp(Integer timesOp) {
		this.timesOp = timesOp;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAptChl() {
		return aptChl;
	}
	public void setAptChl(String aptChl) {
		this.aptChl = aptChl;
	}
	public String getT_b_tick() {
		return t_b_tick;
	}
	public void setT_b_tick(String t_b_tick) {
		this.t_b_tick = t_b_tick;
	}
	public String getT_e_tick() {
		return t_e_tick;
	}
	public void setT_e_tick(String t_e_tick) {
		this.t_e_tick = t_e_tick;
	}
	
}