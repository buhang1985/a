package iih.mp.nr.mpnrbanner.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class Mpnrbannerdto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 计划执行日期
	 * @return FDateTime
	 */
	public FDateTime getExec_date() {
		return ((FDateTime) getAttrVal("Exec_date"));
	}
	/**
	 * 计划执行日期
	 * @param Exec_date
	 */
	public void setExec_date(FDateTime Exec_date) {
		setAttrVal("Exec_date", Exec_date);
	}
	/**
	 * 全部
	 * @return FBoolean
	 */
	public FBoolean getAll() {
		return ((FBoolean) getAttrVal("All"));
	}
	/**
	 * 全部
	 * @param All
	 */
	public void setAll(FBoolean All) {
		setAttrVal("All", All);
	}
	/**
	 * 已执行
	 * @return FBoolean
	 */
	public FBoolean getExecuted() {
		return ((FBoolean) getAttrVal("Executed"));
	}
	/**
	 * 已执行
	 * @param Executed
	 */
	public void setExecuted(FBoolean Executed) {
		setAttrVal("Executed", Executed);
	}
	/**
	 * 未执行
	 * @return FBoolean
	 */
	public FBoolean getUnexecuted() {
		return ((FBoolean) getAttrVal("Unexecuted"));
	}
	/**
	 * 未执行
	 * @param Unexecuted
	 */
	public void setUnexecuted(FBoolean Unexecuted) {
		setAttrVal("Unexecuted", Unexecuted);
	}
	/**
	 * 未用
	 * @return FBoolean
	 */
	public FBoolean getUnused() {
		return ((FBoolean) getAttrVal("Unused"));
	}
	/**
	 * 未用
	 * @param Unused
	 */
	public void setUnused(FBoolean Unused) {
		setAttrVal("Unused", Unused);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getExecutor() {
		return ((String) getAttrVal("Executor"));
	}
	/**
	 * 执行人
	 * @param Executor
	 */
	public void setExecutor(String Executor) {
		setAttrVal("Executor", Executor);
	}
	/**
	 * 执行时间
	 * @return FDateTime
	 */
	public FDateTime getExec_time() {
		return ((FDateTime) getAttrVal("Exec_time"));
	}
	/**
	 * 执行时间
	 * @param Exec_time
	 */
	public void setExec_time(FDateTime Exec_time) {
		setAttrVal("Exec_time", Exec_time);
	}
	/**
	 * 执行人编码
	 * @return String
	 */
	public String getExecutor_code() {
		return ((String) getAttrVal("Executor_code"));
	}
	/**
	 * 执行人编码
	 * @param Executor_code
	 */
	public void setExecutor_code(String Executor_code) {
		setAttrVal("Executor_code", Executor_code);
	}
	/**
	 * 执行人名称
	 * @return String
	 */
	public String getExecutor_name() {
		return ((String) getAttrVal("Executor_name"));
	}
	/**
	 * 执行人名称
	 * @param Executor_name
	 */
	public void setExecutor_name(String Executor_name) {
		setAttrVal("Executor_name", Executor_name);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getExecutestatus() {
		return ((String) getAttrVal("Executestatus"));
	}
	/**
	 * 执行状态
	 * @param Executestatus
	 */
	public void setExecutestatus(String Executestatus) {
		setAttrVal("Executestatus", Executestatus);
	}
	/**
	 * 按计划执行时间执行
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_plan() {
		return ((FBoolean) getAttrVal("Fg_mp_plan"));
	}
	/**
	 * 按计划执行时间执行
	 * @param Fg_mp_plan
	 */
	public void setFg_mp_plan(FBoolean Fg_mp_plan) {
		setAttrVal("Fg_mp_plan", Fg_mp_plan);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getTime_begin() {
		return ((FDateTime) getAttrVal("Time_begin"));
	}
	/**
	 * 开始时间
	 * @param Time_begin
	 */
	public void setTime_begin(FDateTime Time_begin) {
		setAttrVal("Time_begin", Time_begin);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getTime_end() {
		return ((FDateTime) getAttrVal("Time_end"));
	}
	/**
	 * 结束时间
	 * @param Time_end
	 */
	public void setTime_end(FDateTime Time_end) {
		setAttrVal("Time_end", Time_end);
	}
	/**
	 * 计划时间段档案id
	 * @return String
	 */
	public String getId_t_slot() {
		return ((String) getAttrVal("Id_t_slot"));
	}
	/**
	 * 计划时间段档案id
	 * @param Id_t_slot
	 */
	public void setId_t_slot(String Id_t_slot) {
		setAttrVal("Id_t_slot", Id_t_slot);
	}
	/**
	 * 计划时间段档案名字
	 * @return String
	 */
	public String getName_t_slot() {
		return ((String) getAttrVal("Name_t_slot"));
	}
	/**
	 * 计划时间段档案名字
	 * @param Name_t_slot
	 */
	public void setName_t_slot(String Name_t_slot) {
		setAttrVal("Name_t_slot", Name_t_slot);
	}
	/**
	 * 时间段开始时间
	 * @return FTime
	 */
	public FTime getT_begin() {
		return ((FTime) getAttrVal("T_begin"));
	}
	/**
	 * 时间段开始时间
	 * @param T_begin
	 */
	public void setT_begin(FTime T_begin) {
		setAttrVal("T_begin", T_begin);
	}
	/**
	 * 时间段结束时间
	 * @return FTime
	 */
	public FTime getT_end() {
		return ((FTime) getAttrVal("T_end"));
	}
	/**
	 * 时间段结束时间
	 * @param T_end
	 */
	public void setT_end(FTime T_end) {
		setAttrVal("T_end", T_end);
	}
	/**
	 * 上一顿执行标识
	 * @return String
	 */
	public String getMplast() {
		return ((String) getAttrVal("Mplast"));
	}
	/**
	 * 上一顿执行标识
	 * @param Mplast
	 */
	public void setMplast(String Mplast) {
		setAttrVal("Mplast", Mplast);
	}
	/**
	 * 服务类型id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}
	/**
	 * 服务类型
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	/**
	 * 执行用法参数
	 * @return String
	 */
	public String getRoute_param() {
		return ((String) getAttrVal("Route_param"));
	}
	/**
	 * 执行用法参数
	 * @param Route_param
	 */
	public void setRoute_param(String Route_param) {
		setAttrVal("Route_param", Route_param);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}
	/**
	 * 服务类型编码
	 * @param Srvtp_code
	 */
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 长临枚举
	 * @return Integer
	 */
	public Integer getEu_long() {
		return ((Integer) getAttrVal("Eu_long"));
	}
	/**
	 * 长临枚举
	 * @param Eu_long
	 */
	public void setEu_long(Integer Eu_long) {
		setAttrVal("Eu_long", Eu_long);
	}
}