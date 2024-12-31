package iih.mbh.mp.d;

import java.util.List;

public class MpOrPlanDTO {

	// 穿刺时间
	private long dt_inject;
	// 计划执行时间
	private long dt_mp_plan;
	// 执行状态
	private String eu_su;
	// 穿刺人
	private String id_emp_inject;
	// 医嘱执行计划ID
	private String id_or_pr;
	// 穿刺人名称
	private String name_emp_inject;
	// 频次名称
	private String name_freq;
	// 用法名称
	private String name_route;
	// 用法要求
	private String name_routedes;
	// 医嘱类型名称
	private String name_srvtp;
	// 医疗服务类型编码
	private String sd_srvtp;
	// 服务项目列表
	private List<MpOrSrvPlanDTO> srvList;

	public long getDt_inject() {
		return dt_inject;
	}

	public void setDt_inject(long dt_inject) {
		this.dt_inject = dt_inject;
	}

	public long getDt_mp_plan() {
		return dt_mp_plan;
	}

	public void setDt_mp_plan(long dt_mp_plan) {
		this.dt_mp_plan = dt_mp_plan;
	}

	public String getEu_su() {
		return eu_su;
	}

	public void setEu_su(String eu_su) {
		this.eu_su = eu_su;
	}

	public String getId_emp_inject() {
		return id_emp_inject;
	}

	public void setId_emp_inject(String id_emp_inject) {
		this.id_emp_inject = id_emp_inject;
	}

	public String getId_or_pr() {
		return id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getName_emp_inject() {
		return name_emp_inject;
	}

	public void setName_emp_inject(String name_emp_inject) {
		this.name_emp_inject = name_emp_inject;
	}

	public String getName_freq() {
		return name_freq;
	}

	public void setName_freq(String name_freq) {
		this.name_freq = name_freq;
	}

	public String getName_route() {
		return name_route;
	}

	public void setName_route(String name_route) {
		this.name_route = name_route;
	}

	public String getName_routedes() {
		return name_routedes;
	}

	public void setName_routedes(String name_routedes) {
		this.name_routedes = name_routedes;
	}

	public String getName_srvtp() {
		return name_srvtp;
	}

	public void setName_srvtp(String name_srvtp) {
		this.name_srvtp = name_srvtp;
	}

	public String getSd_srvtp() {
		return sd_srvtp;
	}

	public void setSd_srvtp(String sd_srvtp) {
		this.sd_srvtp = sd_srvtp;
	}

	public List<MpOrSrvPlanDTO> getSrvList() {
		return srvList;
	}

	public void setSrvList(List<MpOrSrvPlanDTO> srvList) {
		this.srvList = srvList;
	}

}
