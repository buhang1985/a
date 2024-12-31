package iih.ci.rcm.infectioncasedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 院感病例 DTO数据 
 * 
 */
public class InfectionCaseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 院感病例主键
	 * @return String
	 */
	public String getId_infecase() {
		return ((String) getAttrVal("Id_infecase"));
	}
	/**
	 * 院感病例主键
	 * @param Id_infecase
	 */
	public void setId_infecase(String Id_infecase) {
		setAttrVal("Id_infecase", Id_infecase);
	}
	/**
	 * 调查表时间
	 * @return FDate
	 */
	public FDate getInvestigatetime() {
		return ((FDate) getAttrVal("Investigatetime"));
	}
	/**
	 * 调查表时间
	 * @param Investigatetime
	 */
	public void setInvestigatetime(FDate Investigatetime) {
		setAttrVal("Investigatetime", Investigatetime);
	}
	/**
	 * 调查者
	 * @return String
	 */
	public String getInvestigator() {
		return ((String) getAttrVal("Investigator"));
	}
	/**
	 * 调查者
	 * @param Investigator
	 */
	public void setInvestigator(String Investigator) {
		setAttrVal("Investigator", Investigator);
	}
	/**
	 * 调查方式
	 * @return String
	 */
	public String getName_survey_mth() {
		return ((String) getAttrVal("Name_survey_mth"));
	}
	/**
	 * 调查方式
	 * @param Name_survey_mth
	 */
	public void setName_survey_mth(String Name_survey_mth) {
		setAttrVal("Name_survey_mth", Name_survey_mth);
	}
	/**
	 * 病人编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 病人编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 病人姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 病人姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 病人性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 病人性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 病历号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 科别
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科别
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 入院日期
	 * @return FDate
	 */
	public FDate getDt_acpt() {
		return ((FDate) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDate Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getIn_hospital_days() {
		return ((Integer) getAttrVal("In_hospital_days"));
	}
	/**
	 * 住院天数
	 * @param In_hospital_days
	 */
	public void setIn_hospital_days(Integer In_hospital_days) {
		setAttrVal("In_hospital_days", In_hospital_days);
	}
	/**
	 * 最近修改时间
	 * @return String
	 */
	public String getModifiedtime() {
		return ((String) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最近修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(String Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 漏报
	 * @return FBoolean
	 */
	public FBoolean getIs_fail_report() {
		return ((FBoolean) getAttrVal("Is_fail_report"));
	}
	/**
	 * 漏报
	 * @param Is_fail_report
	 */
	public void setIs_fail_report(FBoolean Is_fail_report) {
		setAttrVal("Is_fail_report", Is_fail_report);
	}
	/**
	 * 医院感染
	 * @return FBoolean
	 */
	public FBoolean getHosinfection() {
		return ((FBoolean) getAttrVal("Hosinfection"));
	}
	/**
	 * 医院感染
	 * @param Hosinfection
	 */
	public void setHosinfection(FBoolean Hosinfection) {
		setAttrVal("Hosinfection", Hosinfection);
	}
	/**
	 * 疾病转归
	 * @return String
	 */
	public String getName_disease_outcome() {
		return ((String) getAttrVal("Name_disease_outcome"));
	}
	/**
	 * 疾病转归
	 * @param Name_disease_outcome
	 */
	public void setName_disease_outcome(String Name_disease_outcome) {
		setAttrVal("Name_disease_outcome", Name_disease_outcome);
	}
	/**
	 * 与死亡的关系
	 * @return String
	 */
	public String getName_rela_with_death() {
		return ((String) getAttrVal("Name_rela_with_death"));
	}
	/**
	 * 与死亡的关系
	 * @param Name_rela_with_death
	 */
	public void setName_rela_with_death(String Name_rela_with_death) {
		setAttrVal("Name_rela_with_death", Name_rela_with_death);
	}
	/**
	 * 感染性疾病病程
	 * @return String
	 */
	public String getInfectious_disease() {
		return ((String) getAttrVal("Infectious_disease"));
	}
	/**
	 * 感染性疾病病程
	 * @param Infectious_disease
	 */
	public void setInfectious_disease(String Infectious_disease) {
		setAttrVal("Infectious_disease", Infectious_disease);
	}
	/**
	 * 诊断依据
	 * @return String
	 */
	public String getDiagnosis_basis() {
		return ((String) getAttrVal("Diagnosis_basis"));
	}
	/**
	 * 诊断依据
	 * @param Diagnosis_basis
	 */
	public void setDiagnosis_basis(String Diagnosis_basis) {
		setAttrVal("Diagnosis_basis", Diagnosis_basis);
	}
	/**
	 * 手术
	 * @return FBoolean
	 */
	public FBoolean getIs_surgery() {
		return ((FBoolean) getAttrVal("Is_surgery"));
	}
	/**
	 * 手术
	 * @param Is_surgery
	 */
	public void setIs_surgery(FBoolean Is_surgery) {
		setAttrVal("Is_surgery", Is_surgery);
	}
	/**
	 * 病原学检验
	 * @return FBoolean
	 */
	public FBoolean getIs_etiol_examination() {
		return ((FBoolean) getAttrVal("Is_etiol_examination"));
	}
	/**
	 * 病原学检验
	 * @param Is_etiol_examination
	 */
	public void setIs_etiol_examination(FBoolean Is_etiol_examination) {
		setAttrVal("Is_etiol_examination", Is_etiol_examination);
	}
	/**
	 * 使用抗生素
	 * @return FBoolean
	 */
	public FBoolean getIs_use_antibiotics() {
		return ((FBoolean) getAttrVal("Is_use_antibiotics"));
	}
	/**
	 * 使用抗生素
	 * @param Is_use_antibiotics
	 */
	public void setIs_use_antibiotics(FBoolean Is_use_antibiotics) {
		setAttrVal("Is_use_antibiotics", Is_use_antibiotics);
	}
	/**
	 * 审签阶段
	 * @return String
	 */
	public String getName_stage() {
		return ((String) getAttrVal("Name_stage"));
	}
	/**
	 * 审签阶段
	 * @param Name_stage
	 */
	public void setName_stage(String Name_stage) {
		setAttrVal("Name_stage", Name_stage);
	}
}