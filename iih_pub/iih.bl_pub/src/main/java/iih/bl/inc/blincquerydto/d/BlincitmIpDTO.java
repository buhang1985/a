package iih.bl.inc.blincquerydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院发票明细查询用dto DTO数据 
 * 
 */
public class BlincitmIpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发票明细主键
	 * @return String
	 */
	public String getId_incitm() {
		return ((String) getAttrVal("Id_incitm"));
	}
	/**
	 * 发票明细主键
	 * @param Id_incitm
	 */
	public void setId_incitm(String Id_incitm) {
		setAttrVal("Id_incitm", Id_incitm);
	}
	/**
	 * 住院发票主键
	 * @return String
	 */
	public String getId_inc() {
		return ((String) getAttrVal("Id_inc"));
	}
	/**
	 * 住院发票主键
	 * @param Id_inc
	 */
	public void setId_inc(String Id_inc) {
		setAttrVal("Id_inc", Id_inc);
	}
	/**
	 * 票据分类项目名称
	 * @return String
	 */
	public String getName_inccaitm() {
		return ((String) getAttrVal("Name_inccaitm"));
	}
	/**
	 * 票据分类项目名称
	 * @param Name_inccaitm
	 */
	public void setName_inccaitm(String Name_inccaitm) {
		setAttrVal("Name_inccaitm", Name_inccaitm);
	}
	/**
	 * 项目金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 项目金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 项目金额_个人支付
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 项目金额_个人支付
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
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
	 * 所属结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 所属结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 住院号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 患者性别
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
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
	 * 医院名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 医院名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 社保号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 社保号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 每个票据分类下合计
	 * @return FDouble
	 */
	public FDouble getSum_inccaitm() {
		return ((FDouble) getAttrVal("Sum_inccaitm"));
	}
	/**
	 * 每个票据分类下合计
	 * @param Sum_inccaitm
	 */
	public void setSum_inccaitm(FDouble Sum_inccaitm) {
		setAttrVal("Sum_inccaitm", Sum_inccaitm);
	}
	/**
	 * 合计
	 * @return FDouble
	 */
	public FDouble getSum_amt() {
		return ((FDouble) getAttrVal("Sum_amt"));
	}
	/**
	 * 合计
	 * @param Sum_amt
	 */
	public void setSum_amt(FDouble Sum_amt) {
		setAttrVal("Sum_amt", Sum_amt);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_start() {
		return ((FDateTime) getAttrVal("Dt_start"));
	}
	/**
	 * 入院日期
	 * @param Dt_start
	 */
	public void setDt_start(FDateTime Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 发票号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 收款日期
	 * @return FDateTime
	 */
	public FDateTime getDt_inc() {
		return ((FDateTime) getAttrVal("Dt_inc"));
	}
	/**
	 * 收款日期
	 * @param Dt_inc
	 */
	public void setDt_inc(FDateTime Dt_inc) {
		setAttrVal("Dt_inc", Dt_inc);
	}
	/**
	 * 收款人姓名
	 * @return String
	 */
	public String getName_empinc() {
		return ((String) getAttrVal("Name_empinc"));
	}
	/**
	 * 收款人姓名
	 * @param Name_empinc
	 */
	public void setName_empinc(String Name_empinc) {
		setAttrVal("Name_empinc", Name_empinc);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getDay_ip() {
		return ((Integer) getAttrVal("Day_ip"));
	}
	/**
	 * 住院天数
	 * @param Day_ip
	 */
	public void setDay_ip(Integer Day_ip) {
		setAttrVal("Day_ip", Day_ip);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getCase_code() {
		return ((String) getAttrVal("Case_code"));
	}
	/**
	 * 病历号
	 * @param Case_code
	 */
	public void setCase_code(String Case_code) {
		setAttrVal("Case_code", Case_code);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编号
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 这张发票对应的就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 这张发票对应的就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医疗机构类型
	 * @return String
	 */
	public String getHospital_type() {
		return ((String) getAttrVal("Hospital_type"));
	}
	/**
	 * 医疗机构类型
	 * @param Hospital_type
	 */
	public void setHospital_type(String Hospital_type) {
		setAttrVal("Hospital_type", Hospital_type);
	}
	/**
	 * 医保计划类型
	 * @return String
	 */
	public String getHp_type() {
		return ((String) getAttrVal("Hp_type"));
	}
	/**
	 * 医保计划类型
	 * @param Hp_type
	 */
	public void setHp_type(String Hp_type) {
		setAttrVal("Hp_type", Hp_type);
	}
	/**
	 * 收款单位
	 * @return String
	 */
	public String getName_pay() {
		return ((String) getAttrVal("Name_pay"));
	}
	/**
	 * 收款单位
	 * @param Name_pay
	 */
	public void setName_pay(String Name_pay) {
		setAttrVal("Name_pay", Name_pay);
	}
}