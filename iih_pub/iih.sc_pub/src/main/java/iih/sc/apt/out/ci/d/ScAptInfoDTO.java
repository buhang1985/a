package iih.sc.apt.out.ci.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预约信息DTO DTO数据 
 * 
 */
public class ScAptInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约ID
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约ID
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 排班类型编码
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 排班类型编码
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	/**
	 * 预约编码
	 * @return String
	 */
	public String getCode_apt() {
		return ((String) getAttrVal("Code_apt"));
	}
	/**
	 * 预约编码
	 * @param Code_apt
	 */
	public void setCode_apt(String Code_apt) {
		setAttrVal("Code_apt", Code_apt);
	}
	/**
	 * 预约描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 预约描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 预约科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 预约科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 预约科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 预约科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 预约科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 预约科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 日期分组id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 日期分组id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 日期分组
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 日期分组
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 排班资源
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 排班资源
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 排班资源名称
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 排班资源名称
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 排班服务名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 号位
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}
	/**
	 * 号位
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 号段
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}
	/**
	 * 号段
	 * @param Id_ticks
	 */
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
	}
	/**
	 * 票号
	 * @return Integer
	 */
	public Integer getQueno() {
		return ((Integer) getAttrVal("Queno"));
	}
	/**
	 * 票号
	 * @param Queno
	 */
	public void setQueno(Integer Queno) {
		setAttrVal("Queno", Queno);
	}
	/**
	 * 预约操作日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约操作日期时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预计结束日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 预计结束日期时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 预计开始日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 预计开始日期时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 预约渠道
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 预约渠道
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	/**
	 * 预约渠道编码
	 * @return String
	 */
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}
	/**
	 * 预约渠道编码
	 * @param Code_scchl
	 */
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
	/**
	 * 预约渠道名称
	 * @return String
	 */
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}
	/**
	 * 预约渠道名称
	 * @param Name_scchl
	 */
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	/**
	 * 预约操作人员
	 * @return String
	 */
	public String getId_oper_appt() {
		return ((String) getAttrVal("Id_oper_appt"));
	}
	/**
	 * 预约操作人员
	 * @param Id_oper_appt
	 */
	public void setId_oper_appt(String Id_oper_appt) {
		setAttrVal("Id_oper_appt", Id_oper_appt);
	}
	/**
	 * 预约操作人员编码
	 * @return String
	 */
	public String getCode_oper_appt() {
		return ((String) getAttrVal("Code_oper_appt"));
	}
	/**
	 * 预约操作人员编码
	 * @param Code_oper_appt
	 */
	public void setCode_oper_appt(String Code_oper_appt) {
		setAttrVal("Code_oper_appt", Code_oper_appt);
	}
	/**
	 * 预约操作人员姓名
	 * @return String
	 */
	public String getName_oper_appt() {
		return ((String) getAttrVal("Name_oper_appt"));
	}
	/**
	 * 预约操作人员姓名
	 * @param Name_oper_appt
	 */
	public void setName_oper_appt(String Name_oper_appt) {
		setAttrVal("Name_oper_appt", Name_oper_appt);
	}
	/**
	 * 预约状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 预约状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 预约已支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_payment() {
		return ((FBoolean) getAttrVal("Fg_payment"));
	}
	/**
	 * 预约已支付标志
	 * @param Fg_payment
	 */
	public void setFg_payment(FBoolean Fg_payment) {
		setAttrVal("Fg_payment", Fg_payment);
	}
	/**
	 * 预约已通知标志
	 * @return FBoolean
	 */
	public FBoolean getFg_notice() {
		return ((FBoolean) getAttrVal("Fg_notice"));
	}
	/**
	 * 预约已通知标志
	 * @param Fg_notice
	 */
	public void setFg_notice(FBoolean Fg_notice) {
		setAttrVal("Fg_notice", Fg_notice);
	}
	/**
	 * 取消预约标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 取消预约标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 取消日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}
	/**
	 * 取消日期时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 取消预约人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}
	/**
	 * 取消预约人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 取消预约人员编码
	 * @return String
	 */
	public String getCode_emp_canc() {
		return ((String) getAttrVal("Code_emp_canc"));
	}
	/**
	 * 取消预约人员编码
	 * @param Code_emp_canc
	 */
	public void setCode_emp_canc(String Code_emp_canc) {
		setAttrVal("Code_emp_canc", Code_emp_canc);
	}
	/**
	 * 取消预约人员姓名
	 * @return String
	 */
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}
	/**
	 * 取消预约人员姓名
	 * @param Name_emp_canc
	 */
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
	}
	/**
	 * 取消预约已通知标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc_notice() {
		return ((FBoolean) getAttrVal("Fg_canc_notice"));
	}
	/**
	 * 取消预约已通知标志
	 * @param Fg_canc_notice
	 */
	public void setFg_canc_notice(FBoolean Fg_canc_notice) {
		setAttrVal("Fg_canc_notice", Fg_canc_notice);
	}
	/**
	 * 取消预约说明
	 * @return String
	 */
	public String getNote_canc() {
		return ((String) getAttrVal("Note_canc"));
	}
	/**
	 * 取消预约说明
	 * @param Note_canc
	 */
	public void setNote_canc(String Note_canc) {
		setAttrVal("Note_canc", Note_canc);
	}
	/**
	 * 已记费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bill() {
		return ((FBoolean) getAttrVal("Fg_bill"));
	}
	/**
	 * 已记费标志
	 * @param Fg_bill
	 */
	public void setFg_bill(FBoolean Fg_bill) {
		setAttrVal("Fg_bill", Fg_bill);
	}
	/**
	 * 改约id
	 * @return String
	 */
	public String getId_scapt_cancto() {
		return ((String) getAttrVal("Id_scapt_cancto"));
	}
	/**
	 * 改约id
	 * @param Id_scapt_cancto
	 */
	public void setId_scapt_cancto(String Id_scapt_cancto) {
		setAttrVal("Id_scapt_cancto", Id_scapt_cancto);
	}
	/**
	 * 手术台id
	 * @return String
	 */
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}
	/**
	 * 手术台id
	 * @param Id_opt
	 */
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
	/**
	 * 手术台编码
	 * @return String
	 */
	public String getCode_opt() {
		return ((String) getAttrVal("Code_opt"));
	}
	/**
	 * 手术台编码
	 * @param Code_opt
	 */
	public void setCode_opt(String Code_opt) {
		setAttrVal("Code_opt", Code_opt);
	}
	/**
	 * 手术台名称
	 * @return String
	 */
	public String getName_opt() {
		return ((String) getAttrVal("Name_opt"));
	}
	/**
	 * 手术台名称
	 * @param Name_opt
	 */
	public void setName_opt(String Name_opt) {
		setAttrVal("Name_opt", Name_opt);
	}
}