package iih.ei.std.d.v1.ci.ris.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方检查医嘱入参 DTO数据 
 * 
 */
public class EmsRisOrdDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱序号
	 * @return String
	 */
	public String getSortno_or() {
		return ((String) getAttrVal("Sortno_or"));
	}	
	/**
	 * 医嘱序号
	 * @param Sortno_or
	 */
	public void setSortno_or(String Sortno_or) {
		setAttrVal("Sortno_or", Sortno_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getCode_srv_or() {
		return ((String) getAttrVal("Code_srv_or"));
	}	
	/**
	 * 检查项目编码
	 * @param Code_srv_or
	 */
	public void setCode_srv_or(String Code_srv_or) {
		setAttrVal("Code_srv_or", Code_srv_or);
	}
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getName_srv_or() {
		return ((String) getAttrVal("Name_srv_or"));
	}	
	/**
	 * 检查项目名称
	 * @param Name_srv_or
	 */
	public void setName_srv_or(String Name_srv_or) {
		setAttrVal("Name_srv_or", Name_srv_or);
	}
	/**
	 * 检查申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 检查申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 检查部位编码
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}	
	/**
	 * 检查部位编码
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 临床诊断编码
	 * @return String
	 */
	public String getCode_diag() {
		return ((String) getAttrVal("Code_diag"));
	}	
	/**
	 * 临床诊断编码
	 * @param Code_diag
	 */
	public void setCode_diag(String Code_diag) {
		setAttrVal("Code_diag", Code_diag);
	}
	/**
	 * 临床诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 临床诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 计划检查日期
	 * @return String
	 */
	public String getDt_plan() {
		return ((String) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划检查日期
	 * @param Dt_plan
	 */
	public void setDt_plan(String Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 临床症状及体征
	 * @return String
	 */
	public String getClinicalzztz() {
		return ((String) getAttrVal("Clinicalzztz"));
	}	
	/**
	 * 临床症状及体征
	 * @param Clinicalzztz
	 */
	public void setClinicalzztz(String Clinicalzztz) {
		setAttrVal("Clinicalzztz", Clinicalzztz);
	}
	/**
	 * 检查目的
	 * @return String
	 */
	public String getSd_pps() {
		return ((String) getAttrVal("Sd_pps"));
	}	
	/**
	 * 检查目的
	 * @param Sd_pps
	 */
	public void setSd_pps(String Sd_pps) {
		setAttrVal("Sd_pps", Sd_pps);
	}
	/**
	 * 加急标识
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 单次数量
	 * @return String
	 */
	public String getQuan_medu_or() {
		return ((String) getAttrVal("Quan_medu_or"));
	}	
	/**
	 * 单次数量
	 * @param Quan_medu_or
	 */
	public void setQuan_medu_or(String Quan_medu_or) {
		setAttrVal("Quan_medu_or", Quan_medu_or);
	}
	/**
	 * 单位支付标志
	 * @return String
	 */
	public String getFg_pay_unit() {
		return ((String) getAttrVal("Fg_pay_unit"));
	}	
	/**
	 * 单位支付标志
	 * @param Fg_pay_unit
	 */
	public void setFg_pay_unit(String Fg_pay_unit) {
		setAttrVal("Fg_pay_unit", Fg_pay_unit);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getCode_org_or() {
		return ((String) getAttrVal("Code_org_or"));
	}	
	/**
	 * 开立机构
	 * @param Code_org_or
	 */
	public void setCode_org_or(String Code_org_or) {
		setAttrVal("Code_org_or", Code_org_or);
	}
	/**
	 * 开立部门
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}	
	/**
	 * 开立部门
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 * 开立医疗组
	 * @return String
	 */
	public String getCode_wg_or() {
		return ((String) getAttrVal("Code_wg_or"));
	}	
	/**
	 * 开立医疗组
	 * @param Code_wg_or
	 */
	public void setCode_wg_or(String Code_wg_or) {
		setAttrVal("Code_wg_or", Code_wg_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}	
	/**
	 * 开立医生
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 * 开立日期
	 * @return String
	 */
	public String getDt_entry_or() {
		return ((String) getAttrVal("Dt_entry_or"));
	}	
	/**
	 * 开立日期
	 * @param Dt_entry_or
	 */
	public void setDt_entry_or(String Dt_entry_or) {
		setAttrVal("Dt_entry_or", Dt_entry_or);
	}
	/**
	 * 医嘱执行机构
	 * @return String
	 */
	public String getCode_org_mp_or() {
		return ((String) getAttrVal("Code_org_mp_or"));
	}	
	/**
	 * 医嘱执行机构
	 * @param Code_org_mp_or
	 */
	public void setCode_org_mp_or(String Code_org_mp_or) {
		setAttrVal("Code_org_mp_or", Code_org_mp_or);
	}
	/**
	 * 医嘱执行科室
	 * @return String
	 */
	public String getCode_dep_mp_or() {
		return ((String) getAttrVal("Code_dep_mp_or"));
	}	
	/**
	 * 医嘱执行科室
	 * @param Code_dep_mp_or
	 */
	public void setCode_dep_mp_or(String Code_dep_mp_or) {
		setAttrVal("Code_dep_mp_or", Code_dep_mp_or);
	}
	/**
	 * 第三方费用入参
	 * @return String
	 */
	public FArrayList getEmsrissrvdto() {
		return ((FArrayList) getAttrVal("Emsrissrvdto"));
	}	
	/**
	 * 第三方费用入参
	 * @param Emsrissrvdto
	 */
	public void setEmsrissrvdto(FArrayList Emsrissrvdto) {
		setAttrVal("Emsrissrvdto", Emsrissrvdto);
	}
}