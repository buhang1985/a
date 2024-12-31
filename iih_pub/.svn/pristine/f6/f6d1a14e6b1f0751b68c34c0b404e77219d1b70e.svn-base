package iih.nm.nhr.nmdeppl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmdeppl.d.desc.NmDepplDODesc;
import java.math.BigDecimal;

/**
 * 实习科室轮转计划 DO数据 
 * 
 */
public class NmDepplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEP_PL= "Id_dep_pl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String YEAR= "Year";
	public static final String ID_NM_GRP= "Id_nm_grp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WEEK= "Week";
	public static final String ALLWEEK= "Allweek";
	public static final String NMGRP_NAME= "Nmgrp_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dep_pl() {
		return ((String) getAttrVal("Id_dep_pl"));
	}	
	public void setId_dep_pl(String Id_dep_pl) {
		setAttrVal("Id_dep_pl", Id_dep_pl);
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
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	public String getId_nm_grp() {
		return ((String) getAttrVal("Id_nm_grp"));
	}	
	public void setId_nm_grp(String Id_nm_grp) {
		setAttrVal("Id_nm_grp", Id_nm_grp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	public Integer getWeek() {
		return ((Integer) getAttrVal("Week"));
	}	
	public void setWeek(Integer Week) {
		setAttrVal("Week", Week);
	}
	public Integer getAllweek() {
		return ((Integer) getAttrVal("Allweek"));
	}	
	public void setAllweek(Integer Allweek) {
		setAttrVal("Allweek", Allweek);
	}
	public String getNmgrp_name() {
		return ((String) getAttrVal("Nmgrp_name"));
	}	
	public void setNmgrp_name(String Nmgrp_name) {
		setAttrVal("Nmgrp_name", Nmgrp_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
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
		return "Id_dep_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_DEP_PL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmDepplDODesc.class);
	}
	
}