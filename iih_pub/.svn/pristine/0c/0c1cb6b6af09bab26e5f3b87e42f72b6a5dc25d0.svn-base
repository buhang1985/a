package iih.bl.pay.blprepaypatpmamtoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.blprepaypatpmamtoep.d.desc.BlPrepayPatPmamtOepDODesc;
import java.math.BigDecimal;

/**
 * 预交金_患者_收支总金额 DO数据 
 * 
 */
public class BlPrepayPatPmamtOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PREPAYPATPMAMT= "Id_prepaypatpmamt";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_PM= "Id_pm";
	public static final String SD_PM= "Sd_pm";
	public static final String AMT_IN= "Amt_in";
	public static final String AMT_OUT= "Amt_out";
	public static final String CODE_ORG= "Code_org";
	public static final String NAME_ORG= "Name_org";
	public static final String CODE_GRP= "Code_grp";
	public static final String NAME_GRP= "Name_grp";
	public static final String CODE_PAT= "Code_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_PM= "Name_pm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prepaypatpmamt() {
		return ((String) getAttrVal("Id_prepaypatpmamt"));
	}	
	public void setId_prepaypatpmamt(String Id_prepaypatpmamt) {
		setAttrVal("Id_prepaypatpmamt", Id_prepaypatpmamt);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}	
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	public FDouble getAmt_in() {
		return ((FDouble) getAttrVal("Amt_in"));
	}	
	public void setAmt_in(FDouble Amt_in) {
		setAttrVal("Amt_in", Amt_in);
	}
	public FDouble getAmt_out() {
		return ((FDouble) getAttrVal("Amt_out"));
	}	
	public void setAmt_out(FDouble Amt_out) {
		setAttrVal("Amt_out", Amt_out);
	}
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}	
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
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
		return "Id_prepaypatpmamt";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prepay_pat_pmamt_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrepayPatPmamtOepDODesc.class);
	}
	
}