package iih.en.pv.outpatient.dto.d;

/**
 * 排班信息
 * 
 * @author yank
 *
 */
public class SchInfoDTO {
	// 排班ID
	private String id_sch;
	// 排班日期
	private String schDate;
	// 科室编码
	private String deptCode;
	// 科室名称
	private String deptName;
	// 医生姓名
	private String doctorName;
	// 医生编码
	private String doctorCode;
	// 职称
	private String doctorTitle;
	// 资源编码
	private String resCode;
	// 资源名称
	private String resName;
	//资源类别编码
	private String sd_scresTp;
	// 特长
	private String speciality;
	// 午别类型
	private String dayslottp;
	// 午别类型
	private String ampm;
	// 午别类型
	private String dayslotType;
	// 午别名称
	private String dayslotName;
	// 号别类型
	private String srvType;
	// 号别名称
	private String srvName;
	// 号别编码
	private String srvCode;
	// 号别ID
	private String srvId;
	// 价格
	private Float price;
	// 总号源数
	private Integer total;
	// 已使用数
	private Integer used;
	// 剩余号源
	private Integer remain;
	// 是否开放
	private Boolean isOpen;
	// 号源池
	private Integer scpolcn;
	//票号模式 01-号位，02-号段
	private String ticktp;
	/**
	 * 获取排班日期
	 * 
	 * @return
	 */
	public String getSchDate() {
		return schDate;
	}

	public void setSchDate(String schDate) {
		this.schDate = schDate;
	}

	/**
	 * 获取科室编码
	 * 
	 * @return 科室编码
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * 设置科室编码
	 * 
	 * @param deptCode 科室编码
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 获取deptName
	 * 
	 * @return deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 设置deptName
	 * 
	 * @param deptName deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 获取doctorName
	 * 
	 * @return doctorName
	 */
	public String getDoctorName() {
		return doctorName;
	}

	/**
	 * 设置doctorName
	 * 
	 * @param doctorName doctorName
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	/**
	 * 获取doctorCode
	 * 
	 * @return doctorCode
	 */
	public String getDoctorCode() {
		return doctorCode;
	}

	/**
	 * 设置doctorCode
	 * 
	 * @param doctorCode doctorCode
	 */
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	/**
	 * 获取职称
	 * 
	 * @return
	 */
	public String getDoctorTitle() {
		return doctorTitle;
	}

	/**
	 * 设置职称
	 * 
	 * @param doctorTitle
	 */
	public void setDoctorTitle(String doctorTitle) {
		this.doctorTitle = doctorTitle;
	}

	/**
	 * 获取speciality
	 * 
	 * @return speciality
	 */
	public String getSpeciality() {
		return speciality;
	}

	/**
	 * 设置特长
	 * 
	 * @param speciality 特长
	 */
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	/**
	 * 获取午别
	 * 
	 * @return 午别
	 */
	public String getDayslotType() {
		return dayslotType;
	}

	/**
	 * 设置午别
	 * 
	 * @param dayslotType 午别
	 */
	public void setDayslotType(String dayslotType) {
		this.dayslotType = dayslotType;
	}

	/**
	 * 获取午别名称
	 * 
	 * @return
	 */
	public String getDayslotName() {
		return dayslotName;
	}

	/**
	 * 设置午别名称
	 * 
	 * @param dayslotName 午别名称
	 */
	public void setDayslotName(String dayslotName) {
		this.dayslotName = dayslotName;
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
	 * 获取号别类型
	 * 
	 * @return
	 */
	public String getSrvType() {
		return srvType;
	}

	/**
	 * 设置号别类型
	 * 
	 * @param srvType
	 */
	public void setSrvType(String srvType) {
		this.srvType = srvType;
	}

	/**
	 * 获取服务名称
	 * 
	 * @return srvName
	 */
	public String getSrvName() {
		return srvName;
	}

	/**
	 * 设置服务名称
	 * 
	 * @param srvName 服务名称
	 */
	public void setSrvName(String srvName) {
		this.srvName = srvName;
	}

	/**
	 * 获取服务编码
	 * 
	 * @return 服务编码
	 */
	public String getSrvCode() {
		return srvCode;
	}

	/**
	 * 设置服务编码
	 * 
	 * @param srvCode 服务编码
	 */
	public void setSrvCode(String srvCode) {
		this.srvCode = srvCode;
	}

	/**
	 * 获取价格
	 * 
	 * @return 价格
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * 设置价格
	 * 
	 * @param price 价格
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * 获取剩余号源
	 * 
	 * @return 剩余号源
	 */
	public Integer getRemain() {
		return this.remain;
	}

	/**
	 * 是否开放
	 * 
	 * @return isOpen
	 */
	public Boolean getIsOpen() {
		return isOpen;
	}

	/**
	 * 设置是否开放
	 * 
	 * @param isOpen
	 *            是否开放
	 */
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * 号别ID
	 * 
	 * @return
	 */
	public String getSrvId() {
		return srvId;
	}

	/**
	 * 号别ID
	 * 
	 * @param srvId
	 */
	public void setSrvId(String srvId) {
		this.srvId = srvId;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getUsed() {
		return used;
	}

	public void setUsed(Integer used) {
		this.used = used;
	}

	public void setRemain(Integer remain) {
		this.remain = remain;
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

	public String getId_sch() {
		return id_sch;
	}

	public void setId_sch(String id_sch) {
		this.id_sch = id_sch;
	}

	public Integer getScpolcn() {
		return scpolcn;
	}

	public void setScpolcn(Integer scpolcn) {
		this.scpolcn = scpolcn;
	}

	public String getTicktp() {
		return ticktp;
	}

	public void setTicktp(String ticktp) {
		this.ticktp = ticktp;
	}

	public String getSd_scresTp() {
		return sd_scresTp;
	}

	public void setSd_scresTp(String sd_scresTp) {
		this.sd_scresTp = sd_scresTp;
	}
}
