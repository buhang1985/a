package iih.nm.nit.nitpracgrppl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpracgrppl.d.desc.NitPracgrpPlDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_小组实习计划 DO数据 
 * 
 */
public class NitPracgrpPlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRACGRP_PL= "Id_pracgrp_pl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PRACGRP= "Id_pracgrp";
	public static final String NAME= "Name";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String TOTAL_WEEKS= "Total_weeks";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PRACGRP_NAME= "Pracgrp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pracgrp_pl() {
		return ((String) getAttrVal("Id_pracgrp_pl"));
	}	
	public void setId_pracgrp_pl(String Id_pracgrp_pl) {
		setAttrVal("Id_pracgrp_pl", Id_pracgrp_pl);
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
	public String getId_pracgrp() {
		return ((String) getAttrVal("Id_pracgrp"));
	}	
	public void setId_pracgrp(String Id_pracgrp) {
		setAttrVal("Id_pracgrp", Id_pracgrp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getTotal_weeks() {
		return ((String) getAttrVal("Total_weeks"));
	}	
	public void setTotal_weeks(String Total_weeks) {
		setAttrVal("Total_weeks", Total_weeks);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
	public String getPracgrp_name() {
		return ((String) getAttrVal("Pracgrp_name"));
	}	
	public void setPracgrp_name(String Pracgrp_name) {
		setAttrVal("Pracgrp_name", Pracgrp_name);
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
		return "Id_pracgrp_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRACGRP_PL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPracgrpPlDODesc.class);
	}
	
}