package iih.bl.st.blpaypatiplog.d;

import iih.bl.st.blpaypatiplog.d.desc.BlPayItmPatIpLogDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 住院患者收付款明细日志 DO数据 
 * 
 */
public class BlPayItmPatIpLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者收收付款明细日志主键
	public static final String ID_PAYITMPATIPLOG= "Id_payitmpatiplog";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//患者收付款主键
	public static final String ID_PAYPATIP= "Id_paypatip";
	//患者收付款子表主键
	public static final String ID_PAYITMPATIP= "Id_payitmpatip";
	//预交金收付款主键
	public static final String ID_PAYPAT= "Id_paypat";
	//结转预交金id
	public static final String ID_PAYPAT_MERGE= "Id_paypat_merge";
	//收付款方式id
	public static final String ID_PM= "Id_pm";
	//收付款方式编码
	public static final String SD_PM= "Sd_pm";
	//方向
	public static final String EU_DIRECT= "Eu_direct";
	//收退款金额
	public static final String AMT= "Amt";
	//银行
	public static final String ID_BANK= "Id_bank";
	//银行卡号
	public static final String BANKNO= "Bankno";
	//收款方信息
	public static final String PAYMODENODE= "Paymodenode";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_GRP= "Code_grp";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//付款方式名称
	public static final String NAME_PM= "Name_pm";
	//付款方式编码
	public static final String CODE_PM= "Code_pm";
	//银行编码
	public static final String CODE_BANK= "Code_bank";
	//银行名称
	public static final String NAME_BANK= "Name_bank";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者收收付款明细日志主键
	 * @return String
	 */
	public String getId_payitmpatiplog() {
		return ((String) getAttrVal("Id_payitmpatiplog"));
	}	
	/**
	 * 患者收收付款明细日志主键
	 * @param Id_payitmpatiplog
	 */
	public void setId_payitmpatiplog(String Id_payitmpatiplog) {
		setAttrVal("Id_payitmpatiplog", Id_payitmpatiplog);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	 * 患者收付款子表主键
	 * @return String
	 */
	public String getId_payitmpatip() {
		return ((String) getAttrVal("Id_payitmpatip"));
	}	
	/**
	 * 患者收付款子表主键
	 * @param Id_payitmpatip
	 */
	public void setId_payitmpatip(String Id_payitmpatip) {
		setAttrVal("Id_payitmpatip", Id_payitmpatip);
	}
	/**
	 * 预交金收付款主键
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	/**
	 * 预交金收付款主键
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 结转预交金id
	 * @return String
	 */
	public String getId_paypat_merge() {
		return ((String) getAttrVal("Id_paypat_merge"));
	}	
	/**
	 * 结转预交金id
	 * @param Id_paypat_merge
	 */
	public void setId_paypat_merge(String Id_paypat_merge) {
		setAttrVal("Id_paypat_merge", Id_paypat_merge);
	}
	/**
	 * 收付款方式id
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 收付款方式id
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
	 * 方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
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
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}	
	/**
	 * 付款方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 付款方式编码
	 * @return String
	 */
	public String getCode_pm() {
		return ((String) getAttrVal("Code_pm"));
	}	
	/**
	 * 付款方式编码
	 * @param Code_pm
	 */
	public void setCode_pm(String Code_pm) {
		setAttrVal("Code_pm", Code_pm);
	}
	/**
	 * 银行编码
	 * @return String
	 */
	public String getCode_bank() {
		return ((String) getAttrVal("Code_bank"));
	}	
	/**
	 * 银行编码
	 * @param Code_bank
	 */
	public void setCode_bank(String Code_bank) {
		setAttrVal("Code_bank", Code_bank);
	}
	/**
	 * 银行名称
	 * @return String
	 */
	public String getName_bank() {
		return ((String) getAttrVal("Name_bank"));
	}	
	/**
	 * 银行名称
	 * @param Name_bank
	 */
	public void setName_bank(String Name_bank) {
		setAttrVal("Name_bank", Name_bank);
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
		return "Id_payitmpatiplog";
	}
	
	@Override
	public String getTableName() {	  
		return "BL_PAY_ITM_IP_LOG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPayItmPatIpLogDODesc.class);
	}
	
}