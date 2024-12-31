package iih.nm.nqm.nmnqmwdkpi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmwdkpi.d.desc.NmNqmWdKpiDODesc;
import java.math.BigDecimal;

/**
 * 病区护理指标 DO数据 
 * 
 */
public class NmNqmWdKpiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_WD_KPI= "Id_nqm_wd_kpi";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NQM_SPCS= "Id_nqm_spcs";
	public static final String ID_NQM_SPCS_KPI= "Id_nqm_spcs_kpi";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String NUMCAP= "Numcap";
	public static final String NUMFLOOR= "Numfloor";
	public static final String NUMOVER= "Numover";
	public static final String ID_GOAL= "Id_goal";
	public static final String SD_GOAL= "Sd_goal";
	public static final String ID_PER_UNIT= "Id_per_unit";
	public static final String SD_PER_UNIT= "Sd_per_unit";
	public static final String DT_OPER= "Dt_oper";
	public static final String ID_OPER_PSN= "Id_oper_psn";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SPCS= "Name_spcs";
	public static final String NAME_SPCS_KPI= "Name_spcs_kpi";
	public static final String CODE_SPCS_KPI= "Code_spcs_kpi";
	public static final String CHKNUMBNAME_SPCS_KPI= "Chknumbname_spcs_kpi";
	public static final String CHKDENORNAME_SPCS_KPI= "Chkdenorname_spcs_kpi";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_GOAL= "Name_goal";
	public static final String NAME_PER_UNIT= "Name_per_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_wd_kpi() {
		return ((String) getAttrVal("Id_nqm_wd_kpi"));
	}	
	public void setId_nqm_wd_kpi(String Id_nqm_wd_kpi) {
		setAttrVal("Id_nqm_wd_kpi", Id_nqm_wd_kpi);
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
	public String getId_nqm_spcs() {
		return ((String) getAttrVal("Id_nqm_spcs"));
	}	
	public void setId_nqm_spcs(String Id_nqm_spcs) {
		setAttrVal("Id_nqm_spcs", Id_nqm_spcs);
	}
	public String getId_nqm_spcs_kpi() {
		return ((String) getAttrVal("Id_nqm_spcs_kpi"));
	}	
	public void setId_nqm_spcs_kpi(String Id_nqm_spcs_kpi) {
		setAttrVal("Id_nqm_spcs_kpi", Id_nqm_spcs_kpi);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FDouble getNumcap() {
		return ((FDouble) getAttrVal("Numcap"));
	}	
	public void setNumcap(FDouble Numcap) {
		setAttrVal("Numcap", Numcap);
	}
	public FDouble getNumfloor() {
		return ((FDouble) getAttrVal("Numfloor"));
	}	
	public void setNumfloor(FDouble Numfloor) {
		setAttrVal("Numfloor", Numfloor);
	}
	public FDouble getNumover() {
		return ((FDouble) getAttrVal("Numover"));
	}	
	public void setNumover(FDouble Numover) {
		setAttrVal("Numover", Numover);
	}
	public String getId_goal() {
		return ((String) getAttrVal("Id_goal"));
	}	
	public void setId_goal(String Id_goal) {
		setAttrVal("Id_goal", Id_goal);
	}
	public String getSd_goal() {
		return ((String) getAttrVal("Sd_goal"));
	}	
	public void setSd_goal(String Sd_goal) {
		setAttrVal("Sd_goal", Sd_goal);
	}
	public String getId_per_unit() {
		return ((String) getAttrVal("Id_per_unit"));
	}	
	public void setId_per_unit(String Id_per_unit) {
		setAttrVal("Id_per_unit", Id_per_unit);
	}
	public String getSd_per_unit() {
		return ((String) getAttrVal("Sd_per_unit"));
	}	
	public void setSd_per_unit(String Sd_per_unit) {
		setAttrVal("Sd_per_unit", Sd_per_unit);
	}
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	public String getId_oper_psn() {
		return ((String) getAttrVal("Id_oper_psn"));
	}	
	public void setId_oper_psn(String Id_oper_psn) {
		setAttrVal("Id_oper_psn", Id_oper_psn);
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
	public String getName_spcs() {
		return ((String) getAttrVal("Name_spcs"));
	}	
	public void setName_spcs(String Name_spcs) {
		setAttrVal("Name_spcs", Name_spcs);
	}
	public String getName_spcs_kpi() {
		return ((String) getAttrVal("Name_spcs_kpi"));
	}	
	public void setName_spcs_kpi(String Name_spcs_kpi) {
		setAttrVal("Name_spcs_kpi", Name_spcs_kpi);
	}
	public String getCode_spcs_kpi() {
		return ((String) getAttrVal("Code_spcs_kpi"));
	}	
	public void setCode_spcs_kpi(String Code_spcs_kpi) {
		setAttrVal("Code_spcs_kpi", Code_spcs_kpi);
	}
	public String getChknumbname_spcs_kpi() {
		return ((String) getAttrVal("Chknumbname_spcs_kpi"));
	}	
	public void setChknumbname_spcs_kpi(String Chknumbname_spcs_kpi) {
		setAttrVal("Chknumbname_spcs_kpi", Chknumbname_spcs_kpi);
	}
	public String getChkdenorname_spcs_kpi() {
		return ((String) getAttrVal("Chkdenorname_spcs_kpi"));
	}	
	public void setChkdenorname_spcs_kpi(String Chkdenorname_spcs_kpi) {
		setAttrVal("Chkdenorname_spcs_kpi", Chkdenorname_spcs_kpi);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_goal() {
		return ((String) getAttrVal("Name_goal"));
	}	
	public void setName_goal(String Name_goal) {
		setAttrVal("Name_goal", Name_goal);
	}
	public String getName_per_unit() {
		return ((String) getAttrVal("Name_per_unit"));
	}	
	public void setName_per_unit(String Name_per_unit) {
		setAttrVal("Name_per_unit", Name_per_unit);
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
		return "Id_nqm_wd_kpi";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_WD_KPI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmWdKpiDODesc.class);
	}
	
}