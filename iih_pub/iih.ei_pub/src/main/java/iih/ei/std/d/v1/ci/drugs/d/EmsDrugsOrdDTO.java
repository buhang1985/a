package iih.ei.std.d.v1.ci.drugs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊药品医嘱入参 DTO数据 
 * 
 */
public class EmsDrugsOrdDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药品服务信息
	 * @return String
	 */
	public FArrayList getEmsdrugssrvdto() {
		return ((FArrayList) getAttrVal("Emsdrugssrvdto"));
	}	
	/**
	 * 药品服务信息
	 * @param Emsdrugssrvdto
	 */
	public void setEmsdrugssrvdto(FArrayList Emsdrugssrvdto) {
		setAttrVal("Emsdrugssrvdto", Emsdrugssrvdto);
	}
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
	 * 医嘱频次
	 * @return String
	 */
	public String getCode_freq_or() {
		return ((String) getAttrVal("Code_freq_or"));
	}	
	/**
	 * 医嘱频次
	 * @param Code_freq_or
	 */
	public void setCode_freq_or(String Code_freq_or) {
		setAttrVal("Code_freq_or", Code_freq_or);
	}
	/**
	 * 医嘱用法
	 * @return String
	 */
	public String getCode_route() {
		return ((String) getAttrVal("Code_route"));
	}	
	/**
	 * 医嘱用法
	 * @param Code_route
	 */
	public void setCode_route(String Code_route) {
		setAttrVal("Code_route", Code_route);
	}
	/**
	 * 医嘱天数
	 * @return String
	 */
	public String getDays_or() {
		return ((String) getAttrVal("Days_or"));
	}	
	/**
	 * 医嘱天数
	 * @param Days_or
	 */
	public void setDays_or(String Days_or) {
		setAttrVal("Days_or", Days_or);
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
	 * 滴速
	 * @return String
	 */
	public String getSd_dripspeed() {
		return ((String) getAttrVal("Sd_dripspeed"));
	}	
	/**
	 * 滴速
	 * @param Sd_dripspeed
	 */
	public void setSd_dripspeed(String Sd_dripspeed) {
		setAttrVal("Sd_dripspeed", Sd_dripspeed);
	}
	/**
	 * 超量开单原因sd
	 * @return String
	 */
	public String getSd_excessive_reason() {
		return ((String) getAttrVal("Sd_excessive_reason"));
	}	
	/**
	 * 超量开单原因sd
	 * @param Sd_excessive_reason
	 */
	public void setSd_excessive_reason(String Sd_excessive_reason) {
		setAttrVal("Sd_excessive_reason", Sd_excessive_reason);
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
}