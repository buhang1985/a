package iih.bl.pay.dto.prepay.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金收退dto DTO数据 
 * 
 */
public class BlPrepayRDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预交金主键
	 * @return String
	 */
	public String getId_prepay_new() {
		return ((String) getAttrVal("Id_prepay_new"));
	}
	/**
	 * 预交金主键
	 * @param Id_prepay_new
	 */
	public void setId_prepay_new(String Id_prepay_new) {
		setAttrVal("Id_prepay_new", Id_prepay_new);
	}
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 团检id
	 * @return String
	 */
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}
	/**
	 * 团检id
	 * @param Id_pecmpy
	 */
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	/**
	 * 待校验票号
	 * @return String
	 */
	public String getCode_req() {
		return ((String) getAttrVal("Code_req"));
	}
	/**
	 * 待校验票号
	 * @param Code_req
	 */
	public void setCode_req(String Code_req) {
		setAttrVal("Code_req", Code_req);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 收费款终端
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 收费款终端
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}
	/**
	 * 付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 付款方式编码
	 * @return String
	 */
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}
	/**
	 * 付款方式编码
	 * @param Sd_pm
	 */
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}
	/**
	 * 付款方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
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
	 * 银行卡号（第三方交易号）
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 银行卡号（第三方交易号）
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 收款方信息
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}
	/**
	 * 收款方信息
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 银行卡号(真实)
	 * @return String
	 */
	public String getBankcardno() {
		return ((String) getAttrVal("Bankcardno"));
	}
	/**
	 * 银行卡号(真实)
	 * @param Bankcardno
	 */
	public void setBankcardno(String Bankcardno) {
		setAttrVal("Bankcardno", Bankcardno);
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
	 * 收款员
	 * @return String
	 */
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}
	/**
	 * 收款员
	 * @param Id_emp_pay
	 */
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	/**
	 * 原预交金id
	 * @return String
	 */
	public String getId_prepay_old() {
		return ((String) getAttrVal("Id_prepay_old"));
	}
	/**
	 * 原预交金id
	 * @param Id_prepay_old
	 */
	public void setId_prepay_old(String Id_prepay_old) {
		setAttrVal("Id_prepay_old", Id_prepay_old);
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
	 * 可用金额
	 * @return FDouble
	 */
	public FDouble getAmt_avail() {
		return ((FDouble) getAttrVal("Amt_avail"));
	}
	/**
	 * 可用金额
	 * @param Amt_avail
	 */
	public void setAmt_avail(FDouble Amt_avail) {
		setAttrVal("Amt_avail", Amt_avail);
	}
	/**
	 * 收退费日期
	 * @return FDateTime
	 */
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}
	/**
	 * 收退费日期
	 * @param Dt_pay
	 */
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
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
	 * 是否半退
	 * @return FBoolean
	 */
	public FBoolean getIshalfrefund() {
		return ((FBoolean) getAttrVal("Ishalfrefund"));
	}
	/**
	 * 是否半退
	 * @param Ishalfrefund
	 */
	public void setIshalfrefund(FBoolean Ishalfrefund) {
		setAttrVal("Ishalfrefund", Ishalfrefund);
	}
	/**
	 * 退预交金票号
	 * @return String
	 */
	public String getCode_req_refund() {
		return ((String) getAttrVal("Code_req_refund"));
	}
	/**
	 * 退预交金票号
	 * @param Code_req_refund
	 */
	public void setCode_req_refund(String Code_req_refund) {
		setAttrVal("Code_req_refund", Code_req_refund);
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
	 * 手工退账
	 * @return FBoolean
	 */
	public FBoolean getFg_refund_manual() {
		return ((FBoolean) getAttrVal("Fg_refund_manual"));
	}
	/**
	 * 手工退账
	 * @param Fg_refund_manual
	 */
	public void setFg_refund_manual(FBoolean Fg_refund_manual) {
		setAttrVal("Fg_refund_manual", Fg_refund_manual);
	}
}