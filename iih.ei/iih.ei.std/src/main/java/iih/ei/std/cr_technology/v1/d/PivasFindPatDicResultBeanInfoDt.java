package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 在院病人基本信息JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PivasFindPatDicResultBeanInfoDt implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "PATIENT_NO")
	private String patient_no;
	@XmlElement(name = "PATIENT_ID")
	private String patient_id;
	@XmlElement(name = "VISIT_ID")
	private String visit_id;
	@XmlElement(name = "PATIENTNAME")
	private String patientname;
	@XmlElement(name = "SEX")
	private String sex;
	@XmlElement(name = "BIRTHDAY")
	private String birthday;
	@XmlElement(name = "NATION")
	private String nation;
	@XmlElement(name = "LAST_VISIT_DATE")
	private String last_visit_date;
	@XmlElement(name = "PYM")
	private String pym;
	@XmlElement(name = "IDENTITY")
	private String identity;
	@XmlElement(name = "CHARGE_TYPE")
	private String charge_type;
	@XmlElement(name = "ATTENDING_DOCTOR")
	private String attending_doctor;
	@XmlElement(name = "DEPT_CODE")
	private String dept_code;
	@XmlElement(name = "NIANL")
	private String nianl;
	@XmlElement(name = "IS_CHUY")
	private String is_chuy;
	@XmlElement(name = "DIAGNOSIS")
	private String diagnosis;
	@XmlElement(name = "PATIENT_WEIGHT")
	private String patient_weight;
	@XmlElement(name = "PATIENT_CLASS")
	private String patient_class;

	/**
	 * 住院号
	 * 
	 * @return
	 */
	public String getPatient_no() {
		return patient_no;
	}

	/**
	 * 住院号
	 * 
	 * @param patient_no
	 */
	public void setPatient_no(String patient_no) {
		this.patient_no = patient_no;
	}

	/**
	 * 病人ID
	 * 
	 * @return
	 */
	public String getPatient_id() {
		return patient_id;
	}

	/**
	 * 病人ID
	 * 
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * 病人本次住院标识
	 * 
	 * @return
	 */
	public String getVisit_id() {
		return visit_id;
	}

	/**
	 * 病人本次住院标识
	 * 
	 * @param visit_id
	 */
	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}

	/**
	 * 病人名称
	 * 
	 * @return
	 */
	public String getPatientname() {
		return patientname;
	}

	/**
	 * 病人名称
	 * 
	 * @param patientname
	 */
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	/**
	 * 性别（汉字）
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 性别（汉字）
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 出生日期
	 * 
	 * @return
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * 出生日期
	 * 
	 * @param birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * 民族（汉字）
	 * 
	 * @return
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * 民族（汉字）
	 * 
	 * @param nation
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * 入院日期
	 * 
	 * @return
	 */
	public String getLast_visit_date() {
		return last_visit_date;
	}

	/**
	 * 入院日期
	 * 
	 * @param last_visit_date
	 */
	public void setLast_visit_date(String last_visit_date) {
		this.last_visit_date = last_visit_date;
	}

	/**
	 * 拼音码（简拼）
	 * 
	 * @return
	 */
	public String getPym() {
		return pym;
	}

	/**
	 * 拼音码（简拼）
	 * 
	 * @param pym
	 */
	public void setPym(String pym) {
		this.pym = pym;
	}

	/**
	 * 身份证
	 * 
	 * @return
	 */
	public String getIdentity() {
		return identity;
	}

	/**
	 * 身份证
	 * 
	 * @param identity
	 */
	public void setIdentity(String identity) {
		this.identity = identity;
	}

	/**
	 * 费别
	 * 
	 * @return
	 */
	public String getCharge_type() {
		return charge_type;
	}

	/**
	 * 费别
	 * 
	 * @param charge_type
	 */
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}

	/**
	 * 主治医生
	 * 
	 * @return
	 */
	public String getAttending_doctor() {
		return attending_doctor;
	}

	/**
	 * 主治医生
	 * 
	 * @param attending_doctor
	 */
	public void setAttending_doctor(String attending_doctor) {
		this.attending_doctor = attending_doctor;
	}

	/**
	 * 科室
	 * 
	 * @return
	 */
	public String getDept_code() {
		return dept_code;
	}

	/**
	 * 科室
	 * 
	 * @param dept_code
	 */
	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	/**
	 * 年龄
	 * 
	 * @return
	 */
	public String getNianl() {
		return nianl;
	}

	/**
	 * 年龄
	 * 
	 * @param nianl
	 */
	public void setNianl(String nianl) {
		this.nianl = nianl;
	}

	/**
	 * 病人出院情况
	 * 
	 * @return
	 */
	public String getIs_chuy() {
		return is_chuy;
	}

	/**
	 * 病人出院情况
	 * 
	 * @param is_chuy
	 */
	public void setIs_chuy(String is_chuy) {
		this.is_chuy = is_chuy;
	}

	/**
	 * 主要诊断
	 * 
	 * @return
	 */
	public String getDiagnosis() {
		return diagnosis;
	}

	/**
	 * 主要诊断
	 * 
	 * @param diagnosis
	 */
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/**
	 * 病人体重
	 * 
	 * @return
	 */
	public String getPatient_weight() {
		return patient_weight;
	}

	/**
	 * 病人体重
	 * 
	 * @param patient_weight
	 */
	public void setPatient_weight(String patient_weight) {
		this.patient_weight = patient_weight;
	}

	/**
	 * 病人类型
	 * 
	 * @return
	 */
	public String getPatient_class() {
		return patient_class;
	}

	/**
	 * 病人类型
	 * 
	 * @param patient_class
	 */
	public void setPatient_class(String patient_class) {
		this.patient_class = patient_class;
	}

}
