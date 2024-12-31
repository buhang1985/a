
package iih.nmr.pkuf.prebracordxh.d.desc;

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
 * 预防压疮护理评估表（Braden评分） DO 元数据信息
 */
public class PreBraCordxhDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.prebracordxh.d.PreBraCordxhDO";
	public static final String CLASS_DISPALYNAME = "预防压疮护理评估表（Braden评分）";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_PREBRACORDXH";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pre";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PreBraCordxhDODesc(){
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
		this.setKeyDesc(getId_preADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_preADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_feelADesc(tblDesc));
		this.add(getSd_feelADesc(tblDesc));
		this.add(getId_ass_pointADesc(tblDesc));
		this.add(getSd_ass_pointADesc(tblDesc));
		this.add(getId_dampADesc(tblDesc));
		this.add(getSd_dampADesc(tblDesc));
		this.add(getId_act_abilityADesc(tblDesc));
		this.add(getSd_act_abilityADesc(tblDesc));
		this.add(getId_mobileADesc(tblDesc));
		this.add(getSd_mobileADesc(tblDesc));
		this.add(getId_frictionADesc(tblDesc));
		this.add(getSd_frictionADesc(tblDesc));
		this.add(getId_weightADesc(tblDesc));
		this.add(getSd_weightADesc(tblDesc));
		this.add(getId_agesADesc(tblDesc));
		this.add(getSd_agesADesc(tblDesc));
		this.add(getId_albuminADesc(tblDesc));
		this.add(getSd_albuminADesc(tblDesc));
		this.add(getId_hbADesc(tblDesc));
		this.add(getSd_hbADesc(tblDesc));
		this.add(getId_dietADesc(tblDesc));
		this.add(getSd_dietADesc(tblDesc));
		this.add(getId_ora_mucosaADesc(tblDesc));
		this.add(getSd_ora_mucosaADesc(tblDesc));
		this.add(getId_teethADesc(tblDesc));
		this.add(getSd_teethADesc(tblDesc));
		this.add(getId_nur_measuresADesc(tblDesc));
		this.add(getSd_nur_measuresADesc(tblDesc));
		this.add(getScore_feelADesc(tblDesc));
		this.add(getScore_dampADesc(tblDesc));
		this.add(getScore_actADesc(tblDesc));
		this.add(getScore_mobileADesc(tblDesc));
		this.add(getScore_frictionADesc(tblDesc));
		this.add(getScore_weightADesc(tblDesc));
		this.add(getScore_agesADesc(tblDesc));
		this.add(getScore_albuminADesc(tblDesc));
		this.add(getScore_hbADesc(tblDesc));
		this.add(getScore_dietADesc(tblDesc));
		this.add(getScore_oraADesc(tblDesc));
		this.add(getScore_teethADesc(tblDesc));
		this.add(getScore_nutritionADesc(tblDesc));
		this.add(getTotal_scoreADesc(tblDesc));
		this.add(getTips_contentADesc(tblDesc));
		this.add(getScore_hintADesc(tblDesc));
		this.add(getId_guidanceADesc(tblDesc));
		this.add(getSd_guidanceADesc(tblDesc));
		this.add(getSup_contentADesc(tblDesc));
		this.add(getId_is_savenurADesc(tblDesc));
		this.add(getSd_is_savenurADesc(tblDesc));
		this.add(getNur_contentADesc(tblDesc));
		this.add(getId_nutri_staADesc(tblDesc));
		this.add(getSd_nutri_staADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_feelADesc(tblDesc));
		this.add(getName_ass_pointADesc(tblDesc));
		this.add(getName_dampADesc(tblDesc));
		this.add(getName_act_abilityADesc(tblDesc));
		this.add(getName_mobileADesc(tblDesc));
		this.add(getName_frictionADesc(tblDesc));
		this.add(getName_weightADesc(tblDesc));
		this.add(getName_agesADesc(tblDesc));
		this.add(getName_albuminADesc(tblDesc));
		this.add(getName_hbADesc(tblDesc));
		this.add(getName_dietADesc(tblDesc));
		this.add(getName_ora_mucosaADesc(tblDesc));
		this.add(getName_teethADesc(tblDesc));
		this.add(getName_nur_measuresADesc(tblDesc));
		this.add(getName_guidanceADesc(tblDesc));
		this.add(getName_is_savenurADesc(tblDesc));
		this.add(getName_nutri_staADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_preCDesc(tblDesc));
		tblDesc.add(getId_preCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_feelCDesc(tblDesc));
		tblDesc.add(getSd_feelCDesc(tblDesc));
		tblDesc.add(getId_ass_pointCDesc(tblDesc));
		tblDesc.add(getSd_ass_pointCDesc(tblDesc));
		tblDesc.add(getId_dampCDesc(tblDesc));
		tblDesc.add(getSd_dampCDesc(tblDesc));
		tblDesc.add(getId_act_abilityCDesc(tblDesc));
		tblDesc.add(getSd_act_abilityCDesc(tblDesc));
		tblDesc.add(getId_mobileCDesc(tblDesc));
		tblDesc.add(getSd_mobileCDesc(tblDesc));
		tblDesc.add(getId_frictionCDesc(tblDesc));
		tblDesc.add(getSd_frictionCDesc(tblDesc));
		tblDesc.add(getId_weightCDesc(tblDesc));
		tblDesc.add(getSd_weightCDesc(tblDesc));
		tblDesc.add(getId_agesCDesc(tblDesc));
		tblDesc.add(getSd_agesCDesc(tblDesc));
		tblDesc.add(getId_albuminCDesc(tblDesc));
		tblDesc.add(getSd_albuminCDesc(tblDesc));
		tblDesc.add(getId_hbCDesc(tblDesc));
		tblDesc.add(getSd_hbCDesc(tblDesc));
		tblDesc.add(getId_dietCDesc(tblDesc));
		tblDesc.add(getSd_dietCDesc(tblDesc));
		tblDesc.add(getId_ora_mucosaCDesc(tblDesc));
		tblDesc.add(getSd_ora_mucosaCDesc(tblDesc));
		tblDesc.add(getId_teethCDesc(tblDesc));
		tblDesc.add(getSd_teethCDesc(tblDesc));
		tblDesc.add(getId_nur_measuresCDesc(tblDesc));
		tblDesc.add(getSd_nur_measuresCDesc(tblDesc));
		tblDesc.add(getScore_feelCDesc(tblDesc));
		tblDesc.add(getScore_dampCDesc(tblDesc));
		tblDesc.add(getScore_actCDesc(tblDesc));
		tblDesc.add(getScore_mobileCDesc(tblDesc));
		tblDesc.add(getScore_frictionCDesc(tblDesc));
		tblDesc.add(getScore_weightCDesc(tblDesc));
		tblDesc.add(getScore_agesCDesc(tblDesc));
		tblDesc.add(getScore_albuminCDesc(tblDesc));
		tblDesc.add(getScore_hbCDesc(tblDesc));
		tblDesc.add(getScore_dietCDesc(tblDesc));
		tblDesc.add(getScore_oraCDesc(tblDesc));
		tblDesc.add(getScore_teethCDesc(tblDesc));
		tblDesc.add(getScore_nutritionCDesc(tblDesc));
		tblDesc.add(getTotal_scoreCDesc(tblDesc));
		tblDesc.add(getTips_contentCDesc(tblDesc));
		tblDesc.add(getScore_hintCDesc(tblDesc));
		tblDesc.add(getId_guidanceCDesc(tblDesc));
		tblDesc.add(getSd_guidanceCDesc(tblDesc));
		tblDesc.add(getSup_contentCDesc(tblDesc));
		tblDesc.add(getId_is_savenurCDesc(tblDesc));
		tblDesc.add(getSd_is_savenurCDesc(tblDesc));
		tblDesc.add(getNur_contentCDesc(tblDesc));
		tblDesc.add(getId_nutri_staCDesc(tblDesc));
		tblDesc.add(getSd_nutri_staCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 评估单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pre",  getId_preCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估单主键");
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
	 * 感知属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_feel",  getId_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感知");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 感知编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_feel",  getSd_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("感知编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 评估点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ass_pointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ass_point",  getId_ass_pointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 评估点编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ass_pointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ass_point",  getSd_ass_pointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("评估点编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 潮湿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_damp",  getId_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("潮湿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 潮湿编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_damp",  getSd_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("潮湿编码");
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
	private IAttrDesc getId_act_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_act_ability",  getId_act_abilityCDesc(tblDesc), this);
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
	private IAttrDesc getSd_act_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_act_ability",  getSd_act_abilityCDesc(tblDesc), this);
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
	 * 移动能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mobileADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mobile",  getId_mobileCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 移动能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_mobileADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_mobile",  getSd_mobileCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("移动能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_frictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_friction",  getId_frictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力和剪切力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_frictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_friction",  getSd_frictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("摩擦力和剪切力编码");
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
	private IAttrDesc getId_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_weight",  getId_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体重");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体重编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_weight",  getSd_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体重编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄段属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_agesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ages",  getId_agesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄段");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 年龄段编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_agesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ages",  getSd_agesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("年龄段编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 白蛋白属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_albuminADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_albumin",  getId_albuminCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("白蛋白");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 白蛋白编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_albuminADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_albumin",  getSd_albuminCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("白蛋白编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Hb属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hb",  getId_hbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Hb");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * Hb编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hb",  getSd_hbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Hb编码");
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
		attrDesc.setRefType(true);
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
	 * 口腔粘膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ora_mucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ora_mucosa",  getId_ora_mucosaCDesc(tblDesc), this);
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
	private IAttrDesc getSd_ora_mucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ora_mucosa",  getSd_ora_mucosaCDesc(tblDesc), this);
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
	 * 牙齿属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_teethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_teeth",  getId_teethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("牙齿");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 牙齿编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_teethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_teeth",  getSd_teethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("牙齿编码");
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
	private IAttrDesc getId_nur_measuresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_measures",  getId_nur_measuresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理措施编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nur_measuresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nur_measures",  getSd_nur_measuresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理措施编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 感觉分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_feel",  getScore_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("感觉分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 潮湿分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_damp",  getScore_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("潮湿分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 活动能力分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_actADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_act",  getScore_actCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("活动能力分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 移动能力分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_mobileADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_mobile",  getScore_mobileCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("移动能力分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 摩擦力和剪切力分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_frictionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_friction",  getScore_frictionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("摩擦力和剪切力分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体重分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_weight",  getScore_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("体重分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 年龄分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_agesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_ages",  getScore_agesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("年龄分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 白蛋白分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_albuminADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_albumin",  getScore_albuminCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("白蛋白分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Hb分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_hbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_hb",  getScore_hbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("Hb分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_diet",  getScore_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("饮食分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口腔粘膜分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_oraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_ora",  getScore_oraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("口腔粘膜分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 牙齿分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_teethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_teeth",  getScore_teethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("牙齿分值");
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
	private IAttrDesc getScore_nutritionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_nutrition",  getScore_nutritionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("营养评分");
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
	private IAttrDesc getTotal_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Total_score",  getTotal_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养提示属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTips_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tips_content",  getTips_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养提示");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养总分值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getScore_hintADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Score_hint",  getScore_hintCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("营养总分值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 协助或指导属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_guidanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_guidance",  getId_guidanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("协助或指导");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 协助或指导编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_guidanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_guidance",  getSd_guidanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("协助或指导编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 补充内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSup_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sup_content",  getSup_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("补充内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否将分数保存到护理记录单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_is_savenurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_is_savenur",  getId_is_savenurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否将分数保存到护理记录单");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否将分数保存到护理记录单编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_is_savenurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_is_savenur",  getSd_is_savenurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否将分数保存到护理记录单编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 保存到护理记录单内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_contentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_content",  getNur_contentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("保存到护理记录单内容");
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
	private IAttrDesc getId_nutri_staADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nutri_sta",  getId_nutri_staCDesc(tblDesc), this);
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
	private IAttrDesc getSd_nutri_staADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nutri_sta",  getSd_nutri_staCDesc(tblDesc), this);
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
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_feelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_feel",  getName_feelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_feel=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ass_pointADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ass_point",  getName_ass_pointCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_ass_point=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dampADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_damp",  getName_dampCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_damp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_act_abilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_act_ability",  getName_act_abilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_act_ability=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_mobileADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_mobile",  getName_mobileCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_mobile=id_udidoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_friction=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_weightADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_weight",  getName_weightCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_weight=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_agesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ages",  getName_agesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_ages=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_albuminADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_albumin",  getName_albuminCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_albumin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hb",  getName_hbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_hb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dietADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diet",  getName_dietCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_diet=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ora_mucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ora_mucosa",  getName_ora_mucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_ora_mucosa=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_teethADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_teeth",  getName_teethCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_teeth=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_measuresADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_measures",  getName_nur_measuresCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_nur_measures=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_guidanceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_guidance",  getName_guidanceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_guidance=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_is_savenurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_is_savenur",  getName_is_savenurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_is_savenur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nutri_staADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nutri_sta",  getName_nutri_staCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_nutri_sta=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取评估单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估单主键"); 
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
	 * 获取感知表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_feel");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感知"); 
		return column;
	}
	/**
	 * 获取感知编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_feel");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("感知编码"); 
		return column;
	}
	/**
	 * 获取评估点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ass_pointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ass_point");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估点"); 
		return column;
	}
	/**
	 * 获取评估点编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ass_pointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ass_point");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("评估点编码"); 
		return column;
	}
	/**
	 * 获取潮湿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_damp");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("潮湿"); 
		return column;
	}
	/**
	 * 获取潮湿编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_damp");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("潮湿编码"); 
		return column;
	}
	/**
	 * 获取活动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_act_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_act_ability");
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
	private IColumnDesc getSd_act_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_act_ability");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("活动能力编码"); 
		return column;
	}
	/**
	 * 获取移动能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mobileCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mobile");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动能力"); 
		return column;
	}
	/**
	 * 获取移动能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_mobileCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_mobile");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("移动能力编码"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_frictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_friction");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_frictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_friction");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力编码"); 
		return column;
	}
	/**
	 * 获取体重表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_weight");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体重"); 
		return column;
	}
	/**
	 * 获取体重编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_weight");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体重编码"); 
		return column;
	}
	/**
	 * 获取年龄段表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_agesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ages");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄段"); 
		return column;
	}
	/**
	 * 获取年龄段编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_agesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ages");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("年龄段编码"); 
		return column;
	}
	/**
	 * 获取白蛋白表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_albuminCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_albumin");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("白蛋白"); 
		return column;
	}
	/**
	 * 获取白蛋白编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_albuminCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_albumin");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("白蛋白编码"); 
		return column;
	}
	/**
	 * 获取Hb表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hb");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Hb"); 
		return column;
	}
	/**
	 * 获取Hb编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hb");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Hb编码"); 
		return column;
	}
	/**
	 * 获取饮食表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diet");
		column.setLength(500);
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
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食编码"); 
		return column;
	}
	/**
	 * 获取口腔粘膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ora_mucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ora_mucosa");
		column.setLength(500);
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
	private IColumnDesc getSd_ora_mucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ora_mucosa");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔粘膜编码"); 
		return column;
	}
	/**
	 * 获取牙齿表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_teethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_teeth");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("牙齿"); 
		return column;
	}
	/**
	 * 获取牙齿编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_teethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_teeth");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("牙齿编码"); 
		return column;
	}
	/**
	 * 获取护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_measuresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_measures");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理措施"); 
		return column;
	}
	/**
	 * 获取护理措施编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nur_measuresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nur_measures");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理措施编码"); 
		return column;
	}
	/**
	 * 获取感觉分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_feel");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("感觉分值"); 
		return column;
	}
	/**
	 * 获取潮湿分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_damp");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("潮湿分值"); 
		return column;
	}
	/**
	 * 获取活动能力分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_actCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_act");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("活动能力分值"); 
		return column;
	}
	/**
	 * 获取移动能力分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_mobileCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_mobile");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("移动能力分值"); 
		return column;
	}
	/**
	 * 获取摩擦力和剪切力分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_frictionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_friction");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("摩擦力和剪切力分值"); 
		return column;
	}
	/**
	 * 获取体重分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_weight");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("体重分值"); 
		return column;
	}
	/**
	 * 获取年龄分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_agesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_ages");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("年龄分值"); 
		return column;
	}
	/**
	 * 获取白蛋白分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_albuminCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_albumin");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("白蛋白分值"); 
		return column;
	}
	/**
	 * 获取Hb分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_hbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_hb");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("Hb分值"); 
		return column;
	}
	/**
	 * 获取饮食分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_diet");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("饮食分值"); 
		return column;
	}
	/**
	 * 获取口腔粘膜分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_oraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_ora");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("口腔粘膜分值"); 
		return column;
	}
	/**
	 * 获取牙齿分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_teethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_teeth");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("牙齿分值"); 
		return column;
	}
	/**
	 * 获取营养评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_nutritionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_nutrition");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("营养评分"); 
		return column;
	}
	/**
	 * 获取总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTotal_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Total_score");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("总分"); 
		return column;
	}
	/**
	 * 获取营养提示表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTips_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tips_content");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养提示"); 
		return column;
	}
	/**
	 * 获取营养总分值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getScore_hintCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Score_hint");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("营养总分值"); 
		return column;
	}
	/**
	 * 获取协助或指导表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_guidanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_guidance");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("协助或指导"); 
		return column;
	}
	/**
	 * 获取协助或指导编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_guidanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_guidance");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("协助或指导编码"); 
		return column;
	}
	/**
	 * 获取补充内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSup_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sup_content");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("补充内容"); 
		return column;
	}
	/**
	 * 获取是否将分数保存到护理记录单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_is_savenurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_is_savenur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否将分数保存到护理记录单"); 
		return column;
	}
	/**
	 * 获取是否将分数保存到护理记录单编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_is_savenurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_is_savenur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否将分数保存到护理记录单编码"); 
		return column;
	}
	/**
	 * 获取保存到护理记录单内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_contentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_content");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("保存到护理记录单内容"); 
		return column;
	}
	/**
	 * 获取营养状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nutri_staCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nutri_sta");
		column.setLength(20);
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
	private IColumnDesc getSd_nutri_staCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nutri_sta");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养状况编码"); 
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
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
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
	private IColumnDesc getName_feelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_feel");
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
	private IColumnDesc getName_ass_pointCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ass_point");
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
	private IColumnDesc getName_dampCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_damp");
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
	private IColumnDesc getName_act_abilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_act_ability");
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
	private IColumnDesc getName_mobileCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_mobile");
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_weightCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_weight");
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
	private IColumnDesc getName_agesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ages");
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
	private IColumnDesc getName_albuminCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_albumin");
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
	private IColumnDesc getName_hbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hb");
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
	private IColumnDesc getName_dietCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diet");
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
	private IColumnDesc getName_ora_mucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ora_mucosa");
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
	private IColumnDesc getName_teethCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_teeth");
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
	private IColumnDesc getName_nur_measuresCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_measures");
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
	private IColumnDesc getName_guidanceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_guidance");
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
	private IColumnDesc getName_is_savenurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_is_savenur");
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
	private IColumnDesc getName_nutri_staCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nutri_sta");
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
