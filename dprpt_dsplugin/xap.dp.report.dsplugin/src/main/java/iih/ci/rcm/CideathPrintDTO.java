package iih.ci.rcm;

/**
 * 
 * @author tangws
 * @date 2017年3月30日 下午3:04:40 死亡证明书打印dto
 */
public class CideathPrintDTO {
 
    private String healthnumber;//第一联编码
	private String province;// 省
	private String city;// 市
	private String county;// 县
	private String street;// 街道
	private String address_code;// 行政区划代码
	private String address_no;// 编码
	private String name_pat;// 死者姓名
	private String sex_pat;// 性别
	private String sex;
	private String nation_pat;// 民族
	private String country_pat;// 国家或地区
	private String idcard_type;// 证件类别
	private String cardtype;
	private String idcard_no;// 证件号
	private String age_pat;// 年龄
	private String marry_status;// 婚姻
	private String degree_pat;// 文化程度

	private String birth_pat;// 出生日期
	private String is_pregnant;// 是否妊娠期
	private String job_pat;// 个人身份
	private String death_time;// 死亡日期
	private String death_site;// 死亡地点
	private String deathplace;
	private String work_company;// 生前工作单位
	private String birth_place;// 户籍地址
	private String birth_place_fullname;//户籍地址全称
	private String address_usual;// 常住地址
	private String address_usual_fullname;//常住地址全称
	private String relation_name;// 联系人
	private String relation_phone;// 联系电话
	private String relation_address;// 联系人地址
	private String death_a_diag;
	private String death_a_timespan;
	private String death_b_diag;
	private String death_b_timespan;
	private String death_c_diag;
	private String death_c_timespan;
	private String death_d_diag;
	private String death_d_timespan;
	private String death_other_diag;// 其它诊断
	private String diag_basis;// 最高诊断依据（参照要处理）
	private String diag_hospital;// 最高诊断单位（参照要处理）
	private String sign_doctor;// 医师签名
	private String inhos_no;// 住院号
	private String createdtime;// 填表日期
	private String death_reason;// 根本死亡原因
	private String diag_icdname;// ICD编码
	private String symptom_sign;// 症状体征
	private String investigate_name;// 被调查者姓名
	private String investigate_relation;// 关系
	private String investigate_phone;// 电话
	private String investigate_address;// 住址
	private String death_infer;// 死因推断
	private String investigate_date;// 调查日期
	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;
	private String second;

  	public String getHealthnumber() {
		return healthnumber;
	}

	public void setHealthnumber(String healthnumber) {
		this.healthnumber = healthnumber;
	}
	
	public String getProvince() {
		return province;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress_code() {
		return address_code;
	}

	public void setAddress_code(String address_code) {
		this.address_code = address_code;
	}

	public String getAddress_no() {
		return address_no;
	}

	public void setAddress_no(String address_no) {
		this.address_no = address_no;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getSex_pat() {
		return sex_pat;
	}

	public void setSex_pat(String sex_pat) {
		this.sex_pat = sex_pat;
	}

	public String getNation_pat() {
		return nation_pat;
	}

	public void setNation_pat(String nation_pat) {
		this.nation_pat = nation_pat;
	}

	public String getCountry_pat() {
		return country_pat;
	}

	public void setCountry_pat(String country_pat) {
		this.country_pat = country_pat;
	}

	public String getIdcard_type() {
		return idcard_type;
	}

	public void setIdcard_type(String idcard_type) {
		this.idcard_type = idcard_type;
	}

	public String getIdcard_no() {
		return idcard_no;
	}

	public void setIdcard_no(String idcard_no) {
		this.idcard_no = idcard_no;
	}

	public String getAge_pat() {
		return age_pat;
	}

	public void setAge_pat(String age_pat) {
		this.age_pat = age_pat;
	}

	public String getMarry_status() {
		return marry_status;
	}

	public void setMarry_status(String marry_status) {
		this.marry_status = marry_status;
	}

	public String getDegree_pat() {
		return degree_pat;
	}

	public void setDegree_pat(String degree_pat) {
		this.degree_pat = degree_pat;
	}

	public String getBirth_pat() {
		return birth_pat;
	}

	public void setBirth_pat(String birth_pat) {
		this.birth_pat = birth_pat;
	}

	public String getIs_pregnant() {
		return is_pregnant;
	}

	public void setIs_pregnant(String is_pregnant) {
		this.is_pregnant = is_pregnant;
	}

	public String getJob_pat() {
		return job_pat;
	}

	public void setJob_pat(String job_pat) {
		this.job_pat = job_pat;
	}

	public String getDeath_time() {
		return death_time;
	}

	public void setDeath_time(String death_time) {
		this.death_time = death_time;
	}

	public String getDeath_site() {
		return death_site;
	}

	public void setDeath_site(String death_site) {
		this.death_site = death_site;
	}

	public String getWork_company() {
		return work_company;
	}

	public void setWork_company(String work_company) {
		this.work_company = work_company;
	}

	public String getBirth_place() {
		return birth_place;
	}

	public void setBirth_place(String birth_place) {
		this.birth_place = birth_place;
	}

	public String getAddress_usual() {
		return address_usual;
	}

	public void setAddress_usual(String address_usual) {
		this.address_usual = address_usual;
	}

	public String getRelation_name() {
		return relation_name;
	}

	public void setRelation_name(String relation_name) {
		this.relation_name = relation_name;
	}

	public String getRelation_phone() {
		return relation_phone;
	}

	public void setRelation_phone(String relation_phone) {
		this.relation_phone = relation_phone;
	}

	public String getRelation_address() {
		return relation_address;
	}

	public void setRelation_address(String relation_address) {
		this.relation_address = relation_address;
	}

	public String getDeath_a_diag() {
		return death_a_diag;
	}

	public void setDeath_a_diag(String death_a_diag) {
		this.death_a_diag = death_a_diag;
	}

	public String getDeath_a_timespan() {
		return death_a_timespan;
	}

	public void setDeath_a_timespan(String death_a_timespan) {
		this.death_a_timespan = death_a_timespan;
	}

	public String getDeath_b_diag() {
		return death_b_diag;
	}

	public void setDeath_b_diag(String death_b_diag) {
		this.death_b_diag = death_b_diag;
	}

	public String getDeath_b_timespan() {
		return death_b_timespan;
	}

	public void setDeath_b_timespan(String death_b_timespan) {
		this.death_b_timespan = death_b_timespan;
	}

	public String getDeath_c_diag() {
		return death_c_diag;
	}

	public void setDeath_c_diag(String death_c_diag) {
		this.death_c_diag = death_c_diag;
	}

	public String getDeath_c_timespan() {
		return death_c_timespan;
	}

	public void setDeath_c_timespan(String death_c_timespan) {
		this.death_c_timespan = death_c_timespan;
	}

	public String getDeath_d_diag() {
		return death_d_diag;
	}

	public void setDeath_d_diag(String death_d_diag) {
		this.death_d_diag = death_d_diag;
	}

	public String getDeath_d_timespan() {
		return death_d_timespan;
	}

	public void setDeath_d_timespan(String death_d_timespan) {
		this.death_d_timespan = death_d_timespan;
	}

	public String getDeath_other_diag() {
		return death_other_diag;
	}

	public void setDeath_other_diag(String death_other_diag) {
		this.death_other_diag = death_other_diag;
	}

	public String getDiag_basis() {
		return diag_basis;
	}

	public void setDiag_basis(String diag_basis) {
		this.diag_basis = diag_basis;
	}

	public String getDiag_hospital() {
		return diag_hospital;
	}

	public void setDiag_hospital(String diag_hospital) {
		this.diag_hospital = diag_hospital;
	}

	public String getSign_doctor() {
		return sign_doctor;
	}

	public void setSign_doctor(String sign_doctor) {
		this.sign_doctor = sign_doctor;
	}

	public String getInhos_no() {
		return inhos_no;
	}

	public void setInhos_no(String inhos_no) {
		this.inhos_no = inhos_no;
	}

	public String getCreatedtime() {
		return createdtime;
	}

	public void setCreatedtime(String createdtime) {
		this.createdtime = createdtime;
	}

	public String getDeath_reason() {
		return death_reason;
	}

	public void setDeath_reason(String death_reason) {
		this.death_reason = death_reason;
	}

	public String getDiag_icdname() {
		return diag_icdname;
	}

	public void setDiag_icdname(String diag_icdname) {
		this.diag_icdname = diag_icdname;
	}

	public String getSymptom_sign() {
		return symptom_sign;
	}

	public void setSymptom_sign(String symptom_sign) {
		this.symptom_sign = symptom_sign;
	}

	public String getInvestigate_name() {
		return investigate_name;
	}

	public void setInvestigate_name(String investigate_name) {
		this.investigate_name = investigate_name;
	}

	public String getInvestigate_relation() {
		return investigate_relation;
	}

	public void setInvestigate_relation(String investigate_relation) {
		this.investigate_relation = investigate_relation;
	}

	public String getInvestigate_phone() {
		return investigate_phone;
	}

	public void setInvestigate_phone(String investigate_phone) {
		this.investigate_phone = investigate_phone;
	}

	public String getInvestigate_address() {
		return investigate_address;
	}

	public void setInvestigate_address(String investigate_address) {
		this.investigate_address = investigate_address;
	}

	public String getDeath_infer() {
		return death_infer;
	}

	public void setDeath_infer(String death_infer) {
		this.death_infer = death_infer;
	}

	public String getInvestigate_date() {
		return investigate_date;
	}

	public void setInvestigate_date(String investigate_date) {
		this.investigate_date = investigate_date;
	}

	public String getDeathplace() {
		return deathplace;
	}

	public void setDeathplace(String deathplace) {
		this.deathplace = deathplace;
	}
	
	public String getBirth_place_fullname(){
		return birth_place_fullname;
	}
	
	public void setBirth_place_fullname(String birth_place_fullname){
		this.birth_place_fullname = birth_place_fullname;
	}
	
	public String getAddress_usual_fullname(){
		return address_usual_fullname;
	}
	
	public void setAddress_usual_fullname(String address_usual_fullname){
		this.address_usual_fullname = address_usual_fullname;
	}

}
