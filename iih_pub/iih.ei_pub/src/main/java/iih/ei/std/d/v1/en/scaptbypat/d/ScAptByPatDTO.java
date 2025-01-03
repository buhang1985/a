package iih.ei.std.d.v1.en.scaptbypat.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 入院许可证 DTO数据 
 * 
 */
public class ScAptByPatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}	
	/**
	 * 主键
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	/**
	 * 门诊就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 门诊就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院就诊
	 * @return String
	 */
	public String getId_entip() {
		return ((String) getAttrVal("Id_entip"));
	}	
	/**
	 * 住院就诊
	 * @param Id_entip
	 */
	public void setId_entip(String Id_entip) {
		setAttrVal("Id_entip", Id_entip);
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
	 * 患者性别
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保编号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保编号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 门诊就诊科室
	 * @return String
	 */
	public String getId_dep_op() {
		return ((String) getAttrVal("Id_dep_op"));
	}	
	/**
	 * 门诊就诊科室
	 * @param Id_dep_op
	 */
	public void setId_dep_op(String Id_dep_op) {
		setAttrVal("Id_dep_op", Id_dep_op);
	}
	/**
	 * 门诊就诊科室名称
	 * @return String
	 */
	public String getName_dep_op() {
		return ((String) getAttrVal("Name_dep_op"));
	}	
	/**
	 * 门诊就诊科室名称
	 * @param Name_dep_op
	 */
	public void setName_dep_op(String Name_dep_op) {
		setAttrVal("Name_dep_op", Name_dep_op);
	}
	/**
	 * 门诊就诊科室编码
	 * @return String
	 */
	public String getCode_dep_op() {
		return ((String) getAttrVal("Code_dep_op"));
	}	
	/**
	 * 门诊就诊科室编码
	 * @param Code_dep_op
	 */
	public void setCode_dep_op(String Code_dep_op) {
		setAttrVal("Code_dep_op", Code_dep_op);
	}
	/**
	 * 门诊医生
	 * @return String
	 */
	public String getId_emp_phy_op() {
		return ((String) getAttrVal("Id_emp_phy_op"));
	}	
	/**
	 * 门诊医生
	 * @param Id_emp_phy_op
	 */
	public void setId_emp_phy_op(String Id_emp_phy_op) {
		setAttrVal("Id_emp_phy_op", Id_emp_phy_op);
	}
	/**
	 * 门诊医生名称
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}	
	/**
	 * 门诊医生名称
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 门诊医生编码
	 * @return String
	 */
	public String getCode_emp_phy_op() {
		return ((String) getAttrVal("Code_emp_phy_op"));
	}	
	/**
	 * 门诊医生编码
	 * @param Code_emp_phy_op
	 */
	public void setCode_emp_phy_op(String Code_emp_phy_op) {
		setAttrVal("Code_emp_phy_op", Code_emp_phy_op);
	}
	/**
	 * 门诊诊断
	 * @return String
	 */
	public String getId_didef_op() {
		return ((String) getAttrVal("Id_didef_op"));
	}	
	/**
	 * 门诊诊断
	 * @param Id_didef_op
	 */
	public void setId_didef_op(String Id_didef_op) {
		setAttrVal("Id_didef_op", Id_didef_op);
	}
	/**
	 * 门诊诊断名称
	 * @return String
	 */
	public String getName_didef_op() {
		return ((String) getAttrVal("Name_didef_op"));
	}	
	/**
	 * 门诊诊断名称
	 * @param Name_didef_op
	 */
	public void setName_didef_op(String Name_didef_op) {
		setAttrVal("Name_didef_op", Name_didef_op);
	}
	/**
	 * 门诊诊断编码
	 * @return String
	 */
	public String getCode_didef_op() {
		return ((String) getAttrVal("Code_didef_op"));
	}	
	/**
	 * 门诊诊断编码
	 * @param Code_didef_op
	 */
	public void setCode_didef_op(String Code_didef_op) {
		setAttrVal("Code_didef_op", Code_didef_op);
	}
	/**
	 * 门诊诊断补充说明
	 * @return String
	 */
	public String getSupplement_di() {
		return ((String) getAttrVal("Supplement_di"));
	}	
	/**
	 * 门诊诊断补充说明
	 * @param Supplement_di
	 */
	public void setSupplement_di(String Supplement_di) {
		setAttrVal("Supplement_di", Supplement_di);
	}
	/**
	 * 病情级别
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}	
	/**
	 * 病情级别
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病人分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	/**
	 * 病人分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 病人分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}	
	/**
	 * 病人分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 申请入院科室
	 * @return String
	 */
	public String getCode_dep_phy_ip() {
		return ((String) getAttrVal("Code_dep_phy_ip"));
	}	
	/**
	 * 申请入院科室
	 * @param Code_dep_phy_ip
	 */
	public void setCode_dep_phy_ip(String Code_dep_phy_ip) {
		setAttrVal("Code_dep_phy_ip", Code_dep_phy_ip);
	}
	/**
	 * 申请入院病区
	 * @return String
	 */
	public String getCode_dep_nur_ip() {
		return ((String) getAttrVal("Code_dep_nur_ip"));
	}	
	/**
	 * 申请入院病区
	 * @param Code_dep_nur_ip
	 */
	public void setCode_dep_nur_ip(String Code_dep_nur_ip) {
		setAttrVal("Code_dep_nur_ip", Code_dep_nur_ip);
	}
	/**
	 * 计划入院
	 * @return FBoolean
	 */
	public FBoolean getFg_plan() {
		return ((FBoolean) getAttrVal("Fg_plan"));
	}	
	/**
	 * 计划入院
	 * @param Fg_plan
	 */
	public void setFg_plan(FBoolean Fg_plan) {
		setAttrVal("Fg_plan", Fg_plan);
	}
	/**
	 * 床位类型
	 * @return String
	 */
	public String getSd_bedtype() {
		return ((String) getAttrVal("Sd_bedtype"));
	}	
	/**
	 * 床位类型
	 * @param Sd_bedtype
	 */
	public void setSd_bedtype(String Sd_bedtype) {
		setAttrVal("Sd_bedtype", Sd_bedtype);
	}
	/**
	 * 计划入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_admit_plan() {
		return ((FDateTime) getAttrVal("Dt_admit_plan"));
	}	
	/**
	 * 计划入院时间
	 * @param Dt_admit_plan
	 */
	public void setDt_admit_plan(FDateTime Dt_admit_plan) {
		setAttrVal("Dt_admit_plan", Dt_admit_plan);
	}
	/**
	 * 预计预交金额度
	 * @return FDouble
	 */
	public FDouble getAmt_deposit() {
		return ((FDouble) getAttrVal("Amt_deposit"));
	}	
	/**
	 * 预计预交金额度
	 * @param Amt_deposit
	 */
	public void setAmt_deposit(FDouble Amt_deposit) {
		setAttrVal("Amt_deposit", Amt_deposit);
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
	 * 急诊留观标志
	 * @return FBoolean
	 */
	public FBoolean getFg_emgstay() {
		return ((FBoolean) getAttrVal("Fg_emgstay"));
	}	
	/**
	 * 急诊留观标志
	 * @param Fg_emgstay
	 */
	public void setFg_emgstay(FBoolean Fg_emgstay) {
		setAttrVal("Fg_emgstay", Fg_emgstay);
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
	 * 通知单有效期
	 * @return FDateTime
	 */
	public FDateTime getDt_valid() {
		return ((FDateTime) getAttrVal("Dt_valid"));
	}	
	/**
	 * 通知单有效期
	 * @param Dt_valid
	 */
	public void setDt_valid(FDateTime Dt_valid) {
		setAttrVal("Dt_valid", Dt_valid);
	}
	/**
	 * 优先级别
	 * @return String
	 */
	public String getLevel_pri() {
		return ((String) getAttrVal("Level_pri"));
	}	
	/**
	 * 优先级别
	 * @param Level_pri
	 */
	public void setLevel_pri(String Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 优先级别原因
	 * @return String
	 */
	public String getLevel_pri_rsn() {
		return ((String) getAttrVal("Level_pri_rsn"));
	}	
	/**
	 * 优先级别原因
	 * @param Level_pri_rsn
	 */
	public void setLevel_pri_rsn(String Level_pri_rsn) {
		setAttrVal("Level_pri_rsn", Level_pri_rsn);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	/**
	 * 申请时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	/**
	 * 预约人
	 * @return String
	 */
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}	
	/**
	 * 预约人
	 * @param Id_emp_appt
	 */
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	/**
	 * 预约人编码
	 * @return String
	 */
	public String getCode_emp_appt() {
		return ((String) getAttrVal("Code_emp_appt"));
	}	
	/**
	 * 预约人编码
	 * @param Code_emp_appt
	 */
	public void setCode_emp_appt(String Code_emp_appt) {
		setAttrVal("Code_emp_appt", Code_emp_appt);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约确认人
	 * @return String
	 */
	public String getId_emp_cfm() {
		return ((String) getAttrVal("Id_emp_cfm"));
	}	
	/**
	 * 预约确认人
	 * @param Id_emp_cfm
	 */
	public void setId_emp_cfm(String Id_emp_cfm) {
		setAttrVal("Id_emp_cfm", Id_emp_cfm);
	}
	/**
	 * 预约确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cfm() {
		return ((FDateTime) getAttrVal("Dt_cfm"));
	}	
	/**
	 * 预约确认时间
	 * @param Dt_cfm
	 */
	public void setDt_cfm(FDateTime Dt_cfm) {
		setAttrVal("Dt_cfm", Dt_cfm);
	}
	/**
	 * 拒绝原因
	 * @return String
	 */
	public String getRsn_refuse() {
		return ((String) getAttrVal("Rsn_refuse"));
	}	
	/**
	 * 拒绝原因
	 * @param Rsn_refuse
	 */
	public void setRsn_refuse(String Rsn_refuse) {
		setAttrVal("Rsn_refuse", Rsn_refuse);
	}
	/**
	 * 通知经办人
	 * @return String
	 */
	public String getId_emp_notice() {
		return ((String) getAttrVal("Id_emp_notice"));
	}	
	/**
	 * 通知经办人
	 * @param Id_emp_notice
	 */
	public void setId_emp_notice(String Id_emp_notice) {
		setAttrVal("Id_emp_notice", Id_emp_notice);
	}
	/**
	 * 通知单经办人姓名
	 * @return String
	 */
	public String getName_emp_notice() {
		return ((String) getAttrVal("Name_emp_notice"));
	}	
	/**
	 * 通知单经办人姓名
	 * @param Name_emp_notice
	 */
	public void setName_emp_notice(String Name_emp_notice) {
		setAttrVal("Name_emp_notice", Name_emp_notice);
	}
	/**
	 * 通知下达日期
	 * @return FDateTime
	 */
	public FDateTime getDt_notice() {
		return ((FDateTime) getAttrVal("Dt_notice"));
	}	
	/**
	 * 通知下达日期
	 * @param Dt_notice
	 */
	public void setDt_notice(FDateTime Dt_notice) {
		setAttrVal("Dt_notice", Dt_notice);
	}
	/**
	 * 手动配置
	 * @return FBoolean
	 */
	public FBoolean getFg_manual() {
		return ((FBoolean) getAttrVal("Fg_manual"));
	}	
	/**
	 * 手动配置
	 * @param Fg_manual
	 */
	public void setFg_manual(FBoolean Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
	}
	/**
	 * 通知单状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 通知单状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * vip标志
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * vip标志
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 来院途径
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}	
	/**
	 * 来院途径
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 联系医生姓名
	 * @return String
	 */
	public String getName_cont_phy() {
		return ((String) getAttrVal("Name_cont_phy"));
	}	
	/**
	 * 联系医生姓名
	 * @param Name_cont_phy
	 */
	public void setName_cont_phy(String Name_cont_phy) {
		setAttrVal("Name_cont_phy", Name_cont_phy);
	}
	/**
	 * 联系医生电话
	 * @return String
	 */
	public String getTel_cont_phy() {
		return ((String) getAttrVal("Tel_cont_phy"));
	}	
	/**
	 * 联系医生电话
	 * @param Tel_cont_phy
	 */
	public void setTel_cont_phy(String Tel_cont_phy) {
		setAttrVal("Tel_cont_phy", Tel_cont_phy);
	}
	/**
	 * 预约信息记录
	 * @return String
	 */
	public String getNote_apt() {
		return ((String) getAttrVal("Note_apt"));
	}	
	/**
	 * 预约信息记录
	 * @param Note_apt
	 */
	public void setNote_apt(String Note_apt) {
		setAttrVal("Note_apt", Note_apt);
	}
	/**
	 * 行走方式
	 * @return String
	 */
	public String getSd_walkwith() {
		return ((String) getAttrVal("Sd_walkwith"));
	}	
	/**
	 * 行走方式
	 * @param Sd_walkwith
	 */
	public void setSd_walkwith(String Sd_walkwith) {
		setAttrVal("Sd_walkwith", Sd_walkwith);
	}
	/**
	 * 联系人id
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}	
	/**
	 * 联系人id
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	/**
	 * 预住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_preip() {
		return ((FBoolean) getAttrVal("Fg_preip"));
	}	
	/**
	 * 预住院标志
	 * @param Fg_preip
	 */
	public void setFg_preip(FBoolean Fg_preip) {
		setAttrVal("Fg_preip", Fg_preip);
	}
	/**
	 * 更新时间
	 * @return FDateTime
	 */
	public FDateTime getUpdate_time() {
		return ((FDateTime) getAttrVal("Update_time"));
	}	
	/**
	 * 更新时间
	 * @param Update_time
	 */
	public void setUpdate_time(FDateTime Update_time) {
		setAttrVal("Update_time", Update_time);
	}
}