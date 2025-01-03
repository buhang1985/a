
package iih.sc.apt.aptip.d.desc;

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
 * 住院预约 DO 元数据信息
 */
public class AptIpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.sc.apt.aptip.d.AptIpDO";
	public static final String CLASS_DISPALYNAME = "住院预约";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "sc_apt_ip";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aptip";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public AptIpDODesc(){
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
		this.setKeyDesc(getId_aptipADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aptipADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_entipADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_patcaADesc(tblDesc));
		this.add(getId_sex_patADesc(tblDesc));
		this.add(getSd_sex_patADesc(tblDesc));
		this.add(getDt_brith_patADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getCode_hpADesc(tblDesc));
		this.add(getId_dep_opADesc(tblDesc));
		this.add(getName_dep_opADesc(tblDesc));
		this.add(getId_emp_phy_opADesc(tblDesc));
		this.add(getName_emp_phy_opADesc(tblDesc));
		this.add(getId_didef_opADesc(tblDesc));
		this.add(getName_didef_opADesc(tblDesc));
		this.add(getSupplement_diADesc(tblDesc));
		this.add(getId_level_diseADesc(tblDesc));
		this.add(getSd_level_diseADesc(tblDesc));
		this.add(getId_dep_phy_ipADesc(tblDesc));
		this.add(getId_dep_nur_ipADesc(tblDesc));
		this.add(getFg_planADesc(tblDesc));
		this.add(getId_bedtpADesc(tblDesc));
		this.add(getSd_bedtypeADesc(tblDesc));
		this.add(getDt_admit_planADesc(tblDesc));
		this.add(getAmt_depositADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getFg_emgstayADesc(tblDesc));
		this.add(getId_bedADesc(tblDesc));
		this.add(getSd_statusADesc(tblDesc));
		this.add(getDt_validADesc(tblDesc));
		this.add(getLevel_priADesc(tblDesc));
		this.add(getLevel_pri_rsnADesc(tblDesc));
		this.add(getDt_insertADesc(tblDesc));
		this.add(getFg_cancADesc(tblDesc));
		this.add(getId_emp_cancADesc(tblDesc));
		this.add(getDt_cancADesc(tblDesc));
		this.add(getId_emp_apptADesc(tblDesc));
		this.add(getDt_apptADesc(tblDesc));
		this.add(getId_emp_cfmADesc(tblDesc));
		this.add(getDt_cfmADesc(tblDesc));
		this.add(getId_emp_noticeADesc(tblDesc));
		this.add(getName_emp_noticeADesc(tblDesc));
		this.add(getDa_noticeADesc(tblDesc));
		this.add(getRsn_refuseADesc(tblDesc));
		this.add(getFg_manualADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getFg_vipADesc(tblDesc));
		this.add(getSd_referalsrcADesc(tblDesc));
		this.add(getName_cont_phyADesc(tblDesc));
		this.add(getTel_cont_phyADesc(tblDesc));
		this.add(getId_referalsrcADesc(tblDesc));
		this.add(getNote_aptADesc(tblDesc));
		this.add(getSd_walkwithADesc(tblDesc));
		this.add(getId_walkwithADesc(tblDesc));
		this.add(getId_introducerADesc(tblDesc));
		this.add(getId_patcontADesc(tblDesc));
		this.add(getFg_cfmADesc(tblDesc));
		this.add(getFg_ippreADesc(tblDesc));
		this.add(getId_dep_phy_ippreADesc(tblDesc));
		this.add(getId_dep_nur_ippreADesc(tblDesc));
		this.add(getId_kindADesc(tblDesc));
		this.add(getSd_kindADesc(tblDesc));
		this.add(getFg_beddayADesc(tblDesc));
		this.add(getId_wgADesc(tblDesc));
		this.add(getName_introducerADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aptipCDesc(tblDesc));
		tblDesc.add(getId_aptipCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_entipCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_patcaCDesc(tblDesc));
		tblDesc.add(getId_sex_patCDesc(tblDesc));
		tblDesc.add(getSd_sex_patCDesc(tblDesc));
		tblDesc.add(getDt_brith_patCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getCode_hpCDesc(tblDesc));
		tblDesc.add(getId_dep_opCDesc(tblDesc));
		tblDesc.add(getName_dep_opCDesc(tblDesc));
		tblDesc.add(getId_emp_phy_opCDesc(tblDesc));
		tblDesc.add(getName_emp_phy_opCDesc(tblDesc));
		tblDesc.add(getId_didef_opCDesc(tblDesc));
		tblDesc.add(getName_didef_opCDesc(tblDesc));
		tblDesc.add(getSupplement_diCDesc(tblDesc));
		tblDesc.add(getId_level_diseCDesc(tblDesc));
		tblDesc.add(getSd_level_diseCDesc(tblDesc));
		tblDesc.add(getId_dep_phy_ipCDesc(tblDesc));
		tblDesc.add(getId_dep_nur_ipCDesc(tblDesc));
		tblDesc.add(getFg_planCDesc(tblDesc));
		tblDesc.add(getId_bedtpCDesc(tblDesc));
		tblDesc.add(getSd_bedtypeCDesc(tblDesc));
		tblDesc.add(getDt_admit_planCDesc(tblDesc));
		tblDesc.add(getAmt_depositCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getFg_emgstayCDesc(tblDesc));
		tblDesc.add(getId_bedCDesc(tblDesc));
		tblDesc.add(getSd_statusCDesc(tblDesc));
		tblDesc.add(getDt_validCDesc(tblDesc));
		tblDesc.add(getLevel_priCDesc(tblDesc));
		tblDesc.add(getLevel_pri_rsnCDesc(tblDesc));
		tblDesc.add(getDt_insertCDesc(tblDesc));
		tblDesc.add(getFg_cancCDesc(tblDesc));
		tblDesc.add(getId_emp_cancCDesc(tblDesc));
		tblDesc.add(getDt_cancCDesc(tblDesc));
		tblDesc.add(getId_emp_apptCDesc(tblDesc));
		tblDesc.add(getDt_apptCDesc(tblDesc));
		tblDesc.add(getId_emp_cfmCDesc(tblDesc));
		tblDesc.add(getDt_cfmCDesc(tblDesc));
		tblDesc.add(getId_emp_noticeCDesc(tblDesc));
		tblDesc.add(getName_emp_noticeCDesc(tblDesc));
		tblDesc.add(getDa_noticeCDesc(tblDesc));
		tblDesc.add(getRsn_refuseCDesc(tblDesc));
		tblDesc.add(getFg_manualCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getFg_vipCDesc(tblDesc));
		tblDesc.add(getSd_referalsrcCDesc(tblDesc));
		tblDesc.add(getName_cont_phyCDesc(tblDesc));
		tblDesc.add(getTel_cont_phyCDesc(tblDesc));
		tblDesc.add(getId_referalsrcCDesc(tblDesc));
		tblDesc.add(getNote_aptCDesc(tblDesc));
		tblDesc.add(getSd_walkwithCDesc(tblDesc));
		tblDesc.add(getId_walkwithCDesc(tblDesc));
		tblDesc.add(getId_introducerCDesc(tblDesc));
		tblDesc.add(getId_patcontCDesc(tblDesc));
		tblDesc.add(getFg_cfmCDesc(tblDesc));
		tblDesc.add(getFg_ippreCDesc(tblDesc));
		tblDesc.add(getId_dep_phy_ippreCDesc(tblDesc));
		tblDesc.add(getId_dep_nur_ippreCDesc(tblDesc));
		tblDesc.add(getId_kindCDesc(tblDesc));
		tblDesc.add(getSd_kindCDesc(tblDesc));
		tblDesc.add(getFg_beddayCDesc(tblDesc));
		tblDesc.add(getId_wgCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 入院预约id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aptipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aptip",  getId_aptipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院预约id");
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
	 * 住院就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_entip",  getId_entipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院就诊");
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
		attrDesc.setRefType(true);
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
	 * 患者分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patca",  getId_patcaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者性别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_sex_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_sex_pat",  getId_sex_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 患者性别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_sex_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_sex_pat",  getSd_sex_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("患者性别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 出生日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_brith_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_brith_pat",  getDt_brith_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("出生日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保计划属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_hp",  getId_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保计划");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保编号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hp",  getCode_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保编号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊就诊科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_op",  getId_dep_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊就诊科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊就诊科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_op",  getName_dep_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊就诊科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊医生属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_phy_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_phy_op",  getId_emp_phy_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊医生");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊医生名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_phy_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_phy_op",  getName_emp_phy_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊医生名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊诊断属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_didef_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_didef_op",  getId_didef_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊诊断");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊诊断名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_didef_opADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_didef_op",  getName_didef_opCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊诊断名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊诊断补充说明属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSupplement_diADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Supplement_di",  getSupplement_diCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊诊断补充说明");
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
	 * 病情状况编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_level_diseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_level_dise",  getSd_level_diseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情状况编码");
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
	private IAttrDesc getId_dep_phy_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy_ip",  getId_dep_phy_ipCDesc(tblDesc), this);
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
	private IAttrDesc getId_dep_nur_ipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur_ip",  getId_dep_nur_ipCDesc(tblDesc), this);
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
	 * 计划内入院属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_plan",  getFg_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("计划内入院");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位类型id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bedtp",  getId_bedtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位类型id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 床位类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_bedtypeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_bedtype",  getSd_bedtypeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划入院日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_admit_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_admit_plan",  getDt_admit_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计划入院日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预计预交金额度属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmt_depositADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Amt_deposit",  getAmt_depositCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("预计预交金额度");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 备注属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNoteADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note",  getNoteCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("备注");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 急诊留观标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_emgstayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_emgstay",  getFg_emgstayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("急诊留观标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 床位id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bed",  getId_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请单状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status",  getSd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单有效期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_validADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_valid",  getDt_validCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("申请单有效期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优先级别属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLevel_priADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Level_pri",  getLevel_priCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("优先级别");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 优先级别原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLevel_pri_rsnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Level_pri_rsn",  getLevel_pri_rsnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("优先级别原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_insertADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_insert",  getDt_insertCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("申请时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_canc",  getFg_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("取消标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_canc",  getId_emp_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("取消人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 取消时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cancADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_canc",  getDt_cancCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("取消时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_appt",  getId_emp_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 预约时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_apptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_appt",  getDt_apptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("预约时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划确认人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_cfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_cfm",  getId_emp_cfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("计划确认人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划确认时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_cfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_cfm",  getDt_cfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计划确认时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知经办人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_noticeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_notice",  getId_emp_noticeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知经办人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 通知经办人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_noticeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_notice",  getName_emp_noticeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知经办人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知下达日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDa_noticeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Da_notice",  getDa_noticeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("通知下达日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 拒绝原因属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getRsn_refuseADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Rsn_refuse",  getRsn_refuseCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("拒绝原因");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 手动配置属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_manualADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_manual",  getFg_manualCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("手动配置");
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
	 * vip标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_vipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_vip",  getFg_vipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("vip标识");
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
	private IAttrDesc getSd_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_referalsrc",  getSd_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_cont_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_cont_phy",  getName_cont_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医生电话属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTel_cont_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tel_cont_phy",  getTel_cont_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医生电话");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 来院方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_referalsrcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_referalsrc",  getId_referalsrcCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("来院方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预约信息反馈属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNote_aptADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Note_apt",  getNote_aptCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预约信息反馈");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 送入方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_walkwithADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_walkwith",  getSd_walkwithCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("送入方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 送入方式id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_walkwithADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_walkwith",  getId_walkwithCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("送入方式id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 介绍人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_introducerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_introducer",  getId_introducerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("介绍人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 联系人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_patcontADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_patcont",  getId_patcontCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("联系人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 确认标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_cfmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_cfm",  getFg_cfmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("确认标志");
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
	 * 预住院科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_phy_ippreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_phy_ippre",  getId_dep_phy_ippreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预住院科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预住院病区属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nur_ippreADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur_ippre",  getId_dep_nur_ippreCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预住院病区");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预住院类别id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_kindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_kind",  getId_kindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预住院类别id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 预住院类别编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_kindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_kind",  getSd_kindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("预住院类别编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 日间医疗标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_beddayADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_bedday",  getFg_beddayCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("日间医疗标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗组id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_wgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_wg",  getId_wgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗组id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 介绍人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_introducerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_introducer",  getName_introducerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("介绍人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b22","id_introducer=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取入院预约id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aptipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aptip");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院预约id"); 
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
	 * 获取住院就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_entip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("住院就诊"); 
		return column;
	}
	/**
	 * 获取患者ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_pat");
		column.setLength(20);
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
	 * 获取患者分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者分类"); 
		return column;
	}
	/**
	 * 获取患者性别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_sex_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_sex_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别"); 
		return column;
	}
	/**
	 * 获取患者性别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_sex_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_sex_pat");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("患者性别编码"); 
		return column;
	}
	/**
	 * 获取出生日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_brith_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_brith_pat");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("出生日期"); 
		return column;
	}
	/**
	 * 获取医保计划表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保计划"); 
		return column;
	}
	/**
	 * 获取医保编号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保编号"); 
		return column;
	}
	/**
	 * 获取门诊就诊科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊就诊科室"); 
		return column;
	}
	/**
	 * 获取门诊就诊科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊就诊科室名称"); 
		return column;
	}
	/**
	 * 获取门诊医生表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_phy_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_phy_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊医生"); 
		return column;
	}
	/**
	 * 获取门诊医生名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_phy_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_phy_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊医生名称"); 
		return column;
	}
	/**
	 * 获取门诊诊断表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_didef_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_didef_op");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊诊断"); 
		return column;
	}
	/**
	 * 获取门诊诊断名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_didef_opCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_didef_op");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊诊断名称"); 
		return column;
	}
	/**
	 * 获取门诊诊断补充说明表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSupplement_diCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Supplement_di");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊诊断补充说明"); 
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
	 * 获取病情状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_level_diseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_level_dise");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情状况编码"); 
		return column;
	}
	/**
	 * 获取入院科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phy_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy_ip");
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
	private IColumnDesc getId_dep_nur_ipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur_ip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病区"); 
		return column;
	}
	/**
	 * 获取计划内入院表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_plan");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划内入院"); 
		return column;
	}
	/**
	 * 获取床位类型id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bedtp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位类型id"); 
		return column;
	}
	/**
	 * 获取床位类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_bedtypeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_bedtype");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位类型"); 
		return column;
	}
	/**
	 * 获取计划入院日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_admit_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_admit_plan");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划入院日期"); 
		return column;
	}
	/**
	 * 获取预计预交金额度表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmt_depositCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Amt_deposit");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("预计预交金额度"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNoteCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note");
		column.setLength(200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
		return column;
	}
	/**
	 * 获取急诊留观标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_emgstayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_emgstay");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("急诊留观标识"); 
		return column;
	}
	/**
	 * 获取床位id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位id"); 
		return column;
	}
	/**
	 * 获取申请单状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单状态"); 
		return column;
	}
	/**
	 * 获取申请单有效期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_validCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_valid");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请单有效期"); 
		return column;
	}
	/**
	 * 获取优先级别表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLevel_priCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Level_pri");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("优先级别"); 
		return column;
	}
	/**
	 * 获取优先级别原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLevel_pri_rsnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Level_pri_rsn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("优先级别原因"); 
		return column;
	}
	/**
	 * 获取申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_insertCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_insert");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请时间"); 
		return column;
	}
	/**
	 * 获取取消标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_canc");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取消标志"); 
		return column;
	}
	/**
	 * 获取取消人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_canc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("取消人员"); 
		return column;
	}
	/**
	 * 获取取消时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cancCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_canc");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("取消时间"); 
		return column;
	}
	/**
	 * 获取预约人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_appt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约人"); 
		return column;
	}
	/**
	 * 获取预约时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_appt");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("预约时间"); 
		return column;
	}
	/**
	 * 获取计划确认人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_cfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_cfm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("计划确认人"); 
		return column;
	}
	/**
	 * 获取计划确认时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_cfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_cfm");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划确认时间"); 
		return column;
	}
	/**
	 * 获取通知经办人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_noticeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_notice");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知经办人"); 
		return column;
	}
	/**
	 * 获取通知经办人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_noticeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_notice");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知经办人姓名"); 
		return column;
	}
	/**
	 * 获取通知下达日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDa_noticeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Da_notice");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("通知下达日期"); 
		return column;
	}
	/**
	 * 获取拒绝原因表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getRsn_refuseCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Rsn_refuse");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("拒绝原因"); 
		return column;
	}
	/**
	 * 获取手动配置表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_manualCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_manual");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("手动配置"); 
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
	 * 获取vip标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_vipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_vip");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("vip标识"); 
		return column;
	}
	/**
	 * 获取来院方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_referalsrc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式"); 
		return column;
	}
	/**
	 * 获取医生姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_cont_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_cont_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生姓名"); 
		return column;
	}
	/**
	 * 获取医生电话表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTel_cont_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tel_cont_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医生电话"); 
		return column;
	}
	/**
	 * 获取来院方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_referalsrcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_referalsrc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("来院方式id"); 
		return column;
	}
	/**
	 * 获取预约信息反馈表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNote_aptCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Note_apt");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预约信息反馈"); 
		return column;
	}
	/**
	 * 获取送入方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_walkwithCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_walkwith");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("送入方式"); 
		return column;
	}
	/**
	 * 获取送入方式id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_walkwithCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_walkwith");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("送入方式id"); 
		return column;
	}
	/**
	 * 获取介绍人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_introducerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_introducer");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("介绍人"); 
		return column;
	}
	/**
	 * 获取联系人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_patcontCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_patcont");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("联系人"); 
		return column;
	}
	/**
	 * 获取确认标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_cfmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_cfm");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("确认标志"); 
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
	 * 获取预住院科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_phy_ippreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_phy_ippre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预住院科室"); 
		return column;
	}
	/**
	 * 获取预住院病区表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nur_ippreCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur_ippre");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预住院病区"); 
		return column;
	}
	/**
	 * 获取预住院类别id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_kindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_kind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预住院类别id"); 
		return column;
	}
	/**
	 * 获取预住院类别编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_kindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_kind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("预住院类别编码"); 
		return column;
	}
	/**
	 * 获取日间医疗标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_beddayCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_bedday");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("日间医疗标志"); 
		return column;
	}
	/**
	 * 获取医疗组id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_wgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_wg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗组id"); 
		return column;
	}
	/**
	 * 获取介绍人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_introducerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_introducer");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("介绍人姓名"); 
		return column;
	}
	/**
	 * 设置IBDataInfo接口映射数据
	 */
	private void setIBDDataInfoFldMap(){
		iBDDataInfoFldMap=new HashMap<String, String>();
		iBDDataInfoFldMap.put("id","Id_aptip");
		iBDDataInfoFldMap.put("id_org","Id_org");
		iBDDataInfoFldMap.put("id_group","Id_grp");
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
	}
	
}
