package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院召回DTO DTO数据 
 * 
 */
public class HosRecallDTO extends BaseDTO {
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
	 * 住院号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 住院号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return Integer
	 */
	public Integer getSd_sex_pat() {
		return ((Integer) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 性别
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(Integer Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
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
	/**
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge_pat() {
		return ((Integer) getAttrVal("Age_pat"));
	}
	/**
	 * 年龄
	 * @param Age_pat
	 */
	public void setAge_pat(Integer Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 床位id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
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
	 * 新床位id
	 * @return String
	 */
	public String getId_bed_new() {
		return ((String) getAttrVal("Id_bed_new"));
	}
	/**
	 * 新床位id
	 * @param Id_bed_new
	 */
	public void setId_bed_new(String Id_bed_new) {
		setAttrVal("Id_bed_new", Id_bed_new);
	}
	/**
	 * 新床号
	 * @return String
	 */
	public String getName_bed_new() {
		return ((String) getAttrVal("Name_bed_new"));
	}
	/**
	 * 新床号
	 * @param Name_bed_new
	 */
	public void setName_bed_new(String Name_bed_new) {
		setAttrVal("Name_bed_new", Name_bed_new);
	}
	/**
	 * 是否结算
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 是否结算
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 新生儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_newborn() {
		return ((FBoolean) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新生儿标识
	 * @param Fg_newborn
	 */
	public void setFg_newborn(FBoolean Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 母亲id
	 * @return String
	 */
	public String getId_ent_mom() {
		return ((String) getAttrVal("Id_ent_mom"));
	}
	/**
	 * 母亲id
	 * @param Id_ent_mom
	 */
	public void setId_ent_mom(String Id_ent_mom) {
		setAttrVal("Id_ent_mom", Id_ent_mom);
	}
	/**
	 * 在院科室
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 在院科室
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 在院病区
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 在院病区
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 病区
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 是否费用召回
	 * @return FBoolean
	 */
	public FBoolean getFg_blrecall() {
		return ((FBoolean) getAttrVal("Fg_blrecall"));
	}
	/**
	 * 是否费用召回
	 * @param Fg_blrecall
	 */
	public void setFg_blrecall(FBoolean Fg_blrecall) {
		setAttrVal("Fg_blrecall", Fg_blrecall);
	}
	/**
	 * 诊疗费用是否审核
	 * @return FBoolean
	 */
	public FBoolean getFg_pass_clinic() {
		return ((FBoolean) getAttrVal("Fg_pass_clinic"));
	}
	/**
	 * 诊疗费用是否审核
	 * @param Fg_pass_clinic
	 */
	public void setFg_pass_clinic(FBoolean Fg_pass_clinic) {
		setAttrVal("Fg_pass_clinic", Fg_pass_clinic);
	}
	/**
	 * 医保费用是否审核
	 * @return FBoolean
	 */
	public FBoolean getFg_pass_hp() {
		return ((FBoolean) getAttrVal("Fg_pass_hp"));
	}
	/**
	 * 医保费用是否审核
	 * @param Fg_pass_hp
	 */
	public void setFg_pass_hp(FBoolean Fg_pass_hp) {
		setAttrVal("Fg_pass_hp", Fg_pass_hp);
	}
}