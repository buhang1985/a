package iih.bd.pp.cust.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.cust.d.desc.CustCaDODesc;
import java.math.BigDecimal;

/**
 * 付款客户分类 DO数据 
 * 
 */
public class CustCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CUSTCA= "Id_custca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CUSTTP= "Id_custtp";
	public static final String SD_CUSTTP= "Sd_custtp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_PAR= "Id_par";
	public static final String PATH= "Path";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CUSTTP_NAME= "Custtp_name";
	public static final String PAR_NAME= "Par_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_custca() {
		return ((String) getAttrVal("Id_custca"));
	}	
	public void setId_custca(String Id_custca) {
		setAttrVal("Id_custca", Id_custca);
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
	public String getId_custtp() {
		return ((String) getAttrVal("Id_custtp"));
	}	
	public void setId_custtp(String Id_custtp) {
		setAttrVal("Id_custtp", Id_custtp);
	}
	public String getSd_custtp() {
		return ((String) getAttrVal("Sd_custtp"));
	}	
	public void setSd_custtp(String Sd_custtp) {
		setAttrVal("Sd_custtp", Sd_custtp);
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
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public String getPath() {
		return ((String) getAttrVal("Path"));
	}	
	public void setPath(String Path) {
		setAttrVal("Path", Path);
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
	public String getCusttp_name() {
		return ((String) getAttrVal("Custtp_name"));
	}	
	public void setCusttp_name(String Custtp_name) {
		setAttrVal("Custtp_name", Custtp_name);
	}
	public String getPar_name() {
		return ((String) getAttrVal("Par_name"));
	}	
	public void setPar_name(String Par_name) {
		setAttrVal("Par_name", Par_name);
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
		return "Id_custca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_custca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CustCaDODesc.class);
	}
	
}