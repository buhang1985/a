package iih.bl.cc.blcc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cc.blcc.d.desc.BlCcPmDODesc;
import java.math.BigDecimal;

/**
 * 结账_付款方式信息 DO数据 
 * 
 */
public class BlCcPmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结账付款方式主键
	public static final String ID_CCPM= "Id_ccpm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//结账
	public static final String ID_CC= "Id_cc";
	//付款方式
	public static final String ID_PM= "Id_pm";
	//收款总金额
	public static final String AMT= "Amt";
	//收款交易笔数
	public static final String CN_AMT= "Cn_amt";
	//退款总金额
	public static final String AMT_RETURN= "Amt_return";
	//退款交易笔数
	public static final String CN_AMTRETURN= "Cn_amtreturn";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结账付款方式主键
	 * @return String
	 */
	public String getId_ccpm() {
		return ((String) getAttrVal("Id_ccpm"));
	}	
	/**
	 * 结账付款方式主键
	 * @param Id_ccpm
	 */
	public void setId_ccpm(String Id_ccpm) {
		setAttrVal("Id_ccpm", Id_ccpm);
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
	 * 结账
	 * @return String
	 */
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	/**
	 * 结账
	 * @param Id_cc
	 */
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 收款总金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 收款总金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 收款交易笔数
	 * @return Integer
	 */
	public Integer getCn_amt() {
		return ((Integer) getAttrVal("Cn_amt"));
	}	
	/**
	 * 收款交易笔数
	 * @param Cn_amt
	 */
	public void setCn_amt(Integer Cn_amt) {
		setAttrVal("Cn_amt", Cn_amt);
	}
	/**
	 * 退款总金额
	 * @return FDouble
	 */
	public FDouble getAmt_return() {
		return ((FDouble) getAttrVal("Amt_return"));
	}	
	/**
	 * 退款总金额
	 * @param Amt_return
	 */
	public void setAmt_return(FDouble Amt_return) {
		setAttrVal("Amt_return", Amt_return);
	}
	/**
	 * 退款交易笔数
	 * @return Integer
	 */
	public Integer getCn_amtreturn() {
		return ((Integer) getAttrVal("Cn_amtreturn"));
	}	
	/**
	 * 退款交易笔数
	 * @param Cn_amtreturn
	 */
	public void setCn_amtreturn(Integer Cn_amtreturn) {
		setAttrVal("Cn_amtreturn", Cn_amtreturn);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_ccpm";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cc_pm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCcPmDODesc.class);
	}
	
}