package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 退费单查询 DTO数据 
 * 
 */
public class BlRefundApplyQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 患者就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 申请时间（起）
	 * @return FDateTime
	 */
	public FDateTime getDt_ap_start() {
		return ((FDateTime) getAttrVal("Dt_ap_start"));
	}
	/**
	 * 申请时间（起）
	 * @param Dt_ap_start
	 */
	public void setDt_ap_start(FDateTime Dt_ap_start) {
		setAttrVal("Dt_ap_start", Dt_ap_start);
	}
	/**
	 * 申请时间（止）
	 * @return FDateTime
	 */
	public FDateTime getDt_ap_end() {
		return ((FDateTime) getAttrVal("Dt_ap_end"));
	}
	/**
	 * 申请时间（止）
	 * @param Dt_ap_end
	 */
	public void setDt_ap_end(FDateTime Dt_ap_end) {
		setAttrVal("Dt_ap_end", Dt_ap_end);
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
	public String getId_emp_ap() {
		return ((String) getAttrVal("Id_emp_ap"));
	}
	/**
	 * 申请人id
	 * @param Id_emp_ap
	 */
	public void setId_emp_ap(String Id_emp_ap) {
		setAttrVal("Id_emp_ap", Id_emp_ap);
	}
	/**
	 * 申请人姓名
	 * @return String
	 */
	public String getName_emp_ap() {
		return ((String) getAttrVal("Name_emp_ap"));
	}
	/**
	 * 申请人姓名
	 * @param Name_emp_ap
	 */
	public void setName_emp_ap(String Name_emp_ap) {
		setAttrVal("Name_emp_ap", Name_emp_ap);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_ap
	 */
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getName_dep_ap() {
		return ((String) getAttrVal("Name_dep_ap"));
	}
	/**
	 * 申请科室名称
	 * @param Name_dep_ap
	 */
	public void setName_dep_ap(String Name_dep_ap) {
		setAttrVal("Name_dep_ap", Name_dep_ap);
	}
	/**
	 * 申请单状态编码
	 * @return String
	 */
	public String getCode_su_ap() {
		return ((String) getAttrVal("Code_su_ap"));
	}
	/**
	 * 申请单状态编码
	 * @param Code_su_ap
	 */
	public void setCode_su_ap(String Code_su_ap) {
		setAttrVal("Code_su_ap", Code_su_ap);
	}
	/**
	 * 申请单状态名称
	 * @return String
	 */
	public String getName_su_ap() {
		return ((String) getAttrVal("Name_su_ap"));
	}
	/**
	 * 申请单状态名称
	 * @param Name_su_ap
	 */
	public void setName_su_ap(String Name_su_ap) {
		setAttrVal("Name_su_ap", Name_su_ap);
	}
	/**
	 * 退费单类型编码
	 * @return String
	 */
	public String getSd_rfdaptp() {
		return ((String) getAttrVal("Sd_rfdaptp"));
	}
	/**
	 * 退费单类型编码
	 * @param Sd_rfdaptp
	 */
	public void setSd_rfdaptp(String Sd_rfdaptp) {
		setAttrVal("Sd_rfdaptp", Sd_rfdaptp);
	}
	/**
	 * 退费单类型id
	 * @return String
	 */
	public String getId_rfdaptp() {
		return ((String) getAttrVal("Id_rfdaptp"));
	}
	/**
	 * 退费单类型id
	 * @param Id_rfdaptp
	 */
	public void setId_rfdaptp(String Id_rfdaptp) {
		setAttrVal("Id_rfdaptp", Id_rfdaptp);
	}
	/**
	 * 退费单类型名称
	 * @return String
	 */
	public String getName_rfdaptp() {
		return ((String) getAttrVal("Name_rfdaptp"));
	}
	/**
	 * 退费单类型名称
	 * @param Name_rfdaptp
	 */
	public void setName_rfdaptp(String Name_rfdaptp) {
		setAttrVal("Name_rfdaptp", Name_rfdaptp);
	}
}