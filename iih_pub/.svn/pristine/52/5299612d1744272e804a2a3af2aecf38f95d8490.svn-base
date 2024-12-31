package iih.nm.nhr.nmnhrschedrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnhrschedrp.d.desc.NhrSchedRpDODesc;
import java.math.BigDecimal;

/**
 * 替班申请 DO数据 
 * 
 */
public class NhrSchedRpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//替班申请主键
	public static final String ID_NHR_SCHED_RP= "Id_nhr_sched_rp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//申请人
	public static final String ID_NUR_APY= "Id_nur_apy";
	//人员基本属性(申请人)
	public static final String ID_PSNDOC= "Id_psndoc";
	//申请人护理单元
	public static final String ID_DEP_APY= "Id_dep_apy";
	//申请人护士层级
	public static final String ID_NUR_LVL_APY= "Id_nur_lvl_apy";
	//申请人护士层级编码
	public static final String SD_NUR_LVL_APY= "Sd_nur_lvl_apy";
	//替班人
	public static final String ID_NUR_RP= "Id_nur_rp";
	//替班人护理单元
	public static final String ID_DEP_RP= "Id_dep_rp";
	//替班人护士层级
	public static final String ID_NUR_LVL_RP= "Id_nur_lvl_rp";
	//替班人护士层级编码
	public static final String SD_NUR_LVL_RP= "Sd_nur_lvl_rp";
	//申请人原班次
	public static final String ID_NHR_SI_APY_OLD= "Id_nhr_si_apy_old";
	//申请人新班次
	public static final String ID_NHR_SI_APY_NEW= "Id_nhr_si_apy_new";
	//替班人原班次
	public static final String ID_NHR_SI_RP_OLD= "Id_nhr_si_rp_old";
	//替班人新班次
	public static final String ID_NHR_SI_RP_NEW= "Id_nhr_si_rp_new";
	//替班日期
	public static final String DT_RP= "Dt_rp";
	//申请事由编码
	public static final String SD_APY_REASON= "Sd_apy_reason";
	//申请事由
	public static final String ID_APY_REASON= "Id_apy_reason";
	//申请状态
	public static final String ID_APY_STATUS= "Id_apy_status";
	//申请状态编码
	public static final String SD_APY_STATUS= "Sd_apy_status";
	//登记人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//登记时间
	public static final String DT_REG= "Dt_reg";
	//流程任务ID
	public static final String ID_TASK= "Id_task";
	//审核人
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	//审核时间
	public static final String DT_AUDIT= "Dt_audit";
	//审核意见
	public static final String APCOMMENTS= "Apcomments";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员姓名
	public static final String NAME_NUR_APY= "Name_nur_apy";
	//人员
	public static final String NAME_PSNDOC= "Name_psndoc";
	//申请人护理单元
	public static final String DEP_APY_NAME= "Dep_apy_name";
	//名称
	public static final String NAME_LVL_APY= "Name_lvl_apy";
	//人员姓名
	public static final String NAME_NHR_RP= "Name_nhr_rp";
	//替班人护理单元
	public static final String DEP_RP_NAME= "Dep_rp_name";
	//名称
	public static final String NAME_LVL_RP= "Name_lvl_rp";
	//排班班次
	public static final String NAME_APY_NHR_SI= "Name_apy_nhr_si";
	//名称
	public static final String NAME_APY_NEW= "Name_apy_new";
	//简称
	public static final String NAME_SHORT_APY_NEW= "Name_short_apy_new";
	//排班班次
	public static final String NAME_RP_NHR_SI= "Name_rp_nhr_si";
	//名称
	public static final String NAME_RP_NEW= "Name_rp_new";
	//简称
	public static final String NAME_SHORT_RP_NEW= "Name_short_rp_new";
	//名称
	public static final String NAME_APY_REASON= "Name_apy_reason";
	//名称
	public static final String NAME_APY_STATUS= "Name_apy_status";
	//人员姓名
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 替班申请主键
	 * @return String
	 */
	public String getId_nhr_sched_rp() {
		return ((String) getAttrVal("Id_nhr_sched_rp"));
	}	
	/**
	 * 替班申请主键
	 * @param Id_nhr_sched_rp
	 */
	public void setId_nhr_sched_rp(String Id_nhr_sched_rp) {
		setAttrVal("Id_nhr_sched_rp", Id_nhr_sched_rp);
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
	 * 人员基本属性(申请人)
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员基本属性(申请人)
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 申请人护理单元
	 * @return String
	 */
	public String getId_dep_apy() {
		return ((String) getAttrVal("Id_dep_apy"));
	}	
	/**
	 * 申请人护理单元
	 * @param Id_dep_apy
	 */
	public void setId_dep_apy(String Id_dep_apy) {
		setAttrVal("Id_dep_apy", Id_dep_apy);
	}
	/**
	 * 申请人护士层级
	 * @return String
	 */
	public String getId_nur_lvl_apy() {
		return ((String) getAttrVal("Id_nur_lvl_apy"));
	}	
	/**
	 * 申请人护士层级
	 * @param Id_nur_lvl_apy
	 */
	public void setId_nur_lvl_apy(String Id_nur_lvl_apy) {
		setAttrVal("Id_nur_lvl_apy", Id_nur_lvl_apy);
	}
	/**
	 * 申请人护士层级编码
	 * @return String
	 */
	public String getSd_nur_lvl_apy() {
		return ((String) getAttrVal("Sd_nur_lvl_apy"));
	}	
	/**
	 * 申请人护士层级编码
	 * @param Sd_nur_lvl_apy
	 */
	public void setSd_nur_lvl_apy(String Sd_nur_lvl_apy) {
		setAttrVal("Sd_nur_lvl_apy", Sd_nur_lvl_apy);
	}
	/**
	 * 替班人
	 * @return String
	 */
	public String getId_nur_rp() {
		return ((String) getAttrVal("Id_nur_rp"));
	}	
	/**
	 * 替班人
	 * @param Id_nur_rp
	 */
	public void setId_nur_rp(String Id_nur_rp) {
		setAttrVal("Id_nur_rp", Id_nur_rp);
	}
	/**
	 * 替班人护理单元
	 * @return String
	 */
	public String getId_dep_rp() {
		return ((String) getAttrVal("Id_dep_rp"));
	}	
	/**
	 * 替班人护理单元
	 * @param Id_dep_rp
	 */
	public void setId_dep_rp(String Id_dep_rp) {
		setAttrVal("Id_dep_rp", Id_dep_rp);
	}
	/**
	 * 替班人护士层级
	 * @return String
	 */
	public String getId_nur_lvl_rp() {
		return ((String) getAttrVal("Id_nur_lvl_rp"));
	}	
	/**
	 * 替班人护士层级
	 * @param Id_nur_lvl_rp
	 */
	public void setId_nur_lvl_rp(String Id_nur_lvl_rp) {
		setAttrVal("Id_nur_lvl_rp", Id_nur_lvl_rp);
	}
	/**
	 * 替班人护士层级编码
	 * @return String
	 */
	public String getSd_nur_lvl_rp() {
		return ((String) getAttrVal("Sd_nur_lvl_rp"));
	}	
	/**
	 * 替班人护士层级编码
	 * @param Sd_nur_lvl_rp
	 */
	public void setSd_nur_lvl_rp(String Sd_nur_lvl_rp) {
		setAttrVal("Sd_nur_lvl_rp", Sd_nur_lvl_rp);
	}
	/**
	 * 申请人原班次
	 * @return String
	 */
	public String getId_nhr_si_apy_old() {
		return ((String) getAttrVal("Id_nhr_si_apy_old"));
	}	
	/**
	 * 申请人原班次
	 * @param Id_nhr_si_apy_old
	 */
	public void setId_nhr_si_apy_old(String Id_nhr_si_apy_old) {
		setAttrVal("Id_nhr_si_apy_old", Id_nhr_si_apy_old);
	}
	/**
	 * 申请人新班次
	 * @return String
	 */
	public String getId_nhr_si_apy_new() {
		return ((String) getAttrVal("Id_nhr_si_apy_new"));
	}	
	/**
	 * 申请人新班次
	 * @param Id_nhr_si_apy_new
	 */
	public void setId_nhr_si_apy_new(String Id_nhr_si_apy_new) {
		setAttrVal("Id_nhr_si_apy_new", Id_nhr_si_apy_new);
	}
	/**
	 * 替班人原班次
	 * @return String
	 */
	public String getId_nhr_si_rp_old() {
		return ((String) getAttrVal("Id_nhr_si_rp_old"));
	}	
	/**
	 * 替班人原班次
	 * @param Id_nhr_si_rp_old
	 */
	public void setId_nhr_si_rp_old(String Id_nhr_si_rp_old) {
		setAttrVal("Id_nhr_si_rp_old", Id_nhr_si_rp_old);
	}
	/**
	 * 替班人新班次
	 * @return String
	 */
	public String getId_nhr_si_rp_new() {
		return ((String) getAttrVal("Id_nhr_si_rp_new"));
	}	
	/**
	 * 替班人新班次
	 * @param Id_nhr_si_rp_new
	 */
	public void setId_nhr_si_rp_new(String Id_nhr_si_rp_new) {
		setAttrVal("Id_nhr_si_rp_new", Id_nhr_si_rp_new);
	}
	/**
	 * 替班日期
	 * @return FDate
	 */
	public FDate getDt_rp() {
		return ((FDate) getAttrVal("Dt_rp"));
	}	
	/**
	 * 替班日期
	 * @param Dt_rp
	 */
	public void setDt_rp(FDate Dt_rp) {
		setAttrVal("Dt_rp", Dt_rp);
	}
	/**
	 * 申请事由编码
	 * @return String
	 */
	public String getSd_apy_reason() {
		return ((String) getAttrVal("Sd_apy_reason"));
	}	
	/**
	 * 申请事由编码
	 * @param Sd_apy_reason
	 */
	public void setSd_apy_reason(String Sd_apy_reason) {
		setAttrVal("Sd_apy_reason", Sd_apy_reason);
	}
	/**
	 * 申请事由
	 * @return String
	 */
	public String getId_apy_reason() {
		return ((String) getAttrVal("Id_apy_reason"));
	}	
	/**
	 * 申请事由
	 * @param Id_apy_reason
	 */
	public void setId_apy_reason(String Id_apy_reason) {
		setAttrVal("Id_apy_reason", Id_apy_reason);
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
	 * 登记人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 登记时间
	 * @return String
	 */
	public String getDt_reg() {
		return ((String) getAttrVal("Dt_reg"));
	}	
	/**
	 * 登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(String Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	 * 人员
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 人员
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 申请人护理单元
	 * @return String
	 */
	public String getDep_apy_name() {
		return ((String) getAttrVal("Dep_apy_name"));
	}	
	/**
	 * 申请人护理单元
	 * @param Dep_apy_name
	 */
	public void setDep_apy_name(String Dep_apy_name) {
		setAttrVal("Dep_apy_name", Dep_apy_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_lvl_apy() {
		return ((String) getAttrVal("Name_lvl_apy"));
	}	
	/**
	 * 名称
	 * @param Name_lvl_apy
	 */
	public void setName_lvl_apy(String Name_lvl_apy) {
		setAttrVal("Name_lvl_apy", Name_lvl_apy);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_nhr_rp() {
		return ((String) getAttrVal("Name_nhr_rp"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nhr_rp
	 */
	public void setName_nhr_rp(String Name_nhr_rp) {
		setAttrVal("Name_nhr_rp", Name_nhr_rp);
	}
	/**
	 * 替班人护理单元
	 * @return String
	 */
	public String getDep_rp_name() {
		return ((String) getAttrVal("Dep_rp_name"));
	}	
	/**
	 * 替班人护理单元
	 * @param Dep_rp_name
	 */
	public void setDep_rp_name(String Dep_rp_name) {
		setAttrVal("Dep_rp_name", Dep_rp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_lvl_rp() {
		return ((String) getAttrVal("Name_lvl_rp"));
	}	
	/**
	 * 名称
	 * @param Name_lvl_rp
	 */
	public void setName_lvl_rp(String Name_lvl_rp) {
		setAttrVal("Name_lvl_rp", Name_lvl_rp);
	}
	/**
	 * 排班班次
	 * @return String
	 */
	public String getName_apy_nhr_si() {
		return ((String) getAttrVal("Name_apy_nhr_si"));
	}	
	/**
	 * 排班班次
	 * @param Name_apy_nhr_si
	 */
	public void setName_apy_nhr_si(String Name_apy_nhr_si) {
		setAttrVal("Name_apy_nhr_si", Name_apy_nhr_si);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_apy_new() {
		return ((String) getAttrVal("Name_apy_new"));
	}	
	/**
	 * 名称
	 * @param Name_apy_new
	 */
	public void setName_apy_new(String Name_apy_new) {
		setAttrVal("Name_apy_new", Name_apy_new);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getName_short_apy_new() {
		return ((String) getAttrVal("Name_short_apy_new"));
	}	
	/**
	 * 简称
	 * @param Name_short_apy_new
	 */
	public void setName_short_apy_new(String Name_short_apy_new) {
		setAttrVal("Name_short_apy_new", Name_short_apy_new);
	}
	/**
	 * 排班班次
	 * @return String
	 */
	public String getName_rp_nhr_si() {
		return ((String) getAttrVal("Name_rp_nhr_si"));
	}	
	/**
	 * 排班班次
	 * @param Name_rp_nhr_si
	 */
	public void setName_rp_nhr_si(String Name_rp_nhr_si) {
		setAttrVal("Name_rp_nhr_si", Name_rp_nhr_si);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rp_new() {
		return ((String) getAttrVal("Name_rp_new"));
	}	
	/**
	 * 名称
	 * @param Name_rp_new
	 */
	public void setName_rp_new(String Name_rp_new) {
		setAttrVal("Name_rp_new", Name_rp_new);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getName_short_rp_new() {
		return ((String) getAttrVal("Name_short_rp_new"));
	}	
	/**
	 * 简称
	 * @param Name_short_rp_new
	 */
	public void setName_short_rp_new(String Name_short_rp_new) {
		setAttrVal("Name_short_rp_new", Name_short_rp_new);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_apy_reason() {
		return ((String) getAttrVal("Name_apy_reason"));
	}	
	/**
	 * 名称
	 * @param Name_apy_reason
	 */
	public void setName_apy_reason(String Name_apy_reason) {
		setAttrVal("Name_apy_reason", Name_apy_reason);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_apy_status() {
		return ((String) getAttrVal("Name_apy_status"));
	}	
	/**
	 * 名称
	 * @param Name_apy_status
	 */
	public void setName_apy_status(String Name_apy_status) {
		setAttrVal("Name_apy_status", Name_apy_status);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	/**
	 * 人员姓名
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
		return "Id_nhr_sched_rp";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_sched_rp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NhrSchedRpDODesc.class);
	}
	
}