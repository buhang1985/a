package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金控制策略与金额 DTO数据 
 * 
 */
public class PrePaidAccAmtDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 欠费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_arrears() {
		return ((FBoolean) getAttrVal("Fg_arrears"));
	}	
	/**
	 * 欠费标志
	 * @param Fg_arrears
	 */
	public void setFg_arrears(FBoolean Fg_arrears) {
		setAttrVal("Fg_arrears", Fg_arrears);
	}
	/**
	 * 欠费等级（0不控制，1警告提醒，2部分控制，3完全控制）
	 * @return String
	 */
	public String getSd_arslv() {
		return ((String) getAttrVal("Sd_arslv"));
	}	
	/**
	 * 欠费等级（0不控制，1警告提醒，2部分控制，3完全控制）
	 * @param Sd_arslv
	 */
	public void setSd_arslv(String Sd_arslv) {
		setAttrVal("Sd_arslv", Sd_arslv);
	}
	/**
	 * 控制金额
	 * @return FDouble
	 */
	public FDouble getAmt_limit() {
		return ((FDouble) getAttrVal("Amt_limit"));
	}	
	/**
	 * 控制金额
	 * @param Amt_limit
	 */
	public void setAmt_limit(FDouble Amt_limit) {
		setAttrVal("Amt_limit", Amt_limit);
	}
	/**
	 * 判断类型（0个人，1团检中个人，2团检单位）
	 * @return String
	 */
	public String getSd_prewarntp() {
		return ((String) getAttrVal("Sd_prewarntp"));
	}	
	/**
	 * 判断类型（0个人，1团检中个人，2团检单位）
	 * @param Sd_prewarntp
	 */
	public void setSd_prewarntp(String Sd_prewarntp) {
		setAttrVal("Sd_prewarntp", Sd_prewarntp);
	}
	/**
	 * 预交金总金额
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}	
	/**
	 * 预交金总金额
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 预交金余额
	 * @return FDouble
	 */
	public FDouble getAmt_bal() {
		return ((FDouble) getAttrVal("Amt_bal"));
	}	
	/**
	 * 预交金余额
	 * @param Amt_bal
	 */
	public void setAmt_bal(FDouble Amt_bal) {
		setAttrVal("Amt_bal", Amt_bal);
	}
	/**
	 * 可用余额
	 * @return FDouble
	 */
	public FDouble getAmt_available() {
		return ((FDouble) getAttrVal("Amt_available"));
	}	
	/**
	 * 可用余额
	 * @param Amt_available
	 */
	public void setAmt_available(FDouble Amt_available) {
		setAttrVal("Amt_available", Amt_available);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者编码
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 预交金策略控制主体
	 * @return String
	 */
	public FArrayList getPrewarns() {
		return ((FArrayList) getAttrVal("Prewarns"));
	}	
	/**
	 * 预交金策略控制主体
	 * @param Prewarns
	 */
	public void setPrewarns(FArrayList Prewarns) {
		setAttrVal("Prewarns", Prewarns);
	}
	/**
	 * 是否扣除新增未记账医嘱金额
	 * @return FBoolean
	 */
	public FBoolean getFg_isdeduct() {
		return ((FBoolean) getAttrVal("Fg_isdeduct"));
	}	
	/**
	 * 是否扣除新增未记账医嘱金额
	 * @param Fg_isdeduct
	 */
	public void setFg_isdeduct(FBoolean Fg_isdeduct) {
		setAttrVal("Fg_isdeduct", Fg_isdeduct);
	}
	/**
	 * 住院预交金信息
	 * @return String
	 */
	public FArrayList getBalancedtos() {
		return ((FArrayList) getAttrVal("Balancedtos"));
	}	
	/**
	 * 住院预交金信息
	 * @param Balancedtos
	 */
	public void setBalancedtos(FArrayList Balancedtos) {
		setAttrVal("Balancedtos", Balancedtos);
	}
}