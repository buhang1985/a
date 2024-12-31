package iih.pi.reg.dto.patap.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.pi.reg.pat.d.PatiAggDO;

import java.math.BigDecimal;

/**
 * chis患者信息(新视图) DTO数据 
 * 
 */
public class PiPatChisInfoDTO extends BaseDTO {
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
	 * 身份证
	 * @return String
	 */
	public String getSocial_no() {
		return ((String) getAttrVal("Social_no"));
	}
	/**
	 * 身份证
	 * @param Social_no
	 */
	public void setSocial_no(String Social_no) {
		setAttrVal("Social_no", Social_no);
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
	 * 条形码卡
	 * @return String
	 */
	public String getP_bar_code() {
		return ((String) getAttrVal("P_bar_code"));
	}
	/**
	 * 条形码卡
	 * @param P_bar_code
	 */
	public void setP_bar_code(String P_bar_code) {
		setAttrVal("P_bar_code", P_bar_code);
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
	 * 性别编码
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别编码
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}
	/**
	 * 婚姻编码
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 国家编码
	 * @return String
	 */
	public String getCountry_code() {
		return ((String) getAttrVal("Country_code"));
	}
	/**
	 * 国家编码
	 * @param Country_code
	 */
	public void setCountry_code(String Country_code) {
		setAttrVal("Country_code", Country_code);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}
	/**
	 * 民族编码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getBirth_place() {
		return ((String) getAttrVal("Birth_place"));
	}
	/**
	 * 出生地
	 * @param Birth_place
	 */
	public void setBirth_place(String Birth_place) {
		setAttrVal("Birth_place", Birth_place);
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
	 * 未知1
	 * @return String
	 */
	public String getInsul_code() {
		return ((String) getAttrVal("Insul_code"));
	}
	/**
	 * 未知1
	 * @param Insul_code
	 */
	public void setInsul_code(String Insul_code) {
		setAttrVal("Insul_code", Insul_code);
	}
	/**
	 * 账户余额
	 * @return FDouble
	 */
	public FDouble getBalance() {
		return ((FDouble) getAttrVal("Balance"));
	}
	/**
	 * 账户余额
	 * @param Balance
	 */
	public void setBalance(FDouble Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 最大接诊次数
	 * @return Integer
	 */
	public Integer getMax_times() {
		return ((Integer) getAttrVal("Max_times"));
	}
	/**
	 * 最大接诊次数
	 * @param Max_times
	 */
	public void setMax_times(Integer Max_times) {
		setAttrVal("Max_times", Max_times);
	}
	/**
	 * 最后就诊时间
	 * @return FDateTime
	 */
	public FDateTime getLv_data() {
		return ((FDateTime) getAttrVal("Lv_data"));
	}
	/**
	 * 最后就诊时间
	 * @param Lv_data
	 */
	public void setLv_data(FDateTime Lv_data) {
		setAttrVal("Lv_data", Lv_data);
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
	 * 黑名单标志(身份)
	 * @return String
	 */
	public String getBlack_flag() {
		return ((String) getAttrVal("Black_flag"));
	}
	/**
	 * 黑名单标志(身份)
	 * @param Black_flag
	 */
	public void setBlack_flag(String Black_flag) {
		setAttrVal("Black_flag", Black_flag);
	}
	/**
	 * 拼音
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 全拼
	 * @return String
	 */
	public String getCpy() {
		return ((String) getAttrVal("Cpy"));
	}
	/**
	 * 全拼
	 * @param Cpy
	 */
	public void setCpy(String Cpy) {
		setAttrVal("Cpy", Cpy);
	}
	/**
	 * 处方细目流水号发生器 
	 * @return Integer
	 */
	public Integer getMax_ledger_sn() {
		return ((Integer) getAttrVal("Max_ledger_sn"));
	}
	/**
	 * 处方细目流水号发生器 
	 * @param Max_ledger_sn
	 */
	public void setMax_ledger_sn(Integer Max_ledger_sn) {
		setAttrVal("Max_ledger_sn", Max_ledger_sn);
	}
	/**
	 * 结帐序号发生器
	 * @return Integer
	 */
	public Integer getMax_item_sn() {
		return ((Integer) getAttrVal("Max_item_sn"));
	}
	/**
	 * 结帐序号发生器
	 * @param Max_item_sn
	 */
	public void setMax_item_sn(Integer Max_item_sn) {
		setAttrVal("Max_item_sn", Max_item_sn);
	}
	/**
	 * 无用
	 * @return Integer
	 */
	public Integer getMax_receipt_sn() {
		return ((Integer) getAttrVal("Max_receipt_sn"));
	}
	/**
	 * 无用
	 * @param Max_receipt_sn
	 */
	public void setMax_receipt_sn(Integer Max_receipt_sn) {
		setAttrVal("Max_receipt_sn", Max_receipt_sn);
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
	 * 未知2
	 * @return String
	 */
	public String getEm_sn() {
		return ((String) getAttrVal("Em_sn"));
	}
	/**
	 * 未知2
	 * @param Em_sn
	 */
	public void setEm_sn(String Em_sn) {
		setAttrVal("Em_sn", Em_sn);
	}
	/**
	 * 收费等级
	 * @return String
	 */
	public String getCharge_grade() {
		return ((String) getAttrVal("Charge_grade"));
	}
	/**
	 * 收费等级
	 * @param Charge_grade
	 */
	public void setCharge_grade(String Charge_grade) {
		setAttrVal("Charge_grade", Charge_grade);
	}
	/**
	 * 现住址区县
	 * @return String
	 */
	public String getTemp_district() {
		return ((String) getAttrVal("Temp_district"));
	}
	/**
	 * 现住址区县
	 * @param Temp_district
	 */
	public void setTemp_district(String Temp_district) {
		setAttrVal("Temp_district", Temp_district);
	}
	/**
	 * 现住址街道
	 * @return String
	 */
	public String getTemp_street() {
		return ((String) getAttrVal("Temp_street"));
	}
	/**
	 * 现住址街道
	 * @param Temp_street
	 */
	public void setTemp_street(String Temp_street) {
		setAttrVal("Temp_street", Temp_street);
	}
	/**
	 * 现住址邮编
	 * @return String
	 */
	public String getTemp_zipcode() {
		return ((String) getAttrVal("Temp_zipcode"));
	}
	/**
	 * 现住址邮编
	 * @param Temp_zipcode
	 */
	public void setTemp_zipcode(String Temp_zipcode) {
		setAttrVal("Temp_zipcode", Temp_zipcode);
	}
	/**
	 * 来源
	 * @return String
	 */
	public String getSource() {
		return ((String) getAttrVal("Source"));
	}
	/**
	 * 来源
	 * @param Source
	 */
	public void setSource(String Source) {
		setAttrVal("Source", Source);
	}
	/**
	 * 实名认证
	 * @return String
	 */
	public String getIdentify_flag() {
		return ((String) getAttrVal("Identify_flag"));
	}
	/**
	 * 实名认证
	 * @param Identify_flag
	 */
	public void setIdentify_flag(String Identify_flag) {
		setAttrVal("Identify_flag", Identify_flag);
	}
	/**
	 * 监护人病人ID
	 * @return String
	 */
	public String getGuarder_patient_id() {
		return ((String) getAttrVal("Guarder_patient_id"));
	}
	/**
	 * 监护人病人ID
	 * @param Guarder_patient_id
	 */
	public void setGuarder_patient_id(String Guarder_patient_id) {
		setAttrVal("Guarder_patient_id", Guarder_patient_id);
	}
	/**
	 * 监护人身份证号
	 * @return String
	 */
	public String getGuarder_social_no() {
		return ((String) getAttrVal("Guarder_social_no"));
	}
	/**
	 * 监护人身份证号
	 * @param Guarder_social_no
	 */
	public void setGuarder_social_no(String Guarder_social_no) {
		setAttrVal("Guarder_social_no", Guarder_social_no);
	}
	/**
	 * 监护人姓名
	 * @return String
	 */
	public String getGuarder_name() {
		return ((String) getAttrVal("Guarder_name"));
	}
	/**
	 * 监护人姓名
	 * @param Guarder_name
	 */
	public void setGuarder_name(String Guarder_name) {
		setAttrVal("Guarder_name", Guarder_name);
	}
	/**
	 * (监护人)创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreate_date() {
		return ((FDateTime) getAttrVal("Create_date"));
	}
	/**
	 * (监护人)创建时间
	 * @param Create_date
	 */
	public void setCreate_date(FDateTime Create_date) {
		setAttrVal("Create_date", Create_date);
	}
	/**
	 * (监护人)操作人员
	 * @return String
	 */
	public String getCreate_operator() {
		return ((String) getAttrVal("Create_operator"));
	}
	/**
	 * (监护人)操作人员
	 * @param Create_operator
	 */
	public void setCreate_operator(String Create_operator) {
		setAttrVal("Create_operator", Create_operator);
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