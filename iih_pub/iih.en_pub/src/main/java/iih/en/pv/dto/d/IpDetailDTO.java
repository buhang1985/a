package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院详细信息DTO DTO数据 
 * 
 */
public class IpDetailDTO extends BaseDTO {
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
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	 * 性别
	 * @return String
	 */
	public String getName_sex_pat() {
		return ((String) getAttrVal("Name_sex_pat"));
	}
	/**
	 * 性别
	 * @param Name_sex_pat
	 */
	public void setName_sex_pat(String Name_sex_pat) {
		setAttrVal("Name_sex_pat", Name_sex_pat);
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
	 * 证件号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
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
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_mari_pat() {
		return ((String) getAttrVal("Sd_mari_pat"));
	}
	/**
	 * 婚姻状况编码
	 * @param Sd_mari_pat
	 */
	public void setSd_mari_pat(String Sd_mari_pat) {
		setAttrVal("Sd_mari_pat", Sd_mari_pat);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getName_mari_pat() {
		return ((String) getAttrVal("Name_mari_pat"));
	}
	/**
	 * 婚姻状况
	 * @param Name_mari_pat
	 */
	public void setName_mari_pat(String Name_mari_pat) {
		setAttrVal("Name_mari_pat", Name_mari_pat);
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
	 * 患者价格分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 患者信用分类id
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}
	/**
	 * 患者信用分类id
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 患者信用分类
	 * @return String
	 */
	public String getName_patcret() {
		return ((String) getAttrVal("Name_patcret"));
	}
	/**
	 * 患者信用分类
	 * @param Name_patcret
	 */
	public void setName_patcret(String Name_patcret) {
		setAttrVal("Name_patcret", Name_patcret);
	}
	/**
	 * 主医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 主医保计划
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 主医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 主医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 辅医保计划id
	 * @return String
	 */
	public String getId_hp_as() {
		return ((String) getAttrVal("Id_hp_as"));
	}
	/**
	 * 辅医保计划id
	 * @param Id_hp_as
	 */
	public void setId_hp_as(String Id_hp_as) {
		setAttrVal("Id_hp_as", Id_hp_as);
	}
	/**
	 * 辅医保计划
	 * @return String
	 */
	public String getName_hp_as() {
		return ((String) getAttrVal("Name_hp_as"));
	}
	/**
	 * 辅医保计划
	 * @param Name_hp_as
	 */
	public void setName_hp_as(String Name_hp_as) {
		setAttrVal("Name_hp_as", Name_hp_as);
	}
	/**
	 * 辅医保卡号
	 * @return String
	 */
	public String getNo_hp_as() {
		return ((String) getAttrVal("No_hp_as"));
	}
	/**
	 * 辅医保卡号
	 * @param No_hp_as
	 */
	public void setNo_hp_as(String No_hp_as) {
		setAttrVal("No_hp_as", No_hp_as);
	}
	/**
	 * 现住址区县码id
	 * @return String
	 */
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}
	/**
	 * 现住址区县码id
	 * @param Id_admdiv
	 */
	public void setId_admdiv(String Id_admdiv) {
		setAttrVal("Id_admdiv", Id_admdiv);
	}
	/**
	 * 现住址区县码编码
	 * @return String
	 */
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}
	/**
	 * 现住址区县码编码
	 * @param Sd_admdiv
	 */
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
	}
	/**
	 * 现住址区县码
	 * @return String
	 */
	public String getName_admdiv() {
		return ((String) getAttrVal("Name_admdiv"));
	}
	/**
	 * 现住址区县码
	 * @param Name_admdiv
	 */
	public void setName_admdiv(String Name_admdiv) {
		setAttrVal("Name_admdiv", Name_admdiv);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 现住址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getCont_name() {
		return ((String) getAttrVal("Cont_name"));
	}
	/**
	 * 联系人
	 * @param Cont_name
	 */
	public void setCont_name(String Cont_name) {
		setAttrVal("Cont_name", Cont_name);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getCont_address() {
		return ((String) getAttrVal("Cont_address"));
	}
	/**
	 * 联系人地址
	 * @param Cont_address
	 */
	public void setCont_address(String Cont_address) {
		setAttrVal("Cont_address", Cont_address);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getCont_tel() {
		return ((String) getAttrVal("Cont_tel"));
	}
	/**
	 * 联系人电话
	 * @param Cont_tel
	 */
	public void setCont_tel(String Cont_tel) {
		setAttrVal("Cont_tel", Cont_tel);
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
	 * 联系人类型
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
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
	 * 来院方式编码
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 来院方式编码
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 来院方式
	 * @return String
	 */
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}
	/**
	 * 来院方式
	 * @param Name_referalsrc
	 */
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
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
	 * 入院病区sd
	 * @return String
	 */
	public String getSd_dep_nuradm() {
		return ((String) getAttrVal("Sd_dep_nuradm"));
	}
	/**
	 * 入院病区sd
	 * @param Sd_dep_nuradm
	 */
	public void setSd_dep_nuradm(String Sd_dep_nuradm) {
		setAttrVal("Sd_dep_nuradm", Sd_dep_nuradm);
	}
	/**
	 * 住院诊断
	 * @return String
	 */
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}
	/**
	 * 住院诊断
	 * @param Id_didef_dis
	 */
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
	/**
	 * 住院诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}
	/**
	 * 住院诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 诊断补充说明
	 * @return String
	 */
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}
	/**
	 * 诊断补充说明
	 * @param Supplement
	 */
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
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
	 * 当前科室sd
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 当前科室sd
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
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
	 * 当前病区sd
	 * @return String
	 */
	public String getSd_dep_nur() {
		return ((String) getAttrVal("Sd_dep_nur"));
	}
	/**
	 * 当前病区sd
	 * @param Sd_dep_nur
	 */
	public void setSd_dep_nur(String Sd_dep_nur) {
		setAttrVal("Sd_dep_nur", Sd_dep_nur);
	}
	/**
	 * 主管医生id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 主管医生id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 主管医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 主管医生
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
	 * 护理等级id
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}
	/**
	 * 护理等级id
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 护理等级编码
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}
	/**
	 * 护理等级编码
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 护理等级
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}
	/**
	 * 护理等级
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
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
	 * 病情等级编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情等级编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病情等级
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情等级
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
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
	 * 营养等级id
	 * @return String
	 */
	public String getId_level_nutr() {
		return ((String) getAttrVal("Id_level_nutr"));
	}
	/**
	 * 营养等级id
	 * @param Id_level_nutr
	 */
	public void setId_level_nutr(String Id_level_nutr) {
		setAttrVal("Id_level_nutr", Id_level_nutr);
	}
	/**
	 * 营养等级编码
	 * @return String
	 */
	public String getSd_level_nutr() {
		return ((String) getAttrVal("Sd_level_nutr"));
	}
	/**
	 * 营养等级编码
	 * @param Sd_level_nutr
	 */
	public void setSd_level_nutr(String Sd_level_nutr) {
		setAttrVal("Sd_level_nutr", Sd_level_nutr);
	}
	/**
	 * 营养等级
	 * @return String
	 */
	public String getName_level_nutr() {
		return ((String) getAttrVal("Name_level_nutr"));
	}
	/**
	 * 营养等级
	 * @param Name_level_nutr
	 */
	public void setName_level_nutr(String Name_level_nutr) {
		setAttrVal("Name_level_nutr", Name_level_nutr);
	}
	/**
	 * 新生儿标志
	 * @return FBoolean
	 */
	public FBoolean getFg_newborn() {
		return ((FBoolean) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新生儿标志
	 * @param Fg_newborn
	 */
	public void setFg_newborn(FBoolean Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getHosdays() {
		return ((Integer) getAttrVal("Hosdays"));
	}
	/**
	 * 住院天数
	 * @param Hosdays
	 */
	public void setHosdays(Integer Hosdays) {
		setAttrVal("Hosdays", Hosdays);
	}
	/**
	 * 转科科室id
	 * @return String
	 */
	public String getId_dep_trans() {
		return ((String) getAttrVal("Id_dep_trans"));
	}
	/**
	 * 转科科室id
	 * @param Id_dep_trans
	 */
	public void setId_dep_trans(String Id_dep_trans) {
		setAttrVal("Id_dep_trans", Id_dep_trans);
	}
	/**
	 * 转科科室
	 * @return String
	 */
	public String getName_dep_trans() {
		return ((String) getAttrVal("Name_dep_trans"));
	}
	/**
	 * 转科科室
	 * @param Name_dep_trans
	 */
	public void setName_dep_trans(String Name_dep_trans) {
		setAttrVal("Name_dep_trans", Name_dep_trans);
	}
	/**
	 * 转科科室sd
	 * @return String
	 */
	public String getSd_dep_trans() {
		return ((String) getAttrVal("Sd_dep_trans"));
	}
	/**
	 * 转科科室sd
	 * @param Sd_dep_trans
	 */
	public void setSd_dep_trans(String Sd_dep_trans) {
		setAttrVal("Sd_dep_trans", Sd_dep_trans);
	}
	/**
	 * 出院病区id
	 * @return String
	 */
	public String getId_dep_nurdisc() {
		return ((String) getAttrVal("Id_dep_nurdisc"));
	}
	/**
	 * 出院病区id
	 * @param Id_dep_nurdisc
	 */
	public void setId_dep_nurdisc(String Id_dep_nurdisc) {
		setAttrVal("Id_dep_nurdisc", Id_dep_nurdisc);
	}
	/**
	 * 出院病区
	 * @return String
	 */
	public String getName_dep_nurdisc() {
		return ((String) getAttrVal("Name_dep_nurdisc"));
	}
	/**
	 * 出院病区
	 * @param Name_dep_nurdisc
	 */
	public void setName_dep_nurdisc(String Name_dep_nurdisc) {
		setAttrVal("Name_dep_nurdisc", Name_dep_nurdisc);
	}
	/**
	 * 出院病区sd
	 * @return String
	 */
	public String getSd_dep_nurdisc() {
		return ((String) getAttrVal("Sd_dep_nurdisc"));
	}
	/**
	 * 出院病区sd
	 * @param Sd_dep_nurdisc
	 */
	public void setSd_dep_nurdisc(String Sd_dep_nurdisc) {
		setAttrVal("Sd_dep_nurdisc", Sd_dep_nurdisc);
	}
	/**
	 * 出院科室id
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}
	/**
	 * 出院科室id
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getName_dep_phydisc() {
		return ((String) getAttrVal("Name_dep_phydisc"));
	}
	/**
	 * 出院科室
	 * @param Name_dep_phydisc
	 */
	public void setName_dep_phydisc(String Name_dep_phydisc) {
		setAttrVal("Name_dep_phydisc", Name_dep_phydisc);
	}
	/**
	 * 出院科室sd
	 * @return String
	 */
	public String getSd_dep_phydisc() {
		return ((String) getAttrVal("Sd_dep_phydisc"));
	}
	/**
	 * 出院科室sd
	 * @param Sd_dep_phydisc
	 */
	public void setSd_dep_phydisc(String Sd_dep_phydisc) {
		setAttrVal("Sd_dep_phydisc", Sd_dep_phydisc);
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
	 * 入院科室编码
	 * @return String
	 */
	public String getCode_dep_phyadm() {
		return ((String) getAttrVal("Code_dep_phyadm"));
	}
	/**
	 * 入院科室编码
	 * @param Code_dep_phyadm
	 */
	public void setCode_dep_phyadm(String Code_dep_phyadm) {
		setAttrVal("Code_dep_phyadm", Code_dep_phyadm);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室名称
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 入院诊断id
	 * @return String
	 */
	public String getId_di_entry() {
		return ((String) getAttrVal("Id_di_entry"));
	}
	/**
	 * 入院诊断id
	 * @param Id_di_entry
	 */
	public void setId_di_entry(String Id_di_entry) {
		setAttrVal("Id_di_entry", Id_di_entry);
	}
	/**
	 * 入院诊断编码
	 * @return String
	 */
	public String getCode_di_entry() {
		return ((String) getAttrVal("Code_di_entry"));
	}
	/**
	 * 入院诊断编码
	 * @param Code_di_entry
	 */
	public void setCode_di_entry(String Code_di_entry) {
		setAttrVal("Code_di_entry", Code_di_entry);
	}
	/**
	 * 入院诊断名称
	 * @return String
	 */
	public String getName_di_entry() {
		return ((String) getAttrVal("Name_di_entry"));
	}
	/**
	 * 入院诊断名称
	 * @param Name_di_entry
	 */
	public void setName_di_entry(String Name_di_entry) {
		setAttrVal("Name_di_entry", Name_di_entry);
	}
	/**
	 * 入院诊断说明
	 * @return String
	 */
	public String getSupl_di_entry() {
		return ((String) getAttrVal("Supl_di_entry"));
	}
	/**
	 * 入院诊断说明
	 * @param Supl_di_entry
	 */
	public void setSupl_di_entry(String Supl_di_entry) {
		setAttrVal("Supl_di_entry", Supl_di_entry);
	}
	/**
	 * 新生儿体重
	 * @return FDouble
	 */
	public FDouble getWeight_nb() {
		return ((FDouble) getAttrVal("Weight_nb"));
	}
	/**
	 * 新生儿体重
	 * @param Weight_nb
	 */
	public void setWeight_nb(FDouble Weight_nb) {
		setAttrVal("Weight_nb", Weight_nb);
	}
	/**
	 * 现住址区县全称
	 * @return String
	 */
	public String getFullname_admdiv() {
		return ((String) getAttrVal("Fullname_admdiv"));
	}
	/**
	 * 现住址区县全称
	 * @param Fullname_admdiv
	 */
	public void setFullname_admdiv(String Fullname_admdiv) {
		setAttrVal("Fullname_admdiv", Fullname_admdiv);
	}
	/**
	 * 住院诊断code
	 * @return String
	 */
	public String getCode_didef_dis() {
		return ((String) getAttrVal("Code_didef_dis"));
	}
	/**
	 * 住院诊断code
	 * @param Code_didef_dis
	 */
	public void setCode_didef_dis(String Code_didef_dis) {
		setAttrVal("Code_didef_dis", Code_didef_dis);
	}
	/**
	 * 付款方式sd
	 * @return String
	 */
	public String getSd_pay_mothod() {
		return ((String) getAttrVal("Sd_pay_mothod"));
	}
	/**
	 * 付款方式sd
	 * @param Sd_pay_mothod
	 */
	public void setSd_pay_mothod(String Sd_pay_mothod) {
		setAttrVal("Sd_pay_mothod", Sd_pay_mothod);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getName_pay_mothod() {
		return ((String) getAttrVal("Name_pay_mothod"));
	}
	/**
	 * 付款方式
	 * @param Name_pay_mothod
	 */
	public void setName_pay_mothod(String Name_pay_mothod) {
		setAttrVal("Name_pay_mothod", Name_pay_mothod);
	}
	/**
	 * 付款方式id
	 * @return String
	 */
	public String getId_pay_mothod() {
		return ((String) getAttrVal("Id_pay_mothod"));
	}
	/**
	 * 付款方式id
	 * @param Id_pay_mothod
	 */
	public void setId_pay_mothod(String Id_pay_mothod) {
		setAttrVal("Id_pay_mothod", Id_pay_mothod);
	}
	/**
	 * 第一个新生儿入院体重
	 * @return FDouble
	 */
	public FDouble getFirstnb_weight_reg() {
		return ((FDouble) getAttrVal("Firstnb_weight_reg"));
	}
	/**
	 * 第一个新生儿入院体重
	 * @param Firstnb_weight_reg
	 */
	public void setFirstnb_weight_reg(FDouble Firstnb_weight_reg) {
		setAttrVal("Firstnb_weight_reg", Firstnb_weight_reg);
	}
	/**
	 * 第一个新生儿体重
	 * @return FDouble
	 */
	public FDouble getFirstnb_weight() {
		return ((FDouble) getAttrVal("Firstnb_weight"));
	}
	/**
	 * 第一个新生儿体重
	 * @param Firstnb_weight
	 */
	public void setFirstnb_weight(FDouble Firstnb_weight) {
		setAttrVal("Firstnb_weight", Firstnb_weight);
	}
}