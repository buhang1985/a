package iih.mi.miinsurebiz.etsettleparam.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊费用报销入参 DTO数据 
 * 
 */
public class EtSettleInParamDTO extends BaseDTO {
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
	 * 门诊就诊id
	 * @return String
	 */
	public String getId_ent_oep() {
		return ((String) getAttrVal("Id_ent_oep"));
	}
	/**
	 * 门诊就诊id
	 * @param Id_ent_oep
	 */
	public void setId_ent_oep(String Id_ent_oep) {
		setAttrVal("Id_ent_oep", Id_ent_oep);
	}
	/**
	 * 住院就诊id
	 * @return String
	 */
	public String getId_ent_ip() {
		return ((String) getAttrVal("Id_ent_ip"));
	}
	/**
	 * 住院就诊id
	 * @param Id_ent_ip
	 */
	public void setId_ent_ip(String Id_ent_ip) {
		setAttrVal("Id_ent_ip", Id_ent_ip);
	}
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 结算id
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 住院流水号(门诊流水号)
	 * @return String
	 */
	public String getSerialno() {
		return ((String) getAttrVal("Serialno"));
	}
	/**
	 * 住院流水号(门诊流水号)
	 * @param Serialno
	 */
	public void setSerialno(String Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getMedkind() {
		return ((String) getAttrVal("Medkind"));
	}
	/**
	 * 医疗类别
	 * @param Medkind
	 */
	public void setMedkind(String Medkind) {
		setAttrVal("Medkind", Medkind);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getBillcode() {
		return ((String) getAttrVal("Billcode"));
	}
	/**
	 * 单据号
	 * @param Billcode
	 */
	public void setBillcode(String Billcode) {
		setAttrVal("Billcode", Billcode);
	}
	/**
	 * 结算日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 结算日期
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 报销标志
	 * @return String
	 */
	public String getSettle_tag() {
		return ((String) getAttrVal("Settle_tag"));
	}
	/**
	 * 报销标志
	 * @param Settle_tag
	 */
	public void setSettle_tag(String Settle_tag) {
		setAttrVal("Settle_tag", Settle_tag);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_outhos() {
		return ((FDateTime) getAttrVal("Dt_outhos"));
	}
	/**
	 * 出院日期
	 * @param Dt_outhos
	 */
	public void setDt_outhos(FDateTime Dt_outhos) {
		setAttrVal("Dt_outhos", Dt_outhos);
	}
	/**
	 * 出院诊断疾病编码
	 * @return String
	 */
	public String getOuthos_dicode() {
		return ((String) getAttrVal("Outhos_dicode"));
	}
	/**
	 * 出院诊断疾病编码
	 * @param Outhos_dicode
	 */
	public void setOuthos_dicode(String Outhos_dicode) {
		setAttrVal("Outhos_dicode", Outhos_dicode);
	}
	/**
	 * 出院诊断疾病名称
	 * @return String
	 */
	public String getOuthos_diname() {
		return ((String) getAttrVal("Outhos_diname"));
	}
	/**
	 * 出院诊断疾病名称
	 * @param Outhos_diname
	 */
	public void setOuthos_diname(String Outhos_diname) {
		setAttrVal("Outhos_diname", Outhos_diname);
	}
	/**
	 * 出院原因
	 * @return String
	 */
	public String getOuthos_reason() {
		return ((String) getAttrVal("Outhos_reason"));
	}
	/**
	 * 出院原因
	 * @param Outhos_reason
	 */
	public void setOuthos_reason(String Outhos_reason) {
		setAttrVal("Outhos_reason", Outhos_reason);
	}
	/**
	 * 账户使用标志
	 * @return FBoolean
	 */
	public FBoolean getAccountuse_tag() {
		return ((FBoolean) getAttrVal("Accountuse_tag"));
	}
	/**
	 * 账户使用标志
	 * @param Accountuse_tag
	 */
	public void setAccountuse_tag(FBoolean Accountuse_tag) {
		setAttrVal("Accountuse_tag", Accountuse_tag);
	}
	/**
	 * 计划生育手术类别
	 * @return String
	 */
	public String getPlanbear_opstype() {
		return ((String) getAttrVal("Planbear_opstype"));
	}
	/**
	 * 计划生育手术类别
	 * @param Planbear_opstype
	 */
	public void setPlanbear_opstype(String Planbear_opstype) {
		setAttrVal("Planbear_opstype", Planbear_opstype);
	}
	/**
	 * 生产方式
	 * @return String
	 */
	public String getBearmethod() {
		return ((String) getAttrVal("Bearmethod"));
	}
	/**
	 * 生产方式
	 * @param Bearmethod
	 */
	public void setBearmethod(String Bearmethod) {
		setAttrVal("Bearmethod", Bearmethod);
	}
	/**
	 * 产前检查标志
	 * @return String
	 */
	public String getExaminebear_tag() {
		return ((String) getAttrVal("Examinebear_tag"));
	}
	/**
	 * 产前检查标志
	 * @param Examinebear_tag
	 */
	public void setExaminebear_tag(String Examinebear_tag) {
		setAttrVal("Examinebear_tag", Examinebear_tag);
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
	 * 出院诊断疾病2编码
	 * @return String
	 */
	public String getOuthos_dicode2() {
		return ((String) getAttrVal("Outhos_dicode2"));
	}
	/**
	 * 出院诊断疾病2编码
	 * @param Outhos_dicode2
	 */
	public void setOuthos_dicode2(String Outhos_dicode2) {
		setAttrVal("Outhos_dicode2", Outhos_dicode2);
	}
	/**
	 * 出院诊断疾病2名称
	 * @return String
	 */
	public String getOuthos_diname2() {
		return ((String) getAttrVal("Outhos_diname2"));
	}
	/**
	 * 出院诊断疾病2名称
	 * @param Outhos_diname2
	 */
	public void setOuthos_diname2(String Outhos_diname2) {
		setAttrVal("Outhos_diname2", Outhos_diname2);
	}
	/**
	 * 出院诊断疾病3编码
	 * @return String
	 */
	public String getOuthos_dicode3() {
		return ((String) getAttrVal("Outhos_dicode3"));
	}
	/**
	 * 出院诊断疾病3编码
	 * @param Outhos_dicode3
	 */
	public void setOuthos_dicode3(String Outhos_dicode3) {
		setAttrVal("Outhos_dicode3", Outhos_dicode3);
	}
	/**
	 * 出院诊断疾病3名称
	 * @return String
	 */
	public String getOuthos_diname3() {
		return ((String) getAttrVal("Outhos_diname3"));
	}
	/**
	 * 出院诊断疾病3名称
	 * @param Outhos_diname3
	 */
	public void setOuthos_diname3(String Outhos_diname3) {
		setAttrVal("Outhos_diname3", Outhos_diname3);
	}
	/**
	 * 生育或终止妊娠时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bear() {
		return ((FDateTime) getAttrVal("Dt_bear"));
	}
	/**
	 * 生育或终止妊娠时间
	 * @param Dt_bear
	 */
	public void setDt_bear(FDateTime Dt_bear) {
		setAttrVal("Dt_bear", Dt_bear);
	}
	/**
	 * 胎儿数
	 * @return Integer
	 */
	public Integer getFetus_count() {
		return ((Integer) getAttrVal("Fetus_count"));
	}
	/**
	 * 胎儿数
	 * @param Fetus_count
	 */
	public void setFetus_count(Integer Fetus_count) {
		setAttrVal("Fetus_count", Fetus_count);
	}
	/**
	 * 胎次
	 * @return String
	 */
	public String getParity() {
		return ((String) getAttrVal("Parity"));
	}
	/**
	 * 胎次
	 * @param Parity
	 */
	public void setParity(String Parity) {
		setAttrVal("Parity", Parity);
	}
	/**
	 * 产前检查费
	 * @return String
	 */
	public String getBearexamine_fee() {
		return ((String) getAttrVal("Bearexamine_fee"));
	}
	/**
	 * 产前检查费
	 * @param Bearexamine_fee
	 */
	public void setBearexamine_fee(String Bearexamine_fee) {
		setAttrVal("Bearexamine_fee", Bearexamine_fee);
	}
	/**
	 * 孕周
	 * @return FDouble
	 */
	public FDouble getPregnantweek() {
		return ((FDouble) getAttrVal("Pregnantweek"));
	}
	/**
	 * 孕周
	 * @param Pregnantweek
	 */
	public void setPregnantweek(FDouble Pregnantweek) {
		setAttrVal("Pregnantweek", Pregnantweek);
	}
	/**
	 * 婴儿状况
	 * @return String
	 */
	public String getBaby_status() {
		return ((String) getAttrVal("Baby_status"));
	}
	/**
	 * 婴儿状况
	 * @param Baby_status
	 */
	public void setBaby_status(String Baby_status) {
		setAttrVal("Baby_status", Baby_status);
	}
	/**
	 * 带药标志
	 * @return String
	 */
	public String getWithdrug_tag() {
		return ((String) getAttrVal("Withdrug_tag"));
	}
	/**
	 * 带药标志
	 * @param Withdrug_tag
	 */
	public void setWithdrug_tag(String Withdrug_tag) {
		setAttrVal("Withdrug_tag", Withdrug_tag);
	}
	/**
	 * 带药月数
	 * @return String
	 */
	public String getWithdurg_month() {
		return ((String) getAttrVal("Withdurg_month"));
	}
	/**
	 * 带药月数
	 * @param Withdurg_month
	 */
	public void setWithdurg_month(String Withdurg_month) {
		setAttrVal("Withdurg_month", Withdurg_month);
	}
	/**
	 * 生育并发症
	 * @return String
	 */
	public String getBearneopathy() {
		return ((String) getAttrVal("Bearneopathy"));
	}
	/**
	 * 生育并发症
	 * @param Bearneopathy
	 */
	public void setBearneopathy(String Bearneopathy) {
		setAttrVal("Bearneopathy", Bearneopathy);
	}
	/**
	 * 个人编码
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人编码
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
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
	 * 门诊登记返回流水号
	 * @return String
	 */
	public String getCode_regist_hp() {
		return ((String) getAttrVal("Code_regist_hp"));
	}
	/**
	 * 门诊登记返回流水号
	 * @param Code_regist_hp
	 */
	public void setCode_regist_hp(String Code_regist_hp) {
		setAttrVal("Code_regist_hp", Code_regist_hp);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getPat_sex() {
		return ((String) getAttrVal("Pat_sex"));
	}
	/**
	 * 性别
	 * @param Pat_sex
	 */
	public void setPat_sex(String Pat_sex) {
		setAttrVal("Pat_sex", Pat_sex);
	}
	/**
	 * 结算数据集
	 * @return FArrayList
	 */
	public FArrayList getData() {
		return ((FArrayList) getAttrVal("Data"));
	}
	/**
	 * 结算数据集
	 * @param Data
	 */
	public void setData(FArrayList Data) {
		setAttrVal("Data", Data);
	}
	/**
	 * 卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}
	/**
	 * 卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 开发商标志
	 * @return String
	 */
	public String getFacadetp() {
		return ((String) getAttrVal("Facadetp"));
	}
	/**
	 * 开发商标志
	 * @param Facadetp
	 */
	public void setFacadetp(String Facadetp) {
		setAttrVal("Facadetp", Facadetp);
	}
	/**
	 * 其他信息
	 * @return FMap
	 */
	public FMap getOtherparam() {
		return ((FMap) getAttrVal("Otherparam"));
	}
	/**
	 * 其他信息
	 * @param Otherparam
	 */
	public void setOtherparam(FMap Otherparam) {
		setAttrVal("Otherparam", Otherparam);
	}
}