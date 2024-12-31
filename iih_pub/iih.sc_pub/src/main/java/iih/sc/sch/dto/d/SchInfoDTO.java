package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班信息dto DTO数据 
 * 
 */
public class SchInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 计划id
	 * @return String
	 */
	public String getId_scpl() {
		return ((String) getAttrVal("Id_scpl"));
	}
	/**
	 * 计划id
	 * @param Id_scpl
	 */
	public void setId_scpl(String Id_scpl) {
		setAttrVal("Id_scpl", Id_scpl);
	}
	/**
	 * 计划
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 计划
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 排班服务id
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务id
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 排班服务
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 排班资源id
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 排班资源id
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 排班资源
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 排班资源
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 预约规则id
	 * @return String
	 */
	public String getId_apptru() {
		return ((String) getAttrVal("Id_apptru"));
	}
	/**
	 * 预约规则id
	 * @param Id_apptru
	 */
	public void setId_apptru(String Id_apptru) {
		setAttrVal("Id_apptru", Id_apptru);
	}
	/**
	 * 预约规则
	 * @return String
	 */
	public String getName_apptru() {
		return ((String) getAttrVal("Name_apptru"));
	}
	/**
	 * 预约规则
	 * @param Name_apptru
	 */
	public void setName_apptru(String Name_apptru) {
		setAttrVal("Name_apptru", Name_apptru);
	}
	/**
	 * 总号源数
	 * @return Integer
	 */
	public Integer getQuan_total() {
		return ((Integer) getAttrVal("Quan_total"));
	}
	/**
	 * 总号源数
	 * @param Quan_total
	 */
	public void setQuan_total(Integer Quan_total) {
		setAttrVal("Quan_total", Quan_total);
	}
	/**
	 * 总使用数
	 * @return Integer
	 */
	public Integer getQuan_total_used() {
		return ((Integer) getAttrVal("Quan_total_used"));
	}
	/**
	 * 总使用数
	 * @param Quan_total_used
	 */
	public void setQuan_total_used(Integer Quan_total_used) {
		setAttrVal("Quan_total_used", Quan_total_used);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 状态
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 启用标识
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 计划日期
	 * @return String
	 */
	public String getDt_plan() {
		return ((String) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划日期
	 * @param Dt_plan
	 */
	public void setDt_plan(String Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 排班类型
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 排班类型
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 是否停用
	 * @return FBoolean
	 */
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}
	/**
	 * 是否停用
	 * @param Fg_stop
	 */
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	/**
	 * 排班日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
}