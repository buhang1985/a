package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊登记患者DTO DTO数据 
 * 
 */
public class OpRegPatDTO extends BaseDTO {
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
	 * CHIS条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * CHIS条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
	 * 固定电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 固定电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
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
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 证件号码
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
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
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}
	/**
	 * 婚姻状况编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
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
	 * 患者分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
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
	 * 患者价格分类名称
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 患者价格分类名称
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 患者信用分类id
	 * @return String
	 */
	public String getId_patcredtp() {
		return ((String) getAttrVal("Id_patcredtp"));
	}
	/**
	 * 患者信用分类id
	 * @param Id_patcredtp
	 */
	public void setId_patcredtp(String Id_patcredtp) {
		setAttrVal("Id_patcredtp", Id_patcredtp);
	}
	/**
	 * 患者信用分类名称
	 * @return String
	 */
	public String getName_patcredtp() {
		return ((String) getAttrVal("Name_patcredtp"));
	}
	/**
	 * 患者信用分类名称
	 * @param Name_patcredtp
	 */
	public void setName_patcredtp(String Name_patcredtp) {
		setAttrVal("Name_patcredtp", Name_patcredtp);
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
	 * 现住址区县码Id
	 * @return String
	 */
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}
	/**
	 * 现住址区县码Id
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
	 * 现住址邮编
	 * @return String
	 */
	public String getPostcode_addr() {
		return ((String) getAttrVal("Postcode_addr"));
	}
	/**
	 * 现住址邮编
	 * @param Postcode_addr
	 */
	public void setPostcode_addr(String Postcode_addr) {
		setAttrVal("Postcode_addr", Postcode_addr);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}
	/**
	 * 民族
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}
	/**
	 * 民族名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
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
	 * 国籍id
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}
	/**
	 * 国籍id
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getCode_country() {
		return ((String) getAttrVal("Code_country"));
	}
	/**
	 * 国籍编码
	 * @param Code_country
	 */
	public void setCode_country(String Code_country) {
		setAttrVal("Code_country", Code_country);
	}
	/**
	 * 国籍名称
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国籍名称
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
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
	 * 是否可持卡结算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_settlebycard() {
		return ((FBoolean) getAttrVal("Fg_settlebycard"));
	}
	/**
	 * 是否可持卡结算标识
	 * @param Fg_settlebycard
	 */
	public void setFg_settlebycard(FBoolean Fg_settlebycard) {
		setAttrVal("Fg_settlebycard", Fg_settlebycard);
	}
	/**
	 * 能否医保结算标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpsettle() {
		return ((FBoolean) getAttrVal("Fg_hpsettle"));
	}
	/**
	 * 能否医保结算标识
	 * @param Fg_hpsettle
	 */
	public void setFg_hpsettle(FBoolean Fg_hpsettle) {
		setAttrVal("Fg_hpsettle", Fg_hpsettle);
	}
	/**
	 * 辅医保计划id
	 * @return String
	 */
	public String getId_hp_sec() {
		return ((String) getAttrVal("Id_hp_sec"));
	}
	/**
	 * 辅医保计划id
	 * @param Id_hp_sec
	 */
	public void setId_hp_sec(String Id_hp_sec) {
		setAttrVal("Id_hp_sec", Id_hp_sec);
	}
	/**
	 * 辅医保计划
	 * @return String
	 */
	public String getName_hp_sec() {
		return ((String) getAttrVal("Name_hp_sec"));
	}
	/**
	 * 辅医保计划
	 * @param Name_hp_sec
	 */
	public void setName_hp_sec(String Name_hp_sec) {
		setAttrVal("Name_hp_sec", Name_hp_sec);
	}
	/**
	 * 辅医保卡号
	 * @return String
	 */
	public String getNo_hp_sec() {
		return ((String) getAttrVal("No_hp_sec"));
	}
	/**
	 * 辅医保卡号
	 * @param No_hp_sec
	 */
	public void setNo_hp_sec(String No_hp_sec) {
		setAttrVal("No_hp_sec", No_hp_sec);
	}
	/**
	 * 患者现住址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 患者现住址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 实名认证标志
	 * @return FBoolean
	 */
	public FBoolean getFg_realname() {
		return ((FBoolean) getAttrVal("Fg_realname"));
	}
	/**
	 * 实名认证标志
	 * @param Fg_realname
	 */
	public void setFg_realname(FBoolean Fg_realname) {
		setAttrVal("Fg_realname", Fg_realname);
	}
	/**
	 * 是否持卡
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}
	/**
	 * 是否持卡
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 更多
	 * @return FArrayList
	 */
	public FArrayList getMore() {
		return ((FArrayList) getAttrVal("More"));
	}
	/**
	 * 更多
	 * @param More
	 */
	public void setMore(FArrayList More) {
		setAttrVal("More", More);
	}
	/**
	 * 险种类型ID
	 * @return String
	 */
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}
	/**
	 * 险种类型ID
	 * @param Id_hpkind
	 */
	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}
	/**
	 * 险种类型
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}
	/**
	 * 险种类型
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	/**
	 * 患者医保身份
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 患者医保身份
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 户籍类型
	 * @return String
	 */
	public String getName_srcregiontp() {
		return ((String) getAttrVal("Name_srcregiontp"));
	}
	/**
	 * 户籍类型
	 * @param Name_srcregiontp
	 */
	public void setName_srcregiontp(String Name_srcregiontp) {
		setAttrVal("Name_srcregiontp", Name_srcregiontp);
	}
	/**
	 * 户籍类型id
	 * @return String
	 */
	public String getId_srcregiontp() {
		return ((String) getAttrVal("Id_srcregiontp"));
	}
	/**
	 * 户籍类型id
	 * @param Id_srcregiontp
	 */
	public void setId_srcregiontp(String Id_srcregiontp) {
		setAttrVal("Id_srcregiontp", Id_srcregiontp);
	}
	/**
	 * 户籍类型编码
	 * @return String
	 */
	public String getSd_srcregiontp() {
		return ((String) getAttrVal("Sd_srcregiontp"));
	}
	/**
	 * 户籍类型编码
	 * @param Sd_srcregiontp
	 */
	public void setSd_srcregiontp(String Sd_srcregiontp) {
		setAttrVal("Sd_srcregiontp", Sd_srcregiontp);
	}
	/**
	 * 免挂号费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_freereg() {
		return ((FBoolean) getAttrVal("Fg_freereg"));
	}
	/**
	 * 免挂号费标志
	 * @param Fg_freereg
	 */
	public void setFg_freereg(FBoolean Fg_freereg) {
		setAttrVal("Fg_freereg", Fg_freereg);
	}
	/**
	 * 开单医生id
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 开单医生id
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 开单医生
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 开单医生
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 开单科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 开单科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 开单科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
	 * 医疗类别编码
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}
	/**
	 * 医疗类别编码
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 医疗类别id
	 * @return String
	 */
	public String getId_hpmedkind() {
		return ((String) getAttrVal("Id_hpmedkind"));
	}
	/**
	 * 医疗类别id
	 * @param Id_hpmedkind
	 */
	public void setId_hpmedkind(String Id_hpmedkind) {
		setAttrVal("Id_hpmedkind", Id_hpmedkind);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getName_hpmedkind() {
		return ((String) getAttrVal("Name_hpmedkind"));
	}
	/**
	 * 医疗类别
	 * @param Name_hpmedkind
	 */
	public void setName_hpmedkind(String Name_hpmedkind) {
		setAttrVal("Name_hpmedkind", Name_hpmedkind);
	}
	/**
	 * 账户余额
	 * @return FDouble
	 */
	public FDouble getAccamount() {
		return ((FDouble) getAttrVal("Accamount"));
	}
	/**
	 * 账户余额
	 * @param Accamount
	 */
	public void setAccamount(FDouble Accamount) {
		setAttrVal("Accamount", Accamount);
	}
	/**
	 * 三无人员标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nonperson() {
		return ((FBoolean) getAttrVal("Fg_nonperson"));
	}
	/**
	 * 三无人员标识
	 * @param Fg_nonperson
	 */
	public void setFg_nonperson(FBoolean Fg_nonperson) {
		setAttrVal("Fg_nonperson", Fg_nonperson);
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
	 * 医保卡信息
	 * @return FArrayList
	 */
	public FArrayList getHpcardinfo() {
		return ((FArrayList) getAttrVal("Hpcardinfo"));
	}
	/**
	 * 医保卡信息
	 * @param Hpcardinfo
	 */
	public void setHpcardinfo(FArrayList Hpcardinfo) {
		setAttrVal("Hpcardinfo", Hpcardinfo);
	}
	/**
	 * 职业id
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}
	/**
	 * 职业id
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
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
	 * 职业名称
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}
	/**
	 * 职业名称
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 原患者id
	 * @return String
	 */
	public String getId_pat_old() {
		return ((String) getAttrVal("Id_pat_old"));
	}
	/**
	 * 原患者id
	 * @param Id_pat_old
	 */
	public void setId_pat_old(String Id_pat_old) {
		setAttrVal("Id_pat_old", Id_pat_old);
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
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室id
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 面部id
	 * @return String
	 */
	public String getFaceid() {
		return ((String) getAttrVal("Faceid"));
	}
	/**
	 * 面部id
	 * @param Faceid
	 */
	public void setFaceid(String Faceid) {
		setAttrVal("Faceid", Faceid);
	}
}
    
