package iih.pe.papt.dto.pehminfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 健康管理个人基本资料 DTO数据 
 * 
 */
public class PeHmInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检客户主键标识
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}
	/**
	 * 体检客户主键标识
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 性别标识
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别标识
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 婚姻标识
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}
	/**
	 * 婚姻标识
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
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
	 * @return Integer
	 */
	public Integer getAge() {
		return ((Integer) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(Integer Age) {
		setAttrVal("Age", Age);
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
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex_psn() {
		return ((String) getAttrVal("Sd_sex_psn"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex_psn
	 */
	public void setSd_sex_psn(String Sd_sex_psn) {
		setAttrVal("Sd_sex_psn", Sd_sex_psn);
	}
	/**
	 * 婚否
	 * @return String
	 */
	public String getMarried() {
		return ((String) getAttrVal("Married"));
	}
	/**
	 * 婚否
	 * @param Married
	 */
	public void setMarried(String Married) {
		setAttrVal("Married", Married);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getMobi() {
		return ((String) getAttrVal("Mobi"));
	}
	/**
	 * 电话
	 * @param Mobi
	 */
	public void setMobi(String Mobi) {
		setAttrVal("Mobi", Mobi);
	}
	/**
	 * 身份证号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}
	/**
	 * 身份证号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	/**
	 * 照片
	 * @return byte[]
	 */
	public byte[] getPho() {
		return ((byte[]) getAttrVal("Pho"));
	}
	/**
	 * 照片
	 * @param Pho
	 */
	public void setPho(byte[] Pho) {
		setAttrVal("Pho", Pho);
	}
	/**
	 * 预约日期
	 * @return FDate
	 */
	public FDate getDt_appt() {
		return ((FDate) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDate Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约号
	 * @return Integer
	 */
	public Integer getNo_appt() {
		return ((Integer) getAttrVal("No_appt"));
	}
	/**
	 * 预约号
	 * @param No_appt
	 */
	public void setNo_appt(Integer No_appt) {
		setAttrVal("No_appt", No_appt);
	}
	/**
	 * 健康管理状态
	 * @return Integer
	 */
	public Integer getHmstatus() {
		return ((Integer) getAttrVal("Hmstatus"));
	}
	/**
	 * 健康管理状态
	 * @param Hmstatus
	 */
	public void setHmstatus(Integer Hmstatus) {
		setAttrVal("Hmstatus", Hmstatus);
	}
	/**
	 * 健康预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}
	/**
	 * 健康预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 期望寿命
	 * @return Integer
	 */
	public Integer getLifeexpectancy() {
		return ((Integer) getAttrVal("Lifeexpectancy"));
	}
	/**
	 * 期望寿命
	 * @param Lifeexpectancy
	 */
	public void setLifeexpectancy(Integer Lifeexpectancy) {
		setAttrVal("Lifeexpectancy", Lifeexpectancy);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getBloodtype() {
		return ((String) getAttrVal("Bloodtype"));
	}
	/**
	 * 血型
	 * @param Bloodtype
	 */
	public void setBloodtype(String Bloodtype) {
		setAttrVal("Bloodtype", Bloodtype);
	}
}