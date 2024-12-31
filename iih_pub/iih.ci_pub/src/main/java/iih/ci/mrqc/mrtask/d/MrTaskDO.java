package iih.ci.mrqc.mrtask.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.mrtask.d.desc.MrTaskDODesc;
import java.math.BigDecimal;

/**
 * 病历任务 DO数据 
 * 
 */
public class MrTaskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病历任务主键标识
	public static final String ID_MRTASK= "Id_mrtask";
	//病历书写任务配置id
	public static final String ID_MR_TASK_RULE= "Id_mr_task_rule";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//任务名称
	public static final String MRTASK_NAME= "Mrtask_name";
	//自动质控项id
	public static final String ID_QA_ITM_CONFIG= "Id_qa_itm_config";
	//任务状态
	public static final String ID_MRTASK_STA= "Id_mrtask_sta";
	//任务状态编码
	public static final String SD_MRTASK_STA= "Sd_mrtask_sta";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//事件部门
	public static final String ID_EXEC_DEPT= "Id_exec_dept";
	//事件人员
	public static final String ID_EXEC_DOCTOR= "Id_exec_doctor";
	//医疗记录自定义分类
	public static final String ID_MRCACTM= "Id_mrcactm";
	//医疗记录类型
	public static final String ID_MRTP= "Id_mrtp";
	//来源id
	public static final String ID_SOURCE= "Id_source";
	//来源类型
	public static final String SOURCE_TYPE= "Source_type";
	//来源名称
	public static final String SOURCE_NAME= "Source_name";
	//开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//结束时间
	public static final String DT_END= "Dt_end";
	//完成时间
	public static final String DT_COMPLETE= "Dt_complete";
	//剩余时间
	public static final String TIME_HAS= "Time_has";
	//取消任务原因
	public static final String REASON_CANCEL= "Reason_cancel";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//是否频次
	public static final String ISRATE= "Israte";
	//频次
	public static final String RATE= "Rate";
	//医嘱
	public static final String ID_OR= "Id_or";
	//可替代医疗记录类型
	public static final String ID_MRTP_CHANGE= "Id_mrtp_change";
	//是否已超时提醒
	public static final String ISREMINDED= "Isreminded";
	//名称
	public static final String MRTASKSTA_NAME= "Mrtasksta_name";
	//编码
	public static final String MRTASKSTA_CODE= "Mrtasksta_code";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//名称
	public static final String MRCACTM_NAME= "Mrcactm_name";
	//编码
	public static final String MRCACTM_CODE= "Mrcactm_code";
	//医疗记录类型编码
	public static final String MRTP_CODE= "Mrtp_code";
	//医疗记录类型名称
	public static final String MRTP_NAME= "Mrtp_name";
	//医疗记录类型编码
	public static final String MRTP_CHANGE_CODE= "Mrtp_change_code";
	//医疗记录类型名称
	public static final String MRTP_CHANGE_NAME= "Mrtp_change_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病历任务主键标识
	 * @return String
	 */
	public String getId_mrtask() {
		return ((String) getAttrVal("Id_mrtask"));
	}	
	/**
	 * 病历任务主键标识
	 * @param Id_mrtask
	 */
	public void setId_mrtask(String Id_mrtask) {
		setAttrVal("Id_mrtask", Id_mrtask);
	}
	/**
	 * 病历书写任务配置id
	 * @return String
	 */
	public String getId_mr_task_rule() {
		return ((String) getAttrVal("Id_mr_task_rule"));
	}	
	/**
	 * 病历书写任务配置id
	 * @param Id_mr_task_rule
	 */
	public void setId_mr_task_rule(String Id_mr_task_rule) {
		setAttrVal("Id_mr_task_rule", Id_mr_task_rule);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 任务名称
	 * @return String
	 */
	public String getMrtask_name() {
		return ((String) getAttrVal("Mrtask_name"));
	}	
	/**
	 * 任务名称
	 * @param Mrtask_name
	 */
	public void setMrtask_name(String Mrtask_name) {
		setAttrVal("Mrtask_name", Mrtask_name);
	}
	/**
	 * 自动质控项id
	 * @return String
	 */
	public String getId_qa_itm_config() {
		return ((String) getAttrVal("Id_qa_itm_config"));
	}	
	/**
	 * 自动质控项id
	 * @param Id_qa_itm_config
	 */
	public void setId_qa_itm_config(String Id_qa_itm_config) {
		setAttrVal("Id_qa_itm_config", Id_qa_itm_config);
	}
	/**
	 * 任务状态
	 * @return String
	 */
	public String getId_mrtask_sta() {
		return ((String) getAttrVal("Id_mrtask_sta"));
	}	
	/**
	 * 任务状态
	 * @param Id_mrtask_sta
	 */
	public void setId_mrtask_sta(String Id_mrtask_sta) {
		setAttrVal("Id_mrtask_sta", Id_mrtask_sta);
	}
	/**
	 * 任务状态编码
	 * @return String
	 */
	public String getSd_mrtask_sta() {
		return ((String) getAttrVal("Sd_mrtask_sta"));
	}	
	/**
	 * 任务状态编码
	 * @param Sd_mrtask_sta
	 */
	public void setSd_mrtask_sta(String Sd_mrtask_sta) {
		setAttrVal("Sd_mrtask_sta", Sd_mrtask_sta);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 事件部门
	 * @return String
	 */
	public String getId_exec_dept() {
		return ((String) getAttrVal("Id_exec_dept"));
	}	
	/**
	 * 事件部门
	 * @param Id_exec_dept
	 */
	public void setId_exec_dept(String Id_exec_dept) {
		setAttrVal("Id_exec_dept", Id_exec_dept);
	}
	/**
	 * 事件人员
	 * @return String
	 */
	public String getId_exec_doctor() {
		return ((String) getAttrVal("Id_exec_doctor"));
	}	
	/**
	 * 事件人员
	 * @param Id_exec_doctor
	 */
	public void setId_exec_doctor(String Id_exec_doctor) {
		setAttrVal("Id_exec_doctor", Id_exec_doctor);
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
	 * 来源id
	 * @return String
	 */
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}	
	/**
	 * 来源id
	 * @param Id_source
	 */
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	/**
	 * 来源类型
	 * @return String
	 */
	public String getSource_type() {
		return ((String) getAttrVal("Source_type"));
	}	
	/**
	 * 来源类型
	 * @param Source_type
	 */
	public void setSource_type(String Source_type) {
		setAttrVal("Source_type", Source_type);
	}
	/**
	 * 来源名称
	 * @return String
	 */
	public String getSource_name() {
		return ((String) getAttrVal("Source_name"));
	}	
	/**
	 * 来源名称
	 * @param Source_name
	 */
	public void setSource_name(String Source_name) {
		setAttrVal("Source_name", Source_name);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 完成时间
	 * @return FDateTime
	 */
	public FDateTime getDt_complete() {
		return ((FDateTime) getAttrVal("Dt_complete"));
	}	
	/**
	 * 完成时间
	 * @param Dt_complete
	 */
	public void setDt_complete(FDateTime Dt_complete) {
		setAttrVal("Dt_complete", Dt_complete);
	}
	/**
	 * 剩余时间
	 * @return String
	 */
	public String getTime_has() {
		return ((String) getAttrVal("Time_has"));
	}	
	/**
	 * 剩余时间
	 * @param Time_has
	 */
	public void setTime_has(String Time_has) {
		setAttrVal("Time_has", Time_has);
	}
	/**
	 * 取消任务原因
	 * @return String
	 */
	public String getReason_cancel() {
		return ((String) getAttrVal("Reason_cancel"));
	}	
	/**
	 * 取消任务原因
	 * @param Reason_cancel
	 */
	public void setReason_cancel(String Reason_cancel) {
		setAttrVal("Reason_cancel", Reason_cancel);
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
	 * 是否频次
	 * @return FBoolean
	 */
	public FBoolean getIsrate() {
		return ((FBoolean) getAttrVal("Israte"));
	}	
	/**
	 * 是否频次
	 * @param Israte
	 */
	public void setIsrate(FBoolean Israte) {
		setAttrVal("Israte", Israte);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getRate() {
		return ((String) getAttrVal("Rate"));
	}	
	/**
	 * 频次
	 * @param Rate
	 */
	public void setRate(String Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 是否已超时提醒
	 * @return FBoolean
	 */
	public FBoolean getIsreminded() {
		return ((FBoolean) getAttrVal("Isreminded"));
	}	
	/**
	 * 是否已超时提醒
	 * @param Isreminded
	 */
	public void setIsreminded(FBoolean Isreminded) {
		setAttrVal("Isreminded", Isreminded);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMrtasksta_name() {
		return ((String) getAttrVal("Mrtasksta_name"));
	}	
	/**
	 * 名称
	 * @param Mrtasksta_name
	 */
	public void setMrtasksta_name(String Mrtasksta_name) {
		setAttrVal("Mrtasksta_name", Mrtasksta_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMrtasksta_code() {
		return ((String) getAttrVal("Mrtasksta_code"));
	}	
	/**
	 * 编码
	 * @param Mrtasksta_code
	 */
	public void setMrtasksta_code(String Mrtasksta_code) {
		setAttrVal("Mrtasksta_code", Mrtasksta_code);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMrcactm_name() {
		return ((String) getAttrVal("Mrcactm_name"));
	}	
	/**
	 * 名称
	 * @param Mrcactm_name
	 */
	public void setMrcactm_name(String Mrcactm_name) {
		setAttrVal("Mrcactm_name", Mrcactm_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMrcactm_code() {
		return ((String) getAttrVal("Mrcactm_code"));
	}	
	/**
	 * 编码
	 * @param Mrcactm_code
	 */
	public void setMrcactm_code(String Mrcactm_code) {
		setAttrVal("Mrcactm_code", Mrcactm_code);
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
		return "Id_mrtask";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_mrtask";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTaskDODesc.class);
	}
	
}