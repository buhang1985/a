package iih.bl.st.payment.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院收付款预交金DTO DTO数据 
 * 
 */
public class BlIpPrePayPatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预交金主键
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}
	/**
	 * 预交金主键
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
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
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 收付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}
	/**
	 * 收付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 收付款方式编码
	 * @return String
	 */
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}
	/**
	 * 收付款方式编码
	 * @param Sd_pm
	 */
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	/**
	 * 收款方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}
	/**
	 * 收款方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 收款方信息
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}
	/**
	 * 收款方信息
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 收退款金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 收退款金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 是否已找零
	 * @return FBoolean
	 */
	public FBoolean getFg_change() {
		return ((FBoolean) getAttrVal("Fg_change"));
	}
	/**
	 * 是否已找零
	 * @param Fg_change
	 */
	public void setFg_change(FBoolean Fg_change) {
		setAttrVal("Fg_change", Fg_change);
	}
	/**
	 * 预交金收据号
	 * @return String
	 */
	public String getCode_rep() {
		return ((String) getAttrVal("Code_rep"));
	}
	/**
	 * 预交金收据号
	 * @param Code_rep
	 */
	public void setCode_rep(String Code_rep) {
		setAttrVal("Code_rep", Code_rep);
	}
	/**
	 * 患者收付款类型编码
	 * @return String
	 */
	public String getSd_paytp() {
		return ((String) getAttrVal("Sd_paytp"));
	}
	/**
	 * 患者收付款类型编码
	 * @param Sd_paytp
	 */
	public void setSd_paytp(String Sd_paytp) {
		setAttrVal("Sd_paytp", Sd_paytp);
	}
	/**
	 * 患者收付款类型
	 * @return String
	 */
	public String getId_paytp() {
		return ((String) getAttrVal("Id_paytp"));
	}
	/**
	 * 患者收付款类型
	 * @param Id_paytp
	 */
	public void setId_paytp(String Id_paytp) {
		setAttrVal("Id_paytp", Id_paytp);
	}
	/**
	 * 合同单位id
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}
	/**
	 * 合同单位id
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 合同单位名称
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}
	/**
	 * 合同单位名称
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}
	/**
	 * 找零金额
	 * @return String
	 */
	public String getChange_amt() {
		return ((String) getAttrVal("Change_amt"));
	}
	/**
	 * 找零金额
	 * @param Change_amt
	 */
	public void setChange_amt(String Change_amt) {
		setAttrVal("Change_amt", Change_amt);
	}
	/**
	 * 原收款日期
	 * @return String
	 */
	public String getDt_pay() {
		return ((String) getAttrVal("Dt_pay"));
	}
	/**
	 * 原收款日期
	 * @param Dt_pay
	 */
	public void setDt_pay(String Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
}