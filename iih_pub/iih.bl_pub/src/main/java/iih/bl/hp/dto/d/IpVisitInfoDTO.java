package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记dto DTO数据 
 * 
 */
public class IpVisitInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院流水号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 住院流水号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getType() {
		return ((String) getAttrVal("Type"));
	}
	/**
	 * 医疗类别
	 * @param Type
	 */
	public void setType(String Type) {
		setAttrVal("Type", Type);
	}
	/**
	 * 挂号日期
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 挂号日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 诊断疾病编码
	 * @return String
	 */
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}
	/**
	 * 诊断疾病编码
	 * @param Di_code
	 */
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}
	/**
	 * 诊断名称
	 * @param Di_name
	 */
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	/**
	 * 病历信息
	 * @return String
	 */
	public String getRecord() {
		return ((String) getAttrVal("Record"));
	}
	/**
	 * 病历信息
	 * @param Record
	 */
	public void setRecord(String Record) {
		setAttrVal("Record", Record);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床位号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getDoc_code() {
		return ((String) getAttrVal("Doc_code"));
	}
	/**
	 * 医生编码
	 * @param Doc_code
	 */
	public void setDoc_code(String Doc_code) {
		setAttrVal("Doc_code", Doc_code);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getDoc_name() {
		return ((String) getAttrVal("Doc_name"));
	}
	/**
	 * 医生姓名
	 * @param Doc_name
	 */
	public void setDoc_name(String Doc_name) {
		setAttrVal("Doc_name", Doc_name);
	}
	/**
	 * 挂号费
	 * @return FDouble
	 */
	public FDouble getAmt_register() {
		return ((FDouble) getAttrVal("Amt_register"));
	}
	/**
	 * 挂号费
	 * @param Amt_register
	 */
	public void setAmt_register(FDouble Amt_register) {
		setAttrVal("Amt_register", Amt_register);
	}
	/**
	 * 检查费
	 * @return FDouble
	 */
	public FDouble getAmt_jiancha() {
		return ((FDouble) getAttrVal("Amt_jiancha"));
	}
	/**
	 * 检查费
	 * @param Amt_jiancha
	 */
	public void setAmt_jiancha(FDouble Amt_jiancha) {
		setAttrVal("Amt_jiancha", Amt_jiancha);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 经办人
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 前次住院号
	 * @return String
	 */
	public String getLast_code_ent() {
		return ((String) getAttrVal("Last_code_ent"));
	}
	/**
	 * 前次住院号
	 * @param Last_code_ent
	 */
	public void setLast_code_ent(String Last_code_ent) {
		setAttrVal("Last_code_ent", Last_code_ent);
	}
	/**
	 * 精神病院免起付线标志
	 * @return FBoolean
	 */
	public FBoolean getFg_freestart() {
		return ((FBoolean) getAttrVal("Fg_freestart"));
	}
	/**
	 * 精神病院免起付线标志
	 * @param Fg_freestart
	 */
	public void setFg_freestart(FBoolean Fg_freestart) {
		setAttrVal("Fg_freestart", Fg_freestart);
	}
	/**
	 * 分院编码
	 * @return String
	 */
	public String getBranch_code() {
		return ((String) getAttrVal("Branch_code"));
	}
	/**
	 * 分院编码
	 * @param Branch_code
	 */
	public void setBranch_code(String Branch_code) {
		setAttrVal("Branch_code", Branch_code);
	}
	/**
	 * 入院第一副诊断编码
	 * @return String
	 */
	public String getCode_ipfirstvicedi() {
		return ((String) getAttrVal("Code_ipfirstvicedi"));
	}
	/**
	 * 入院第一副诊断编码
	 * @param Code_ipfirstvicedi
	 */
	public void setCode_ipfirstvicedi(String Code_ipfirstvicedi) {
		setAttrVal("Code_ipfirstvicedi", Code_ipfirstvicedi);
	}
	/**
	 * 入院第一副诊断名称
	 * @return String
	 */
	public String getName_ipfirstvicedi() {
		return ((String) getAttrVal("Name_ipfirstvicedi"));
	}
	/**
	 * 入院第一副诊断名称
	 * @param Name_ipfirstvicedi
	 */
	public void setName_ipfirstvicedi(String Name_ipfirstvicedi) {
		setAttrVal("Name_ipfirstvicedi", Name_ipfirstvicedi);
	}
	/**
	 * 入院第二副诊断编码
	 * @return String
	 */
	public String getCode_ipsecvicedi() {
		return ((String) getAttrVal("Code_ipsecvicedi"));
	}
	/**
	 * 入院第二副诊断编码
	 * @param Code_ipsecvicedi
	 */
	public void setCode_ipsecvicedi(String Code_ipsecvicedi) {
		setAttrVal("Code_ipsecvicedi", Code_ipsecvicedi);
	}
	/**
	 * 入院第二副诊断名称
	 * @return String
	 */
	public String getName_ipsecvicedi() {
		return ((String) getAttrVal("Name_ipsecvicedi"));
	}
	/**
	 * 入院第二副诊断名称
	 * @param Name_ipsecvicedi
	 */
	public void setName_ipsecvicedi(String Name_ipsecvicedi) {
		setAttrVal("Name_ipsecvicedi", Name_ipsecvicedi);
	}
	/**
	 * 档案号
	 * @return String
	 */
	public String getFileno() {
		return ((String) getAttrVal("Fileno"));
	}
	/**
	 * 档案号
	 * @param Fileno
	 */
	public void setFileno(String Fileno) {
		setAttrVal("Fileno", Fileno);
	}
	/**
	 * 省份
	 * @return String
	 */
	public String getProvince() {
		return ((String) getAttrVal("Province"));
	}
	/**
	 * 省份
	 * @param Province
	 */
	public void setProvince(String Province) {
		setAttrVal("Province", Province);
	}
	/**
	 * 医院等级
	 * @return String
	 */
	public String getLevel_hosp() {
		return ((String) getAttrVal("Level_hosp"));
	}
	/**
	 * 医院等级
	 * @param Level_hosp
	 */
	public void setLevel_hosp(String Level_hosp) {
		setAttrVal("Level_hosp", Level_hosp);
	}
	/**
	 * 入院第三副诊断编码
	 * @return String
	 */
	public String getCode_ipthirdvicedi() {
		return ((String) getAttrVal("Code_ipthirdvicedi"));
	}
	/**
	 * 入院第三副诊断编码
	 * @param Code_ipthirdvicedi
	 */
	public void setCode_ipthirdvicedi(String Code_ipthirdvicedi) {
		setAttrVal("Code_ipthirdvicedi", Code_ipthirdvicedi);
	}
	/**
	 * 入院第四副诊断编码
	 * @return String
	 */
	public String getCode_ip4vicedi() {
		return ((String) getAttrVal("Code_ip4vicedi"));
	}
	/**
	 * 入院第四副诊断编码
	 * @param Code_ip4vicedi
	 */
	public void setCode_ip4vicedi(String Code_ip4vicedi) {
		setAttrVal("Code_ip4vicedi", Code_ip4vicedi);
	}
	/**
	 * 入院第五副诊断编码
	 * @return String
	 */
	public String getCode_ipfivevicedi() {
		return ((String) getAttrVal("Code_ipfivevicedi"));
	}
	/**
	 * 入院第五副诊断编码
	 * @param Code_ipfivevicedi
	 */
	public void setCode_ipfivevicedi(String Code_ipfivevicedi) {
		setAttrVal("Code_ipfivevicedi", Code_ipfivevicedi);
	}
	/**
	 * 起付线
	 * @return FDouble
	 */
	public FDouble getDeductible() {
		return ((FDouble) getAttrVal("Deductible"));
	}
	/**
	 * 起付线
	 * @param Deductible
	 */
	public void setDeductible(FDouble Deductible) {
		setAttrVal("Deductible", Deductible);
	}
}