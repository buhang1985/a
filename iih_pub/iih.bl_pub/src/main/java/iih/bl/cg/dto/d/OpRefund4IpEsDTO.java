package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊退费集成平台事件源DTO DTO数据 
 * 
 */
public class OpRefund4IpEsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 单据号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}
	/**
	 * 单据号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 单据类型
	 * @return String
	 */
	public String getCode_applytp() {
		return ((String) getAttrVal("Code_applytp"));
	}
	/**
	 * 单据类型
	 * @param Code_applytp
	 */
	public void setCode_applytp(String Code_applytp) {
		setAttrVal("Code_applytp", Code_applytp);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 退费人ID
	 * @return String
	 */
	public String getId_emp_refund() {
		return ((String) getAttrVal("Id_emp_refund"));
	}
	/**
	 * 退费人ID
	 * @param Id_emp_refund
	 */
	public void setId_emp_refund(String Id_emp_refund) {
		setAttrVal("Id_emp_refund", Id_emp_refund);
	}
	/**
	 * 退费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_refund() {
		return ((FDateTime) getAttrVal("Dt_refund"));
	}
	/**
	 * 退费时间
	 * @param Dt_refund
	 */
	public void setDt_refund(FDateTime Dt_refund) {
		setAttrVal("Dt_refund", Dt_refund);
	}
	/**
	 * 退费原因
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}
	/**
	 * 退费原因
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 处方ID
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方ID
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 记账明细编号
	 * @return String
	 */
	public String getId_cgitm() {
		return ((String) getAttrVal("Id_cgitm"));
	}
	/**
	 * 记账明细编号
	 * @param Id_cgitm
	 */
	public void setId_cgitm(String Id_cgitm) {
		setAttrVal("Id_cgitm", Id_cgitm);
	}
	/**
	 * 处方编号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方编号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
}