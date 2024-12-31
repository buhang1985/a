package iih.ci.ord.ciaphvconsumables.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciaphvconsumables.d.desc.CiApHvconsumblesDODesc;
import java.math.BigDecimal;

/**
 * 医嘱高值耗材申请  DO数据 
 * 
 */
public class CiApHvconsumblesDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//高值耗材申请ID
	public static final String ID_APHVCONSUMABLES= "Id_aphvconsumables";
	//申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//申请类型
	public static final String SD_HCAPTP= "Sd_hcaptp";
	//就诊类型
	public static final String CODE_ENTP= "Code_entp";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//关联医嘱10
	public static final String ID_OR= "Id_or";
	//关联单号
	public static final String NO_APPLYFORM_REL= "No_applyform_rel";
	//申请理由主键
	public static final String ID_REASON_AP= "Id_reason_ap";
	//申请理由编码
	public static final String SD_REASON_AP= "Sd_reason_ap";
	//申请理由
	public static final String REASON= "Reason";
	//流向科室
	public static final String ID_DEP_LOC= "Id_dep_loc";
	//是否加急
	public static final String FG_URGENT= "Fg_urgent";
	//申请单状态
	public static final String SD_SU_HC= "Sd_su_hc";
	//申请人
	public static final String ID_EMP_AP= "Id_emp_ap";
	//申请时间
	public static final String DT_AP= "Dt_ap";
	//申请科室
	public static final String ID_DEP_AP= "Id_dep_ap";
	//签署标识
	public static final String FG_SIGN= "Fg_sign";
	//审核人
	public static final String ID_EMP_CHK= "Id_emp_chk";
	//审核时间
	public static final String DT_CHK= "Dt_chk";
	//审核科室
	public static final String ID_DEP_CHK= "Id_dep_chk";
	//审核结果
	public static final String SD_APPROVE= "Sd_approve";
	//审核记录
	public static final String APPROVE= "Approve";
	//签署人
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	//签署时间
	public static final String DT_SIGN= "Dt_sign";
	//签署科室
	public static final String ID_DEP_SIGN= "Id_dep_sign";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//计划使用时间
	public static final String DT_PLAN= "Dt_plan";
	//医嘱内容
	public static final String CONTENT_OR= "Content_or";
	//医嘱名称
	public static final String NAME_OR= "Name_or";
	//流向科室
	public static final String NAME_DEP_LOC= "Name_dep_loc";
	//申请人
	public static final String NAME_EMP_AP= "Name_emp_ap";
	//申请科室
	public static final String NAME_DEP_AP= "Name_dep_ap";
	//审核人姓名
	public static final String NAME_EMP_CHK= "Name_emp_chk";
	//审核科室名称
	public static final String NAME_DEP_CHK= "Name_dep_chk";
	//签署人姓名
	public static final String NAME_EMP_SIGN= "Name_emp_sign";
	//签署科室
	public static final String NAME_DEP_SIGN= "Name_dep_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 高值耗材申请ID
	 * @return String
	 */
	public String getId_aphvconsumables() {
		return ((String) getAttrVal("Id_aphvconsumables"));
	}	
	/**
	 * 高值耗材申请ID
	 * @param Id_aphvconsumables
	 */
	public void setId_aphvconsumables(String Id_aphvconsumables) {
		setAttrVal("Id_aphvconsumables", Id_aphvconsumables);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 申请类型
	 * @return String
	 */
	public String getSd_hcaptp() {
		return ((String) getAttrVal("Sd_hcaptp"));
	}	
	/**
	 * 申请类型
	 * @param Sd_hcaptp
	 */
	public void setSd_hcaptp(String Sd_hcaptp) {
		setAttrVal("Sd_hcaptp", Sd_hcaptp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	 * 关联医嘱10
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 关联医嘱10
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 关联单号
	 * @return String
	 */
	public String getNo_applyform_rel() {
		return ((String) getAttrVal("No_applyform_rel"));
	}	
	/**
	 * 关联单号
	 * @param No_applyform_rel
	 */
	public void setNo_applyform_rel(String No_applyform_rel) {
		setAttrVal("No_applyform_rel", No_applyform_rel);
	}
	/**
	 * 申请理由主键
	 * @return String
	 */
	public String getId_reason_ap() {
		return ((String) getAttrVal("Id_reason_ap"));
	}	
	/**
	 * 申请理由主键
	 * @param Id_reason_ap
	 */
	public void setId_reason_ap(String Id_reason_ap) {
		setAttrVal("Id_reason_ap", Id_reason_ap);
	}
	/**
	 * 申请理由编码
	 * @return String
	 */
	public String getSd_reason_ap() {
		return ((String) getAttrVal("Sd_reason_ap"));
	}	
	/**
	 * 申请理由编码
	 * @param Sd_reason_ap
	 */
	public void setSd_reason_ap(String Sd_reason_ap) {
		setAttrVal("Sd_reason_ap", Sd_reason_ap);
	}
	/**
	 * 申请理由
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	/**
	 * 申请理由
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 流向科室
	 * @return String
	 */
	public String getId_dep_loc() {
		return ((String) getAttrVal("Id_dep_loc"));
	}	
	/**
	 * 流向科室
	 * @param Id_dep_loc
	 */
	public void setId_dep_loc(String Id_dep_loc) {
		setAttrVal("Id_dep_loc", Id_dep_loc);
	}
	/**
	 * 是否加急
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 是否加急
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 申请单状态
	 * @return String
	 */
	public String getSd_su_hc() {
		return ((String) getAttrVal("Sd_su_hc"));
	}	
	/**
	 * 申请单状态
	 * @param Sd_su_hc
	 */
	public void setSd_su_hc(String Sd_su_hc) {
		setAttrVal("Sd_su_hc", Sd_su_hc);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_emp_ap() {
		return ((String) getAttrVal("Id_emp_ap"));
	}	
	/**
	 * 申请人
	 * @param Id_emp_ap
	 */
	public void setId_emp_ap(String Id_emp_ap) {
		setAttrVal("Id_emp_ap", Id_emp_ap);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ap() {
		return ((FDateTime) getAttrVal("Dt_ap"));
	}	
	/**
	 * 申请时间
	 * @param Dt_ap
	 */
	public void setDt_ap(FDateTime Dt_ap) {
		setAttrVal("Dt_ap", Dt_ap);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}	
	/**
	 * 申请科室
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 签署标识
	 * @return String
	 */
	public String getFg_sign() {
		return ((String) getAttrVal("Fg_sign"));
	}	
	/**
	 * 签署标识
	 * @param Fg_sign
	 */
	public void setFg_sign(String Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	/**
	 * 审核人
	 * @param Id_emp_chk
	 */
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 审核时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 审核科室
	 * @return String
	 */
	public String getId_dep_chk() {
		return ((String) getAttrVal("Id_dep_chk"));
	}	
	/**
	 * 审核科室
	 * @param Id_dep_chk
	 */
	public void setId_dep_chk(String Id_dep_chk) {
		setAttrVal("Id_dep_chk", Id_dep_chk);
	}
	/**
	 * 审核结果
	 * @return String
	 */
	public String getSd_approve() {
		return ((String) getAttrVal("Sd_approve"));
	}	
	/**
	 * 审核结果
	 * @param Sd_approve
	 */
	public void setSd_approve(String Sd_approve) {
		setAttrVal("Sd_approve", Sd_approve);
	}
	/**
	 * 审核记录
	 * @return String
	 */
	public String getApprove() {
		return ((String) getAttrVal("Approve"));
	}	
	/**
	 * 审核记录
	 * @param Approve
	 */
	public void setApprove(String Approve) {
		setAttrVal("Approve", Approve);
	}
	/**
	 * 签署人
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	/**
	 * 签署人
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sign() {
		return ((FDateTime) getAttrVal("Dt_sign"));
	}	
	/**
	 * 签署时间
	 * @param Dt_sign
	 */
	public void setDt_sign(FDateTime Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 签署科室
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	/**
	 * 签署科室
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
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
	 * 计划使用时间
	 * @return FDate
	 */
	public FDate getDt_plan() {
		return ((FDate) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划使用时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDate Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 流向科室
	 * @return String
	 */
	public String getName_dep_loc() {
		return ((String) getAttrVal("Name_dep_loc"));
	}	
	/**
	 * 流向科室
	 * @param Name_dep_loc
	 */
	public void setName_dep_loc(String Name_dep_loc) {
		setAttrVal("Name_dep_loc", Name_dep_loc);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getName_emp_ap() {
		return ((String) getAttrVal("Name_emp_ap"));
	}	
	/**
	 * 申请人
	 * @param Name_emp_ap
	 */
	public void setName_emp_ap(String Name_emp_ap) {
		setAttrVal("Name_emp_ap", Name_emp_ap);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getName_dep_ap() {
		return ((String) getAttrVal("Name_dep_ap"));
	}	
	/**
	 * 申请科室
	 * @param Name_dep_ap
	 */
	public void setName_dep_ap(String Name_dep_ap) {
		setAttrVal("Name_dep_ap", Name_dep_ap);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getName_emp_chk() {
		return ((String) getAttrVal("Name_emp_chk"));
	}	
	/**
	 * 审核人姓名
	 * @param Name_emp_chk
	 */
	public void setName_emp_chk(String Name_emp_chk) {
		setAttrVal("Name_emp_chk", Name_emp_chk);
	}
	/**
	 * 审核科室名称
	 * @return String
	 */
	public String getName_dep_chk() {
		return ((String) getAttrVal("Name_dep_chk"));
	}	
	/**
	 * 审核科室名称
	 * @param Name_dep_chk
	 */
	public void setName_dep_chk(String Name_dep_chk) {
		setAttrVal("Name_dep_chk", Name_dep_chk);
	}
	/**
	 * 签署人姓名
	 * @return String
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}	
	/**
	 * 签署人姓名
	 * @param Name_emp_sign
	 */
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 签署科室
	 * @return String
	 */
	public String getName_dep_sign() {
		return ((String) getAttrVal("Name_dep_sign"));
	}	
	/**
	 * 签署科室
	 * @param Name_dep_sign
	 */
	public void setName_dep_sign(String Name_dep_sign) {
		setAttrVal("Name_dep_sign", Name_dep_sign);
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
		return "Id_aphvconsumables";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_hvconsumables";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiApHvconsumblesDODesc.class);
	}
	
}