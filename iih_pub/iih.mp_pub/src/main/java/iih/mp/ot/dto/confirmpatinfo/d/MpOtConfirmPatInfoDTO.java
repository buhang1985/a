package iih.mp.ot.dto.confirmpatinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者信息 DTO数据 
 * 
 */
public class MpOtConfirmPatInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	 * 就诊号
	 * @return String
	 */
	public String getCode_en() {
		return ((String) getAttrVal("Code_en"));
	}
	/**
	 * 就诊号
	 * @param Code_en
	 */
	public void setCode_en(String Code_en) {
		setAttrVal("Code_en", Code_en);
	}
	/**
	 * 住院就诊次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}
	/**
	 * 住院就诊次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 就诊日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 就诊日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 接诊医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 接诊医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 号别
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 号别
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
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
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 接诊日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 接诊日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
}