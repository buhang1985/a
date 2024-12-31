package iih.mbh.nm.nhrscheddata.d;

import java.util.List;
public class NhrSchedDTO {

	// 开始时间
	private String dt_beon;
	// 开始时间2
	private String dt_beon2;
	// 结束时间
	private String dt_off;
	// 结束时间2
	private String dt_off2;
	// 排班日期
	private String dt_sched_date;
	// 考勤时长
	private double dur_chk_ca;
	// 科室id
	private String id_dep;
	// 人员排班表主键
	private String id_nhr_sched;
	// 请假记录
	private String id_nhr_sched_lv;
	// 周排班外键
	private String id_nhr_sched_week;
	// 班次主键
	private String id_nhr_si;
	// 排班人员
	private String id_nur;
	// 护士层级id
	private String id_nur_lvl;
	// 班次分类id
	private String id_sica;
	// 班次性质id
	private String id_sipro;
	// 班次名称
	private String name_nhr_si;
	// 人员姓名
	private String name_nur;
	// 班次所管床位
	private List<NhrSchedBedDTO> schedbedlist;
	// 护士层级编码
	private String sd_nur_lvl;
	// 班次分类编码
	private String sd_sica;
	// 班次性质编码
	private String sd_sipro;
	// 班次序号
	private int sortno_day;
	// 数据状态
	private int status;

	public String getDt_beon() {
		return dt_beon;
	}

	public void setDt_beon(String dt_beon) {
		this.dt_beon = dt_beon;
	}

	public String getDt_beon2() {
		return dt_beon2;
	}

	public void setDt_beon2(String dt_beon2) {
		this.dt_beon2 = dt_beon2;
	}

	public String getDt_off() {
		return dt_off;
	}

	public void setDt_off(String dt_off) {
		this.dt_off = dt_off;
	}

	public String getDt_off2() {
		return dt_off2;
	}

	public void setDt_off2(String dt_off2) {
		this.dt_off2 = dt_off2;
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

	public String getId_nhr_sched_lv() {
		return id_nhr_sched_lv;
	}

	public void setId_nhr_sched_lv(String id_nhr_sched_lv) {
		this.id_nhr_sched_lv = id_nhr_sched_lv;
	}

	public String getId_nhr_sched_week() {
		return id_nhr_sched_week;
	}

	public void setId_nhr_sched_week(String id_nhr_sched_week) {
		this.id_nhr_sched_week = id_nhr_sched_week;
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

	public String getId_nur_lvl() {
		return id_nur_lvl;
	}

	public void setId_nur_lvl(String id_nur_lvl) {
		this.id_nur_lvl = id_nur_lvl;
	}

	public String getId_sica() {
		return id_sica;
	}

	public void setId_sica(String id_sica) {
		this.id_sica = id_sica;
	}

	public String getId_sipro() {
		return id_sipro;
	}

	public void setId_sipro(String id_sipro) {
		this.id_sipro = id_sipro;
	}

	public String getName_nhr_si() {
		return name_nhr_si;
	}

	public void setName_nhr_si(String name_nhr_si) {
		this.name_nhr_si = name_nhr_si;
	}

	public String getName_nur() {
		return name_nur;
	}

	public void setName_nur(String name_nur) {
		this.name_nur = name_nur;
	}

	public List<NhrSchedBedDTO> getSchedbedlist() {
		return schedbedlist;
	}

	public void setSchedbedlist(List<NhrSchedBedDTO> schedbedlist) {
		this.schedbedlist = schedbedlist;
	}

	public String getSd_nur_lvl() {
		return sd_nur_lvl;
	}

	public void setSd_nur_lvl(String sd_nur_lvl) {
		this.sd_nur_lvl = sd_nur_lvl;
	}

	public String getSd_sica() {
		return sd_sica;
	}

	public void setSd_sica(String sd_sica) {
		this.sd_sica = sd_sica;
	}

	public String getSd_sipro() {
		return sd_sipro;
	}

	public void setSd_sipro(String sd_sipro) {
		this.sd_sipro = sd_sipro;
	}

	public int getSortno_day() {
		return sortno_day;
	}

	public void setSortno_day(int sortno_day) {
		this.sortno_day = sortno_day;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
