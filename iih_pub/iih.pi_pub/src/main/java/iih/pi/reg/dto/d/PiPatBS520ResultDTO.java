package iih.pi.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 专用患者基本信息查询服务结果DTO DTO数据 
 * 
 */
public class PiPatBS520ResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 域id
	 * @return String
	 */
	public String getDomainid() {
		return ((String) getAttrVal("Domainid"));
	}
	/**
	 * 域id
	 * @param Domainid
	 */
	public void setDomainid(String Domainid) {
		setAttrVal("Domainid", Domainid);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getMsgtype() {
		return ((String) getAttrVal("Msgtype"));
	}
	/**
	 * 消息类型
	 * @param Msgtype
	 */
	public void setMsgtype(String Msgtype) {
		setAttrVal("Msgtype", Msgtype);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getHospitalcode() {
		return ((String) getAttrVal("Hospitalcode"));
	}
	/**
	 * 医疗机构编码
	 * @param Hospitalcode
	 */
	public void setHospitalcode(String Hospitalcode) {
		setAttrVal("Hospitalcode", Hospitalcode);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHospitalname() {
		return ((String) getAttrVal("Hospitalname"));
	}
	/**
	 * 医疗机构名称
	 * @param Hospitalname
	 */
	public void setHospitalname(String Hospitalname) {
		setAttrVal("Hospitalname", Hospitalname);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
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
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 手机号
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}
	/**
	 * 手机号
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
	}
	/**
	 * 门诊号
	 * @return String
	 */
	public String getCode_amr_oep() {
		return ((String) getAttrVal("Code_amr_oep"));
	}
	/**
	 * 门诊号
	 * @param Code_amr_oep
	 */
	public void setCode_amr_oep(String Code_amr_oep) {
		setAttrVal("Code_amr_oep", Code_amr_oep);
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
	 * 医保号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
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
	public String getBirthday() {
		return ((String) getAttrVal("Birthday"));
	}
	/**
	 * 出生日期
	 * @param Birthday
	 */
	public void setBirthday(String Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getBornplace() {
		return ((String) getAttrVal("Bornplace"));
	}
	/**
	 * 出生地
	 * @param Bornplace
	 */
	public void setBornplace(String Bornplace) {
		setAttrVal("Bornplace", Bornplace);
	}
	/**
	 * 国家
	 * @return String
	 */
	public String getCountry() {
		return ((String) getAttrVal("Country"));
	}
	/**
	 * 国家
	 * @param Country
	 */
	public void setCountry(String Country) {
		setAttrVal("Country", Country);
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
	 * 籍贯
	 * @return String
	 */
	public String getDistrict() {
		return ((String) getAttrVal("District"));
	}
	/**
	 * 籍贯
	 * @param District
	 */
	public void setDistrict(String District) {
		setAttrVal("District", District);
	}
	/**
	 * 学历代码
	 * @return String
	 */
	public String getEducode() {
		return ((String) getAttrVal("Educode"));
	}
	/**
	 * 学历代码
	 * @param Educode
	 */
	public void setEducode(String Educode) {
		setAttrVal("Educode", Educode);
	}
	/**
	 * 职业特征代码
	 * @return String
	 */
	public String getOccutypecode() {
		return ((String) getAttrVal("Occutypecode"));
	}
	/**
	 * 职业特征代码
	 * @param Occutypecode
	 */
	public void setOccutypecode(String Occutypecode) {
		setAttrVal("Occutypecode", Occutypecode);
	}
	/**
	 * 工作单位名称
	 * @return String
	 */
	public String getWorkplace() {
		return ((String) getAttrVal("Workplace"));
	}
	/**
	 * 工作单位名称
	 * @param Workplace
	 */
	public void setWorkplace(String Workplace) {
		setAttrVal("Workplace", Workplace);
	}
	/**
	 * 电子邮件
	 * @return String
	 */
	public String getEmail() {
		return ((String) getAttrVal("Email"));
	}
	/**
	 * 电子邮件
	 * @param Email
	 */
	public void setEmail(String Email) {
		setAttrVal("Email", Email);
	}
	/**
	 * 婚姻状态编码
	 * @return String
	 */
	public String getMarrycode() {
		return ((String) getAttrVal("Marrycode"));
	}
	/**
	 * 婚姻状态编码
	 * @param Marrycode
	 */
	public void setMarrycode(String Marrycode) {
		setAttrVal("Marrycode", Marrycode);
	}
	/**
	 * 家庭电话号码
	 * @return String
	 */
	public String getHometel() {
		return ((String) getAttrVal("Hometel"));
	}
	/**
	 * 家庭电话号码
	 * @param Hometel
	 */
	public void setHometel(String Hometel) {
		setAttrVal("Hometel", Hometel);
	}
	/**
	 * 联系人电话号码
	 * @return String
	 */
	public String getRelationtel() {
		return ((String) getAttrVal("Relationtel"));
	}
	/**
	 * 联系人电话号码
	 * @param Relationtel
	 */
	public void setRelationtel(String Relationtel) {
		setAttrVal("Relationtel", Relationtel);
	}
	/**
	 * 工作单位电话号码
	 * @return String
	 */
	public String getWorktel() {
		return ((String) getAttrVal("Worktel"));
	}
	/**
	 * 工作单位电话号码
	 * @param Worktel
	 */
	public void setWorktel(String Worktel) {
		setAttrVal("Worktel", Worktel);
	}
	/**
	 * 现住地址-区县码
	 * @return String
	 */
	public String getLive_district_code() {
		return ((String) getAttrVal("Live_district_code"));
	}
	/**
	 * 现住地址-区县码
	 * @param Live_district_code
	 */
	public void setLive_district_code(String Live_district_code) {
		setAttrVal("Live_district_code", Live_district_code);
	}
	/**
	 * 现住地址-街道
	 * @return String
	 */
	public String getLive_street() {
		return ((String) getAttrVal("Live_street"));
	}
	/**
	 * 现住地址-街道
	 * @param Live_street
	 */
	public void setLive_street(String Live_street) {
		setAttrVal("Live_street", Live_street);
	}
	/**
	 * 现住地址-地址
	 * @return String
	 */
	public String getLive_address() {
		return ((String) getAttrVal("Live_address"));
	}
	/**
	 * 现住地址-地址
	 * @param Live_address
	 */
	public void setLive_address(String Live_address) {
		setAttrVal("Live_address", Live_address);
	}
	/**
	 * 现住地址-邮编
	 * @return String
	 */
	public String getLive_postcode() {
		return ((String) getAttrVal("Live_postcode"));
	}
	/**
	 * 现住地址-邮编
	 * @param Live_postcode
	 */
	public void setLive_postcode(String Live_postcode) {
		setAttrVal("Live_postcode", Live_postcode);
	}
	/**
	 * 家庭地址-区县码
	 * @return String
	 */
	public String getHome_district_code() {
		return ((String) getAttrVal("Home_district_code"));
	}
	/**
	 * 家庭地址-区县码
	 * @param Home_district_code
	 */
	public void setHome_district_code(String Home_district_code) {
		setAttrVal("Home_district_code", Home_district_code);
	}
	/**
	 * 家庭地址-地址
	 * @return String
	 */
	public String getHome_address() {
		return ((String) getAttrVal("Home_address"));
	}
	/**
	 * 家庭地址-地址
	 * @param Home_address
	 */
	public void setHome_address(String Home_address) {
		setAttrVal("Home_address", Home_address);
	}
	/**
	 * 家庭地址-街道
	 * @return String
	 */
	public String getHome_street() {
		return ((String) getAttrVal("Home_street"));
	}
	/**
	 * 家庭地址-街道
	 * @param Home_street
	 */
	public void setHome_street(String Home_street) {
		setAttrVal("Home_street", Home_street);
	}
	/**
	 * 家庭地址-邮编
	 * @return String
	 */
	public String getHome_zipcode() {
		return ((String) getAttrVal("Home_zipcode"));
	}
	/**
	 * 家庭地址-邮编
	 * @param Home_zipcode
	 */
	public void setHome_zipcode(String Home_zipcode) {
		setAttrVal("Home_zipcode", Home_zipcode);
	}
	/**
	 * 户籍地址-区县码
	 * @return String
	 */
	public String getNative_district_code() {
		return ((String) getAttrVal("Native_district_code"));
	}
	/**
	 * 户籍地址-区县码
	 * @param Native_district_code
	 */
	public void setNative_district_code(String Native_district_code) {
		setAttrVal("Native_district_code", Native_district_code);
	}
	/**
	 * 户籍地址-街道
	 * @return String
	 */
	public String getNative_street() {
		return ((String) getAttrVal("Native_street"));
	}
	/**
	 * 户籍地址-街道
	 * @param Native_street
	 */
	public void setNative_street(String Native_street) {
		setAttrVal("Native_street", Native_street);
	}
	/**
	 * 户籍地址-地址
	 * @return String
	 */
	public String getNative_address() {
		return ((String) getAttrVal("Native_address"));
	}
	/**
	 * 户籍地址-地址
	 * @param Native_address
	 */
	public void setNative_address(String Native_address) {
		setAttrVal("Native_address", Native_address);
	}
	/**
	 * 户籍地址-邮编
	 * @return String
	 */
	public String getNative_postcode() {
		return ((String) getAttrVal("Native_postcode"));
	}
	/**
	 * 户籍地址-邮编
	 * @param Native_postcode
	 */
	public void setNative_postcode(String Native_postcode) {
		setAttrVal("Native_postcode", Native_postcode);
	}
	/**
	 * 工作单位地址-区县码
	 * @return String
	 */
	public String getWork_district_code() {
		return ((String) getAttrVal("Work_district_code"));
	}
	/**
	 * 工作单位地址-区县码
	 * @param Work_district_code
	 */
	public void setWork_district_code(String Work_district_code) {
		setAttrVal("Work_district_code", Work_district_code);
	}
	/**
	 * 工作单位地址-街道
	 * @return String
	 */
	public String getWork_street() {
		return ((String) getAttrVal("Work_street"));
	}
	/**
	 * 工作单位地址-街道
	 * @param Work_street
	 */
	public void setWork_street(String Work_street) {
		setAttrVal("Work_street", Work_street);
	}
	/**
	 * 工作单位地址-地址
	 * @return String
	 */
	public String getWork_address() {
		return ((String) getAttrVal("Work_address"));
	}
	/**
	 * 工作单位地址-地址
	 * @param Work_address
	 */
	public void setWork_address(String Work_address) {
		setAttrVal("Work_address", Work_address);
	}
	/**
	 * 工作单位地址-邮编
	 * @return String
	 */
	public String getWork_postcode() {
		return ((String) getAttrVal("Work_postcode"));
	}
	/**
	 * 工作单位地址-邮编
	 * @param Work_postcode
	 */
	public void setWork_postcode(String Work_postcode) {
		setAttrVal("Work_postcode", Work_postcode);
	}
	/**
	 * 联系人地址-区县码
	 * @return String
	 */
	public String getRelation_district_code() {
		return ((String) getAttrVal("Relation_district_code"));
	}
	/**
	 * 联系人地址-区县码
	 * @param Relation_district_code
	 */
	public void setRelation_district_code(String Relation_district_code) {
		setAttrVal("Relation_district_code", Relation_district_code);
	}
	/**
	 * 联系人地址-街道
	 * @return String
	 */
	public String getRelation_street() {
		return ((String) getAttrVal("Relation_street"));
	}
	/**
	 * 联系人地址-街道
	 * @param Relation_street
	 */
	public void setRelation_street(String Relation_street) {
		setAttrVal("Relation_street", Relation_street);
	}
	/**
	 * 联系人地址-地址
	 * @return String
	 */
	public String getRelation_address() {
		return ((String) getAttrVal("Relation_address"));
	}
	/**
	 * 联系人地址-地址
	 * @param Relation_address
	 */
	public void setRelation_address(String Relation_address) {
		setAttrVal("Relation_address", Relation_address);
	}
	/**
	 * 联系人地址-邮编
	 * @return String
	 */
	public String getRelation_postcode() {
		return ((String) getAttrVal("Relation_postcode"));
	}
	/**
	 * 联系人地址-邮编
	 * @param Relation_postcode
	 */
	public void setRelation_postcode(String Relation_postcode) {
		setAttrVal("Relation_postcode", Relation_postcode);
	}
	/**
	 * 联系人关系代码
	 * @return String
	 */
	public String getRelation_code() {
		return ((String) getAttrVal("Relation_code"));
	}
	/**
	 * 联系人关系代码
	 * @param Relation_code
	 */
	public void setRelation_code(String Relation_code) {
		setAttrVal("Relation_code", Relation_code);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getRelation_name() {
		return ((String) getAttrVal("Relation_name"));
	}
	/**
	 * 联系人姓名
	 * @param Relation_name
	 */
	public void setRelation_name(String Relation_name) {
		setAttrVal("Relation_name", Relation_name);
	}
	/**
	 * 操作人ID
	 * @return String
	 */
	public String getInput_opera() {
		return ((String) getAttrVal("Input_opera"));
	}
	/**
	 * 操作人ID
	 * @param Input_opera
	 */
	public void setInput_opera(String Input_opera) {
		setAttrVal("Input_opera", Input_opera);
	}
	/**
	 * 操作人姓名
	 * @return String
	 */
	public String getInput_opera_name() {
		return ((String) getAttrVal("Input_opera_name"));
	}
	/**
	 * 操作人姓名
	 * @param Input_opera_name
	 */
	public void setInput_opera_name(String Input_opera_name) {
		setAttrVal("Input_opera_name", Input_opera_name);
	}
	/**
	 * 其他证件号码
	 * @return String
	 */
	public String getOthercardno() {
		return ((String) getAttrVal("Othercardno"));
	}
	/**
	 * 其他证件号码
	 * @param Othercardno
	 */
	public void setOthercardno(String Othercardno) {
		setAttrVal("Othercardno", Othercardno);
	}
}