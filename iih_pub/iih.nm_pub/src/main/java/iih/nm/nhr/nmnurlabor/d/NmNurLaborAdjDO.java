package iih.nm.nhr.nmnurlabor.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurlabor.d.desc.NmNurLaborAdjDODesc;
import java.math.BigDecimal;

/**
 * 工时调整记录 DO数据 
 * 
 */
public class NmNurLaborAdjDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_LABOR_ADJ= "Id_nur_labor_adj";
	public static final String ID_NUR_LABOR= "Id_nur_labor";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ADJTP= "Adjtp";
	public static final String ID_NHR_SCHED_LV= "Id_nhr_sched_lv";
	public static final String ID_NHR_SCHED_RP= "Id_nhr_sched_rp";
	public static final String DT_SCHED_LV= "Dt_sched_lv";
	public static final String DT_SCHED_RP= "Dt_sched_rp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_labor_adj() {
		return ((String) getAttrVal("Id_nur_labor_adj"));
	}	
	public void setId_nur_labor_adj(String Id_nur_labor_adj) {
		setAttrVal("Id_nur_labor_adj", Id_nur_labor_adj);
	}
	public String getId_nur_labor() {
		return ((String) getAttrVal("Id_nur_labor"));
	}	
	public void setId_nur_labor(String Id_nur_labor) {
		setAttrVal("Id_nur_labor", Id_nur_labor);
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
	public Integer getAdjtp() {
		return ((Integer) getAttrVal("Adjtp"));
	}	
	public void setAdjtp(Integer Adjtp) {
		setAttrVal("Adjtp", Adjtp);
	}
	public String getId_nhr_sched_lv() {
		return ((String) getAttrVal("Id_nhr_sched_lv"));
	}	
	public void setId_nhr_sched_lv(String Id_nhr_sched_lv) {
		setAttrVal("Id_nhr_sched_lv", Id_nhr_sched_lv);
	}
	public String getId_nhr_sched_rp() {
		return ((String) getAttrVal("Id_nhr_sched_rp"));
	}	
	public void setId_nhr_sched_rp(String Id_nhr_sched_rp) {
		setAttrVal("Id_nhr_sched_rp", Id_nhr_sched_rp);
	}
	public FDate getDt_sched_lv() {
		return ((FDate) getAttrVal("Dt_sched_lv"));
	}	
	public void setDt_sched_lv(FDate Dt_sched_lv) {
		setAttrVal("Dt_sched_lv", Dt_sched_lv);
	}
	public FDate getDt_sched_rp() {
		return ((FDate) getAttrVal("Dt_sched_rp"));
	}	
	public void setDt_sched_rp(FDate Dt_sched_rp) {
		setAttrVal("Dt_sched_rp", Dt_sched_rp);
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
		return "Id_nur_labor_adj";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NUR_LABOR_ADJ";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurLaborAdjDODesc.class);
	}
	
}