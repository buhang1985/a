package iih.ci.rcm.au.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.au.d.desc.AntibioticUseDODesc;
import java.math.BigDecimal;

/**
 * 抗菌用药 DO数据 
 * 
 */
public class AntibioticUseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//抗菌用药主键ID
	public static final String ID_AU= "Id_au";
	//院感上报主卡主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//药物不良反应
	public static final String ADV_DRUG_REACTIONS= "Adv_drug_reactions";
	//药物不良反应编码
	public static final String SD_ADV_DRUG_REACTIONS= "Sd_adv_drug_reactions";
	//药物不良反应名称
	public static final String NAME_ADV_DRUG_REACTIONS= "Name_adv_drug_reactions";
	//二重感染
	public static final String DOUBLE_INFECTION= "Double_infection";
	//二重感染编码
	public static final String SD_DOUBLE_INFECTION= "Sd_double_infection";
	//二重感染名称
	public static final String NAME_DOUBLE_INFECTION= "Name_double_infection";
	//用途
	public static final String DRUGWAY= "Drugway";
	//用途编码
	public static final String SD_DRUGWAY= "Sd_drugway";
	//用途名称
	public static final String NAME_DRUGWAY= "Name_drugway";
	//药物分类
	public static final String DRUG_CLASSIFY= "Drug_classify";
	//药物分类编码
	public static final String SD_DRUG_CLASSIFY= "Sd_drug_classify";
	//药物分类名称
	public static final String NAME_DRUG_CLASSIFY= "Name_drug_classify";
	//药名（化学名）
	public static final String ID_DRUG= "Id_drug";
	//药名（化学名）编码
	public static final String SD_DRUG= "Sd_drug";
	//药名（化学名）名称
	public static final String NAME_DRUG= "Name_drug";
	//给药途径
	public static final String ID_ROUTE_ADMINIS= "Id_route_adminis";
	//给药途径编码
	public static final String SD_ROUTE_ADMINIS= "Sd_route_adminis";
	//给药途径名称
	public static final String NAME_ROUTE_ADMINIS= "Name_route_adminis";
	//剂量
	public static final String DOSE= "Dose";
	//剂量单位
	public static final String ID_DOSE_UNIT= "Id_dose_unit";
	//剂量单位编码
	public static final String SD_DOSE_UNIT= "Sd_dose_unit";
	//剂量单位名称
	public static final String NAME_DOSE_UNIT= "Name_dose_unit";
	//用法
	public static final String USAGE= "Usage";
	//单位
	public static final String DRUG_UNIT= "Drug_unit";
	//单位编码
	public static final String SD_DRUG_UNIT= "Sd_drug_unit";
	//单位名称
	public static final String NAME_DRUG_UNIT= "Name_drug_unit";
	//起始时间
	public static final String DT_START= "Dt_start";
	//截至时间
	public static final String DT_END= "Dt_end";
	//用药天数
	public static final String DRUG_USED_DAYS= "Drug_used_days";
	//治疗用药方式
	public static final String ID_TREAT_METHODS= "Id_treat_methods";
	//治疗用药方式编码
	public static final String SD_TREAT_METHODS= "Sd_treat_methods";
	//治疗用药方式名称
	public static final String NAME_TREAT_METHODS= "Name_treat_methods";
	//术前用药时间
	public static final String PRE_MEDI_TIME= "Pre_medi_time";
	//术后用药天数
	public static final String DAYS_AFTER_OPER= "Days_after_oper";
	//目的
	public static final String ID_OBJECTIVE= "Id_objective";
	//目的编码
	public static final String SD_OBJECTIVE= "Sd_objective";
	//目的名称
	public static final String NAME_OBJECTIVE= "Name_objective";
	//联合用药
	public static final String ID_COM_MEDI= "Id_com_medi";
	//联合用药编码
	public static final String SD_COM_MEDI= "Sd_com_medi";
	//联合用药名称
	public static final String NAME_COM_MEDI= "Name_com_medi";
	//备用字段1
	public static final String BACKUP_FIELD1= "Backup_field1";
	//备用字段2
	public static final String BACKUP_FIELD2= "Backup_field2";
	//备用字段3
	public static final String BACKUP_FIELD3= "Backup_field3";
	//备用字段4
	public static final String BACKUP_FIELD4= "Backup_field4";
	//备用字段5
	public static final String BACKUP_FIELD5= "Backup_field5";
	//用药详情
	public static final String DRUG_USED_INFO= "Drug_used_info";
	//编码
	public static final String ADV_DRUG_REACTIONS_CODE= "Adv_drug_reactions_code";
	//名称
	public static final String ADV_DRUG_REACTIONS_NAME= "Adv_drug_reactions_name";
	//编码
	public static final String DOUBLE_INFECTION_CODE= "Double_infection_code";
	//名称
	public static final String DOUBLE_INFECTION_NAME= "Double_infection_name";
	//编码
	public static final String DRUGWAY_CODE= "Drugway_code";
	//名称
	public static final String DRUGWAY_NAME= "Drugway_name";
	//编码
	public static final String DRUG_CLASSIFY_CODE= "Drug_classify_code";
	//名称
	public static final String DRUG_CLASSIFY_NAME= "Drug_classify_name";
	//编码
	public static final String DRUG_CODE= "Drug_code";
	//名称
	public static final String DRUG_NAME= "Drug_name";
	//编码
	public static final String ROUTE_ADMINIS_CODE= "Route_adminis_code";
	//名称
	public static final String ROUTE_ADMINIS_NAME= "Route_adminis_name";
	//编码
	public static final String DOSE_UNIT_CODE= "Dose_unit_code";
	//名称
	public static final String DOSE_UNIT_NAME= "Dose_unit_name";
	//编码
	public static final String DRUG_UNIT_CODE= "Drug_unit_code";
	//名称
	public static final String DRUG_UNIT_NAME= "Drug_unit_name";
	//编码
	public static final String TREAT_METHODS_CODE= "Treat_methods_code";
	//名称
	public static final String TREAT_METHODS_NAME= "Treat_methods_name";
	//编码
	public static final String OBJECTIVE_CODE= "Objective_code";
	//名称
	public static final String OBJECTIVE_NAME= "Objective_name";
	//编码
	public static final String COM_MEDI_CODE= "Com_medi_code";
	//名称
	public static final String COM_MEDI_NAME= "Com_medi_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 抗菌用药主键ID
	 * @return String
	 */
	public String getId_au() {
		return ((String) getAttrVal("Id_au"));
	}	
	/**
	 * 抗菌用药主键ID
	 * @param Id_au
	 */
	public void setId_au(String Id_au) {
		setAttrVal("Id_au", Id_au);
	}
	/**
	 * 院感上报主卡主键
	 * @return String
	 */
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	/**
	 * 院感上报主卡主键
	 * @param Id_hospitalreport
	 */
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	/**
	 * 药物不良反应
	 * @return String
	 */
	public String getAdv_drug_reactions() {
		return ((String) getAttrVal("Adv_drug_reactions"));
	}	
	/**
	 * 药物不良反应
	 * @param Adv_drug_reactions
	 */
	public void setAdv_drug_reactions(String Adv_drug_reactions) {
		setAttrVal("Adv_drug_reactions", Adv_drug_reactions);
	}
	/**
	 * 药物不良反应编码
	 * @return String
	 */
	public String getSd_adv_drug_reactions() {
		return ((String) getAttrVal("Sd_adv_drug_reactions"));
	}	
	/**
	 * 药物不良反应编码
	 * @param Sd_adv_drug_reactions
	 */
	public void setSd_adv_drug_reactions(String Sd_adv_drug_reactions) {
		setAttrVal("Sd_adv_drug_reactions", Sd_adv_drug_reactions);
	}
	/**
	 * 药物不良反应名称
	 * @return String
	 */
	public String getName_adv_drug_reactions() {
		return ((String) getAttrVal("Name_adv_drug_reactions"));
	}	
	/**
	 * 药物不良反应名称
	 * @param Name_adv_drug_reactions
	 */
	public void setName_adv_drug_reactions(String Name_adv_drug_reactions) {
		setAttrVal("Name_adv_drug_reactions", Name_adv_drug_reactions);
	}
	/**
	 * 二重感染
	 * @return String
	 */
	public String getDouble_infection() {
		return ((String) getAttrVal("Double_infection"));
	}	
	/**
	 * 二重感染
	 * @param Double_infection
	 */
	public void setDouble_infection(String Double_infection) {
		setAttrVal("Double_infection", Double_infection);
	}
	/**
	 * 二重感染编码
	 * @return String
	 */
	public String getSd_double_infection() {
		return ((String) getAttrVal("Sd_double_infection"));
	}	
	/**
	 * 二重感染编码
	 * @param Sd_double_infection
	 */
	public void setSd_double_infection(String Sd_double_infection) {
		setAttrVal("Sd_double_infection", Sd_double_infection);
	}
	/**
	 * 二重感染名称
	 * @return String
	 */
	public String getName_double_infection() {
		return ((String) getAttrVal("Name_double_infection"));
	}	
	/**
	 * 二重感染名称
	 * @param Name_double_infection
	 */
	public void setName_double_infection(String Name_double_infection) {
		setAttrVal("Name_double_infection", Name_double_infection);
	}
	/**
	 * 用途
	 * @return String
	 */
	public String getDrugway() {
		return ((String) getAttrVal("Drugway"));
	}	
	/**
	 * 用途
	 * @param Drugway
	 */
	public void setDrugway(String Drugway) {
		setAttrVal("Drugway", Drugway);
	}
	/**
	 * 用途编码
	 * @return String
	 */
	public String getSd_drugway() {
		return ((String) getAttrVal("Sd_drugway"));
	}	
	/**
	 * 用途编码
	 * @param Sd_drugway
	 */
	public void setSd_drugway(String Sd_drugway) {
		setAttrVal("Sd_drugway", Sd_drugway);
	}
	/**
	 * 用途名称
	 * @return String
	 */
	public String getName_drugway() {
		return ((String) getAttrVal("Name_drugway"));
	}	
	/**
	 * 用途名称
	 * @param Name_drugway
	 */
	public void setName_drugway(String Name_drugway) {
		setAttrVal("Name_drugway", Name_drugway);
	}
	/**
	 * 药物分类
	 * @return String
	 */
	public String getDrug_classify() {
		return ((String) getAttrVal("Drug_classify"));
	}	
	/**
	 * 药物分类
	 * @param Drug_classify
	 */
	public void setDrug_classify(String Drug_classify) {
		setAttrVal("Drug_classify", Drug_classify);
	}
	/**
	 * 药物分类编码
	 * @return String
	 */
	public String getSd_drug_classify() {
		return ((String) getAttrVal("Sd_drug_classify"));
	}	
	/**
	 * 药物分类编码
	 * @param Sd_drug_classify
	 */
	public void setSd_drug_classify(String Sd_drug_classify) {
		setAttrVal("Sd_drug_classify", Sd_drug_classify);
	}
	/**
	 * 药物分类名称
	 * @return String
	 */
	public String getName_drug_classify() {
		return ((String) getAttrVal("Name_drug_classify"));
	}	
	/**
	 * 药物分类名称
	 * @param Name_drug_classify
	 */
	public void setName_drug_classify(String Name_drug_classify) {
		setAttrVal("Name_drug_classify", Name_drug_classify);
	}
	/**
	 * 药名（化学名）
	 * @return String
	 */
	public String getId_drug() {
		return ((String) getAttrVal("Id_drug"));
	}	
	/**
	 * 药名（化学名）
	 * @param Id_drug
	 */
	public void setId_drug(String Id_drug) {
		setAttrVal("Id_drug", Id_drug);
	}
	/**
	 * 药名（化学名）编码
	 * @return String
	 */
	public String getSd_drug() {
		return ((String) getAttrVal("Sd_drug"));
	}	
	/**
	 * 药名（化学名）编码
	 * @param Sd_drug
	 */
	public void setSd_drug(String Sd_drug) {
		setAttrVal("Sd_drug", Sd_drug);
	}
	/**
	 * 药名（化学名）名称
	 * @return String
	 */
	public String getName_drug() {
		return ((String) getAttrVal("Name_drug"));
	}	
	/**
	 * 药名（化学名）名称
	 * @param Name_drug
	 */
	public void setName_drug(String Name_drug) {
		setAttrVal("Name_drug", Name_drug);
	}
	/**
	 * 给药途径
	 * @return String
	 */
	public String getId_route_adminis() {
		return ((String) getAttrVal("Id_route_adminis"));
	}	
	/**
	 * 给药途径
	 * @param Id_route_adminis
	 */
	public void setId_route_adminis(String Id_route_adminis) {
		setAttrVal("Id_route_adminis", Id_route_adminis);
	}
	/**
	 * 给药途径编码
	 * @return String
	 */
	public String getSd_route_adminis() {
		return ((String) getAttrVal("Sd_route_adminis"));
	}	
	/**
	 * 给药途径编码
	 * @param Sd_route_adminis
	 */
	public void setSd_route_adminis(String Sd_route_adminis) {
		setAttrVal("Sd_route_adminis", Sd_route_adminis);
	}
	/**
	 * 给药途径名称
	 * @return String
	 */
	public String getName_route_adminis() {
		return ((String) getAttrVal("Name_route_adminis"));
	}	
	/**
	 * 给药途径名称
	 * @param Name_route_adminis
	 */
	public void setName_route_adminis(String Name_route_adminis) {
		setAttrVal("Name_route_adminis", Name_route_adminis);
	}
	/**
	 * 剂量
	 * @return String
	 */
	public String getDose() {
		return ((String) getAttrVal("Dose"));
	}	
	/**
	 * 剂量
	 * @param Dose
	 */
	public void setDose(String Dose) {
		setAttrVal("Dose", Dose);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getId_dose_unit() {
		return ((String) getAttrVal("Id_dose_unit"));
	}	
	/**
	 * 剂量单位
	 * @param Id_dose_unit
	 */
	public void setId_dose_unit(String Id_dose_unit) {
		setAttrVal("Id_dose_unit", Id_dose_unit);
	}
	/**
	 * 剂量单位编码
	 * @return String
	 */
	public String getSd_dose_unit() {
		return ((String) getAttrVal("Sd_dose_unit"));
	}	
	/**
	 * 剂量单位编码
	 * @param Sd_dose_unit
	 */
	public void setSd_dose_unit(String Sd_dose_unit) {
		setAttrVal("Sd_dose_unit", Sd_dose_unit);
	}
	/**
	 * 剂量单位名称
	 * @return String
	 */
	public String getName_dose_unit() {
		return ((String) getAttrVal("Name_dose_unit"));
	}	
	/**
	 * 剂量单位名称
	 * @param Name_dose_unit
	 */
	public void setName_dose_unit(String Name_dose_unit) {
		setAttrVal("Name_dose_unit", Name_dose_unit);
	}
	/**
	 * 用法
	 * @return Integer
	 */
	public Integer getUsage() {
		return ((Integer) getAttrVal("Usage"));
	}	
	/**
	 * 用法
	 * @param Usage
	 */
	public void setUsage(Integer Usage) {
		setAttrVal("Usage", Usage);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getDrug_unit() {
		return ((String) getAttrVal("Drug_unit"));
	}	
	/**
	 * 单位
	 * @param Drug_unit
	 */
	public void setDrug_unit(String Drug_unit) {
		setAttrVal("Drug_unit", Drug_unit);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getSd_drug_unit() {
		return ((String) getAttrVal("Sd_drug_unit"));
	}	
	/**
	 * 单位编码
	 * @param Sd_drug_unit
	 */
	public void setSd_drug_unit(String Sd_drug_unit) {
		setAttrVal("Sd_drug_unit", Sd_drug_unit);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_drug_unit() {
		return ((String) getAttrVal("Name_drug_unit"));
	}	
	/**
	 * 单位名称
	 * @param Name_drug_unit
	 */
	public void setName_drug_unit(String Name_drug_unit) {
		setAttrVal("Name_drug_unit", Name_drug_unit);
	}
	/**
	 * 起始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_start() {
		return ((FDateTime) getAttrVal("Dt_start"));
	}	
	/**
	 * 起始时间
	 * @param Dt_start
	 */
	public void setDt_start(FDateTime Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 截至时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 截至时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 用药天数
	 * @return Integer
	 */
	public Integer getDrug_used_days() {
		return ((Integer) getAttrVal("Drug_used_days"));
	}	
	/**
	 * 用药天数
	 * @param Drug_used_days
	 */
	public void setDrug_used_days(Integer Drug_used_days) {
		setAttrVal("Drug_used_days", Drug_used_days);
	}
	/**
	 * 治疗用药方式
	 * @return String
	 */
	public String getId_treat_methods() {
		return ((String) getAttrVal("Id_treat_methods"));
	}	
	/**
	 * 治疗用药方式
	 * @param Id_treat_methods
	 */
	public void setId_treat_methods(String Id_treat_methods) {
		setAttrVal("Id_treat_methods", Id_treat_methods);
	}
	/**
	 * 治疗用药方式编码
	 * @return String
	 */
	public String getSd_treat_methods() {
		return ((String) getAttrVal("Sd_treat_methods"));
	}	
	/**
	 * 治疗用药方式编码
	 * @param Sd_treat_methods
	 */
	public void setSd_treat_methods(String Sd_treat_methods) {
		setAttrVal("Sd_treat_methods", Sd_treat_methods);
	}
	/**
	 * 治疗用药方式名称
	 * @return String
	 */
	public String getName_treat_methods() {
		return ((String) getAttrVal("Name_treat_methods"));
	}	
	/**
	 * 治疗用药方式名称
	 * @param Name_treat_methods
	 */
	public void setName_treat_methods(String Name_treat_methods) {
		setAttrVal("Name_treat_methods", Name_treat_methods);
	}
	/**
	 * 术前用药时间
	 * @return FDateTime
	 */
	public FDateTime getPre_medi_time() {
		return ((FDateTime) getAttrVal("Pre_medi_time"));
	}	
	/**
	 * 术前用药时间
	 * @param Pre_medi_time
	 */
	public void setPre_medi_time(FDateTime Pre_medi_time) {
		setAttrVal("Pre_medi_time", Pre_medi_time);
	}
	/**
	 * 术后用药天数
	 * @return Integer
	 */
	public Integer getDays_after_oper() {
		return ((Integer) getAttrVal("Days_after_oper"));
	}	
	/**
	 * 术后用药天数
	 * @param Days_after_oper
	 */
	public void setDays_after_oper(Integer Days_after_oper) {
		setAttrVal("Days_after_oper", Days_after_oper);
	}
	/**
	 * 目的
	 * @return String
	 */
	public String getId_objective() {
		return ((String) getAttrVal("Id_objective"));
	}	
	/**
	 * 目的
	 * @param Id_objective
	 */
	public void setId_objective(String Id_objective) {
		setAttrVal("Id_objective", Id_objective);
	}
	/**
	 * 目的编码
	 * @return String
	 */
	public String getSd_objective() {
		return ((String) getAttrVal("Sd_objective"));
	}	
	/**
	 * 目的编码
	 * @param Sd_objective
	 */
	public void setSd_objective(String Sd_objective) {
		setAttrVal("Sd_objective", Sd_objective);
	}
	/**
	 * 目的名称
	 * @return String
	 */
	public String getName_objective() {
		return ((String) getAttrVal("Name_objective"));
	}	
	/**
	 * 目的名称
	 * @param Name_objective
	 */
	public void setName_objective(String Name_objective) {
		setAttrVal("Name_objective", Name_objective);
	}
	/**
	 * 联合用药
	 * @return String
	 */
	public String getId_com_medi() {
		return ((String) getAttrVal("Id_com_medi"));
	}	
	/**
	 * 联合用药
	 * @param Id_com_medi
	 */
	public void setId_com_medi(String Id_com_medi) {
		setAttrVal("Id_com_medi", Id_com_medi);
	}
	/**
	 * 联合用药编码
	 * @return String
	 */
	public String getSd_com_medi() {
		return ((String) getAttrVal("Sd_com_medi"));
	}	
	/**
	 * 联合用药编码
	 * @param Sd_com_medi
	 */
	public void setSd_com_medi(String Sd_com_medi) {
		setAttrVal("Sd_com_medi", Sd_com_medi);
	}
	/**
	 * 联合用药名称
	 * @return String
	 */
	public String getName_com_medi() {
		return ((String) getAttrVal("Name_com_medi"));
	}	
	/**
	 * 联合用药名称
	 * @param Name_com_medi
	 */
	public void setName_com_medi(String Name_com_medi) {
		setAttrVal("Name_com_medi", Name_com_medi);
	}
	/**
	 * 备用字段1
	 * @return String
	 */
	public String getBackup_field1() {
		return ((String) getAttrVal("Backup_field1"));
	}	
	/**
	 * 备用字段1
	 * @param Backup_field1
	 */
	public void setBackup_field1(String Backup_field1) {
		setAttrVal("Backup_field1", Backup_field1);
	}
	/**
	 * 备用字段2
	 * @return String
	 */
	public String getBackup_field2() {
		return ((String) getAttrVal("Backup_field2"));
	}	
	/**
	 * 备用字段2
	 * @param Backup_field2
	 */
	public void setBackup_field2(String Backup_field2) {
		setAttrVal("Backup_field2", Backup_field2);
	}
	/**
	 * 备用字段3
	 * @return String
	 */
	public String getBackup_field3() {
		return ((String) getAttrVal("Backup_field3"));
	}	
	/**
	 * 备用字段3
	 * @param Backup_field3
	 */
	public void setBackup_field3(String Backup_field3) {
		setAttrVal("Backup_field3", Backup_field3);
	}
	/**
	 * 备用字段4
	 * @return String
	 */
	public String getBackup_field4() {
		return ((String) getAttrVal("Backup_field4"));
	}	
	/**
	 * 备用字段4
	 * @param Backup_field4
	 */
	public void setBackup_field4(String Backup_field4) {
		setAttrVal("Backup_field4", Backup_field4);
	}
	/**
	 * 备用字段5
	 * @return String
	 */
	public String getBackup_field5() {
		return ((String) getAttrVal("Backup_field5"));
	}	
	/**
	 * 备用字段5
	 * @param Backup_field5
	 */
	public void setBackup_field5(String Backup_field5) {
		setAttrVal("Backup_field5", Backup_field5);
	}
	/**
	 * 用药详情
	 * @return String
	 */
	public String getDrug_used_info() {
		return ((String) getAttrVal("Drug_used_info"));
	}	
	/**
	 * 用药详情
	 * @param Drug_used_info
	 */
	public void setDrug_used_info(String Drug_used_info) {
		setAttrVal("Drug_used_info", Drug_used_info);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAdv_drug_reactions_code() {
		return ((String) getAttrVal("Adv_drug_reactions_code"));
	}	
	/**
	 * 编码
	 * @param Adv_drug_reactions_code
	 */
	public void setAdv_drug_reactions_code(String Adv_drug_reactions_code) {
		setAttrVal("Adv_drug_reactions_code", Adv_drug_reactions_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAdv_drug_reactions_name() {
		return ((String) getAttrVal("Adv_drug_reactions_name"));
	}	
	/**
	 * 名称
	 * @param Adv_drug_reactions_name
	 */
	public void setAdv_drug_reactions_name(String Adv_drug_reactions_name) {
		setAttrVal("Adv_drug_reactions_name", Adv_drug_reactions_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDouble_infection_code() {
		return ((String) getAttrVal("Double_infection_code"));
	}	
	/**
	 * 编码
	 * @param Double_infection_code
	 */
	public void setDouble_infection_code(String Double_infection_code) {
		setAttrVal("Double_infection_code", Double_infection_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDouble_infection_name() {
		return ((String) getAttrVal("Double_infection_name"));
	}	
	/**
	 * 名称
	 * @param Double_infection_name
	 */
	public void setDouble_infection_name(String Double_infection_name) {
		setAttrVal("Double_infection_name", Double_infection_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDrugway_code() {
		return ((String) getAttrVal("Drugway_code"));
	}	
	/**
	 * 编码
	 * @param Drugway_code
	 */
	public void setDrugway_code(String Drugway_code) {
		setAttrVal("Drugway_code", Drugway_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDrugway_name() {
		return ((String) getAttrVal("Drugway_name"));
	}	
	/**
	 * 名称
	 * @param Drugway_name
	 */
	public void setDrugway_name(String Drugway_name) {
		setAttrVal("Drugway_name", Drugway_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDrug_classify_code() {
		return ((String) getAttrVal("Drug_classify_code"));
	}	
	/**
	 * 编码
	 * @param Drug_classify_code
	 */
	public void setDrug_classify_code(String Drug_classify_code) {
		setAttrVal("Drug_classify_code", Drug_classify_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDrug_classify_name() {
		return ((String) getAttrVal("Drug_classify_name"));
	}	
	/**
	 * 名称
	 * @param Drug_classify_name
	 */
	public void setDrug_classify_name(String Drug_classify_name) {
		setAttrVal("Drug_classify_name", Drug_classify_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDrug_code() {
		return ((String) getAttrVal("Drug_code"));
	}	
	/**
	 * 编码
	 * @param Drug_code
	 */
	public void setDrug_code(String Drug_code) {
		setAttrVal("Drug_code", Drug_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDrug_name() {
		return ((String) getAttrVal("Drug_name"));
	}	
	/**
	 * 名称
	 * @param Drug_name
	 */
	public void setDrug_name(String Drug_name) {
		setAttrVal("Drug_name", Drug_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRoute_adminis_code() {
		return ((String) getAttrVal("Route_adminis_code"));
	}	
	/**
	 * 编码
	 * @param Route_adminis_code
	 */
	public void setRoute_adminis_code(String Route_adminis_code) {
		setAttrVal("Route_adminis_code", Route_adminis_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRoute_adminis_name() {
		return ((String) getAttrVal("Route_adminis_name"));
	}	
	/**
	 * 名称
	 * @param Route_adminis_name
	 */
	public void setRoute_adminis_name(String Route_adminis_name) {
		setAttrVal("Route_adminis_name", Route_adminis_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDose_unit_code() {
		return ((String) getAttrVal("Dose_unit_code"));
	}	
	/**
	 * 编码
	 * @param Dose_unit_code
	 */
	public void setDose_unit_code(String Dose_unit_code) {
		setAttrVal("Dose_unit_code", Dose_unit_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDose_unit_name() {
		return ((String) getAttrVal("Dose_unit_name"));
	}	
	/**
	 * 名称
	 * @param Dose_unit_name
	 */
	public void setDose_unit_name(String Dose_unit_name) {
		setAttrVal("Dose_unit_name", Dose_unit_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDrug_unit_code() {
		return ((String) getAttrVal("Drug_unit_code"));
	}	
	/**
	 * 编码
	 * @param Drug_unit_code
	 */
	public void setDrug_unit_code(String Drug_unit_code) {
		setAttrVal("Drug_unit_code", Drug_unit_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDrug_unit_name() {
		return ((String) getAttrVal("Drug_unit_name"));
	}	
	/**
	 * 名称
	 * @param Drug_unit_name
	 */
	public void setDrug_unit_name(String Drug_unit_name) {
		setAttrVal("Drug_unit_name", Drug_unit_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTreat_methods_code() {
		return ((String) getAttrVal("Treat_methods_code"));
	}	
	/**
	 * 编码
	 * @param Treat_methods_code
	 */
	public void setTreat_methods_code(String Treat_methods_code) {
		setAttrVal("Treat_methods_code", Treat_methods_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTreat_methods_name() {
		return ((String) getAttrVal("Treat_methods_name"));
	}	
	/**
	 * 名称
	 * @param Treat_methods_name
	 */
	public void setTreat_methods_name(String Treat_methods_name) {
		setAttrVal("Treat_methods_name", Treat_methods_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getObjective_code() {
		return ((String) getAttrVal("Objective_code"));
	}	
	/**
	 * 编码
	 * @param Objective_code
	 */
	public void setObjective_code(String Objective_code) {
		setAttrVal("Objective_code", Objective_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getObjective_name() {
		return ((String) getAttrVal("Objective_name"));
	}	
	/**
	 * 名称
	 * @param Objective_name
	 */
	public void setObjective_name(String Objective_name) {
		setAttrVal("Objective_name", Objective_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCom_medi_code() {
		return ((String) getAttrVal("Com_medi_code"));
	}	
	/**
	 * 编码
	 * @param Com_medi_code
	 */
	public void setCom_medi_code(String Com_medi_code) {
		setAttrVal("Com_medi_code", Com_medi_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCom_medi_name() {
		return ((String) getAttrVal("Com_medi_name"));
	}	
	/**
	 * 名称
	 * @param Com_medi_name
	 */
	public void setCom_medi_name(String Com_medi_name) {
		setAttrVal("Com_medi_name", Com_medi_name);
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
		return "Id_au";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_AU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntibioticUseDODesc.class);
	}
	
}