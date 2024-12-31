package iih.ei.std.d.v1.mp.ipdispdrugInfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院发药明细 DTO数据 
 * 
 */
public class IPCollocateDrugDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病例号
	 * @return String
	 */
	public String getNo_inpatient() {
		return ((String) getAttrVal("No_inpatient"));
	}	
	/**
	 * 病例号
	 * @param No_inpatient
	 */
	public void setNo_inpatient(String No_inpatient) {
		setAttrVal("No_inpatient", No_inpatient);
	}
	/**
	 * 病人ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 病人ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getCode_ward() {
		return ((String) getAttrVal("Code_ward"));
	}	
	/**
	 * 病区编码
	 * @param Code_ward
	 */
	public void setCode_ward(String Code_ward) {
		setAttrVal("Code_ward", Code_ward);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_ward() {
		return ((String) getAttrVal("Name_ward"));
	}	
	/**
	 * 病区名称
	 * @param Name_ward
	 */
	public void setName_ward(String Name_ward) {
		setAttrVal("Name_ward", Name_ward);
	}
	/**
	 * 医生
	 * @return String
	 */
	public String getDoctor() {
		return ((String) getAttrVal("Doctor"));
	}	
	/**
	 * 医生
	 * @param Doctor
	 */
	public void setDoctor(String Doctor) {
		setAttrVal("Doctor", Doctor);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getNo_bed() {
		return ((String) getAttrVal("No_bed"));
	}	
	/**
	 * 床号
	 * @param No_bed
	 */
	public void setNo_bed(String No_bed) {
		setAttrVal("No_bed", No_bed);
	}
	/**
	 * 服用方法
	 * @return String
	 */
	public String getComm1() {
		return ((String) getAttrVal("Comm1"));
	}	
	/**
	 * 服用方法
	 * @param Comm1
	 */
	public void setComm1(String Comm1) {
		setAttrVal("Comm1", Comm1);
	}
	/**
	 * 医生嘱托
	 * @return String
	 */
	public String getComm2() {
		return ((String) getAttrVal("Comm2"));
	}	
	/**
	 * 医生嘱托
	 * @param Comm2
	 */
	public void setComm2(String Comm2) {
		setAttrVal("Comm2", Comm2);
	}
	/**
	 * 服用方法(中间表)
	 * @return String
	 */
	public String getComment() {
		return ((String) getAttrVal("Comment"));
	}	
	/**
	 * 服用方法(中间表)
	 * @param Comment
	 */
	public void setComment(String Comment) {
		setAttrVal("Comment", Comment);
	}
	/**
	 * 药品编码
	 * @return String
	 */
	public String getCode_drug() {
		return ((String) getAttrVal("Code_drug"));
	}	
	/**
	 * 药品编码
	 * @param Code_drug
	 */
	public void setCode_drug(String Code_drug) {
		setAttrVal("Code_drug", Code_drug);
	}
	/**
	 * 药品名称
	 * @return String
	 */
	public String getName_drug() {
		return ((String) getAttrVal("Name_drug"));
	}	
	/**
	 * 药品名称
	 * @param Name_drug
	 */
	public void setName_drug(String Name_drug) {
		setAttrVal("Name_drug", Name_drug);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpecification() {
		return ((String) getAttrVal("Specification"));
	}	
	/**
	 * 规格
	 * @param Specification
	 */
	public void setSpecification(String Specification) {
		setAttrVal("Specification", Specification);
	}
	/**
	 * 药品规格
	 * @return String
	 */
	public String getSpec_drug() {
		return ((String) getAttrVal("Spec_drug"));
	}	
	/**
	 * 药品规格
	 * @param Spec_drug
	 */
	public void setSpec_drug(String Spec_drug) {
		setAttrVal("Spec_drug", Spec_drug);
	}
	/**
	 * 单位规格大小
	 * @return FDouble
	 */
	public FDouble getDos_per() {
		return ((FDouble) getAttrVal("Dos_per"));
	}	
	/**
	 * 单位规格大小
	 * @param Dos_per
	 */
	public void setDos_per(FDouble Dos_per) {
		setAttrVal("Dos_per", Dos_per);
	}
	/**
	 * 规格单位
	 * @return String
	 */
	public String getDos_per_units() {
		return ((String) getAttrVal("Dos_per_units"));
	}	
	/**
	 * 规格单位
	 * @param Dos_per_units
	 */
	public void setDos_per_units(String Dos_per_units) {
		setAttrVal("Dos_per_units", Dos_per_units);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getDosage() {
		return ((FDouble) getAttrVal("Dosage"));
	}	
	/**
	 * 剂量
	 * @param Dosage
	 */
	public void setDosage(FDouble Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 剂量单位
	 * @return String
	 */
	public String getUnit_dos() {
		return ((String) getAttrVal("Unit_dos"));
	}	
	/**
	 * 剂量单位
	 * @param Unit_dos
	 */
	public void setUnit_dos(String Unit_dos) {
		setAttrVal("Unit_dos", Unit_dos);
	}
	/**
	 * 服用数量
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	/**
	 * 服用数量
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 领药量
	 * @return FDouble
	 */
	public FDouble getTotal() {
		return ((FDouble) getAttrVal("Total"));
	}	
	/**
	 * 领药量
	 * @param Total
	 */
	public void setTotal(FDouble Total) {
		setAttrVal("Total", Total);
	}
	/**
	 * 服药时间
	 * @return FDateTime
	 */
	public FDateTime getTime_occ() {
		return ((FDateTime) getAttrVal("Time_occ"));
	}	
	/**
	 * 服药时间
	 * @param Time_occ
	 */
	public void setTime_occ(FDateTime Time_occ) {
		setAttrVal("Time_occ", Time_occ);
	}
	/**
	 * 标记
	 * @return String
	 */
	public String getFlag() {
		return ((String) getAttrVal("Flag"));
	}	
	/**
	 * 标记
	 * @param Flag
	 */
	public void setFlag(String Flag) {
		setAttrVal("Flag", Flag);
	}
	/**
	 * 分包设备编号
	 * @return String
	 */
	public String getNo_atf() {
		return ((String) getAttrVal("No_atf"));
	}	
	/**
	 * 分包设备编号
	 * @param No_atf
	 */
	public void setNo_atf(String No_atf) {
		setAttrVal("No_atf", No_atf);
	}
	/**
	 * 优先标记
	 * @return String
	 */
	public String getPri_flag() {
		return ((String) getAttrVal("Pri_flag"));
	}	
	/**
	 * 优先标记
	 * @param Pri_flag
	 */
	public void setPri_flag(String Pri_flag) {
		setAttrVal("Pri_flag", Pri_flag);
	}
	/**
	 * 本次申请的唯一号
	 * @return String
	 */
	public String getNo_page() {
		return ((String) getAttrVal("No_page"));
	}	
	/**
	 * 本次申请的唯一号
	 * @param No_page
	 */
	public void setNo_page(String No_page) {
		setAttrVal("No_page", No_page);
	}
	/**
	 * 明细编号
	 * @return String
	 */
	public String getCode_detail() {
		return ((String) getAttrVal("Code_detail"));
	}	
	/**
	 * 明细编号
	 * @param Code_detail
	 */
	public void setCode_detail(String Code_detail) {
		setAttrVal("Code_detail", Code_detail);
	}
	/**
	 * 生成X档的时间
	 * @return FDateTime
	 */
	public FDateTime getTime_gen() {
		return ((FDateTime) getAttrVal("Time_gen"));
	}	
	/**
	 * 生成X档的时间
	 * @param Time_gen
	 */
	public void setTime_gen(FDateTime Time_gen) {
		setAttrVal("Time_gen", Time_gen);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getFlag_mz() {
		return ((String) getAttrVal("Flag_mz"));
	}	
	/**
	 * 医嘱类型
	 * @param Flag_mz
	 */
	public void setFlag_mz(String Flag_mz) {
		setAttrVal("Flag_mz", Flag_mz);
	}
}