package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院信息DTO DTO数据 
 * 
 */
public class IpInfoDTO extends BaseDTO {
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
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
	 * 性别
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 性别
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
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
	 * 婚姻状况
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}
	/**
	 * 婚姻状况
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
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
	 * 入科日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入科日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
	 * 床位状态编码
	 * @return String
	 */
	public String getSd_bedsu() {
		return ((String) getAttrVal("Sd_bedsu"));
	}
	/**
	 * 床位状态编码
	 * @param Sd_bedsu
	 */
	public void setSd_bedsu(String Sd_bedsu) {
		setAttrVal("Sd_bedsu", Sd_bedsu);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDes_di() {
		return ((String) getAttrVal("Des_di"));
	}
	/**
	 * 诊断描述
	 * @param Des_di
	 */
	public void setDes_di(String Des_di) {
		setAttrVal("Des_di", Des_di);
	}
	/**
	 * 是否手术
	 * @return FBoolean
	 */
	public FBoolean getFg_surg() {
		return ((FBoolean) getAttrVal("Fg_surg"));
	}
	/**
	 * 是否手术
	 * @param Fg_surg
	 */
	public void setFg_surg(FBoolean Fg_surg) {
		setAttrVal("Fg_surg", Fg_surg);
	}
	/**
	 * 就诊预交金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 就诊预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 账单费用
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 账单费用
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 当前费用余额
	 * @return FDouble
	 */
	public FDouble getBalance() {
		return ((FDouble) getAttrVal("Balance"));
	}
	/**
	 * 当前费用余额
	 * @param Balance
	 */
	public void setBalance(FDouble Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 当前主管医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 当前主管医生姓名
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 当前主管医生姓名
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 当前主管护士
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 当前主管护士
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 当前主管护士姓名
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}
	/**
	 * 当前主管护士姓名
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 主医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 主医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 次医保计划
	 * @return String
	 */
	public String getId_hp_sec() {
		return ((String) getAttrVal("Id_hp_sec"));
	}
	/**
	 * 次医保计划
	 * @param Id_hp_sec
	 */
	public void setId_hp_sec(String Id_hp_sec) {
		setAttrVal("Id_hp_sec", Id_hp_sec);
	}
	/**
	 * 次医保计划名称
	 * @return String
	 */
	public String getName_hp_sec() {
		return ((String) getAttrVal("Name_hp_sec"));
	}
	/**
	 * 次医保计划名称
	 * @param Name_hp_sec
	 */
	public void setName_hp_sec(String Name_hp_sec) {
		setAttrVal("Name_hp_sec", Name_hp_sec);
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
	 * 护理等级名称
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}
	/**
	 * 护理等级名称
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
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
	 * 营养等级名称
	 * @return String
	 */
	public String getName_level_nutr() {
		return ((String) getAttrVal("Name_level_nutr"));
	}
	/**
	 * 营养等级名称
	 * @param Name_level_nutr
	 */
	public void setName_level_nutr(String Name_level_nutr) {
		setAttrVal("Name_level_nutr", Name_level_nutr);
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
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}
	/**
	 * 证件号码
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 电话号码
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 电话号码
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 手机号码
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 手机号码
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}
	/**
	 * 现住址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 现住址区县码
	 * @return String
	 */
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}
	/**
	 * 现住址区县码
	 * @param Sd_admdiv
	 */
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
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
	 * 现住址区县码名称
	 * @return String
	 */
	public String getName_admdiv() {
		return ((String) getAttrVal("Name_admdiv"));
	}
	/**
	 * 现住址区县码名称
	 * @param Name_admdiv
	 */
	public void setName_admdiv(String Name_admdiv) {
		setAttrVal("Name_admdiv", Name_admdiv);
	}
	/**
	 * 现住址电话
	 * @return String
	 */
	public String getTel_addr() {
		return ((String) getAttrVal("Tel_addr"));
	}
	/**
	 * 现住址电话
	 * @param Tel_addr
	 */
	public void setTel_addr(String Tel_addr) {
		setAttrVal("Tel_addr", Tel_addr);
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
	 * 联系人名称
	 * @return String
	 */
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}
	/**
	 * 联系人名称
	 * @param Name_cont
	 */
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
	}
	/**
	 * 就诊编号
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 就诊编号
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编号
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 照片
	 * @return byte[]
	 */
	public byte[] getPhoto() {
		return ((byte[]) getAttrVal("Photo"));
	}
	/**
	 * 照片
	 * @param Photo
	 */
	public void setPhoto(byte[] Photo) {
		setAttrVal("Photo", Photo);
	}
	/**
	 * 患者状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 患者状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 患者标签id
	 * @return String
	 */
	public String getId_tagtp() {
		return ((String) getAttrVal("Id_tagtp"));
	}
	/**
	 * 患者标签id
	 * @param Id_tagtp
	 */
	public void setId_tagtp(String Id_tagtp) {
		setAttrVal("Id_tagtp", Id_tagtp);
	}
	/**
	 * 患者标签名称
	 * @return String
	 */
	public String getName_tagtp() {
		return ((String) getAttrVal("Name_tagtp"));
	}
	/**
	 * 患者标签名称
	 * @param Name_tagtp
	 */
	public void setName_tagtp(String Name_tagtp) {
		setAttrVal("Name_tagtp", Name_tagtp);
	}
	/**
	 * 入院体重(KG)
	 * @return FDouble
	 */
	public FDouble getWeight_reg() {
		return ((FDouble) getAttrVal("Weight_reg"));
	}
	/**
	 * 入院体重(KG)
	 * @param Weight_reg
	 */
	public void setWeight_reg(FDouble Weight_reg) {
		setAttrVal("Weight_reg", Weight_reg);
	}
	/**
	 * 入院体重(G)
	 * @return FDouble
	 */
	public FDouble getWeight_reg_g() {
		return ((FDouble) getAttrVal("Weight_reg_g"));
	}
	/**
	 * 入院体重(G)
	 * @param Weight_reg_g
	 */
	public void setWeight_reg_g(FDouble Weight_reg_g) {
		setAttrVal("Weight_reg_g", Weight_reg_g);
	}
	/**
	 * 出生体重(KG)
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}
	/**
	 * 出生体重(KG)
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 出生体重(G)
	 * @return FDouble
	 */
	public FDouble getWeight_g() {
		return ((FDouble) getAttrVal("Weight_g"));
	}
	/**
	 * 出生体重(G)
	 * @param Weight_g
	 */
	public void setWeight_g(FDouble Weight_g) {
		setAttrVal("Weight_g", Weight_g);
	}
	/**
	 * 身高(CM)
	 * @return FDouble
	 */
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}
	/**
	 * 身高(CM)
	 * @param Height
	 */
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getName_blood_abo() {
		return ((String) getAttrVal("Name_blood_abo"));
	}
	/**
	 * 血型
	 * @param Name_blood_abo
	 */
	public void setName_blood_abo(String Name_blood_abo) {
		setAttrVal("Name_blood_abo", Name_blood_abo);
	}
	/**
	 * 血型日期
	 * @return FDateTime
	 */
	public FDateTime getDt_comfirmbloog() {
		return ((FDateTime) getAttrVal("Dt_comfirmbloog"));
	}
	/**
	 * 血型日期
	 * @param Dt_comfirmbloog
	 */
	public void setDt_comfirmbloog(FDateTime Dt_comfirmbloog) {
		setAttrVal("Dt_comfirmbloog", Dt_comfirmbloog);
	}
	/**
	 * 血型ID
	 * @return String
	 */
	public String getId_blood_abo() {
		return ((String) getAttrVal("Id_blood_abo"));
	}
	/**
	 * 血型ID
	 * @param Id_blood_abo
	 */
	public void setId_blood_abo(String Id_blood_abo) {
		setAttrVal("Id_blood_abo", Id_blood_abo);
	}
	/**
	 * 血型编码
	 * @return String
	 */
	public String getSd_blood_abo() {
		return ((String) getAttrVal("Sd_blood_abo"));
	}
	/**
	 * 血型编码
	 * @param Sd_blood_abo
	 */
	public void setSd_blood_abo(String Sd_blood_abo) {
		setAttrVal("Sd_blood_abo", Sd_blood_abo);
	}
	/**
	 * RH反应id
	 * @return String
	 */
	public String getId_blood_rh() {
		return ((String) getAttrVal("Id_blood_rh"));
	}
	/**
	 * RH反应id
	 * @param Id_blood_rh
	 */
	public void setId_blood_rh(String Id_blood_rh) {
		setAttrVal("Id_blood_rh", Id_blood_rh);
	}
	/**
	 * RH反应
	 * @return String
	 */
	public String getName_blood_rh() {
		return ((String) getAttrVal("Name_blood_rh"));
	}
	/**
	 * RH反应
	 * @param Name_blood_rh
	 */
	public void setName_blood_rh(String Name_blood_rh) {
		setAttrVal("Name_blood_rh", Name_blood_rh);
	}
	/**
	 * RH反应sd
	 * @return String
	 */
	public String getSd_blood_rh() {
		return ((String) getAttrVal("Sd_blood_rh"));
	}
	/**
	 * RH反应sd
	 * @param Sd_blood_rh
	 */
	public void setSd_blood_rh(String Sd_blood_rh) {
		setAttrVal("Sd_blood_rh", Sd_blood_rh);
	}
	/**
	 * 入院方式id
	 * @return String
	 */
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}
	/**
	 * 入院方式id
	 * @param Id_referalsrc
	 */
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	/**
	 * 入院方式编码
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 入院方式编码
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 入院方式
	 * @return String
	 */
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}
	/**
	 * 入院方式
	 * @param Name_referalsrc
	 */
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
}