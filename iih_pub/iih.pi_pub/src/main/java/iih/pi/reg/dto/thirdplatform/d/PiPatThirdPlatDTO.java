package iih.pi.reg.dto.thirdplatform.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方平台患者信息 DTO数据 
 * 
 */
public class PiPatThirdPlatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 第三方平台id
	 * @return String
	 */
	public String getId_third() {
		return ((String) getAttrVal("Id_third"));
	}
	/**
	 * 第三方平台id
	 * @param Id_third
	 */
	public void setId_third(String Id_third) {
		setAttrVal("Id_third", Id_third);
	}
	/**
	 * 第三方平台编码
	 * @return String
	 */
	public String getCode_third() {
		return ((String) getAttrVal("Code_third"));
	}
	/**
	 * 第三方平台编码
	 * @param Code_third
	 */
	public void setCode_third(String Code_third) {
		setAttrVal("Code_third", Code_third);
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
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 主身份标志类型名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 主身份标志类型名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 手机号
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 手机号
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
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
	 * 国家编码
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国家编码
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 国家名称
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国家名称
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
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
	 * 就诊卡信息
	 * @return FArrayList
	 */
	public FArrayList getPatcard() {
		return ((FArrayList) getAttrVal("Patcard"));
	}
	/**
	 * 就诊卡信息
	 * @param Patcard
	 */
	public void setPatcard(FArrayList Patcard) {
		setAttrVal("Patcard", Patcard);
	}
	/**
	 * 医保卡卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 医保卡卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
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
	 * 地址集合
	 * @return FArrayList
	 */
	public FArrayList getAddrarray() {
		return ((FArrayList) getAttrVal("Addrarray"));
	}
	/**
	 * 地址集合
	 * @param Addrarray
	 */
	public void setAddrarray(FArrayList Addrarray) {
		setAttrVal("Addrarray", Addrarray);
	}
	/**
	 * 联系人
	 * @return FArrayList
	 */
	public FArrayList getPatcont() {
		return ((FArrayList) getAttrVal("Patcont"));
	}
	/**
	 * 联系人
	 * @param Patcont
	 */
	public void setPatcont(FArrayList Patcont) {
		setAttrVal("Patcont", Patcont);
	}
}