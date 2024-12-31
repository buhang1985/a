package iih.pmp.pay.ordqryrstdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 对账查询请求DTO DTO数据 
 * 
 */
public class BillQryReqDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 对账类型
	 * @return String
	 */
	public String getBill_type() {
		return ((String) getAttrVal("Bill_type"));
	}
	/**
	 * 对账类型
	 * @param Bill_type
	 */
	public void setBill_type(String Bill_type) {
		setAttrVal("Bill_type", Bill_type);
	}
	/**
	 * 对账日期
	 * @return FDate
	 */
	public FDate getDt_bill() {
		return ((FDate) getAttrVal("Dt_bill"));
	}
	/**
	 * 对账日期
	 * @param Dt_bill
	 */
	public void setDt_bill(FDate Dt_bill) {
		setAttrVal("Dt_bill", Dt_bill);
	}
	/**
	 * 对账渠道
	 * @return String
	 */
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}
	/**
	 * 对账渠道
	 * @param Sd_chl
	 */
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
}