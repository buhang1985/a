package iih.sc.sch.scsch.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.sch.scsch.d.desc.SchOcpResDODesc;
import java.math.BigDecimal;

/**
 * 排班资源占用 DO数据 
 * 
 */
public class SchOcpResDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SCHOCPRES= "Id_schocpres";
	public static final String ID_SCH= "Id_sch";
	public static final String EU_OCPTP= "Eu_ocptp";
	public static final String ID_QUESITE= "Id_quesite";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_schocpres() {
		return ((String) getAttrVal("Id_schocpres"));
	}	
	public void setId_schocpres(String Id_schocpres) {
		setAttrVal("Id_schocpres", Id_schocpres);
	}
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	public Integer getEu_ocptp() {
		return ((Integer) getAttrVal("Eu_ocptp"));
	}	
	public void setEu_ocptp(Integer Eu_ocptp) {
		setAttrVal("Eu_ocptp", Eu_ocptp);
	}
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}	
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
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
		return "Id_schocpres";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_sch_ocpres";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SchOcpResDODesc.class);
	}
	
}