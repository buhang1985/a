package iih.ci.ord.i.external.thirdws.lis.d;

import java.util.List;

import iih.ci.ord.i.external.thirdws.base.EmsCommonOrdDTO;

/**
 * 检验医嘱DTO_第三方系统回传 DTO数据 
 * 
 */
public class EmsLisOrdDTO extends EmsCommonOrdDTO {
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
	 * 检验项目编码
	 * @return String
	 */
	public String getCode_srv_or() {
		return ((String) getAttrVal("Code_srv_or"));
	}
	/**
	 * 检验项目编码
	 * @param Code_srv_or
	 */
	public void setCode_srv_or(String Code_srv_or) {
		setAttrVal("Code_srv_or", Code_srv_or);
	}
	/**
	 * 检验项目名称
	 * @return String
	 */
	public String getName_srv_or() {
		return ((String) getAttrVal("Name_srv_or"));
	}
	/**
	 * 检验项目名称
	 * @param Name_srv_or
	 */
	public void setName_srv_or(String Name_srv_or) {
		setAttrVal("Name_srv_or", Name_srv_or);
	}
	/**
	 * 检验申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 检验申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本类型
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 标本采集时间类型
	 * @return String
	 */
	public String getSd_sampcollecttimetp() {
		return ((String) getAttrVal("Sd_sampcollecttimetp"));
	}
	/**
	 * 标本采集时间类型
	 * @param Sd_sampcollecttimetp
	 */
	public void setSd_sampcollecttimetp(String Sd_sampcollecttimetp) {
		setAttrVal("Sd_sampcollecttimetp", Sd_sampcollecttimetp);
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
	 * 计划检验日期
	 * @return String
	 */
	public String getDt_plan() {
		return ((String) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划检验日期
	 * @param Dt_plan
	 */
	public void setDt_plan(String Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
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
	 * 容器类型
	 * @return String
	 */
	public String getId_contp() {
		return ((String) getAttrVal("Id_contp"));
	}	
	/**
	 * 容器类型
	 * @param Id_contp
	 */
	public void setId_contp(String Id_contp) {
		setAttrVal("Id_contp", Id_contp);
	}
	/**
	 * 容器类型编码
	 * @return String
	 */
	public String getSd_contp() {
		return ((String) getAttrVal("Sd_contp"));
	}	
	/**
	 * 容器类型编码
	 * @param Sd_contp
	 */
	public void setSd_contp(String Sd_contp) {
		setAttrVal("Sd_contp", Sd_contp);
	}
}