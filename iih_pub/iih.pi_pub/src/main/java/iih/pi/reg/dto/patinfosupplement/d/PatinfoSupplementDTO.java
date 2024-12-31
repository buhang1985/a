package iih.pi.reg.dto.patinfosupplement.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者信息补充 DTO数据 
 * 
 */
public class PatinfoSupplementDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
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
	public FDate getDt_brith() {
		return ((FDate) getAttrVal("Dt_brith"));
	}
	/**
	 * 出生日期
	 * @param Dt_brith
	 */
	public void setDt_brith(FDate Dt_brith) {
		setAttrVal("Dt_brith", Dt_brith);
	}
	/**
	 * 国籍
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国籍
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国籍编码
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 患者编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 证件类型名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getCode_idtp() {
		return ((String) getAttrVal("Code_idtp"));
	}
	/**
	 * 证件号码
	 * @param Code_idtp
	 */
	public void setCode_idtp(String Code_idtp) {
		setAttrVal("Code_idtp", Code_idtp);
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
	 * 婚姻
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}
	/**
	 * 婚姻
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 婚姻id
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}
	/**
	 * 婚姻id
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}
	/**
	 * 婚姻编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
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
	 * 患者分类
	 * @return String
	 */
	public String getName_paticate() {
		return ((String) getAttrVal("Name_paticate"));
	}
	/**
	 * 患者分类
	 * @param Name_paticate
	 */
	public void setName_paticate(String Name_paticate) {
		setAttrVal("Name_paticate", Name_paticate);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getSd_paticate() {
		return ((String) getAttrVal("Sd_paticate"));
	}
	/**
	 * 患者分类编码
	 * @param Sd_paticate
	 */
	public void setSd_paticate(String Sd_paticate) {
		setAttrVal("Sd_paticate", Sd_paticate);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getName_patcrettp() {
		return ((String) getAttrVal("Name_patcrettp"));
	}
	/**
	 * 信用分类
	 * @param Name_patcrettp
	 */
	public void setName_patcrettp(String Name_patcrettp) {
		setAttrVal("Name_patcrettp", Name_patcrettp);
	}
	/**
	 * 价格分类名称
	 * @return String
	 */
	public String getName_patpritp() {
		return ((String) getAttrVal("Name_patpritp"));
	}
	/**
	 * 价格分类名称
	 * @param Name_patpritp
	 */
	public void setName_patpritp(String Name_patpritp) {
		setAttrVal("Name_patpritp", Name_patpritp);
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
	 * 工作地点
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}
	/**
	 * 工作地点
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 文化程度名称
	 * @return String
	 */
	public String getName_educ() {
		return ((String) getAttrVal("Name_educ"));
	}
	/**
	 * 文化程度名称
	 * @param Name_educ
	 */
	public void setName_educ(String Name_educ) {
		setAttrVal("Name_educ", Name_educ);
	}
	/**
	 * 文化程度id
	 * @return String
	 */
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}
	/**
	 * 文化程度id
	 * @param Id_educ
	 */
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
	}
	/**
	 * 文化程度编码
	 * @return String
	 */
	public String getSd_educ() {
		return ((String) getAttrVal("Sd_educ"));
	}
	/**
	 * 文化程度编码
	 * @param Sd_educ
	 */
	public void setSd_educ(String Sd_educ) {
		setAttrVal("Sd_educ", Sd_educ);
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
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * CHIS条号码
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * CHIS条号码
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 现住区县
	 * @return String
	 */
	public String getName_admdiv() {
		return ((String) getAttrVal("Name_admdiv"));
	}
	/**
	 * 现住区县
	 * @param Name_admdiv
	 */
	public void setName_admdiv(String Name_admdiv) {
		setAttrVal("Name_admdiv", Name_admdiv);
	}
	/**
	 * 现住区县编码
	 * @return String
	 */
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}
	/**
	 * 现住区县编码
	 * @param Sd_admdiv
	 */
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
	}
	/**
	 * 现住区县id
	 * @return String
	 */
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}
	/**
	 * 现住区县id
	 * @param Id_admdiv
	 */
	public void setId_admdiv(String Id_admdiv) {
		setAttrVal("Id_admdiv", Id_admdiv);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAdress() {
		return ((String) getAttrVal("Adress"));
	}
	/**
	 * 现住址
	 * @param Adress
	 */
	public void setAdress(String Adress) {
		setAttrVal("Adress", Adress);
	}
	/**
	 * 建档来源编码
	 * @return String
	 */
	public String getSd_patsrctp() {
		return ((String) getAttrVal("Sd_patsrctp"));
	}
	/**
	 * 建档来源编码
	 * @param Sd_patsrctp
	 */
	public void setSd_patsrctp(String Sd_patsrctp) {
		setAttrVal("Sd_patsrctp", Sd_patsrctp);
	}
	/**
	 * 建档来源
	 * @return String
	 */
	public String getName_patsrctp() {
		return ((String) getAttrVal("Name_patsrctp"));
	}
	/**
	 * 建档来源
	 * @param Name_patsrctp
	 */
	public void setName_patsrctp(String Name_patsrctp) {
		setAttrVal("Name_patsrctp", Name_patsrctp);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getSd_hp() {
		return ((String) getAttrVal("Sd_hp"));
	}
	/**
	 * 医保计划编码
	 * @param Sd_hp
	 */
	public void setSd_hp(String Sd_hp) {
		setAttrVal("Sd_hp", Sd_hp);
	}
	/**
	 * displaynam47
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * displaynam47
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
	 * 医保证件号码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保证件号码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 户籍类型编码
	 * @return String
	 */
	public String getSd_srcregiontps() {
		return ((String) getAttrVal("Sd_srcregiontps"));
	}
	/**
	 * 户籍类型编码
	 * @param Sd_srcregiontps
	 */
	public void setSd_srcregiontps(String Sd_srcregiontps) {
		setAttrVal("Sd_srcregiontps", Sd_srcregiontps);
	}
	/**
	 * 户籍类型
	 * @return String
	 */
	public String getName_srcregiontps() {
		return ((String) getAttrVal("Name_srcregiontps"));
	}
	/**
	 * 户籍类型
	 * @param Name_srcregiontps
	 */
	public void setName_srcregiontps(String Name_srcregiontps) {
		setAttrVal("Name_srcregiontps", Name_srcregiontps);
	}
	/**
	 * 血型编码
	 * @return String
	 */
	public String getSd_blood_adobo() {
		return ((String) getAttrVal("Sd_blood_adobo"));
	}
	/**
	 * 血型编码
	 * @param Sd_blood_adobo
	 */
	public void setSd_blood_adobo(String Sd_blood_adobo) {
		setAttrVal("Sd_blood_adobo", Sd_blood_adobo);
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
	 * 患者标签
	 * @return String
	 */
	public String getId_mark() {
		return ((String) getAttrVal("Id_mark"));
	}
	/**
	 * 患者标签
	 * @param Id_mark
	 */
	public void setId_mark(String Id_mark) {
		setAttrVal("Id_mark", Id_mark);
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
	 * 国家id
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}
	/**
	 * 国家id
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
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
}