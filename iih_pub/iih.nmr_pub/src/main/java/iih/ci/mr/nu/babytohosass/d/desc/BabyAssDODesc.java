
package iih.ci.mr.nu.babytohosass.d.desc;

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
 * 新生儿基本信息 DO 元数据信息
 */
public class BabyAssDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.babytohosass.d.BabyAssDO";
	public static final String CLASS_DISPALYNAME = "新生儿基本信息";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "MR_NU_BABYASS";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_baby";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BabyAssDODesc(){
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
		this.setKeyDesc(getId_babyADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_babyADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getName_parentADesc(tblDesc));
		this.add(getName_medhispreADesc(tblDesc));
		this.add(getPre_relatADesc(tblDesc));
		this.add(getTelADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getDt_collectdataADesc(tblDesc));
		this.add(getHosp_reasonADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getId_product_modeADesc(tblDesc));
		this.add(getSd_product_modeADesc(tblDesc));
		this.add(getProduct_mode_otherADesc(tblDesc));
		this.add(getId_feed_modeADesc(tblDesc));
		this.add(getSd_feed_modeADesc(tblDesc));
		this.add(getBirth_orderADesc(tblDesc));
		this.add(getLy_inADesc(tblDesc));
		this.add(getId_fetal_ageADesc(tblDesc));
		this.add(getSd_fetal_ageADesc(tblDesc));
		this.add(getPreterm_birth_weekADesc(tblDesc));
		this.add(getTwinsADesc(tblDesc));
		this.add(getTempADesc(tblDesc));
		this.add(getPulseADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getHeadsizeADesc(tblDesc));
		this.add(getHeightADesc(tblDesc));
		this.add(getId_mind_statesADesc(tblDesc));
		this.add(getSd_mind_statesADesc(tblDesc));
		this.add(getId_cryADesc(tblDesc));
		this.add(getSd_cryADesc(tblDesc));
		this.add(getId_limb_exerADesc(tblDesc));
		this.add(getSd_limb_exerADesc(tblDesc));
		this.add(getId_muscle_toneADesc(tblDesc));
		this.add(getSd_muscle_toneADesc(tblDesc));
		this.add(getId_reflex_actionADesc(tblDesc));
		this.add(getSd_reflex_actionADesc(tblDesc));
		this.add(getId_face_colorADesc(tblDesc));
		this.add(getSd_face_colorADesc(tblDesc));
		this.add(getFace_color_otherADesc(tblDesc));
		this.add(getId_mouth_mucosaADesc(tblDesc));
		this.add(getSd_mouth_mucosaADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getId_breath_statesADesc(tblDesc));
		this.add(getSd_breath_statesADesc(tblDesc));
		this.add(getBreath_states_otherADesc(tblDesc));
		this.add(getId_digestive_systemADesc(tblDesc));
		this.add(getSd_digestive_systemADesc(tblDesc));
		this.add(getId_funicleADesc(tblDesc));
		this.add(getSd_funicleADesc(tblDesc));
		this.add(getId_peri_umbilicusADesc(tblDesc));
		this.add(getSd_peri_umbilicusADesc(tblDesc));
		this.add(getPeri_umbilicus_otherADesc(tblDesc));
		this.add(getSubject_situatADesc(tblDesc));
		this.add(getNur_manageADesc(tblDesc));
		this.add(getName_nur_psn1ADesc(tblDesc));
		this.add(getId_nur_psn1ADesc(tblDesc));
		this.add(getName_nur_psn2ADesc(tblDesc));
		this.add(getId_nur_psn2ADesc(tblDesc));
		this.add(getDt_assADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getId_psn_signADesc(tblDesc));
		this.add(getName_product_modeADesc(tblDesc));
		this.add(getName_feed_modeADesc(tblDesc));
		this.add(getName_fetal_ageADesc(tblDesc));
		this.add(getName_mind_statesADesc(tblDesc));
		this.add(getName_cryADesc(tblDesc));
		this.add(getName_limb_exerADesc(tblDesc));
		this.add(getName_muscle_toneADesc(tblDesc));
		this.add(getName_reflex_actionADesc(tblDesc));
		this.add(getName_face_colorADesc(tblDesc));
		this.add(getName_mouth_mucosaADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_breath_statesADesc(tblDesc));
		this.add(getName_digestive_systemADesc(tblDesc));
		this.add(getName_funicleADesc(tblDesc));
		this.add(getName_peri_umbilicusADesc(tblDesc));
		this.add(getName_psn_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_babyCDesc(tblDesc));
		tblDesc.add(getId_babyCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getName_parentCDesc(tblDesc));
		tblDesc.add(getName_medhispreCDesc(tblDesc));
		tblDesc.add(getPre_relatCDesc(tblDesc));
		tblDesc.add(getTelCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getDt_collectdataCDesc(tblDesc));
		tblDesc.add(getHosp_reasonCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getId_product_modeCDesc(tblDesc));
		tblDesc.add(getSd_product_modeCDesc(tblDesc));
		tblDesc.add(getProduct_mode_otherCDesc(tblDesc));
		tblDesc.add(getId_feed_modeCDesc(tblDesc));
		tblDesc.add(getSd_feed_modeCDesc(tblDesc));
		tblDesc.add(getBirth_orderCDesc(tblDesc));
		tblDesc.add(getLy_inCDesc(tblDesc));
		tblDesc.add(getId_fetal_ageCDesc(tblDesc));
		tblDesc.add(getSd_fetal_ageCDesc(tblDesc));
		tblDesc.add(getPreterm_birth_weekCDesc(tblDesc));
		tblDesc.add(getTwinsCDesc(tblDesc));
		tblDesc.add(getTempCDesc(tblDesc));
		tblDesc.add(getPulseCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getHeadsizeCDesc(tblDesc));
		tblDesc.add(getHeightCDesc(tblDesc));
		tblDesc.add(getId_mind_statesCDesc(tblDesc));
		tblDesc.add(getSd_mind_statesCDesc(tblDesc));
		tblDesc.add(getId_cryCDesc(tblDesc));
		tblDesc.add(getSd_cryCDesc(tblDesc));
		tblDesc.add(getId_limb_exerCDesc(tblDesc));
		tblDesc.add(getSd_limb_exerCDesc(tblDesc));
		tblDesc.add(getId_muscle_toneCDesc(tblDesc));
		tblDesc.add(getSd_muscle_toneCDesc(tblDesc));
		tblDesc.add(getId_reflex_actionCDesc(tblDesc));
		tblDesc.add(getSd_reflex_actionCDesc(tblDesc));
		tblDesc.add(getId_face_colorCDesc(tblDesc));
		tblDesc.add(getSd_face_colorCDesc(tblDesc));
		tblDesc.add(getFace_color_otherCDesc(tblDesc));
		tblDesc.add(getId_mouth_mucosaCDesc(tblDesc));
		tblDesc.add(getSd_mouth_mucosaCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getId_breath_statesCDesc(tblDesc));
		tblDesc.add(getSd_breath_statesCDesc(tblDesc));
		tblDesc.add(getBreath_states_otherCDesc(tblDesc));
		tblDesc.add(getId_digestive_systemCDesc(tblDesc));
		tblDesc.add(getSd_digestive_systemCDesc(tblDesc));
		tblDesc.add(getId_funicleCDesc(tblDesc));
		tblDesc.add(getSd_funicleCDesc(tblDesc));
		tblDesc.add(getId_peri_umbilicusCDesc(tblDesc));
		tblDesc.add(getSd_peri_umbilicusCDesc(tblDesc));
		tblDesc.add(getPeri_umbilicus_otherCDesc(tblDesc));
		tblDesc.add(getSubject_situatCDesc(tblDesc));
		tblDesc.add(getNur_manageCDesc(tblDesc));
		tblDesc.add(getName_nur_psn1CDesc(tblDesc));
		tblDesc.add(getId_nur_psn1CDesc(tblDesc));
		tblDesc.add(getName_nur_psn2CDesc(tblDesc));
		tblDesc.add(getId_nur_psn2CDesc(tblDesc));
		tblDesc.add(getDt_assCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getId_psn_signCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 新生儿ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_babyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_baby",  getId_babyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("新生儿ID");
		attrDesc.setNullable(true);
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
	 * 家长姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_parentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_parent",  getName_parentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家长姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病史陈述者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_medhispreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_medhispre",  getName_medhispreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病史陈述者");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 与患者关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPre_relatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pre_relat",  getPre_relatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与患者关系");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel",  getTelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系电话");
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
	 * 收集资料时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_collectdataADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_collectdata",  getDt_collectdataCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("收集资料时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHosp_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Hosp_reason",  getHosp_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院原因");
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
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院诊断");
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
	 * 生产方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_product_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_product_mode",  getId_product_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生产方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_product_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_product_mode",  getSd_product_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产方式其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getProduct_mode_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Product_mode_other",  getProduct_mode_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产方式其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 喂养方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_feed_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_feed_mode",  getId_feed_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("喂养方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 喂养方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_feed_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_feed_mode",  getSd_feed_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("喂养方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 胎次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBirth_orderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Birth_order",  getBirth_orderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("胎次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 产期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLy_inADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ly_in",  getLy_inCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("产期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fetal_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fetal_age",  getId_fetal_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生产情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fetal_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fetal_age",  getSd_fetal_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 周数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPreterm_birth_weekADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Preterm_birth_week",  getPreterm_birth_weekCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("周数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 双胎属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTwinsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Twins",  getTwinsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("双胎");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * T属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTempADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Temp",  getTempCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("T");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * P属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pulse",  getPulseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("P");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * R属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath",  getBreathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("R");
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
	 * 头围属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeadsizeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Headsize",  getHeadsizeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("头围");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHeightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Height",  getHeightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("身长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mind_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mind_states",  getId_mind_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 意识状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mind_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mind_states",  getSd_mind_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 哭声属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cry",  getId_cryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 哭声编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cry",  getSd_cryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肢体活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_limb_exerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_limb_exer",  getId_limb_exerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肢体活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肢体活动编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_limb_exerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_limb_exer",  getSd_limb_exerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肢体活动编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_muscle_toneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_muscle_tone",  getId_muscle_toneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 肌张力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_muscle_toneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_muscle_tone",  getSd_muscle_toneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 反射活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reflex_actionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reflex_action",  getId_reflex_actionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("反射活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 反射活动编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reflex_actionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reflex_action",  getSd_reflex_actionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("反射活动编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_face_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_face_color",  getId_face_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 面色编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_face_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_face_color",  getSd_face_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面色其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFace_color_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Face_color_other",  getFace_color_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口腔粘膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mouth_mucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mouth_mucosa",  getId_mouth_mucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔粘膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 口腔粘膜编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mouth_mucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mouth_mucosa",  getSd_mouth_mucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔粘膜编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin",  getId_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_breath_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_breath_states",  getId_breath_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 呼吸情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_breath_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_breath_states",  getSd_breath_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸情况其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBreath_states_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath_states_other",  getBreath_states_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸情况其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 消化系统属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_digestive_systemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_digestive_system",  getId_digestive_systemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消化系统");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 消化系统编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_digestive_systemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_digestive_system",  getSd_digestive_systemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消化系统编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_funicleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_funicle",  getId_funicleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脐带编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_funicleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_funicle",  getSd_funicleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐周属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peri_umbilicusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peri_umbilicus",  getId_peri_umbilicusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐周");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 脐周编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_peri_umbilicusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_peri_umbilicus",  getSd_peri_umbilicusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐周编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐周其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPeri_umbilicus_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Peri_umbilicus_other",  getPeri_umbilicus_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐周其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 专科情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSubject_situatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Subject_situat",  getSubject_situatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("专科情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_manageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_manage",  getNur_manageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_psn1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_psn1",  getName_nur_psn1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护士1ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_psn1ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_psn1",  getId_nur_psn1CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士1ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_psn2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_psn2",  getName_nur_psn2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护士2ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_psn2ADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_psn2",  getId_nur_psn2CDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士2ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_assADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ass",  getDt_assCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("评估日期");
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
	 * 签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psn_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psn_sign",  getId_psn_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 生产方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_product_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_product_mode",  getName_product_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_product_mode=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 喂养方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_feed_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_feed_mode",  getName_feed_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("喂养方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_feed_mode=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生产情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fetal_ageADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fetal_age",  getName_fetal_ageCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生产情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_fetal_age=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 意识状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mind_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mind_states",  getName_mind_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("意识状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_mind_states=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 哭声属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cry",  getName_cryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("哭声");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_cry=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肢体活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_limb_exerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_limb_exer",  getName_limb_exerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肢体活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_limb_exer=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 肌张力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_muscle_toneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_muscle_tone",  getName_muscle_toneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("肌张力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_muscle_tone=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 反射活动属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_reflex_actionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_reflex_action",  getName_reflex_actionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("反射活动");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_reflex_action=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 面色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_face_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_face_color",  getName_face_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("面色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_face_color=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口腔粘膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mouth_mucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mouth_mucosa",  getName_mouth_mucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔粘膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_mouth_mucosa=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin",  getName_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 呼吸情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_breath_statesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_breath_states",  getName_breath_statesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("呼吸情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_breath_states=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 消化系统属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_digestive_systemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_digestive_system",  getName_digestive_systemCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("消化系统");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_digestive_system=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐带属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_funicleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_funicle",  getName_funicleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐带");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_funicle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 脐周属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_peri_umbilicusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_peri_umbilicus",  getName_peri_umbilicusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("脐周");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_peri_umbilicus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psn_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psn_sign",  getName_psn_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b26","id_psn_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取新生儿ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_babyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_baby");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("新生儿ID"); 
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
	 * 获取家长姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_parentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_parent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家长姓名"); 
		return column;
	}
	/**
	 * 获取病史陈述者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_medhispreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_medhispre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病史陈述者"); 
		return column;
	}
	/**
	 * 获取与患者关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPre_relatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pre_relat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与患者关系"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
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
	 * 获取收集资料时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_collectdataCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_collectdata");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("收集资料时间"); 
		return column;
	}
	/**
	 * 获取入院原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHosp_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Hosp_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院原因"); 
		return column;
	}
	/**
	 * 获取入院诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院诊断"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取生产方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_product_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_product_mode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产方式"); 
		return column;
	}
	/**
	 * 获取生产方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_product_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_product_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产方式编码"); 
		return column;
	}
	/**
	 * 获取生产方式其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getProduct_mode_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Product_mode_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产方式其他"); 
		return column;
	}
	/**
	 * 获取喂养方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_feed_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_feed_mode");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("喂养方式"); 
		return column;
	}
	/**
	 * 获取喂养方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_feed_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_feed_mode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("喂养方式编码"); 
		return column;
	}
	/**
	 * 获取胎次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBirth_orderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Birth_order");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("胎次"); 
		return column;
	}
	/**
	 * 获取产期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLy_inCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ly_in");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("产期"); 
		return column;
	}
	/**
	 * 获取生产情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fetal_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fetal_age");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产情况"); 
		return column;
	}
	/**
	 * 获取生产情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fetal_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fetal_age");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产情况编码"); 
		return column;
	}
	/**
	 * 获取周数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPreterm_birth_weekCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Preterm_birth_week");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("周数"); 
		return column;
	}
	/**
	 * 获取双胎表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTwinsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Twins");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("双胎"); 
		return column;
	}
	/**
	 * 获取T表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTempCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Temp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("T"); 
		return column;
	}
	/**
	 * 获取P表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pulse");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("P"); 
		return column;
	}
	/**
	 * 获取R表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("R"); 
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
	 * 获取头围表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeadsizeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Headsize");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("头围"); 
		return column;
	}
	/**
	 * 获取身长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHeightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Height");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("身长"); 
		return column;
	}
	/**
	 * 获取意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mind_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mind_states");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识状态"); 
		return column;
	}
	/**
	 * 获取意识状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mind_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mind_states");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识状态编码"); 
		return column;
	}
	/**
	 * 获取哭声表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cry");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声"); 
		return column;
	}
	/**
	 * 获取哭声编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声编码"); 
		return column;
	}
	/**
	 * 获取肢体活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_limb_exerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_limb_exer");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肢体活动"); 
		return column;
	}
	/**
	 * 获取肢体活动编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_limb_exerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_limb_exer");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肢体活动编码"); 
		return column;
	}
	/**
	 * 获取肌张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_muscle_toneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_muscle_tone");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力"); 
		return column;
	}
	/**
	 * 获取肌张力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_muscle_toneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_muscle_tone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力编码"); 
		return column;
	}
	/**
	 * 获取反射活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reflex_actionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reflex_action");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("反射活动"); 
		return column;
	}
	/**
	 * 获取反射活动编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reflex_actionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reflex_action");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("反射活动编码"); 
		return column;
	}
	/**
	 * 获取面色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_face_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_face_color");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色"); 
		return column;
	}
	/**
	 * 获取面色编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_face_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_face_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色编码"); 
		return column;
	}
	/**
	 * 获取面色其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFace_color_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Face_color_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色其他"); 
		return column;
	}
	/**
	 * 获取口腔粘膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mouth_mucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mouth_mucosa");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔粘膜"); 
		return column;
	}
	/**
	 * 获取口腔粘膜编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mouth_mucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mouth_mucosa");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔粘膜编码"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤编码"); 
		return column;
	}
	/**
	 * 获取呼吸情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_breath_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_breath_states");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸情况"); 
		return column;
	}
	/**
	 * 获取呼吸情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_breath_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_breath_states");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸情况编码"); 
		return column;
	}
	/**
	 * 获取呼吸情况其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBreath_states_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath_states_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸情况其他"); 
		return column;
	}
	/**
	 * 获取消化系统表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_digestive_systemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_digestive_system");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("消化系统"); 
		return column;
	}
	/**
	 * 获取消化系统编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_digestive_systemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_digestive_system");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("消化系统编码"); 
		return column;
	}
	/**
	 * 获取脐带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_funicleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_funicle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带"); 
		return column;
	}
	/**
	 * 获取脐带编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_funicleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_funicle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带编码"); 
		return column;
	}
	/**
	 * 获取脐周表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peri_umbilicusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peri_umbilicus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐周"); 
		return column;
	}
	/**
	 * 获取脐周编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_peri_umbilicusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_peri_umbilicus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐周编码"); 
		return column;
	}
	/**
	 * 获取脐周其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPeri_umbilicus_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Peri_umbilicus_other");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐周其他"); 
		return column;
	}
	/**
	 * 获取专科情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSubject_situatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Subject_situat");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("专科情况"); 
		return column;
	}
	/**
	 * 获取护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_manageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_manage");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理措施"); 
		return column;
	}
	/**
	 * 获取护士1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_psn1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_psn1");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士1"); 
		return column;
	}
	/**
	 * 获取护士1ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_psn1CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_psn1");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士1ID"); 
		return column;
	}
	/**
	 * 获取护士2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_psn2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_psn2");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士2"); 
		return column;
	}
	/**
	 * 获取护士2ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_psn2CDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_psn2");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士2ID"); 
		return column;
	}
	/**
	 * 获取评估日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_assCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ass");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估日期"); 
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
	 * 获取签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psn_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psn_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签名"); 
		return column;
	}
	/**
	 * 获取生产方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_product_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_product_mode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产方式"); 
		return column;
	}
	/**
	 * 获取喂养方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_feed_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_feed_mode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("喂养方式"); 
		return column;
	}
	/**
	 * 获取生产情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fetal_ageCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fetal_age");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生产情况"); 
		return column;
	}
	/**
	 * 获取意识状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mind_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mind_states");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("意识状态"); 
		return column;
	}
	/**
	 * 获取哭声表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cry");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("哭声"); 
		return column;
	}
	/**
	 * 获取肢体活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_limb_exerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_limb_exer");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肢体活动"); 
		return column;
	}
	/**
	 * 获取肌张力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_muscle_toneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_muscle_tone");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("肌张力"); 
		return column;
	}
	/**
	 * 获取反射活动表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_reflex_actionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_reflex_action");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("反射活动"); 
		return column;
	}
	/**
	 * 获取面色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_face_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_face_color");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("面色"); 
		return column;
	}
	/**
	 * 获取口腔粘膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mouth_mucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mouth_mucosa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔粘膜"); 
		return column;
	}
	/**
	 * 获取皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤"); 
		return column;
	}
	/**
	 * 获取呼吸情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_breath_statesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_breath_states");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("呼吸情况"); 
		return column;
	}
	/**
	 * 获取消化系统表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_digestive_systemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_digestive_system");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("消化系统"); 
		return column;
	}
	/**
	 * 获取脐带表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_funicleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_funicle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐带"); 
		return column;
	}
	/**
	 * 获取脐周表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_peri_umbilicusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_peri_umbilicus");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("脐周"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psn_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psn_sign");
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
	
}
