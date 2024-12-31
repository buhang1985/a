package iih.bl.pub.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;

/**
 * 费用与IE平台交互的事件DTO DTO数据 
 * 
 */
public class BlIihIeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消息创建时间
	 * @return String
	 */
	public String getMsg_create_date() {
		return ((String) getAttrVal("Msg_create_date"));
	}
	/**
	 * 消息创建时间
	 * @param Msg_create_date
	 */
	public void setMsg_create_date(String Msg_create_date) {
		setAttrVal("Msg_create_date", Msg_create_date);
	}
	
	/**
	 * 消息交互类型
	 * @return String
	 */
	public String getMsg_type() {
		return ((String) getAttrVal("Msg_type"));
	}
	/**
	 * 消息交互类型
	 * @param Msg_type
	 */
	public void setMsg_type(String Msg_type) {
		setAttrVal("Msg_type", Msg_type);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}
	/**
	 * 域ID
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
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
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getEnt_code() {
		return ((String) getAttrVal("Ent_code"));
	}
	/**
	 * 就诊号
	 * @param Ent_code
	 */
	public void setEnt_code(String Ent_code) {
		setAttrVal("Ent_code", Ent_code);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getEnt_times() {
		return ((String) getAttrVal("Ent_times"));
	}
	/**
	 * 就诊次数
	 * @param Ent_times
	 */
	public void setEnt_times(String Ent_times) {
		setAttrVal("Ent_times", Ent_times);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getTranstacttype() {
		return ((String) getAttrVal("Transtacttype"));
	}
	/**
	 * 交易类型
	 * @param Transtacttype
	 */
	public void setTranstacttype(String Transtacttype) {
		setAttrVal("Transtacttype", Transtacttype);
	}
	/**
	 * 收款日期
	 * @return String
	 */
	public String getDt_pay() {
		return ((String) getAttrVal("Dt_pay"));
	}
	/**
	 * 收款日期
	 * @param Dt_pay
	 */
	public void setDt_pay(String Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 收款人编码
	 * @return String
	 */
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}
	/**
	 * 收款人编码
	 * @param Id_emp_pay
	 */
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	/**
	 * 收款人姓名
	 * @return String
	 */
	public String getEmp_pay_name() {
		return ((String) getAttrVal("Emp_pay_name"));
	}
	/**
	 * 收款人姓名
	 * @param Emp_pay_name
	 */
	public void setEmp_pay_name(String Emp_pay_name) {
		setAttrVal("Emp_pay_name", Emp_pay_name);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getInsur_no() {
		return ((String) getAttrVal("Insur_no"));
	}
	/**
	 * 医保号
	 * @param Insur_no
	 */
	public void setInsur_no(String Insur_no) {
		setAttrVal("Insur_no", Insur_no);
	}
	/**
	 * 病人医保付费类型编码
	 * @return String
	 */
	public String getInsur_charge_type_code() {
		return ((String) getAttrVal("Insur_charge_type_code"));
	}
	/**
	 * 病人医保付费类型编码
	 * @param Insur_charge_type_code
	 */
	public void setInsur_charge_type_code(String Insur_charge_type_code) {
		setAttrVal("Insur_charge_type_code", Insur_charge_type_code);
	}
	/**
	 * 病人医保付费类型名称
	 * @return String
	 */
	public String getInsur_charge_type_name() {
		return ((String) getAttrVal("Insur_charge_type_name"));
	}
	/**
	 * 病人医保付费类型名称
	 * @param Insur_charge_type_name
	 */
	public void setInsur_charge_type_name(String Insur_charge_type_name) {
		setAttrVal("Insur_charge_type_name", Insur_charge_type_name);
	}
	/**
	 * 医保金额
	 * @return String
	 */
	public String getInsur_amt() {
		return ((String) getAttrVal("Insur_amt"));
	}
	/**
	 * 医保金额
	 * @param Insur_amt
	 */
	public void setInsur_amt(String Insur_amt) {
		setAttrVal("Insur_amt", Insur_amt);
	}
	/**
	 * 医保金额单位
	 * @return String
	 */
	public String getInsur_amt_unit() {
		return ((String) getAttrVal("Insur_amt_unit"));
	}
	/**
	 * 医保金额单位
	 * @param Insur_amt_unit
	 */
	public void setInsur_amt_unit(String Insur_amt_unit) {
		setAttrVal("Insur_amt_unit", Insur_amt_unit);
	}
	
//	
//	/**
//	 * 其他卡号
//	 * @return String
//	 */
//	public String getOther_card_no4pay() {
//		return ((String) getAttrVal("Other_card_no4pay"));
//	}
//	/**
//	 * 其他卡号
//	 * @param Other_card_no4pay
//	 */
//	public void setOther_card_no4pay(String Other_card_no4pay) {
//		setAttrVal("Other_card_no4pay", Other_card_no4pay);
//	}
//	
//	/**
//	 * 病人付费类别编码
//	 * @return String
//	 */
//	public String getCheck_type() {
//		return ((String) getAttrVal("Check_type"));
//	}
//	/**
//	 * 病人付费类别编码
//	 * @param Check_type
//	 */
//	public void setCheck_type(String Check_type) {
//		setAttrVal("Check_type", Check_type);
//	}
//	
//	/**
//	 * 病人付费类别名称
//	 * @return String
//	 */
//	public String getCheck_type_name() {
//		return ((String) getAttrVal("Check_type_name"));
//	}
//	/**
//	 * 病人付费类别名称
//	 * @param Check_type_name
//	 */
//	public void setCheck_type_name(String Check_type_name) {
//		setAttrVal("Check_type_name", Check_type_name);
//	}
//	
//	/**
//	 *医保外付费金额
//	 * @return String
//	 */
//	public String getCharge_total_money() {
//		return ((String) getAttrVal("Charge_total_money"));
//	}
//	/**
//	 * 医保外付费金额
//	 * @param Charge_total_money
//	 */
//	public void setCharge_total_money(String Charge_total_money) {
//		setAttrVal("Charge_total_money", Charge_total_money);
//	}
//	
//	
//	/**
//	 *医保外付费金额单位
//	 * @return String
//	 */
//	public String getCharge_total_money_unit_name() {
//		return ((String) getAttrVal("Charge_total_money_unit_name"));
//	}
//	/**
//	 * 医保外付费金额单位
//	 * @param Charge_total_money_unit_name
//	 */
//	public void setCharge_total_money_unit_name(String Charge_total_money_unit_name) {
//		setAttrVal("Charge_total_money_unit_name", Charge_total_money_unit_name);
//	}
	
	/**
	 * 其他卡号
	 * @return String
	 */
	public String getOther_card_pay_no() {
		return ((String) getAttrVal("Other_card_pay_no"));
	}
	/**
	 * 其他卡号
	 * @param Other_card_pay_no
	 */
	public void setOther_card_pay_no(String Other_card_pay_no) {
		setAttrVal("Other_card_pay_no", Other_card_pay_no);
	}
	/**
	 * 病人其他卡付费类型编码
	 * @return String
	 */
	public String getOther_card_charge_type_code() {
		return ((String) getAttrVal("Other_card_charge_type_code"));
	}
	/**
	 * 病人其他卡付费类型编码
	 * @param Other_card_charge_type_code
	 */
	public void setOther_card_charge_type_code(String Other_card_charge_type_code) {
		setAttrVal("Other_card_charge_type_code", Other_card_charge_type_code);
	}
	/**
	 * 病人其他卡付费类型名称
	 * @return String
	 */
	public String getOther_card_charge_type_name() {
		return ((String) getAttrVal("Other_card_charge_type_name"));
	}
	/**
	 * 病人其他卡付费类型名称
	 * @param Other_card_charge_type_name
	 */
	public void setOther_card_charge_type_name(String Other_card_charge_type_name) {
		setAttrVal("Other_card_charge_type_name", Other_card_charge_type_name);
	}
	/**
	 * 其他卡金额
	 * @return String
	 */
	public String getOther_card_amt() {
		return ((String) getAttrVal("Other_card_amt"));
	}
	/**
	 * 其他卡金额
	 * @param Other_card_amt
	 */
	public void setOther_card_amt(String Other_card_amt) {
		setAttrVal("Other_card_amt", Other_card_amt);
	}
	/**
	 * 其他卡金额单位
	 * @return String
	 */
	public String getOther_card_amt_unit() {
		return ((String) getAttrVal("Other_card_amt_unit"));
	}
	/**
	 * 其他卡金额单位
	 * @param Other_card_amt_unit
	 */
	public void setOther_card_amt_unit(String Other_card_amt_unit) {
		setAttrVal("Other_card_amt_unit", Other_card_amt_unit);
	}

	
	/**
	 * BlIihIe_bill_DTO  账单信息 DTO数据 
	 * @param FarrayList2
	 */
	public FArrayList2 getBliihie_bill_dto()
	{
		return ((FArrayList2) getAttrVal("Bliihie_bill_dto"));
	}
	/**
	 * BlIihIe_bill_DTO  账单信息 DTO数据 
	 * @param BlIihIe_bill_DTO
	 */
	public void setBliihie_bill_dto(FArrayList2 Bliihie_bill_dto) {
		setAttrVal("Bliihie_bill_dto", Bliihie_bill_dto);
	}
	
	
	
}