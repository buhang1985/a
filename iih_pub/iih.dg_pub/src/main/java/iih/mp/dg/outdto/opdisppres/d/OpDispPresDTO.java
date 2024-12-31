package iih.mp.dg.outdto.opdisppres.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 待摆药处方 DTO数据 
 * 
 */
public class OpDispPresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 唯一标识
	 * @return String
	 */
	public String getUuid() {
		return ((String) getAttrVal("Uuid"));
	}
	/**
	 * 唯一标识
	 * @param Uuid
	 */
	public void setUuid(String Uuid) {
		setAttrVal("Uuid", Uuid);
	}
	/**
	 * 唯一序列号
	 * @return String
	 */
	public String getSequence_id() {
		return ((String) getAttrVal("Sequence_id"));
	}
	/**
	 * 唯一序列号
	 * @param Sequence_id
	 */
	public void setSequence_id(String Sequence_id) {
		setAttrVal("Sequence_id", Sequence_id);
	}
	/**
	 * 发药编号
	 * @return String
	 */
	public String getPrescription_id() {
		return ((String) getAttrVal("Prescription_id"));
	}
	/**
	 * 发药编号
	 * @param Prescription_id
	 */
	public void setPrescription_id(String Prescription_id) {
		setAttrVal("Prescription_id", Prescription_id);
	}
	/**
	 * 药品顺序号
	 * @return String
	 */
	public String getPrescription_seqno() {
		return ((String) getAttrVal("Prescription_seqno"));
	}
	/**
	 * 药品顺序号
	 * @param Prescription_seqno
	 */
	public void setPrescription_seqno(String Prescription_seqno) {
		setAttrVal("Prescription_seqno", Prescription_seqno);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getPrescription_no() {
		return ((String) getAttrVal("Prescription_no"));
	}
	/**
	 * 处方号
	 * @param Prescription_no
	 */
	public void setPrescription_no(String Prescription_no) {
		setAttrVal("Prescription_no", Prescription_no);
	}
	/**
	 * 处方名称
	 * @return String
	 */
	public String getPrescription_name() {
		return ((String) getAttrVal("Prescription_name"));
	}
	/**
	 * 处方名称
	 * @param Prescription_name
	 */
	public void setPrescription_name(String Prescription_name) {
		setAttrVal("Prescription_name", Prescription_name);
	}
	/**
	 * 处方描述
	 * @return String
	 */
	public String getPrescription_desc() {
		return ((String) getAttrVal("Prescription_desc"));
	}
	/**
	 * 处方描述
	 * @param Prescription_desc
	 */
	public void setPrescription_desc(String Prescription_desc) {
		setAttrVal("Prescription_desc", Prescription_desc);
	}
	/**
	 * 自定义编码
	 * @return String
	 */
	public String getPrescription_code() {
		return ((String) getAttrVal("Prescription_code"));
	}
	/**
	 * 自定义编码
	 * @param Prescription_code
	 */
	public void setPrescription_code(String Prescription_code) {
		setAttrVal("Prescription_code", Prescription_code);
	}
	/**
	 * 处方类型
	 * @return String
	 */
	public String getPrescription_type() {
		return ((String) getAttrVal("Prescription_type"));
	}
	/**
	 * 处方类型
	 * @param Prescription_type
	 */
	public void setPrescription_type(String Prescription_type) {
		setAttrVal("Prescription_type", Prescription_type);
	}
	/**
	 * 发药药房编码
	 * @return String
	 */
	public String getExport_dept_code() {
		return ((String) getAttrVal("Export_dept_code"));
	}
	/**
	 * 发药药房编码
	 * @param Export_dept_code
	 */
	public void setExport_dept_code(String Export_dept_code) {
		setAttrVal("Export_dept_code", Export_dept_code);
	}
	/**
	 * 药房名称
	 * @return String
	 */
	public String getExport_dept_name() {
		return ((String) getAttrVal("Export_dept_name"));
	}
	/**
	 * 药房名称
	 * @param Export_dept_name
	 */
	public void setExport_dept_name(String Export_dept_name) {
		setAttrVal("Export_dept_name", Export_dept_name);
	}
	/**
	 * 开单科室编号
	 * @return String
	 */
	public String getKd_dept_code() {
		return ((String) getAttrVal("Kd_dept_code"));
	}
	/**
	 * 开单科室编号
	 * @param Kd_dept_code
	 */
	public void setKd_dept_code(String Kd_dept_code) {
		setAttrVal("Kd_dept_code", Kd_dept_code);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getKd_dept_name() {
		return ((String) getAttrVal("Kd_dept_name"));
	}
	/**
	 * 开单科室名称
	 * @param Kd_dept_name
	 */
	public void setKd_dept_name(String Kd_dept_name) {
		setAttrVal("Kd_dept_name", Kd_dept_name);
	}
	/**
	 * 摆药科室
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}
	/**
	 * 摆药科室
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 摆药科室名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}
	/**
	 * 摆药科室名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 医生编号
	 * @return String
	 */
	public String getDoctor_code() {
		return ((String) getAttrVal("Doctor_code"));
	}
	/**
	 * 医生编号
	 * @param Doctor_code
	 */
	public void setDoctor_code(String Doctor_code) {
		setAttrVal("Doctor_code", Doctor_code);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getDoctor_name() {
		return ((String) getAttrVal("Doctor_name"));
	}
	/**
	 * 医生姓名
	 * @param Doctor_name
	 */
	public void setDoctor_name(String Doctor_name) {
		setAttrVal("Doctor_name", Doctor_name);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}
	/**
	 * 患者ID
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatient_name() {
		return ((String) getAttrVal("Patient_name"));
	}
	/**
	 * 患者姓名
	 * @param Patient_name
	 */
	public void setPatient_name(String Patient_name) {
		setAttrVal("Patient_name", Patient_name);
	}
	/**
	 * 姓名拼音
	 * @return String
	 */
	public String getEnglish_name() {
		return ((String) getAttrVal("English_name"));
	}
	/**
	 * 姓名拼音
	 * @param English_name
	 */
	public void setEnglish_name(String English_name) {
		setAttrVal("English_name", English_name);
	}
	/**
	 * 出生年月
	 * @return FDate
	 */
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}
	/**
	 * 出生年月
	 * @param Birthday
	 */
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 处方日期
	 * @return FDateTime
	 */
	public FDateTime getPrescription_date() {
		return ((FDateTime) getAttrVal("Prescription_date"));
	}
	/**
	 * 处方日期
	 * @param Prescription_date
	 */
	public void setPrescription_date(FDateTime Prescription_date) {
		setAttrVal("Prescription_date", Prescription_date);
	}
	/**
	 * 取药窗口号
	 * @return String
	 */
	public String getWicket() {
		return ((String) getAttrVal("Wicket"));
	}
	/**
	 * 取药窗口号
	 * @param Wicket
	 */
	public void setWicket(String Wicket) {
		setAttrVal("Wicket", Wicket);
	}
	/**
	 * 嘱咐
	 * @return String
	 */
	public String getInstruction() {
		return ((String) getAttrVal("Instruction"));
	}
	/**
	 * 嘱咐
	 * @param Instruction
	 */
	public void setInstruction(String Instruction) {
		setAttrVal("Instruction", Instruction);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes() {
		return ((Integer) getAttrVal("Times"));
	}
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(Integer Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 诊断类型
	 * @return String
	 */
	public String getDiagz_type() {
		return ((String) getAttrVal("Diagz_type"));
	}
	/**
	 * 诊断类型
	 * @param Diagz_type
	 */
	public void setDiagz_type(String Diagz_type) {
		setAttrVal("Diagz_type", Diagz_type);
	}
	/**
	 * 药品编号
	 * @return String
	 */
	public String getHos_drug_code() {
		return ((String) getAttrVal("Hos_drug_code"));
	}
	/**
	 * 药品编号
	 * @param Hos_drug_code
	 */
	public void setHos_drug_code(String Hos_drug_code) {
		setAttrVal("Hos_drug_code", Hos_drug_code);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getHos_drug_name() {
		return ((String) getAttrVal("Hos_drug_name"));
	}
	/**
	 * 药品名称
	 * @param Hos_drug_name
	 */
	public void setHos_drug_name(String Hos_drug_name) {
		setAttrVal("Hos_drug_name", Hos_drug_name);
	}
	/**
	 * 药品单位
	 * @return String
	 */
	public String getPackage_units() {
		return ((String) getAttrVal("Package_units"));
	}
	/**
	 * 药品单位
	 * @param Package_units
	 */
	public void setPackage_units(String Package_units) {
		setAttrVal("Package_units", Package_units);
	}
	/**
	 * 药品规格
	 * @return String
	 */
	public String getPackage_spec() {
		return ((String) getAttrVal("Package_spec"));
	}
	/**
	 * 药品规格
	 * @param Package_spec
	 */
	public void setPackage_spec(String Package_spec) {
		setAttrVal("Package_spec", Package_spec);
	}
	/**
	 * 生产厂家编码
	 * @return String
	 */
	public String getManufact_code() {
		return ((String) getAttrVal("Manufact_code"));
	}
	/**
	 * 生产厂家编码
	 * @param Manufact_code
	 */
	public void setManufact_code(String Manufact_code) {
		setAttrVal("Manufact_code", Manufact_code);
	}
	/**
	 * 生产厂家名称
	 * @return String
	 */
	public String getManufact_name() {
		return ((String) getAttrVal("Manufact_name"));
	}
	/**
	 * 生产厂家名称
	 * @param Manufact_name
	 */
	public void setManufact_name(String Manufact_name) {
		setAttrVal("Manufact_name", Manufact_name);
	}
	/**
	 * 处方拼音码
	 * @return String
	 */
	public String getPrescription_pycode() {
		return ((String) getAttrVal("Prescription_pycode"));
	}
	/**
	 * 处方拼音码
	 * @param Prescription_pycode
	 */
	public void setPrescription_pycode(String Prescription_pycode) {
		setAttrVal("Prescription_pycode", Prescription_pycode);
	}
	/**
	 * 药品数量
	 * @return Integer
	 */
	public Integer getDrug_count() {
		return ((Integer) getAttrVal("Drug_count"));
	}
	/**
	 * 药品数量
	 * @param Drug_count
	 */
	public void setDrug_count(Integer Drug_count) {
		setAttrVal("Drug_count", Drug_count);
	}
	/**
	 * 用药途径
	 * @return String
	 */
	public String getAdministration_desc() {
		return ((String) getAttrVal("Administration_desc"));
	}
	/**
	 * 用药途径
	 * @param Administration_desc
	 */
	public void setAdministration_desc(String Administration_desc) {
		setAttrVal("Administration_desc", Administration_desc);
	}
	/**
	 * 处方状态主键
	 * @return String
	 */
	public String getId_dgpresst() {
		return ((String) getAttrVal("Id_dgpresst"));
	}
	/**
	 * 处方状态主键
	 * @param Id_dgpresst
	 */
	public void setId_dgpresst(String Id_dgpresst) {
		setAttrVal("Id_dgpresst", Id_dgpresst);
	}
	/**
	 * 处方状态
	 * @return Integer
	 */
	public Integer getPrescription_status() {
		return ((Integer) getAttrVal("Prescription_status"));
	}
	/**
	 * 处方状态
	 * @param Prescription_status
	 */
	public void setPrescription_status(Integer Prescription_status) {
		setAttrVal("Prescription_status", Prescription_status);
	}
	/**
	 * 是否需要冷藏
	 * @return String
	 */
	public String getRefrigerated() {
		return ((String) getAttrVal("Refrigerated"));
	}
	/**
	 * 是否需要冷藏
	 * @param Refrigerated
	 */
	public void setRefrigerated(String Refrigerated) {
		setAttrVal("Refrigerated", Refrigerated);
	}
	/**
	 * 收费时间
	 * @return FDateTime
	 */
	public FDateTime getCharge_time() {
		return ((FDateTime) getAttrVal("Charge_time"));
	}
	/**
	 * 收费时间
	 * @param Charge_time
	 */
	public void setCharge_time(FDateTime Charge_time) {
		setAttrVal("Charge_time", Charge_time);
	}
	/**
	 * 结账次数
	 * @return Integer
	 */
	public Integer getLedger_sn() {
		return ((Integer) getAttrVal("Ledger_sn"));
	}
	/**
	 * 结账次数
	 * @param Ledger_sn
	 */
	public void setLedger_sn(Integer Ledger_sn) {
		setAttrVal("Ledger_sn", Ledger_sn);
	}
	/**
	 * 预付费标志
	 * @return String
	 */
	public String getPre_pay_flag() {
		return ((String) getAttrVal("Pre_pay_flag"));
	}
	/**
	 * 预付费标志
	 * @param Pre_pay_flag
	 */
	public void setPre_pay_flag(String Pre_pay_flag) {
		setAttrVal("Pre_pay_flag", Pre_pay_flag);
	}
}