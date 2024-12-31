package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 床位卡dto DTO数据 
 * 
 */
public class DeptBedBeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 床code
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}
	/**
	 * 床code
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	/**
	 * 当前护理单位
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 当前护理单位
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 床id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}
	/**
	 * 床号
	 * @param Bed_name
	 */
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
	}
	/**
	 * 床位状态编码
	 * @return String
	 */
	public String getSd_bedsu() {
		return ((String) getAttrVal("Sd_bedsu"));
	}
	/**
	 * 床位状态编码
	 * @param Sd_bedsu
	 */
	public void setSd_bedsu(String Sd_bedsu) {
		setAttrVal("Sd_bedsu", Sd_bedsu);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 患者性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getGetdate() {
		return ((FDateTime) getAttrVal("Getdate"));
	}
	/**
	 * 入院日期
	 * @param Getdate
	 */
	public void setGetdate(FDateTime Getdate) {
		setAttrVal("Getdate", Getdate);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 诊断描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情等级编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 护理等级编码
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}
	/**
	 * 护理等级编码
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 营养等级编码
	 * @return String
	 */
	public String getSd_level_nutr() {
		return ((String) getAttrVal("Sd_level_nutr"));
	}
	/**
	 * 营养等级编码
	 * @param Sd_level_nutr
	 */
	public void setSd_level_nutr(String Sd_level_nutr) {
		setAttrVal("Sd_level_nutr", Sd_level_nutr);
	}
	/**
	 * 是否手术
	 * @return FBoolean
	 */
	public FBoolean getFg_surg() {
		return ((FBoolean) getAttrVal("Fg_surg"));
	}
	/**
	 * 是否手术
	 * @param Fg_surg
	 */
	public void setFg_surg(FBoolean Fg_surg) {
		setAttrVal("Fg_surg", Fg_surg);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_mari_pat() {
		return ((String) getAttrVal("Sd_mari_pat"));
	}
	/**
	 * 婚姻状况编码
	 * @param Sd_mari_pat
	 */
	public void setSd_mari_pat(String Sd_mari_pat) {
		setAttrVal("Sd_mari_pat", Sd_mari_pat);
	}
	/**
	 * 就诊预交金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 就诊预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 账单费用
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 账单费用
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 当前费用余额
	 * @return FDouble
	 */
	public FDouble getBalance() {
		return ((FDouble) getAttrVal("Balance"));
	}
	/**
	 * 当前费用余额
	 * @param Balance
	 */
	public void setBalance(FDouble Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getDoctor() {
		return ((String) getAttrVal("Doctor"));
	}
	/**
	 * 当前主管医生
	 * @param Doctor
	 */
	public void setDoctor(String Doctor) {
		setAttrVal("Doctor", Doctor);
	}
	/**
	 * 当前主管护士
	 * @return String
	 */
	public String getNurse() {
		return ((String) getAttrVal("Nurse"));
	}
	/**
	 * 当前主管护士
	 * @param Nurse
	 */
	public void setNurse(String Nurse) {
		setAttrVal("Nurse", Nurse);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getDephyname() {
		return ((String) getAttrVal("Dephyname"));
	}
	/**
	 * 科室
	 * @param Dephyname
	 */
	public void setDephyname(String Dephyname) {
		setAttrVal("Dephyname", Dephyname);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}
	/**
	 * 病区
	 * @param Deptname
	 */
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	/**
	 * 主医保计划名称
	 * @return String
	 */
	public String getHpname() {
		return ((String) getAttrVal("Hpname"));
	}
	/**
	 * 主医保计划名称
	 * @param Hpname
	 */
	public void setHpname(String Hpname) {
		setAttrVal("Hpname", Hpname);
	}
	/**
	 * 次医保计划名称
	 * @return String
	 */
	public String getTimehpname() {
		return ((String) getAttrVal("Timehpname"));
	}
	/**
	 * 次医保计划名称
	 * @param Timehpname
	 */
	public void setTimehpname(String Timehpname) {
		setAttrVal("Timehpname", Timehpname);
	}
	/**
	 * 患者性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 患者性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 病情等级id
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级id
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 护理等级id
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}
	/**
	 * 护理等级id
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 营养等级id
	 * @return String
	 */
	public String getId_level_nutr() {
		return ((String) getAttrVal("Id_level_nutr"));
	}
	/**
	 * 营养等级id
	 * @param Id_level_nutr
	 */
	public void setId_level_nutr(String Id_level_nutr) {
		setAttrVal("Id_level_nutr", Id_level_nutr);
	}
	/**
	 * 参照用病情等级名称
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 参照用病情等级名称
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 参照用护理等级名称
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}
	/**
	 * 参照用护理等级名称
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
	}
	/**
	 * 参照用营养等级名称
	 * @return String
	 */
	public String getName_level_nutr() {
		return ((String) getAttrVal("Name_level_nutr"));
	}
	/**
	 * 参照用营养等级名称
	 * @param Name_level_nutr
	 */
	public void setName_level_nutr(String Name_level_nutr) {
		setAttrVal("Name_level_nutr", Name_level_nutr);
	}
	/**
	 * 参照用患者性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 参照用患者性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
}