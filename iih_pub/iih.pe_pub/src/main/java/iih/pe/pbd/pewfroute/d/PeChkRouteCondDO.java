package iih.pe.pbd.pewfroute.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pewfroute.d.desc.PeChkRouteCondDODesc;
import java.math.BigDecimal;

/**
 * 体检检查路线适用条件 DO数据 
 * 
 */
public class PeChkRouteCondDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECHKROUTECOND= "Id_pechkroutecond";
	public static final String ID_PEWFROUTEDEF= "Id_pewfroutedef";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_PEMEMCARD= "Id_pememcard";
	public static final String ID_PESRVSETDEF= "Id_pesrvsetdef";
	public static final String SEXLIMIT= "Sexlimit";
	public static final String NAME_MEMCARD= "Name_memcard";
	public static final String CODE_MEMCARD= "Code_memcard";
	public static final String NAME_SRVSET= "Name_srvset";
	public static final String CODE_SRVSET= "Code_srvset";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pechkroutecond() {
		return ((String) getAttrVal("Id_pechkroutecond"));
	}	
	public void setId_pechkroutecond(String Id_pechkroutecond) {
		setAttrVal("Id_pechkroutecond", Id_pechkroutecond);
	}
	public String getId_pewfroutedef() {
		return ((String) getAttrVal("Id_pewfroutedef"));
	}	
	public void setId_pewfroutedef(String Id_pewfroutedef) {
		setAttrVal("Id_pewfroutedef", Id_pewfroutedef);
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
	public String getId_pememcard() {
		return ((String) getAttrVal("Id_pememcard"));
	}	
	public void setId_pememcard(String Id_pememcard) {
		setAttrVal("Id_pememcard", Id_pememcard);
	}
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}	
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	public Integer getSexlimit() {
		return ((Integer) getAttrVal("Sexlimit"));
	}	
	public void setSexlimit(Integer Sexlimit) {
		setAttrVal("Sexlimit", Sexlimit);
	}
	public String getName_memcard() {
		return ((String) getAttrVal("Name_memcard"));
	}	
	public void setName_memcard(String Name_memcard) {
		setAttrVal("Name_memcard", Name_memcard);
	}
	public String getCode_memcard() {
		return ((String) getAttrVal("Code_memcard"));
	}	
	public void setCode_memcard(String Code_memcard) {
		setAttrVal("Code_memcard", Code_memcard);
	}
	public String getName_srvset() {
		return ((String) getAttrVal("Name_srvset"));
	}	
	public void setName_srvset(String Name_srvset) {
		setAttrVal("Name_srvset", Name_srvset);
	}
	public String getCode_srvset() {
		return ((String) getAttrVal("Code_srvset"));
	}	
	public void setCode_srvset(String Code_srvset) {
		setAttrVal("Code_srvset", Code_srvset);
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
		return "Id_pechkroutecond";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_chkroutecond";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChkRouteCondDODesc.class);
	}
	
}