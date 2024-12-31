package iih.mbh.nm.nhrexpscheddto.d;

import java.util.List;
public class NhrExpSchedDTO {

	// 备注
	private String des;
	// 期望排班日期
	private String dt_sched;
	// 提交时间
	private String dt_submit;
	// 关联科室外键
	private String id_dep;
	// 护理单元外键
	private String id_dep_nur;
	// 期望排班主键
	private String id_nhr_expsched;
	// 期望排班外键
	private String id_nhr_si;
	// 护理人员外键
	private String id_nur;
	// 人员外键
	private String id_psndoc;
	// 护理单元
	private String name_dep_nur;
	// 期望排班
	private String name_nhr_si;
	// 护理人员
	private String name_nur;
	// 数据状态
	private int status;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDt_sched() {
		return dt_sched;
	}

	public void setDt_sched(String dt_sched) {
		this.dt_sched = dt_sched;
	}

	public String getDt_submit() {
		return dt_submit;
	}

	public void setDt_submit(String dt_submit) {
		this.dt_submit = dt_submit;
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

	public String getId_nhr_expsched() {
		return id_nhr_expsched;
	}

	public void setId_nhr_expsched(String id_nhr_expsched) {
		this.id_nhr_expsched = id_nhr_expsched;
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

	public String getId_psndoc() {
		return id_psndoc;
	}

	public void setId_psndoc(String id_psndoc) {
		this.id_psndoc = id_psndoc;
	}

	public String getName_dep_nur() {
		return name_dep_nur;
	}

	public void setName_dep_nur(String name_dep_nur) {
		this.name_dep_nur = name_dep_nur;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
