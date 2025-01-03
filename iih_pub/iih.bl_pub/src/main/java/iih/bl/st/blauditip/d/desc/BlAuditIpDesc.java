
package iih.bl.st.blauditip.d.desc;

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
 * 费用审核_住院 DO 元数据信息
 */
public class BlAuditIpDesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bl.st.blauditip.d.BlAuditIp";
	public static final String CLASS_DISPALYNAME = "费用审核_住院";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bl_audit_ip";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_auditip";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public BlAuditIpDesc(){
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
		this.setKeyDesc(getId_auditipADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_auditipADesc(tblDesc));
		this.add(getFg_pass_clinicADesc(tblDesc));
		this.add(getId_emp_clinicADesc(tblDesc));
		this.add(getDt_audit_clinicADesc(tblDesc));
		this.add(getId_emp_canc_clinicADesc(tblDesc));
		this.add(getDt_audit_canc_clinicADesc(tblDesc));
		this.add(getFg_pass_hpADesc(tblDesc));
		this.add(getId_emp_hpADesc(tblDesc));
		this.add(getDt_audit_hpADesc(tblDesc));
		this.add(getId_emp_canc_hpADesc(tblDesc));
		this.add(getDt_audit_canc_hpADesc(tblDesc));
		this.add(getId_stipADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_entADesc(tblDesc));
		this.add(getId_patADesc(tblDesc));
		this.add(getCode_entpADesc(tblDesc));
		this.add(getId_stoepADesc(tblDesc));
		this.add(getAudit_clinic_rstADesc(tblDesc));
		this.add(getAudit_hp_rstADesc(tblDesc));
		this.add(getEmp_name_clinicADesc(tblDesc));
		this.add(getCode_clinicADesc(tblDesc));
		this.add(getCode_canc_clinicADesc(tblDesc));
		this.add(getName_canc_clinicADesc(tblDesc));
		this.add(getCode_hpADesc(tblDesc));
		this.add(getName_hpADesc(tblDesc));
		this.add(getCode_hp_cancelADesc(tblDesc));
		this.add(getName_hp_cancelADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_auditipCDesc(tblDesc));
		tblDesc.add(getId_auditipCDesc(tblDesc));
		tblDesc.add(getFg_pass_clinicCDesc(tblDesc));
		tblDesc.add(getId_emp_clinicCDesc(tblDesc));
		tblDesc.add(getDt_audit_clinicCDesc(tblDesc));
		tblDesc.add(getId_emp_canc_clinicCDesc(tblDesc));
		tblDesc.add(getDt_audit_canc_clinicCDesc(tblDesc));
		tblDesc.add(getFg_pass_hpCDesc(tblDesc));
		tblDesc.add(getId_emp_hpCDesc(tblDesc));
		tblDesc.add(getDt_audit_hpCDesc(tblDesc));
		tblDesc.add(getId_emp_canc_hpCDesc(tblDesc));
		tblDesc.add(getDt_audit_canc_hpCDesc(tblDesc));
		tblDesc.add(getId_stipCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_entCDesc(tblDesc));
		tblDesc.add(getId_patCDesc(tblDesc));
		tblDesc.add(getCode_entpCDesc(tblDesc));
		tblDesc.add(getId_stoepCDesc(tblDesc));
		tblDesc.add(getAudit_clinic_rstCDesc(tblDesc));
		tblDesc.add(getAudit_hp_rstCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 住院费用审核主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_auditipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_auditip",  getId_auditipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("住院费用审核主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗费用审核通过标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pass_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pass_clinic",  getFg_pass_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("诊疗费用审核通过标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗费用审核人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_clinic",  getId_emp_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗费用审核人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊疗费用审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_audit_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_audit_clinic",  getDt_audit_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("诊疗费用审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 诊疗费用审核取消人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_canc_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_canc_clinic",  getId_emp_canc_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗费用审核取消人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊疗费用审核取消时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_audit_canc_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_audit_canc_clinic",  getDt_audit_canc_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("诊疗费用审核取消时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保费用审核标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_pass_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_pass_hp",  getFg_pass_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("医保费用审核标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保费用审核人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_hp",  getId_emp_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保费用审核人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保费用审核时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_audit_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_audit_hp",  getDt_audit_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("医保费用审核时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保费用审核取消人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_canc_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_canc_hp",  getId_emp_canc_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保费用审核取消人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医保费用审核取消时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_audit_canc_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_audit_canc_hp",  getDt_audit_canc_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("医保费用审核取消时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 结算属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stipADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stip",  getId_stipCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 启用标志属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("启用标志");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 所属集团属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属集团");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属组织属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属组织");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 所属就诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_entADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_ent",  getId_entCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("所属就诊");
		attrDesc.setNullable(false);
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
		attrDesc.setRefType(true);
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
	 * 结算_门诊属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_stoepADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_stoep",  getId_stoepCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("结算_门诊");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 诊疗费用审核结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAudit_clinic_rstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Audit_clinic_rst",  getAudit_clinic_rstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("诊疗费用审核结果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医保审核结果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAudit_hp_rstADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Audit_hp_rst",  getAudit_hp_rstCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医保审核结果");
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
	private IAttrDesc getEmp_name_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Emp_name_clinic",  getEmp_name_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b2","id_emp_clinic=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_clinic",  getCode_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b2","id_emp_clinic=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_canc_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_canc_clinic",  getCode_canc_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_canc_clinic=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_canc_clinicADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_canc_clinic",  getName_canc_clinicCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b3","id_emp_canc_clinic=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hp",  getCode_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_hp=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hp",  getName_hpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b5","id_emp_hp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_hp_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_hp_cancel",  getCode_hp_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_canc_hp=id_psndoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_hp_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_hp_cancel",  getName_hp_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b6","id_emp_canc_hp=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取住院费用审核主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_auditipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_auditip");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("住院费用审核主键"); 
		return column;
	}
	/**
	 * 获取诊疗费用审核通过标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pass_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pass_clinic");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊疗费用审核通过标志"); 
		return column;
	}
	/**
	 * 获取诊疗费用审核人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_clinic");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗费用审核人员"); 
		return column;
	}
	/**
	 * 获取诊疗费用审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_audit_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_audit_clinic");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊疗费用审核时间"); 
		return column;
	}
	/**
	 * 获取诊疗费用审核取消人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_canc_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_canc_clinic");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗费用审核取消人员"); 
		return column;
	}
	/**
	 * 获取诊疗费用审核取消时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_audit_canc_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_audit_canc_clinic");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("诊疗费用审核取消时间"); 
		return column;
	}
	/**
	 * 获取医保费用审核标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_pass_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_pass_hp");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保费用审核标志"); 
		return column;
	}
	/**
	 * 获取医保费用审核人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保费用审核人员"); 
		return column;
	}
	/**
	 * 获取医保费用审核时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_audit_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_audit_hp");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保费用审核时间"); 
		return column;
	}
	/**
	 * 获取医保费用审核取消人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_canc_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_canc_hp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保费用审核取消人员"); 
		return column;
	}
	/**
	 * 获取医保费用审核取消时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_audit_canc_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_audit_canc_hp");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("医保费用审核取消时间"); 
		return column;
	}
	/**
	 * 获取结算表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stipCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stip");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算"); 
		return column;
	}
	/**
	 * 获取启用标志表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("启用标志"); 
		return column;
	}
	/**
	 * 获取所属集团表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属集团"); 
		return column;
	}
	/**
	 * 获取所属组织表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属组织"); 
		return column;
	}
	/**
	 * 获取所属就诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_entCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_ent");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("所属就诊"); 
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
	 * 获取结算_门诊表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_stoepCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_stoep");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("结算_门诊"); 
		return column;
	}
	/**
	 * 获取诊疗费用审核结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAudit_clinic_rstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Audit_clinic_rst");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("诊疗费用审核结果"); 
		return column;
	}
	/**
	 * 获取医保审核结果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAudit_hp_rstCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Audit_hp_rst");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医保审核结果"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEmp_name_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Emp_name_clinic");
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
	private IColumnDesc getCode_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_clinic");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取人员编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_canc_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_canc_clinic");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_canc_clinicCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_canc_clinic");
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
	private IColumnDesc getCode_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hp");
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
	private IColumnDesc getCode_hp_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_hp_cancel");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员编码"); 
		return column;
	}
	/**
	 * 获取姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_hp_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_hp_cancel");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("姓名"); 
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
	}
	
}
