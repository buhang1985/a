package iih.pi.reg.dto.patap.d;

import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 老chis患者信息 DTO数据 
 * 
 */
public class PiPatOldChisInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	private PatiAggDO patiAgg;
	
	public PatiAggDO getPatiAgg() {
		return patiAgg;
	}
	public void setPatiAgg(PatiAggDO patiAgg) {
		this.patiAgg = patiAgg;
	}
	
	/**
	 * 病人ID
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}
	/**
	 * 病人ID
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
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
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 全拼音
	 * @return String
	 */
	public String getCpy() {
		return ((String) getAttrVal("Cpy"));
	}
	/**
	 * 全拼音
	 * @param Cpy
	 */
	public void setCpy(String Cpy) {
		setAttrVal("Cpy", Cpy);
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
	 * 身份
	 * @return String
	 */
	public String getResponse_type() {
		return ((String) getAttrVal("Response_type"));
	}
	/**
	 * 身份
	 * @param Response_type
	 */
	public void setResponse_type(String Response_type) {
		setAttrVal("Response_type", Response_type);
	}
	/**
	 * 医保身份证 
	 * @return String
	 */
	public String getSocial_no() {
		return ((String) getAttrVal("Social_no"));
	}
	/**
	 * 医保身份证 
	 * @param Social_no
	 */
	public void setSocial_no(String Social_no) {
		setAttrVal("Social_no", Social_no);
	}
	/**
	 * 生日
	 * @return FDate
	 */
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}
	/**
	 * 生日
	 * @param Birthday
	 */
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getP_bar_code() {
		return ((String) getAttrVal("P_bar_code"));
	}
	/**
	 * 条码号
	 * @param P_bar_code
	 */
	public void setP_bar_code(String P_bar_code) {
		setAttrVal("P_bar_code", P_bar_code);
	}
	/**
	 * 实名认证标志
	 * @return String
	 */
	public String getDentify_flag() {
		return ((String) getAttrVal("Dentify_flag"));
	}
	/**
	 * 实名认证标志
	 * @param Dentify_flag
	 */
	public void setDentify_flag(String Dentify_flag) {
		setAttrVal("Dentify_flag", Dentify_flag);
	}
	/**
	 * 出身地区
	 * @return String
	 */
	public String getBirth_place() {
		return ((String) getAttrVal("Birth_place"));
	}
	/**
	 * 出身地区
	 * @param Birth_place
	 */
	public void setBirth_place(String Birth_place) {
		setAttrVal("Birth_place", Birth_place);
	}
	/**
	 * 黑名单标志
	 * @return String
	 */
	public String getBlack_flag() {
		return ((String) getAttrVal("Black_flag"));
	}
	/**
	 * 黑名单标志
	 * @param Black_flag
	 */
	public void setBlack_flag(String Black_flag) {
		setAttrVal("Black_flag", Black_flag);
	}
	/**
	 * 余额
	 * @return FDouble
	 */
	public FDouble getBalance() {
		return ((FDouble) getAttrVal("Balance"));
	}
	/**
	 * 余额
	 * @param Balance
	 */
	public void setBalance(FDouble Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 费别
	 * @return String
	 */
	public String getCharge_type() {
		return ((String) getAttrVal("Charge_type"));
	}
	/**
	 * 费别
	 * @param Charge_type
	 */
	public void setCharge_type(String Charge_type) {
		setAttrVal("Charge_type", Charge_type);
	}
	/**
	 * 合同代码
	 * @return String
	 */
	public String getContract_code() {
		return ((String) getAttrVal("Contract_code"));
	}
	/**
	 * 合同代码
	 * @param Contract_code
	 */
	public void setContract_code(String Contract_code) {
		setAttrVal("Contract_code", Contract_code);
	}
	/**
	 * 国家代码
	 * @return String
	 */
	public String getCountry_code() {
		return ((String) getAttrVal("Country_code"));
	}
	/**
	 * 国家代码
	 * @param Country_code
	 */
	public void setCountry_code(String Country_code) {
		setAttrVal("Country_code", Country_code);
	}
	/**
	 * 医疗证号
	 * @return String
	 */
	public String getHic_no() {
		return ((String) getAttrVal("Hic_no"));
	}
	/**
	 * 医疗证号
	 * @param Hic_no
	 */
	public void setHic_no(String Hic_no) {
		setAttrVal("Hic_no", Hic_no);
	}
	/**
	 * 家庭区县
	 * @return String
	 */
	public String getHome_district() {
		return ((String) getAttrVal("Home_district"));
	}
	/**
	 * 家庭区县
	 * @param Home_district
	 */
	public void setHome_district(String Home_district) {
		setAttrVal("Home_district", Home_district);
	}
	/**
	 * 家庭街道
	 * @return String
	 */
	public String getHome_street() {
		return ((String) getAttrVal("Home_street"));
	}
	/**
	 * 家庭街道
	 * @param Home_street
	 */
	public void setHome_street(String Home_street) {
		setAttrVal("Home_street", Home_street);
	}
	/**
	 * 家庭电话
	 * @return String
	 */
	public String getHome_tel() {
		return ((String) getAttrVal("Home_tel"));
	}
	/**
	 * 家庭电话
	 * @param Home_tel
	 */
	public void setHome_tel(String Home_tel) {
		setAttrVal("Home_tel", Home_tel);
	}
	/**
	 * 家庭邮编
	 * @return String
	 */
	public String getHome_zipcode() {
		return ((String) getAttrVal("Home_zipcode"));
	}
	/**
	 * 家庭邮编
	 * @param Home_zipcode
	 */
	public void setHome_zipcode(String Home_zipcode) {
		setAttrVal("Home_zipcode", Home_zipcode);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getInpatient_no() {
		return ((String) getAttrVal("Inpatient_no"));
	}
	/**
	 * 住院号
	 * @param Inpatient_no
	 */
	public void setInpatient_no(String Inpatient_no) {
		setAttrVal("Inpatient_no", Inpatient_no);
	}
	/**
	 * 保险公司
	 * @return String
	 */
	public String getInsurl_code() {
		return ((String) getAttrVal("Insurl_code"));
	}
	/**
	 * 保险公司
	 * @param Insurl_code
	 */
	public void setInsurl_code(String Insurl_code) {
		setAttrVal("Insurl_code", Insurl_code);
	}
	/**
	 * 最后就诊日期
	 * @return FDateTime
	 */
	public FDateTime getLv_date() {
		return ((FDateTime) getAttrVal("Lv_date"));
	}
	/**
	 * 最后就诊日期
	 * @param Lv_date
	 */
	public void setLv_date(FDateTime Lv_date) {
		setAttrVal("Lv_date", Lv_date);
	}
	/**
	 * 婚姻代码
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}
	/**
	 * 婚姻代码
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 最后就诊次数
	 * @return Integer
	 */
	public Integer getMax_times() {
		return ((Integer) getAttrVal("Max_times"));
	}
	/**
	 * 最后就诊次数
	 * @param Max_times
	 */
	public void setMax_times(Integer Max_times) {
		setAttrVal("Max_times", Max_times);
	}
	/**
	 * 地区编码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}
	/**
	 * 地区编码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	/**
	 * 身份职业特征
	 * @return String
	 */
	public String getOccupation_type() {
		return ((String) getAttrVal("Occupation_type"));
	}
	/**
	 * 身份职业特征
	 * @param Occupation_type
	 */
	public void setOccupation_type(String Occupation_type) {
		setAttrVal("Occupation_type", Occupation_type);
	}
	/**
	 * 门诊号
	 * @return String
	 */
	public String getOutpatient_no() {
		return ((String) getAttrVal("Outpatient_no"));
	}
	/**
	 * 门诊号
	 * @param Outpatient_no
	 */
	public void setOutpatient_no(String Outpatient_no) {
		setAttrVal("Outpatient_no", Outpatient_no);
	}
	/**
	 * 联系人编码
	 * @return String
	 */
	public String getRelation_code() {
		return ((String) getAttrVal("Relation_code"));
	}
	/**
	 * 联系人编码
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
	 * 联系人电话
	 * @return String
	 */
	public String getRelation_tel() {
		return ((String) getAttrVal("Relation_tel"));
	}
	/**
	 * 联系人电话
	 * @param Relation_tel
	 */
	public void setRelation_tel(String Relation_tel) {
		setAttrVal("Relation_tel", Relation_tel);
	}
	/**
	 * 附加的号码  
	 * @return String
	 */
	public String getAddition_no1() {
		return ((String) getAttrVal("Addition_no1"));
	}
	/**
	 * 附加的号码  
	 * @param Addition_no1
	 */
	public void setAddition_no1(String Addition_no1) {
		setAttrVal("Addition_no1", Addition_no1);
	}
	/**
	 * 是否为身份证
	 * @return FBoolean
	 */
	public FBoolean getFg_identity() {
		return ((FBoolean) getAttrVal("Fg_identity"));
	}
	/**
	 * 是否为身份证
	 * @param Fg_identity
	 */
	public void setFg_identity(FBoolean Fg_identity) {
		setAttrVal("Fg_identity", Fg_identity);
	}
}