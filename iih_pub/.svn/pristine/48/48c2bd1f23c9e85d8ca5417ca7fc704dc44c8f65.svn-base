
package iih.bd.srv.mrtaskrule.d.desc;

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
 * 病历书写任务配置 DO 元数据信息
 */
public class MrTaskRuleDODesc extends DODesc {
	public static final String CLASS_FULLNAME = "iih.bd.srv.mrtaskrule.d.MrTaskRuleDO";
	public static final String CLASS_DISPALYNAME = "病历书写任务配置";
	public static final String CLASS_RESID = "";
	public static final String CLASS_RESMODULE = "";
	public static final String TABLE_NAME = "bd_mr_task_rule";
	public static final String TABLE_ALIAS_NAME = "a0";
	public static final String PRIMARYKEY_FIELDNAME="Id_mr_task_rule";
	private ColumnDesc dsColumn=null;
	private ColumnDesc svColumn=null;
	
	/**
	 * 无参构造函数
	 */
	public MrTaskRuleDODesc(){
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
		this.setKeyDesc(getId_mr_task_ruleADesc(tblDesc));
		this.setIBDDataInfoFldMap();
		this.setIAuditInfoFldMap();
		this.setDefaultValueMap();
		this.add(getId_mr_task_ruleADesc(tblDesc));
		this.add(getId_grpADesc(tblDesc));
		this.add(getId_orgADesc(tblDesc));
		this.add(getId_mrcactmADesc(tblDesc));
		this.add(getId_mrtpADesc(tblDesc));
		this.add(getId_mrtp_changeADesc(tblDesc));
		this.add(getFg_changeADesc(tblDesc));
		this.add(getTiptextADesc(tblDesc));
		this.add(getId_udidocADesc(tblDesc));
		this.add(getCode_udidocADesc(tblDesc));
		this.add(getFg_activeADesc(tblDesc));
		this.add(getLimittimeADesc(tblDesc));
		this.add(getFg_returnADesc(tblDesc));
		this.add(getCreatedbyADesc(tblDesc));
		this.add(getCreatedtimeADesc(tblDesc));
		this.add(getModifiedbyADesc(tblDesc));
		this.add(getModifiedtimeADesc(tblDesc));
		this.add(getSortnoADesc(tblDesc));
		this.add(getId_evtADesc(tblDesc));
		this.add(getSrcname_evtADesc(tblDesc));
		this.add(getSrccode_evtADesc(tblDesc));
		this.add(getCode_evtADesc(tblDesc));
		this.add(getName_evtADesc(tblDesc));
		this.add(getEvt_typeADesc(tblDesc));
		this.add(getId_evt_cancelADesc(tblDesc));
		this.add(getSrcname_evt_cancelADesc(tblDesc));
		this.add(getSrcode_evt_cancelADesc(tblDesc));
		this.add(getCode_evt_cancelADesc(tblDesc));
		this.add(getName_evt_cancelADesc(tblDesc));
		this.add(getEvt_cancel_typeADesc(tblDesc));
		this.add(getId_tmplADesc(tblDesc));
		this.add(getCode_tmplADesc(tblDesc));
		this.add(getName_tmplADesc(tblDesc));
		this.add(getTimeout_reminderADesc(tblDesc));
		this.add(getReminder_time_limitADesc(tblDesc));
		this.add(getTimeout_colorADesc(tblDesc));
		this.add(getTask_generationADesc(tblDesc));
		this.add(getId_tmpl_remindADesc(tblDesc));
		this.add(getCode_tmpl_remindADesc(tblDesc));
		this.add(getName_tmpl_remindADesc(tblDesc));
		this.add(getGrp_codeADesc(tblDesc));
		this.add(getGrp_nameADesc(tblDesc));
		this.add(getOrg_codeADesc(tblDesc));
		this.add(getOrg_nameADesc(tblDesc));
		this.add(getMr_codeADesc(tblDesc));
		this.add(getMr_nameADesc(tblDesc));
		this.add(getMrtp_codeADesc(tblDesc));
		this.add(getMrtp_nameADesc(tblDesc));
		this.add(getMrtp_change_codeADesc(tblDesc));
		this.add(getMrtp_change_nameADesc(tblDesc));
		this.add(getUdidoc_codeADesc(tblDesc));
		this.add(getUdidoc_nameADesc(tblDesc));
		this.add(getEvt_typecodeADesc(tblDesc));
		this.add(getEvt_typenameADesc(tblDesc));
		this.add(getEvt_srcnameADesc(tblDesc));
		this.add(getEvt_cancel_srcnameADesc(tblDesc));
		this.add(getEvt_cancel_typenameADesc(tblDesc));
		this.add(getEvt_cancel_typecodeADesc(tblDesc));
		this.add(getTmpl_nameADesc(tblDesc));
		this.add(getTmpl_codeADesc(tblDesc));
		this.add(getTmpl_remind_codeADesc(tblDesc));
		this.add(getTmpl_remind_nameADesc(tblDesc));
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
		tblDesc.setPrimaryKey(getId_mr_task_ruleCDesc(tblDesc));
		tblDesc.add(getId_mr_task_ruleCDesc(tblDesc));
		tblDesc.add(getId_grpCDesc(tblDesc));
		tblDesc.add(getId_orgCDesc(tblDesc));
		tblDesc.add(getId_mrcactmCDesc(tblDesc));
		tblDesc.add(getId_mrtpCDesc(tblDesc));
		tblDesc.add(getId_mrtp_changeCDesc(tblDesc));
		tblDesc.add(getFg_changeCDesc(tblDesc));
		tblDesc.add(getTiptextCDesc(tblDesc));
		tblDesc.add(getId_udidocCDesc(tblDesc));
		tblDesc.add(getCode_udidocCDesc(tblDesc));
		tblDesc.add(getFg_activeCDesc(tblDesc));
		tblDesc.add(getLimittimeCDesc(tblDesc));
		tblDesc.add(getFg_returnCDesc(tblDesc));
		tblDesc.add(getCreatedbyCDesc(tblDesc));
		tblDesc.add(getCreatedtimeCDesc(tblDesc));
		tblDesc.add(getModifiedbyCDesc(tblDesc));
		tblDesc.add(getModifiedtimeCDesc(tblDesc));
		tblDesc.add(getSortnoCDesc(tblDesc));
		tblDesc.add(getId_evtCDesc(tblDesc));
		tblDesc.add(getSrcname_evtCDesc(tblDesc));
		tblDesc.add(getSrccode_evtCDesc(tblDesc));
		tblDesc.add(getCode_evtCDesc(tblDesc));
		tblDesc.add(getName_evtCDesc(tblDesc));
		tblDesc.add(getEvt_typeCDesc(tblDesc));
		tblDesc.add(getId_evt_cancelCDesc(tblDesc));
		tblDesc.add(getSrcname_evt_cancelCDesc(tblDesc));
		tblDesc.add(getSrcode_evt_cancelCDesc(tblDesc));
		tblDesc.add(getCode_evt_cancelCDesc(tblDesc));
		tblDesc.add(getName_evt_cancelCDesc(tblDesc));
		tblDesc.add(getEvt_cancel_typeCDesc(tblDesc));
		tblDesc.add(getId_tmplCDesc(tblDesc));
		tblDesc.add(getCode_tmplCDesc(tblDesc));
		tblDesc.add(getName_tmplCDesc(tblDesc));
		tblDesc.add(getTimeout_reminderCDesc(tblDesc));
		tblDesc.add(getReminder_time_limitCDesc(tblDesc));
		tblDesc.add(getTimeout_colorCDesc(tblDesc));
		tblDesc.add(getTask_generationCDesc(tblDesc));
		tblDesc.add(getId_tmpl_remindCDesc(tblDesc));
		tblDesc.add(getCode_tmpl_remindCDesc(tblDesc));
		tblDesc.add(getName_tmpl_remindCDesc(tblDesc));
		dsColumn=new DsColumn(tblDesc);
		svColumn=new SvColumn(tblDesc);
	
		return tblDesc;
	}
	
	/**
	 * 病历书写任务配置主键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mr_task_ruleADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mr_task_rule",  getId_mr_task_ruleCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历书写任务配置主键");
		attrDesc.setNullable(false);
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
	 * 医疗记录自定义分类属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrcactmADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrcactm",  getId_mrcactmCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录自定义分类");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 医疗记录类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtpADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp",  getId_mrtpCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 可替代医疗记录类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_mrtp_changeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_mrtp_change",  getId_mrtp_changeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可替代医疗记录类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 是否替换属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_changeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_change",  getFg_changeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否替换");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 提醒文本属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTiptextADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tiptext",  getTiptextCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("提醒文本");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 病历书写任务触发事件属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_udidocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_udidoc",  getId_udidocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("病历书写任务触发事件");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 主类型code值属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_udidocADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_udidoc",  getCode_udidocCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("主类型code值");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否启用属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_activeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_active",  getFg_activeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否启用");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 期限时间（小时）属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getLimittimeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Limittime",  getLimittimeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("期限时间（小时）");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 是否可逆属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getFg_returnADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Fg_return",  getFg_returnCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.FBoolean);
		attrDesc.setLabel("是否可逆");
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
	 * 序号属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSortnoADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Sortno",  getSortnoCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("序号");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_evtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_evt",  getId_evtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务事件外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 业务事件源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrcname_evtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srcname_evt",  getSrcname_evtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务事件源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务事件源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrccode_evtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srccode_evt",  getSrccode_evtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务事件源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务事件类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_evtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_evt",  getCode_evtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务事件类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 业务事件类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_evtADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_evt",  getName_evtCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("业务事件类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_type",  getEvt_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可逆业务事件外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_evt_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_evt_cancel",  getId_evt_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可逆业务事件外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 可逆业务事件源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrcname_evt_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srcname_evt_cancel",  getSrcname_evt_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可逆业务事件源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可逆业务事件源编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getSrcode_evt_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Srcode_evt_cancel",  getSrcode_evt_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可逆业务事件源编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可逆业务事件编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_evt_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_evt_cancel",  getCode_evt_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可逆业务事件编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可逆业务事件名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_evt_cancelADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_evt_cancel",  getName_evt_cancelCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可逆业务事件名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 可逆事件类型属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_cancel_typeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_cancel_type",  getEvt_cancel_typeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("可逆事件类型");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自动创建模板外键属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tmpl",  getId_tmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自动创建模板外键");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 自动创建模板编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_tmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_tmpl",  getCode_tmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自动创建模板编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 自动创建模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tmplADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tmpl",  getName_tmplCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("自动创建模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超时提醒属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimeout_reminderADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Timeout_reminder",  getTimeout_reminderCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超时提醒");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 超时提醒时限(分钟)属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getReminder_time_limitADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Reminder_time_limit",  getReminder_time_limitCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("超时提醒时限(分钟)");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超时任务前景色属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTimeout_colorADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Timeout_color",  getTimeout_colorCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超时任务前景色");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 任务生成属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTask_generationADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Task_generation",  getTask_generationCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("任务生成");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 超时提醒病历模板属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getId_tmpl_remindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Id_tmpl_remind",  getId_tmpl_remindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超时提醒病历模板");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(true);
		return attrDesc;
	}
	/**
	 * 超时提醒病历模编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getCode_tmpl_remindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Code_tmpl_remind",  getCode_tmpl_remindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超时提醒病历模编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 超时提醒病历模名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getName_tmpl_remindADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Name_tmpl_remind",  getName_tmpl_remindCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("超时提醒病历模名称");
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
	private IAttrDesc getGrp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_code",  getGrp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b3","id_grp=id_grp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getGrp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Grp_name",  getGrp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_grp a0b3","id_grp=id_grp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_code",  getOrg_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b4","id_org=id_org","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 组织名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getOrg_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Org_name",  getOrg_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("组织名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_org a0b4","id_org=id_org","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_code",  getMr_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrca_ctm a0b2","id_mrcactm=id_mrcactm","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMr_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mr_name",  getMr_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrca_ctm a0b2","id_mrcactm=id_mrcactm","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtp_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtp_code",  getMrtp_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b7","id_mrtp=id_mrtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtp_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtp_name",  getMrtp_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b7","id_mrtp=id_mrtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtp_change_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtp_change_code",  getMrtp_change_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b8","id_mrtp_change=id_mrtp","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getMrtp_change_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Mrtp_change_name",  getMrtp_change_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtp a0b8","id_mrtp_change=id_mrtp","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUdidoc_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Udidoc_code",  getUdidoc_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_udidoc=id_udidoc","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getUdidoc_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Udidoc_name",  getUdidoc_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_udidoc a0b9","id_udidoc=id_udidoc","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_typecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_typecode",  getEvt_typecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_eventtype a0b10","id_evt=id_eventtype","eventtypecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_typenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_typename",  getEvt_typenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_eventtype a0b10","id_evt=id_eventtype","eventtypename"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_srcnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_srcname",  getEvt_srcnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_eventtype a0b10","id_evt=id_eventtype","srcname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件源名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_cancel_srcnameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_cancel_srcname",  getEvt_cancel_srcnameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件源名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_eventtype a0b11","id_evt_cancel=id_eventtype","srcname"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类型名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_cancel_typenameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_cancel_typename",  getEvt_cancel_typenameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("事件类型名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_eventtype a0b11","id_evt_cancel=id_eventtype","eventtypename"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 事件类型编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getEvt_cancel_typecodeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Evt_cancel_typecode",  getEvt_cancel_typecodeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.Integer);
		attrDesc.setLabel("事件类型编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"sys_eventtype a0b11","id_evt_cancel=id_eventtype","eventtypecode"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTmpl_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tmpl_name",  getTmpl_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl a0b12","id_tmpl=id_mrtpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTmpl_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tmpl_code",  getTmpl_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl a0b12","id_tmpl=id_mrtpl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板编码属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTmpl_remind_codeADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tmpl_remind_code",  getTmpl_remind_codeCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板编码");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl a0b13","id_tmpl_remind=id_mrtpl","code"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 医疗记录模板名称属性元数据
	 * @param tblDesc
	 * @return
	 */
	private IAttrDesc getTmpl_remind_nameADesc(ITableDesc tblDesc){
		Attr attrDesc=new Attr("Tmpl_remind_name",  getTmpl_remind_nameCDesc(tblDesc), this);
		attrDesc.setJavaType(FType.String);
		attrDesc.setLabel("医疗记录模板名称");
		attrDesc.setNullable(true);
		attrDesc.setPersistence(true);
		attrDesc.setSerializable(true);
		attrDesc.setStatic(false);
		attrDesc.setRefTblInfos(new String[]{"bd_mrtpl a0b13","id_tmpl_remind=id_mrtpl","name"});
		attrDesc.setRefType(false);
		return attrDesc;
	}
	/**
	 * 获取病历书写任务配置主键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mr_task_ruleCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mr_task_rule");
		column.setLength(20);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("病历书写任务配置主键"); 
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
	 * 获取医疗记录自定义分类表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrcactmCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrcactm");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录自定义分类"); 
		return column;
	}
	/**
	 * 获取医疗记录类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtpCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型"); 
		return column;
	}
	/**
	 * 获取可替代医疗记录类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_mrtp_changeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_mrtp_change");
		column.setLength(2000);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可替代医疗记录类型"); 
		return column;
	}
	/**
	 * 获取是否替换表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_changeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_change");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否替换"); 
		return column;
	}
	/**
	 * 获取提醒文本表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTiptextCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tiptext");
		column.setLength(1200);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("提醒文本"); 
		return column;
	}
	/**
	 * 获取病历书写任务触发事件表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_udidocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_udidoc");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("病历书写任务触发事件"); 
		return column;
	}
	/**
	 * 获取主类型code值表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_udidocCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_udidoc");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("主类型code值"); 
		return column;
	}
	/**
	 * 获取是否启用表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_activeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_active");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否启用"); 
		return column;
	}
	/**
	 * 获取期限时间（小时）表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getLimittimeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Limittime");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("期限时间（小时）"); 
		return column;
	}
	/**
	 * 获取是否可逆表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getFg_returnCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Fg_return");
		column.setLength(1);
        column.setSqlType(Types.CHAR);
		column.setNullable(true);
		column.setLabel("是否可逆"); 
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
	 * 获取序号表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSortnoCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Sortno");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("序号"); 
		return column;
	}
	/**
	 * 获取业务事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_evtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_evt");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务事件外键"); 
		return column;
	}
	/**
	 * 获取业务事件源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrcname_evtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srcname_evt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务事件源名称"); 
		return column;
	}
	/**
	 * 获取业务事件源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrccode_evtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srccode_evt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务事件源编码"); 
		return column;
	}
	/**
	 * 获取业务事件类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_evtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_evt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务事件类型编码"); 
		return column;
	}
	/**
	 * 获取业务事件类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_evtCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_evt");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("业务事件类型名称"); 
		return column;
	}
	/**
	 * 获取事件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件类型"); 
		return column;
	}
	/**
	 * 获取可逆业务事件外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_evt_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_evt_cancel");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可逆业务事件外键"); 
		return column;
	}
	/**
	 * 获取可逆业务事件源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrcname_evt_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srcname_evt_cancel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可逆业务事件源名称"); 
		return column;
	}
	/**
	 * 获取可逆业务事件源编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getSrcode_evt_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Srcode_evt_cancel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可逆业务事件源编码"); 
		return column;
	}
	/**
	 * 获取可逆业务事件编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_evt_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_evt_cancel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可逆业务事件编码"); 
		return column;
	}
	/**
	 * 获取可逆业务事件名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_evt_cancelCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_evt_cancel");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可逆业务事件名称"); 
		return column;
	}
	/**
	 * 获取可逆事件类型表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_cancel_typeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_cancel_type");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("可逆事件类型"); 
		return column;
	}
	/**
	 * 获取自动创建模板外键表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tmpl");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自动创建模板外键"); 
		return column;
	}
	/**
	 * 获取自动创建模板编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_tmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_tmpl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自动创建模板编码"); 
		return column;
	}
	/**
	 * 获取自动创建模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tmplCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tmpl");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("自动创建模板名称"); 
		return column;
	}
	/**
	 * 获取超时提醒表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimeout_reminderCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Timeout_reminder");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超时提醒"); 
		return column;
	}
	/**
	 * 获取超时提醒时限(分钟)表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getReminder_time_limitCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Reminder_time_limit");
		column.setLength(10);
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("超时提醒时限(分钟)"); 
		return column;
	}
	/**
	 * 获取超时任务前景色表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTimeout_colorCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Timeout_color");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超时任务前景色"); 
		return column;
	}
	/**
	 * 获取任务生成表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTask_generationCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Task_generation");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("任务生成"); 
		return column;
	}
	/**
	 * 获取超时提醒病历模板表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getId_tmpl_remindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Id_tmpl_remind");
		column.setLength(20);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超时提醒病历模板"); 
		return column;
	}
	/**
	 * 获取超时提醒病历模编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getCode_tmpl_remindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Code_tmpl_remind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超时提醒病历模编码"); 
		return column;
	}
	/**
	 * 获取超时提醒病历模名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getName_tmpl_remindCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Name_tmpl_remind");
		column.setLength(50);
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("超时提醒病历模名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getGrp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_code");
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
	private IColumnDesc getGrp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Grp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取组织编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织编码"); 
		return column;
	}
	/**
	 * 获取组织名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getOrg_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Org_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("组织名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMr_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_code");
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
	private IColumnDesc getMr_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mr_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取医疗记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtp_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtp_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtp_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtp_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型名称"); 
		return column;
	}
	/**
	 * 获取医疗记录类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtp_change_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtp_change_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getMrtp_change_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Mrtp_change_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录类型名称"); 
		return column;
	}
	/**
	 * 获取编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getUdidoc_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Udidoc_code");
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
	private IColumnDesc getUdidoc_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Udidoc_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("名称"); 
		return column;
	}
	/**
	 * 获取事件类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_typecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_typecode");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件类型编码"); 
		return column;
	}
	/**
	 * 获取事件类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_typenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_typename");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件类型名称"); 
		return column;
	}
	/**
	 * 获取事件源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_srcnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_srcname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件源名称"); 
		return column;
	}
	/**
	 * 获取事件源名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_cancel_srcnameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_cancel_srcname");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件源名称"); 
		return column;
	}
	/**
	 * 获取事件类型名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_cancel_typenameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_cancel_typename");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("事件类型名称"); 
		return column;
	}
	/**
	 * 获取事件类型编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getEvt_cancel_typecodeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Evt_cancel_typecode");
        column.setSqlType(Types.INTEGER);
		column.setNullable(true);
		column.setLabel("事件类型编码"); 
		return column;
	}
	/**
	 * 获取医疗记录模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTmpl_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tmpl_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板名称"); 
		return column;
	}
	/**
	 * 获取医疗记录模板编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTmpl_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tmpl_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板编码"); 
		return column;
	}
	/**
	 * 获取医疗记录模板编码表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTmpl_remind_codeCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tmpl_remind_code");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板编码"); 
		return column;
	}
	/**
	 * 获取医疗记录模板名称表列元数据
	 * @param tblDesc
	 * @return
	 */
	private IColumnDesc getTmpl_remind_nameCDesc(ITableDesc tblDesc){
		ColumnDesc column=new ColumnDesc(tblDesc,"Tmpl_remind_name");
        column.setSqlType(Types.VARCHAR);
		column.setNullable(true);
		column.setLabel("医疗记录模板名称"); 
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
