
package iih.nmr.ha.tcho.nachsorge.d.desc;

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
 * 出院护理评估单 DO 元数据信息
 */
public class TchoNachsorgeDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.ha.tcho.nachsorge.d.TchoNachsorgeDO";
	public static final String CLASS_DISPALYNAME = "出院护理评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nmr_ha_tcho_nachsorge";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nachsorge";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TchoNachsorgeDODesc(){
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
		this.setKeyDesc(getId_nachsorgeADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nachsorgeADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_groupADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getDt_dischargeADesc(tblDesc));
		this.add(getId_operationADesc(tblDesc));
		this.add(getSd_operationADesc(tblDesc));
		this.add(getDt_operationADesc(tblDesc));
		this.add(getName_operationADesc(tblDesc));
		this.add(getChinese_diagnoseADesc(tblDesc));
		this.add(getName_document_typeADesc(tblDesc));
		this.add(getWestern_diagnoseADesc(tblDesc));
		this.add(getId_disease_prognosisADesc(tblDesc));
		this.add(getSd_disease_prognosisADesc(tblDesc));
		this.add(getName_disease_prognosisADesc(tblDesc));
		this.add(getId_disease_perceive_degreeADesc(tblDesc));
		this.add(getSd_disease_perceive_degreeADesc(tblDesc));
		this.add(getName_disease_perceive_degreeADesc(tblDesc));
		this.add(getId_emotions_statusADesc(tblDesc));
		this.add(getSd_emotions_statusADesc(tblDesc));
		this.add(getName_emotions_statusADesc(tblDesc));
		this.add(getId_self_care_abilityADesc(tblDesc));
		this.add(getSd_self_care_abilityADesc(tblDesc));
		this.add(getName_self_care_abilityADesc(tblDesc));
		this.add(getId_administration_behaviorADesc(tblDesc));
		this.add(getSd_administration_behaviorADesc(tblDesc));
		this.add(getName_administration_behaviorADesc(tblDesc));
		this.add(getId_teach_contentADesc(tblDesc));
		this.add(getSd_teach_contentADesc(tblDesc));
		this.add(getName_teach_contentADesc(tblDesc));
		this.add(getId_teach_wayADesc(tblDesc));
		this.add(getSd_teach_wayADesc(tblDesc));
		this.add(getName_teach_wayADesc(tblDesc));
		this.add(getId_teach_comprehend_degreeADesc(tblDesc));
		this.add(getSd_teach_comprehend_degreeADesc(tblDesc));
		this.add(getName_teach_comprehend_degreeADesc(tblDesc));
		this.add(getId_complicationADesc(tblDesc));
		this.add(getSd_complicationADesc(tblDesc));
		this.add(getName_complicationADesc(tblDesc));
		this.add(getOther_assessADesc(tblDesc));
		this.add(getId_medication_guideADesc(tblDesc));
		this.add(getSd_medication_guideADesc(tblDesc));
		this.add(getName_medication_guideADesc(tblDesc));
		this.add(getSpecial_medication_guideADesc(tblDesc));
		this.add(getId_health_guideADesc(tblDesc));
		this.add(getSd_health_guideADesc(tblDesc));
		this.add(getName_health_guideADesc(tblDesc));
		this.add(getOther_health_guideADesc(tblDesc));
		this.add(getSpecial_guideADesc(tblDesc));
		this.add(getFill_dateADesc(tblDesc));
		this.add(getId_primary_nurseADesc(tblDesc));
		this.add(getId_discharge_wayADesc(tblDesc));
		this.add(getSd_discharge_wayADesc(tblDesc));
		this.add(getId_emp_nurADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getBackup_field1ADesc(tblDesc));
		this.add(getBackup_field2ADesc(tblDesc));
		this.add(getBackup_field3ADesc(tblDesc));
		this.add(getBackup_field4ADesc(tblDesc));
		this.add(getBackup_field5ADesc(tblDesc));
		this.add(getOperation_nameADesc(tblDesc));
		this.add(getOperation_codeADesc(tblDesc));
		this.add(getDisease_pro_codeADesc(tblDesc));
		this.add(getDisease_pro_nameADesc(tblDesc));
		this.add(getDisease_per_codeADesc(tblDesc));
		this.add(getDisease_per_nameADesc(tblDesc));
		this.add(getEmotions_status_codeADesc(tblDesc));
		this.add(getEmotions_status_nameADesc(tblDesc));
		this.add(getSelf_care_codeADesc(tblDesc));
		this.add(getSelf_care_nameADesc(tblDesc));
		this.add(getAdm_beh_codeADesc(tblDesc));
		this.add(getAdm_beh_nameADesc(tblDesc));
		this.add(getTeach_con_codeADesc(tblDesc));
		this.add(getTeach_con_nameADesc(tblDesc));
		this.add(getTeach_way_codeADesc(tblDesc));
		this.add(getTeach_way_nameADesc(tblDesc));
		this.add(getTeach_com_codeADesc(tblDesc));
		this.add(getTeach_com_nameADesc(tblDesc));
		this.add(getComplication_codeADesc(tblDesc));
		this.add(getComplication_nameADesc(tblDesc));
		this.add(getMedication_guide_codeADesc(tblDesc));
		this.add(getMedication_guide_nameADesc(tblDesc));
		this.add(getHealth_guide_codeADesc(tblDesc));
		this.add(getHealth_guide_nameADesc(tblDesc));
		this.add(getName_primary_nurseADesc(tblDesc));
		this.add(getName_discharge_wayADesc(tblDesc));
		this.add(getName_emp_nurADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nachsorgeCDesc(tblDesc));
		tblDesc.add(getId_nachsorgeCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_groupCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getDt_dischargeCDesc(tblDesc));
		tblDesc.add(getId_operationCDesc(tblDesc));
		tblDesc.add(getSd_operationCDesc(tblDesc));
		tblDesc.add(getDt_operationCDesc(tblDesc));
		tblDesc.add(getName_operationCDesc(tblDesc));
		tblDesc.add(getChinese_diagnoseCDesc(tblDesc));
		tblDesc.add(getName_document_typeCDesc(tblDesc));
		tblDesc.add(getWestern_diagnoseCDesc(tblDesc));
		tblDesc.add(getId_disease_prognosisCDesc(tblDesc));
		tblDesc.add(getSd_disease_prognosisCDesc(tblDesc));
		tblDesc.add(getName_disease_prognosisCDesc(tblDesc));
		tblDesc.add(getId_disease_perceive_degreeCDesc(tblDesc));
		tblDesc.add(getSd_disease_perceive_degreeCDesc(tblDesc));
		tblDesc.add(getName_disease_perceive_degreeCDesc(tblDesc));
		tblDesc.add(getId_emotions_statusCDesc(tblDesc));
		tblDesc.add(getSd_emotions_statusCDesc(tblDesc));
		tblDesc.add(getName_emotions_statusCDesc(tblDesc));
		tblDesc.add(getId_self_care_abilityCDesc(tblDesc));
		tblDesc.add(getSd_self_care_abilityCDesc(tblDesc));
		tblDesc.add(getName_self_care_abilityCDesc(tblDesc));
		tblDesc.add(getId_administration_behaviorCDesc(tblDesc));
		tblDesc.add(getSd_administration_behaviorCDesc(tblDesc));
		tblDesc.add(getName_administration_behaviorCDesc(tblDesc));
		tblDesc.add(getId_teach_contentCDesc(tblDesc));
		tblDesc.add(getSd_teach_contentCDesc(tblDesc));
		tblDesc.add(getName_teach_contentCDesc(tblDesc));
		tblDesc.add(getId_teach_wayCDesc(tblDesc));
		tblDesc.add(getSd_teach_wayCDesc(tblDesc));
		tblDesc.add(getName_teach_wayCDesc(tblDesc));
		tblDesc.add(getId_teach_comprehend_degreeCDesc(tblDesc));
		tblDesc.add(getSd_teach_comprehend_degreeCDesc(tblDesc));
		tblDesc.add(getName_teach_comprehend_degreeCDesc(tblDesc));
		tblDesc.add(getId_complicationCDesc(tblDesc));
		tblDesc.add(getSd_complicationCDesc(tblDesc));
		tblDesc.add(getName_complicationCDesc(tblDesc));
		tblDesc.add(getOther_assessCDesc(tblDesc));
		tblDesc.add(getId_medication_guideCDesc(tblDesc));
		tblDesc.add(getSd_medication_guideCDesc(tblDesc));
		tblDesc.add(getName_medication_guideCDesc(tblDesc));
		tblDesc.add(getSpecial_medication_guideCDesc(tblDesc));
		tblDesc.add(getId_health_guideCDesc(tblDesc));
		tblDesc.add(getSd_health_guideCDesc(tblDesc));
		tblDesc.add(getName_health_guideCDesc(tblDesc));
		tblDesc.add(getOther_health_guideCDesc(tblDesc));
		tblDesc.add(getSpecial_guideCDesc(tblDesc));
		tblDesc.add(getFill_dateCDesc(tblDesc));
		tblDesc.add(getId_primary_nurseCDesc(tblDesc));
		tblDesc.add(getId_discharge_wayCDesc(tblDesc));
		tblDesc.add(getSd_discharge_wayCDesc(tblDesc));
		tblDesc.add(getId_emp_nurCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getBackup_field1CDesc(tblDesc));
		tblDesc.add(getBackup_field2CDesc(tblDesc));
		tblDesc.add(getBackup_field3CDesc(tblDesc));
		tblDesc.add(getBackup_field4CDesc(tblDesc));
		tblDesc.add(getBackup_field5CDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 出院护理评估单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nachsorgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nachsorge",  getId_nachsorgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院护理评估单主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_groupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_group",  getId_groupCDesc(tblDesc), this);
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
	 * 就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pat",  getName_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bed",  getName_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院病案编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院病案编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("入院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_dischargeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_discharge",  getDt_dischargeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_operation",  getId_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 手术编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_operation",  getSd_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_operation",  getDt_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("手术日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operation",  getName_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 中医诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getChinese_diagnoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Chinese_diagnose",  getChinese_diagnoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("中医诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 证型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_document_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_document_type",  getName_document_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("证型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 西医诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWestern_diagnoseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Western_diagnose",  getWestern_diagnoseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("西医诊断");
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
	private IAttrDesc getId_disease_prognosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disease_prognosis",  getId_disease_prognosisCDesc(tblDesc), this);
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
	private IAttrDesc getSd_disease_prognosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disease_prognosis",  getSd_disease_prognosisCDesc(tblDesc), this);
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
	private IAttrDesc getName_disease_prognosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disease_prognosis",  getName_disease_prognosisCDesc(tblDesc), this);
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
	 * 疾病认知度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_disease_perceive_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_disease_perceive_degree",  getId_disease_perceive_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病认知度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疾病认知度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_disease_perceive_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_disease_perceive_degree",  getSd_disease_perceive_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病认知度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疾病认知度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_disease_perceive_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_disease_perceive_degree",  getName_disease_perceive_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疾病认知度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情志状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emotions_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emotions_status",  getId_emotions_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情志状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 情志状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emotions_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emotions_status",  getSd_emotions_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情志状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情志状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emotions_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emotions_status",  getName_emotions_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情志状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_self_care_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_self_care_ability",  getId_self_care_abilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 自理能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_self_care_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_self_care_ability",  getSd_self_care_abilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理能力名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_self_care_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_self_care_ability",  getName_self_care_abilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服药行为属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_administration_behaviorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_administration_behavior",  getId_administration_behaviorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服药行为");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 服药行为编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_administration_behaviorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_administration_behavior",  getSd_administration_behaviorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服药行为编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服药行为名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_administration_behaviorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_administration_behavior",  getName_administration_behaviorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服药行为名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宣教内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_teach_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_teach_content",  getId_teach_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宣教内容编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_teach_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_teach_content",  getSd_teach_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教内容编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宣教内容名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_teach_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_teach_content",  getName_teach_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教内容名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宣教方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_teach_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_teach_way",  getId_teach_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宣教方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_teach_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_teach_way",  getSd_teach_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宣教方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_teach_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_teach_way",  getName_teach_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宣教理解度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_teach_comprehend_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_teach_comprehend_degree",  getId_teach_comprehend_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教理解度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 宣教理解度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_teach_comprehend_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_teach_comprehend_degree",  getSd_teach_comprehend_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教理解度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 宣教理解度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_teach_comprehend_degreeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_teach_comprehend_degree",  getName_teach_comprehend_degreeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("宣教理解度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并发症属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_complication",  getId_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 并发症编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_complication",  getSd_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 并发症名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_complicationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_complication",  getName_complicationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("并发症名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院评估其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_assessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_assess",  getOther_assessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院评估其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药指导属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medication_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medication_guide",  getId_medication_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药指导");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 用药指导编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_medication_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_medication_guide",  getSd_medication_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药指导编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药指导名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medication_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medication_guide",  getName_medication_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("用药指导名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊用药指导属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecial_medication_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Special_medication_guide",  getSpecial_medication_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊用药指导");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 养生指导属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_health_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_health_guide",  getId_health_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("养生指导");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 养生指导编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_health_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_health_guide",  getSd_health_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("养生指导编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 养生指导名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_health_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_health_guide",  getName_health_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("养生指导名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 养生指导其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_health_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_health_guide",  getOther_health_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("养生指导其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特殊指导属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSpecial_guideADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Special_guide",  getSpecial_guideCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特殊指导");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_date",  getFill_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任护士属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_primary_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_primary_nurse",  getId_primary_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_discharge_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_discharge_way",  getId_discharge_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_discharge_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_discharge_way",  getSd_discharge_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士长签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_nur",  getId_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士长签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 备用1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field1",  getBackup_field1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field2",  getBackup_field2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field3ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field3",  getBackup_field3CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field4ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field4",  getBackup_field4CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备用5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBackup_field5ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Backup_field5",  getBackup_field5CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备用5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperation_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operation_name",  getOperation_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b28","id_operation=id_srv","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 服务编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperation_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operation_code",  getOperation_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("服务编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_srv a0b28","id_operation=id_srv","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_pro_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_pro_code",  getDisease_pro_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_disease_prognosis=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_pro_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_pro_name",  getDisease_pro_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_disease_prognosis=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_per_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_per_code",  getDisease_per_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_disease_perceive_degree=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDisease_per_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Disease_per_name",  getDisease_per_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_disease_perceive_degree=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmotions_status_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emotions_status_code",  getEmotions_status_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_emotions_status=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEmotions_status_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emotions_status_name",  getEmotions_status_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_emotions_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSelf_care_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Self_care_code",  getSelf_care_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_self_care_ability=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSelf_care_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Self_care_name",  getSelf_care_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_self_care_ability=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdm_beh_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adm_beh_code",  getAdm_beh_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_administration_behavior=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdm_beh_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adm_beh_name",  getAdm_beh_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_administration_behavior=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeach_con_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teach_con_code",  getTeach_con_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_teach_content=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeach_con_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teach_con_name",  getTeach_con_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_teach_content=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeach_way_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teach_way_code",  getTeach_way_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_teach_way=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeach_way_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teach_way_name",  getTeach_way_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_teach_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeach_com_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teach_com_code",  getTeach_com_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_teach_comprehend_degree=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTeach_com_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Teach_com_name",  getTeach_com_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_teach_comprehend_degree=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComplication_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Complication_code",  getComplication_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_complication=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getComplication_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Complication_name",  getComplication_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_complication=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedication_guide_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medication_guide_code",  getMedication_guide_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_medication_guide=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedication_guide_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Medication_guide_name",  getMedication_guide_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_medication_guide=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHealth_guide_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Health_guide_code",  getHealth_guide_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_health_guide=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHealth_guide_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Health_guide_name",  getHealth_guide_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_health_guide=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 责任护士姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_primary_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_primary_nurse",  getName_primary_nurseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("责任护士姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_primary_nurse=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_discharge_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_discharge_way",  getName_discharge_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_discharge_way=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士长姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_nur",  getName_emp_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士长姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b30","id_emp_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取出院护理评估单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nachsorgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nachsorge");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院护理评估单主键"); 
		return column;
	}
	/**
	 * 获取就诊号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊号"); 
		return column;
	}
	/**
	 * 获取集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_groupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_group");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团"); 
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
	 * 获取就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊科室"); 
		return column;
	}
	/**
	 * 获取患者姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者姓名"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取住院病案编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院病案编号"); 
		return column;
	}
	/**
	 * 获取入院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院时间"); 
		return column;
	}
	/**
	 * 获取出院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_dischargeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_discharge");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院时间"); 
		return column;
	}
	/**
	 * 获取手术表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_operation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术"); 
		return column;
	}
	/**
	 * 获取手术编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_operation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术编码"); 
		return column;
	}
	/**
	 * 获取手术日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_operation");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术日期"); 
		return column;
	}
	/**
	 * 获取手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术名称"); 
		return column;
	}
	/**
	 * 获取中医诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChinese_diagnoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chinese_diagnose");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医诊断"); 
		return column;
	}
	/**
	 * 获取证型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_document_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_document_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("证型"); 
		return column;
	}
	/**
	 * 获取西医诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWestern_diagnoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Western_diagnose");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("西医诊断"); 
		return column;
	}
	/**
	 * 获取疾病转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disease_prognosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disease_prognosis");
		column.setLength(500);
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
	private IColumnDesc getSd_disease_prognosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disease_prognosis");
		column.setLength(200);
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
	private IColumnDesc getName_disease_prognosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disease_prognosis");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病转归名称"); 
		return column;
	}
	/**
	 * 获取疾病认知度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_disease_perceive_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_disease_perceive_degree");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病认知度"); 
		return column;
	}
	/**
	 * 获取疾病认知度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_disease_perceive_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_disease_perceive_degree");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病认知度编码"); 
		return column;
	}
	/**
	 * 获取疾病认知度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_disease_perceive_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_disease_perceive_degree");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疾病认知度名称"); 
		return column;
	}
	/**
	 * 获取情志状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emotions_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emotions_status");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情志状态"); 
		return column;
	}
	/**
	 * 获取情志状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emotions_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emotions_status");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情志状态编码"); 
		return column;
	}
	/**
	 * 获取情志状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emotions_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emotions_status");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情志状态名称"); 
		return column;
	}
	/**
	 * 获取自理能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_self_care_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_self_care_ability");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力"); 
		return column;
	}
	/**
	 * 获取自理能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_self_care_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_self_care_ability");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力编码"); 
		return column;
	}
	/**
	 * 获取自理能力名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_self_care_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_self_care_ability");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力名称"); 
		return column;
	}
	/**
	 * 获取服药行为表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_administration_behaviorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_administration_behavior");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服药行为"); 
		return column;
	}
	/**
	 * 获取服药行为编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_administration_behaviorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_administration_behavior");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服药行为编码"); 
		return column;
	}
	/**
	 * 获取服药行为名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_administration_behaviorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_administration_behavior");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服药行为名称"); 
		return column;
	}
	/**
	 * 获取宣教内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_teach_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_teach_content");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教内容"); 
		return column;
	}
	/**
	 * 获取宣教内容编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_teach_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_teach_content");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教内容编码"); 
		return column;
	}
	/**
	 * 获取宣教内容名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_teach_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_teach_content");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教内容名称"); 
		return column;
	}
	/**
	 * 获取宣教方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_teach_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_teach_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教方式"); 
		return column;
	}
	/**
	 * 获取宣教方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_teach_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_teach_way");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教方式编码"); 
		return column;
	}
	/**
	 * 获取宣教方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_teach_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_teach_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教方式名称"); 
		return column;
	}
	/**
	 * 获取宣教理解度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_teach_comprehend_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_teach_comprehend_degree");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教理解度"); 
		return column;
	}
	/**
	 * 获取宣教理解度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_teach_comprehend_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_teach_comprehend_degree");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教理解度编码"); 
		return column;
	}
	/**
	 * 获取宣教理解度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_teach_comprehend_degreeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_teach_comprehend_degree");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("宣教理解度名称"); 
		return column;
	}
	/**
	 * 获取并发症表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_complication");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症"); 
		return column;
	}
	/**
	 * 获取并发症编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_complication");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症编码"); 
		return column;
	}
	/**
	 * 获取并发症名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_complicationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_complication");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("并发症名称"); 
		return column;
	}
	/**
	 * 获取出院评估其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_assessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_assess");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院评估其它"); 
		return column;
	}
	/**
	 * 获取用药指导表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medication_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medication_guide");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药指导"); 
		return column;
	}
	/**
	 * 获取用药指导编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_medication_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_medication_guide");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药指导编码"); 
		return column;
	}
	/**
	 * 获取用药指导名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medication_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medication_guide");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("用药指导名称"); 
		return column;
	}
	/**
	 * 获取特殊用药指导表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecial_medication_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Special_medication_guide");
		column.setLength(400);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊用药指导"); 
		return column;
	}
	/**
	 * 获取养生指导表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_health_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_health_guide");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("养生指导"); 
		return column;
	}
	/**
	 * 获取养生指导编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_health_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_health_guide");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("养生指导编码"); 
		return column;
	}
	/**
	 * 获取养生指导名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_health_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_health_guide");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("养生指导名称"); 
		return column;
	}
	/**
	 * 获取养生指导其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_health_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_health_guide");
		column.setLength(400);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("养生指导其它"); 
		return column;
	}
	/**
	 * 获取特殊指导表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSpecial_guideCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Special_guide");
		column.setLength(400);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特殊指导"); 
		return column;
	}
	/**
	 * 获取日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日期"); 
		return column;
	}
	/**
	 * 获取责任护士表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_primary_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_primary_nurse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士"); 
		return column;
	}
	/**
	 * 获取出院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_discharge_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_discharge_way");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院方式"); 
		return column;
	}
	/**
	 * 获取出院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_discharge_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_discharge_way");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院方式编码"); 
		return column;
	}
	/**
	 * 获取护士长签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士长签名"); 
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
	 * 获取备用1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用1"); 
		return column;
	}
	/**
	 * 获取备用2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field2");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用2"); 
		return column;
	}
	/**
	 * 获取备用3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field3CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field3");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用3"); 
		return column;
	}
	/**
	 * 获取备用4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field4CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field4");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用4"); 
		return column;
	}
	/**
	 * 获取备用5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBackup_field5CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Backup_field5");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备用5"); 
		return column;
	}
	/**
	 * 获取服务名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperation_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operation_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务名称"); 
		return column;
	}
	/**
	 * 获取服务编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperation_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operation_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("服务编码"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDisease_pro_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_pro_code");
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
	private IColumnDesc getDisease_pro_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_pro_name");
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
	private IColumnDesc getDisease_per_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_per_code");
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
	private IColumnDesc getDisease_per_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Disease_per_name");
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
	private IColumnDesc getEmotions_status_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emotions_status_code");
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
	private IColumnDesc getEmotions_status_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emotions_status_name");
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
	private IColumnDesc getSelf_care_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Self_care_code");
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
	private IColumnDesc getSelf_care_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Self_care_name");
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
	private IColumnDesc getAdm_beh_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adm_beh_code");
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
	private IColumnDesc getAdm_beh_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adm_beh_name");
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
	private IColumnDesc getTeach_con_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teach_con_code");
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
	private IColumnDesc getTeach_con_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teach_con_name");
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
	private IColumnDesc getTeach_way_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teach_way_code");
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
	private IColumnDesc getTeach_way_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teach_way_name");
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
	private IColumnDesc getTeach_com_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teach_com_code");
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
	private IColumnDesc getTeach_com_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Teach_com_name");
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
	private IColumnDesc getComplication_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Complication_code");
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
	private IColumnDesc getComplication_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Complication_name");
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
	private IColumnDesc getMedication_guide_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medication_guide_code");
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
	private IColumnDesc getMedication_guide_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Medication_guide_name");
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
	private IColumnDesc getHealth_guide_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Health_guide_code");
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
	private IColumnDesc getHealth_guide_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Health_guide_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取责任护士姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_primary_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_primary_nurse");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("责任护士姓名"); 
		return column;
	}
	/**
	 * 获取出院方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_discharge_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_discharge_way");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院方式名称"); 
		return column;
	}
	/**
	 * 获取护士长姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士长姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_group");
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
	}
	
}
