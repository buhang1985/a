package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊抢救入出转管理DTO DTO数据 
 * 
 */
public class UrgInOutTransMgrDTO extends BaseDTO {
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
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
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
	 * 就诊类型
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 有效期结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_valid_e() {
		return ((FDateTime) getAttrVal("Dt_valid_e"));
	}
	/**
	 * 有效期结束时间
	 * @param Dt_valid_e
	 */
	public void setDt_valid_e(FDateTime Dt_valid_e) {
		setAttrVal("Dt_valid_e", Dt_valid_e);
	}
	/**
	 * 就诊科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 就诊病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 就诊病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 就诊病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
	 * 到院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 到院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 滞留时长
	 * @return String
	 */
	public String getTimes_retention() {
		return ((String) getAttrVal("Times_retention"));
	}
	/**
	 * 滞留时长
	 * @param Times_retention
	 */
	public void setTimes_retention(String Times_retention) {
		setAttrVal("Times_retention", Times_retention);
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
	 * 急诊抢救状态编码
	 * @return String
	 */
	public String getEu_urginouttransstatus() {
		return ((String) getAttrVal("Eu_urginouttransstatus"));
	}
	/**
	 * 急诊抢救状态编码
	 * @param Eu_urginouttransstatus
	 */
	public void setEu_urginouttransstatus(String Eu_urginouttransstatus) {
		setAttrVal("Eu_urginouttransstatus", Eu_urginouttransstatus);
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
	 * 床位名称
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位名称
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 出生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_hms() {
		return ((FDateTime) getAttrVal("Dt_birth_hms"));
	}
	/**
	 * 出生时间
	 * @param Dt_birth_hms
	 */
	public void setDt_birth_hms(FDateTime Dt_birth_hms) {
		setAttrVal("Dt_birth_hms", Dt_birth_hms);
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
	 * 诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 护理级别id
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}
	/**
	 * 护理级别id
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 护理级别编码
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}
	/**
	 * 护理级别编码
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}
	/**
	 * 护理级别
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
	}
	/**
	 * 离院去向id
	 * @return String
	 */
	public String getId_gowhere() {
		return ((String) getAttrVal("Id_gowhere"));
	}
	/**
	 * 离院去向id
	 * @param Id_gowhere
	 */
	public void setId_gowhere(String Id_gowhere) {
		setAttrVal("Id_gowhere", Id_gowhere);
	}
	/**
	 * 离院去向编码
	 * @return String
	 */
	public String getSd_gowhere() {
		return ((String) getAttrVal("Sd_gowhere"));
	}
	/**
	 * 离院去向编码
	 * @param Sd_gowhere
	 */
	public void setSd_gowhere(String Sd_gowhere) {
		setAttrVal("Sd_gowhere", Sd_gowhere);
	}
	/**
	 * 离院去向
	 * @return String
	 */
	public String getName_gowhere() {
		return ((String) getAttrVal("Name_gowhere"));
	}
	/**
	 * 离院去向
	 * @param Name_gowhere
	 */
	public void setName_gowhere(String Name_gowhere) {
		setAttrVal("Name_gowhere", Name_gowhere);
	}
	/**
	 * 绿色通道id
	 * @return String
	 */
	public String getIds_green_channel_sym() {
		return ((String) getAttrVal("Ids_green_channel_sym"));
	}
	/**
	 * 绿色通道id
	 * @param Ids_green_channel_sym
	 */
	public void setIds_green_channel_sym(String Ids_green_channel_sym) {
		setAttrVal("Ids_green_channel_sym", Ids_green_channel_sym);
	}
	/**
	 * 绿色通道编码
	 * @return String
	 */
	public String getSds_green_channel_sym() {
		return ((String) getAttrVal("Sds_green_channel_sym"));
	}
	/**
	 * 绿色通道编码
	 * @param Sds_green_channel_sym
	 */
	public void setSds_green_channel_sym(String Sds_green_channel_sym) {
		setAttrVal("Sds_green_channel_sym", Sds_green_channel_sym);
	}
	/**
	 * 绿色通道
	 * @return String
	 */
	public String getNames_green_channel_sym() {
		return ((String) getAttrVal("Names_green_channel_sym"));
	}
	/**
	 * 绿色通道
	 * @param Names_green_channel_sym
	 */
	public void setNames_green_channel_sym(String Names_green_channel_sym) {
		setAttrVal("Names_green_channel_sym", Names_green_channel_sym);
	}
	/**
	 * 接诊医生id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 接诊医生id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 接诊医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 接诊医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
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
	 * 预检状态
	 * @return String
	 */
	public String getSd_status_erpre() {
		return ((String) getAttrVal("Sd_status_erpre"));
	}
	/**
	 * 预检状态
	 * @param Sd_status_erpre
	 */
	public void setSd_status_erpre(String Sd_status_erpre) {
		setAttrVal("Sd_status_erpre", Sd_status_erpre);
	}
	/**
	 * 分诊去向id
	 * @return String
	 */
	public String getId_triage_to() {
		return ((String) getAttrVal("Id_triage_to"));
	}
	/**
	 * 分诊去向id
	 * @param Id_triage_to
	 */
	public void setId_triage_to(String Id_triage_to) {
		setAttrVal("Id_triage_to", Id_triage_to);
	}
	/**
	 * 分诊去向编码
	 * @return String
	 */
	public String getSd_triage_to() {
		return ((String) getAttrVal("Sd_triage_to"));
	}
	/**
	 * 分诊去向编码
	 * @param Sd_triage_to
	 */
	public void setSd_triage_to(String Sd_triage_to) {
		setAttrVal("Sd_triage_to", Sd_triage_to);
	}
	/**
	 * 分诊去向
	 * @return String
	 */
	public String getName_triage_to() {
		return ((String) getAttrVal("Name_triage_to"));
	}
	/**
	 * 分诊去向
	 * @param Name_triage_to
	 */
	public void setName_triage_to(String Name_triage_to) {
		setAttrVal("Name_triage_to", Name_triage_to);
	}
	/**
	 * 新病区id
	 * @return String
	 */
	public String getId_dep_nur_new() {
		return ((String) getAttrVal("Id_dep_nur_new"));
	}
	/**
	 * 新病区id
	 * @param Id_dep_nur_new
	 */
	public void setId_dep_nur_new(String Id_dep_nur_new) {
		setAttrVal("Id_dep_nur_new", Id_dep_nur_new);
	}
	/**
	 * 新病区
	 * @return String
	 */
	public String getName_dep_nur_new() {
		return ((String) getAttrVal("Name_dep_nur_new"));
	}
	/**
	 * 新病区
	 * @param Name_dep_nur_new
	 */
	public void setName_dep_nur_new(String Name_dep_nur_new) {
		setAttrVal("Name_dep_nur_new", Name_dep_nur_new);
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
	 * 新床位
	 * @return String
	 */
	public String getName_bed_new() {
		return ((String) getAttrVal("Name_bed_new"));
	}
	/**
	 * 新床位
	 * @param Name_bed_new
	 */
	public void setName_bed_new(String Name_bed_new) {
		setAttrVal("Name_bed_new", Name_bed_new);
	}
	/**
	 * 新接诊医生id
	 * @return String
	 */
	public String getId_emp_phy_new() {
		return ((String) getAttrVal("Id_emp_phy_new"));
	}
	/**
	 * 新接诊医生id
	 * @param Id_emp_phy_new
	 */
	public void setId_emp_phy_new(String Id_emp_phy_new) {
		setAttrVal("Id_emp_phy_new", Id_emp_phy_new);
	}
	/**
	 * 新接诊医生
	 * @return String
	 */
	public String getName_emp_phy_new() {
		return ((String) getAttrVal("Name_emp_phy_new"));
	}
	/**
	 * 新接诊医生
	 * @param Name_emp_phy_new
	 */
	public void setName_emp_phy_new(String Name_emp_phy_new) {
		setAttrVal("Name_emp_phy_new", Name_emp_phy_new);
	}
	/**
	 * 新护理级别id
	 * @return String
	 */
	public String getId_level_nur_new() {
		return ((String) getAttrVal("Id_level_nur_new"));
	}
	/**
	 * 新护理级别id
	 * @param Id_level_nur_new
	 */
	public void setId_level_nur_new(String Id_level_nur_new) {
		setAttrVal("Id_level_nur_new", Id_level_nur_new);
	}
	/**
	 * 新护理级别编码
	 * @return String
	 */
	public String getSd_level_nur_new() {
		return ((String) getAttrVal("Sd_level_nur_new"));
	}
	/**
	 * 新护理级别编码
	 * @param Sd_level_nur_new
	 */
	public void setSd_level_nur_new(String Sd_level_nur_new) {
		setAttrVal("Sd_level_nur_new", Sd_level_nur_new);
	}
	/**
	 * 新护理级别
	 * @return String
	 */
	public String getName_level_nur_new() {
		return ((String) getAttrVal("Name_level_nur_new"));
	}
	/**
	 * 新护理级别
	 * @param Name_level_nur_new
	 */
	public void setName_level_nur_new(String Name_level_nur_new) {
		setAttrVal("Name_level_nur_new", Name_level_nur_new);
	}
	/**
	 * 转科时间
	 * @return FDateTime
	 */
	public FDateTime getDt_trans() {
		return ((FDateTime) getAttrVal("Dt_trans"));
	}
	/**
	 * 转科时间
	 * @param Dt_trans
	 */
	public void setDt_trans(FDateTime Dt_trans) {
		setAttrVal("Dt_trans", Dt_trans);
	}
}