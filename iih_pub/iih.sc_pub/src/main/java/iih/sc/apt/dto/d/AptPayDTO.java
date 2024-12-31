package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预约支付DTO DTO数据 
 * 
 */
public class AptPayDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发票号
	 * @return String
	 */
	public String getInvoiceno() {
		return ((String) getAttrVal("Invoiceno"));
	}
	/**
	 * 发票号
	 * @param Invoiceno
	 */
	public void setInvoiceno(String Invoiceno) {
		setAttrVal("Invoiceno", Invoiceno);
	}
	/**
	 * 标准总金额
	 * @return FDouble
	 */
	public FDouble getAmt_st() {
		return ((FDouble) getAttrVal("Amt_st"));
	}
	/**
	 * 标准总金额
	 * @param Amt_st
	 */
	public void setAmt_st(FDouble Amt_st) {
		setAttrVal("Amt_st", Amt_st);
	}
	/**
	 * 医保支付总金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保支付总金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 自付总金额
	 * @return FDouble
	 */
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}
	/**
	 * 自付总金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getPaystyle() {
		return ((String) getAttrVal("Paystyle"));
	}
	/**
	 * 付款方式
	 * @param Paystyle
	 */
	public void setPaystyle(String Paystyle) {
		setAttrVal("Paystyle", Paystyle);
	}
	/**
	 * 银行
	 * @return String
	 */
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}
	/**
	 * 银行
	 * @param Id_bank
	 */
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
	/**
	 * 银行卡号
	 * @return String
	 */
	public String getNo_bank() {
		return ((String) getAttrVal("No_bank"));
	}
	/**
	 * 银行卡号
	 * @param No_bank
	 */
	public void setNo_bank(String No_bank) {
		setAttrVal("No_bank", No_bank);
	}
	/**
	 * 实际支付
	 * @return FDouble
	 */
	public FDouble getRelpay() {
		return ((FDouble) getAttrVal("Relpay"));
	}
	/**
	 * 实际支付
	 * @param Relpay
	 */
	public void setRelpay(FDouble Relpay) {
		setAttrVal("Relpay", Relpay);
	}
	/**
	 * 找零
	 * @return FDouble
	 */
	public FDouble getChange() {
		return ((FDouble) getAttrVal("Change"));
	}
	/**
	 * 找零
	 * @param Change
	 */
	public void setChange(FDouble Change) {
		setAttrVal("Change", Change);
	}
	/**
	 * 记账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_acc() {
		return ((FBoolean) getAttrVal("Fg_acc"));
	}
	/**
	 * 记账标志
	 * @param Fg_acc
	 */
	public void setFg_acc(FBoolean Fg_acc) {
		setAttrVal("Fg_acc", Fg_acc);
	}
	/**
	 * 新划价模式标识
	 * @return FBoolean
	 */
	public FBoolean getFg_newprice() {
		return ((FBoolean) getAttrVal("Fg_newprice"));
	}
	/**
	 * 新划价模式标识
	 * @param Fg_newprice
	 */
	public void setFg_newprice(FBoolean Fg_newprice) {
		setAttrVal("Fg_newprice", Fg_newprice);
	}
	/**
	 * 退费重收标志
	 * @return FBoolean
	 */
	public FBoolean getFg_resettle() {
		return ((FBoolean) getAttrVal("Fg_resettle"));
	}
	/**
	 * 退费重收标志
	 * @param Fg_resettle
	 */
	public void setFg_resettle(FBoolean Fg_resettle) {
		setAttrVal("Fg_resettle", Fg_resettle);
	}
	/**
	 * 是否打印发票
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 是否打印发票
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 支付备注信息
	 * @return String
	 */
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}
	/**
	 * 支付备注信息
	 * @param Remark
	 */
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	/**
	 * 收付款终端类型编码
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 收付款终端类型编码
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 支付信息
	 * @return FArrayList
	 */
	public FArrayList getPayinfo() {
		return ((FArrayList) getAttrVal("Payinfo"));
	}
	/**
	 * 支付信息
	 * @param Payinfo
	 */
	public void setPayinfo(FArrayList Payinfo) {
		setAttrVal("Payinfo", Payinfo);
	}
}