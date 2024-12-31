package iih.bl.inc.blincquerydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊结算发票账单费用信息 DTO数据 
 * 
 */
public class BlinvoicecaitmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发票账单关系主键ID
	 * @return String
	 */
	public String getId_incitmoep() {
		return ((String) getAttrVal("Id_incitmoep"));
	}
	/**
	 * 发票账单关系主键ID
	 * @param Id_incitmoep
	 */
	public void setId_incitmoep(String Id_incitmoep) {
		setAttrVal("Id_incitmoep", Id_incitmoep);
	}
	/**
	 * 发票主键
	 * @return String
	 */
	public String getId_incoep() {
		return ((String) getAttrVal("Id_incoep"));
	}
	/**
	 * 发票主键
	 * @param Id_incoep
	 */
	public void setId_incoep(String Id_incoep) {
		setAttrVal("Id_incoep", Id_incoep);
	}
	/**
	 * 账单项编码
	 * @return String
	 */
	public String getCode_inccam() {
		return ((String) getAttrVal("Code_inccam"));
	}
	/**
	 * 账单项编码
	 * @param Code_inccam
	 */
	public void setCode_inccam(String Code_inccam) {
		setAttrVal("Code_inccam", Code_inccam);
	}
	/**
	 * 账单项名称
	 * @return String
	 */
	public String getName_inccam() {
		return ((String) getAttrVal("Name_inccam"));
	}
	/**
	 * 账单项名称
	 * @param Name_inccam
	 */
	public void setName_inccam(String Name_inccam) {
		setAttrVal("Name_inccam", Name_inccam);
	}
	/**
	 * 标准金额
	 * @return FDouble
	 */
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}
	/**
	 * 标准金额
	 * @param Amt_std
	 */
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 折扣金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 折扣金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 医保基金支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保基金支付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 个人自付部分
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 个人自付部分
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 减免金额
	 * @return FDouble
	 */
	public FDouble getAmt_free() {
		return ((FDouble) getAttrVal("Amt_free"));
	}
	/**
	 * 减免金额
	 * @param Amt_free
	 */
	public void setAmt_free(FDouble Amt_free) {
		setAttrVal("Amt_free", Amt_free);
	}
	/**
	 * 实际支付金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 实际支付金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
}