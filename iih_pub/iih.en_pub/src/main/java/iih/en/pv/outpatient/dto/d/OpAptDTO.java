package iih.en.pv.outpatient.dto.d;

/**
 * 门诊预约信息
 * @author yank
 *
 */
public class OpAptDTO {
	/***
	 * 状态编码
	 */
	private String statusCode;
	//预约ID
	private String id_apt;
	//患者编码
	private String patCode;
	//患者姓名
	private String patName;
	//手机号码
	private String mobile;
	//科室编码
	private String deptCode;
	//科室名称
	private String deptName;
	//预约编码
	private String aptCode;
	//就诊时间
	private String entTime;
	//操作时间
	private String oprTime;
	//午别类型
	private String dayslottp;
	//午别类型（上午下午）
	private String dayslotType;
	//午别类型（上午下午）
	private String ampm;
	//预计候诊时间
	private String expectedWaitTime;
	//就诊顺序号
	private String ticketno;
	//票号
	private String queNo;
	//医生编码
	private String doctorCode;
	//医生姓名
	private String doctorName;
	//资源编码
	private String resCode;
	//资源名称
	private String resName;
	//服务编码
	private String srvCode;
	//服务名称
	private String srvName;
	//号别类型编码
	private String srvType;
	//号别类型名称
	private String srvTpName;
	//渠道类型
	private String chlType;
	//渠道类型名称
	private String chlTypeName;
	//状态
	private String status;
	//支付标识
	private String fgPayment;
	/***
	 * 外部预约码
	 */
	private String ex_code_apt;
	/**
	 * 获取患者编码
	 * @return
	 */
	public String getPatCode() {
		return patCode;
	}
	/**
	 * 设置患者编码
	 * @param patCode
	 */
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	/**
	 * 获取患者姓名
	 * @return
	 */
	public String getPatName() {
		return patName;
	}
	/**
	 * 设置患者姓名
	 * @param patName
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}
	/**
	 * 获取手机号码
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置手机号码
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取科室编码
	 * @return
	 */
	public String getDeptCode() {
		return deptCode;
	}
	/**
	 * 设置科室编码
	 * @param deptCode
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	/**
	 * 获取科室名称
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}
	/**
	 * 设置科室名称
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 获取预约号
	 * @return
	 */
	public String getAptCode() {
		return aptCode;
	}
	/**
	 * 设置预约号
	 * @param aptCode
	 */
	public void setAptCode(String aptCode) {
		this.aptCode = aptCode;
	}
	/**
	 * 获取就诊时间
	 * @return
	 */
	public String getEntTime() {
		return entTime;
	}
	/**
	 * 设置就诊时间
	 * @param entTime
	 */
	public void setEntTime(String entTime) {
		this.entTime = entTime;
	}
	/**
	 * 获取操作时间
	 * @return
	 */
	public String getOprTime() {
		return oprTime;
	}
	/**
	 * 设置操作时间
	 * @param oprTime
	 */
	public void setOprTime(String oprTime) {
		this.oprTime = oprTime;
	}
	/**
	 * 获取午别类型（上午/下午）
	 * @return
	 */
	public String getDayslotType() {
		return dayslotType;
	}
	/**
	 * 设置午别类型（上午/下午）
	 * @param dayslotType
	 */
	public void setDayslotType(String dayslotType) {
		this.dayslotType = dayslotType;
	}
	/**
	 * 获取预计候诊时间
	 * @return
	 */
	public String getExpectedWaitTime() {
		return expectedWaitTime;
	}
	/**
	 * 设置预计候诊时间
	 * @param expectedWaitTime
	 */
	public void setExpectedWaitTime(String expectedWaitTime) {
		this.expectedWaitTime = expectedWaitTime;
	}
	/**
	 * 获取顺序号
	 * @return
	 */
	public String getQueNo() {
		return queNo;
	}
	/**
	 * 设置顺序号
	 * @param queNo
	 */
	public void setQueNo(String queNo) {
		this.queNo = queNo;
	}
	/**
	 * 获取医生姓名
	 * @return
	 */
	public String getDoctorName() {
		return doctorName;
	}
	/**
	 * 设置医生姓名
	 * @param docName
	 */
	public void setDoctorName(String docName) {
		this.doctorName = docName;
	}
	/**
	 * 医生编码
	 * @return
	 */
	public String getDoctorCode() {
		return doctorCode;
	}
	/**
	 * 医生编码
	 * @param doctorCode
	 */
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	/**
	 * @return the resCode
	 */
	public String getResCode() {
		return resCode;
	}
	/**
	 * @param resCode the resCode to set
	 */
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	/**
	 * @return the resName
	 */
	public String getResName() {
		return resName;
	}
	/**
	 * @param resName the resName to set
	 */
	public void setResName(String resName) {
		this.resName = resName;
	}
	/**
	 * 获取号别编码
	 * @return
	 */
	public String getSrvCode() {
		return srvCode;
	}
	/**
	 * 设置号别编码
	 * @param srvCode
	 */
	public void setSrvCode(String srvCode) {
		this.srvCode = srvCode;
	}
	/**
	 * 获取号别名称
	 * @return
	 */
	public String getSrvName() {
		return srvName;
	}
	/**
	 * 设置号别名称
	 * @param srvName
	 */
	public void setSrvName(String srvName) {
		this.srvName = srvName;
	}
	/**
	 * 获取渠道类型
	 * @return
	 */
	public String getChlType() {
		return chlType;
	}
	/**
	 * 设置渠道类型
	 * @param chlType
	 */
	public void setChlType(String chlType) {
		this.chlType = chlType;
	}
	/**
	 * 渠道类型名称
	 * @return
	 */
	public String getChlTypeName() {
		return chlTypeName;
	}
	/**
	 * 渠道类型名称
	 * @param chlTypeName
	 */
	public void setChlTypeName(String chlTypeName) {
		this.chlTypeName = chlTypeName;
	}
	/**
	 * 获取就诊状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置就诊状态
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	public String getTicketno() {
		return ticketno;
	}
	public void setTicketno(String ticketno) {
		this.ticketno = ticketno;
	}
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
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
	/**
	 * @return the fgPayment
	 */
	public String getFgPayment() {
		return fgPayment;
	}
	/**
	 * @param fgPayment the fgPayment to set
	 */
	public void setFgPayment(String fgPayment) {
		this.fgPayment = fgPayment;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/***
	 * 外部预约码
	 * @return
	 */
	public String getEx_code_apt() {
		return ex_code_apt;
	}
	/***
	 * 外部预约码
	 * @param ex_code_apt
	 */
	public void setEx_code_apt(String ex_code_apt) {
		this.ex_code_apt = ex_code_apt;
	}	
}
