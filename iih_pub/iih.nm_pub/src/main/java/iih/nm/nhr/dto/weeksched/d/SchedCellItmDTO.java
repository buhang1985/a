package iih.nm.nhr.dto.weeksched.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 单元格内部项目 DTO数据 
 * 
 */
public class SchedCellItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班班次id
	 * @return String
	 */
	public String getId_nhr_sched() {
		return ((String) getAttrVal("Id_nhr_sched"));
	}
	/**
	 * 排班班次id
	 * @param Id_nhr_sched
	 */
	public void setId_nhr_sched(String Id_nhr_sched) {
		setAttrVal("Id_nhr_sched", Id_nhr_sched);
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
	 * 班次明细
	 * @return FArrayList
	 */
	public FArrayList getSi_detail_list() {
		return ((FArrayList) getAttrVal("Si_detail_list"));
	}
	/**
	 * 班次明细
	 * @param Si_detail_list
	 */
	public void setSi_detail_list(FArrayList Si_detail_list) {
		setAttrVal("Si_detail_list", Si_detail_list);
	}
	/**
	 * 所管床位
	 * @return FArrayList
	 */
	public FArrayList getItm_bed_list() {
		return ((FArrayList) getAttrVal("Itm_bed_list"));
	}
	/**
	 * 所管床位
	 * @param Itm_bed_list
	 */
	public void setItm_bed_list(FArrayList Itm_bed_list) {
		setAttrVal("Itm_bed_list", Itm_bed_list);
	}
	/**
	 * 所带学生列表
	 * @return FArrayList
	 */
	public FArrayList getItm_stu_list() {
		return ((FArrayList) getAttrVal("Itm_stu_list"));
	}
	/**
	 * 所带学生列表
	 * @param Itm_stu_list
	 */
	public void setItm_stu_list(FArrayList Itm_stu_list) {
		setAttrVal("Itm_stu_list", Itm_stu_list);
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
}