package iih.pi.acc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者关联金额信息 DTO数据 
 * 
 */
public class PatRelAmountInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 预交金金额
	 * @return FDouble
	 */
	public FDouble getPrepay() {
		return ((FDouble) getAttrVal("Prepay"));
	}
	/**
	 * 预交金金额
	 * @param Prepay
	 */
	public void setPrepay(FDouble Prepay) {
		setAttrVal("Prepay", Prepay);
	}
	/**
	 * 信用总额
	 * @return FDouble
	 */
	public FDouble getCred_total() {
		return ((FDouble) getAttrVal("Cred_total"));
	}
	/**
	 * 信用总额
	 * @param Cred_total
	 */
	public void setCred_total(FDouble Cred_total) {
		setAttrVal("Cred_total", Cred_total);
	}
	/**
	 * 授权消费（未结算费用）
	 * @return FDouble
	 */
	public FDouble getAcc_lock() {
		return ((FDouble) getAttrVal("Acc_lock"));
	}
	/**
	 * 授权消费（未结算费用）
	 * @param Acc_lock
	 */
	public void setAcc_lock(FDouble Acc_lock) {
		setAttrVal("Acc_lock", Acc_lock);
	}
	/**
	 * 可用余额
	 * @return FDouble
	 */
	public FDouble getMoney_canuse() {
		return ((FDouble) getAttrVal("Money_canuse"));
	}
	/**
	 * 可用余额
	 * @param Money_canuse
	 */
	public void setMoney_canuse(FDouble Money_canuse) {
		setAttrVal("Money_canuse", Money_canuse);
	}
	/**
	 * 账户是否被冻结
	 * @return FBoolean
	 */
	public FBoolean getFg_acc_freeze() {
		return ((FBoolean) getAttrVal("Fg_acc_freeze"));
	}
	/**
	 * 账户是否被冻结
	 * @param Fg_acc_freeze
	 */
	public void setFg_acc_freeze(FBoolean Fg_acc_freeze) {
		setAttrVal("Fg_acc_freeze", Fg_acc_freeze);
	}
	/**
	 * 预交金金额_留观
	 * @return FDouble
	 */
	public FDouble getPrepay_emgstay() {
		return ((FDouble) getAttrVal("Prepay_emgstay"));
	}
	/**
	 * 预交金金额_留观
	 * @param Prepay_emgstay
	 */
	public void setPrepay_emgstay(FDouble Prepay_emgstay) {
		setAttrVal("Prepay_emgstay", Prepay_emgstay);
	}
	/**
	 * 消费_授权_留观 
	 * @return FDouble
	 */
	public FDouble getAcc_lock_emgstay() {
		return ((FDouble) getAttrVal("Acc_lock_emgstay"));
	}
	/**
	 * 消费_授权_留观 
	 * @param Acc_lock_emgstay
	 */
	public void setAcc_lock_emgstay(FDouble Acc_lock_emgstay) {
		setAttrVal("Acc_lock_emgstay", Acc_lock_emgstay);
	}
	/**
	 * 留观_信用度
	 * @return FDouble
	 */
	public FDouble getCred_emgstay() {
		return ((FDouble) getAttrVal("Cred_emgstay"));
	}
	/**
	 * 留观_信用度
	 * @param Cred_emgstay
	 */
	public void setCred_emgstay(FDouble Cred_emgstay) {
		setAttrVal("Cred_emgstay", Cred_emgstay);
	}
	/**
	 * 可用余额_留观
	 * @return FDouble
	 */
	public FDouble getMoney_canuse_emgstay() {
		return ((FDouble) getAttrVal("Money_canuse_emgstay"));
	}
	/**
	 * 可用余额_留观
	 * @param Money_canuse_emgstay
	 */
	public void setMoney_canuse_emgstay(FDouble Money_canuse_emgstay) {
		setAttrVal("Money_canuse_emgstay", Money_canuse_emgstay);
	}
	/**
	 * 信用总额_留观
	 * @return FDouble
	 */
	public FDouble getCred_total_emgstay() {
		return ((FDouble) getAttrVal("Cred_total_emgstay"));
	}
	/**
	 * 信用总额_留观
	 * @param Cred_total_emgstay
	 */
	public void setCred_total_emgstay(FDouble Cred_total_emgstay) {
		setAttrVal("Cred_total_emgstay", Cred_total_emgstay);
	}
}