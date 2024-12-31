package iih.ei.std.d.v1.bl.oprechargedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊押金充值出参 DTO数据 
 * 
 */
public class OpRechargeResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 票据编码
	 * @return String
	 */
	public String getCode_req() {
		return ((String) getAttrVal("Code_req"));
	}	
	/**
	 * 票据编码
	 * @param Code_req
	 */
	public void setCode_req(String Code_req) {
		setAttrVal("Code_req", Code_req);
	}
	/**
	 * 账户余额
	 * @return String
	 */
	public String getAmt_balance() {
		return ((String) getAttrVal("Amt_balance"));
	}	
	/**
	 * 账户余额
	 * @param Amt_balance
	 */
	public void setAmt_balance(String Amt_balance) {
		setAttrVal("Amt_balance", Amt_balance);
	}
}