package iih.ei.std.d.v1.bl.paytradedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 收付款对账信息入参 DTO数据 
 * 
 */
public class PayTradeParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getCode_opera() {
		return ((String) getAttrVal("Code_opera"));
	}	
	/**
	 * 操作员编码
	 * @param Code_opera
	 */
	public void setCode_opera(String Code_opera) {
		setAttrVal("Code_opera", Code_opera);
	}
	/**
	 * 支付方式
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 支付方式
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
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
	 * 订单流水号
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 订单流水号
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
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
	 * 开始时间
	 * @return String
	 */
	public String getDt_start() {
		return ((String) getAttrVal("Dt_start"));
	}	
	/**
	 * 开始时间
	 * @param Dt_start
	 */
	public void setDt_start(String Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}