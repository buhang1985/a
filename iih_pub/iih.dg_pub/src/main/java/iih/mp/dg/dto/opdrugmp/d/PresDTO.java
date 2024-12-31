package iih.mp.dg.dto.opdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方DTO DTO数据 
 * 
 */
public class PresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}
	/**
	 * 处方
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 处方类型名称
	 * @return String
	 */
	public String getName_prestp() {
		return ((String) getAttrVal("Name_prestp"));
	}
	/**
	 * 处方类型名称
	 * @param Name_prestp
	 */
	public void setName_prestp(String Name_prestp) {
		setAttrVal("Name_prestp", Name_prestp);
	}
	/**
	 * 处方编码
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方编码
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getName_pres() {
		return ((String) getAttrVal("Name_pres"));
	}
	/**
	 * 处方名称
	 * @param Name_pres
	 */
	public void setName_pres(String Name_pres) {
		setAttrVal("Name_pres", Name_pres);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 发药人
	 * @return String
	 */
	public String getName_emp_disp() {
		return ((String) getAttrVal("Name_emp_disp"));
	}
	/**
	 * 发药人
	 * @param Name_emp_disp
	 */
	public void setName_emp_disp(String Name_emp_disp) {
		setAttrVal("Name_emp_disp", Name_emp_disp);
	}
	/**
	 * 发药日期
	 * @return FDateTime
	 */
	public FDateTime getDt_disp() {
		return ((FDateTime) getAttrVal("Dt_disp"));
	}
	/**
	 * 发药日期
	 * @param Dt_disp
	 */
	public void setDt_disp(FDateTime Dt_disp) {
		setAttrVal("Dt_disp", Dt_disp);
	}
	/**
	 * 收费日期
	 * @return FDateTime
	 */
	public FDateTime getDt_charge() {
		return ((FDateTime) getAttrVal("Dt_charge"));
	}
	/**
	 * 收费日期
	 * @param Dt_charge
	 */
	public void setDt_charge(FDateTime Dt_charge) {
		setAttrVal("Dt_charge", Dt_charge);
	}
	/**
	 * 医嘱开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 医嘱开始时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 实付款
	 * @return FDouble
	 */
	public FDouble getAmt_real() {
		return ((FDouble) getAttrVal("Amt_real"));
	}
	/**
	 * 实付款
	 * @param Amt_real
	 */
	public void setAmt_real(FDouble Amt_real) {
		setAttrVal("Amt_real", Amt_real);
	}
	/**
	 * 应付款
	 * @return FDouble
	 */
	public FDouble getAmt_should() {
		return ((FDouble) getAttrVal("Amt_should"));
	}
	/**
	 * 应付款
	 * @param Amt_should
	 */
	public void setAmt_should(FDouble Amt_should) {
		setAttrVal("Amt_should", Amt_should);
	}
	/**
	 * 退药原因
	 * @return String
	 */
	public String getReason_rtn() {
		return ((String) getAttrVal("Reason_rtn"));
	}
	/**
	 * 退药原因
	 * @param Reason_rtn
	 */
	public void setReason_rtn(String Reason_rtn) {
		setAttrVal("Reason_rtn", Reason_rtn);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 明细
	 * @return FArrayList
	 */
	public FArrayList getDetail() {
		return ((FArrayList) getAttrVal("Detail"));
	}
	/**
	 * 明细
	 * @param Detail
	 */
	public void setDetail(FArrayList Detail) {
		setAttrVal("Detail", Detail);
	}
	/**
	 * 是草药否
	 * @return FBoolean
	 */
	public FBoolean getIs_herb() {
		return ((FBoolean) getAttrVal("Is_herb"));
	}
	/**
	 * 是草药否
	 * @param Is_herb
	 */
	public void setIs_herb(FBoolean Is_herb) {
		setAttrVal("Is_herb", Is_herb);
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
	 * 过敏史
	 * @return String
	 */
	public String getPatal() {
		return ((String) getAttrVal("Patal"));
	}
	/**
	 * 过敏史
	 * @param Patal
	 */
	public void setPatal(String Patal) {
		setAttrVal("Patal", Patal);
	}
}