package iih.nm.nqm.nmnqmtaskdep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmtaskdep.d.desc.NmNqmTaskPsnDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_科室检查人员 DO数据 
 * 
 */
public class NmNqmTaskPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_TASK_PSN= "Id_nqm_task_psn";
	public static final String ID_NQM_TASK_DEP= "Id_nqm_task_dep";
	public static final String ID_NQM_TASK= "Id_nqm_task";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	public static final String SD_NUR_LVL= "Sd_nur_lvl";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_task_psn() {
		return ((String) getAttrVal("Id_nqm_task_psn"));
	}	
	public void setId_nqm_task_psn(String Id_nqm_task_psn) {
		setAttrVal("Id_nqm_task_psn", Id_nqm_task_psn);
	}
	public String getId_nqm_task_dep() {
		return ((String) getAttrVal("Id_nqm_task_dep"));
	}	
	public void setId_nqm_task_dep(String Id_nqm_task_dep) {
		setAttrVal("Id_nqm_task_dep", Id_nqm_task_dep);
	}
	public String getId_nqm_task() {
		return ((String) getAttrVal("Id_nqm_task"));
	}	
	public void setId_nqm_task(String Id_nqm_task) {
		setAttrVal("Id_nqm_task", Id_nqm_task);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}	
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
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
		return "Id_nqm_task_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmTaskPsnDODesc.class);
	}
	
}