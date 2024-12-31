package iih.bd.srv.routedosage.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.routedosage.d.desc.RouteDosageRefDODesc;
import java.math.BigDecimal;

/**
 * 用法关联剂型 DO数据 
 * 
 */
public class RouteDosageRefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ROUTEDOSAGEREF= "Id_routedosageref";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_DOSAGE= "Id_dosage";
	public static final String SD_DOSAGE= "Sd_dosage";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ROUTE_CODE= "Route_code";
	public static final String ROUTE_NAME= "Route_name";
	public static final String DOS_NAME= "Dos_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	public String getId_routedosageref() {
		return ((String) getAttrVal("Id_routedosageref"));
	}	
	public void setId_routedosageref(String Id_routedosageref) {
		setAttrVal("Id_routedosageref", Id_routedosageref);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}	
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	public String getSd_dosage() {
		return ((String) getAttrVal("Sd_dosage"));
	}	
	public void setSd_dosage(String Sd_dosage) {
		setAttrVal("Sd_dosage", Sd_dosage);
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
	public String getRoute_code() {
		return ((String) getAttrVal("Route_code"));
	}	
	public void setRoute_code(String Route_code) {
		setAttrVal("Route_code", Route_code);
	}
	public String getRoute_name() {
		return ((String) getAttrVal("Route_name"));
	}	
	public void setRoute_name(String Route_name) {
		setAttrVal("Route_name", Route_name);
	}
	public String getDos_name() {
		return ((String) getAttrVal("Dos_name"));
	}	
	public void setDos_name(String Dos_name) {
		setAttrVal("Dos_name", Dos_name);
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
		return "Id_routedosageref";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_route_dosage_ref";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RouteDosageRefDODesc.class);
	}
	
}