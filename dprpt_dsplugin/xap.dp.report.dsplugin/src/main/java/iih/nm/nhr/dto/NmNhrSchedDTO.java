package iih.nm.nhr.dto;

public class NmNhrSchedDTO {

	/**
	 * 护理人员id
	 */
	private String id_nur;
	/**
	 * 班次名称
	 */
	private String name_nhr_si;
	/**
	 * 排班日期
	 */
	private String dt_sched_date;
	
	/**
	 * 实际考勤时长
	 */
	private double dur_chk_ca;
	
	public String getId_nur() {
		return id_nur;
	}
	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
	}
	public String getName_nhr_si() {
		return name_nhr_si;
	}
	public void setName_nhr_si(String name_nhr_si) {
		this.name_nhr_si = name_nhr_si;
	}
	public String getDt_sched_date() {
		return dt_sched_date;
	}
	public void setDt_sched_date(String dt_sched_date) {
		this.dt_sched_date = dt_sched_date;
	}
	public double getDur_chk_ca() {
		return dur_chk_ca;
	}
	public void setDur_chk_ca(double dur_chk_ca) {
		this.dur_chk_ca = dur_chk_ca;
	}
	
}
