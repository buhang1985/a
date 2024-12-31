package iih.bl.hp.viewmziihypshare.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * chis的数据结构 DTO数据 
 * 
 */
public class ViewMzIihYpShareDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}
	/**
	 * 患者编码
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 门诊次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 门诊次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getDrugname() {
		return ((String) getAttrVal("Drugname"));
	}
	/**
	 * 药品名称
	 * @param Drugname
	 */
	public void setDrugname(String Drugname) {
		setAttrVal("Drugname", Drugname);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCharge_code() {
		return ((String) getAttrVal("Charge_code"));
	}
	/**
	 * 药品编码
	 * @param Charge_code
	 */
	public void setCharge_code(String Charge_code) {
		setAttrVal("Charge_code", Charge_code);
	}
	/**
	 * 大小包装
	 * @return String
	 */
	public String getSerial_no() {
		return ((String) getAttrVal("Serial_no"));
	}
	/**
	 * 大小包装
	 * @param Serial_no
	 */
	public void setSerial_no(String Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	/**
	 * 计费数量
	 * @return FDouble
	 */
	public FDouble getCharge_amount() {
		return ((FDouble) getAttrVal("Charge_amount"));
	}
	/**
	 * 计费数量
	 * @param Charge_amount
	 */
	public void setCharge_amount(FDouble Charge_amount) {
		setAttrVal("Charge_amount", Charge_amount);
	}
	/**
	 * 草药付数
	 * @return Integer
	 */
	public Integer getCaoyao_fu() {
		return ((Integer) getAttrVal("Caoyao_fu"));
	}
	/**
	 * 草药付数
	 * @param Caoyao_fu
	 */
	public void setCaoyao_fu(Integer Caoyao_fu) {
		setAttrVal("Caoyao_fu", Caoyao_fu);
	}
	/**
	 * 开方时间
	 * @return FDateTime
	 */
	public FDateTime getHappen_date() {
		return ((FDateTime) getAttrVal("Happen_date"));
	}
	/**
	 * 开方时间
	 * @param Happen_date
	 */
	public void setHappen_date(FDateTime Happen_date) {
		setAttrVal("Happen_date", Happen_date);
	}
	/**
	 * 医保标志
	 * @return String
	 */
	public String getFit_type() {
		return ((String) getAttrVal("Fit_type"));
	}
	/**
	 * 医保标志
	 * @param Fit_type
	 */
	public void setFit_type(String Fit_type) {
		setAttrVal("Fit_type", Fit_type);
	}
	/**
	 * 开药持有天数
	 * @return Integer
	 */
	public Integer getPersist_days() {
		return ((Integer) getAttrVal("Persist_days"));
	}
	/**
	 * 开药持有天数
	 * @param Persist_days
	 */
	public void setPersist_days(Integer Persist_days) {
		setAttrVal("Persist_days", Persist_days);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getOrder_properties() {
		return ((String) getAttrVal("Order_properties"));
	}
	/**
	 * 处方类型
	 * @param Order_properties
	 */
	public void setOrder_properties(String Order_properties) {
		setAttrVal("Order_properties", Order_properties);
	}
	/**
	 * 收费状态
	 * @return String
	 */
	public String getCharge_status() {
		return ((String) getAttrVal("Charge_status"));
	}
	/**
	 * 收费状态
	 * @param Charge_status
	 */
	public void setCharge_status(String Charge_status) {
		setAttrVal("Charge_status", Charge_status);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getVisit_dept() {
		return ((String) getAttrVal("Visit_dept"));
	}
	/**
	 * 就诊科室
	 * @param Visit_dept
	 */
	public void setVisit_dept(String Visit_dept) {
		setAttrVal("Visit_dept", Visit_dept);
	}
	/**
	 * 医嘱大分类
	 * @return String
	 */
	public String getInfusion_flag() {
		return ((String) getAttrVal("Infusion_flag"));
	}
	/**
	 * 医嘱大分类
	 * @param Infusion_flag
	 */
	public void setInfusion_flag(String Infusion_flag) {
		setAttrVal("Infusion_flag", Infusion_flag);
	}
	/**
	 * 开单科室编码
	 * @return String
	 */
	public String getApply_unit() {
		return ((String) getAttrVal("Apply_unit"));
	}
	/**
	 * 开单科室编码
	 * @param Apply_unit
	 */
	public void setApply_unit(String Apply_unit) {
		setAttrVal("Apply_unit", Apply_unit);
	}
	/**
	 * 开单医生编码
	 * @return String
	 */
	public String getDoctor_code() {
		return ((String) getAttrVal("Doctor_code"));
	}
	/**
	 * 开单医生编码
	 * @param Doctor_code
	 */
	public void setDoctor_code(String Doctor_code) {
		setAttrVal("Doctor_code", Doctor_code);
	}
	/**
	 * 频次编码
	 * @return String
	 */
	public String getFreq_code() {
		return ((String) getAttrVal("Freq_code"));
	}
	/**
	 * 频次编码
	 * @param Freq_code
	 */
	public void setFreq_code(String Freq_code) {
		setAttrVal("Freq_code", Freq_code);
	}
	/**
	 * 毒麻分类
	 * @return String
	 */
	public String getDrug_flag() {
		return ((String) getAttrVal("Drug_flag"));
	}
	/**
	 * 毒麻分类
	 * @param Drug_flag
	 */
	public void setDrug_flag(String Drug_flag) {
		setAttrVal("Drug_flag", Drug_flag);
	}
	/**
	 * 处方类型iih
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型iih
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 处方类型字
	 * @return String
	 */
	public String getSd_prestpword() {
		return ((String) getAttrVal("Sd_prestpword"));
	}
	/**
	 * 处方类型字
	 * @param Sd_prestpword
	 */
	public void setSd_prestpword(String Sd_prestpword) {
		setAttrVal("Sd_prestpword", Sd_prestpword);
	}
	/**
	 * 记账状态
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 记账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 数据来源
	 * @return String
	 */
	public String getSrc_sys() {
		return ((String) getAttrVal("Src_sys"));
	}
	/**
	 * 数据来源
	 * @param Src_sys
	 */
	public void setSrc_sys(String Src_sys) {
		setAttrVal("Src_sys", Src_sys);
	}
}