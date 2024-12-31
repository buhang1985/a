package iih.nm.nhr.nmgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmgrp.d.desc.GrpDepDODesc;
import java.math.BigDecimal;

/**
 * 小组包含科室 DO数据 
 * 
 */
public class GrpDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_GRP_DEP= "Id_grp_dep";
	public static final String ID_NM_GRP= "Id_nm_grp";
	public static final String ID_DEP= "Id_dep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NMGRP_NAME= "Nmgrp_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_grp_dep() {
		return ((String) getAttrVal("Id_grp_dep"));
	}	
	public void setId_grp_dep(String Id_grp_dep) {
		setAttrVal("Id_grp_dep", Id_grp_dep);
	}
	public String getId_nm_grp() {
		return ((String) getAttrVal("Id_nm_grp"));
	}	
	public void setId_nm_grp(String Id_nm_grp) {
		setAttrVal("Id_nm_grp", Id_nm_grp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
		return "Id_grp_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_GRP_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(GrpDepDODesc.class);
	}
	
}