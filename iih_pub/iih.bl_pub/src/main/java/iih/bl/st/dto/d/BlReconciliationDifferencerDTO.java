package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用对账差异DTO DTO数据 
 * 
 */
public class BlReconciliationDifferencerDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 支付金额
	 * @return FDouble
	 */
	public FDouble getPayment_amt() {
		return ((FDouble) getAttrVal("Payment_amt"));
	}
	/**
	 * 支付金额
	 * @param Payment_amt
	 */
	public void setPayment_amt(FDouble Payment_amt) {
		setAttrVal("Payment_amt", Payment_amt);
	}
	/**
	 * 退款金额
	 * @return FDouble
	 */
	public FDouble getRefund_amt() {
		return ((FDouble) getAttrVal("Refund_amt"));
	}
	/**
	 * 退款金额
	 * @param Refund_amt
	 */
	public void setRefund_amt(FDouble Refund_amt) {
		setAttrVal("Refund_amt", Refund_amt);
	}
	/**
	 * 支付数量
	 * @return FDouble
	 */
	public FDouble getPayment_quan() {
		return ((FDouble) getAttrVal("Payment_quan"));
	}
	/**
	 * 支付数量
	 * @param Payment_quan
	 */
	public void setPayment_quan(FDouble Payment_quan) {
		setAttrVal("Payment_quan", Payment_quan);
	}
	/**
	 * 退款数量
	 * @return FDouble
	 */
	public FDouble getRefund_quan() {
		return ((FDouble) getAttrVal("Refund_quan"));
	}
	/**
	 * 退款数量
	 * @param Refund_quan
	 */
	public void setRefund_quan(FDouble Refund_quan) {
		setAttrVal("Refund_quan", Refund_quan);
	}
	/**
	 * 合计金额
	 * @return FDouble
	 */
	public FDouble getTotal_amt() {
		return ((FDouble) getAttrVal("Total_amt"));
	}
	/**
	 * 合计金额
	 * @param Total_amt
	 */
	public void setTotal_amt(FDouble Total_amt) {
		setAttrVal("Total_amt", Total_amt);
	}
	/**
	 * 平台类型
	 * @return String
	 */
	public String getPlatform_type() {
		return ((String) getAttrVal("Platform_type"));
	}
	/**
	 * 平台类型
	 * @param Platform_type
	 */
	public void setPlatform_type(String Platform_type) {
		setAttrVal("Platform_type", Platform_type);
	}
}