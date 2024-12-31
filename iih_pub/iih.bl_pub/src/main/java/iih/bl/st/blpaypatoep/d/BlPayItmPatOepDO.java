package iih.bl.st.blpaypatoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blpaypatoep.d.desc.BlPayItmPatOepDODesc;
import java.math.BigDecimal;

/**
 * 门急诊患者收付款明细 DO数据 
 * 
 */
public class BlPayItmPatOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者收付歀明细主键
	public static final String ID_PAYITMPATOEP= "Id_payitmpatoep";
	//患者收付款主键
	public static final String ID_PAYPATOEP= "Id_paypatoep";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//收付款方向
	public static final String EU_DIRECT= "Eu_direct";
	//实收（退）付款段标志
	public static final String FG_REALPAY= "Fg_realpay";
	//支付方
	public static final String ID_CUST= "Id_cust";
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
	//收付款方式名称
	public static final String NAME_PM= "Name_pm";
	//预交金收付款
	public static final String ID_PAYPAT= "Id_paypat";
	//手工标识
	public static final String FG_MANUAL= "Fg_manual";
	//账户名称
	public static final String ACC_NAME= "Acc_name";
	//银行卡号(真实)
	public static final String BANKCARDNO= "Bankcardno";
	//客户名称
	public static final String CUST_NAME= "Cust_name";
	//付款方式编码
	public static final String PM_CODE= "Pm_code";
	//付款方式名称
	public static final String PM_NAME= "Pm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 收付款方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}	
	/**
	 * 收付款方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
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
	 * 手工标识
	 * @return FBoolean
	 */
	public FBoolean getFg_manual() {
		return ((FBoolean) getAttrVal("Fg_manual"));
	}	
	/**
	 * 手工标识
	 * @param Fg_manual
	 */
	public void setFg_manual(FBoolean Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
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
	 * 客户名称
	 * @return String
	 */
	public String getCust_name() {
		return ((String) getAttrVal("Cust_name"));
	}	
	/**
	 * 客户名称
	 * @param Cust_name
	 */
	public void setCust_name(String Cust_name) {
		setAttrVal("Cust_name", Cust_name);
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
		return "Id_payitmpatoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_pay_itm_pat_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPayItmPatOepDODesc.class);
	}
	
}