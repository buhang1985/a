package iih.mp.dg.wsbean;

/**
 * 门诊待摆药处方信息bean
 * @author ssq
 *
 */
public class OpDispPresBean {
	
	private String Uuid;
	private String Sequence_id;
	private String Prescription_id;
	private String Prescription_seqno;
	private String Prescription_no;
	private String Prescription_name;
	private String Prescription_desc; 
	private String Prescription_code;
	private String Prescription_type;
	private String Export_dept_code;
	private String Export_dept_name;
	private String Kd_dept_code;
	private String Kd_dept_name; 
	private String Dept_code;
	private String Dept_name; 
	private String Doctor_code;
	private String Doctor_name; 
	private String Patient_id;
	private String Patient_name; 
	private String English_name;
	private String Birthday;
	private String Sex;
	private String Prescription_date;
	private String wicket;
	private String Instruction;
	private Integer Times_op;
	private String Diagz_type;
	private String Hos_drug_code; 
	private String Hos_drug_name; 
	private String package_units;
	private String package_spec;  
	private String manufact_code;
	private String manufact_name; 
	private String Prescription_pycode;  
	private Integer Drug_count;
	private String Administration_desc;
	private Integer Prescription_status;
	private String Refrigerated;
	private String Charge_time;
	private Integer Ledger_sn;
	private String Pre_pay_flag;
	
	/**
	 * 唯一标识
	 * @return string
	 */
	public String getUuid() {
		return Uuid;
	}

	/**
	 * 唯一标识
	 * @param uuid
	 */
	public void setUuid(String uuid) {
		Uuid = uuid;
	}
	
	/**
	 * 唯一序列号
	 * @return String
	 */
	public String getSequence_id() {
		return Sequence_id;
	}
	
	/**
	 * 唯一序列号
	 * @param sequence_id
	 */
	public void setSequence_id(String sequence_id) {
		Sequence_id = sequence_id;
	}
	
	/**
	 * 发药编号 
	 * @return String
	 */
	public String getPrescription_id() {
		return Prescription_id;
	}
	
	/**
	 * 发药编号 
	 * @param prescription_id
	 */
	public void setPrescription_id(String prescription_id) {
		Prescription_id = prescription_id;
	}
	
	/**
	 * 药品顺序号
	 * @return String
	 */
	public String getPrescription_seqno() {
		return Prescription_seqno;
	}
	
	/**
	 * 药品顺序号
	 * @param prescription_seqno
	 */
	public void setPrescription_seqno(String prescription_seqno) {
		Prescription_seqno = prescription_seqno;
	}
	
	/**
	 * 处方号
	 * @return String
	 */
	public String getPrescription_no() {
		return Prescription_no;
	}
	
	/**
	 * 处方号
	 * @param prescription_no
	 */
	public void setPrescription_no(String prescription_no) {
		Prescription_no = prescription_no;
	}
	
	/**
	 * 处方名称
	 * @return String
	 */
	public String getPrescription_name() {
		return Prescription_name;
	}
	
	/**
	 * 处方名称
	 * @param prescription_name
	 */
	public void setPrescription_name(String prescription_name) {
		Prescription_name = prescription_name;
	}
	
	/**
	 * 处方描述
	 * @return String
	 */
	public String getPrescription_desc() {
		return Prescription_desc;
	}
	
	/**
	 * 处方描述
	 * @param prescription_desc
	 */
	public void setPrescription_desc(String prescription_desc) {
		Prescription_desc = prescription_desc;
	}
	
	/**
	 * 自定义编码
	 * @return String
	 */
	public String getPrescription_code() {
		return Prescription_code;
	}
	
	/**
	 * 自定义编码
	 * @param prescription_code
	 */
	public void setPrescription_code(String prescription_code) {
		Prescription_code = prescription_code;
	}
	
	/**
	 * 处方类型
	 * @return String
	 */
	public String getPrescription_type() {
		return Prescription_type;
	}
	
	/**
	 * 处方类型
	 * @param prescription_type
	 */
	public void setPrescription_type(String prescription_type) {
		Prescription_type = prescription_type;
	}
	
	/**
	 * 发药药房编码
	 * @return String
	 */
	public String getExport_dept_code() {
		return Export_dept_code;
	}
	
	/**
	 * 发药药房编码
	 * @param export_dept_code
	 */
	public void setExport_dept_code(String export_dept_code) {
		Export_dept_code = export_dept_code;
	}
	
	/**
	 * 发药药房名称
	 * @return String
	 */
	public String getExport_dept_name() {
		return Export_dept_name;
	}
	
	/**
	 * 发药药房名称
	 * @param export_dept_name
	 */
	public void setExport_dept_name(String export_dept_name) {
		Export_dept_name = export_dept_name;
	}
	
	/**
	 * 开单科室编号
	 * @return String
	 */
	public String getKd_dept_code() {
		return Kd_dept_code;
	}
	
	/**
	 * 开单科室编号
	 * @param kd_dept_code
	 */
	public void setKd_dept_code(String kd_dept_code) {
		Kd_dept_code = kd_dept_code;
	}
	
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getKd_dept_name() {
		return Kd_dept_name;
	}
	
	/**
	 * 开单科室名称
	 * @param kd_dept_code
	 */
	public void setKd_dept_name(String kd_dept_name) {
		Kd_dept_name = kd_dept_name;
	}
	
	/**
	 * 摆药科室编号
	 * @return String
	 */
	public String getDept_code() {
		return Dept_code;
	}
	
	/**
	 * 摆药科室编号
	 * @param dept_code
	 */
	public void setDept_code(String dept_code) {
		Dept_code = dept_code;
	}
	
	/**
	 * 摆药科室名称
	 * @return String
	 */
	public String getDept_name() {
		return Dept_name;
	}
	
	/**
	 * 摆药科室名称
	 * @param dept_code
	 */
	public void setDept_name(String dept_name) {
		Dept_name = dept_name;
	}
	
	/**
	 *  医生编号（医院的医生编号是5位）
	 * @return String
	 */
	public String getDoctor_code() {
		return Doctor_code;
	}
	
	/**
	 *  医生编号（医院的医生编号是5位）
	 * @param doctor_code
	 */
	public void setDoctor_code(String doctor_code) {
		Doctor_code = doctor_code;
	}
	
	/**
	 *  医生名称
	 * @param doctor_code
	 */
	public String getDoctor_name() {
		return Doctor_name;
	}
	
	/**
	 *  医生名称
	 * @param doctor_name
	 */
	public void setDoctor_name(String doctor_name) {
		Doctor_name = doctor_name;
	}
	
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatient_id() {
		return Patient_id;
	}
	
	/**
	 * 患者ID
	 * @param patient_id
	 */
	public void setPatient_id(String patient_id) {
		Patient_id = patient_id;
	}
	
	/**
	 * 患者名称
	 * @return String
	 */
	public String getPatient_name() {
		return Patient_name;
	}
	
	/**
	 * 患者名称
	 * @param patient_name
	 */
	public void setPatient_name(String patient_name) {
		Patient_name = patient_name;
	}
	
	/**
	 * 姓名拼音
	 * @return String
	 */
	public String getEnglish_name() {
		return English_name;
	}
	
	/**
	 * 姓名拼音
	 * @param english_name
	 */
	public void setEnglish_name(String english_name) {
		English_name = english_name;
	}
	
	/**
	 * 出生年月 
	 * @return Calendar
	 */
	public String getBirthday() {
		return Birthday;
	}
	
	/**
	 * 出生年月 
	 * @param  birthday
	 */
	public void setBirthday(String birthday) {
		Birthday = birthday;
	}
	
	/**
	 * 	性别;1：男；2：女；9：不明 
	 * @return String
	 */
	public String getSex() {
		return Sex;
	}
	
	/**
	 * 	性别;1：男；2：女；9：不明 
	 * @param sex
	 */
	public void setSex(String sex) {
		Sex = sex;
	}
	
	/**
	 * 处方日期
	 * @return Calendar
	 */
	public String getPrescription_date() {
		return Prescription_date;
	}
	
	/**
	 * 处方日期
	 * @param  prescription_date
	 */
	public void setPrescription_date(String prescription_date) {
		Prescription_date = prescription_date;
	}
	
	/**
	 * 取药窗口号
	 * @return  String
	 */
	public String getWicket() {
		return wicket;
	}
	
	/**
	 * 取药窗口号
	 * @param  wicket
	 */
	public void setWicket(String wicket) {
		this.wicket = wicket;
	}

	/**
	 * 	嘱咐
	 * @return  String
	 */
	public String getInstruction() {
		return Instruction;
	}
	
	/**
	 * 	嘱咐
	 * @param  instruction
	 */
	public void setInstruction(String instruction) {
		Instruction = instruction;
	}

	/**
	 * 就诊次数 
	 * @return  Integer
	 */
	public Integer getTimes_op() {
		return Times_op;
	}
	
	/**
	 *  就诊次数 
	 * @param  times_op
	 */
	public void setTimes_op(Integer times_op) {
		Times_op = times_op;
	}
	
	/**
	 * 类型(初，复，最后诊断) 
	 * @return  String
	 */
	public String getDiagz_type() {
		return Diagz_type;
	}
	
	/**
	 *  类型(初，复，最后诊断)
	 * @param  diagz_type
	 */
	public void setDiagz_type(String diagz_type) {
		Diagz_type = diagz_type;
	}
	
	/**
	 * 药品编号
	 * @return  String
	 */
	public String getHos_drug_code() {
		return Hos_drug_code;
	}
	
	/**
	 *  药品编号
	 * @param  hos_drug_code
	 */
	public void setHos_drug_code(String hos_drug_code) {
		Hos_drug_code = hos_drug_code;
	}
	
	/**
	 * 药品名称
	 * @return  String
	 */
	public String getHos_drug_name() {
		return Hos_drug_name;
	}
	
	/**
	 *  药品名称
	 * @param  hos_drug_name
	 */
	public void setHos_drug_name(String hos_drug_name) {
		Hos_drug_name = hos_drug_name;
	}
	
	/**
	 * 药品单位：药品包装单位
	 * @return  String
	 */
	public String getPackage_units() {
		return package_units;
	}
	
	/**
	 *  药品单位：药品包装单位
	 * @param  package_units
	 */
	public void setPackage_units(String package_units) {
		this.package_units = package_units;
	}
	
	/**
	 * 药品规格：药品包装规格 
	 * @return  String
	 */
	public String getPackage_spec() {
		return package_spec;
	}
	
	/**
	 *  药品规格：药品包装规格 
	 * @param  package_spec
	 */
	public void setPackage_spec(String package_spec) {
		this.package_spec = package_spec;
	}
	
	/**
	 * 生产厂家编码
	 * @return  String
	 */
	public String getManufact_code() {
		return manufact_code;
	}
	
	/**
	 *  生产厂家编码
	 * @param  manufact_code
	 */
	public void setManufact_code(String manufact_code) {
		this.manufact_code = manufact_code;
	}
	
	/**
	 * 生产厂家名称
	 * @return  String
	 */
	public String getManufact_name() {
		return manufact_name;
	}
	
	/**
	 *   生产厂家名称
	 * @param  manufact_name
	 */
	public void setManufact_name(String manufact_name) {
		this.manufact_name = manufact_name;
	}
	
	/**
	 * 拼音码
	 * @return  String
	 */
	public String getPrescription_pycode() {
		return Prescription_pycode;
	}
	
	/**
	 * 拼音码
	 * @param  prescription_pycode
	 */
	public void setPrescription_pycode(String prescription_pycode) {
		Prescription_pycode = prescription_pycode;
	}
	
	/**
	 * 药品数量
	 * @return  String
	 */
	public Integer getDrug_count() {
		return Drug_count;
	}
	
	/**
	 *  药品数量
	 * @param  drug_count
	 */
	public void setDrug_count(Integer drug_count) {
		Drug_count = drug_count;
	}
	
	/**
	 * 用药途径
	 * @return  String
	 */
	public String getAdministration_desc() {
		return Administration_desc;
	}
	
	/**
	 *  用药途径
	 * @param  administration_desc
	 */
	public void setAdministration_desc(String administration_desc) {
		Administration_desc = administration_desc;
	}
	
	/**
	 * 处方状态
	 * @return  String
	 */
	public Integer getPrescription_status() {
		return Prescription_status;
	}
	
	/**
	 *  处方状态
	 * @param  prescription_status
	 */
	public void setPrescription_status(Integer prescription_status) {
		Prescription_status = prescription_status;
	}
	
	/**
	 * 是否需要冷藏：0：否；1：是
	 * @return  String
	 */
	public String getRefrigerated() {
		return Refrigerated;
	}
	
	/**
	 * 是否需要冷藏：0：否；1：是
	 * @param  refrigerated
	 */
	public void setRefrigerated(String refrigerated) {
		Refrigerated = refrigerated;
	}
	
	/**
	 * 收费时间
	 * @return  Calendar
	 */
	public String getCharge_time() {
		return Charge_time;
	}
	
	/**
	 *  收费时间
	 * @param  charge_time
	 */
	public void setCharge_time(String charge_time) {
		Charge_time = charge_time;
	}
	
	/**
	 * 结账次数 
	 * @return  Integer
	 */
	public Integer getLedger_sn() {
		return Ledger_sn;
	}
	
	/**
	 *  结账次数 
	 * @param  ledger_sn
	 */
	public void setLedger_sn(Integer ledger_sn) {
		Ledger_sn = ledger_sn;
	}
	
	/**
	 * 预付费标志
	 * @return  String
	 */
	public String getPre_pay_flag() {
		return Pre_pay_flag;
	}
	
	/**
	 *  预付费标志
	 * @param  pre_pay_flag
	 */
	public void setPre_pay_flag(String pre_pay_flag) {
		Pre_pay_flag = pre_pay_flag;
	}
}


