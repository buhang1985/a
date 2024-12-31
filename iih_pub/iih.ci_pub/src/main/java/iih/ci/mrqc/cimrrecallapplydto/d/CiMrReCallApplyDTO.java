package iih.ci.mrqc.cimrrecallapplydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历召回申请查询DTO DTO数据 
 * 
 */
public class CiMrReCallApplyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病历召回申请DO主键
	 * @return String
	 */
	public String getId_recall_apply() {
		return ((String) getAttrVal("Id_recall_apply"));
	}
	/**
	 * 病历召回申请DO主键
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
	 * 住院编码
	 * @return String
	 */
	public String getCode_ent_ip() {
		return ((String) getAttrVal("Code_ent_ip"));
	}
	/**
	 * 住院编码
	 * @param Code_ent_ip
	 */
	public void setCode_ent_ip(String Code_ent_ip) {
		setAttrVal("Code_ent_ip", Code_ent_ip);
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
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_in() {
		return ((FDateTime) getAttrVal("Dt_in"));
	}
	/**
	 * 入院日期
	 * @param Dt_in
	 */
	public void setDt_in(FDateTime Dt_in) {
		setAttrVal("Dt_in", Dt_in);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_out() {
		return ((FDateTime) getAttrVal("Dt_out"));
	}
	/**
	 * 出院日期
	 * @param Dt_out
	 */
	public void setDt_out(FDateTime Dt_out) {
		setAttrVal("Dt_out", Dt_out);
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
	 * 申请状态code
	 * @return String
	 */
	public String getSd_apply_status() {
		return ((String) getAttrVal("Sd_apply_status"));
	}
	/**
	 * 申请状态code
	 * @param Sd_apply_status
	 */
	public void setSd_apply_status(String Sd_apply_status) {
		setAttrVal("Sd_apply_status", Sd_apply_status);
	}
	/**
	 * 申请状态name
	 * @return String
	 */
	public String getName_apply_status() {
		return ((String) getAttrVal("Name_apply_status"));
	}
	/**
	 * 申请状态name
	 * @param Name_apply_status
	 */
	public void setName_apply_status(String Name_apply_status) {
		setAttrVal("Name_apply_status", Name_apply_status);
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
	 * 申请人id
	 * @return String
	 */
	public String getId_apply_user() {
		return ((String) getAttrVal("Id_apply_user"));
	}
	/**
	 * 申请人id
	 * @param Id_apply_user
	 */
	public void setId_apply_user(String Id_apply_user) {
		setAttrVal("Id_apply_user", Id_apply_user);
	}
	/**
	 * 申请人name
	 * @return String
	 */
	public String getName_apply_user() {
		return ((String) getAttrVal("Name_apply_user"));
	}
	/**
	 * 申请人name
	 * @param Name_apply_user
	 */
	public void setName_apply_user(String Name_apply_user) {
		setAttrVal("Name_apply_user", Name_apply_user);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_apply_dep() {
		return ((String) getAttrVal("Id_apply_dep"));
	}
	/**
	 * 申请科室id
	 * @param Id_apply_dep
	 */
	public void setId_apply_dep(String Id_apply_dep) {
		setAttrVal("Id_apply_dep", Id_apply_dep);
	}
	/**
	 * 申请科室name
	 * @return String
	 */
	public String getName_apply_dep() {
		return ((String) getAttrVal("Name_apply_dep"));
	}
	/**
	 * 申请科室name
	 * @param Name_apply_dep
	 */
	public void setName_apply_dep(String Name_apply_dep) {
		setAttrVal("Name_apply_dep", Name_apply_dep);
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
	 * 科室审核人id
	 * @return String
	 */
	public String getId_dep_agree_user() {
		return ((String) getAttrVal("Id_dep_agree_user"));
	}
	/**
	 * 科室审核人id
	 * @param Id_dep_agree_user
	 */
	public void setId_dep_agree_user(String Id_dep_agree_user) {
		setAttrVal("Id_dep_agree_user", Id_dep_agree_user);
	}
	/**
	 * 科室审核人name
	 * @return String
	 */
	public String getName_dep_agree_user() {
		return ((String) getAttrVal("Name_dep_agree_user"));
	}
	/**
	 * 科室审核人name
	 * @param Name_dep_agree_user
	 */
	public void setName_dep_agree_user(String Name_dep_agree_user) {
		setAttrVal("Name_dep_agree_user", Name_dep_agree_user);
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
	 * 医务审核人id
	 * @return String
	 */
	public String getId_med_agree_user() {
		return ((String) getAttrVal("Id_med_agree_user"));
	}
	/**
	 * 医务审核人id
	 * @param Id_med_agree_user
	 */
	public void setId_med_agree_user(String Id_med_agree_user) {
		setAttrVal("Id_med_agree_user", Id_med_agree_user);
	}
	/**
	 * 医务审核人name
	 * @return String
	 */
	public String getName_med_agree_user() {
		return ((String) getAttrVal("Name_med_agree_user"));
	}
	/**
	 * 医务审核人name
	 * @param Name_med_agree_user
	 */
	public void setName_med_agree_user(String Name_med_agree_user) {
		setAttrVal("Name_med_agree_user", Name_med_agree_user);
	}
	/**
	 * 医务审核时间
	 * @return String
	 */
	public String getDt_med_agree() {
		return ((String) getAttrVal("Dt_med_agree"));
	}
	/**
	 * 医务审核时间
	 * @param Dt_med_agree
	 */
	public void setDt_med_agree(String Dt_med_agree) {
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
}