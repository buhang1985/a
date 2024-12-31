package iih.ci.mrqc.cimroverapplydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历超时申请查询DTO DTO数据 
 * 
 */
public class CiMrOverApplyDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 病历任务主键
	 * @return String
	 */
	public String getId_mrtask() {
		return ((String) getAttrVal("Id_mrtask"));
	}
	/**
	 * 病历任务主键
	 * @param Id_mrtask
	 */
	public void setId_mrtask(String Id_mrtask) {
		setAttrVal("Id_mrtask", Id_mrtask);
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
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	 * 申请人id
	 * @return String
	 */
	public String getId_emp_oa() {
		return ((String) getAttrVal("Id_emp_oa"));
	}
	/**
	 * 申请人id
	 * @param Id_emp_oa
	 */
	public void setId_emp_oa(String Id_emp_oa) {
		setAttrVal("Id_emp_oa", Id_emp_oa);
	}
	/**
	 * 申请人姓名
	 * @return String
	 */
	public String getName_emp_oa() {
		return ((String) getAttrVal("Name_emp_oa"));
	}
	/**
	 * 申请人姓名
	 * @param Name_emp_oa
	 */
	public void setName_emp_oa(String Name_emp_oa) {
		setAttrVal("Name_emp_oa", Name_emp_oa);
	}
	/**
	 * 申请记录名称
	 * @return String
	 */
	public String getMrtask_name() {
		return ((String) getAttrVal("Mrtask_name"));
	}
	/**
	 * 申请记录名称
	 * @param Mrtask_name
	 */
	public void setMrtask_name(String Mrtask_name) {
		setAttrVal("Mrtask_name", Mrtask_name);
	}
	/**
	 * 超过时长
	 * @return String
	 */
	public String getOvertime() {
		return ((String) getAttrVal("Overtime"));
	}
	/**
	 * 超过时长
	 * @param Overtime
	 */
	public void setOvertime(String Overtime) {
		setAttrVal("Overtime", Overtime);
	}
	/**
	 * 正常书写时间区间
	 * @return String
	 */
	public String getNormaltime() {
		return ((String) getAttrVal("Normaltime"));
	}
	/**
	 * 正常书写时间区间
	 * @param Normaltime
	 */
	public void setNormaltime(String Normaltime) {
		setAttrVal("Normaltime", Normaltime);
	}
	/**
	 * 申请原因
	 * @return String
	 */
	public String getReason_oa() {
		return ((String) getAttrVal("Reason_oa"));
	}
	/**
	 * 申请原因
	 * @param Reason_oa
	 */
	public void setReason_oa(String Reason_oa) {
		setAttrVal("Reason_oa", Reason_oa);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oa() {
		return ((FDateTime) getAttrVal("Dt_oa"));
	}
	/**
	 * 申请时间
	 * @param Dt_oa
	 */
	public void setDt_oa(FDateTime Dt_oa) {
		setAttrVal("Dt_oa", Dt_oa);
	}
	/**
	 * 审核人id
	 * @return String
	 */
	public String getId_emp_sub() {
		return ((String) getAttrVal("Id_emp_sub"));
	}
	/**
	 * 审核人id
	 * @param Id_emp_sub
	 */
	public void setId_emp_sub(String Id_emp_sub) {
		setAttrVal("Id_emp_sub", Id_emp_sub);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getName_emp_sub() {
		return ((String) getAttrVal("Name_emp_sub"));
	}
	/**
	 * 审核人姓名
	 * @param Name_emp_sub
	 */
	public void setName_emp_sub(String Name_emp_sub) {
		setAttrVal("Name_emp_sub", Name_emp_sub);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_sub() {
		return ((FDateTime) getAttrVal("Dt_sub"));
	}
	/**
	 * 审核时间
	 * @param Dt_sub
	 */
	public void setDt_sub(FDateTime Dt_sub) {
		setAttrVal("Dt_sub", Dt_sub);
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
}