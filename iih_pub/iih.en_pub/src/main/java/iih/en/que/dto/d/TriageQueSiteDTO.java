package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分诊台队列或工作站点DTO DTO数据 
 * 
 */
public class TriageQueSiteDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 工作站点id
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}
	/**
	 * 工作站点id
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 工作点名称
	 * @return String
	 */
	public String getName_quesite() {
		return ((String) getAttrVal("Name_quesite"));
	}
	/**
	 * 工作点名称
	 * @param Name_quesite
	 */
	public void setName_quesite(String Name_quesite) {
		setAttrVal("Name_quesite", Name_quesite);
	}
	/**
	 * 队列id
	 * @return String
	 */
	public String getId_que() {
		return ((String) getAttrVal("Id_que"));
	}
	/**
	 * 队列id
	 * @param Id_que
	 */
	public void setId_que(String Id_que) {
		setAttrVal("Id_que", Id_que);
	}
	/**
	 * 队列名称
	 * @return String
	 */
	public String getName_que() {
		return ((String) getAttrVal("Name_que"));
	}
	/**
	 * 队列名称
	 * @param Name_que
	 */
	public void setName_que(String Name_que) {
		setAttrVal("Name_que", Name_que);
	}
	/**
	 * 分诊台id
	 * @return String
	 */
	public String getId_ben() {
		return ((String) getAttrVal("Id_ben"));
	}
	/**
	 * 分诊台id
	 * @param Id_ben
	 */
	public void setId_ben(String Id_ben) {
		setAttrVal("Id_ben", Id_ben);
	}
	/**
	 * 分诊台名称
	 * @return String
	 */
	public String getName_ben() {
		return ((String) getAttrVal("Name_ben"));
	}
	/**
	 * 分诊台名称
	 * @param Name_ben
	 */
	public void setName_ben(String Name_ben) {
		setAttrVal("Name_ben", Name_ben);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 资源服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 资源服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getScsrv_name() {
		return ((String) getAttrVal("Scsrv_name"));
	}
	/**
	 * 排班服务名称
	 * @param Scsrv_name
	 */
	public void setScsrv_name(String Scsrv_name) {
		setAttrVal("Scsrv_name", Scsrv_name);
	}
	/**
	 * 接诊医生
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 接诊医生
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 医生
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}
	/**
	 * 医生
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 未分诊人数
	 * @return Integer
	 */
	public Integer getNotriagenum() {
		return ((Integer) getAttrVal("Notriagenum"));
	}
	/**
	 * 未分诊人数
	 * @param Notriagenum
	 */
	public void setNotriagenum(Integer Notriagenum) {
		setAttrVal("Notriagenum", Notriagenum);
	}
	/**
	 * 分诊人数
	 * @return Integer
	 */
	public Integer getTriagenum() {
		return ((Integer) getAttrVal("Triagenum"));
	}
	/**
	 * 分诊人数
	 * @param Triagenum
	 */
	public void setTriagenum(Integer Triagenum) {
		setAttrVal("Triagenum", Triagenum);
	}
	/**
	 * 候诊人数
	 * @return Integer
	 */
	public Integer getWaitnum() {
		return ((Integer) getAttrVal("Waitnum"));
	}
	/**
	 * 候诊人数
	 * @param Waitnum
	 */
	public void setWaitnum(Integer Waitnum) {
		setAttrVal("Waitnum", Waitnum);
	}
	/**
	 * 已检查人数
	 * @return Integer
	 */
	public Integer getCheckednum() {
		return ((Integer) getAttrVal("Checkednum"));
	}
	/**
	 * 已检查人数
	 * @param Checkednum
	 */
	public void setCheckednum(Integer Checkednum) {
		setAttrVal("Checkednum", Checkednum);
	}
	/**
	 * 工作站状态
	 * @return String
	 */
	public String getSitestatus() {
		return ((String) getAttrVal("Sitestatus"));
	}
	/**
	 * 工作站状态
	 * @param Sitestatus
	 */
	public void setSitestatus(String Sitestatus) {
		setAttrVal("Sitestatus", Sitestatus);
	}
	/**
	 * 资源id
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 资源id
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 排班资源名称
	 * @return String
	 */
	public String getName_res() {
		return ((String) getAttrVal("Name_res"));
	}
	/**
	 * 排班资源名称
	 * @param Name_res
	 */
	public void setName_res(String Name_res) {
		setAttrVal("Name_res", Name_res);
	}
	/**
	 * 暂停
	 * @return FBoolean
	 */
	public FBoolean getFg_pause() {
		return ((FBoolean) getAttrVal("Fg_pause"));
	}
	/**
	 * 暂停
	 * @param Fg_pause
	 */
	public void setFg_pause(FBoolean Fg_pause) {
		setAttrVal("Fg_pause", Fg_pause);
	}
	/**
	 * 预约数
	 * @return String
	 */
	public String getQuan_appt_used() {
		return ((String) getAttrVal("Quan_appt_used"));
	}
	/**
	 * 预约数
	 * @param Quan_appt_used
	 */
	public void setQuan_appt_used(String Quan_appt_used) {
		setAttrVal("Quan_appt_used", Quan_appt_used);
	}
	/**
	 * 剩余数
	 * @return String
	 */
	public String getQuan_left() {
		return ((String) getAttrVal("Quan_left"));
	}
	/**
	 * 剩余数
	 * @param Quan_left
	 */
	public void setQuan_left(String Quan_left) {
		setAttrVal("Quan_left", Quan_left);
	}
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 站点状态
	 * @return String
	 */
	public String getEu_pause() {
		return ((String) getAttrVal("Eu_pause"));
	}
	/**
	 * 站点状态
	 * @param Eu_pause
	 */
	public void setEu_pause(String Eu_pause) {
		setAttrVal("Eu_pause", Eu_pause);
	}
	/**
	 * 排班服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 排班服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 排班资源类型
	 * @return String
	 */
	public String getSd_screstp() {
		return ((String) getAttrVal("Sd_screstp"));
	}
	/**
	 * 排班资源类型
	 * @param Sd_screstp
	 */
	public void setSd_screstp(String Sd_screstp) {
		setAttrVal("Sd_screstp", Sd_screstp);
	}
	/**
	 * 最大申请量
	 * @return Integer
	 */
	public Integer getApply_max() {
		return ((Integer) getAttrVal("Apply_max"));
	}
	/**
	 * 最大申请量
	 * @param Apply_max
	 */
	public void setApply_max(Integer Apply_max) {
		setAttrVal("Apply_max", Apply_max);
	}
	/**
	 * 队列分诊模式
	 * @return String
	 */
	public String getSd_mode() {
		return ((String) getAttrVal("Sd_mode"));
	}
	/**
	 * 队列分诊模式
	 * @param Sd_mode
	 */
	public void setSd_mode(String Sd_mode) {
		setAttrVal("Sd_mode", Sd_mode);
	}
	/**
	 * 房间号
	 * @return String
	 */
	public String getRoom() {
		return ((String) getAttrVal("Room"));
	}
	/**
	 * 房间号
	 * @param Room
	 */
	public void setRoom(String Room) {
		setAttrVal("Room", Room);
	}
	/**
	 * 午别id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 排班计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 排班计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 票号模式
	 * @return String
	 */
	public String getSd_tickmd() {
		return ((String) getAttrVal("Sd_tickmd"));
	}
	/**
	 * 票号模式
	 * @param Sd_tickmd
	 */
	public void setSd_tickmd(String Sd_tickmd) {
		setAttrVal("Sd_tickmd", Sd_tickmd);
	}
	/**
	 * 队列最大顺序号
	 * @return Integer
	 */
	public Integer getTicketno() {
		return ((Integer) getAttrVal("Ticketno"));
	}
	/**
	 * 队列最大顺序号
	 * @param Ticketno
	 */
	public void setTicketno(Integer Ticketno) {
		setAttrVal("Ticketno", Ticketno);
	}
}
    
