package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊留观许可dto DTO数据 
 * 
 */
public class EnObsPermitDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 留观许可id
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}
	/**
	 * 留观许可id
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
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
	 * 婚姻状况id
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}
	/**
	 * 婚姻状况id
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻状况名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}
	/**
	 * 婚姻状况名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 绿色通道id
	 * @return String
	 */
	public String getIds_green_channel() {
		return ((String) getAttrVal("Ids_green_channel"));
	}
	/**
	 * 绿色通道id
	 * @param Ids_green_channel
	 */
	public void setIds_green_channel(String Ids_green_channel) {
		setAttrVal("Ids_green_channel", Ids_green_channel);
	}
	/**
	 * 绿色通道
	 * @return String
	 */
	public String getNames_green_channel() {
		return ((String) getAttrVal("Names_green_channel"));
	}
	/**
	 * 绿色通道
	 * @param Names_green_channel
	 */
	public void setNames_green_channel(String Names_green_channel) {
		setAttrVal("Names_green_channel", Names_green_channel);
	}
	/**
	 * 分诊科室id
	 * @return String
	 */
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}
	/**
	 * 分诊科室id
	 * @param Id_dep_to
	 */
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	/**
	 * 分诊科室
	 * @return String
	 */
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}
	/**
	 * 分诊科室
	 * @param Name_dep_to
	 */
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
	}
	/**
	 * 证件类型id
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 证件类型id
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 预检分级id
	 * @return String
	 */
	public String getId_scale_triage() {
		return ((String) getAttrVal("Id_scale_triage"));
	}
	/**
	 * 预检分级id
	 * @param Id_scale_triage
	 */
	public void setId_scale_triage(String Id_scale_triage) {
		setAttrVal("Id_scale_triage", Id_scale_triage);
	}
	/**
	 * 预检分级编码
	 * @return String
	 */
	public String getSd_scale_triage() {
		return ((String) getAttrVal("Sd_scale_triage"));
	}
	/**
	 * 预检分级编码
	 * @param Sd_scale_triage
	 */
	public void setSd_scale_triage(String Sd_scale_triage) {
		setAttrVal("Sd_scale_triage", Sd_scale_triage);
	}
	/**
	 * 预检分级
	 * @return String
	 */
	public String getName_scale_triage() {
		return ((String) getAttrVal("Name_scale_triage"));
	}
	/**
	 * 预检分级
	 * @param Name_scale_triage
	 */
	public void setName_scale_triage(String Name_scale_triage) {
		setAttrVal("Name_scale_triage", Name_scale_triage);
	}
	/**
	 * 预检时间
	 * @return FDateTime
	 */
	public FDateTime getDt_erpre() {
		return ((FDateTime) getAttrVal("Dt_erpre"));
	}
	/**
	 * 预检时间
	 * @param Dt_erpre
	 */
	public void setDt_erpre(FDateTime Dt_erpre) {
		setAttrVal("Dt_erpre", Dt_erpre);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 联系电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 现住址区县id
	 * @return String
	 */
	public String getId_addr_now() {
		return ((String) getAttrVal("Id_addr_now"));
	}
	/**
	 * 现住址区县id
	 * @param Id_addr_now
	 */
	public void setId_addr_now(String Id_addr_now) {
		setAttrVal("Id_addr_now", Id_addr_now);
	}
	/**
	 * 现住址区县编码
	 * @return String
	 */
	public String getCode_addr_now() {
		return ((String) getAttrVal("Code_addr_now"));
	}
	/**
	 * 现住址区县编码
	 * @param Code_addr_now
	 */
	public void setCode_addr_now(String Code_addr_now) {
		setAttrVal("Code_addr_now", Code_addr_now);
	}
	/**
	 * 现住址区县
	 * @return String
	 */
	public String getName_addr_now() {
		return ((String) getAttrVal("Name_addr_now"));
	}
	/**
	 * 现住址区县
	 * @param Name_addr_now
	 */
	public void setName_addr_now(String Name_addr_now) {
		setAttrVal("Name_addr_now", Name_addr_now);
	}
	/**
	 * 现住址街道
	 * @return String
	 */
	public String getStreet_addr_now() {
		return ((String) getAttrVal("Street_addr_now"));
	}
	/**
	 * 现住址街道
	 * @param Street_addr_now
	 */
	public void setStreet_addr_now(String Street_addr_now) {
		setAttrVal("Street_addr_now", Street_addr_now);
	}
	/**
	 * 患者联系人id
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}
	/**
	 * 患者联系人id
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
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
	 * 联系人类型编码
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人类型编码
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
	 * 门诊诊断id
	 * @return String
	 */
	public String getId_didef_op() {
		return ((String) getAttrVal("Id_didef_op"));
	}
	/**
	 * 门诊诊断id
	 * @param Id_didef_op
	 */
	public void setId_didef_op(String Id_didef_op) {
		setAttrVal("Id_didef_op", Id_didef_op);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef_op() {
		return ((String) getAttrVal("Name_didef_op"));
	}
	/**
	 * 诊断名称
	 * @param Name_didef_op
	 */
	public void setName_didef_op(String Name_didef_op) {
		setAttrVal("Name_didef_op", Name_didef_op);
	}
	/**
	 * 诊断补充说明
	 * @return String
	 */
	public String getSupplement_di() {
		return ((String) getAttrVal("Supplement_di"));
	}
	/**
	 * 诊断补充说明
	 * @param Supplement_di
	 */
	public void setSupplement_di(String Supplement_di) {
		setAttrVal("Supplement_di", Supplement_di);
	}
	/**
	 * 留观科室
	 * @return String
	 */
	public String getId_dep_phy_ip() {
		return ((String) getAttrVal("Id_dep_phy_ip"));
	}
	/**
	 * 留观科室
	 * @param Id_dep_phy_ip
	 */
	public void setId_dep_phy_ip(String Id_dep_phy_ip) {
		setAttrVal("Id_dep_phy_ip", Id_dep_phy_ip);
	}
	/**
	 * 留观科室id
	 * @return String
	 */
	public String getName_dep_phy_ip() {
		return ((String) getAttrVal("Name_dep_phy_ip"));
	}
	/**
	 * 留观科室id
	 * @param Name_dep_phy_ip
	 */
	public void setName_dep_phy_ip(String Name_dep_phy_ip) {
		setAttrVal("Name_dep_phy_ip", Name_dep_phy_ip);
	}
	/**
	 * 留观病区id
	 * @return String
	 */
	public String getId_dep_nur_ip() {
		return ((String) getAttrVal("Id_dep_nur_ip"));
	}
	/**
	 * 留观病区id
	 * @param Id_dep_nur_ip
	 */
	public void setId_dep_nur_ip(String Id_dep_nur_ip) {
		setAttrVal("Id_dep_nur_ip", Id_dep_nur_ip);
	}
	/**
	 * 留观病区
	 * @return String
	 */
	public String getName_dep_nur_ip() {
		return ((String) getAttrVal("Name_dep_nur_ip"));
	}
	/**
	 * 留观病区
	 * @param Name_dep_nur_ip
	 */
	public void setName_dep_nur_ip(String Name_dep_nur_ip) {
		setAttrVal("Name_dep_nur_ip", Name_dep_nur_ip);
	}
	/**
	 * 病情状况id
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情状况id
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情级别编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情级别编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病情状况
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情状况
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 申请开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}
	/**
	 * 申请开立时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	/**
	 * 预交金
	 * @return FDouble
	 */
	public FDouble getAmt_deposit() {
		return ((FDouble) getAttrVal("Amt_deposit"));
	}
	/**
	 * 预交金
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
	 * 急诊就诊科室id
	 * @return String
	 */
	public String getId_dep_op() {
		return ((String) getAttrVal("Id_dep_op"));
	}
	/**
	 * 急诊就诊科室id
	 * @param Id_dep_op
	 */
	public void setId_dep_op(String Id_dep_op) {
		setAttrVal("Id_dep_op", Id_dep_op);
	}
	/**
	 * 急诊就诊科室名称
	 * @return String
	 */
	public String getName_dep_op() {
		return ((String) getAttrVal("Name_dep_op"));
	}
	/**
	 * 急诊就诊科室名称
	 * @param Name_dep_op
	 */
	public void setName_dep_op(String Name_dep_op) {
		setAttrVal("Name_dep_op", Name_dep_op);
	}
	/**
	 * 急诊医生
	 * @return String
	 */
	public String getId_emp_phy_op() {
		return ((String) getAttrVal("Id_emp_phy_op"));
	}
	/**
	 * 急诊医生
	 * @param Id_emp_phy_op
	 */
	public void setId_emp_phy_op(String Id_emp_phy_op) {
		setAttrVal("Id_emp_phy_op", Id_emp_phy_op);
	}
	/**
	 * 急诊医生名称
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}
	/**
	 * 急诊医生名称
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 急诊状态
	 * @return String
	 */
	public String getSd_status_op() {
		return ((String) getAttrVal("Sd_status_op"));
	}
	/**
	 * 急诊状态
	 * @param Sd_status_op
	 */
	public void setSd_status_op(String Sd_status_op) {
		setAttrVal("Sd_status_op", Sd_status_op);
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
	 * 计划留观时间
	 * @return FDate
	 */
	public FDate getDt_admit_plan() {
		return ((FDate) getAttrVal("Dt_admit_plan"));
	}
	/**
	 * 计划留观时间
	 * @param Dt_admit_plan
	 */
	public void setDt_admit_plan(FDate Dt_admit_plan) {
		setAttrVal("Dt_admit_plan", Dt_admit_plan);
	}
	/**
	 * 申请有效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_valid() {
		return ((FDateTime) getAttrVal("Dt_valid"));
	}
	/**
	 * 申请有效时间
	 * @param Dt_valid
	 */
	public void setDt_valid(FDateTime Dt_valid) {
		setAttrVal("Dt_valid", Dt_valid);
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
	 * 患者是否在院
	 * @return FBoolean
	 */
	public FBoolean getFg_inhos() {
		return ((FBoolean) getAttrVal("Fg_inhos"));
	}
	/**
	 * 患者是否在院
	 * @param Fg_inhos
	 */
	public void setFg_inhos(FBoolean Fg_inhos) {
		setAttrVal("Fg_inhos", Fg_inhos);
	}
	/**
	 * 是否有其他有效的申请单
	 * @return FBoolean
	 */
	public FBoolean getFg_other_apply() {
		return ((FBoolean) getAttrVal("Fg_other_apply"));
	}
	/**
	 * 是否有其他有效的申请单
	 * @param Fg_other_apply
	 */
	public void setFg_other_apply(FBoolean Fg_other_apply) {
		setAttrVal("Fg_other_apply", Fg_other_apply);
	}
}