package iih.nm.nhr.dto.weeksched.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班行数据 DTO数据 
 * 
 */
public class SchedRowDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 护士id
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}
	/**
	 * 护士id
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 护士名称
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 护士名称
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 护理等级id
	 * @return String
	 */
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}
	/**
	 * 护理等级id
	 * @param Id_nur_lvl
	 */
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	/**
	 * 护理等级编码
	 * @return String
	 */
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}
	/**
	 * 护理等级编码
	 * @param Sd_nur_lvl
	 */
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	/**
	 * 护理等级
	 * @return String
	 */
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}
	/**
	 * 护理等级
	 * @param Name_nur_lvl
	 */
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 排班分组id
	 * @return String
	 */
	public String getId_nhr_sigrp() {
		return ((String) getAttrVal("Id_nhr_sigrp"));
	}
	/**
	 * 排班分组id
	 * @param Id_nhr_sigrp
	 */
	public void setId_nhr_sigrp(String Id_nhr_sigrp) {
		setAttrVal("Id_nhr_sigrp", Id_nhr_sigrp);
	}
	/**
	 * 组内角色id
	 * @return String
	 */
	public String getId_rule_grp() {
		return ((String) getAttrVal("Id_rule_grp"));
	}
	/**
	 * 组内角色id
	 * @param Id_rule_grp
	 */
	public void setId_rule_grp(String Id_rule_grp) {
		setAttrVal("Id_rule_grp", Id_rule_grp);
	}
	/**
	 * 组内角色编码
	 * @return String
	 */
	public String getSd_rule_grp() {
		return ((String) getAttrVal("Sd_rule_grp"));
	}
	/**
	 * 组内角色编码
	 * @param Sd_rule_grp
	 */
	public void setSd_rule_grp(String Sd_rule_grp) {
		setAttrVal("Sd_rule_grp", Sd_rule_grp);
	}
	/**
	 * 组内角色
	 * @return String
	 */
	public String getName_rule_grp() {
		return ((String) getAttrVal("Name_rule_grp"));
	}
	/**
	 * 组内角色
	 * @param Name_rule_grp
	 */
	public void setName_rule_grp(String Name_rule_grp) {
		setAttrVal("Name_rule_grp", Name_rule_grp);
	}
	/**
	 * 周工时
	 * @return FDouble
	 */
	public FDouble getWeek_labor() {
		return ((FDouble) getAttrVal("Week_labor"));
	}
	/**
	 * 周工时
	 * @param Week_labor
	 */
	public void setWeek_labor(FDouble Week_labor) {
		setAttrVal("Week_labor", Week_labor);
	}
	/**
	 * 上周累计工时
	 * @return FDouble
	 */
	public FDouble getOwe_labor_lastweek() {
		return ((FDouble) getAttrVal("Owe_labor_lastweek"));
	}
	/**
	 * 上周累计工时
	 * @param Owe_labor_lastweek
	 */
	public void setOwe_labor_lastweek(FDouble Owe_labor_lastweek) {
		setAttrVal("Owe_labor_lastweek", Owe_labor_lastweek);
	}
	/**
	 * 年假
	 * @return FDouble
	 */
	public FDouble getAnnual_day() {
		return ((FDouble) getAttrVal("Annual_day"));
	}
	/**
	 * 年假
	 * @param Annual_day
	 */
	public void setAnnual_day(FDouble Annual_day) {
		setAttrVal("Annual_day", Annual_day);
	}
	/**
	 * 累计工时
	 * @return FDouble
	 */
	public FDouble getOwe_labor() {
		return ((FDouble) getAttrVal("Owe_labor"));
	}
	/**
	 * 累计工时
	 * @param Owe_labor
	 */
	public void setOwe_labor(FDouble Owe_labor) {
		setAttrVal("Owe_labor", Owe_labor);
	}
	/**
	 * 本周计假
	 * @return FDouble
	 */
	public FDouble getVacate_week() {
		return ((FDouble) getAttrVal("Vacate_week"));
	}
	/**
	 * 本周计假
	 * @param Vacate_week
	 */
	public void setVacate_week(FDouble Vacate_week) {
		setAttrVal("Vacate_week", Vacate_week);
	}
	/**
	 * 排班班次集合
	 * @return FArrayList
	 */
	public FArrayList getSchedcelllist() {
		return ((FArrayList) getAttrVal("Schedcelllist"));
	}
	/**
	 * 排班班次集合
	 * @param Schedcelllist
	 */
	public void setSchedcelllist(FArrayList Schedcelllist) {
		setAttrVal("Schedcelllist", Schedcelllist);
	}
}