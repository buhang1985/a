package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Banner就诊信息 DTO数据 
 * 
 */
public class Ent4BannerDTO extends BaseDTO {
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
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊号
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
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保计划名称
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
	 * 患者医保计划名称
	 * @return String
	 */
	public String getPipathpname() {
		return ((String) getAttrVal("Pipathpname"));
	}
	/**
	 * 患者医保计划名称
	 * @param Pipathpname
	 */
	public void setPipathpname(String Pipathpname) {
		setAttrVal("Pipathpname", Pipathpname);
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
	 * 科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 医疗组id
	 * @return String
	 */
	public String getId_wg_phy() {
		return ((String) getAttrVal("Id_wg_phy"));
	}
	/**
	 * 医疗组id
	 * @param Id_wg_phy
	 */
	public void setId_wg_phy(String Id_wg_phy) {
		setAttrVal("Id_wg_phy", Id_wg_phy);
	}
	/**
	 * 医疗组
	 * @return String
	 */
	public String getName_wg_phy() {
		return ((String) getAttrVal("Name_wg_phy"));
	}
	/**
	 * 医疗组
	 * @param Name_wg_phy
	 */
	public void setName_wg_phy(String Name_wg_phy) {
		setAttrVal("Name_wg_phy", Name_wg_phy);
	}
	/**
	 * 主治医生id
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 主治医生id
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 主治医生名称
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 主治医生名称
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
	 * 诊断名称
	 * @return String
	 */
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}
	/**
	 * 诊断名称
	 * @param Diagnosis
	 */
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
	}
	/**
	 * 住院开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 住院开始时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 就诊结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 就诊结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getDays_inhos() {
		return ((Integer) getAttrVal("Days_inhos"));
	}
	/**
	 * 住院天数
	 * @param Days_inhos
	 */
	public void setDays_inhos(Integer Days_inhos) {
		setAttrVal("Days_inhos", Days_inhos);
	}
	/**
	 * 价格分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 价格分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 信用分类id
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}
	/**
	 * 信用分类id
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getName_patcret() {
		return ((String) getAttrVal("Name_patcret"));
	}
	/**
	 * 信用分类
	 * @param Name_patcret
	 */
	public void setName_patcret(String Name_patcret) {
		setAttrVal("Name_patcret", Name_patcret);
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
	 * 患者分类
	 * @return String
	 */
	public String getPatcaname() {
		return ((String) getAttrVal("Patcaname"));
	}
	/**
	 * 患者分类
	 * @param Patcaname
	 */
	public void setPatcaname(String Patcaname) {
		setAttrVal("Patcaname", Patcaname);
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
	 * 头像
	 * @return byte[]
	 */
	public byte[] getPhoto_pat() {
		return ((byte[]) getAttrVal("Photo_pat"));
	}
	/**
	 * 头像
	 * @param Photo_pat
	 */
	public void setPhoto_pat(byte[] Photo_pat) {
		setAttrVal("Photo_pat", Photo_pat);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 证件类型
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
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
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
	 * 职业
	 * @return String
	 */
	public String getOccupation() {
		return ((String) getAttrVal("Occupation"));
	}
	/**
	 * 职业
	 * @param Occupation
	 */
	public void setOccupation(String Occupation) {
		setAttrVal("Occupation", Occupation);
	}
	/**
	 * 电话号码
	 * @return String
	 */
	public String getPhonenum() {
		return ((String) getAttrVal("Phonenum"));
	}
	/**
	 * 电话号码
	 * @param Phonenum
	 */
	public void setPhonenum(String Phonenum) {
		setAttrVal("Phonenum", Phonenum);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 地址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 地址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
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
	 * 婚史Count
	 * @return Integer
	 */
	public Integer getMarryhiscount() {
		return ((Integer) getAttrVal("Marryhiscount"));
	}
	/**
	 * 婚史Count
	 * @param Marryhiscount
	 */
	public void setMarryhiscount(Integer Marryhiscount) {
		setAttrVal("Marryhiscount", Marryhiscount);
	}
	/**
	 * 婚史
	 * @return String
	 */
	public String getMarryhis() {
		return ((String) getAttrVal("Marryhis"));
	}
	/**
	 * 婚史
	 * @param Marryhis
	 */
	public void setMarryhis(String Marryhis) {
		setAttrVal("Marryhis", Marryhis);
	}
	/**
	 * 育史count
	 * @return Integer
	 */
	public Integer getBirthhiscount() {
		return ((Integer) getAttrVal("Birthhiscount"));
	}
	/**
	 * 育史count
	 * @param Birthhiscount
	 */
	public void setBirthhiscount(Integer Birthhiscount) {
		setAttrVal("Birthhiscount", Birthhiscount);
	}
	/**
	 * 育史
	 * @return String
	 */
	public String getBirthhis() {
		return ((String) getAttrVal("Birthhis"));
	}
	/**
	 * 育史
	 * @param Birthhis
	 */
	public void setBirthhis(String Birthhis) {
		setAttrVal("Birthhis", Birthhis);
	}
	/**
	 * 疾病史Count
	 * @return Integer
	 */
	public Integer getSicknesshiscount() {
		return ((Integer) getAttrVal("Sicknesshiscount"));
	}
	/**
	 * 疾病史Count
	 * @param Sicknesshiscount
	 */
	public void setSicknesshiscount(Integer Sicknesshiscount) {
		setAttrVal("Sicknesshiscount", Sicknesshiscount);
	}
	/**
	 * 疾病史
	 * @return String
	 */
	public String getSicknesshis() {
		return ((String) getAttrVal("Sicknesshis"));
	}
	/**
	 * 疾病史
	 * @param Sicknesshis
	 */
	public void setSicknesshis(String Sicknesshis) {
		setAttrVal("Sicknesshis", Sicknesshis);
	}
	/**
	 * 过敏史Count
	 * @return Integer
	 */
	public Integer getAllergyhiscount() {
		return ((Integer) getAttrVal("Allergyhiscount"));
	}
	/**
	 * 过敏史Count
	 * @param Allergyhiscount
	 */
	public void setAllergyhiscount(Integer Allergyhiscount) {
		setAttrVal("Allergyhiscount", Allergyhiscount);
	}
	/**
	 * 过敏史
	 * @return String
	 */
	public String getAllergyhis() {
		return ((String) getAttrVal("Allergyhis"));
	}
	/**
	 * 过敏史
	 * @param Allergyhis
	 */
	public void setAllergyhis(String Allergyhis) {
		setAttrVal("Allergyhis", Allergyhis);
	}
	/**
	 * 护理病区
	 * @return String
	 */
	public String getNursingdept() {
		return ((String) getAttrVal("Nursingdept"));
	}
	/**
	 * 护理病区
	 * @param Nursingdept
	 */
	public void setNursingdept(String Nursingdept) {
		setAttrVal("Nursingdept", Nursingdept);
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
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
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
	 * 新生儿
	 * @return String
	 */
	public String getIsnewborn() {
		return ((String) getAttrVal("Isnewborn"));
	}
	/**
	 * 新生儿
	 * @param Isnewborn
	 */
	public void setIsnewborn(String Isnewborn) {
		setAttrVal("Isnewborn", Isnewborn);
	}
	/**
	 * 新生儿数量
	 * @return Integer
	 */
	public Integer getNum_newborn() {
		return ((Integer) getAttrVal("Num_newborn"));
	}
	/**
	 * 新生儿数量
	 * @param Num_newborn
	 */
	public void setNum_newborn(Integer Num_newborn) {
		setAttrVal("Num_newborn", Num_newborn);
	}
	/**
	 * 临床路径名称
	 * @return String
	 */
	public String getName_cp() {
		return ((String) getAttrVal("Name_cp"));
	}
	/**
	 * 临床路径名称
	 * @param Name_cp
	 */
	public void setName_cp(String Name_cp) {
		setAttrVal("Name_cp", Name_cp);
	}
	/**
	 * 入径时间
	 * @return FDateTime
	 */
	public FDateTime getCp_dt_enter() {
		return ((FDateTime) getAttrVal("Cp_dt_enter"));
	}
	/**
	 * 入径时间
	 * @param Cp_dt_enter
	 */
	public void setCp_dt_enter(FDateTime Cp_dt_enter) {
		setAttrVal("Cp_dt_enter", Cp_dt_enter);
	}
	/**
	 * 第一主诊断名称
	 * @return String
	 */
	public String getCp_diag_name() {
		return ((String) getAttrVal("Cp_diag_name"));
	}
	/**
	 * 第一主诊断名称
	 * @param Cp_diag_name
	 */
	public void setCp_diag_name(String Cp_diag_name) {
		setAttrVal("Cp_diag_name", Cp_diag_name);
	}
	/**
	 * 手术
	 * @return String
	 */
	public String getCp_operation() {
		return ((String) getAttrVal("Cp_operation"));
	}
	/**
	 * 手术
	 * @param Cp_operation
	 */
	public void setCp_operation(String Cp_operation) {
		setAttrVal("Cp_operation", Cp_operation);
	}
	/**
	 * 平均费用
	 * @return FDouble
	 */
	public FDouble getCp_avgcost() {
		return ((FDouble) getAttrVal("Cp_avgcost"));
	}
	/**
	 * 平均费用
	 * @param Cp_avgcost
	 */
	public void setCp_avgcost(FDouble Cp_avgcost) {
		setAttrVal("Cp_avgcost", Cp_avgcost);
	}
	/**
	 * 当前费用
	 * @return FDouble
	 */
	public FDouble getCp_cost_now() {
		return ((FDouble) getAttrVal("Cp_cost_now"));
	}
	/**
	 * 当前费用
	 * @param Cp_cost_now
	 */
	public void setCp_cost_now(FDouble Cp_cost_now) {
		setAttrVal("Cp_cost_now", Cp_cost_now);
	}
	/**
	 * 最小平均住院天数
	 * @return Integer
	 */
	public Integer getCp_minspandays() {
		return ((Integer) getAttrVal("Cp_minspandays"));
	}
	/**
	 * 最小平均住院天数
	 * @param Cp_minspandays
	 */
	public void setCp_minspandays(Integer Cp_minspandays) {
		setAttrVal("Cp_minspandays", Cp_minspandays);
	}
	/**
	 * 最大平均住院天数
	 * @return Integer
	 */
	public Integer getCp_maxspandays() {
		return ((Integer) getAttrVal("Cp_maxspandays"));
	}
	/**
	 * 最大平均住院天数
	 * @param Cp_maxspandays
	 */
	public void setCp_maxspandays(Integer Cp_maxspandays) {
		setAttrVal("Cp_maxspandays", Cp_maxspandays);
	}
	/**
	 * 当前在径天数
	 * @return Integer
	 */
	public Integer getCp_in_days() {
		return ((Integer) getAttrVal("Cp_in_days"));
	}
	/**
	 * 当前在径天数
	 * @param Cp_in_days
	 */
	public void setCp_in_days(Integer Cp_in_days) {
		setAttrVal("Cp_in_days", Cp_in_days);
	}
	/**
	 * 患者在径状态
	 * @return String
	 */
	public String getCp_status() {
		return ((String) getAttrVal("Cp_status"));
	}
	/**
	 * 患者在径状态
	 * @param Cp_status
	 */
	public void setCp_status(String Cp_status) {
		setAttrVal("Cp_status", Cp_status);
	}
	/**
	 * 目标天数
	 * @return String
	 */
	public String getCp_standarddays() {
		return ((String) getAttrVal("Cp_standarddays"));
	}
	/**
	 * 目标天数
	 * @param Cp_standarddays
	 */
	public void setCp_standarddays(String Cp_standarddays) {
		setAttrVal("Cp_standarddays", Cp_standarddays);
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
	 * 是否在院
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 是否在院
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 实名认证标识
	 * @return FBoolean
	 */
	public FBoolean getFg_realname() {
		return ((FBoolean) getAttrVal("Fg_realname"));
	}
	/**
	 * 实名认证标识
	 * @param Fg_realname
	 */
	public void setFg_realname(FBoolean Fg_realname) {
		setAttrVal("Fg_realname", Fg_realname);
	}
	/**
	 * 就诊患者类别
	 * @return String
	 */
	public String getEntpattp() {
		return ((String) getAttrVal("Entpattp"));
	}
	/**
	 * 就诊患者类别
	 * @param Entpattp
	 */
	public void setEntpattp(String Entpattp) {
		setAttrVal("Entpattp", Entpattp);
	}
	/**
	 * 生理状态
	 * @return String
	 */
	public String getPhystate() {
		return ((String) getAttrVal("Phystate"));
	}
	/**
	 * 生理状态
	 * @param Phystate
	 */
	public void setPhystate(String Phystate) {
		setAttrVal("Phystate", Phystate);
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
	 * 就诊结算标志
	 * @return FBoolean
	 */
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}
	/**
	 * 就诊结算标志
	 * @param Fg_st
	 */
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 就诊状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 就诊状态
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 待回诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_needrtn() {
		return ((FBoolean) getAttrVal("Fg_needrtn"));
	}
	/**
	 * 待回诊标志
	 * @param Fg_needrtn
	 */
	public void setFg_needrtn(FBoolean Fg_needrtn) {
		setAttrVal("Fg_needrtn", Fg_needrtn);
	}
	/**
	 * 就诊账户预交金
	 * @return FDouble
	 */
	public FDouble getPrepay_amount() {
		return ((FDouble) getAttrVal("Prepay_amount"));
	}
	/**
	 * 就诊账户预交金
	 * @param Prepay_amount
	 */
	public void setPrepay_amount(FDouble Prepay_amount) {
		setAttrVal("Prepay_amount", Prepay_amount);
	}
	/**
	 * 就诊账户预交金余额
	 * @return FDouble
	 */
	public FDouble getPrepay_balance() {
		return ((FDouble) getAttrVal("Prepay_balance"));
	}
	/**
	 * 就诊账户预交金余额
	 * @param Prepay_balance
	 */
	public void setPrepay_balance(FDouble Prepay_balance) {
		setAttrVal("Prepay_balance", Prepay_balance);
	}
	/**
	 * 信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}
	/**
	 * 信用额度
	 * @param Amt_cred
	 */
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	/**
	 * 初诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_first() {
		return ((FBoolean) getAttrVal("Fg_first"));
	}
	/**
	 * 初诊标志
	 * @param Fg_first
	 */
	public void setFg_first(FBoolean Fg_first) {
		setAttrVal("Fg_first", Fg_first);
	}
	/**
	 * 在医保黑名单标志
	 * @return FBoolean
	 */
	public FBoolean getFg_inhpbbr() {
		return ((FBoolean) getAttrVal("Fg_inhpbbr"));
	}
	/**
	 * 在医保黑名单标志
	 * @param Fg_inhpbbr
	 */
	public void setFg_inhpbbr(FBoolean Fg_inhpbbr) {
		setAttrVal("Fg_inhpbbr", Fg_inhpbbr);
	}
	/**
	 * 医保基金支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpfundpay() {
		return ((FBoolean) getAttrVal("Fg_hpfundpay"));
	}
	/**
	 * 医保基金支付标志
	 * @param Fg_hpfundpay
	 */
	public void setFg_hpfundpay(FBoolean Fg_hpfundpay) {
		setAttrVal("Fg_hpfundpay", Fg_hpfundpay);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 号别编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 号别命名
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 号别命名
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 绿色通道标识
	 * @return FBoolean
	 */
	public FBoolean getFg_gcvip() {
		return ((FBoolean) getAttrVal("Fg_gcvip"));
	}
	/**
	 * 绿色通道标识
	 * @param Fg_gcvip
	 */
	public void setFg_gcvip(FBoolean Fg_gcvip) {
		setAttrVal("Fg_gcvip", Fg_gcvip);
	}
	/**
	 * 门诊就诊次数
	 * @return Integer
	 */
	public Integer getTimes_op() {
		return ((Integer) getAttrVal("Times_op"));
	}
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(Integer Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 特病患者标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpspcl() {
		return ((FBoolean) getAttrVal("Fg_hpspcl"));
	}
	/**
	 * 特病患者标志
	 * @param Fg_hpspcl
	 */
	public void setFg_hpspcl(FBoolean Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}
	/**
	 * 患者账户余额
	 * @return FDouble
	 */
	public FDouble getPatacc_balance() {
		return ((FDouble) getAttrVal("Patacc_balance"));
	}
	/**
	 * 患者账户余额
	 * @param Patacc_balance
	 */
	public void setPatacc_balance(FDouble Patacc_balance) {
		setAttrVal("Patacc_balance", Patacc_balance);
	}
	/**
	 * 患者账户余额警示信息
	 * @return String
	 */
	public String getPatacc_balance_warn() {
		return ((String) getAttrVal("Patacc_balance_warn"));
	}
	/**
	 * 患者账户余额警示信息
	 * @param Patacc_balance_warn
	 */
	public void setPatacc_balance_warn(String Patacc_balance_warn) {
		setAttrVal("Patacc_balance_warn", Patacc_balance_warn);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getSd_hptp() {
		return ((String) getAttrVal("Sd_hptp"));
	}
	/**
	 * 医保类型
	 * @param Sd_hptp
	 */
	public void setSd_hptp(String Sd_hptp) {
		setAttrVal("Sd_hptp", Sd_hptp);
	}
	/**
	 * 医保记账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpcg() {
		return ((FBoolean) getAttrVal("Fg_hpcg"));
	}
	/**
	 * 医保记账标志
	 * @param Fg_hpcg
	 */
	public void setFg_hpcg(FBoolean Fg_hpcg) {
		setAttrVal("Fg_hpcg", Fg_hpcg);
	}
	/**
	 * 自定义项1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 自定义项1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 自定义项2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 自定义项2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 自定义项3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 自定义项3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 自定义项4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 自定义项4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 自定义项5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 自定义项5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 是否全保内(副部级)
	 * @return FBoolean
	 */
	public FBoolean getFg_allinhp() {
		return ((FBoolean) getAttrVal("Fg_allinhp"));
	}
	/**
	 * 是否全保内(副部级)
	 * @param Fg_allinhp
	 */
	public void setFg_allinhp(FBoolean Fg_allinhp) {
		setAttrVal("Fg_allinhp", Fg_allinhp);
	}
	/**
	 * 体重
	 * @return FDouble
	 */
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}
	/**
	 * 体重
	 * @param Weight
	 */
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	/**
	 * 是否展示体重
	 * @return FBoolean
	 */
	public FBoolean getFg_weightshow() {
		return ((FBoolean) getAttrVal("Fg_weightshow"));
	}
	/**
	 * 是否展示体重
	 * @param Fg_weightshow
	 */
	public void setFg_weightshow(FBoolean Fg_weightshow) {
		setAttrVal("Fg_weightshow", Fg_weightshow);
	}
	/**
	 * 带单位体重
	 * @return String
	 */
	public String getWeightunit() {
		return ((String) getAttrVal("Weightunit"));
	}
	/**
	 * 带单位体重
	 * @param Weightunit
	 */
	public void setWeightunit(String Weightunit) {
		setAttrVal("Weightunit", Weightunit);
	}
	/**
	 * 记帐总费用
	 * @return FDouble
	 */
	public FDouble getCp_cost() {
		return ((FDouble) getAttrVal("Cp_cost"));
	}
	/**
	 * 记帐总费用
	 * @param Cp_cost
	 */
	public void setCp_cost(FDouble Cp_cost) {
		setAttrVal("Cp_cost", Cp_cost);
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
	 * 患者卡号
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者卡号
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 体检类型
	 * @return String
	 */
	public String getSd_pe_psntp() {
		return ((String) getAttrVal("Sd_pe_psntp"));
	}
	/**
	 * 体检类型
	 * @param Sd_pe_psntp
	 */
	public void setSd_pe_psntp(String Sd_pe_psntp) {
		setAttrVal("Sd_pe_psntp", Sd_pe_psntp);
	}
	/**
	 * 团检标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pe_group() {
		return ((FBoolean) getAttrVal("Fg_pe_group"));
	}
	/**
	 * 团检标志
	 * @param Fg_pe_group
	 */
	public void setFg_pe_group(FBoolean Fg_pe_group) {
		setAttrVal("Fg_pe_group", Fg_pe_group);
	}
	/**
	 * 团检
	 * @return String
	 */
	public String getPe_group() {
		return ((String) getAttrVal("Pe_group"));
	}
	/**
	 * 团检
	 * @param Pe_group
	 */
	public void setPe_group(String Pe_group) {
		setAttrVal("Pe_group", Pe_group);
	}
	/**
	 * 患者标签
	 * @return String
	 */
	public String getPattag() {
		return ((String) getAttrVal("Pattag"));
	}
	/**
	 * 患者标签
	 * @param Pattag
	 */
	public void setPattag(String Pattag) {
		setAttrVal("Pattag", Pattag);
	}
	/**
	 * 渠道打印标识
	 * @return String
	 */
	public String getPrintident_scchl() {
		return ((String) getAttrVal("Printident_scchl"));
	}
	/**
	 * 渠道打印标识
	 * @param Printident_scchl
	 */
	public void setPrintident_scchl(String Printident_scchl) {
		setAttrVal("Printident_scchl", Printident_scchl);
	}
	/**
	 * 是否显示渠道打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_printident_scchl() {
		return ((FBoolean) getAttrVal("Fg_printident_scchl"));
	}
	/**
	 * 是否显示渠道打印标识
	 * @param Fg_printident_scchl
	 */
	public void setFg_printident_scchl(FBoolean Fg_printident_scchl) {
		setAttrVal("Fg_printident_scchl", Fg_printident_scchl);
	}
	/**
	 * 孕妇风险等级编码
	 * @return String
	 */
	public String getCode_gravidarisk() {
		return ((String) getAttrVal("Code_gravidarisk"));
	}
	/**
	 * 孕妇风险等级编码
	 * @param Code_gravidarisk
	 */
	public void setCode_gravidarisk(String Code_gravidarisk) {
		setAttrVal("Code_gravidarisk", Code_gravidarisk);
	}
	/**
	 * 孕妇风险等级
	 * @return String
	 */
	public String getName_gravidarisk() {
		return ((String) getAttrVal("Name_gravidarisk"));
	}
	/**
	 * 孕妇风险等级
	 * @param Name_gravidarisk
	 */
	public void setName_gravidarisk(String Name_gravidarisk) {
		setAttrVal("Name_gravidarisk", Name_gravidarisk);
	}
	/**
	 * 未记账费用
	 * @return FDouble
	 */
	public FDouble getAmt_nocg() {
		return ((FDouble) getAttrVal("Amt_nocg"));
	}
	/**
	 * 未记账费用
	 * @param Amt_nocg
	 */
	public void setAmt_nocg(FDouble Amt_nocg) {
		setAttrVal("Amt_nocg", Amt_nocg);
	}
	/**
	 * 可用余额
	 * @return FDouble
	 */
	public FDouble getAmt_balance_canuse() {
		return ((FDouble) getAttrVal("Amt_balance_canuse"));
	}
	/**
	 * 可用余额
	 * @param Amt_balance_canuse
	 */
	public void setAmt_balance_canuse(FDouble Amt_balance_canuse) {
		setAttrVal("Amt_balance_canuse", Amt_balance_canuse);
	}
	/**
	 * 急诊停留标志
	 * @return String
	 */
	public String getSd_ertp() {
		return ((String) getAttrVal("Sd_ertp"));
	}
	/**
	 * 急诊停留标志
	 * @param Sd_ertp
	 */
	public void setSd_ertp(String Sd_ertp) {
		setAttrVal("Sd_ertp", Sd_ertp);
	}
	/**
	 * 入院途径
	 * @return String
	 */
	public String getInhosway() {
		return ((String) getAttrVal("Inhosway"));
	}
	/**
	 * 入院途径
	 * @param Inhosway
	 */
	public void setInhosway(String Inhosway) {
		setAttrVal("Inhosway", Inhosway);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getPatcacode() {
		return ((String) getAttrVal("Patcacode"));
	}
	/**
	 * 患者分类编码
	 * @param Patcacode
	 */
	public void setPatcacode(String Patcacode) {
		setAttrVal("Patcacode", Patcacode);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getPatcaid() {
		return ((String) getAttrVal("Patcaid"));
	}
	/**
	 * 患者分类id
	 * @param Patcaid
	 */
	public void setPatcaid(String Patcaid) {
		setAttrVal("Patcaid", Patcaid);
	}
	/**
	 * 就诊状况图标
	 * @return String
	 */
	public String getEnstate_logos() {
		return ((String) getAttrVal("Enstate_logos"));
	}
	/**
	 * 就诊状况图标
	 * @param Enstate_logos
	 */
	public void setEnstate_logos(String Enstate_logos) {
		setAttrVal("Enstate_logos", Enstate_logos);
	}
	/**
	 * 挂号操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}
	/**
	 * 挂号操作时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	/**
	 * 签到时间
	 * @return FDateTime
	 */
	public FDateTime getDt_arrv() {
		return ((FDateTime) getAttrVal("Dt_arrv"));
	}
	/**
	 * 签到时间
	 * @param Dt_arrv
	 */
	public void setDt_arrv(FDateTime Dt_arrv) {
		setAttrVal("Dt_arrv", Dt_arrv);
	}
	/**
	 * 就诊队列状态
	 * @return String
	 */
	public String getQuestatus() {
		return ((String) getAttrVal("Questatus"));
	}
	/**
	 * 就诊队列状态
	 * @param Questatus
	 */
	public void setQuestatus(String Questatus) {
		setAttrVal("Questatus", Questatus);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 挂红资源
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 挂红资源
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 号别
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 号别
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 患者密码
	 * @return String
	 */
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}
	/**
	 * 患者密码
	 * @param Password
	 */
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
	}
	/**
	 * 医保医疗类别
	 * @return String
	 */
	public String getName_hpmedkind() {
		return ((String) getAttrVal("Name_hpmedkind"));
	}
	/**
	 * 医保医疗类别
	 * @param Name_hpmedkind
	 */
	public void setName_hpmedkind(String Name_hpmedkind) {
		setAttrVal("Name_hpmedkind", Name_hpmedkind);
	}
	/**
	 * 医保可报销额度
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保可报销额度
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
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
	 * 挂号有效期开始时间
	 * @return String
	 */
	public String getDt_valid_b() {
		return ((String) getAttrVal("Dt_valid_b"));
	}
	/**
	 * 挂号有效期开始时间
	 * @param Dt_valid_b
	 */
	public void setDt_valid_b(String Dt_valid_b) {
		setAttrVal("Dt_valid_b", Dt_valid_b);
	}
	/**
	 * 挂号有效期结束时间
	 * @return String
	 */
	public String getDt_valid_e() {
		return ((String) getAttrVal("Dt_valid_e"));
	}
	/**
	 * 挂号有效期结束时间
	 * @param Dt_valid_e
	 */
	public void setDt_valid_e(String Dt_valid_e) {
		setAttrVal("Dt_valid_e", Dt_valid_e);
	}
	/**
	 * 医保计划_就诊
	 * @return String
	 */
	public String getEnhpname() {
		return ((String) getAttrVal("Enhpname"));
	}
	/**
	 * 医保计划_就诊
	 * @param Enhpname
	 */
	public void setEnhpname(String Enhpname) {
		setAttrVal("Enhpname", Enhpname);
	}
	/**
	 * 费用提示
	 * @return String
	 */
	public String getMsg_amt() {
		return ((String) getAttrVal("Msg_amt"));
	}
	/**
	 * 费用提示
	 * @param Msg_amt
	 */
	public void setMsg_amt(String Msg_amt) {
		setAttrVal("Msg_amt", Msg_amt);
	}
	/**
	 * 费用召回标识
	 * @return FBoolean
	 */
	public FBoolean getFg_blrecall() {
		return ((FBoolean) getAttrVal("Fg_blrecall"));
	}
	/**
	 * 费用召回标识
	 * @param Fg_blrecall
	 */
	public void setFg_blrecall(FBoolean Fg_blrecall) {
		setAttrVal("Fg_blrecall", Fg_blrecall);
	}
	/**
	 * 统筹区域
	 * @return String
	 */
	public String getCode_hparea() {
		return ((String) getAttrVal("Code_hparea"));
	}
	/**
	 * 统筹区域
	 * @param Code_hparea
	 */
	public void setCode_hparea(String Code_hparea) {
		setAttrVal("Code_hparea", Code_hparea);
	}
	/**
	 * 统筹区域名称
	 * @return String
	 */
	public String getName_hparea() {
		return ((String) getAttrVal("Name_hparea"));
	}
	/**
	 * 统筹区域名称
	 * @param Name_hparea
	 */
	public void setName_hparea(String Name_hparea) {
		setAttrVal("Name_hparea", Name_hparea);
	}
	/**
	 * 特病信息
	 * @return String
	 */
	public String getMimcspecinfo() {
		return ((String) getAttrVal("Mimcspecinfo"));
	}
	/**
	 * 特病信息
	 * @param Mimcspecinfo
	 */
	public void setMimcspecinfo(String Mimcspecinfo) {
		setAttrVal("Mimcspecinfo", Mimcspecinfo);
	}
	/**
	 * 全部诊断名称
	 * @return String
	 */
	public String getAll_diag_name() {
		return ((String) getAttrVal("All_diag_name"));
	}
	/**
	 * 全部诊断名称
	 * @param All_diag_name
	 */
	public void setAll_diag_name(String All_diag_name) {
		setAttrVal("All_diag_name", All_diag_name);
	}
	/**
	 * 归档标识
	 * @return FBoolean
	 */
	public FBoolean getFg_data_transf() {
		return ((FBoolean) getAttrVal("Fg_data_transf"));
	}
	/**
	 * 归档标识
	 * @param Fg_data_transf
	 */
	public void setFg_data_transf(FBoolean Fg_data_transf) {
		setAttrVal("Fg_data_transf", Fg_data_transf);
	}
	/**
	 * 挂号费是否付款
	 * @return String
	 */
	public String getFg_pay_regist() {
		return ((String) getAttrVal("Fg_pay_regist"));
	}
	/**
	 * 挂号费是否付款
	 * @param Fg_pay_regist
	 */
	public void setFg_pay_regist(String Fg_pay_regist) {
		setAttrVal("Fg_pay_regist", Fg_pay_regist);
	}
}