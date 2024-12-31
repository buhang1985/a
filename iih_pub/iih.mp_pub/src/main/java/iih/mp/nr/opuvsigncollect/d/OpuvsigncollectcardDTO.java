package iih.mp.nr.opuvsigncollect.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门急诊体温录入卡dto DTO数据 
 * 
 */
public class OpuvsigncollectcardDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getDept() {
		return ((String) getAttrVal("Dept"));
	}
	/**
	 * 科室
	 * @param Dept
	 */
	public void setDept(String Dept) {
		setAttrVal("Dept", Dept);
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
	 * 患者分类
	 * @return String
	 */
	public String getPatientca() {
		return ((String) getAttrVal("Patientca"));
	}
	/**
	 * 患者分类
	 * @param Patientca
	 */
	public void setPatientca(String Patientca) {
		setAttrVal("Patientca", Patientca);
	}
	/**
	 * 测量日期
	 * @return FDate
	 */
	public FDate getDt_surey() {
		return ((FDate) getAttrVal("Dt_surey"));
	}
	/**
	 * 测量日期
	 * @param Dt_surey
	 */
	public void setDt_surey(FDate Dt_surey) {
		setAttrVal("Dt_surey", Dt_surey);
	}
	/**
	 * 测量时间
	 * @return FTime
	 */
	public FTime getT_surey() {
		return ((FTime) getAttrVal("T_surey"));
	}
	/**
	 * 测量时间
	 * @param T_surey
	 */
	public void setT_surey(FTime T_surey) {
		setAttrVal("T_surey", T_surey);
	}
	/**
	 * 时间分组
	 * @return String
	 */
	public String getTime_begin() {
		return ((String) getAttrVal("Time_begin"));
	}
	/**
	 * 时间分组
	 * @param Time_begin
	 */
	public void setTime_begin(String Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	/**
	 * 日期时间分组
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期时间分组
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 就诊登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊登记时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 就诊状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 就诊状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
}