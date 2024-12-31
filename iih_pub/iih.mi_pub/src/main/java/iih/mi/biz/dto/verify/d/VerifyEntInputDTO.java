package iih.mi.biz.dto.verify.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 医保审核就诊主单信息 DTO数据 
 * 
 */
public class VerifyEntInputDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保报销金额(明细医保报销金额的合计，如无法获取请填写单据的总金额)
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保报销金额(明细医保报销金额的合计，如无法获取请填写单据的总金额)
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 就诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 入院诊断编码
	 * @return String
	 */
	public String getDiagnosis_in() {
		return ((String) getAttrVal("Diagnosis_in"));
	}
	/**
	 * 入院诊断编码
	 * @param Diagnosis_in
	 */
	public void setDiagnosis_in(String Diagnosis_in) {
		setAttrVal("Diagnosis_in", Diagnosis_in);
	}
	/**
	 * 出院诊断编码
	 * @return String
	 */
	public String getDiagnosis_out() {
		return ((String) getAttrVal("Diagnosis_out"));
	}
	/**
	 * 出院诊断编码
	 * @param Diagnosis_out
	 */
	public void setDiagnosis_out(String Diagnosis_out) {
		setAttrVal("Diagnosis_out", Diagnosis_out);
	}
	/**
	 * 其他诊断
	 * @return String
	 */
	public String getDiagnosis_tother() {
		return ((String) getAttrVal("Diagnosis_tother"));
	}
	/**
	 * 其他诊断
	 * @param Diagnosis_tother
	 */
	public void setDiagnosis_tother(String Diagnosis_tother) {
		setAttrVal("Diagnosis_tother", Diagnosis_tother);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getGender() {
		return ((String) getAttrVal("Gender"));
	}
	/**
	 * 性别
	 * @param Gender
	 */
	public void setGender(String Gender) {
		setAttrVal("Gender", Gender);
	}
	/**
	 * 定点机构等级
	 * @return String
	 */
	public String getHospital_level() {
		return ((String) getAttrVal("Hospital_level"));
	}
	/**
	 * 定点机构等级
	 * @param Hospital_level
	 */
	public void setHospital_level(String Hospital_level) {
		setAttrVal("Hospital_level", Hospital_level);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getHs_area_code() {
		return ((String) getAttrVal("Hs_area_code"));
	}
	/**
	 * 病区
	 * @param Hs_area_code
	 */
	public void setHs_area_code(String Hs_area_code) {
		setAttrVal("Hs_area_code", Hs_area_code);
	}
	/**
	 * 入院诊断中文名
	 * @return String
	 */
	public String getHs_diagnosis_in_name() {
		return ((String) getAttrVal("Hs_diagnosis_in_name"));
	}
	/**
	 * 入院诊断中文名
	 * @param Hs_diagnosis_in_name
	 */
	public void setHs_diagnosis_in_name(String Hs_diagnosis_in_name) {
		setAttrVal("Hs_diagnosis_in_name", Hs_diagnosis_in_name);
	}
	/**
	 * 出院诊断中文名
	 * @return String
	 */
	public String getHs_diagnosis_out_name() {
		return ((String) getAttrVal("Hs_diagnosis_out_name"));
	}
	/**
	 * 出院诊断中文名
	 * @param Hs_diagnosis_out_name
	 */
	public void setHs_diagnosis_out_name(String Hs_diagnosis_out_name) {
		setAttrVal("Hs_diagnosis_out_name", Hs_diagnosis_out_name);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getHs_in_number() {
		return ((String) getAttrVal("Hs_in_number"));
	}
	/**
	 * 病案号
	 * @param Hs_in_number
	 */
	public void setHs_in_number(String Hs_in_number) {
		setAttrVal("Hs_in_number", Hs_in_number);
	}
	/**
	 * 住院号\门诊号
	 * @return String
	 */
	public String getHs_number() {
		return ((String) getAttrVal("Hs_number"));
	}
	/**
	 * 住院号\门诊号
	 * @param Hs_number
	 */
	public void setHs_number(String Hs_number) {
		setAttrVal("Hs_number", Hs_number);
	}
	/**
	 * 参保人姓名
	 * @return String
	 */
	public String getHs_patient_name() {
		return ((String) getAttrVal("Hs_patient_name"));
	}
	/**
	 * 参保人姓名
	 * @param Hs_patient_name
	 */
	public void setHs_patient_name(String Hs_patient_name) {
		setAttrVal("Hs_patient_name", Hs_patient_name);
	}
	/**
	 * 住院状态(0未结算1已结算，默认1)
	 * @return String
	 */
	public String getHs_status() {
		return ((String) getAttrVal("Hs_status"));
	}
	/**
	 * 住院状态(0未结算1已结算，默认1)
	 * @param Hs_status
	 */
	public void setHs_status(String Hs_status) {
		setAttrVal("Hs_status", Hs_status);
	}
	/**
	 * 定点机构类型
	 * @return String
	 */
	public String getHospitaltype() {
		return ((String) getAttrVal("Hospitaltype"));
	}
	/**
	 * 定点机构类型
	 * @param Hospitaltype
	 */
	public void setHospitaltype(String Hospitaltype) {
		setAttrVal("Hospitaltype", Hospitaltype);
	}
	/**
	 * 主单ID(唯一编码.非空)
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主单ID(唯一编码.非空)
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getIn_date() {
		return ((FDateTime) getAttrVal("In_date"));
	}
	/**
	 * 入院日期
	 * @param In_date
	 */
	public void setIn_date(FDateTime In_date) {
		setAttrVal("In_date", In_date);
	}
	/**
	 * 是否哺乳期(0否1是)
	 * @return String
	 */
	public String getIslactation() {
		return ((String) getAttrVal("Islactation"));
	}
	/**
	 * 是否哺乳期(0否1是)
	 * @param Islactation
	 */
	public void setIslactation(String Islactation) {
		setAttrVal("Islactation", Islactation);
	}
	/**
	 * 是否孕期(0否1是)
	 * @return String
	 */
	public String getIspregnant() {
		return ((String) getAttrVal("Ispregnant"));
	}
	/**
	 * 是否孕期(0否1是)
	 * @param Ispregnant
	 */
	public void setIspregnant(String Ispregnant) {
		setAttrVal("Ispregnant", Ispregnant);
	}
	/**
	 * 就医方式
	 * @return String
	 */
	public String getMedical_type() {
		return ((String) getAttrVal("Medical_type"));
	}
	/**
	 * 就医方式
	 * @param Medical_type
	 */
	public void setMedical_type(String Medical_type) {
		setAttrVal("Medical_type", Medical_type);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getOut_date() {
		return ((FDateTime) getAttrVal("Out_date"));
	}
	/**
	 * 出院日期
	 * @param Out_date
	 */
	public void setOut_date(FDateTime Out_date) {
		setAttrVal("Out_date", Out_date);
	}
	/**
	 * 出生日期
	 * @return FDateTime
	 */
	public FDate getPatient_birth() {
		return ((FDate) getAttrVal("Patient_birth"));
	}
	/**
	 * 出生日期
	 * @param Patient_birth
	 */
	public void setPatient_birth(FDate Patient_birth) {
		setAttrVal("Patient_birth", Patient_birth);
	}
	/**
	 * 参保人特殊保险类型组编码
	 * @return String
	 */
	public String getPatientbenefitgroupcode() {
		return ((String) getAttrVal("Patientbenefitgroupcode"));
	}
	/**
	 * 参保人特殊保险类型组编码
	 * @param Patientbenefitgroupcode
	 */
	public void setPatientbenefitgroupcode(String Patientbenefitgroupcode) {
		setAttrVal("Patientbenefitgroupcode", Patientbenefitgroupcode);
	}
	/**
	 * 参保人唯一编码
	 * @return String
	 */
	public String getPatient_idstr() {
		return ((String) getAttrVal("Patient_idstr"));
	}
	/**
	 * 参保人唯一编码
	 * @param Patient_idstr
	 */
	public void setPatient_idstr(String Patient_idstr) {
		setAttrVal("Patient_idstr", Patient_idstr);
	}
	/**
	 * 结算日期
	 * @return FDateTime
	 */
	public FDateTime getSettle_date() {
		return ((FDateTime) getAttrVal("Settle_date"));
	}
	/**
	 * 结算日期
	 * @param Settle_date
	 */
	public void setSettle_date(FDateTime Settle_date) {
		setAttrVal("Settle_date", Settle_date);
	}
	/**
	 * 总费用
	 * @return FDouble
	 */
	public FDouble getTotal_cost() {
		return ((FDouble) getAttrVal("Total_cost"));
	}
	/**
	 * 总费用
	 * @param Total_cost
	 */
	public void setTotal_cost(FDouble Total_cost) {
		setAttrVal("Total_cost", Total_cost);
	}
	/**
	 * 是否异地就医(0否1是)
	 * @return String
	 */
	public String getUnusual_flag() {
		return ((String) getAttrVal("Unusual_flag"));
	}
	/**
	 * 是否异地就医(0否1是)
	 * @param Unusual_flag
	 */
	public void setUnusual_flag(String Unusual_flag) {
		setAttrVal("Unusual_flag", Unusual_flag);
	}
	/**
	 * 公务员标记(0否1是)
	 * @return String
	 */
	public String getZ_aact007() {
		return ((String) getAttrVal("Z_aact007"));
	}
	/**
	 * 公务员标记(0否1是)
	 * @param Z_aact007
	 */
	public void setZ_aact007(String Z_aact007) {
		setAttrVal("Z_aact007", Z_aact007);
	}
	/**
	 * 诊疗项目限价类别
	 * @return String
	 */
	public String getZ_aact008() {
		return ((String) getAttrVal("Z_aact008"));
	}
	/**
	 * 诊疗项目限价类别
	 * @param Z_aact008
	 */
	public void setZ_aact008(String Z_aact008) {
		setAttrVal("Z_aact008", Z_aact008);
	}
	/**
	 * 预留三(默认0)
	 * @return String
	 */
	public String getZ_bac021() {
		return ((String) getAttrVal("Z_bac021"));
	}
	/**
	 * 预留三(默认0)
	 * @param Z_bac021
	 */
	public void setZ_bac021(String Z_bac021) {
		setAttrVal("Z_bac021", Z_bac021);
	}
}