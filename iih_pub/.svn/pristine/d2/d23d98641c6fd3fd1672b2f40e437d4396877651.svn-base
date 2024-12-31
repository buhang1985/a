
package iih.ci.rcm.hospitalreport.d.desc;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import xap.sys.appfw.orm.desc.db.ColumnDesc;
import xap.sys.appfw.orm.desc.db.DsColumn;
import xap.sys.appfw.orm.desc.db.SvColumn;
import xap.sys.appfw.orm.desc.db.TableDesc;
import xap.sys.appfw.orm.desc.ent.dataobject.Attr;
import xap.sys.appfw.orm.desc.ent.dataobject.DODesc;
import xap.sys.appfw.orm.desc.ent.dataobject.DsAttr;
import xap.sys.appfw.orm.desc.ent.dataobject.SvAttr;
import xap.mw.coreitf.i.IAttrDesc;
import xap.mw.coreitf.i.IColumnDesc;
import xap.mw.coreitf.i.ITableDesc;
import xap.mw.coreitf.d.FType;
import java.math.BigDecimal;

/**
 * 院感上报 DO 元数据信息
 */
public class HospitalReportDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.rcm.hospitalreport.d.HospitalReportDO";
	public static final String CLASS_DISPALYNAME = "院感上报";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "CI_MR_HOS_REPORT";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_hospitalreport";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public HospitalReportDODesc(){
		init();
	}
	
	/**
	 * 数据初始化
	 */
	private void init(){		
		this.setResID(CLASS_RESID);
		this.setResNode(CLASS_RESMODULE);
		this.setLabel(CLASS_DISPALYNAME);
		this.setEntityName(CLASS_FULLNAME);
		ITableDesc tblDesc=getTableDesc();
		this.setKeyDesc(getId_hospitalreportADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_hospitalreportADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getAdmission_dateADesc(tblDesc));
		this.add(getId_ry_diagnosisADesc(tblDesc));
		this.add(getSd_ry_diagnosisADesc(tblDesc));
		this.add(getName_ry_diagnosisADesc(tblDesc));
		this.add(getDischarge_dateADesc(tblDesc));
		this.add(getId_cy_diagnosisADesc(tblDesc));
		this.add(getSd_cy_diagnosisADesc(tblDesc));
		this.add(getName_cy_diagnosisADesc(tblDesc));
		this.add(getIn_hospital_daysADesc(tblDesc));
		this.add(getMonitor_dateADesc(tblDesc));
		this.add(getId_di_diagnosisADesc(tblDesc));
		this.add(getSd_di_diagnosisADesc(tblDesc));
		this.add(getName_di_diagnosisADesc(tblDesc));
		this.add(getId_disease_outcomeADesc(tblDesc));
		this.add(getSd_disease_outcomeADesc(tblDesc));
		this.add(getName_disease_outcomeADesc(tblDesc));
		this.add(getId_rela_with_deathADesc(tblDesc));
		this.add(getSd_rela_with_deathADesc(tblDesc));
		this.add(getName_rela_with_deathADesc(tblDesc));
		this.add(getInfectious_diseaseADesc(tblDesc));
		this.add(getDiagnosis_basisADesc(tblDesc));
		this.add(getId_ishos_infecADesc(tblDesc));
		this.add(getSd_ishos_infecADesc(tblDesc));
		this.add(getName_ishos_infecADesc(tblDesc));
		this.add(getId_is_investigationADesc(tblDesc));
		this.add(getSd_is_investigationADesc(tblDesc));
		this.add(getName_is_investigationADesc(tblDesc));
		this.add(getId_investigationADesc(tblDesc));
		this.add(getSd_investigationADesc(tblDesc));
		this.add(getName_investigationADesc(tblDesc));
		this.add(getIs_treatment_in_icuADesc(tblDesc));
		this.add(getId_icu_typeADesc(tblDesc));
		this.add(getSd_icu_typeADesc(tblDesc));
		this.add(getName_icu_typeADesc(tblDesc));
		this.add(getHospital_occurrence_dateADesc(tblDesc));
		this.add(getId_infection_factorsADesc(tblDesc));
		this.add(getSd_infection_factorsADesc(tblDesc));
		this.add(getName_infection_factorsADesc(tblDesc));
		this.add(getOther_infection_factorsADesc(tblDesc));
		this.add(getIs_surgeryADesc(tblDesc));
		this.add(getDi_of_hosp_infectionADesc(tblDesc));
		this.add(getIs_etiol_examinationADesc(tblDesc));
		this.add(getIs_use_antibioticsADesc(tblDesc));
		this.add(getIs_lateADesc(tblDesc));
		this.add(getFill_in_personADesc(tblDesc));
		this.add(getFill_in_dateADesc(tblDesc));
		this.add(getTitleADesc(tblDesc));
		this.add(getId_stageADesc(tblDesc));
		this.add(getSd_stageADesc(tblDesc));
		this.add(getName_stageADesc(tblDesc));
		this.add(getReject_reasonADesc(tblDesc));
		this.add(getDelete_reasonADesc(tblDesc));
		this.add(getDeletebyADesc(tblDesc));
		this.add(getCode_deletebyADesc(tblDesc));
		this.add(getName_deletebyADesc(tblDesc));
		this.add(getDeletetimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getOther_inversitagion_wayADesc(tblDesc));
		this.add(getYgfsrqADesc(tblDesc));
		this.add(getId_survey_mthADesc(tblDesc));
		this.add(getSd_survey_mthADesc(tblDesc));
		this.add(getName_survey_mthADesc(tblDesc));
		this.add(getId_deptADesc(tblDesc));
		this.add(getSd_deptADesc(tblDesc));
		this.add(getName_deptADesc(tblDesc));
		this.add(getId_dept_nsADesc(tblDesc));
		this.add(getSd_dept_nsADesc(tblDesc));
		this.add(getName_dept_nsADesc(tblDesc));
		this.add(getId_bedADesc(tblDesc));
		this.add(getSd_bedADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getBackup_filed1ADesc(tblDesc));
		this.add(getBackup_filed2ADesc(tblDesc));
		this.add(getBackup_filed3ADesc(tblDesc));
		this.add(getBackup_filed4ADesc(tblDesc));
		this.add(getBackup_filed5ADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getSd_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_sexADesc(tblDesc));
		this.add(getSd_sexADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getPat_ageADesc(tblDesc));
		this.add(getTimes_ipADesc(tblDesc));
		this.add(getSd_entADesc(tblDesc));
		this.add(getId_in_deptADesc(tblDesc));
		this.add(getSd_in_deptADesc(tblDesc));
		this.add(getName_in_deptADesc(tblDesc));
		this.add(getId_in_dept_nsADesc(tblDesc));
		this.add(getSd_in_dept_nsADesc(tblDesc));
		this.add(getName_in_dept_nsADesc(tblDesc));
		this.add(getId_fill_in_deptADesc(tblDesc));
		this.add(getSd_fill_in_deptADesc(tblDesc));
		this.add(getName_fill_in_deptADesc(tblDesc));
		this.add(getId_inva_oper_siteADesc(tblDesc));
		this.add(getSd_inva_oper_siteADesc(tblDesc));
		this.add(getName_inva_oper_siteADesc(tblDesc));
		this.add(getCode_orgADesc(tblDesc));
		this.add(getName_orgADesc(tblDesc));
		this.add(getCode_grpADesc(tblDesc));
		this.add(getName_grpADesc(tblDesc));
		this.add(getCode_entADesc(tblDesc));
		this.add(getRy_diagnosis_codeADesc(tblDesc));
		this.add(getRy_diagnosis_nameADesc(tblDesc));
		this.add(getCy_diagnosis_codeADesc(tblDesc));
		this.add(getCy_iagnosis_nameADesc(tblDesc));
		this.add(getDi_diagnosis_codeADesc(tblDesc));
		this.add(getDi_diagnosis_nameADesc(tblDesc));
		this.add(getDisease_outcome_codeADesc(tblDesc));
		this.add(getDisease_outcome_nameADesc(tblDesc));
		this.add(getRelationship_with_death_codeADesc(tblDesc));
		this.add(getRelationship_with_death_nameADesc(tblDesc));
		this.add(getInhos_infec_codeADesc(tblDesc));
		this.add(getInhos_infec_nameADesc(tblDesc));
		this.add(getInvestigation_codeADesc(tblDesc));
		this.add(getInvestigation_nameADesc(tblDesc));
		this.add(getInvestiga_codeADesc(tblDesc));
		this.add(getInvestiga_nameADesc(tblDesc));
		this.add(getIcu_type_codeADesc(tblDesc));
		this.add(getIcu_type_nameADesc(tblDesc));
		this.add(getInfection_factors_codeADesc(tblDesc));
		this.add(getInfection_factors_nameADesc(tblDesc));
		this.add(getStage_codeADesc(tblDesc));
		this.add(getStage_nameADesc(tblDesc));
		this.add(getDeleteby_codeADesc(tblDesc));
		this.add(getDeleteby_nameADesc(tblDesc));
		this.add(getSurvey_mth_codeADesc(tblDesc));
		this.add(getSurvey_mth_nameADesc(tblDesc));
		this.add(getDept_codeADesc(tblDesc));
		this.add(getDept_nameADesc(tblDesc));
		this.add(getDept_ns_codeADesc(tblDesc));
		this.add(getDept_ns_nameADesc(tblDesc));
		this.add(getBed_codeADesc(tblDesc));
		this.add(getBed_nameADesc(tblDesc));
		this.add(getPat_codeADesc(tblDesc));
		this.add(getPat_nameADesc(tblDesc));
		this.add(getSex_codeADesc(tblDesc));
		this.add(getSex_nameADesc(tblDesc));
		this.add(getIn_dept_codeADesc(tblDesc));
		this.add(getIn_dept_nameADesc(tblDesc));
		this.add(getIn_dept_ns_codeADesc(tblDesc));
		this.add(getIn_dept_ns_nameADesc(tblDesc));
		this.add(getFill_in_dept_codeADesc(tblDesc));
		this.add(getFill_in_dept_nameADesc(tblDesc));
		this.add(getInva_oper_site_codeADesc(tblDesc));
		this.add(getInva_oper_site_nameADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		this.setIsRefTableInfo(true);
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getId_hospitalreportCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getAdmission_dateCDesc(tblDesc));
		tblDesc.add(getId_ry_diagnosisCDesc(tblDesc));
		tblDesc.add(getSd_ry_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_ry_diagnosisCDesc(tblDesc));
		tblDesc.add(getDischarge_dateCDesc(tblDesc));
		tblDesc.add(getId_cy_diagnosisCDesc(tblDesc));
		tblDesc.add(getSd_cy_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_cy_diagnosisCDesc(tblDesc));
		tblDesc.add(getIn_hospital_daysCDesc(tblDesc));
		tblDesc.add(getMonitor_dateCDesc(tblDesc));
		tblDesc.add(getId_di_diagnosisCDesc(tblDesc));
		tblDesc.add(getSd_di_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_di_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_disease_outcomeCDesc(tblDesc));
		tblDesc.add(getSd_disease_outcomeCDesc(tblDesc));
		tblDesc.add(getName_disease_outcomeCDesc(tblDesc));
		tblDesc.add(getId_rela_with_deathCDesc(tblDesc));
		tblDesc.add(getSd_rela_with_deathCDesc(tblDesc));
		tblDesc.add(getName_rela_with_deathCDesc(tblDesc));
		tblDesc.add(getInfectious_diseaseCDesc(tblDesc));
		tblDesc.add(getDiagnosis_basisCDesc(tblDesc));
		tblDesc.add(getId_ishos_infecCDesc(tblDesc));
		tblDesc.add(getSd_ishos_infecCDesc(tblDesc));
		tblDesc.add(getName_ishos_infecCDesc(tblDesc));
		tblDesc.add(getId_is_investigationCDesc(tblDesc));
		tblDesc.add(getSd_is_investigationCDesc(tblDesc));
		tblDesc.add(getName_is_investigationCDesc(tblDesc));
		tblDesc.add(getId_investigationCDesc(tblDesc));
		tblDesc.add(getSd_investigationCDesc(tblDesc));
		tblDesc.add(getName_investigationCDesc(tblDesc));
		tblDesc.add(getIs_treatment_in_icuCDesc(tblDesc));
		tblDesc.add(getId_icu_typeCDesc(tblDesc));
		tblDesc.add(getSd_icu_typeCDesc(tblDesc));
		tblDesc.add(getName_icu_typeCDesc(tblDesc));
		tblDesc.add(getHospital_occurrence_dateCDesc(tblDesc));
		tblDesc.add(getId_infection_factorsCDesc(tblDesc));
		tblDesc.add(getSd_infection_factorsCDesc(tblDesc));
		tblDesc.add(getName_infection_factorsCDesc(tblDesc));
		tblDesc.add(getOther_infection_factorsCDesc(tblDesc));
		tblDesc.add(getIs_surgeryCDesc(tblDesc));
		tblDesc.add(getDi_of_hosp_infectionCDesc(tblDesc));
		tblDesc.add(getIs_etiol_examinationCDesc(tblDesc));
		tblDesc.add(getIs_use_antibioticsCDesc(tblDesc));
		tblDesc.add(getIs_lateCDesc(tblDesc));
		tblDesc.add(getFill_in_personCDesc(tblDesc));
		tblDesc.add(getFill_in_dateCDesc(tblDesc));
		tblDesc.add(getTitleCDesc(tblDesc));
		tblDesc.add(getId_stageCDesc(tblDesc));
		tblDesc.add(getSd_stageCDesc(tblDesc));
		tblDesc.add(getName_stageCDesc(tblDesc));
		tblDesc.add(getReject_reasonCDesc(tblDesc));
		tblDesc.add(getDelete_reasonCDesc(tblDesc));
		tblDesc.add(getDeletebyCDesc(tblDesc));
		tblDesc.add(getCode_deletebyCDesc(tblDesc));
		tblDesc.add(getName_deletebyCDesc(tblDesc));
		tblDesc.add(getDeletetimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getOther_inversitagion_wayCDesc(tblDesc));
		tblDesc.add(getYgfsrqCDesc(tblDesc));
		tblDesc.add(getId_survey_mthCDesc(tblDesc));
		tblDesc.add(getSd_survey_mthCDesc(tblDesc));
		tblDesc.add(getName_survey_mthCDesc(tblDesc));
		tblDesc.add(getId_deptCDesc(tblDesc));
		tblDesc.add(getSd_deptCDesc(tblDesc));
		tblDesc.add(getName_deptCDesc(tblDesc));
		tblDesc.add(getId_dept_nsCDesc(tblDesc));
		tblDesc.add(getSd_dept_nsCDesc(tblDesc));
		tblDesc.add(getName_dept_nsCDesc(tblDesc));
		tblDesc.add(getId_bedCDesc(tblDesc));
		tblDesc.add(getSd_bedCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getBackup_filed1CDesc(tblDesc));
		tblDesc.add(getBackup_filed2CDesc(tblDesc));
		tblDesc.add(getBackup_filed3CDesc(tblDesc));
		tblDesc.add(getBackup_filed4CDesc(tblDesc));
		tblDesc.add(getBackup_filed5CDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getSd_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_sexCDesc(tblDesc));
		tblDesc.add(getSd_sexCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getPat_ageCDesc(tblDesc));
		tblDesc.add(getTimes_ipCDesc(tblDesc));
		tblDesc.add(getSd_entCDesc(tblDesc));
		tblDesc.add(getId_in_deptCDesc(tblDesc));
		tblDesc.add(getSd_in_deptCDesc(tblDesc));
		tblDesc.add(getName_in_deptCDesc(tblDesc));
		tblDesc.add(getId_in_dept_nsCDesc(tblDesc));
		tblDesc.add(getSd_in_dept_nsCDesc(tblDesc));
		tblDesc.add(getName_in_dept_nsCDesc(tblDesc));
		tblDesc.add(getId_fill_in_deptCDesc(tblDesc));
		tblDesc.add(getSd_fill_in_deptCDesc(tblDesc));
		tblDesc.add(getName_fill_in_deptCDesc(tblDesc));
		tblDesc.add(getId_inva_oper_siteCDesc(tblDesc));
		tblDesc.add(getSd_inva_oper_siteCDesc(tblDesc));
		tblDesc.add(getName_inva_oper_siteCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 院感上报主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitalreportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitalreport",  getId_hospitalreportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院感上报主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 就诊号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊号");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdmission_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Admission_date",  getAdmission_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("入院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ry_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ry_diagnosis",  getId_ry_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ry_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ry_diagnosis",  getSd_ry_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ry_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ry_diagnosis",  getName_ry_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDischarge_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Discharge_date",  getDischarge_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cy_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cy_diagnosis",  getId_cy_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cy_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cy_diagnosis",  getSd_cy_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cy_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cy_diagnosis",  getName_cy_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_hospital_daysADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_hospital_days",  getIn_hospital_daysCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 监测日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMonitor_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Monitor_date",  getMonitor_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("监测日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_di_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_di_diagnosis",  getId_di_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_di_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_di_diagnosis",  getSd_di_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_di_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_di_diagnosis",  getName_di_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病转归属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disease_outcomeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disease_outcome",  getId_disease_outcomeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病转归");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病转归编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disease_outcomeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disease_outcome",  getSd_disease_outcomeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病转归编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病转归名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disease_outcomeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disease_outcome",  getName_disease_outcomeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病转归名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与死亡的关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rela_with_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rela_with_death",  getId_rela_with_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与死亡的关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与死亡的关系编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rela_with_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rela_with_death",  getSd_rela_with_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与死亡的关系编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与死亡的关系名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rela_with_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rela_with_death",  getName_rela_with_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与死亡的关系名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染性疾病病程属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfectious_diseaseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infectious_disease",  getInfectious_diseaseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染性疾病病程");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断依据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDiagnosis_basisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Diagnosis_basis",  getDiagnosis_basisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断依据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否医院内感染属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ishos_infecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ishos_infec",  getId_ishos_infecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否医院内感染");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医院感染编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ishos_infecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ishos_infec",  getSd_ishos_infecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院感染编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医院感染名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ishos_infecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ishos_infec",  getName_ishos_infecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医院感染名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否随访属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_is_investigationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_is_investigation",  getId_is_investigationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否随访");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 随访编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_is_investigationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_is_investigation",  getSd_is_investigationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随访编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随访名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_is_investigationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_is_investigation",  getName_is_investigationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随访名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随访方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_investigationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_investigation",  getId_investigationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随访方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 随访方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_investigationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_investigation",  getSd_investigationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随访方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随访方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_investigationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_investigation",  getName_investigationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随访方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 在ICU治疗过属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_treatment_in_icuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_treatment_in_icu",  getIs_treatment_in_icuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("在ICU治疗过");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ICU科别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_icu_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_icu_type",  getId_icu_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU科别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * ICU科别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_icu_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_icu_type",  getSd_icu_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU科别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ICU科别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_icu_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_icu_type",  getName_icu_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("ICU科别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 转入ICU时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHospital_occurrence_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hospital_occurrence_date",  getHospital_occurrence_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("转入ICU时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染因素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_infection_factorsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_infection_factors",  getId_infection_factorsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染因素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感染因素编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_infection_factorsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_infection_factors",  getSd_infection_factorsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染因素编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染因素名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_infection_factorsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_infection_factors",  getName_infection_factorsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染因素名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感染因素其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_infection_factorsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_infection_factors",  getOther_infection_factorsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感染因素其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否有手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_surgeryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_surgery",  getIs_surgeryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否有手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院内感染诊断依据属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_of_hosp_infectionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_of_hosp_infection",  getDi_of_hosp_infectionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院内感染诊断依据");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病原学检查属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_etiol_examinationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_etiol_examination",  getIs_etiol_examinationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("病原学检查");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用抗生素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_use_antibioticsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_use_antibiotics",  getIs_use_antibioticsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("使用抗生素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否迟报属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIs_lateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Is_late",  getIs_lateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否迟报");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_in_personADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_in_person",  getFill_in_personCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_in_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_in_date",  getFill_in_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("填报日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院感上报标题属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Title",  getTitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("院感上报标题");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签阶段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stage",  getId_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签阶段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审签阶段编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_stage",  getSd_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签阶段编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审签阶段名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_stageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_stage",  getName_stageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审签阶段名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 驳回原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReject_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reject_reason",  getReject_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("驳回原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDelete_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Delete_reason",  getDelete_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeletebyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deleteby",  getDeletebyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 删除人编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_deletebyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_deleteby",  getCode_deletebyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除人编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deletebyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_deleteby",  getName_deletebyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("删除人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 删除时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeletetimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deletetime",  getDeletetimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("删除时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 创建人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdby",  getCreatedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("创建人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 创建时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCreatedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Createdtime",  getCreatedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("创建时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 最后修改人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedbyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedby",  getModifiedbyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("最后修改人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 最后修改时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getModifiedtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Modifiedtime",  getModifiedtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("最后修改时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 随访方式备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_inversitagion_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_inversitagion_way",  getOther_inversitagion_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("随访方式备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院感发生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getYgfsrqADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ygfsrq",  getYgfsrqCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("院感发生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_survey_mthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_survey_mth",  getId_survey_mthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 调查方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_survey_mthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_survey_mth",  getSd_survey_mthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_survey_mthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_survey_mth",  getName_survey_mthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept",  getId_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dept",  getSd_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept",  getName_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dept_nsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dept_ns",  getId_dept_nsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者病区编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dept_nsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dept_ns",  getSd_dept_nsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者病区编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者病区名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dept_nsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dept_ns",  getName_dept_nsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者病区名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者床位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bed",  getId_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者床位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者床位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bed",  getSd_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者床位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者床位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者床位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_filed1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_filed1",  getBackup_filed1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_filed2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_filed2",  getBackup_filed2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_filed3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_filed3",  getBackup_filed3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_filed4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_filed4",  getBackup_filed4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_filed5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_filed5",  getBackup_filed5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pat",  getSd_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex",  getId_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex",  getSd_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者性别名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_age",  getPat_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者年龄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_ip",  getTimes_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ent",  getSd_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_in_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_in_dept",  getId_in_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_in_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_in_dept",  getSd_in_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_in_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_in_dept",  getName_in_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_in_dept_nsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_in_dept_ns",  getId_in_dept_nsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院病区编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_in_dept_nsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_in_dept_ns",  getSd_in_dept_nsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病区编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院病区名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_in_dept_nsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_in_dept_ns",  getName_in_dept_nsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病区名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报人科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fill_in_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fill_in_dept",  getId_fill_in_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 填报人科室编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fill_in_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fill_in_dept",  getSd_fill_in_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人科室编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 填报人科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fill_in_deptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fill_in_dept",  getName_fill_in_deptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与感染部分相关侵袭性操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inva_oper_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inva_oper_site",  getId_inva_oper_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与感染部分相关侵袭性操作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 与感染部分相关侵袭性操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_inva_oper_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_inva_oper_site",  getSd_inva_oper_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与感染部分相关侵袭性操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与感染部分相关侵袭性操作名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_inva_oper_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_inva_oper_site",  getName_inva_oper_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与感染部分相关侵袭性操作名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_org",  getCode_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b16","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_org",  getName_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b16","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_grp",  getCode_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b17","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_grp",  getName_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b17","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_ent",  getCode_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"en_ent a0b22","id_ent=id_ent","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRy_diagnosis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ry_diagnosis_code",  getRy_diagnosis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b9","id_ry_diagnosis=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRy_diagnosis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ry_diagnosis_name",  getRy_diagnosis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b9","id_ry_diagnosis=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCy_diagnosis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cy_diagnosis_code",  getCy_diagnosis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b10","id_cy_diagnosis=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCy_iagnosis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cy_iagnosis_name",  getCy_iagnosis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b10","id_cy_diagnosis=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_diagnosis_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_diagnosis_code",  getDi_diagnosis_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b2","id_di_diagnosis=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDi_diagnosis_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Di_diagnosis_name",  getDi_diagnosis_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b2","id_di_diagnosis=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_outcome_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_outcome_code",  getDisease_outcome_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_disease_outcome=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_outcome_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_outcome_name",  getDisease_outcome_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b3","id_disease_outcome=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelationship_with_death_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relationship_with_death_code",  getRelationship_with_death_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_rela_with_death=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelationship_with_death_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relationship_with_death_name",  getRelationship_with_death_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_rela_with_death=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInhos_infec_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inhos_infec_code",  getInhos_infec_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_ishos_infec=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInhos_infec_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inhos_infec_name",  getInhos_infec_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_ishos_infec=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigation_code",  getInvestigation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_is_investigation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestigation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investigation_name",  getInvestigation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_is_investigation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestiga_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investiga_code",  getInvestiga_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_investigation=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInvestiga_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Investiga_name",  getInvestiga_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_investigation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIcu_type_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Icu_type_code",  getIcu_type_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_icu_type=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIcu_type_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Icu_type_name",  getIcu_type_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_icu_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_factors_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_factors_code",  getInfection_factors_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_infection_factors=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInfection_factors_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Infection_factors_name",  getInfection_factors_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_infection_factors=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStage_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stage_code",  getStage_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_stage=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStage_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stage_name",  getStage_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_stage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeleteby_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deleteby_code",  getDeleteby_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","deleteby=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDeleteby_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Deleteby_name",  getDeleteby_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b7","deleteby=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSurvey_mth_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Survey_mth_code",  getSurvey_mth_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_survey_mth=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 调查方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSurvey_mth_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Survey_mth_name",  getSurvey_mth_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("调查方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_survey_mth=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_code",  getDept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b19","id_dept=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_name",  getDept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b19","id_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_ns_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_ns_code",  getDept_ns_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b20","id_dept_ns=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDept_ns_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dept_ns_name",  getDept_ns_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b20","id_dept_ns=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBed_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bed_code",  getBed_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_bed a0b21","id_bed=id_bed","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBed_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bed_name",  getBed_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_bed a0b21","id_bed=id_bed","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_code",  getPat_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b23","id_pat=id_pat","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPat_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pat_name",  getPat_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"pi_pat a0b23","id_pat=id_pat","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_code",  getSex_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_sex=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSex_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sex_name",  getSex_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_sex=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_dept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_dept_code",  getIn_dept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b25","id_in_dept=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_dept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_dept_name",  getIn_dept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b25","id_in_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_dept_ns_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_dept_ns_code",  getIn_dept_ns_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b26","id_in_dept_ns=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getIn_dept_ns_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("In_dept_ns_name",  getIn_dept_ns_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b26","id_in_dept_ns=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_in_dept_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_in_dept_code",  getFill_in_dept_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b27","id_fill_in_dept=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_in_dept_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_in_dept_name",  getFill_in_dept_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b27","id_fill_in_dept=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInva_oper_site_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inva_oper_site_code",  getInva_oper_site_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_inva_oper_site=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInva_oper_site_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Inva_oper_site_name",  getInva_oper_site_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_inva_oper_site=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取院感上报主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalreportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalreport");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("院感上报主键"); 
		return column;
	}
	/**
	 * 获取组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
		return column;
	}
	/**
	 * 获取就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊号"); 
		return column;
	}
	/**
	 * 获取入院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdmission_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Admission_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院日期"); 
		return column;
	}
	/**
	 * 获取入院诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ry_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ry_diagnosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断"); 
		return column;
	}
	/**
	 * 获取入院诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ry_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ry_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断编码"); 
		return column;
	}
	/**
	 * 获取入院诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ry_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ry_diagnosis");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断名称"); 
		return column;
	}
	/**
	 * 获取出院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDischarge_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Discharge_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院日期"); 
		return column;
	}
	/**
	 * 获取出院诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cy_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cy_diagnosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院诊断"); 
		return column;
	}
	/**
	 * 获取出院诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cy_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cy_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院诊断编码"); 
		return column;
	}
	/**
	 * 获取出院诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cy_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cy_diagnosis");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院诊断名称"); 
		return column;
	}
	/**
	 * 获取住院天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_hospital_daysCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_hospital_days");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院天数"); 
		return column;
	}
	/**
	 * 获取监测日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMonitor_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Monitor_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("监测日期"); 
		return column;
	}
	/**
	 * 获取疾病诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_di_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_di_diagnosis");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断"); 
		return column;
	}
	/**
	 * 获取疾病诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_di_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_di_diagnosis");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断编码"); 
		return column;
	}
	/**
	 * 获取疾病诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_di_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_di_diagnosis");
		column.setLength(5000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病诊断名称"); 
		return column;
	}
	/**
	 * 获取疾病转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disease_outcomeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disease_outcome");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病转归"); 
		return column;
	}
	/**
	 * 获取疾病转归编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disease_outcomeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disease_outcome");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病转归编码"); 
		return column;
	}
	/**
	 * 获取疾病转归名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disease_outcomeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disease_outcome");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病转归名称"); 
		return column;
	}
	/**
	 * 获取与死亡的关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rela_with_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rela_with_death");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与死亡的关系"); 
		return column;
	}
	/**
	 * 获取与死亡的关系编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rela_with_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rela_with_death");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与死亡的关系编码"); 
		return column;
	}
	/**
	 * 获取与死亡的关系名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rela_with_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rela_with_death");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与死亡的关系名称"); 
		return column;
	}
	/**
	 * 获取感染性疾病病程表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfectious_diseaseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infectious_disease");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染性疾病病程"); 
		return column;
	}
	/**
	 * 获取诊断依据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDiagnosis_basisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Diagnosis_basis");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断依据"); 
		return column;
	}
	/**
	 * 获取是否医院内感染表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ishos_infecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ishos_infec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否医院内感染"); 
		return column;
	}
	/**
	 * 获取医院感染编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ishos_infecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ishos_infec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院感染编码"); 
		return column;
	}
	/**
	 * 获取医院感染名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ishos_infecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ishos_infec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医院感染名称"); 
		return column;
	}
	/**
	 * 获取是否随访表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_is_investigationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_is_investigation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否随访"); 
		return column;
	}
	/**
	 * 获取随访编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_is_investigationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_is_investigation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随访编码"); 
		return column;
	}
	/**
	 * 获取随访名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_is_investigationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_is_investigation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随访名称"); 
		return column;
	}
	/**
	 * 获取随访方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_investigationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_investigation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随访方式"); 
		return column;
	}
	/**
	 * 获取随访方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_investigationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_investigation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随访方式编码"); 
		return column;
	}
	/**
	 * 获取随访方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_investigationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_investigation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随访方式名称"); 
		return column;
	}
	/**
	 * 获取在ICU治疗过表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_treatment_in_icuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_treatment_in_icu");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("在ICU治疗过"); 
		return column;
	}
	/**
	 * 获取ICU科别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_icu_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_icu_type");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU科别"); 
		return column;
	}
	/**
	 * 获取ICU科别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_icu_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_icu_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU科别编码"); 
		return column;
	}
	/**
	 * 获取ICU科别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_icu_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_icu_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("ICU科别名称"); 
		return column;
	}
	/**
	 * 获取转入ICU时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHospital_occurrence_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hospital_occurrence_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("转入ICU时间"); 
		return column;
	}
	/**
	 * 获取感染因素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_infection_factorsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_infection_factors");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染因素"); 
		return column;
	}
	/**
	 * 获取感染因素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_infection_factorsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_infection_factors");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染因素编码"); 
		return column;
	}
	/**
	 * 获取感染因素名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_infection_factorsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_infection_factors");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染因素名称"); 
		return column;
	}
	/**
	 * 获取感染因素其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_infection_factorsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_infection_factors");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感染因素其它"); 
		return column;
	}
	/**
	 * 获取是否有手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_surgeryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_surgery");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否有手术"); 
		return column;
	}
	/**
	 * 获取院内感染诊断依据表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_of_hosp_infectionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_of_hosp_infection");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院内感染诊断依据"); 
		return column;
	}
	/**
	 * 获取病原学检查表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_etiol_examinationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_etiol_examination");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病原学检查"); 
		return column;
	}
	/**
	 * 获取使用抗生素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_use_antibioticsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_use_antibiotics");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("使用抗生素"); 
		return column;
	}
	/**
	 * 获取是否迟报表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIs_lateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Is_late");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否迟报"); 
		return column;
	}
	/**
	 * 获取填报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_in_personCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_in_person");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人"); 
		return column;
	}
	/**
	 * 获取填报日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_in_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_in_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("填报日期"); 
		return column;
	}
	/**
	 * 获取院感上报标题表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Title");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("院感上报标题"); 
		return column;
	}
	/**
	 * 获取审签阶段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stage");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签阶段"); 
		return column;
	}
	/**
	 * 获取审签阶段编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_stage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签阶段编码"); 
		return column;
	}
	/**
	 * 获取审签阶段名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_stageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_stage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审签阶段名称"); 
		return column;
	}
	/**
	 * 获取驳回原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReject_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reject_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("驳回原因"); 
		return column;
	}
	/**
	 * 获取删除原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDelete_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Delete_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除原因"); 
		return column;
	}
	/**
	 * 获取删除人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeletebyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deleteby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除人"); 
		return column;
	}
	/**
	 * 获取删除人编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_deletebyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_deleteby");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除人编码"); 
		return column;
	}
	/**
	 * 获取删除人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deletebyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_deleteby");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("删除人姓名"); 
		return column;
	}
	/**
	 * 获取删除时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeletetimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deletetime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("删除时间"); 
		return column;
	}
	/**
	 * 获取创建人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("创建人"); 
		return column;
	}
	/**
	 * 获取创建时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCreatedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Createdtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("创建时间"); 
		return column;
	}
	/**
	 * 获取最后修改人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedbyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedby");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("最后修改人"); 
		return column;
	}
	/**
	 * 获取最后修改时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getModifiedtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Modifiedtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("最后修改时间"); 
		return column;
	}
	/**
	 * 获取随访方式备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_inversitagion_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_inversitagion_way");
		column.setLength(75);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("随访方式备注"); 
		return column;
	}
	/**
	 * 获取院感发生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getYgfsrqCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ygfsrq");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("院感发生日期"); 
		return column;
	}
	/**
	 * 获取调查方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_survey_mthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_survey_mth");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查方式"); 
		return column;
	}
	/**
	 * 获取调查方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_survey_mthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_survey_mth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查方式编码"); 
		return column;
	}
	/**
	 * 获取调查方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_survey_mthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_survey_mth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查方式名称"); 
		return column;
	}
	/**
	 * 获取患者科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者科室"); 
		return column;
	}
	/**
	 * 获取患者科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者科室编码"); 
		return column;
	}
	/**
	 * 获取患者科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者科室名称"); 
		return column;
	}
	/**
	 * 获取患者病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dept_nsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dept_ns");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者病区"); 
		return column;
	}
	/**
	 * 获取患者病区编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dept_nsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dept_ns");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者病区编码"); 
		return column;
	}
	/**
	 * 获取患者病区名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dept_nsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dept_ns");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者病区名称"); 
		return column;
	}
	/**
	 * 获取患者床位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者床位"); 
		return column;
	}
	/**
	 * 获取患者床位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者床位编码"); 
		return column;
	}
	/**
	 * 获取患者床位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者床位名称"); 
		return column;
	}
	/**
	 * 获取备用字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_filed1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_filed1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段1"); 
		return column;
	}
	/**
	 * 获取备用字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_filed2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_filed2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段2"); 
		return column;
	}
	/**
	 * 获取备用字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_filed3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_filed3");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段3"); 
		return column;
	}
	/**
	 * 获取备用字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_filed4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_filed4");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段4"); 
		return column;
	}
	/**
	 * 获取备用字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_filed5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_filed5");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用字段5"); 
		return column;
	}
	/**
	 * 获取患者主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者主键"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取患者名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者名称"); 
		return column;
	}
	/**
	 * 获取患者性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别"); 
		return column;
	}
	/**
	 * 获取患者性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别编码"); 
		return column;
	}
	/**
	 * 获取患者性别名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别名称"); 
		return column;
	}
	/**
	 * 获取患者年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者年龄"); 
		return column;
	}
	/**
	 * 获取住院次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院次数"); 
		return column;
	}
	/**
	 * 获取就诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊编码"); 
		return column;
	}
	/**
	 * 获取入院科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_in_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_in_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科室"); 
		return column;
	}
	/**
	 * 获取入院科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_in_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_in_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科室编码"); 
		return column;
	}
	/**
	 * 获取入院科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_in_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_in_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科室名称"); 
		return column;
	}
	/**
	 * 获取入院病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_in_dept_nsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_in_dept_ns");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病区"); 
		return column;
	}
	/**
	 * 获取入院病区编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_in_dept_nsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_in_dept_ns");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病区编码"); 
		return column;
	}
	/**
	 * 获取入院病区名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_in_dept_nsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_in_dept_ns");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病区名称"); 
		return column;
	}
	/**
	 * 获取填报人科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fill_in_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fill_in_dept");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人科室"); 
		return column;
	}
	/**
	 * 获取填报人科室编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fill_in_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fill_in_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人科室编码"); 
		return column;
	}
	/**
	 * 获取填报人科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fill_in_deptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fill_in_dept");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人科室名称"); 
		return column;
	}
	/**
	 * 获取与感染部分相关侵袭性操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inva_oper_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inva_oper_site");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与感染部分相关侵袭性操作"); 
		return column;
	}
	/**
	 * 获取与感染部分相关侵袭性操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_inva_oper_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_inva_oper_site");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与感染部分相关侵袭性操作编码"); 
		return column;
	}
	/**
	 * 获取与感染部分相关侵袭性操作名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_inva_oper_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_inva_oper_site");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与感染部分相关侵袭性操作名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_org");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_grp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取就诊编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_ent");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊编码"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRy_diagnosis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ry_diagnosis_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRy_diagnosis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ry_diagnosis_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCy_diagnosis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cy_diagnosis_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCy_iagnosis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cy_iagnosis_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_diagnosis_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_diagnosis_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDi_diagnosis_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Di_diagnosis_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_outcome_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_outcome_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_outcome_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_outcome_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelationship_with_death_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relationship_with_death_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelationship_with_death_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relationship_with_death_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInhos_infec_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inhos_infec_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInhos_infec_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inhos_infec_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigation_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestigation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investigation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestiga_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investiga_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInvestiga_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Investiga_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIcu_type_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Icu_type_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIcu_type_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Icu_type_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_factors_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_factors_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInfection_factors_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Infection_factors_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStage_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stage_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStage_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stage_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeleteby_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deleteby_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDeleteby_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Deleteby_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取调查方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSurvey_mth_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Survey_mth_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查方式编码"); 
		return column;
	}
	/**
	 * 获取调查方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSurvey_mth_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Survey_mth_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("调查方式名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_ns_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_ns_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDept_ns_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dept_ns_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取床位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBed_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bed_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位编码"); 
		return column;
	}
	/**
	 * 获取床位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBed_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bed_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位名称"); 
		return column;
	}
	/**
	 * 获取患者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者编码"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPat_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pat_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSex_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sex_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_dept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_dept_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_dept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_dept_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_dept_ns_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_dept_ns_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getIn_dept_ns_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"In_dept_ns_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_in_dept_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_in_dept_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_in_dept_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_in_dept_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInva_oper_site_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inva_oper_site_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInva_oper_site_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Inva_oper_site_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
		iAuditInfoFldMap=new HashMap<String, String>();
		iAuditInfoFldMap.put("createdby","Createdby");
		iAuditInfoFldMap.put("createdtime","Createdtime");
		iAuditInfoFldMap.put("modifiedby","Modifiedby");
		iAuditInfoFldMap.put("modifiedtime","Modifiedtime");
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
		defaultValueMap.put("Is_treatment_in_icu",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Is_surgery",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Is_etiol_examination",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Is_use_antibiotics",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Is_late",new xap.mw.coreitf.d.FBoolean("N"));
	}
	
}
