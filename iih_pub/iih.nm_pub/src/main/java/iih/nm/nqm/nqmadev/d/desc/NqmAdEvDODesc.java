
package iih.nm.nqm.nqmadev.d.desc;

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
 * 不良事件 DO 元数据信息
 */
public class NqmAdEvDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.nm.nqm.nqmadev.d.NqmAdEvDO";
	public static final String CLASS_DISPALYNAME = "不良事件";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "nm_nqm_adev";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_nqm_adev";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public NqmAdEvDODesc(){
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
		this.setKeyDesc(getId_nqm_adevADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_nqm_adevADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_nur_psnADesc(tblDesc));
		this.add(getId_dep_nurADesc(tblDesc));
		this.add(getId_emptitleADesc(tblDesc));
		this.add(getSd_emptitleADesc(tblDesc));
		this.add(getWkyearADesc(tblDesc));
		this.add(getDt_occurADesc(tblDesc));
		this.add(getId_monthADesc(tblDesc));
		this.add(getSd_monthADesc(tblDesc));
		this.add(getId_adev_caADesc(tblDesc));
		this.add(getSd_adev_caADesc(tblDesc));
		this.add(getAdev_ca_otherADesc(tblDesc));
		this.add(getDescribeADesc(tblDesc));
		this.add(getId_reason_caADesc(tblDesc));
		this.add(getSd_reason_caADesc(tblDesc));
		this.add(getDep_reasonADesc(tblDesc));
		this.add(getPsn_reasonADesc(tblDesc));
		this.add(getReasonADesc(tblDesc));
		this.add(getHandsuggestADesc(tblDesc));
		this.add(getImpro_measADesc(tblDesc));
		this.add(getNur_dep_opinADesc(tblDesc));
		this.add(getId_nur_headADesc(tblDesc));
		this.add(getId_depnur_psnADesc(tblDesc));
		this.add(getId_report_psnADesc(tblDesc));
		this.add(getDt_reportADesc(tblDesc));
		this.add(getId_taskADesc(tblDesc));
		this.add(getId_audit_statusADesc(tblDesc));
		this.add(getSd_audit_statusADesc(tblDesc));
		this.add(getId_audit_psnADesc(tblDesc));
		this.add(getDt_auditADesc(tblDesc));
		this.add(getAudit_commentsADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getName_nur_psnADesc(tblDesc));
		this.add(getName_dep_nurADesc(tblDesc));
		this.add(getName_emptitleADesc(tblDesc));
		this.add(getName_monthADesc(tblDesc));
		this.add(getName_adev_caADesc(tblDesc));
		this.add(getName_reason_caADesc(tblDesc));
		this.add(getName_nur_headADesc(tblDesc));
		this.add(getNameADesc(tblDesc));
		this.add(getName_report_psnADesc(tblDesc));
		this.add(getName_audit_statusADesc(tblDesc));
		this.add(getName_auditADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_nqm_adevCDesc(tblDesc));
		tblDesc.add(getId_nqm_adevCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_nur_psnCDesc(tblDesc));
		tblDesc.add(getId_dep_nurCDesc(tblDesc));
		tblDesc.add(getId_emptitleCDesc(tblDesc));
		tblDesc.add(getSd_emptitleCDesc(tblDesc));
		tblDesc.add(getWkyearCDesc(tblDesc));
		tblDesc.add(getDt_occurCDesc(tblDesc));
		tblDesc.add(getId_monthCDesc(tblDesc));
		tblDesc.add(getSd_monthCDesc(tblDesc));
		tblDesc.add(getId_adev_caCDesc(tblDesc));
		tblDesc.add(getSd_adev_caCDesc(tblDesc));
		tblDesc.add(getAdev_ca_otherCDesc(tblDesc));
		tblDesc.add(getDescribeCDesc(tblDesc));
		tblDesc.add(getId_reason_caCDesc(tblDesc));
		tblDesc.add(getSd_reason_caCDesc(tblDesc));
		tblDesc.add(getDep_reasonCDesc(tblDesc));
		tblDesc.add(getPsn_reasonCDesc(tblDesc));
		tblDesc.add(getReasonCDesc(tblDesc));
		tblDesc.add(getHandsuggestCDesc(tblDesc));
		tblDesc.add(getImpro_measCDesc(tblDesc));
		tblDesc.add(getNur_dep_opinCDesc(tblDesc));
		tblDesc.add(getId_nur_headCDesc(tblDesc));
		tblDesc.add(getId_depnur_psnCDesc(tblDesc));
		tblDesc.add(getId_report_psnCDesc(tblDesc));
		tblDesc.add(getDt_reportCDesc(tblDesc));
		tblDesc.add(getId_taskCDesc(tblDesc));
		tblDesc.add(getId_audit_statusCDesc(tblDesc));
		tblDesc.add(getSd_audit_statusCDesc(tblDesc));
		tblDesc.add(getId_audit_psnCDesc(tblDesc));
		tblDesc.add(getDt_auditCDesc(tblDesc));
		tblDesc.add(getAudit_commentsCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 不良事件主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nqm_adevADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nqm_adev",  getId_nqm_adevCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件主键");
		attrDesc.setNullable(false);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_orgADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_org",  getId_orgCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 集团id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_grpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_grp",  getId_grpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("集团id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 当事人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_psn",  getId_nur_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当事人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_dep_nur",  getId_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_emptitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_emptitle",  getId_emptitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 职称编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_emptitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_emptitle",  getSd_emptitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 工作年限属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getWkyearADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Wkyear",  getWkyearCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDouble);
		attrDesc.setLabel("工作年限");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发生时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_occurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_occur",  getDt_occurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("发生时间");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 发生月份ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_month",  getId_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生月份ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 发生月份编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_month",  getSd_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("发生月份编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件分类id属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_adev_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_adev_ca",  getId_adev_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件分类id");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 不良事件分类编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_adev_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_adev_ca",  getSd_adev_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件分类编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 其他分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getAdev_ca_otherADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Adev_ca_other",  getAdev_ca_otherCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("其他分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件经过及后果属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDescribeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Describe",  getDescribeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件经过及后果");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原因分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_reason_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_reason_ca",  getId_reason_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原因分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 原因分析编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_reason_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_reason_ca",  getSd_reason_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原因分析编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 科室管理因素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDep_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dep_reason",  getDep_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("科室管理因素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 个人因素属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getPsn_reasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Psn_reason",  getPsn_reasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("个人因素");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 原因分析属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReasonADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reason",  getReasonCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("原因分析");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 处理意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getHandsuggestADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Handsuggest",  getHandsuggestCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("处理意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 改进措施属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getImpro_measADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Impro_meas",  getImpro_measCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("改进措施");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理部意见属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNur_dep_opinADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Nur_dep_opin",  getNur_dep_opinCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理部意见");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士长签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_nur_headADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_nur_head",  getId_nur_headCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士长签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 护理部签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_depnur_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_depnur_psn",  getId_depnur_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理部签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 上报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_report_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_report_psn",  getId_report_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 上报时间属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getDt_reportADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Dt_report",  getDt_reportCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FDateTime);
		attrDesc.setLabel("上报时间");
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
	 * 上报审核状态ID属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_audit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_audit_status",  getId_audit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上报审核状态ID");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 上报审核状态编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSd_audit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sd_audit_status",  getSd_audit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上报审核状态编码");
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
	private IAttrDesc getId_audit_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_audit_psn",  getId_audit_psnCDesc(tblDesc), this);
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
	private IAttrDesc getAudit_commentsADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Audit_comments",  getAudit_commentsCDesc(tblDesc), this);
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
	 * 当事人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_psn",  getName_nur_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("当事人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b4","id_nur_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理单元属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_dep_nurADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_dep_nur",  getName_dep_nurCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理单元");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_dep a0b5","id_dep_nur=id_dep","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 职称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_emptitleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_emptitle",  getName_emptitleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("职称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b6","id_emptitle=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 月份属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_monthADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_month",  getName_monthCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("月份");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b16","id_month=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_adev_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_adev_ca",  getName_adev_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b7","id_adev_ca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 不良事件原因分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_reason_caADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_reason_ca",  getName_reason_caCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("不良事件原因分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b8","id_reason_ca=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护士长签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_nur_headADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_nur_head",  getName_nur_headCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护士长签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b9","id_nur_head=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 护理部签名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getNameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name",  getNameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("护理部签名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b10","id_depnur_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上报人属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_report_psnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_report_psn",  getName_report_psnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上报人");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b11","id_report_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 上报状态属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_audit_statusADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_audit_status",  getName_audit_statusCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("上报状态");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b14","id_audit_status=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 审核人姓名属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_auditADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_audit",  getName_auditCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("审核人姓名");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"NM_NUR a0b15","id_audit_psn=id_nur","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取不良事件主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nqm_adevCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nqm_adev");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("不良事件主键"); 
		return column;
	}
	/**
	 * 获取组织id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_orgCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_org");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织id"); 
		return column;
	}
	/**
	 * 获取集团id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_grpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_grp");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("集团id"); 
		return column;
	}
	/**
	 * 获取当事人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当事人"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_dep_nur");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_emptitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_emptitle");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称"); 
		return column;
	}
	/**
	 * 获取职称编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_emptitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_emptitle");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称编码"); 
		return column;
	}
	/**
	 * 获取工作年限表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getWkyearCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Wkyear");
		column.setLength(16);
        column.setPrecision(2);
        column.setSqlType(Types.DECIMAL);
		column.setNullable(true);
		column.setLabel("工作年限"); 
		return column;
	}
	/**
	 * 获取发生时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_occurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_occur");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("发生时间"); 
		return column;
	}
	/**
	 * 获取发生月份ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_month");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生月份ID"); 
		return column;
	}
	/**
	 * 获取发生月份编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_month");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("发生月份编码"); 
		return column;
	}
	/**
	 * 获取不良事件分类id表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_adev_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_adev_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件分类id"); 
		return column;
	}
	/**
	 * 获取不良事件分类编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_adev_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_adev_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件分类编码"); 
		return column;
	}
	/**
	 * 获取其他分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getAdev_ca_otherCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Adev_ca_other");
		column.setLength(150);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("其他分类"); 
		return column;
	}
	/**
	 * 获取不良事件经过及后果表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDescribeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Describe");
		column.setLength(1000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件经过及后果"); 
		return column;
	}
	/**
	 * 获取原因分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_reason_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_reason_ca");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原因分类"); 
		return column;
	}
	/**
	 * 获取原因分析编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_reason_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_reason_ca");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原因分析编码"); 
		return column;
	}
	/**
	 * 获取科室管理因素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDep_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dep_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("科室管理因素"); 
		return column;
	}
	/**
	 * 获取个人因素表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getPsn_reasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Psn_reason");
		column.setLength(300);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("个人因素"); 
		return column;
	}
	/**
	 * 获取原因分析表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReasonCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reason");
		column.setLength(500);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("原因分析"); 
		return column;
	}
	/**
	 * 获取处理意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getHandsuggestCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Handsuggest");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("处理意见"); 
		return column;
	}
	/**
	 * 获取改进措施表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getImpro_measCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Impro_meas");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("改进措施"); 
		return column;
	}
	/**
	 * 获取护理部意见表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNur_dep_opinCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Nur_dep_opin");
		column.setLength(600);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理部意见"); 
		return column;
	}
	/**
	 * 获取护士长签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_nur_headCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_nur_head");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士长签名"); 
		return column;
	}
	/**
	 * 获取护理部签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_depnur_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_depnur_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理部签名"); 
		return column;
	}
	/**
	 * 获取上报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_report_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_report_psn");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上报人"); 
		return column;
	}
	/**
	 * 获取上报时间表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getDt_reportCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Dt_report");
		column.setLength(19);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("上报时间"); 
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
	 * 获取上报审核状态ID表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_audit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_audit_status");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上报审核状态ID"); 
		return column;
	}
	/**
	 * 获取上报审核状态编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSd_audit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sd_audit_status");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上报审核状态编码"); 
		return column;
	}
	/**
	 * 获取审核人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_audit_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_audit_psn");
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
	private IColumnDesc getAudit_commentsCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Audit_comments");
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
	 * 获取当事人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("当事人"); 
		return column;
	}
	/**
	 * 获取护理单元表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_dep_nurCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_dep_nur");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理单元"); 
		return column;
	}
	/**
	 * 获取职称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_emptitleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_emptitle");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("职称"); 
		return column;
	}
	/**
	 * 获取月份表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_monthCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_month");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("月份"); 
		return column;
	}
	/**
	 * 获取不良事件分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_adev_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_adev_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件分类"); 
		return column;
	}
	/**
	 * 获取不良事件原因分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_reason_caCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_reason_ca");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("不良事件原因分类"); 
		return column;
	}
	/**
	 * 获取护士长签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_nur_headCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_nur_head");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护士长签名"); 
		return column;
	}
	/**
	 * 获取护理部签名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getNameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("护理部签名"); 
		return column;
	}
	/**
	 * 获取上报人表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_report_psnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_report_psn");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上报人"); 
		return column;
	}
	/**
	 * 获取上报状态表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_audit_statusCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_audit_status");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("上报状态"); 
		return column;
	}
	/**
	 * 获取审核人姓名表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_auditCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_audit");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("审核人姓名"); 
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
