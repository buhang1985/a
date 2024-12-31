package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊预约查询条件 DTO数据 
 * 
 */
public class OpAptQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 开始时间
	 * @return FDate
	 */
	public FDate getD_b() {
		return ((FDate) getAttrVal("D_b"));
	}
	/**
	 * 开始时间
	 * @param D_b
	 */
	public void setD_b(FDate D_b) {
		setAttrVal("D_b", D_b);
	}
	/**
	 * 结算时间
	 * @return FDate
	 */
	public FDate getD_e() {
		return ((FDate) getAttrVal("D_e"));
	}
	/**
	 * 结算时间
	 * @param D_e
	 */
	public void setD_e(FDate D_e) {
		setAttrVal("D_e", D_e);
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
	 * 排班渠道id
	 * @return String
	 */
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}
	/**
	 * 排班渠道id
	 * @param Id_scchl
	 */
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
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
	 * 自动打印
	 * @return FBoolean
	 */
	public FBoolean getFg_autoprint() {
		return ((FBoolean) getAttrVal("Fg_autoprint"));
	}
	/**
	 * 自动打印
	 * @param Fg_autoprint
	 */
	public void setFg_autoprint(FBoolean Fg_autoprint) {
		setAttrVal("Fg_autoprint", Fg_autoprint);
	}
	/**
	 * 预约状态编码
	 * @return String
	 */
	public String getSd_aptstatus() {
		return ((String) getAttrVal("Sd_aptstatus"));
	}
	/**
	 * 预约状态编码
	 * @param Sd_aptstatus
	 */
	public void setSd_aptstatus(String Sd_aptstatus) {
		setAttrVal("Sd_aptstatus", Sd_aptstatus);
	}
	/**
	 * 预约状态id
	 * @return String
	 */
	public String getId_aptstatus() {
		return ((String) getAttrVal("Id_aptstatus"));
	}
	/**
	 * 预约状态id
	 * @param Id_aptstatus
	 */
	public void setId_aptstatus(String Id_aptstatus) {
		setAttrVal("Id_aptstatus", Id_aptstatus);
	}
	/**
	 * 预约状态名称
	 * @return String
	 */
	public String getName_aptstatus() {
		return ((String) getAttrVal("Name_aptstatus"));
	}
	/**
	 * 预约状态名称
	 * @param Name_aptstatus
	 */
	public void setName_aptstatus(String Name_aptstatus) {
		setAttrVal("Name_aptstatus", Name_aptstatus);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 操作开始日期
	 * @return FDateTime
	 */
	public FDateTime getD_b_appt() {
		return ((FDateTime) getAttrVal("D_b_appt"));
	}
	/**
	 * 操作开始日期
	 * @param D_b_appt
	 */
	public void setD_b_appt(FDateTime D_b_appt) {
		setAttrVal("D_b_appt", D_b_appt);
	}
	/**
	 * 操作结束日期
	 * @return FDateTime
	 */
	public FDateTime getD_e_appt() {
		return ((FDateTime) getAttrVal("D_e_appt"));
	}
	/**
	 * 操作结束日期
	 * @param D_e_appt
	 */
	public void setD_e_appt(FDateTime D_e_appt) {
		setAttrVal("D_e_appt", D_e_appt);
	}
	/**
	 * 午别ID
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别ID
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别名称
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别名称
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
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
	 * 预约号
	 * @return String
	 */
	public String getCode_apt() {
		return ((String) getAttrVal("Code_apt"));
	}
	/**
	 * 预约号
	 * @param Code_apt
	 */
	public void setCode_apt(String Code_apt) {
		setAttrVal("Code_apt", Code_apt);
	}
	/**
	 * 排班渠道名称
	 * @return String
	 */
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}
	/**
	 * 排班渠道名称
	 * @param Name_scchl
	 */
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	/**
	 * 登记人ID
	 * @return String
	 */
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}
	/**
	 * 登记人ID
	 * @param Id_emp_appt
	 */
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	/**
	 * 登记人名称
	 * @return String
	 */
	public String getName_emp_appt() {
		return ((String) getAttrVal("Name_emp_appt"));
	}
	/**
	 * 登记人名称
	 * @param Name_emp_appt
	 */
	public void setName_emp_appt(String Name_emp_appt) {
		setAttrVal("Name_emp_appt", Name_emp_appt);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_appt() {
		return ((String) getAttrVal("Id_dep_appt"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_appt
	 */
	public void setId_dep_appt(String Id_dep_appt) {
		setAttrVal("Id_dep_appt", Id_dep_appt);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getName_dept_appt() {
		return ((String) getAttrVal("Name_dept_appt"));
	}
	/**
	 * 申请科室名称
	 * @param Name_dept_appt
	 */
	public void setName_dept_appt(String Name_dept_appt) {
		setAttrVal("Name_dept_appt", Name_dept_appt);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 门诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_op() {
		return ((FBoolean) getAttrVal("Fg_op"));
	}
	/**
	 * 门诊标志
	 * @param Fg_op
	 */
	public void setFg_op(FBoolean Fg_op) {
		setAttrVal("Fg_op", Fg_op);
	}
	/**
	 * 住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_inhos() {
		return ((FBoolean) getAttrVal("Fg_inhos"));
	}
	/**
	 * 住院标志
	 * @param Fg_inhos
	 */
	public void setFg_inhos(FBoolean Fg_inhos) {
		setAttrVal("Fg_inhos", Fg_inhos);
	}
	/**
	 * 急诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_emg() {
		return ((FBoolean) getAttrVal("Fg_emg"));
	}
	/**
	 * 急诊标志
	 * @param Fg_emg
	 */
	public void setFg_emg(FBoolean Fg_emg) {
		setAttrVal("Fg_emg", Fg_emg);
	}
	/**
	 * 预约备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 预约备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 诊疗项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 诊疗项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 诊疗项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 诊疗项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 诊疗项目类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 诊疗项目类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 预约类型
	 * @return String
	 */
	public String getSd_aptmd() {
		return ((String) getAttrVal("Sd_aptmd"));
	}
	/**
	 * 预约类型
	 * @param Sd_aptmd
	 */
	public void setSd_aptmd(String Sd_aptmd) {
		setAttrVal("Sd_aptmd", Sd_aptmd);
	}
	/**
	 * 申请单编码
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单编码
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 操作开始日期时间
	 * @return FDateTime
	 */
	public FDateTime getD_b_appt_time() {
		return ((FDateTime) getAttrVal("D_b_appt_time"));
	}
	/**
	 * 操作开始日期时间
	 * @param D_b_appt_time
	 */
	public void setD_b_appt_time(FDateTime D_b_appt_time) {
		setAttrVal("D_b_appt_time", D_b_appt_time);
	}
	/**
	 * 操作结束日期时间
	 * @return FDateTime
	 */
	public FDateTime getD_e_appt_time() {
		return ((FDateTime) getAttrVal("D_e_appt_time"));
	}
	/**
	 * 操作结束日期时间
	 * @param D_e_appt_time
	 */
	public void setD_e_appt_time(FDateTime D_e_appt_time) {
		setAttrVal("D_e_appt_time", D_e_appt_time);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 身份证号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 电话号
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 电话号
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 医保号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
}