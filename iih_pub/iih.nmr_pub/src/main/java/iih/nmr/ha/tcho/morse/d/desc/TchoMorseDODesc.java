
package iih.nmr.ha.tcho.morse.d.desc;

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
 * Morse跌倒/坠床风险评估单 DO 元数据信息
 */
public class TchoMorseDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nmr.ha.tcho.morse.d.TchoMorseDO";
	public static final String CLASS_DISPALYNAME = "Morse跌倒/坠床风险评估单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nmr_ha_tcho_morse";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_morse";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public TchoMorseDODesc(){
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
		this.setKeyDesc(getId_morseADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_morseADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getAgeADesc(tblDesc));
		this.add(getId_diagnosisADesc(tblDesc));
		this.add(getName_diagnosisADesc(tblDesc));
		this.add(getName_sexADesc(tblDesc));
		this.add(getId_nurs_measADesc(tblDesc));
		this.add(getSd_nurs_measADesc(tblDesc));
		this.add(getId_treadADesc(tblDesc));
		this.add(getSd_treadADesc(tblDesc));
		this.add(getId_know_statusADesc(tblDesc));
		this.add(getSd_know_statusADesc(tblDesc));
		this.add(getId_enum_fallADesc(tblDesc));
		this.add(getSd_enum_fallADesc(tblDesc));
		this.add(getId_medi_diagADesc(tblDesc));
		this.add(getSd_medi_diagADesc(tblDesc));
		this.add(getId_intr_drip_injeADesc(tblDesc));
		this.add(getSd_intr_drip_injeADesc(tblDesc));
		this.add(getId_walk_auxiADesc(tblDesc));
		this.add(getSd_walk_auxiADesc(tblDesc));
		this.add(getId_drug_reacADesc(tblDesc));
		this.add(getSd_drug_reacADesc(tblDesc));
		this.add(getId_envi_factADesc(tblDesc));
		this.add(getSd_envi_factADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getRemarkADesc(tblDesc));
		this.add(getMorse_scoreADesc(tblDesc));
		this.add(getSc_walk_auxiADesc(tblDesc));
		this.add(getSc_falllADesc(tblDesc));
		this.add(getSc_medi_diagADesc(tblDesc));
		this.add(getSc_intr_drip_injeADesc(tblDesc));
		this.add(getSc_treadADesc(tblDesc));
		this.add(getSc_know_statusADesc(tblDesc));
		this.add(getSc_envi_factADesc(tblDesc));
		this.add(getSc_drug_reacADesc(tblDesc));
		this.add(getReport_dateADesc(tblDesc));
		this.add(getId_sign_nurseADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getMeasurenameADesc(tblDesc));
		this.add(getTreadnameADesc(tblDesc));
		this.add(getKnownameADesc(tblDesc));
		this.add(getFallnameADesc(tblDesc));
		this.add(getMedinameADesc(tblDesc));
		this.add(getDripnameADesc(tblDesc));
		this.add(getWalknameADesc(tblDesc));
		this.add(getDrugnameADesc(tblDesc));
		this.add(getEnvinameADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_morseCDesc(tblDesc));
		tblDesc.add(getId_morseCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getName_dep_nurCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getAgeCDesc(tblDesc));
		tblDesc.add(getId_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_diagnosisCDesc(tblDesc));
		tblDesc.add(getName_sexCDesc(tblDesc));
		tblDesc.add(getId_nurs_measCDesc(tblDesc));
		tblDesc.add(getSd_nurs_measCDesc(tblDesc));
		tblDesc.add(getId_treadCDesc(tblDesc));
		tblDesc.add(getSd_treadCDesc(tblDesc));
		tblDesc.add(getId_know_statusCDesc(tblDesc));
		tblDesc.add(getSd_know_statusCDesc(tblDesc));
		tblDesc.add(getId_enum_fallCDesc(tblDesc));
		tblDesc.add(getSd_enum_fallCDesc(tblDesc));
		tblDesc.add(getId_medi_diagCDesc(tblDesc));
		tblDesc.add(getSd_medi_diagCDesc(tblDesc));
		tblDesc.add(getId_intr_drip_injeCDesc(tblDesc));
		tblDesc.add(getSd_intr_drip_injeCDesc(tblDesc));
		tblDesc.add(getId_walk_auxiCDesc(tblDesc));
		tblDesc.add(getSd_walk_auxiCDesc(tblDesc));
		tblDesc.add(getId_drug_reacCDesc(tblDesc));
		tblDesc.add(getSd_drug_reacCDesc(tblDesc));
		tblDesc.add(getId_envi_factCDesc(tblDesc));
		tblDesc.add(getSd_envi_factCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getRemarkCDesc(tblDesc));
		tblDesc.add(getMorse_scoreCDesc(tblDesc));
		tblDesc.add(getSc_walk_auxiCDesc(tblDesc));
		tblDesc.add(getSc_falllCDesc(tblDesc));
		tblDesc.add(getSc_medi_diagCDesc(tblDesc));
		tblDesc.add(getSc_intr_drip_injeCDesc(tblDesc));
		tblDesc.add(getSc_treadCDesc(tblDesc));
		tblDesc.add(getSc_know_statusCDesc(tblDesc));
		tblDesc.add(getSc_envi_factCDesc(tblDesc));
		tblDesc.add(getSc_drug_reacCDesc(tblDesc));
		tblDesc.add(getReport_dateCDesc(tblDesc));
		tblDesc.add(getId_sign_nurseCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * Morse跌倒/坠床风险评估单属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_morseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_morse",  getId_morseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Morse跌倒/坠床风险评估单");
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
	 * 护理措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nurs_measADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nurs_meas",  getId_nurs_measCDesc(tblDesc), this);
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
	private IAttrDesc getSd_nurs_measADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nurs_meas",  getSd_nurs_measCDesc(tblDesc), this);
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
	 * 步态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_treadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tread",  getId_treadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("步态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 步态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_treadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_tread",  getSd_treadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("步态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 认知状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_know_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_know_status",  getId_know_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("认知状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 认知状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_know_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_know_status",  getSd_know_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("认知状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 近3个月跌倒史属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_enum_fallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_enum_fall",  getId_enum_fallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("近3个月跌倒史");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 近3个月跌倒史编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_enum_fallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_enum_fall",  getSd_enum_fallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("近3个月跌倒史编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超过一个医学诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_medi_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_medi_diag",  getId_medi_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超过一个医学诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 超过一个医学诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_medi_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_medi_diag",  getSd_medi_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超过一个医学诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉输液中/静脉留置针属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_intr_drip_injeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_intr_drip_inje",  getId_intr_drip_injeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉输液中/静脉留置针");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 静脉输液中/静脉留置针编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_intr_drip_injeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_intr_drip_inje",  getSd_intr_drip_injeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("静脉输液中/静脉留置针编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行走辅助属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_walk_auxiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_walk_auxi",  getId_walk_auxiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行走辅助");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 行走辅助编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_walk_auxiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_walk_auxi",  getSd_walk_auxiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("行走辅助编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用降压药、镇定药等特殊药物或麻醉反应属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_drug_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_drug_reac",  getId_drug_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用降压药、镇定药等特殊药物或麻醉反应");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 使用降压药、镇定药等特殊药物或麻醉反应编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_drug_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_drug_reac",  getSd_drug_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("使用降压药、镇定药等特殊药物或麻醉反应编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 环境因素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_envi_factADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_envi_fact",  getId_envi_factCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("环境因素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 环境因素编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_envi_factADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_envi_fact",  getSd_envi_factCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("环境因素编码");
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
	 * Morse评估单备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRemarkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Remark",  getRemarkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("Morse评估单备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * Morse评估单填总分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMorse_scoreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Morse_score",  getMorse_scoreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("Morse评估单填总分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 行走辅助评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_walk_auxiADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_walk_auxi",  getSc_walk_auxiCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("行走辅助评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 跌倒史（近三个月有发生）评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_falllADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_falll",  getSc_falllCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("跌倒史（近三个月有发生）评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超过一个医学诊断评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_medi_diagADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_medi_diag",  getSc_medi_diagCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("超过一个医学诊断评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 静脉输液中、使用静脉留置针评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_intr_drip_injeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_intr_drip_inje",  getSc_intr_drip_injeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("静脉输液中、使用静脉留置针评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 步态评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_treadADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_tread",  getSc_treadCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("步态评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 认知状态评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_know_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_know_status",  getSc_know_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("认知状态评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 环境因素评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_envi_factADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_envi_fact",  getSc_envi_factCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("环境因素评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 使用药物评分属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSc_drug_reacADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sc_drug_reac",  getSc_drug_reacCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("使用药物评分");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 报告日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReport_dateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Report_date",  getReport_dateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("报告日期");
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
	private IAttrDesc getId_sign_nurseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sign_nurse",  getId_sign_nurseCDesc(tblDesc), this);
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
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMeasurenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Measurename",  getMeasurenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_nurs_meas=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTreadnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Treadname",  getTreadnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_tread=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getKnownameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Knowname",  getKnownameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_know_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFallnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fallname",  getFallnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_enum_fall=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMedinameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mediname",  getMedinameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_medi_diag=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDripnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dripname",  getDripnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b12","id_intr_drip_inje=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWalknameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Walkname",  getWalknameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b13","id_walk_auxi=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDrugnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Drugname",  getDrugnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_drug_reac=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEnvinameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Enviname",  getEnvinameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b15","id_envi_fact=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b16","id_sign_nurse=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取Morse跌倒/坠床风险评估单表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_morseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_morse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Morse跌倒/坠床风险评估单"); 
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
	 * 获取护理措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nurs_measCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nurs_meas");
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
	private IColumnDesc getSd_nurs_measCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nurs_meas");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理措施编码"); 
		return column;
	}
	/**
	 * 获取步态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_treadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tread");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("步态"); 
		return column;
	}
	/**
	 * 获取步态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_treadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_tread");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("步态编码"); 
		return column;
	}
	/**
	 * 获取认知状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_know_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_know_status");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("认知状态"); 
		return column;
	}
	/**
	 * 获取认知状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_know_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_know_status");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("认知状态编码"); 
		return column;
	}
	/**
	 * 获取近3个月跌倒史表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_enum_fallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_enum_fall");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("近3个月跌倒史"); 
		return column;
	}
	/**
	 * 获取近3个月跌倒史编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_enum_fallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_enum_fall");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("近3个月跌倒史编码"); 
		return column;
	}
	/**
	 * 获取超过一个医学诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_medi_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_medi_diag");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超过一个医学诊断"); 
		return column;
	}
	/**
	 * 获取超过一个医学诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_medi_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_medi_diag");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超过一个医学诊断编码"); 
		return column;
	}
	/**
	 * 获取静脉输液中/静脉留置针表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_intr_drip_injeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_intr_drip_inje");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉输液中/静脉留置针"); 
		return column;
	}
	/**
	 * 获取静脉输液中/静脉留置针编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_intr_drip_injeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_intr_drip_inje");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("静脉输液中/静脉留置针编码"); 
		return column;
	}
	/**
	 * 获取行走辅助表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_walk_auxiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_walk_auxi");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行走辅助"); 
		return column;
	}
	/**
	 * 获取行走辅助编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_walk_auxiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_walk_auxi");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("行走辅助编码"); 
		return column;
	}
	/**
	 * 获取使用降压药、镇定药等特殊药物或麻醉反应表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_drug_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_drug_reac");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用降压药、镇定药等特殊药物或麻醉反应"); 
		return column;
	}
	/**
	 * 获取使用降压药、镇定药等特殊药物或麻醉反应编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_drug_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_drug_reac");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("使用降压药、镇定药等特殊药物或麻醉反应编码"); 
		return column;
	}
	/**
	 * 获取环境因素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_envi_factCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_envi_fact");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("环境因素"); 
		return column;
	}
	/**
	 * 获取环境因素编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_envi_factCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_envi_fact");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("环境因素编码"); 
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
	 * 获取Morse评估单备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRemarkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Remark");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("Morse评估单备注"); 
		return column;
	}
	/**
	 * 获取Morse评估单填总分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMorse_scoreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Morse_score");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("Morse评估单填总分"); 
		return column;
	}
	/**
	 * 获取行走辅助评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_walk_auxiCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_walk_auxi");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("行走辅助评分"); 
		return column;
	}
	/**
	 * 获取跌倒史（近三个月有发生）评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_falllCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_falll");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("跌倒史（近三个月有发生）评分"); 
		return column;
	}
	/**
	 * 获取超过一个医学诊断评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_medi_diagCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_medi_diag");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("超过一个医学诊断评分"); 
		return column;
	}
	/**
	 * 获取静脉输液中、使用静脉留置针评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_intr_drip_injeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_intr_drip_inje");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("静脉输液中、使用静脉留置针评分"); 
		return column;
	}
	/**
	 * 获取步态评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_treadCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_tread");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("步态评分"); 
		return column;
	}
	/**
	 * 获取认知状态评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_know_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_know_status");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("认知状态评分"); 
		return column;
	}
	/**
	 * 获取环境因素评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_envi_factCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_envi_fact");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("环境因素评分"); 
		return column;
	}
	/**
	 * 获取使用药物评分表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSc_drug_reacCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sc_drug_reac");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("使用药物评分"); 
		return column;
	}
	/**
	 * 获取报告日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReport_dateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Report_date");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("报告日期"); 
		return column;
	}
	/**
	 * 获取护士签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sign_nurseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sign_nurse");
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
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMeasurenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Measurename");
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
	private IColumnDesc getTreadnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Treadname");
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
	private IColumnDesc getKnownameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Knowname");
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
	private IColumnDesc getFallnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fallname");
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
	private IColumnDesc getMedinameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mediname");
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
	private IColumnDesc getDripnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dripname");
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
	private IColumnDesc getWalknameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Walkname");
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
	private IColumnDesc getDrugnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Drugname");
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
	private IColumnDesc getEnvinameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Enviname");
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
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
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
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
	}
	
}
