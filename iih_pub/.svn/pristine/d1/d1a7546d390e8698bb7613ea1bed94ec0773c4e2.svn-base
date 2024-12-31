package iih.nm.nhr.nmnhrschedlv.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnhrschedlv.d.desc.NmNhrSchedLvDODesc;
import java.math.BigDecimal;

/**
 * 人员请假申请 DO数据 
 * 
 */
public class NmNhrSchedLvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//人员请假申请主键
	public static final String ID_NHR_SCHED_LV= "Id_nhr_sched_lv";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//人员id
	public static final String ID_PSNDOC= "Id_psndoc";
	//申请人
	public static final String ID_NUR_APY= "Id_nur_apy";
	//申请人关联科室
	public static final String ID_DEP_APY= "Id_dep_apy";
	//申请人护理单元
	public static final String ID_DEP_NUR_APY= "Id_dep_nur_apy";
	//请假开始时间
	public static final String DT_BEGIN_LV= "Dt_begin_lv";
	//请假结束时间
	public static final String DT_END_LV= "Dt_end_lv";
	//申请天数
	public static final String DAYS_LV= "Days_lv";
	//申请事由
	public static final String REASON_LV= "Reason_lv";
	//考勤类型
	public static final String ID_CHK_CA= "Id_chk_ca";
	//考勤类型编码
	public static final String SD_CHK_CA= "Sd_chk_ca";
	//排班班次外键
	public static final String ID_NHR_SI= "Id_nhr_si";
	//申请状态
	public static final String ID_APY_STATUS= "Id_apy_status";
	//申请状态编码
	public static final String SD_APY_STATUS= "Sd_apy_status";
	//关联的请假
	public static final String ID_LV_RELATE= "Id_lv_relate";
	//冲销的请假
	public static final String ID_LV_OFFSET= "Id_lv_offset";
	//请假分类
	public static final String ID_LV_VA= "Id_lv_va";
	//请假分类编码
	public static final String SD_LV_VA= "Sd_lv_va";
	//开始时间上下午
	public static final String AMPM_LV= "Ampm_lv";
	//备注
	public static final String DES= "Des";
	//流程任务ID
	public static final String ID_TASK= "Id_task";
	//审核人
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	//审核时间
	public static final String DT_AUDIT= "Dt_audit";
	//审核意见
	public static final String APCOMMENTS= "Apcomments";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员姓名
	public static final String NAME_PSNDOC= "Name_psndoc";
	//人员姓名
	public static final String NAME_NUR_APY= "Name_nur_apy";
	//工号
	public static final String JOB_NO_NUR_APY= "Job_no_nur_apy";
	//部门名称
	public static final String NAME_DEP_APY= "Name_dep_apy";
	//上级部门
	public static final String ID_PARENT_DEP_APY= "Id_parent_dep_apy";
	//护理单元名称
	public static final String NAME_DEP_NUR_APY= "Name_dep_nur_apy";
	//考勤类型
	public static final String NAME_CHK_CA= "Name_chk_ca";
	//名称
	public static final String NAME_NHR_SI= "Name_nhr_si";
	//申请状态
	public static final String NAME_APY_STATUS= "Name_apy_status";
	//请假开始时间
	public static final String DT_BEGIN_LV_LV_RELATE= "Dt_begin_lv_lv_relate";
	//请假结束时间
	public static final String DT_END_LV_LV_RELATE= "Dt_end_lv_lv_relate";
	//申请天数
	public static final String DAYS_LV_LV_RELATE= "Days_lv_lv_relate";
	//请假结束时间
	public static final String DT_END_LV_LV_OFFSET= "Dt_end_lv_lv_offset";
	//请假开始时间
	public static final String DT_BEGIN_LV_LV_OFFSET= "Dt_begin_lv_lv_offset";
	//请假分类
	public static final String NAME_LV_VA= "Name_lv_va";
	//审批人
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 人员请假申请主键
	 * @return String
	 */
	public String getId_nhr_sched_lv() {
		return ((String) getAttrVal("Id_nhr_sched_lv"));
	}	
	/**
	 * 人员请假申请主键
	 * @param Id_nhr_sched_lv
	 */
	public void setId_nhr_sched_lv(String Id_nhr_sched_lv) {
		setAttrVal("Id_nhr_sched_lv", Id_nhr_sched_lv);
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
	 * 人员id
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员id
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_nur_apy() {
		return ((String) getAttrVal("Id_nur_apy"));
	}	
	/**
	 * 申请人
	 * @param Id_nur_apy
	 */
	public void setId_nur_apy(String Id_nur_apy) {
		setAttrVal("Id_nur_apy", Id_nur_apy);
	}
	/**
	 * 申请人关联科室
	 * @return String
	 */
	public String getId_dep_apy() {
		return ((String) getAttrVal("Id_dep_apy"));
	}	
	/**
	 * 申请人关联科室
	 * @param Id_dep_apy
	 */
	public void setId_dep_apy(String Id_dep_apy) {
		setAttrVal("Id_dep_apy", Id_dep_apy);
	}
	/**
	 * 申请人护理单元
	 * @return String
	 */
	public String getId_dep_nur_apy() {
		return ((String) getAttrVal("Id_dep_nur_apy"));
	}	
	/**
	 * 申请人护理单元
	 * @param Id_dep_nur_apy
	 */
	public void setId_dep_nur_apy(String Id_dep_nur_apy) {
		setAttrVal("Id_dep_nur_apy", Id_dep_nur_apy);
	}
	/**
	 * 请假开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin_lv() {
		return ((FDateTime) getAttrVal("Dt_begin_lv"));
	}	
	/**
	 * 请假开始时间
	 * @param Dt_begin_lv
	 */
	public void setDt_begin_lv(FDateTime Dt_begin_lv) {
		setAttrVal("Dt_begin_lv", Dt_begin_lv);
	}
	/**
	 * 请假结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_lv() {
		return ((FDateTime) getAttrVal("Dt_end_lv"));
	}	
	/**
	 * 请假结束时间
	 * @param Dt_end_lv
	 */
	public void setDt_end_lv(FDateTime Dt_end_lv) {
		setAttrVal("Dt_end_lv", Dt_end_lv);
	}
	/**
	 * 申请天数
	 * @return Integer
	 */
	public Integer getDays_lv() {
		return ((Integer) getAttrVal("Days_lv"));
	}	
	/**
	 * 申请天数
	 * @param Days_lv
	 */
	public void setDays_lv(Integer Days_lv) {
		setAttrVal("Days_lv", Days_lv);
	}
	/**
	 * 申请事由
	 * @return String
	 */
	public String getReason_lv() {
		return ((String) getAttrVal("Reason_lv"));
	}	
	/**
	 * 申请事由
	 * @param Reason_lv
	 */
	public void setReason_lv(String Reason_lv) {
		setAttrVal("Reason_lv", Reason_lv);
	}
	/**
	 * 考勤类型
	 * @return String
	 */
	public String getId_chk_ca() {
		return ((String) getAttrVal("Id_chk_ca"));
	}	
	/**
	 * 考勤类型
	 * @param Id_chk_ca
	 */
	public void setId_chk_ca(String Id_chk_ca) {
		setAttrVal("Id_chk_ca", Id_chk_ca);
	}
	/**
	 * 考勤类型编码
	 * @return String
	 */
	public String getSd_chk_ca() {
		return ((String) getAttrVal("Sd_chk_ca"));
	}	
	/**
	 * 考勤类型编码
	 * @param Sd_chk_ca
	 */
	public void setSd_chk_ca(String Sd_chk_ca) {
		setAttrVal("Sd_chk_ca", Sd_chk_ca);
	}
	/**
	 * 排班班次外键
	 * @return String
	 */
	public String getId_nhr_si() {
		return ((String) getAttrVal("Id_nhr_si"));
	}	
	/**
	 * 排班班次外键
	 * @param Id_nhr_si
	 */
	public void setId_nhr_si(String Id_nhr_si) {
		setAttrVal("Id_nhr_si", Id_nhr_si);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getId_apy_status() {
		return ((String) getAttrVal("Id_apy_status"));
	}	
	/**
	 * 申请状态
	 * @param Id_apy_status
	 */
	public void setId_apy_status(String Id_apy_status) {
		setAttrVal("Id_apy_status", Id_apy_status);
	}
	/**
	 * 申请状态编码
	 * @return String
	 */
	public String getSd_apy_status() {
		return ((String) getAttrVal("Sd_apy_status"));
	}	
	/**
	 * 申请状态编码
	 * @param Sd_apy_status
	 */
	public void setSd_apy_status(String Sd_apy_status) {
		setAttrVal("Sd_apy_status", Sd_apy_status);
	}
	/**
	 * 关联的请假
	 * @return String
	 */
	public String getId_lv_relate() {
		return ((String) getAttrVal("Id_lv_relate"));
	}	
	/**
	 * 关联的请假
	 * @param Id_lv_relate
	 */
	public void setId_lv_relate(String Id_lv_relate) {
		setAttrVal("Id_lv_relate", Id_lv_relate);
	}
	/**
	 * 冲销的请假
	 * @return String
	 */
	public String getId_lv_offset() {
		return ((String) getAttrVal("Id_lv_offset"));
	}	
	/**
	 * 冲销的请假
	 * @param Id_lv_offset
	 */
	public void setId_lv_offset(String Id_lv_offset) {
		setAttrVal("Id_lv_offset", Id_lv_offset);
	}
	/**
	 * 请假分类
	 * @return String
	 */
	public String getId_lv_va() {
		return ((String) getAttrVal("Id_lv_va"));
	}	
	/**
	 * 请假分类
	 * @param Id_lv_va
	 */
	public void setId_lv_va(String Id_lv_va) {
		setAttrVal("Id_lv_va", Id_lv_va);
	}
	/**
	 * 请假分类编码
	 * @return String
	 */
	public String getSd_lv_va() {
		return ((String) getAttrVal("Sd_lv_va"));
	}	
	/**
	 * 请假分类编码
	 * @param Sd_lv_va
	 */
	public void setSd_lv_va(String Sd_lv_va) {
		setAttrVal("Sd_lv_va", Sd_lv_va);
	}
	/**
	 * 开始时间上下午
	 * @return String
	 */
	public String getAmpm_lv() {
		return ((String) getAttrVal("Ampm_lv"));
	}	
	/**
	 * 开始时间上下午
	 * @param Ampm_lv
	 */
	public void setAmpm_lv(String Ampm_lv) {
		setAttrVal("Ampm_lv", Ampm_lv);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 审核人
	 * @return String
	 */
	public String getId_emp_audit() {
		return ((String) getAttrVal("Id_emp_audit"));
	}	
	/**
	 * 审核人
	 * @param Id_emp_audit
	 */
	public void setId_emp_audit(String Id_emp_audit) {
		setAttrVal("Id_emp_audit", Id_emp_audit);
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
	public String getApcomments() {
		return ((String) getAttrVal("Apcomments"));
	}	
	/**
	 * 审核意见
	 * @param Apcomments
	 */
	public void setApcomments(String Apcomments) {
		setAttrVal("Apcomments", Apcomments);
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
	 * 人员姓名
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 人员姓名
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_nur_apy() {
		return ((String) getAttrVal("Name_nur_apy"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nur_apy
	 */
	public void setName_nur_apy(String Name_nur_apy) {
		setAttrVal("Name_nur_apy", Name_nur_apy);
	}
	/**
	 * 工号
	 * @return String
	 */
	public String getJob_no_nur_apy() {
		return ((String) getAttrVal("Job_no_nur_apy"));
	}	
	/**
	 * 工号
	 * @param Job_no_nur_apy
	 */
	public void setJob_no_nur_apy(String Job_no_nur_apy) {
		setAttrVal("Job_no_nur_apy", Job_no_nur_apy);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep_apy() {
		return ((String) getAttrVal("Name_dep_apy"));
	}	
	/**
	 * 部门名称
	 * @param Name_dep_apy
	 */
	public void setName_dep_apy(String Name_dep_apy) {
		setAttrVal("Name_dep_apy", Name_dep_apy);
	}
	/**
	 * 上级部门
	 * @return String
	 */
	public String getId_parent_dep_apy() {
		return ((String) getAttrVal("Id_parent_dep_apy"));
	}	
	/**
	 * 上级部门
	 * @param Id_parent_dep_apy
	 */
	public void setId_parent_dep_apy(String Id_parent_dep_apy) {
		setAttrVal("Id_parent_dep_apy", Id_parent_dep_apy);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_dep_nur_apy() {
		return ((String) getAttrVal("Name_dep_nur_apy"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_dep_nur_apy
	 */
	public void setName_dep_nur_apy(String Name_dep_nur_apy) {
		setAttrVal("Name_dep_nur_apy", Name_dep_nur_apy);
	}
	/**
	 * 考勤类型
	 * @return String
	 */
	public String getName_chk_ca() {
		return ((String) getAttrVal("Name_chk_ca"));
	}	
	/**
	 * 考勤类型
	 * @param Name_chk_ca
	 */
	public void setName_chk_ca(String Name_chk_ca) {
		setAttrVal("Name_chk_ca", Name_chk_ca);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nhr_si() {
		return ((String) getAttrVal("Name_nhr_si"));
	}	
	/**
	 * 名称
	 * @param Name_nhr_si
	 */
	public void setName_nhr_si(String Name_nhr_si) {
		setAttrVal("Name_nhr_si", Name_nhr_si);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getName_apy_status() {
		return ((String) getAttrVal("Name_apy_status"));
	}	
	/**
	 * 申请状态
	 * @param Name_apy_status
	 */
	public void setName_apy_status(String Name_apy_status) {
		setAttrVal("Name_apy_status", Name_apy_status);
	}
	/**
	 * 请假开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin_lv_lv_relate() {
		return ((FDateTime) getAttrVal("Dt_begin_lv_lv_relate"));
	}	
	/**
	 * 请假开始时间
	 * @param Dt_begin_lv_lv_relate
	 */
	public void setDt_begin_lv_lv_relate(FDateTime Dt_begin_lv_lv_relate) {
		setAttrVal("Dt_begin_lv_lv_relate", Dt_begin_lv_lv_relate);
	}
	/**
	 * 请假结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_lv_lv_relate() {
		return ((FDateTime) getAttrVal("Dt_end_lv_lv_relate"));
	}	
	/**
	 * 请假结束时间
	 * @param Dt_end_lv_lv_relate
	 */
	public void setDt_end_lv_lv_relate(FDateTime Dt_end_lv_lv_relate) {
		setAttrVal("Dt_end_lv_lv_relate", Dt_end_lv_lv_relate);
	}
	/**
	 * 申请天数
	 * @return Integer
	 */
	public Integer getDays_lv_lv_relate() {
		return ((Integer) getAttrVal("Days_lv_lv_relate"));
	}	
	/**
	 * 申请天数
	 * @param Days_lv_lv_relate
	 */
	public void setDays_lv_lv_relate(Integer Days_lv_lv_relate) {
		setAttrVal("Days_lv_lv_relate", Days_lv_lv_relate);
	}
	/**
	 * 请假结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_lv_lv_offset() {
		return ((FDateTime) getAttrVal("Dt_end_lv_lv_offset"));
	}	
	/**
	 * 请假结束时间
	 * @param Dt_end_lv_lv_offset
	 */
	public void setDt_end_lv_lv_offset(FDateTime Dt_end_lv_lv_offset) {
		setAttrVal("Dt_end_lv_lv_offset", Dt_end_lv_lv_offset);
	}
	/**
	 * 请假开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin_lv_lv_offset() {
		return ((FDateTime) getAttrVal("Dt_begin_lv_lv_offset"));
	}	
	/**
	 * 请假开始时间
	 * @param Dt_begin_lv_lv_offset
	 */
	public void setDt_begin_lv_lv_offset(FDateTime Dt_begin_lv_lv_offset) {
		setAttrVal("Dt_begin_lv_lv_offset", Dt_begin_lv_lv_offset);
	}
	/**
	 * 请假分类
	 * @return String
	 */
	public String getName_lv_va() {
		return ((String) getAttrVal("Name_lv_va"));
	}	
	/**
	 * 请假分类
	 * @param Name_lv_va
	 */
	public void setName_lv_va(String Name_lv_va) {
		setAttrVal("Name_lv_va", Name_lv_va);
	}
	/**
	 * 审批人
	 * @return String
	 */
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	/**
	 * 审批人
	 * @param Name_emp_audit
	 */
	public void setName_emp_audit(String Name_emp_audit) {
		setAttrVal("Name_emp_audit", Name_emp_audit);
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
		return "Id_nhr_sched_lv";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_SCHED_LV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNhrSchedLvDODesc.class);
	}
	
}