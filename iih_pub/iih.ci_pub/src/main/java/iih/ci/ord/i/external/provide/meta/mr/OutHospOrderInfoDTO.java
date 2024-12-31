package iih.ci.ord.i.external.provide.meta.mr;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

public class OutHospOrderInfoDTO extends BaseDTO {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 出院医嘱生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_out() {
		return ((FDateTime) getAttrVal("Dt_out"));
	}
	/**
	 * 出院医嘱生效时间
	 * @param Dt_out
	 */
	public void setDt_out(FDateTime Dt_out) {
		setAttrVal("Dt_out", Dt_out);
	}
	
	/**
	 *离院方式
	 * @return String
	 */
	public String getId_outtp() {
		return ((String) getAttrVal("Id_outtp"));
	}
	/**
	 * 离院方式
	 * @param Id_outtp
	 */
	public void setId_outtp(String Id_outtp) {
		setAttrVal("Id_outtp", Id_outtp);
	}
	/**
	 *离院方式编码
	 * @return String
	 */
	public String getSd_outtp() {
		return ((String) getAttrVal("Sd_outtp"));
	}
	/**
	 * 离院方式编码
	 * @param Sd_outtp
	 */
	public void setSd_outtp(String Sd_outtp) {
		setAttrVal("Sd_outtp", Sd_outtp);
	}
	/**
	 *离院方式名称
	 * @return String
	 */
	public String getName_outtp() {
		return ((String) getAttrVal("Name_outtp"));
	}
	/**
	 * 离院方式名称
	 * @param Name_outtp
	 */
	public void setName_outtp(String Name_outtp) {
		setAttrVal("Name_outtp", Name_outtp);
	}
	
	/**
	 *出院医嘱开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 出院医嘱开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 *出院医嘱开立科室编码
	 * @return String
	 */
	public String getCode_dep_or() {
		return ((String) getAttrVal("Code_dep_or"));
	}
	/**
	 * 出院医嘱开立科室编码
	 * @param Code_dep_or
	 */
	public void setCode_dep_or(String Code_dep_or) {
		setAttrVal("Code_dep_or", Code_dep_or);
	}
	/**
	 *出院医嘱开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 出院医嘱开立科室名称
	 * @param Sd_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	
	/**
	 *出院医嘱开立病区
	 * @return String
	 */
	public String getId_nur_or() {
		return ((String) getAttrVal("Id_nur_or"));
	}
	/**
	 * 出院医嘱开立病区
	 * @param Id_nur_or
	 */
	public void setId_nur_or(String Id_nur_or) {
		setAttrVal("Id_nur_or", Id_nur_or);
	}
	/**
	 *出院医嘱开立病区编码
	 * @return String
	 */
	public String getCode_nur_or() {
		return ((String) getAttrVal("Code_nur_or"));
	}
	/**
	 * 出院医嘱开立病区编码
	 * @param Code_nur_or
	 */
	public void setCode_nur_or(String Code_nur_or) {
		setAttrVal("Code_nur_or", Code_nur_or);
	}
	/**
	 *出院医嘱开立病区名称
	 * @return String
	 */
	public String getName_nur_or() {
		return ((String) getAttrVal("Name_nur_or"));
	}
	/**
	 * 出院医嘱开立病区名称
	 * @param Name_nur_or
	 */
	public void setName_nur_or(String Name_nur_or) {
		setAttrVal("Name_nur_or", Name_nur_or);
	}
	/**
	 *出院医嘱开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 出院医嘱开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 *出院医嘱开立医生编码
	 * @return String
	 */
	public String getCode_emp_or() {
		return ((String) getAttrVal("Code_emp_or"));
	}
	/**
	 * 出院医嘱开立医生编码
	 * @param Code_emp_or
	 */
	public void setCode_emp_or(String Code_emp_or) {
		setAttrVal("Code_emp_or", Code_emp_or);
	}
	/**
	 *出院医嘱开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 出院医嘱开立医生名称
	 * @param Code_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
}
