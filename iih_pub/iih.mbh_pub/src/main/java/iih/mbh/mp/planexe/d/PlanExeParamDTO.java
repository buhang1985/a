package iih.mbh.mp.planexe.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PlanExeParamDTO {

	// 执行计划
	@RPCField(id = 1)
	private String id_or_pr;
	// 同一人配液原因
	@RPCField(id = 10)
	private String sd_selfreview;
	// 执行状态
	@RPCField(id = 2)
	private int mp_tp;
	// 执行科室
	@RPCField(id = 3)
	private String id_dep;
	// 执行人
	@RPCField(id = 4)
	private String id_emp;
	// 执行时间
	@RPCField(id = 5)
	private String dt_mp;
	// 不执行原因
	@RPCField(id = 6)
	private String sd_skipreson;
	// 滴速
	@RPCField(id = 7)
	private String ivgtt;
	// 单位ID
	@RPCField(id = 8)
	private String id_unit;
	// 单位SD
	@RPCField(id = 9)
	private String sd_unit;

	public String getId_or_pr() {
		return id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getSd_selfreview() {
		return sd_selfreview;
	}

	public void setSd_selfreview(String sd_selfreview) {
		this.sd_selfreview = sd_selfreview;
	}

	public int getMp_tp() {
		return mp_tp;
	}

	public void setMp_tp(int mp_tp) {
		this.mp_tp = mp_tp;
	}

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_emp() {
		return id_emp;
	}

	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}

	public String getDt_mp() {
		return dt_mp;
	}

	public void setDt_mp(String dt_mp) {
		this.dt_mp = dt_mp;
	}

	public String getSd_skipreson() {
		return sd_skipreson;
	}

	public void setSd_skipreson(String sd_skipreson) {
		this.sd_skipreson = sd_skipreson;
	}

	public String getIvgtt() {
		return ivgtt;
	}

	public void setIvgtt(String ivgtt) {
		this.ivgtt = ivgtt;
	}

	public String getId_unit() {
		return id_unit;
	}

	public void setId_unit(String id_unit) {
		this.id_unit = id_unit;
	}

	public String getSd_unit() {
		return sd_unit;
	}

	public void setSd_unit(String sd_unit) {
		this.sd_unit = sd_unit;
	}

}
