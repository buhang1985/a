package iih.nm.nhr.dto.nhrschedweekdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 周信息 DTO数据 
 * 
 */
public class SchedWeekDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班周主键
	 * @return String
	 */
	public String getId_nhr_sched_week() {
		return ((String) getAttrVal("Id_nhr_sched_week"));
	}
	/**
	 * 排班周主键
	 * @param Id_nhr_sched_week
	 */
	public void setId_nhr_sched_week(String Id_nhr_sched_week) {
		setAttrVal("Id_nhr_sched_week", Id_nhr_sched_week);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 周一日期
	 * @return FDate
	 */
	public FDate getDt_monday() {
		return ((FDate) getAttrVal("Dt_monday"));
	}
	/**
	 * 周一日期
	 * @param Dt_monday
	 */
	public void setDt_monday(FDate Dt_monday) {
		setAttrVal("Dt_monday", Dt_monday);
	}
	/**
	 * 排班名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 排班名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 表格名称
	 * @return String
	 */
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}
	/**
	 * 表格名称
	 * @param Title
	 */
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	/**
	 * 班次信息
	 * @return FArrayList
	 */
	public FArrayList getSilist() {
		return ((FArrayList) getAttrVal("Silist"));
	}
	/**
	 * 班次信息
	 * @param Silist
	 */
	public void setSilist(FArrayList Silist) {
		setAttrVal("Silist", Silist);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 排班状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 排班状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 排状态班
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 排状态班
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
}