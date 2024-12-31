package iih.bl.pay.prepaypatrcpt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.prepaypatrcpt.d.desc.BlPrepayPatRcptDODesc;
import java.math.BigDecimal;

/**
 * 预交金票据记录 DO数据 
 * 
 */
public class BlPrepayPatRcptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PAYPAT_RCPT= "Id_paypat_rcpt";
	public static final String ID_PAYPAT= "Id_paypat";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String CODE_INCPKG= "Code_incpkg";
	public static final String ID_INCCA= "Id_incca";
	public static final String CODE_REP= "Code_rep";
	public static final String DT_RECEIPT= "Dt_receipt";
	public static final String ID_EMP_RCPT= "Id_emp_rcpt";
	public static final String ID_EMP_GRP= "Id_emp_grp";
	public static final String ID_EMP_ORG= "Id_emp_org";
	public static final String PRINT_TIMES= "Print_times";
	public static final String FG_REP_RETURN= "Fg_rep_return";
	public static final String ID_REP_LOST= "Id_rep_lost";
	public static final String SD_REP_LOST= "Sd_rep_lost";
	public static final String DT_RETURN= "Dt_return";
	public static final String ID_EMP_RETURN= "Id_emp_return";
	public static final String FG_CC_RCPT= "Fg_cc_rcpt";
	public static final String ID_CC= "Id_cc";
	public static final String NOTE= "Note";
	public static final String ID_RES_REPRINT= "Id_res_reprint";
	public static final String SD_RES_REPRINT= "Sd_res_reprint";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_paypat_rcpt() {
		return ((String) getAttrVal("Id_paypat_rcpt"));
	}	
	public void setId_paypat_rcpt(String Id_paypat_rcpt) {
		setAttrVal("Id_paypat_rcpt", Id_paypat_rcpt);
	}
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getCode_incpkg() {
		return ((String) getAttrVal("Code_incpkg"));
	}	
	public void setCode_incpkg(String Code_incpkg) {
		setAttrVal("Code_incpkg", Code_incpkg);
	}
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	public String getCode_rep() {
		return ((String) getAttrVal("Code_rep"));
	}	
	public void setCode_rep(String Code_rep) {
		setAttrVal("Code_rep", Code_rep);
	}
	public FDateTime getDt_receipt() {
		return ((FDateTime) getAttrVal("Dt_receipt"));
	}	
	public void setDt_receipt(FDateTime Dt_receipt) {
		setAttrVal("Dt_receipt", Dt_receipt);
	}
	public String getId_emp_rcpt() {
		return ((String) getAttrVal("Id_emp_rcpt"));
	}	
	public void setId_emp_rcpt(String Id_emp_rcpt) {
		setAttrVal("Id_emp_rcpt", Id_emp_rcpt);
	}
	public String getId_emp_grp() {
		return ((String) getAttrVal("Id_emp_grp"));
	}	
	public void setId_emp_grp(String Id_emp_grp) {
		setAttrVal("Id_emp_grp", Id_emp_grp);
	}
	public String getId_emp_org() {
		return ((String) getAttrVal("Id_emp_org"));
	}	
	public void setId_emp_org(String Id_emp_org) {
		setAttrVal("Id_emp_org", Id_emp_org);
	}
	public Integer getPrint_times() {
		return ((Integer) getAttrVal("Print_times"));
	}	
	public void setPrint_times(Integer Print_times) {
		setAttrVal("Print_times", Print_times);
	}
	public FBoolean getFg_rep_return() {
		return ((FBoolean) getAttrVal("Fg_rep_return"));
	}	
	public void setFg_rep_return(FBoolean Fg_rep_return) {
		setAttrVal("Fg_rep_return", Fg_rep_return);
	}
	public String getId_rep_lost() {
		return ((String) getAttrVal("Id_rep_lost"));
	}	
	public void setId_rep_lost(String Id_rep_lost) {
		setAttrVal("Id_rep_lost", Id_rep_lost);
	}
	public String getSd_rep_lost() {
		return ((String) getAttrVal("Sd_rep_lost"));
	}	
	public void setSd_rep_lost(String Sd_rep_lost) {
		setAttrVal("Sd_rep_lost", Sd_rep_lost);
	}
	public FDateTime getDt_return() {
		return ((FDateTime) getAttrVal("Dt_return"));
	}	
	public void setDt_return(FDateTime Dt_return) {
		setAttrVal("Dt_return", Dt_return);
	}
	public String getId_emp_return() {
		return ((String) getAttrVal("Id_emp_return"));
	}	
	public void setId_emp_return(String Id_emp_return) {
		setAttrVal("Id_emp_return", Id_emp_return);
	}
	public FBoolean getFg_cc_rcpt() {
		return ((FBoolean) getAttrVal("Fg_cc_rcpt"));
	}	
	public void setFg_cc_rcpt(FBoolean Fg_cc_rcpt) {
		setAttrVal("Fg_cc_rcpt", Fg_cc_rcpt);
	}
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public String getId_res_reprint() {
		return ((String) getAttrVal("Id_res_reprint"));
	}	
	public void setId_res_reprint(String Id_res_reprint) {
		setAttrVal("Id_res_reprint", Id_res_reprint);
	}
	public String getSd_res_reprint() {
		return ((String) getAttrVal("Sd_res_reprint"));
	}	
	public void setSd_res_reprint(String Sd_res_reprint) {
		setAttrVal("Sd_res_reprint", Sd_res_reprint);
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
		return "Id_paypat_rcpt";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prepay_pat_rcpt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrepayPatRcptDODesc.class);
	}
	
}