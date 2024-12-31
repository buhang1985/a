package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 团检患者信息 DTO数据 
 * 
 */
public class EnPePatInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 团检记录ID
	 * @return String
	 */
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}
	/**
	 * 团检记录ID
	 * @param Id_pecmpy
	 */
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院档案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院档案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	 * 患者性别
	 * @return String
	 */
	public String getName_sex_pat() {
		return ((String) getAttrVal("Name_sex_pat"));
	}
	/**
	 * 患者性别
	 * @param Name_sex_pat
	 */
	public void setName_sex_pat(String Name_sex_pat) {
		setAttrVal("Name_sex_pat", Name_sex_pat);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}
	/**
	 * 患者年龄
	 * @param Age_pat
	 */
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	/**
	 * 体检次数
	 * @return String
	 */
	public String getTimes_pe() {
		return ((String) getAttrVal("Times_pe"));
	}
	/**
	 * 体检次数
	 * @param Times_pe
	 */
	public void setTimes_pe(String Times_pe) {
		setAttrVal("Times_pe", Times_pe);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 入院时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getName_dep_nuradm() {
		return ((String) getAttrVal("Name_dep_nuradm"));
	}
	/**
	 * 入院病区
	 * @param Name_dep_nuradm
	 */
	public void setName_dep_nuradm(String Name_dep_nuradm) {
		setAttrVal("Name_dep_nuradm", Name_dep_nuradm);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 就诊状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 结算标志
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 患者出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 患者出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 退诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc_ent() {
		return ((FBoolean) getAttrVal("Fg_canc_ent"));
	}
	/**
	 * 退诊标志
	 * @param Fg_canc_ent
	 */
	public void setFg_canc_ent(FBoolean Fg_canc_ent) {
		setAttrVal("Fg_canc_ent", Fg_canc_ent);
	}
}