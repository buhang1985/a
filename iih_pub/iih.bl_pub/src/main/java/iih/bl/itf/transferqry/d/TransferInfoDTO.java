package iih.bl.itf.transferqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 转账详细信息 DTO数据 
 * 
 */
public class TransferInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
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
	 * 原支付方式
	 * @return String
	 */
	public String getPay_org_ment() {
		return ((String) getAttrVal("Pay_org_ment"));
	}
	/**
	 * 原支付方式
	 * @param Pay_org_ment
	 */
	public void setPay_org_ment(String Pay_org_ment) {
		setAttrVal("Pay_org_ment", Pay_org_ment);
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
	 * 银行
	 * @return String
	 */
	public String getBank() {
		return ((String) getAttrVal("Bank"));
	}
	/**
	 * 银行
	 * @param Bank
	 */
	public void setBank(String Bank) {
		setAttrVal("Bank", Bank);
	}
	/**
	 * 银行卡号
	 * @return String
	 */
	public String getBank_no() {
		return ((String) getAttrVal("Bank_no"));
	}
	/**
	 * 银行卡号
	 * @param Bank_no
	 */
	public void setBank_no(String Bank_no) {
		setAttrVal("Bank_no", Bank_no);
	}
	/**
	 * 付款时间
	 * @return FDateTime
	 */
	public FDateTime getPay_time() {
		return ((FDateTime) getAttrVal("Pay_time"));
	}
	/**
	 * 付款时间
	 * @param Pay_time
	 */
	public void setPay_time(FDateTime Pay_time) {
		setAttrVal("Pay_time", Pay_time);
	}
	/**
	 * 转账操作员
	 * @return String
	 */
	public String getId_emp_transacc() {
		return ((String) getAttrVal("Id_emp_transacc"));
	}
	/**
	 * 转账操作员
	 * @param Id_emp_transacc
	 */
	public void setId_emp_transacc(String Id_emp_transacc) {
		setAttrVal("Id_emp_transacc", Id_emp_transacc);
	}
	/**
	 * 转账时间
	 * @return FDateTime
	 */
	public FDateTime getTransfer_time() {
		return ((FDateTime) getAttrVal("Transfer_time"));
	}
	/**
	 * 转账时间
	 * @param Transfer_time
	 */
	public void setTransfer_time(FDateTime Transfer_time) {
		setAttrVal("Transfer_time", Transfer_time);
	}
}