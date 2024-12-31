package iih.mp.ot.dto.confirm.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技确认医嘱信息 DTO数据 
 * 
 */
public class MpOtOrInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getNo() {
		return ((Integer) getAttrVal("No"));
	}
	/**
	 * 序号
	 * @param No
	 */
	public void setNo(Integer No) {
		setAttrVal("No", No);
	}
	/**
	 * 申请日期
	 * @return FDate
	 */
	public FDate getDt_apply() {
		return ((FDate) getAttrVal("Dt_apply"));
	}
	/**
	 * 申请日期
	 * @param Dt_apply
	 */
	public void setDt_apply(FDate Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	/**
	 * 急诊
	 * @return FBoolean
	 */
	public FBoolean getFg_ur() {
		return ((FBoolean) getAttrVal("Fg_ur"));
	}
	/**
	 * 急诊
	 * @param Fg_ur
	 */
	public void setFg_ur(FBoolean Fg_ur) {
		setAttrVal("Fg_ur", Fg_ur);
	}
	/**
	 * 婴儿
	 * @return FBoolean
	 */
	public FBoolean getFg_baby() {
		return ((FBoolean) getAttrVal("Fg_baby"));
	}
	/**
	 * 婴儿
	 * @param Fg_baby
	 */
	public void setFg_baby(FBoolean Fg_baby) {
		setAttrVal("Fg_baby", Fg_baby);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}
	/**
	 * 申请单号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getDes_order() {
		return ((String) getAttrVal("Des_order"));
	}
	/**
	 * 医嘱内容
	 * @param Des_order
	 */
	public void setDes_order(String Des_order) {
		setAttrVal("Des_order", Des_order);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getState() {
		return ((String) getAttrVal("State"));
	}
	/**
	 * 状态
	 * @param State
	 */
	public void setState(String State) {
		setAttrVal("State", State);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 申请科室
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 申请医生id
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 申请医生id
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 申请医生
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 部位描述
	 * @return String
	 */
	public String getDes_parts() {
		return ((String) getAttrVal("Des_parts"));
	}
	/**
	 * 部位描述
	 * @param Des_parts
	 */
	public void setDes_parts(String Des_parts) {
		setAttrVal("Des_parts", Des_parts);
	}
	/**
	 * 诊断信息
	 * @return String
	 */
	public String getDes_di() {
		return ((String) getAttrVal("Des_di"));
	}
	/**
	 * 诊断信息
	 * @param Des_di
	 */
	public void setDes_di(String Des_di) {
		setAttrVal("Des_di", Des_di);
	}
	/**
	 * 医嘱执行id
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 医嘱执行id
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 时间标志
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 时间标志
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 费用信息
	 * @return FArrayList
	 */
	public FArrayList getInfo_bl() {
		return ((FArrayList) getAttrVal("Info_bl"));
	}
	/**
	 * 费用信息
	 * @param Info_bl
	 */
	public void setInfo_bl(FArrayList Info_bl) {
		setAttrVal("Info_bl", Info_bl);
	}
}