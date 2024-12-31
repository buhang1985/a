package iih.nm.nit.nitpracgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpracgrp.d.desc.NitPracgrpDepDODesc;
import java.math.BigDecimal;

/**
 * 小组实习科室 DO数据 
 * 
 */
public class NitPracgrpDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRACGRP_DEP= "Id_pracgrp_dep";
	public static final String ID_PRACGRP= "Id_pracgrp";
	public static final String ID_DEP= "Id_dep";
	public static final String WEEK_COUNT= "Week_count";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PRACGRP= "Name_pracgrp";
	public static final String CODE_PRACGRP= "Code_pracgrp";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pracgrp_dep() {
		return ((String) getAttrVal("Id_pracgrp_dep"));
	}	
	public void setId_pracgrp_dep(String Id_pracgrp_dep) {
		setAttrVal("Id_pracgrp_dep", Id_pracgrp_dep);
	}
	public String getId_pracgrp() {
		return ((String) getAttrVal("Id_pracgrp"));
	}	
	public void setId_pracgrp(String Id_pracgrp) {
		setAttrVal("Id_pracgrp", Id_pracgrp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public Integer getWeek_count() {
		return ((Integer) getAttrVal("Week_count"));
	}	
	public void setWeek_count(Integer Week_count) {
		setAttrVal("Week_count", Week_count);
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
	public String getName_pracgrp() {
		return ((String) getAttrVal("Name_pracgrp"));
	}	
	public void setName_pracgrp(String Name_pracgrp) {
		setAttrVal("Name_pracgrp", Name_pracgrp);
	}
	public String getCode_pracgrp() {
		return ((String) getAttrVal("Code_pracgrp"));
	}	
	public void setCode_pracgrp(String Code_pracgrp) {
		setAttrVal("Code_pracgrp", Code_pracgrp);
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
		return "Id_pracgrp_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRACGRP_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPracgrpDepDODesc.class);
	}
	
}