package iih.mp.nr.api.d;

import java.io.Serializable;

public class PatientsInfo implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
   
	/**
	 * 患者唯一标识 ID
	 */
	private String patient_id;
	
	/**
	 * 门诊号
	 */
	private String outpatient_id;
	
	/**
	 * 住院号
	 */
	private String inhospital_id;

	/**
	 * 就诊卡号
	 */
	private String card_no;

	/**
	 * 就诊时间/住院时间（格式： yyyy-MM-dd HH:mm:ss.fff）
	 */
	private String visit_time;
	
	/**
	 * 姓名
	 */
	private String patient_name;
	
	/**
	 * 性别
	 */
	private String patient_sex;
	
	/**
	 * 出生日期（格式yyyy-MM-dd）
	 */
	private String patient_birthdate;
	
	/**
	 * 身份证号
	 */
	private String identity_card_id;
	
	/**
	 * 患者类别(住院，急诊，门诊，住院急诊，门诊急诊等)
	 */
	private String patient_type;
	
	/**
	 * 民族
	 */
	private String patient_nation;
	
	/**
	 * 家庭住址-省
	 */
	private String family_address_province;
	
	/**
	 * 家庭住址-市
	 */
	private String family_address_city;
	
	/**
	 * 家庭住址-详细地址
	 */
	private String family_address_detail;
	
	/**
	 * 手机号
	 */
	private String mobile_phone;

	public String getPatient_id() {
		return patient_id;
	}

	public String getOutpatient_id() {
		return outpatient_id;
	}

	public String getInhospital_id() {
		return inhospital_id;
	}

	public String getCard_no() {
		return card_no;
	}

	public String getVisit_time() {
		return visit_time;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public String getPatient_sex() {
		return patient_sex;
	}

	public String getPatient_birthdate() {
		return patient_birthdate;
	}

	public String getIdentity_card_id() {
		return identity_card_id;
	}

	public String getPatient_type() {
		return patient_type;
	}

	public String getPatient_nation() {
		return patient_nation;
	}

	public String getFamily_address_province() {
		return family_address_province;
	}

	public String getFamily_address_city() {
		return family_address_city;
	}

	public String getFamily_address_detail() {
		return family_address_detail;
	}

	public String getMobile_phone() {
		return mobile_phone;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public void setOutpatient_id(String outpatient_id) {
		this.outpatient_id = outpatient_id;
	}

	public void setInhospital_id(String inhospital_id) {
		this.inhospital_id = inhospital_id;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	public void setVisit_time(String visit_time) {
		this.visit_time = visit_time;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public void setPatient_sex(String patient_sex) {
		this.patient_sex = patient_sex;
	}

	public void setPatient_birthdate(String patient_birthdate) {
		this.patient_birthdate = patient_birthdate;
	}

	public void setIdentity_card_id(String identity_card_id) {
		this.identity_card_id = identity_card_id;
	}

	public void setPatient_type(String patient_type) {
		this.patient_type = patient_type;
	}

	public void setPatient_nation(String patient_nation) {
		this.patient_nation = patient_nation;
	}

	public void setFamily_address_province(String family_address_province) {
		this.family_address_province = family_address_province;
	}

	public void setFamily_address_city(String family_address_city) {
		this.family_address_city = family_address_city;
	}

	public void setFamily_address_detail(String family_address_detail) {
		this.family_address_detail = family_address_detail;
	}

	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	
	
	
	
}
