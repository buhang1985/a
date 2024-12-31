package iih.mp.nr.outpatskin.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱内容 DTO数据 
 * 
 */
public class ContentOrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 患者性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 患者拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 患者拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
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
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 开立时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 开立医生姓名
	 * @return String
	 */
	public String getName_empor() {
		return ((String) getAttrVal("Name_empor"));
	}
	/**
	 * 开立医生姓名
	 * @param Name_empor
	 */
	public void setName_empor(String Name_empor) {
		setAttrVal("Name_empor", Name_empor);
	}
	/**
	 * 是否已皮试
	 * @return FBoolean
	 */
	public FBoolean getFg_skined() {
		return ((FBoolean) getAttrVal("Fg_skined"));
	}
	/**
	 * 是否已皮试
	 * @param Fg_skined
	 */
	public void setFg_skined(FBoolean Fg_skined) {
		setAttrVal("Fg_skined", Fg_skined);
	}
	/**
	 * 医疗服务
	 * @return FArrayList
	 */
	public FArrayList getOrsrvs() {
		return ((FArrayList) getAttrVal("Orsrvs"));
	}
	/**
	 * 医疗服务
	 * @param Orsrvs
	 */
	public void setOrsrvs(FArrayList Orsrvs) {
		setAttrVal("Orsrvs", Orsrvs);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 皮试结果录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_skintest() {
		return ((FDateTime) getAttrVal("Dt_skintest"));
	}
	/**
	 * 皮试结果录入时间
	 * @param Dt_skintest
	 */
	public void setDt_skintest(FDateTime Dt_skintest) {
		setAttrVal("Dt_skintest", Dt_skintest);
	}
	/**
	 * 皮试表ID
	 * @return String
	 */
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}
	/**
	 * 皮试表ID
	 * @param Id_skintest
	 */
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	/**
	 * 皮试结果ID
	 * @return String
	 */
	public String getId_rst_skintest() {
		return ((String) getAttrVal("Id_rst_skintest"));
	}
	/**
	 * 皮试结果ID
	 * @param Id_rst_skintest
	 */
	public void setId_rst_skintest(String Id_rst_skintest) {
		setAttrVal("Id_rst_skintest", Id_rst_skintest);
	}
	/**
	 * 皮试结果编码
	 * @return String
	 */
	public String getSd_rst_skintest() {
		return ((String) getAttrVal("Sd_rst_skintest"));
	}
	/**
	 * 皮试结果编码
	 * @param Sd_rst_skintest
	 */
	public void setSd_rst_skintest(String Sd_rst_skintest) {
		setAttrVal("Sd_rst_skintest", Sd_rst_skintest);
	}
	/**
	 * 皮试结果名称
	 * @return String
	 */
	public String getName_rstskintest() {
		return ((String) getAttrVal("Name_rstskintest"));
	}
	/**
	 * 皮试结果名称
	 * @param Name_rstskintest
	 */
	public void setName_rstskintest(String Name_rstskintest) {
		setAttrVal("Name_rstskintest", Name_rstskintest);
	}
	/**
	 * 录入人ID
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 录入人ID
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 录入人姓名
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}
	/**
	 * 录入人姓名
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 需计费数量
	 * @return Integer
	 */
	public Integer getNum_bl() {
		return ((Integer) getAttrVal("Num_bl"));
	}
	/**
	 * 需计费数量
	 * @param Num_bl
	 */
	public void setNum_bl(Integer Num_bl) {
		setAttrVal("Num_bl", Num_bl);
	}
	/**
	 * 计账状态
	 * @return String
	 */
	public String getSd_su_bl() {
		return ((String) getAttrVal("Sd_su_bl"));
	}
	/**
	 * 计账状态
	 * @param Sd_su_bl
	 */
	public void setSd_su_bl(String Sd_su_bl) {
		setAttrVal("Sd_su_bl", Sd_su_bl);
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
	 * 确认人ID
	 * @return String
	 */
	public String getId_emp_confirm() {
		return ((String) getAttrVal("Id_emp_confirm"));
	}
	/**
	 * 确认人ID
	 * @param Id_emp_confirm
	 */
	public void setId_emp_confirm(String Id_emp_confirm) {
		setAttrVal("Id_emp_confirm", Id_emp_confirm);
	}
	/**
	 * 确认人名称
	 * @return String
	 */
	public String getName_emp_confirm() {
		return ((String) getAttrVal("Name_emp_confirm"));
	}
	/**
	 * 确认人名称
	 * @param Name_emp_confirm
	 */
	public void setName_emp_confirm(String Name_emp_confirm) {
		setAttrVal("Name_emp_confirm", Name_emp_confirm);
	}
	/**
	 * 修改原因
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}
	/**
	 * 修改原因
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 医疗服务类型id
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 医疗服务类型id
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医疗服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 医疗服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
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
	 * 开立科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 开立科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 皮试录入科室
	 * @return String
	 */
	public String getId_dep_skin() {
		return ((String) getAttrVal("Id_dep_skin"));
	}
	/**
	 * 皮试录入科室
	 * @param Id_dep_skin
	 */
	public void setId_dep_skin(String Id_dep_skin) {
		setAttrVal("Id_dep_skin", Id_dep_skin);
	}
	/**
	 * 皮试录入科室名称
	 * @return String
	 */
	public String getName_dep_skin() {
		return ((String) getAttrVal("Name_dep_skin"));
	}
	/**
	 * 皮试录入科室名称
	 * @param Name_dep_skin
	 */
	public void setName_dep_skin(String Name_dep_skin) {
		setAttrVal("Name_dep_skin", Name_dep_skin);
	}
	/**
	 * 版本信息
	 * @return String
	 */
	public String getSv() {
		return ((String) getAttrVal("Sv"));
	}
	/**
	 * 版本信息
	 * @param Sv
	 */
	public void setSv(String Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 皮试开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_skin_begin() {
		return ((FDateTime) getAttrVal("Dt_skin_begin"));
	}
	/**
	 * 皮试开始时间
	 * @param Dt_skin_begin
	 */
	public void setDt_skin_begin(FDateTime Dt_skin_begin) {
		setAttrVal("Dt_skin_begin", Dt_skin_begin);
	}
}