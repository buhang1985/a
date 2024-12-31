package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用审核-收付款信息 DTO数据 
 * 
 */
public class BlIpAuditStPayInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * 结算id
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	/**
	 * 收费员id
	 * @return String
	 */
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}
	/**
	 * 收费员id
	 * @param Id_emp_pay
	 */
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	/**
	 * 收费员名称
	 * @return String
	 */
	public String getEmp_name_pay() {
		return ((String) getAttrVal("Emp_name_pay"));
	}
	/**
	 * 收费员名称
	 * @param Emp_name_pay
	 */
	public void setEmp_name_pay(String Emp_name_pay) {
		setAttrVal("Emp_name_pay", Emp_name_pay);
	}
	/**
	 * 付款日期
	 * @return String
	 */
	public String getDt_pay() {
		return ((String) getAttrVal("Dt_pay"));
	}
	/**
	 * 付款日期
	 * @param Dt_pay
	 */
	public void setDt_pay(String Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getSd_pm_name() {
		return ((String) getAttrVal("Sd_pm_name"));
	}
	/**
	 * 付款方式
	 * @param Sd_pm_name
	 */
	public void setSd_pm_name(String Sd_pm_name) {
		setAttrVal("Sd_pm_name", Sd_pm_name);
	}
	/**
	 * 付款状态
	 * @return String
	 */
	public String getPay_status() {
		return ((String) getAttrVal("Pay_status"));
	}
	/**
	 * 付款状态
	 * @param Pay_status
	 */
	public void setPay_status(String Pay_status) {
		setAttrVal("Pay_status", Pay_status);
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
	 * 预交金收据号
	 * @return String
	 */
	public String getPrepaycodeno() {
		return ((String) getAttrVal("Prepaycodeno"));
	}
	/**
	 * 预交金收据号
	 * @param Prepaycodeno
	 */
	public void setPrepaycodeno(String Prepaycodeno) {
		setAttrVal("Prepaycodeno", Prepaycodeno);
	}
}