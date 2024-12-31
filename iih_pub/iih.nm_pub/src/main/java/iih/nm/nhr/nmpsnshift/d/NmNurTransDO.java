package iih.nm.nhr.nmpsnshift.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmpsnshift.d.desc.NmNurTransDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_人员调动 DO数据 
 * 
 */
public class NmNurTransDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//人员调动主键标识
	public static final String ID_NUR_TRANS= "Id_nur_trans";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GROUP= "Id_group";
	//调动人员
	public static final String ID_NUR= "Id_nur";
	//调动人员编码
	public static final String CODE= "Code";
	//调动日期
	public static final String DT_TRANS= "Dt_trans";
	//调入日期
	public static final String DT_IN= "Dt_in";
	//调出日期
	public static final String DT_OUT= "Dt_out";
	//调入护理单元
	public static final String ID_DEP_NUR_IN= "Id_dep_nur_in";
	//调入科室
	public static final String ID_DEP_IN= "Id_dep_in";
	//调出护理单元
	public static final String ID_DEP_NUR_OUT= "Id_dep_nur_out";
	//调出科室
	public static final String ID_DEP_OUT= "Id_dep_out";
	//职务
	public static final String ID_JOB= "Id_job";
	//职称
	public static final String ID_TITLE= "Id_title";
	//职称ID
	public static final String SD_TITLE= "Sd_title";
	//调动原因主键标识
	public static final String ID_TRANS_RES= "Id_trans_res";
	//调动原因编码
	public static final String SD_TRANS_RES= "Sd_trans_res";
	//申请人
	public static final String ID_EMP_APPLY= "Id_emp_apply";
	//申请时间
	public static final String DT_APPLY= "Dt_apply";
	//备注
	public static final String DESC_APPLY= "Desc_apply";
	//流程任务ID
	public static final String ID_TASK= "Id_task";
	//审核状态ID
	public static final String ID_APPLYSTATUS= "Id_applystatus";
	//审核状态编码
	public static final String SD_APPLYSTATUS= "Sd_applystatus";
	//当前行政部门
	public static final String ID_DEP_ADMIN= "Id_dep_admin";
	//审核人
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
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
	//序号
	public static final String NUMERICAL_ORDER= "Numerical_order";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GROUP= "Name_group";
	//调动人员
	public static final String NAME_NUR= "Name_nur";
	//人员id
	public static final String ID_PSNDOC= "Id_psndoc";
	//调入护理单元
	public static final String NAME_DEP_NUR_IN= "Name_dep_nur_in";
	//调入科室名称
	public static final String NAME_DEPIN= "Name_depin";
	//调入科室编码
	public static final String CODE_DEPIN= "Code_depin";
	//调出护理单元
	public static final String NAME_DEP_NUR_OUT= "Name_dep_nur_out";
	//调出科室编码
	public static final String CODE_DEPOUT= "Code_depout";
	//调出科室名称
	public static final String NAME_DEPOUT= "Name_depout";
	//职务名称
	public static final String NAME_JOB= "Name_job";
	//名称
	public static final String NAME_TITLE= "Name_title";
	//调动原因
	public static final String NAME_TRANS_RES= "Name_trans_res";
	//申请人
	public static final String NAME_EMP_APPLY= "Name_emp_apply";
	//名称
	public static final String NAME_APPLYSTATUS= "Name_applystatus";
	//行政归属部门
	public static final String NAME_DEP_ADMIN= "Name_dep_admin";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 人员调动主键标识
	 * @return String
	 */
	public String getId_nur_trans() {
		return ((String) getAttrVal("Id_nur_trans"));
	}	
	/**
	 * 人员调动主键标识
	 * @param Id_nur_trans
	 */
	public void setId_nur_trans(String Id_nur_trans) {
		setAttrVal("Id_nur_trans", Id_nur_trans);
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
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	/**
	 * 所属集团
	 * @param Id_group
	 */
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	/**
	 * 调动人员
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 调动人员
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 调动人员编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 调动人员编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 调动日期
	 * @return FDate
	 */
	public FDate getDt_trans() {
		return ((FDate) getAttrVal("Dt_trans"));
	}	
	/**
	 * 调动日期
	 * @param Dt_trans
	 */
	public void setDt_trans(FDate Dt_trans) {
		setAttrVal("Dt_trans", Dt_trans);
	}
	/**
	 * 调入日期
	 * @return FDate
	 */
	public FDate getDt_in() {
		return ((FDate) getAttrVal("Dt_in"));
	}	
	/**
	 * 调入日期
	 * @param Dt_in
	 */
	public void setDt_in(FDate Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 调出日期
	 * @return FDate
	 */
	public FDate getDt_out() {
		return ((FDate) getAttrVal("Dt_out"));
	}	
	/**
	 * 调出日期
	 * @param Dt_out
	 */
	public void setDt_out(FDate Dt_out) {
		setAttrVal("Dt_out", Dt_out);
	}
	/**
	 * 调入护理单元
	 * @return String
	 */
	public String getId_dep_nur_in() {
		return ((String) getAttrVal("Id_dep_nur_in"));
	}	
	/**
	 * 调入护理单元
	 * @param Id_dep_nur_in
	 */
	public void setId_dep_nur_in(String Id_dep_nur_in) {
		setAttrVal("Id_dep_nur_in", Id_dep_nur_in);
	}
	/**
	 * 调入科室
	 * @return String
	 */
	public String getId_dep_in() {
		return ((String) getAttrVal("Id_dep_in"));
	}	
	/**
	 * 调入科室
	 * @param Id_dep_in
	 */
	public void setId_dep_in(String Id_dep_in) {
		setAttrVal("Id_dep_in", Id_dep_in);
	}
	/**
	 * 调出护理单元
	 * @return String
	 */
	public String getId_dep_nur_out() {
		return ((String) getAttrVal("Id_dep_nur_out"));
	}	
	/**
	 * 调出护理单元
	 * @param Id_dep_nur_out
	 */
	public void setId_dep_nur_out(String Id_dep_nur_out) {
		setAttrVal("Id_dep_nur_out", Id_dep_nur_out);
	}
	/**
	 * 调出科室
	 * @return String
	 */
	public String getId_dep_out() {
		return ((String) getAttrVal("Id_dep_out"));
	}	
	/**
	 * 调出科室
	 * @param Id_dep_out
	 */
	public void setId_dep_out(String Id_dep_out) {
		setAttrVal("Id_dep_out", Id_dep_out);
	}
	/**
	 * 职务
	 * @return String
	 */
	public String getId_job() {
		return ((String) getAttrVal("Id_job"));
	}	
	/**
	 * 职务
	 * @param Id_job
	 */
	public void setId_job(String Id_job) {
		setAttrVal("Id_job", Id_job);
	}
	/**
	 * 职称
	 * @return String
	 */
	public String getId_title() {
		return ((String) getAttrVal("Id_title"));
	}	
	/**
	 * 职称
	 * @param Id_title
	 */
	public void setId_title(String Id_title) {
		setAttrVal("Id_title", Id_title);
	}
	/**
	 * 职称ID
	 * @return String
	 */
	public String getSd_title() {
		return ((String) getAttrVal("Sd_title"));
	}	
	/**
	 * 职称ID
	 * @param Sd_title
	 */
	public void setSd_title(String Sd_title) {
		setAttrVal("Sd_title", Sd_title);
	}
	/**
	 * 调动原因主键标识
	 * @return String
	 */
	public String getId_trans_res() {
		return ((String) getAttrVal("Id_trans_res"));
	}	
	/**
	 * 调动原因主键标识
	 * @param Id_trans_res
	 */
	public void setId_trans_res(String Id_trans_res) {
		setAttrVal("Id_trans_res", Id_trans_res);
	}
	/**
	 * 调动原因编码
	 * @return String
	 */
	public String getSd_trans_res() {
		return ((String) getAttrVal("Sd_trans_res"));
	}	
	/**
	 * 调动原因编码
	 * @param Sd_trans_res
	 */
	public void setSd_trans_res(String Sd_trans_res) {
		setAttrVal("Sd_trans_res", Sd_trans_res);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_emp_apply() {
		return ((String) getAttrVal("Id_emp_apply"));
	}	
	/**
	 * 申请人
	 * @param Id_emp_apply
	 */
	public void setId_emp_apply(String Id_emp_apply) {
		setAttrVal("Id_emp_apply", Id_emp_apply);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apply() {
		return ((FDateTime) getAttrVal("Dt_apply"));
	}	
	/**
	 * 申请时间
	 * @param Dt_apply
	 */
	public void setDt_apply(FDateTime Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDesc_apply() {
		return ((String) getAttrVal("Desc_apply"));
	}	
	/**
	 * 备注
	 * @param Desc_apply
	 */
	public void setDesc_apply(String Desc_apply) {
		setAttrVal("Desc_apply", Desc_apply);
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
	 * 审核状态ID
	 * @return String
	 */
	public String getId_applystatus() {
		return ((String) getAttrVal("Id_applystatus"));
	}	
	/**
	 * 审核状态ID
	 * @param Id_applystatus
	 */
	public void setId_applystatus(String Id_applystatus) {
		setAttrVal("Id_applystatus", Id_applystatus);
	}
	/**
	 * 审核状态编码
	 * @return String
	 */
	public String getSd_applystatus() {
		return ((String) getAttrVal("Sd_applystatus"));
	}	
	/**
	 * 审核状态编码
	 * @param Sd_applystatus
	 */
	public void setSd_applystatus(String Sd_applystatus) {
		setAttrVal("Sd_applystatus", Sd_applystatus);
	}
	/**
	 * 当前行政部门
	 * @return String
	 */
	public String getId_dep_admin() {
		return ((String) getAttrVal("Id_dep_admin"));
	}	
	/**
	 * 当前行政部门
	 * @param Id_dep_admin
	 */
	public void setId_dep_admin(String Id_dep_admin) {
		setAttrVal("Id_dep_admin", Id_dep_admin);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	/**
	 * 审核人
	 * @param Name_emp_audit
	 */
	public void setName_emp_audit(String Name_emp_audit) {
		setAttrVal("Name_emp_audit", Name_emp_audit);
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
	 * 序号
	 * @return String
	 */
	public String getNumerical_order() {
		return ((String) getAttrVal("Numerical_order"));
	}	
	/**
	 * 序号
	 * @param Numerical_order
	 */
	public void setNumerical_order(String Numerical_order) {
		setAttrVal("Numerical_order", Numerical_order);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_group() {
		return ((String) getAttrVal("Name_group"));
	}	
	/**
	 * 名称
	 * @param Name_group
	 */
	public void setName_group(String Name_group) {
		setAttrVal("Name_group", Name_group);
	}
	/**
	 * 调动人员
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 调动人员
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
	 * 调入护理单元
	 * @return String
	 */
	public String getName_dep_nur_in() {
		return ((String) getAttrVal("Name_dep_nur_in"));
	}	
	/**
	 * 调入护理单元
	 * @param Name_dep_nur_in
	 */
	public void setName_dep_nur_in(String Name_dep_nur_in) {
		setAttrVal("Name_dep_nur_in", Name_dep_nur_in);
	}
	/**
	 * 调入科室名称
	 * @return String
	 */
	public String getName_depin() {
		return ((String) getAttrVal("Name_depin"));
	}	
	/**
	 * 调入科室名称
	 * @param Name_depin
	 */
	public void setName_depin(String Name_depin) {
		setAttrVal("Name_depin", Name_depin);
	}
	/**
	 * 调入科室编码
	 * @return String
	 */
	public String getCode_depin() {
		return ((String) getAttrVal("Code_depin"));
	}	
	/**
	 * 调入科室编码
	 * @param Code_depin
	 */
	public void setCode_depin(String Code_depin) {
		setAttrVal("Code_depin", Code_depin);
	}
	/**
	 * 调出护理单元
	 * @return String
	 */
	public String getName_dep_nur_out() {
		return ((String) getAttrVal("Name_dep_nur_out"));
	}	
	/**
	 * 调出护理单元
	 * @param Name_dep_nur_out
	 */
	public void setName_dep_nur_out(String Name_dep_nur_out) {
		setAttrVal("Name_dep_nur_out", Name_dep_nur_out);
	}
	/**
	 * 调出科室编码
	 * @return String
	 */
	public String getCode_depout() {
		return ((String) getAttrVal("Code_depout"));
	}	
	/**
	 * 调出科室编码
	 * @param Code_depout
	 */
	public void setCode_depout(String Code_depout) {
		setAttrVal("Code_depout", Code_depout);
	}
	/**
	 * 调出科室名称
	 * @return String
	 */
	public String getName_depout() {
		return ((String) getAttrVal("Name_depout"));
	}	
	/**
	 * 调出科室名称
	 * @param Name_depout
	 */
	public void setName_depout(String Name_depout) {
		setAttrVal("Name_depout", Name_depout);
	}
	/**
	 * 职务名称
	 * @return String
	 */
	public String getName_job() {
		return ((String) getAttrVal("Name_job"));
	}	
	/**
	 * 职务名称
	 * @param Name_job
	 */
	public void setName_job(String Name_job) {
		setAttrVal("Name_job", Name_job);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_title() {
		return ((String) getAttrVal("Name_title"));
	}	
	/**
	 * 名称
	 * @param Name_title
	 */
	public void setName_title(String Name_title) {
		setAttrVal("Name_title", Name_title);
	}
	/**
	 * 调动原因
	 * @return String
	 */
	public String getName_trans_res() {
		return ((String) getAttrVal("Name_trans_res"));
	}	
	/**
	 * 调动原因
	 * @param Name_trans_res
	 */
	public void setName_trans_res(String Name_trans_res) {
		setAttrVal("Name_trans_res", Name_trans_res);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getName_emp_apply() {
		return ((String) getAttrVal("Name_emp_apply"));
	}	
	/**
	 * 申请人
	 * @param Name_emp_apply
	 */
	public void setName_emp_apply(String Name_emp_apply) {
		setAttrVal("Name_emp_apply", Name_emp_apply);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_applystatus() {
		return ((String) getAttrVal("Name_applystatus"));
	}	
	/**
	 * 名称
	 * @param Name_applystatus
	 */
	public void setName_applystatus(String Name_applystatus) {
		setAttrVal("Name_applystatus", Name_applystatus);
	}
	/**
	 * 行政归属部门
	 * @return String
	 */
	public String getName_dep_admin() {
		return ((String) getAttrVal("Name_dep_admin"));
	}	
	/**
	 * 行政归属部门
	 * @param Name_dep_admin
	 */
	public void setName_dep_admin(String Name_dep_admin) {
		setAttrVal("Name_dep_admin", Name_dep_admin);
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
		return "Id_nur_trans";
	}
	
	@Override
	public String getTableName() {	  
		return "nm_nur_trans";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurTransDODesc.class);
	}
	
}