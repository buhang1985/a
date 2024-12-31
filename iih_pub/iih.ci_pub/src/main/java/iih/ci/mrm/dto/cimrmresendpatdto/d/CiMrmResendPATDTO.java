package iih.ci.mrm.dto.cimrmresendpatdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 病案重发患者信息DTO DTO数据 
 * 
 */
public class CiMrmResendPATDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案重发主键
	 * @return String
	 */
	public String getId_rspat() {
		return ((String) getAttrVal("Id_rspat"));
	}
	/**
	 * 病案重发主键
	 * @param Id_rspat
	 */
	public void setId_rspat(String Id_rspat) {
		setAttrVal("Id_rspat", Id_rspat);
	}
	/**
	 * 集团id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 集团id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	 * 患者code
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}
	/**
	 * 患者code
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 患者name
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者name
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 出生日期
	 * @return FDateTime
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
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 入院科室id
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室id
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院科室code
	 * @return String
	 */
	public String getSd_dep_phyadm() {
		return ((String) getAttrVal("Sd_dep_phyadm"));
	}
	/**
	 * 入院科室code
	 * @param Sd_dep_phyadm
	 */
	public void setSd_dep_phyadm(String Sd_dep_phyadm) {
		setAttrVal("Sd_dep_phyadm", Sd_dep_phyadm);
	}
	/**
	 * 入院科室name
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室name
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 出院科室id
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}
	/**
	 * 出院科室id
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 出院科室code
	 * @return String
	 */
	public String getSd_dep_phydisc() {
		return ((String) getAttrVal("Sd_dep_phydisc"));
	}
	/**
	 * 出院科室code
	 * @param Sd_dep_phydisc
	 */
	public void setSd_dep_phydisc(String Sd_dep_phydisc) {
		setAttrVal("Sd_dep_phydisc", Sd_dep_phydisc);
	}
	/**
	 * 出院科室name
	 * @return String
	 */
	public String getName_dep_phydisc() {
		return ((String) getAttrVal("Name_dep_phydisc"));
	}
	/**
	 * 出院科室name
	 * @param Name_dep_phydisc
	 */
	public void setName_dep_phydisc(String Name_dep_phydisc) {
		setAttrVal("Name_dep_phydisc", Name_dep_phydisc);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getDays_inhos() {
		return ((Integer) getAttrVal("Days_inhos"));
	}
	/**
	 * 住院天数
	 * @param Days_inhos
	 */
	public void setDays_inhos(Integer Days_inhos) {
		setAttrVal("Days_inhos", Days_inhos);
	}
	/**
	 * 第几次入院
	 * @return Integer
	 */
	public Integer getTimes_inhos() {
		return ((Integer) getAttrVal("Times_inhos"));
	}
	/**
	 * 第几次入院
	 * @param Times_inhos
	 */
	public void setTimes_inhos(Integer Times_inhos) {
		setAttrVal("Times_inhos", Times_inhos);
	}
	/**
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别code
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别code
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别name
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别name
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 是否完成书写
	 * @return String
	 */
	public String getFg_complete() {
		return ((String) getAttrVal("Fg_complete"));
	}
	/**
	 * 是否完成书写
	 * @param Fg_complete
	 */
	public void setFg_complete(String Fg_complete) {
		setAttrVal("Fg_complete", Fg_complete);
	}
	/**
	 * 推送开始日期
	 * @return FDate
	 */
	public FDate getDate_start() {
		return ((FDate) getAttrVal("Date_start"));
	}
	/**
	 * 推送开始日期
	 * @param Date_start
	 */
	public void setDate_start(FDate Date_start) {
		setAttrVal("Date_start", Date_start);
	}
	/**
	 * 推送结束日期 
	 * @return FDate
	 */
	public FDate getDate_end() {
		return ((FDate) getAttrVal("Date_end"));
	}
	/**
	 * 推送结束日期 
	 * @param Date_end
	 */
	public void setDate_end(FDate Date_end) {
		setAttrVal("Date_end", Date_end);
	}
	/**
	 * 病案首页-患者表主键
	 * @return String
	 */
	public String getId_cimrfppat() {
		return ((String) getAttrVal("Id_cimrfppat"));
	}
	/**
	 * 病案首页-患者表主键
	 * @param Id_cimrfppat
	 */
	public void setId_cimrfppat(String Id_cimrfppat) {
		setAttrVal("Id_cimrfppat", Id_cimrfppat);
	}
}