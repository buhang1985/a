package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 所有住院信息DTO DTO数据 
 * 
 */
public class IpRegAllInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 姓名
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
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 就诊编号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
	 * 入院病区code
	 * @return String
	 */
	public String getCode_dep_phy() {
		return ((String) getAttrVal("Code_dep_phy"));
	}
	/**
	 * 入院病区code
	 * @param Code_dep_phy
	 */
	public void setCode_dep_phy(String Code_dep_phy) {
		setAttrVal("Code_dep_phy", Code_dep_phy);
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
	 * 当前病区code
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}
	/**
	 * 当前病区code
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
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
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 登记人员id
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}
	/**
	 * 登记人员id
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 登记人员
	 * @return String
	 */
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}
	/**
	 * 登记人员
	 * @param Name_emp_entry
	 */
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 医保id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保类型
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 状态sd
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 状态sd
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 退院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_discharge() {
		return ((FBoolean) getAttrVal("Fg_discharge"));
	}
	/**
	 * 退院标识
	 * @param Fg_discharge
	 */
	public void setFg_discharge(FBoolean Fg_discharge) {
		setAttrVal("Fg_discharge", Fg_discharge);
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
	 * 出生日期(时分秒)
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_hms() {
		return ((FDateTime) getAttrVal("Dt_birth_hms"));
	}
	/**
	 * 出生日期(时分秒)
	 * @param Dt_birth_hms
	 */
	public void setDt_birth_hms(FDateTime Dt_birth_hms) {
		setAttrVal("Dt_birth_hms", Dt_birth_hms);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}
	/**
	 * 电话
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 门诊医生id
	 * @return String
	 */
	public String getId_emp_phy_op() {
		return ((String) getAttrVal("Id_emp_phy_op"));
	}
	/**
	 * 门诊医生id
	 * @param Id_emp_phy_op
	 */
	public void setId_emp_phy_op(String Id_emp_phy_op) {
		setAttrVal("Id_emp_phy_op", Id_emp_phy_op);
	}
	/**
	 * 门诊医生
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}
	/**
	 * 门诊医生
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 结算标志
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 在院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标志
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 转科时间
	 * @return FDateTime
	 */
	public FDateTime getDt_tran() {
		return ((FDateTime) getAttrVal("Dt_tran"));
	}
	/**
	 * 转科时间
	 * @param Dt_tran
	 */
	public void setDt_tran(FDateTime Dt_tran) {
		setAttrVal("Dt_tran", Dt_tran);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}
	/**
	 * 诊断
	 * @param Id_didef_dis
	 */
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 *  家庭住址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 *  家庭住址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 是否死亡
	 * @return FBoolean
	 */
	public FBoolean getFg_death() {
		return ((FBoolean) getAttrVal("Fg_death"));
	}
	/**
	 * 是否死亡
	 * @param Fg_death
	 */
	public void setFg_death(FBoolean Fg_death) {
		setAttrVal("Fg_death", Fg_death);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getName_dep_out() {
		return ((String) getAttrVal("Name_dep_out"));
	}
	/**
	 * 出院科室
	 * @param Name_dep_out
	 */
	public void setName_dep_out(String Name_dep_out) {
		setAttrVal("Name_dep_out", Name_dep_out);
	}
	/**
	 * 出院科室id
	 * @return String
	 */
	public String getId_dep_out() {
		return ((String) getAttrVal("Id_dep_out"));
	}
	/**
	 * 出院科室id
	 * @param Id_dep_out
	 */
	public void setId_dep_out(String Id_dep_out) {
		setAttrVal("Id_dep_out", Id_dep_out);
	}
	/**
	 * 出院病区
	 * @return String
	 */
	public String getName_dep_nur_out() {
		return ((String) getAttrVal("Name_dep_nur_out"));
	}
	/**
	 * 出院病区
	 * @param Name_dep_nur_out
	 */
	public void setName_dep_nur_out(String Name_dep_nur_out) {
		setAttrVal("Name_dep_nur_out", Name_dep_nur_out);
	}
	/**
	 * 出院病区id
	 * @return String
	 */
	public String getId_dep_nur_out() {
		return ((String) getAttrVal("Id_dep_nur_out"));
	}
	/**
	 * 出院病区id
	 * @param Id_dep_nur_out
	 */
	public void setId_dep_nur_out(String Id_dep_nur_out) {
		setAttrVal("Id_dep_nur_out", Id_dep_nur_out);
	}
	/**
	 * 患者分类_本次
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类_本次
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 查询入院时间左边界
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_qry_left() {
		return ((FDateTime) getAttrVal("Dt_entry_qry_left"));
	}
	/**
	 * 查询入院时间左边界
	 * @param Dt_entry_qry_left
	 */
	public void setDt_entry_qry_left(FDateTime Dt_entry_qry_left) {
		setAttrVal("Dt_entry_qry_left", Dt_entry_qry_left);
	}
	/**
	 * 查询入院时间右边界
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_qry_right() {
		return ((FDateTime) getAttrVal("Dt_entry_qry_right"));
	}
	/**
	 * 查询入院时间右边界
	 * @param Dt_entry_qry_right
	 */
	public void setDt_entry_qry_right(FDateTime Dt_entry_qry_right) {
		setAttrVal("Dt_entry_qry_right", Dt_entry_qry_right);
	}
	/**
	 * 查询出院时间左边界
	 * @return FDateTime
	 */
	public FDateTime getDt_end_qry_left() {
		return ((FDateTime) getAttrVal("Dt_end_qry_left"));
	}
	/**
	 * 查询出院时间左边界
	 * @param Dt_end_qry_left
	 */
	public void setDt_end_qry_left(FDateTime Dt_end_qry_left) {
		setAttrVal("Dt_end_qry_left", Dt_end_qry_left);
	}
	/**
	 * 查询出院时间右边界
	 * @return FDateTime
	 */
	public FDateTime getDt_end_qry_right() {
		return ((FDateTime) getAttrVal("Dt_end_qry_right"));
	}
	/**
	 * 查询出院时间右边界
	 * @param Dt_end_qry_right
	 */
	public void setDt_end_qry_right(FDateTime Dt_end_qry_right) {
		setAttrVal("Dt_end_qry_right", Dt_end_qry_right);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}
	/**
	 * 手术名称
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getDoc_resp() {
		return ((String) getAttrVal("Doc_resp"));
	}
	/**
	 * 责任医生
	 * @param Doc_resp
	 */
	public void setDoc_resp(String Doc_resp) {
		setAttrVal("Doc_resp", Doc_resp);
	}
	/**
	 * 入科时间左界
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt_left() {
		return ((FDateTime) getAttrVal("Dt_acpt_left"));
	}
	/**
	 * 入科时间左界
	 * @param Dt_acpt_left
	 */
	public void setDt_acpt_left(FDateTime Dt_acpt_left) {
		setAttrVal("Dt_acpt_left", Dt_acpt_left);
	}
	/**
	 * 入科时间右界
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt_right() {
		return ((FDateTime) getAttrVal("Dt_acpt_right"));
	}
	/**
	 * 入科时间右界
	 * @param Dt_acpt_right
	 */
	public void setDt_acpt_right(FDateTime Dt_acpt_right) {
		setAttrVal("Dt_acpt_right", Dt_acpt_right);
	}
	/**
	 * 死亡时间
	 * @return String
	 */
	public String getDt_death() {
		return ((String) getAttrVal("Dt_death"));
	}
	/**
	 * 死亡时间
	 * @param Dt_death
	 */
	public void setDt_death(String Dt_death) {
		setAttrVal("Dt_death", Dt_death);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
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
	 * 护理等级
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}
	/**
	 * 护理等级
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}
	/**
	 * 护理级别
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 护理名称
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}
	/**
	 * 护理名称
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
	}
	/**
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
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
	 * 患者分类编码
	 * @return String
	 */
	public String getSd_patca() {
		return ((String) getAttrVal("Sd_patca"));
	}
	/**
	 * 患者分类编码
	 * @param Sd_patca
	 */
	public void setSd_patca(String Sd_patca) {
		setAttrVal("Sd_patca", Sd_patca);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 患者价格分类name
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 患者价格分类name
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 患者价格分类编码
	 * @return String
	 */
	public String getSd_pripat() {
		return ((String) getAttrVal("Sd_pripat"));
	}
	/**
	 * 患者价格分类编码
	 * @param Sd_pripat
	 */
	public void setSd_pripat(String Sd_pripat) {
		setAttrVal("Sd_pripat", Sd_pripat);
	}
	/**
	 * 住院天数
	 * @return String
	 */
	public String getDays_ip() {
		return ((String) getAttrVal("Days_ip"));
	}
	/**
	 * 住院天数
	 * @param Days_ip
	 */
	public void setDays_ip(String Days_ip) {
		setAttrVal("Days_ip", Days_ip);
	}
	/**
	 * 黑名单记录次数
	 * @return Integer
	 */
	public Integer getCount_bbr() {
		return ((Integer) getAttrVal("Count_bbr"));
	}
	/**
	 * 黑名单记录次数
	 * @param Count_bbr
	 */
	public void setCount_bbr(Integer Count_bbr) {
		setAttrVal("Count_bbr", Count_bbr);
	}
	/**
	 * 黑名单标识
	 * @return String
	 */
	public String getFg_bbr() {
		return ((String) getAttrVal("Fg_bbr"));
	}
	/**
	 * 黑名单标识
	 * @param Fg_bbr
	 */
	public void setFg_bbr(String Fg_bbr) {
		setAttrVal("Fg_bbr", Fg_bbr);
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
	 * 支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_payedf() {
		return ((FBoolean) getAttrVal("Fg_payedf"));
	}
	/**
	 * 支付标志
	 * @param Fg_payedf
	 */
	public void setFg_payedf(FBoolean Fg_payedf) {
		setAttrVal("Fg_payedf", Fg_payedf);
	}
	/**
	 * 结算人员
	 * @return String
	 */
	public String getName_psn_st() {
		return ((String) getAttrVal("Name_psn_st"));
	}
	/**
	 * 结算人员
	 * @param Name_psn_st
	 */
	public void setName_psn_st(String Name_psn_st) {
		setAttrVal("Name_psn_st", Name_psn_st);
	}
	/**
	 * 结算人员id
	 * @return String
	 */
	public String getId_psn_st() {
		return ((String) getAttrVal("Id_psn_st"));
	}
	/**
	 * 结算人员id
	 * @param Id_psn_st
	 */
	public void setId_psn_st(String Id_psn_st) {
		setAttrVal("Id_psn_st", Id_psn_st);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddar() {
		return ((String) getAttrVal("Addar"));
	}
	/**
	 * 现住址
	 * @param Addar
	 */
	public void setAddar(String Addar) {
		setAttrVal("Addar", Addar);
	}
	/**
	 * 支付人员
	 * @return String
	 */
	public String getName_emp_pay() {
		return ((String) getAttrVal("Name_emp_pay"));
	}
	/**
	 * 支付人员
	 * @param Name_emp_pay
	 */
	public void setName_emp_pay(String Name_emp_pay) {
		setAttrVal("Name_emp_pay", Name_emp_pay);
	}
	/**
	 * 支付人员id
	 * @return String
	 */
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}
	/**
	 * 支付人员id
	 * @param Id_emp_pay
	 */
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	/**
	 * 支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}
	/**
	 * 支付标识
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	 * 序号
	 * @return Integer
	 */
	public Integer getRownum_() {
		return ((Integer) getAttrVal("Rownum_"));
	}
	/**
	 * 序号
	 * @param Rownum_
	 */
	public void setRownum_(Integer Rownum_) {
		setAttrVal("Rownum_", Rownum_);
	}
	/**
	 * 收款时间
	 * @return FDateTime
	 */
	public FDateTime getPaytime() {
		return ((FDateTime) getAttrVal("Paytime"));
	}
	/**
	 * 收款时间
	 * @param Paytime
	 */
	public void setPaytime(FDateTime Paytime) {
		setAttrVal("Paytime", Paytime);
	}
	/**
	 * 归档标志
	 * @return FBoolean
	 */
	public FBoolean getFg_data_transf() {
		return ((FBoolean) getAttrVal("Fg_data_transf"));
	}
	/**
	 * 归档标志
	 * @param Fg_data_transf
	 */
	public void setFg_data_transf(FBoolean Fg_data_transf) {
		setAttrVal("Fg_data_transf", Fg_data_transf);
	}
	/**
	 * 死亡
	 * @return FBoolean
	 */
	public FBoolean getFg_died() {
		return ((FBoolean) getAttrVal("Fg_died"));
	}
	/**
	 * 死亡
	 * @param Fg_died
	 */
	public void setFg_died(FBoolean Fg_died) {
		setAttrVal("Fg_died", Fg_died);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getName_emp_dire() {
		return ((String) getAttrVal("Name_emp_dire"));
	}
	/**
	 * 当前主管医生
	 * @param Name_emp_dire
	 */
	public void setName_emp_dire(String Name_emp_dire) {
		setAttrVal("Name_emp_dire", Name_emp_dire);
	}
	/**
	 * 转入科室
	 * @return String
	 */
	public String getName_dep_trans() {
		return ((String) getAttrVal("Name_dep_trans"));
	}
	/**
	 * 转入科室
	 * @param Name_dep_trans
	 */
	public void setName_dep_trans(String Name_dep_trans) {
		setAttrVal("Name_dep_trans", Name_dep_trans);
	}
	/**
	 * 转入病区
	 * @return String
	 */
	public String getName_nur_trans() {
		return ((String) getAttrVal("Name_nur_trans"));
	}
	/**
	 * 转入病区
	 * @param Name_nur_trans
	 */
	public void setName_nur_trans(String Name_nur_trans) {
		setAttrVal("Name_nur_trans", Name_nur_trans);
	}
	/**
	 * 入院诊断
	 * @return String
	 */
	public String getName_diag_in() {
		return ((String) getAttrVal("Name_diag_in"));
	}
	/**
	 * 入院诊断
	 * @param Name_diag_in
	 */
	public void setName_diag_in(String Name_diag_in) {
		setAttrVal("Name_diag_in", Name_diag_in);
	}
	/**
	 * 出院诊断
	 * @return String
	 */
	public String getName_diag_out() {
		return ((String) getAttrVal("Name_diag_out"));
	}
	/**
	 * 出院诊断
	 * @param Name_diag_out
	 */
	public void setName_diag_out(String Name_diag_out) {
		setAttrVal("Name_diag_out", Name_diag_out);
	}
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * 结算id
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	/**
	 * 医保身份
	 * @return String
	 */
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}
	/**
	 * 医保身份
	 * @param Name_hppatca
	 */
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
	}
	/**
	 * 标签类型
	 * @return String
	 */
	public String getName_tagtp() {
		return ((String) getAttrVal("Name_tagtp"));
	}
	/**
	 * 标签类型
	 * @param Name_tagtp
	 */
	public void setName_tagtp(String Name_tagtp) {
		setAttrVal("Name_tagtp", Name_tagtp);
	}
	/**
	 * 病情
	 * @return String
	 */
	public String getPatient_status() {
		return ((String) getAttrVal("Patient_status"));
	}
	/**
	 * 病情
	 * @param Patient_status
	 */
	public void setPatient_status(String Patient_status) {
		setAttrVal("Patient_status", Patient_status);
	}
	/**
	 * 余额
	 * @return String
	 */
	public String getCost_balance() {
		return ((String) getAttrVal("Cost_balance"));
	}
	/**
	 * 余额
	 * @param Cost_balance
	 */
	public void setCost_balance(String Cost_balance) {
		setAttrVal("Cost_balance", Cost_balance);
	}
	/**
	 * 预交
	 * @return String
	 */
	public String getPrepaid() {
		return ((String) getAttrVal("Prepaid"));
	}
	/**
	 * 预交
	 * @param Prepaid
	 */
	public void setPrepaid(String Prepaid) {
		setAttrVal("Prepaid", Prepaid);
	}
	/**
	 * 已支
	 * @return String
	 */
	public String getCost() {
		return ((String) getAttrVal("Cost"));
	}
	/**
	 * 已支
	 * @param Cost
	 */
	public void setCost(String Cost) {
		setAttrVal("Cost", Cost);
	}
	/**
	 * 主诊断
	 * @return String
	 */
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}
	/**
	 * 主诊断
	 * @param Diagnosis
	 */
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
	}
	/**
	 * 药物过敏
	 * @return String
	 */
	public String getAllergy_drugs() {
		return ((String) getAttrVal("Allergy_drugs"));
	}
	/**
	 * 药物过敏
	 * @param Allergy_drugs
	 */
	public void setAllergy_drugs(String Allergy_drugs) {
		setAttrVal("Allergy_drugs", Allergy_drugs);
	}
	/**
	 * 饮食类别
	 * @return String
	 */
	public String getDiet_type() {
		return ((String) getAttrVal("Diet_type"));
	}
	/**
	 * 饮食类别
	 * @param Diet_type
	 */
	public void setDiet_type(String Diet_type) {
		setAttrVal("Diet_type", Diet_type);
	}
	/**
	 * 手术时间
	 * @return String
	 */
	public String getOperation_time() {
		return ((String) getAttrVal("Operation_time"));
	}
	/**
	 * 手术时间
	 * @param Operation_time
	 */
	public void setOperation_time(String Operation_time) {
		setAttrVal("Operation_time", Operation_time);
	}
	/**
	 * 陪护
	 * @return String
	 */
	public String getEscort() {
		return ((String) getAttrVal("Escort"));
	}
	/**
	 * 陪护
	 * @param Escort
	 */
	public void setEscort(String Escort) {
		setAttrVal("Escort", Escort);
	}
	/**
	 * 隔离
	 * @return String
	 */
	public String getIsolation() {
		return ((String) getAttrVal("Isolation"));
	}
	/**
	 * 隔离
	 * @param Isolation
	 */
	public void setIsolation(String Isolation) {
		setAttrVal("Isolation", Isolation);
	}
	/**
	 * 责任医生id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 责任医生id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 责任医生编码
	 * @return String
	 */
	public String getCode_emp_phy() {
		return ((String) getAttrVal("Code_emp_phy"));
	}
	/**
	 * 责任医生编码
	 * @param Code_emp_phy
	 */
	public void setCode_emp_phy(String Code_emp_phy) {
		setAttrVal("Code_emp_phy", Code_emp_phy);
	}
	/**
	 * 责任医生名称
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 责任医生名称
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 责任护士id
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 责任护士id
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 责任护士编码
	 * @return String
	 */
	public String getCode_emp_nur() {
		return ((String) getAttrVal("Code_emp_nur"));
	}
	/**
	 * 责任护士编码
	 * @param Code_emp_nur
	 */
	public void setCode_emp_nur(String Code_emp_nur) {
		setAttrVal("Code_emp_nur", Code_emp_nur);
	}
	/**
	 * 责任护士名称
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}
	/**
	 * 责任护士名称
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	/**
	 * 未结算费用
	 * @return String
	 */
	public String getAmt_uncg() {
		return ((String) getAttrVal("Amt_uncg"));
	}
	/**
	 * 未结算费用
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(String Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 开通手机app标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mobapp() {
		return ((FBoolean) getAttrVal("Fg_mobapp"));
	}
	/**
	 * 开通手机app标识
	 * @param Fg_mobapp
	 */
	public void setFg_mobapp(FBoolean Fg_mobapp) {
		setAttrVal("Fg_mobapp", Fg_mobapp);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * 条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
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
	 * 婚姻状况
	 * @return String
	 */
	public String getCode_mari_pat() {
		return ((String) getAttrVal("Code_mari_pat"));
	}
	/**
	 * 婚姻状况
	 * @param Code_mari_pat
	 */
	public void setCode_mari_pat(String Code_mari_pat) {
		setAttrVal("Code_mari_pat", Code_mari_pat);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
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
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}
	/**
	 * 民族
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国籍编码
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 国籍id
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}
	/**
	 * 国籍id
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 国籍
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国籍
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	/**
	 * 户籍类型编码
	 * @return String
	 */
	public String getSd_srcregiontp() {
		return ((String) getAttrVal("Sd_srcregiontp"));
	}
	/**
	 * 户籍类型编码
	 * @param Sd_srcregiontp
	 */
	public void setSd_srcregiontp(String Sd_srcregiontp) {
		setAttrVal("Sd_srcregiontp", Sd_srcregiontp);
	}
	/**
	 * 户籍类型id
	 * @return String
	 */
	public String getId_srcregiontp() {
		return ((String) getAttrVal("Id_srcregiontp"));
	}
	/**
	 * 户籍类型id
	 * @param Id_srcregiontp
	 */
	public void setId_srcregiontp(String Id_srcregiontp) {
		setAttrVal("Id_srcregiontp", Id_srcregiontp);
	}
	/**
	 * 户籍类型
	 * @return String
	 */
	public String getName_srcregiontp() {
		return ((String) getAttrVal("Name_srcregiontp"));
	}
	/**
	 * 户籍类型
	 * @param Name_srcregiontp
	 */
	public void setName_srcregiontp(String Name_srcregiontp) {
		setAttrVal("Name_srcregiontp", Name_srcregiontp);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}
	/**
	 * 职业编码
	 * @param Sd_occu
	 */
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	/**
	 * 职业id
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}
	/**
	 * 职业id
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}
	/**
	 * 职业
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	
	/**
	 * 文化程度Id
	 * @return String
	 */
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}
	/**
	 * 文化程度Id
	 * @param Id_educ
	 */
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
	}
	
	/**
	 * 文化程度编码
	 * @return String
	 */
	public String getSd_educ() {
		return ((String) getAttrVal("Sd_educ"));
	}
	/**
	 * 文化程度编码
	 * @param Sd_educ
	 */
	public void setSd_educ(String Sd_educ) {
		setAttrVal("Sd_educ", Sd_educ);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getName_educ() {
		return ((String) getAttrVal("Name_educ"));
	}
	/**
	 * 文化程度
	 * @param Name_educ
	 */
	public void setName_educ(String Name_educ) {
		setAttrVal("Name_educ", Name_educ);
	}
	/**
	 * 现住址区县码
	 * @return String
	 */
	public String getSd_admdiv_addr() {
		return ((String) getAttrVal("Sd_admdiv_addr"));
	}
	/**
	 * 现住址区县码
	 * @param Sd_admdiv_addr
	 */
	public void setSd_admdiv_addr(String Sd_admdiv_addr) {
		setAttrVal("Sd_admdiv_addr", Sd_admdiv_addr);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}
	/**
	 * 信用分类
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 信用分类编码
	 * @return String
	 */
	public String getSd_patcret() {
		return ((String) getAttrVal("Sd_patcret"));
	}
	/**
	 * 信用分类编码
	 * @param Sd_patcret
	 */
	public void setSd_patcret(String Sd_patcret) {
		setAttrVal("Sd_patcret", Sd_patcret);
	}
	/**
	 * 信用分类名称
	 * @return String
	 */
	public String getName_patcret() {
		return ((String) getAttrVal("Name_patcret"));
	}
	/**
	 * 信用分类名称
	 * @param Name_patcret
	 */
	public void setName_patcret(String Name_patcret) {
		setAttrVal("Name_patcret", Name_patcret);
	}
	/**
	 * 营养
	 * @return String
	 */
	public String getSd_level_nutr() {
		return ((String) getAttrVal("Sd_level_nutr"));
	}
	/**
	 * 营养
	 * @param Sd_level_nutr
	 */
	public void setSd_level_nutr(String Sd_level_nutr) {
		setAttrVal("Sd_level_nutr", Sd_level_nutr);
	}
	/**
	 * 来院方式
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 来院方式
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 离院转归
	 * @return String
	 */
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}
	/**
	 * 离院转归
	 * @param Sd_gowhere
	 */
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
	}
	/**
	 * 是否手术标识
	 * @return String
	 */
	public String getFg_surg() {
		return ((String) getAttrVal("Fg_surg"));
	}
	/**
	 * 是否手术标识
	 * @param Fg_surg
	 */
	public void setFg_surg(String Fg_surg) {
		setAttrVal("Fg_surg", Fg_surg);
	}
	/**
	 * 新手儿标识
	 * @return String
	 */
	public String getFg_newborn() {
		return ((String) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新手儿标识
	 * @param Fg_newborn
	 */
	public void setFg_newborn(String Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 是否在临床路径中
	 * @return String
	 */
	public String getFg_incp() {
		return ((String) getAttrVal("Fg_incp"));
	}
	/**
	 * 是否在临床路径中
	 * @param Fg_incp
	 */
	public void setFg_incp(String Fg_incp) {
		setAttrVal("Fg_incp", Fg_incp);
	}
	/**
	 * 临床路径状态
	 * @return String
	 */
	public String getEu_incp() {
		return ((String) getAttrVal("Eu_incp"));
	}
	/**
	 * 临床路径状态
	 * @param Eu_incp
	 */
	public void setEu_incp(String Eu_incp) {
		setAttrVal("Eu_incp", Eu_incp);
	}
	/**
	 * 门诊诊断编码
	 * @return String
	 */
	public String getCode_diag_op() {
		return ((String) getAttrVal("Code_diag_op"));
	}
	/**
	 * 门诊诊断编码
	 * @param Code_diag_op
	 */
	public void setCode_diag_op(String Code_diag_op) {
		setAttrVal("Code_diag_op", Code_diag_op);
	}
	/**
	 * 门诊诊断名称
	 * @return String
	 */
	public String getName_diag_op() {
		return ((String) getAttrVal("Name_diag_op"));
	}
	/**
	 * 门诊诊断名称
	 * @param Name_diag_op
	 */
	public void setName_diag_op(String Name_diag_op) {
		setAttrVal("Name_diag_op", Name_diag_op);
	}
	/**
	 * 门诊诊断id
	 * @return String
	 */
	public String getId_diag_op() {
		return ((String) getAttrVal("Id_diag_op"));
	}
	/**
	 * 门诊诊断id
	 * @param Id_diag_op
	 */
	public void setId_diag_op(String Id_diag_op) {
		setAttrVal("Id_diag_op", Id_diag_op);
	}
	/**
	 * 入院医生id
	 * @return String
	 */
	public String getId_emp_opapply() {
		return ((String) getAttrVal("Id_emp_opapply"));
	}
	/**
	 * 入院医生id
	 * @param Id_emp_opapply
	 */
	public void setId_emp_opapply(String Id_emp_opapply) {
		setAttrVal("Id_emp_opapply", Id_emp_opapply);
	}
	/**
	 * 入院医生编码
	 * @return String
	 */
	public String getCode_emp_opapply() {
		return ((String) getAttrVal("Code_emp_opapply"));
	}
	/**
	 * 入院医生编码
	 * @param Code_emp_opapply
	 */
	public void setCode_emp_opapply(String Code_emp_opapply) {
		setAttrVal("Code_emp_opapply", Code_emp_opapply);
	}
	/**
	 * 入院医生名称
	 * @return String
	 */
	public String getName_emp_opapply() {
		return ((String) getAttrVal("Name_emp_opapply"));
	}
	/**
	 * 入院医生名称
	 * @param Name_emp_opapply
	 */
	public void setName_emp_opapply(String Name_emp_opapply) {
		setAttrVal("Name_emp_opapply", Name_emp_opapply);
	}
	/**
	 * 主要联系人姓名
	 * @return String
	 */
	public String getCont_name() {
		return ((String) getAttrVal("Cont_name"));
	}
	/**
	 * 主要联系人姓名
	 * @param Cont_name
	 */
	public void setCont_name(String Cont_name) {
		setAttrVal("Cont_name", Cont_name);
	}
	/**
	 * 主要联系人电话
	 * @return String
	 */
	public String getCont_tel() {
		return ((String) getAttrVal("Cont_tel"));
	}
	/**
	 * 主要联系人电话
	 * @param Cont_tel
	 */
	public void setCont_tel(String Cont_tel) {
		setAttrVal("Cont_tel", Cont_tel);
	}
	/**
	 * 信用额度
	 * @return String
	 */
	public String getAmt_cret() {
		return ((String) getAttrVal("Amt_cret"));
	}
	/**
	 * 信用额度
	 * @param Amt_cret
	 */
	public void setAmt_cret(String Amt_cret) {
		setAttrVal("Amt_cret", Amt_cret);
	}
	/**
	 * 就诊预交金
	 * @return String
	 */
	public String getAmt_prepay() {
		return ((String) getAttrVal("Amt_prepay"));
	}
	/**
	 * 就诊预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(String Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 欠费下限
	 * @return String
	 */
	public String getAmt_owelimit() {
		return ((String) getAttrVal("Amt_owelimit"));
	}
	/**
	 * 欠费下限
	 * @param Amt_owelimit
	 */
	public void setAmt_owelimit(String Amt_owelimit) {
		setAttrVal("Amt_owelimit", Amt_owelimit);
	}
	/**
	 * 可报销医保额度
	 * @return String
	 */
	public String getAmt_hp() {
		return ((String) getAttrVal("Amt_hp"));
	}
	/**
	 * 可报销医保额度
	 * @param Amt_hp
	 */
	public void setAmt_hp(String Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 封帐标志
	 * @return String
	 */
	public String getFg_freeze() {
		return ((String) getAttrVal("Fg_freeze"));
	}
	/**
	 * 封帐标志
	 * @param Fg_freeze
	 */
	public void setFg_freeze(String Fg_freeze) {
		setAttrVal("Fg_freeze", Fg_freeze);
	}
}