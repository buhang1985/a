package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.dto.ems.uiemsdto.b.BaseEmsViewDTO;

import java.math.BigDecimal;

/**
 * 草药医疗单主 DTO数据 
 * 
 */
public class EmsHerbsViewDTO extends BaseEmsViewDTO {
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
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 处置项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 处置项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次数量
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
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
	 * 处置周期
	 * @return Integer
	 */
	public Integer getUsedays() {
		return ((Integer) getAttrVal("Usedays"));
	}
	/**
	 * 处置周期
	 * @param Usedays
	 */
	public void setUsedays(Integer Usedays) {
		setAttrVal("Usedays", Usedays);
	}
	/**
	 * 在院执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_times_in() {
		return ((FBoolean) getAttrVal("Fg_times_in"));
	}
	/**
	 * 在院执行标识
	 * @param Fg_times_in
	 */
	public void setFg_times_in(FBoolean Fg_times_in) {
		setAttrVal("Fg_times_in", Fg_times_in);
	}
	/**
	 * 在院执行次数
	 * @return String
	 */
	public Integer getTimes_in() {
		return ((Integer) getAttrVal("Times_in"));
	}
	/**
	 * 在院执行次数
	 * @param integer
	 */
	public void setTimes_in(Integer integer) {
		setAttrVal("Times_in", integer);
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
	 * 煎法ID
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法ID
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 煎法过滤条件
	 * @return String
	 */
	public String getFilter_boil() {
		return ((String) getAttrVal("Filter_boil"));
	}
	/**
	 * 煎法过滤条件
	 * @param Filter_boil
	 */
	public void setFilter_boil(String Filter_boil) {
		setAttrVal("Filter_boil", Filter_boil);
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
	 * 代加工
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}
	/**
	 * 代加工
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 外配药
	 * @return FBoolean
	 */
	public FBoolean getFg_extdispense() {
		return ((FBoolean) getAttrVal("Fg_extdispense"));
	}
	/**
	 * 外配药
	 * @param Fg_extdispense
	 */
	public void setFg_extdispense(FBoolean Fg_extdispense) {
		setAttrVal("Fg_extdispense", Fg_extdispense);
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
	 * sv
	 * @return String
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * sv
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 次数
	 * @return String
	 */
	public Integer getTimes_cur() {
		return ((Integer) getAttrVal("Times_cur"));
	}
	/**
	 * 次数
	 * @param Times_cur
	 */
	public void setTimes_cur(Integer Times_cur) {
		setAttrVal("Times_cur", Times_cur);
	}
	/**
	 * 领量
	 * @return String
	 */
	public String getAvailabledays() {
		return ((String) getAttrVal("Availabledays"));
	}
	/**
	 * 领量
	 * @param Availabledays
	 */
	public void setAvailabledays(String Availabledays) {
		setAttrVal("Availabledays", Availabledays);
	}
	/**
	 * 草药药品
	 * @return FArrayList
	 */
	public FArrayList getEmsherbsviewitems() {
		return ((FArrayList) getAttrVal("Emsherbsviewitems"));
	}
	/**
	 * 草药药品
	 * @param Emsherbsviewitems
	 */
	public void setEmsherbsviewitems(FArrayList Emsherbsviewitems) {
		setAttrVal("Emsherbsviewitems", Emsherbsviewitems);
	}
	/**
	 * 付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
}