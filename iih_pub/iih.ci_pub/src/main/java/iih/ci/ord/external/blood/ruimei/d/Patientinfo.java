package iih.ci.ord.external.blood.ruimei.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class Patientinfo  extends BaseDTO {
private static final long serialVersionUID = 1L;
	
	/**
	 * 病人编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 病人编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 就诊编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 住院天数
	 * @return String
	 */
	public String getTotaldays() {
		return ((String) getAttrVal("Totaldays"));
	}
	/**
	 * 住院天数
	 * @param Totaldays
	 */
	public void setTotaldays(String Totaldays) {
		setAttrVal("Totaldays", Totaldays);
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
	 * 黑名单标识
	 * @return String
	 */
	public String getFlag_black() {
		return ((String) getAttrVal("Flag_black"));
	}
	/**
	 * 黑名单标识
	 * @param Flag_black
	 */
	public void setFlag_black(String Flag_black) {
		setAttrVal("Flag_black", Flag_black);
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
	 * @return String
	 */
	public String getDt_birth_date() {
		return ((String) getAttrVal("Dt_birth_date"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_date
	 */
	public void setDt_birth_date(String Dt_birth_date) {
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
	 * 科室
	 * @return String
	 */
	public String getDepcode() {
		return ((String) getAttrVal("Depcode"));
	}
	/**
	 * 科室
	 * @param Depcode
	 */
	public void setDepcode(String Depcode) {
		setAttrVal("Depcode", Depcode);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDepname() {
		return ((String) getAttrVal("Depname"));
	}
	/**
	 * 科室名称
	 * @param Depname
	 */
	public void setDepname(String Depname) {
		setAttrVal("Depname", Depname);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getDepcode_nur() {
		return ((String) getAttrVal("Depcode_nur"));
	}
	/**
	 * 病区
	 * @param Depcode_nur
	 */
	public void setDepcode_nur(String Depcode_nur) {
		setAttrVal("Depcode_nur", Depcode_nur);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getDepname_nur() {
		return ((String) getAttrVal("Depname_nur"));
	}
	/**
	 * 病区名称
	 * @param Depname_nur
	 */
	public void setDepname_nur(String Depname_nur) {
		setAttrVal("Depname_nur", Depname_nur);
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
	public String getBedcode() {
		return ((String) getAttrVal("Bedcode"));
	}
	/**
	 * 床号
	 * @param Bedcode
	 */
	public void setBedcode(String Bedcode) {
		setAttrVal("Bedcode", Bedcode);
	}
	/**
	 * 入院日期
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院日期
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 住院日期
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}
	/**
	 * 住院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院日期
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
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
	public String getIdtype() {
		return ((String) getAttrVal("Idtype"));
	}
	/**
	 * 证件类型
	 * @param Idtype
	 */
	public void setIdtype(String Idtype) {
		setAttrVal("Idtype", Idtype);
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
	 * 状态
	 * @return String
	 */
	public String getIp_status() {
		return ((String) getAttrVal("Ip_status"));
	}
	/**
	 * 状态
	 * @param Ip_status
	 */
	public void setIp_status(String Ip_status) {
		setAttrVal("Ip_status", Ip_status);
	}
	/**
	 * 居民健康卡号
	 * @return String
	 */
	public String getHealth_card_no() {
		return ((String) getAttrVal("Health_card_no"));
	}
	/**
	 * 居民健康卡号
	 * @param Health_card_no
	 */
	public void setHealth_card_no(String Health_card_no) {
		setAttrVal("Health_card_no", Health_card_no);
	}
	/**
	 * 健康档案号
	 * @return String
	 */
	public String getHealth_no() {
		return ((String) getAttrVal("Health_no"));
	}
	/**
	 * 健康档案号
	 * @param Health_no
	 */
	public void setHealth_no(String Health_no) {
		setAttrVal("Health_no", Health_no);
	}
	/**
	 * ABO血型
	 * @return String
	 */
	public String getPatient_abo() {
		return ((String) getAttrVal("Patient_abo"));
	}
	/**
	 * ABO血型
	 * @param Patient_abo
	 */
	public void setPatient_abo(String Patient_abo) {
		setAttrVal("Patient_abo", Patient_abo);
	}
	/**
	 * RHD血型
	 * @return String
	 */
	public String getPatient_rhd() {
		return ((String) getAttrVal("Patient_rhd"));
	}
	/**
	 * RHD血型
	 * @param Patient_rhd
	 */
	public void setPatient_rhd(String Patient_rhd) {
		setAttrVal("Patient_rhd", Patient_rhd);
	}
	/**
	 * 身高
	 * @return String
	 */
	public String getPatietn_height() {
		return ((String) getAttrVal("Patietn_height"));
	}
	/**
	 * 身高
	 * @param Patietn_height
	 */
	public void setPatietn_height(String Patietn_height) {
		setAttrVal("Patietn_height", Patietn_height);
	}
	/**
	 * 体重
	 * @return String
	 */
	public String getPatietn_weigth() {
		return ((String) getAttrVal("Patietn_weigth"));
	}
	/**
	 * 体重
	 * @param Patietn_weigth
	 */
	public void setPatietn_weigth(String Patietn_weigth) {
		setAttrVal("Patietn_weigth", Patietn_weigth);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getAddr_home() {
		return ((String) getAttrVal("Addr_home"));
	}
	/**
	 * 户籍地址
	 * @param Addr_home
	 */
	public void setAddr_home(String Addr_home) {
		setAttrVal("Addr_home", Addr_home);
	}
	/**
	 * 户籍地址代码
	 * @return String
	 */
	public String getAddr_home_code() {
		return ((String) getAttrVal("Addr_home_code"));
	}
	/**
	 * 户籍地址代码
	 * @param Addr_home_code
	 */
	public void setAddr_home_code(String Addr_home_code) {
		setAttrVal("Addr_home_code", Addr_home_code);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getAddr_birth() {
		return ((String) getAttrVal("Addr_birth"));
	}
	/**
	 * 出生地
	 * @param Addr_birth
	 */
	public void setAddr_birth(String Addr_birth) {
		setAttrVal("Addr_birth", Addr_birth);
	}
	/**
	 * 出生地代码
	 * @return String
	 */
	public String getAddr_birth_code() {
		return ((String) getAttrVal("Addr_birth_code"));
	}
	/**
	 * 出生地代码
	 * @param Addr_birth_code
	 */
	public void setAddr_birth_code(String Addr_birth_code) {
		setAttrVal("Addr_birth_code", Addr_birth_code);
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
	 * 主治医师
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}
	/**
	 * 主治医师
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 主治医师名字
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}
	/**
	 * 主治医师名字
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
	}
	/**
	 * 诊断
	 * @return FArrayList
	 */
	public FArrayList getDiagsarr() {
		return ((FArrayList) getAttrVal("Diagsarr"));
	}
	/**
	 * 诊断
	 * @param Diagsarr
	 */
	public void setDiagsarr(FArrayList Diagsarr) {
		setAttrVal("Diagsarr", Diagsarr);
	}
	/**
	 * 诊断代码
	 * @return String
	 */
	public String getDiagcode() {
		return ((String) getAttrVal("Diagcode"));
	}
	/**
	 * 诊断代码
	 * @param Diagcode
	 */
	public void setDiagcode(String Diagcode) {
		setAttrVal("Diagcode", Diagcode);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDiagname() {
		return ((String) getAttrVal("Diagname"));
	}
	/**
	 * 诊断名称
	 * @param Diagname
	 */
	public void setDiagname(String Diagname) {
		setAttrVal("Diagname", Diagname);
	}
	/**
	 * 诊断类型
	 * @return String
	 */
	public String getDiagtype() {
		return ((String) getAttrVal("Diagtype"));
	}
	/**
	 * 诊断类型
	 * @param Diagtype
	 */
	public void setDiagtype(String Diagtype) {
		setAttrVal("Diagtype", Diagtype);
	}
	/**
	 * 第一（主诊断）诊断标记
	 * @return String
	 */
	public String getMaindiagflag() {
		return ((String) getAttrVal("Maindiagflag"));
	}
	/**
	 * 第一（主诊断）诊断标记
	 * @param Maindiagflag
	 */
	public void setMaindiagflag(String Maindiagflag) {
		setAttrVal("Maindiagflag", Maindiagflag);
	}
}
