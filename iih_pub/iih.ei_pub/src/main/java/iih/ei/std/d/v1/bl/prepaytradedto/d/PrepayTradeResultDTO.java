package iih.ei.std.d.v1.bl.prepaytradedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 查询预交金对账出参 DTO数据 
 * 
 */
public class PrepayTradeResultDTO extends BaseDTO {
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
	 * 交易笔数
	 * @return String
	 */
	public String getCount_trade() {
		return ((String) getAttrVal("Count_trade"));
	}	
	/**
	 * 交易笔数
	 * @param Count_trade
	 */
	public void setCount_trade(String Count_trade) {
		setAttrVal("Count_trade", Count_trade);
	}
	/**
	 * 第三方总金额
	 * @return String
	 */
	public String getAmt_third() {
		return ((String) getAttrVal("Amt_third"));
	}	
	/**
	 * 第三方总金额
	 * @param Amt_third
	 */
	public void setAmt_third(String Amt_third) {
		setAttrVal("Amt_third", Amt_third);
	}
	/**
	 * iih中总金额
	 * @return String
	 */
	public String getAmt_iih() {
		return ((String) getAttrVal("Amt_iih"));
	}	
	/**
	 * iih中总金额
	 * @param Amt_iih
	 */
	public void setAmt_iih(String Amt_iih) {
		setAttrVal("Amt_iih", Amt_iih);
	}
	/**
	 * 对账情况
	 * @return String
	 */
	public String getStatus_trade() {
		return ((String) getAttrVal("Status_trade"));
	}	
	/**
	 * 对账情况
	 * @param Status_trade
	 */
	public void setStatus_trade(String Status_trade) {
		setAttrVal("Status_trade", Status_trade);
	}
	/**
	 * 是否存在订单号和流水凭证号
	 * @return String
	 */
	public String getFg_exitno() {
		return ((String) getAttrVal("Fg_exitno"));
	}	
	/**
	 * 是否存在订单号和流水凭证号
	 * @param Fg_exitno
	 */
	public void setFg_exitno(String Fg_exitno) {
		setAttrVal("Fg_exitno", Fg_exitno);
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
	 * 根据订单号查询的订单支付时间
	 * @return String
	 */
	public String getOr_dt_pay() {
		return ((String) getAttrVal("Or_dt_pay"));
	}	
	/**
	 * 根据订单号查询的订单支付时间
	 * @param Or_dt_pay
	 */
	public void setOr_dt_pay(String Or_dt_pay) {
		setAttrVal("Or_dt_pay", Or_dt_pay);
	}
	/**
	 * 根据订单号查询的订单支付方式
	 * @return String
	 */
	public String getOr_code_pm() {
		return ((String) getAttrVal("Or_code_pm"));
	}	
	/**
	 * 根据订单号查询的订单支付方式
	 * @param Or_code_pm
	 */
	public void setOr_code_pm(String Or_code_pm) {
		setAttrVal("Or_code_pm", Or_code_pm);
	}
	/**
	 * 根据订单号查询的流水凭证号
	 * @return String
	 */
	public String getOr_bankno() {
		return ((String) getAttrVal("Or_bankno"));
	}	
	/**
	 * 根据订单号查询的流水凭证号
	 * @param Or_bankno
	 */
	public void setOr_bankno(String Or_bankno) {
		setAttrVal("Or_bankno", Or_bankno);
	}
	/**
	 * 根据订单号查询的订单号
	 * @return String
	 */
	public String getOr_paymodenode() {
		return ((String) getAttrVal("Or_paymodenode"));
	}	
	/**
	 * 根据订单号查询的订单号
	 * @param Or_paymodenode
	 */
	public void setOr_paymodenode(String Or_paymodenode) {
		setAttrVal("Or_paymodenode", Or_paymodenode);
	}
	/**
	 * 根据订单号查询的票据号
	 * @return String
	 */
	public String getOr_code_rep() {
		return ((String) getAttrVal("Or_code_rep"));
	}	
	/**
	 * 根据订单号查询的票据号
	 * @param Or_code_rep
	 */
	public void setOr_code_rep(String Or_code_rep) {
		setAttrVal("Or_code_rep", Or_code_rep);
	}
	/**
	 * 根据订单号查询的订单金额
	 * @return String
	 */
	public String getOr_amt() {
		return ((String) getAttrVal("Or_amt"));
	}	
	/**
	 * 根据订单号查询的订单金额
	 * @param Or_amt
	 */
	public void setOr_amt(String Or_amt) {
		setAttrVal("Or_amt", Or_amt);
	}
	/**
	 * 预交金对账出参对账明细信息
	 * @return String
	 */
	public FArrayList getOrderinfo() {
		return ((FArrayList) getAttrVal("Orderinfo"));
	}	
	/**
	 * 预交金对账出参对账明细信息
	 * @param Orderinfo
	 */
	public void setOrderinfo(FArrayList Orderinfo) {
		setAttrVal("Orderinfo", Orderinfo);
	}
}