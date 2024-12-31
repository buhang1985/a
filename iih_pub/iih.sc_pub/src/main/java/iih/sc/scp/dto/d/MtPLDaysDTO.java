package iih.sc.scp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 复制周计划天数DTO DTO数据 
 * 
 */
public class MtPLDaysDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 周计划id
	 * @return String
	 */
	public String getId_scplweek() {
		return ((String) getAttrVal("Id_scplweek"));
	}
	/**
	 * 周计划id
	 * @param Id_scplweek
	 */
	public void setId_scplweek(String Id_scplweek) {
		setAttrVal("Id_scplweek", Id_scplweek);
	}
	/**
	 * 星期一
	 * @return FBoolean
	 */
	public FBoolean getFg_mon() {
		return ((FBoolean) getAttrVal("Fg_mon"));
	}
	/**
	 * 星期一
	 * @param Fg_mon
	 */
	public void setFg_mon(FBoolean Fg_mon) {
		setAttrVal("Fg_mon", Fg_mon);
	}
	/**
	 * 星期二
	 * @return FBoolean
	 */
	public FBoolean getFg_tue() {
		return ((FBoolean) getAttrVal("Fg_tue"));
	}
	/**
	 * 星期二
	 * @param Fg_tue
	 */
	public void setFg_tue(FBoolean Fg_tue) {
		setAttrVal("Fg_tue", Fg_tue);
	}
	/**
	 * 星期三
	 * @return FBoolean
	 */
	public FBoolean getFg_wed() {
		return ((FBoolean) getAttrVal("Fg_wed"));
	}
	/**
	 * 星期三
	 * @param Fg_wed
	 */
	public void setFg_wed(FBoolean Fg_wed) {
		setAttrVal("Fg_wed", Fg_wed);
	}
	/**
	 * 星期四
	 * @return FBoolean
	 */
	public FBoolean getFg_thu() {
		return ((FBoolean) getAttrVal("Fg_thu"));
	}
	/**
	 * 星期四
	 * @param Fg_thu
	 */
	public void setFg_thu(FBoolean Fg_thu) {
		setAttrVal("Fg_thu", Fg_thu);
	}
	/**
	 * 星期五
	 * @return FBoolean
	 */
	public FBoolean getFg_fri() {
		return ((FBoolean) getAttrVal("Fg_fri"));
	}
	/**
	 * 星期五
	 * @param Fg_fri
	 */
	public void setFg_fri(FBoolean Fg_fri) {
		setAttrVal("Fg_fri", Fg_fri);
	}
	/**
	 * 星期六
	 * @return FBoolean
	 */
	public FBoolean getFg_sat() {
		return ((FBoolean) getAttrVal("Fg_sat"));
	}
	/**
	 * 星期六
	 * @param Fg_sat
	 */
	public void setFg_sat(FBoolean Fg_sat) {
		setAttrVal("Fg_sat", Fg_sat);
	}
	/**
	 * 星期天
	 * @return FBoolean
	 */
	public FBoolean getFg_sun() {
		return ((FBoolean) getAttrVal("Fg_sun"));
	}
	/**
	 * 星期天
	 * @param Fg_sun
	 */
	public void setFg_sun(FBoolean Fg_sun) {
		setAttrVal("Fg_sun", Fg_sun);
	}
	/**
	 * 周模板
	 * @return Integer
	 */
	public Integer getIdx_week() {
		return ((Integer) getAttrVal("Idx_week"));
	}
	/**
	 * 周模板
	 * @param Idx_week
	 */
	public void setIdx_week(Integer Idx_week) {
		setAttrVal("Idx_week", Idx_week);
	}
	/**
	 * 全选
	 * @return FBoolean
	 */
	public FBoolean getFg_all() {
		return ((FBoolean) getAttrVal("Fg_all"));
	}
	/**
	 * 全选
	 * @param Fg_all
	 */
	public void setFg_all(FBoolean Fg_all) {
		setAttrVal("Fg_all", Fg_all);
	}
	/**
	 * 模板
	 * @return String
	 */
	public String getName_week() {
		return ((String) getAttrVal("Name_week"));
	}
	/**
	 * 模板
	 * @param Name_week
	 */
	public void setName_week(String Name_week) {
		setAttrVal("Name_week", Name_week);
	}
	/**
	 * 日期分组ID
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期分组ID
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 计划ID
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 计划ID
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
}