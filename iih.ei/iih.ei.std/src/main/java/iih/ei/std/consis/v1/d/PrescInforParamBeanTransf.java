package iih.ei.std.consis.v1.d;

/**
 * @author dj.zhang
 * @data 2018年7月13日上午8:21:21
 * 
 */
public class PrescInforParamBeanTransf {

	private String id_pres;
	private String id_orsrv;
	private String presc_date;
	private String presc_no;
	private String dispensary;
	private String patient_id;
	private String patient_name;
	private String invoice_no;
	private String patient_type;
	private String date_of_birth;
	private String sex;
	private String presc_identity;
	private String charge_type;
	private String presc_attr;
	private String presc_info;
	private String rcpt_info;
	private String rcpt_remark;
	private String repetition;
	private String costs;
	private String payments;
	private String ordered_by;
	private String ordered_by_name;
	private String prescribed_by;
	private String entered_by;
	private String dispense_pri;
	private Integer item_no;
	private String advice_code;
	private String drug_code;
	private String drug_spec;
	private String drug_name;
	private String firm_id;
	private String firm_name;
	private String package_spec;
	private String package_units;
	private Integer quantity;
	private String unit;
	private Double costs_detail;
	private Double payments_detail;
	private String dosage;
	private String dosage_units;
	private String administration;
	private String frequency;
	private String additionusage;
	private String rcpt_remark_detail;

	/**
	 * 处方ID
	 * 
	 * @return
	 */
	public String getId_pres() {
		return id_pres;
	}

	/**
	 * 处方ID
	 * 
	 * @param id_pres
	 */
	public void setId_pres(String id_pres) {
		this.id_pres = id_pres;
	}

	/**
	 * 明细服务ID
	 * 
	 * @return
	 */
	public String getId_orsrv() {
		return id_orsrv;
	}

	/**
	 * 明细服务ID
	 * 
	 * @param id_orsrv
	 */
	public void setId_orsrv(String id_orsrv) {
		this.id_orsrv = id_orsrv;
	}

	/**
	 * 处方时间
	 * 
	 * @return
	 */
	public String getPresc_date() {
		return presc_date;
	}

	/**
	 * 处方时间
	 * 
	 * @param presc_date
	 */
	public void setPresc_date(String presc_date) {
		this.presc_date = presc_date;
	}

	/**
	 * 处方编号
	 * 
	 * @return
	 */
	public String getPresc_no() {
		return presc_no;
	}

	/**
	 * 处方编号
	 * 
	 * @param presc_no
	 */
	public void setPresc_no(String presc_no) {
		this.presc_no = presc_no;
	}

	/**
	 * 发药药局编号
	 * 
	 * @return
	 */
	public String getDispensary() {
		return dispensary;
	}

	/**
	 * 发药药局编号
	 * 
	 * @param dispensary
	 */
	public void setDispensary(String dispensary) {
		this.dispensary = dispensary;
	}

	/**
	 * 就诊卡号
	 * 
	 * @return
	 */
	public String getPatient_id() {
		return patient_id;
	}

	/**
	 * 就诊卡号
	 * 
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * 患者姓名
	 * 
	 * @return
	 */
	public String getPatient_name() {
		return patient_name;
	}

	/**
	 * 患者姓名
	 * 
	 * @param patient_name
	 */
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	/**
	 * 发票编号
	 * 
	 * @return
	 */
	public String getInvoice_no() {
		return invoice_no;
	}

	/**
	 * 发票编号
	 * 
	 * @param invoice_no
	 */
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}

	/**
	 * 患者类型 ‘00’ 普通 ‘01’ 特需
	 * 
	 * @return
	 */
	public String getPatient_type() {
		return patient_type;
	}

	/**
	 * 患者类型 ‘00’ 普通 ‘01’ 特需
	 * 
	 * @param patient_type
	 */
	public void setPatient_type(String patient_type) {
		this.patient_type = patient_type;
	}

	/**
	 * 患者出生日期
	 * 
	 * @return
	 */
	public String getDate_of_birth() {
		return date_of_birth;
	}

	/**
	 * 患者出生日期
	 * 
	 * @param date_of_birth
	 */
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	/**
	 * 患者性别(男/女)
	 * 
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * 患者性别(男/女)
	 * 
	 * @param sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * 患者身份
	 * 
	 * @return
	 */
	public String getPresc_identity() {
		return presc_identity;
	}

	/**
	 * 患者身份
	 * 
	 * @param presc_identity
	 */
	public void setPresc_identity(String presc_identity) {
		this.presc_identity = presc_identity;
	}

	/**
	 * 医保类型
	 * 
	 * @return
	 */
	public String getCharge_type() {
		return charge_type;
	}

	/**
	 * 医保类型
	 * 
	 * @param charge_type
	 */
	public void setCharge_type(String charge_type) {
		this.charge_type = charge_type;
	}

	/**
	 * 处方属性手工处方，临时处方等文本信息
	 * 
	 * @return
	 */
	public String getPresc_attr() {
		return presc_attr;
	}

	/**
	 * 处方属性手工处方，临时处方等文本信息
	 * 
	 * @param presc_attr
	 */
	public void setPresc_attr(String presc_attr) {
		this.presc_attr = presc_attr;
	}

	/**
	 * 处方类型 费用相关处方类型文本信息（计费方式）
	 * 
	 * @return
	 */
	public String getPresc_info() {
		return presc_info;
	}

	/**
	 * 处方类型 费用相关处方类型文本信息（计费方式）
	 * 
	 * @param presc_info
	 */
	public void setPresc_info(String presc_info) {
		this.presc_info = presc_info;
	}

	/**
	 * 诊断信息
	 * 
	 * @return
	 */
	public String getRcpt_info() {
		return rcpt_info;
	}

	/**
	 * 诊断信息
	 * 
	 * @param rcpt_info
	 */
	public void setRcpt_info(String rcpt_info) {
		this.rcpt_info = rcpt_info;
	}

	/**
	 * 处方备注信息
	 * 
	 * @return
	 */
	public String getRcpt_remark() {
		return rcpt_remark;
	}

	/**
	 * 处方备注信息
	 * 
	 * @param rcpt_remark
	 */
	public void setRcpt_remark(String rcpt_remark) {
		this.rcpt_remark = rcpt_remark;
	}

	/**
	 * 剂数
	 * 
	 * @return
	 */
	public String getRepetition() {
		return repetition;
	}

	/**
	 * 剂数
	 * 
	 * @param repetition
	 */
	public void setRepetition(String repetition) {
		this.repetition = repetition;
	}

	/**
	 * 费用
	 * 
	 * @return
	 */
	public String getCosts() {
		return costs;
	}

	/**
	 * 费用
	 * 
	 * @param costs
	 */
	public void setCosts(String costs) {
		this.costs = costs;
	}

	/**
	 * 实付费用
	 * 
	 * @return
	 */
	public String getPayments() {
		return payments;
	}

	/**
	 * 实付费用
	 * 
	 * @param payments
	 */
	public void setPayments(String payments) {
		this.payments = payments;
	}

	/**
	 * 开单科室编号
	 * 
	 * @return
	 */
	public String getOrdered_by() {
		return ordered_by;
	}

	/**
	 * 开单科室编号
	 * 
	 * @param ordered_by
	 */
	public void setOrdered_by(String ordered_by) {
		this.ordered_by = ordered_by;
	}

	/**
	 * 开单科室名称
	 * 
	 * @return
	 */
	public String getOrdered_by_name() {
		return ordered_by_name;
	}

	/**
	 * 开单科室名称
	 * 
	 * @param ordered_by_name
	 */
	public void setOrdered_by_name(String ordered_by_name) {
		this.ordered_by_name = ordered_by_name;
	}

	/**
	 * 开方医生
	 * 
	 * @return
	 */
	public String getPrescribed_by() {
		return prescribed_by;
	}

	/**
	 * 开方医生
	 * 
	 * @param prescribed_by
	 */
	public void setPrescribed_by(String prescribed_by) {
		this.prescribed_by = prescribed_by;
	}

	/**
	 * 录方人
	 * 
	 * @return
	 */
	public String getEntered_by() {
		return entered_by;
	}

	/**
	 * 录方人
	 * 
	 * @param entered_by
	 */
	public void setEntered_by(String entered_by) {
		this.entered_by = entered_by;
	}

	/**
	 * 配药优先级（付费处到药房距离）数字从小到大表示优先级从高到低
	 * 
	 * @return
	 */
	public String getDispense_pri() {
		return dispense_pri;
	}

	/**
	 * 配药优先级（付费处到药房距离）数字从小到大表示优先级从高到低
	 * 
	 * @param dispense_pri
	 */
	public void setDispense_pri(String dispense_pri) {
		this.dispense_pri = dispense_pri;
	}

	/**
	 * 药品序号
	 * 
	 * @return
	 */
	public Integer getItem_no() {
		return item_no;
	}

	/**
	 * 药品序号
	 * 
	 * @param item_no
	 */
	public void setItem_no(Integer item_no) {
		this.item_no = item_no;
	}

	/**
	 * 医嘱编号
	 * 
	 * @return
	 */
	public String getAdvice_code() {
		return advice_code;
	}

	/**
	 * 医嘱编号
	 * 
	 * @param advice_code
	 */
	public void setAdvice_code(String advice_code) {
		this.advice_code = advice_code;
	}

	/**
	 * 药品编号
	 * 
	 * @return
	 */
	public String getDrug_code() {
		return drug_code;
	}

	/**
	 * 药品编号
	 * 
	 * @param drug_code
	 */
	public void setDrug_code(String drug_code) {
		this.drug_code = drug_code;
	}

	/**
	 * 药品规格
	 * 
	 * @return
	 */
	public String getDrug_spec() {
		return drug_spec;
	}

	/**
	 * 药品规格
	 * 
	 * @param drug_spec
	 */
	public void setDrug_spec(String drug_spec) {
		this.drug_spec = drug_spec;
	}

	/**
	 * 药品名称
	 * 
	 * @return
	 */
	public String getDrug_name() {
		return drug_name;
	}

	/**
	 * 药品名称
	 * 
	 * @param drug_name
	 */
	public void setDrug_name(String drug_name) {
		this.drug_name = drug_name;
	}

	/**
	 * 厂商编号
	 * 
	 * @return
	 */
	public String getFirm_id() {
		return firm_id;
	}

	/**
	 * 厂商编号
	 * 
	 * @param firm_id
	 */
	public void setFirm_id(String firm_id) {
		this.firm_id = firm_id;
	}

	/**
	 * 厂商名称
	 * 
	 * @return
	 */
	public String getFirm_name() {
		return firm_name;
	}

	/**
	 * 厂商名称
	 * 
	 * @param firm_name
	 */
	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
	}

	/**
	 * 药品包装规格
	 * 
	 * @return
	 */
	public String getPackage_spec() {
		return package_spec;
	}

	/**
	 * 药品包装规格
	 * 
	 * @param package_spec
	 */
	public void setPackage_spec(String package_spec) {
		this.package_spec = package_spec;
	}

	/**
	 * 药品包装单位
	 * 
	 * @return
	 */
	public String getPackage_units() {
		return package_units;
	}

	/**
	 * 药品包装单位
	 * 
	 * @param package_units
	 */
	public void setPackage_units(String package_units) {
		this.package_units = package_units;
	}

	/**
	 * 数量
	 * 
	 * @return
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 数量
	 * 
	 * @param quantity
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 药品单位
	 * 
	 * @return
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 药品单位
	 * 
	 * @param unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 明细费用
	 * 
	 * @return
	 */
	public Double getCosts_detail() {
		return costs_detail;
	}

	/**
	 * 明细费用
	 * 
	 * @param costs_detail
	 */
	public void setCosts_detail(Double costs_detail) {
		this.costs_detail = costs_detail;
	}

	/**
	 * 明细实付费用
	 * 
	 * @return
	 */
	public Double getPayments_detail() {
		return payments_detail;
	}

	/**
	 * 明细实付费用
	 * 
	 * @param payments_detail
	 */
	public void setPayments_detail(Double payments_detail) {
		this.payments_detail = payments_detail;
	}

	/**
	 * 药品剂量（每次服用量）
	 * 
	 * @return
	 */
	public String getDosage() {
		return dosage;
	}

	/**
	 * 药品剂量（每次服用量）
	 * 
	 * @param dosage
	 */
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	/**
	 * 剂量单位（每次服用单位）
	 * 
	 * @return
	 */
	public String getDosage_units() {
		return dosage_units;
	}

	/**
	 * 剂量单位（每次服用单位）
	 * 
	 * @param dosage_units
	 */
	public void setDosage_units(String dosage_units) {
		this.dosage_units = dosage_units;
	}

	/**
	 * 药品用法（使用方法）
	 * 
	 * @return
	 */
	public String getAdministration() {
		return administration;
	}

	/**
	 * 药品用法（使用方法）
	 * 
	 * @param administration
	 */
	public void setAdministration(String administration) {
		this.administration = administration;
	}

	/**
	 * 药品用量（使频率 每天几次）
	 * 
	 * @return
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * 药品用量（使频率 每天几次）
	 * 
	 * @param frequency
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * 补充用法
	 * 
	 * @return
	 */
	public String getAdditionusage() {
		return additionusage;
	}

	/**
	 * 补充用法
	 * 
	 * @param additionusage
	 */
	public void setAdditionusage(String additionusage) {
		this.additionusage = additionusage;
	}

	/**
	 * 处方明细备注信息
	 * 
	 * @return
	 */
	public String getRcpt_remark_detail() {
		return rcpt_remark_detail;
	}

	/**
	 * 处方明细备注信息
	 * 
	 * @param rcpt_remark_detail
	 */
	public void setRcpt_remark_detail(String rcpt_remark_detail) {
		this.rcpt_remark_detail = rcpt_remark_detail;
	}
}
