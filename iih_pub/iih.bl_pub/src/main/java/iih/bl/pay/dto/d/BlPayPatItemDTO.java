package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金页面数据DTO DTO数据 
 * 
 */
public class BlPayPatItemDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
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
	 * 预交金金额
	 * @return FDouble
	 */
	public FDouble getPrepay() {
		return ((FDouble) getAttrVal("Prepay"));
	}
	/**
	 * 预交金金额
	 * @param Prepay
	 */
	public void setPrepay(FDouble Prepay) {
		setAttrVal("Prepay", Prepay);
	}
	/**
	 * 交易金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 交易金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 交易金额大写
	 * @return String
	 */
	public String getAmt_upper() {
		return ((String) getAttrVal("Amt_upper"));
	}
	/**
	 * 交易金额大写
	 * @param Amt_upper
	 */
	public void setAmt_upper(String Amt_upper) {
		setAttrVal("Amt_upper", Amt_upper);
	}
	/**
	 * 消费额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}
	/**
	 * 消费额度
	 * @param Amt_cred
	 */
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	/**
	 * 账户余额
	 * @return FDouble
	 */
	public FDouble getAmt_balance() {
		return ((FDouble) getAttrVal("Amt_balance"));
	}
	/**
	 * 账户余额
	 * @param Amt_balance
	 */
	public void setAmt_balance(FDouble Amt_balance) {
		setAttrVal("Amt_balance", Amt_balance);
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
	public String getPaymod_code() {
		return ((String) getAttrVal("Paymod_code"));
	}
	/**
	 * 交易方式编码
	 * @param Paymod_code
	 */
	public void setPaymod_code(String Paymod_code) {
		setAttrVal("Paymod_code", Paymod_code);
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
	 * 银行卡号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 银行卡号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
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
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 收退款方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 收退款方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 支付窗口
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 支付窗口
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 交易方式名称
	 * @return String
	 */
	public String getPaymod_name() {
		return ((String) getAttrVal("Paymod_name"));
	}
	/**
	 * 交易方式名称
	 * @param Paymod_name
	 */
	public void setPaymod_name(String Paymod_name) {
		setAttrVal("Paymod_name", Paymod_name);
	}
	/**
	 * 银行编码
	 * @return String
	 */
	public String getBank_code() {
		return ((String) getAttrVal("Bank_code"));
	}
	/**
	 * 银行编码
	 * @param Bank_code
	 */
	public void setBank_code(String Bank_code) {
		setAttrVal("Bank_code", Bank_code);
	}
	/**
	 * 银行名称
	 * @return String
	 */
	public String getBank_name() {
		return ((String) getAttrVal("Bank_name"));
	}
	/**
	 * 银行名称
	 * @param Bank_name
	 */
	public void setBank_name(String Bank_name) {
		setAttrVal("Bank_name", Bank_name);
	}
	/**
	 * 操作人编号
	 * @return String
	 */
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}
	/**
	 * 操作人编号
	 * @param Id_emp_pay
	 */
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	/**
	 * 客户id
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}
	/**
	 * 客户id
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 合同单位名称
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}
	/**
	 * 合同单位名称
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}
	/**
	 * 合同单位编码
	 * @return String
	 */
	public String getCode_cust() {
		return ((String) getAttrVal("Code_cust"));
	}
	/**
	 * 合同单位编码
	 * @param Code_cust
	 */
	public void setCode_cust(String Code_cust) {
		setAttrVal("Code_cust", Code_cust);
	}
	/**
	 * 账户名称
	 * @return String
	 */
	public String getAcc_name() {
		return ((String) getAttrVal("Acc_name"));
	}
	/**
	 * 账户名称
	 * @param Acc_name
	 */
	public void setAcc_name(String Acc_name) {
		setAttrVal("Acc_name", Acc_name);
	}
	/**
	 * 手工转账
	 * @return FBoolean
	 */
	public FBoolean getFg_transbankacc() {
		return ((FBoolean) getAttrVal("Fg_transbankacc"));
	}
	/**
	 * 手工转账
	 * @param Fg_transbankacc
	 */
	public void setFg_transbankacc(FBoolean Fg_transbankacc) {
		setAttrVal("Fg_transbankacc", Fg_transbankacc);
	}
	/**
	 * 需补交金额
	 * @return FDouble
	 */
	public FDouble getAmt_needpay() {
		return ((FDouble) getAttrVal("Amt_needpay"));
	}
	/**
	 * 需补交金额
	 * @param Amt_needpay
	 */
	public void setAmt_needpay(FDouble Amt_needpay) {
		setAttrVal("Amt_needpay", Amt_needpay);
	}
}