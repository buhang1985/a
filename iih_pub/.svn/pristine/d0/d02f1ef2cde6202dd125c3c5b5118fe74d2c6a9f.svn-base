
package iih.ci.mr.nu.assforchild.d.desc;

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
 * 儿童压疮风险评估单 DO 元数据信息
 */
public class AssforchildDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.assforchild.d.AssforchildDO";
	public static final String CLASS_DISPALYNAME = "儿童压疮风险评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_assforchild";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_assforchild";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AssforchildDODesc(){
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
		this.setKeyDesc(getId_assforchildADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_assforchildADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getBedproADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getFillADesc(tblDesc));
		this.add(getDt_fillADesc(tblDesc));
		this.add(getOtherADesc(tblDesc));
		this.add(getId_perceptionADesc(tblDesc));
		this.add(getSd_perceptionADesc(tblDesc));
		this.add(getId_dipADesc(tblDesc));
		this.add(getSd_dipADesc(tblDesc));
		this.add(getId_nutritionADesc(tblDesc));
		this.add(getSd_nutritionADesc(tblDesc));
		this.add(getId_tpaoxyADesc(tblDesc));
		this.add(getSd_tpaoxyADesc(tblDesc));
		this.add(getId_nurmeaADesc(tblDesc));
		this.add(getSd_nurmeaADesc(tblDesc));
		this.add(getId_mobADesc(tblDesc));
		this.add(getSd_mobADesc(tblDesc));
		this.add(getId_activityADesc(tblDesc));
		this.add(getSd_activityADesc(tblDesc));
		this.add(getId_frictionADesc(tblDesc));
		this.add(getSd_frictionADesc(tblDesc));
		this.add(getMobscoreADesc(tblDesc));
		this.add(getActivityscoreADesc(tblDesc));
		this.add(getPerceptionscoreADesc(tblDesc));
		this.add(getNutritionscoreADesc(tblDesc));
		this.add(getDipscoreADesc(tblDesc));
		this.add(getFrictionscoreADesc(tblDesc));
		this.add(getTpaoxyscoreADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getTotalscoreADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getName_fillADesc(tblDesc));
		this.add(getName_perceptionADesc(tblDesc));
		this.add(getName_dipADesc(tblDesc));
		this.add(getName_nutritionADesc(tblDesc));
		this.add(getName_tpaoxyADesc(tblDesc));
		this.add(getName_nurmeaADesc(tblDesc));
		this.add(getName_mobADesc(tblDesc));
		this.add(getName_activityADesc(tblDesc));
		this.add(getName_frictionADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_assforchildCDesc(tblDesc));
		tblDesc.add(getId_assforchildCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getBedproCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getFillCDesc(tblDesc));
		tblDesc.add(getDt_fillCDesc(tblDesc));
		tblDesc.add(getOtherCDesc(tblDesc));
		tblDesc.add(getId_perceptionCDesc(tblDesc));
		tblDesc.add(getSd_perceptionCDesc(tblDesc));
		tblDesc.add(getId_dipCDesc(tblDesc));
		tblDesc.add(getSd_dipCDesc(tblDesc));
		tblDesc.add(getId_nutritionCDesc(tblDesc));
		tblDesc.add(getSd_nutritionCDesc(tblDesc));
		tblDesc.add(getId_tpaoxyCDesc(tblDesc));
		tblDesc.add(getSd_tpaoxyCDesc(tblDesc));
		tblDesc.add(getId_nurmeaCDesc(tblDesc));
		tblDesc.add(getSd_nurmeaCDesc(tblDesc));
		tblDesc.add(getId_mobCDesc(tblDesc));
		tblDesc.add(getSd_mobCDesc(tblDesc));
		tblDesc.add(getId_activityCDesc(tblDesc));
		tblDesc.add(getSd_activityCDesc(tblDesc));
		tblDesc.add(getId_frictionCDesc(tblDesc));
		tblDesc.add(getSd_frictionCDesc(tblDesc));
		tblDesc.add(getMobscoreCDesc(tblDesc));
		tblDesc.add(getActivityscoreCDesc(tblDesc));
		tblDesc.add(getPerceptionscoreCDesc(tblDesc));
		tblDesc.add(getNutritionscoreCDesc(tblDesc));
		tblDesc.add(getDipscoreCDesc(tblDesc));
		tblDesc.add(getFrictionscoreCDesc(tblDesc));
		tblDesc.add(getTpaoxyscoreCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getTotalscoreCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 儿童压疮风险评估单Id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_assforchildADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_assforchild",  getId_assforchildCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿童压疮风险评估单Id");
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
	 * 压疮性质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBedproADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bedpro",  getBedproCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("压疮性质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病区");
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
	 * 诊断ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diagnosis",  getId_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diagnosisADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diagnosis",  getName_diagnosisCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断");
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
	 * 入院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_entryADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_entry",  getDt_entryCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院时间");
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
	private IAttrDesc getFillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fill",  getFillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("填报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 填报时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_fillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_fill",  getDt_fillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("填报时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOtherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other",  getOtherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感知觉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_perceptionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_perception",  getId_perceptionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感知觉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感知觉编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_perceptionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_perception",  getSd_perceptionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感知觉编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 浸渍属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dip",  getId_dipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("浸渍");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 浸渍编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dip",  getSd_dipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("浸渍编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nutrition",  getId_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养");
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
	 * 组织灌注与氧合属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tpaoxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tpaoxy",  getId_tpaoxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织灌注与氧合");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 组织灌注与氧合编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tpaoxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tpaoxy",  getSd_tpaoxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织灌注与氧合编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 儿童压疮护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurmeaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nurmea",  getId_nurmeaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿童压疮护理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 儿童压疮护理措施编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nurmeaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nurmea",  getSd_nurmeaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿童压疮护理措施编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mob",  getId_mobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 移动度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mob",  getSd_mobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_activity",  getId_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 活动度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_activity",  getSd_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("活动度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力剪切力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_frictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_friction",  getId_frictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力剪切力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 摩擦力剪切力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_frictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_friction",  getSd_frictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力剪切力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动度评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMobscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mobscore",  getMobscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("移动度评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动度评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getActivityscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Activityscore",  getActivityscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("活动度评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感知觉评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPerceptionscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Perceptionscore",  getPerceptionscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("感知觉评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNutritionscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nutritionscore",  getNutritionscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("营养评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 浸渍评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDipscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dipscore",  getDipscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("浸渍评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力剪切力评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFrictionscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Frictionscore",  getFrictionscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("摩擦力剪切力评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织灌注与氧合评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTpaoxyscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tpaoxyscore",  getTpaoxyscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("组织灌注与氧合评分");
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
	 * 总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTotalscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Totalscore",  getTotalscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("总分");
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
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fillADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fill",  getName_fillCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b25","fill=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感知觉属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_perceptionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_perception",  getName_perceptionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感知觉");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_perception=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 浸渍属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dip",  getName_dipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("浸渍");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_dip=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_nutrition=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织灌注与氧合属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tpaoxyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tpaoxy",  getName_tpaoxyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织灌注与氧合");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_tpaoxy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 儿童压疮护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nurmeaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nurmea",  getName_nurmeaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿童压疮护理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_nurmea=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mob",  getName_mobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_mob=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_activityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_activity",  getName_activityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_activity=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_frictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_friction",  getName_frictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b27","id_friction=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取儿童压疮风险评估单Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_assforchildCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_assforchild");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿童压疮风险评估单Id"); 
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
	 * 获取压疮性质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBedproCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bedpro");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("压疮性质"); 
		return column;
	}
	/**
	 * 获取病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病区"); 
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
	 * 获取诊断ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断ID"); 
		return column;
	}
	/**
	 * 获取诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diagnosis");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断"); 
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
	 * 获取入院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_entryCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_entry");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院时间"); 
		return column;
	}
	/**
	 * 获取填报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fill");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("填报人"); 
		return column;
	}
	/**
	 * 获取填报时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_fillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_fill");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("填报时间"); 
		return column;
	}
	/**
	 * 获取其他措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOtherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他措施"); 
		return column;
	}
	/**
	 * 获取感知觉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_perceptionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_perception");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感知觉"); 
		return column;
	}
	/**
	 * 获取感知觉编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_perceptionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_perception");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感知觉编码"); 
		return column;
	}
	/**
	 * 获取浸渍表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("浸渍"); 
		return column;
	}
	/**
	 * 获取浸渍编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("浸渍编码"); 
		return column;
	}
	/**
	 * 获取营养表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nutrition");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养"); 
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
	 * 获取组织灌注与氧合表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tpaoxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tpaoxy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织灌注与氧合"); 
		return column;
	}
	/**
	 * 获取组织灌注与氧合编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tpaoxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tpaoxy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织灌注与氧合编码"); 
		return column;
	}
	/**
	 * 获取儿童压疮护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurmeaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nurmea");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿童压疮护理措施"); 
		return column;
	}
	/**
	 * 获取儿童压疮护理措施编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nurmeaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nurmea");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿童压疮护理措施编码"); 
		return column;
	}
	/**
	 * 获取移动度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mob");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动度"); 
		return column;
	}
	/**
	 * 获取移动度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mob");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动度编码"); 
		return column;
	}
	/**
	 * 获取活动度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_activity");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动度"); 
		return column;
	}
	/**
	 * 获取活动度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_activity");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动度编码"); 
		return column;
	}
	/**
	 * 获取摩擦力剪切力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_frictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_friction");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力剪切力"); 
		return column;
	}
	/**
	 * 获取摩擦力剪切力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_frictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_friction");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力剪切力编码"); 
		return column;
	}
	/**
	 * 获取移动度评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMobscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mobscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("移动度评分"); 
		return column;
	}
	/**
	 * 获取活动度评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getActivityscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Activityscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("活动度评分"); 
		return column;
	}
	/**
	 * 获取感知觉评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPerceptionscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Perceptionscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("感知觉评分"); 
		return column;
	}
	/**
	 * 获取营养评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNutritionscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nutritionscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("营养评分"); 
		return column;
	}
	/**
	 * 获取浸渍评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDipscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dipscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("浸渍评分"); 
		return column;
	}
	/**
	 * 获取摩擦力剪切力评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFrictionscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Frictionscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("摩擦力剪切力评分"); 
		return column;
	}
	/**
	 * 获取组织灌注与氧合评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTpaoxyscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tpaoxyscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("组织灌注与氧合评分"); 
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
	 * 获取总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotalscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Totalscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("总分"); 
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
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fillCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fill");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取感知觉表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_perceptionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_perception");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感知觉"); 
		return column;
	}
	/**
	 * 获取浸渍表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dip");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("浸渍"); 
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
	 * 获取组织灌注与氧合表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tpaoxyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tpaoxy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织灌注与氧合"); 
		return column;
	}
	/**
	 * 获取儿童压疮护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nurmeaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nurmea");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿童压疮护理措施"); 
		return column;
	}
	/**
	 * 获取移动度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_mobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mob");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动度"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_activityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_activity");
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
	private IColumnDesc getName_frictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_friction");
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
	
}
