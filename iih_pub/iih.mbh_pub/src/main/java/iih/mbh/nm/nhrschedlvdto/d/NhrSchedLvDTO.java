package iih.mbh.nm.nhrschedlvdto.d;


public class NhrSchedLvDTO {

	// 开始时间上下午
	private boolean ampm_lv;
	// 申请天数
	private int days_lv;
	// 请假开始时间
	private String dt_begin_lv;
	// 请假结束时间
	private String dt_end_lv;
	// 申请状态
	private String id_apy_status;
	// 关联科室
	private String id_dep;
	// 申请人护理单元id
	private String id_dep_apy;
	// 人员请假申请主键
	private String id_nhr_sched_lv;
	// 排班班次外键
	private String id_nhr_si;
	// 申请人id
	private String id_nur_apy;
	// 人员id
	private String id_psndoc;
	// 任务id
	private String id_task;
	// 申请人护理单元
	private String name_dep_apy;
	// 请假类型
	private String name_nhr_si;
	// 申请人名称
	private String name_nur_apy;
	// 人员名称
	private String name_psndoc;
	// 申请事由
	private String reason_lv;
	// 申请状态编码
	private String sd_apy_status;
	// 数据状态
	private int status;

	public boolean getAmpm_lv() {
		return ampm_lv;
	}

	public void setAmpm_lv(boolean ampm_lv) {
		this.ampm_lv = ampm_lv;
	}

	public int getDays_lv() {
		return days_lv;
	}

	public void setDays_lv(int days_lv) {
		this.days_lv = days_lv;
	}

	public String getDt_begin_lv() {
		return dt_begin_lv;
	}

	public void setDt_begin_lv(String dt_begin_lv) {
		this.dt_begin_lv = dt_begin_lv;
	}

	public String getDt_end_lv() {
		return dt_end_lv;
	}

	public void setDt_end_lv(String dt_end_lv) {
		this.dt_end_lv = dt_end_lv;
	}

	public String getId_apy_status() {
		return id_apy_status;
	}

	public void setId_apy_status(String id_apy_status) {
		this.id_apy_status = id_apy_status;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_dep_apy() {
		return id_dep_apy;
	}

	public void setId_dep_apy(String id_dep_apy) {
		this.id_dep_apy = id_dep_apy;
	}

	public String getId_nhr_sched_lv() {
		return id_nhr_sched_lv;
	}

	public void setId_nhr_sched_lv(String id_nhr_sched_lv) {
		this.id_nhr_sched_lv = id_nhr_sched_lv;
	}

	public String getId_nhr_si() {
		return id_nhr_si;
	}

	public void setId_nhr_si(String id_nhr_si) {
		this.id_nhr_si = id_nhr_si;
	}

	public String getId_nur_apy() {
		return id_nur_apy;
	}

	public void setId_nur_apy(String id_nur_apy) {
		this.id_nur_apy = id_nur_apy;
	}

	public String getId_psndoc() {
		return id_psndoc;
	}

	public void setId_psndoc(String id_psndoc) {
		this.id_psndoc = id_psndoc;
	}

	public String getId_task() {
		return id_task;
	}

	public void setId_task(String id_task) {
		this.id_task = id_task;
	}

	public String getName_dep_apy() {
		return name_dep_apy;
	}

	public void setName_dep_apy(String name_dep_apy) {
		this.name_dep_apy = name_dep_apy;
	}

	public String getName_nhr_si() {
		return name_nhr_si;
	}

	public void setName_nhr_si(String name_nhr_si) {
		this.name_nhr_si = name_nhr_si;
	}

	public String getName_nur_apy() {
		return name_nur_apy;
	}

	public void setName_nur_apy(String name_nur_apy) {
		this.name_nur_apy = name_nur_apy;
	}

	public String getName_psndoc() {
		return name_psndoc;
	}

	public void setName_psndoc(String name_psndoc) {
		this.name_psndoc = name_psndoc;
	}

	public String getReason_lv() {
		return reason_lv;
	}

	public void setReason_lv(String reason_lv) {
		this.reason_lv = reason_lv;
	}

	public String getSd_apy_status() {
		return sd_apy_status;
	}

	public void setSd_apy_status(String sd_apy_status) {
		this.sd_apy_status = sd_apy_status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
