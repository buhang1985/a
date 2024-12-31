package iih.nm.nqm.aer.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.aer.d.desc.NmAerCaDODesc;
import java.math.BigDecimal;

/**
 * 事件分类 DO数据 
 * 
 */
public class NmAerCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AERCA= "Id_aerca";
	public static final String ID_AER= "Id_aer";
	public static final String ID_EVT_CA= "Id_evt_ca";
	public static final String SD_EVT_CA= "Sd_evt_ca";
	public static final String EVT_CA_NAME_OTHER= "Evt_ca_name_other";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_EVT_CA= "Name_evt_ca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aerca() {
		return ((String) getAttrVal("Id_aerca"));
	}	
	public void setId_aerca(String Id_aerca) {
		setAttrVal("Id_aerca", Id_aerca);
	}
	public String getId_aer() {
		return ((String) getAttrVal("Id_aer"));
	}	
	public void setId_aer(String Id_aer) {
		setAttrVal("Id_aer", Id_aer);
	}
	public String getId_evt_ca() {
		return ((String) getAttrVal("Id_evt_ca"));
	}	
	public void setId_evt_ca(String Id_evt_ca) {
		setAttrVal("Id_evt_ca", Id_evt_ca);
	}
	public String getSd_evt_ca() {
		return ((String) getAttrVal("Sd_evt_ca"));
	}	
	public void setSd_evt_ca(String Sd_evt_ca) {
		setAttrVal("Sd_evt_ca", Sd_evt_ca);
	}
	public String getEvt_ca_name_other() {
		return ((String) getAttrVal("Evt_ca_name_other"));
	}	
	public void setEvt_ca_name_other(String Evt_ca_name_other) {
		setAttrVal("Evt_ca_name_other", Evt_ca_name_other);
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
	public String getName_evt_ca() {
		return ((String) getAttrVal("Name_evt_ca"));
	}	
	public void setName_evt_ca(String Name_evt_ca) {
		setAttrVal("Name_evt_ca", Name_evt_ca);
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
		return "Id_aerca";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_AER_CA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmAerCaDODesc.class);
	}
	
}