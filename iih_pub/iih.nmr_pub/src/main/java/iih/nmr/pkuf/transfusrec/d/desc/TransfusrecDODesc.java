
package iih.nmr.pkuf.transfusrec.d.desc;

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
 * 输血安全护理记录单 DO 元数据信息
 */
public class TransfusrecDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.pkuf.transfusrec.d.TransfusrecDO";
	public static final String CLASS_DISPALYNAME = "输血安全护理记录单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NMR_PKUF_TRANSFUSREC";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_transfusrec";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TransfusrecDODesc(){
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
		this.setKeyDesc(getId_transfusrecADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_transfusrecADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getId_signADesc(tblDesc));
		this.add(getDt_createADesc(tblDesc));
		this.add(getBlcoll_dateADesc(tblDesc));
		this.add(getBlcoll_timeADesc(tblDesc));
		this.add(getBloodcolleADesc(tblDesc));
		this.add(getId_bloodaboADesc(tblDesc));
		this.add(getSd_bloodaboADesc(tblDesc));
		this.add(getId_bloodrhADesc(tblDesc));
		this.add(getSd_bloodrhADesc(tblDesc));
		this.add(getId_bloodpraboADesc(tblDesc));
		this.add(getSd_bloodpraboADesc(tblDesc));
		this.add(getId_bloodprrhADesc(tblDesc));
		this.add(getSd_bloodprrhADesc(tblDesc));
		this.add(getNv_tADesc(tblDesc));
		this.add(getId_input_pathADesc(tblDesc));
		this.add(getSd_input_pathADesc(tblDesc));
		this.add(getId_input_modeADesc(tblDesc));
		this.add(getSd_input_modeADesc(tblDesc));
		this.add(getId_sign_ststusADesc(tblDesc));
		this.add(getSd_sign_ststusADesc(tblDesc));
		this.add(getId_check_caseADesc(tblDesc));
		this.add(getSd_check_caseADesc(tblDesc));
		this.add(getId_bloodaboaADesc(tblDesc));
		this.add(getSd_bloodaboaADesc(tblDesc));
		this.add(getId_bloodrhaADesc(tblDesc));
		this.add(getSd_bloodrhaADesc(tblDesc));
		this.add(getId_bloodpraboaADesc(tblDesc));
		this.add(getSd_bloodpraboaADesc(tblDesc));
		this.add(getId_bloodprrhaADesc(tblDesc));
		this.add(getSd_bloodprrhaADesc(tblDesc));
		this.add(getId_bloodpr_typeADesc(tblDesc));
		this.add(getSd_bloodpr_typeADesc(tblDesc));
		this.add(getBloodpr_numADesc(tblDesc));
		this.add(getId_cross_matchADesc(tblDesc));
		this.add(getSd_cross_matchADesc(tblDesc));
		this.add(getId_blbag_facADesc(tblDesc));
		this.add(getSd_blbag_facADesc(tblDesc));
		this.add(getBlbag_barcodeADesc(tblDesc));
		this.add(getBlood_validityADesc(tblDesc));
		this.add(getId_blood_donatorADesc(tblDesc));
		this.add(getId_checkerADesc(tblDesc));
		this.add(getId_check_casesADesc(tblDesc));
		this.add(getSd_check_casesADesc(tblDesc));
		this.add(getId_bloodpr_typesADesc(tblDesc));
		this.add(getSd_bloodpr_typesADesc(tblDesc));
		this.add(getId_bloodabobADesc(tblDesc));
		this.add(getSd_bloodabobADesc(tblDesc));
		this.add(getId_bloodrhbADesc(tblDesc));
		this.add(getSd_bloodrhbADesc(tblDesc));
		this.add(getId_blood_donatoraADesc(tblDesc));
		this.add(getId_checkeraADesc(tblDesc));
		this.add(getBldtr_begtimeADesc(tblDesc));
		this.add(getDrop_speedADesc(tblDesc));
		this.add(getAfter_speedADesc(tblDesc));
		this.add(getId_adver_reactADesc(tblDesc));
		this.add(getSd_adver_reactADesc(tblDesc));
		this.add(getBldtr_endtimeADesc(tblDesc));
		this.add(getId_adver_reactaADesc(tblDesc));
		this.add(getSd_adver_reactaADesc(tblDesc));
		this.add(getId_pt_effectADesc(tblDesc));
		this.add(getSd_pt_effectADesc(tblDesc));
		this.add(getId_evalua_bldtrsADesc(tblDesc));
		this.add(getSd_evalua_bldtrsADesc(tblDesc));
		this.add(getId_blood_donatorbADesc(tblDesc));
		this.add(getId_checkerbADesc(tblDesc));
		this.add(getBlbag_retimeADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_signADesc(tblDesc));
		this.add(getName_bloodcolleADesc(tblDesc));
		this.add(getName_bloodaboADesc(tblDesc));
		this.add(getName_bloodrhADesc(tblDesc));
		this.add(getName_bloodpraboADesc(tblDesc));
		this.add(getName_bloodprrhADesc(tblDesc));
		this.add(getName_input_pathADesc(tblDesc));
		this.add(getName_input_modeADesc(tblDesc));
		this.add(getName_sign_ststusADesc(tblDesc));
		this.add(getName_check_caseADesc(tblDesc));
		this.add(getName_bloodaboaADesc(tblDesc));
		this.add(getName_bloodrhaADesc(tblDesc));
		this.add(getName_bloodpraboaADesc(tblDesc));
		this.add(getName_bloodprrhaADesc(tblDesc));
		this.add(getName_bloodpr_typeADesc(tblDesc));
		this.add(getName_cross_matchADesc(tblDesc));
		this.add(getName_blbag_facADesc(tblDesc));
		this.add(getName_blood_donatorADesc(tblDesc));
		this.add(getName_checkerADesc(tblDesc));
		this.add(getName_check_casesADesc(tblDesc));
		this.add(getName_bloodpr_typesADesc(tblDesc));
		this.add(getName_bloodabobADesc(tblDesc));
		this.add(getName_bloodrhbADesc(tblDesc));
		this.add(getName_blood_donatoraADesc(tblDesc));
		this.add(getName_checkeraADesc(tblDesc));
		this.add(getName_adver_reactADesc(tblDesc));
		this.add(getName_adver_reactaADesc(tblDesc));
		this.add(getName_pt_effectADesc(tblDesc));
		this.add(getName_evalua_bldtrsADesc(tblDesc));
		this.add(getName_blood_donatorbADesc(tblDesc));
		this.add(getName_checkerbADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_transfusrecCDesc(tblDesc));
		tblDesc.add(getId_transfusrecCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_dep_phyCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getId_signCDesc(tblDesc));
		tblDesc.add(getDt_createCDesc(tblDesc));
		tblDesc.add(getBlcoll_dateCDesc(tblDesc));
		tblDesc.add(getBlcoll_timeCDesc(tblDesc));
		tblDesc.add(getBloodcolleCDesc(tblDesc));
		tblDesc.add(getId_bloodaboCDesc(tblDesc));
		tblDesc.add(getSd_bloodaboCDesc(tblDesc));
		tblDesc.add(getId_bloodrhCDesc(tblDesc));
		tblDesc.add(getSd_bloodrhCDesc(tblDesc));
		tblDesc.add(getId_bloodpraboCDesc(tblDesc));
		tblDesc.add(getSd_bloodpraboCDesc(tblDesc));
		tblDesc.add(getId_bloodprrhCDesc(tblDesc));
		tblDesc.add(getSd_bloodprrhCDesc(tblDesc));
		tblDesc.add(getNv_tCDesc(tblDesc));
		tblDesc.add(getId_input_pathCDesc(tblDesc));
		tblDesc.add(getSd_input_pathCDesc(tblDesc));
		tblDesc.add(getId_input_modeCDesc(tblDesc));
		tblDesc.add(getSd_input_modeCDesc(tblDesc));
		tblDesc.add(getId_sign_ststusCDesc(tblDesc));
		tblDesc.add(getSd_sign_ststusCDesc(tblDesc));
		tblDesc.add(getId_check_caseCDesc(tblDesc));
		tblDesc.add(getSd_check_caseCDesc(tblDesc));
		tblDesc.add(getId_bloodaboaCDesc(tblDesc));
		tblDesc.add(getSd_bloodaboaCDesc(tblDesc));
		tblDesc.add(getId_bloodrhaCDesc(tblDesc));
		tblDesc.add(getSd_bloodrhaCDesc(tblDesc));
		tblDesc.add(getId_bloodpraboaCDesc(tblDesc));
		tblDesc.add(getSd_bloodpraboaCDesc(tblDesc));
		tblDesc.add(getId_bloodprrhaCDesc(tblDesc));
		tblDesc.add(getSd_bloodprrhaCDesc(tblDesc));
		tblDesc.add(getId_bloodpr_typeCDesc(tblDesc));
		tblDesc.add(getSd_bloodpr_typeCDesc(tblDesc));
		tblDesc.add(getBloodpr_numCDesc(tblDesc));
		tblDesc.add(getId_cross_matchCDesc(tblDesc));
		tblDesc.add(getSd_cross_matchCDesc(tblDesc));
		tblDesc.add(getId_blbag_facCDesc(tblDesc));
		tblDesc.add(getSd_blbag_facCDesc(tblDesc));
		tblDesc.add(getBlbag_barcodeCDesc(tblDesc));
		tblDesc.add(getBlood_validityCDesc(tblDesc));
		tblDesc.add(getId_blood_donatorCDesc(tblDesc));
		tblDesc.add(getId_checkerCDesc(tblDesc));
		tblDesc.add(getId_check_casesCDesc(tblDesc));
		tblDesc.add(getSd_check_casesCDesc(tblDesc));
		tblDesc.add(getId_bloodpr_typesCDesc(tblDesc));
		tblDesc.add(getSd_bloodpr_typesCDesc(tblDesc));
		tblDesc.add(getId_bloodabobCDesc(tblDesc));
		tblDesc.add(getSd_bloodabobCDesc(tblDesc));
		tblDesc.add(getId_bloodrhbCDesc(tblDesc));
		tblDesc.add(getSd_bloodrhbCDesc(tblDesc));
		tblDesc.add(getId_blood_donatoraCDesc(tblDesc));
		tblDesc.add(getId_checkeraCDesc(tblDesc));
		tblDesc.add(getBldtr_begtimeCDesc(tblDesc));
		tblDesc.add(getDrop_speedCDesc(tblDesc));
		tblDesc.add(getAfter_speedCDesc(tblDesc));
		tblDesc.add(getId_adver_reactCDesc(tblDesc));
		tblDesc.add(getSd_adver_reactCDesc(tblDesc));
		tblDesc.add(getBldtr_endtimeCDesc(tblDesc));
		tblDesc.add(getId_adver_reactaCDesc(tblDesc));
		tblDesc.add(getSd_adver_reactaCDesc(tblDesc));
		tblDesc.add(getId_pt_effectCDesc(tblDesc));
		tblDesc.add(getSd_pt_effectCDesc(tblDesc));
		tblDesc.add(getId_evalua_bldtrsCDesc(tblDesc));
		tblDesc.add(getSd_evalua_bldtrsCDesc(tblDesc));
		tblDesc.add(getId_blood_donatorbCDesc(tblDesc));
		tblDesc.add(getId_checkerbCDesc(tblDesc));
		tblDesc.add(getBlbag_retimeCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 输血安全护理主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_transfusrecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_transfusrec",  getId_transfusrecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血安全护理主键");
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
	 * 录入人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign",  getId_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 录入日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_createADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_create",  getDt_createCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("录入日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlcoll_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blcoll_date",  getBlcoll_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("取血日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlcoll_timeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blcoll_time",  getBlcoll_timeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FTime);
		attrDesc.setLabel("取血时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBloodcolleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bloodcolle",  getBloodcolleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取血者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型ABO属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodaboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodabo",  getId_bloodaboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型ABO编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodaboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodabo",  getSd_bloodaboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型RH属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodrhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodrh",  getId_bloodrhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型RH编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodrhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodrh",  getSd_bloodrhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型ABO属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodpraboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodprabo",  getId_bloodpraboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型ABO");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血制品血型ABO编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodpraboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodprabo",  getSd_bloodpraboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型ABO编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型RH属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodprrhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodprrh",  getId_bloodprrhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型RH");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血制品血型RH编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodprrhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodprrh",  getSd_bloodprrhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型RH编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血前体温属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNv_tADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nv_t",  getNv_tCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("输血前体温");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输入途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_input_pathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_input_path",  getId_input_pathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输入途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输入途径编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_input_pathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_input_path",  getSd_input_pathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输入途径编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_input_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_input_mode",  getId_input_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_input_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_input_mode",  getSd_input_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 知情同意书签署情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sign_ststusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign_ststus",  getId_sign_ststusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("知情同意书签署情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 知情同意书签署情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sign_ststusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sign_ststus",  getSd_sign_ststusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("知情同意书签署情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者信息核对情况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_check_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_check_case",  getId_check_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息核对情况");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者信息核对情况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_check_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_check_case",  getSd_check_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息核对情况编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型ABO1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodaboaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodaboa",  getId_bloodaboaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型ABO1编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodaboaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodaboa",  getSd_bloodaboaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO1编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型RH1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodrhaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodrha",  getId_bloodrhaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型RH1编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodrhaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodrha",  getSd_bloodrhaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH1编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型ABO1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodpraboaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodpraboa",  getId_bloodpraboaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型ABO1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血制品血型ABO1编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodpraboaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodpraboa",  getSd_bloodpraboaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型ABO1编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型RH1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodprrhaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodprrha",  getId_bloodprrhaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型RH1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血制品血型RH1编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodprrhaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodprrha",  getSd_bloodprrhaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型RH1编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输注血制品的种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodpr_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodpr_type",  getId_bloodpr_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输注血制品的种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输注血制品的种类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodpr_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodpr_type",  getSd_bloodpr_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输注血制品的种类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输注血制品的数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBloodpr_numADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bloodpr_num",  getBloodpr_numCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("输注血制品的数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交叉配血的结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_cross_matchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_cross_match",  getId_cross_matchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血的结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 交叉配血的结果编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cross_matchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cross_match",  getSd_cross_matchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血的结果编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋外观属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blbag_facADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blbag_fac",  getId_blbag_facCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋外观");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血袋外观编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_blbag_facADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_blbag_fac",  getSd_blbag_facCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋外观编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋条形码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlbag_barcodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blbag_barcode",  getBlbag_barcodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋条形码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血液有效期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlood_validityADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blood_validity",  getBlood_validityCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("血液有效期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血者输血前属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_donatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_donator",  getId_blood_donatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血者输血前");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 核对者输血前属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_checkerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_checker",  getId_checkerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核对者输血前");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者信息核对情况1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_check_casesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_check_cases",  getId_check_casesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息核对情况1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者信息核对情况1编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_check_casesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_check_cases",  getSd_check_casesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息核对情况1编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输注血制品的种类1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodpr_typesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodpr_types",  getId_bloodpr_typesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输注血制品的种类1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输注血制品的种类1编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodpr_typesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodpr_types",  getSd_bloodpr_typesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输注血制品的种类1编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型ABO2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodabobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodabob",  getId_bloodabobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型ABO2编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodabobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodabob",  getSd_bloodabobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO2编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型RH2属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bloodrhbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bloodrhb",  getId_bloodrhbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH2");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者血型RH2编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bloodrhbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bloodrhb",  getSd_bloodrhbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH2编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血者床旁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_donatoraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_donatora",  getId_blood_donatoraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血者床旁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 核对者床旁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_checkeraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_checkera",  getId_checkeraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核对者床旁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBldtr_begtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bldtr_begtime",  getBldtr_begtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("输血开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血过程前15分滴速属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrop_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drop_speed",  getDrop_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("输血过程前15分滴速");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血过程后15分滴速属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAfter_speedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("After_speed",  getAfter_speedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("输血过程后15分滴速");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血过程有无不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_adver_reactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_adver_react",  getId_adver_reactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血过程有无不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血过程有无不良反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_adver_reactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_adver_react",  getSd_adver_reactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血过程有无不良反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBldtr_endtimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Bldtr_endtime",  getBldtr_endtimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("输血结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血后有无不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_adver_reactaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_adver_reacta",  getId_adver_reactaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后有无不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血后有无不良反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_adver_reactaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_adver_reacta",  getSd_adver_reactaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后有无不良反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血后不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_pt_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_pt_effect",  getId_pt_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血后不良反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pt_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pt_effect",  getSd_pt_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后不良反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血后穿刺部位评估属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_evalua_bldtrsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_evalua_bldtrs",  getId_evalua_bldtrsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后穿刺部位评估");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 输血后穿刺部位评估编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_evalua_bldtrsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_evalua_bldtrs",  getSd_evalua_bldtrsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后穿刺部位评估编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血者输血后属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_blood_donatorbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_blood_donatorb",  getId_blood_donatorbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血者输血后");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 核对者输血后属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_checkerbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_checkerb",  getId_checkerbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核对者输血后");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 血袋送回血库时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getBlbag_retimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Blbag_retime",  getBlbag_retimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("血袋送回血库时间");
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
	 * 录入人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign",  getName_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("录入人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b4","id_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取血者签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodcolleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodcolle",  getName_bloodcolleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取血者签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","bloodcolle=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型ABO属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodaboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodabo",  getName_bloodaboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_bloodabo=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型RH属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodrhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodrh",  getName_bloodrhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_bloodrh=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型ABO属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodpraboADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodprabo",  getName_bloodpraboCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型ABO");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_bloodprabo=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型RH属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodprrhADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodprrh",  getName_bloodprrhCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型RH");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_bloodprrh=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输入途径属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_input_pathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_input_path",  getName_input_pathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输入途径");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_input_path=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_input_modeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_input_mode",  getName_input_modeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_input_mode=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 知情同意书签署属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_sign_ststusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_sign_ststus",  getName_sign_ststusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("知情同意书签署");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_sign_ststus=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者信息核对属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_check_caseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_check_case",  getName_check_caseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息核对");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_check_case=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型ABO属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodaboaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodaboa",  getName_bloodaboaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_bloodaboa=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型RH1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodrhaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodrha",  getName_bloodrhaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_bloodrha=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型ABO1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodpraboaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodpraboa",  getName_bloodpraboaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型ABO1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_bloodpraboa=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血制品血型RH1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodprrhaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodprrha",  getName_bloodprrhaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血制品血型RH1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_bloodprrha=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输注血制品的种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodpr_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodpr_type",  getName_bloodpr_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输注血制品的种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_bloodpr_type=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 交叉配血结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cross_matchADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cross_match",  getName_cross_matchCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("交叉配血结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_cross_match=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 血袋外观属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blbag_facADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blbag_fac",  getName_blbag_facCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("血袋外观");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b20","id_blbag_fac=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血者输血前属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_donatorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_donator",  getName_blood_donatorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血者输血前");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_blood_donator=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核对者输血前属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_checkerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_checker",  getName_checkerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核对者输血前");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b22","id_checker=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者信息核对1属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_check_casesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_check_cases",  getName_check_casesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者信息核对1");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b23","id_check_cases=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血制品种类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodpr_typesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodpr_types",  getName_bloodpr_typesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血制品种类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b24","id_bloodpr_types=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型ABO属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodabobADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodabob",  getName_bloodabobCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型ABO");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b25","id_bloodabob=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者血型RH属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_bloodrhbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_bloodrhb",  getName_bloodrhbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者血型RH");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b26","id_bloodrhb=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血者床旁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_donatoraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_donatora",  getName_blood_donatoraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血者床旁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b27","id_blood_donatora=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核对者床旁属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_checkeraADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_checkera",  getName_checkeraCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核对者床旁");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b28","id_checkera=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血过程有无不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_adver_reactADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_adver_react",  getName_adver_reactCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血过程有无不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b29","id_adver_react=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血后有无不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_adver_reactaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_adver_reacta",  getName_adver_reactaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后有无不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b30","id_adver_reacta=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血后不良反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pt_effectADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pt_effect",  getName_pt_effectCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后不良反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b31","id_pt_effect=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血后穿刺部位评估属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_evalua_bldtrsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_evalua_bldtrs",  getName_evalua_bldtrsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血后穿刺部位评估");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b32","id_evalua_bldtrs=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 输血者输血后属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_blood_donatorbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_blood_donatorb",  getName_blood_donatorbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("输血者输血后");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b33","id_blood_donatorb=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 核对者输血后属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_checkerbADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_checkerb",  getName_checkerbCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("核对者输血后");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b34","id_checkerb=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取输血安全护理主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_transfusrecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_transfusrec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血安全护理主键"); 
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
	 * 获取录入人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入人员"); 
		return column;
	}
	/**
	 * 获取录入日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_createCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_create");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("录入日期"); 
		return column;
	}
	/**
	 * 获取取血日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlcoll_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blcoll_date");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取血日期"); 
		return column;
	}
	/**
	 * 获取取血时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlcoll_timeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blcoll_time");
		column.setLength(8);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取血时间"); 
		return column;
	}
	/**
	 * 获取取血者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBloodcolleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bloodcolle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取血者签名"); 
		return column;
	}
	/**
	 * 获取患者血型ABO表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodaboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodabo");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO"); 
		return column;
	}
	/**
	 * 获取患者血型ABO编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodaboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodabo");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO编码"); 
		return column;
	}
	/**
	 * 获取患者血型RH表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodrhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodrh");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH"); 
		return column;
	}
	/**
	 * 获取患者血型RH编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodrhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodrh");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH编码"); 
		return column;
	}
	/**
	 * 获取血制品血型ABO表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodpraboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodprabo");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型ABO"); 
		return column;
	}
	/**
	 * 获取血制品血型ABO编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodpraboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodprabo");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型ABO编码"); 
		return column;
	}
	/**
	 * 获取血制品血型RH表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodprrhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodprrh");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型RH"); 
		return column;
	}
	/**
	 * 获取血制品血型RH编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodprrhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodprrh");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型RH编码"); 
		return column;
	}
	/**
	 * 获取输血前体温表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNv_tCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nv_t");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("输血前体温"); 
		return column;
	}
	/**
	 * 获取输入途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_input_pathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_input_path");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输入途径"); 
		return column;
	}
	/**
	 * 获取输入途径编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_input_pathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_input_path");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输入途径编码"); 
		return column;
	}
	/**
	 * 获取输血方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_input_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_input_mode");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血方式"); 
		return column;
	}
	/**
	 * 获取输血方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_input_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_input_mode");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血方式编码"); 
		return column;
	}
	/**
	 * 获取知情同意书签署情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sign_ststusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign_ststus");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("知情同意书签署情况"); 
		return column;
	}
	/**
	 * 获取知情同意书签署情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sign_ststusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sign_ststus");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("知情同意书签署情况编码"); 
		return column;
	}
	/**
	 * 获取患者信息核对情况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_check_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_check_case");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息核对情况"); 
		return column;
	}
	/**
	 * 获取患者信息核对情况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_check_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_check_case");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息核对情况编码"); 
		return column;
	}
	/**
	 * 获取患者血型ABO1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodaboaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodaboa");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO1"); 
		return column;
	}
	/**
	 * 获取患者血型ABO1编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodaboaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodaboa");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO1编码"); 
		return column;
	}
	/**
	 * 获取患者血型RH1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodrhaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodrha");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH1"); 
		return column;
	}
	/**
	 * 获取患者血型RH1编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodrhaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodrha");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH1编码"); 
		return column;
	}
	/**
	 * 获取血制品血型ABO1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodpraboaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodpraboa");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型ABO1"); 
		return column;
	}
	/**
	 * 获取血制品血型ABO1编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodpraboaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodpraboa");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型ABO1编码"); 
		return column;
	}
	/**
	 * 获取血制品血型RH1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodprrhaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodprrha");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型RH1"); 
		return column;
	}
	/**
	 * 获取血制品血型RH1编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodprrhaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodprrha");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型RH1编码"); 
		return column;
	}
	/**
	 * 获取输注血制品的种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodpr_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodpr_type");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输注血制品的种类"); 
		return column;
	}
	/**
	 * 获取输注血制品的种类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodpr_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodpr_type");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输注血制品的种类编码"); 
		return column;
	}
	/**
	 * 获取输注血制品的数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBloodpr_numCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bloodpr_num");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("输注血制品的数量"); 
		return column;
	}
	/**
	 * 获取交叉配血的结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_cross_matchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_cross_match");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血的结果"); 
		return column;
	}
	/**
	 * 获取交叉配血的结果编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cross_matchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cross_match");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血的结果编码"); 
		return column;
	}
	/**
	 * 获取血袋外观表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blbag_facCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blbag_fac");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋外观"); 
		return column;
	}
	/**
	 * 获取血袋外观编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_blbag_facCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_blbag_fac");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋外观编码"); 
		return column;
	}
	/**
	 * 获取血袋条形码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlbag_barcodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blbag_barcode");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋条形码"); 
		return column;
	}
	/**
	 * 获取血液有效期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlood_validityCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blood_validity");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("血液有效期"); 
		return column;
	}
	/**
	 * 获取输血者输血前表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_donatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_donator");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血者输血前"); 
		return column;
	}
	/**
	 * 获取核对者输血前表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_checkerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_checker");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核对者输血前"); 
		return column;
	}
	/**
	 * 获取患者信息核对情况1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_check_casesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_check_cases");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息核对情况1"); 
		return column;
	}
	/**
	 * 获取患者信息核对情况1编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_check_casesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_check_cases");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息核对情况1编码"); 
		return column;
	}
	/**
	 * 获取输注血制品的种类1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodpr_typesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodpr_types");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输注血制品的种类1"); 
		return column;
	}
	/**
	 * 获取输注血制品的种类1编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodpr_typesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodpr_types");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输注血制品的种类1编码"); 
		return column;
	}
	/**
	 * 获取患者血型ABO2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodabobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodabob");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO2"); 
		return column;
	}
	/**
	 * 获取患者血型ABO2编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodabobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodabob");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO2编码"); 
		return column;
	}
	/**
	 * 获取患者血型RH2表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bloodrhbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bloodrhb");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH2"); 
		return column;
	}
	/**
	 * 获取患者血型RH2编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bloodrhbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bloodrhb");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH2编码"); 
		return column;
	}
	/**
	 * 获取输血者床旁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_donatoraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_donatora");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血者床旁"); 
		return column;
	}
	/**
	 * 获取核对者床旁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_checkeraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_checkera");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核对者床旁"); 
		return column;
	}
	/**
	 * 获取输血开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBldtr_begtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bldtr_begtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输血开始时间"); 
		return column;
	}
	/**
	 * 获取输血过程前15分滴速表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDrop_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drop_speed");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("输血过程前15分滴速"); 
		return column;
	}
	/**
	 * 获取输血过程后15分滴速表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAfter_speedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"After_speed");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("输血过程后15分滴速"); 
		return column;
	}
	/**
	 * 获取输血过程有无不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_adver_reactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_adver_react");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血过程有无不良反应"); 
		return column;
	}
	/**
	 * 获取输血过程有无不良反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_adver_reactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_adver_react");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血过程有无不良反应编码"); 
		return column;
	}
	/**
	 * 获取输血结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBldtr_endtimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Bldtr_endtime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("输血结束时间"); 
		return column;
	}
	/**
	 * 获取输血后有无不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_adver_reactaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_adver_reacta");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后有无不良反应"); 
		return column;
	}
	/**
	 * 获取输血后有无不良反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_adver_reactaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_adver_reacta");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后有无不良反应编码"); 
		return column;
	}
	/**
	 * 获取输血后不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_pt_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pt_effect");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后不良反应"); 
		return column;
	}
	/**
	 * 获取输血后不良反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pt_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pt_effect");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后不良反应编码"); 
		return column;
	}
	/**
	 * 获取输血后穿刺部位评估表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_evalua_bldtrsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_evalua_bldtrs");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后穿刺部位评估"); 
		return column;
	}
	/**
	 * 获取输血后穿刺部位评估编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_evalua_bldtrsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_evalua_bldtrs");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后穿刺部位评估编码"); 
		return column;
	}
	/**
	 * 获取输血者输血后表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_blood_donatorbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_blood_donatorb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血者输血后"); 
		return column;
	}
	/**
	 * 获取核对者输血后表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_checkerbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_checkerb");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核对者输血后"); 
		return column;
	}
	/**
	 * 获取血袋送回血库时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getBlbag_retimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Blbag_retime");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("血袋送回血库时间"); 
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
	 * 获取录入人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("录入人员"); 
		return column;
	}
	/**
	 * 获取取血者签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodcolleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodcolle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取血者签名"); 
		return column;
	}
	/**
	 * 获取患者血型ABO表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodaboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodabo");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO"); 
		return column;
	}
	/**
	 * 获取患者血型RH表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodrhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodrh");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH"); 
		return column;
	}
	/**
	 * 获取血制品血型ABO表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodpraboCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodprabo");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型ABO"); 
		return column;
	}
	/**
	 * 获取血制品血型RH表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodprrhCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodprrh");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型RH"); 
		return column;
	}
	/**
	 * 获取输入途径表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_input_pathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_input_path");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输入途径"); 
		return column;
	}
	/**
	 * 获取输血方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_input_modeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_input_mode");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血方式"); 
		return column;
	}
	/**
	 * 获取知情同意书签署表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_sign_ststusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_sign_ststus");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("知情同意书签署"); 
		return column;
	}
	/**
	 * 获取患者信息核对表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_check_caseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_check_case");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息核对"); 
		return column;
	}
	/**
	 * 获取患者血型ABO表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodaboaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodaboa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO"); 
		return column;
	}
	/**
	 * 获取患者血型RH1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodrhaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodrha");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH1"); 
		return column;
	}
	/**
	 * 获取血制品血型ABO1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodpraboaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodpraboa");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型ABO1"); 
		return column;
	}
	/**
	 * 获取血制品血型RH1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodprrhaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodprrha");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血制品血型RH1"); 
		return column;
	}
	/**
	 * 获取输注血制品的种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodpr_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodpr_type");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输注血制品的种类"); 
		return column;
	}
	/**
	 * 获取交叉配血结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cross_matchCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cross_match");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("交叉配血结果"); 
		return column;
	}
	/**
	 * 获取血袋外观表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blbag_facCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blbag_fac");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("血袋外观"); 
		return column;
	}
	/**
	 * 获取输血者输血前表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_donatorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_donator");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血者输血前"); 
		return column;
	}
	/**
	 * 获取核对者输血前表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_checkerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_checker");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核对者输血前"); 
		return column;
	}
	/**
	 * 获取患者信息核对1表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_check_casesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_check_cases");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者信息核对1"); 
		return column;
	}
	/**
	 * 获取输血制品种类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodpr_typesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodpr_types");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血制品种类"); 
		return column;
	}
	/**
	 * 获取患者血型ABO表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodabobCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodabob");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型ABO"); 
		return column;
	}
	/**
	 * 获取患者血型RH表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bloodrhbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bloodrhb");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者血型RH"); 
		return column;
	}
	/**
	 * 获取输血者床旁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_donatoraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_donatora");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血者床旁"); 
		return column;
	}
	/**
	 * 获取核对者床旁表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_checkeraCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_checkera");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核对者床旁"); 
		return column;
	}
	/**
	 * 获取输血过程有无不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_adver_reactCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_adver_react");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血过程有无不良反应"); 
		return column;
	}
	/**
	 * 获取输血后有无不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_adver_reactaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_adver_reacta");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后有无不良反应"); 
		return column;
	}
	/**
	 * 获取输血后不良反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pt_effectCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pt_effect");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后不良反应"); 
		return column;
	}
	/**
	 * 获取输血后穿刺部位评估表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_evalua_bldtrsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_evalua_bldtrs");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血后穿刺部位评估"); 
		return column;
	}
	/**
	 * 获取输血者输血后表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_blood_donatorbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_blood_donatorb");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("输血者输血后"); 
		return column;
	}
	/**
	 * 获取核对者输血后表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_checkerbCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_checkerb");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("核对者输血后"); 
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
