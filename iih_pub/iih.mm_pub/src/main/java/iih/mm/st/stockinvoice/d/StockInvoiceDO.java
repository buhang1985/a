package iih.mm.st.stockinvoice.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.stockinvoice.d.desc.StockInvoiceDODesc;
import java.math.BigDecimal;

/**
 * 采购发票 DO数据 
 * 
 */
public class StockInvoiceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INV= "Id_inv";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String RED_BLUE= "Red_blue";
	public static final String ID_MMSTCA= "Id_mmstca";
	public static final String INV_CODE= "Inv_code";
	public static final String ORIG_CODE= "Orig_code";
	public static final String DT_ORIG= "Dt_orig";
	public static final String ID_EMP_PO= "Id_emp_po";
	public static final String ID_DEP= "Id_dep";
	public static final String INV_DES= "Inv_des";
	public static final String ID_SUP= "Id_sup";
	public static final String ID_WH= "Id_wh";
	public static final String ID_INV_ST= "Id_inv_st";
	public static final String SD_INV_ST= "Sd_inv_st";
	public static final String FG_BANL= "Fg_banl";
	public static final String AMT= "Amt";
	public static final String DT_ST= "Dt_st";
	public static final String DT_ST_SHORT= "Dt_st_short";
	public static final String YEAR_MONTH= "Year_month";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String ID_EMP_CONF= "Id_emp_conf";
	public static final String DT_CONF= "Dt_conf";
	public static final String ID_EMP_CHECK= "Id_emp_check";
	public static final String DT_CHECK= "Dt_check";
	public static final String APCOMMENTS= "Apcomments";
	public static final String IDINLIST= "Idinlist";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String STCA_NAME= "Stca_name";
	public static final String EMPPO_NAME= "Emppo_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String SUP_NAME= "Sup_name";
	public static final String WH_NAME= "Wh_name";
	public static final String INVST_NAME= "Invst_name";
	public static final String EMPST_NAME= "Empst_name";
	public static final String EMPCONF_NAME= "Empconf_name";
	public static final String EMPCHECK_NAME= "Empcheck_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_inv() {
		return ((String) getAttrVal("Id_inv"));
	}	
	public void setId_inv(String Id_inv) {
		setAttrVal("Id_inv", Id_inv);
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
	public FBoolean getRed_blue() {
		return ((FBoolean) getAttrVal("Red_blue"));
	}	
	public void setRed_blue(FBoolean Red_blue) {
		setAttrVal("Red_blue", Red_blue);
	}
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
	}
	public String getInv_code() {
		return ((String) getAttrVal("Inv_code"));
	}	
	public void setInv_code(String Inv_code) {
		setAttrVal("Inv_code", Inv_code);
	}
	public String getOrig_code() {
		return ((String) getAttrVal("Orig_code"));
	}	
	public void setOrig_code(String Orig_code) {
		setAttrVal("Orig_code", Orig_code);
	}
	public FDate getDt_orig() {
		return ((FDate) getAttrVal("Dt_orig"));
	}	
	public void setDt_orig(FDate Dt_orig) {
		setAttrVal("Dt_orig", Dt_orig);
	}
	public String getId_emp_po() {
		return ((String) getAttrVal("Id_emp_po"));
	}	
	public void setId_emp_po(String Id_emp_po) {
		setAttrVal("Id_emp_po", Id_emp_po);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getInv_des() {
		return ((String) getAttrVal("Inv_des"));
	}	
	public void setInv_des(String Inv_des) {
		setAttrVal("Inv_des", Inv_des);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getId_inv_st() {
		return ((String) getAttrVal("Id_inv_st"));
	}	
	public void setId_inv_st(String Id_inv_st) {
		setAttrVal("Id_inv_st", Id_inv_st);
	}
	public String getSd_inv_st() {
		return ((String) getAttrVal("Sd_inv_st"));
	}	
	public void setSd_inv_st(String Sd_inv_st) {
		setAttrVal("Sd_inv_st", Sd_inv_st);
	}
	public FBoolean getFg_banl() {
		return ((FBoolean) getAttrVal("Fg_banl"));
	}	
	public void setFg_banl(FBoolean Fg_banl) {
		setAttrVal("Fg_banl", Fg_banl);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	public FDate getDt_st_short() {
		return ((FDate) getAttrVal("Dt_st_short"));
	}	
	public void setDt_st_short(FDate Dt_st_short) {
		setAttrVal("Dt_st_short", Dt_st_short);
	}
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	public String getApcomments() {
		return ((String) getAttrVal("Apcomments"));
	}	
	public void setApcomments(String Apcomments) {
		setAttrVal("Apcomments", Apcomments);
	}
	public String getIdinlist() {
		return ((String) getAttrVal("Idinlist"));
	}	
	public void setIdinlist(String Idinlist) {
		setAttrVal("Idinlist", Idinlist);
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
	public String getStca_name() {
		return ((String) getAttrVal("Stca_name"));
	}	
	public void setStca_name(String Stca_name) {
		setAttrVal("Stca_name", Stca_name);
	}
	public String getEmppo_name() {
		return ((String) getAttrVal("Emppo_name"));
	}	
	public void setEmppo_name(String Emppo_name) {
		setAttrVal("Emppo_name", Emppo_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getInvst_name() {
		return ((String) getAttrVal("Invst_name"));
	}	
	public void setInvst_name(String Invst_name) {
		setAttrVal("Invst_name", Invst_name);
	}
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
	}
	public String getEmpconf_name() {
		return ((String) getAttrVal("Empconf_name"));
	}	
	public void setEmpconf_name(String Empconf_name) {
		setAttrVal("Empconf_name", Empconf_name);
	}
	public String getEmpcheck_name() {
		return ((String) getAttrVal("Empcheck_name"));
	}	
	public void setEmpcheck_name(String Empcheck_name) {
		setAttrVal("Empcheck_name", Empcheck_name);
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
		return "Id_inv";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_INV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StockInvoiceDODesc.class);
	}
	
}