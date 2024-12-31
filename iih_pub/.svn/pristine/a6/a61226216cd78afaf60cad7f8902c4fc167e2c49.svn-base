package iih.nm.nqm.nmnqmtaskdep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmtaskdep.d.desc.NmNqmTaskDepDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_检查科室 DO数据 
 * 
 */
public class NmNqmTaskDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_TASK_DEP= "Id_nqm_task_dep";
	public static final String ID_NQM_TASK= "Id_nqm_task";
	public static final String ID_DEP= "Id_dep";
	public static final String CODE_DEP= "Code_dep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
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
		return "Id_nqm_task_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmTaskDepDODesc.class);
	}
	
}