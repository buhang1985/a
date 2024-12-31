package iih.bl.pay.dto.blprepaydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者预交金dto DTO数据 
 * 
 */
public class BlPrepayDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
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
	 * 患者编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_enttp() {
		return ((String) getAttrVal("Name_enttp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_enttp
	 */
	public void setName_enttp(String Name_enttp) {
		setAttrVal("Name_enttp", Name_enttp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 收款人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 收款人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 收款人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 收款人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 收款部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 收款部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 收款部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 收款部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 收付款日期
	 * @return String
	 */
	public String getDt_pay() {
		return ((String) getAttrVal("Dt_pay"));
	}
	/**
	 * 收付款日期
	 * @param Dt_pay
	 */
	public void setDt_pay(String Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 收据编号
	 * @return String
	 */
	public String getCode_rep() {
		return ((String) getAttrVal("Code_rep"));
	}
	/**
	 * 收据编号
	 * @param Code_rep
	 */
	public void setCode_rep(String Code_rep) {
		setAttrVal("Code_rep", Code_rep);
	}
	/**
	 * 交易金额
	 * @return FDouble
	 */
	public FDouble getPrepay() {
		return ((FDouble) getAttrVal("Prepay"));
	}
	/**
	 * 交易金额
	 * @param Prepay
	 */
	public void setPrepay(FDouble Prepay) {
		setAttrVal("Prepay", Prepay);
	}
	/**
	 * 终端类型
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 终端类型
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 交易方式
	 * @return String
	 */
	public String getId_paymod() {
		return ((String) getAttrVal("Id_paymod"));
	}
	/**
	 * 交易方式
	 * @param Id_paymod
	 */
	public void setId_paymod(String Id_paymod) {
		setAttrVal("Id_paymod", Id_paymod);
	}
	/**
	 * 交易方式编码
	 * @return String
	 */
	public String getCode_paymod() {
		return ((String) getAttrVal("Code_paymod"));
	}
	/**
	 * 交易方式编码
	 * @param Code_paymod
	 */
	public void setCode_paymod(String Code_paymod) {
		setAttrVal("Code_paymod", Code_paymod);
	}
	/**
	 * 交易方式名称
	 * @return String
	 */
	public String getName_paymod() {
		return ((String) getAttrVal("Name_paymod"));
	}
	/**
	 * 交易方式名称
	 * @param Name_paymod
	 */
	public void setName_paymod(String Name_paymod) {
		setAttrVal("Name_paymod", Name_paymod);
	}
	/**
	 * 银行
	 * @return String
	 */
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}
	/**
	 * 银行
	 * @param Id_bank
	 */
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
	/**
	 * 银行名称
	 * @return String
	 */
	public String getName_bank() {
		return ((String) getAttrVal("Name_bank"));
	}
	/**
	 * 银行名称
	 * @param Name_bank
	 */
	public void setName_bank(String Name_bank) {
		setAttrVal("Name_bank", Name_bank);
	}
	/**
	 * 银行卡号
	 * @return String
	 */
	public String getNum_bank() {
		return ((String) getAttrVal("Num_bank"));
	}
	/**
	 * 银行卡号
	 * @param Num_bank
	 */
	public void setNum_bank(String Num_bank) {
		setAttrVal("Num_bank", Num_bank);
	}
	/**
	 * 凭证号码
	 * @return String
	 */
	public String getPaymodeno() {
		return ((String) getAttrVal("Paymodeno"));
	}
	/**
	 * 凭证号码
	 * @param Paymodeno
	 */
	public void setPaymodeno(String Paymodeno) {
		setAttrVal("Paymodeno", Paymodeno);
	}
	/**
	 * 交易凭证号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 交易凭证号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 卡费服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 卡费服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 卡费
	 * @return FDouble
	 */
	public FDouble getCard_amt() {
		return ((FDouble) getAttrVal("Card_amt"));
	}
	/**
	 * 卡费
	 * @param Card_amt
	 */
	public void setCard_amt(FDouble Card_amt) {
		setAttrVal("Card_amt", Card_amt);
	}
	/**
	 * 患者卡id
	 * @return String
	 */
	public String getId_patcard() {
		return ((String) getAttrVal("Id_patcard"));
	}
	/**
	 * 患者卡id
	 * @param Id_patcard
	 */
	public void setId_patcard(String Id_patcard) {
		setAttrVal("Id_patcard", Id_patcard);
	}
	/**
	 * 卡记账方式
	 * @return String
	 */
	public String getEu_cardcgmd() {
		return ((String) getAttrVal("Eu_cardcgmd"));
	}
	/**
	 * 卡记账方式
	 * @param Eu_cardcgmd
	 */
	public void setEu_cardcgmd(String Eu_cardcgmd) {
		setAttrVal("Eu_cardcgmd", Eu_cardcgmd);
	}
	/**
	 * 是否含病历费
	 * @return FBoolean
	 */
	public FBoolean getFg_medrecord() {
		return ((FBoolean) getAttrVal("Fg_medrecord"));
	}
	/**
	 * 是否含病历费
	 * @param Fg_medrecord
	 */
	public void setFg_medrecord(FBoolean Fg_medrecord) {
		setAttrVal("Fg_medrecord", Fg_medrecord);
	}
	/**
	 * 病历费
	 * @return FDouble
	 */
	public FDouble getMedrecord_amt() {
		return ((FDouble) getAttrVal("Medrecord_amt"));
	}
	/**
	 * 病历费
	 * @param Medrecord_amt
	 */
	public void setMedrecord_amt(FDouble Medrecord_amt) {
		setAttrVal("Medrecord_amt", Medrecord_amt);
	}
	/**
	 * 个人账户余额
	 * @return FDouble
	 */
	public FDouble getAccamt() {
		return ((FDouble) getAttrVal("Accamt"));
	}
	/**
	 * 个人账户余额
	 * @param Accamt
	 */
	public void setAccamt(FDouble Accamt) {
		setAttrVal("Accamt", Accamt);
	}
	/**
	 * 第三方支付的交易流水号
	 * @return String
	 */
	public String getTradeno() {
		return ((String) getAttrVal("Tradeno"));
	}
	/**
	 * 第三方支付的交易流水号
	 * @param Tradeno
	 */
	public void setTradeno(String Tradeno) {
		setAttrVal("Tradeno", Tradeno);
	}
	/**
	 * 患者收付款主键
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}
	/**
	 * 患者收付款主键
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 收入
	 * @return String
	 */
	public String getAmt_income() {
		return ((String) getAttrVal("Amt_income"));
	}
	/**
	 * 收入
	 * @param Amt_income
	 */
	public void setAmt_income(String Amt_income) {
		setAttrVal("Amt_income", Amt_income);
	}
	/**
	 * 支出
	 * @return String
	 */
	public String getAmt_pay() {
		return ((String) getAttrVal("Amt_pay"));
	}
	/**
	 * 支出
	 * @param Amt_pay
	 */
	public void setAmt_pay(String Amt_pay) {
		setAttrVal("Amt_pay", Amt_pay);
	}
	/**
	 * 收付款类型
	 * @return String
	 */
	public String getSd_paytp() {
		return ((String) getAttrVal("Sd_paytp"));
	}
	/**
	 * 收付款类型
	 * @param Sd_paytp
	 */
	public void setSd_paytp(String Sd_paytp) {
		setAttrVal("Sd_paytp", Sd_paytp);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 账户余额
	 * @return String
	 */
	public String getAmt_acc() {
		return ((String) getAttrVal("Amt_acc"));
	}
	/**
	 * 账户余额
	 * @param Amt_acc
	 */
	public void setAmt_acc(String Amt_acc) {
		setAttrVal("Amt_acc", Amt_acc);
	}
	/**
	 * 收退名称
	 * @return String
	 */
	public String getName_eu_direct() {
		return ((String) getAttrVal("Name_eu_direct"));
	}
	/**
	 * 收退名称
	 * @param Name_eu_direct
	 */
	public void setName_eu_direct(String Name_eu_direct) {
		setAttrVal("Name_eu_direct", Name_eu_direct);
	}
	/**
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getNum_inc() {
		return ((String) getAttrVal("Num_inc"));
	}
	/**
	 * 发票号
	 * @param Num_inc
	 */
	public void setNum_inc(String Num_inc) {
		setAttrVal("Num_inc", Num_inc);
	}
	/**
	 * 备注付款方式
	 * @return String
	 */
	public String getNode_paydetail() {
		return ((String) getAttrVal("Node_paydetail"));
	}
	/**
	 * 备注付款方式
	 * @param Node_paydetail
	 */
	public void setNode_paydetail(String Node_paydetail) {
		setAttrVal("Node_paydetail", Node_paydetail);
	}
}