package iih.ci.ord.ip.dto.ems.uiemsdto;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 西药医疗单主 DTO数据 
 * 
 */
public class EmsDrugsViewDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 用法ID
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法ID
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法过滤条件
	 * @return String
	 */
	public String getFilter_route() {
		return ((String) getAttrVal("Filter_route"));
	}
	/**
	 * 用法过滤条件
	 * @param Filter_route
	 */
	public void setFilter_route(String Filter_route) {
		setAttrVal("Filter_route", Filter_route);
	}
	/**
	 * 用法要求ID
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求ID
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 频次ID
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 频次ID
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 频次数量
	 * @return String
	 */
	public String getFreqct() {
		return ((String) getAttrVal("Freqct"));
	}
	/**
	 * 频次数量
	 * @param Freqct
	 */
	public void setFreqct(String Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 频次周期类型SD
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}
	/**
	 * 频次周期类型SD
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 备用医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pmor() {
		return ((FBoolean) getAttrVal("Fg_pmor"));
	}
	/**
	 * 备用医嘱标识
	 * @param Fg_pmor
	 */
	public void setFg_pmor(FBoolean Fg_pmor) {
		setAttrVal("Fg_pmor", Fg_pmor);
	}
	/**
	 * 备用医嘱使用条件描述
	 * @return String
	 */
	public String getDes_pmor() {
		return ((String) getAttrVal("Des_pmor"));
	}
	/**
	 * 备用医嘱使用条件描述
	 * @param Des_pmor
	 */
	public void setDes_pmor(String Des_pmor) {
		setAttrVal("Des_pmor", Des_pmor);
	}
	/**
	 * 备用医嘱启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active_pm() {
		return ((FBoolean) getAttrVal("Fg_active_pm"));
	}
	/**
	 * 备用医嘱启用标识
	 * @param Fg_active_pm
	 */
	public void setFg_active_pm(FBoolean Fg_active_pm) {
		setAttrVal("Fg_active_pm", Fg_active_pm);
	}
	/**
	 * 失效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}
	/**
	 * 失效时间
	 * @param Dt_invalid
	 */
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	/**
	 * 开始日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 开始日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 天数
	 * @return String
	 */
	public String getUsedays() {
		return ((String) getAttrVal("Usedays"));
	}
	/**
	 * 天数
	 * @param Usedays
	 */
	public void setUsedays(String Usedays) {
		setAttrVal("Usedays", Usedays);
	}
	/**
	 * 首日执行次数
	 * @return Integer
	 */
	public Integer getQuan_firday_mp() {
		return ((Integer) getAttrVal("Quan_firday_mp"));
	}
	/**
	 * 首日执行次数
	 * @param Quan_firday_mp
	 */
	public void setQuan_firday_mp(Integer Quan_firday_mp) {
		setAttrVal("Quan_firday_mp", Quan_firday_mp);
	}
	/**
	 * 首日执行时间
	 * @return String
	 */
	public String getWork_time() {
		return ((String) getAttrVal("Work_time"));
	}
	/**
	 * 首日执行时间
	 * @param Work_time
	 */
	public void setWork_time(String Work_time) {
		setAttrVal("Work_time", Work_time);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 西药药品
	 * @return FArrayList
	 */
	public FArrayList getEmsdrugsviewitems() {
		return ((FArrayList) getAttrVal("Emsdrugsviewitems"));
	}
	/**
	 * 西药药品
	 * @param Emsdrugsviewitems
	 */
	public void setEmsdrugsviewitems(FArrayList Emsdrugsviewitems) {
		setAttrVal("Emsdrugsviewitems", Emsdrugsviewitems);
	}
}