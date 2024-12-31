package iih.ei.std.d.v1.bl.thirdpaytradedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信支付宝对账出参明细 DTO数据 
 * 
 */
public class ThirdPayInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交易时间
	 * @return String
	 */
	public String getDt_pay() {
		return ((String) getAttrVal("Dt_pay"));
	}	
	/**
	 * 交易时间
	 * @param Dt_pay
	 */
	public void setDt_pay(String Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
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
	 * 订单号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	/**
	 * 订单号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 交易号
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 交易号
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
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
	 * 收据id
	 * @return String
	 */
	public String getCode_rep() {
		return ((String) getAttrVal("Code_rep"));
	}	
	/**
	 * 收据id
	 * @param Code_rep
	 */
	public void setCode_rep(String Code_rep) {
		setAttrVal("Code_rep", Code_rep);
	}
	/**
	 * 业务类型值
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 业务类型值
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 订单来源终端编码
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 订单来源终端编码
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 订单来源终端名称
	 * @return String
	 */
	public String getName_pttp() {
		return ((String) getAttrVal("Name_pttp"));
	}	
	/**
	 * 订单来源终端名称
	 * @param Name_pttp
	 */
	public void setName_pttp(String Name_pttp) {
		setAttrVal("Name_pttp", Name_pttp);
	}
	/**
	 * 订单渠道类型
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}	
	/**
	 * 订单渠道类型
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
}