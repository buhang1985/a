package iih.nm.nhr.dto.nhrschedweekdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班人员明细dto DTO数据 
 * 
 */
public class SchedItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 人员排班明细主键
	 * @return String
	 */
	public String getId_nhr_sched_itm() {
		return ((String) getAttrVal("Id_nhr_sched_itm"));
	}
	/**
	 * 人员排班明细主键
	 * @param Id_nhr_sched_itm
	 */
	public void setId_nhr_sched_itm(String Id_nhr_sched_itm) {
		setAttrVal("Id_nhr_sched_itm", Id_nhr_sched_itm);
	}
	/**
	 * 人员排班表外键
	 * @return String
	 */
	public String getId_nhr_sched() {
		return ((String) getAttrVal("Id_nhr_sched"));
	}
	/**
	 * 人员排班表外键
	 * @param Id_nhr_sched
	 */
	public void setId_nhr_sched(String Id_nhr_sched) {
		setAttrVal("Id_nhr_sched", Id_nhr_sched);
	}
	/**
	 * 班次外键
	 * @return String
	 */
	public String getId_nhr_si() {
		return ((String) getAttrVal("Id_nhr_si"));
	}
	/**
	 * 班次外键
	 * @param Id_nhr_si
	 */
	public void setId_nhr_si(String Id_nhr_si) {
		setAttrVal("Id_nhr_si", Id_nhr_si);
	}
	/**
	 * 实际上班时间
	 * @return FDateTime
	 */
	public FDateTime getDt_beon() {
		return ((FDateTime) getAttrVal("Dt_beon"));
	}
	/**
	 * 实际上班时间
	 * @param Dt_beon
	 */
	public void setDt_beon(FDateTime Dt_beon) {
		setAttrVal("Dt_beon", Dt_beon);
	}
	/**
	 * 实际下班时间
	 * @return FDateTime
	 */
	public FDateTime getDt_off() {
		return ((FDateTime) getAttrVal("Dt_off"));
	}
	/**
	 * 实际下班时间
	 * @param Dt_off
	 */
	public void setDt_off(FDateTime Dt_off) {
		setAttrVal("Dt_off", Dt_off);
	}
}