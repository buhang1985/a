package iih.ei.std.d.v1.hr.depscheddata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班数据 DTO数据 
 * 
 */
public class SchedDataInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班Id
	 * @return String
	 */
	public String getId_hsc_sched() {
		return ((String) getAttrVal("Id_hsc_sched"));
	}	
	/**
	 * 排班Id
	 * @param Id_hsc_sched
	 */
	public void setId_hsc_sched(String Id_hsc_sched) {
		setAttrVal("Id_hsc_sched", Id_hsc_sched);
	}
	/**
	 * 组织Id
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织Id
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团Id
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团Id
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 周排班Id
	 * @return String
	 */
	public String getId_hsc_sched_week() {
		return ((String) getAttrVal("Id_hsc_sched_week"));
	}	
	/**
	 * 周排班Id
	 * @param Id_hsc_sched_week
	 */
	public void setId_hsc_sched_week(String Id_hsc_sched_week) {
		setAttrVal("Id_hsc_sched_week", Id_hsc_sched_week);
	}
	/**
	 * 科室Id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室Id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 排班日期
	 * @return String
	 */
	public String getDt_sched_date() {
		return ((String) getAttrVal("Dt_sched_date"));
	}	
	/**
	 * 排班日期
	 * @param Dt_sched_date
	 */
	public void setDt_sched_date(String Dt_sched_date) {
		setAttrVal("Dt_sched_date", Dt_sched_date);
	}
	/**
	 * 人员Id
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员Id
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	/**
	 * 人员名称
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 班次Id
	 * @return String
	 */
	public String getId_hsc_si() {
		return ((String) getAttrVal("Id_hsc_si"));
	}	
	/**
	 * 班次Id
	 * @param Id_hsc_si
	 */
	public void setId_hsc_si(String Id_hsc_si) {
		setAttrVal("Id_hsc_si", Id_hsc_si);
	}
	/**
	 * 班次名称
	 * @return String
	 */
	public String getName_hsc_si() {
		return ((String) getAttrVal("Name_hsc_si"));
	}	
	/**
	 * 班次名称
	 * @param Name_hsc_si
	 */
	public void setName_hsc_si(String Name_hsc_si) {
		setAttrVal("Name_hsc_si", Name_hsc_si);
	}
	/**
	 * 班次简称
	 * @return String
	 */
	public String getShortname_hsc_si() {
		return ((String) getAttrVal("Shortname_hsc_si"));
	}	
	/**
	 * 班次简称
	 * @param Shortname_hsc_si
	 */
	public void setShortname_hsc_si(String Shortname_hsc_si) {
		setAttrVal("Shortname_hsc_si", Shortname_hsc_si);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno_day() {
		return ((Integer) getAttrVal("Sortno_day"));
	}	
	/**
	 * 序号
	 * @param Sortno_day
	 */
	public void setSortno_day(Integer Sortno_day) {
		setAttrVal("Sortno_day", Sortno_day);
	}
	/**
	 * 加班标志
	 * @return FBoolean
	 */
	public FBoolean getFg_overtime() {
		return ((FBoolean) getAttrVal("Fg_overtime"));
	}	
	/**
	 * 加班标志
	 * @param Fg_overtime
	 */
	public void setFg_overtime(FBoolean Fg_overtime) {
		setAttrVal("Fg_overtime", Fg_overtime);
	}
}