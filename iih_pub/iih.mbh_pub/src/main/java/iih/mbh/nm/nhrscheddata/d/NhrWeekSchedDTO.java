package iih.mbh.nm.nhrscheddata.d;

import java.util.List;
public class NhrWeekSchedDTO {

	// 备注
	private String des;
	// 周一日期
	private String dt_monday;
	// 排班分组列表
	private List<NhrGrpSchedDTO> grpschedlist;
	// 科室id
	private String id_dep;
	// 排班周主键
	private String id_nhr_sched_week;
	// 排班状态id
	private String id_status;
	// 是否存在排班数据
	private boolean is_existdata;
	// 名称
	private String name;
	// 排班数据
	private List<NhrSchedDTO> schedlist;
	// 排班状态
	private String sd_status;
	// 数据状态
	private int status;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDt_monday() {
		return dt_monday;
	}

	public void setDt_monday(String dt_monday) {
		this.dt_monday = dt_monday;
	}

	public List<NhrGrpSchedDTO> getGrpschedlist() {
		return grpschedlist;
	}

	public void setGrpschedlist(List<NhrGrpSchedDTO> grpschedlist) {
		this.grpschedlist = grpschedlist;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_nhr_sched_week() {
		return id_nhr_sched_week;
	}

	public void setId_nhr_sched_week(String id_nhr_sched_week) {
		this.id_nhr_sched_week = id_nhr_sched_week;
	}

	public String getId_status() {
		return id_status;
	}

	public void setId_status(String id_status) {
		this.id_status = id_status;
	}

	public boolean getIs_existdata() {
		return is_existdata;
	}

	public void setIs_existdata(boolean is_existdata) {
		this.is_existdata = is_existdata;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NhrSchedDTO> getSchedlist() {
		return schedlist;
	}

	public void setSchedlist(List<NhrSchedDTO> schedlist) {
		this.schedlist = schedlist;
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
