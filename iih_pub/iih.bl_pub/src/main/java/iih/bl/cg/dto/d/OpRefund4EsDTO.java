package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊退费事件源DTO DTO数据 
 * 
 */
public class OpRefund4EsDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算ID
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 结算ID
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 记账ID
	 * @return String
	 */
	public String getId_cg() {
		return ((String) getAttrVal("Id_cg"));
	}
	/**
	 * 记账ID
	 * @param Id_cg
	 */
	public void setId_cg(String Id_cg) {
		setAttrVal("Id_cg", Id_cg);
	}
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
}