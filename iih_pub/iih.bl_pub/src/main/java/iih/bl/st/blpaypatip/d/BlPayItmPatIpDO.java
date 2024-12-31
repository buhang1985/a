package iih.bl.st.blpaypatip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blpaypatip.d.desc.BlPayItmPatIpDODesc;
import java.math.BigDecimal;

/**
 * 住院患者收付款明细 DO数据 
 * 
 */
public class BlPayItmPatIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者收收付款明细主键
	public static final String ID_PAYITMPATIP= "Id_payitmpatip";
	//患者收付款主键
	public static final String ID_PAYPATIP= "Id_paypatip";
	//所属机构
	public static final String ID_ORG= "Id_org";
	//收付款方向
	public static final String EU_DIRECT= "Eu_direct";
	//实收（退）付款段标志
	public static final String FG_REALPAY= "Fg_realpay";
	//收付款方式
	public static final String ID_PM= "Id_pm";
	//收付款方式编码
	public static final String SD_PM= "Sd_pm";
	//收退款金额
	public static final String AMT= "Amt";
	//银行
	public static final String ID_BANK= "Id_bank";
	//银行卡号(外部交易号)
	public static final String BANKNO= "Bankno";
	//收款方信息
	public static final String PAYMODENODE= "Paymodenode";
	//预交金收付款
	public static final String ID_PAYPAT= "Id_paypat";
	//手工退费标识
	public static final String FG_REFUND_MANUAL= "Fg_refund_manual";
	//支付方
	public static final String ID_CUST= "Id_cust";
	//账户名称
	public static final String ACC_NAME= "Acc_name";
	//银行卡号(真实)
	public static final String BANKCARDNO= "Bankcardno";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//付款方式编码
	public static final String PM_CODE= "Pm_code";
	//付款方式名称
	public static final String PM_NAME= "Pm_name";
	//银行名称
	public static final String BANK_NAME= "Bank_name";
	//银行编码
	public static final String BANK_CODE= "Bank_code";
	//客户编码
	public static final String CODE_CUST= "Code_cust";
	//客户名称
	public static final String NAME_CUST= "Name_cust";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者收收付款明细主键
	 * @return String
	 */
	public String getId_payitmpatip() {
		return ((String) getAttrVal("Id_payitmpatip"));
	}	
	/**
	 * 患者收收付款明细主键
	 * @param Id_payitmpatip
	 */
	public void setId_payitmpatip(String Id_payitmpatip) {
		setAttrVal("Id_payitmpatip", Id_payitmpatip);
	}
	/**
	 * 患者收付款主键
	 * @return String
	 */
	public String getId_paypatip() {
		return ((String) getAttrVal("Id_paypatip"));
	}	
	/**
	 * 患者收付款主键
	 * @param Id_paypatip
	 */
	public void setId_paypatip(String Id_paypatip) {
		setAttrVal("Id_paypatip", Id_paypatip);
	}
	/**
	 * 所属机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 实收（退）付款段标志
	 * @return FBoolean
	 */
	public FBoolean getFg_realpay() {
		return ((FBoolean) getAttrVal("Fg_realpay"));
	}	
	/**
	 * 实收（退）付款段标志
	 * @param Fg_realpay
	 */
	public void setFg_realpay(FBoolean Fg_realpay) {
		setAttrVal("Fg_realpay", Fg_realpay);
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
	 * 银行卡号(外部交易号)
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	/**
	 * 银行卡号(外部交易号)
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
	 * 预交金收付款
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	/**
	 * 预交金收付款
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 手工退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_refund_manual() {
		return ((FBoolean) getAttrVal("Fg_refund_manual"));
	}	
	/**
	 * 手工退费标识
	 * @param Fg_refund_manual
	 */
	public void setFg_refund_manual(FBoolean Fg_refund_manual) {
		setAttrVal("Fg_refund_manual", Fg_refund_manual);
	}
	/**
	 * 支付方
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}	
	/**
	 * 支付方
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 账户名称
	 * @return String
	 */
	public String getAcc_name() {
		return ((String) getAttrVal("Acc_name"));
	}	
	/**
	 * 账户名称
	 * @param Acc_name
	 */
	public void setAcc_name(String Acc_name) {
		setAttrVal("Acc_name", Acc_name);
	}
	/**
	 * 银行卡号(真实)
	 * @return String
	 */
	public String getBankcardno() {
		return ((String) getAttrVal("Bankcardno"));
	}	
	/**
	 * 银行卡号(真实)
	 * @param Bankcardno
	 */
	public void setBankcardno(String Bankcardno) {
		setAttrVal("Bankcardno", Bankcardno);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 付款方式编码
	 * @return String
	 */
	public String getPm_code() {
		return ((String) getAttrVal("Pm_code"));
	}	
	/**
	 * 付款方式编码
	 * @param Pm_code
	 */
	public void setPm_code(String Pm_code) {
		setAttrVal("Pm_code", Pm_code);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getPm_name() {
		return ((String) getAttrVal("Pm_name"));
	}	
	/**
	 * 付款方式名称
	 * @param Pm_name
	 */
	public void setPm_name(String Pm_name) {
		setAttrVal("Pm_name", Pm_name);
	}
	/**
	 * 银行名称
	 * @return String
	 */
	public String getBank_name() {
		return ((String) getAttrVal("Bank_name"));
	}	
	/**
	 * 银行名称
	 * @param Bank_name
	 */
	public void setBank_name(String Bank_name) {
		setAttrVal("Bank_name", Bank_name);
	}
	/**
	 * 银行编码
	 * @return String
	 */
	public String getBank_code() {
		return ((String) getAttrVal("Bank_code"));
	}	
	/**
	 * 银行编码
	 * @param Bank_code
	 */
	public void setBank_code(String Bank_code) {
		setAttrVal("Bank_code", Bank_code);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode_cust() {
		return ((String) getAttrVal("Code_cust"));
	}	
	/**
	 * 客户编码
	 * @param Code_cust
	 */
	public void setCode_cust(String Code_cust) {
		setAttrVal("Code_cust", Code_cust);
	}
	/**
	 * 客户名称
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}	
	/**
	 * 客户名称
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_payitmpatip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_pay_itm_pat_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPayItmPatIpDODesc.class);
	}
	
}