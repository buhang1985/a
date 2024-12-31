package iih.bl.pay.blprepaypatacc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.blprepaypatacc.d.desc.BlPrepayPatAccDODesc;
import java.math.BigDecimal;

/**
 * 预交金账目流水 DO数据 
 * 
 */
public class BlPrepayPatAccDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//预交金流水id
	public static final String ID_PAYPAT_ACC= "Id_paypat_acc";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//预交金id
	public static final String ID_PAYPAT= "Id_paypat";
	//当前预交金账户总金额
	public static final String AMT_ACC= "Amt_acc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 预交金流水id
	 * @return String
	 */
	public String getId_paypat_acc() {
		return ((String) getAttrVal("Id_paypat_acc"));
	}	
	/**
	 * 预交金流水id
	 * @param Id_paypat_acc
	 */
	public void setId_paypat_acc(String Id_paypat_acc) {
		setAttrVal("Id_paypat_acc", Id_paypat_acc);
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
	 * 预交金id
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	/**
	 * 预交金id
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 当前预交金账户总金额
	 * @return FDouble
	 */
	public FDouble getAmt_acc() {
		return ((FDouble) getAttrVal("Amt_acc"));
	}	
	/**
	 * 当前预交金账户总金额
	 * @param Amt_acc
	 */
	public void setAmt_acc(FDouble Amt_acc) {
		setAttrVal("Amt_acc", Amt_acc);
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
		return "Id_paypat_acc";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prepay_pat_acc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrepayPatAccDODesc.class);
	}
	
}