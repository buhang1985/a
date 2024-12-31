package iih.hp.cp.app.qry.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 临床路径应用信息 DTO数据 
 * 
 */
public class HpCpAppQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊疗计划应用ID
	 * @return String
	 */
	public String getId_cpapp() {
		return ((String) getAttrVal("Id_cpapp"));
	}
	/**
	 * 诊疗计划应用ID
	 * @param Id_cpapp
	 */
	public void setId_cpapp(String Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
	}
	/**
	 * 患者就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 患者就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 患者就诊名称
	 * @return String
	 */
	public String getName_ent() {
		return ((String) getAttrVal("Name_ent"));
	}
	/**
	 * 患者就诊名称
	 * @param Name_ent
	 */
	public void setName_ent(String Name_ent) {
		setAttrVal("Name_ent", Name_ent);
	}
	/**
	 * 诊疗计划ID
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}
	/**
	 * 诊疗计划ID
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	/**
	 * 诊疗计划code
	 * @return String
	 */
	public String getCode_cp() {
		return ((String) getAttrVal("Code_cp"));
	}
	/**
	 * 诊疗计划code
	 * @param Code_cp
	 */
	public void setCode_cp(String Code_cp) {
		setAttrVal("Code_cp", Code_cp);
	}
	/**
	 * 诊疗计划name
	 * @return String
	 */
	public String getName_cp() {
		return ((String) getAttrVal("Name_cp"));
	}
	/**
	 * 诊疗计划name
	 * @param Name_cp
	 */
	public void setName_cp(String Name_cp) {
		setAttrVal("Name_cp", Name_cp);
	}
	/**
	 * 路径版本
	 * @return String
	 */
	public String getCp_version() {
		return ((String) getAttrVal("Cp_version"));
	}
	/**
	 * 路径版本
	 * @param Cp_version
	 */
	public void setCp_version(String Cp_version) {
		setAttrVal("Cp_version", Cp_version);
	}
	/**
	 * 路径状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}
	/**
	 * 路径状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 路径状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 路径状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 路径状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 路径状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 入径时间
	 * @return FDateTime
	 */
	public FDateTime getDt_enter() {
		return ((FDateTime) getAttrVal("Dt_enter"));
	}
	/**
	 * 入径时间
	 * @param Dt_enter
	 */
	public void setDt_enter(FDateTime Dt_enter) {
		setAttrVal("Dt_enter", Dt_enter);
	}
	/**
	 * 入径操作人id
	 * @return String
	 */
	public String getId_emp_enter() {
		return ((String) getAttrVal("Id_emp_enter"));
	}
	/**
	 * 入径操作人id
	 * @param Id_emp_enter
	 */
	public void setId_emp_enter(String Id_emp_enter) {
		setAttrVal("Id_emp_enter", Id_emp_enter);
	}
	/**
	 * 入径操作人code
	 * @return String
	 */
	public String getCode_emp_enter() {
		return ((String) getAttrVal("Code_emp_enter"));
	}
	/**
	 * 入径操作人code
	 * @param Code_emp_enter
	 */
	public void setCode_emp_enter(String Code_emp_enter) {
		setAttrVal("Code_emp_enter", Code_emp_enter);
	}
	/**
	 * 入径操作人name
	 * @return String
	 */
	public String getName_emp_enter() {
		return ((String) getAttrVal("Name_emp_enter"));
	}
	/**
	 * 入径操作人name
	 * @param Name_emp_enter
	 */
	public void setName_emp_enter(String Name_emp_enter) {
		setAttrVal("Name_emp_enter", Name_emp_enter);
	}
	/**
	 * 变异标志
	 * @return FBoolean
	 */
	public FBoolean getFg_alter() {
		return ((FBoolean) getAttrVal("Fg_alter"));
	}
	/**
	 * 变异标志
	 * @param Fg_alter
	 */
	public void setFg_alter(FBoolean Fg_alter) {
		setAttrVal("Fg_alter", Fg_alter);
	}
	/**
	 * 出径时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exit() {
		return ((FDateTime) getAttrVal("Dt_exit"));
	}
	/**
	 * 出径时间
	 * @param Dt_exit
	 */
	public void setDt_exit(FDateTime Dt_exit) {
		setAttrVal("Dt_exit", Dt_exit);
	}
	/**
	 * 出径操作人id
	 * @return String
	 */
	public String getId_emp_exit() {
		return ((String) getAttrVal("Id_emp_exit"));
	}
	/**
	 * 出径操作人id
	 * @param Id_emp_exit
	 */
	public void setId_emp_exit(String Id_emp_exit) {
		setAttrVal("Id_emp_exit", Id_emp_exit);
	}
	/**
	 * 出径操作人code
	 * @return String
	 */
	public String getCode_emp_exit() {
		return ((String) getAttrVal("Code_emp_exit"));
	}
	/**
	 * 出径操作人code
	 * @param Code_emp_exit
	 */
	public void setCode_emp_exit(String Code_emp_exit) {
		setAttrVal("Code_emp_exit", Code_emp_exit);
	}
	/**
	 * 出径操作人name
	 * @return String
	 */
	public String getName_emp_exit() {
		return ((String) getAttrVal("Name_emp_exit"));
	}
	/**
	 * 出径操作人name
	 * @param Name_emp_exit
	 */
	public void setName_emp_exit(String Name_emp_exit) {
		setAttrVal("Name_emp_exit", Name_emp_exit);
	}
	/**
	 * 路径执行天数
	 * @return Integer
	 */
	public Integer getDays_exe() {
		return ((Integer) getAttrVal("Days_exe"));
	}
	/**
	 * 路径执行天数
	 * @param Days_exe
	 */
	public void setDays_exe(Integer Days_exe) {
		setAttrVal("Days_exe", Days_exe);
	}
	/**
	 * 出径原因类型id
	 * @return String
	 */
	public String getId_halt_rsn_tp() {
		return ((String) getAttrVal("Id_halt_rsn_tp"));
	}
	/**
	 * 出径原因类型id
	 * @param Id_halt_rsn_tp
	 */
	public void setId_halt_rsn_tp(String Id_halt_rsn_tp) {
		setAttrVal("Id_halt_rsn_tp", Id_halt_rsn_tp);
	}
	/**
	 * 出径原因类型编码
	 * @return String
	 */
	public String getCode_halt_rsn_tp() {
		return ((String) getAttrVal("Code_halt_rsn_tp"));
	}
	/**
	 * 出径原因类型编码
	 * @param Code_halt_rsn_tp
	 */
	public void setCode_halt_rsn_tp(String Code_halt_rsn_tp) {
		setAttrVal("Code_halt_rsn_tp", Code_halt_rsn_tp);
	}
	/**
	 * 出径原因类型名称
	 * @return String
	 */
	public String getName_halt_rsn_tp() {
		return ((String) getAttrVal("Name_halt_rsn_tp"));
	}
	/**
	 * 出径原因类型名称
	 * @param Name_halt_rsn_tp
	 */
	public void setName_halt_rsn_tp(String Name_halt_rsn_tp) {
		setAttrVal("Name_halt_rsn_tp", Name_halt_rsn_tp);
	}
	/**
	 * 计划所属类型
	 * @return String
	 */
	public String getEu_owtp() {
		return ((String) getAttrVal("Eu_owtp"));
	}
	/**
	 * 计划所属类型
	 * @param Eu_owtp
	 */
	public void setEu_owtp(String Eu_owtp) {
		setAttrVal("Eu_owtp", Eu_owtp);
	}
	/**
	 * 计划所属类型名称
	 * @return String
	 */
	public String getName_owtp() {
		return ((String) getAttrVal("Name_owtp"));
	}
	/**
	 * 计划所属类型名称
	 * @param Name_owtp
	 */
	public void setName_owtp(String Name_owtp) {
		setAttrVal("Name_owtp", Name_owtp);
	}
	/**
	 * 可用范围类型
	 * @return String
	 */
	public String getEu_enbltp() {
		return ((String) getAttrVal("Eu_enbltp"));
	}
	/**
	 * 可用范围类型
	 * @param Eu_enbltp
	 */
	public void setEu_enbltp(String Eu_enbltp) {
		setAttrVal("Eu_enbltp", Eu_enbltp);
	}
	/**
	 * 可用范围类型名称
	 * @return String
	 */
	public String getName_enbltp() {
		return ((String) getAttrVal("Name_enbltp"));
	}
	/**
	 * 可用范围类型名称
	 * @param Name_enbltp
	 */
	public void setName_enbltp(String Name_enbltp) {
		setAttrVal("Name_enbltp", Name_enbltp);
	}
	/**
	 * 所属科室id
	 * @return String
	 */
	public String getId_ow_dep() {
		return ((String) getAttrVal("Id_ow_dep"));
	}
	/**
	 * 所属科室id
	 * @param Id_ow_dep
	 */
	public void setId_ow_dep(String Id_ow_dep) {
		setAttrVal("Id_ow_dep", Id_ow_dep);
	}
	/**
	 * 所属科室code
	 * @return String
	 */
	public String getCode_ow_dep() {
		return ((String) getAttrVal("Code_ow_dep"));
	}
	/**
	 * 所属科室code
	 * @param Code_ow_dep
	 */
	public void setCode_ow_dep(String Code_ow_dep) {
		setAttrVal("Code_ow_dep", Code_ow_dep);
	}
	/**
	 * 所属科室name
	 * @return String
	 */
	public String getName_ow_dep() {
		return ((String) getAttrVal("Name_ow_dep"));
	}
	/**
	 * 所属科室name
	 * @param Name_ow_dep
	 */
	public void setName_ow_dep(String Name_ow_dep) {
		setAttrVal("Name_ow_dep", Name_ow_dep);
	}
	/**
	 * 适用科室id
	 * @return String
	 */
	public String getId_apply_dep() {
		return ((String) getAttrVal("Id_apply_dep"));
	}
	/**
	 * 适用科室id
	 * @param Id_apply_dep
	 */
	public void setId_apply_dep(String Id_apply_dep) {
		setAttrVal("Id_apply_dep", Id_apply_dep);
	}
	/**
	 * 适用科室编码
	 * @return String
	 */
	public String getCode_apply_dep() {
		return ((String) getAttrVal("Code_apply_dep"));
	}
	/**
	 * 适用科室编码
	 * @param Code_apply_dep
	 */
	public void setCode_apply_dep(String Code_apply_dep) {
		setAttrVal("Code_apply_dep", Code_apply_dep);
	}
	/**
	 * 适用科室名称
	 * @return String
	 */
	public String getName_apply_dep() {
		return ((String) getAttrVal("Name_apply_dep"));
	}
	/**
	 * 适用科室名称
	 * @param Name_apply_dep
	 */
	public void setName_apply_dep(String Name_apply_dep) {
		setAttrVal("Name_apply_dep", Name_apply_dep);
	}
	/**
	 * 出径原因描述
	 * @return String
	 */
	public String getReason_desc() {
		return ((String) getAttrVal("Reason_desc"));
	}
	/**
	 * 出径原因描述
	 * @param Reason_desc
	 */
	public void setReason_desc(String Reason_desc) {
		setAttrVal("Reason_desc", Reason_desc);
	}
}