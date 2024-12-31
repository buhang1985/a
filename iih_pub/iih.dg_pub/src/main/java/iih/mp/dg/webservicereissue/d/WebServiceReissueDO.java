package iih.mp.dg.webservicereissue.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.webservicereissue.d.desc.WebServiceReissueDODesc;
import java.math.BigDecimal;

/**
 * 第三方接口补发 DO数据 
 * 
 */
public class WebServiceReissueDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String WEBSERVICEID= "Webserviceid";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SER_INTERFACE= "Ser_interface";
	public static final String CALL_TIME= "Call_time";
	public static final String RETURN_TIME= "Return_time";
	public static final String CALL_CONTENT= "Call_content";
	public static final String RETURN_CONTENT= "Return_content";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getWebserviceid() {
		return ((String) getAttrVal("Webserviceid"));
	}	
	public void setWebserviceid(String Webserviceid) {
		setAttrVal("Webserviceid", Webserviceid);
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
	public String getSer_interface() {
		return ((String) getAttrVal("Ser_interface"));
	}	
	public void setSer_interface(String Ser_interface) {
		setAttrVal("Ser_interface", Ser_interface);
	}
	public FDateTime getCall_time() {
		return ((FDateTime) getAttrVal("Call_time"));
	}	
	public void setCall_time(FDateTime Call_time) {
		setAttrVal("Call_time", Call_time);
	}
	public FDateTime getReturn_time() {
		return ((FDateTime) getAttrVal("Return_time"));
	}	
	public void setReturn_time(FDateTime Return_time) {
		setAttrVal("Return_time", Return_time);
	}
	public String getCall_content() {
		return ((String) getAttrVal("Call_content"));
	}	
	public void setCall_content(String Call_content) {
		setAttrVal("Call_content", Call_content);
	}
	public String getReturn_content() {
		return ((String) getAttrVal("Return_content"));
	}	
	public void setReturn_content(String Return_content) {
		setAttrVal("Return_content", Return_content);
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
		return "Webserviceid";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_LOG_WEBSERVICE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WebServiceReissueDODesc.class);
	}
	
}