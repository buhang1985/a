package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/***
 * 获取入院许可证-出参
 * @author zhangpp
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ScAptByPatResult extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private String id_aptip;
	/**
	 * 门诊就诊id
	 */
	private String id_ent;
	/**
	 * 住院就诊id
	 */
	private String id_entip;
	/**
	 * 患者id
	 */
	private String id_pat;
	/**
	 * 患者姓名
	 */
	private String name_pat;
	/**
	 * 患者性别
	 */
	private String sd_sex_pat;
	/**
	 * 出生日期
	 */
	private String dt_birth_pat;
	/**
	 * 医保计划
	 */
	private String id_hp;
	/**
	 * 医保编号
	 */
	private String code_hp;
	/**
	 * 门诊就诊科室id
	 */
	private String id_dep_op;
	/**
	 * 门诊就诊科室编码
	 */
	private String code_dep_op;
	/**
	 * 门诊就诊科室名称
	 */
	private String name_dep_op;
	/**
	 * 门诊医生id
	 */
	private String id_emp_phy_op;
	/**
	 * 门诊医生编码
	 */
	private String code_emp_phy_op;
	/**
	 * 门诊医生名称
	 */
	private String name_emp_phy_op;
	/**
	 * 门诊诊断id
	 */
	private String id_didef_op;
	/**
	 * 门诊诊断编码
	 */
	private String code_didef_op;
	/**
	 * 门诊诊断名称
	 */
	private String name_didef_op;
	/**
	 * 门诊诊断补充说明
	 */
	private String supplement_di;
	/**
	 * 病情级别
	 */
	private String sd_level_dise;
	/**
	 * 病人分类id
	 */
	private String id_patca;
	/**
	 * 病人分类编码
	 */
	private String code_patca;
	/**
	 * 申请入院科室
	 */
	private String code_dep_phy_ip;
	/**
	 * 申请入院病区
	 */
	private String code_dep_nur_ip;
	/**
	 * 计划入院
	 */
	private String fg_plan;
	/**
	 * 计划入院时间
	 */
	private String dt_admit_plan;
	/**
	 * 床位类型
	 */
	private String sd_bedtype;
	/**
	 * 预计预交金额度
	 */
	private String amt_deposit;
	/**
	 * 备注
	 */
	private String note;
	/**
	 * 急诊留观标志
	 */
	private String fg_emgstay;
	/**
	 * 床位id
	 */
	private String id_bed;
	/**
	 * 通知单有效期
	 */
	private String dt_valid;
	/**
	 * 优先级别
	 */
	private String level_pri;
	/**
	 * 优先级别原因
	 */
	private String level_pri_rsn;
	/**
	 * 申请时间
	 */
	private String dt_insert;
	/**
	 * 预约人id
	 */
	private String id_emp_appt;
	/**
	 * 预约人编码
	 */
	private String code_emp_appt;
	/**
	 * 预约时间
	 */
	private String dt_appt;
	/**
	 * 预约备注
	 */
	private String note_appt;
	/**
	 * 预约确认人
	 */
	private String id_emp_cfm;
	/**
	 * 预约确认时间
	 */
	private String dt_cfm;
	/**
	 * 拒绝原因
	 */
	private String rsn_refuse;
	/**
	 * 通知经办人id
	 */
	private String id_emp_notice;
	/**
	 * 通知经办人姓名
	 */
	private String name_emp_notice;
	/**
	 * 通知下达日期
	 */
	private String dt_notice;
	/**
	 * 手动配置
	 */
	private String fg_manual;
	/**
	 * 通知单状态
	 */
	private String sd_status;
	/**
	 * VIP标志
	 */
	private String fg_vip;
	/**
	 * 来院途径
	 */
	private String sd_referalsrc;
	/**
	 * 联系医生姓名
	 */
	private String name_cont_phy;
	/**
	 * 联系医生电话
	 */
	private String tel_cont_phy;
	/**
	 * 预约信息记录
	 */
	private String note_apt;
	/**
	 * 行走方式
	 */
	private String sd_walkwith;
	/**
	 * 联系人id
	 */
	private String id_patcont;
	/**
	 * 预住院标志
	 */
	private String fg_preip;
	
	/**
	 * 更新时间
	 */
	private String Update_time = "";
	
	public String getUpdate_time() {
		return Update_time;
	}

	public void setUpdate_time(String update_time) {
		Update_time = update_time;
	}
	
	public String getId_aptip() {
		return id_aptip;
	}
	public void setId_aptip(String id_aptip) {
		this.id_aptip = id_aptip;
	}
	public String getId_ent() {
		return id_ent;
	}
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	public String getId_entip() {
		return id_entip;
	}
	public void setId_entip(String id_entip) {
		this.id_entip = id_entip;
	}
	public String getId_pat() {
		return id_pat;
	}
	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}
	public String getName_pat() {
		return name_pat;
	}
	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}
	public String getSd_sex_pat() {
		return sd_sex_pat;
	}
	public void setSd_sex_pat(String sd_sex_pat) {
		this.sd_sex_pat = sd_sex_pat;
	}
	public String getDt_birth_pat() {
		return dt_birth_pat;
	}
	public void setDt_birth_pat(String dt_birth_pat) {
		this.dt_birth_pat = dt_birth_pat;
	}
	public String getId_hp() {
		return id_hp;
	}
	public void setId_hp(String id_hp) {
		this.id_hp = id_hp;
	}
	public String getCode_hp() {
		return code_hp;
	}
	public void setCode_hp(String code_hp) {
		this.code_hp = code_hp;
	}
	public String getId_dep_op() {
		return id_dep_op;
	}
	public void setId_dep_op(String id_dep_op) {
		this.id_dep_op = id_dep_op;
	}
	public String getCode_dep_op() {
		return code_dep_op;
	}
	public void setCode_dep_op(String code_dep_op) {
		this.code_dep_op = code_dep_op;
	}
	public String getName_dep_op() {
		return name_dep_op;
	}
	public void setName_dep_op(String name_dep_op) {
		this.name_dep_op = name_dep_op;
	}
	public String getId_emp_phy_op() {
		return id_emp_phy_op;
	}
	public void setId_emp_phy_op(String id_emp_phy_op) {
		this.id_emp_phy_op = id_emp_phy_op;
	}
	public String getCode_emp_phy_op() {
		return code_emp_phy_op;
	}
	public void setCode_emp_phy_op(String code_emp_phy_op) {
		this.code_emp_phy_op = code_emp_phy_op;
	}
	public String getName_emp_phy_op() {
		return name_emp_phy_op;
	}
	public void setName_emp_phy_op(String name_emp_phy_op) {
		this.name_emp_phy_op = name_emp_phy_op;
	}
	public String getId_didef_op() {
		return id_didef_op;
	}
	public void setId_didef_op(String id_didef_op) {
		this.id_didef_op = id_didef_op;
	}
	public String getCode_didef_op() {
		return code_didef_op;
	}
	public void setCode_didef_op(String code_didef_op) {
		this.code_didef_op = code_didef_op;
	}
	public String getName_didef_op() {
		return name_didef_op;
	}
	public void setName_didef_op(String name_didef_op) {
		this.name_didef_op = name_didef_op;
	}
	public String getSupplement_di() {
		return supplement_di;
	}
	public void setSupplement_di(String supplement_di) {
		this.supplement_di = supplement_di;
	}
	public String getSd_level_dise() {
		return sd_level_dise;
	}
	public void setSd_level_dise(String sd_level_dise) {
		this.sd_level_dise = sd_level_dise;
	}
	public String getId_patca() {
		return id_patca;
	}
	public void setId_patca(String id_patca) {
		this.id_patca = id_patca;
	}
	public String getCode_patca() {
		return code_patca;
	}
	public void setCode_patca(String code_patca) {
		this.code_patca = code_patca;
	}
	public String getCode_dep_phy_ip() {
		return code_dep_phy_ip;
	}
	public void setCode_dep_phy_ip(String code_dep_phy_ip) {
		this.code_dep_phy_ip = code_dep_phy_ip;
	}
	public String getCode_dep_nur_ip() {
		return code_dep_nur_ip;
	}
	public void setCode_dep_nur_ip(String code_dep_nur_ip) {
		this.code_dep_nur_ip = code_dep_nur_ip;
	}
	public String getFg_plan() {
		return fg_plan;
	}
	public void setFg_plan(String fg_plan) {
		this.fg_plan = fg_plan;
	}
	public String getDt_admit_plan() {
		return dt_admit_plan;
	}
	public void setDt_admit_plan(String dt_admit_plan) {
		this.dt_admit_plan = dt_admit_plan;
	}
	public String getSd_bedtype() {
		return sd_bedtype;
	}
	public void setSd_bedtype(String sd_bedtype) {
		this.sd_bedtype = sd_bedtype;
	}
	public String getAmt_deposit() {
		return amt_deposit;
	}
	public void setAmt_deposit(String amt_deposit) {
		this.amt_deposit = amt_deposit;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getFg_emgstay() {
		return fg_emgstay;
	}
	public void setFg_emgstay(String fg_emgstay) {
		this.fg_emgstay = fg_emgstay;
	}
	public String getId_bed() {
		return id_bed;
	}
	public void setId_bed(String id_bed) {
		this.id_bed = id_bed;
	}
	public String getDt_valid() {
		return dt_valid;
	}
	public void setDt_valid(String dt_valid) {
		this.dt_valid = dt_valid;
	}
	public String getLevel_pri() {
		return level_pri;
	}
	public void setLevel_pri(String level_pri) {
		this.level_pri = level_pri;
	}
	public String getLevel_pri_rsn() {
		return level_pri_rsn;
	}
	public void setLevel_pri_rsn(String level_pri_rsn) {
		this.level_pri_rsn = level_pri_rsn;
	}
	public String getDt_insert() {
		return dt_insert;
	}
	public void setDt_insert(String dt_insert) {
		this.dt_insert = dt_insert;
	}
	public String getId_emp_appt() {
		return id_emp_appt;
	}
	public void setId_emp_appt(String id_emp_appt) {
		this.id_emp_appt = id_emp_appt;
	}
	public String getCode_emp_appt() {
		return code_emp_appt;
	}
	public void setCode_emp_appt(String code_emp_appt) {
		this.code_emp_appt = code_emp_appt;
	}
	public String getDt_appt() {
		return dt_appt;
	}
	public void setDt_appt(String dt_appt) {
		this.dt_appt = dt_appt;
	}
	public String getNote_appt() {
		return note_appt;
	}
	public void setNote_appt(String note_appt) {
		this.note_appt = note_appt;
	}
	public String getId_emp_cfm() {
		return id_emp_cfm;
	}
	public void setId_emp_cfm(String id_emp_cfm) {
		this.id_emp_cfm = id_emp_cfm;
	}
	public String getDt_cfm() {
		return dt_cfm;
	}
	public void setDt_cfm(String dt_cfm) {
		this.dt_cfm = dt_cfm;
	}
	public String getRsn_refuse() {
		return rsn_refuse;
	}
	public void setRsn_refuse(String rsn_refuse) {
		this.rsn_refuse = rsn_refuse;
	}
	public String getId_emp_notice() {
		return id_emp_notice;
	}
	public void setId_emp_notice(String id_emp_notice) {
		this.id_emp_notice = id_emp_notice;
	}
	public String getName_emp_notice() {
		return name_emp_notice;
	}
	public void setName_emp_notice(String name_emp_notice) {
		this.name_emp_notice = name_emp_notice;
	}
	public String getDt_notice() {
		return dt_notice;
	}
	public void setDt_notice(String dt_notice) {
		this.dt_notice = dt_notice;
	}
	public String getFg_manual() {
		return fg_manual;
	}
	public void setFg_manual(String fg_manual) {
		this.fg_manual = fg_manual;
	}
	public String getSd_status() {
		return sd_status;
	}
	public void setSd_status(String sd_status) {
		this.sd_status = sd_status;
	}
	public String getFg_vip() {
		return fg_vip;
	}
	public void setFg_vip(String fg_vip) {
		this.fg_vip = fg_vip;
	}
	public String getSd_referalsrc() {
		return sd_referalsrc;
	}
	public void setSd_referalsrc(String sd_referalsrc) {
		this.sd_referalsrc = sd_referalsrc;
	}
	public String getName_cont_phy() {
		return name_cont_phy;
	}
	public void setName_cont_phy(String name_cont_phy) {
		this.name_cont_phy = name_cont_phy;
	}
	public String getTel_cont_phy() {
		return tel_cont_phy;
	}
	public void setTel_cont_phy(String tel_cont_phy) {
		this.tel_cont_phy = tel_cont_phy;
	}
	public String getNote_apt() {
		return note_apt;
	}
	public void setNote_apt(String note_apt) {
		this.note_apt = note_apt;
	}
	public String getSd_walkwith() {
		return sd_walkwith;
	}
	public void setSd_walkwith(String sd_walkwith) {
		this.sd_walkwith = sd_walkwith;
	}
	public String getId_patcont() {
		return id_patcont;
	}
	public void setId_patcont(String id_patcont) {
		this.id_patcont = id_patcont;
	}
	public String getFg_preip() {
		return fg_preip;
	}
	public void setFg_preip(String fg_preip) {
		this.fg_preip = fg_preip;
	}
	
}
