package iih.mm.st.settlement.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.settlement.d.desc.SettlementDODesc;
import java.math.BigDecimal;

/**
 * 采购结算 DO数据 
 * 
 */
public class SettlementDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BANL= "Id_banl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_INV= "Id_inv";
	public static final String CODE= "Code";
	public static final String ID_WH= "Id_wh";
	public static final String YEAR_MONTH= "Year_month";
	public static final String DT_ST= "Dt_st";
	public static final String DT_ST_SHORT= "Dt_st_short";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String ID_EMP_PO= "Id_emp_po";
	public static final String ID_DEP= "Id_dep";
	public static final String DES= "Des";
	public static final String ID_MMSTCA= "Id_mmstca";
	public static final String ID_SUP= "Id_sup";
	public static final String AMT= "Amt";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WH_CODE= "Wh_code";
	public static final String WH_NAME= "Wh_name";
	public static final String ST_EMP_NAME= "St_emp_name";
	public static final String ST_EMP_CODE= "St_emp_code";
	public static final String PO_EMP_CODE= "Po_emp_code";
	public static final String PO_EMP_NAME= "Po_emp_name";
	public static final String DEP_CODE= "Dep_code";
	public static final String DEP_NAME= "Dep_name";
	public static final String MMSTCA_CODE= "Mmstca_code";
	public static final String MMSTCA_NAME= "Mmstca_name";
	public static final String SUP_CODE= "Sup_code";
	public static final String SUP_NAME= "Sup_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_banl() {
		return ((String) getAttrVal("Id_banl"));
	}	
	public void setId_banl(String Id_banl) {
		setAttrVal("Id_banl", Id_banl);
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
	public String getId_inv() {
		return ((String) getAttrVal("Id_inv"));
	}	
	public void setId_inv(String Id_inv) {
		setAttrVal("Id_inv", Id_inv);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
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
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_mmstca() {
		return ((String) getAttrVal("Id_mmstca"));
	}	
	public void setId_mmstca(String Id_mmstca) {
		setAttrVal("Id_mmstca", Id_mmstca);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
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
	public String getWh_code() {
		return ((String) getAttrVal("Wh_code"));
	}	
	public void setWh_code(String Wh_code) {
		setAttrVal("Wh_code", Wh_code);
	}
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getSt_emp_name() {
		return ((String) getAttrVal("St_emp_name"));
	}	
	public void setSt_emp_name(String St_emp_name) {
		setAttrVal("St_emp_name", St_emp_name);
	}
	public String getSt_emp_code() {
		return ((String) getAttrVal("St_emp_code"));
	}	
	public void setSt_emp_code(String St_emp_code) {
		setAttrVal("St_emp_code", St_emp_code);
	}
	public String getPo_emp_code() {
		return ((String) getAttrVal("Po_emp_code"));
	}	
	public void setPo_emp_code(String Po_emp_code) {
		setAttrVal("Po_emp_code", Po_emp_code);
	}
	public String getPo_emp_name() {
		return ((String) getAttrVal("Po_emp_name"));
	}	
	public void setPo_emp_name(String Po_emp_name) {
		setAttrVal("Po_emp_name", Po_emp_name);
	}
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getMmstca_code() {
		return ((String) getAttrVal("Mmstca_code"));
	}	
	public void setMmstca_code(String Mmstca_code) {
		setAttrVal("Mmstca_code", Mmstca_code);
	}
	public String getMmstca_name() {
		return ((String) getAttrVal("Mmstca_name"));
	}	
	public void setMmstca_name(String Mmstca_name) {
		setAttrVal("Mmstca_name", Mmstca_name);
	}
	public String getSup_code() {
		return ((String) getAttrVal("Sup_code"));
	}	
	public void setSup_code(String Sup_code) {
		setAttrVal("Sup_code", Sup_code);
	}
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
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
		return "Id_banl";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_BANL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SettlementDODesc.class);
	}
	
}