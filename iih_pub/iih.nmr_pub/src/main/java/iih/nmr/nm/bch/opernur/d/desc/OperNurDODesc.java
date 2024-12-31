
package iih.nmr.nm.bch.opernur.d.desc;

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
 * 围手术期患者评估记录单 DO 元数据信息
 */
public class OperNurDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.nm.bch.opernur.d.OperNurDO";
	public static final String CLASS_DISPALYNAME = "围手术期患者评估记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_BCH_OPERNUR";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_opernur";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OperNurDODesc(){
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
		this.setKeyDesc(getId_opernurADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_opernurADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getNv_t_beforeADesc(tblDesc));
		this.add(getInt_pulse_beforeADesc(tblDesc));
		this.add(getInt_breath_beforeADesc(tblDesc));
		this.add(getInt_sbp_beforeADesc(tblDesc));
		this.add(getInt_dbp_beforeADesc(tblDesc));
		this.add(getDt_eval_beforeADesc(tblDesc));
		this.add(getId_mental_stateADesc(tblDesc));
		this.add(getSd_mental_stateADesc(tblDesc));
		this.add(getId_past_historyADesc(tblDesc));
		this.add(getSd_past_historyADesc(tblDesc));
		this.add(getOther_past_historyADesc(tblDesc));
		this.add(getId_nutrition_statusADesc(tblDesc));
		this.add(getSd_nutrition_statusADesc(tblDesc));
		this.add(getDt_fast_beginADesc(tblDesc));
		this.add(getName_operationADesc(tblDesc));
		this.add(getDt_operationADesc(tblDesc));
		this.add(getId_anesthesiaADesc(tblDesc));
		this.add(getSd_anesthesiaADesc(tblDesc));
		this.add(getOther_anesthesiaADesc(tblDesc));
		this.add(getEu_oper_siteADesc(tblDesc));
		this.add(getId_skin_prepareADesc(tblDesc));
		this.add(getSd_skin_prepareADesc(tblDesc));
		this.add(getId_blood_prepareADesc(tblDesc));
		this.add(getSd_blood_prepareADesc(tblDesc));
		this.add(getId_pipeADesc(tblDesc));
		this.add(getSd_pipeADesc(tblDesc));
		this.add(getOther_pipeADesc(tblDesc));
		this.add(getId_pre_medicADesc(tblDesc));
		this.add(getSd_pre_medicADesc(tblDesc));
		this.add(getStableADesc(tblDesc));
		this.add(getAlprazolamADesc(tblDesc));
		this.add(getOther_medicADesc(tblDesc));
		this.add(getDt_medicADesc(tblDesc));
		this.add(getId_sleep_stateADesc(tblDesc));
		this.add(getSd_sleep_stateADesc(tblDesc));
		this.add(getId_pre_educationADesc(tblDesc));
		this.add(getSd_pre_educationADesc(tblDesc));
		this.add(getId_symp_manageADesc(tblDesc));
		this.add(getSd_symp_manageADesc(tblDesc));
		this.add(getId_selfcare_abilityADesc(tblDesc));
		this.add(getSd_selfcare_abilityADesc(tblDesc));
		this.add(getOther_recordADesc(tblDesc));
		this.add(getFg_icuADesc(tblDesc));
		this.add(getNv_t_afterADesc(tblDesc));
		this.add(getInt_pulse_afterADesc(tblDesc));
		this.add(getInt_breath_afterADesc(tblDesc));
		this.add(getInt_sbp_afterADesc(tblDesc));
		this.add(getInt_dbp_afterADesc(tblDesc));
		this.add(getDt_eval_afterADesc(tblDesc));
		this.add(getEu_vein_channelADesc(tblDesc));
		this.add(getEu_unobstructedADesc(tblDesc));
		this.add(getSiteADesc(tblDesc));
		this.add(getId_after_anesthesiaADesc(tblDesc));
		this.add(getSd_after_anesthesiaADesc(tblDesc));
		this.add(getOther_after_anesthesiaADesc(tblDesc));
		this.add(getSurgical_wayADesc(tblDesc));
		this.add(getId_awarenessADesc(tblDesc));
		this.add(getSd_awarenessADesc(tblDesc));
		this.add(getEu_lefteye_reflectADesc(tblDesc));
		this.add(getEu_lefteye_sizeADesc(tblDesc));
		this.add(getEu_skin_stateADesc(tblDesc));
		this.add(getLocation_areaADesc(tblDesc));
		this.add(getEu_righteye_reflectADesc(tblDesc));
		this.add(getEu_righteye_sizeADesc(tblDesc));
		this.add(getEu_exudateADesc(tblDesc));
		this.add(getEu_oozingADesc(tblDesc));
		this.add(getEu_sheddingADesc(tblDesc));
		this.add(getId_pressure_levelADesc(tblDesc));
		this.add(getSd_pressure_levelADesc(tblDesc));
		this.add(getEu_urinary_patencyADesc(tblDesc));
		this.add(getPosition_drainageADesc(tblDesc));
		this.add(getName_drainageADesc(tblDesc));
		this.add(getEu_obstructedADesc(tblDesc));
		this.add(getProperties_drainageADesc(tblDesc));
		this.add(getId_after_educationADesc(tblDesc));
		this.add(getSd_after_educationADesc(tblDesc));
		this.add(getId_symp_manageafterADesc(tblDesc));
		this.add(getSd_symp_manageafterADesc(tblDesc));
		this.add(getId_selfcare_abilityafterADesc(tblDesc));
		this.add(getSd_selfcare_abilityafterADesc(tblDesc));
		this.add(getAfter_other_recordADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getId_nurADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_mental_stateADesc(tblDesc));
		this.add(getName_past_historyADesc(tblDesc));
		this.add(getName_nutrition_statusADesc(tblDesc));
		this.add(getName_anesthesiaADesc(tblDesc));
		this.add(getName_skin_prepareADesc(tblDesc));
		this.add(getName_blood_prepareADesc(tblDesc));
		this.add(getName_pipeADesc(tblDesc));
		this.add(getName_pre_medicADesc(tblDesc));
		this.add(getName_sleep_stateADesc(tblDesc));
		this.add(getName_pre_educationADesc(tblDesc));
		this.add(getName_symp_manageADesc(tblDesc));
		this.add(getName_selfcare_abilityADesc(tblDesc));
		this.add(getName_after_anesthesiaADesc(tblDesc));
		this.add(getName_awarenessADesc(tblDesc));
		this.add(getName_pressure_levelADesc(tblDesc));
		this.add(getName_after_educationADesc(tblDesc));
		this.add(getName_symp_manageafterADesc(tblDesc));
		this.add(getName_selfcare_abilityafterADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_nurADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_opernurCDesc(tblDesc));
		tblDesc.add(getId_opernurCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getNv_t_beforeCDesc(tblDesc));
		tblDesc.add(getInt_pulse_beforeCDesc(tblDesc));
		tblDesc.add(getInt_breath_beforeCDesc(tblDesc));
		tblDesc.add(getInt_sbp_beforeCDesc(tblDesc));
		tblDesc.add(getInt_dbp_beforeCDesc(tblDesc));
		tblDesc.add(getDt_eval_beforeCDesc(tblDesc));
		tblDesc.add(getId_mental_stateCDesc(tblDesc));
		tblDesc.add(getSd_mental_stateCDesc(tblDesc));
		tblDesc.add(getId_past_historyCDesc(tblDesc));
		tblDesc.add(getSd_past_historyCDesc(tblDesc));
		tblDesc.add(getOther_past_historyCDesc(tblDesc));
		tblDesc.add(getId_nutrition_statusCDesc(tblDesc));
		tblDesc.add(getSd_nutrition_statusCDesc(tblDesc));
		tblDesc.add(getDt_fast_beginCDesc(tblDesc));
		tblDesc.add(getName_operationCDesc(tblDesc));
		tblDesc.add(getDt_operationCDesc(tblDesc));
		tblDesc.add(getId_anesthesiaCDesc(tblDesc));
		tblDesc.add(getSd_anesthesiaCDesc(tblDesc));
		tblDesc.add(getOther_anesthesiaCDesc(tblDesc));
		tblDesc.add(getEu_oper_siteCDesc(tblDesc));
		tblDesc.add(getId_skin_prepareCDesc(tblDesc));
		tblDesc.add(getSd_skin_prepareCDesc(tblDesc));
		tblDesc.add(getId_blood_prepareCDesc(tblDesc));
		tblDesc.add(getSd_blood_prepareCDesc(tblDesc));
		tblDesc.add(getId_pipeCDesc(tblDesc));
		tblDesc.add(getSd_pipeCDesc(tblDesc));
		tblDesc.add(getOther_pipeCDesc(tblDesc));
		tblDesc.add(getId_pre_medicCDesc(tblDesc));
		tblDesc.add(getSd_pre_medicCDesc(tblDesc));
		tblDesc.add(getStableCDesc(tblDesc));
		tblDesc.add(getAlprazolamCDesc(tblDesc));
		tblDesc.add(getOther_medicCDesc(tblDesc));
		tblDesc.add(getDt_medicCDesc(tblDesc));
		tblDesc.add(getId_sleep_stateCDesc(tblDesc));
		tblDesc.add(getSd_sleep_stateCDesc(tblDesc));
		tblDesc.add(getId_pre_educationCDesc(tblDesc));
		tblDesc.add(getSd_pre_educationCDesc(tblDesc));
		tblDesc.add(getId_symp_manageCDesc(tblDesc));
		tblDesc.add(getSd_symp_manageCDesc(tblDesc));
		tblDesc.add(getId_selfcare_abilityCDesc(tblDesc));
		tblDesc.add(getSd_selfcare_abilityCDesc(tblDesc));
		tblDesc.add(getOther_recordCDesc(tblDesc));
		tblDesc.add(getFg_icuCDesc(tblDesc));
		tblDesc.add(getNv_t_afterCDesc(tblDesc));
		tblDesc.add(getInt_pulse_afterCDesc(tblDesc));
		tblDesc.add(getInt_breath_afterCDesc(tblDesc));
		tblDesc.add(getInt_sbp_afterCDesc(tblDesc));
		tblDesc.add(getInt_dbp_afterCDesc(tblDesc));
		tblDesc.add(getDt_eval_afterCDesc(tblDesc));
		tblDesc.add(getEu_vein_channelCDesc(tblDesc));
		tblDesc.add(getEu_unobstructedCDesc(tblDesc));
		tblDesc.add(getSiteCDesc(tblDesc));
		tblDesc.add(getId_after_anesthesiaCDesc(tblDesc));
		tblDesc.add(getSd_after_anesthesiaCDesc(tblDesc));
		tblDesc.add(getOther_after_anesthesiaCDesc(tblDesc));
		tblDesc.add(getSurgical_wayCDesc(tblDesc));
		tblDesc.add(getId_awarenessCDesc(tblDesc));
		tblDesc.add(getSd_awarenessCDesc(tblDesc));
		tblDesc.add(getEu_lefteye_reflectCDesc(tblDesc));
		tblDesc.add(getEu_lefteye_sizeCDesc(tblDesc));
		tblDesc.add(getEu_skin_stateCDesc(tblDesc));
		tblDesc.add(getLocation_areaCDesc(tblDesc));
		tblDesc.add(getEu_righteye_reflectCDesc(tblDesc));
		tblDesc.add(getEu_righteye_sizeCDesc(tblDesc));
		tblDesc.add(getEu_exudateCDesc(tblDesc));
		tblDesc.add(getEu_oozingCDesc(tblDesc));
		tblDesc.add(getEu_sheddingCDesc(tblDesc));
		tblDesc.add(getId_pressure_levelCDesc(tblDesc));
		tblDesc.add(getSd_pressure_levelCDesc(tblDesc));
		tblDesc.add(getEu_urinary_patencyCDesc(tblDesc));
		tblDesc.add(getPosition_drainageCDesc(tblDesc));
		tblDesc.add(getName_drainageCDesc(tblDesc));
		tblDesc.add(getEu_obstructedCDesc(tblDesc));
		tblDesc.add(getProperties_drainageCDesc(tblDesc));
		tblDesc.add(getId_after_educationCDesc(tblDesc));
		tblDesc.add(getSd_after_educationCDesc(tblDesc));
		tblDesc.add(getId_symp_manageafterCDesc(tblDesc));
		tblDesc.add(getSd_symp_manageafterCDesc(tblDesc));
		tblDesc.add(getId_selfcare_abilityafterCDesc(tblDesc));
		tblDesc.add(getSd_selfcare_abilityafterCDesc(tblDesc));
		tblDesc.add(getAfter_other_recordCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getId_nurCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 围手术id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_opernurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_opernur",  getId_opernurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("围手术id");
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
	 * 就诊病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pat",  getId_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者ID");
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
	 * 就诊ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊ID");
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
	 * 年龄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAgeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Age",  getAgeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄");
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
	 * 诊断Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sexADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sex",  getName_sexCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNv_t_beforeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nv_t_before",  getNv_t_beforeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术前体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_pulse_beforeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_pulse_before",  getInt_pulse_beforeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前脉搏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_breath_beforeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_breath_before",  getInt_breath_beforeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_sbp_beforeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_sbp_before",  getInt_sbp_beforeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_dbp_beforeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_dbp_before",  getInt_dbp_beforeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术前舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前评估时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eval_beforeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_eval_before",  getDt_eval_beforeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("术前评估时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mental_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mental_state",  getId_mental_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 心理状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mental_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mental_state",  getSd_mental_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_past_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_past_history",  getId_past_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 既往史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_past_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_past_history",  getSd_past_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往史其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_past_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_past_history",  getOther_past_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往史其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nutrition_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nutrition_status",  getId_nutrition_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 营养状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nutrition_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nutrition_status",  getSd_nutrition_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 禁食开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_fast_beginADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_fast_begin",  getDt_fast_beginCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("禁食开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拟行手术名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_operation",  getName_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拟行手术名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_operationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_operation",  getDt_operationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("手术时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拟行麻醉方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_anesthesia",  getId_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拟行麻醉方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 拟行麻醉方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_anesthesia",  getSd_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拟行麻醉方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拟行麻醉方式其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_anesthesia",  getOther_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拟行麻醉方式其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术部位识别标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_oper_siteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_oper_site",  getEu_oper_siteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("手术部位识别标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备皮属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_prepareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_prepare",  getId_skin_prepareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备皮");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备皮编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_prepareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_prepare",  getSd_skin_prepareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备皮编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_prepareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_prepare",  getId_blood_prepareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 备血编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blood_prepareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blood_prepare",  getSd_blood_prepareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pipe",  getId_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 置管编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pipe",  getSd_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_pipe",  getOther_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pre_medicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pre_medic",  getId_pre_medicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前用药编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pre_medicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pre_medic",  getSd_pre_medicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前用药编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 安定用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getStableADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Stable",  getStableCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("安定用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 阿普唑仑属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAlprazolamADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Alprazolam",  getAlprazolamCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("阿普唑仑");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他用药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_medicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_medic",  getOther_medicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他用药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 用药时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_medicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_medic",  getDt_medicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("用药时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sleep_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sleep_state",  getId_sleep_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠状况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 睡眠状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sleep_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sleep_state",  getSd_sleep_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠状况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前宣教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pre_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pre_education",  getId_pre_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前宣教");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术前宣教编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pre_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pre_education",  getSd_pre_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前宣教编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 症状管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_symp_manageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_symp_manage",  getId_symp_manageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 症状管理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_symp_manageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_symp_manage",  getSd_symp_manageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状管理编码");
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
	private IAttrDesc getId_selfcare_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_selfcare_ability",  getId_selfcare_abilityCDesc(tblDesc), this);
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
	private IAttrDesc getSd_selfcare_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_selfcare_ability",  getSd_selfcare_abilityCDesc(tblDesc), this);
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
	 * 其他记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_record",  getOther_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他记录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后ICU属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_icuADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_icu",  getFg_icuCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("术后ICU");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNv_t_afterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nv_t_after",  getNv_t_afterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("术后体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_pulse_afterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_pulse_after",  getInt_pulse_afterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后脉搏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_breath_afterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_breath_after",  getInt_breath_afterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_sbp_afterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_sbp_after",  getInt_sbp_afterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_dbp_afterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_dbp_after",  getInt_dbp_afterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("术后舒张压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后评估时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_eval_afterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_eval_after",  getDt_eval_afterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("术后评估时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉通道属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_vein_channelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_vein_channel",  getEu_vein_channelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("静脉通道");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通畅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_unobstructedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_unobstructed",  getEu_unobstructedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("通畅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSiteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Site",  getSiteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_after_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_after_anesthesia",  getId_after_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 麻醉方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_after_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_after_anesthesia",  getSd_after_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_after_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_after_anesthesia",  getOther_after_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSurgical_wayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Surgical_way",  getSurgical_wayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_awareness",  getId_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_awareness",  getSd_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左瞳对光反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_lefteye_reflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_lefteye_reflect",  getEu_lefteye_reflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("左瞳对光反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 左瞳大小属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_lefteye_sizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_lefteye_size",  getEu_lefteye_sizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("左瞳大小");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_skin_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_skin_state",  getEu_skin_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("皮肤情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤位置面积属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLocation_areaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Location_area",  getLocation_areaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤位置面积");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳对光反射属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_righteye_reflectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_righteye_reflect",  getEu_righteye_reflectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("右瞳对光反射");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 右瞳大小属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_righteye_sizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_righteye_size",  getEu_righteye_sizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("右瞳大小");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渗液情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_exudateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_exudate",  getEu_exudateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("渗液情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 渗血情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_oozingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_oozing",  getEu_oozingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("渗血情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 敷料脱落属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_sheddingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_shedding",  getEu_sheddingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("敷料脱落");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受压程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pressure_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pressure_level",  getId_pressure_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受压程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受压程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pressure_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pressure_level",  getSd_pressure_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受压程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 尿管通畅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_urinary_patencyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_urinary_patency",  getEu_urinary_patencyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("尿管通畅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管位置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPosition_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Position_drainage",  getPosition_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管位置");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_drainage",  getName_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否通畅属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_obstructedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_obstructed",  getEu_obstructedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否通畅");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 引流液性状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProperties_drainageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Properties_drainage",  getProperties_drainageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("引流液性状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后宣教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_after_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_after_education",  getId_after_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后宣教");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后宣教编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_after_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_after_education",  getSd_after_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后宣教编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后症状管理属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_symp_manageafterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_symp_manageafter",  getId_symp_manageafterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后症状管理");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后症状管理编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_symp_manageafterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_symp_manageafter",  getSd_symp_manageafterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后症状管理编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后自理能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_selfcare_abilityafterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_selfcare_abilityafter",  getId_selfcare_abilityafterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后自理能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 术后自理能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_selfcare_abilityafterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_selfcare_abilityafter",  getSd_selfcare_abilityafterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后自理能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后其他记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAfter_other_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("After_other_record",  getAfter_other_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后其他记录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * id_sign属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("id_sign");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur",  getId_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护师签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护师签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * dt_create属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("dt_create");
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
	 * 心理状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mental_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mental_state",  getName_mental_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_mental_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往史名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_past_historyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_past_history",  getName_past_historyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往史名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_past_history=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养状况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nutrition_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nutrition_status",  getName_nutrition_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养状况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_nutrition_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_anesthesia",  getName_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_anesthesia=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备皮名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skin_prepareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin_prepare",  getName_skin_prepareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备皮名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_skin_prepare=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备血名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_prepareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_prepare",  getName_blood_prepareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备血名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_blood_prepare=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 置管名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pipe",  getName_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("置管名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_pipe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前用药名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pre_medicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pre_medic",  getName_pre_medicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前用药名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_pre_medic=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sleep_stateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sleep_state",  getName_sleep_stateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_sleep_state=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术前健康宣教名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pre_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pre_education",  getName_pre_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术前健康宣教名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_pre_education=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 症状管理名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_symp_manageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_symp_manage",  getName_symp_manageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状管理名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_symp_manage=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自理能力名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_selfcare_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_selfcare_ability",  getName_selfcare_abilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自理能力名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_selfcare_ability=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 麻醉方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_after_anesthesiaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_after_anesthesia",  getName_after_anesthesiaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("麻醉方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_after_anesthesia=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_awarenessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_awareness",  getName_awarenessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_awareness=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受压程度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pressure_levelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pressure_level",  getName_pressure_levelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受压程度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_pressure_level=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 术后宣教名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_after_educationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_after_education",  getName_after_educationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("术后宣教名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_after_education=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_symp_manageafterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_symp_manageafter",  getName_symp_manageafterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_symp_manageafter=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_selfcare_abilityafterADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_selfcare_abilityafter",  getName_selfcare_abilityafterCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_selfcare_abilityafter=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b29","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur",  getName_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b30","id_nur=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp",  getName_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b31","id_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取围手术id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_opernurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_opernur");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("围手术id"); 
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
	 * 获取就诊病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊病区"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者ID"); 
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
	 * 获取就诊ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊ID"); 
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
	 * 获取年龄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAgeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄"); 
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
	 * 获取诊断Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断Id"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sexCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sex");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("性别"); 
		return column;
	}
	/**
	 * 获取术前体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNv_t_beforeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nv_t_before");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术前体温"); 
		return column;
	}
	/**
	 * 获取术前脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_pulse_beforeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_pulse_before");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前脉搏"); 
		return column;
	}
	/**
	 * 获取术前呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_breath_beforeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_breath_before");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前呼吸"); 
		return column;
	}
	/**
	 * 获取术前收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_sbp_beforeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_sbp_before");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前收缩压"); 
		return column;
	}
	/**
	 * 获取术前舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_dbp_beforeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_dbp_before");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术前舒张压"); 
		return column;
	}
	/**
	 * 获取术前评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eval_beforeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_eval_before");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术前评估时间"); 
		return column;
	}
	/**
	 * 获取心理状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mental_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mental_state");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态"); 
		return column;
	}
	/**
	 * 获取心理状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mental_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mental_state");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态编码"); 
		return column;
	}
	/**
	 * 获取既往史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_past_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_past_history");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史"); 
		return column;
	}
	/**
	 * 获取既往史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_past_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_past_history");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史编码"); 
		return column;
	}
	/**
	 * 获取既往史其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_past_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_past_history");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史其他"); 
		return column;
	}
	/**
	 * 获取营养状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nutrition_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nutrition_status");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养状况"); 
		return column;
	}
	/**
	 * 获取营养状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nutrition_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nutrition_status");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养状况编码"); 
		return column;
	}
	/**
	 * 获取禁食开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_fast_beginCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_fast_begin");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("禁食开始时间"); 
		return column;
	}
	/**
	 * 获取拟行手术名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_operation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拟行手术名称"); 
		return column;
	}
	/**
	 * 获取手术时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_operationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_operation");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手术时间"); 
		return column;
	}
	/**
	 * 获取拟行麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_anesthesia");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拟行麻醉方式"); 
		return column;
	}
	/**
	 * 获取拟行麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_anesthesia");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拟行麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取拟行麻醉方式其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_anesthesia");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拟行麻醉方式其他"); 
		return column;
	}
	/**
	 * 获取手术部位识别标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_oper_siteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_oper_site");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("手术部位识别标识"); 
		return column;
	}
	/**
	 * 获取备皮表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_prepareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_prepare");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备皮"); 
		return column;
	}
	/**
	 * 获取备皮编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_prepareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_prepare");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备皮编码"); 
		return column;
	}
	/**
	 * 获取备血表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_prepareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_prepare");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血"); 
		return column;
	}
	/**
	 * 获取备血编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blood_prepareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blood_prepare");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血编码"); 
		return column;
	}
	/**
	 * 获取置管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pipe");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管"); 
		return column;
	}
	/**
	 * 获取置管编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pipe");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管编码"); 
		return column;
	}
	/**
	 * 获取置管其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_pipe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管其他"); 
		return column;
	}
	/**
	 * 获取术前用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pre_medicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pre_medic");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前用药"); 
		return column;
	}
	/**
	 * 获取术前用药编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pre_medicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pre_medic");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前用药编码"); 
		return column;
	}
	/**
	 * 获取安定用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getStableCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Stable");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("安定用药"); 
		return column;
	}
	/**
	 * 获取阿普唑仑表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAlprazolamCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Alprazolam");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("阿普唑仑"); 
		return column;
	}
	/**
	 * 获取其他用药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_medicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_medic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他用药"); 
		return column;
	}
	/**
	 * 获取用药时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_medicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_medic");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("用药时间"); 
		return column;
	}
	/**
	 * 获取睡眠状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sleep_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sleep_state");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠状况"); 
		return column;
	}
	/**
	 * 获取睡眠状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sleep_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sleep_state");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠状况编码"); 
		return column;
	}
	/**
	 * 获取术前宣教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pre_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pre_education");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前宣教"); 
		return column;
	}
	/**
	 * 获取术前宣教编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pre_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pre_education");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前宣教编码"); 
		return column;
	}
	/**
	 * 获取症状管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_symp_manageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_symp_manage");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状管理"); 
		return column;
	}
	/**
	 * 获取症状管理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_symp_manageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_symp_manage");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状管理编码"); 
		return column;
	}
	/**
	 * 获取自理能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_selfcare_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_selfcare_ability");
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
	private IColumnDesc getSd_selfcare_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_selfcare_ability");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力编码"); 
		return column;
	}
	/**
	 * 获取其他记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_record");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他记录"); 
		return column;
	}
	/**
	 * 获取术后ICU表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_icuCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_icu");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术后ICU"); 
		return column;
	}
	/**
	 * 获取术后体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNv_t_afterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nv_t_after");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("术后体温"); 
		return column;
	}
	/**
	 * 获取术后脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_pulse_afterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_pulse_after");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后脉搏"); 
		return column;
	}
	/**
	 * 获取术后呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_breath_afterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_breath_after");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后呼吸"); 
		return column;
	}
	/**
	 * 获取术后收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_sbp_afterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_sbp_after");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后收缩压"); 
		return column;
	}
	/**
	 * 获取术后舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_dbp_afterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_dbp_after");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("术后舒张压"); 
		return column;
	}
	/**
	 * 获取术后评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_eval_afterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_eval_after");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("术后评估时间"); 
		return column;
	}
	/**
	 * 获取静脉通道表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_vein_channelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_vein_channel");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("静脉通道"); 
		return column;
	}
	/**
	 * 获取通畅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_unobstructedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_unobstructed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("通畅"); 
		return column;
	}
	/**
	 * 获取部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSiteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Site");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部位"); 
		return column;
	}
	/**
	 * 获取麻醉方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_after_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_after_anesthesia");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式"); 
		return column;
	}
	/**
	 * 获取麻醉方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_after_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_after_anesthesia");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式编码"); 
		return column;
	}
	/**
	 * 获取麻醉方式其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_after_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_after_anesthesia");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式其他"); 
		return column;
	}
	/**
	 * 获取手术方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSurgical_wayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Surgical_way");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术方式"); 
		return column;
	}
	/**
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_awareness");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识"); 
		return column;
	}
	/**
	 * 获取意识编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_awareness");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识编码"); 
		return column;
	}
	/**
	 * 获取左瞳对光反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_lefteye_reflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_lefteye_reflect");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("左瞳对光反射"); 
		return column;
	}
	/**
	 * 获取左瞳大小表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_lefteye_sizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_lefteye_size");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("左瞳大小"); 
		return column;
	}
	/**
	 * 获取皮肤情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_skin_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_skin_state");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("皮肤情况"); 
		return column;
	}
	/**
	 * 获取皮肤位置面积表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLocation_areaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Location_area");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤位置面积"); 
		return column;
	}
	/**
	 * 获取右瞳对光反射表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_righteye_reflectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_righteye_reflect");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("右瞳对光反射"); 
		return column;
	}
	/**
	 * 获取右瞳大小表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_righteye_sizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_righteye_size");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("右瞳大小"); 
		return column;
	}
	/**
	 * 获取渗液情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_exudateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_exudate");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("渗液情况"); 
		return column;
	}
	/**
	 * 获取渗血情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_oozingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_oozing");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("渗血情况"); 
		return column;
	}
	/**
	 * 获取敷料脱落表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_sheddingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_shedding");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("敷料脱落"); 
		return column;
	}
	/**
	 * 获取受压程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pressure_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pressure_level");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受压程度"); 
		return column;
	}
	/**
	 * 获取受压程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pressure_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pressure_level");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受压程度编码"); 
		return column;
	}
	/**
	 * 获取尿管通畅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_urinary_patencyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_urinary_patency");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("尿管通畅"); 
		return column;
	}
	/**
	 * 获取引流管位置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPosition_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Position_drainage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管位置"); 
		return column;
	}
	/**
	 * 获取引流管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_drainage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流管名称"); 
		return column;
	}
	/**
	 * 获取是否通畅表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_obstructedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_obstructed");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否通畅"); 
		return column;
	}
	/**
	 * 获取引流液性状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProperties_drainageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Properties_drainage");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("引流液性状"); 
		return column;
	}
	/**
	 * 获取术后宣教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_after_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_after_education");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后宣教"); 
		return column;
	}
	/**
	 * 获取术后宣教编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_after_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_after_education");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后宣教编码"); 
		return column;
	}
	/**
	 * 获取术后症状管理表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_symp_manageafterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_symp_manageafter");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后症状管理"); 
		return column;
	}
	/**
	 * 获取术后症状管理编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_symp_manageafterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_symp_manageafter");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后症状管理编码"); 
		return column;
	}
	/**
	 * 获取术后自理能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_selfcare_abilityafterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_selfcare_abilityafter");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后自理能力"); 
		return column;
	}
	/**
	 * 获取术后自理能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_selfcare_abilityafterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_selfcare_abilityafter");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后自理能力编码"); 
		return column;
	}
	/**
	 * 获取术后其他记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAfter_other_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"After_other_record");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后其他记录"); 
		return column;
	}
	/**
	 * 获取id_sign表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("id_sign"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取护师签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护师签名"); 
		return column;
	}
	/**
	 * 获取dt_create表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("dt_create"); 
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
	 * 获取心理状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mental_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mental_state");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态名称"); 
		return column;
	}
	/**
	 * 获取既往史名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_past_historyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_past_history");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史名称"); 
		return column;
	}
	/**
	 * 获取营养状况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nutrition_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nutrition_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养状况名称"); 
		return column;
	}
	/**
	 * 获取麻醉方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_anesthesia");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式名称"); 
		return column;
	}
	/**
	 * 获取备皮名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skin_prepareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin_prepare");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备皮名称"); 
		return column;
	}
	/**
	 * 获取备血名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_prepareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_prepare");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备血名称"); 
		return column;
	}
	/**
	 * 获取置管名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("置管名称"); 
		return column;
	}
	/**
	 * 获取术前用药名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pre_medicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pre_medic");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前用药名称"); 
		return column;
	}
	/**
	 * 获取睡眠状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sleep_stateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sleep_state");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠状态名称"); 
		return column;
	}
	/**
	 * 获取术前健康宣教名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pre_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pre_education");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术前健康宣教名称"); 
		return column;
	}
	/**
	 * 获取症状管理名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_symp_manageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_symp_manage");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状管理名称"); 
		return column;
	}
	/**
	 * 获取自理能力名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_selfcare_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_selfcare_ability");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自理能力名称"); 
		return column;
	}
	/**
	 * 获取麻醉方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_after_anesthesiaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_after_anesthesia");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("麻醉方式名称"); 
		return column;
	}
	/**
	 * 获取意识名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_awarenessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_awareness");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识名称"); 
		return column;
	}
	/**
	 * 获取受压程度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pressure_levelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pressure_level");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受压程度名称"); 
		return column;
	}
	/**
	 * 获取术后宣教名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_after_educationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_after_education");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("术后宣教名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_symp_manageafterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_symp_manageafter");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_selfcare_abilityafterCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_selfcare_abilityafter");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("pid","Id_org");
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
	}
	
}
