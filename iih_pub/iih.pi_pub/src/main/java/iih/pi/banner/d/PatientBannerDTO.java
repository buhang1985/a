package iih.pi.banner.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者信息 DTO数据 
 * 
 */
public class PatientBannerDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 患者编码Code
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 患者编码Code
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 就诊卡号
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 就诊卡号
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
	 * 出生日期(时分秒)
	 * @return String
	 */
	public String getDt_birth_hms() {
		return ((String) getAttrVal("Dt_birth_hms"));
	}
	/**
	 * 出生日期(时分秒)
	 * @param Dt_birth_hms
	 */
	public void setDt_birth_hms(String Dt_birth_hms) {
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
	 * 现住址
	 * @return String
	 */
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}
	/**
	 * 现住址
	 * @param Address
	 */
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getPhonenum() {
		return ((String) getAttrVal("Phonenum"));
	}
	/**
	 * 电话
	 * @param Phonenum
	 */
	public void setPhonenum(String Phonenum) {
		setAttrVal("Phonenum", Phonenum);
	}
	/**
	 * 医保名称
	 * @return String
	 */
	public String getPipathpname() {
		return ((String) getAttrVal("Pipathpname"));
	}
	/**
	 * 医保名称
	 * @param Pipathpname
	 */
	public void setPipathpname(String Pipathpname) {
		setAttrVal("Pipathpname", Pipathpname);
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
	 * 医保号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 医保号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
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
	 * 患者地址id
	 * @return String
	 */
	public String getId_pataddr() {
		return ((String) getAttrVal("Id_pataddr"));
	}
	/**
	 * 患者地址id
	 * @param Id_pataddr
	 */
	public void setId_pataddr(String Id_pataddr) {
		setAttrVal("Id_pataddr", Id_pataddr);
	}
	/**
	 * 实名认证
	 * @return FBoolean
	 */
	public FBoolean getFg_realname() {
		return ((FBoolean) getAttrVal("Fg_realname"));
	}
	/**
	 * 实名认证
	 * @param Fg_realname
	 */
	public void setFg_realname(FBoolean Fg_realname) {
		setAttrVal("Fg_realname", Fg_realname);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 患者头像
	 * @return byte[]
	 */
	public byte[] getPhoto_pat() {
		return ((byte[]) getAttrVal("Photo_pat"));
	}
	/**
	 * 患者头像
	 * @param Photo_pat
	 */
	public void setPhoto_pat(byte[] Photo_pat) {
		setAttrVal("Photo_pat", Photo_pat);
	}
	/**
	 * 预交金余额
	 * @return FDouble
	 */
	public FDouble getPrepay_balance() {
		return ((FDouble) getAttrVal("Prepay_balance"));
	}
	/**
	 * 预交金余额
	 * @param Prepay_balance
	 */
	public void setPrepay_balance(FDouble Prepay_balance) {
		setAttrVal("Prepay_balance", Prepay_balance);
	}
	/**
	 * 患者账户可用额
	 * @return FDouble
	 */
	public FDouble getPatacc_balance() {
		return ((FDouble) getAttrVal("Patacc_balance"));
	}
	/**
	 * 患者账户可用额
	 * @param Patacc_balance
	 */
	public void setPatacc_balance(FDouble Patacc_balance) {
		setAttrVal("Patacc_balance", Patacc_balance);
	}
	/**
	 * 密码
	 * @return String
	 */
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}
	/**
	 * 密码
	 * @param Password
	 */
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
	}
	/**
	 * 后台提示信息
	 * @return String
	 */
	public String getMsg() {
		return ((String) getAttrVal("Msg"));
	}
	/**
	 * 后台提示信息
	 * @param Msg
	 */
	public void setMsg(String Msg) {
		setAttrVal("Msg", Msg);
	}
	/**
	 * 第三方体检登记流水号
	 * @return String
	 */
	public String getPecode() {
		return ((String) getAttrVal("Pecode"));
	}
	/**
	 * 第三方体检登记流水号
	 * @param Pecode
	 */
	public void setPecode(String Pecode) {
		setAttrVal("Pecode", Pecode);
	}
	/**
	 * 急诊预检编码
	 * @return String
	 */
	public String getCode_erpre() {
		return ((String) getAttrVal("Code_erpre"));
	}
	/**
	 * 急诊预检编码
	 * @param Code_erpre
	 */
	public void setCode_erpre(String Code_erpre) {
		setAttrVal("Code_erpre", Code_erpre);
	}
	/**
	 * 急诊预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 急诊预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
	}
	/**
	 * 急诊预检到院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_erpre() {
		return ((FDateTime) getAttrVal("Dt_entry_erpre"));
	}
	/**
	 * 急诊预检到院时间
	 * @param Dt_entry_erpre
	 */
	public void setDt_entry_erpre(FDateTime Dt_entry_erpre) {
		setAttrVal("Dt_entry_erpre", Dt_entry_erpre);
	}
	/**
	 * 分检级别编码
	 * @return String
	 */
	public String getSd_triage_sco() {
		return ((String) getAttrVal("Sd_triage_sco"));
	}
	/**
	 * 分检级别编码
	 * @param Sd_triage_sco
	 */
	public void setSd_triage_sco(String Sd_triage_sco) {
		setAttrVal("Sd_triage_sco", Sd_triage_sco);
	}
	/**
	 * 分检级别名称
	 * @return String
	 */
	public String getName_triage_sco() {
		return ((String) getAttrVal("Name_triage_sco"));
	}
	/**
	 * 分检级别名称
	 * @param Name_triage_sco
	 */
	public void setName_triage_sco(String Name_triage_sco) {
		setAttrVal("Name_triage_sco", Name_triage_sco);
	}
	/**
	 * 分检目标科室id
	 * @return String
	 */
	public String getId_triage_dep() {
		return ((String) getAttrVal("Id_triage_dep"));
	}
	/**
	 * 分检目标科室id
	 * @param Id_triage_dep
	 */
	public void setId_triage_dep(String Id_triage_dep) {
		setAttrVal("Id_triage_dep", Id_triage_dep);
	}
	/**
	 * 分检目标科室
	 * @return String
	 */
	public String getName_triage_dep() {
		return ((String) getAttrVal("Name_triage_dep"));
	}
	/**
	 * 分检目标科室
	 * @param Name_triage_dep
	 */
	public void setName_triage_dep(String Name_triage_dep) {
		setAttrVal("Name_triage_dep", Name_triage_dep);
	}
	/**
	 * 绿色通道ids
	 * @return String
	 */
	public String getIds_green_channel_sym() {
		return ((String) getAttrVal("Ids_green_channel_sym"));
	}
	/**
	 * 绿色通道ids
	 * @param Ids_green_channel_sym
	 */
	public void setIds_green_channel_sym(String Ids_green_channel_sym) {
		setAttrVal("Ids_green_channel_sym", Ids_green_channel_sym);
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
	 * 预检三无人员标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nonperson() {
		return ((FBoolean) getAttrVal("Fg_nonperson"));
	}
	/**
	 * 预检三无人员标识
	 * @param Fg_nonperson
	 */
	public void setFg_nonperson(FBoolean Fg_nonperson) {
		setAttrVal("Fg_nonperson", Fg_nonperson);
	}
	/**
	 * 预检状态编码
	 * @return String
	 */
	public String getSd_status_erpre() {
		return ((String) getAttrVal("Sd_status_erpre"));
	}
	/**
	 * 预检状态编码
	 * @param Sd_status_erpre
	 */
	public void setSd_status_erpre(String Sd_status_erpre) {
		setAttrVal("Sd_status_erpre", Sd_status_erpre);
	}
	/**
	 * 分检去向
	 * @return String
	 */
	public String getName_triage_to() {
		return ((String) getAttrVal("Name_triage_to"));
	}
	/**
	 * 分检去向
	 * @param Name_triage_to
	 */
	public void setName_triage_to(String Name_triage_to) {
		setAttrVal("Name_triage_to", Name_triage_to);
	}
	/**
	 * 分检去向编码
	 * @return String
	 */
	public String getSd_triage_to() {
		return ((String) getAttrVal("Sd_triage_to"));
	}
	/**
	 * 分检去向编码
	 * @param Sd_triage_to
	 */
	public void setSd_triage_to(String Sd_triage_to) {
		setAttrVal("Sd_triage_to", Sd_triage_to);
	}
	/**
	 * 分检去向id
	 * @return String
	 */
	public String getId_triage_to() {
		return ((String) getAttrVal("Id_triage_to"));
	}
	/**
	 * 分检去向id
	 * @param Id_triage_to
	 */
	public void setId_triage_to(String Id_triage_to) {
		setAttrVal("Id_triage_to", Id_triage_to);
	}
	/**
	 * 预检状态
	 * @return String
	 */
	public String getName_status_erpre() {
		return ((String) getAttrVal("Name_status_erpre"));
	}
	/**
	 * 预检状态
	 * @param Name_status_erpre
	 */
	public void setName_status_erpre(String Name_status_erpre) {
		setAttrVal("Name_status_erpre", Name_status_erpre);
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
}
    
