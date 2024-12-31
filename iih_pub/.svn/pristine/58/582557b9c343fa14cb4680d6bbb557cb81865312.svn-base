
package iih.ci.ord.ciaphvconsumables.d.desc;

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
 * 医嘱高值耗材申请  DO 元数据信息
 */
public class CiApHvconsumblesDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.ci.ord.ciaphvconsumables.d.CiApHvconsumblesDO";
	public static final String CLASS_DISPALYNAME = "医嘱高值耗材申请 ";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "ci_ap_hvconsumables";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_aphvconsumables";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public CiApHvconsumblesDODesc(){
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
		this.setKeyDesc(getId_aphvconsumablesADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_aphvconsumablesADesc(tblDesc));
		this.add(getNo_applyformADesc(tblDesc));
		this.add(getSd_hcaptpADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_orADesc(tblDesc));
		this.add(getNo_applyform_relADesc(tblDesc));
		this.add(getId_reason_apADesc(tblDesc));
		this.add(getSd_reason_apADesc(tblDesc));
		this.add(getReasonADesc(tblDesc));
		this.add(getId_dep_locADesc(tblDesc));
		this.add(getFg_urgentADesc(tblDesc));
		this.add(getSd_su_hcADesc(tblDesc));
		this.add(getId_emp_apADesc(tblDesc));
		this.add(getDt_apADesc(tblDesc));
		this.add(getId_dep_apADesc(tblDesc));
		this.add(getFg_signADesc(tblDesc));
		this.add(getId_emp_chkADesc(tblDesc));
		this.add(getDt_chkADesc(tblDesc));
		this.add(getId_dep_chkADesc(tblDesc));
		this.add(getSd_approveADesc(tblDesc));
		this.add(getApproveADesc(tblDesc));
		this.add(getId_emp_signADesc(tblDesc));
		this.add(getDt_signADesc(tblDesc));
		this.add(getId_dep_signADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getDt_planADesc(tblDesc));
		this.add(getContent_orADesc(tblDesc));
		this.add(getName_orADesc(tblDesc));
		this.add(getName_dep_locADesc(tblDesc));
		this.add(getName_emp_apADesc(tblDesc));
		this.add(getName_dep_apADesc(tblDesc));
		this.add(getName_emp_chkADesc(tblDesc));
		this.add(getName_dep_chkADesc(tblDesc));
		this.add(getName_emp_signADesc(tblDesc));
		this.add(getName_dep_signADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_aphvconsumablesCDesc(tblDesc));
		tblDesc.add(getId_aphvconsumablesCDesc(tblDesc));
		tblDesc.add(getNo_applyformCDesc(tblDesc));
		tblDesc.add(getSd_hcaptpCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_orCDesc(tblDesc));
		tblDesc.add(getNo_applyform_relCDesc(tblDesc));
		tblDesc.add(getId_reason_apCDesc(tblDesc));
		tblDesc.add(getSd_reason_apCDesc(tblDesc));
		tblDesc.add(getReasonCDesc(tblDesc));
		tblDesc.add(getId_dep_locCDesc(tblDesc));
		tblDesc.add(getFg_urgentCDesc(tblDesc));
		tblDesc.add(getSd_su_hcCDesc(tblDesc));
		tblDesc.add(getId_emp_apCDesc(tblDesc));
		tblDesc.add(getDt_apCDesc(tblDesc));
		tblDesc.add(getId_dep_apCDesc(tblDesc));
		tblDesc.add(getFg_signCDesc(tblDesc));
		tblDesc.add(getId_emp_chkCDesc(tblDesc));
		tblDesc.add(getDt_chkCDesc(tblDesc));
		tblDesc.add(getId_dep_chkCDesc(tblDesc));
		tblDesc.add(getSd_approveCDesc(tblDesc));
		tblDesc.add(getApproveCDesc(tblDesc));
		tblDesc.add(getId_emp_signCDesc(tblDesc));
		tblDesc.add(getDt_signCDesc(tblDesc));
		tblDesc.add(getId_dep_signCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getDt_planCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 高值耗材申请ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_aphvconsumablesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_aphvconsumables",  getId_aphvconsumablesCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("高值耗材申请ID");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyformADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform",  getNo_applyformCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_hcaptpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_hcaptp",  getSd_hcaptpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_entpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_entp",  getCode_entpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 就诊id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("就诊id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 关联医嘱10属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_or",  getId_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联医嘱10");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 关联单号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNo_applyform_relADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("No_applyform_rel",  getNo_applyform_relCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联单号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请理由主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reason_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reason_ap",  getId_reason_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请理由主键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请理由编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reason_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reason_ap",  getSd_reason_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请理由编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请理由属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reason",  getReasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请理由");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流向科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_loc",  getId_dep_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流向科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否加急属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_urgentADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_urgent",  getFg_urgentCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("是否加急");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请单状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_su_hcADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_su_hc",  getSd_su_hcCDesc(tblDesc), this);
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
	 * 申请人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_ap",  getId_emp_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
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
	 * 申请科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_ap",  getId_dep_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 签署标识属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_sign",  getFg_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署标识");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_chk",  getId_emp_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_chk",  getDt_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_chk",  getId_dep_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 审核结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_approveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_approve",  getSd_approveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核记录属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApproveADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Approve",  getApproveCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核记录");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_sign",  getId_emp_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 签署时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_sign",  getDt_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("签署时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_sign",  getId_dep_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署科室");
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
	 * 计划使用时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_planADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_plan",  getDt_planCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("计划使用时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱内容属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getContent_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Content_or",  getContent_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱内容");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_order a0b12","id_or=id_or","content_or"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医嘱名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_orADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_or",  getName_orCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医嘱名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"ci_order a0b12","id_or=id_or","name_or"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流向科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_locADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_loc",  getName_dep_locCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流向科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dep_loc=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_ap",  getName_emp_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_ap=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_apADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_ap",  getName_dep_apCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_ap=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_chk",  getName_emp_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b8","id_emp_chk=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核科室名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_chkADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_chk",  getName_dep_chkCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核科室名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b9","id_dep_chk=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_sign",  getName_emp_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b10","id_emp_sign=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 签署科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_signADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_sign",  getName_dep_signCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("签署科室");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b11","id_dep_sign=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取高值耗材申请ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_aphvconsumablesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_aphvconsumables");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("高值耗材申请ID"); 
		return column;
	}
	/**
	 * 获取申请单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyformCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单号"); 
		return column;
	}
	/**
	 * 获取申请类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_hcaptpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_hcaptp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请类型"); 
		return column;
	}
	/**
	 * 获取就诊类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_entpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_entp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊类型"); 
		return column;
	}
	/**
	 * 获取就诊id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("就诊id"); 
		return column;
	}
	/**
	 * 获取关联医嘱10表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_or");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联医嘱10"); 
		return column;
	}
	/**
	 * 获取关联单号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNo_applyform_relCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"No_applyform_rel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联单号"); 
		return column;
	}
	/**
	 * 获取申请理由主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reason_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reason_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请理由主键"); 
		return column;
	}
	/**
	 * 获取申请理由编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reason_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reason_ap");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请理由编码"); 
		return column;
	}
	/**
	 * 获取申请理由表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请理由"); 
		return column;
	}
	/**
	 * 获取流向科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_loc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流向科室"); 
		return column;
	}
	/**
	 * 获取是否加急表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_urgentCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_urgent");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("是否加急"); 
		return column;
	}
	/**
	 * 获取申请单状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_su_hcCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_su_hc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请单状态"); 
		return column;
	}
	/**
	 * 获取申请人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人"); 
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
	 * 获取申请科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_ap");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请科室"); 
		return column;
	}
	/**
	 * 获取签署标识表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_sign");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署标识"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_chk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人"); 
		return column;
	}
	/**
	 * 获取审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_chk");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取审核科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_chk");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核科室"); 
		return column;
	}
	/**
	 * 获取审核结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_approveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_approve");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核结果"); 
		return column;
	}
	/**
	 * 获取审核记录表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApproveCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Approve");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核记录"); 
		return column;
	}
	/**
	 * 获取签署人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署人"); 
		return column;
	}
	/**
	 * 获取签署时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_sign");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("签署时间"); 
		return column;
	}
	/**
	 * 获取签署科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_sign");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署科室"); 
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
	 * 获取计划使用时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_planCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_plan");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("计划使用时间"); 
		return column;
	}
	/**
	 * 获取医嘱内容表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getContent_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Content_or");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱内容"); 
		return column;
	}
	/**
	 * 获取医嘱名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_orCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_or");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医嘱名称"); 
		return column;
	}
	/**
	 * 获取流向科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_locCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_loc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流向科室"); 
		return column;
	}
	/**
	 * 获取申请人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_ap");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人"); 
		return column;
	}
	/**
	 * 获取申请科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_apCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_ap");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请科室"); 
		return column;
	}
	/**
	 * 获取审核人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_chk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人姓名"); 
		return column;
	}
	/**
	 * 获取审核科室名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_chkCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_chk");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核科室名称"); 
		return column;
	}
	/**
	 * 获取签署人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署人姓名"); 
		return column;
	}
	/**
	 * 获取签署科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_signCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_sign");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("签署科室"); 
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
	}
	
}
