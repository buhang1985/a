
package iih.nm.nhr.nmnhrschedlv.d.desc;

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
 * 人员请假申请 DO 元数据信息
 */
public class NmNhrSchedLvDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nhr.nmnhrschedlv.d.NmNhrSchedLvDO";
	public static final String CLASS_DISPALYNAME = "人员请假申请";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "NM_NHR_SCHED_LV";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nhr_sched_lv";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NmNhrSchedLvDODesc(){
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
		this.setKeyDesc(getId_nhr_sched_lvADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nhr_sched_lvADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_psndocADesc(tblDesc));
		this.add(getId_nur_apyADesc(tblDesc));
		this.add(getId_dep_apyADesc(tblDesc));
		this.add(getId_dep_nur_apyADesc(tblDesc));
		this.add(getDt_begin_lvADesc(tblDesc));
		this.add(getDt_end_lvADesc(tblDesc));
		this.add(getDays_lvADesc(tblDesc));
		this.add(getReason_lvADesc(tblDesc));
		this.add(getId_chk_caADesc(tblDesc));
		this.add(getSd_chk_caADesc(tblDesc));
		this.add(getId_nhr_siADesc(tblDesc));
		this.add(getId_apy_statusADesc(tblDesc));
		this.add(getSd_apy_statusADesc(tblDesc));
		this.add(getId_lv_relateADesc(tblDesc));
		this.add(getId_lv_offsetADesc(tblDesc));
		this.add(getId_lv_vaADesc(tblDesc));
		this.add(getSd_lv_vaADesc(tblDesc));
		this.add(getAmpm_lvADesc(tblDesc));
		this.add(getDesADesc(tblDesc));
		this.add(getId_taskADesc(tblDesc));
		this.add(getId_emp_auditADesc(tblDesc));
		this.add(getDt_auditADesc(tblDesc));
		this.add(getApcommentsADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_psndocADesc(tblDesc));
		this.add(getName_nur_apyADesc(tblDesc));
		this.add(getJob_no_nur_apyADesc(tblDesc));
		this.add(getName_dep_apyADesc(tblDesc));
		this.add(getId_parent_dep_apyADesc(tblDesc));
		this.add(getName_dep_nur_apyADesc(tblDesc));
		this.add(getName_chk_caADesc(tblDesc));
		this.add(getName_nhr_siADesc(tblDesc));
		this.add(getName_apy_statusADesc(tblDesc));
		this.add(getDt_begin_lv_lv_relateADesc(tblDesc));
		this.add(getDt_end_lv_lv_relateADesc(tblDesc));
		this.add(getDays_lv_lv_relateADesc(tblDesc));
		this.add(getDt_end_lv_lv_offsetADesc(tblDesc));
		this.add(getDt_begin_lv_lv_offsetADesc(tblDesc));
		this.add(getName_lv_vaADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nhr_sched_lvCDesc(tblDesc));
		tblDesc.add(getId_nhr_sched_lvCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_psndocCDesc(tblDesc));
		tblDesc.add(getId_nur_apyCDesc(tblDesc));
		tblDesc.add(getId_dep_apyCDesc(tblDesc));
		tblDesc.add(getId_dep_nur_apyCDesc(tblDesc));
		tblDesc.add(getDt_begin_lvCDesc(tblDesc));
		tblDesc.add(getDt_end_lvCDesc(tblDesc));
		tblDesc.add(getDays_lvCDesc(tblDesc));
		tblDesc.add(getReason_lvCDesc(tblDesc));
		tblDesc.add(getId_chk_caCDesc(tblDesc));
		tblDesc.add(getSd_chk_caCDesc(tblDesc));
		tblDesc.add(getId_nhr_siCDesc(tblDesc));
		tblDesc.add(getId_apy_statusCDesc(tblDesc));
		tblDesc.add(getSd_apy_statusCDesc(tblDesc));
		tblDesc.add(getId_lv_relateCDesc(tblDesc));
		tblDesc.add(getId_lv_offsetCDesc(tblDesc));
		tblDesc.add(getId_lv_vaCDesc(tblDesc));
		tblDesc.add(getSd_lv_vaCDesc(tblDesc));
		tblDesc.add(getAmpm_lvCDesc(tblDesc));
		tblDesc.add(getDesCDesc(tblDesc));
		tblDesc.add(getId_taskCDesc(tblDesc));
		tblDesc.add(getId_emp_auditCDesc(tblDesc));
		tblDesc.add(getDt_auditCDesc(tblDesc));
		tblDesc.add(getApcommentsCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 人员请假申请主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_sched_lvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_sched_lv",  getId_nhr_sched_lvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员请假申请主键");
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
	 * 人员id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_psndoc",  getId_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员id");
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
	 * 申请人关联科室属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_apy",  getId_dep_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请人关联科室");
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
	private IAttrDesc getId_dep_nur_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur_apy",  getId_dep_nur_apyCDesc(tblDesc), this);
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
	 * 请假开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_begin_lvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_begin_lv",  getDt_begin_lvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请假开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请假结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_end_lvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end_lv",  getDt_end_lvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请假结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_lvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_lv",  getDays_lvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("申请天数");
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
	private IAttrDesc getReason_lvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reason_lv",  getReason_lvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请事由");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_chk_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_chk_ca",  getId_chk_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 考勤类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_chk_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_chk_ca",  getSd_chk_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 排班班次外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nhr_siADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nhr_si",  getId_nhr_siCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("排班班次外键");
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
	 * 关联的请假属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lv_relateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lv_relate",  getId_lv_relateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("关联的请假");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 冲销的请假属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lv_offsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lv_offset",  getId_lv_offsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("冲销的请假");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请假分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_lv_vaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_lv_va",  getId_lv_vaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请假分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 请假分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_lv_vaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_lv_va",  getSd_lv_vaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请假分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 开始时间上下午属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAmpm_lvADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Ampm_lv",  getAmpm_lvCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("开始时间上下午");
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
	 * 审核人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emp_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emp_audit",  getId_emp_auditCDesc(tblDesc), this);
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
	private IAttrDesc getDt_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_audit",  getDt_auditCDesc(tblDesc), this);
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
	 * 审核意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getApcommentsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Apcomments",  getApcommentsCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核意见");
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
	private IAttrDesc getName_psndocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_psndoc",  getName_psndocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("人员姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b15","id_psndoc=id_psndoc","name"});
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
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b5","id_nur_apy=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getJob_no_nur_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Job_no_nur_apy",  getJob_no_nur_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("工号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b5","id_nur_apy=id_nur","job_no"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 部门名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_apy",  getName_dep_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("部门名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b6","id_dep_apy=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上级部门属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_parent_dep_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_parent_dep_apy",  getId_parent_dep_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上级部门");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b6","id_dep_apy=id_dep","id_parent"});
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理单元名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nur_apyADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur_apy",  getName_dep_nur_apyCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NBD_DEP a0b16","id_dep_nur_apy=id_nbd_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 考勤类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_chk_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_chk_ca",  getName_chk_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("考勤类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b4","id_chk_ca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nhr_siADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nhr_si",  getName_nhr_siCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"nm_nhr_si a0b7","id_nhr_si=id_nhr_si","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_apy_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_apy_status",  getName_apy_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("申请状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_apy_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请假开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_begin_lv_lv_relateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_begin_lv_lv_relate",  getDt_begin_lv_lv_relateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请假开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NHR_SCHED_LV a0b10","id_lv_relate=id_nhr_sched_lv","dt_begin_lv"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请假结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_end_lv_lv_relateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end_lv_lv_relate",  getDt_end_lv_lv_relateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请假结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NHR_SCHED_LV a0b10","id_lv_relate=id_nhr_sched_lv","dt_end_lv"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 申请天数属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDays_lv_lv_relateADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Days_lv_lv_relate",  getDays_lv_lv_relateCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("申请天数");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NHR_SCHED_LV a0b10","id_lv_relate=id_nhr_sched_lv","days_lv"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请假结束时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_end_lv_lv_offsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_end_lv_lv_offset",  getDt_end_lv_lv_offsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请假结束时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NHR_SCHED_LV a0b11","id_lv_offset=id_nhr_sched_lv","dt_end_lv"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请假开始时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_begin_lv_lv_offsetADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_begin_lv_lv_offset",  getDt_begin_lv_lv_offsetCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("请假开始时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NHR_SCHED_LV a0b11","id_lv_offset=id_nhr_sched_lv","dt_begin_lv"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 请假分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_lv_vaADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_lv_va",  getName_lv_vaCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("请假分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_lv_va=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审批人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emp_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emp_audit",  getName_emp_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审批人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_psndoc a0b14","id_emp_audit=id_psndoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取人员请假申请主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_sched_lvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_sched_lv");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("人员请假申请主键"); 
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
	 * 获取人员id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_psndoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员id"); 
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
	 * 获取申请人关联科室表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_apy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人关联科室"); 
		return column;
	}
	/**
	 * 获取申请人护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nur_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur_apy");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请人护理单元"); 
		return column;
	}
	/**
	 * 获取请假开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_begin_lvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin_lv");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请假开始时间"); 
		return column;
	}
	/**
	 * 获取请假结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_end_lvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end_lv");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请假结束时间"); 
		return column;
	}
	/**
	 * 获取申请天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_lvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_lv");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("申请天数"); 
		return column;
	}
	/**
	 * 获取申请事由表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReason_lvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reason_lv");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请事由"); 
		return column;
	}
	/**
	 * 获取考勤类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_chk_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_chk_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤类型"); 
		return column;
	}
	/**
	 * 获取考勤类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_chk_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_chk_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤类型编码"); 
		return column;
	}
	/**
	 * 获取排班班次外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nhr_siCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nhr_si");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("排班班次外键"); 
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
	 * 获取关联的请假表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lv_relateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lv_relate");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("关联的请假"); 
		return column;
	}
	/**
	 * 获取冲销的请假表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lv_offsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lv_offset");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("冲销的请假"); 
		return column;
	}
	/**
	 * 获取请假分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_lv_vaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_lv_va");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请假分类"); 
		return column;
	}
	/**
	 * 获取请假分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_lv_vaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_lv_va");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请假分类编码"); 
		return column;
	}
	/**
	 * 获取开始时间上下午表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAmpm_lvCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Ampm_lv");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("开始时间上下午"); 
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
	 * 获取流程任务ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_taskCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_task");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("流程任务ID"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emp_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emp_audit");
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
	private IColumnDesc getDt_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_audit");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("审核时间"); 
		return column;
	}
	/**
	 * 获取审核意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getApcommentsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Apcomments");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核意见"); 
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
	private IColumnDesc getName_psndocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_psndoc");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("人员姓名"); 
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
	 * 获取工号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getJob_no_nur_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Job_no_nur_apy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("工号"); 
		return column;
	}
	/**
	 * 获取部门名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_apy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("部门名称"); 
		return column;
	}
	/**
	 * 获取上级部门表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_parent_dep_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_parent_dep_apy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上级部门"); 
		return column;
	}
	/**
	 * 获取护理单元名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nur_apyCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur_apy");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元名称"); 
		return column;
	}
	/**
	 * 获取考勤类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_chk_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_chk_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("考勤类型"); 
		return column;
	}
	/**
	 * 获取名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nhr_siCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nhr_si");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取申请状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_apy_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_apy_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("申请状态"); 
		return column;
	}
	/**
	 * 获取请假开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_begin_lv_lv_relateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin_lv_lv_relate");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请假开始时间"); 
		return column;
	}
	/**
	 * 获取请假结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_end_lv_lv_relateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end_lv_lv_relate");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请假结束时间"); 
		return column;
	}
	/**
	 * 获取申请天数表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDays_lv_lv_relateCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Days_lv_lv_relate");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("申请天数"); 
		return column;
	}
	/**
	 * 获取请假结束时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_end_lv_lv_offsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_end_lv_lv_offset");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请假结束时间"); 
		return column;
	}
	/**
	 * 获取请假开始时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_begin_lv_lv_offsetCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_begin_lv_lv_offset");
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("请假开始时间"); 
		return column;
	}
	/**
	 * 获取请假分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_lv_vaCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_lv_va");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("请假分类"); 
		return column;
	}
	/**
	 * 获取审批人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emp_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emp_audit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审批人"); 
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
