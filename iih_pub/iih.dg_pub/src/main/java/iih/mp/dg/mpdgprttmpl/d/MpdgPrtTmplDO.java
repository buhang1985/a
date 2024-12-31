package iih.mp.dg.mpdgprttmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.mpdgprttmpl.d.desc.MpdgPrtTmplDODesc;
import java.math.BigDecimal;

/**
 * 药单打印模板管理 DO数据 
 * 
 */
public class MpdgPrtTmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRTTMPL= "Id_prttmpl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String RPTPATH= "Rptpath";
	public static final String ID_DRUGDOCS_APPLY= "Id_drugdocs_apply";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DRUG_CODE= "Drug_code";
	public static final String DRUG_NAME= "Drug_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prttmpl() {
		return ((String) getAttrVal("Id_prttmpl"));
	}	
	public void setId_prttmpl(String Id_prttmpl) {
		setAttrVal("Id_prttmpl", Id_prttmpl);
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
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getRptpath() {
		return ((String) getAttrVal("Rptpath"));
	}	
	public void setRptpath(String Rptpath) {
		setAttrVal("Rptpath", Rptpath);
	}
	public String getId_drugdocs_apply() {
		return ((String) getAttrVal("Id_drugdocs_apply"));
	}	
	public void setId_drugdocs_apply(String Id_drugdocs_apply) {
		setAttrVal("Id_drugdocs_apply", Id_drugdocs_apply);
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
	public String getDrug_code() {
		return ((String) getAttrVal("Drug_code"));
	}	
	public void setDrug_code(String Drug_code) {
		setAttrVal("Drug_code", Drug_code);
	}
	public String getDrug_name() {
		return ((String) getAttrVal("Drug_name"));
	}	
	public void setDrug_name(String Drug_name) {
		setAttrVal("Drug_name", Drug_name);
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
		return "Id_prttmpl";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_PRTTMPL_DRUGDOC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpdgPrtTmplDODesc.class);
	}
	
}