package iih.nm.nhr.dto.weeksched.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 单元格内部项目 DTO数据 
 * 
 */
public class SchedCellDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 人员排班id
	 * @return String
	 */
	public String getId_nhr_sched() {
		return ((String) getAttrVal("Id_nhr_sched"));
	}
	/**
	 * 人员排班id
	 * @param Id_nhr_sched
	 */
	public void setId_nhr_sched(String Id_nhr_sched) {
		setAttrVal("Id_nhr_sched", Id_nhr_sched);
	}
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
	 * 排班日期
	 * @return FDate
	 */
	public FDate getDt_sched() {
		return ((FDate) getAttrVal("Dt_sched"));
	}
	/**
	 * 排班日期
	 * @param Dt_sched
	 */
	public void setDt_sched(FDate Dt_sched) {
		setAttrVal("Dt_sched", Dt_sched);
	}
	/**
	 * 排班班次
	 * @return FArrayList
	 */
	public FArrayList getSi_list() {
		return ((FArrayList) getAttrVal("Si_list"));
	}
	/**
	 * 排班班次
	 * @param Si_list
	 */
	public void setSi_list(FArrayList Si_list) {
		setAttrVal("Si_list", Si_list);
	}
	/**
	 * 班次id
	 * @return String
	 */
	public String getId_nhr_si() {
		return ((String) getAttrVal("Id_nhr_si"));
	}
	/**
	 * 班次id
	 * @param Id_nhr_si
	 */
	public void setId_nhr_si(String Id_nhr_si) {
		setAttrVal("Id_nhr_si", Id_nhr_si);
	}
	/**
	 * 班次名称
	 * @return String
	 */
	public String getName_nhr_si() {
		return ((String) getAttrVal("Name_nhr_si"));
	}
	/**
	 * 班次名称
	 * @param Name_nhr_si
	 */
	public void setName_nhr_si(String Name_nhr_si) {
		setAttrVal("Name_nhr_si", Name_nhr_si);
	}
	/**
	 * 班次序号
	 * @return Integer
	 */
	public Integer getSortno_day() {
		return ((Integer) getAttrVal("Sortno_day"));
	}
	/**
	 * 班次序号
	 * @param Sortno_day
	 */
	public void setSortno_day(Integer Sortno_day) {
		setAttrVal("Sortno_day", Sortno_day);
	}
	/**
	 * 所管床位
	 * @return FArrayList
	 */
	public FArrayList getBed_list() {
		return ((FArrayList) getAttrVal("Bed_list"));
	}
	/**
	 * 所管床位
	 * @param Bed_list
	 */
	public void setBed_list(FArrayList Bed_list) {
		setAttrVal("Bed_list", Bed_list);
	}
	/**
	 * 考勤时长
	 * @return FDouble
	 */
	public FDouble getDur_chk_ca() {
		return ((FDouble) getAttrVal("Dur_chk_ca"));
	}
	/**
	 * 考勤时长
	 * @param Dur_chk_ca
	 */
	public void setDur_chk_ca(FDouble Dur_chk_ca) {
		setAttrVal("Dur_chk_ca", Dur_chk_ca);
	}
	/**
	 * 所带学生列表
	 * @return FArrayList
	 */
	public FArrayList getStu_list() {
		return ((FArrayList) getAttrVal("Stu_list"));
	}
	/**
	 * 所带学生列表
	 * @param Stu_list
	 */
	public void setStu_list(FArrayList Stu_list) {
		setAttrVal("Stu_list", Stu_list);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}
	/**
	 * 备注
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 上周班次id
	 * @return String
	 */
	public String getId_nhr_sched_last() {
		return ((String) getAttrVal("Id_nhr_sched_last"));
	}
	/**
	 * 上周班次id
	 * @param Id_nhr_sched_last
	 */
	public void setId_nhr_sched_last(String Id_nhr_sched_last) {
		setAttrVal("Id_nhr_sched_last", Id_nhr_sched_last);
	}
	/**
	 * 上周班次
	 * @return String
	 */
	public String getName_nhr_sched_last() {
		return ((String) getAttrVal("Name_nhr_sched_last"));
	}
	/**
	 * 上周班次
	 * @param Name_nhr_sched_last
	 */
	public void setName_nhr_sched_last(String Name_nhr_sched_last) {
		setAttrVal("Name_nhr_sched_last", Name_nhr_sched_last);
	}
	/**
	 * 上周考勤时长
	 * @return FDouble
	 */
	public FDouble getDur_chk_ca_lastweek() {
		return ((FDouble) getAttrVal("Dur_chk_ca_lastweek"));
	}
	/**
	 * 上周考勤时长
	 * @param Dur_chk_ca_lastweek
	 */
	public void setDur_chk_ca_lastweek(FDouble Dur_chk_ca_lastweek) {
		setAttrVal("Dur_chk_ca_lastweek", Dur_chk_ca_lastweek);
	}
}