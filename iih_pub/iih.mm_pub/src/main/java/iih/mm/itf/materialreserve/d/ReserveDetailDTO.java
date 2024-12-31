package iih.mm.itf.materialreserve.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品预留详细信息 DTO数据 
 * 
 */
public class ReserveDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
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
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医疗服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
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
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}
	/**
	 * 物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 物品规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
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
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_or() {
		return ((FDateTime) getAttrVal("Dt_or"));
	}
	/**
	 * 开立时间
	 * @param Dt_or
	 */
	public void setDt_or(FDateTime Dt_or) {
		setAttrVal("Dt_or", Dt_or);
	}
	/**
	 * 开立人名称
	 * @return String
	 */
	public String getEmp_or_name() {
		return ((String) getAttrVal("Emp_or_name"));
	}
	/**
	 * 开立人名称
	 * @param Emp_or_name
	 */
	public void setEmp_or_name(String Emp_or_name) {
		setAttrVal("Emp_or_name", Emp_or_name);
	}
	/**
	 * 预留数量
	 * @return String
	 */
	public String getQuan_reserve() {
		return ((String) getAttrVal("Quan_reserve"));
	}
	/**
	 * 预留数量
	 * @param Quan_reserve
	 */
	public void setQuan_reserve(String Quan_reserve) {
		setAttrVal("Quan_reserve", Quan_reserve);
	}
	/**
	 * 预留时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reserve() {
		return ((FDateTime) getAttrVal("Dt_reserve"));
	}
	/**
	 * 预留时间
	 * @param Dt_reserve
	 */
	public void setDt_reserve(FDateTime Dt_reserve) {
		setAttrVal("Dt_reserve", Dt_reserve);
	}
	/**
	 * 预留人
	 * @return String
	 */
	public String getEmp_reserve_name() {
		return ((String) getAttrVal("Emp_reserve_name"));
	}
	/**
	 * 预留人
	 * @param Emp_reserve_name
	 */
	public void setEmp_reserve_name(String Emp_reserve_name) {
		setAttrVal("Emp_reserve_name", Emp_reserve_name);
	}
	/**
	 * 预留状态
	 * @return Integer
	 */
	public Integer getEn_opertype() {
		return ((Integer) getAttrVal("En_opertype"));
	}
	/**
	 * 预留状态
	 * @param En_opertype
	 */
	public void setEn_opertype(Integer En_opertype) {
		setAttrVal("En_opertype", En_opertype);
	}
	/**
	 * 取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cancel() {
		return ((FDateTime) getAttrVal("Dt_cancel"));
	}
	/**
	 * 取消时间
	 * @param Dt_cancel
	 */
	public void setDt_cancel(FDateTime Dt_cancel) {
		setAttrVal("Dt_cancel", Dt_cancel);
	}
	/**
	 * 取消人
	 * @return String
	 */
	public String getEmp_cancel_name() {
		return ((String) getAttrVal("Emp_cancel_name"));
	}
	/**
	 * 取消人
	 * @param Emp_cancel_name
	 */
	public void setEmp_cancel_name(String Emp_cancel_name) {
		setAttrVal("Emp_cancel_name", Emp_cancel_name);
	}
}