package iih.en.pv.outpatient.dto.d;

/**
 * 爽约记录
 * 
 * @author yank
 *
 */
public class BrokenAptDTO {
	// 预约ID
	private String id_apt;
	/**
	 * EMPI
	 */
	private String empi;
	/**
	 * 患者CODE
	 */
	private String patient_id;
	/**
	 * 患者姓名
	 */
	private String name_pat;
	/**
	 * 患者CODE
	 */
	private String patCode;
	/**
	 * 患者姓名
	 */
	private String patName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 服务编码
	 */
	private String scsrv_code;
	/**
	 * 服务名称（号别）
	 */
	private String scsrv_name;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 就诊日期
	 */
	private String dt_entry;
	/**
	 * 不良行为编码
	 */
	private String sd_bbrtp; // add by zhengcm 2018-04-17
	/**
	 * 就诊
	 */
	private String id_ent; // add by zhengcm 2018-04-17

	/**
	 * 获取EMPI
	 * 
	 * @return
	 */
	public String getEmpi() {
		return empi;
	}

	/**
	 * 设置EMPI
	 * 
	 * @param empi
	 */
	public void setEmpi(String empi) {
		this.empi = empi;
	}

	/**
	 * 获取患者姓名
	 * 
	 * @return
	 */
	public String getName_pat() {
		return name_pat;
	}

	/**
	 * 设置患者姓名
	 * 
	 * @param name_pat
	 */
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	/**
	 * 获取性别
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 设置性别
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 服务编码
	 * 
	 * @return
	 */
	public String getScsrv_code() {
		return scsrv_code;
	}

	/**
	 * 设置服务编码
	 * 
	 * @param scsrv_code
	 */
	public void setScsrv_code(String scsrv_code) {
		this.scsrv_code = scsrv_code;
	}

	/**
	 * 获取手机号码
	 * 
	 * @return
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置手机号码
	 * 
	 * @param mobile
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取患者ID
	 * 
	 * @return
	 */
	public String getPatient_id() {
		return patient_id;
	}

	/**
	 * 设置患者ID
	 * 
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * 获取服务名称（号别）
	 * 
	 * @return
	 */
	public String getScsrv_name() {
		return scsrv_name;
	}

	/**
	 * 设置服务名称（号别）
	 * 
	 * @param scsrv_name
	 */
	public void setScsrv_name(String scsrv_name) {
		this.scsrv_name = scsrv_name;
	}

	public String getId_apt() {
		return id_apt;
	}

	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}

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

	/**
	 * 就诊日期
	 * 
	 * @author fanlq
	 * @return
	 */
	public String getDt_entry() {
		return dt_entry;
	}

	/***
	 * 就诊日期
	 * 
	 * @author fanlq
	 * @param dt_entry
	 */
	public void setDt_entry(String dt_entry) {
		this.dt_entry = dt_entry;
	}

	public String getSd_bbrtp() {
		return sd_bbrtp;
	}

	public void setSd_bbrtp(String sd_bbrtp) {
		this.sd_bbrtp = sd_bbrtp;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

}
