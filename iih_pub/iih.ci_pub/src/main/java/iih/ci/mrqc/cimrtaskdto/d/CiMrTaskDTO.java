package iih.ci.mrqc.cimrtaskdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历任务查询DTO DTO数据 
 * 
 */
public class CiMrTaskDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 任务状态id
	 * @return String
	 */
	public String getId_mrtask_sta() {
		return ((String) getAttrVal("Id_mrtask_sta"));
	}
	/**
	 * 任务状态id
	 * @param Id_mrtask_sta
	 */
	public void setId_mrtask_sta(String Id_mrtask_sta) {
		setAttrVal("Id_mrtask_sta", Id_mrtask_sta);
	}
	/**
	 * 任务状态sd
	 * @return String
	 */
	public String getSd_mrtask_sta() {
		return ((String) getAttrVal("Sd_mrtask_sta"));
	}
	/**
	 * 任务状态sd
	 * @param Sd_mrtask_sta
	 */
	public void setSd_mrtask_sta(String Sd_mrtask_sta) {
		setAttrVal("Sd_mrtask_sta", Sd_mrtask_sta);
	}
	/**
	 * 任务状态name
	 * @return String
	 */
	public String getName_mrtask_sta() {
		return ((String) getAttrVal("Name_mrtask_sta"));
	}
	/**
	 * 任务状态name
	 * @param Name_mrtask_sta
	 */
	public void setName_mrtask_sta(String Name_mrtask_sta) {
		setAttrVal("Name_mrtask_sta", Name_mrtask_sta);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
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
	 * 申请状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 申请状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 申请状态sd
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 申请状态sd
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 申请状态name
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 申请状态name
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 病历超时申请主键
	 * @return String
	 */
	public String getId_ci_mr_oa() {
		return ((String) getAttrVal("Id_ci_mr_oa"));
	}
	/**
	 * 病历超时申请主键
	 * @param Id_ci_mr_oa
	 */
	public void setId_ci_mr_oa(String Id_ci_mr_oa) {
		setAttrVal("Id_ci_mr_oa", Id_ci_mr_oa);
	}
	/**
	 * 扣分说明
	 * @return String
	 */
	public String getDrp_des() {
		return ((String) getAttrVal("Drp_des"));
	}
	/**
	 * 扣分说明
	 * @param Drp_des
	 */
	public void setDrp_des(String Drp_des) {
		setAttrVal("Drp_des", Drp_des);
	}
	/**
	 * 整改要求
	 * @return String
	 */
	public String getRfm_req() {
		return ((String) getAttrVal("Rfm_req"));
	}
	/**
	 * 整改要求
	 * @param Rfm_req
	 */
	public void setRfm_req(String Rfm_req) {
		setAttrVal("Rfm_req", Rfm_req);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 责任医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 期限小时（自动质控用）
	 * @return Integer
	 */
	public Integer getDead_hours() {
		return ((Integer) getAttrVal("Dead_hours"));
	}
	/**
	 * 期限小时（自动质控用）
	 * @param Dead_hours
	 */
	public void setDead_hours(Integer Dead_hours) {
		setAttrVal("Dead_hours", Dead_hours);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
}