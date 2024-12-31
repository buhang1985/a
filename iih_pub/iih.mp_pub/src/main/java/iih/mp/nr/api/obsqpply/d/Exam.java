package iih.mp.nr.api.obsqpply.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱信息 DTO数据 
 * 
 */
public class Exam extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}
	/**
	 * 医嘱号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getInpatient_no() {
		return ((String) getAttrVal("Inpatient_no"));
	}
	/**
	 * 住院号
	 * @param Inpatient_no
	 */
	public void setInpatient_no(String Inpatient_no) {
		setAttrVal("Inpatient_no", Inpatient_no);
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
	 * 病房（文字）
	 * @return String
	 */
	public String getName_zd_unit_code() {
		return ((String) getAttrVal("Name_zd_unit_code"));
	}
	/**
	 * 病房（文字）
	 * @param Name_zd_unit_code
	 */
	public void setName_zd_unit_code(String Name_zd_unit_code) {
		setAttrVal("Name_zd_unit_code", Name_zd_unit_code);
	}
	/**
	 * 患者来源（门诊，住院，急诊）
	 * @return String
	 */
	public String getDept_type() {
		return ((String) getAttrVal("Dept_type"));
	}
	/**
	 * 患者来源（门诊，住院，急诊）
	 * @param Dept_type
	 */
	public void setDept_type(String Dept_type) {
		setAttrVal("Dept_type", Dept_type);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}
	/**
	 * 科室名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 临床医师
	 * @return String
	 */
	public String getOrder_placinc_physician() {
		return ((String) getAttrVal("Order_placinc_physician"));
	}
	/**
	 * 临床医师
	 * @param Order_placinc_physician
	 */
	public void setOrder_placinc_physician(String Order_placinc_physician) {
		setAttrVal("Order_placinc_physician", Order_placinc_physician);
	}
	/**
	 * 临床症状
	 * @return String
	 */
	public String getClinic_symp() {
		return ((String) getAttrVal("Clinic_symp"));
	}
	/**
	 * 临床症状
	 * @param Clinic_symp
	 */
	public void setClinic_symp(String Clinic_symp) {
		setAttrVal("Clinic_symp", Clinic_symp);
	}
	/**
	 * 体征
	 * @return String
	 */
	public String getPhys_sign() {
		return ((String) getAttrVal("Phys_sign"));
	}
	/**
	 * 体征
	 * @param Phys_sign
	 */
	public void setPhys_sign(String Phys_sign) {
		setAttrVal("Phys_sign", Phys_sign);
	}
	/**
	 * 临床诊断
	 * @return String
	 */
	public String getClinic_diag() {
		return ((String) getAttrVal("Clinic_diag"));
	}
	/**
	 * 临床诊断
	 * @param Clinic_diag
	 */
	public void setClinic_diag(String Clinic_diag) {
		setAttrVal("Clinic_diag", Clinic_diag);
	}
	/**
	 * 次数（门诊，住院）
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 次数（门诊，住院）
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 检查类型码
	 * @return String
	 */
	public String getStudy_item_type() {
		return ((String) getAttrVal("Study_item_type"));
	}
	/**
	 * 检查类型码
	 * @param Study_item_type
	 */
	public void setStudy_item_type(String Study_item_type) {
		setAttrVal("Study_item_type", Study_item_type);
	}
	/**
	 * 检查子类码
	 * @return String
	 */
	public String getStudy_item_subtype() {
		return ((String) getAttrVal("Study_item_subtype"));
	}
	/**
	 * 检查子类码
	 * @param Study_item_subtype
	 */
	public void setStudy_item_subtype(String Study_item_subtype) {
		setAttrVal("Study_item_subtype", Study_item_subtype);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getExam_serial() {
		return ((String) getAttrVal("Exam_serial"));
	}
	/**
	 * 申请单号
	 * @param Exam_serial
	 */
	public void setExam_serial(String Exam_serial) {
		setAttrVal("Exam_serial", Exam_serial);
	}
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getExam_name() {
		return ((String) getAttrVal("Exam_name"));
	}
	/**
	 * 检查项目名称
	 * @param Exam_name
	 */
	public void setExam_name(String Exam_name) {
		setAttrVal("Exam_name", Exam_name);
	}
	/**
	 * 总价
	 * @return String
	 */
	public String getTotal_price() {
		return ((String) getAttrVal("Total_price"));
	}
	/**
	 * 总价
	 * @param Total_price
	 */
	public void setTotal_price(String Total_price) {
		setAttrVal("Total_price", Total_price);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getApply_date() {
		return ((FDateTime) getAttrVal("Apply_date"));
	}
	/**
	 * 申请时间
	 * @param Apply_date
	 */
	public void setApply_date(FDateTime Apply_date) {
		setAttrVal("Apply_date", Apply_date);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getBill_no() {
		return ((String) getAttrVal("Bill_no"));
	}
	/**
	 * 发票号
	 * @param Bill_no
	 */
	public void setBill_no(String Bill_no) {
		setAttrVal("Bill_no", Bill_no);
	}
	/**
	 * 费用信息
	 * @return FArrayList
	 */
	public FArrayList getPrices() {
		return ((FArrayList) getAttrVal("Prices"));
	}
	/**
	 * 费用信息
	 * @param Prices
	 */
	public void setPrices(FArrayList Prices) {
		setAttrVal("Prices", Prices);
	}
}