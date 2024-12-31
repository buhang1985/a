package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 付款信息 DTO数据 
 * 
 */
public class CashDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;

	
	public String getInvoiceNo() {
		return ((String) getAttrVal("InvoiceNo"));
	}	
	public void setInvoiceNo(String Invoiceno) {
		setAttrVal("InvoiceNo", Invoiceno);
	}
	public FDouble getTotal() {
		return ((FDouble) getAttrVal("Total"));
	}	
	public void setTotal(FDouble Total) {
		setAttrVal("Total", Total);
	}
	public FDouble getSelfPay() {
		return ((FDouble) getAttrVal("SelfPay"));
	}	
	public void setSelfPay(FDouble Selfpay) {
		setAttrVal("SelfPay", Selfpay);
	}
	public FDouble getRelPay() {
		return ((FDouble) getAttrVal("RelPay"));
	}	
	public void setRelPay(FDouble Relpay) {
		setAttrVal("RelPay", Relpay);
	}
	public FDouble getChange() {
		return ((FDouble) getAttrVal("Change"));
	}	
	public void setChange(FDouble Change) {
		setAttrVal("Change", Change);
	}
	public String getPayStyle() {
		return ((String) getAttrVal("PayStyle"));
	}	
	public void setPayStyle(String Paystyle) {
		setAttrVal("PayStyle", Paystyle);
	}

	
}