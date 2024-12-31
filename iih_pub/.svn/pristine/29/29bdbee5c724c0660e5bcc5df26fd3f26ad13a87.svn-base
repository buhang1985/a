
package iih.nm.nhr.nmnhrschedrp.d.desc;

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
 * 替班申请 DO 元数据信息
 */
public class NhrSchedRpDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nhr.nmnhrschedrp.d.NhrSchedRpDO";
	public static final String CLASS_DISPALYNAME = "替班申请";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nm_sched_rp";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nhr_sched_rp";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NhrSchedRpDODesc(){
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
		this.setKeyDesc(getId_nhr_sched_rpADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nhr_sched_rpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_nur_apyADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getId_dep_apyADesc(tblDesc));
		this.add(getId_nur_lvl_apyADesc(tblDesc));
		this.add(getSd_nur_lvl_apyADesc(tblDesc));
		this.add(getId_nur_rpADesc(tblDesc));
		this.add(getId_dep_rpADesc(tblDesc));
		this.add(getId_nur_lvl_rpADesc(tblDesc));
		this.add(getSd_nur_lvl_rpADesc(tblDesc));
		this.add(getId_nhr_si_apy_oldADesc(tblDesc));
		this.add(getId_nhr_si_apy_newADesc(tblDesc));
		this.add(getId_nhr_si_rp_oldADesc(tblDesc));
		this.add(getId_nhr_si_rp_newADesc(tblDesc));
		this.add(getDt_rpADesc(tblDesc));
		this.add(getSd_apy_reasonADesc(tblDesc));
		this.add(getId_apy_reasonADesc(tblDesc));
		this.add(getId_apy_statusADesc(tblDesc));
		this.add(getSd_apy_statusADesc(tblDesc));
		this.add(getId_reg_psnADesc(tblDesc));
		this.add(getDt_regADesc(tblDesc));
		this.add(getId_taskADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_nur_apyADesc(tblDesc));
		this.add(getName_psndocADesc(tblDesc));
		this.add(getDep_apy_nameADesc(tblDesc));
		this.add(getName_lvl_apyADesc(tblDesc));
		this.add(getName_nhr_rpADesc(tblDesc));
		this.add(getDep_rp_nameADesc(tblDesc));
		this.add(getName_lvl_rpADesc(tblDesc));
		this.add(getName_apy_nhr_siADesc(tblDesc));
		this.add(getName_apy_newADesc(tblDesc));
		this.add(getName_short_apy_newADesc(tblDesc));
		this.add(getName_rp_nhr_siADesc(tblDesc));
		this.add(getName_rp_newADesc(tblDesc));
		this.add(getName_short_rp_newADesc(tblDesc));
		this.add(getName_apy_reasonADesc(tblDesc));
		this.add(getName_apy_statusADesc(tblDesc));
		this.add(getName_emp_auditADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nhr_sched_rpCDesc(tblDesc));
		tblDesc.add(getId_nhr_sched_rpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_nur_apyCDesc(tblDesc));
		tblDesc.add(getId_psndocCDesc(tblDesc));
		tblDesc.add(getId_dep_apyCDesc(tblDesc));
		tblDesc.add(getId_nur_lvl_apyCDesc(tblDesc));
		tblDesc.add(getSd_nur_lvl_apyCDesc(tblDesc));
		tblDesc.add(getId_nur_rpCDesc(tblDesc));
		tblDesc.add(getId_dep_rpCDesc(tblDesc));
		tblDesc.add(getId_nur_lvl_rpCDesc(tblDesc));
		tblDesc.add(getSd_nur_lvl_rpCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_apy_oldCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_apy_newCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_rp_oldCDesc(tblDesc));
		tblDesc.add(getId_nhr_si_rp_newCDesc(tblDesc));
		tblDesc.add(getDt_rpCDesc(tblDesc));
		tblDesc.add(getSd_apy_reasonCDesc(tblDesc));
		tblDesc.add(getId_apy_reasonCDesc(tblDesc));
		tblDesc.add(getId_apy_statusCDesc(tblDesc));
		tblDesc.add(getSd_apy_statusCDesc(tblDesc));
		tblDesc.add(getId_reg_psnCDesc(tblDesc));
		tblDesc.add(getDt_regCDesc(tblDesc));
		tblDesc.add(getId_taskCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 替班申请主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_sched_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_sched_rp",  getId_nhr_sched_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班申请主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
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
	 * 申请人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_apy",  getId_nur_apyCDesc(tblDesc), this);
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
	 * 人员基本属性(申请人)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员基本属性(申请人)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请人护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_apy",  getId_dep_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请人护士层级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_lvl_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_lvl_apy",  getId_nur_lvl_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人护士层级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请人护士层级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nur_lvl_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nur_lvl_apy",  getSd_nur_lvl_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人护士层级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 替班人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_rp",  getId_nur_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班人护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_rp",  getId_dep_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班人护士层级属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_lvl_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_lvl_rp",  getId_nur_lvl_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人护士层级");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班人护士层级编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_nur_lvl_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_nur_lvl_rp",  getSd_nur_lvl_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人护士层级编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请人原班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_apy_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_apy_old",  getId_nhr_si_apy_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人原班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请人新班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_apy_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_apy_new",  getId_nhr_si_apy_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人新班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班人原班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_rp_oldADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_rp_old",  getId_nhr_si_rp_oldCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人原班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班人新班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_si_rp_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si_rp_new",  getId_nhr_si_rp_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人新班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 替班日期属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_rp",  getDt_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDate);
		attrDesc.setLabel("替班日期");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请事由编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_apy_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_apy_reason",  getSd_apy_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请事由编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请事由属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apy_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apy_reason",  getId_apy_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请事由");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_apy_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_apy_status",  getId_apy_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 申请状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_apy_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_apy_status",  getSd_apy_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请状态编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reg_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reg_psn",  getId_reg_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 登记时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_regADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_reg",  getDt_regCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("登记时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 流程任务ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_taskADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_task",  getId_taskCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("流程任务ID");
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
	private IAttrDesc getDesADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Des",  getDesCDesc(tblDesc), this);
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
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_apy",  getName_nur_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b4","id_nur_apy=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psndoc",  getName_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b21","id_psndoc=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请人护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_apy_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_apy_name",  getDep_apy_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dep_apy=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lvl_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lvl_apy",  getName_lvl_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b18","id_nur_lvl_apy=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nhr_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nhr_rp",  getName_nhr_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b6","id_nur_rp=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 替班人护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_rp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_rp_name",  getDep_rp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("替班人护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b7","id_dep_rp=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lvl_rpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lvl_rp",  getName_lvl_rpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b19","id_nur_lvl_rp=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_apy_nhr_siADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_apy_nhr_si",  getName_apy_nhr_siCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NHR_SCHED a0b13","id_nhr_si_apy_old=id_nhr_sched","name_nhr_si"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_apy_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_apy_new",  getName_apy_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a0b14","id_nhr_si_apy_new=id_nhr_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 简称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_short_apy_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_short_apy_new",  getName_short_apy_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("简称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a0b14","id_nhr_si_apy_new=id_nhr_si","name_short"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班班次属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rp_nhr_siADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rp_nhr_si",  getName_rp_nhr_siCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班班次");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NHR_SCHED a0b15","id_nhr_si_rp_old=id_nhr_sched","name_nhr_si"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_rp_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_rp_new",  getName_rp_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a0b16","id_nhr_si_rp_new=id_nhr_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 简称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_short_rp_newADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_short_rp_new",  getName_short_rp_newCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("简称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a0b16","id_nhr_si_rp_new=id_nhr_si","name_short"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_apy_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_apy_reason",  getName_apy_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b17","id_apy_reason=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_apy_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_apy_status",  getName_apy_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b10","id_apy_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 人员姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_audit",  getName_emp_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b20","id_emp_audit=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取替班申请主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_sched_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_sched_rp");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("替班申请主键"); 
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
	 * 获取申请人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_apy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人"); 
		return column;
	}
	/**
	 * 获取人员基本属性(申请人)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员基本属性(申请人)"); 
		return column;
	}
	/**
	 * 获取申请人护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_apy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人护理单元"); 
		return column;
	}
	/**
	 * 获取申请人护士层级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_lvl_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_lvl_apy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人护士层级"); 
		return column;
	}
	/**
	 * 获取申请人护士层级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nur_lvl_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nur_lvl_apy");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人护士层级编码"); 
		return column;
	}
	/**
	 * 获取替班人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_rp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人"); 
		return column;
	}
	/**
	 * 获取替班人护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_rp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人护理单元"); 
		return column;
	}
	/**
	 * 获取替班人护士层级表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_lvl_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_lvl_rp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人护士层级"); 
		return column;
	}
	/**
	 * 获取替班人护士层级编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_nur_lvl_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_nur_lvl_rp");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人护士层级编码"); 
		return column;
	}
	/**
	 * 获取申请人原班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_apy_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_apy_old");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人原班次"); 
		return column;
	}
	/**
	 * 获取申请人新班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_apy_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_apy_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人新班次"); 
		return column;
	}
	/**
	 * 获取替班人原班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_rp_oldCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_rp_old");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人原班次"); 
		return column;
	}
	/**
	 * 获取替班人新班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_si_rp_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si_rp_new");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人新班次"); 
		return column;
	}
	/**
	 * 获取替班日期表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_rp");
		column.setLength(10);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("替班日期"); 
		return column;
	}
	/**
	 * 获取申请事由编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_apy_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_apy_reason");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请事由编码"); 
		return column;
	}
	/**
	 * 获取申请事由表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apy_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apy_reason");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请事由"); 
		return column;
	}
	/**
	 * 获取申请状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_apy_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_apy_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请状态"); 
		return column;
	}
	/**
	 * 获取申请状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_apy_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_apy_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请状态编码"); 
		return column;
	}
	/**
	 * 获取登记人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reg_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reg_psn");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记人"); 
		return column;
	}
	/**
	 * 获取登记时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_regCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_reg");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("登记时间"); 
		return column;
	}
	/**
	 * 获取流程任务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_task");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流程任务ID"); 
		return column;
	}
	/**
	 * 获取备注表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDesCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Des");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("备注"); 
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
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_apy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
		return column;
	}
	/**
	 * 获取人员表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psndoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员"); 
		return column;
	}
	/**
	 * 获取申请人护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_apy_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_apy_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人护理单元"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lvl_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lvl_apy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nhr_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nhr_rp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
		return column;
	}
	/**
	 * 获取替班人护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_rp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_rp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("替班人护理单元"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lvl_rpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lvl_rp");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取排班班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_apy_nhr_siCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_apy_nhr_si");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班班次"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_apy_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_apy_new");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取简称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_short_apy_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_short_apy_new");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("简称"); 
		return column;
	}
	/**
	 * 获取排班班次表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rp_nhr_siCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rp_nhr_si");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班班次"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_rp_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_rp_new");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取简称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_short_rp_newCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_short_rp_new");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("简称"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_apy_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_apy_reason");
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
	private IColumnDesc getName_apy_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_apy_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取人员姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_audit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
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
