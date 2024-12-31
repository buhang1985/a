package iih.ci.rcm.infectionpre.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医院感染现患率调查 DTO数据 
 * 
 */
public class InfectionpreDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 感染现患率调查主键
	 * @return String
	 */
	public String getId_hosinfectionrate() {
		return ((String) getAttrVal("Id_hosinfectionrate"));
	}
	/**
	 * 感染现患率调查主键
	 * @param Id_hosinfectionrate
	 */
	public void setId_hosinfectionrate(String Id_hosinfectionrate) {
		setAttrVal("Id_hosinfectionrate", Id_hosinfectionrate);
	}
	/**
	 * 调查表时间
	 * @return FDateTime
	 */
	public FDateTime getInvesttime() {
		return ((FDateTime) getAttrVal("Investtime"));
	}
	/**
	 * 调查表时间
	 * @param Investtime
	 */
	public void setInvesttime(FDateTime Investtime) {
		setAttrVal("Investtime", Investtime);
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
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 病人
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 病人
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 科室编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}
	/**
	 * 床位号
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次
	 * @return Integer
	 */
	public Integer getN_times_inhospital() {
		return ((Integer) getAttrVal("N_times_inhospital"));
	}
	/**
	 * 住院次
	 * @param N_times_inhospital
	 */
	public void setN_times_inhospital(Integer N_times_inhospital) {
		setAttrVal("N_times_inhospital", N_times_inhospital);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 是否漏报
	 * @return FBoolean
	 */
	public FBoolean getIs_fail_report() {
		return ((FBoolean) getAttrVal("Is_fail_report"));
	}
	/**
	 * 是否漏报
	 * @param Is_fail_report
	 */
	public void setIs_fail_report(FBoolean Is_fail_report) {
		setAttrVal("Is_fail_report", Is_fail_report);
	}
	/**
	 * 医院感染
	 * @return FBoolean
	 */
	public FBoolean getNoso_infection() {
		return ((FBoolean) getAttrVal("Noso_infection"));
	}
	/**
	 * 医院感染
	 * @param Noso_infection
	 */
	public void setNoso_infection(FBoolean Noso_infection) {
		setAttrVal("Noso_infection", Noso_infection);
	}
	/**
	 * HBsAg阳性
	 * @return String
	 */
	public String getHbsag_positive() {
		return ((String) getAttrVal("Hbsag_positive"));
	}
	/**
	 * HBsAg阳性
	 * @param Hbsag_positive
	 */
	public void setHbsag_positive(String Hbsag_positive) {
		setAttrVal("Hbsag_positive", Hbsag_positive);
	}
	/**
	 * 抗-HIV阳性
	 * @return String
	 */
	public String getHiv_positive() {
		return ((String) getAttrVal("Hiv_positive"));
	}
	/**
	 * 抗-HIV阳性
	 * @param Hiv_positive
	 */
	public void setHiv_positive(String Hiv_positive) {
		setAttrVal("Hiv_positive", Hiv_positive);
	}
	/**
	 * 抗-HCV阳性
	 * @return String
	 */
	public String getHcv_positive() {
		return ((String) getAttrVal("Hcv_positive"));
	}
	/**
	 * 抗-HCV阳性
	 * @param Hcv_positive
	 */
	public void setHcv_positive(String Hcv_positive) {
		setAttrVal("Hcv_positive", Hcv_positive);
	}
	/**
	 * 抗菌药物使用 
	 * @return FBoolean
	 */
	public FBoolean getAntibiotics_use() {
		return ((FBoolean) getAttrVal("Antibiotics_use"));
	}
	/**
	 * 抗菌药物使用 
	 * @param Antibiotics_use
	 */
	public void setAntibiotics_use(FBoolean Antibiotics_use) {
		setAttrVal("Antibiotics_use", Antibiotics_use);
	}
	/**
	 * 动静脉插管
	 * @return FBoolean
	 */
	public FBoolean getArte_intubation() {
		return ((FBoolean) getAttrVal("Arte_intubation"));
	}
	/**
	 * 动静脉插管
	 * @param Arte_intubation
	 */
	public void setArte_intubation(FBoolean Arte_intubation) {
		setAttrVal("Arte_intubation", Arte_intubation);
	}
	/**
	 * 使用呼吸机
	 * @return FBoolean
	 */
	public FBoolean getVentilator_use() {
		return ((FBoolean) getAttrVal("Ventilator_use"));
	}
	/**
	 * 使用呼吸机
	 * @param Ventilator_use
	 */
	public void setVentilator_use(FBoolean Ventilator_use) {
		setAttrVal("Ventilator_use", Ventilator_use);
	}
	/**
	 * 术前应用抗生素
	 * @return FBoolean
	 */
	public FBoolean getPre_use_antibiotic() {
		return ((FBoolean) getAttrVal("Pre_use_antibiotic"));
	}
	/**
	 * 术前应用抗生素
	 * @param Pre_use_antibiotic
	 */
	public void setPre_use_antibiotic(FBoolean Pre_use_antibiotic) {
		setAttrVal("Pre_use_antibiotic", Pre_use_antibiotic);
	}
	/**
	 * 外科手术期用药
	 * @return FBoolean
	 */
	public FBoolean getSurg_pharmacy() {
		return ((FBoolean) getAttrVal("Surg_pharmacy"));
	}
	/**
	 * 外科手术期用药
	 * @param Surg_pharmacy
	 */
	public void setSurg_pharmacy(FBoolean Surg_pharmacy) {
		setAttrVal("Surg_pharmacy", Surg_pharmacy);
	}
	/**
	 * 静脉输液
	 * @return FBoolean
	 */
	public FBoolean getIntravenous() {
		return ((FBoolean) getAttrVal("Intravenous"));
	}
	/**
	 * 静脉输液
	 * @param Intravenous
	 */
	public void setIntravenous(FBoolean Intravenous) {
		setAttrVal("Intravenous", Intravenous);
	}
	/**
	 * 细菌培养
	 * @return FBoolean
	 */
	public FBoolean getBact_culture() {
		return ((FBoolean) getAttrVal("Bact_culture"));
	}
	/**
	 * 细菌培养
	 * @param Bact_culture
	 */
	public void setBact_culture(FBoolean Bact_culture) {
		setAttrVal("Bact_culture", Bact_culture);
	}
	/**
	 * 泌尿道插管
	 * @return FBoolean
	 */
	public FBoolean getUrin_intubatton() {
		return ((FBoolean) getAttrVal("Urin_intubatton"));
	}
	/**
	 * 泌尿道插管
	 * @param Urin_intubatton
	 */
	public void setUrin_intubatton(FBoolean Urin_intubatton) {
		setAttrVal("Urin_intubatton", Urin_intubatton);
	}
	/**
	 * 腹泻
	 * @return FBoolean
	 */
	public FBoolean getDiarrhea() {
		return ((FBoolean) getAttrVal("Diarrhea"));
	}
	/**
	 * 腹泻
	 * @param Diarrhea
	 */
	public void setDiarrhea(FBoolean Diarrhea) {
		setAttrVal("Diarrhea", Diarrhea);
	}
	/**
	 * 手术
	 * @return FBoolean
	 */
	public FBoolean getOperation() {
		return ((FBoolean) getAttrVal("Operation"));
	}
	/**
	 * 手术
	 * @param Operation
	 */
	public void setOperation(FBoolean Operation) {
		setAttrVal("Operation", Operation);
	}
	/**
	 * 联用
	 * @return String
	 */
	public String getId_com_medi() {
		return ((String) getAttrVal("Id_com_medi"));
	}
	/**
	 * 联用
	 * @param Id_com_medi
	 */
	public void setId_com_medi(String Id_com_medi) {
		setAttrVal("Id_com_medi", Id_com_medi);
	}
	/**
	 * 联用编码
	 * @return String
	 */
	public String getSd_com_medi() {
		return ((String) getAttrVal("Sd_com_medi"));
	}
	/**
	 * 联用编码
	 * @param Sd_com_medi
	 */
	public void setSd_com_medi(String Sd_com_medi) {
		setAttrVal("Sd_com_medi", Sd_com_medi);
	}
	/**
	 * 联用名称
	 * @return String
	 */
	public String getName_com_medi() {
		return ((String) getAttrVal("Name_com_medi"));
	}
	/**
	 * 联用名称
	 * @param Name_com_medi
	 */
	public void setName_com_medi(String Name_com_medi) {
		setAttrVal("Name_com_medi", Name_com_medi);
	}
	/**
	 * 目的
	 * @return String
	 */
	public String getId_purpose() {
		return ((String) getAttrVal("Id_purpose"));
	}
	/**
	 * 目的
	 * @param Id_purpose
	 */
	public void setId_purpose(String Id_purpose) {
		setAttrVal("Id_purpose", Id_purpose);
	}
	/**
	 * 目的编码
	 * @return String
	 */
	public String getSd_purpose() {
		return ((String) getAttrVal("Sd_purpose"));
	}
	/**
	 * 目的编码
	 * @param Sd_purpose
	 */
	public void setSd_purpose(String Sd_purpose) {
		setAttrVal("Sd_purpose", Sd_purpose);
	}
	/**
	 * 目的名称
	 * @return String
	 */
	public String getName_purpose() {
		return ((String) getAttrVal("Name_purpose"));
	}
	/**
	 * 目的名称
	 * @param Name_purpose
	 */
	public void setName_purpose(String Name_purpose) {
		setAttrVal("Name_purpose", Name_purpose);
	}
	/**
	 * 手术切口
	 * @return String
	 */
	public String getId_surg_incision() {
		return ((String) getAttrVal("Id_surg_incision"));
	}
	/**
	 * 手术切口
	 * @param Id_surg_incision
	 */
	public void setId_surg_incision(String Id_surg_incision) {
		setAttrVal("Id_surg_incision", Id_surg_incision);
	}
	/**
	 * 手术切口编码
	 * @return String
	 */
	public String getSd_surg_incision() {
		return ((String) getAttrVal("Sd_surg_incision"));
	}
	/**
	 * 手术切口编码
	 * @param Sd_surg_incision
	 */
	public void setSd_surg_incision(String Sd_surg_incision) {
		setAttrVal("Sd_surg_incision", Sd_surg_incision);
	}
	/**
	 * 手术切口名称
	 * @return String
	 */
	public String getName_surg_incision() {
		return ((String) getAttrVal("Name_surg_incision"));
	}
	/**
	 * 手术切口名称
	 * @param Name_surg_incision
	 */
	public void setName_surg_incision(String Name_surg_incision) {
		setAttrVal("Name_surg_incision", Name_surg_incision);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifytime() {
		return ((FDateTime) getAttrVal("Modifytime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifytime
	 */
	public void setModifytime(FDateTime Modifytime) {
		setAttrVal("Modifytime", Modifytime);
	}
	/**
	 * 操作者
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 操作者
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
}