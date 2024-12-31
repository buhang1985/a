
package iih.en.pv.inpatient.d.desc;

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
 * 住院属性 DO 元数据信息
 */
public class InpatientDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.pv.inpatient.d.InpatientDO";
	public static final String CLASS_DISPALYNAME = "住院属性";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_ent_ip";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_inpatient";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public InpatientDODesc(){
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
		this.setKeyDesc(getId_inpatientADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_inpatientADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getCode_amr_ipADesc(tblDesc));
		this.add(getSd_statusADesc(tblDesc));
		this.add(getId_dep_phyadmADesc(tblDesc));
		this.add(getId_dep_nuradmADesc(tblDesc));
		this.add(getId_bedADesc(tblDesc));
		this.add(getName_bedADesc(tblDesc));
		this.add(getFg_surgADesc(tblDesc));
		this.add(getId_level_nurADesc(tblDesc));
		this.add(getSd_level_nurADesc(tblDesc));
		this.add(getId_level_diseADesc(tblDesc));
		this.add(getSd_level_diseADesc(tblDesc));
		this.add(getId_level_nutrADesc(tblDesc));
		this.add(getSd_level_nutrADesc(tblDesc));
		this.add(getFg_newbornADesc(tblDesc));
		this.add(getNum_newbornADesc(tblDesc));
		this.add(getId_outcomesADesc(tblDesc));
		this.add(getSd_outcomesADesc(tblDesc));
		this.add(getId_referalsrcADesc(tblDesc));
		this.add(getSd_referalsrcADesc(tblDesc));
		this.add(getSd_level_diseadmADesc(tblDesc));
		this.add(getId_level_diseadmADesc(tblDesc));
		this.add(getId_patcontADesc(tblDesc));
		this.add(getCont_nameADesc(tblDesc));
		this.add(getCont_telADesc(tblDesc));
		this.add(getId_gowhereADesc(tblDesc));
		this.add(getSd_gowhereADesc(tblDesc));
		this.add(getId_dep_phydiscADesc(tblDesc));
		this.add(getId_dep_nurdiscADesc(tblDesc));
		this.add(getFg_doc_commitADesc(tblDesc));
		this.add(getDt_doc_commitADesc(tblDesc));
		this.add(getId_doc_statusADesc(tblDesc));
		this.add(getSd_doc_statusADesc(tblDesc));
		this.add(getId_diag_opADesc(tblDesc));
		this.add(getDesc_diag_opADesc(tblDesc));
		this.add(getTimes_ipADesc(tblDesc));
		this.add(getDt_deathADesc(tblDesc));
		this.add(getFg_incpADesc(tblDesc));
		this.add(getEu_incpADesc(tblDesc));
		this.add(getId_emp_discADesc(tblDesc));
		this.add(getDt_discADesc(tblDesc));
		this.add(getTimes_printADesc(tblDesc));
		this.add(getSd_pay_mothodADesc(tblDesc));
		this.add(getId_emp_opapplyADesc(tblDesc));
		this.add(getFg_mobappADesc(tblDesc));
		this.add(getTelno_mobappADesc(tblDesc));
		this.add(getFg_vipADesc(tblDesc));
		this.add(getFg_peADesc(tblDesc));
		this.add(getSd_pe_psntpADesc(tblDesc));
		this.add(getName_pe_intrADesc(tblDesc));
		this.add(getFg_blrecallADesc(tblDesc));
		this.add(getId_ip_specADesc(tblDesc));
		this.add(getSd_ip_specADesc(tblDesc));
		this.add(getDt_end_lastADesc(tblDesc));
		this.add(getFg_ippreADesc(tblDesc));
		this.add(getSd_dep_phyADesc(tblDesc));
		this.add(getName_dep_phyADesc(tblDesc));
		this.add(getSd_dep_nurADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_level_nurADesc(tblDesc));
		this.add(getName_level_diseADesc(tblDesc));
		this.add(getName_level_nutrADesc(tblDesc));
		this.add(getName_referalsrcADesc(tblDesc));
		this.add(getName_level_diseadmADesc(tblDesc));
		this.add(getSd_diag_opADesc(tblDesc));
		this.add(getName_diag_opADesc(tblDesc));
		this.add(getName_pay_mothodADesc(tblDesc));
		this.add(getName_emp_phy_opADesc(tblDesc));
		this.add(getCode_emp_phy_opADesc(tblDesc));
		this.add(getName_pe_psntpADesc(tblDesc));
		this.add(getName_ip_specADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_inpatientCDesc(tblDesc));
		tblDesc.add(getId_inpatientCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getCode_amr_ipCDesc(tblDesc));
		tblDesc.add(getSd_statusCDesc(tblDesc));
		tblDesc.add(getId_dep_phyadmCDesc(tblDesc));
		tblDesc.add(getId_dep_nuradmCDesc(tblDesc));
		tblDesc.add(getId_bedCDesc(tblDesc));
		tblDesc.add(getName_bedCDesc(tblDesc));
		tblDesc.add(getFg_surgCDesc(tblDesc));
		tblDesc.add(getId_level_nurCDesc(tblDesc));
		tblDesc.add(getSd_level_nurCDesc(tblDesc));
		tblDesc.add(getId_level_diseCDesc(tblDesc));
		tblDesc.add(getSd_level_diseCDesc(tblDesc));
		tblDesc.add(getId_level_nutrCDesc(tblDesc));
		tblDesc.add(getSd_level_nutrCDesc(tblDesc));
		tblDesc.add(getFg_newbornCDesc(tblDesc));
		tblDesc.add(getNum_newbornCDesc(tblDesc));
		tblDesc.add(getId_outcomesCDesc(tblDesc));
		tblDesc.add(getSd_outcomesCDesc(tblDesc));
		tblDesc.add(getId_referalsrcCDesc(tblDesc));
		tblDesc.add(getSd_referalsrcCDesc(tblDesc));
		tblDesc.add(getSd_level_diseadmCDesc(tblDesc));
		tblDesc.add(getId_level_diseadmCDesc(tblDesc));
		tblDesc.add(getId_patcontCDesc(tblDesc));
		tblDesc.add(getCont_nameCDesc(tblDesc));
		tblDesc.add(getCont_telCDesc(tblDesc));
		tblDesc.add(getId_gowhereCDesc(tblDesc));
		tblDesc.add(getSd_gowhereCDesc(tblDesc));
		tblDesc.add(getId_dep_phydiscCDesc(tblDesc));
		tblDesc.add(getId_dep_nurdiscCDesc(tblDesc));
		tblDesc.add(getFg_doc_commitCDesc(tblDesc));
		tblDesc.add(getDt_doc_commitCDesc(tblDesc));
		tblDesc.add(getId_doc_statusCDesc(tblDesc));
		tblDesc.add(getSd_doc_statusCDesc(tblDesc));
		tblDesc.add(getId_diag_opCDesc(tblDesc));
		tblDesc.add(getDesc_diag_opCDesc(tblDesc));
		tblDesc.add(getTimes_ipCDesc(tblDesc));
		tblDesc.add(getDt_deathCDesc(tblDesc));
		tblDesc.add(getFg_incpCDesc(tblDesc));
		tblDesc.add(getEu_incpCDesc(tblDesc));
		tblDesc.add(getId_emp_discCDesc(tblDesc));
		tblDesc.add(getDt_discCDesc(tblDesc));
		tblDesc.add(getTimes_printCDesc(tblDesc));
		tblDesc.add(getSd_pay_mothodCDesc(tblDesc));
		tblDesc.add(getId_emp_opapplyCDesc(tblDesc));
		tblDesc.add(getFg_mobappCDesc(tblDesc));
		tblDesc.add(getTelno_mobappCDesc(tblDesc));
		tblDesc.add(getFg_vipCDesc(tblDesc));
		tblDesc.add(getFg_peCDesc(tblDesc));
		tblDesc.add(getSd_pe_psntpCDesc(tblDesc));
		tblDesc.add(getName_pe_intrCDesc(tblDesc));
		tblDesc.add(getFg_blrecallCDesc(tblDesc));
		tblDesc.add(getId_ip_specCDesc(tblDesc));
		tblDesc.add(getSd_ip_specCDesc(tblDesc));
		tblDesc.add(getDt_end_lastCDesc(tblDesc));
		tblDesc.add(getFg_ippreCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 住院属性主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_inpatientADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_inpatient",  getId_inpatientCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院属性主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 患者就诊主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者就诊主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 住院档案号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_amr_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_amr_ip",  getCode_amr_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院档案号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status",  getSd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phyadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phyadm",  getId_dep_phyadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nuradmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nuradm",  getId_dep_nuradmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病床属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bed",  getId_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病床");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 是否手术标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_surgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_surg",  getFg_surgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否手术标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_level_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_level_nur",  getId_level_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_nur",  getSd_level_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_level_diseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_level_dise",  getId_level_diseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病情等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_diseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_dise",  getSd_level_diseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 营养等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_level_nutrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_level_nutr",  getId_level_nutrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 营养等级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_nutrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_nutr",  getSd_level_nutrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("营养等级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_newbornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_newborn",  getFg_newbornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("新生儿标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 新生儿数量属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNum_newbornADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Num_newborn",  getNum_newbornCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("新生儿数量");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情转归属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_outcomesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_outcomes",  getId_outcomesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情转归");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病情转归编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_outcomesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_outcomes",  getSd_outcomesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情转归编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 来院方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_referalsrc",  getId_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 来院方式编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_referalsrc",  getSd_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院病情编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_diseadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_diseadm",  getSd_level_diseadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病情编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 入院病情id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_level_diseadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_level_diseadm",  getId_level_diseadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院病情id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主要联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcont",  getId_patcontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主要联系人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主要联系人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCont_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cont_name",  getCont_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主要联系人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 主要联系人电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCont_telADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cont_tel",  getCont_telCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主要联系人电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 离院转归属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_gowhereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_gowhere",  getId_gowhereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离院转归");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 离院转归编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_gowhereADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_gowhere",  getSd_gowhereCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("离院转归编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出院科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phydiscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phydisc",  getId_dep_phydiscCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurdiscADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nurdisc",  getId_dep_nurdiscCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案转归标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_doc_commitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_doc_commit",  getFg_doc_commitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("病案转归标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案转归日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_doc_commitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_doc_commit",  getDt_doc_commitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("病案转归日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病案转归状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_doc_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_doc_status",  getId_doc_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案转归状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 病案转归状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_doc_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_doc_status",  getSd_doc_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病案转归状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊主要诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diag_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diag_op",  getId_diag_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊主要诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊主要诊断描述属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesc_diag_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Desc_diag_op",  getDesc_diag_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊主要诊断描述");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 住院次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_ip",  getTimes_ipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("住院次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 死亡时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_deathADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_death",  getDt_deathCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("死亡时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否在临床路径中属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_incpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_incp",  getFg_incpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否在临床路径中");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 临床路径状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_incpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_incp",  getEu_incpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("临床路径状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院操作人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_discADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_disc",  getId_emp_discCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("出院操作人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 出院操作时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_discADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_disc",  getDt_discCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("出院操作时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 打印次数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimes_printADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Times_print",  getTimes_printCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("打印次数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 付款方式（首页）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pay_mothodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pay_mothod",  getSd_pay_mothodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("付款方式（首页）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 入院医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_opapplyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_opapply",  getId_emp_opapplyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 开通手机app标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_mobappADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_mobapp",  getFg_mobappCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("开通手机app标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手机app电话号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTelno_mobappADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Telno_mobapp",  getTelno_mobappCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("手机app电话号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * VIP标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip",  getFg_vipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("VIP标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_peADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pe",  getFg_peCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("体检标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 体检身份类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_pe_psntpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_pe_psntp",  getSd_pe_psntpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检身份类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 体检介绍人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pe_intrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pe_intr",  getName_pe_intrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("体检介绍人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否是费用召回属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_blrecallADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_blrecall",  getFg_blrecallCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否是费用召回");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 特定类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ip_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ip_spec",  getId_ip_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特定类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 特定类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_ip_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_ip_spec",  getSd_ip_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("特定类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上次踢出院时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_end_lastADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end_last",  getDt_end_lastCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("上次踢出院时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预住院标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_ippreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_ippre",  getFg_ippreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("预住院标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dep_phy",  getSd_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_phyadm=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_phy",  getName_dep_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_phyadm=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_dep_nur",  getSd_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b2","id_dep_nuradm=id_dep","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b2","id_dep_nuradm=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_level_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_level_nur",  getName_level_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_level_nur=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_level_diseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_level_dise",  getName_level_diseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_level_dise=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_level_nutrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_level_nutr",  getName_level_nutrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_level_nutr=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_referalsrc",  getName_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b11","id_referalsrc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称病情等级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_level_diseadmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_level_diseadm",  getName_level_diseadmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称病情等级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_level_diseadm=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_diag_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_diag_op",  getSd_diag_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b15","id_diag_op=id_didef","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_diag_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_diag_op",  getName_diag_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_di_def a0b15","id_diag_op=id_didef","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pay_mothodADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pay_mothod",  getName_pay_mothodCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","sd_pay_mothod=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_phy_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_phy_op",  getName_emp_phy_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_emp_opapply=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_emp_phy_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_emp_phy_op",  getCode_emp_phy_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b20","id_emp_opapply=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_pe_psntpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_pe_psntp",  getName_pe_psntpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","sd_pe_psntp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_ip_specADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_ip_spec",  getName_ip_specCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b21","id_ip_spec=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取住院属性主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_inpatientCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_inpatient");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院属性主键"); 
		return column;
	}
	/**
	 * 获取患者就诊主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者就诊主键"); 
		return column;
	}
	/**
	 * 获取住院档案号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_amr_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_amr_ip");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院档案号"); 
		return column;
	}
	/**
	 * 获取就诊状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊状态"); 
		return column;
	}
	/**
	 * 获取入院科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phyadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phyadm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院科室"); 
		return column;
	}
	/**
	 * 获取入院病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nuradmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nuradm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病区"); 
		return column;
	}
	/**
	 * 获取病床表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病床"); 
		return column;
	}
	/**
	 * 获取床号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_bed");
		column.setLength(100);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床号"); 
		return column;
	}
	/**
	 * 获取是否手术标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_surgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_surg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否手术标志"); 
		return column;
	}
	/**
	 * 获取护理等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_level_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_level_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理等级"); 
		return column;
	}
	/**
	 * 获取护理等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_nur");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理等级编码"); 
		return column;
	}
	/**
	 * 获取病情等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_level_diseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_level_dise");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情等级"); 
		return column;
	}
	/**
	 * 获取病情等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_diseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_dise");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情等级编码"); 
		return column;
	}
	/**
	 * 获取营养等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_level_nutrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_level_nutr");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养等级"); 
		return column;
	}
	/**
	 * 获取营养等级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_nutrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_nutr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("营养等级编码"); 
		return column;
	}
	/**
	 * 获取新生儿标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_newbornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_newborn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("新生儿标志"); 
		return column;
	}
	/**
	 * 获取新生儿数量表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNum_newbornCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Num_newborn");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("新生儿数量"); 
		return column;
	}
	/**
	 * 获取病情转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_outcomesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_outcomes");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情转归"); 
		return column;
	}
	/**
	 * 获取病情转归编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_outcomesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_outcomes");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情转归编码"); 
		return column;
	}
	/**
	 * 获取来院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_referalsrc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式"); 
		return column;
	}
	/**
	 * 获取来院方式编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_referalsrc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式编码"); 
		return column;
	}
	/**
	 * 获取入院病情编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_diseadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_diseadm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病情编码"); 
		return column;
	}
	/**
	 * 获取入院病情id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_level_diseadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_level_diseadm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病情id"); 
		return column;
	}
	/**
	 * 获取主要联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主要联系人"); 
		return column;
	}
	/**
	 * 获取主要联系人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCont_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cont_name");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主要联系人姓名"); 
		return column;
	}
	/**
	 * 获取主要联系人电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCont_telCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cont_tel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主要联系人电话"); 
		return column;
	}
	/**
	 * 获取离院转归表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_gowhereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_gowhere");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离院转归"); 
		return column;
	}
	/**
	 * 获取离院转归编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_gowhereCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_gowhere");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("离院转归编码"); 
		return column;
	}
	/**
	 * 获取出院科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phydiscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phydisc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院科室"); 
		return column;
	}
	/**
	 * 获取出院病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurdiscCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nurdisc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院病区"); 
		return column;
	}
	/**
	 * 获取病案转归标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_doc_commitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_doc_commit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病案转归标志"); 
		return column;
	}
	/**
	 * 获取病案转归日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_doc_commitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_doc_commit");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病案转归日期"); 
		return column;
	}
	/**
	 * 获取病案转归状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_doc_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_doc_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案转归状态"); 
		return column;
	}
	/**
	 * 获取病案转归状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_doc_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_doc_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病案转归状态编码"); 
		return column;
	}
	/**
	 * 获取门诊主要诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diag_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diag_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊主要诊断"); 
		return column;
	}
	/**
	 * 获取门诊主要诊断描述表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesc_diag_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Desc_diag_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊主要诊断描述"); 
		return column;
	}
	/**
	 * 获取住院次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_ip");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("住院次数"); 
		return column;
	}
	/**
	 * 获取死亡时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_deathCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_death");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("死亡时间"); 
		return column;
	}
	/**
	 * 获取是否在临床路径中表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_incpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_incp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否在临床路径中"); 
		return column;
	}
	/**
	 * 获取临床路径状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_incpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_incp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("临床路径状态"); 
		return column;
	}
	/**
	 * 获取出院操作人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_discCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_disc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("出院操作人"); 
		return column;
	}
	/**
	 * 获取出院操作时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_discCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_disc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出院操作时间"); 
		return column;
	}
	/**
	 * 获取打印次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimes_printCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Times_print");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("打印次数"); 
		return column;
	}
	/**
	 * 获取付款方式（首页）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pay_mothodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pay_mothod");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("付款方式（首页）"); 
		return column;
	}
	/**
	 * 获取入院医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_opapplyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_opapply");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院医生"); 
		return column;
	}
	/**
	 * 获取开通手机app标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_mobappCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_mobapp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("开通手机app标识"); 
		return column;
	}
	/**
	 * 获取手机app电话号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTelno_mobappCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Telno_mobapp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("手机app电话号"); 
		return column;
	}
	/**
	 * 获取VIP标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("VIP标志"); 
		return column;
	}
	/**
	 * 获取体检标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_peCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pe");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("体检标志"); 
		return column;
	}
	/**
	 * 获取体检身份类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_pe_psntpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_pe_psntp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检身份类型"); 
		return column;
	}
	/**
	 * 获取体检介绍人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pe_intrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pe_intr");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("体检介绍人"); 
		return column;
	}
	/**
	 * 获取是否是费用召回表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_blrecallCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_blrecall");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否是费用召回"); 
		return column;
	}
	/**
	 * 获取特定类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ip_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ip_spec");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特定类型id"); 
		return column;
	}
	/**
	 * 获取特定类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_ip_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_ip_spec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("特定类型编码"); 
		return column;
	}
	/**
	 * 获取上次踢出院时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_end_lastCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end_last");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上次踢出院时间"); 
		return column;
	}
	/**
	 * 获取预住院标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_ippreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_ippre");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预住院标志"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dep_phy");
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
	private IColumnDesc getName_dep_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_phy");
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
	private IColumnDesc getSd_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_dep_nur");
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
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
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
	private IColumnDesc getName_level_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_level_nur");
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
	private IColumnDesc getName_level_diseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_level_dise");
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
	private IColumnDesc getName_level_nutrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_level_nutr");
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
	private IColumnDesc getName_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_referalsrc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取名称病情等级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_level_diseadmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_level_diseadm");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称病情等级"); 
		return column;
	}
	/**
	 * 获取诊断编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_diag_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_diag_op");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断编码"); 
		return column;
	}
	/**
	 * 获取诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_diag_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_diag_op");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊断名称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pay_mothodCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pay_mothod");
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
	private IColumnDesc getName_emp_phy_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_phy_op");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_emp_phy_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_emp_phy_op");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_pe_psntpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_pe_psntp");
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
	private IColumnDesc getName_ip_specCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_ip_spec");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
	}

	/**
	 * 设置实体审计信息数据映射关系 
	 */
	private void setIAuditInfoFldMap(){
	}
	
	/**
	 * 设置实体默认值
	 */
	private void setDefaultValueMap(){
		defaultValueMap=new HashMap<String, Object>();
		defaultValueMap.put("Times_ip",0);
	}
	
}
