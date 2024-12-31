
package iih.ci.mr.nu.pedadmcare.d.desc;

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
 * 儿科入院护理评估记录单 DO 元数据信息
 */
public class PedadmcareDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.mr.nu.pedadmcare.d.PedadmcareDO";
	public static final String CLASS_DISPALYNAME = "儿科入院护理评估记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "mr_nu_pedadmcare";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_pedadmcare";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public PedadmcareDODesc(){
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
		this.setKeyDesc(getId_pedadmcareADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_pedadmcareADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getRepresentorADesc(tblDesc));
		this.add(getRelationshipADesc(tblDesc));
		this.add(getDt_entryADesc(tblDesc));
		this.add(getTodoctortimeADesc(tblDesc));
		this.add(getContactaddressADesc(tblDesc));
		this.add(getLinkmanADesc(tblDesc));
		this.add(getLinkmantelADesc(tblDesc));
		this.add(getId_hospitalizewayADesc(tblDesc));
		this.add(getSd_hospitalizewayADesc(tblDesc));
		this.add(getId_nationADesc(tblDesc));
		this.add(getId_educADesc(tblDesc));
		this.add(getFg_allergyADesc(tblDesc));
		this.add(getFg_pastmedicADesc(tblDesc));
		this.add(getOther_hospitalizewayADesc(tblDesc));
		this.add(getReasonsadmissionADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getTelephoneADesc(tblDesc));
		this.add(getAddressADesc(tblDesc));
		this.add(getName_allergyADesc(tblDesc));
		this.add(getName_pastmedicADesc(tblDesc));
		this.add(getTemADesc(tblDesc));
		this.add(getPaulseADesc(tblDesc));
		this.add(getBreathADesc(tblDesc));
		this.add(getWeightADesc(tblDesc));
		this.add(getSys_preADesc(tblDesc));
		this.add(getDia_preADesc(tblDesc));
		this.add(getId_consciousnessADesc(tblDesc));
		this.add(getSd_consciousnessADesc(tblDesc));
		this.add(getOther_consciousnessADesc(tblDesc));
		this.add(getId_emotionalstatusADesc(tblDesc));
		this.add(getSd_emotionalstatusADesc(tblDesc));
		this.add(getOther_emotionalADesc(tblDesc));
		this.add(getId_languageabilityADesc(tblDesc));
		this.add(getSd_languageabilityADesc(tblDesc));
		this.add(getId_fontanelleADesc(tblDesc));
		this.add(getSd_fontanelleADesc(tblDesc));
		this.add(getId_lipsADesc(tblDesc));
		this.add(getSd_lipsADesc(tblDesc));
		this.add(getOther_lipsADesc(tblDesc));
		this.add(getId_oralmucosaADesc(tblDesc));
		this.add(getSd_oralmucosaADesc(tblDesc));
		this.add(getOther_oralmucosaADesc(tblDesc));
		this.add(getId_skinADesc(tblDesc));
		this.add(getSd_skinADesc(tblDesc));
		this.add(getOther_skinADesc(tblDesc));
		this.add(getId_limbADesc(tblDesc));
		this.add(getSd_limbADesc(tblDesc));
		this.add(getId_peeexcretionADesc(tblDesc));
		this.add(getSd_peeexcretionADesc(tblDesc));
		this.add(getOther_peeexcretionADesc(tblDesc));
		this.add(getId_shitexcretionADesc(tblDesc));
		this.add(getSd_shitexcretionADesc(tblDesc));
		this.add(getOther_shitADesc(tblDesc));
		this.add(getAdlscoreADesc(tblDesc));
		this.add(getBraden_qscoreADesc(tblDesc));
		this.add(getFallbedscoreADesc(tblDesc));
		this.add(getPipeslippagestoreADesc(tblDesc));
		this.add(getId_sleephabitADesc(tblDesc));
		this.add(getSd_sleephabitADesc(tblDesc));
		this.add(getOther_sleephabitADesc(tblDesc));
		this.add(getName_other_tongueADesc(tblDesc));
		this.add(getName_other_tonguecoatADesc(tblDesc));
		this.add(getId_tongueADesc(tblDesc));
		this.add(getSd_tongueADesc(tblDesc));
		this.add(getId_tongue_coatADesc(tblDesc));
		this.add(getSd_tongue_coatADesc(tblDesc));
		this.add(getId_eathabitADesc(tblDesc));
		this.add(getSd_eathabitADesc(tblDesc));
		this.add(getOther_eatADesc(tblDesc));
		this.add(getId_familyattitudeADesc(tblDesc));
		this.add(getSd_familyattitudeADesc(tblDesc));
		this.add(getId_hospitaleducationADesc(tblDesc));
		this.add(getSd_hospitaleducationADesc(tblDesc));
		this.add(getOther_hospitaleducaADesc(tblDesc));
		this.add(getNursingplanADesc(tblDesc));
		this.add(getEvaluationtimeADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_hospitalizewayADesc(tblDesc));
		this.add(getName_nationADesc(tblDesc));
		this.add(getName_educADesc(tblDesc));
		this.add(getName_consciousnessADesc(tblDesc));
		this.add(getName_emotionalstatusADesc(tblDesc));
		this.add(getName_languageabilityADesc(tblDesc));
		this.add(getName_fontanelleADesc(tblDesc));
		this.add(getName_lipsADesc(tblDesc));
		this.add(getName_oralmucosaADesc(tblDesc));
		this.add(getName_skinADesc(tblDesc));
		this.add(getName_limbADesc(tblDesc));
		this.add(getName_peeexcretionADesc(tblDesc));
		this.add(getName_shitexcretionADesc(tblDesc));
		this.add(getName_sleephabitADesc(tblDesc));
		this.add(getName_tongueADesc(tblDesc));
		this.add(getName_tongue_coatADesc(tblDesc));
		this.add(getName_eathabitADesc(tblDesc));
		this.add(getName_familyattitudeADesc(tblDesc));
		this.add(getName_hospitaleducationADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_pedadmcareCDesc(tblDesc));
		tblDesc.add(getId_pedadmcareCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getRepresentorCDesc(tblDesc));
		tblDesc.add(getRelationshipCDesc(tblDesc));
		tblDesc.add(getDt_entryCDesc(tblDesc));
		tblDesc.add(getTodoctortimeCDesc(tblDesc));
		tblDesc.add(getContactaddressCDesc(tblDesc));
		tblDesc.add(getLinkmanCDesc(tblDesc));
		tblDesc.add(getLinkmantelCDesc(tblDesc));
		tblDesc.add(getId_hospitalizewayCDesc(tblDesc));
		tblDesc.add(getSd_hospitalizewayCDesc(tblDesc));
		tblDesc.add(getId_nationCDesc(tblDesc));
		tblDesc.add(getId_educCDesc(tblDesc));
		tblDesc.add(getFg_allergyCDesc(tblDesc));
		tblDesc.add(getFg_pastmedicCDesc(tblDesc));
		tblDesc.add(getOther_hospitalizewayCDesc(tblDesc));
		tblDesc.add(getReasonsadmissionCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getTelephoneCDesc(tblDesc));
		tblDesc.add(getAddressCDesc(tblDesc));
		tblDesc.add(getName_allergyCDesc(tblDesc));
		tblDesc.add(getName_pastmedicCDesc(tblDesc));
		tblDesc.add(getTemCDesc(tblDesc));
		tblDesc.add(getPaulseCDesc(tblDesc));
		tblDesc.add(getBreathCDesc(tblDesc));
		tblDesc.add(getWeightCDesc(tblDesc));
		tblDesc.add(getSys_preCDesc(tblDesc));
		tblDesc.add(getDia_preCDesc(tblDesc));
		tblDesc.add(getId_consciousnessCDesc(tblDesc));
		tblDesc.add(getSd_consciousnessCDesc(tblDesc));
		tblDesc.add(getOther_consciousnessCDesc(tblDesc));
		tblDesc.add(getId_emotionalstatusCDesc(tblDesc));
		tblDesc.add(getSd_emotionalstatusCDesc(tblDesc));
		tblDesc.add(getOther_emotionalCDesc(tblDesc));
		tblDesc.add(getId_languageabilityCDesc(tblDesc));
		tblDesc.add(getSd_languageabilityCDesc(tblDesc));
		tblDesc.add(getId_fontanelleCDesc(tblDesc));
		tblDesc.add(getSd_fontanelleCDesc(tblDesc));
		tblDesc.add(getId_lipsCDesc(tblDesc));
		tblDesc.add(getSd_lipsCDesc(tblDesc));
		tblDesc.add(getOther_lipsCDesc(tblDesc));
		tblDesc.add(getId_oralmucosaCDesc(tblDesc));
		tblDesc.add(getSd_oralmucosaCDesc(tblDesc));
		tblDesc.add(getOther_oralmucosaCDesc(tblDesc));
		tblDesc.add(getId_skinCDesc(tblDesc));
		tblDesc.add(getSd_skinCDesc(tblDesc));
		tblDesc.add(getOther_skinCDesc(tblDesc));
		tblDesc.add(getId_limbCDesc(tblDesc));
		tblDesc.add(getSd_limbCDesc(tblDesc));
		tblDesc.add(getId_peeexcretionCDesc(tblDesc));
		tblDesc.add(getSd_peeexcretionCDesc(tblDesc));
		tblDesc.add(getOther_peeexcretionCDesc(tblDesc));
		tblDesc.add(getId_shitexcretionCDesc(tblDesc));
		tblDesc.add(getSd_shitexcretionCDesc(tblDesc));
		tblDesc.add(getOther_shitCDesc(tblDesc));
		tblDesc.add(getAdlscoreCDesc(tblDesc));
		tblDesc.add(getBraden_qscoreCDesc(tblDesc));
		tblDesc.add(getFallbedscoreCDesc(tblDesc));
		tblDesc.add(getPipeslippagestoreCDesc(tblDesc));
		tblDesc.add(getId_sleephabitCDesc(tblDesc));
		tblDesc.add(getSd_sleephabitCDesc(tblDesc));
		tblDesc.add(getOther_sleephabitCDesc(tblDesc));
		tblDesc.add(getName_other_tongueCDesc(tblDesc));
		tblDesc.add(getName_other_tonguecoatCDesc(tblDesc));
		tblDesc.add(getId_tongueCDesc(tblDesc));
		tblDesc.add(getSd_tongueCDesc(tblDesc));
		tblDesc.add(getId_tongue_coatCDesc(tblDesc));
		tblDesc.add(getSd_tongue_coatCDesc(tblDesc));
		tblDesc.add(getId_eathabitCDesc(tblDesc));
		tblDesc.add(getSd_eathabitCDesc(tblDesc));
		tblDesc.add(getOther_eatCDesc(tblDesc));
		tblDesc.add(getId_familyattitudeCDesc(tblDesc));
		tblDesc.add(getSd_familyattitudeCDesc(tblDesc));
		tblDesc.add(getId_hospitaleducationCDesc(tblDesc));
		tblDesc.add(getSd_hospitaleducationCDesc(tblDesc));
		tblDesc.add(getOther_hospitaleducaCDesc(tblDesc));
		tblDesc.add(getNursingplanCDesc(tblDesc));
		tblDesc.add(getEvaluationtimeCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 儿科入院护理评估单ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pedadmcareADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pedadmcare",  getId_pedadmcareCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿科入院护理评估单ID");
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
	 * 科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室");
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
	 * 病史陈述者属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRepresentorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Representor",  getRepresentorCDesc(tblDesc), this);
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
	 * 与患儿关系属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRelationshipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Relationship",  getRelationshipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("与患儿关系");
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
	 * 告知医生时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTodoctortimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Todoctortime",  getTodoctortimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("告知医生时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContactaddressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Contactaddress",  getContactaddressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系地址");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLinkmanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Linkman",  getLinkmanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人");
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
	private IAttrDesc getLinkmantelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Linkmantel",  getLinkmantelCDesc(tblDesc), this);
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
	 * 入院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitalizeway",  getId_hospitalizewayCDesc(tblDesc), this);
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
	private IAttrDesc getSd_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hospitalizeway",  getSd_hospitalizewayCDesc(tblDesc), this);
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
	 * 民族属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nation",  getId_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 文化程度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_educADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_educ",  getId_educCDesc(tblDesc), this);
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
	 * 过敏史有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_allergy",  getFg_allergyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("过敏史有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 既往史有无属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pastmedicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pastmedic",  getFg_pastmedicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("既往史有无");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院方式其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_hospitalizeway",  getOther_hospitalizewayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式其他");
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
	private IAttrDesc getReasonsadmissionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reasonsadmission",  getReasonsadmissionCDesc(tblDesc), this);
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
	 * 电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelephoneADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Telephone",  getTelephoneCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 地址属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAddressADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Address",  getAddressCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("地址");
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
	private IAttrDesc getName_allergyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_allergy",  getName_allergyCDesc(tblDesc), this);
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
	 * 既往史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pastmedicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pastmedic",  getName_pastmedicCDesc(tblDesc), this);
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
	 * 体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTemADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tem",  getTemCDesc(tblDesc), this);
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
	private IAttrDesc getPaulseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Paulse",  getPaulseCDesc(tblDesc), this);
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
	private IAttrDesc getBreathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Breath",  getBreathCDesc(tblDesc), this);
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
	 * 收缩压属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSys_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sys_pre",  getSys_preCDesc(tblDesc), this);
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
	private IAttrDesc getDia_preADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dia_pre",  getDia_preCDesc(tblDesc), this);
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
	 * 神志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_consciousness",  getId_consciousnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 神志编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_consciousness",  getSd_consciousnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 神志其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_consciousness",  getOther_consciousnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emotionalstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emotionalstatus",  getId_emotionalstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 情绪状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emotionalstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emotionalstatus",  getSd_emotionalstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪状态其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_emotionalADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_emotional",  getOther_emotionalCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪状态其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言能力属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_languageabilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_languageability",  getId_languageabilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言能力");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 语言能力编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_languageabilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_languageability",  getSd_languageabilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言能力编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卤门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_fontanelleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_fontanelle",  getId_fontanelleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卤门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 卤门编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_fontanelleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_fontanelle",  getSd_fontanelleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卤门编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口唇属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lipsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lips",  getId_lipsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口唇");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 口唇编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lipsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lips",  getSd_lipsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口唇编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口唇其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_lipsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_lips",  getOther_lipsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口唇其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口腔黏膜属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_oralmucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_oralmucosa",  getId_oralmucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔黏膜");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 口腔黏膜编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_oralmucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_oralmucosa",  getSd_oralmucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔黏膜编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口腔黏膜其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_oralmucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_oralmucosa",  getOther_oralmucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔黏膜其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 儿科皮肤属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_skin",  getId_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿科皮肤");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 儿科皮肤编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_skin",  getSd_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿科皮肤编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 儿科皮肤其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_skin",  getOther_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("儿科皮肤其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 四肢属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_limbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_limb",  getId_limbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("四肢");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 四肢编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_limbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_limb",  getSd_limbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("四肢编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便排泄情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_peeexcretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_peeexcretion",  getId_peeexcretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便排泄情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 小便排泄情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_peeexcretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_peeexcretion",  getSd_peeexcretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便排泄情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_peeexcretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_peeexcretion",  getOther_peeexcretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便排泄情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_shitexcretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_shitexcretion",  getId_shitexcretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便排泄情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 大便排泄情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_shitexcretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_shitexcretion",  getSd_shitexcretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便排泄情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排泄情况大便其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_shitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_shit",  getOther_shitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排泄情况大便其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * ADL评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdlscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adlscore",  getAdlscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("ADL评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Braden_Q评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBraden_qscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Braden_qscore",  getBraden_qscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("Braden_Q评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒坠床评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFallbedscoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fallbedscore",  getFallbedscoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("跌倒坠床评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 管道滑脱评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPipeslippagestoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Pipeslippagestore",  getPipeslippagestoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("管道滑脱评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠生活习惯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sleephabitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sleephabit",  getId_sleephabitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠生活习惯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 睡眠生活习惯编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sleephabitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sleephabit",  getSd_sleephabitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠生活习惯编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠生活习惯其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_sleephabitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_sleephabit",  getOther_sleephabitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠生活习惯其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌质其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_tongue",  getName_other_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌质其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌苔其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_other_tonguecoatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_other_tonguecoat",  getName_other_tonguecoatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌质属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tongue",  getId_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌质");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 舌质编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tongue",  getSd_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌质编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 舌苔属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tongue_coatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tongue_coat",  getId_tongue_coatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 舌苔编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_tongue_coatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tongue_coat",  getSd_tongue_coatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("舌苔编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食生活习惯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_eathabitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_eathabit",  getId_eathabitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食生活习惯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 饮食生活习惯编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_eathabitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_eathabit",  getSd_eathabitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食生活习惯编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 生活习惯饮食其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_eatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_eat",  getOther_eatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("生活习惯饮食其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家属态度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_familyattitudeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_familyattitude",  getId_familyattitudeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家属态度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 家属态度编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_familyattitudeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_familyattitude",  getSd_familyattitudeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家属态度编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院宣教属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hospitaleducationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hospitaleducation",  getId_hospitaleducationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院宣教编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hospitaleducationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hospitaleducation",  getSd_hospitaleducationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院宣教其他属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOther_hospitaleducaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Other_hospitaleduca",  getOther_hospitaleducaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教其他");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNursingplanADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nursingplan",  getNursingplanCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理计划");
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
	private IAttrDesc getEvaluationtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evaluationtime",  getEvaluationtimeCDesc(tblDesc), this);
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
	 * 护士签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
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
	 * 入院方式名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hospitalizewayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hospitalizeway",  getName_hospitalizewayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院方式名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b35","id_hospitalizeway=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 民族名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nation",  getName_nationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("民族名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b42","id_nation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 文化程度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_educADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_educ",  getName_educCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("文化程度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b43","id_educ=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 神志名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_consciousnessADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_consciousness",  getName_consciousnessCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("神志名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_consciousness=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 情绪状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emotionalstatusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emotionalstatus",  getName_emotionalstatusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("情绪状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_emotionalstatus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 语言能力名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_languageabilityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_languageability",  getName_languageabilityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("语言能力名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_languageability=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 卤门名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_fontanelleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_fontanelle",  getName_fontanelleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("卤门名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_fontanelle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口唇名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lipsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lips",  getName_lipsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口唇名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b22","id_lips=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 口腔黏膜名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_oralmucosaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_oralmucosa",  getName_oralmucosaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("口腔黏膜名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_oralmucosa=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 皮肤名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_skinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_skin",  getName_skinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("皮肤名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_skin=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 四肢名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_limbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_limb",  getName_limbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("四肢名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_limb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 小便排泄情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_peeexcretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_peeexcretion",  getName_peeexcretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("小便排泄情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_peeexcretion=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 大便排泄情况名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_shitexcretionADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_shitexcretion",  getName_shitexcretionCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("大便排泄情况名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_shitexcretion=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 睡眠生活习惯名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sleephabitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sleephabit",  getName_sleephabitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("睡眠生活习惯名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b33","id_sleephabit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tongueADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tongue",  getName_tongueCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b40","id_tongue=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tongue_coatADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tongue_coat",  getName_tongue_coatCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b41","id_tongue_coat=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 饮食生活习惯属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_eathabitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_eathabit",  getName_eathabitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("饮食生活习惯");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b34","id_eathabit=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 家属态度名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_familyattitudeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_familyattitude",  getName_familyattitudeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("家属态度名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b28","id_familyattitude=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院宣教名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hospitaleducationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hospitaleducation",  getName_hospitaleducationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院宣教名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_hospitaleducation=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b36","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取儿科入院护理评估单ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pedadmcareCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pedadmcare");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿科入院护理评估单ID"); 
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
	 * 获取科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室"); 
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
	 * 获取病史陈述者表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRepresentorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Representor");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病史陈述者"); 
		return column;
	}
	/**
	 * 获取与患儿关系表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRelationshipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Relationship");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("与患儿关系"); 
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
	 * 获取告知医生时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTodoctortimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Todoctortime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("告知医生时间"); 
		return column;
	}
	/**
	 * 获取联系地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContactaddressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Contactaddress");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系地址"); 
		return column;
	}
	/**
	 * 获取联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLinkmanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Linkman");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人"); 
		return column;
	}
	/**
	 * 获取联系电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLinkmantelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Linkmantel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系电话"); 
		return column;
	}
	/**
	 * 获取入院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitalizeway");
		column.setLength(20);
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
	private IColumnDesc getSd_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hospitalizeway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式编码"); 
		return column;
	}
	/**
	 * 获取民族表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nation");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族"); 
		return column;
	}
	/**
	 * 获取文化程度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_educCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_educ");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度"); 
		return column;
	}
	/**
	 * 获取过敏史有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_allergy");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("过敏史有无"); 
		return column;
	}
	/**
	 * 获取既往史有无表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pastmedicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pastmedic");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("既往史有无"); 
		return column;
	}
	/**
	 * 获取入院方式其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_hospitalizeway");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式其他"); 
		return column;
	}
	/**
	 * 获取入院原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReasonsadmissionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reasonsadmission");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院原因"); 
		return column;
	}
	/**
	 * 获取诊断Id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diagnosisCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diagnosis");
		column.setLength(20);
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
	 * 获取电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelephoneCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Telephone");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("电话"); 
		return column;
	}
	/**
	 * 获取地址表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAddressCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Address");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("地址"); 
		return column;
	}
	/**
	 * 获取过敏史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_allergyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_allergy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("过敏史"); 
		return column;
	}
	/**
	 * 获取既往史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pastmedicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pastmedic");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("既往史"); 
		return column;
	}
	/**
	 * 获取体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTemCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tem");
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
	private IColumnDesc getPaulseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Paulse");
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
	private IColumnDesc getBreathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Breath");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("呼吸"); 
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
	 * 获取收缩压表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSys_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sys_pre");
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
	private IColumnDesc getDia_preCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dia_pre");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("舒张压"); 
		return column;
	}
	/**
	 * 获取神志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_consciousness");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志"); 
		return column;
	}
	/**
	 * 获取神志编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_consciousness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志编码"); 
		return column;
	}
	/**
	 * 获取神志其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_consciousness");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志其他"); 
		return column;
	}
	/**
	 * 获取情绪状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emotionalstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emotionalstatus");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪状态"); 
		return column;
	}
	/**
	 * 获取情绪状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emotionalstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emotionalstatus");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪状态编码"); 
		return column;
	}
	/**
	 * 获取情绪状态其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_emotionalCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_emotional");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪状态其他"); 
		return column;
	}
	/**
	 * 获取语言能力表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_languageabilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_languageability");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言能力"); 
		return column;
	}
	/**
	 * 获取语言能力编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_languageabilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_languageability");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言能力编码"); 
		return column;
	}
	/**
	 * 获取卤门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_fontanelleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_fontanelle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卤门"); 
		return column;
	}
	/**
	 * 获取卤门编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_fontanelleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_fontanelle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卤门编码"); 
		return column;
	}
	/**
	 * 获取口唇表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lipsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lips");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口唇"); 
		return column;
	}
	/**
	 * 获取口唇编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lipsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lips");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口唇编码"); 
		return column;
	}
	/**
	 * 获取口唇其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_lipsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_lips");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口唇其他"); 
		return column;
	}
	/**
	 * 获取口腔黏膜表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_oralmucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_oralmucosa");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔黏膜"); 
		return column;
	}
	/**
	 * 获取口腔黏膜编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_oralmucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_oralmucosa");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔黏膜编码"); 
		return column;
	}
	/**
	 * 获取口腔黏膜其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_oralmucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_oralmucosa");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔黏膜其他"); 
		return column;
	}
	/**
	 * 获取儿科皮肤表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_skin");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿科皮肤"); 
		return column;
	}
	/**
	 * 获取儿科皮肤编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿科皮肤编码"); 
		return column;
	}
	/**
	 * 获取儿科皮肤其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_skin");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("儿科皮肤其他"); 
		return column;
	}
	/**
	 * 获取四肢表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_limbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_limb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("四肢"); 
		return column;
	}
	/**
	 * 获取四肢编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_limbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_limb");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("四肢编码"); 
		return column;
	}
	/**
	 * 获取小便排泄情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_peeexcretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_peeexcretion");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便排泄情况"); 
		return column;
	}
	/**
	 * 获取小便排泄情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_peeexcretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_peeexcretion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便排泄情况编码"); 
		return column;
	}
	/**
	 * 获取小便其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_peeexcretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_peeexcretion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便其他"); 
		return column;
	}
	/**
	 * 获取大便排泄情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_shitexcretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_shitexcretion");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便排泄情况"); 
		return column;
	}
	/**
	 * 获取大便排泄情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_shitexcretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_shitexcretion");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便排泄情况编码"); 
		return column;
	}
	/**
	 * 获取排泄情况大便其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_shitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_shit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排泄情况大便其他"); 
		return column;
	}
	/**
	 * 获取ADL评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdlscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adlscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("ADL评分"); 
		return column;
	}
	/**
	 * 获取Braden_Q评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBraden_qscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Braden_qscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("Braden_Q评分"); 
		return column;
	}
	/**
	 * 获取跌倒坠床评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFallbedscoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fallbedscore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("跌倒坠床评分"); 
		return column;
	}
	/**
	 * 获取管道滑脱评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPipeslippagestoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Pipeslippagestore");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("管道滑脱评分"); 
		return column;
	}
	/**
	 * 获取睡眠生活习惯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sleephabitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sleephabit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠生活习惯"); 
		return column;
	}
	/**
	 * 获取睡眠生活习惯编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sleephabitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sleephabit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠生活习惯编码"); 
		return column;
	}
	/**
	 * 获取睡眠生活习惯其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_sleephabitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_sleephabit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠生活习惯其他"); 
		return column;
	}
	/**
	 * 获取舌质其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_tongue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质其他"); 
		return column;
	}
	/**
	 * 获取舌苔其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_other_tonguecoatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_other_tonguecoat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔其他"); 
		return column;
	}
	/**
	 * 获取舌质表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tongue");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质"); 
		return column;
	}
	/**
	 * 获取舌质编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tongue");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌质编码"); 
		return column;
	}
	/**
	 * 获取舌苔表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tongue_coatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tongue_coat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔"); 
		return column;
	}
	/**
	 * 获取舌苔编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_tongue_coatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tongue_coat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("舌苔编码"); 
		return column;
	}
	/**
	 * 获取饮食生活习惯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_eathabitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_eathabit");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食生活习惯"); 
		return column;
	}
	/**
	 * 获取饮食生活习惯编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_eathabitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_eathabit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食生活习惯编码"); 
		return column;
	}
	/**
	 * 获取生活习惯饮食其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_eatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_eat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("生活习惯饮食其他"); 
		return column;
	}
	/**
	 * 获取家属态度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_familyattitudeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_familyattitude");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家属态度"); 
		return column;
	}
	/**
	 * 获取家属态度编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_familyattitudeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_familyattitude");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家属态度编码"); 
		return column;
	}
	/**
	 * 获取入院宣教表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hospitaleducationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hospitaleducation");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教"); 
		return column;
	}
	/**
	 * 获取入院宣教编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hospitaleducationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hospitaleducation");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教编码"); 
		return column;
	}
	/**
	 * 获取入院宣教其他表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOther_hospitaleducaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Other_hospitaleduca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教其他"); 
		return column;
	}
	/**
	 * 获取护理计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNursingplanCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nursingplan");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理计划"); 
		return column;
	}
	/**
	 * 获取评估时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvaluationtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evaluationtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("评估时间"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士签名"); 
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
	 * 获取入院方式名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hospitalizewayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hospitalizeway");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院方式名称"); 
		return column;
	}
	/**
	 * 获取民族名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("民族名称"); 
		return column;
	}
	/**
	 * 获取文化程度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_educCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_educ");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("文化程度名称"); 
		return column;
	}
	/**
	 * 获取神志名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_consciousnessCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_consciousness");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("神志名称"); 
		return column;
	}
	/**
	 * 获取情绪状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emotionalstatusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emotionalstatus");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("情绪状态名称"); 
		return column;
	}
	/**
	 * 获取语言能力名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_languageabilityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_languageability");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("语言能力名称"); 
		return column;
	}
	/**
	 * 获取卤门名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_fontanelleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_fontanelle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("卤门名称"); 
		return column;
	}
	/**
	 * 获取口唇名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lipsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lips");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口唇名称"); 
		return column;
	}
	/**
	 * 获取口腔黏膜名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_oralmucosaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_oralmucosa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("口腔黏膜名称"); 
		return column;
	}
	/**
	 * 获取皮肤名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_skinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_skin");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("皮肤名称"); 
		return column;
	}
	/**
	 * 获取四肢名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_limbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_limb");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("四肢名称"); 
		return column;
	}
	/**
	 * 获取小便排泄情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_peeexcretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_peeexcretion");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("小便排泄情况名称"); 
		return column;
	}
	/**
	 * 获取大便排泄情况名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_shitexcretionCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_shitexcretion");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("大便排泄情况名称"); 
		return column;
	}
	/**
	 * 获取睡眠生活习惯名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sleephabitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sleephabit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("睡眠生活习惯名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tongueCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tongue");
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
	private IColumnDesc getName_tongue_coatCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tongue_coat");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取饮食生活习惯表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_eathabitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_eathabit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("饮食生活习惯"); 
		return column;
	}
	/**
	 * 获取家属态度名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_familyattitudeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_familyattitude");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("家属态度名称"); 
		return column;
	}
	/**
	 * 获取入院宣教名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hospitaleducationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hospitaleducation");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院宣教名称"); 
		return column;
	}
	/**
	 * 获取护士姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士姓名"); 
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
