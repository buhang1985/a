package iih.mp.dg.mpdgdruglackmsgdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药房缺药提醒 DTO数据 
 * 
 */
public class MpdgDrugLackMsgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getDep_nur_name() {
		return ((String) getAttrVal("Dep_nur_name"));
	}
	/**
	 * 病区名称
	 * @param Dep_nur_name
	 */
	public void setDep_nur_name(String Dep_nur_name) {
		setAttrVal("Dep_nur_name", Dep_nur_name);
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
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getDep_or_name() {
		return ((String) getAttrVal("Dep_or_name"));
	}
	/**
	 * 开立科室名称
	 * @param Dep_or_name
	 */
	public void setDep_or_name(String Dep_or_name) {
		setAttrVal("Dep_or_name", Dep_or_name);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getEmp_or_name() {
		return ((String) getAttrVal("Emp_or_name"));
	}
	/**
	 * 开立医生名称
	 * @param Emp_or_name
	 */
	public void setEmp_or_name(String Emp_or_name) {
		setAttrVal("Emp_or_name", Emp_or_name);
	}
	/**
	 * 服用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 服用时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}
	/**
	 * 仓库
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 药品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 药品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}
	/**
	 * 药品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}
	/**
	 * 药品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}
	/**
	 * 生产厂家
	 * @param Sup_name
	 */
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者名称
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDesc() {
		return ((String) getAttrVal("Desc"));
	}
	/**
	 * 描述
	 * @param Desc
	 */
	public void setDesc(String Desc) {
		setAttrVal("Desc", Desc);
	}
	/**
	 * 患者个数
	 * @return Integer
	 */
	public Integer getQuan_pat() {
		return ((Integer) getAttrVal("Quan_pat"));
	}
	/**
	 * 患者个数
	 * @param Quan_pat
	 */
	public void setQuan_pat(Integer Quan_pat) {
		setAttrVal("Quan_pat", Quan_pat);
	}
	/**
	 * 药品个数
	 * @return Integer
	 */
	public Integer getQuan_mm() {
		return ((Integer) getAttrVal("Quan_mm"));
	}
	/**
	 * 药品个数
	 * @param Quan_mm
	 */
	public void setQuan_mm(Integer Quan_mm) {
		setAttrVal("Quan_mm", Quan_mm);
	}
}