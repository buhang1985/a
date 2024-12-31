package iih.ci.rcm;
/**
 * 院感上报主卡
 * @author LJL
 *
 */
public class HospitalInfectionMainPrintDTO {
	private String id_hospitalreport;
	private String name_dept; // 科别
	private String fill_in_person; // 调查者
	private String modifiedtime;  // 最近修改时间
	private String sd_pat;  // 病人编码
	private String code_amr_ip;  // 病历号
	private String times_ip;  // 住院次
	private String name_pat;  // 姓名
	private String name_sex;  // 性别
	private String pat_age;   // 年龄
	private String admission_date;  // 入院日期
	private String discharge_date;  // 出院日期
	private String in_hospital_days;  // 住院天数
	private String name_bed;   // 床号
	private String name_ishos_infec; // 医院感染
	private String is_late; // 是否漏报
	private String id_survey_mth;   // 调查方式
	private String id_disease_outcome;   // 疾病转归
	private String id_rela_with_death;   // 死亡关系
	private String infectious_disease; // 感染性疾病病程
	private String diagnosis_basis; // 感染疾病诊断依据
	private String name_di_diagnosis;  // 疾病诊断
	private String name_infection_factors;  // 易感因素
	private String name_inva_oper_site;  // 侵害性操作
	private String is_treatment_in_icu; // 是否ICU
	private String id_icu_type; // ICU科别
    private String is_surgery; // 是否手术
    private String is_etiol_examination; // 是否病原检验
    private String is_use_antibiotics; // 是否使用抗菌药物
    private String serial_number; // 序号
    
	public String getId_icu_type() {
		return id_icu_type;
	}
	public void setId_icu_type(String id_icu_type) {
		this.id_icu_type = id_icu_type;
	}
	public String getName_infection_factors() {
		return name_infection_factors;
	}
	public void setName_infection_factors(String name_infection_factors) {
		this.name_infection_factors = name_infection_factors;
	}
	public String getName_inva_oper_site() {
		return name_inva_oper_site;
	}
	public void setName_inva_oper_site(String name_inva_oper_site) {
		this.name_inva_oper_site = name_inva_oper_site;
	}
	public String getIs_treatment_in_icu() {
		return is_treatment_in_icu;
	}
	public void setIs_treatment_in_icu(String is_treatment_in_icu) {
		this.is_treatment_in_icu = is_treatment_in_icu;
	}
	public String getIs_surgery() {
		return is_surgery;
	}
	public void setIs_surgery(String is_surgery) {
		this.is_surgery = is_surgery;
	}
	public String getIs_etiol_examination() {
		return is_etiol_examination;
	}
	public void setIs_etiol_examination(String is_etiol_examination) {
		this.is_etiol_examination = is_etiol_examination;
	}
	public String getIs_use_antibiotics() {
		return is_use_antibiotics;
	}
	public void setIs_use_antibiotics(String is_use_antibiotics) {
		this.is_use_antibiotics = is_use_antibiotics;
	}
	public String getId_survey_mth() {
		return id_survey_mth;
	}
	public void setId_survey_mth(String id_survey_mth) {
		this.id_survey_mth = id_survey_mth;
	}
	public String getId_disease_outcome() {
		return id_disease_outcome;
	}
	public void setId_disease_outcome(String id_disease_outcome) {
		this.id_disease_outcome = id_disease_outcome;
	}
	public String getId_rela_with_death() {
		return id_rela_with_death;
	}
	public void setId_rela_with_death(String id_rela_with_death) {
		this.id_rela_with_death = id_rela_with_death;
	}
	public String getInfectious_disease() {
		return infectious_disease;
	}
	public void setInfectious_disease(String infectious_disease) {
		this.infectious_disease = infectious_disease;
	}
	public String getDiagnosis_basis() {
		return diagnosis_basis;
	}
	public void setDiagnosis_basis(String diagnosis_basis) {
		this.diagnosis_basis = diagnosis_basis;
	}
	public String getSerial_number() {
		return serial_number;
	}
	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}
	public String getId_hospitalreport() {
		return id_hospitalreport;
	}
	public void setId_hospitalreport(String id_hospitalreport) {
		this.id_hospitalreport = id_hospitalreport;
	}
	public String getName_dept() {
		return name_dept;
	}
	public void setName_dept(String name_dept) {
		this.name_dept = name_dept;
	}
	public String getFill_in_person() {
		return fill_in_person;
	}
	public void setFill_in_person(String fill_in_person) {
		this.fill_in_person = fill_in_person;
	}
	public String getModifiedtime() {
		return modifiedtime;
	}
	public void setModifiedtime(String modifiedtime) {
		this.modifiedtime = modifiedtime;
	}
	public String getSd_pat() {
		return sd_pat;
	}
	public void setSd_pat(String sd_pat) {
		this.sd_pat = sd_pat;
	}
	public String getCode_amr_ip() {
		return code_amr_ip;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}
	public String getTimes_ip() {
		return times_ip;
	}
	public void setTimes_ip(String times_ip) {
		this.times_ip = times_ip;
	}
	public String getName_pat() {
		return name_pat;
	}
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}
	public String getName_sex() {
		return name_sex;
	}
	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}
	public String getPat_age() {
		return pat_age;
	}
	public void setPat_age(String pat_age) {
		this.pat_age = pat_age;
	}
	public String getName_di_diagnosis() {
		return name_di_diagnosis;
	}
	public void setName_di_diagnosis(String name_di_diagnosis) {
		this.name_di_diagnosis = name_di_diagnosis;
	}
	public String getAdmission_date() {
		return admission_date;
	}
	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}
	public String getDischarge_date() {
		return discharge_date;
	}
	public void setDischarge_date(String discharge_date) {
		this.discharge_date = discharge_date;
	}
	public String getIn_hospital_days() {
		return in_hospital_days;
	}
	public void setIn_hospital_days(String in_hospital_days) {
		this.in_hospital_days = in_hospital_days;
	}
	public String getName_bed() {
		return name_bed;
	}
	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}
	public String getName_ishos_infec() {
		return name_ishos_infec;
	}
	public void setName_ishos_infec(String name_ishos_infec) {
		this.name_ishos_infec = name_ishos_infec;
	}
	public String getIs_late() {
		return is_late;
	}
	public void setIs_late(String is_late) {
		this.is_late = is_late;
	}
}
