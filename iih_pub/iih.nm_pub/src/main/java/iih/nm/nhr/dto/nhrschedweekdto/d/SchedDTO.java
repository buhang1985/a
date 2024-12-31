package iih.nm.nhr.dto.nhrschedweekdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班人员dto DTO数据 
 * 
 */
public class SchedDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 人员排班主键
	 * @return String
	 */
	public String getId_nhr_sched() {
		return ((String) getAttrVal("Id_nhr_sched"));
	}
	/**
	 * 人员排班主键
	 * @param Id_nhr_sched
	 */
	public void setId_nhr_sched(String Id_nhr_sched) {
		setAttrVal("Id_nhr_sched", Id_nhr_sched);
	}
	/**
	 * 周排班外键
	 * @return String
	 */
	public String getId_nhr_sched_week() {
		return ((String) getAttrVal("Id_nhr_sched_week"));
	}
	/**
	 * 周排班外键
	 * @param Id_nhr_sched_week
	 */
	public void setId_nhr_sched_week(String Id_nhr_sched_week) {
		setAttrVal("Id_nhr_sched_week", Id_nhr_sched_week);
	}
	/**
	 * 护理单元外键
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理单元外键
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getDt_sched_date() {
		return ((FDate) getAttrVal("Dt_sched_date"));
	}
	/**
	 * 排班日期
	 * @param Dt_sched_date
	 */
	public void setDt_sched_date(FDate Dt_sched_date) {
		setAttrVal("Dt_sched_date", Dt_sched_date);
	}
	/**
	 * 护士层级
	 * @return String
	 */
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}
	/**
	 * 护士层级
	 * @param Sd_nur_lvl
	 */
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	/**
	 * 排班人
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 排班人
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 排班人姓名
	 * @return String
	 */
	public String getNur_name() {
		return ((String) getAttrVal("Nur_name"));
	}
	/**
	 * 排班人姓名
	 * @param Nur_name
	 */
	public void setNur_name(String Nur_name) {
		setAttrVal("Nur_name", Nur_name);
	}
	/**
	 * 人员明细列表
	 * @return FArrayList
	 */
	public FArrayList getItmlist() {
		return ((FArrayList) getAttrVal("Itmlist"));
	}
	/**
	 * 人员明细列表
	 * @param Itmlist
	 */
	public void setItmlist(FArrayList Itmlist) {
		setAttrVal("Itmlist", Itmlist);
	}
	/**
	 * 版本
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
}