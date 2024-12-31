package iih.pe.pbd.pepreface.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pepreface.d.desc.PePrefaceDODesc;
import java.math.BigDecimal;

/**
 * 体检报告卷首语 DO数据 
 * 
 */
public class PePrefaceDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPREFACE= "Id_pepreface";
	public static final String ID_PEPREFACE_PAR= "Id_pepreface_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_REPORT= "Id_report";
	public static final String COVERWORDS= "Coverwords";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepreface() {
		return ((String) getAttrVal("Id_pepreface"));
	}	
	public void setId_pepreface(String Id_pepreface) {
		setAttrVal("Id_pepreface", Id_pepreface);
	}
	public String getId_pepreface_par() {
		return ((String) getAttrVal("Id_pepreface_par"));
	}	
	public void setId_pepreface_par(String Id_pepreface_par) {
		setAttrVal("Id_pepreface_par", Id_pepreface_par);
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
	public String getId_report() {
		return ((String) getAttrVal("Id_report"));
	}	
	public void setId_report(String Id_report) {
		setAttrVal("Id_report", Id_report);
	}
	public String getCoverwords() {
		return ((String) getAttrVal("Coverwords"));
	}	
	public void setCoverwords(String Coverwords) {
		setAttrVal("Coverwords", Coverwords);
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
		return "Id_pepreface";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_pepreface";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePrefaceDODesc.class);
	}
	
}