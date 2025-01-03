package iih.bd.srv.mrtaskrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrtaskrule.d.desc.MrTaskRuleDODesc;
import java.math.BigDecimal;

/**
 * 病历书写任务配置 DO数据 
 * 
 */
public class MrTaskRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病历书写任务配置主键
	public static final String ID_MR_TASK_RULE= "Id_mr_task_rule";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//医疗记录自定义分类
	public static final String ID_MRCACTM= "Id_mrcactm";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//可替代医疗记录类型
	public static final String ID_MRTP_CHANGE= "Id_mrtp_change";
	//是否替换
	public static final String FG_CHANGE= "Fg_change";
	//提醒文本
	public static final String TIPTEXT= "Tiptext";
	//病历书写任务触发事件
	public static final String ID_UDIDOC= "Id_udidoc";
	//主类型code值
	public static final String CODE_UDIDOC= "Code_udidoc";
	//是否启用
	public static final String FG_ACTIVE= "Fg_active";
	//期限时间（小时）
	public static final String LIMITTIME= "Limittime";
	//是否可逆
	public static final String FG_RETURN= "Fg_return";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//序号
	public static final String SORTNO= "Sortno";
	//业务事件外键
	public static final String ID_EVT= "Id_evt";
	//业务事件源名称
	public static final String SRCNAME_EVT= "Srcname_evt";
	//业务事件源编码
	public static final String SRCCODE_EVT= "Srccode_evt";
	//业务事件类型编码
	public static final String CODE_EVT= "Code_evt";
	//业务事件类型名称
	public static final String NAME_EVT= "Name_evt";
	//事件类型
	public static final String EVT_TYPE= "Evt_type";
	//可逆业务事件外键
	public static final String ID_EVT_CANCEL= "Id_evt_cancel";
	//可逆业务事件源名称
	public static final String SRCNAME_EVT_CANCEL= "Srcname_evt_cancel";
	//可逆业务事件源编码
	public static final String SRCODE_EVT_CANCEL= "Srcode_evt_cancel";
	//可逆业务事件编码
	public static final String CODE_EVT_CANCEL= "Code_evt_cancel";
	//可逆业务事件名称
	public static final String NAME_EVT_CANCEL= "Name_evt_cancel";
	//可逆事件类型
	public static final String EVT_CANCEL_TYPE= "Evt_cancel_type";
	//自动创建模板外键
	public static final String ID_TMPL= "Id_tmpl";
	//自动创建模板编码
	public static final String CODE_TMPL= "Code_tmpl";
	//自动创建模板名称
	public static final String NAME_TMPL= "Name_tmpl";
	//超时提醒
	public static final String TIMEOUT_REMINDER= "Timeout_reminder";
	//超时提醒时限(分钟)
	public static final String REMINDER_TIME_LIMIT= "Reminder_time_limit";
	//超时任务前景色
	public static final String TIMEOUT_COLOR= "Timeout_color";
	//任务生成
	public static final String TASK_GENERATION= "Task_generation";
	//超时提醒病历模板
	public static final String ID_TMPL_REMIND= "Id_tmpl_remind";
	//超时提醒病历模编码
	public static final String CODE_TMPL_REMIND= "Code_tmpl_remind";
	//超时提醒病历模名称
	public static final String NAME_TMPL_REMIND= "Name_tmpl_remind";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String MR_CODE= "Mr_code";
	//名称
	public static final String MR_NAME= "Mr_name";
	//医疗记录类型编码
	public static final String MRTP_CODE= "Mrtp_code";
	//医疗记录类型名称
	public static final String MRTP_NAME= "Mrtp_name";
	//医疗记录类型编码
	public static final String MRTP_CHANGE_CODE= "Mrtp_change_code";
	//医疗记录类型名称
	public static final String MRTP_CHANGE_NAME= "Mrtp_change_name";
	//编码
	public static final String UDIDOC_CODE= "Udidoc_code";
	//名称
	public static final String UDIDOC_NAME= "Udidoc_name";
	//事件类型编码
	public static final String EVT_TYPECODE= "Evt_typecode";
	//事件类型名称
	public static final String EVT_TYPENAME= "Evt_typename";
	//事件源名称
	public static final String EVT_SRCNAME= "Evt_srcname";
	//事件源名称
	public static final String EVT_CANCEL_SRCNAME= "Evt_cancel_srcname";
	//事件类型名称
	public static final String EVT_CANCEL_TYPENAME= "Evt_cancel_typename";
	//事件类型编码
	public static final String EVT_CANCEL_TYPECODE= "Evt_cancel_typecode";
	//医疗记录模板名称
	public static final String TMPL_NAME= "Tmpl_name";
	//医疗记录模板编码
	public static final String TMPL_CODE= "Tmpl_code";
	//医疗记录模板编码
	public static final String TMPL_REMIND_CODE= "Tmpl_remind_code";
	//医疗记录模板名称
	public static final String TMPL_REMIND_NAME= "Tmpl_remind_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病历书写任务配置主键
	 * @return String
	 */
	public String getId_mr_task_rule() {
		return ((String) getAttrVal("Id_mr_task_rule"));
	}	
	/**
	 * 病历书写任务配置主键
	 * @param Id_mr_task_rule
	 */
	public void setId_mr_task_rule(String Id_mr_task_rule) {
		setAttrVal("Id_mr_task_rule", Id_mr_task_rule);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 医疗记录自定义分类
	 * @return String
	 */
	public String getId_mrcactm() {
		return ((String) getAttrVal("Id_mrcactm"));
	}	
	/**
	 * 医疗记录自定义分类
	 * @param Id_mrcactm
	 */
	public void setId_mrcactm(String Id_mrcactm) {
		setAttrVal("Id_mrcactm", Id_mrcactm);
	}
	/**
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	/**
	 * 医疗记录类型
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 可替代医疗记录类型
	 * @return String
	 */
	public String getId_mrtp_change() {
		return ((String) getAttrVal("Id_mrtp_change"));
	}	
	/**
	 * 可替代医疗记录类型
	 * @param Id_mrtp_change
	 */
	public void setId_mrtp_change(String Id_mrtp_change) {
		setAttrVal("Id_mrtp_change", Id_mrtp_change);
	}
	/**
	 * 是否替换
	 * @return FBoolean
	 */
	public FBoolean getFg_change() {
		return ((FBoolean) getAttrVal("Fg_change"));
	}	
	/**
	 * 是否替换
	 * @param Fg_change
	 */
	public void setFg_change(FBoolean Fg_change) {
		setAttrVal("Fg_change", Fg_change);
	}
	/**
	 * 提醒文本
	 * @return String
	 */
	public String getTiptext() {
		return ((String) getAttrVal("Tiptext"));
	}	
	/**
	 * 提醒文本
	 * @param Tiptext
	 */
	public void setTiptext(String Tiptext) {
		setAttrVal("Tiptext", Tiptext);
	}
	/**
	 * 病历书写任务触发事件
	 * @return String
	 */
	public String getId_udidoc() {
		return ((String) getAttrVal("Id_udidoc"));
	}	
	/**
	 * 病历书写任务触发事件
	 * @param Id_udidoc
	 */
	public void setId_udidoc(String Id_udidoc) {
		setAttrVal("Id_udidoc", Id_udidoc);
	}
	/**
	 * 主类型code值
	 * @return String
	 */
	public String getCode_udidoc() {
		return ((String) getAttrVal("Code_udidoc"));
	}	
	/**
	 * 主类型code值
	 * @param Code_udidoc
	 */
	public void setCode_udidoc(String Code_udidoc) {
		setAttrVal("Code_udidoc", Code_udidoc);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 期限时间（小时）
	 * @return Integer
	 */
	public Integer getLimittime() {
		return ((Integer) getAttrVal("Limittime"));
	}	
	/**
	 * 期限时间（小时）
	 * @param Limittime
	 */
	public void setLimittime(Integer Limittime) {
		setAttrVal("Limittime", Limittime);
	}
	/**
	 * 是否可逆
	 * @return FBoolean
	 */
	public FBoolean getFg_return() {
		return ((FBoolean) getAttrVal("Fg_return"));
	}	
	/**
	 * 是否可逆
	 * @param Fg_return
	 */
	public void setFg_return(FBoolean Fg_return) {
		setAttrVal("Fg_return", Fg_return);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 业务事件外键
	 * @return String
	 */
	public String getId_evt() {
		return ((String) getAttrVal("Id_evt"));
	}	
	/**
	 * 业务事件外键
	 * @param Id_evt
	 */
	public void setId_evt(String Id_evt) {
		setAttrVal("Id_evt", Id_evt);
	}
	/**
	 * 业务事件源名称
	 * @return String
	 */
	public String getSrcname_evt() {
		return ((String) getAttrVal("Srcname_evt"));
	}	
	/**
	 * 业务事件源名称
	 * @param Srcname_evt
	 */
	public void setSrcname_evt(String Srcname_evt) {
		setAttrVal("Srcname_evt", Srcname_evt);
	}
	/**
	 * 业务事件源编码
	 * @return String
	 */
	public String getSrccode_evt() {
		return ((String) getAttrVal("Srccode_evt"));
	}	
	/**
	 * 业务事件源编码
	 * @param Srccode_evt
	 */
	public void setSrccode_evt(String Srccode_evt) {
		setAttrVal("Srccode_evt", Srccode_evt);
	}
	/**
	 * 业务事件类型编码
	 * @return String
	 */
	public String getCode_evt() {
		return ((String) getAttrVal("Code_evt"));
	}	
	/**
	 * 业务事件类型编码
	 * @param Code_evt
	 */
	public void setCode_evt(String Code_evt) {
		setAttrVal("Code_evt", Code_evt);
	}
	/**
	 * 业务事件类型名称
	 * @return String
	 */
	public String getName_evt() {
		return ((String) getAttrVal("Name_evt"));
	}	
	/**
	 * 业务事件类型名称
	 * @param Name_evt
	 */
	public void setName_evt(String Name_evt) {
		setAttrVal("Name_evt", Name_evt);
	}
	/**
	 * 事件类型
	 * @return String
	 */
	public String getEvt_type() {
		return ((String) getAttrVal("Evt_type"));
	}	
	/**
	 * 事件类型
	 * @param Evt_type
	 */
	public void setEvt_type(String Evt_type) {
		setAttrVal("Evt_type", Evt_type);
	}
	/**
	 * 可逆业务事件外键
	 * @return String
	 */
	public String getId_evt_cancel() {
		return ((String) getAttrVal("Id_evt_cancel"));
	}	
	/**
	 * 可逆业务事件外键
	 * @param Id_evt_cancel
	 */
	public void setId_evt_cancel(String Id_evt_cancel) {
		setAttrVal("Id_evt_cancel", Id_evt_cancel);
	}
	/**
	 * 可逆业务事件源名称
	 * @return String
	 */
	public String getSrcname_evt_cancel() {
		return ((String) getAttrVal("Srcname_evt_cancel"));
	}	
	/**
	 * 可逆业务事件源名称
	 * @param Srcname_evt_cancel
	 */
	public void setSrcname_evt_cancel(String Srcname_evt_cancel) {
		setAttrVal("Srcname_evt_cancel", Srcname_evt_cancel);
	}
	/**
	 * 可逆业务事件源编码
	 * @return String
	 */
	public String getSrcode_evt_cancel() {
		return ((String) getAttrVal("Srcode_evt_cancel"));
	}	
	/**
	 * 可逆业务事件源编码
	 * @param Srcode_evt_cancel
	 */
	public void setSrcode_evt_cancel(String Srcode_evt_cancel) {
		setAttrVal("Srcode_evt_cancel", Srcode_evt_cancel);
	}
	/**
	 * 可逆业务事件编码
	 * @return String
	 */
	public String getCode_evt_cancel() {
		return ((String) getAttrVal("Code_evt_cancel"));
	}	
	/**
	 * 可逆业务事件编码
	 * @param Code_evt_cancel
	 */
	public void setCode_evt_cancel(String Code_evt_cancel) {
		setAttrVal("Code_evt_cancel", Code_evt_cancel);
	}
	/**
	 * 可逆业务事件名称
	 * @return String
	 */
	public String getName_evt_cancel() {
		return ((String) getAttrVal("Name_evt_cancel"));
	}	
	/**
	 * 可逆业务事件名称
	 * @param Name_evt_cancel
	 */
	public void setName_evt_cancel(String Name_evt_cancel) {
		setAttrVal("Name_evt_cancel", Name_evt_cancel);
	}
	/**
	 * 可逆事件类型
	 * @return String
	 */
	public String getEvt_cancel_type() {
		return ((String) getAttrVal("Evt_cancel_type"));
	}	
	/**
	 * 可逆事件类型
	 * @param Evt_cancel_type
	 */
	public void setEvt_cancel_type(String Evt_cancel_type) {
		setAttrVal("Evt_cancel_type", Evt_cancel_type);
	}
	/**
	 * 自动创建模板外键
	 * @return String
	 */
	public String getId_tmpl() {
		return ((String) getAttrVal("Id_tmpl"));
	}	
	/**
	 * 自动创建模板外键
	 * @param Id_tmpl
	 */
	public void setId_tmpl(String Id_tmpl) {
		setAttrVal("Id_tmpl", Id_tmpl);
	}
	/**
	 * 自动创建模板编码
	 * @return String
	 */
	public String getCode_tmpl() {
		return ((String) getAttrVal("Code_tmpl"));
	}	
	/**
	 * 自动创建模板编码
	 * @param Code_tmpl
	 */
	public void setCode_tmpl(String Code_tmpl) {
		setAttrVal("Code_tmpl", Code_tmpl);
	}
	/**
	 * 自动创建模板名称
	 * @return String
	 */
	public String getName_tmpl() {
		return ((String) getAttrVal("Name_tmpl"));
	}	
	/**
	 * 自动创建模板名称
	 * @param Name_tmpl
	 */
	public void setName_tmpl(String Name_tmpl) {
		setAttrVal("Name_tmpl", Name_tmpl);
	}
	/**
	 * 超时提醒
	 * @return String
	 */
	public String getTimeout_reminder() {
		return ((String) getAttrVal("Timeout_reminder"));
	}	
	/**
	 * 超时提醒
	 * @param Timeout_reminder
	 */
	public void setTimeout_reminder(String Timeout_reminder) {
		setAttrVal("Timeout_reminder", Timeout_reminder);
	}
	/**
	 * 超时提醒时限(分钟)
	 * @return Integer
	 */
	public Integer getReminder_time_limit() {
		return ((Integer) getAttrVal("Reminder_time_limit"));
	}	
	/**
	 * 超时提醒时限(分钟)
	 * @param Reminder_time_limit
	 */
	public void setReminder_time_limit(Integer Reminder_time_limit) {
		setAttrVal("Reminder_time_limit", Reminder_time_limit);
	}
	/**
	 * 超时任务前景色
	 * @return String
	 */
	public String getTimeout_color() {
		return ((String) getAttrVal("Timeout_color"));
	}	
	/**
	 * 超时任务前景色
	 * @param Timeout_color
	 */
	public void setTimeout_color(String Timeout_color) {
		setAttrVal("Timeout_color", Timeout_color);
	}
	/**
	 * 任务生成
	 * @return String
	 */
	public String getTask_generation() {
		return ((String) getAttrVal("Task_generation"));
	}	
	/**
	 * 任务生成
	 * @param Task_generation
	 */
	public void setTask_generation(String Task_generation) {
		setAttrVal("Task_generation", Task_generation);
	}
	/**
	 * 超时提醒病历模板
	 * @return String
	 */
	public String getId_tmpl_remind() {
		return ((String) getAttrVal("Id_tmpl_remind"));
	}	
	/**
	 * 超时提醒病历模板
	 * @param Id_tmpl_remind
	 */
	public void setId_tmpl_remind(String Id_tmpl_remind) {
		setAttrVal("Id_tmpl_remind", Id_tmpl_remind);
	}
	/**
	 * 超时提醒病历模编码
	 * @return String
	 */
	public String getCode_tmpl_remind() {
		return ((String) getAttrVal("Code_tmpl_remind"));
	}	
	/**
	 * 超时提醒病历模编码
	 * @param Code_tmpl_remind
	 */
	public void setCode_tmpl_remind(String Code_tmpl_remind) {
		setAttrVal("Code_tmpl_remind", Code_tmpl_remind);
	}
	/**
	 * 超时提醒病历模名称
	 * @return String
	 */
	public String getName_tmpl_remind() {
		return ((String) getAttrVal("Name_tmpl_remind"));
	}	
	/**
	 * 超时提醒病历模名称
	 * @param Name_tmpl_remind
	 */
	public void setName_tmpl_remind(String Name_tmpl_remind) {
		setAttrVal("Name_tmpl_remind", Name_tmpl_remind);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMr_code() {
		return ((String) getAttrVal("Mr_code"));
	}	
	/**
	 * 编码
	 * @param Mr_code
	 */
	public void setMr_code(String Mr_code) {
		setAttrVal("Mr_code", Mr_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMr_name() {
		return ((String) getAttrVal("Mr_name"));
	}	
	/**
	 * 名称
	 * @param Mr_name
	 */
	public void setMr_name(String Mr_name) {
		setAttrVal("Mr_name", Mr_name);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getMrtp_code() {
		return ((String) getAttrVal("Mrtp_code"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Mrtp_code
	 */
	public void setMrtp_code(String Mrtp_code) {
		setAttrVal("Mrtp_code", Mrtp_code);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getMrtp_name() {
		return ((String) getAttrVal("Mrtp_name"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Mrtp_name
	 */
	public void setMrtp_name(String Mrtp_name) {
		setAttrVal("Mrtp_name", Mrtp_name);
	}
	/**
	 * 医疗记录类型编码
	 * @return String
	 */
	public String getMrtp_change_code() {
		return ((String) getAttrVal("Mrtp_change_code"));
	}	
	/**
	 * 医疗记录类型编码
	 * @param Mrtp_change_code
	 */
	public void setMrtp_change_code(String Mrtp_change_code) {
		setAttrVal("Mrtp_change_code", Mrtp_change_code);
	}
	/**
	 * 医疗记录类型名称
	 * @return String
	 */
	public String getMrtp_change_name() {
		return ((String) getAttrVal("Mrtp_change_name"));
	}	
	/**
	 * 医疗记录类型名称
	 * @param Mrtp_change_name
	 */
	public void setMrtp_change_name(String Mrtp_change_name) {
		setAttrVal("Mrtp_change_name", Mrtp_change_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getUdidoc_code() {
		return ((String) getAttrVal("Udidoc_code"));
	}	
	/**
	 * 编码
	 * @param Udidoc_code
	 */
	public void setUdidoc_code(String Udidoc_code) {
		setAttrVal("Udidoc_code", Udidoc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getUdidoc_name() {
		return ((String) getAttrVal("Udidoc_name"));
	}	
	/**
	 * 名称
	 * @param Udidoc_name
	 */
	public void setUdidoc_name(String Udidoc_name) {
		setAttrVal("Udidoc_name", Udidoc_name);
	}
	/**
	 * 事件类型编码
	 * @return Integer
	 */
	public Integer getEvt_typecode() {
		return ((Integer) getAttrVal("Evt_typecode"));
	}	
	/**
	 * 事件类型编码
	 * @param Evt_typecode
	 */
	public void setEvt_typecode(Integer Evt_typecode) {
		setAttrVal("Evt_typecode", Evt_typecode);
	}
	/**
	 * 事件类型名称
	 * @return String
	 */
	public String getEvt_typename() {
		return ((String) getAttrVal("Evt_typename"));
	}	
	/**
	 * 事件类型名称
	 * @param Evt_typename
	 */
	public void setEvt_typename(String Evt_typename) {
		setAttrVal("Evt_typename", Evt_typename);
	}
	/**
	 * 事件源名称
	 * @return String
	 */
	public String getEvt_srcname() {
		return ((String) getAttrVal("Evt_srcname"));
	}	
	/**
	 * 事件源名称
	 * @param Evt_srcname
	 */
	public void setEvt_srcname(String Evt_srcname) {
		setAttrVal("Evt_srcname", Evt_srcname);
	}
	/**
	 * 事件源名称
	 * @return String
	 */
	public String getEvt_cancel_srcname() {
		return ((String) getAttrVal("Evt_cancel_srcname"));
	}	
	/**
	 * 事件源名称
	 * @param Evt_cancel_srcname
	 */
	public void setEvt_cancel_srcname(String Evt_cancel_srcname) {
		setAttrVal("Evt_cancel_srcname", Evt_cancel_srcname);
	}
	/**
	 * 事件类型名称
	 * @return String
	 */
	public String getEvt_cancel_typename() {
		return ((String) getAttrVal("Evt_cancel_typename"));
	}	
	/**
	 * 事件类型名称
	 * @param Evt_cancel_typename
	 */
	public void setEvt_cancel_typename(String Evt_cancel_typename) {
		setAttrVal("Evt_cancel_typename", Evt_cancel_typename);
	}
	/**
	 * 事件类型编码
	 * @return Integer
	 */
	public Integer getEvt_cancel_typecode() {
		return ((Integer) getAttrVal("Evt_cancel_typecode"));
	}	
	/**
	 * 事件类型编码
	 * @param Evt_cancel_typecode
	 */
	public void setEvt_cancel_typecode(Integer Evt_cancel_typecode) {
		setAttrVal("Evt_cancel_typecode", Evt_cancel_typecode);
	}
	/**
	 * 医疗记录模板名称
	 * @return String
	 */
	public String getTmpl_name() {
		return ((String) getAttrVal("Tmpl_name"));
	}	
	/**
	 * 医疗记录模板名称
	 * @param Tmpl_name
	 */
	public void setTmpl_name(String Tmpl_name) {
		setAttrVal("Tmpl_name", Tmpl_name);
	}
	/**
	 * 医疗记录模板编码
	 * @return String
	 */
	public String getTmpl_code() {
		return ((String) getAttrVal("Tmpl_code"));
	}	
	/**
	 * 医疗记录模板编码
	 * @param Tmpl_code
	 */
	public void setTmpl_code(String Tmpl_code) {
		setAttrVal("Tmpl_code", Tmpl_code);
	}
	/**
	 * 医疗记录模板编码
	 * @return String
	 */
	public String getTmpl_remind_code() {
		return ((String) getAttrVal("Tmpl_remind_code"));
	}	
	/**
	 * 医疗记录模板编码
	 * @param Tmpl_remind_code
	 */
	public void setTmpl_remind_code(String Tmpl_remind_code) {
		setAttrVal("Tmpl_remind_code", Tmpl_remind_code);
	}
	/**
	 * 医疗记录模板名称
	 * @return String
	 */
	public String getTmpl_remind_name() {
		return ((String) getAttrVal("Tmpl_remind_name"));
	}	
	/**
	 * 医疗记录模板名称
	 * @param Tmpl_remind_name
	 */
	public void setTmpl_remind_name(String Tmpl_remind_name) {
		setAttrVal("Tmpl_remind_name", Tmpl_remind_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_mr_task_rule";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_task_rule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTaskRuleDODesc.class);
	}
	
}