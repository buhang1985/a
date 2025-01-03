package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院预约DTO DTO数据 
 * 
 */
public class AptIpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院预约id
	 * @return String
	 */
	public String getId_scaptip() {
		return ((String) getAttrVal("Id_scaptip"));
	}
	/**
	 * 住院预约id
	 * @param Id_scaptip
	 */
	public void setId_scaptip(String Id_scaptip) {
		setAttrVal("Id_scaptip", Id_scaptip);
	}
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者Id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者Id
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
	 * 病人编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 病人编号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel_pat() {
		return ((String) getAttrVal("Tel_pat"));
	}
	/**
	 * 电话
	 * @param Tel_pat
	 */
	public void setTel_pat(String Tel_pat) {
		setAttrVal("Tel_pat", Tel_pat);
	}
	/**
	 * 家庭地址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 家庭地址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 现住址id
	 * @return String
	 */
	public String getId_addr() {
		return ((String) getAttrVal("Id_addr"));
	}
	/**
	 * 现住址id
	 * @param Id_addr
	 */
	public void setId_addr(String Id_addr) {
		setAttrVal("Id_addr", Id_addr);
	}
	/**
	 * 现住址区划id
	 * @return String
	 */
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}
	/**
	 * 现住址区划id
	 * @param Id_admdiv
	 */
	public void setId_admdiv(String Id_admdiv) {
		setAttrVal("Id_admdiv", Id_admdiv);
	}
	/**
	 * 现住址区划名称
	 * @return String
	 */
	public String getName_admdiv() {
		return ((String) getAttrVal("Name_admdiv"));
	}
	/**
	 * 现住址区划名称
	 * @param Name_admdiv
	 */
	public void setName_admdiv(String Name_admdiv) {
		setAttrVal("Name_admdiv", Name_admdiv);
	}
	/**
	 * 行政区划sd
	 * @return String
	 */
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}
	/**
	 * 行政区划sd
	 * @param Sd_admdiv
	 */
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirth_pat() {
		return ((FDate) getAttrVal("Birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Birth_pat
	 */
	public void setBirth_pat(FDate Birth_pat) {
		setAttrVal("Birth_pat", Birth_pat);
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
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 性别id
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex_pat() {
		return ((String) getAttrVal("Name_sex_pat"));
	}
	/**
	 * 性别名称
	 * @param Name_sex_pat
	 */
	public void setName_sex_pat(String Name_sex_pat) {
		setAttrVal("Name_sex_pat", Name_sex_pat);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getSd_patcardtp() {
		return ((String) getAttrVal("Sd_patcardtp"));
	}
	/**
	 * 证件类型
	 * @param Sd_patcardtp
	 */
	public void setSd_patcardtp(String Sd_patcardtp) {
		setAttrVal("Sd_patcardtp", Sd_patcardtp);
	}
	/**
	 * 证件类型ID
	 * @return String
	 */
	public String getId_patcardtp() {
		return ((String) getAttrVal("Id_patcardtp"));
	}
	/**
	 * 证件类型ID
	 * @param Id_patcardtp
	 */
	public void setId_patcardtp(String Id_patcardtp) {
		setAttrVal("Id_patcardtp", Id_patcardtp);
	}
	/**
	 * 证件类型名称
	 * @return String
	 */
	public String getName_patcardtp() {
		return ((String) getAttrVal("Name_patcardtp"));
	}
	/**
	 * 证件类型名称
	 * @param Name_patcardtp
	 */
	public void setName_patcardtp(String Name_patcardtp) {
		setAttrVal("Name_patcardtp", Name_patcardtp);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getSd_patcardtp_code() {
		return ((String) getAttrVal("Sd_patcardtp_code"));
	}
	/**
	 * 证件号
	 * @param Sd_patcardtp_code
	 */
	public void setSd_patcardtp_code(String Sd_patcardtp_code) {
		setAttrVal("Sd_patcardtp_code", Sd_patcardtp_code);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
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
	 * 病情等级id
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级id
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情等级
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病情等级名称
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情等级名称
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
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
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phy_ip() {
		return ((String) getAttrVal("Id_dep_phy_ip"));
	}
	/**
	 * 入院科室
	 * @param Id_dep_phy_ip
	 */
	public void setId_dep_phy_ip(String Id_dep_phy_ip) {
		setAttrVal("Id_dep_phy_ip", Id_dep_phy_ip);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getName_dep_phy_ip() {
		return ((String) getAttrVal("Name_dep_phy_ip"));
	}
	/**
	 * 入院科室名称
	 * @param Name_dep_phy_ip
	 */
	public void setName_dep_phy_ip(String Name_dep_phy_ip) {
		setAttrVal("Name_dep_phy_ip", Name_dep_phy_ip);
	}
	/**
	 * 入院病区id
	 * @return String
	 */
	public String getId_dep_nur_ip() {
		return ((String) getAttrVal("Id_dep_nur_ip"));
	}
	/**
	 * 入院病区id
	 * @param Id_dep_nur_ip
	 */
	public void setId_dep_nur_ip(String Id_dep_nur_ip) {
		setAttrVal("Id_dep_nur_ip", Id_dep_nur_ip);
	}
	/**
	 * 入院病区名称
	 * @return String
	 */
	public String getName_dep_nur_ip() {
		return ((String) getAttrVal("Name_dep_nur_ip"));
	}
	/**
	 * 入院病区名称
	 * @param Name_dep_nur_ip
	 */
	public void setName_dep_nur_ip(String Name_dep_nur_ip) {
		setAttrVal("Name_dep_nur_ip", Name_dep_nur_ip);
	}
	/**
	 * 计划入院日期
	 * @return FDate
	 */
	public FDate getDt_admit_plan() {
		return ((FDate) getAttrVal("Dt_admit_plan"));
	}
	/**
	 * 计划入院日期
	 * @param Dt_admit_plan
	 */
	public void setDt_admit_plan(FDate Dt_admit_plan) {
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
	 * 就诊转归id
	 * @return String
	 */
	public String getId_gowhere() {
		return ((String) getAttrVal("Id_gowhere"));
	}
	/**
	 * 就诊转归id
	 * @param Id_gowhere
	 */
	public void setId_gowhere(String Id_gowhere) {
		setAttrVal("Id_gowhere", Id_gowhere);
	}
	/**
	 * 就诊转归编码
	 * @return String
	 */
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}
	/**
	 * 就诊转归编码
	 * @param Sd_gowhere
	 */
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
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
	 * 入院通知单id
	 * @return String
	 */
	public String getId_ent_ipnt() {
		return ((String) getAttrVal("Id_ent_ipnt"));
	}
	/**
	 * 入院通知单id
	 * @param Id_ent_ipnt
	 */
	public void setId_ent_ipnt(String Id_ent_ipnt) {
		setAttrVal("Id_ent_ipnt", Id_ent_ipnt);
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
	 * 取消人id
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}
	/**
	 * 取消人id
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 取消人
	 * @return String
	 */
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}
	/**
	 * 取消人
	 * @param Name_emp_canc
	 */
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
	}
	/**
	 * 取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}
	/**
	 * 取消时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 确认人id
	 * @return String
	 */
	public String getId_emp_cfm() {
		return ((String) getAttrVal("Id_emp_cfm"));
	}
	/**
	 * 确认人id
	 * @param Id_emp_cfm
	 */
	public void setId_emp_cfm(String Id_emp_cfm) {
		setAttrVal("Id_emp_cfm", Id_emp_cfm);
	}
	/**
	 * 确认人
	 * @return String
	 */
	public String getName_emp_cfm() {
		return ((String) getAttrVal("Name_emp_cfm"));
	}
	/**
	 * 确认人
	 * @param Name_emp_cfm
	 */
	public void setName_emp_cfm(String Name_emp_cfm) {
		setAttrVal("Name_emp_cfm", Name_emp_cfm);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cfm() {
		return ((FDateTime) getAttrVal("Dt_cfm"));
	}
	/**
	 * 确认时间
	 * @param Dt_cfm
	 */
	public void setDt_cfm(FDateTime Dt_cfm) {
		setAttrVal("Dt_cfm", Dt_cfm);
	}
	/**
	 * 通知经办人id
	 * @return String
	 */
	public String getId_emp_notice() {
		return ((String) getAttrVal("Id_emp_notice"));
	}
	/**
	 * 通知经办人id
	 * @param Id_emp_notice
	 */
	public void setId_emp_notice(String Id_emp_notice) {
		setAttrVal("Id_emp_notice", Id_emp_notice);
	}
	/**
	 * 通知经办人
	 * @return String
	 */
	public String getName_emp_notice() {
		return ((String) getAttrVal("Name_emp_notice"));
	}
	/**
	 * 通知经办人
	 * @param Name_emp_notice
	 */
	public void setName_emp_notice(String Name_emp_notice) {
		setAttrVal("Name_emp_notice", Name_emp_notice);
	}
	/**
	 * 通知下达日期
	 * @return String
	 */
	public String getDt_notice() {
		return ((String) getAttrVal("Dt_notice"));
	}
	/**
	 * 通知下达日期
	 * @param Dt_notice
	 */
	public void setDt_notice(String Dt_notice) {
		setAttrVal("Dt_notice", Dt_notice);
	}
	/**
	 * 手动配置标志
	 * @return FBoolean
	 */
	public FBoolean getFg_manual() {
		return ((FBoolean) getAttrVal("Fg_manual"));
	}
	/**
	 * 手动配置标志
	 * @param Fg_manual
	 */
	public void setFg_manual(FBoolean Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
	}
	/**
	 * 计划再入院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_plan() {
		return ((FBoolean) getAttrVal("Fg_plan"));
	}
	/**
	 * 计划再入院标志
	 * @param Fg_plan
	 */
	public void setFg_plan(FBoolean Fg_plan) {
		setAttrVal("Fg_plan", Fg_plan);
	}
	/**
	 * 预约床位特征集合
	 * @return FArrayList
	 */
	public FArrayList getBedattrs() {
		return ((FArrayList) getAttrVal("Bedattrs"));
	}
	/**
	 * 预约床位特征集合
	 * @param Bedattrs
	 */
	public void setBedattrs(FArrayList Bedattrs) {
		setAttrVal("Bedattrs", Bedattrs);
	}
	/**
	 * 申请单状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 申请单状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
	 * 预约人id
	 * @return String
	 */
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}
	/**
	 * 预约人id
	 * @param Id_emp_appt
	 */
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	/**
	 * 预约人
	 * @return String
	 */
	public String getName_emp_appt() {
		return ((String) getAttrVal("Name_emp_appt"));
	}
	/**
	 * 预约人
	 * @param Name_emp_appt
	 */
	public void setName_emp_appt(String Name_emp_appt) {
		setAttrVal("Name_emp_appt", Name_emp_appt);
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
	 * 床位属性
	 * @return String
	 */
	public String getBed_attr() {
		return ((String) getAttrVal("Bed_attr"));
	}
	/**
	 * 床位属性
	 * @param Bed_attr
	 */
	public void setBed_attr(String Bed_attr) {
		setAttrVal("Bed_attr", Bed_attr);
	}
	/**
	 * 床位所属病区
	 * @return String
	 */
	public String getId_dep_belong() {
		return ((String) getAttrVal("Id_dep_belong"));
	}
	/**
	 * 床位所属病区
	 * @param Id_dep_belong
	 */
	public void setId_dep_belong(String Id_dep_belong) {
		setAttrVal("Id_dep_belong", Id_dep_belong);
	}
	/**
	 * 申请单床位特征
	 * @return String
	 */
	public String getBed_attrs_str() {
		return ((String) getAttrVal("Bed_attrs_str"));
	}
	/**
	 * 申请单床位特征
	 * @param Bed_attrs_str
	 */
	public void setBed_attrs_str(String Bed_attrs_str) {
		setAttrVal("Bed_attrs_str", Bed_attrs_str);
	}
	/**
	 * 预约病区
	 * @return String
	 */
	public String getName_appt_nur_ip() {
		return ((String) getAttrVal("Name_appt_nur_ip"));
	}
	/**
	 * 预约病区
	 * @param Name_appt_nur_ip
	 */
	public void setName_appt_nur_ip(String Name_appt_nur_ip) {
		setAttrVal("Name_appt_nur_ip", Name_appt_nur_ip);
	}
	/**
	 * 剩余等待时间
	 * @return Integer
	 */
	public Integer getLeave_wait_days() {
		return ((Integer) getAttrVal("Leave_wait_days"));
	}
	/**
	 * 剩余等待时间
	 * @param Leave_wait_days
	 */
	public void setLeave_wait_days(Integer Leave_wait_days) {
		setAttrVal("Leave_wait_days", Leave_wait_days);
	}
	/**
	 * 剩余占床时间
	 * @return Integer
	 */
	public Integer getLeave_occp_bed_hours() {
		return ((Integer) getAttrVal("Leave_occp_bed_hours"));
	}
	/**
	 * 剩余占床时间
	 * @param Leave_occp_bed_hours
	 */
	public void setLeave_occp_bed_hours(Integer Leave_occp_bed_hours) {
		setAttrVal("Leave_occp_bed_hours", Leave_occp_bed_hours);
	}
	/**
	 * 排序类型
	 * @return String
	 */
	public String getSort_date_type() {
		return ((String) getAttrVal("Sort_date_type"));
	}
	/**
	 * 排序类型
	 * @param Sort_date_type
	 */
	public void setSort_date_type(String Sort_date_type) {
		setAttrVal("Sort_date_type", Sort_date_type);
	}
	/**
	 * 在院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标识
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
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
	 * 医生姓名
	 * @return String
	 */
	public String getName_cont_phy() {
		return ((String) getAttrVal("Name_cont_phy"));
	}
	/**
	 * 医生姓名
	 * @param Name_cont_phy
	 */
	public void setName_cont_phy(String Name_cont_phy) {
		setAttrVal("Name_cont_phy", Name_cont_phy);
	}
	/**
	 * 医生电话
	 * @return String
	 */
	public String getTel_cont_phy() {
		return ((String) getAttrVal("Tel_cont_phy"));
	}
	/**
	 * 医生电话
	 * @param Tel_cont_phy
	 */
	public void setTel_cont_phy(String Tel_cont_phy) {
		setAttrVal("Tel_cont_phy", Tel_cont_phy);
	}
	/**
	 * 来院方式名称
	 * @return String
	 */
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}
	/**
	 * 来院方式名称
	 * @param Name_referalsrc
	 */
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
	/**
	 * 来院方式id
	 * @return String
	 */
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}
	/**
	 * 来院方式id
	 * @param Id_referalsrc
	 */
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	/**
	 * 医生ID
	 * @return String
	 */
	public String getId_cont_phy() {
		return ((String) getAttrVal("Id_cont_phy"));
	}
	/**
	 * 医生ID
	 * @param Id_cont_phy
	 */
	public void setId_cont_phy(String Id_cont_phy) {
		setAttrVal("Id_cont_phy", Id_cont_phy);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getName_patcont() {
		return ((String) getAttrVal("Name_patcont"));
	}
	/**
	 * 联系人姓名
	 * @param Name_patcont
	 */
	public void setName_patcont(String Name_patcont) {
		setAttrVal("Name_patcont", Name_patcont);
	}
	/**
	 * 联系人参照
	 * @return String
	 */
	public String getName_patcontref() {
		return ((String) getAttrVal("Name_patcontref"));
	}
	/**
	 * 联系人参照
	 * @param Name_patcontref
	 */
	public void setName_patcontref(String Name_patcontref) {
		setAttrVal("Name_patcontref", Name_patcontref);
	}
	/**
	 * 联系人类型id
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}
	/**
	 * 联系人类型id
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人类型
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人类型
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人类型名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型名称
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getConttel() {
		return ((String) getAttrVal("Conttel"));
	}
	/**
	 * 联系人电话
	 * @param Conttel
	 */
	public void setConttel(String Conttel) {
		setAttrVal("Conttel", Conttel);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getContaddr() {
		return ((String) getAttrVal("Contaddr"));
	}
	/**
	 * 联系人地址
	 * @param Contaddr
	 */
	public void setContaddr(String Contaddr) {
		setAttrVal("Contaddr", Contaddr);
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
	 * 就诊联系人id
	 * @return String
	 */
	public String getId_entcont() {
		return ((String) getAttrVal("Id_entcont"));
	}
	/**
	 * 就诊联系人id
	 * @param Id_entcont
	 */
	public void setId_entcont(String Id_entcont) {
		setAttrVal("Id_entcont", Id_entcont);
	}
	/**
	 * 门诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 门诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 患者chis编号
	 * @return String
	 */
	public String getChis_pat() {
		return ((String) getAttrVal("Chis_pat"));
	}
	/**
	 * 患者chis编号
	 * @param Chis_pat
	 */
	public void setChis_pat(String Chis_pat) {
		setAttrVal("Chis_pat", Chis_pat);
	}
	/**
	 * 信息反馈
	 * @return String
	 */
	public String getInfofeedback() {
		return ((String) getAttrVal("Infofeedback"));
	}
	/**
	 * 信息反馈
	 * @param Infofeedback
	 */
	public void setInfofeedback(String Infofeedback) {
		setAttrVal("Infofeedback", Infofeedback);
	}
	/**
	 * 门诊就诊状态编码
	 * @return String
	 */
	public String getSd_status_op() {
		return ((String) getAttrVal("Sd_status_op"));
	}
	/**
	 * 门诊就诊状态编码
	 * @param Sd_status_op
	 */
	public void setSd_status_op(String Sd_status_op) {
		setAttrVal("Sd_status_op", Sd_status_op);
	}
	/**
	 * 住院就诊状态编码
	 * @return String
	 */
	public String getSd_status_ip() {
		return ((String) getAttrVal("Sd_status_ip"));
	}
	/**
	 * 住院就诊状态编码
	 * @param Sd_status_ip
	 */
	public void setSd_status_ip(String Sd_status_ip) {
		setAttrVal("Sd_status_ip", Sd_status_ip);
	}
	/**
	 * 送入方式
	 * @return String
	 */
	public String getName_walkwith() {
		return ((String) getAttrVal("Name_walkwith"));
	}
	/**
	 * 送入方式
	 * @param Name_walkwith
	 */
	public void setName_walkwith(String Name_walkwith) {
		setAttrVal("Name_walkwith", Name_walkwith);
	}
	/**
	 * 送入方式sd
	 * @return String
	 */
	public String getSd_walkwith() {
		return ((String) getAttrVal("Sd_walkwith"));
	}
	/**
	 * 送入方式sd
	 * @param Sd_walkwith
	 */
	public void setSd_walkwith(String Sd_walkwith) {
		setAttrVal("Sd_walkwith", Sd_walkwith);
	}
	/**
	 * 送入方式id
	 * @return String
	 */
	public String getId_walkwith() {
		return ((String) getAttrVal("Id_walkwith"));
	}
	/**
	 * 送入方式id
	 * @param Id_walkwith
	 */
	public void setId_walkwith(String Id_walkwith) {
		setAttrVal("Id_walkwith", Id_walkwith);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getChis_code() {
		return ((String) getAttrVal("Chis_code"));
	}
	/**
	 * 条码号
	 * @param Chis_code
	 */
	public void setChis_code(String Chis_code) {
		setAttrVal("Chis_code", Chis_code);
	}
	/**
	 * 选择标志
	 * @return FBoolean
	 */
	public FBoolean getFg_chose() {
		return ((FBoolean) getAttrVal("Fg_chose"));
	}
	/**
	 * 选择标志
	 * @param Fg_chose
	 */
	public void setFg_chose(FBoolean Fg_chose) {
		setAttrVal("Fg_chose", Fg_chose);
	}
	/**
	 * 介绍人
	 * @return String
	 */
	public String getId_introducer() {
		return ((String) getAttrVal("Id_introducer"));
	}
	/**
	 * 介绍人
	 * @param Id_introducer
	 */
	public void setId_introducer(String Id_introducer) {
		setAttrVal("Id_introducer", Id_introducer);
	}
	/**
	 * 介绍人姓名
	 * @return String
	 */
	public String getName_introducer() {
		return ((String) getAttrVal("Name_introducer"));
	}
	/**
	 * 介绍人姓名
	 * @param Name_introducer
	 */
	public void setName_introducer(String Name_introducer) {
		setAttrVal("Name_introducer", Name_introducer);
	}
	/**
	 * 籍贯id
	 * @return String
	 */
	public String getId_addr_origin() {
		return ((String) getAttrVal("Id_addr_origin"));
	}
	/**
	 * 籍贯id
	 * @param Id_addr_origin
	 */
	public void setId_addr_origin(String Id_addr_origin) {
		setAttrVal("Id_addr_origin", Id_addr_origin);
	}
	/**
	 * 籍贯编码
	 * @return String
	 */
	public String getSd_addr_origin() {
		return ((String) getAttrVal("Sd_addr_origin"));
	}
	/**
	 * 籍贯编码
	 * @param Sd_addr_origin
	 */
	public void setSd_addr_origin(String Sd_addr_origin) {
		setAttrVal("Sd_addr_origin", Sd_addr_origin);
	}
	/**
	 * 籍贯名称
	 * @return String
	 */
	public String getName_addr_origin() {
		return ((String) getAttrVal("Name_addr_origin"));
	}
	/**
	 * 籍贯名称
	 * @param Name_addr_origin
	 */
	public void setName_addr_origin(String Name_addr_origin) {
		setAttrVal("Name_addr_origin", Name_addr_origin);
	}
	/**
	 * 预住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ippre() {
		return ((FBoolean) getAttrVal("Fg_ippre"));
	}
	/**
	 * 预住院标志
	 * @param Fg_ippre
	 */
	public void setFg_ippre(FBoolean Fg_ippre) {
		setAttrVal("Fg_ippre", Fg_ippre);
	}
	/**
	 * 预住院科室id
	 * @return String
	 */
	public String getId_dep_phy_ippre() {
		return ((String) getAttrVal("Id_dep_phy_ippre"));
	}
	/**
	 * 预住院科室id
	 * @param Id_dep_phy_ippre
	 */
	public void setId_dep_phy_ippre(String Id_dep_phy_ippre) {
		setAttrVal("Id_dep_phy_ippre", Id_dep_phy_ippre);
	}
	/**
	 * 预住院科室名称
	 * @return String
	 */
	public String getName_dep_phy_ippre() {
		return ((String) getAttrVal("Name_dep_phy_ippre"));
	}
	/**
	 * 预住院科室名称
	 * @param Name_dep_phy_ippre
	 */
	public void setName_dep_phy_ippre(String Name_dep_phy_ippre) {
		setAttrVal("Name_dep_phy_ippre", Name_dep_phy_ippre);
	}
	/**
	 * 预住院病区id
	 * @return String
	 */
	public String getId_dep_nur_ippre() {
		return ((String) getAttrVal("Id_dep_nur_ippre"));
	}
	/**
	 * 预住院病区id
	 * @param Id_dep_nur_ippre
	 */
	public void setId_dep_nur_ippre(String Id_dep_nur_ippre) {
		setAttrVal("Id_dep_nur_ippre", Id_dep_nur_ippre);
	}
	/**
	 * 预住院病区名称
	 * @return String
	 */
	public String getName_dep_nur_ippre() {
		return ((String) getAttrVal("Name_dep_nur_ippre"));
	}
	/**
	 * 预住院病区名称
	 * @param Name_dep_nur_ippre
	 */
	public void setName_dep_nur_ippre(String Name_dep_nur_ippre) {
		setAttrVal("Name_dep_nur_ippre", Name_dep_nur_ippre);
	}
	/**
	 * 住院类别id
	 * @return String
	 */
	public String getId_kind() {
		return ((String) getAttrVal("Id_kind"));
	}
	/**
	 * 住院类别id
	 * @param Id_kind
	 */
	public void setId_kind(String Id_kind) {
		setAttrVal("Id_kind", Id_kind);
	}
	/**
	 * 住院类别编码
	 * @return String
	 */
	public String getSd_kind() {
		return ((String) getAttrVal("Sd_kind"));
	}
	/**
	 * 住院类别编码
	 * @param Sd_kind
	 */
	public void setSd_kind(String Sd_kind) {
		setAttrVal("Sd_kind", Sd_kind);
	}
	/**
	 * 住院类别名称
	 * @return String
	 */
	public String getName_kind() {
		return ((String) getAttrVal("Name_kind"));
	}
	/**
	 * 住院类别名称
	 * @param Name_kind
	 */
	public void setName_kind(String Name_kind) {
		setAttrVal("Name_kind", Name_kind);
	}
	/**
	 * 预住院医嘱项目名称
	 * @return String
	 */
	public String getName_item_or_ippre() {
		return ((String) getAttrVal("Name_item_or_ippre"));
	}
	/**
	 * 预住院医嘱项目名称
	 * @param Name_item_or_ippre
	 */
	public void setName_item_or_ippre(String Name_item_or_ippre) {
		setAttrVal("Name_item_or_ippre", Name_item_or_ippre);
	}
	/**
	 * 预约登记确认标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cfm_patinf() {
		return ((FBoolean) getAttrVal("Fg_cfm_patinf"));
	}
	/**
	 * 预约登记确认标志
	 * @param Fg_cfm_patinf
	 */
	public void setFg_cfm_patinf(FBoolean Fg_cfm_patinf) {
		setAttrVal("Fg_cfm_patinf", Fg_cfm_patinf);
	}
	/**
	 * 预约登记确认人员
	 * @return String
	 */
	public String getId_emp_cfm_patinf() {
		return ((String) getAttrVal("Id_emp_cfm_patinf"));
	}
	/**
	 * 预约登记确认人员
	 * @param Id_emp_cfm_patinf
	 */
	public void setId_emp_cfm_patinf(String Id_emp_cfm_patinf) {
		setAttrVal("Id_emp_cfm_patinf", Id_emp_cfm_patinf);
	}
	/**
	 * 预约登记确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cfm_patinf() {
		return ((FDateTime) getAttrVal("Dt_cfm_patinf"));
	}
	/**
	 * 预约登记确认时间
	 * @param Dt_cfm_patinf
	 */
	public void setDt_cfm_patinf(FDateTime Dt_cfm_patinf) {
		setAttrVal("Dt_cfm_patinf", Dt_cfm_patinf);
	}
	/**
	 * 日间医疗标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bedday() {
		return ((FBoolean) getAttrVal("Fg_bedday"));
	}
	/**
	 * 日间医疗标志
	 * @param Fg_bedday
	 */
	public void setFg_bedday(FBoolean Fg_bedday) {
		setAttrVal("Fg_bedday", Fg_bedday);
	}
	/**
	 * 手术id
	 * @return String
	 */
	public String getId_srv_opt() {
		return ((String) getAttrVal("Id_srv_opt"));
	}
	/**
	 * 手术id
	 * @param Id_srv_opt
	 */
	public void setId_srv_opt(String Id_srv_opt) {
		setAttrVal("Id_srv_opt", Id_srv_opt);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName_srv_opt() {
		return ((String) getAttrVal("Name_srv_opt"));
	}
	/**
	 * 手术名称
	 * @param Name_srv_opt
	 */
	public void setName_srv_opt(String Name_srv_opt) {
		setAttrVal("Name_srv_opt", Name_srv_opt);
	}
	/**
	 * 手术日期
	 * @return FDateTime
	 */
	public FDateTime getDt_opt() {
		return ((FDateTime) getAttrVal("Dt_opt"));
	}
	/**
	 * 手术日期
	 * @param Dt_opt
	 */
	public void setDt_opt(FDateTime Dt_opt) {
		setAttrVal("Dt_opt", Dt_opt);
	}
	/**
	 * 在院天数
	 * @return Integer
	 */
	public Integer getDays() {
		return ((Integer) getAttrVal("Days"));
	}
	/**
	 * 在院天数
	 * @param Days
	 */
	public void setDays(Integer Days) {
		setAttrVal("Days", Days);
	}
}