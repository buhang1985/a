package iih.pe.pitm.perstillness.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病定义 DO数据 
 * 
 */
public class PeRstIllnessDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERSTILLNESS= "Id_perstillness";
	public static final String ID_PERSTILLNESS_PAR= "Id_perstillness_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ICD9= "Icd9";
	public static final String ICD10= "Icd10";
	public static final String SORTNO= "Sortno";
	public static final String NOTE= "Note";
	public static final String FG_CORPREPORT= "Fg_corpreport";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_perstillness() {
		return ((String) getAttrVal("Id_perstillness"));
	}	
	public void setId_perstillness(String Id_perstillness) {
		setAttrVal("Id_perstillness", Id_perstillness);
	}
	public String getId_perstillness_par() {
		return ((String) getAttrVal("Id_perstillness_par"));
	}	
	public void setId_perstillness_par(String Id_perstillness_par) {
		setAttrVal("Id_perstillness_par", Id_perstillness_par);
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
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
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
	public String getIcd9() {
		return ((String) getAttrVal("Icd9"));
	}	
	public void setIcd9(String Icd9) {
		setAttrVal("Icd9", Icd9);
	}
	public String getIcd10() {
		return ((String) getAttrVal("Icd10"));
	}	
	public void setIcd10(String Icd10) {
		setAttrVal("Icd10", Icd10);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public FBoolean getFg_corpreport() {
		return ((FBoolean) getAttrVal("Fg_corpreport"));
	}	
	public void setFg_corpreport(FBoolean Fg_corpreport) {
		setAttrVal("Fg_corpreport", Fg_corpreport);
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
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_perstillness";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstillness";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstIllnessDODesc.class);
	}
	
}