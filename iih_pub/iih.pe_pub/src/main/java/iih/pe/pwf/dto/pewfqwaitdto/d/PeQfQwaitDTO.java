package iih.pe.pwf.dto.pewfqwaitdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检分检等候队列 DTO数据 
 * 
 */
public class PeQfQwaitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检流程诊间ID
	 * @return String
	 */
	public String getId_pewfroom() {
		return ((String) getAttrVal("Id_pewfroom"));
	}
	/**
	 * 体检流程诊间ID
	 * @param Id_pewfroom
	 */
	public void setId_pewfroom(String Id_pewfroom) {
		setAttrVal("Id_pewfroom", Id_pewfroom);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检科室ID
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}
	/**
	 * 体检科室ID
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检诊间ID
	 * @return String
	 */
	public String getId_pediroom() {
		return ((String) getAttrVal("Id_pediroom"));
	}
	/**
	 * 体检诊间ID
	 * @param Id_pediroom
	 */
	public void setId_pediroom(String Id_pediroom) {
		setAttrVal("Id_pediroom", Id_pediroom);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检日期
	 * @return FDate
	 */
	public FDate getDt_peroom() {
		return ((FDate) getAttrVal("Dt_peroom"));
	}
	/**
	 * 体检日期
	 * @param Dt_peroom
	 */
	public void setDt_peroom(FDate Dt_peroom) {
		setAttrVal("Dt_peroom", Dt_peroom);
	}
	/**
	 * 排入等候时间
	 * @return FDateTime
	 */
	public FDateTime getDt_wait() {
		return ((FDateTime) getAttrVal("Dt_wait"));
	}
	/**
	 * 排入等候时间
	 * @param Dt_wait
	 */
	public void setDt_wait(FDateTime Dt_wait) {
		setAttrVal("Dt_wait", Dt_wait);
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
	 * 体检流程卡
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}
	/**
	 * 体检流程卡
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
	 * 交费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_paid() {
		return ((FBoolean) getAttrVal("Fg_paid"));
	}
	/**
	 * 交费标识
	 * @param Fg_paid
	 */
	public void setFg_paid(FBoolean Fg_paid) {
		setAttrVal("Fg_paid", Fg_paid);
	}
	/**
	 * 后付费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nopay() {
		return ((FBoolean) getAttrVal("Fg_nopay"));
	}
	/**
	 * 后付费标识
	 * @param Fg_nopay
	 */
	public void setFg_nopay(FBoolean Fg_nopay) {
		setAttrVal("Fg_nopay", Fg_nopay);
	}
	/**
	 * 客户编号
	 * @return String
	 */
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}
	/**
	 * 客户编号
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	/**
	 * 主索引ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 主索引ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
}