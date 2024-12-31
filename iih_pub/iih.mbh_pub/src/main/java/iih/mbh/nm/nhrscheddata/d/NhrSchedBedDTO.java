package iih.mbh.nm.nhrscheddata.d;

public class NhrSchedBedDTO {

	// 所属科室
	private String id_dep;
	// 人员排班外键
	private String id_nhr_sched;
	// 人员班次所管床位主键
	private String id_nhr_sched_bed;
	// 班次外键
	private String id_nhr_si;
	// 护理人员
	private String id_nur;
	// 床位名称
	private String name_bed;
	// 床位编号
	private String sd_bed;
	// 数据状态
	private int status;

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_nhr_sched() {
		return id_nhr_sched;
	}

	public void setId_nhr_sched(String id_nhr_sched) {
		this.id_nhr_sched = id_nhr_sched;
	}

	public String getId_nhr_sched_bed() {
		return id_nhr_sched_bed;
	}

	public void setId_nhr_sched_bed(String id_nhr_sched_bed) {
		this.id_nhr_sched_bed = id_nhr_sched_bed;
	}

	public String getId_nhr_si() {
		return id_nhr_si;
	}

	public void setId_nhr_si(String id_nhr_si) {
		this.id_nhr_si = id_nhr_si;
	}

	public String getId_nur() {
		return id_nur;
	}

	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public String getSd_bed() {
		return sd_bed;
	}

	public void setSd_bed(String sd_bed) {
		this.sd_bed = sd_bed;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
