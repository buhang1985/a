package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技已预约申请单 DTO数据 
 * 
 */
public class PisPhkMtAppDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 医技辅预约id
	 * @return String
	 */
	public String getId_aptmt() {
		return ((String) getAttrVal("Id_aptmt"));
	}
	/**
	 * 医技辅预约id
	 * @param Id_aptmt
	 */
	public void setId_aptmt(String Id_aptmt) {
		setAttrVal("Id_aptmt", Id_aptmt);
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
	 * 计划日期
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}
	/**
	 * 计划日期
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dep_apply() {
		return ((String) getAttrVal("Id_dep_apply"));
	}
	/**
	 * 申请科室id
	 * @param Id_dep_apply
	 */
	public void setId_dep_apply(String Id_dep_apply) {
		setAttrVal("Id_dep_apply", Id_dep_apply);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getName_dep_apply() {
		return ((String) getAttrVal("Name_dep_apply"));
	}
	/**
	 * 申请科室名称
	 * @param Name_dep_apply
	 */
	public void setName_dep_apply(String Name_dep_apply) {
		setAttrVal("Name_dep_apply", Name_dep_apply);
	}
	/**
	 * 急诊标识
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}
	/**
	 * 急诊标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别id
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
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
	 * 就诊类型id
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getSd_enttp() {
		return ((String) getAttrVal("Sd_enttp"));
	}
	/**
	 * 就诊类型编码
	 * @param Sd_enttp
	 */
	public void setSd_enttp(String Sd_enttp) {
		setAttrVal("Sd_enttp", Sd_enttp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_enttp() {
		return ((String) getAttrVal("Name_enttp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_enttp
	 */
	public void setName_enttp(String Name_enttp) {
		setAttrVal("Name_enttp", Name_enttp);
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
	 * 医疗服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医嘱项目id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱项目id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医嘱项目名称
	 * @return String
	 */
	public String getName_orsrv() {
		return ((String) getAttrVal("Name_orsrv"));
	}
	/**
	 * 医嘱项目名称
	 * @param Name_orsrv
	 */
	public void setName_orsrv(String Name_orsrv) {
		setAttrVal("Name_orsrv", Name_orsrv);
	}
	/**
	 * 患者出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pa() {
		return ((FDate) getAttrVal("Dt_birth_pa"));
	}
	/**
	 * 患者出生日期
	 * @param Dt_birth_pa
	 */
	public void setDt_birth_pa(FDate Dt_birth_pa) {
		setAttrVal("Dt_birth_pa", Dt_birth_pa);
	}
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 开始时间
	 * @return FDate
	 */
	public FDate getT_b() {
		return ((FDate) getAttrVal("T_b"));
	}
	/**
	 * 开始时间
	 * @param T_b
	 */
	public void setT_b(FDate T_b) {
		setAttrVal("T_b", T_b);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getT_e() {
		return ((FDate) getAttrVal("T_e"));
	}
	/**
	 * 结束时间
	 * @param T_e
	 */
	public void setT_e(FDate T_e) {
		setAttrVal("T_e", T_e);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室id
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
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
	 * 医嘱状态
	 * @return String
	 */
	public String getOr_status() {
		return ((String) getAttrVal("Or_status"));
	}
	/**
	 * 医嘱状态
	 * @param Or_status
	 */
	public void setOr_status(String Or_status) {
		setAttrVal("Or_status", Or_status);
	}
	/**
	 * 照片url
	 * @return String
	 */
	public String getUrl_photo() {
		return ((String) getAttrVal("Url_photo"));
	}
	/**
	 * 照片url
	 * @param Url_photo
	 */
	public void setUrl_photo(String Url_photo) {
		setAttrVal("Url_photo", Url_photo);
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
	 * 排班计划名称
	 * @return String
	 */
	public String getName_scpl() {
		return ((String) getAttrVal("Name_scpl"));
	}
	/**
	 * 排班计划名称
	 * @param Name_scpl
	 */
	public void setName_scpl(String Name_scpl) {
		setAttrVal("Name_scpl", Name_scpl);
	}
	/**
	 * 排班日期
	 * @return String
	 */
	public String getD_sch() {
		return ((String) getAttrVal("D_sch"));
	}
	/**
	 * 排班日期
	 * @param D_sch
	 */
	public void setD_sch(String D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱描述
	 * @return String
	 */
	public String getDesc_or() {
		return ((String) getAttrVal("Desc_or"));
	}
	/**
	 * 医嘱描述
	 * @param Desc_or
	 */
	public void setDesc_or(String Desc_or) {
		setAttrVal("Desc_or", Desc_or);
	}
	/**
	 * 申请医生ID
	 * @return String
	 */
	public String getId_emp_apply() {
		return ((String) getAttrVal("Id_emp_apply"));
	}
	/**
	 * 申请医生ID
	 * @param Id_emp_apply
	 */
	public void setId_emp_apply(String Id_emp_apply) {
		setAttrVal("Id_emp_apply", Id_emp_apply);
	}
	/**
	 * 预约申请ID
	 * @return String
	 */
	public String getId_apt_appl() {
		return ((String) getAttrVal("Id_apt_appl"));
	}
	/**
	 * 预约申请ID
	 * @param Id_apt_appl
	 */
	public void setId_apt_appl(String Id_apt_appl) {
		setAttrVal("Id_apt_appl", Id_apt_appl);
	}
	/**
	 * 医嘱申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 医嘱申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getName_emp_apply() {
		return ((String) getAttrVal("Name_emp_apply"));
	}
	/**
	 * 申请医生
	 * @param Name_emp_apply
	 */
	public void setName_emp_apply(String Name_emp_apply) {
		setAttrVal("Name_emp_apply", Name_emp_apply);
	}
	/**
	 * 计划执行日期
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 计划执行日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
}