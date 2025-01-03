
package iih.nmr.pkuf.assnur.d.desc;

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
 * 入院护理评估单 DO 元数据信息
 */
public class AssnurDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.assnur.d.AssnurDO";
	public static final String CLASS_DISPALYNAME = "入院护理评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_ASSNUR";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_assnur";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AssnurDODesc(){
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
		this.setKeyDesc(getId_assnurADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_assnurADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getId_occupADesc(tblDesc));
		this.add(getSd_occupADesc(tblDesc));
		this.add(getId_edu_degADesc(tblDesc));
		this.add(getSd_edu_degADesc(tblDesc));
		this.add(getName_nationADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getWeight_dADesc(tblDesc));
		this.add(getId_admi_modeADesc(tblDesc));
		this.add(getSd_admi_modeADesc(tblDesc));
		this.add(getPast_hisADesc(tblDesc));
		this.add(getId_isdrug_hisADesc(tblDesc));
		this.add(getSd_isdrug_hisADesc(tblDesc));
		this.add(getAllergy_recordADesc(tblDesc));
		this.add(getAllergy_hisADesc(tblDesc));
		this.add(getName_mmADesc(tblDesc));
		this.add(getNv_tADesc(tblDesc));
		this.add(getInt_pulseADesc(tblDesc));
		this.add(getInt_breathingADesc(tblDesc));
		this.add(getInt_sbpADesc(tblDesc));
		this.add(getInt_dbpADesc(tblDesc));
		this.add(getId_conscADesc(tblDesc));
		this.add(getSd_conscADesc(tblDesc));
		this.add(getId_lang_commADesc(tblDesc));
		this.add(getSd_lang_commADesc(tblDesc));
		this.add(getId_limb_movADesc(tblDesc));
		this.add(getSd_limb_movADesc(tblDesc));
		this.add(getId_visionADesc(tblDesc));
		this.add(getSd_visionADesc(tblDesc));
		this.add(getId_hearADesc(tblDesc));
		this.add(getSd_hearADesc(tblDesc));
		this.add(getId_swallowADesc(tblDesc));
		this.add(getSd_swallowADesc(tblDesc));
		this.add(getId_iswoundADesc(tblDesc));
		this.add(getSd_iswoundADesc(tblDesc));
		this.add(getWoundADesc(tblDesc));
		this.add(getId_skin_condADesc(tblDesc));
		this.add(getName_skin_condADesc(tblDesc));
		this.add(getSd_skin_condADesc(tblDesc));
		this.add(getId_moc_lipADesc(tblDesc));
		this.add(getSd_moc_lipADesc(tblDesc));
		this.add(getId_dietADesc(tblDesc));
		this.add(getSd_dietADesc(tblDesc));
		this.add(getName_dietADesc(tblDesc));
		this.add(getId_sleepADesc(tblDesc));
		this.add(getSd_sleepADesc(tblDesc));
		this.add(getId_mictADesc(tblDesc));
		this.add(getSd_mictADesc(tblDesc));
		this.add(getId_defecADesc(tblDesc));
		this.add(getSd_defecADesc(tblDesc));
		this.add(getSc_biADesc(tblDesc));
		this.add(getId_ispainADesc(tblDesc));
		this.add(getSd_ispainADesc(tblDesc));
		this.add(getSc_painADesc(tblDesc));
		this.add(getLoca_painADesc(tblDesc));
		this.add(getId_nature_painADesc(tblDesc));
		this.add(getSd_nature_painADesc(tblDesc));
		this.add(getId_way_painADesc(tblDesc));
		this.add(getSd_way_painADesc(tblDesc));
		this.add(getSc_bradenADesc(tblDesc));
		this.add(getSc_morseADesc(tblDesc));
		this.add(getId_is_pipeADesc(tblDesc));
		this.add(getSd_is_pipeADesc(tblDesc));
		this.add(getId_class_pipeADesc(tblDesc));
		this.add(getName_class_pipeADesc(tblDesc));
		this.add(getSd_class_pipeADesc(tblDesc));
		this.add(getId_dis_consADesc(tblDesc));
		this.add(getSd_dis_consADesc(tblDesc));
		this.add(getId_act_abilitADesc(tblDesc));
		this.add(getSd_act_abilitADesc(tblDesc));
		this.add(getId_nur_preaADesc(tblDesc));
		this.add(getName_nur_preaADesc(tblDesc));
		this.add(getSd_nur_preaADesc(tblDesc));
		this.add(getId_symptADesc(tblDesc));
		this.add(getSd_symptADesc(tblDesc));
		this.add(getId_mentalityADesc(tblDesc));
		this.add(getSd_mentalityADesc(tblDesc));
		this.add(getId_excretionADesc(tblDesc));
		this.add(getName_excretionADesc(tblDesc));
		this.add(getSd_excretionADesc(tblDesc));
		this.add(getId_psy_recaADesc(tblDesc));
		this.add(getName_psy_recaADesc(tblDesc));
		this.add(getSd_psy_recaADesc(tblDesc));
		this.add(getId_dise_undersADesc(tblDesc));
		this.add(getSd_dise_undersADesc(tblDesc));
		this.add(getId_pro_infoADesc(tblDesc));
		this.add(getSd_pro_infoADesc(tblDesc));
		this.add(getMember_patientADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getMcomplaintADesc(tblDesc));
		this.add(getCmedihisADesc(tblDesc));
		this.add(getId_short_pulseADesc(tblDesc));
		this.add(getSd_short_pulseADesc(tblDesc));
		this.add(getBlsugarADesc(tblDesc));
		this.add(getId_empADesc(tblDesc));
		this.add(getScore_fallriskADesc(tblDesc));
		this.add(getHeart_valueADesc(tblDesc));
		this.add(getDef_stringfADesc(tblDesc));
		this.add(getDef_stringtADesc(tblDesc));
		this.add(getDef_stringthADesc(tblDesc));
		this.add(getDef_stringfoADesc(tblDesc));
		this.add(getDef_stringfiADesc(tblDesc));
		this.add(getDef_doublefADesc(tblDesc));
		this.add(getDef_doubletADesc(tblDesc));
		this.add(getDef_doublefhADesc(tblDesc));
		this.add(getDef_doublefoADesc(tblDesc));
		this.add(getDef_doublefiADesc(tblDesc));
		this.add(getOperationhisADesc(tblDesc));
		this.add(getId_psystatesADesc(tblDesc));
		this.add(getSd_psystatesADesc(tblDesc));
		this.add(getId_toothADesc(tblDesc));
		this.add(getSd_toothADesc(tblDesc));
		this.add(getId_rashADesc(tblDesc));
		this.add(getSd_rashADesc(tblDesc));
		this.add(getName_wrashADesc(tblDesc));
		this.add(getName_bodyADesc(tblDesc));
		this.add(getPresoresADesc(tblDesc));
		this.add(getId_acheADesc(tblDesc));
		this.add(getName_acheADesc(tblDesc));
		this.add(getSd_acheADesc(tblDesc));
		this.add(getId_nutritionADesc(tblDesc));
		this.add(getSd_nutritionADesc(tblDesc));
		this.add(getName_occupADesc(tblDesc));
		this.add(getName_edu_degADesc(tblDesc));
		this.add(getName_admi_modeADesc(tblDesc));
		this.add(getName_isdrug_hisADesc(tblDesc));
		this.add(getName_conscADesc(tblDesc));
		this.add(getName_lang_commADesc(tblDesc));
		this.add(getName_limb_movADesc(tblDesc));
		this.add(getName_visionADesc(tblDesc));
		this.add(getName_hearADesc(tblDesc));
		this.add(getName_swallowADesc(tblDesc));
		this.add(getName_iswoundADesc(tblDesc));
		this.add(getName_moc_lipADesc(tblDesc));
		this.add(getName_sleepADesc(tblDesc));
		this.add(getName_mictADesc(tblDesc));
		this.add(getName_defecADesc(tblDesc));
		this.add(getName_ispainADesc(tblDesc));
		this.add(getName_nature_painADesc(tblDesc));
		this.add(getName_way_painADesc(tblDesc));
		this.add(getName_is_pipeADesc(tblDesc));
		this.add(getName_dis_consADesc(tblDesc));
		this.add(getName_act_abilitADesc(tblDesc));
		this.add(getName_symptADesc(tblDesc));
		this.add(getName_mentalityADesc(tblDesc));
		this.add(getName_dise_undersADesc(tblDesc));
		this.add(getName_pro_infoADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_short_pulseADesc(tblDesc));
		this.add(getName_empADesc(tblDesc));
		this.add(getName_psystatesADesc(tblDesc));
		this.add(getName_toothADesc(tblDesc));
		this.add(getName_rashADesc(tblDesc));
		this.add(getName_nutritionADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_assnurCDesc(tblDesc));
		tblDesc.add(getId_assnurCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_occupCDesc(tblDesc));
		tblDesc.add(getSd_occupCDesc(tblDesc));
		tblDesc.add(getId_edu_degCDesc(tblDesc));
		tblDesc.add(getSd_edu_degCDesc(tblDesc));
		tblDesc.add(getName_nationCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getWeight_dCDesc(tblDesc));
		tblDesc.add(getId_admi_modeCDesc(tblDesc));
		tblDesc.add(getSd_admi_modeCDesc(tblDesc));
		tblDesc.add(getPast_hisCDesc(tblDesc));
		tblDesc.add(getId_isdrug_hisCDesc(tblDesc));
		tblDesc.add(getSd_isdrug_hisCDesc(tblDesc));
		tblDesc.add(getAllergy_recordCDesc(tblDesc));
		tblDesc.add(getAllergy_hisCDesc(tblDesc));
		tblDesc.add(getName_mmCDesc(tblDesc));
		tblDesc.add(getNv_tCDesc(tblDesc));
		tblDesc.add(getInt_pulseCDesc(tblDesc));
		tblDesc.add(getInt_breathingCDesc(tblDesc));
		tblDesc.add(getInt_sbpCDesc(tblDesc));
		tblDesc.add(getInt_dbpCDesc(tblDesc));
		tblDesc.add(getId_conscCDesc(tblDesc));
		tblDesc.add(getSd_conscCDesc(tblDesc));
		tblDesc.add(getId_lang_commCDesc(tblDesc));
		tblDesc.add(getSd_lang_commCDesc(tblDesc));
		tblDesc.add(getId_limb_movCDesc(tblDesc));
		tblDesc.add(getSd_limb_movCDesc(tblDesc));
		tblDesc.add(getId_visionCDesc(tblDesc));
		tblDesc.add(getSd_visionCDesc(tblDesc));
		tblDesc.add(getId_hearCDesc(tblDesc));
		tblDesc.add(getSd_hearCDesc(tblDesc));
		tblDesc.add(getId_swallowCDesc(tblDesc));
		tblDesc.add(getSd_swallowCDesc(tblDesc));
		tblDesc.add(getId_iswoundCDesc(tblDesc));
		tblDesc.add(getSd_iswoundCDesc(tblDesc));
		tblDesc.add(getWoundCDesc(tblDesc));
		tblDesc.add(getId_skin_condCDesc(tblDesc));
		tblDesc.add(getName_skin_condCDesc(tblDesc));
		tblDesc.add(getSd_skin_condCDesc(tblDesc));
		tblDesc.add(getId_moc_lipCDesc(tblDesc));
		tblDesc.add(getSd_moc_lipCDesc(tblDesc));
		tblDesc.add(getId_dietCDesc(tblDesc));
		tblDesc.add(getSd_dietCDesc(tblDesc));
		tblDesc.add(getName_dietCDesc(tblDesc));
		tblDesc.add(getId_sleepCDesc(tblDesc));
		tblDesc.add(getSd_sleepCDesc(tblDesc));
		tblDesc.add(getId_mictCDesc(tblDesc));
		tblDesc.add(getSd_mictCDesc(tblDesc));
		tblDesc.add(getId_defecCDesc(tblDesc));
		tblDesc.add(getSd_defecCDesc(tblDesc));
		tblDesc.add(getSc_biCDesc(tblDesc));
		tblDesc.add(getId_ispainCDesc(tblDesc));
		tblDesc.add(getSd_ispainCDesc(tblDesc));
		tblDesc.add(getSc_painCDesc(tblDesc));
		tblDesc.add(getLoca_painCDesc(tblDesc));
		tblDesc.add(getId_nature_painCDesc(tblDesc));
		tblDesc.add(getSd_nature_painCDesc(tblDesc));
		tblDesc.add(getId_way_painCDesc(tblDesc));
		tblDesc.add(getSd_way_painCDesc(tblDesc));
		tblDesc.add(getSc_bradenCDesc(tblDesc));
		tblDesc.add(getSc_morseCDesc(tblDesc));
		tblDesc.add(getId_is_pipeCDesc(tblDesc));
		tblDesc.add(getSd_is_pipeCDesc(tblDesc));
		tblDesc.add(getId_class_pipeCDesc(tblDesc));
		tblDesc.add(getName_class_pipeCDesc(tblDesc));
		tblDesc.add(getSd_class_pipeCDesc(tblDesc));
		tblDesc.add(getId_dis_consCDesc(tblDesc));
		tblDesc.add(getSd_dis_consCDesc(tblDesc));
		tblDesc.add(getId_act_abilitCDesc(tblDesc));
		tblDesc.add(getSd_act_abilitCDesc(tblDesc));
		tblDesc.add(getId_nur_preaCDesc(tblDesc));
		tblDesc.add(getName_nur_preaCDesc(tblDesc));
		tblDesc.add(getSd_nur_preaCDesc(tblDesc));
		tblDesc.add(getId_symptCDesc(tblDesc));
		tblDesc.add(getSd_symptCDesc(tblDesc));
		tblDesc.add(getId_mentalityCDesc(tblDesc));
		tblDesc.add(getSd_mentalityCDesc(tblDesc));
		tblDesc.add(getId_excretionCDesc(tblDesc));
		tblDesc.add(getName_excretionCDesc(tblDesc));
		tblDesc.add(getSd_excretionCDesc(tblDesc));
		tblDesc.add(getId_psy_recaCDesc(tblDesc));
		tblDesc.add(getName_psy_recaCDesc(tblDesc));
		tblDesc.add(getSd_psy_recaCDesc(tblDesc));
		tblDesc.add(getId_dise_undersCDesc(tblDesc));
		tblDesc.add(getSd_dise_undersCDesc(tblDesc));
		tblDesc.add(getId_pro_infoCDesc(tblDesc));
		tblDesc.add(getSd_pro_infoCDesc(tblDesc));
		tblDesc.add(getMember_patientCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getMcomplaintCDesc(tblDesc));
		tblDesc.add(getCmedihisCDesc(tblDesc));
		tblDesc.add(getId_short_pulseCDesc(tblDesc));
		tblDesc.add(getSd_short_pulseCDesc(tblDesc));
		tblDesc.add(getBlsugarCDesc(tblDesc));
		tblDesc.add(getId_empCDesc(tblDesc));
		tblDesc.add(getScore_fallriskCDesc(tblDesc));
		tblDesc.add(getHeart_valueCDesc(tblDesc));
		tblDesc.add(getDef_stringfCDesc(tblDesc));
		tblDesc.add(getDef_stringtCDesc(tblDesc));
		tblDesc.add(getDef_stringthCDesc(tblDesc));
		tblDesc.add(getDef_stringfoCDesc(tblDesc));
		tblDesc.add(getDef_stringfiCDesc(tblDesc));
		tblDesc.add(getDef_doublefCDesc(tblDesc));
		tblDesc.add(getDef_doubletCDesc(tblDesc));
		tblDesc.add(getDef_doublefhCDesc(tblDesc));
		tblDesc.add(getDef_doublefoCDesc(tblDesc));
		tblDesc.add(getDef_doublefiCDesc(tblDesc));
		tblDesc.add(getOperationhisCDesc(tblDesc));
		tblDesc.add(getId_psystatesCDesc(tblDesc));
		tblDesc.add(getSd_psystatesCDesc(tblDesc));
		tblDesc.add(getId_toothCDesc(tblDesc));
		tblDesc.add(getSd_toothCDesc(tblDesc));
		tblDesc.add(getId_rashCDesc(tblDesc));
		tblDesc.add(getSd_rashCDesc(tblDesc));
		tblDesc.add(getName_wrashCDesc(tblDesc));
		tblDesc.add(getName_bodyCDesc(tblDesc));
		tblDesc.add(getPresoresCDesc(tblDesc));
		tblDesc.add(getId_acheCDesc(tblDesc));
		tblDesc.add(getName_acheCDesc(tblDesc));
		tblDesc.add(getSd_acheCDesc(tblDesc));
		tblDesc.add(getId_nutritionCDesc(tblDesc));
		tblDesc.add(getSd_nutritionCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 入院护理主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_assnurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_assnur",  getId_assnurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院护理主键");
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
	 * 诊断ID(通用)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断ID(通用)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断(通用)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断(通用)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职业属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_occupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_occup",  getId_occupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职业编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_occupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_occup",  getSd_occupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_edu_degADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_edu_deg",  getId_edu_degCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文化程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_edu_degADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_edu_deg",  getSd_edu_degCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nation",  getName_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight",  getWeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重(支持文本)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWeight_dADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Weight_d",  getWeight_dCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体重(支持文本)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_admi_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_admi_mode",  getId_admi_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_admi_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_admi_mode",  getSd_admi_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式编码");
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
	private IAttrDesc getPast_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Past_his",  getPast_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("既往史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物过敏史是否属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_isdrug_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_isdrug_his",  getId_isdrug_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物过敏史是否");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 药物过敏史是否编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_isdrug_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_isdrug_his",  getSd_isdrug_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物过敏史是否编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAllergy_recordADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Allergy_record",  getAllergy_recordCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏记录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAllergy_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Allergy_his",  getAllergy_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药品过敏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mm",  getName_mmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药品过敏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNv_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nv_t",  getNv_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉搏属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_pulse",  getInt_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("脉搏");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_breathingADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_breathing",  getInt_breathingCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("呼吸");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_sbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_sbp",  getInt_sbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("收缩压");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舒张压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getInt_dbpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Int_dbp",  getInt_dbpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("舒张压");
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
	private IAttrDesc getId_conscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_consc",  getId_conscCDesc(tblDesc), this);
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
	private IAttrDesc getSd_conscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_consc",  getSd_conscCDesc(tblDesc), this);
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
	 * 语言沟通属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lang_commADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lang_comm",  getId_lang_commCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言沟通");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 语言沟通编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lang_commADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lang_comm",  getSd_lang_commCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言沟通编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 四肢活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_limb_movADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_limb_mov",  getId_limb_movCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("四肢活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 四肢活动编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_limb_movADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_limb_mov",  getSd_limb_movCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("四肢活动编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 视力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_visionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_vision",  getId_visionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("视力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 视力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_visionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_vision",  getSd_visionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("视力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 听力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hear",  getId_hearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("听力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 听力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hear",  getSd_hearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("听力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吞咽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_swallowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_swallow",  getId_swallowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吞咽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 吞咽编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_swallowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_swallow",  getSd_swallowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吞咽编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_iswoundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_iswound",  getId_iswoundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 伤口有无编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_iswoundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_iswound",  getSd_iswoundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口有无编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWoundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wound",  getWoundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤情况ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skin_condADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin_cond",  getId_skin_condCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤情况ID");
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
	private IAttrDesc getName_skin_condADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin_cond",  getName_skin_condCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skin_condADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin_cond",  getSd_skin_condCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口唇粘膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_moc_lipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_moc_lip",  getId_moc_lipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口唇粘膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 口唇粘膜编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_moc_lipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_moc_lip",  getSd_moc_lipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口唇粘膜编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diet",  getId_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diet",  getSd_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet",  getName_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 睡眠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sleep",  getId_sleepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 睡眠编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sleep",  getSd_sleepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排尿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mictADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mict",  getId_mictCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排尿编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mictADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mict",  getSd_mictCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_defecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_defec",  getId_defecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排便编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_defecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_defec",  getSd_defecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Barthel指数（BI）评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_biADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_bi",  getSc_biCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("Barthel指数（BI）评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ispainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ispain",  getId_ispainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疼痛有无编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ispainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ispain",  getSd_ispainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛有无编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_pain",  getSc_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("疼痛评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLoca_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Loca_pain",  getLoca_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nature_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nature_pain",  getId_nature_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疼痛性质编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nature_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nature_pain",  getSd_nature_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛性质编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛评估方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_way_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_way_pain",  getId_way_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛评估方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疼痛评估方法编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_way_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_way_pain",  getSd_way_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛评估方法编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Braden评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_bradenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_braden",  getSc_bradenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("Braden评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Morse评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_morseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_morse",  getSc_morseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("Morse评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_is_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_is_pipe",  getId_is_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导管有无编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_is_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_is_pipe",  getSd_is_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管有无编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管分类ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_class_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_class_pipe",  getId_class_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管分类ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_class_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_class_pipe",  getName_class_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 导管分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_class_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_class_pipe",  getSd_class_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识障碍属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dis_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dis_cons",  getId_dis_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识障碍");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识障碍编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dis_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dis_cons",  getSd_dis_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识障碍编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_act_abilitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_act_abilit",  getId_act_abilitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 活动能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_act_abilitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_act_abilit",  getSd_act_abilitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * displaynam108属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_preaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_prea",  getId_nur_preaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("displaynam108");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理操作属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_preaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_prea",  getName_nur_preaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理操作");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理操作编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nur_preaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nur_prea",  getSd_nur_preaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理操作编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 症状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_symptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sympt",  getId_symptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 症状编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_symptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sympt",  getSd_symptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精神状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mentality",  getId_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 精神状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mentality",  getSd_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排泄ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_excretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_excretion",  getId_excretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排泄ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排泄属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_excretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_excretion",  getName_excretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排泄");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 排泄编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_excretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_excretion",  getSd_excretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排泄编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理反应ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psy_recaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psy_reca",  getId_psy_recaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理反应ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psy_recaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psy_reca",  getName_psy_recaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 心理反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_psy_recaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psy_reca",  getSd_psy_recaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者对疾病理解属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dise_undersADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dise_unders",  getId_dise_undersCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者对疾病理解");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者对疾病理解编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dise_undersADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dise_unders",  getSd_dise_undersCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者对疾病理解编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提供资料者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pro_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pro_info",  getId_pro_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提供资料者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 提供资料者编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pro_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pro_info",  getSd_pro_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提供资料者编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者家属（与患者关系）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMember_patientADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Member_patient",  getMember_patientCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者家属（与患者关系）");
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
	 * 主诉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMcomplaintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mcomplaint",  getMcomplaintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主诉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 现病史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCmedihisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cmedihis",  getCmedihisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("现病史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脉搏短础id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_short_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_short_pulse",  getId_short_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脉搏短础id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脉搏短础属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_short_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_short_pulse",  getSd_short_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脉搏短础");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血糖值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlsugarADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blsugar",  getBlsugarCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("血糖值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_empADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp",  getId_empCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 坠床评估得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_fallriskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_fallrisk",  getScore_fallriskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("坠床评估得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心率值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeart_valueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Heart_value",  getHeart_valueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("心率值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文本扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_stringfADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_stringf",  getDef_stringfCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文本扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文本扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_stringtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_stringt",  getDef_stringtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文本扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文本扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_stringthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_stringth",  getDef_stringthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文本扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文本扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_stringfoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_stringfo",  getDef_stringfoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文本扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文本扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_stringfiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_stringfi",  getDef_stringfiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文本扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数值扩展字段1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_doublefADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_doublef",  getDef_doublefCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数值扩展字段1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数值扩展字段2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_doubletADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_doublet",  getDef_doubletCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数值扩展字段2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数值扩展字段3属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_doublefhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_doublefh",  getDef_doublefhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数值扩展字段3");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数值扩展字段4属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_doublefoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_doublefo",  getDef_doublefoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数值扩展字段4");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 数值扩展字段5属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDef_doublefiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Def_doublefi",  getDef_doublefiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("数值扩展字段5");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手术史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOperationhisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Operationhis",  getOperationhisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手术史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 心理状态ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psystatesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psystates",  getId_psystatesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("心理状态ID");
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
	private IAttrDesc getSd_psystatesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_psystates",  getSd_psystatesCDesc(tblDesc), this);
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
	 * 义齿ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_toothADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tooth",  getId_toothCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("义齿ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 义齿编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_toothADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tooth",  getSd_toothCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("义齿编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮疹ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_rashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_rash",  getId_rashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮疹ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮疹编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rash",  getSd_rashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮疹编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮疹类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_wrashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_wrash",  getName_wrashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮疹类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 分布属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bodyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_body",  getName_bodyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("分布");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPresoresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Presores",  getPresoresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_acheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ache",  getId_acheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛Id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_acheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ache",  getName_acheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 疼痛编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_acheADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ache",  getSd_acheCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nutrition",  getId_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 营养编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nutrition",  getSd_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职业属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_occupADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_occup",  getName_occupCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职业");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_occup=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_edu_degADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_edu_deg",  getName_edu_degCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_edu_deg=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_admi_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_admi_mode",  getName_admi_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_admi_mode=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药物过敏史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_isdrug_hisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_isdrug_his",  getName_isdrug_hisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药物过敏史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_isdrug_his=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_conscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_consc",  getName_conscCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_consc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言沟通属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lang_commADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lang_comm",  getName_lang_commCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言沟通");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_lang_comm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 四肢活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_limb_movADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_limb_mov",  getName_limb_movCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("四肢活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_limb_mov=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 视力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_visionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_vision",  getName_visionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("视力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_vision=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 听力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hear",  getName_hearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("听力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_hear=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 吞咽属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_swallowADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_swallow",  getName_swallowCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("吞咽");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_swallow=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 伤口属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_iswoundADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_iswound",  getName_iswoundCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("伤口");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_iswound=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口唇粘膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_moc_lipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_moc_lip",  getName_moc_lipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口唇粘膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_moc_lip=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sleepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sleep",  getName_sleepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_sleep=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排尿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mictADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mict",  getName_mictCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排尿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_mict=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排便属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_defecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_defec",  getName_defecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排便");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_defec=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ispainADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ispain",  getName_ispainCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_ispain=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nature_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nature_pain",  getName_nature_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_nature_pain=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 疼痛评估方法属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_way_painADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_way_pain",  getName_way_painCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("疼痛评估方法");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_way_pain=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 导管属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_is_pipeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_is_pipe",  getName_is_pipeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("导管");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_is_pipe=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识障碍属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dis_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dis_cons",  getName_dis_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识障碍");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_dis_cons=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_act_abilitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_act_abilit",  getName_act_abilitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_act_abilit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 症状属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_symptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sympt",  getName_symptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("症状");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_sympt=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 精神状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mentalityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mentality",  getName_mentalityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("精神状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_mentality=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者对疾病的理解属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dise_undersADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dise_unders",  getName_dise_undersCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者对疾病的理解");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_dise_unders=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提供资料者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pro_infoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pro_info",  getName_pro_infoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提供资料者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_pro_info=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b36","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_short_pulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_short_pulse",  getName_short_pulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","id_short_pulse=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b39","id_emp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psystatesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psystates",  getName_psystatesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_psystates=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_toothADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tooth",  getName_toothCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b46","id_tooth=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rashADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rash",  getName_rashCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_rash=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nutrition",  getName_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b45","id_nutrition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取入院护理主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_assnurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_assnur");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院护理主键"); 
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
	 * 获取诊断ID(通用)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断ID(通用)"); 
		return column;
	}
	/**
	 * 获取诊断(通用)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断(通用)"); 
		return column;
	}
	/**
	 * 获取职业表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_occupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_occup");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业"); 
		return column;
	}
	/**
	 * 获取职业编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_occupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_occup");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业编码"); 
		return column;
	}
	/**
	 * 获取文化程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_edu_degCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_edu_deg");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度"); 
		return column;
	}
	/**
	 * 获取文化程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_edu_degCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_edu_deg");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度编码"); 
		return column;
	}
	/**
	 * 获取民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族"); 
		return column;
	}
	/**
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取体重(支持文本)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWeight_dCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Weight_d");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体重(支持文本)"); 
		return column;
	}
	/**
	 * 获取入院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_admi_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_admi_mode");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式"); 
		return column;
	}
	/**
	 * 获取入院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_admi_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_admi_mode");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式编码"); 
		return column;
	}
	/**
	 * 获取既往史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPast_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Past_his");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史"); 
		return column;
	}
	/**
	 * 获取药物过敏史是否表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_isdrug_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_isdrug_his");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药物过敏史是否"); 
		return column;
	}
	/**
	 * 获取药物过敏史是否编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_isdrug_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_isdrug_his");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药物过敏史是否编码"); 
		return column;
	}
	/**
	 * 获取过敏记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAllergy_recordCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Allergy_record");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏记录"); 
		return column;
	}
	/**
	 * 获取过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAllergy_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Allergy_his");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏史"); 
		return column;
	}
	/**
	 * 获取药品过敏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mm");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药品过敏"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNv_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nv_t");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("体温"); 
		return column;
	}
	/**
	 * 获取脉搏表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("脉搏"); 
		return column;
	}
	/**
	 * 获取呼吸表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_breathingCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_breathing");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸"); 
		return column;
	}
	/**
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_sbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_sbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("收缩压"); 
		return column;
	}
	/**
	 * 获取舒张压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getInt_dbpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Int_dbp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_conscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_consc");
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
	private IColumnDesc getSd_conscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_consc");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识编码"); 
		return column;
	}
	/**
	 * 获取语言沟通表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lang_commCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lang_comm");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言沟通"); 
		return column;
	}
	/**
	 * 获取语言沟通编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lang_commCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lang_comm");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言沟通编码"); 
		return column;
	}
	/**
	 * 获取四肢活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_limb_movCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_limb_mov");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("四肢活动"); 
		return column;
	}
	/**
	 * 获取四肢活动编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_limb_movCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_limb_mov");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("四肢活动编码"); 
		return column;
	}
	/**
	 * 获取视力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_visionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_vision");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("视力"); 
		return column;
	}
	/**
	 * 获取视力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_visionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_vision");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("视力编码"); 
		return column;
	}
	/**
	 * 获取听力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hear");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("听力"); 
		return column;
	}
	/**
	 * 获取听力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hear");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("听力编码"); 
		return column;
	}
	/**
	 * 获取吞咽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_swallowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_swallow");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吞咽"); 
		return column;
	}
	/**
	 * 获取吞咽编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_swallowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_swallow");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吞咽编码"); 
		return column;
	}
	/**
	 * 获取伤口有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_iswoundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_iswound");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口有无"); 
		return column;
	}
	/**
	 * 获取伤口有无编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_iswoundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_iswound");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口有无编码"); 
		return column;
	}
	/**
	 * 获取伤口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWoundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wound");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口"); 
		return column;
	}
	/**
	 * 获取皮肤情况ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skin_condCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin_cond");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤情况ID"); 
		return column;
	}
	/**
	 * 获取皮肤情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skin_condCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin_cond");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤情况"); 
		return column;
	}
	/**
	 * 获取皮肤情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skin_condCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin_cond");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤情况编码"); 
		return column;
	}
	/**
	 * 获取口唇粘膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_moc_lipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_moc_lip");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口唇粘膜"); 
		return column;
	}
	/**
	 * 获取口唇粘膜编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_moc_lipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_moc_lip");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口唇粘膜编码"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食"); 
		return column;
	}
	/**
	 * 获取饮食编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食编码"); 
		return column;
	}
	/**
	 * 获取饮食名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食名称"); 
		return column;
	}
	/**
	 * 获取睡眠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sleep");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠"); 
		return column;
	}
	/**
	 * 获取睡眠编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sleep");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠编码"); 
		return column;
	}
	/**
	 * 获取排尿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mictCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mict");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿"); 
		return column;
	}
	/**
	 * 获取排尿编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mictCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mict");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿编码"); 
		return column;
	}
	/**
	 * 获取排便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_defecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_defec");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便"); 
		return column;
	}
	/**
	 * 获取排便编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_defecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_defec");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便编码"); 
		return column;
	}
	/**
	 * 获取Barthel指数（BI）评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_biCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_bi");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("Barthel指数（BI）评分"); 
		return column;
	}
	/**
	 * 获取疼痛有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ispainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ispain");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛有无"); 
		return column;
	}
	/**
	 * 获取疼痛有无编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ispainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ispain");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛有无编码"); 
		return column;
	}
	/**
	 * 获取疼痛评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_pain");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("疼痛评分"); 
		return column;
	}
	/**
	 * 获取疼痛部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLoca_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Loca_pain");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛部位"); 
		return column;
	}
	/**
	 * 获取疼痛性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nature_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nature_pain");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛性质"); 
		return column;
	}
	/**
	 * 获取疼痛性质编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nature_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nature_pain");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛性质编码"); 
		return column;
	}
	/**
	 * 获取疼痛评估方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_way_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_way_pain");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛评估方法"); 
		return column;
	}
	/**
	 * 获取疼痛评估方法编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_way_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_way_pain");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛评估方法编码"); 
		return column;
	}
	/**
	 * 获取Braden评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_bradenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_braden");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("Braden评分"); 
		return column;
	}
	/**
	 * 获取Morse评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_morseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_morse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("Morse评分"); 
		return column;
	}
	/**
	 * 获取导管有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_is_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_is_pipe");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管有无"); 
		return column;
	}
	/**
	 * 获取导管有无编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_is_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_is_pipe");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管有无编码"); 
		return column;
	}
	/**
	 * 获取导管分类ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_class_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_class_pipe");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管分类ID"); 
		return column;
	}
	/**
	 * 获取导管分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_class_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_class_pipe");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管分类"); 
		return column;
	}
	/**
	 * 获取导管分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_class_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_class_pipe");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管分类编码"); 
		return column;
	}
	/**
	 * 获取意识障碍表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dis_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dis_cons");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识障碍"); 
		return column;
	}
	/**
	 * 获取意识障碍编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dis_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dis_cons");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识障碍编码"); 
		return column;
	}
	/**
	 * 获取活动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_act_abilitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_act_abilit");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动能力"); 
		return column;
	}
	/**
	 * 获取活动能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_act_abilitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_act_abilit");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动能力编码"); 
		return column;
	}
	/**
	 * 获取displaynam108表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_preaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_prea");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("displaynam108"); 
		return column;
	}
	/**
	 * 获取护理操作表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_preaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_prea");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理操作"); 
		return column;
	}
	/**
	 * 获取护理操作编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nur_preaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nur_prea");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理操作编码"); 
		return column;
	}
	/**
	 * 获取症状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_symptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sympt");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状"); 
		return column;
	}
	/**
	 * 获取症状编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_symptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sympt");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状编码"); 
		return column;
	}
	/**
	 * 获取精神状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mentality");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神状态"); 
		return column;
	}
	/**
	 * 获取精神状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mentality");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神状态编码"); 
		return column;
	}
	/**
	 * 获取排泄ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_excretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_excretion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄ID"); 
		return column;
	}
	/**
	 * 获取排泄表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_excretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_excretion");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄"); 
		return column;
	}
	/**
	 * 获取排泄编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_excretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_excretion");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄编码"); 
		return column;
	}
	/**
	 * 获取心理反应ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psy_recaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psy_reca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理反应ID"); 
		return column;
	}
	/**
	 * 获取心理反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psy_recaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psy_reca");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理反应"); 
		return column;
	}
	/**
	 * 获取心理反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psy_recaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psy_reca");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理反应编码"); 
		return column;
	}
	/**
	 * 获取患者对疾病理解表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dise_undersCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dise_unders");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者对疾病理解"); 
		return column;
	}
	/**
	 * 获取患者对疾病理解编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dise_undersCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dise_unders");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者对疾病理解编码"); 
		return column;
	}
	/**
	 * 获取提供资料者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pro_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pro_info");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提供资料者"); 
		return column;
	}
	/**
	 * 获取提供资料者编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pro_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pro_info");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提供资料者编码"); 
		return column;
	}
	/**
	 * 获取患者家属（与患者关系）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMember_patientCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Member_patient");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者家属（与患者关系）"); 
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
	 * 获取主诉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMcomplaintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mcomplaint");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主诉"); 
		return column;
	}
	/**
	 * 获取现病史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCmedihisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cmedihis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("现病史"); 
		return column;
	}
	/**
	 * 获取脉搏短础id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_short_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_short_pulse");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉搏短础id"); 
		return column;
	}
	/**
	 * 获取脉搏短础表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_short_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_short_pulse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脉搏短础"); 
		return column;
	}
	/**
	 * 获取血糖值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlsugarCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blsugar");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("血糖值"); 
		return column;
	}
	/**
	 * 获取护士长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士长"); 
		return column;
	}
	/**
	 * 获取坠床评估得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_fallriskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_fallrisk");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("坠床评估得分"); 
		return column;
	}
	/**
	 * 获取心率值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeart_valueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Heart_value");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("心率值"); 
		return column;
	}
	/**
	 * 获取文本扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_stringfCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_stringf");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文本扩展字段1"); 
		return column;
	}
	/**
	 * 获取文本扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_stringtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_stringt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文本扩展字段2"); 
		return column;
	}
	/**
	 * 获取文本扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_stringthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_stringth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文本扩展字段3"); 
		return column;
	}
	/**
	 * 获取文本扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_stringfoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_stringfo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文本扩展字段4"); 
		return column;
	}
	/**
	 * 获取文本扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_stringfiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_stringfi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文本扩展字段5"); 
		return column;
	}
	/**
	 * 获取数值扩展字段1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_doublefCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_doublef");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数值扩展字段1"); 
		return column;
	}
	/**
	 * 获取数值扩展字段2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_doubletCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_doublet");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数值扩展字段2"); 
		return column;
	}
	/**
	 * 获取数值扩展字段3表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_doublefhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_doublefh");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数值扩展字段3"); 
		return column;
	}
	/**
	 * 获取数值扩展字段4表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_doublefoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_doublefo");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数值扩展字段4"); 
		return column;
	}
	/**
	 * 获取数值扩展字段5表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDef_doublefiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Def_doublefi");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("数值扩展字段5"); 
		return column;
	}
	/**
	 * 获取手术史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOperationhisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Operationhis");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手术史"); 
		return column;
	}
	/**
	 * 获取心理状态ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psystatesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psystates");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态ID"); 
		return column;
	}
	/**
	 * 获取心理状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_psystatesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_psystates");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("心理状态编码"); 
		return column;
	}
	/**
	 * 获取义齿ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_toothCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tooth");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("义齿ID"); 
		return column;
	}
	/**
	 * 获取义齿编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_toothCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tooth");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("义齿编码"); 
		return column;
	}
	/**
	 * 获取皮疹ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_rashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_rash");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮疹ID"); 
		return column;
	}
	/**
	 * 获取皮疹编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rash");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮疹编码"); 
		return column;
	}
	/**
	 * 获取皮疹类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_wrashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_wrash");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮疹类型名称"); 
		return column;
	}
	/**
	 * 获取分布表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bodyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_body");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("分布"); 
		return column;
	}
	/**
	 * 获取压疮表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPresoresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Presores");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮"); 
		return column;
	}
	/**
	 * 获取疼痛Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_acheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ache");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛Id"); 
		return column;
	}
	/**
	 * 获取疼痛名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_acheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ache");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛名称"); 
		return column;
	}
	/**
	 * 获取疼痛编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_acheCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ache");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛编码"); 
		return column;
	}
	/**
	 * 获取营养ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nutrition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养ID"); 
		return column;
	}
	/**
	 * 获取营养编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nutrition");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养编码"); 
		return column;
	}
	/**
	 * 获取职业表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_occupCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_occup");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职业"); 
		return column;
	}
	/**
	 * 获取文化程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_edu_degCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_edu_deg");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度"); 
		return column;
	}
	/**
	 * 获取入院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_admi_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_admi_mode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式"); 
		return column;
	}
	/**
	 * 获取药物过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_isdrug_hisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_isdrug_his");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药物过敏史"); 
		return column;
	}
	/**
	 * 获取意识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_conscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_consc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识"); 
		return column;
	}
	/**
	 * 获取语言沟通表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lang_commCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lang_comm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言沟通"); 
		return column;
	}
	/**
	 * 获取四肢活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_limb_movCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_limb_mov");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("四肢活动"); 
		return column;
	}
	/**
	 * 获取视力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_visionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_vision");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("视力"); 
		return column;
	}
	/**
	 * 获取听力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hear");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("听力"); 
		return column;
	}
	/**
	 * 获取吞咽表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_swallowCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_swallow");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("吞咽"); 
		return column;
	}
	/**
	 * 获取伤口表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_iswoundCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_iswound");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("伤口"); 
		return column;
	}
	/**
	 * 获取口唇粘膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_moc_lipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_moc_lip");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口唇粘膜"); 
		return column;
	}
	/**
	 * 获取睡眠表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sleepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sleep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠"); 
		return column;
	}
	/**
	 * 获取排尿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mictCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mict");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排尿"); 
		return column;
	}
	/**
	 * 获取排便表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_defecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_defec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排便"); 
		return column;
	}
	/**
	 * 获取疼痛表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ispainCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ispain");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛"); 
		return column;
	}
	/**
	 * 获取疼痛性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nature_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nature_pain");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛性质"); 
		return column;
	}
	/**
	 * 获取疼痛评估方法表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_way_painCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_way_pain");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("疼痛评估方法"); 
		return column;
	}
	/**
	 * 获取导管表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_is_pipeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_is_pipe");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("导管"); 
		return column;
	}
	/**
	 * 获取意识障碍表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dis_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dis_cons");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识障碍"); 
		return column;
	}
	/**
	 * 获取活动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_act_abilitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_act_abilit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动能力"); 
		return column;
	}
	/**
	 * 获取症状表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_symptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sympt");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("症状"); 
		return column;
	}
	/**
	 * 获取精神状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mentalityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mentality");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("精神状态"); 
		return column;
	}
	/**
	 * 获取患者对疾病的理解表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dise_undersCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dise_unders");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者对疾病的理解"); 
		return column;
	}
	/**
	 * 获取提供资料者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pro_infoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pro_info");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提供资料者"); 
		return column;
	}
	/**
	 * 获取评估人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估人"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_short_pulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_short_pulse");
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
	private IColumnDesc getName_empCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psystatesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psystates");
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
	private IColumnDesc getName_toothCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tooth");
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
	private IColumnDesc getName_rashCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rash");
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
	private IColumnDesc getName_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nutrition");
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
	}
	
}
