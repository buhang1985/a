package iih.ci.rcm.infectionrate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.infectionrate.d.desc.InfectionRateDODesc;
import java.math.BigDecimal;

/**
 * 医院感染现患率 DO数据 
 * 
 */
public class InfectionRateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医院感染现患率主键
	public static final String ID_MMRATEHOSPITALINFECTION= "Id_mmratehospitalinfection";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//患者
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String CODE_PAT= "Code_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//病历号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//床位号
	public static final String NAME_BED= "Name_bed";
	//科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//科室编码
	public static final String SD_DEP_PHY= "Sd_dep_phy";
	//科室名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//调查时间
	public static final String INVESTTIME= "Investtime";
	//调查者
	public static final String ID_PSN= "Id_psn";
	//HBsAg阳性
	public static final String ID_HBSAG_POSITIVE= "Id_hbsag_positive";
	//HBsAg阳性编码
	public static final String SD_HBSAG_POSITIVE= "Sd_hbsag_positive";
	//HBsAg阳性名称
	public static final String NAME_HBSAG_POSITIVE= "Name_hbsag_positive";
	//抗HCV阳性
	public static final String ID_HCV_POSITIVE= "Id_hcv_positive";
	//抗HCV阳性编码
	public static final String SD_HCV_POSITIVE= "Sd_hcv_positive";
	//抗HCV阳性名称
	public static final String NAME_HCV_POSITIVE= "Name_hcv_positive";
	//抗HIV阳性
	public static final String ID_HIV_POSITIVE= "Id_hiv_positive";
	//抗HIV阳性编码
	public static final String SD_HIV_POSITIVE= "Sd_hiv_positive";
	//抗HIV阳性名称
	public static final String NAME_HIV_POSITIVE= "Name_hiv_positive";
	//医院感染
	public static final String NOSO_INFECTION= "Noso_infection";
	//抗菌药物使用
	public static final String ANTIBIOTICS_USE= "Antibiotics_use";
	//静脉输液
	public static final String INTRAVENOUS= "Intravenous";
	//多次腹泻
	public static final String DIARRHOEA= "Diarrhoea";
	//细菌培养
	public static final String BACT_CULTURE= "Bact_culture";
	//动静脉插管
	public static final String ARTE_INTUBATION= "Arte_intubation";
	//泌尿道插管
	public static final String URIN_INTUBATTON= "Urin_intubatton";
	//使用呼吸机
	public static final String VENTILATOR_USE= "Ventilator_use";
	//手术
	public static final String OPERATION= "Operation";
	//术前应用抗生素
	public static final String PRE_USE_ANTIBIOTIC= "Pre_use_antibiotic";
	//外科手术期用药
	public static final String SURG_PHARMACY= "Surg_pharmacy";
	//目的
	public static final String ID_PURPOSE= "Id_purpose";
	//目的编码
	public static final String SD_PURPOSE= "Sd_purpose";
	//目的名称
	public static final String NAME_PURPOSE= "Name_purpose";
	//联用
	public static final String ID_COMBINED_USE= "Id_combined_use";
	//联用编码
	public static final String SD_COMBINED_USE= "Sd_combined_use";
	//联用名称
	public static final String NAME_COMBINED_USE= "Name_combined_use";
	//手术切口
	public static final String ID_SURG_INCISION= "Id_surg_incision";
	//手术切口编码
	public static final String SD_SURG_INCISION= "Sd_surg_incision";
	//手术切口名称
	public static final String NAME_SURG_INCISION= "Name_surg_incision";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String DEPT_CODE= "Dept_code";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String HBSAG_POSITIVE_CODE= "Hbsag_positive_code";
	//名称
	public static final String HBSAG_POSITIVE_NAME= "Hbsag_positive_name";
	//编码
	public static final String HCV_POSITIVE_CODE= "Hcv_positive_code";
	//名称
	public static final String HCV_POSITIVE_NAME= "Hcv_positive_name";
	//编码
	public static final String HIV_POSITIVE_CODE= "Hiv_positive_code";
	//名称
	public static final String HIV_POSITIVE_NAME= "Hiv_positive_name";
	//编码
	public static final String PURPOSE_CODE= "Purpose_code";
	//名称
	public static final String PURPOSE_NAME= "Purpose_name";
	//编码
	public static final String COMBINED_CODE= "Combined_code";
	//名称
	public static final String COMBINED_NAME= "Combined_name";
	//编码
	public static final String SUR_INCISION_CODE= "Sur_incision_code";
	//名称
	public static final String SUR_INCISION_NAME= "Sur_incision_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医院感染现患率主键
	 * @return String
	 */
	public String getId_mmratehospitalinfection() {
		return ((String) getAttrVal("Id_mmratehospitalinfection"));
	}	
	/**
	 * 医院感染现患率主键
	 * @param Id_mmratehospitalinfection
	 */
	public void setId_mmratehospitalinfection(String Id_mmratehospitalinfection) {
		setAttrVal("Id_mmratehospitalinfection", Id_mmratehospitalinfection);
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
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
	 * 调查时间
	 * @return FDateTime
	 */
	public FDateTime getInvesttime() {
		return ((FDateTime) getAttrVal("Investtime"));
	}	
	/**
	 * 调查时间
	 * @param Investtime
	 */
	public void setInvesttime(FDateTime Investtime) {
		setAttrVal("Investtime", Investtime);
	}
	/**
	 * 调查者
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}	
	/**
	 * 调查者
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * HBsAg阳性
	 * @return String
	 */
	public String getId_hbsag_positive() {
		return ((String) getAttrVal("Id_hbsag_positive"));
	}	
	/**
	 * HBsAg阳性
	 * @param Id_hbsag_positive
	 */
	public void setId_hbsag_positive(String Id_hbsag_positive) {
		setAttrVal("Id_hbsag_positive", Id_hbsag_positive);
	}
	/**
	 * HBsAg阳性编码
	 * @return String
	 */
	public String getSd_hbsag_positive() {
		return ((String) getAttrVal("Sd_hbsag_positive"));
	}	
	/**
	 * HBsAg阳性编码
	 * @param Sd_hbsag_positive
	 */
	public void setSd_hbsag_positive(String Sd_hbsag_positive) {
		setAttrVal("Sd_hbsag_positive", Sd_hbsag_positive);
	}
	/**
	 * HBsAg阳性名称
	 * @return String
	 */
	public String getName_hbsag_positive() {
		return ((String) getAttrVal("Name_hbsag_positive"));
	}	
	/**
	 * HBsAg阳性名称
	 * @param Name_hbsag_positive
	 */
	public void setName_hbsag_positive(String Name_hbsag_positive) {
		setAttrVal("Name_hbsag_positive", Name_hbsag_positive);
	}
	/**
	 * 抗HCV阳性
	 * @return String
	 */
	public String getId_hcv_positive() {
		return ((String) getAttrVal("Id_hcv_positive"));
	}	
	/**
	 * 抗HCV阳性
	 * @param Id_hcv_positive
	 */
	public void setId_hcv_positive(String Id_hcv_positive) {
		setAttrVal("Id_hcv_positive", Id_hcv_positive);
	}
	/**
	 * 抗HCV阳性编码
	 * @return String
	 */
	public String getSd_hcv_positive() {
		return ((String) getAttrVal("Sd_hcv_positive"));
	}	
	/**
	 * 抗HCV阳性编码
	 * @param Sd_hcv_positive
	 */
	public void setSd_hcv_positive(String Sd_hcv_positive) {
		setAttrVal("Sd_hcv_positive", Sd_hcv_positive);
	}
	/**
	 * 抗HCV阳性名称
	 * @return String
	 */
	public String getName_hcv_positive() {
		return ((String) getAttrVal("Name_hcv_positive"));
	}	
	/**
	 * 抗HCV阳性名称
	 * @param Name_hcv_positive
	 */
	public void setName_hcv_positive(String Name_hcv_positive) {
		setAttrVal("Name_hcv_positive", Name_hcv_positive);
	}
	/**
	 * 抗HIV阳性
	 * @return String
	 */
	public String getId_hiv_positive() {
		return ((String) getAttrVal("Id_hiv_positive"));
	}	
	/**
	 * 抗HIV阳性
	 * @param Id_hiv_positive
	 */
	public void setId_hiv_positive(String Id_hiv_positive) {
		setAttrVal("Id_hiv_positive", Id_hiv_positive);
	}
	/**
	 * 抗HIV阳性编码
	 * @return String
	 */
	public String getSd_hiv_positive() {
		return ((String) getAttrVal("Sd_hiv_positive"));
	}	
	/**
	 * 抗HIV阳性编码
	 * @param Sd_hiv_positive
	 */
	public void setSd_hiv_positive(String Sd_hiv_positive) {
		setAttrVal("Sd_hiv_positive", Sd_hiv_positive);
	}
	/**
	 * 抗HIV阳性名称
	 * @return String
	 */
	public String getName_hiv_positive() {
		return ((String) getAttrVal("Name_hiv_positive"));
	}	
	/**
	 * 抗HIV阳性名称
	 * @param Name_hiv_positive
	 */
	public void setName_hiv_positive(String Name_hiv_positive) {
		setAttrVal("Name_hiv_positive", Name_hiv_positive);
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
	 * 多次腹泻
	 * @return FBoolean
	 */
	public FBoolean getDiarrhoea() {
		return ((FBoolean) getAttrVal("Diarrhoea"));
	}	
	/**
	 * 多次腹泻
	 * @param Diarrhoea
	 */
	public void setDiarrhoea(FBoolean Diarrhoea) {
		setAttrVal("Diarrhoea", Diarrhoea);
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
	 * 联用
	 * @return String
	 */
	public String getId_combined_use() {
		return ((String) getAttrVal("Id_combined_use"));
	}	
	/**
	 * 联用
	 * @param Id_combined_use
	 */
	public void setId_combined_use(String Id_combined_use) {
		setAttrVal("Id_combined_use", Id_combined_use);
	}
	/**
	 * 联用编码
	 * @return String
	 */
	public String getSd_combined_use() {
		return ((String) getAttrVal("Sd_combined_use"));
	}	
	/**
	 * 联用编码
	 * @param Sd_combined_use
	 */
	public void setSd_combined_use(String Sd_combined_use) {
		setAttrVal("Sd_combined_use", Sd_combined_use);
	}
	/**
	 * 联用名称
	 * @return String
	 */
	public String getName_combined_use() {
		return ((String) getAttrVal("Name_combined_use"));
	}	
	/**
	 * 联用名称
	 * @param Name_combined_use
	 */
	public void setName_combined_use(String Name_combined_use) {
		setAttrVal("Name_combined_use", Name_combined_use);
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
	public String getHbsag_positive_code() {
		return ((String) getAttrVal("Hbsag_positive_code"));
	}	
	/**
	 * 编码
	 * @param Hbsag_positive_code
	 */
	public void setHbsag_positive_code(String Hbsag_positive_code) {
		setAttrVal("Hbsag_positive_code", Hbsag_positive_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHbsag_positive_name() {
		return ((String) getAttrVal("Hbsag_positive_name"));
	}	
	/**
	 * 名称
	 * @param Hbsag_positive_name
	 */
	public void setHbsag_positive_name(String Hbsag_positive_name) {
		setAttrVal("Hbsag_positive_name", Hbsag_positive_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHcv_positive_code() {
		return ((String) getAttrVal("Hcv_positive_code"));
	}	
	/**
	 * 编码
	 * @param Hcv_positive_code
	 */
	public void setHcv_positive_code(String Hcv_positive_code) {
		setAttrVal("Hcv_positive_code", Hcv_positive_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHcv_positive_name() {
		return ((String) getAttrVal("Hcv_positive_name"));
	}	
	/**
	 * 名称
	 * @param Hcv_positive_name
	 */
	public void setHcv_positive_name(String Hcv_positive_name) {
		setAttrVal("Hcv_positive_name", Hcv_positive_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHiv_positive_code() {
		return ((String) getAttrVal("Hiv_positive_code"));
	}	
	/**
	 * 编码
	 * @param Hiv_positive_code
	 */
	public void setHiv_positive_code(String Hiv_positive_code) {
		setAttrVal("Hiv_positive_code", Hiv_positive_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHiv_positive_name() {
		return ((String) getAttrVal("Hiv_positive_name"));
	}	
	/**
	 * 名称
	 * @param Hiv_positive_name
	 */
	public void setHiv_positive_name(String Hiv_positive_name) {
		setAttrVal("Hiv_positive_name", Hiv_positive_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPurpose_code() {
		return ((String) getAttrVal("Purpose_code"));
	}	
	/**
	 * 编码
	 * @param Purpose_code
	 */
	public void setPurpose_code(String Purpose_code) {
		setAttrVal("Purpose_code", Purpose_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPurpose_name() {
		return ((String) getAttrVal("Purpose_name"));
	}	
	/**
	 * 名称
	 * @param Purpose_name
	 */
	public void setPurpose_name(String Purpose_name) {
		setAttrVal("Purpose_name", Purpose_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCombined_code() {
		return ((String) getAttrVal("Combined_code"));
	}	
	/**
	 * 编码
	 * @param Combined_code
	 */
	public void setCombined_code(String Combined_code) {
		setAttrVal("Combined_code", Combined_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCombined_name() {
		return ((String) getAttrVal("Combined_name"));
	}	
	/**
	 * 名称
	 * @param Combined_name
	 */
	public void setCombined_name(String Combined_name) {
		setAttrVal("Combined_name", Combined_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSur_incision_code() {
		return ((String) getAttrVal("Sur_incision_code"));
	}	
	/**
	 * 编码
	 * @param Sur_incision_code
	 */
	public void setSur_incision_code(String Sur_incision_code) {
		setAttrVal("Sur_incision_code", Sur_incision_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSur_incision_name() {
		return ((String) getAttrVal("Sur_incision_name"));
	}	
	/**
	 * 名称
	 * @param Sur_incision_name
	 */
	public void setSur_incision_name(String Sur_incision_name) {
		setAttrVal("Sur_incision_name", Sur_incision_name);
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
		return "Id_mmratehospitalinfection";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_infectrate";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InfectionRateDODesc.class);
	}
	
}