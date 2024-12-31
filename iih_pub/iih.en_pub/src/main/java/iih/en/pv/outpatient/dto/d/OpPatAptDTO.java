package iih.en.pv.outpatient.dto.d;

/**
 * 门诊预约信息
 * @author yank
 *
 */
public class OpPatAptDTO {
	//预约ID
	private String id_apt;
	//就诊ID
	private String id_ent;
	//cgID
	private String id_cg;
	//患者编码
	private String patCode;
	//患者姓名
	private String patName;
	//患者类型
	private String patCa;
	//科室编码
	private String deptCode;
	//科室名称
	private String deptName;
	//服务编码
	private String srvCode;
	//服务ID
	private String srvId;
	//服务名称
	private String srvName;
	//医生编码
	private String doctorCode;
	//医生姓名
	private String doctorName;
	//资源编码
	private String resCode;
	//资源名称
	private String resName;
	//票号
	private Integer ticketNo;
	//就诊时间
	private String entTime;
	//操作时间
	private String oprTime;
	//午别类型
	private String dayslottp;
	//午别类型（上午下午）
	private String dayslotType;
	//午别名称
	private String dayslotName;
	//午别类型（am/pm）
	private String ampm;
	//挂号顺序号
	private String seqNo;
	//支付订单号
	private String paymodeno;
	//支付账户
	private String bankno;
	//支付方式
	private String pmCode;
	//预约号
	private String aptno;
	//费用状态
	private String feeStatus;
	//状态
	private String status;

	//费用总额
	private Float amtRatio;
	//预约编码
	private String aptCode;
	//就诊分诊地址
	private String address;
	//门诊就诊次数
	private Integer times; 
	//门诊就诊次数
	private Integer timesOp;
	//联系方式
	private String mobile;
	
	//就诊类型编码
	private String entpCode;
	//就诊类型名称
	private String entpName;
	//患者类别名称
	private String patCaName;
	//性别
	private String sex;
	//出生日期
	private String birthday;
	//年龄
	private String age;
	//医院编码
	private String hospitalCode;
	//医院名称
	private String hospitalName;
	//开始时间
	private String dt_b;
	//结束时间
	private String dt_e;
	//建议就诊时间
	private String sugest_time;
	//医保名称
	private String hpName;
	//就诊地址
	private String entAddr;
	//实际支付金额
	private Float amt;
	//患者自付金额
	private Float amtPat;
	//预交金余额
	private Double balance;
	//预约人员
	private String aptOpr;
	//加号标志
	private String addFg;
	//预约渠道
	private String aptChl;
	//服务类型
	private String sd_srvTp;
	//预约 排班类型
	private String sd_sctp;
	
	//渠道类型名称
	private String chlTypeName;
	
	private Boolean fg_payment;
	//结算id
	private String id_stoep;
	//结算流水号
	private String code_st;
	//结算时间
	private String dt_st;
	//号位开始时间
	private String t_b_tick;
	//号位结束时间
	private String t_e_tick;
	
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getPatCa() {
		return patCa;
	}
	public void setPatCa(String patca) {
		this.patCa = patca;
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
	public String getDoctorCode() {
		return doctorCode;
	}
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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
	 * @return the tickNo
	 */
	public Integer getTicketNo() {
		return ticketNo;
	}
	/**
	 * @param tickNo the tickNo to set
	 */
	public void setTicketNo(Integer tickNo) {
		this.ticketNo = tickNo;
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
	public String getDayslotType() {
		return dayslotType;
	}
	public void setDayslotType(String dayslotType) {
		this.dayslotType = dayslotType;
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
	public Float getAmt() {
		return amt;
	}
	public void setAmt(Float amt) {
		this.amt = amt;
	}
	public Float getAmtRatio() {
		return amtRatio;
	}
	public void setAmtRatio(Float amtRatio) {
		this.amtRatio = amtRatio;
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
	public Integer getTimes() {
		return times;
	}
	public void setTimes(Integer times) {
		this.times = times;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEntpCode() {
		return entpCode;
	}
	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}
	public String getEntpName() {
		return entpName;
	}
	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}
	public String getPatCaName() {
		return patCaName;
	}
	public void setPatCaName(String patCaName) {
		this.patCaName = patCaName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getSrvId() {
		return srvId;
	}
	public void setSrvId(String srvId) {
		this.srvId = srvId;
	}
	public String getDt_b() {
		return dt_b;
	}
	public void setDt_b(String dt_b) {
		this.dt_b = dt_b;
	}
	public String getDt_e() {
		return dt_e;
	}
	public void setDt_e(String dt_e) {
		this.dt_e = dt_e;
	}
	public String getSugest_time() {
		return sugest_time;
	}
	public void setSugest_time(String sugest_time) {
		this.sugest_time = sugest_time;
	}
	public String getHpName() {
		return hpName;
	}
	public void setHpName(String hpName) {
		this.hpName = hpName;
	}
	public String getEntAddr() {
		return entAddr;
	}
	public void setEntAddr(String entAddr) {
		this.entAddr = entAddr;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAptOpr() {
		return aptOpr;
	}
	public void setAptOpr(String aptOpr) {
		this.aptOpr = aptOpr;
	}
	public String getAddFg() {
		return addFg;
	}
	public void setAddFg(String addFg) {
		this.addFg = addFg;
	}
	public String getAptChl() {
		return aptChl;
	}
	public void setAptChl(String aptChl) {
		this.aptChl = aptChl;
	}
	public String getId_apt() {
		return id_apt;
	}
	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}
	public Integer getTimesOp() {
		return timesOp;
	}
	public void setTimesOp(Integer timesOp) {
		this.timesOp = timesOp;
	}
	public Float getAmtPat() {
		return amtPat;
	}
	public void setAmtPat(Float amtPat) {
		this.amtPat = amtPat;
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
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	/**
	 * @return the dayslotName
	 */
	public String getDayslotName() {
		return dayslotName;
	}
	/**
	 * @param dayslotName the dayslotName to set
	 */
	public void setDayslotName(String dayslotName) {
		this.dayslotName = dayslotName;
	}
	/**
	 * @return the id_cg
	 */
	public String getId_cg() {
		return id_cg;
	}
	/**
	 * @param id_cg the id_cg to set
	 */
	public void setId_cg(String id_cg) {
		this.id_cg = id_cg;
	}
	/**
	 * @return the sd_srvTp
	 */
	public String getSd_srvTp() {
		return sd_srvTp;
	}
	/**
	 * @param sd_srvTp the sd_srvTp to set
	 */
	public void setSd_srvTp(String sd_srvTp) {
		this.sd_srvTp = sd_srvTp;
	}
	/**
	 * @return the sd_sctp
	 */
	public String getSd_sctp() {
		return sd_sctp;
	}
	/**
	 * @param sd_sctp the sd_sctp to set
	 */
	public void setSd_sctp(String sd_sctp) {
		this.sd_sctp = sd_sctp;
	}
	public String getChlTypeName() {
		return chlTypeName;
	}
	public void setChlTypeName(String chlTypeName) {
		this.chlTypeName = chlTypeName;
	}
	public Boolean getFg_payment() {
		return fg_payment;
	}
	public void setFg_payment(Boolean fg_payment) {
		this.fg_payment = fg_payment;
	}
	public String getId_stoep() {
		return id_stoep;
	}
	public void setId_stoep(String id_stoep) {
		this.id_stoep = id_stoep;
	}
	public String getCode_st() {
		return code_st;
	}
	public void setCode_st(String code_st) {
		this.code_st = code_st;
	}
	public String getDt_st() {
		return dt_st;
	}
	public void setDt_st(String dt_st) {
		this.dt_st = dt_st;
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
