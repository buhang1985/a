package iih.bl.cc.blccdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊患者结算收付款明细 DTO数据 
 * 
 */
public class BlPayItmPatOepDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者收付歀明细主键
	 * @return String
	 */
	public String getId_payitmpatoep() {
		return ((String) getAttrVal("Id_payitmpatoep"));
	}
	/**
	 * 患者收付歀明细主键
	 * @param Id_payitmpatoep
	 */
	public void setId_payitmpatoep(String Id_payitmpatoep) {
		setAttrVal("Id_payitmpatoep", Id_payitmpatoep);
	}
	/**
	 * 患者收付款主键
	 * @return String
	 */
	public String getId_paypatoep() {
		return ((String) getAttrVal("Id_paypatoep"));
	}
	/**
	 * 患者收付款主键
	 * @param Id_paypatoep
	 */
	public void setId_paypatoep(String Id_paypatoep) {
		setAttrVal("Id_paypatoep", Id_paypatoep);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 银行卡号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
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
	 * 收付款方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 收付款方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
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
	 * 找零
	 * @return String
	 */
	public String getChange() {
		return ((String) getAttrVal("Change"));
	}
	/**
	 * 找零
	 * @param Change
	 */
	public void setChange(String Change) {
		setAttrVal("Change", Change);
	}
	/**
	 * 支付方式名称
	 * @return String
	 */
	public String getPm_name() {
		return ((String) getAttrVal("Pm_name"));
	}
	/**
	 * 支付方式名称
	 * @param Pm_name
	 */
	public void setPm_name(String Pm_name) {
		setAttrVal("Pm_name", Pm_name);
	}
}