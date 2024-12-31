package iih.bl.hp.dto;
/**
 * 根据CHIS的视图VIEW_MZ_IIH_YP_SHARE字段，提供IIH的开单信息
 * @author tcy
 *
 */
public class MzYpShareDataDTO {
	/**
	 * 患者编码
	 */
	private String patient_id;
	/**
	 * 门诊次数
	 */
	private int times;
	/**
	 * 药品名称
	 */
	private String drugname;
	/**
	 * 药品编码
	 */
	private String charge_code;
	/**
	 * 大小包装
	 */
	private String serial_no;
	/**
	 * 计费数量
	 */
	private double charge_amount;
	/**
	 * 草药付数
	 */
	private int caoyao_fu;
	/**
	 * 开方时间
	 */
	private String happen_date;
	/**
	 * 医保内标志
	 */
	private String fit_type;
	/**
	 * 开药持有天数
	 */
	private int persist_days;
	/**
	 * 处方类型
	 */
	private String order_properties;
	/**
	 * 收费状态
	 */
	private String charge_status;
	/**
	 * 就诊科室
	 */
	private String visit_dept;
	/**
	 * 医嘱大分类
	 */
	private String infusion_flag;
	/**
	 * 开单科室编码
	 */
	private String apply_unit;
	/**
	 * 频次编码
	 */
	private String freq_req;
	/**
	 * 毒麻分类
	 */
	private String drug_flag;
	/**
	 * 数据来源
	 */
	private String src_sys;
	/**
	 * 医生编码
	 */
	private String doctor_code;
	
	/**
	 * 获得患者编码
	 * @return
	 */
	public String getPatient_id() {
		return patient_id;
	}
	/**
	 * 设置患者编码
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}
	/**
	 * 获得门诊次数
	 * @return
	 */
	public int getTimes() {
		return times;
	}
	/**
	 * 设置门诊次数
	 * @param times
	 */
	public void setTimes(int times) {
		this.times = times;
	}
	/**
	 * 获得药品名称
	 * @return
	 */
	public String getDrugname() {
		return drugname;
	}
	/**
	 * 设置药品名称
	 * @param drugname
	 */
	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}
	/**
	 * 获得药品编码
	 * @return
	 */
	public String getCharge_code() {
		return charge_code;
	}
	/**
	 * 设置药品编码
	 * @param charge_code
	 */
	public void setCharge_code(String charge_code) {
		this.charge_code = charge_code;
	}
	/**
	 * 获得大小包装
	 * @return
	 */
	public String getSerial_no() {
		return serial_no;
	}
	/**
	 * 设置大小包装
	 * @param serial_no
	 */
	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}
	/**
	 * 获得计费数量
	 * @return
	 */
	public double getCharge_amount() {
		return charge_amount;
	}
	/**
	 * 设置计费数量
	 * @param charge_amount
	 */
	public void setCharge_amount(double charge_amount) {
		this.charge_amount = charge_amount;
	}
	/**
	 * 获得草药付数
	 * @return
	 */
	public int getCaoyao_fu() {
		return caoyao_fu;
	}
	/**
	 * 设置草药付数
	 * @param caoyao_fu
	 */
	public void setCaoyao_fu(int caoyao_fu) {
		this.caoyao_fu = caoyao_fu;
	}
	/**
	 * 获得开方时间
	 * @return
	 */
	public String getHappen_date() {
		return happen_date;
	}
	/**
	 * 设置开方时间
	 * @param appen_date
	 */
	public void setHappen_date(String happen_date) {
		this.happen_date = happen_date;
	}
	/**
	 * 获得医保内标志
	 * @return
	 */
	public String getFit_type() {
		return fit_type;
	}
	/**
	 * 设置医保内标志
	 * @param fit_type
	 */
	public void setFit_type(String fit_type) {
		this.fit_type = fit_type;
	}
	/**
	 * 获得开药持有天数
	 * @return
	 */
	public int getPersist_days() {
		return persist_days;
	}
	/**
	 * 设置开药持有天数
	 * @param persist_days
	 */
	public void setPersist_days(int persist_days) {
		this.persist_days = persist_days;
	}
	/**
	 * 获得处方类型
	 * @return
	 */
	public String getOrder_properties() {
		return order_properties;
	}
	/**
	 * 设置处方类型
	 * @param order_properties
	 */
	public void setOrder_properties(String order_properties) {
		this.order_properties = order_properties;
	}
	 /**
	  * 获得处方类型
	  * @return
	  */
	public String getCharge_status() {
		return charge_status;
	}
	/**
	 * 设置处方类型
	 * @param charge_status
	 */
	public void setCharge_status(String charge_status) {
		this.charge_status = charge_status;
	}
	/**
	 * 获得就诊科室
	 * @return
	 */
	public String getVisit_dept() {
		return visit_dept;
	}
	/**
	 * 设置就诊科室
	 * @param visit_dept
	 */
	public void setVisit_dept(String visit_dept) {
		this.visit_dept = visit_dept;
	}
	/**
	 * 获得医嘱大分类
	 * @return
	 */
	public String getInfusion_flag() {
		return infusion_flag;
	}
	/**
	 * 设置医嘱大分类
	 * @param infusion_flag
	 */
	public void setInfusion_flag(String infusion_flag) {
		this.infusion_flag = infusion_flag;
	}
	/**
	 * 获得开单科室编码
	 * @return
	 */
	public String getApply_unit() {
		return apply_unit;
	}
	/**
	 * 设置开单科室编码
	 * @param apply_unit
	 */
	public void setApply_unit(String apply_unit) {
		this.apply_unit = apply_unit;
	}
	/**
	 * 获得频次编码
	 * @return
	 */
	public String getFreq_req() {
		return freq_req;
	}
	/**
	 * 设置频次编码
	 * @param freq_req
	 */
	public void setFreq_req(String freq_req) {
		this.freq_req = freq_req;
	}
	/**
	 * 获得毒麻分类
	 * @return
	 */
	public String getDrug_flag() {
		return drug_flag;
	}
	/**
	 * 设置毒麻分类
	 * @param drug_flag
	 */
	public void setDrug_flag(String drug_flag) {
		this.drug_flag = drug_flag;
	}
	/**
	 * 数据来源
	 * @return
	 */
	public String getSrc_sys() {
		return src_sys;
	}
	/**
	 * 数据来源
	 * @param src_sys
	 */
	public void setSrc_sys(String src_sys) {
		this.src_sys = src_sys;
	}
	/**
	 * 医生编码
	 * @return
	 */
	public String getDoctor_code() {
		return doctor_code;
	}
	/**
	 * 医生编码
	 * @param doctor_code
	 */
	public void setDoctor_code(String doctor_code) {
		this.doctor_code = doctor_code;
	}
}
