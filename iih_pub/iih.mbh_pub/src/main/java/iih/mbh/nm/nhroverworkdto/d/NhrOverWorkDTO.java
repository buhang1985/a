package iih.mbh.nm.nhroverworkdto.d;

public class NhrOverWorkDTO {

	// 审批意见
	private String ctrl3;
	// 申请原因
	private String des;
	// 操作时间
	private String dt_submit;
	// 加班日期
	private String dt_work;
	// 加班时长
	private double dur_hour;
	// 关联科室
	private String id_dep;
	// 护理单元外键
	private String id_dep_nur;
	// 加班申请主键
	private String id_nhr_overwork;
	// 护理人员外键
	private String id_nur;
	// 人员外键
	private String id_psndoc;
	// 任务id
	private String id_task;
	// 护理单元
	private String name_dep_nur;
	// 护理人员
	private String name_nur;
	// 流程状态
	private String sd_status;
	// 数据状态
	private int status;

	public String getCtrl3() {
		return ctrl3;
	}

	public void setCtrl3(String ctrl3) {
		this.ctrl3 = ctrl3;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDt_submit() {
		return dt_submit;
	}

	public void setDt_submit(String dt_submit) {
		this.dt_submit = dt_submit;
	}

	public String getDt_work() {
		return dt_work;
	}

	public void setDt_work(String dt_work) {
		this.dt_work = dt_work;
	}

	public double getDur_hour() {
		return dur_hour;
	}

	public void setDur_hour(double dur_hour) {
		this.dur_hour = dur_hour;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_dep_nur() {
		return id_dep_nur;
	}

	public void setId_dep_nur(String id_dep_nur) {
		this.id_dep_nur = id_dep_nur;
	}

	public String getId_nhr_overwork() {
		return id_nhr_overwork;
	}

	public void setId_nhr_overwork(String id_nhr_overwork) {
		this.id_nhr_overwork = id_nhr_overwork;
	}

	public String getId_nur() {
		return id_nur;
	}

	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
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

	public String getName_dep_nur() {
		return name_dep_nur;
	}

	public void setName_dep_nur(String name_dep_nur) {
		this.name_dep_nur = name_dep_nur;
	}

	public String getName_nur() {
		return name_nur;
	}

	public void setName_nur(String name_nur) {
		this.name_nur = name_nur;
	}

	public String getSd_status() {
		return sd_status;
	}

	public void setSd_status(String sd_status) {
		this.sd_status = sd_status;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
