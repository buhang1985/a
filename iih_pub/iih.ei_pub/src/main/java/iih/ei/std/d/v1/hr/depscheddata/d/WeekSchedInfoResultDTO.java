package iih.ei.std.d.v1.hr.depscheddata.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班查询返回数据 DTO数据 
 * 
 */
public class WeekSchedInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 排班表
	 * @return String
	 */
	public FArrayList getHscscheds() {
		return ((FArrayList) getAttrVal("Hscscheds"));
	}	
	/**
	 * 排班表
	 * @param Hscscheds
	 */
	public void setHscscheds(FArrayList Hscscheds) {
		setAttrVal("Hscscheds", Hscscheds);
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
}