
package iih.nmr.ha.tcho.tchopulceriskass.d.desc;

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
 * 压疮风险评分单DO DO 元数据信息
 */
public class TchoPulceriskAssDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.ha.tcho.tchopulceriskass.d.TchoPulceriskAssDO";
	public static final String CLASS_DISPALYNAME = "压疮风险评分单DO";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nmr_ha_tcho_pulceriskass";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pulceriskass";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TchoPulceriskAssDODesc(){
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
		this.setKeyDesc(getId_pulceriskassADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_pulceriskassADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getChinese_diagnoseADesc(tblDesc));
		this.add(getWestern_diagnoseADesc(tblDesc));
		this.add(getTotal_gradeADesc(tblDesc));
		this.add(getBasic_sickADesc(tblDesc));
		this.add(getOthersADesc(tblDesc));
		this.add(getFill_peopleADesc(tblDesc));
		this.add(getSc_feelADesc(tblDesc));
		this.add(getSc_dampADesc(tblDesc));
		this.add(getSc_activityADesc(tblDesc));
		this.add(getSc_ctrlpowerADesc(tblDesc));
		this.add(getSc_nutritionADesc(tblDesc));
		this.add(getSc_fhpowerADesc(tblDesc));
		this.add(getId_feelADesc(tblDesc));
		this.add(getSd_feelADesc(tblDesc));
		this.add(getId_dampADesc(tblDesc));
		this.add(getSd_dampADesc(tblDesc));
		this.add(getId_activityADesc(tblDesc));
		this.add(getSd_activityADesc(tblDesc));
		this.add(getId_moveADesc(tblDesc));
		this.add(getSd_moveADesc(tblDesc));
		this.add(getId_nutritionADesc(tblDesc));
		this.add(getSd_nutritionADesc(tblDesc));
		this.add(getId_fhpowerADesc(tblDesc));
		this.add(getSd_fhpowerADesc(tblDesc));
		this.add(getId_nursmeasureADesc(tblDesc));
		this.add(getSd_nursmeasureADesc(tblDesc));
		this.add(getId_preventive_effectADesc(tblDesc));
		this.add(getSd_preventive_effectADesc(tblDesc));
		this.add(getDt_birthADesc(tblDesc));
		this.add(getFill_timeADesc(tblDesc));
		this.add(getEu_ishappenADesc(tblDesc));
		this.add(getEu_isobeyADesc(tblDesc));
		this.add(getId_ulcerpositionADesc(tblDesc));
		this.add(getSd_ulcerpositionADesc(tblDesc));
		this.add(getId_ulcerlevelADesc(tblDesc));
		this.add(getSd_ulcerlevelADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_peopleADesc(tblDesc));
		this.add(getName_feelADesc(tblDesc));
		this.add(getName_dampADesc(tblDesc));
		this.add(getName_activityADesc(tblDesc));
		this.add(getName_moveADesc(tblDesc));
		this.add(getName_nutritionADesc(tblDesc));
		this.add(getName_fhpowerADesc(tblDesc));
		this.add(getName_nursmeasureADesc(tblDesc));
		this.add(getName_preventive_effectADesc(tblDesc));
		this.add(getName_ulcerpositionADesc(tblDesc));
		this.add(getName_ulcerlevelADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pulceriskassCDesc(tblDesc));
		tblDesc.add(getId_pulceriskassCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getChinese_diagnoseCDesc(tblDesc));
		tblDesc.add(getWestern_diagnoseCDesc(tblDesc));
		tblDesc.add(getTotal_gradeCDesc(tblDesc));
		tblDesc.add(getBasic_sickCDesc(tblDesc));
		tblDesc.add(getOthersCDesc(tblDesc));
		tblDesc.add(getFill_peopleCDesc(tblDesc));
		tblDesc.add(getSc_feelCDesc(tblDesc));
		tblDesc.add(getSc_dampCDesc(tblDesc));
		tblDesc.add(getSc_activityCDesc(tblDesc));
		tblDesc.add(getSc_ctrlpowerCDesc(tblDesc));
		tblDesc.add(getSc_nutritionCDesc(tblDesc));
		tblDesc.add(getSc_fhpowerCDesc(tblDesc));
		tblDesc.add(getId_feelCDesc(tblDesc));
		tblDesc.add(getSd_feelCDesc(tblDesc));
		tblDesc.add(getId_dampCDesc(tblDesc));
		tblDesc.add(getSd_dampCDesc(tblDesc));
		tblDesc.add(getId_activityCDesc(tblDesc));
		tblDesc.add(getSd_activityCDesc(tblDesc));
		tblDesc.add(getId_moveCDesc(tblDesc));
		tblDesc.add(getSd_moveCDesc(tblDesc));
		tblDesc.add(getId_nutritionCDesc(tblDesc));
		tblDesc.add(getSd_nutritionCDesc(tblDesc));
		tblDesc.add(getId_fhpowerCDesc(tblDesc));
		tblDesc.add(getSd_fhpowerCDesc(tblDesc));
		tblDesc.add(getId_nursmeasureCDesc(tblDesc));
		tblDesc.add(getSd_nursmeasureCDesc(tblDesc));
		tblDesc.add(getId_preventive_effectCDesc(tblDesc));
		tblDesc.add(getSd_preventive_effectCDesc(tblDesc));
		tblDesc.add(getDt_birthCDesc(tblDesc));
		tblDesc.add(getFill_timeCDesc(tblDesc));
		tblDesc.add(getEu_ishappenCDesc(tblDesc));
		tblDesc.add(getEu_isobeyCDesc(tblDesc));
		tblDesc.add(getId_ulcerpositionCDesc(tblDesc));
		tblDesc.add(getSd_ulcerpositionCDesc(tblDesc));
		tblDesc.add(getId_ulcerlevelCDesc(tblDesc));
		tblDesc.add(getSd_ulcerlevelCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 压疮风险评定单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pulceriskassADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pulceriskass",  getId_pulceriskassCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮风险评定单ID");
		attrDesc.setNullable(false);
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
	 * 合计得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotal_gradeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_grade",  getTotal_gradeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("合计得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 基础疾病属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBasic_sickADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Basic_sick",  getBasic_sickCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("基础疾病");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其它属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOthersADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Others",  getOthersCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其它");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_peopleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_people",  getFill_peopleCDesc(tblDesc), this);
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
	 * 对压迫有关的不适感受力得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_feel",  getSc_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("对压迫有关的不适感受力得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤暴露于潮湿的程度得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_damp",  getSc_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("皮肤暴露于潮湿的程度得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 身体活动程度得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_activity",  getSc_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("身体活动程度得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动能力改变和控制体位的能力得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_ctrlpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_ctrlpower",  getSc_ctrlpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("活动能力改变和控制体位的能力得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通常摄食情况得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_nutrition",  getSc_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("通常摄食情况得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力得分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_fhpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_fhpower",  getSc_fhpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("摩擦力和剪切力得分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感觉(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_feel",  getId_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感觉(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感觉(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_feel",  getSd_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感觉(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 潮湿(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_damp",  getId_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("潮湿(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 潮湿(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_damp",  getSd_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("潮湿(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动力(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_activity",  getId_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动力(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 活动力(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_activity",  getSd_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动力(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动力(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_moveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_move",  getId_moveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动力(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 移动力(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_moveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_move",  getSd_moveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动力(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nutrition",  getId_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 营养(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nutrition",  getSd_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fhpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fhpower",  getId_fhpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力和剪切力(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fhpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fhpower",  getSd_fhpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力和剪切力(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防措施(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nursmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nursmeasure",  getId_nursmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防措施(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预防措施(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nursmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nursmeasure",  getSd_nursmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防措施(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防效果(tcho)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preventive_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_preventive_effect",  getId_preventive_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防效果(tcho)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预防效果(tcho)编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_preventive_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_preventive_effect",  getSd_preventive_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防效果(tcho)编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_birthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_birth",  getDt_birthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("患者出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFill_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill_time",  getFill_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("评估时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否发生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_ishappenADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_ishappen",  getEu_ishappenCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("是否发生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者及家属依从性属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_isobeyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_isobey",  getEu_isobeyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("患者及家属依从性");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮发生部位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ulcerpositionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ulcerposition",  getId_ulcerpositionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮发生部位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮发生部位编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ulcerpositionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ulcerposition",  getSd_ulcerpositionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮发生部位编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 压疮发生程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ulcerlevelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ulcerlevel",  getId_ulcerlevelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮发生程度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 压疮发生程度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ulcerlevelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ulcerlevel",  getSd_ulcerlevelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮发生程度编码");
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_peopleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_people",  getName_peopleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b17","fill_people=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感觉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_feel",  getName_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感觉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_feel=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 潮湿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_damp",  getName_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("潮湿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_damp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_activity",  getName_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_activity=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_moveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_move",  getName_moveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_move=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nutrition",  getName_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_nutrition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fhpowerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fhpower",  getName_fhpowerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力和剪切力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_fhpower=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nursmeasureADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nursmeasure",  getName_nursmeasureCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_nursmeasure=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预防效果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_preventive_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_preventive_effect",  getName_preventive_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预防效果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_preventive_effect=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ulcerpositionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ulcerposition",  getName_ulcerpositionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_ulcerposition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ulcerlevelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ulcerlevel",  getName_ulcerlevelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_ulcerlevel=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取压疮风险评定单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pulceriskassCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pulceriskass");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("压疮风险评定单ID"); 
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
		column.setLength(50);
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
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取中医诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getChinese_diagnoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Chinese_diagnose");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("中医诊断"); 
		return column;
	}
	/**
	 * 获取西医诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWestern_diagnoseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Western_diagnose");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("西医诊断"); 
		return column;
	}
	/**
	 * 获取合计得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_gradeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_grade");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("合计得分"); 
		return column;
	}
	/**
	 * 获取基础疾病表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBasic_sickCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Basic_sick");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("基础疾病"); 
		return column;
	}
	/**
	 * 获取其它表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOthersCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Others");
		column.setLength(1500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其它"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_peopleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_people");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
		return column;
	}
	/**
	 * 获取对压迫有关的不适感受力得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_feel");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("对压迫有关的不适感受力得分"); 
		return column;
	}
	/**
	 * 获取皮肤暴露于潮湿的程度得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_damp");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("皮肤暴露于潮湿的程度得分"); 
		return column;
	}
	/**
	 * 获取身体活动程度得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_activity");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("身体活动程度得分"); 
		return column;
	}
	/**
	 * 获取活动能力改变和控制体位的能力得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_ctrlpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_ctrlpower");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("活动能力改变和控制体位的能力得分"); 
		return column;
	}
	/**
	 * 获取通常摄食情况得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_nutrition");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("通常摄食情况得分"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力得分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_fhpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_fhpower");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力得分"); 
		return column;
	}
	/**
	 * 获取感觉(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_feel");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感觉(tcho)"); 
		return column;
	}
	/**
	 * 获取感觉(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_feel");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感觉(tcho)编码"); 
		return column;
	}
	/**
	 * 获取潮湿(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_damp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("潮湿(tcho)"); 
		return column;
	}
	/**
	 * 获取潮湿(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_damp");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("潮湿(tcho)编码"); 
		return column;
	}
	/**
	 * 获取活动力(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_activity");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动力(tcho)"); 
		return column;
	}
	/**
	 * 获取活动力(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_activity");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动力(tcho)编码"); 
		return column;
	}
	/**
	 * 获取移动力(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_moveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_move");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动力(tcho)"); 
		return column;
	}
	/**
	 * 获取移动力(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_moveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_move");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动力(tcho)编码"); 
		return column;
	}
	/**
	 * 获取营养(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nutrition");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养(tcho)"); 
		return column;
	}
	/**
	 * 获取营养(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nutrition");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养(tcho)编码"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fhpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fhpower");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力(tcho)"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fhpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fhpower");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力(tcho)编码"); 
		return column;
	}
	/**
	 * 获取预防措施(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nursmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nursmeasure");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防措施(tcho)"); 
		return column;
	}
	/**
	 * 获取预防措施(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nursmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nursmeasure");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防措施(tcho)编码"); 
		return column;
	}
	/**
	 * 获取预防效果(tcho)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preventive_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_preventive_effect");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防效果(tcho)"); 
		return column;
	}
	/**
	 * 获取预防效果(tcho)编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_preventive_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_preventive_effect");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防效果(tcho)编码"); 
		return column;
	}
	/**
	 * 获取患者出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_birthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_birth");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("患者出生日期"); 
		return column;
	}
	/**
	 * 获取评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFill_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill_time");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估时间"); 
		return column;
	}
	/**
	 * 获取是否发生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_ishappenCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_ishappen");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("是否发生"); 
		return column;
	}
	/**
	 * 获取患者及家属依从性表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_isobeyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_isobey");
		column.setLength(20);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("患者及家属依从性"); 
		return column;
	}
	/**
	 * 获取压疮发生部位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ulcerpositionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ulcerposition");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮发生部位"); 
		return column;
	}
	/**
	 * 获取压疮发生部位编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ulcerpositionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ulcerposition");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮发生部位编码"); 
		return column;
	}
	/**
	 * 获取压疮发生程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ulcerlevelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ulcerlevel");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮发生程度"); 
		return column;
	}
	/**
	 * 获取压疮发生程度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ulcerlevelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ulcerlevel");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮发生程度编码"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_peopleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_people");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取感觉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_feel");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感觉"); 
		return column;
	}
	/**
	 * 获取潮湿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_damp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("潮湿"); 
		return column;
	}
	/**
	 * 获取活动力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_activity");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动力"); 
		return column;
	}
	/**
	 * 获取移动力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_moveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_move");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动力"); 
		return column;
	}
	/**
	 * 获取营养表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nutrition");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fhpowerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fhpower");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力"); 
		return column;
	}
	/**
	 * 获取预防措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nursmeasureCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nursmeasure");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防措施"); 
		return column;
	}
	/**
	 * 获取预防效果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_preventive_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_preventive_effect");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预防效果"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_ulcerpositionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ulcerposition");
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
	private IColumnDesc getName_ulcerlevelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ulcerlevel");
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
