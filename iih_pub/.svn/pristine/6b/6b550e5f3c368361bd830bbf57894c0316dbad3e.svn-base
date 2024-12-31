package iih.nm.nit.nitpracgrppl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpracgrppl.d.desc.NitPracgrpPlDepDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_小组计划轮转科室 DO数据 
 * 
 */
public class NitPracgrpPlDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRACGRP_PL_DEP= "Id_pracgrp_pl_dep";
	public static final String ID_PRACGRP_PL= "Id_pracgrp_pl";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String ID_DEP_CYC= "Id_dep_cyc";
	public static final String SORTNO= "Sortno";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PRACGRP_PL_NAME= "Pracgrp_pl_name";
	public static final String DT_BEGIN_PL= "Dt_begin_pl";
	public static final String DT_END_PL= "Dt_end_pl";
	public static final String TOTAL_WEEKS= "Total_weeks";
	public static final String DEP_NAME= "Dep_name";
	public static final String DEP_CODE= "Dep_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pracgrp_pl_dep() {
		return ((String) getAttrVal("Id_pracgrp_pl_dep"));
	}	
	public void setId_pracgrp_pl_dep(String Id_pracgrp_pl_dep) {
		setAttrVal("Id_pracgrp_pl_dep", Id_pracgrp_pl_dep);
	}
	public String getId_pracgrp_pl() {
		return ((String) getAttrVal("Id_pracgrp_pl"));
	}	
	public void setId_pracgrp_pl(String Id_pracgrp_pl) {
		setAttrVal("Id_pracgrp_pl", Id_pracgrp_pl);
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
	public String getId_dep_cyc() {
		return ((String) getAttrVal("Id_dep_cyc"));
	}	
	public void setId_dep_cyc(String Id_dep_cyc) {
		setAttrVal("Id_dep_cyc", Id_dep_cyc);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getPracgrp_pl_name() {
		return ((String) getAttrVal("Pracgrp_pl_name"));
	}	
	public void setPracgrp_pl_name(String Pracgrp_pl_name) {
		setAttrVal("Pracgrp_pl_name", Pracgrp_pl_name);
	}
	public FDate getDt_begin_pl() {
		return ((FDate) getAttrVal("Dt_begin_pl"));
	}	
	public void setDt_begin_pl(FDate Dt_begin_pl) {
		setAttrVal("Dt_begin_pl", Dt_begin_pl);
	}
	public FDate getDt_end_pl() {
		return ((FDate) getAttrVal("Dt_end_pl"));
	}	
	public void setDt_end_pl(FDate Dt_end_pl) {
		setAttrVal("Dt_end_pl", Dt_end_pl);
	}
	public String getTotal_weeks() {
		return ((String) getAttrVal("Total_weeks"));
	}	
	public void setTotal_weeks(String Total_weeks) {
		setAttrVal("Total_weeks", Total_weeks);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}	
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
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
		return "Id_pracgrp_pl_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRACGRP_PL_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPracgrpPlDepDODesc.class);
	}
	
}