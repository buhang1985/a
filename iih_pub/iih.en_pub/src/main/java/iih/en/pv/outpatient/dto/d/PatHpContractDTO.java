package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者与医保对照DTO DTO数据 
 * 
 */
public class PatHpContractDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 患者性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
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
	 * 患者证件类型编码
	 * @return String
	 */
	public String getSd_idtp_pat() {
		return ((String) getAttrVal("Sd_idtp_pat"));
	}
	/**
	 * 患者证件类型编码
	 * @param Sd_idtp_pat
	 */
	public void setSd_idtp_pat(String Sd_idtp_pat) {
		setAttrVal("Sd_idtp_pat", Sd_idtp_pat);
	}
	/**
	 * 患者证件类型
	 * @return String
	 */
	public String getName_idtp_pat() {
		return ((String) getAttrVal("Name_idtp_pat"));
	}
	/**
	 * 患者证件类型
	 * @param Name_idtp_pat
	 */
	public void setName_idtp_pat(String Name_idtp_pat) {
		setAttrVal("Name_idtp_pat", Name_idtp_pat);
	}
	/**
	 * 患者证件号码
	 * @return String
	 */
	public String getCode_id_pat() {
		return ((String) getAttrVal("Code_id_pat"));
	}
	/**
	 * 患者证件号码
	 * @param Code_id_pat
	 */
	public void setCode_id_pat(String Code_id_pat) {
		setAttrVal("Code_id_pat", Code_id_pat);
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
	 * 患者医保卡号
	 * @return String
	 */
	public String getNo_hp_pat() {
		return ((String) getAttrVal("No_hp_pat"));
	}
	/**
	 * 患者医保卡号
	 * @param No_hp_pat
	 */
	public void setNo_hp_pat(String No_hp_pat) {
		setAttrVal("No_hp_pat", No_hp_pat);
	}
	/**
	 * 卡患者姓名
	 * @return String
	 */
	public String getName_hppat() {
		return ((String) getAttrVal("Name_hppat"));
	}
	/**
	 * 卡患者姓名
	 * @param Name_hppat
	 */
	public void setName_hppat(String Name_hppat) {
		setAttrVal("Name_hppat", Name_hppat);
	}
	/**
	 * 卡患者性别编码
	 * @return String
	 */
	public String getSd_sex_hppat() {
		return ((String) getAttrVal("Sd_sex_hppat"));
	}
	/**
	 * 卡患者性别编码
	 * @param Sd_sex_hppat
	 */
	public void setSd_sex_hppat(String Sd_sex_hppat) {
		setAttrVal("Sd_sex_hppat", Sd_sex_hppat);
	}
	/**
	 * 卡患者性别
	 * @return String
	 */
	public String getName_sex_hppat() {
		return ((String) getAttrVal("Name_sex_hppat"));
	}
	/**
	 * 卡患者性别
	 * @param Name_sex_hppat
	 */
	public void setName_sex_hppat(String Name_sex_hppat) {
		setAttrVal("Name_sex_hppat", Name_sex_hppat);
	}
	/**
	 * 卡患者证件类型编码
	 * @return String
	 */
	public String getSd_idtp_hppat() {
		return ((String) getAttrVal("Sd_idtp_hppat"));
	}
	/**
	 * 卡患者证件类型编码
	 * @param Sd_idtp_hppat
	 */
	public void setSd_idtp_hppat(String Sd_idtp_hppat) {
		setAttrVal("Sd_idtp_hppat", Sd_idtp_hppat);
	}
	/**
	 * 卡患者证件类型
	 * @return String
	 */
	public String getName_idtp_hppat() {
		return ((String) getAttrVal("Name_idtp_hppat"));
	}
	/**
	 * 卡患者证件类型
	 * @param Name_idtp_hppat
	 */
	public void setName_idtp_hppat(String Name_idtp_hppat) {
		setAttrVal("Name_idtp_hppat", Name_idtp_hppat);
	}
	/**
	 * 卡患者证件号码
	 * @return String
	 */
	public String getCode_id_hppat() {
		return ((String) getAttrVal("Code_id_hppat"));
	}
	/**
	 * 卡患者证件号码
	 * @param Code_id_hppat
	 */
	public void setCode_id_hppat(String Code_id_hppat) {
		setAttrVal("Code_id_hppat", Code_id_hppat);
	}
	/**
	 * 卡患者出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_hppat() {
		return ((FDate) getAttrVal("Dt_birth_hppat"));
	}
	/**
	 * 卡患者出生日期
	 * @param Dt_birth_hppat
	 */
	public void setDt_birth_hppat(FDate Dt_birth_hppat) {
		setAttrVal("Dt_birth_hppat", Dt_birth_hppat);
	}
	/**
	 * 卡患者医保卡号
	 * @return String
	 */
	public String getNo_hp_hppat() {
		return ((String) getAttrVal("No_hp_hppat"));
	}
	/**
	 * 卡患者医保卡号
	 * @param No_hp_hppat
	 */
	public void setNo_hp_hppat(String No_hp_hppat) {
		setAttrVal("No_hp_hppat", No_hp_hppat);
	}
}