
package iih.ci.ord.cons.d.desc;

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
 * 会诊申请单 DO 元数据信息
 */
public class OrdApConsDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.cons.d.OrdApConsDO";
	public static final String CLASS_DISPALYNAME = "会诊申请单";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ap_cons";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_apcons";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public OrdApConsDODesc(){
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
		this.setKeyDesc(getId_apconsADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_apconsADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getDt_planADesc(tblDesc));
		this.add(getDes_pspADesc(tblDesc));
		this.add(getDes_emrADesc(tblDesc));
		this.add(getTelADesc(tblDesc));
		this.add(getDt_apADesc(tblDesc));
		this.add(getId_placeADesc(tblDesc));
		this.add(getPlaceADesc(tblDesc));
		this.add(getId_su_consADesc(tblDesc));
		this.add(getSd_su_consADesc(tblDesc));
		this.add(getFg_inorgADesc(tblDesc));
		this.add(getFg_depsADesc(tblDesc));
		this.add(getFg_audit_clidepADesc(tblDesc));
		this.add(getEu_approve_clidepADesc(tblDesc));
		this.add(getFg_audit_admdepADesc(tblDesc));
		this.add(getEu_approvet_admdepADesc(tblDesc));
		this.add(getFg_emptitlelimitADesc(tblDesc));
		this.add(getSd_emptitle_phyADesc(tblDesc));
		this.add(getSd_emptitle_tecADesc(tblDesc));
		this.add(getSd_emptitle_phaADesc(tblDesc));
		this.add(getFg_openorADesc(tblDesc));
		this.add(getSd_cgmdADesc(tblDesc));
		this.add(getSd_rcdmdADesc(tblDesc));
		this.add(getQuan_answerADesc(tblDesc));
		this.add(getId_unit_answerADesc(tblDesc));
		this.add(getFg_asgn_answerADesc(tblDesc));
		this.add(getFg_eval_apADesc(tblDesc));
		this.add(getQuan_eval_apADesc(tblDesc));
		this.add(getId_unit_eval_apADesc(tblDesc));
		this.add(getFg_eval_invADesc(tblDesc));
		this.add(getQuan_eval_invADesc(tblDesc));
		this.add(getId_unit_eval_invADesc(tblDesc));
		this.add(getFg_eval_admdepADesc(tblDesc));
		this.add(getQuan_eval_admdepADesc(tblDesc));
		this.add(getId_unit_eval_admdepADesc(tblDesc));
		this.add(getFg_prnADesc(tblDesc));
		this.add(getCnt_prnADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getId_constpADesc(tblDesc));
		this.add(getSd_constpADesc(tblDesc));
		this.add(getDt_constimelimitADesc(tblDesc));
		this.add(getName_su_consADesc(tblDesc));
		this.add(getName_unit_answerADesc(tblDesc));
		this.add(getName_unit_eval_apADesc(tblDesc));
		this.add(getName_unit_eval_invADesc(tblDesc));
		this.add(getName_unit_eval_admdepADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_apconsCDesc(tblDesc));
		tblDesc.add(getId_apconsCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getDt_planCDesc(tblDesc));
		tblDesc.add(getDes_pspCDesc(tblDesc));
		tblDesc.add(getDes_emrCDesc(tblDesc));
		tblDesc.add(getTelCDesc(tblDesc));
		tblDesc.add(getDt_apCDesc(tblDesc));
		tblDesc.add(getId_placeCDesc(tblDesc));
		tblDesc.add(getPlaceCDesc(tblDesc));
		tblDesc.add(getId_su_consCDesc(tblDesc));
		tblDesc.add(getSd_su_consCDesc(tblDesc));
		tblDesc.add(getFg_inorgCDesc(tblDesc));
		tblDesc.add(getFg_depsCDesc(tblDesc));
		tblDesc.add(getFg_audit_clidepCDesc(tblDesc));
		tblDesc.add(getEu_approve_clidepCDesc(tblDesc));
		tblDesc.add(getFg_audit_admdepCDesc(tblDesc));
		tblDesc.add(getEu_approvet_admdepCDesc(tblDesc));
		tblDesc.add(getFg_emptitlelimitCDesc(tblDesc));
		tblDesc.add(getSd_emptitle_phyCDesc(tblDesc));
		tblDesc.add(getSd_emptitle_tecCDesc(tblDesc));
		tblDesc.add(getSd_emptitle_phaCDesc(tblDesc));
		tblDesc.add(getFg_openorCDesc(tblDesc));
		tblDesc.add(getSd_cgmdCDesc(tblDesc));
		tblDesc.add(getSd_rcdmdCDesc(tblDesc));
		tblDesc.add(getQuan_answerCDesc(tblDesc));
		tblDesc.add(getId_unit_answerCDesc(tblDesc));
		tblDesc.add(getFg_asgn_answerCDesc(tblDesc));
		tblDesc.add(getFg_eval_apCDesc(tblDesc));
		tblDesc.add(getQuan_eval_apCDesc(tblDesc));
		tblDesc.add(getId_unit_eval_apCDesc(tblDesc));
		tblDesc.add(getFg_eval_invCDesc(tblDesc));
		tblDesc.add(getQuan_eval_invCDesc(tblDesc));
		tblDesc.add(getId_unit_eval_invCDesc(tblDesc));
		tblDesc.add(getFg_eval_admdepCDesc(tblDesc));
		tblDesc.add(getQuan_eval_admdepCDesc(tblDesc));
		tblDesc.add(getId_unit_eval_admdepCDesc(tblDesc));
		tblDesc.add(getFg_prnCDesc(tblDesc));
		tblDesc.add(getCnt_prnCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getId_constpCDesc(tblDesc));
		tblDesc.add(getSd_constpCDesc(tblDesc));
		tblDesc.add(getDt_constimelimitCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 医嘱会诊申请主键标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apconsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apcons",  getId_apconsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱会诊申请主键标识");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 计划会诊时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_plan",  getDt_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("计划会诊时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊目的属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_pspADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_psp",  getDes_pspCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊目的");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历摘要属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDes_emrADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des_emr",  getDes_emrCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历摘要");
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
	 * 申请时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_ap",  getDt_apCDesc(tblDesc), this);
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
	 * 会诊地点主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_placeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_place",  getId_placeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊地点主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊地点属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPlaceADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Place",  getPlaceCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊地点");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊申请状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_su_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_su_cons",  getId_su_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊申请状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 会诊申请状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_cons",  getSd_su_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊申请状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 院内会诊标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_inorgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_inorg",  getFg_inorgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("院内会诊标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 多科会诊标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_depsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_deps",  getFg_depsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("多科会诊标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需科室审批属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_audit_clidepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_audit_clidep",  getFg_audit_clidepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需科室审批");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室审批结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_approve_clidepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_approve_clidep",  getEu_approve_clidepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室审批结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否需医务部审批属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_audit_admdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_audit_admdep",  getFg_audit_admdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否需医务部审批");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务审批结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEu_approvet_admdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Eu_approvet_admdep",  getEu_approvet_admdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务审批结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀人员是否限制职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_emptitlelimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_emptitlelimit",  getFg_emptitlelimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("受邀人员是否限制职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医师最低职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitle_phyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitle_phy",  getSd_emptitle_phyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医师最低职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 技师最低职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitle_tecADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitle_tec",  getSd_emptitle_tecCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("技师最低职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 药师最低职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitle_phaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitle_pha",  getSd_emptitle_phaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("药师最低职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否允许受邀方开立医嘱属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_openorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_openor",  getFg_openorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否允许受邀方开立医嘱");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊收费方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_cgmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_cgmd",  getSd_cgmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊收费方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊记录方式属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_rcdmdADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_rcdmd",  getSd_rcdmdCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊记录方式");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊应答时效属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_answerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_answer",  getQuan_answerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("会诊应答时效");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答时效单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_answerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_answer",  getId_unit_answerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答时效单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 非指定人员是否可应答属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_asgn_answerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_asgn_answer",  getFg_asgn_answerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("非指定人员是否可应答");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请方是否参与会诊评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_eval_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_eval_ap",  getFg_eval_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("申请方是否参与会诊评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请方评价限时时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_eval_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_eval_ap",  getQuan_eval_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("申请方评价限时时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请方评价限时单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_eval_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_eval_ap",  getId_unit_eval_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请方评价限时单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 受邀方是否参与会诊评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_eval_invADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_eval_inv",  getFg_eval_invCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("受邀方是否参与会诊评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀方评价限时时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_eval_invADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_eval_inv",  getQuan_eval_invCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("受邀方评价限时时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀方评价限时单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_eval_invADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_eval_inv",  getId_unit_eval_invCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀方评价限时单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医务是否参与会诊评价属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_eval_admdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_eval_admdep",  getFg_eval_admdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医务是否参与会诊评价");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务评价限时时长属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getQuan_eval_admdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Quan_eval_admdep",  getQuan_eval_admdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("医务评价限时时长");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务评价限时单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_unit_eval_admdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_unit_eval_admdep",  getId_unit_eval_admdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务评价限时单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 打印标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_prn",  getFg_prnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("打印标识");
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
	private IAttrDesc getCnt_prnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Cnt_prn",  getCnt_prnCDesc(tblDesc), this);
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
	 * 加急标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("加急标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊类型ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_constpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_constp",  getId_constpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊类型ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_constpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_constp",  getSd_constpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊时间限制属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_constimelimitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_constimelimit",  getDt_constimelimitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊时间限制");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 会诊申请状态名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_su_consADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_su_cons",  getName_su_consCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("会诊申请状态名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b5","id_su_cons=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 应答时效单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_answerADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_answer",  getName_unit_answerCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("应答时效单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b6","id_unit_answer=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请方评价限时单位名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_eval_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_eval_ap",  getName_unit_eval_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请方评价限时单位名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b7","id_unit_eval_ap=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 受邀方评价限时单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_eval_invADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_eval_inv",  getName_unit_eval_invCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("受邀方评价限时单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b8","id_unit_eval_inv=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医务评价限时单位属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_unit_eval_admdepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_unit_eval_admdep",  getName_unit_eval_admdepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医务评价限时单位");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_measdoc a0b9","id_unit_eval_admdep=id_measdoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取医嘱会诊申请主键标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apconsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apcons");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医嘱会诊申请主键标识"); 
		return column;
	}
	/**
	 * 获取医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱"); 
		return column;
	}
	/**
	 * 获取会诊申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊申请单号"); 
		return column;
	}
	/**
	 * 获取计划会诊时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_plan");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划会诊时间"); 
		return column;
	}
	/**
	 * 获取会诊目的表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_pspCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_psp");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊目的"); 
		return column;
	}
	/**
	 * 获取病历摘要表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDes_emrCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des_emr");
		column.setLength(4000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历摘要"); 
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
	 * 获取申请时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_ap");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请时间"); 
		return column;
	}
	/**
	 * 获取会诊地点主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_placeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_place");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("会诊地点主键"); 
		return column;
	}
	/**
	 * 获取会诊地点表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPlaceCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Place");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊地点"); 
		return column;
	}
	/**
	 * 获取会诊申请状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_su_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_su_cons");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊申请状态"); 
		return column;
	}
	/**
	 * 获取会诊申请状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_cons");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊申请状态编码"); 
		return column;
	}
	/**
	 * 获取院内会诊标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_inorgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_inorg");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("院内会诊标志"); 
		return column;
	}
	/**
	 * 获取多科会诊标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_depsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_deps");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("多科会诊标志"); 
		return column;
	}
	/**
	 * 获取是否需科室审批表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_audit_clidepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_audit_clidep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需科室审批"); 
		return column;
	}
	/**
	 * 获取科室审批结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_approve_clidepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_approve_clidep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室审批结果"); 
		return column;
	}
	/**
	 * 获取是否需医务部审批表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_audit_admdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_audit_admdep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否需医务部审批"); 
		return column;
	}
	/**
	 * 获取医务审批结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEu_approvet_admdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Eu_approvet_admdep");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务审批结果"); 
		return column;
	}
	/**
	 * 获取受邀人员是否限制职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_emptitlelimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_emptitlelimit");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受邀人员是否限制职称"); 
		return column;
	}
	/**
	 * 获取医师最低职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitle_phyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitle_phy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医师最低职称"); 
		return column;
	}
	/**
	 * 获取技师最低职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitle_tecCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitle_tec");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("技师最低职称"); 
		return column;
	}
	/**
	 * 获取药师最低职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitle_phaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitle_pha");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("药师最低职称"); 
		return column;
	}
	/**
	 * 获取是否允许受邀方开立医嘱表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_openorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_openor");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否允许受邀方开立医嘱"); 
		return column;
	}
	/**
	 * 获取会诊收费方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_cgmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_cgmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊收费方式"); 
		return column;
	}
	/**
	 * 获取会诊记录方式表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_rcdmdCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_rcdmd");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊记录方式"); 
		return column;
	}
	/**
	 * 获取会诊应答时效表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_answerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_answer");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("会诊应答时效"); 
		return column;
	}
	/**
	 * 获取应答时效单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_answerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_answer");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答时效单位"); 
		return column;
	}
	/**
	 * 获取非指定人员是否可应答表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_asgn_answerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_asgn_answer");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("非指定人员是否可应答"); 
		return column;
	}
	/**
	 * 获取申请方是否参与会诊评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_eval_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_eval_ap");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("申请方是否参与会诊评价"); 
		return column;
	}
	/**
	 * 获取申请方评价限时时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_eval_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_eval_ap");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("申请方评价限时时长"); 
		return column;
	}
	/**
	 * 获取申请方评价限时单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_eval_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_eval_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请方评价限时单位"); 
		return column;
	}
	/**
	 * 获取受邀方是否参与会诊评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_eval_invCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_eval_inv");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("受邀方是否参与会诊评价"); 
		return column;
	}
	/**
	 * 获取受邀方评价限时时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_eval_invCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_eval_inv");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("受邀方评价限时时长"); 
		return column;
	}
	/**
	 * 获取受邀方评价限时单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_eval_invCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_eval_inv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀方评价限时单位"); 
		return column;
	}
	/**
	 * 获取医务是否参与会诊评价表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_eval_admdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_eval_admdep");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医务是否参与会诊评价"); 
		return column;
	}
	/**
	 * 获取医务评价限时时长表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getQuan_eval_admdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Quan_eval_admdep");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("医务评价限时时长"); 
		return column;
	}
	/**
	 * 获取医务评价限时单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_unit_eval_admdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_unit_eval_admdep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务评价限时单位"); 
		return column;
	}
	/**
	 * 获取打印标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_prn");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("打印标识"); 
		return column;
	}
	/**
	 * 获取打印次数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCnt_prnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Cnt_prn");
		column.setLength(5);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("打印次数"); 
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
	 * 获取加急标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("加急标志"); 
		return column;
	}
	/**
	 * 获取会诊类型ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_constpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_constp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊类型ID"); 
		return column;
	}
	/**
	 * 获取会诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_constpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_constp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊类型"); 
		return column;
	}
	/**
	 * 获取会诊时间限制表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_constimelimitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_constimelimit");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊时间限制"); 
		return column;
	}
	/**
	 * 获取会诊申请状态名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_su_consCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_su_cons");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("会诊申请状态名称"); 
		return column;
	}
	/**
	 * 获取应答时效单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_answerCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_answer");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("应答时效单位名称"); 
		return column;
	}
	/**
	 * 获取申请方评价限时单位名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_eval_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_eval_ap");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请方评价限时单位名称"); 
		return column;
	}
	/**
	 * 获取受邀方评价限时单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_eval_invCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_eval_inv");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("受邀方评价限时单位"); 
		return column;
	}
	/**
	 * 获取医务评价限时单位表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_unit_eval_admdepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_unit_eval_admdep");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医务评价限时单位"); 
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
		defaultValueMap.put("Fg_emptitlelimit",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_openor",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Fg_prn",new xap.mw.coreitf.d.FBoolean("N"));
		defaultValueMap.put("Cnt_prn",0);
	}
	
}
