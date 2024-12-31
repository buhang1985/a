package iih.bl.cg.blcgoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import java.math.BigDecimal;

/**
 * 门急诊记账 DO数据 
 * 
 */
public class BlCgOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CGOEP= "Id_cgoep";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_CG= "Code_cg";
	public static final String ID_PAT= "Id_pat";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String DT_CG= "Dt_cg";
	public static final String ID_ORG_CG= "Id_org_cg";
	public static final String ID_DEP_CG= "Id_dep_cg";
	public static final String ID_EMP_CG= "Id_emp_cg";
	public static final String ENT_INVOICENO= "Ent_invoiceno";
	public static final String HAS_SAVEINDB= "Has_saveindb";
	public static final String ST_FIRST_INCNO= "St_first_incno";
	public static final String ENT_INVOICE_EMPNAME= "Ent_invoice_empname";
	public static final String STOEP_INVOICENO= "Stoep_invoiceno";
	public static final String STOEP_INVOICENAME= "Stoep_invoicename";
	public static final String ORSRVIDS= "Orsrvids";
	public static final String ENT_INVOICE_PKGCODE= "Ent_invoice_pkgcode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ORGCODE= "Orgcode";
	public static final String ORGNAME= "Orgname";
	public static final String PAT_CODE= "Pat_code";
	public static final String PAT_NAME= "Pat_name";
	public static final String CG_ORG_CODE= "Cg_org_code";
	public static final String CG_ORG_NAME= "Cg_org_name";
	public static final String CG_DEP_CODE= "Cg_dep_code";
	public static final String CG_DEP_NAME= "Cg_dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cgoep() {
		return ((String) getAttrVal("Id_cgoep"));
	}	
	public void setId_cgoep(String Id_cgoep) {
		setAttrVal("Id_cgoep", Id_cgoep);
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
	public String getCode_cg() {
		return ((String) getAttrVal("Code_cg"));
	}	
	public void setCode_cg(String Code_cg) {
		setAttrVal("Code_cg", Code_cg);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}	
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	public String getId_org_cg() {
		return ((String) getAttrVal("Id_org_cg"));
	}	
	public void setId_org_cg(String Id_org_cg) {
		setAttrVal("Id_org_cg", Id_org_cg);
	}
	public String getId_dep_cg() {
		return ((String) getAttrVal("Id_dep_cg"));
	}	
	public void setId_dep_cg(String Id_dep_cg) {
		setAttrVal("Id_dep_cg", Id_dep_cg);
	}
	public String getId_emp_cg() {
		return ((String) getAttrVal("Id_emp_cg"));
	}	
	public void setId_emp_cg(String Id_emp_cg) {
		setAttrVal("Id_emp_cg", Id_emp_cg);
	}
	public String getEnt_invoiceno() {
		return ((String) getAttrVal("Ent_invoiceno"));
	}	
	public void setEnt_invoiceno(String Ent_invoiceno) {
		setAttrVal("Ent_invoiceno", Ent_invoiceno);
	}
	public FBoolean getHas_saveindb() {
		return ((FBoolean) getAttrVal("Has_saveindb"));
	}	
	public void setHas_saveindb(FBoolean Has_saveindb) {
		setAttrVal("Has_saveindb", Has_saveindb);
	}
	public String getSt_first_incno() {
		return ((String) getAttrVal("St_first_incno"));
	}	
	public void setSt_first_incno(String St_first_incno) {
		setAttrVal("St_first_incno", St_first_incno);
	}
	public String getEnt_invoice_empname() {
		return ((String) getAttrVal("Ent_invoice_empname"));
	}	
	public void setEnt_invoice_empname(String Ent_invoice_empname) {
		setAttrVal("Ent_invoice_empname", Ent_invoice_empname);
	}
	public String getStoep_invoiceno() {
		return ((String) getAttrVal("Stoep_invoiceno"));
	}	
	public void setStoep_invoiceno(String Stoep_invoiceno) {
		setAttrVal("Stoep_invoiceno", Stoep_invoiceno);
	}
	public String getStoep_invoicename() {
		return ((String) getAttrVal("Stoep_invoicename"));
	}	
	public void setStoep_invoicename(String Stoep_invoicename) {
		setAttrVal("Stoep_invoicename", Stoep_invoicename);
	}
	public String getOrsrvids() {
		return ((String) getAttrVal("Orsrvids"));
	}	
	public void setOrsrvids(String Orsrvids) {
		setAttrVal("Orsrvids", Orsrvids);
	}
	public String getEnt_invoice_pkgcode() {
		return ((String) getAttrVal("Ent_invoice_pkgcode"));
	}	
	public void setEnt_invoice_pkgcode(String Ent_invoice_pkgcode) {
		setAttrVal("Ent_invoice_pkgcode", Ent_invoice_pkgcode);
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
	public String getOrgcode() {
		return ((String) getAttrVal("Orgcode"));
	}	
	public void setOrgcode(String Orgcode) {
		setAttrVal("Orgcode", Orgcode);
	}
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	public String getCg_org_code() {
		return ((String) getAttrVal("Cg_org_code"));
	}	
	public void setCg_org_code(String Cg_org_code) {
		setAttrVal("Cg_org_code", Cg_org_code);
	}
	public String getCg_org_name() {
		return ((String) getAttrVal("Cg_org_name"));
	}	
	public void setCg_org_name(String Cg_org_name) {
		setAttrVal("Cg_org_name", Cg_org_name);
	}
	public String getCg_dep_code() {
		return ((String) getAttrVal("Cg_dep_code"));
	}	
	public void setCg_dep_code(String Cg_dep_code) {
		setAttrVal("Cg_dep_code", Cg_dep_code);
	}
	public String getCg_dep_name() {
		return ((String) getAttrVal("Cg_dep_name"));
	}	
	public void setCg_dep_name(String Cg_dep_name) {
		setAttrVal("Cg_dep_name", Cg_dep_name);
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
		return "Id_cgoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cg_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCgOepDODesc.class);
	}
	
}