package iih.nm.nqm.nqmadev.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmadev.d.desc.NqmAdEvDODesc;
import java.math.BigDecimal;

/**
 * 不良事件 DO数据 
 * 
 */
public class NqmAdEvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//不良事件主键
	public static final String ID_NQM_ADEV= "Id_nqm_adev";
	//组织id
	public static final String ID_ORG= "Id_org";
	//集团id
	public static final String ID_GRP= "Id_grp";
	//当事人
	public static final String ID_NUR_PSN= "Id_nur_psn";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//职称
	public static final String ID_EMPTITLE= "Id_emptitle";
	//职称编码
	public static final String SD_EMPTITLE= "Sd_emptitle";
	//工作年限
	public static final String WKYEAR= "Wkyear";
	//发生时间
	public static final String DT_OCCUR= "Dt_occur";
	//发生月份ID
	public static final String ID_MONTH= "Id_month";
	//发生月份编码
	public static final String SD_MONTH= "Sd_month";
	//不良事件分类id
	public static final String ID_ADEV_CA= "Id_adev_ca";
	//不良事件分类编码
	public static final String SD_ADEV_CA= "Sd_adev_ca";
	//其他分类
	public static final String ADEV_CA_OTHER= "Adev_ca_other";
	//不良事件经过及后果
	public static final String DESCRIBE= "Describe";
	//原因分类
	public static final String ID_REASON_CA= "Id_reason_ca";
	//原因分析编码
	public static final String SD_REASON_CA= "Sd_reason_ca";
	//科室管理因素
	public static final String DEP_REASON= "Dep_reason";
	//个人因素
	public static final String PSN_REASON= "Psn_reason";
	//原因分析
	public static final String REASON= "Reason";
	//处理意见
	public static final String HANDSUGGEST= "Handsuggest";
	//改进措施
	public static final String IMPRO_MEAS= "Impro_meas";
	//护理部意见
	public static final String NUR_DEP_OPIN= "Nur_dep_opin";
	//护士长签名
	public static final String ID_NUR_HEAD= "Id_nur_head";
	//护理部签名
	public static final String ID_DEPNUR_PSN= "Id_depnur_psn";
	//上报人
	public static final String ID_REPORT_PSN= "Id_report_psn";
	//上报时间
	public static final String DT_REPORT= "Dt_report";
	//流程任务ID
	public static final String ID_TASK= "Id_task";
	//上报审核状态ID
	public static final String ID_AUDIT_STATUS= "Id_audit_status";
	//上报审核状态编码
	public static final String SD_AUDIT_STATUS= "Sd_audit_status";
	//审核人
	public static final String ID_AUDIT_PSN= "Id_audit_psn";
	//审核时间
	public static final String DT_AUDIT= "Dt_audit";
	//审核意见
	public static final String AUDIT_COMMENTS= "Audit_comments";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//当事人
	public static final String NAME_NUR_PSN= "Name_nur_psn";
	//护理单元
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//职称
	public static final String NAME_EMPTITLE= "Name_emptitle";
	//月份
	public static final String NAME_MONTH= "Name_month";
	//不良事件分类
	public static final String NAME_ADEV_CA= "Name_adev_ca";
	//不良事件原因分类
	public static final String NAME_REASON_CA= "Name_reason_ca";
	//护士长签名
	public static final String NAME_NUR_HEAD= "Name_nur_head";
	//护理部签名
	public static final String NAME= "Name";
	//上报人
	public static final String NAME_REPORT_PSN= "Name_report_psn";
	//上报状态
	public static final String NAME_AUDIT_STATUS= "Name_audit_status";
	//审核人姓名
	public static final String NAME_AUDIT= "Name_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 不良事件主键
	 * @return String
	 */
	public String getId_nqm_adev() {
		return ((String) getAttrVal("Id_nqm_adev"));
	}	
	/**
	 * 不良事件主键
	 * @param Id_nqm_adev
	 */
	public void setId_nqm_adev(String Id_nqm_adev) {
		setAttrVal("Id_nqm_adev", Id_nqm_adev);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 当事人
	 * @return String
	 */
	public String getId_nur_psn() {
		return ((String) getAttrVal("Id_nur_psn"));
	}	
	/**
	 * 当事人
	 * @param Id_nur_psn
	 */
	public void setId_nur_psn(String Id_nur_psn) {
		setAttrVal("Id_nur_psn", Id_nur_psn);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 职称
	 * @return String
	 */
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}	
	/**
	 * 职称
	 * @param Id_emptitle
	 */
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	/**
	 * 职称编码
	 * @return String
	 */
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}	
	/**
	 * 职称编码
	 * @param Sd_emptitle
	 */
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	/**
	 * 工作年限
	 * @return FDouble
	 */
	public FDouble getWkyear() {
		return ((FDouble) getAttrVal("Wkyear"));
	}	
	/**
	 * 工作年限
	 * @param Wkyear
	 */
	public void setWkyear(FDouble Wkyear) {
		setAttrVal("Wkyear", Wkyear);
	}
	/**
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_occur() {
		return ((FDateTime) getAttrVal("Dt_occur"));
	}	
	/**
	 * 发生时间
	 * @param Dt_occur
	 */
	public void setDt_occur(FDateTime Dt_occur) {
		setAttrVal("Dt_occur", Dt_occur);
	}
	/**
	 * 发生月份ID
	 * @return String
	 */
	public String getId_month() {
		return ((String) getAttrVal("Id_month"));
	}	
	/**
	 * 发生月份ID
	 * @param Id_month
	 */
	public void setId_month(String Id_month) {
		setAttrVal("Id_month", Id_month);
	}
	/**
	 * 发生月份编码
	 * @return String
	 */
	public String getSd_month() {
		return ((String) getAttrVal("Sd_month"));
	}	
	/**
	 * 发生月份编码
	 * @param Sd_month
	 */
	public void setSd_month(String Sd_month) {
		setAttrVal("Sd_month", Sd_month);
	}
	/**
	 * 不良事件分类id
	 * @return String
	 */
	public String getId_adev_ca() {
		return ((String) getAttrVal("Id_adev_ca"));
	}	
	/**
	 * 不良事件分类id
	 * @param Id_adev_ca
	 */
	public void setId_adev_ca(String Id_adev_ca) {
		setAttrVal("Id_adev_ca", Id_adev_ca);
	}
	/**
	 * 不良事件分类编码
	 * @return String
	 */
	public String getSd_adev_ca() {
		return ((String) getAttrVal("Sd_adev_ca"));
	}	
	/**
	 * 不良事件分类编码
	 * @param Sd_adev_ca
	 */
	public void setSd_adev_ca(String Sd_adev_ca) {
		setAttrVal("Sd_adev_ca", Sd_adev_ca);
	}
	/**
	 * 其他分类
	 * @return String
	 */
	public String getAdev_ca_other() {
		return ((String) getAttrVal("Adev_ca_other"));
	}	
	/**
	 * 其他分类
	 * @param Adev_ca_other
	 */
	public void setAdev_ca_other(String Adev_ca_other) {
		setAttrVal("Adev_ca_other", Adev_ca_other);
	}
	/**
	 * 不良事件经过及后果
	 * @return String
	 */
	public String getDescribe() {
		return ((String) getAttrVal("Describe"));
	}	
	/**
	 * 不良事件经过及后果
	 * @param Describe
	 */
	public void setDescribe(String Describe) {
		setAttrVal("Describe", Describe);
	}
	/**
	 * 原因分类
	 * @return String
	 */
	public String getId_reason_ca() {
		return ((String) getAttrVal("Id_reason_ca"));
	}	
	/**
	 * 原因分类
	 * @param Id_reason_ca
	 */
	public void setId_reason_ca(String Id_reason_ca) {
		setAttrVal("Id_reason_ca", Id_reason_ca);
	}
	/**
	 * 原因分析编码
	 * @return String
	 */
	public String getSd_reason_ca() {
		return ((String) getAttrVal("Sd_reason_ca"));
	}	
	/**
	 * 原因分析编码
	 * @param Sd_reason_ca
	 */
	public void setSd_reason_ca(String Sd_reason_ca) {
		setAttrVal("Sd_reason_ca", Sd_reason_ca);
	}
	/**
	 * 科室管理因素
	 * @return String
	 */
	public String getDep_reason() {
		return ((String) getAttrVal("Dep_reason"));
	}	
	/**
	 * 科室管理因素
	 * @param Dep_reason
	 */
	public void setDep_reason(String Dep_reason) {
		setAttrVal("Dep_reason", Dep_reason);
	}
	/**
	 * 个人因素
	 * @return String
	 */
	public String getPsn_reason() {
		return ((String) getAttrVal("Psn_reason"));
	}	
	/**
	 * 个人因素
	 * @param Psn_reason
	 */
	public void setPsn_reason(String Psn_reason) {
		setAttrVal("Psn_reason", Psn_reason);
	}
	/**
	 * 原因分析
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	/**
	 * 原因分析
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 处理意见
	 * @return String
	 */
	public String getHandsuggest() {
		return ((String) getAttrVal("Handsuggest"));
	}	
	/**
	 * 处理意见
	 * @param Handsuggest
	 */
	public void setHandsuggest(String Handsuggest) {
		setAttrVal("Handsuggest", Handsuggest);
	}
	/**
	 * 改进措施
	 * @return String
	 */
	public String getImpro_meas() {
		return ((String) getAttrVal("Impro_meas"));
	}	
	/**
	 * 改进措施
	 * @param Impro_meas
	 */
	public void setImpro_meas(String Impro_meas) {
		setAttrVal("Impro_meas", Impro_meas);
	}
	/**
	 * 护理部意见
	 * @return String
	 */
	public String getNur_dep_opin() {
		return ((String) getAttrVal("Nur_dep_opin"));
	}	
	/**
	 * 护理部意见
	 * @param Nur_dep_opin
	 */
	public void setNur_dep_opin(String Nur_dep_opin) {
		setAttrVal("Nur_dep_opin", Nur_dep_opin);
	}
	/**
	 * 护士长签名
	 * @return String
	 */
	public String getId_nur_head() {
		return ((String) getAttrVal("Id_nur_head"));
	}	
	/**
	 * 护士长签名
	 * @param Id_nur_head
	 */
	public void setId_nur_head(String Id_nur_head) {
		setAttrVal("Id_nur_head", Id_nur_head);
	}
	/**
	 * 护理部签名
	 * @return String
	 */
	public String getId_depnur_psn() {
		return ((String) getAttrVal("Id_depnur_psn"));
	}	
	/**
	 * 护理部签名
	 * @param Id_depnur_psn
	 */
	public void setId_depnur_psn(String Id_depnur_psn) {
		setAttrVal("Id_depnur_psn", Id_depnur_psn);
	}
	/**
	 * 上报人
	 * @return String
	 */
	public String getId_report_psn() {
		return ((String) getAttrVal("Id_report_psn"));
	}	
	/**
	 * 上报人
	 * @param Id_report_psn
	 */
	public void setId_report_psn(String Id_report_psn) {
		setAttrVal("Id_report_psn", Id_report_psn);
	}
	/**
	 * 上报时间
	 * @return FDateTime
	 */
	public FDateTime getDt_report() {
		return ((FDateTime) getAttrVal("Dt_report"));
	}	
	/**
	 * 上报时间
	 * @param Dt_report
	 */
	public void setDt_report(FDateTime Dt_report) {
		setAttrVal("Dt_report", Dt_report);
	}
	/**
	 * 流程任务ID
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	/**
	 * 流程任务ID
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 上报审核状态ID
	 * @return String
	 */
	public String getId_audit_status() {
		return ((String) getAttrVal("Id_audit_status"));
	}	
	/**
	 * 上报审核状态ID
	 * @param Id_audit_status
	 */
	public void setId_audit_status(String Id_audit_status) {
		setAttrVal("Id_audit_status", Id_audit_status);
	}
	/**
	 * 上报审核状态编码
	 * @return String
	 */
	public String getSd_audit_status() {
		return ((String) getAttrVal("Sd_audit_status"));
	}	
	/**
	 * 上报审核状态编码
	 * @param Sd_audit_status
	 */
	public void setSd_audit_status(String Sd_audit_status) {
		setAttrVal("Sd_audit_status", Sd_audit_status);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_audit_psn() {
		return ((String) getAttrVal("Id_audit_psn"));
	}	
	/**
	 * 审核人
	 * @param Id_audit_psn
	 */
	public void setId_audit_psn(String Id_audit_psn) {
		setAttrVal("Id_audit_psn", Id_audit_psn);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	/**
	 * 审核时间
	 * @param Dt_audit
	 */
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getAudit_comments() {
		return ((String) getAttrVal("Audit_comments"));
	}	
	/**
	 * 审核意见
	 * @param Audit_comments
	 */
	public void setAudit_comments(String Audit_comments) {
		setAttrVal("Audit_comments", Audit_comments);
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
	 * 当事人
	 * @return String
	 */
	public String getName_nur_psn() {
		return ((String) getAttrVal("Name_nur_psn"));
	}	
	/**
	 * 当事人
	 * @param Name_nur_psn
	 */
	public void setName_nur_psn(String Name_nur_psn) {
		setAttrVal("Name_nur_psn", Name_nur_psn);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 职称
	 * @return String
	 */
	public String getName_emptitle() {
		return ((String) getAttrVal("Name_emptitle"));
	}	
	/**
	 * 职称
	 * @param Name_emptitle
	 */
	public void setName_emptitle(String Name_emptitle) {
		setAttrVal("Name_emptitle", Name_emptitle);
	}
	/**
	 * 月份
	 * @return String
	 */
	public String getName_month() {
		return ((String) getAttrVal("Name_month"));
	}	
	/**
	 * 月份
	 * @param Name_month
	 */
	public void setName_month(String Name_month) {
		setAttrVal("Name_month", Name_month);
	}
	/**
	 * 不良事件分类
	 * @return String
	 */
	public String getName_adev_ca() {
		return ((String) getAttrVal("Name_adev_ca"));
	}	
	/**
	 * 不良事件分类
	 * @param Name_adev_ca
	 */
	public void setName_adev_ca(String Name_adev_ca) {
		setAttrVal("Name_adev_ca", Name_adev_ca);
	}
	/**
	 * 不良事件原因分类
	 * @return String
	 */
	public String getName_reason_ca() {
		return ((String) getAttrVal("Name_reason_ca"));
	}	
	/**
	 * 不良事件原因分类
	 * @param Name_reason_ca
	 */
	public void setName_reason_ca(String Name_reason_ca) {
		setAttrVal("Name_reason_ca", Name_reason_ca);
	}
	/**
	 * 护士长签名
	 * @return String
	 */
	public String getName_nur_head() {
		return ((String) getAttrVal("Name_nur_head"));
	}	
	/**
	 * 护士长签名
	 * @param Name_nur_head
	 */
	public void setName_nur_head(String Name_nur_head) {
		setAttrVal("Name_nur_head", Name_nur_head);
	}
	/**
	 * 护理部签名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 护理部签名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 上报人
	 * @return String
	 */
	public String getName_report_psn() {
		return ((String) getAttrVal("Name_report_psn"));
	}	
	/**
	 * 上报人
	 * @param Name_report_psn
	 */
	public void setName_report_psn(String Name_report_psn) {
		setAttrVal("Name_report_psn", Name_report_psn);
	}
	/**
	 * 上报状态
	 * @return String
	 */
	public String getName_audit_status() {
		return ((String) getAttrVal("Name_audit_status"));
	}	
	/**
	 * 上报状态
	 * @param Name_audit_status
	 */
	public void setName_audit_status(String Name_audit_status) {
		setAttrVal("Name_audit_status", Name_audit_status);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getName_audit() {
		return ((String) getAttrVal("Name_audit"));
	}	
	/**
	 * 审核人姓名
	 * @param Name_audit
	 */
	public void setName_audit(String Name_audit) {
		setAttrVal("Name_audit", Name_audit);
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
		return "Id_nqm_adev";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_nqm_adev";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmAdEvDODesc.class);
	}
	
}