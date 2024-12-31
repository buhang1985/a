package iih.ci.mrqc.mrborrowapply.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.mrborrowapply.d.desc.AmrBorrowApplyDODesc;
import java.math.BigDecimal;

/**
 * 病案借阅申请 DO数据 
 * 
 */
public class AmrBorrowApplyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病案借阅申请主键
	public static final String ID_AMR_BORROW_APPLY= "Id_amr_borrow_apply";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//借阅申请状态
	public static final String ID_BORROW_APPLY_STATUS= "Id_borrow_apply_status";
	//借阅申请状态编码
	public static final String SD_BORROW_APPLY_STATUS= "Sd_borrow_apply_status";
	//病案主键
	public static final String ID_AMR= "Id_amr";
	//住院病案号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//申请期限
	public static final String TIME_OVER= "Time_over";
	//审批类型
	public static final String ID_TYPE_APPROVE= "Id_type_approve";
	//审批类型编号
	public static final String SD_TYPE_APPROVE= "Sd_type_approve";
	//申请备注
	public static final String REMARK_APPLY= "Remark_apply";
	//借阅申请原因
	public static final String ID_BORROW_APPLY_REASON= "Id_borrow_apply_reason";
	//借阅原因编号
	public static final String SD_BORROW_APPLY_REASON= "Sd_borrow_apply_reason";
	//借阅申请人
	public static final String ID_BORROW_APPLY_USER= "Id_borrow_apply_user";
	//借阅申请科室
	public static final String ID_BORROW_APPLY_DEP= "Id_borrow_apply_dep";
	//借阅申请时间
	public static final String DT_BORROW_APPLY= "Dt_borrow_apply";
	//就诊主键
	public static final String ID_ENT= "Id_ent";
	//借阅审批人
	public static final String ID_AGREE_BORROW_USER= "Id_agree_borrow_user";
	//借阅审批时间
	public static final String DT_BORROW_AGREE= "Dt_borrow_agree";
	//借阅截止时间
	public static final String DT_END_BORROW= "Dt_end_borrow";
	//患者主键
	public static final String ID_PAT= "Id_pat";
	//患者性别
	public static final String ID_SEX= "Id_sex";
	//患者性别编码
	public static final String SD_SEX= "Sd_sex";
	//患者年龄
	public static final String PAT_AGE= "Pat_age";
	//就诊号code
	public static final String ENT_CODE= "Ent_code";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String BORROW_APPLY_CODE= "Borrow_apply_code";
	//名称
	public static final String BORROW_APPLY_NAME= "Borrow_apply_name";
	//编码
	public static final String TYPE_APPROVE_CODE= "Type_approve_code";
	//名称
	public static final String TYPE_APPROVE_NAME= "Type_approve_name";
	//编码
	public static final String BORROW_APPLY_REASON_CODE= "Borrow_apply_reason_code";
	//名称
	public static final String BORROW_APPLY_REASON_NAME= "Borrow_apply_reason_name";
	//用户编码
	public static final String USERR_BORROWAPPLY_CODE= "Userr_borrowapply_code";
	//用户名称
	public static final String USER_BORROWAPPLY_NAME= "User_borrowapply_name";
	//编码
	public static final String DEPR_BORROWAPPLY_CODE= "Depr_borrowapply_code";
	//名称
	public static final String DEPR_BORROWAPPLY_NAME= "Depr_borrowapply_name";
	//用户名称
	public static final String USERR_BORROWAGREE_NAME= "Userr_borrowagree_name";
	//用户编码
	public static final String USER_BORROWAGREE_CODE= "User_borrowagree_code";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//患者编码
	public static final String PAT_CODE= "Pat_code";
	//编码
	public static final String SEX_CODE= "Sex_code";
	//名称
	public static final String SEX_NAME= "Sex_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病案借阅申请主键
	 * @return String
	 */
	public String getId_amr_borrow_apply() {
		return ((String) getAttrVal("Id_amr_borrow_apply"));
	}	
	/**
	 * 病案借阅申请主键
	 * @param Id_amr_borrow_apply
	 */
	public void setId_amr_borrow_apply(String Id_amr_borrow_apply) {
		setAttrVal("Id_amr_borrow_apply", Id_amr_borrow_apply);
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
	 * 借阅申请状态
	 * @return String
	 */
	public String getId_borrow_apply_status() {
		return ((String) getAttrVal("Id_borrow_apply_status"));
	}	
	/**
	 * 借阅申请状态
	 * @param Id_borrow_apply_status
	 */
	public void setId_borrow_apply_status(String Id_borrow_apply_status) {
		setAttrVal("Id_borrow_apply_status", Id_borrow_apply_status);
	}
	/**
	 * 借阅申请状态编码
	 * @return String
	 */
	public String getSd_borrow_apply_status() {
		return ((String) getAttrVal("Sd_borrow_apply_status"));
	}	
	/**
	 * 借阅申请状态编码
	 * @param Sd_borrow_apply_status
	 */
	public void setSd_borrow_apply_status(String Sd_borrow_apply_status) {
		setAttrVal("Sd_borrow_apply_status", Sd_borrow_apply_status);
	}
	/**
	 * 病案主键
	 * @return String
	 */
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}	
	/**
	 * 病案主键
	 * @param Id_amr
	 */
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	/**
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 申请期限
	 * @return Integer
	 */
	public Integer getTime_over() {
		return ((Integer) getAttrVal("Time_over"));
	}	
	/**
	 * 申请期限
	 * @param Time_over
	 */
	public void setTime_over(Integer Time_over) {
		setAttrVal("Time_over", Time_over);
	}
	/**
	 * 审批类型
	 * @return String
	 */
	public String getId_type_approve() {
		return ((String) getAttrVal("Id_type_approve"));
	}	
	/**
	 * 审批类型
	 * @param Id_type_approve
	 */
	public void setId_type_approve(String Id_type_approve) {
		setAttrVal("Id_type_approve", Id_type_approve);
	}
	/**
	 * 审批类型编号
	 * @return String
	 */
	public String getSd_type_approve() {
		return ((String) getAttrVal("Sd_type_approve"));
	}	
	/**
	 * 审批类型编号
	 * @param Sd_type_approve
	 */
	public void setSd_type_approve(String Sd_type_approve) {
		setAttrVal("Sd_type_approve", Sd_type_approve);
	}
	/**
	 * 申请备注
	 * @return String
	 */
	public String getRemark_apply() {
		return ((String) getAttrVal("Remark_apply"));
	}	
	/**
	 * 申请备注
	 * @param Remark_apply
	 */
	public void setRemark_apply(String Remark_apply) {
		setAttrVal("Remark_apply", Remark_apply);
	}
	/**
	 * 借阅申请原因
	 * @return String
	 */
	public String getId_borrow_apply_reason() {
		return ((String) getAttrVal("Id_borrow_apply_reason"));
	}	
	/**
	 * 借阅申请原因
	 * @param Id_borrow_apply_reason
	 */
	public void setId_borrow_apply_reason(String Id_borrow_apply_reason) {
		setAttrVal("Id_borrow_apply_reason", Id_borrow_apply_reason);
	}
	/**
	 * 借阅原因编号
	 * @return String
	 */
	public String getSd_borrow_apply_reason() {
		return ((String) getAttrVal("Sd_borrow_apply_reason"));
	}	
	/**
	 * 借阅原因编号
	 * @param Sd_borrow_apply_reason
	 */
	public void setSd_borrow_apply_reason(String Sd_borrow_apply_reason) {
		setAttrVal("Sd_borrow_apply_reason", Sd_borrow_apply_reason);
	}
	/**
	 * 借阅申请人
	 * @return String
	 */
	public String getId_borrow_apply_user() {
		return ((String) getAttrVal("Id_borrow_apply_user"));
	}	
	/**
	 * 借阅申请人
	 * @param Id_borrow_apply_user
	 */
	public void setId_borrow_apply_user(String Id_borrow_apply_user) {
		setAttrVal("Id_borrow_apply_user", Id_borrow_apply_user);
	}
	/**
	 * 借阅申请科室
	 * @return String
	 */
	public String getId_borrow_apply_dep() {
		return ((String) getAttrVal("Id_borrow_apply_dep"));
	}	
	/**
	 * 借阅申请科室
	 * @param Id_borrow_apply_dep
	 */
	public void setId_borrow_apply_dep(String Id_borrow_apply_dep) {
		setAttrVal("Id_borrow_apply_dep", Id_borrow_apply_dep);
	}
	/**
	 * 借阅申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_borrow_apply() {
		return ((FDateTime) getAttrVal("Dt_borrow_apply"));
	}	
	/**
	 * 借阅申请时间
	 * @param Dt_borrow_apply
	 */
	public void setDt_borrow_apply(FDateTime Dt_borrow_apply) {
		setAttrVal("Dt_borrow_apply", Dt_borrow_apply);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 借阅审批人
	 * @return String
	 */
	public String getId_agree_borrow_user() {
		return ((String) getAttrVal("Id_agree_borrow_user"));
	}	
	/**
	 * 借阅审批人
	 * @param Id_agree_borrow_user
	 */
	public void setId_agree_borrow_user(String Id_agree_borrow_user) {
		setAttrVal("Id_agree_borrow_user", Id_agree_borrow_user);
	}
	/**
	 * 借阅审批时间
	 * @return FDateTime
	 */
	public FDateTime getDt_borrow_agree() {
		return ((FDateTime) getAttrVal("Dt_borrow_agree"));
	}	
	/**
	 * 借阅审批时间
	 * @param Dt_borrow_agree
	 */
	public void setDt_borrow_agree(FDateTime Dt_borrow_agree) {
		setAttrVal("Dt_borrow_agree", Dt_borrow_agree);
	}
	/**
	 * 借阅截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_borrow() {
		return ((FDateTime) getAttrVal("Dt_end_borrow"));
	}	
	/**
	 * 借阅截止时间
	 * @param Dt_end_borrow
	 */
	public void setDt_end_borrow(FDateTime Dt_end_borrow) {
		setAttrVal("Dt_end_borrow", Dt_end_borrow);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 患者性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 患者性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}	
	/**
	 * 患者年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 就诊号code
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}	
	/**
	 * 就诊号code
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
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
	public String getBorrow_apply_code() {
		return ((String) getAttrVal("Borrow_apply_code"));
	}	
	/**
	 * 编码
	 * @param Borrow_apply_code
	 */
	public void setBorrow_apply_code(String Borrow_apply_code) {
		setAttrVal("Borrow_apply_code", Borrow_apply_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBorrow_apply_name() {
		return ((String) getAttrVal("Borrow_apply_name"));
	}	
	/**
	 * 名称
	 * @param Borrow_apply_name
	 */
	public void setBorrow_apply_name(String Borrow_apply_name) {
		setAttrVal("Borrow_apply_name", Borrow_apply_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getType_approve_code() {
		return ((String) getAttrVal("Type_approve_code"));
	}	
	/**
	 * 编码
	 * @param Type_approve_code
	 */
	public void setType_approve_code(String Type_approve_code) {
		setAttrVal("Type_approve_code", Type_approve_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getType_approve_name() {
		return ((String) getAttrVal("Type_approve_name"));
	}	
	/**
	 * 名称
	 * @param Type_approve_name
	 */
	public void setType_approve_name(String Type_approve_name) {
		setAttrVal("Type_approve_name", Type_approve_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBorrow_apply_reason_code() {
		return ((String) getAttrVal("Borrow_apply_reason_code"));
	}	
	/**
	 * 编码
	 * @param Borrow_apply_reason_code
	 */
	public void setBorrow_apply_reason_code(String Borrow_apply_reason_code) {
		setAttrVal("Borrow_apply_reason_code", Borrow_apply_reason_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBorrow_apply_reason_name() {
		return ((String) getAttrVal("Borrow_apply_reason_name"));
	}	
	/**
	 * 名称
	 * @param Borrow_apply_reason_name
	 */
	public void setBorrow_apply_reason_name(String Borrow_apply_reason_name) {
		setAttrVal("Borrow_apply_reason_name", Borrow_apply_reason_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getUserr_borrowapply_code() {
		return ((String) getAttrVal("Userr_borrowapply_code"));
	}	
	/**
	 * 用户编码
	 * @param Userr_borrowapply_code
	 */
	public void setUserr_borrowapply_code(String Userr_borrowapply_code) {
		setAttrVal("Userr_borrowapply_code", Userr_borrowapply_code);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getUser_borrowapply_name() {
		return ((String) getAttrVal("User_borrowapply_name"));
	}	
	/**
	 * 用户名称
	 * @param User_borrowapply_name
	 */
	public void setUser_borrowapply_name(String User_borrowapply_name) {
		setAttrVal("User_borrowapply_name", User_borrowapply_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDepr_borrowapply_code() {
		return ((String) getAttrVal("Depr_borrowapply_code"));
	}	
	/**
	 * 编码
	 * @param Depr_borrowapply_code
	 */
	public void setDepr_borrowapply_code(String Depr_borrowapply_code) {
		setAttrVal("Depr_borrowapply_code", Depr_borrowapply_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDepr_borrowapply_name() {
		return ((String) getAttrVal("Depr_borrowapply_name"));
	}	
	/**
	 * 名称
	 * @param Depr_borrowapply_name
	 */
	public void setDepr_borrowapply_name(String Depr_borrowapply_name) {
		setAttrVal("Depr_borrowapply_name", Depr_borrowapply_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getUserr_borrowagree_name() {
		return ((String) getAttrVal("Userr_borrowagree_name"));
	}	
	/**
	 * 用户名称
	 * @param Userr_borrowagree_name
	 */
	public void setUserr_borrowagree_name(String Userr_borrowagree_name) {
		setAttrVal("Userr_borrowagree_name", Userr_borrowagree_name);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getUser_borrowagree_code() {
		return ((String) getAttrVal("User_borrowagree_code"));
	}	
	/**
	 * 用户编码
	 * @param User_borrowagree_code
	 */
	public void setUser_borrowagree_code(String User_borrowagree_code) {
		setAttrVal("User_borrowagree_code", User_borrowagree_code);
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
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	/**
	 * 编码
	 * @param Sex_code
	 */
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	/**
	 * 名称
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
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
		return "Id_amr_borrow_apply";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_amr_borrow_apply";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AmrBorrowApplyDODesc.class);
	}
	
}