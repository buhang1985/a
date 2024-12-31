package iih.mkr.std.commondeval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.std.commondeval.d.desc.DataElementValDODesc;
import java.math.BigDecimal;

/**
 * 数据元值 DO数据 
 * 
 */
public class DataElementValDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DE_VAL= "Id_de_val";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String VALDOMAINCODE= "Valdomaincode";
	public static final String VALDOMAINCODENAME= "Valdomaincodename";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String VAL= "Val";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String DES= "Des";
	public static final String VALTYPE= "Valtype";
	public static final String VER= "Ver";
	public static final String ID_PAR= "Id_par";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAR= "Name_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_de_val() {
		return ((String) getAttrVal("Id_de_val"));
	}	
	public void setId_de_val(String Id_de_val) {
		setAttrVal("Id_de_val", Id_de_val);
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
	public String getValdomaincode() {
		return ((String) getAttrVal("Valdomaincode"));
	}	
	public void setValdomaincode(String Valdomaincode) {
		setAttrVal("Valdomaincode", Valdomaincode);
	}
	public String getValdomaincodename() {
		return ((String) getAttrVal("Valdomaincodename"));
	}	
	public void setValdomaincodename(String Valdomaincodename) {
		setAttrVal("Valdomaincodename", Valdomaincodename);
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
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getValtype() {
		return ((Integer) getAttrVal("Valtype"));
	}	
	public void setValtype(Integer Valtype) {
		setAttrVal("Valtype", Valtype);
	}
	public String getVer() {
		return ((String) getAttrVal("Ver"));
	}	
	public void setVer(String Ver) {
		setAttrVal("Ver", Ver);
	}
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
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
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
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
		return "Id_de_val";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_de_val";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DataElementValDODesc.class);
	}
	
}