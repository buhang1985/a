package iih.ci.mrqc.randomqc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 抽查记录明细dto DTO数据 
 * 
 */
public class MrQcRandomItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录明细主键
	 * @return String
	 */
	public String getId_random_itm() {
		return ((String) getAttrVal("Id_random_itm"));
	}
	/**
	 * 记录明细主键
	 * @param Id_random_itm
	 */
	public void setId_random_itm(String Id_random_itm) {
		setAttrVal("Id_random_itm", Id_random_itm);
	}
	/**
	 * 抽查状态
	 * @return String
	 */
	public String getId_check_status() {
		return ((String) getAttrVal("Id_check_status"));
	}
	/**
	 * 抽查状态
	 * @param Id_check_status
	 */
	public void setId_check_status(String Id_check_status) {
		setAttrVal("Id_check_status", Id_check_status);
	}
	/**
	 * 抽查状态编码
	 * @return String
	 */
	public String getSd_check_status() {
		return ((String) getAttrVal("Sd_check_status"));
	}
	/**
	 * 抽查状态编码
	 * @param Sd_check_status
	 */
	public void setSd_check_status(String Sd_check_status) {
		setAttrVal("Sd_check_status", Sd_check_status);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 门诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 门诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}
	/**
	 * 年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getPat_sex() {
		return ((String) getAttrVal("Pat_sex"));
	}
	/**
	 * 性别
	 * @param Pat_sex
	 */
	public void setPat_sex(String Pat_sex) {
		setAttrVal("Pat_sex", Pat_sex);
	}
	/**
	 * 当前主管医生主键
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 当前主管医生主键
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getSd_emp_phy() {
		return ((String) getAttrVal("Sd_emp_phy"));
	}
	/**
	 * 医生编码
	 * @param Sd_emp_phy
	 */
	public void setSd_emp_phy(String Sd_emp_phy) {
		setAttrVal("Sd_emp_phy", Sd_emp_phy);
	}
	/**
	 * 就诊医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 就诊医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 当前就诊科室主键
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 当前就诊科室主键
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 科室编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
	 * 抽查时间
	 * @return FDateTime
	 */
	public FDateTime getDt_random() {
		return ((FDateTime) getAttrVal("Dt_random"));
	}
	/**
	 * 抽查时间
	 * @param Dt_random
	 */
	public void setDt_random(FDateTime Dt_random) {
		setAttrVal("Dt_random", Dt_random);
	}
	/**
	 * 抽查医生
	 * @return String
	 */
	public String getName_emp_random() {
		return ((String) getAttrVal("Name_emp_random"));
	}
	/**
	 * 抽查医生
	 * @param Name_emp_random
	 */
	public void setName_emp_random(String Name_emp_random) {
		setAttrVal("Name_emp_random", Name_emp_random);
	}
	/**
	 * 抽查人主键
	 * @return String
	 */
	public String getId_emp_random() {
		return ((String) getAttrVal("Id_emp_random"));
	}
	/**
	 * 抽查人主键
	 * @param Id_emp_random
	 */
	public void setId_emp_random(String Id_emp_random) {
		setAttrVal("Id_emp_random", Id_emp_random);
	}
	/**
	 * 抽查科室主键
	 * @return String
	 */
	public String getId_dep_random() {
		return ((String) getAttrVal("Id_dep_random"));
	}
	/**
	 * 抽查科室主键
	 * @param Id_dep_random
	 */
	public void setId_dep_random(String Id_dep_random) {
		setAttrVal("Id_dep_random", Id_dep_random);
	}
	/**
	 * 抽查科室
	 * @return String
	 */
	public String getName_dep_random() {
		return ((String) getAttrVal("Name_dep_random"));
	}
	/**
	 * 抽查科室
	 * @param Name_dep_random
	 */
	public void setName_dep_random(String Name_dep_random) {
		setAttrVal("Name_dep_random", Name_dep_random);
	}
	/**
	 * 审核人主键
	 * @return String
	 */
	public String getId_emp_examine() {
		return ((String) getAttrVal("Id_emp_examine"));
	}
	/**
	 * 审核人主键
	 * @param Id_emp_examine
	 */
	public void setId_emp_examine(String Id_emp_examine) {
		setAttrVal("Id_emp_examine", Id_emp_examine);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getName_emp_examine() {
		return ((String) getAttrVal("Name_emp_examine"));
	}
	/**
	 * 审核人
	 * @param Name_emp_examine
	 */
	public void setName_emp_examine(String Name_emp_examine) {
		setAttrVal("Name_emp_examine", Name_emp_examine);
	}
	/**
	 * 审核科室主键
	 * @return String
	 */
	public String getId_dep_examine() {
		return ((String) getAttrVal("Id_dep_examine"));
	}
	/**
	 * 审核科室主键
	 * @param Id_dep_examine
	 */
	public void setId_dep_examine(String Id_dep_examine) {
		setAttrVal("Id_dep_examine", Id_dep_examine);
	}
	/**
	 * 审核科室
	 * @return String
	 */
	public String getName_dep_examine() {
		return ((String) getAttrVal("Name_dep_examine"));
	}
	/**
	 * 审核科室
	 * @param Name_dep_examine
	 */
	public void setName_dep_examine(String Name_dep_examine) {
		setAttrVal("Name_dep_examine", Name_dep_examine);
	}
	/**
	 * 病案主键
	 * @return String
	 */
	public String getId_amr() {
		return ((String) getAttrVal("Id_amr"));
	}
	/**
	 * 病案主键
	 * @param Id_amr
	 */
	public void setId_amr(String Id_amr) {
		setAttrVal("Id_amr", Id_amr);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}
	/**
	 * 住院号
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 缺陷次数
	 * @return Integer
	 */
	public Integer getFlt_times() {
		return ((Integer) getAttrVal("Flt_times"));
	}
	/**
	 * 缺陷次数
	 * @param Flt_times
	 */
	public void setFlt_times(Integer Flt_times) {
		setAttrVal("Flt_times", Flt_times);
	}
	/**
	 * 抽查状态名称
	 * @return String
	 */
	public String getName_check_status() {
		return ((String) getAttrVal("Name_check_status"));
	}
	/**
	 * 抽查状态名称
	 * @param Name_check_status
	 */
	public void setName_check_status(String Name_check_status) {
		setAttrVal("Name_check_status", Name_check_status);
	}
	/**
	 * 分数
	 * @return String
	 */
	public String getScore() {
		return ((String) getAttrVal("Score"));
	}
	/**
	 * 分数
	 * @param Score
	 */
	public void setScore(String Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 质控标记
	 * @return FBoolean
	 */
	public FBoolean getFg_mrqc() {
		return ((FBoolean) getAttrVal("Fg_mrqc"));
	}
	/**
	 * 质控标记
	 * @param Fg_mrqc
	 */
	public void setFg_mrqc(FBoolean Fg_mrqc) {
		setAttrVal("Fg_mrqc", Fg_mrqc);
	}
	/**
	 * 终末质控标记
	 * @return FBoolean
	 */
	public FBoolean getFg_mrqc_terminal() {
		return ((FBoolean) getAttrVal("Fg_mrqc_terminal"));
	}
	/**
	 * 终末质控标记
	 * @param Fg_mrqc_terminal
	 */
	public void setFg_mrqc_terminal(FBoolean Fg_mrqc_terminal) {
		setAttrVal("Fg_mrqc_terminal", Fg_mrqc_terminal);
	}
	/**
	 * 终末分数
	 * @return String
	 */
	public String getScore_terminal() {
		return ((String) getAttrVal("Score_terminal"));
	}
	/**
	 * 终末分数
	 * @param Score_terminal
	 */
	public void setScore_terminal(String Score_terminal) {
		setAttrVal("Score_terminal", Score_terminal);
	}
}