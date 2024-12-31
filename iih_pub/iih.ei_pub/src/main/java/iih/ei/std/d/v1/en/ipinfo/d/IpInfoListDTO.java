package iih.ei.std.d.v1.en.ipinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院信息 DTO数据 
 * 
 */
public class IpInfoListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病人编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 病人编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}	
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getTotal_days() {
		return ((Integer) getAttrVal("Total_days"));
	}	
	/**
	 * 住院天数
	 * @param Total_days
	 */
	public void setTotal_days(Integer Total_days) {
		setAttrVal("Total_days", Total_days);
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
	 * 黑名单标志
	 * @return FBoolean
	 */
	public FBoolean getFlag_black() {
		return ((FBoolean) getAttrVal("Flag_black"));
	}	
	/**
	 * 黑名单标志
	 * @param Flag_black
	 */
	public void setFlag_black(FBoolean Flag_black) {
		setAttrVal("Flag_black", Flag_black);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_date() {
		return ((FDate) getAttrVal("Dt_birth_date"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth_date
	 */
	public void setDt_birth_date(FDate Dt_birth_date) {
		setAttrVal("Dt_birth_date", Dt_birth_date);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
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
	 * 患者分类名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}	
	/**
	 * 患者分类名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 价格分类编码
	 * @return String
	 */
	public String getSd_pripat() {
		return ((String) getAttrVal("Sd_pripat"));
	}	
	/**
	 * 价格分类编码
	 * @param Sd_pripat
	 */
	public void setSd_pripat(String Sd_pripat) {
		setAttrVal("Sd_pripat", Sd_pripat);
	}
	/**
	 * 价格分类名称
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}	
	/**
	 * 价格分类名称
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 医保编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	/**
	 * 医保名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
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
	 * 入院科室编码
	 * @return String
	 */
	public String getCode_dep_adm() {
		return ((String) getAttrVal("Code_dep_adm"));
	}	
	/**
	 * 入院科室编码
	 * @param Code_dep_adm
	 */
	public void setCode_dep_adm(String Code_dep_adm) {
		setAttrVal("Code_dep_adm", Code_dep_adm);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getName_dep_adm() {
		return ((String) getAttrVal("Name_dep_adm"));
	}	
	/**
	 * 入院科室名称
	 * @param Name_dep_adm
	 */
	public void setName_dep_adm(String Name_dep_adm) {
		setAttrVal("Name_dep_adm", Name_dep_adm);
	}
	/**
	 * 入院病区编码
	 * @return String
	 */
	public String getCode_dep_nur_adm() {
		return ((String) getAttrVal("Code_dep_nur_adm"));
	}	
	/**
	 * 入院病区编码
	 * @param Code_dep_nur_adm
	 */
	public void setCode_dep_nur_adm(String Code_dep_nur_adm) {
		setAttrVal("Code_dep_nur_adm", Code_dep_nur_adm);
	}
	/**
	 * 入院病区名称
	 * @return String
	 */
	public String getName_dep_nur_adm() {
		return ((String) getAttrVal("Name_dep_nur_adm"));
	}	
	/**
	 * 入院病区名称
	 * @param Name_dep_nur_adm
	 */
	public void setName_dep_nur_adm(String Name_dep_nur_adm) {
		setAttrVal("Name_dep_nur_adm", Name_dep_nur_adm);
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
	 * 病区编码
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 病区编码
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 病区名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 入院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 住院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 住院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 家庭住址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}	
	/**
	 * 家庭住址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getId_type() {
		return ((String) getAttrVal("Id_type"));
	}	
	/**
	 * 证件类型
	 * @param Id_type
	 */
	public void setId_type(String Id_type) {
		setAttrVal("Id_type", Id_type);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}	
	/**
	 * 证件号
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 就诊状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
	 * 责任护士
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}	
	/**
	 * 责任护士
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
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
	 * 责任医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 责任医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 开通手机app标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mobapp() {
		return ((FBoolean) getAttrVal("Fg_mobapp"));
	}	
	/**
	 * 开通手机app标志
	 * @param Fg_mobapp
	 */
	public void setFg_mobapp(FBoolean Fg_mobapp) {
		setAttrVal("Fg_mobapp", Fg_mobapp);
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
	 * 更新时间
	 * @return String
	 */
	public String getUpdate_time() {
		return ((String) getAttrVal("Update_time"));
	}	
	/**
	 * 更新时间
	 * @param Update_time
	 */
	public void setUpdate_time(String Update_time) {
		setAttrVal("Update_time", Update_time);
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
	 * 科室ID
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 科室ID
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 病区ID
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 病区ID
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 责任医生ID
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	/**
	 * 责任医生ID
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 责任护士ID
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	/**
	 * 责任护士ID
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 入院科室ID
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}	
	/**
	 * 入院科室ID
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院病区ID
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}	
	/**
	 * 入院病区ID
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 黑名单记录
	 * @return Integer
	 */
	public Integer getCount_bbr() {
		return ((Integer) getAttrVal("Count_bbr"));
	}	
	/**
	 * 黑名单记录
	 * @param Count_bbr
	 */
	public void setCount_bbr(Integer Count_bbr) {
		setAttrVal("Count_bbr", Count_bbr);
	}
}