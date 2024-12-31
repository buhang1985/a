package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用对账信息展示DTO DTO数据 
 * 
 */
public class BlReconciliationShowDataDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 第三方交易记录id
	 * @return String
	 */
	public String getId_transrcd() {
		return ((String) getAttrVal("Id_transrcd"));
	}
	/**
	 * 第三方交易记录id
	 * @param Id_transrcd
	 */
	public void setId_transrcd(String Id_transrcd) {
		setAttrVal("Id_transrcd", Id_transrcd);
	}
	/**
	 * 第三方交易注册id
	 * @return String
	 */
	public String getId_transreg() {
		return ((String) getAttrVal("Id_transreg"));
	}
	/**
	 * 第三方交易注册id
	 * @param Id_transreg
	 */
	public void setId_transreg(String Id_transreg) {
		setAttrVal("Id_transreg", Id_transreg);
	}
	/**
	 * 第三方交易注册名称
	 * @return String
	 */
	public String getName_transreg() {
		return ((String) getAttrVal("Name_transreg"));
	}
	/**
	 * 第三方交易注册名称
	 * @param Name_transreg
	 */
	public void setName_transreg(String Name_transreg) {
		setAttrVal("Name_transreg", Name_transreg);
	}
	/**
	 * 交易时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}
	/**
	 * 交易时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 交易渠道id
	 * @return String
	 */
	public String getId_serial() {
		return ((String) getAttrVal("Id_serial"));
	}
	/**
	 * 交易渠道id
	 * @param Id_serial
	 */
	public void setId_serial(String Id_serial) {
		setAttrVal("Id_serial", Id_serial);
	}
	/**
	 * 交易渠道编码
	 * @return String
	 */
	public String getCode_serial() {
		return ((String) getAttrVal("Code_serial"));
	}
	/**
	 * 交易渠道编码
	 * @param Code_serial
	 */
	public void setCode_serial(String Code_serial) {
		setAttrVal("Code_serial", Code_serial);
	}
	/**
	 * 交易渠道名称
	 * @return String
	 */
	public String getName_serial() {
		return ((String) getAttrVal("Name_serial"));
	}
	/**
	 * 交易渠道名称
	 * @param Name_serial
	 */
	public void setName_serial(String Name_serial) {
		setAttrVal("Name_serial", Name_serial);
	}
	/**
	 * 交易发生业务场景
	 * @return String
	 */
	public String getId_bizscene() {
		return ((String) getAttrVal("Id_bizscene"));
	}
	/**
	 * 交易发生业务场景
	 * @param Id_bizscene
	 */
	public void setId_bizscene(String Id_bizscene) {
		setAttrVal("Id_bizscene", Id_bizscene);
	}
	/**
	 * 交易发生业务场景编码
	 * @return String
	 */
	public String getCode_bizscene() {
		return ((String) getAttrVal("Code_bizscene"));
	}
	/**
	 * 交易发生业务场景编码
	 * @param Code_bizscene
	 */
	public void setCode_bizscene(String Code_bizscene) {
		setAttrVal("Code_bizscene", Code_bizscene);
	}
	/**
	 * 交易发生业务场景名称
	 * @return String
	 */
	public String getName_bizscene() {
		return ((String) getAttrVal("Name_bizscene"));
	}
	/**
	 * 交易发生业务场景名称
	 * @param Name_bizscene
	 */
	public void setName_bizscene(String Name_bizscene) {
		setAttrVal("Name_bizscene", Name_bizscene);
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 交易描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 交易描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 操作员id
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}
	/**
	 * 操作员id
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作员姓名
	 * @return String
	 */
	public String getName_emp_oper() {
		return ((String) getAttrVal("Name_emp_oper"));
	}
	/**
	 * 操作员姓名
	 * @param Name_emp_oper
	 */
	public void setName_emp_oper(String Name_emp_oper) {
		setAttrVal("Name_emp_oper", Name_emp_oper);
	}
	/**
	 * 交易金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 交易金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 渠道交易号
	 * @return String
	 */
	public String getSerial_no() {
		return ((String) getAttrVal("Serial_no"));
	}
	/**
	 * 渠道交易号
	 * @param Serial_no
	 */
	public void setSerial_no(String Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	/**
	 * 商户订单号
	 * @return String
	 */
	public String getHos_ord_no() {
		return ((String) getAttrVal("Hos_ord_no"));
	}
	/**
	 * 商户订单号
	 * @param Hos_ord_no
	 */
	public void setHos_ord_no(String Hos_ord_no) {
		setAttrVal("Hos_ord_no", Hos_ord_no);
	}
	/**
	 * 内部HIS交易号
	 * @return String
	 */
	public String getVoucher_no() {
		return ((String) getAttrVal("Voucher_no"));
	}
	/**
	 * 内部HIS交易号
	 * @param Voucher_no
	 */
	public void setVoucher_no(String Voucher_no) {
		setAttrVal("Voucher_no", Voucher_no);
	}
	/**
	 * 外部订单号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}
	/**
	 * 外部订单号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 银行订单号
	 * @return String
	 */
	public String getSerial_no_ord() {
		return ((String) getAttrVal("Serial_no_ord"));
	}
	/**
	 * 银行订单号
	 * @param Serial_no_ord
	 */
	public void setSerial_no_ord(String Serial_no_ord) {
		setAttrVal("Serial_no_ord", Serial_no_ord);
	}
	/**
	 * 银行交易号
	 * @return String
	 */
	public String getSerial_no_trd() {
		return ((String) getAttrVal("Serial_no_trd"));
	}
	/**
	 * 银行交易号
	 * @param Serial_no_trd
	 */
	public void setSerial_no_trd(String Serial_no_trd) {
		setAttrVal("Serial_no_trd", Serial_no_trd);
	}
	/**
	 * 患者手机号码
	 * @return String
	 */
	public String getPat_mob() {
		return ((String) getAttrVal("Pat_mob"));
	}
	/**
	 * 患者手机号码
	 * @param Pat_mob
	 */
	public void setPat_mob(String Pat_mob) {
		setAttrVal("Pat_mob", Pat_mob);
	}
	/**
	 * 主身份证件类型id
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 主身份证件类型id
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份证件类编码
	 * @return String
	 */
	public String getCode_idtp() {
		return ((String) getAttrVal("Code_idtp"));
	}
	/**
	 * 主身份证件类编码
	 * @param Code_idtp
	 */
	public void setCode_idtp(String Code_idtp) {
		setAttrVal("Code_idtp", Code_idtp);
	}
	/**
	 * 主身份证件类型名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 主身份证件类型名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 支付方式id
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}
	/**
	 * 支付方式id
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 支付方式编码
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}
	/**
	 * 支付方式编码
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 支付方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}
	/**
	 * 支付方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 是否处理异常
	 * @return FBoolean
	 */
	public FBoolean getFg_rollback() {
		return ((FBoolean) getAttrVal("Fg_rollback"));
	}
	/**
	 * 是否处理异常
	 * @param Fg_rollback
	 */
	public void setFg_rollback(FBoolean Fg_rollback) {
		setAttrVal("Fg_rollback", Fg_rollback);
	}
	/**
	 * 业务类型
	 * @return String
	 */
	public String getBusiness_type() {
		return ((String) getAttrVal("Business_type"));
	}
	/**
	 * 业务类型
	 * @param Business_type
	 */
	public void setBusiness_type(String Business_type) {
		setAttrVal("Business_type", Business_type);
	}
	/**
	 * 交易方向名称
	 * @return String
	 */
	public String getName_eu_direct() {
		return ((String) getAttrVal("Name_eu_direct"));
	}
	/**
	 * 交易方向名称
	 * @param Name_eu_direct
	 */
	public void setName_eu_direct(String Name_eu_direct) {
		setAttrVal("Name_eu_direct", Name_eu_direct);
	}
	/**
	 * 交易方向
	 * @return String
	 */
	public String getCode_eu_direct() {
		return ((String) getAttrVal("Code_eu_direct"));
	}
	/**
	 * 交易方向
	 * @param Code_eu_direct
	 */
	public void setCode_eu_direct(String Code_eu_direct) {
		setAttrVal("Code_eu_direct", Code_eu_direct);
	}
	/**
	 * IIH交易状态编码
	 * @return String
	 */
	public String getCode_eu_iihstatus() {
		return ((String) getAttrVal("Code_eu_iihstatus"));
	}
	/**
	 * IIH交易状态编码
	 * @param Code_eu_iihstatus
	 */
	public void setCode_eu_iihstatus(String Code_eu_iihstatus) {
		setAttrVal("Code_eu_iihstatus", Code_eu_iihstatus);
	}
	/**
	 * IIH交易状态名称
	 * @return String
	 */
	public String getName_eu_iihstatus() {
		return ((String) getAttrVal("Name_eu_iihstatus"));
	}
	/**
	 * IIH交易状态名称
	 * @param Name_eu_iihstatus
	 */
	public void setName_eu_iihstatus(String Name_eu_iihstatus) {
		setAttrVal("Name_eu_iihstatus", Name_eu_iihstatus);
	}
	/**
	 * 商户编号
	 * @return String
	 */
	public String getMerchant_no() {
		return ((String) getAttrVal("Merchant_no"));
	}
	/**
	 * 商户编号
	 * @param Merchant_no
	 */
	public void setMerchant_no(String Merchant_no) {
		setAttrVal("Merchant_no", Merchant_no);
	}
	/**
	 * 终端IP
	 * @return String
	 */
	public String getTerminal_addr() {
		return ((String) getAttrVal("Terminal_addr"));
	}
	/**
	 * 终端IP
	 * @param Terminal_addr
	 */
	public void setTerminal_addr(String Terminal_addr) {
		setAttrVal("Terminal_addr", Terminal_addr);
	}
	/**
	 * 异常状态
	 * @return String
	 */
	public String getException_type() {
		return ((String) getAttrVal("Exception_type"));
	}
	/**
	 * 异常状态
	 * @param Exception_type
	 */
	public void setException_type(String Exception_type) {
		setAttrVal("Exception_type", Exception_type);
	}
	/**
	 * 异常原因
	 * @return String
	 */
	public String getException_reason() {
		return ((String) getAttrVal("Exception_reason"));
	}
	/**
	 * 异常原因
	 * @param Exception_reason
	 */
	public void setException_reason(String Exception_reason) {
		setAttrVal("Exception_reason", Exception_reason);
	}
	/**
	 * 退款交易号
	 * @return String
	 */
	public String getRefund_req_no() {
		return ((String) getAttrVal("Refund_req_no"));
	}
	/**
	 * 退款交易号
	 * @param Refund_req_no
	 */
	public void setRefund_req_no(String Refund_req_no) {
		setAttrVal("Refund_req_no", Refund_req_no);
	}
	/**
	 * 关联id
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}
	/**
	 * 关联id
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 平台交易状态编码
	 * @return String
	 */
	public String getCode_eu_pmpstatus() {
		return ((String) getAttrVal("Code_eu_pmpstatus"));
	}
	/**
	 * 平台交易状态编码
	 * @param Code_eu_pmpstatus
	 */
	public void setCode_eu_pmpstatus(String Code_eu_pmpstatus) {
		setAttrVal("Code_eu_pmpstatus", Code_eu_pmpstatus);
	}
	/**
	 * 平台交易状态名称
	 * @return String
	 */
	public String getName_eu_pmpstatus() {
		return ((String) getAttrVal("Name_eu_pmpstatus"));
	}
	/**
	 * 平台交易状态名称
	 * @param Name_eu_pmpstatus
	 */
	public void setName_eu_pmpstatus(String Name_eu_pmpstatus) {
		setAttrVal("Name_eu_pmpstatus", Name_eu_pmpstatus);
	}
}