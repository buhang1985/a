package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预住院就诊管理dto DTO数据 
 * 
 */
public class EnIppreInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
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
	 * 民族id
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}
	/**
	 * 民族id
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getNation() {
		return ((String) getAttrVal("Nation"));
	}
	/**
	 * 民族
	 * @param Nation
	 */
	public void setNation(String Nation) {
		setAttrVal("Nation", Nation);
	}
	/**
	 * 婚姻id
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}
	/**
	 * 婚姻id
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getMarry() {
		return ((String) getAttrVal("Marry"));
	}
	/**
	 * 婚姻
	 * @param Marry
	 */
	public void setMarry(String Marry) {
		setAttrVal("Marry", Marry);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 门诊医生
	 * @return String
	 */
	public String getName_emp_opapply() {
		return ((String) getAttrVal("Name_emp_opapply"));
	}
	/**
	 * 门诊医生
	 * @param Name_emp_opapply
	 */
	public void setName_emp_opapply(String Name_emp_opapply) {
		setAttrVal("Name_emp_opapply", Name_emp_opapply);
	}
	/**
	 * 门诊医生ID
	 * @return String
	 */
	public String getId_emp_opapply() {
		return ((String) getAttrVal("Id_emp_opapply"));
	}
	/**
	 * 门诊医生ID
	 * @param Id_emp_opapply
	 */
	public void setId_emp_opapply(String Id_emp_opapply) {
		setAttrVal("Id_emp_opapply", Id_emp_opapply);
	}
	/**
	 * 责任护士ID
	 * @return String
	 */
	public String getId_emp_nurse() {
		return ((String) getAttrVal("Id_emp_nurse"));
	}
	/**
	 * 责任护士ID
	 * @param Id_emp_nurse
	 */
	public void setId_emp_nurse(String Id_emp_nurse) {
		setAttrVal("Id_emp_nurse", Id_emp_nurse);
	}
	/**
	 * 责任护士
	 * @return String
	 */
	public String getName_emp_nurse() {
		return ((String) getAttrVal("Name_emp_nurse"));
	}
	/**
	 * 责任护士
	 * @param Name_emp_nurse
	 */
	public void setName_emp_nurse(String Name_emp_nurse) {
		setAttrVal("Name_emp_nurse", Name_emp_nurse);
	}
	/**
	 * 床位id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 入院登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院登记时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getExit_times() {
		return ((FDateTime) getAttrVal("Exit_times"));
	}
	/**
	 * 出院时间
	 * @param Exit_times
	 */
	public void setExit_times(FDateTime Exit_times) {
		setAttrVal("Exit_times", Exit_times);
	}
	/**
	 * 预住院科室id
	 * @return String
	 */
	public String getCur_id_dep_phy() {
		return ((String) getAttrVal("Cur_id_dep_phy"));
	}
	/**
	 * 预住院科室id
	 * @param Cur_id_dep_phy
	 */
	public void setCur_id_dep_phy(String Cur_id_dep_phy) {
		setAttrVal("Cur_id_dep_phy", Cur_id_dep_phy);
	}
	/**
	 * 预住院科室
	 * @return String
	 */
	public String getCur_name_dep_phy() {
		return ((String) getAttrVal("Cur_name_dep_phy"));
	}
	/**
	 * 预住院科室
	 * @param Cur_name_dep_phy
	 */
	public void setCur_name_dep_phy(String Cur_name_dep_phy) {
		setAttrVal("Cur_name_dep_phy", Cur_name_dep_phy);
	}
	/**
	 * 预住院病区id
	 * @return String
	 */
	public String getCur_id_dep_nur() {
		return ((String) getAttrVal("Cur_id_dep_nur"));
	}
	/**
	 * 预住院病区id
	 * @param Cur_id_dep_nur
	 */
	public void setCur_id_dep_nur(String Cur_id_dep_nur) {
		setAttrVal("Cur_id_dep_nur", Cur_id_dep_nur);
	}
	/**
	 * 预住院病区
	 * @return String
	 */
	public String getCur_name_dep_nur() {
		return ((String) getAttrVal("Cur_name_dep_nur"));
	}
	/**
	 * 预住院病区
	 * @param Cur_name_dep_nur
	 */
	public void setCur_name_dep_nur(String Cur_name_dep_nur) {
		setAttrVal("Cur_name_dep_nur", Cur_name_dep_nur);
	}
	/**
	 * 当前科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 当前科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 当前科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 当前科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 当前病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 当前病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 当前病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 当前病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 入院科室id
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室id
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 入院病区id
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}
	/**
	 * 入院病区id
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getName_dep_nuradm() {
		return ((String) getAttrVal("Name_dep_nuradm"));
	}
	/**
	 * 入院病区
	 * @param Name_dep_nuradm
	 */
	public void setName_dep_nuradm(String Name_dep_nuradm) {
		setAttrVal("Name_dep_nuradm", Name_dep_nuradm);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getExit_name_dep_phy() {
		return ((String) getAttrVal("Exit_name_dep_phy"));
	}
	/**
	 * 出院科室
	 * @param Exit_name_dep_phy
	 */
	public void setExit_name_dep_phy(String Exit_name_dep_phy) {
		setAttrVal("Exit_name_dep_phy", Exit_name_dep_phy);
	}
	/**
	 * 出院科室id
	 * @return String
	 */
	public String getExit_id_dep_phy() {
		return ((String) getAttrVal("Exit_id_dep_phy"));
	}
	/**
	 * 出院科室id
	 * @param Exit_id_dep_phy
	 */
	public void setExit_id_dep_phy(String Exit_id_dep_phy) {
		setAttrVal("Exit_id_dep_phy", Exit_id_dep_phy);
	}
	/**
	 * 出院病区
	 * @return String
	 */
	public String getExit_name_dep_nur() {
		return ((String) getAttrVal("Exit_name_dep_nur"));
	}
	/**
	 * 出院病区
	 * @param Exit_name_dep_nur
	 */
	public void setExit_name_dep_nur(String Exit_name_dep_nur) {
		setAttrVal("Exit_name_dep_nur", Exit_name_dep_nur);
	}
	/**
	 * 出院病区id
	 * @return String
	 */
	public String getExit_id_dep_nur() {
		return ((String) getAttrVal("Exit_id_dep_nur"));
	}
	/**
	 * 出院病区id
	 * @param Exit_id_dep_nur
	 */
	public void setExit_id_dep_nur(String Exit_id_dep_nur) {
		setAttrVal("Exit_id_dep_nur", Exit_id_dep_nur);
	}
	/**
	 * 转出科室id
	 * @return String
	 */
	public String getId_dep_from() {
		return ((String) getAttrVal("Id_dep_from"));
	}
	/**
	 * 转出科室id
	 * @param Id_dep_from
	 */
	public void setId_dep_from(String Id_dep_from) {
		setAttrVal("Id_dep_from", Id_dep_from);
	}
	/**
	 * 转出科室
	 * @return String
	 */
	public String getName_dep_from() {
		return ((String) getAttrVal("Name_dep_from"));
	}
	/**
	 * 转出科室
	 * @param Name_dep_from
	 */
	public void setName_dep_from(String Name_dep_from) {
		setAttrVal("Name_dep_from", Name_dep_from);
	}
	/**
	 * 转出病区id
	 * @return String
	 */
	public String getId_dep_nur_from() {
		return ((String) getAttrVal("Id_dep_nur_from"));
	}
	/**
	 * 转出病区id
	 * @param Id_dep_nur_from
	 */
	public void setId_dep_nur_from(String Id_dep_nur_from) {
		setAttrVal("Id_dep_nur_from", Id_dep_nur_from);
	}
	/**
	 * 转出病区
	 * @return String
	 */
	public String getName_dep_nur_from() {
		return ((String) getAttrVal("Name_dep_nur_from"));
	}
	/**
	 * 转出病区
	 * @param Name_dep_nur_from
	 */
	public void setName_dep_nur_from(String Name_dep_nur_from) {
		setAttrVal("Name_dep_nur_from", Name_dep_nur_from);
	}
	/**
	 * 入科时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入科时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 检查完成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_done_mt() {
		return ((FBoolean) getAttrVal("Fg_done_mt"));
	}
	/**
	 * 检查完成标志
	 * @param Fg_done_mt
	 */
	public void setFg_done_mt(FBoolean Fg_done_mt) {
		setAttrVal("Fg_done_mt", Fg_done_mt);
	}
	/**
	 * 麻醉评估通过标志
	 * @return FBoolean
	 */
	public FBoolean getFg_done_anest() {
		return ((FBoolean) getAttrVal("Fg_done_anest"));
	}
	/**
	 * 麻醉评估通过标志
	 * @param Fg_done_anest
	 */
	public void setFg_done_anest(FBoolean Fg_done_anest) {
		setAttrVal("Fg_done_anest", Fg_done_anest);
	}
	/**
	 * 入院审核标志
	 * @return FBoolean
	 */
	public FBoolean getFg_done_dep() {
		return ((FBoolean) getAttrVal("Fg_done_dep"));
	}
	/**
	 * 入院审核标志
	 * @param Fg_done_dep
	 */
	public void setFg_done_dep(FBoolean Fg_done_dep) {
		setAttrVal("Fg_done_dep", Fg_done_dep);
	}
	/**
	 * 床位预约标志
	 * @return FBoolean
	 */
	public FBoolean getFg_done_bed() {
		return ((FBoolean) getAttrVal("Fg_done_bed"));
	}
	/**
	 * 床位预约标志
	 * @param Fg_done_bed
	 */
	public void setFg_done_bed(FBoolean Fg_done_bed) {
		setAttrVal("Fg_done_bed", Fg_done_bed);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel_nopat() {
		return ((String) getAttrVal("Tel_nopat"));
	}
	/**
	 * 电话
	 * @param Tel_nopat
	 */
	public void setTel_nopat(String Tel_nopat) {
		setAttrVal("Tel_nopat", Tel_nopat);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 转出
	 * @return FBoolean
	 */
	public FBoolean getFg_transdep() {
		return ((FBoolean) getAttrVal("Fg_transdep"));
	}
	/**
	 * 转出
	 * @param Fg_transdep
	 */
	public void setFg_transdep(FBoolean Fg_transdep) {
		setAttrVal("Fg_transdep", Fg_transdep);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getCur_addr_pat() {
		return ((String) getAttrVal("Cur_addr_pat"));
	}
	/**
	 * 现住址
	 * @param Cur_addr_pat
	 */
	public void setCur_addr_pat(String Cur_addr_pat) {
		setAttrVal("Cur_addr_pat", Cur_addr_pat);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
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
	 * 是否结算
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 是否结算
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 床位状态
	 * @return String
	 */
	public String getSd_bedsu() {
		return ((String) getAttrVal("Sd_bedsu"));
	}
	/**
	 * 床位状态
	 * @param Sd_bedsu
	 */
	public void setSd_bedsu(String Sd_bedsu) {
		setAttrVal("Sd_bedsu", Sd_bedsu);
	}
	/**
	 * 新床位id
	 * @return String
	 */
	public String getId_bed_new() {
		return ((String) getAttrVal("Id_bed_new"));
	}
	/**
	 * 新床位id
	 * @param Id_bed_new
	 */
	public void setId_bed_new(String Id_bed_new) {
		setAttrVal("Id_bed_new", Id_bed_new);
	}
	/**
	 * 新床位编码
	 * @return String
	 */
	public String getSd_bed_new() {
		return ((String) getAttrVal("Sd_bed_new"));
	}
	/**
	 * 新床位编码
	 * @param Sd_bed_new
	 */
	public void setSd_bed_new(String Sd_bed_new) {
		setAttrVal("Sd_bed_new", Sd_bed_new);
	}
	/**
	 * 新床位名称
	 * @return String
	 */
	public String getName_bed_new() {
		return ((String) getAttrVal("Name_bed_new"));
	}
	/**
	 * 新床位名称
	 * @param Name_bed_new
	 */
	public void setName_bed_new(String Name_bed_new) {
		setAttrVal("Name_bed_new", Name_bed_new);
	}
	/**
	 * 医嘱检查状态
	 * @return Integer
	 */
	public Integer getStatus_or() {
		return ((Integer) getAttrVal("Status_or"));
	}
	/**
	 * 医嘱检查状态
	 * @param Status_or
	 */
	public void setStatus_or(Integer Status_or) {
		setAttrVal("Status_or", Status_or);
	}
	/**
	 * 医嘱检查状态名称
	 * @return String
	 */
	public String getName_status_or() {
		return ((String) getAttrVal("Name_status_or"));
	}
	/**
	 * 医嘱检查状态名称
	 * @param Name_status_or
	 */
	public void setName_status_or(String Name_status_or) {
		setAttrVal("Name_status_or", Name_status_or);
	}
	/**
	 * 执行检查状态
	 * @return Integer
	 */
	public Integer getStatus_mp() {
		return ((Integer) getAttrVal("Status_mp"));
	}
	/**
	 * 执行检查状态
	 * @param Status_mp
	 */
	public void setStatus_mp(Integer Status_mp) {
		setAttrVal("Status_mp", Status_mp);
	}
	/**
	 * 执行检查状态名称
	 * @return String
	 */
	public String getName_status_mp() {
		return ((String) getAttrVal("Name_status_mp"));
	}
	/**
	 * 执行检查状态名称
	 * @param Name_status_mp
	 */
	public void setName_status_mp(String Name_status_mp) {
		setAttrVal("Name_status_mp", Name_status_mp);
	}
	/**
	 * 药品检查状态
	 * @return Integer
	 */
	public Integer getStatus_med() {
		return ((Integer) getAttrVal("Status_med"));
	}
	/**
	 * 药品检查状态
	 * @param Status_med
	 */
	public void setStatus_med(Integer Status_med) {
		setAttrVal("Status_med", Status_med);
	}
	/**
	 * 药品检查状态名称
	 * @return String
	 */
	public String getName_status_med() {
		return ((String) getAttrVal("Name_status_med"));
	}
	/**
	 * 药品检查状态名称
	 * @param Name_status_med
	 */
	public void setName_status_med(String Name_status_med) {
		setAttrVal("Name_status_med", Name_status_med);
	}
	/**
	 * 医技检查状态
	 * @return Integer
	 */
	public Integer getStatus_tech() {
		return ((Integer) getAttrVal("Status_tech"));
	}
	/**
	 * 医技检查状态
	 * @param Status_tech
	 */
	public void setStatus_tech(Integer Status_tech) {
		setAttrVal("Status_tech", Status_tech);
	}
	/**
	 * 医技检查状态名称
	 * @return String
	 */
	public String getName_status_tech() {
		return ((String) getAttrVal("Name_status_tech"));
	}
	/**
	 * 医技检查状态名称
	 * @param Name_status_tech
	 */
	public void setName_status_tech(String Name_status_tech) {
		setAttrVal("Name_status_tech", Name_status_tech);
	}
	/**
	 * 其他检查状态
	 * @return Integer
	 */
	public Integer getStatus_other() {
		return ((Integer) getAttrVal("Status_other"));
	}
	/**
	 * 其他检查状态
	 * @param Status_other
	 */
	public void setStatus_other(Integer Status_other) {
		setAttrVal("Status_other", Status_other);
	}
	/**
	 * 其他检查状态名称
	 * @return String
	 */
	public String getName_status_other() {
		return ((String) getAttrVal("Name_status_other"));
	}
	/**
	 * 其他检查状态名称
	 * @param Name_status_other
	 */
	public void setName_status_other(String Name_status_other) {
		setAttrVal("Name_status_other", Name_status_other);
	}
	/**
	 * 费用检查状态
	 * @return Integer
	 */
	public Integer getStatus_bl() {
		return ((Integer) getAttrVal("Status_bl"));
	}
	/**
	 * 费用检查状态
	 * @param Status_bl
	 */
	public void setStatus_bl(Integer Status_bl) {
		setAttrVal("Status_bl", Status_bl);
	}
	/**
	 * 费用检查状态名称
	 * @return String
	 */
	public String getName_status_bl() {
		return ((String) getAttrVal("Name_status_bl"));
	}
	/**
	 * 费用检查状态名称
	 * @param Name_status_bl
	 */
	public void setName_status_bl(String Name_status_bl) {
		setAttrVal("Name_status_bl", Name_status_bl);
	}
	/**
	 * 转科时间
	 * @return String
	 */
	public String getDt_trans() {
		return ((String) getAttrVal("Dt_trans"));
	}
	/**
	 * 转科时间
	 * @param Dt_trans
	 */
	public void setDt_trans(String Dt_trans) {
		setAttrVal("Dt_trans", Dt_trans);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}
	/**
	 * 登记人
	 * @param Name_emp_entry
	 */
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
	}
	/**
	 * 预住院时间
	 * @return String
	 */
	public String getDt_acpt_ippre() {
		return ((String) getAttrVal("Dt_acpt_ippre"));
	}
	/**
	 * 预住院时间
	 * @param Dt_acpt_ippre
	 */
	public void setDt_acpt_ippre(String Dt_acpt_ippre) {
		setAttrVal("Dt_acpt_ippre", Dt_acpt_ippre);
	}
	/**
	 * 预住院人
	 * @return String
	 */
	public String getName_emp_ippre() {
		return ((String) getAttrVal("Name_emp_ippre"));
	}
	/**
	 * 预住院人
	 * @param Name_emp_ippre
	 */
	public void setName_emp_ippre(String Name_emp_ippre) {
		setAttrVal("Name_emp_ippre", Name_emp_ippre);
	}
	/**
	 * 登记人id
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}
	/**
	 * 登记人id
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 就诊状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 就诊状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 预住院人id
	 * @return String
	 */
	public String getId_emp_ippre() {
		return ((String) getAttrVal("Id_emp_ippre"));
	}
	/**
	 * 预住院人id
	 * @param Id_emp_ippre
	 */
	public void setId_emp_ippre(String Id_emp_ippre) {
		setAttrVal("Id_emp_ippre", Id_emp_ippre);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 最后一次责任护士id
	 * @return String
	 */
	public String getId_emp_nur_last() {
		return ((String) getAttrVal("Id_emp_nur_last"));
	}
	/**
	 * 最后一次责任护士id
	 * @param Id_emp_nur_last
	 */
	public void setId_emp_nur_last(String Id_emp_nur_last) {
		setAttrVal("Id_emp_nur_last", Id_emp_nur_last);
	}
	/**
	 * 最后一次责任护士名称
	 * @return String
	 */
	public String getName_emp_nur_last() {
		return ((String) getAttrVal("Name_emp_nur_last"));
	}
	/**
	 * 最后一次责任护士名称
	 * @param Name_emp_nur_last
	 */
	public void setName_emp_nur_last(String Name_emp_nur_last) {
		setAttrVal("Name_emp_nur_last", Name_emp_nur_last);
	}
	/**
	 * 住院类别
	 * @return String
	 */
	public String getName_ipkind() {
		return ((String) getAttrVal("Name_ipkind"));
	}
	/**
	 * 住院类别
	 * @param Name_ipkind
	 */
	public void setName_ipkind(String Name_ipkind) {
		setAttrVal("Name_ipkind", Name_ipkind);
	}
	/**
	 * 门诊诊断
	 * @return String
	 */
	public String getName_didef_op() {
		return ((String) getAttrVal("Name_didef_op"));
	}
	/**
	 * 门诊诊断
	 * @param Name_didef_op
	 */
	public void setName_didef_op(String Name_didef_op) {
		setAttrVal("Name_didef_op", Name_didef_op);
	}
}