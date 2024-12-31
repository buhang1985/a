package iih.ci.rcm.hospitalreport.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.hospitalreport.d.desc.HospitalReportDODesc;
import java.math.BigDecimal;

/**
 * 院感上报 DO数据 
 * 
 */
public class HospitalReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//院感上报主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊号
	public static final String ID_ENT= "Id_ent";
	//入院日期
	public static final String ADMISSION_DATE= "Admission_date";
	//入院诊断
	public static final String ID_RY_DIAGNOSIS= "Id_ry_diagnosis";
	//入院诊断编码
	public static final String SD_RY_DIAGNOSIS= "Sd_ry_diagnosis";
	//入院诊断名称
	public static final String NAME_RY_DIAGNOSIS= "Name_ry_diagnosis";
	//出院日期
	public static final String DISCHARGE_DATE= "Discharge_date";
	//出院诊断
	public static final String ID_CY_DIAGNOSIS= "Id_cy_diagnosis";
	//出院诊断编码
	public static final String SD_CY_DIAGNOSIS= "Sd_cy_diagnosis";
	//出院诊断名称
	public static final String NAME_CY_DIAGNOSIS= "Name_cy_diagnosis";
	//住院天数
	public static final String IN_HOSPITAL_DAYS= "In_hospital_days";
	//监测日期
	public static final String MONITOR_DATE= "Monitor_date";
	//疾病诊断
	public static final String ID_DI_DIAGNOSIS= "Id_di_diagnosis";
	//疾病诊断编码
	public static final String SD_DI_DIAGNOSIS= "Sd_di_diagnosis";
	//疾病诊断名称
	public static final String NAME_DI_DIAGNOSIS= "Name_di_diagnosis";
	//疾病转归
	public static final String ID_DISEASE_OUTCOME= "Id_disease_outcome";
	//疾病转归编码
	public static final String SD_DISEASE_OUTCOME= "Sd_disease_outcome";
	//疾病转归名称
	public static final String NAME_DISEASE_OUTCOME= "Name_disease_outcome";
	//与死亡的关系
	public static final String ID_RELA_WITH_DEATH= "Id_rela_with_death";
	//与死亡的关系编码
	public static final String SD_RELA_WITH_DEATH= "Sd_rela_with_death";
	//与死亡的关系名称
	public static final String NAME_RELA_WITH_DEATH= "Name_rela_with_death";
	//感染性疾病病程
	public static final String INFECTIOUS_DISEASE= "Infectious_disease";
	//诊断依据
	public static final String DIAGNOSIS_BASIS= "Diagnosis_basis";
	//是否医院内感染
	public static final String ID_ISHOS_INFEC= "Id_ishos_infec";
	//医院感染编码
	public static final String SD_ISHOS_INFEC= "Sd_ishos_infec";
	//医院感染名称
	public static final String NAME_ISHOS_INFEC= "Name_ishos_infec";
	//是否随访
	public static final String ID_IS_INVESTIGATION= "Id_is_investigation";
	//随访编码
	public static final String SD_IS_INVESTIGATION= "Sd_is_investigation";
	//随访名称
	public static final String NAME_IS_INVESTIGATION= "Name_is_investigation";
	//随访方式
	public static final String ID_INVESTIGATION= "Id_investigation";
	//随访方式编码
	public static final String SD_INVESTIGATION= "Sd_investigation";
	//随访方式名称
	public static final String NAME_INVESTIGATION= "Name_investigation";
	//在ICU治疗过
	public static final String IS_TREATMENT_IN_ICU= "Is_treatment_in_icu";
	//ICU科别
	public static final String ID_ICU_TYPE= "Id_icu_type";
	//ICU科别编码
	public static final String SD_ICU_TYPE= "Sd_icu_type";
	//ICU科别名称
	public static final String NAME_ICU_TYPE= "Name_icu_type";
	//转入ICU时间
	public static final String HOSPITAL_OCCURRENCE_DATE= "Hospital_occurrence_date";
	//感染因素
	public static final String ID_INFECTION_FACTORS= "Id_infection_factors";
	//感染因素编码
	public static final String SD_INFECTION_FACTORS= "Sd_infection_factors";
	//感染因素名称
	public static final String NAME_INFECTION_FACTORS= "Name_infection_factors";
	//感染因素其它
	public static final String OTHER_INFECTION_FACTORS= "Other_infection_factors";
	//是否有手术
	public static final String IS_SURGERY= "Is_surgery";
	//院内感染诊断依据
	public static final String DI_OF_HOSP_INFECTION= "Di_of_hosp_infection";
	//病原学检查
	public static final String IS_ETIOL_EXAMINATION= "Is_etiol_examination";
	//使用抗生素
	public static final String IS_USE_ANTIBIOTICS= "Is_use_antibiotics";
	//是否迟报
	public static final String IS_LATE= "Is_late";
	//填报人
	public static final String FILL_IN_PERSON= "Fill_in_person";
	//填报日期
	public static final String FILL_IN_DATE= "Fill_in_date";
	//院感上报标题
	public static final String TITLE= "Title";
	//审签阶段
	public static final String ID_STAGE= "Id_stage";
	//审签阶段编码
	public static final String SD_STAGE= "Sd_stage";
	//审签阶段名称
	public static final String NAME_STAGE= "Name_stage";
	//驳回原因
	public static final String REJECT_REASON= "Reject_reason";
	//删除原因
	public static final String DELETE_REASON= "Delete_reason";
	//删除人
	public static final String DELETEBY= "Deleteby";
	//删除人编码
	public static final String CODE_DELETEBY= "Code_deleteby";
	//删除人姓名
	public static final String NAME_DELETEBY= "Name_deleteby";
	//删除时间
	public static final String DELETETIME= "Deletetime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//随访方式备注
	public static final String OTHER_INVERSITAGION_WAY= "Other_inversitagion_way";
	//院感发生日期
	public static final String YGFSRQ= "Ygfsrq";
	//调查方式
	public static final String ID_SURVEY_MTH= "Id_survey_mth";
	//调查方式编码
	public static final String SD_SURVEY_MTH= "Sd_survey_mth";
	//调查方式名称
	public static final String NAME_SURVEY_MTH= "Name_survey_mth";
	//患者科室
	public static final String ID_DEPT= "Id_dept";
	//患者科室编码
	public static final String SD_DEPT= "Sd_dept";
	//患者科室名称
	public static final String NAME_DEPT= "Name_dept";
	//患者病区
	public static final String ID_DEPT_NS= "Id_dept_ns";
	//患者病区编码
	public static final String SD_DEPT_NS= "Sd_dept_ns";
	//患者病区名称
	public static final String NAME_DEPT_NS= "Name_dept_ns";
	//患者床位
	public static final String ID_BED= "Id_bed";
	//患者床位编码
	public static final String SD_BED= "Sd_bed";
	//患者床位名称
	public static final String NAME_BED= "Name_bed";
	//备用字段1
	public static final String BACKUP_FILED1= "Backup_filed1";
	//备用字段2
	public static final String BACKUP_FILED2= "Backup_filed2";
	//备用字段3
	public static final String BACKUP_FILED3= "Backup_filed3";
	//备用字段4
	public static final String BACKUP_FILED4= "Backup_filed4";
	//备用字段5
	public static final String BACKUP_FILED5= "Backup_filed5";
	//患者主键
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String SD_PAT= "Sd_pat";
	//患者名称
	public static final String NAME_PAT= "Name_pat";
	//患者性别
	public static final String ID_SEX= "Id_sex";
	//患者性别编码
	public static final String SD_SEX= "Sd_sex";
	//患者性别名称
	public static final String NAME_SEX= "Name_sex";
	//患者年龄
	public static final String PAT_AGE= "Pat_age";
	//住院次数
	public static final String TIMES_IP= "Times_ip";
	//就诊编码
	public static final String SD_ENT= "Sd_ent";
	//入院科室
	public static final String ID_IN_DEPT= "Id_in_dept";
	//入院科室编码
	public static final String SD_IN_DEPT= "Sd_in_dept";
	//入院科室名称
	public static final String NAME_IN_DEPT= "Name_in_dept";
	//入院病区
	public static final String ID_IN_DEPT_NS= "Id_in_dept_ns";
	//入院病区编码
	public static final String SD_IN_DEPT_NS= "Sd_in_dept_ns";
	//入院病区名称
	public static final String NAME_IN_DEPT_NS= "Name_in_dept_ns";
	//填报人科室
	public static final String ID_FILL_IN_DEPT= "Id_fill_in_dept";
	//填报人科室编码
	public static final String SD_FILL_IN_DEPT= "Sd_fill_in_dept";
	//填报人科室名称
	public static final String NAME_FILL_IN_DEPT= "Name_fill_in_dept";
	//与感染部分相关侵袭性操作
	public static final String ID_INVA_OPER_SITE= "Id_inva_oper_site";
	//与感染部分相关侵袭性操作编码
	public static final String SD_INVA_OPER_SITE= "Sd_inva_oper_site";
	//与感染部分相关侵袭性操作名称
	public static final String NAME_INVA_OPER_SITE= "Name_inva_oper_site";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//编码
	public static final String CODE_GRP= "Code_grp";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//就诊编码
	public static final String CODE_ENT= "Code_ent";
	//诊断编码
	public static final String RY_DIAGNOSIS_CODE= "Ry_diagnosis_code";
	//诊断名称
	public static final String RY_DIAGNOSIS_NAME= "Ry_diagnosis_name";
	//诊断编码
	public static final String CY_DIAGNOSIS_CODE= "Cy_diagnosis_code";
	//诊断名称
	public static final String CY_IAGNOSIS_NAME= "Cy_iagnosis_name";
	//诊断编码
	public static final String DI_DIAGNOSIS_CODE= "Di_diagnosis_code";
	//诊断名称
	public static final String DI_DIAGNOSIS_NAME= "Di_diagnosis_name";
	//编码
	public static final String DISEASE_OUTCOME_CODE= "Disease_outcome_code";
	//名称
	public static final String DISEASE_OUTCOME_NAME= "Disease_outcome_name";
	//编码
	public static final String RELATIONSHIP_WITH_DEATH_CODE= "Relationship_with_death_code";
	//名称
	public static final String RELATIONSHIP_WITH_DEATH_NAME= "Relationship_with_death_name";
	//编码
	public static final String INHOS_INFEC_CODE= "Inhos_infec_code";
	//名称
	public static final String INHOS_INFEC_NAME= "Inhos_infec_name";
	//编码
	public static final String INVESTIGATION_CODE= "Investigation_code";
	//名称
	public static final String INVESTIGATION_NAME= "Investigation_name";
	//编码
	public static final String INVESTIGA_CODE= "Investiga_code";
	//名称
	public static final String INVESTIGA_NAME= "Investiga_name";
	//编码
	public static final String ICU_TYPE_CODE= "Icu_type_code";
	//名称
	public static final String ICU_TYPE_NAME= "Icu_type_name";
	//编码
	public static final String INFECTION_FACTORS_CODE= "Infection_factors_code";
	//名称
	public static final String INFECTION_FACTORS_NAME= "Infection_factors_name";
	//编码
	public static final String STAGE_CODE= "Stage_code";
	//名称
	public static final String STAGE_NAME= "Stage_name";
	//人员编码
	public static final String DELETEBY_CODE= "Deleteby_code";
	//姓名
	public static final String DELETEBY_NAME= "Deleteby_name";
	//调查方式编码
	public static final String SURVEY_MTH_CODE= "Survey_mth_code";
	//调查方式名称
	public static final String SURVEY_MTH_NAME= "Survey_mth_name";
	//编码
	public static final String DEPT_CODE= "Dept_code";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String DEPT_NS_CODE= "Dept_ns_code";
	//名称
	public static final String DEPT_NS_NAME= "Dept_ns_name";
	//床位编码
	public static final String BED_CODE= "Bed_code";
	//床位名称
	public static final String BED_NAME= "Bed_name";
	//患者编码
	public static final String PAT_CODE= "Pat_code";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//编码
	public static final String SEX_CODE= "Sex_code";
	//名称
	public static final String SEX_NAME= "Sex_name";
	//编码
	public static final String IN_DEPT_CODE= "In_dept_code";
	//名称
	public static final String IN_DEPT_NAME= "In_dept_name";
	//编码
	public static final String IN_DEPT_NS_CODE= "In_dept_ns_code";
	//名称
	public static final String IN_DEPT_NS_NAME= "In_dept_ns_name";
	//编码
	public static final String FILL_IN_DEPT_CODE= "Fill_in_dept_code";
	//名称
	public static final String FILL_IN_DEPT_NAME= "Fill_in_dept_name";
	//编码
	public static final String INVA_OPER_SITE_CODE= "Inva_oper_site_code";
	//名称
	public static final String INVA_OPER_SITE_NAME= "Inva_oper_site_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 院感上报主键
	 * @return String
	 */
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	/**
	 * 院感上报主键
	 * @param Id_hospitalreport
	 */
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 入院日期
	 * @return FDate
	 */
	public FDate getAdmission_date() {
		return ((FDate) getAttrVal("Admission_date"));
	}	
	/**
	 * 入院日期
	 * @param Admission_date
	 */
	public void setAdmission_date(FDate Admission_date) {
		setAttrVal("Admission_date", Admission_date);
	}
	/**
	 * 入院诊断
	 * @return String
	 */
	public String getId_ry_diagnosis() {
		return ((String) getAttrVal("Id_ry_diagnosis"));
	}	
	/**
	 * 入院诊断
	 * @param Id_ry_diagnosis
	 */
	public void setId_ry_diagnosis(String Id_ry_diagnosis) {
		setAttrVal("Id_ry_diagnosis", Id_ry_diagnosis);
	}
	/**
	 * 入院诊断编码
	 * @return String
	 */
	public String getSd_ry_diagnosis() {
		return ((String) getAttrVal("Sd_ry_diagnosis"));
	}	
	/**
	 * 入院诊断编码
	 * @param Sd_ry_diagnosis
	 */
	public void setSd_ry_diagnosis(String Sd_ry_diagnosis) {
		setAttrVal("Sd_ry_diagnosis", Sd_ry_diagnosis);
	}
	/**
	 * 入院诊断名称
	 * @return String
	 */
	public String getName_ry_diagnosis() {
		return ((String) getAttrVal("Name_ry_diagnosis"));
	}	
	/**
	 * 入院诊断名称
	 * @param Name_ry_diagnosis
	 */
	public void setName_ry_diagnosis(String Name_ry_diagnosis) {
		setAttrVal("Name_ry_diagnosis", Name_ry_diagnosis);
	}
	/**
	 * 出院日期
	 * @return FDate
	 */
	public FDate getDischarge_date() {
		return ((FDate) getAttrVal("Discharge_date"));
	}	
	/**
	 * 出院日期
	 * @param Discharge_date
	 */
	public void setDischarge_date(FDate Discharge_date) {
		setAttrVal("Discharge_date", Discharge_date);
	}
	/**
	 * 出院诊断
	 * @return String
	 */
	public String getId_cy_diagnosis() {
		return ((String) getAttrVal("Id_cy_diagnosis"));
	}	
	/**
	 * 出院诊断
	 * @param Id_cy_diagnosis
	 */
	public void setId_cy_diagnosis(String Id_cy_diagnosis) {
		setAttrVal("Id_cy_diagnosis", Id_cy_diagnosis);
	}
	/**
	 * 出院诊断编码
	 * @return String
	 */
	public String getSd_cy_diagnosis() {
		return ((String) getAttrVal("Sd_cy_diagnosis"));
	}	
	/**
	 * 出院诊断编码
	 * @param Sd_cy_diagnosis
	 */
	public void setSd_cy_diagnosis(String Sd_cy_diagnosis) {
		setAttrVal("Sd_cy_diagnosis", Sd_cy_diagnosis);
	}
	/**
	 * 出院诊断名称
	 * @return String
	 */
	public String getName_cy_diagnosis() {
		return ((String) getAttrVal("Name_cy_diagnosis"));
	}	
	/**
	 * 出院诊断名称
	 * @param Name_cy_diagnosis
	 */
	public void setName_cy_diagnosis(String Name_cy_diagnosis) {
		setAttrVal("Name_cy_diagnosis", Name_cy_diagnosis);
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
	 * 监测日期
	 * @return FDate
	 */
	public FDate getMonitor_date() {
		return ((FDate) getAttrVal("Monitor_date"));
	}	
	/**
	 * 监测日期
	 * @param Monitor_date
	 */
	public void setMonitor_date(FDate Monitor_date) {
		setAttrVal("Monitor_date", Monitor_date);
	}
	/**
	 * 疾病诊断
	 * @return String
	 */
	public String getId_di_diagnosis() {
		return ((String) getAttrVal("Id_di_diagnosis"));
	}	
	/**
	 * 疾病诊断
	 * @param Id_di_diagnosis
	 */
	public void setId_di_diagnosis(String Id_di_diagnosis) {
		setAttrVal("Id_di_diagnosis", Id_di_diagnosis);
	}
	/**
	 * 疾病诊断编码
	 * @return String
	 */
	public String getSd_di_diagnosis() {
		return ((String) getAttrVal("Sd_di_diagnosis"));
	}	
	/**
	 * 疾病诊断编码
	 * @param Sd_di_diagnosis
	 */
	public void setSd_di_diagnosis(String Sd_di_diagnosis) {
		setAttrVal("Sd_di_diagnosis", Sd_di_diagnosis);
	}
	/**
	 * 疾病诊断名称
	 * @return String
	 */
	public String getName_di_diagnosis() {
		return ((String) getAttrVal("Name_di_diagnosis"));
	}	
	/**
	 * 疾病诊断名称
	 * @param Name_di_diagnosis
	 */
	public void setName_di_diagnosis(String Name_di_diagnosis) {
		setAttrVal("Name_di_diagnosis", Name_di_diagnosis);
	}
	/**
	 * 疾病转归
	 * @return String
	 */
	public String getId_disease_outcome() {
		return ((String) getAttrVal("Id_disease_outcome"));
	}	
	/**
	 * 疾病转归
	 * @param Id_disease_outcome
	 */
	public void setId_disease_outcome(String Id_disease_outcome) {
		setAttrVal("Id_disease_outcome", Id_disease_outcome);
	}
	/**
	 * 疾病转归编码
	 * @return String
	 */
	public String getSd_disease_outcome() {
		return ((String) getAttrVal("Sd_disease_outcome"));
	}	
	/**
	 * 疾病转归编码
	 * @param Sd_disease_outcome
	 */
	public void setSd_disease_outcome(String Sd_disease_outcome) {
		setAttrVal("Sd_disease_outcome", Sd_disease_outcome);
	}
	/**
	 * 疾病转归名称
	 * @return String
	 */
	public String getName_disease_outcome() {
		return ((String) getAttrVal("Name_disease_outcome"));
	}	
	/**
	 * 疾病转归名称
	 * @param Name_disease_outcome
	 */
	public void setName_disease_outcome(String Name_disease_outcome) {
		setAttrVal("Name_disease_outcome", Name_disease_outcome);
	}
	/**
	 * 与死亡的关系
	 * @return String
	 */
	public String getId_rela_with_death() {
		return ((String) getAttrVal("Id_rela_with_death"));
	}	
	/**
	 * 与死亡的关系
	 * @param Id_rela_with_death
	 */
	public void setId_rela_with_death(String Id_rela_with_death) {
		setAttrVal("Id_rela_with_death", Id_rela_with_death);
	}
	/**
	 * 与死亡的关系编码
	 * @return String
	 */
	public String getSd_rela_with_death() {
		return ((String) getAttrVal("Sd_rela_with_death"));
	}	
	/**
	 * 与死亡的关系编码
	 * @param Sd_rela_with_death
	 */
	public void setSd_rela_with_death(String Sd_rela_with_death) {
		setAttrVal("Sd_rela_with_death", Sd_rela_with_death);
	}
	/**
	 * 与死亡的关系名称
	 * @return String
	 */
	public String getName_rela_with_death() {
		return ((String) getAttrVal("Name_rela_with_death"));
	}	
	/**
	 * 与死亡的关系名称
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
	 * 是否医院内感染
	 * @return String
	 */
	public String getId_ishos_infec() {
		return ((String) getAttrVal("Id_ishos_infec"));
	}	
	/**
	 * 是否医院内感染
	 * @param Id_ishos_infec
	 */
	public void setId_ishos_infec(String Id_ishos_infec) {
		setAttrVal("Id_ishos_infec", Id_ishos_infec);
	}
	/**
	 * 医院感染编码
	 * @return String
	 */
	public String getSd_ishos_infec() {
		return ((String) getAttrVal("Sd_ishos_infec"));
	}	
	/**
	 * 医院感染编码
	 * @param Sd_ishos_infec
	 */
	public void setSd_ishos_infec(String Sd_ishos_infec) {
		setAttrVal("Sd_ishos_infec", Sd_ishos_infec);
	}
	/**
	 * 医院感染名称
	 * @return String
	 */
	public String getName_ishos_infec() {
		return ((String) getAttrVal("Name_ishos_infec"));
	}	
	/**
	 * 医院感染名称
	 * @param Name_ishos_infec
	 */
	public void setName_ishos_infec(String Name_ishos_infec) {
		setAttrVal("Name_ishos_infec", Name_ishos_infec);
	}
	/**
	 * 是否随访
	 * @return String
	 */
	public String getId_is_investigation() {
		return ((String) getAttrVal("Id_is_investigation"));
	}	
	/**
	 * 是否随访
	 * @param Id_is_investigation
	 */
	public void setId_is_investigation(String Id_is_investigation) {
		setAttrVal("Id_is_investigation", Id_is_investigation);
	}
	/**
	 * 随访编码
	 * @return String
	 */
	public String getSd_is_investigation() {
		return ((String) getAttrVal("Sd_is_investigation"));
	}	
	/**
	 * 随访编码
	 * @param Sd_is_investigation
	 */
	public void setSd_is_investigation(String Sd_is_investigation) {
		setAttrVal("Sd_is_investigation", Sd_is_investigation);
	}
	/**
	 * 随访名称
	 * @return String
	 */
	public String getName_is_investigation() {
		return ((String) getAttrVal("Name_is_investigation"));
	}	
	/**
	 * 随访名称
	 * @param Name_is_investigation
	 */
	public void setName_is_investigation(String Name_is_investigation) {
		setAttrVal("Name_is_investigation", Name_is_investigation);
	}
	/**
	 * 随访方式
	 * @return String
	 */
	public String getId_investigation() {
		return ((String) getAttrVal("Id_investigation"));
	}	
	/**
	 * 随访方式
	 * @param Id_investigation
	 */
	public void setId_investigation(String Id_investigation) {
		setAttrVal("Id_investigation", Id_investigation);
	}
	/**
	 * 随访方式编码
	 * @return String
	 */
	public String getSd_investigation() {
		return ((String) getAttrVal("Sd_investigation"));
	}	
	/**
	 * 随访方式编码
	 * @param Sd_investigation
	 */
	public void setSd_investigation(String Sd_investigation) {
		setAttrVal("Sd_investigation", Sd_investigation);
	}
	/**
	 * 随访方式名称
	 * @return String
	 */
	public String getName_investigation() {
		return ((String) getAttrVal("Name_investigation"));
	}	
	/**
	 * 随访方式名称
	 * @param Name_investigation
	 */
	public void setName_investigation(String Name_investigation) {
		setAttrVal("Name_investigation", Name_investigation);
	}
	/**
	 * 在ICU治疗过
	 * @return FBoolean
	 */
	public FBoolean getIs_treatment_in_icu() {
		return ((FBoolean) getAttrVal("Is_treatment_in_icu"));
	}	
	/**
	 * 在ICU治疗过
	 * @param Is_treatment_in_icu
	 */
	public void setIs_treatment_in_icu(FBoolean Is_treatment_in_icu) {
		setAttrVal("Is_treatment_in_icu", Is_treatment_in_icu);
	}
	/**
	 * ICU科别
	 * @return String
	 */
	public String getId_icu_type() {
		return ((String) getAttrVal("Id_icu_type"));
	}	
	/**
	 * ICU科别
	 * @param Id_icu_type
	 */
	public void setId_icu_type(String Id_icu_type) {
		setAttrVal("Id_icu_type", Id_icu_type);
	}
	/**
	 * ICU科别编码
	 * @return String
	 */
	public String getSd_icu_type() {
		return ((String) getAttrVal("Sd_icu_type"));
	}	
	/**
	 * ICU科别编码
	 * @param Sd_icu_type
	 */
	public void setSd_icu_type(String Sd_icu_type) {
		setAttrVal("Sd_icu_type", Sd_icu_type);
	}
	/**
	 * ICU科别名称
	 * @return String
	 */
	public String getName_icu_type() {
		return ((String) getAttrVal("Name_icu_type"));
	}	
	/**
	 * ICU科别名称
	 * @param Name_icu_type
	 */
	public void setName_icu_type(String Name_icu_type) {
		setAttrVal("Name_icu_type", Name_icu_type);
	}
	/**
	 * 转入ICU时间
	 * @return FDateTime
	 */
	public FDateTime getHospital_occurrence_date() {
		return ((FDateTime) getAttrVal("Hospital_occurrence_date"));
	}	
	/**
	 * 转入ICU时间
	 * @param Hospital_occurrence_date
	 */
	public void setHospital_occurrence_date(FDateTime Hospital_occurrence_date) {
		setAttrVal("Hospital_occurrence_date", Hospital_occurrence_date);
	}
	/**
	 * 感染因素
	 * @return String
	 */
	public String getId_infection_factors() {
		return ((String) getAttrVal("Id_infection_factors"));
	}	
	/**
	 * 感染因素
	 * @param Id_infection_factors
	 */
	public void setId_infection_factors(String Id_infection_factors) {
		setAttrVal("Id_infection_factors", Id_infection_factors);
	}
	/**
	 * 感染因素编码
	 * @return String
	 */
	public String getSd_infection_factors() {
		return ((String) getAttrVal("Sd_infection_factors"));
	}	
	/**
	 * 感染因素编码
	 * @param Sd_infection_factors
	 */
	public void setSd_infection_factors(String Sd_infection_factors) {
		setAttrVal("Sd_infection_factors", Sd_infection_factors);
	}
	/**
	 * 感染因素名称
	 * @return String
	 */
	public String getName_infection_factors() {
		return ((String) getAttrVal("Name_infection_factors"));
	}	
	/**
	 * 感染因素名称
	 * @param Name_infection_factors
	 */
	public void setName_infection_factors(String Name_infection_factors) {
		setAttrVal("Name_infection_factors", Name_infection_factors);
	}
	/**
	 * 感染因素其它
	 * @return String
	 */
	public String getOther_infection_factors() {
		return ((String) getAttrVal("Other_infection_factors"));
	}	
	/**
	 * 感染因素其它
	 * @param Other_infection_factors
	 */
	public void setOther_infection_factors(String Other_infection_factors) {
		setAttrVal("Other_infection_factors", Other_infection_factors);
	}
	/**
	 * 是否有手术
	 * @return FBoolean
	 */
	public FBoolean getIs_surgery() {
		return ((FBoolean) getAttrVal("Is_surgery"));
	}	
	/**
	 * 是否有手术
	 * @param Is_surgery
	 */
	public void setIs_surgery(FBoolean Is_surgery) {
		setAttrVal("Is_surgery", Is_surgery);
	}
	/**
	 * 院内感染诊断依据
	 * @return String
	 */
	public String getDi_of_hosp_infection() {
		return ((String) getAttrVal("Di_of_hosp_infection"));
	}	
	/**
	 * 院内感染诊断依据
	 * @param Di_of_hosp_infection
	 */
	public void setDi_of_hosp_infection(String Di_of_hosp_infection) {
		setAttrVal("Di_of_hosp_infection", Di_of_hosp_infection);
	}
	/**
	 * 病原学检查
	 * @return FBoolean
	 */
	public FBoolean getIs_etiol_examination() {
		return ((FBoolean) getAttrVal("Is_etiol_examination"));
	}	
	/**
	 * 病原学检查
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
	 * 是否迟报
	 * @return FBoolean
	 */
	public FBoolean getIs_late() {
		return ((FBoolean) getAttrVal("Is_late"));
	}	
	/**
	 * 是否迟报
	 * @param Is_late
	 */
	public void setIs_late(FBoolean Is_late) {
		setAttrVal("Is_late", Is_late);
	}
	/**
	 * 填报人
	 * @return String
	 */
	public String getFill_in_person() {
		return ((String) getAttrVal("Fill_in_person"));
	}	
	/**
	 * 填报人
	 * @param Fill_in_person
	 */
	public void setFill_in_person(String Fill_in_person) {
		setAttrVal("Fill_in_person", Fill_in_person);
	}
	/**
	 * 填报日期
	 * @return FDate
	 */
	public FDate getFill_in_date() {
		return ((FDate) getAttrVal("Fill_in_date"));
	}	
	/**
	 * 填报日期
	 * @param Fill_in_date
	 */
	public void setFill_in_date(FDate Fill_in_date) {
		setAttrVal("Fill_in_date", Fill_in_date);
	}
	/**
	 * 院感上报标题
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	/**
	 * 院感上报标题
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 审签阶段
	 * @return String
	 */
	public String getId_stage() {
		return ((String) getAttrVal("Id_stage"));
	}	
	/**
	 * 审签阶段
	 * @param Id_stage
	 */
	public void setId_stage(String Id_stage) {
		setAttrVal("Id_stage", Id_stage);
	}
	/**
	 * 审签阶段编码
	 * @return String
	 */
	public String getSd_stage() {
		return ((String) getAttrVal("Sd_stage"));
	}	
	/**
	 * 审签阶段编码
	 * @param Sd_stage
	 */
	public void setSd_stage(String Sd_stage) {
		setAttrVal("Sd_stage", Sd_stage);
	}
	/**
	 * 审签阶段名称
	 * @return String
	 */
	public String getName_stage() {
		return ((String) getAttrVal("Name_stage"));
	}	
	/**
	 * 审签阶段名称
	 * @param Name_stage
	 */
	public void setName_stage(String Name_stage) {
		setAttrVal("Name_stage", Name_stage);
	}
	/**
	 * 驳回原因
	 * @return String
	 */
	public String getReject_reason() {
		return ((String) getAttrVal("Reject_reason"));
	}	
	/**
	 * 驳回原因
	 * @param Reject_reason
	 */
	public void setReject_reason(String Reject_reason) {
		setAttrVal("Reject_reason", Reject_reason);
	}
	/**
	 * 删除原因
	 * @return String
	 */
	public String getDelete_reason() {
		return ((String) getAttrVal("Delete_reason"));
	}	
	/**
	 * 删除原因
	 * @param Delete_reason
	 */
	public void setDelete_reason(String Delete_reason) {
		setAttrVal("Delete_reason", Delete_reason);
	}
	/**
	 * 删除人
	 * @return String
	 */
	public String getDeleteby() {
		return ((String) getAttrVal("Deleteby"));
	}	
	/**
	 * 删除人
	 * @param Deleteby
	 */
	public void setDeleteby(String Deleteby) {
		setAttrVal("Deleteby", Deleteby);
	}
	/**
	 * 删除人编码
	 * @return String
	 */
	public String getCode_deleteby() {
		return ((String) getAttrVal("Code_deleteby"));
	}	
	/**
	 * 删除人编码
	 * @param Code_deleteby
	 */
	public void setCode_deleteby(String Code_deleteby) {
		setAttrVal("Code_deleteby", Code_deleteby);
	}
	/**
	 * 删除人姓名
	 * @return String
	 */
	public String getName_deleteby() {
		return ((String) getAttrVal("Name_deleteby"));
	}	
	/**
	 * 删除人姓名
	 * @param Name_deleteby
	 */
	public void setName_deleteby(String Name_deleteby) {
		setAttrVal("Name_deleteby", Name_deleteby);
	}
	/**
	 * 删除时间
	 * @return FDateTime
	 */
	public FDateTime getDeletetime() {
		return ((FDateTime) getAttrVal("Deletetime"));
	}	
	/**
	 * 删除时间
	 * @param Deletetime
	 */
	public void setDeletetime(FDateTime Deletetime) {
		setAttrVal("Deletetime", Deletetime);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 随访方式备注
	 * @return String
	 */
	public String getOther_inversitagion_way() {
		return ((String) getAttrVal("Other_inversitagion_way"));
	}	
	/**
	 * 随访方式备注
	 * @param Other_inversitagion_way
	 */
	public void setOther_inversitagion_way(String Other_inversitagion_way) {
		setAttrVal("Other_inversitagion_way", Other_inversitagion_way);
	}
	/**
	 * 院感发生日期
	 * @return FDate
	 */
	public FDate getYgfsrq() {
		return ((FDate) getAttrVal("Ygfsrq"));
	}	
	/**
	 * 院感发生日期
	 * @param Ygfsrq
	 */
	public void setYgfsrq(FDate Ygfsrq) {
		setAttrVal("Ygfsrq", Ygfsrq);
	}
	/**
	 * 调查方式
	 * @return String
	 */
	public String getId_survey_mth() {
		return ((String) getAttrVal("Id_survey_mth"));
	}	
	/**
	 * 调查方式
	 * @param Id_survey_mth
	 */
	public void setId_survey_mth(String Id_survey_mth) {
		setAttrVal("Id_survey_mth", Id_survey_mth);
	}
	/**
	 * 调查方式编码
	 * @return String
	 */
	public String getSd_survey_mth() {
		return ((String) getAttrVal("Sd_survey_mth"));
	}	
	/**
	 * 调查方式编码
	 * @param Sd_survey_mth
	 */
	public void setSd_survey_mth(String Sd_survey_mth) {
		setAttrVal("Sd_survey_mth", Sd_survey_mth);
	}
	/**
	 * 调查方式名称
	 * @return String
	 */
	public String getName_survey_mth() {
		return ((String) getAttrVal("Name_survey_mth"));
	}	
	/**
	 * 调查方式名称
	 * @param Name_survey_mth
	 */
	public void setName_survey_mth(String Name_survey_mth) {
		setAttrVal("Name_survey_mth", Name_survey_mth);
	}
	/**
	 * 患者科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 患者科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 患者科室编码
	 * @return String
	 */
	public String getSd_dept() {
		return ((String) getAttrVal("Sd_dept"));
	}	
	/**
	 * 患者科室编码
	 * @param Sd_dept
	 */
	public void setSd_dept(String Sd_dept) {
		setAttrVal("Sd_dept", Sd_dept);
	}
	/**
	 * 患者科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 患者科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 患者病区
	 * @return String
	 */
	public String getId_dept_ns() {
		return ((String) getAttrVal("Id_dept_ns"));
	}	
	/**
	 * 患者病区
	 * @param Id_dept_ns
	 */
	public void setId_dept_ns(String Id_dept_ns) {
		setAttrVal("Id_dept_ns", Id_dept_ns);
	}
	/**
	 * 患者病区编码
	 * @return String
	 */
	public String getSd_dept_ns() {
		return ((String) getAttrVal("Sd_dept_ns"));
	}	
	/**
	 * 患者病区编码
	 * @param Sd_dept_ns
	 */
	public void setSd_dept_ns(String Sd_dept_ns) {
		setAttrVal("Sd_dept_ns", Sd_dept_ns);
	}
	/**
	 * 患者病区名称
	 * @return String
	 */
	public String getName_dept_ns() {
		return ((String) getAttrVal("Name_dept_ns"));
	}	
	/**
	 * 患者病区名称
	 * @param Name_dept_ns
	 */
	public void setName_dept_ns(String Name_dept_ns) {
		setAttrVal("Name_dept_ns", Name_dept_ns);
	}
	/**
	 * 患者床位
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 患者床位
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 患者床位编码
	 * @return String
	 */
	public String getSd_bed() {
		return ((String) getAttrVal("Sd_bed"));
	}	
	/**
	 * 患者床位编码
	 * @param Sd_bed
	 */
	public void setSd_bed(String Sd_bed) {
		setAttrVal("Sd_bed", Sd_bed);
	}
	/**
	 * 患者床位名称
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 患者床位名称
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 备用字段1
	 * @return String
	 */
	public String getBackup_filed1() {
		return ((String) getAttrVal("Backup_filed1"));
	}	
	/**
	 * 备用字段1
	 * @param Backup_filed1
	 */
	public void setBackup_filed1(String Backup_filed1) {
		setAttrVal("Backup_filed1", Backup_filed1);
	}
	/**
	 * 备用字段2
	 * @return String
	 */
	public String getBackup_filed2() {
		return ((String) getAttrVal("Backup_filed2"));
	}	
	/**
	 * 备用字段2
	 * @param Backup_filed2
	 */
	public void setBackup_filed2(String Backup_filed2) {
		setAttrVal("Backup_filed2", Backup_filed2);
	}
	/**
	 * 备用字段3
	 * @return String
	 */
	public String getBackup_filed3() {
		return ((String) getAttrVal("Backup_filed3"));
	}	
	/**
	 * 备用字段3
	 * @param Backup_filed3
	 */
	public void setBackup_filed3(String Backup_filed3) {
		setAttrVal("Backup_filed3", Backup_filed3);
	}
	/**
	 * 备用字段4
	 * @return String
	 */
	public String getBackup_filed4() {
		return ((String) getAttrVal("Backup_filed4"));
	}	
	/**
	 * 备用字段4
	 * @param Backup_filed4
	 */
	public void setBackup_filed4(String Backup_filed4) {
		setAttrVal("Backup_filed4", Backup_filed4);
	}
	/**
	 * 备用字段5
	 * @return String
	 */
	public String getBackup_filed5() {
		return ((String) getAttrVal("Backup_filed5"));
	}	
	/**
	 * 备用字段5
	 * @param Backup_filed5
	 */
	public void setBackup_filed5(String Backup_filed5) {
		setAttrVal("Backup_filed5", Backup_filed5);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}	
	/**
	 * 患者编码
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 患者性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 患者性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 患者性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 患者性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}	
	/**
	 * 患者年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
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
	 * 就诊编码
	 * @return String
	 */
	public String getSd_ent() {
		return ((String) getAttrVal("Sd_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Sd_ent
	 */
	public void setSd_ent(String Sd_ent) {
		setAttrVal("Sd_ent", Sd_ent);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_in_dept() {
		return ((String) getAttrVal("Id_in_dept"));
	}	
	/**
	 * 入院科室
	 * @param Id_in_dept
	 */
	public void setId_in_dept(String Id_in_dept) {
		setAttrVal("Id_in_dept", Id_in_dept);
	}
	/**
	 * 入院科室编码
	 * @return String
	 */
	public String getSd_in_dept() {
		return ((String) getAttrVal("Sd_in_dept"));
	}	
	/**
	 * 入院科室编码
	 * @param Sd_in_dept
	 */
	public void setSd_in_dept(String Sd_in_dept) {
		setAttrVal("Sd_in_dept", Sd_in_dept);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getName_in_dept() {
		return ((String) getAttrVal("Name_in_dept"));
	}	
	/**
	 * 入院科室名称
	 * @param Name_in_dept
	 */
	public void setName_in_dept(String Name_in_dept) {
		setAttrVal("Name_in_dept", Name_in_dept);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getId_in_dept_ns() {
		return ((String) getAttrVal("Id_in_dept_ns"));
	}	
	/**
	 * 入院病区
	 * @param Id_in_dept_ns
	 */
	public void setId_in_dept_ns(String Id_in_dept_ns) {
		setAttrVal("Id_in_dept_ns", Id_in_dept_ns);
	}
	/**
	 * 入院病区编码
	 * @return String
	 */
	public String getSd_in_dept_ns() {
		return ((String) getAttrVal("Sd_in_dept_ns"));
	}	
	/**
	 * 入院病区编码
	 * @param Sd_in_dept_ns
	 */
	public void setSd_in_dept_ns(String Sd_in_dept_ns) {
		setAttrVal("Sd_in_dept_ns", Sd_in_dept_ns);
	}
	/**
	 * 入院病区名称
	 * @return String
	 */
	public String getName_in_dept_ns() {
		return ((String) getAttrVal("Name_in_dept_ns"));
	}	
	/**
	 * 入院病区名称
	 * @param Name_in_dept_ns
	 */
	public void setName_in_dept_ns(String Name_in_dept_ns) {
		setAttrVal("Name_in_dept_ns", Name_in_dept_ns);
	}
	/**
	 * 填报人科室
	 * @return String
	 */
	public String getId_fill_in_dept() {
		return ((String) getAttrVal("Id_fill_in_dept"));
	}	
	/**
	 * 填报人科室
	 * @param Id_fill_in_dept
	 */
	public void setId_fill_in_dept(String Id_fill_in_dept) {
		setAttrVal("Id_fill_in_dept", Id_fill_in_dept);
	}
	/**
	 * 填报人科室编码
	 * @return String
	 */
	public String getSd_fill_in_dept() {
		return ((String) getAttrVal("Sd_fill_in_dept"));
	}	
	/**
	 * 填报人科室编码
	 * @param Sd_fill_in_dept
	 */
	public void setSd_fill_in_dept(String Sd_fill_in_dept) {
		setAttrVal("Sd_fill_in_dept", Sd_fill_in_dept);
	}
	/**
	 * 填报人科室名称
	 * @return String
	 */
	public String getName_fill_in_dept() {
		return ((String) getAttrVal("Name_fill_in_dept"));
	}	
	/**
	 * 填报人科室名称
	 * @param Name_fill_in_dept
	 */
	public void setName_fill_in_dept(String Name_fill_in_dept) {
		setAttrVal("Name_fill_in_dept", Name_fill_in_dept);
	}
	/**
	 * 与感染部分相关侵袭性操作
	 * @return String
	 */
	public String getId_inva_oper_site() {
		return ((String) getAttrVal("Id_inva_oper_site"));
	}	
	/**
	 * 与感染部分相关侵袭性操作
	 * @param Id_inva_oper_site
	 */
	public void setId_inva_oper_site(String Id_inva_oper_site) {
		setAttrVal("Id_inva_oper_site", Id_inva_oper_site);
	}
	/**
	 * 与感染部分相关侵袭性操作编码
	 * @return String
	 */
	public String getSd_inva_oper_site() {
		return ((String) getAttrVal("Sd_inva_oper_site"));
	}	
	/**
	 * 与感染部分相关侵袭性操作编码
	 * @param Sd_inva_oper_site
	 */
	public void setSd_inva_oper_site(String Sd_inva_oper_site) {
		setAttrVal("Sd_inva_oper_site", Sd_inva_oper_site);
	}
	/**
	 * 与感染部分相关侵袭性操作名称
	 * @return String
	 */
	public String getName_inva_oper_site() {
		return ((String) getAttrVal("Name_inva_oper_site"));
	}	
	/**
	 * 与感染部分相关侵袭性操作名称
	 * @param Name_inva_oper_site
	 */
	public void setName_inva_oper_site(String Name_inva_oper_site) {
		setAttrVal("Name_inva_oper_site", Name_inva_oper_site);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getRy_diagnosis_code() {
		return ((String) getAttrVal("Ry_diagnosis_code"));
	}	
	/**
	 * 诊断编码
	 * @param Ry_diagnosis_code
	 */
	public void setRy_diagnosis_code(String Ry_diagnosis_code) {
		setAttrVal("Ry_diagnosis_code", Ry_diagnosis_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getRy_diagnosis_name() {
		return ((String) getAttrVal("Ry_diagnosis_name"));
	}	
	/**
	 * 诊断名称
	 * @param Ry_diagnosis_name
	 */
	public void setRy_diagnosis_name(String Ry_diagnosis_name) {
		setAttrVal("Ry_diagnosis_name", Ry_diagnosis_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCy_diagnosis_code() {
		return ((String) getAttrVal("Cy_diagnosis_code"));
	}	
	/**
	 * 诊断编码
	 * @param Cy_diagnosis_code
	 */
	public void setCy_diagnosis_code(String Cy_diagnosis_code) {
		setAttrVal("Cy_diagnosis_code", Cy_diagnosis_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getCy_iagnosis_name() {
		return ((String) getAttrVal("Cy_iagnosis_name"));
	}	
	/**
	 * 诊断名称
	 * @param Cy_iagnosis_name
	 */
	public void setCy_iagnosis_name(String Cy_iagnosis_name) {
		setAttrVal("Cy_iagnosis_name", Cy_iagnosis_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDi_diagnosis_code() {
		return ((String) getAttrVal("Di_diagnosis_code"));
	}	
	/**
	 * 诊断编码
	 * @param Di_diagnosis_code
	 */
	public void setDi_diagnosis_code(String Di_diagnosis_code) {
		setAttrVal("Di_diagnosis_code", Di_diagnosis_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_diagnosis_name() {
		return ((String) getAttrVal("Di_diagnosis_name"));
	}	
	/**
	 * 诊断名称
	 * @param Di_diagnosis_name
	 */
	public void setDi_diagnosis_name(String Di_diagnosis_name) {
		setAttrVal("Di_diagnosis_name", Di_diagnosis_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDisease_outcome_code() {
		return ((String) getAttrVal("Disease_outcome_code"));
	}	
	/**
	 * 编码
	 * @param Disease_outcome_code
	 */
	public void setDisease_outcome_code(String Disease_outcome_code) {
		setAttrVal("Disease_outcome_code", Disease_outcome_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDisease_outcome_name() {
		return ((String) getAttrVal("Disease_outcome_name"));
	}	
	/**
	 * 名称
	 * @param Disease_outcome_name
	 */
	public void setDisease_outcome_name(String Disease_outcome_name) {
		setAttrVal("Disease_outcome_name", Disease_outcome_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRelationship_with_death_code() {
		return ((String) getAttrVal("Relationship_with_death_code"));
	}	
	/**
	 * 编码
	 * @param Relationship_with_death_code
	 */
	public void setRelationship_with_death_code(String Relationship_with_death_code) {
		setAttrVal("Relationship_with_death_code", Relationship_with_death_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRelationship_with_death_name() {
		return ((String) getAttrVal("Relationship_with_death_name"));
	}	
	/**
	 * 名称
	 * @param Relationship_with_death_name
	 */
	public void setRelationship_with_death_name(String Relationship_with_death_name) {
		setAttrVal("Relationship_with_death_name", Relationship_with_death_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInhos_infec_code() {
		return ((String) getAttrVal("Inhos_infec_code"));
	}	
	/**
	 * 编码
	 * @param Inhos_infec_code
	 */
	public void setInhos_infec_code(String Inhos_infec_code) {
		setAttrVal("Inhos_infec_code", Inhos_infec_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInhos_infec_name() {
		return ((String) getAttrVal("Inhos_infec_name"));
	}	
	/**
	 * 名称
	 * @param Inhos_infec_name
	 */
	public void setInhos_infec_name(String Inhos_infec_name) {
		setAttrVal("Inhos_infec_name", Inhos_infec_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInvestigation_code() {
		return ((String) getAttrVal("Investigation_code"));
	}	
	/**
	 * 编码
	 * @param Investigation_code
	 */
	public void setInvestigation_code(String Investigation_code) {
		setAttrVal("Investigation_code", Investigation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInvestigation_name() {
		return ((String) getAttrVal("Investigation_name"));
	}	
	/**
	 * 名称
	 * @param Investigation_name
	 */
	public void setInvestigation_name(String Investigation_name) {
		setAttrVal("Investigation_name", Investigation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInvestiga_code() {
		return ((String) getAttrVal("Investiga_code"));
	}	
	/**
	 * 编码
	 * @param Investiga_code
	 */
	public void setInvestiga_code(String Investiga_code) {
		setAttrVal("Investiga_code", Investiga_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInvestiga_name() {
		return ((String) getAttrVal("Investiga_name"));
	}	
	/**
	 * 名称
	 * @param Investiga_name
	 */
	public void setInvestiga_name(String Investiga_name) {
		setAttrVal("Investiga_name", Investiga_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIcu_type_code() {
		return ((String) getAttrVal("Icu_type_code"));
	}	
	/**
	 * 编码
	 * @param Icu_type_code
	 */
	public void setIcu_type_code(String Icu_type_code) {
		setAttrVal("Icu_type_code", Icu_type_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIcu_type_name() {
		return ((String) getAttrVal("Icu_type_name"));
	}	
	/**
	 * 名称
	 * @param Icu_type_name
	 */
	public void setIcu_type_name(String Icu_type_name) {
		setAttrVal("Icu_type_name", Icu_type_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInfection_factors_code() {
		return ((String) getAttrVal("Infection_factors_code"));
	}	
	/**
	 * 编码
	 * @param Infection_factors_code
	 */
	public void setInfection_factors_code(String Infection_factors_code) {
		setAttrVal("Infection_factors_code", Infection_factors_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInfection_factors_name() {
		return ((String) getAttrVal("Infection_factors_name"));
	}	
	/**
	 * 名称
	 * @param Infection_factors_name
	 */
	public void setInfection_factors_name(String Infection_factors_name) {
		setAttrVal("Infection_factors_name", Infection_factors_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getStage_code() {
		return ((String) getAttrVal("Stage_code"));
	}	
	/**
	 * 编码
	 * @param Stage_code
	 */
	public void setStage_code(String Stage_code) {
		setAttrVal("Stage_code", Stage_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getStage_name() {
		return ((String) getAttrVal("Stage_name"));
	}	
	/**
	 * 名称
	 * @param Stage_name
	 */
	public void setStage_name(String Stage_name) {
		setAttrVal("Stage_name", Stage_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getDeleteby_code() {
		return ((String) getAttrVal("Deleteby_code"));
	}	
	/**
	 * 人员编码
	 * @param Deleteby_code
	 */
	public void setDeleteby_code(String Deleteby_code) {
		setAttrVal("Deleteby_code", Deleteby_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getDeleteby_name() {
		return ((String) getAttrVal("Deleteby_name"));
	}	
	/**
	 * 姓名
	 * @param Deleteby_name
	 */
	public void setDeleteby_name(String Deleteby_name) {
		setAttrVal("Deleteby_name", Deleteby_name);
	}
	/**
	 * 调查方式编码
	 * @return String
	 */
	public String getSurvey_mth_code() {
		return ((String) getAttrVal("Survey_mth_code"));
	}	
	/**
	 * 调查方式编码
	 * @param Survey_mth_code
	 */
	public void setSurvey_mth_code(String Survey_mth_code) {
		setAttrVal("Survey_mth_code", Survey_mth_code);
	}
	/**
	 * 调查方式名称
	 * @return String
	 */
	public String getSurvey_mth_name() {
		return ((String) getAttrVal("Survey_mth_name"));
	}	
	/**
	 * 调查方式名称
	 * @param Survey_mth_name
	 */
	public void setSurvey_mth_name(String Survey_mth_name) {
		setAttrVal("Survey_mth_name", Survey_mth_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDept_ns_code() {
		return ((String) getAttrVal("Dept_ns_code"));
	}	
	/**
	 * 编码
	 * @param Dept_ns_code
	 */
	public void setDept_ns_code(String Dept_ns_code) {
		setAttrVal("Dept_ns_code", Dept_ns_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDept_ns_name() {
		return ((String) getAttrVal("Dept_ns_name"));
	}	
	/**
	 * 名称
	 * @param Dept_ns_name
	 */
	public void setDept_ns_name(String Dept_ns_name) {
		setAttrVal("Dept_ns_name", Dept_ns_name);
	}
	/**
	 * 床位编码
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}	
	/**
	 * 床位编码
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	/**
	 * 床位名称
	 * @return String
	 */
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}	
	/**
	 * 床位名称
	 * @param Bed_name
	 */
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	/**
	 * 编码
	 * @param Sex_code
	 */
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	/**
	 * 名称
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIn_dept_code() {
		return ((String) getAttrVal("In_dept_code"));
	}	
	/**
	 * 编码
	 * @param In_dept_code
	 */
	public void setIn_dept_code(String In_dept_code) {
		setAttrVal("In_dept_code", In_dept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIn_dept_name() {
		return ((String) getAttrVal("In_dept_name"));
	}	
	/**
	 * 名称
	 * @param In_dept_name
	 */
	public void setIn_dept_name(String In_dept_name) {
		setAttrVal("In_dept_name", In_dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIn_dept_ns_code() {
		return ((String) getAttrVal("In_dept_ns_code"));
	}	
	/**
	 * 编码
	 * @param In_dept_ns_code
	 */
	public void setIn_dept_ns_code(String In_dept_ns_code) {
		setAttrVal("In_dept_ns_code", In_dept_ns_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIn_dept_ns_name() {
		return ((String) getAttrVal("In_dept_ns_name"));
	}	
	/**
	 * 名称
	 * @param In_dept_ns_name
	 */
	public void setIn_dept_ns_name(String In_dept_ns_name) {
		setAttrVal("In_dept_ns_name", In_dept_ns_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getFill_in_dept_code() {
		return ((String) getAttrVal("Fill_in_dept_code"));
	}	
	/**
	 * 编码
	 * @param Fill_in_dept_code
	 */
	public void setFill_in_dept_code(String Fill_in_dept_code) {
		setAttrVal("Fill_in_dept_code", Fill_in_dept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFill_in_dept_name() {
		return ((String) getAttrVal("Fill_in_dept_name"));
	}	
	/**
	 * 名称
	 * @param Fill_in_dept_name
	 */
	public void setFill_in_dept_name(String Fill_in_dept_name) {
		setAttrVal("Fill_in_dept_name", Fill_in_dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInva_oper_site_code() {
		return ((String) getAttrVal("Inva_oper_site_code"));
	}	
	/**
	 * 编码
	 * @param Inva_oper_site_code
	 */
	public void setInva_oper_site_code(String Inva_oper_site_code) {
		setAttrVal("Inva_oper_site_code", Inva_oper_site_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInva_oper_site_name() {
		return ((String) getAttrVal("Inva_oper_site_name"));
	}	
	/**
	 * 名称
	 * @param Inva_oper_site_name
	 */
	public void setInva_oper_site_name(String Inva_oper_site_name) {
		setAttrVal("Inva_oper_site_name", Inva_oper_site_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_hospitalreport";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_HOS_REPORT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HospitalReportDODesc.class);
	}
	
}