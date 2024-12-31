package iih.ci.mrqc.recallapply.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.recallapply.d.desc.ReCallApplyDODesc;
import java.math.BigDecimal;

/**
 * 病历召回申请DO DO数据 
 * 
 */
public class ReCallApplyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病历召回申请主键
	public static final String ID_RECALL_APPLY= "Id_recall_apply";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//就诊主键
	public static final String ID_ENT= "Id_ent";
	//患者主键
	public static final String ID_PAT= "Id_pat";
	//申请状态id
	public static final String ID_APPLY_STATUS= "Id_apply_status";
	//申请状态编码
	public static final String SD_APPLY_STATUS= "Sd_apply_status";
	//申请原因
	public static final String APPLY_REASON= "Apply_reason";
	//申请人
	public static final String ID_APPLY_USER= "Id_apply_user";
	//申请科室
	public static final String ID_APPLY_DEP= "Id_apply_dep";
	//申请时间
	public static final String DT_APPLY= "Dt_apply";
	//科室审核人
	public static final String ID_DEP_AGREE_USER= "Id_dep_agree_user";
	//科室审核时间
	public static final String DT_DEP_AGREE= "Dt_dep_agree";
	//医务审核人
	public static final String ID_MED_AGREE_USER= "Id_med_agree_user";
	//医务审核时间
	public static final String DT_MED_AGREE= "Dt_med_agree";
	//审核完成标志
	public static final String ISCOMPLETED= "Iscompleted";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//通过意见
	public static final String ADOPT_OPINION= "Adopt_opinion";
	//驳回原因
	public static final String REJECT_REASON= "Reject_reason";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病历召回申请主键
	 * @return String
	 */
	public String getId_recall_apply() {
		return ((String) getAttrVal("Id_recall_apply"));
	}	
	/**
	 * 病历召回申请主键
	 * @param Id_recall_apply
	 */
	public void setId_recall_apply(String Id_recall_apply) {
		setAttrVal("Id_recall_apply", Id_recall_apply);
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
	 * 申请状态id
	 * @return String
	 */
	public String getId_apply_status() {
		return ((String) getAttrVal("Id_apply_status"));
	}	
	/**
	 * 申请状态id
	 * @param Id_apply_status
	 */
	public void setId_apply_status(String Id_apply_status) {
		setAttrVal("Id_apply_status", Id_apply_status);
	}
	/**
	 * 申请状态编码
	 * @return String
	 */
	public String getSd_apply_status() {
		return ((String) getAttrVal("Sd_apply_status"));
	}	
	/**
	 * 申请状态编码
	 * @param Sd_apply_status
	 */
	public void setSd_apply_status(String Sd_apply_status) {
		setAttrVal("Sd_apply_status", Sd_apply_status);
	}
	/**
	 * 申请原因
	 * @return String
	 */
	public String getApply_reason() {
		return ((String) getAttrVal("Apply_reason"));
	}	
	/**
	 * 申请原因
	 * @param Apply_reason
	 */
	public void setApply_reason(String Apply_reason) {
		setAttrVal("Apply_reason", Apply_reason);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_apply_user() {
		return ((String) getAttrVal("Id_apply_user"));
	}	
	/**
	 * 申请人
	 * @param Id_apply_user
	 */
	public void setId_apply_user(String Id_apply_user) {
		setAttrVal("Id_apply_user", Id_apply_user);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_apply_dep() {
		return ((String) getAttrVal("Id_apply_dep"));
	}	
	/**
	 * 申请科室
	 * @param Id_apply_dep
	 */
	public void setId_apply_dep(String Id_apply_dep) {
		setAttrVal("Id_apply_dep", Id_apply_dep);
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
	 * 科室审核人
	 * @return String
	 */
	public String getId_dep_agree_user() {
		return ((String) getAttrVal("Id_dep_agree_user"));
	}	
	/**
	 * 科室审核人
	 * @param Id_dep_agree_user
	 */
	public void setId_dep_agree_user(String Id_dep_agree_user) {
		setAttrVal("Id_dep_agree_user", Id_dep_agree_user);
	}
	/**
	 * 科室审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_dep_agree() {
		return ((FDateTime) getAttrVal("Dt_dep_agree"));
	}	
	/**
	 * 科室审核时间
	 * @param Dt_dep_agree
	 */
	public void setDt_dep_agree(FDateTime Dt_dep_agree) {
		setAttrVal("Dt_dep_agree", Dt_dep_agree);
	}
	/**
	 * 医务审核人
	 * @return String
	 */
	public String getId_med_agree_user() {
		return ((String) getAttrVal("Id_med_agree_user"));
	}	
	/**
	 * 医务审核人
	 * @param Id_med_agree_user
	 */
	public void setId_med_agree_user(String Id_med_agree_user) {
		setAttrVal("Id_med_agree_user", Id_med_agree_user);
	}
	/**
	 * 医务审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_med_agree() {
		return ((FDateTime) getAttrVal("Dt_med_agree"));
	}	
	/**
	 * 医务审核时间
	 * @param Dt_med_agree
	 */
	public void setDt_med_agree(FDateTime Dt_med_agree) {
		setAttrVal("Dt_med_agree", Dt_med_agree);
	}
	/**
	 * 审核完成标志
	 * @return String
	 */
	public String getIscompleted() {
		return ((String) getAttrVal("Iscompleted"));
	}	
	/**
	 * 审核完成标志
	 * @param Iscompleted
	 */
	public void setIscompleted(String Iscompleted) {
		setAttrVal("Iscompleted", Iscompleted);
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
	 * 通过意见
	 * @return String
	 */
	public String getAdopt_opinion() {
		return ((String) getAttrVal("Adopt_opinion"));
	}	
	/**
	 * 通过意见
	 * @param Adopt_opinion
	 */
	public void setAdopt_opinion(String Adopt_opinion) {
		setAttrVal("Adopt_opinion", Adopt_opinion);
	}
	/**
	 * 驳回原因
	 * @return String
	 */
	public String getReject_reason() {
		return ((String) getAttrVal("Reject_reason"));
	}	
	/**
	 * 驳回原因
	 * @param Reject_reason
	 */
	public void setReject_reason(String Reject_reason) {
		setAttrVal("Reject_reason", Reject_reason);
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
		return "Id_recall_apply";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_recall_apply";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ReCallApplyDODesc.class);
	}
	
}