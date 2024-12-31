package iih.pe.papt.dto.pehmapptdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeHmApptListDTO extends BaseDTO{

	// 健康管理服务预约主键标识
	@RPCField(id = 1)
	private String id_pehmappt;
	// 时间段
	@RPCField(id = 10)
	private String timeslice;
	// 预约姓名
	@RPCField(id = 11)
	private String name_psn;
	// 性别
	@RPCField(id = 12)
	private String sex_psn;
	// 年龄
	@RPCField(id = 13)
	private String age_psn;
	// 电话
	@RPCField(id = 14)
	private String mob_psn;
	// 健康管理师姓名
	@RPCField(id = 15)
	private String name_hmer;
	// 预约占用标识
	@RPCField(id = 16)
	private boolean fg_apped;
	// 个人预约单ID
	@RPCField(id = 2)
	private String id_pepsnappt;
	// 体检客户ID
	@RPCField(id = 3)
	private String id_pepsnbinfo;
	// 预约日期
	@RPCField(id = 4)
	private String dt_appt;
	// 预约号
	@RPCField(id = 5)
	private String no_appt;
	// 时间段开始时间
	@RPCField(id = 6)
	private String dt_apptbegin;
	// 时间段截止时间
	@RPCField(id = 7)
	private String dt_apptend;
	// 健康管理师ID
	@RPCField(id = 8)
	private String id_user;
	// 健康管理状态
	@RPCField(id = 9)
	private int hmstatus;

	public String getId_pehmappt() {
		return id_pehmappt;
	}

	public void setId_pehmappt(String id_pehmappt) {
		this.id_pehmappt = id_pehmappt;
	}

	public String getTimeslice() {
		return timeslice;
	}

	public void setTimeslice(String timeslice) {
		this.timeslice = timeslice;
	}

	public String getName_psn() {
		return name_psn;
	}

	public void setName_psn(String name_psn) {
		this.name_psn = name_psn;
	}

	public String getSex_psn() {
		return sex_psn;
	}

	public void setSex_psn(String sex_psn) {
		this.sex_psn = sex_psn;
	}

	public String getAge_psn() {
		return age_psn;
	}

	public void setAge_psn(String age_psn) {
		this.age_psn = age_psn;
	}

	public String getMob_psn() {
		return mob_psn;
	}

	public void setMob_psn(String mob_psn) {
		this.mob_psn = mob_psn;
	}

	public String getName_hmer() {
		return name_hmer;
	}

	public void setName_hmer(String name_hmer) {
		this.name_hmer = name_hmer;
	}

	public boolean getFg_apped() {
		return fg_apped;
	}

	public void setFg_apped(boolean fg_apped) {
		this.fg_apped = fg_apped;
	}

	public String getId_pepsnappt() {
		return id_pepsnappt;
	}

	public void setId_pepsnappt(String id_pepsnappt) {
		this.id_pepsnappt = id_pepsnappt;
	}

	public String getId_pepsnbinfo() {
		return id_pepsnbinfo;
	}

	public void setId_pepsnbinfo(String id_pepsnbinfo) {
		this.id_pepsnbinfo = id_pepsnbinfo;
	}

	public String getDt_appt() {
		return dt_appt;
	}

	public void setDt_appt(String dt_appt) {
		this.dt_appt = dt_appt;
	}

	public String getNo_appt() {
		return no_appt;
	}

	public void setNo_appt(String no_appt) {
		this.no_appt = no_appt;
	}

	public String getDt_apptbegin() {
		return dt_apptbegin;
	}

	public void setDt_apptbegin(String dt_apptbegin) {
		this.dt_apptbegin = dt_apptbegin;
	}

	public String getDt_apptend() {
		return dt_apptend;
	}

	public void setDt_apptend(String dt_apptend) {
		this.dt_apptend = dt_apptend;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public int getHmstatus() {
		return hmstatus;
	}

	public void setHmstatus(int hmstatus) {
		this.hmstatus = hmstatus;
	}

}
