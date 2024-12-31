package iih.bl.st.dto.bloepregrefund.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊退号数据 DTO数据 
 * 
 */
public class BlOepRegRefundDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 终端类型
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 终端类型
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 是否打印重收发票
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 是否打印重收发票
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 是否打印红冲发票
	 * @return FBoolean
	 */
	public FBoolean getFg_printred() {
		return ((FBoolean) getAttrVal("Fg_printred"));
	}
	/**
	 * 是否打印红冲发票
	 * @param Fg_printred
	 */
	public void setFg_printred(FBoolean Fg_printred) {
		setAttrVal("Fg_printred", Fg_printred);
	}
	/**
	 * 记账主键集合
	 * @return FArrayList
	 */
	public FArrayList getId_cg() {
		return ((FArrayList) getAttrVal("Id_cg"));
	}
	/**
	 * 记账主键集合
	 * @param Id_cg
	 */
	public void setId_cg(FArrayList Id_cg) {
		setAttrVal("Id_cg", Id_cg);
	}
	/**
	 * 重收时医保产品id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 重收时医保产品id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 费用总额
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}
	/**
	 * 费用总额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 医保费用总额
	 * @return FDouble
	 */
	public FDouble getAmt_hpall() {
		return ((FDouble) getAttrVal("Amt_hpall"));
	}
	/**
	 * 医保费用总额
	 * @param Amt_hpall
	 */
	public void setAmt_hpall(FDouble Amt_hpall) {
		setAttrVal("Amt_hpall", Amt_hpall);
	}
	/**
	 * 医保基金
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保基金
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 医保个人账户
	 * @return FDouble
	 */
	public FDouble getAmt_psnacc() {
		return ((FDouble) getAttrVal("Amt_psnacc"));
	}
	/**
	 * 医保个人账户
	 * @param Amt_psnacc
	 */
	public void setAmt_psnacc(FDouble Amt_psnacc) {
		setAttrVal("Amt_psnacc", Amt_psnacc);
	}
	/**
	 * 医保现金支付
	 * @return FDouble
	 */
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}
	/**
	 * 医保现金支付
	 * @param Amt_cash
	 */
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	/**
	 * 医保差额
	 * @return FDouble
	 */
	public FDouble getAmt_diff() {
		return ((FDouble) getAttrVal("Amt_diff"));
	}
	/**
	 * 医保差额
	 * @param Amt_diff
	 */
	public void setAmt_diff(FDouble Amt_diff) {
		setAttrVal("Amt_diff", Amt_diff);
	}
	/**
	 * 医保盈亏
	 * @return FDouble
	 */
	public FDouble getAmt_hosbear() {
		return ((FDouble) getAttrVal("Amt_hosbear"));
	}
	/**
	 * 医保盈亏
	 * @param Amt_hosbear
	 */
	public void setAmt_hosbear(FDouble Amt_hosbear) {
		setAttrVal("Amt_hosbear", Amt_hosbear);
	}
	/**
	 * 业务周期号
	 * @return String
	 */
	public String getCode_business() {
		return ((String) getAttrVal("Code_business"));
	}
	/**
	 * 业务周期号
	 * @param Code_business
	 */
	public void setCode_business(String Code_business) {
		setAttrVal("Code_business", Code_business);
	}
	/**
	 * 旧医保平台分摊数据
	 * @return FArrayList
	 */
	public FArrayList getOldpropdata() {
		return ((FArrayList) getAttrVal("Oldpropdata"));
	}
	/**
	 * 旧医保平台分摊数据
	 * @param Oldpropdata
	 */
	public void setOldpropdata(FArrayList Oldpropdata) {
		setAttrVal("Oldpropdata", Oldpropdata);
	}
}