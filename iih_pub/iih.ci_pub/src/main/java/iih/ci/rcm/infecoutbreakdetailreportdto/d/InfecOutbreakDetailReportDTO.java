package iih.ci.rcm.infecoutbreakdetailreportdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医院感染暴发详情报告登记表 DTO数据 
 * 
 */
public class InfecOutbreakDetailReportDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医院感染暴发详情报告主键
	 * @return String
	 */
	public String getId_infeoutdetailredto() {
		return ((String) getAttrVal("Id_infeoutdetailredto"));
	}
	/**
	 * 医院感染暴发详情报告主键
	 * @param Id_infeoutdetailredto
	 */
	public void setId_infeoutdetailredto(String Id_infeoutdetailredto) {
		setAttrVal("Id_infeoutdetailredto", Id_infeoutdetailredto);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSerial_number() {
		return ((Integer) getAttrVal("Serial_number"));
	}
	/**
	 * 序号
	 * @param Serial_number
	 */
	public void setSerial_number(Integer Serial_number) {
		setAttrVal("Serial_number", Serial_number);
	}
	/**
	 * 调查表时间
	 * @return String
	 */
	public String getInvestigatetime() {
		return ((String) getAttrVal("Investigatetime"));
	}
	/**
	 * 调查表时间
	 * @param Investigatetime
	 */
	public void setInvestigatetime(String Investigatetime) {
		setAttrVal("Investigatetime", Investigatetime);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 病人
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 病人
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 病人编码
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}
	/**
	 * 病人编码
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 病人姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 病人姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 病历号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dept() {
		return ((String) getAttrVal("Sd_dept"));
	}
	/**
	 * 科室编码
	 * @param Sd_dept
	 */
	public void setSd_dept(String Sd_dept) {
		setAttrVal("Sd_dept", Sd_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 入院日期
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院日期
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 天数
	 * @return String
	 */
	public String getDays() {
		return ((String) getAttrVal("Days"));
	}
	/**
	 * 天数
	 * @param Days
	 */
	public void setDays(String Days) {
		setAttrVal("Days", Days);
	}
}