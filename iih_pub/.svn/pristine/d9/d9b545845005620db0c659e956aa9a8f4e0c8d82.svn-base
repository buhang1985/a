package iih.bl.inc.blincip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blincip.d.desc.BlIncItmIpDODesc;
import java.math.BigDecimal;

/**
 * 住院发票明细 DO数据 
 * 
 */
public class BlIncItmIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INCITMIP= "Id_incitmip";
	public static final String ID_INCIP= "Id_incip";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String AMT= "Amt";
	public static final String AMT_PAT= "Amt_pat";
	public static final String AMT_FREE= "Amt_free";
	public static final String AMT_STD= "Amt_std";
	public static final String AMT_RATIO= "Amt_ratio";
	public static final String AMT_HP= "Amt_hp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_incitmip() {
		return ((String) getAttrVal("Id_incitmip"));
	}	
	public void setId_incitmip(String Id_incitmip) {
		setAttrVal("Id_incitmip", Id_incitmip);
	}
	public String getId_incip() {
		return ((String) getAttrVal("Id_incip"));
	}	
	public void setId_incip(String Id_incip) {
		setAttrVal("Id_incip", Id_incip);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDouble getAmt_pat() {
		return ((FDouble) getAttrVal("Amt_pat"));
	}	
	public void setAmt_pat(FDouble Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
	public FDouble getAmt_free() {
		return ((FDouble) getAttrVal("Amt_free"));
	}	
	public void setAmt_free(FDouble Amt_free) {
		setAttrVal("Amt_free", Amt_free);
	}
	public FDouble getAmt_std() {
		return ((FDouble) getAttrVal("Amt_std"));
	}	
	public void setAmt_std(FDouble Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}	
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
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
		return "Id_incitmip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_itm_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncItmIpDODesc.class);
	}
	
}