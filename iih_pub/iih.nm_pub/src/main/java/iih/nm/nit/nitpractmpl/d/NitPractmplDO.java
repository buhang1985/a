package iih.nm.nit.nitpractmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpractmpl.d.desc.NitPractmplDODesc;
import java.math.BigDecimal;

/**
 * 实习模板 DO数据 
 * 
 */
public class NitPractmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NIT_PRACTMPL= "Id_nit_practmpl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_TMPLTP= "Id_tmpltp";
	public static final String SD_TMPLTP= "Sd_tmpltp";
	public static final String TOTAL_WEEK= "Total_week";
	public static final String ID_PSN_CRT= "Id_psn_crt";
	public static final String DT_CRT= "Dt_crt";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_EDU= "Id_edu";
	public static final String SD_EDU= "Sd_edu";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_TMPLTP= "Name_tmpltp";
	public static final String NAME_PSN_CRT= "Name_psn_crt";
	public static final String NAME_EDU= "Name_edu";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nit_practmpl() {
		return ((String) getAttrVal("Id_nit_practmpl"));
	}	
	public void setId_nit_practmpl(String Id_nit_practmpl) {
		setAttrVal("Id_nit_practmpl", Id_nit_practmpl);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_tmpltp() {
		return ((String) getAttrVal("Id_tmpltp"));
	}	
	public void setId_tmpltp(String Id_tmpltp) {
		setAttrVal("Id_tmpltp", Id_tmpltp);
	}
	public String getSd_tmpltp() {
		return ((String) getAttrVal("Sd_tmpltp"));
	}	
	public void setSd_tmpltp(String Sd_tmpltp) {
		setAttrVal("Sd_tmpltp", Sd_tmpltp);
	}
	public Integer getTotal_week() {
		return ((Integer) getAttrVal("Total_week"));
	}	
	public void setTotal_week(Integer Total_week) {
		setAttrVal("Total_week", Total_week);
	}
	public String getId_psn_crt() {
		return ((String) getAttrVal("Id_psn_crt"));
	}	
	public void setId_psn_crt(String Id_psn_crt) {
		setAttrVal("Id_psn_crt", Id_psn_crt);
	}
	public FDateTime getDt_crt() {
		return ((FDateTime) getAttrVal("Dt_crt"));
	}	
	public void setDt_crt(FDateTime Dt_crt) {
		setAttrVal("Dt_crt", Dt_crt);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	public String getId_edu() {
		return ((String) getAttrVal("Id_edu"));
	}	
	public void setId_edu(String Id_edu) {
		setAttrVal("Id_edu", Id_edu);
	}
	public String getSd_edu() {
		return ((String) getAttrVal("Sd_edu"));
	}	
	public void setSd_edu(String Sd_edu) {
		setAttrVal("Sd_edu", Sd_edu);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_tmpltp() {
		return ((String) getAttrVal("Name_tmpltp"));
	}	
	public void setName_tmpltp(String Name_tmpltp) {
		setAttrVal("Name_tmpltp", Name_tmpltp);
	}
	public String getName_psn_crt() {
		return ((String) getAttrVal("Name_psn_crt"));
	}	
	public void setName_psn_crt(String Name_psn_crt) {
		setAttrVal("Name_psn_crt", Name_psn_crt);
	}
	public String getName_edu() {
		return ((String) getAttrVal("Name_edu"));
	}	
	public void setName_edu(String Name_edu) {
		setAttrVal("Name_edu", Name_edu);
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
		return "Id_nit_practmpl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRACTMPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPractmplDODesc.class);
	}
	
}