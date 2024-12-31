package iih.bd.srv.diagdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.diagdef.d.desc.DiagCompDODesc;
import java.math.BigDecimal;

/**
 * 诊断对照关系 DO数据 
 * 
 */
public class DiagCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DICOMP= "Id_dicomp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DIDEF= "Id_didef";
	public static final String ID_DISTD_COMP= "Id_distd_comp";
	public static final String ID_DIDEF_COMP= "Id_didef_comp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CDSYSTP_NAME= "Cdsystp_name";
	public static final String DISTD_COMP_NAME= "Distd_comp_name";
	public static final String DIDEF_COMP_CODE= "Didef_comp_code";
	public static final String DIDEF_COMP_NAME= "Didef_comp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dicomp() {
		return ((String) getAttrVal("Id_dicomp"));
	}	
	public void setId_dicomp(String Id_dicomp) {
		setAttrVal("Id_dicomp", Id_dicomp);
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
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getId_distd_comp() {
		return ((String) getAttrVal("Id_distd_comp"));
	}	
	public void setId_distd_comp(String Id_distd_comp) {
		setAttrVal("Id_distd_comp", Id_distd_comp);
	}
	public String getId_didef_comp() {
		return ((String) getAttrVal("Id_didef_comp"));
	}	
	public void setId_didef_comp(String Id_didef_comp) {
		setAttrVal("Id_didef_comp", Id_didef_comp);
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
	public String getCdsystp_name() {
		return ((String) getAttrVal("Cdsystp_name"));
	}	
	public void setCdsystp_name(String Cdsystp_name) {
		setAttrVal("Cdsystp_name", Cdsystp_name);
	}
	public String getDistd_comp_name() {
		return ((String) getAttrVal("Distd_comp_name"));
	}	
	public void setDistd_comp_name(String Distd_comp_name) {
		setAttrVal("Distd_comp_name", Distd_comp_name);
	}
	public String getDidef_comp_code() {
		return ((String) getAttrVal("Didef_comp_code"));
	}	
	public void setDidef_comp_code(String Didef_comp_code) {
		setAttrVal("Didef_comp_code", Didef_comp_code);
	}
	public String getDidef_comp_name() {
		return ((String) getAttrVal("Didef_comp_name"));
	}	
	public void setDidef_comp_name(String Didef_comp_name) {
		setAttrVal("Didef_comp_name", Didef_comp_name);
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
		return "Id_dicomp";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_DI_COMP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DiagCompDODesc.class);
	}
	
}