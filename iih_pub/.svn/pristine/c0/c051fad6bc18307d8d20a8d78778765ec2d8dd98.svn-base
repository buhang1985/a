package iih.bl.pay.blpayspcl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.blpayspcl.d.desc.BlPaySpclDODesc;
import java.math.BigDecimal;

/**
 * 收付款_专用款 DO数据 
 * 
 */
public class BlPaySpclDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PAYSPCL= "Id_payspcl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_PTTP= "Id_pttp";
	public static final String SD_PTTP= "Sd_pttp";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String AMT= "Amt";
	public static final String DT_PAY= "Dt_pay";
	public static final String ID_ORG_PAY= "Id_org_pay";
	public static final String ID_DEP_PAY= "Id_dep_pay";
	public static final String ID_EMP_PAY= "Id_emp_pay";
	public static final String ID_CC= "Id_cc";
	public static final String FG_CC= "Fg_cc";
	public static final String CODE_REP= "Code_rep";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_payspcl() {
		return ((String) getAttrVal("Id_payspcl"));
	}	
	public void setId_payspcl(String Id_payspcl) {
		setAttrVal("Id_payspcl", Id_payspcl);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_pttp() {
		return ((String) getAttrVal("Id_pttp"));
	}	
	public void setId_pttp(String Id_pttp) {
		setAttrVal("Id_pttp", Id_pttp);
	}
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}	
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	public String getId_org_pay() {
		return ((String) getAttrVal("Id_org_pay"));
	}	
	public void setId_org_pay(String Id_org_pay) {
		setAttrVal("Id_org_pay", Id_org_pay);
	}
	public String getId_dep_pay() {
		return ((String) getAttrVal("Id_dep_pay"));
	}	
	public void setId_dep_pay(String Id_dep_pay) {
		setAttrVal("Id_dep_pay", Id_dep_pay);
	}
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}	
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	public FBoolean getFg_cc() {
		return ((FBoolean) getAttrVal("Fg_cc"));
	}	
	public void setFg_cc(FBoolean Fg_cc) {
		setAttrVal("Fg_cc", Fg_cc);
	}
	public String getCode_rep() {
		return ((String) getAttrVal("Code_rep"));
	}	
	public void setCode_rep(String Code_rep) {
		setAttrVal("Code_rep", Code_rep);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_payspcl";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_pay_spcl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPaySpclDODesc.class);
	}
	
}