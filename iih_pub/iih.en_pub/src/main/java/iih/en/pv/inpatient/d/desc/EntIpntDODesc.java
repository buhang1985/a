
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
 * 入院通知单 DO 元数据信息
 */
public class EntIpntDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.en.pv.inpatient.d.EntIpntDO";
	public static final String CLASS_DISPALYNAME = "入院通知单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "en_ent_ipnt";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_ent_ipnt";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public EntIpntDODesc(){
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
		this.setKeyDesc(getId_ent_ipntADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();  
		this.add(getId_ent_ipntADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_entipADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getName_patADesc(tblDesc));
		this.add(getId_sex_patADesc(tblDesc));
		this.add(getSd_sex_patADesc(tblDesc));
		this.add(getDt_brith_patADesc(tblDesc));
		this.add(getId_hpADesc(tblDesc));
		this.add(getCode_hpADesc(tblDesc));
		this.add(getId_dep_opADesc(tblDesc));
		this.add(getName_dep_opADesc(tblDesc));
		this.add(getId_emp_phy_opADesc(tblDesc));
		this.add(getName_emp_phy_opADesc(tblDesc));
		this.add(getId_diag_op_majADesc(tblDesc));
		this.add(getDesc_diag_op_majADesc(tblDesc));
		this.add(getDesc_diag_op_elsADesc(tblDesc));
		this.add(getId_diag_op_maj_tcmADesc(tblDesc));
		this.add(getDesc_diag_op_maj_tcmADesc(tblDesc));
		this.add(getId_diag_op_els_tcmADesc(tblDesc));
		this.add(getId_status_patADesc(tblDesc));
		this.add(getSd_status_patADesc(tblDesc));
		this.add(getId_dep_phy_ipADesc(tblDesc));
		this.add(getId_dep_nur_ipADesc(tblDesc));
		this.add(getSd_bedtypeADesc(tblDesc));
		this.add(getDt_admit_planADesc(tblDesc));
		this.add(getAmt_depositADesc(tblDesc));
		this.add(getDa_noticeADesc(tblDesc));
		this.add(getId_emp_noticeADesc(tblDesc));
		this.add(getName_emp_noticeADesc(tblDesc));
		this.add(getId_stautsADesc(tblDesc));
		this.add(getSd_statusADesc(tblDesc));
		this.add(getDt_validADesc(tblDesc));
		this.add(getNoteADesc(tblDesc));
		this.add(getFg_emgstayADesc(tblDesc));
		this.add(getId_bedADesc(tblDesc));
		this.add(new DsAttr(dsColumn,this));
		this.add(new SvAttr(svColumn,this));
		
	}
		
	/**
	 * 获得表元数据
	 * @return
	 */
	private ITableDesc getTableDesc(){
		TableDesc tblDesc=new TableDesc(TABLE_NAME,TABLE_ALIAS_NAME);
		tblDesc.setLabel(CLASS_DISPALYNAME);
		tblDesc.setPrimaryKey(getId_ent_ipntCDesc(tblDesc));
		tblDesc.add(getId_ent_ipntCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_entipCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getName_patCDesc(tblDesc));
		tblDesc.add(getId_sex_patCDesc(tblDesc));
		tblDesc.add(getSd_sex_patCDesc(tblDesc));
		tblDesc.add(getDt_brith_patCDesc(tblDesc));
		tblDesc.add(getId_hpCDesc(tblDesc));
		tblDesc.add(getCode_hpCDesc(tblDesc));
		tblDesc.add(getId_dep_opCDesc(tblDesc));
		tblDesc.add(getName_dep_opCDesc(tblDesc));
		tblDesc.add(getId_emp_phy_opCDesc(tblDesc));
		tblDesc.add(getName_emp_phy_opCDesc(tblDesc));
		tblDesc.add(getId_diag_op_majCDesc(tblDesc));
		tblDesc.add(getDesc_diag_op_majCDesc(tblDesc));
		tblDesc.add(getDesc_diag_op_elsCDesc(tblDesc));
		tblDesc.add(getId_diag_op_maj_tcmCDesc(tblDesc));
		tblDesc.add(getDesc_diag_op_maj_tcmCDesc(tblDesc));
		tblDesc.add(getId_diag_op_els_tcmCDesc(tblDesc));
		tblDesc.add(getId_status_patCDesc(tblDesc));
		tblDesc.add(getSd_status_patCDesc(tblDesc));
		tblDesc.add(getId_dep_phy_ipCDesc(tblDesc));
		tblDesc.add(getId_dep_nur_ipCDesc(tblDesc));
		tblDesc.add(getSd_bedtypeCDesc(tblDesc));
		tblDesc.add(getDt_admit_planCDesc(tblDesc));
		tblDesc.add(getAmt_depositCDesc(tblDesc));
		tblDesc.add(getDa_noticeCDesc(tblDesc));
		tblDesc.add(getId_emp_noticeCDesc(tblDesc));
		tblDesc.add(getName_emp_noticeCDesc(tblDesc));
		tblDesc.add(getId_stautsCDesc(tblDesc));
		tblDesc.add(getSd_statusCDesc(tblDesc));
		tblDesc.add(getDt_validCDesc(tblDesc));
		tblDesc.add(getNoteCDesc(tblDesc));
		tblDesc.add(getFg_emgstayCDesc(tblDesc));
		tblDesc.add(getId_bedCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 入院通知单主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_ent_ipntADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent_ipnt",  getId_ent_ipntCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("入院通知单主键");
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
	 * 门诊主要诊断_西药属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diag_op_majADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diag_op_maj",  getId_diag_op_majCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊主要诊断_西药");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊主要诊断描述_西医属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesc_diag_op_majADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Desc_diag_op_maj",  getDesc_diag_op_majCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊主要诊断描述_西医");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊其他诊断描述_西医属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesc_diag_op_elsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Desc_diag_op_els",  getDesc_diag_op_elsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊其他诊断描述_西医");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊主要诊断_中医属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diag_op_maj_tcmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diag_op_maj_tcm",  getId_diag_op_maj_tcmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊主要诊断_中医");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 门诊主要诊断描述_中医属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDesc_diag_op_maj_tcmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Desc_diag_op_maj_tcm",  getDesc_diag_op_maj_tcmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊主要诊断描述_中医");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 门诊其他诊断描述_中医属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_diag_op_els_tcmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_diag_op_els_tcm",  getId_diag_op_els_tcmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("门诊其他诊断描述_中医");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病情状况属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_status_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_status_pat",  getId_status_patCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病情状况");
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
	private IAttrDesc getSd_status_patADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status_pat",  getSd_status_patCDesc(tblDesc), this);
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
		attrDesc.setRefType(false);
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
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知单经办人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_noticeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_notice",  getName_emp_noticeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知单经办人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知单状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stautsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stauts",  getId_stautsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知单状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知单状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_status",  getSd_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("通知单状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 通知单有效期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_validADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_valid",  getDt_validCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("通知单有效期");
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
	 * 床位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_bedADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_bed",  getId_bedCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("床位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 获取入院通知单主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_ent_ipntCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent_ipnt");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("入院通知单主键"); 
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
	 * 获取门诊主要诊断_西药表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diag_op_majCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diag_op_maj");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊主要诊断_西药"); 
		return column;
	}
	/**
	 * 获取门诊主要诊断描述_西医表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesc_diag_op_majCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Desc_diag_op_maj");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊主要诊断描述_西医"); 
		return column;
	}
	/**
	 * 获取门诊其他诊断描述_西医表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesc_diag_op_elsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Desc_diag_op_els");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊其他诊断描述_西医"); 
		return column;
	}
	/**
	 * 获取门诊主要诊断_中医表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diag_op_maj_tcmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diag_op_maj_tcm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊主要诊断_中医"); 
		return column;
	}
	/**
	 * 获取门诊主要诊断描述_中医表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesc_diag_op_maj_tcmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Desc_diag_op_maj_tcm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊主要诊断描述_中医"); 
		return column;
	}
	/**
	 * 获取门诊其他诊断描述_中医表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_diag_op_els_tcmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_diag_op_els_tcm");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("门诊其他诊断描述_中医"); 
		return column;
	}
	/**
	 * 获取病情状况表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_status_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_status_pat");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病情状况"); 
		return column;
	}
	/**
	 * 获取病情状况编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_status_patCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status_pat");
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
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("入院病区"); 
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
	 * 获取通知经办人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_noticeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_notice");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知经办人"); 
		return column;
	}
	/**
	 * 获取通知单经办人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_noticeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_notice");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知单经办人姓名"); 
		return column;
	}
	/**
	 * 获取通知单状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stautsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stauts");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知单状态"); 
		return column;
	}
	/**
	 * 获取通知单状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("通知单状态编码"); 
		return column;
	}
	/**
	 * 获取通知单有效期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_validCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_valid");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("通知单有效期"); 
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
	 * 获取床位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_bedCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_bed");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("床位"); 
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
	
}
