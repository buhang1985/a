package iih.pe.pwf.dto.pereglistdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检报到名单 DTO数据 
 * 
 */
public class PeRegListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检预约单主键标识
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单主键标识
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检客户主键
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}
	/**
	 * 体检客户主键
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检套餐ID
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}
	/**
	 * 体检套餐ID
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 会员卡ID
	 * @return String
	 */
	public String getId_pepsncard() {
		return ((String) getAttrVal("Id_pepsncard"));
	}
	/**
	 * 会员卡ID
	 * @param Id_pepsncard
	 */
	public void setId_pepsncard(String Id_pepsncard) {
		setAttrVal("Id_pepsncard", Id_pepsncard);
	}
	/**
	 * 会员卡
	 * @return String
	 */
	public String getNo_card() {
		return ((String) getAttrVal("No_card"));
	}
	/**
	 * 会员卡
	 * @param No_card
	 */
	public void setNo_card(String No_card) {
		setAttrVal("No_card", No_card);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 体检状态
	 * @return Integer
	 */
	public Integer getPestatus() {
		return ((Integer) getAttrVal("Pestatus"));
	}
	/**
	 * 体检状态
	 * @param Pestatus
	 */
	public void setPestatus(Integer Pestatus) {
		setAttrVal("Pestatus", Pestatus);
	}
	/**
	 * 体检流程号
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}
	/**
	 * 体检流程号
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	/**
	 * 客户姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}
	/**
	 * 客户姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	/**
	 * 客户性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 客户性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
	 * 体检套餐名称
	 * @return String
	 */
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}
	/**
	 * 体检套餐名称
	 * @param Name_set
	 */
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
	}
	/**
	 * 团体名称
	 * @return String
	 */
	public String getName_corp() {
		return ((String) getAttrVal("Name_corp"));
	}
	/**
	 * 团体名称
	 * @param Name_corp
	 */
	public void setName_corp(String Name_corp) {
		setAttrVal("Name_corp", Name_corp);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 体检次数
	 * @return Integer
	 */
	public Integer getPe_times() {
		return ((Integer) getAttrVal("Pe_times"));
	}
	/**
	 * 体检次数
	 * @param Pe_times
	 */
	public void setPe_times(Integer Pe_times) {
		setAttrVal("Pe_times", Pe_times);
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
	 * 证件号码
	 * @return String
	 */
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}
	/**
	 * 证件号码
	 * @param Idcode
	 */
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
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
	 * 预约体检日期
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}
	/**
	 * 预约体检日期
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 体检登记日期
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}
	/**
	 * 体检登记日期
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_paid() {
		return ((FBoolean) getAttrVal("Fg_paid"));
	}
	/**
	 * 收费标识
	 * @param Fg_paid
	 */
	public void setFg_paid(FBoolean Fg_paid) {
		setAttrVal("Fg_paid", Fg_paid);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 后付费体检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nopay() {
		return ((FBoolean) getAttrVal("Fg_nopay"));
	}
	/**
	 * 后付费体检标识
	 * @param Fg_nopay
	 */
	public void setFg_nopay(FBoolean Fg_nopay) {
		setAttrVal("Fg_nopay", Fg_nopay);
	}
	/**
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 客户编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
}