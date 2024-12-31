package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊挂号结算信息DTO DTO数据 
 * 
 */
public class OpRegStDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊结算id
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 门诊结算id
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}

	/**
	 * 门诊收款id
	 * @return String
	 */
	public String getId_pay() {
		return ((String) getAttrVal("Id_pay"));
	}
	/**
	 * 门诊收款id
	 * @param Id_stoep
	 */
	public void setId_pay(String Id_pay) {
		setAttrVal("Id_pay", Id_pay);
	}
	/**
	 * 记账id
	 * @return String
	 */
	public String getId_cg() {
		return ((String) getAttrVal("Id_cg"));
	}
	/**
	 * 记账id
	 * @param Id_cg
	 */
	public void setId_cg(String Id_cg) {
		setAttrVal("Id_cg", Id_cg);
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
	 * 医保支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保支付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 患者自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 患者自付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 支付金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 支付金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 结算日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 结算日期
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}

	/**
	 * 支付明细集合
	 * @return FArrayList
	 */
	public FArrayList getPayitm_list() {
		return ((FArrayList) getAttrVal("Payitm_list"));
	}
	/**
	 * 支付明细集合
	 * @param Payitm_list
	 */
	public void setPayitm_list(FArrayList Payitm_list) {
		setAttrVal("Payitm_list", Payitm_list);
	}
}