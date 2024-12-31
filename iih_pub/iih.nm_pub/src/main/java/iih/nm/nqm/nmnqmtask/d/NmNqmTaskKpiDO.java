package iih.nm.nqm.nmnqmtask.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmtask.d.desc.NmNqmTaskKpiDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_检查指标 DO数据 
 * 
 */
public class NmNqmTaskKpiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_TASK_KPI= "Id_nqm_task_kpi";
	public static final String ID_NQM_TASK= "Id_nqm_task";
	public static final String ID_NBD_KPI= "Id_nbd_kpi";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NBD_KPI= "Name_nbd_kpi";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_task_kpi() {
		return ((String) getAttrVal("Id_nqm_task_kpi"));
	}	
	public void setId_nqm_task_kpi(String Id_nqm_task_kpi) {
		setAttrVal("Id_nqm_task_kpi", Id_nqm_task_kpi);
	}
	public String getId_nqm_task() {
		return ((String) getAttrVal("Id_nqm_task"));
	}	
	public void setId_nqm_task(String Id_nqm_task) {
		setAttrVal("Id_nqm_task", Id_nqm_task);
	}
	public String getId_nbd_kpi() {
		return ((String) getAttrVal("Id_nbd_kpi"));
	}	
	public void setId_nbd_kpi(String Id_nbd_kpi) {
		setAttrVal("Id_nbd_kpi", Id_nbd_kpi);
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
	public String getName_nbd_kpi() {
		return ((String) getAttrVal("Name_nbd_kpi"));
	}	
	public void setName_nbd_kpi(String Name_nbd_kpi) {
		setAttrVal("Name_nbd_kpi", Name_nbd_kpi);
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
		return "Id_nqm_task_kpi";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK_KPI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmTaskKpiDODesc.class);
	}
	
}