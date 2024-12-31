package iih.pe.pds.pedsdiag.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pds.pedsdiag.d.desc.PeDsDiagDefDODesc;
import java.math.BigDecimal;

/**
 * 体检诊断决策定义 DO数据 
 * 
 */
public class PeDsDiagDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDSDIAGDEF= "Id_pedsdiagdef";
	public static final String ID_PEDSDIAGDEF_PAR= "Id_pedsdiagdef_par";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DI= "Code_di";
	public static final String NAME_DI= "Name_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedsdiagdef() {
		return ((String) getAttrVal("Id_pedsdiagdef"));
	}	
	public void setId_pedsdiagdef(String Id_pedsdiagdef) {
		setAttrVal("Id_pedsdiagdef", Id_pedsdiagdef);
	}
	public String getId_pedsdiagdef_par() {
		return ((String) getAttrVal("Id_pedsdiagdef_par"));
	}	
	public void setId_pedsdiagdef_par(String Id_pedsdiagdef_par) {
		setAttrVal("Id_pedsdiagdef_par", Id_pedsdiagdef_par);
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
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
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
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
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
		return "Id_pedsdiagdef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ds_pedsdiagdef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDsDiagDefDODesc.class);
	}
	
}