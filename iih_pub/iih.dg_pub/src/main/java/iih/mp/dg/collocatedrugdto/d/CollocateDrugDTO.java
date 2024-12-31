package iih.mp.dg.collocatedrugdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 包药机中间表 DTO数据 
 * 
 */
public class CollocateDrugDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病例号
	 * @return String
	 */
	public String getInpatient_no() {
		return ((String) getAttrVal("Inpatient_no"));
	}
	/**
	 * 病例号
	 * @param Inpatient_no
	 */
	public void setInpatient_no(String Inpatient_no) {
		setAttrVal("Inpatient_no", Inpatient_no);
	}
	/**
	 * 病人ID
	 * @return String
	 */
	public String getP_id() {
		return ((String) getAttrVal("P_id"));
	}
	/**
	 * 病人ID
	 * @param P_id
	 */
	public void setP_id(String P_id) {
		setAttrVal("P_id", P_id);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getDept_sn() {
		return ((String) getAttrVal("Dept_sn"));
	}
	/**
	 * 科室编码
	 * @param Dept_sn
	 */
	public void setDept_sn(String Dept_sn) {
		setAttrVal("Dept_sn", Dept_sn);
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
	 * 病区编码
	 * @return String
	 */
	public String getWard_sn() {
		return ((String) getAttrVal("Ward_sn"));
	}
	/**
	 * 病区编码
	 * @param Ward_sn
	 */
	public void setWard_sn(String Ward_sn) {
		setAttrVal("Ward_sn", Ward_sn);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getWard_name() {
		return ((String) getAttrVal("Ward_name"));
	}
	/**
	 * 病区名称
	 * @param Ward_name
	 */
	public void setWard_name(String Ward_name) {
		setAttrVal("Ward_name", Ward_name);
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
	public String getDrug_code() {
		return ((String) getAttrVal("Drug_code"));
	}
	/**
	 * 药品编码
	 * @param Drug_code
	 */
	public void setDrug_code(String Drug_code) {
		setAttrVal("Drug_code", Drug_code);
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
	public String getDrug_spec() {
		return ((String) getAttrVal("Drug_spec"));
	}
	/**
	 * 药品规格
	 * @param Drug_spec
	 */
	public void setDrug_spec(String Drug_spec) {
		setAttrVal("Drug_spec", Drug_spec);
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
	public String getDos_unit() {
		return ((String) getAttrVal("Dos_unit"));
	}
	/**
	 * 剂量单位
	 * @param Dos_unit
	 */
	public void setDos_unit(String Dos_unit) {
		setAttrVal("Dos_unit", Dos_unit);
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
	public FDateTime getOcc_time() {
		return ((FDateTime) getAttrVal("Occ_time"));
	}
	/**
	 * 服药时间
	 * @param Occ_time
	 */
	public void setOcc_time(FDateTime Occ_time) {
		setAttrVal("Occ_time", Occ_time);
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
	public String getAtf_no() {
		return ((String) getAttrVal("Atf_no"));
	}
	/**
	 * 分包设备编号
	 * @param Atf_no
	 */
	public void setAtf_no(String Atf_no) {
		setAttrVal("Atf_no", Atf_no);
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
	public String getPage_no() {
		return ((String) getAttrVal("Page_no"));
	}
	/**
	 * 本次申请的唯一号
	 * @param Page_no
	 */
	public void setPage_no(String Page_no) {
		setAttrVal("Page_no", Page_no);
	}
	/**
	 * 明细编号
	 * @return String
	 */
	public String getDetail_sn() {
		return ((String) getAttrVal("Detail_sn"));
	}
	/**
	 * 明细编号
	 * @param Detail_sn
	 */
	public void setDetail_sn(String Detail_sn) {
		setAttrVal("Detail_sn", Detail_sn);
	}
	/**
	 * 生成X档的时间
	 * @return FDateTime
	 */
	public FDateTime getGen_time() {
		return ((FDateTime) getAttrVal("Gen_time"));
	}
	/**
	 * 生成X档的时间
	 * @param Gen_time
	 */
	public void setGen_time(FDateTime Gen_time) {
		setAttrVal("Gen_time", Gen_time);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getMz_flag() {
		return ((String) getAttrVal("Mz_flag"));
	}
	/**
	 * 医嘱类型
	 * @param Mz_flag
	 */
	public void setMz_flag(String Mz_flag) {
		setAttrVal("Mz_flag", Mz_flag);
	}
}