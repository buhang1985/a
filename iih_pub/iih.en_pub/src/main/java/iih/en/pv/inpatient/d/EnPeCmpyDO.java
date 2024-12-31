package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.inpatient.d.desc.EnPeCmpyDODesc;
import java.math.BigDecimal;

/**
 * 团检记录 DO数据 
 * 
 */
public class EnPeCmpyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECMPY= "Id_pecmpy";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_CUST_CMPY= "Id_cust_cmpy";
	public static final String NO_CONTRACT= "No_contract";
	public static final String TIMES_PE= "Times_pe";
	public static final String EU_STATUS= "Eu_status";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}	
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
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
	public String getId_cust_cmpy() {
		return ((String) getAttrVal("Id_cust_cmpy"));
	}	
	public void setId_cust_cmpy(String Id_cust_cmpy) {
		setAttrVal("Id_cust_cmpy", Id_cust_cmpy);
	}
	public String getNo_contract() {
		return ((String) getAttrVal("No_contract"));
	}	
	public void setNo_contract(String No_contract) {
		setAttrVal("No_contract", No_contract);
	}
	public Integer getTimes_pe() {
		return ((Integer) getAttrVal("Times_pe"));
	}	
	public void setTimes_pe(Integer Times_pe) {
		setAttrVal("Times_pe", Times_pe);
	}
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}	
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
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
		return "Id_pecmpy";
	}
	
	@Override
	public String getTableName() {	  
		return "en_pe_cmpy";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnPeCmpyDODesc.class);
	}
	
}