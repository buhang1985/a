package iih.nm.nqm.nqmimprovkpi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmimprovkpi.d.desc.NqmImprovKpiItmDODesc;
import java.math.BigDecimal;

/**
 * 存在问题明细 DO数据 
 * 
 */
public class NqmImprovKpiItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_IMPROV_KPI_ITM= "Id_nqm_improv_kpi_itm";
	public static final String ID_NQM_IMPROV_KPI= "Id_nqm_improv_kpi";
	public static final String ID_QUES= "Id_ques";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_improv_kpi_itm() {
		return ((String) getAttrVal("Id_nqm_improv_kpi_itm"));
	}	
	public void setId_nqm_improv_kpi_itm(String Id_nqm_improv_kpi_itm) {
		setAttrVal("Id_nqm_improv_kpi_itm", Id_nqm_improv_kpi_itm);
	}
	public String getId_nqm_improv_kpi() {
		return ((String) getAttrVal("Id_nqm_improv_kpi"));
	}	
	public void setId_nqm_improv_kpi(String Id_nqm_improv_kpi) {
		setAttrVal("Id_nqm_improv_kpi", Id_nqm_improv_kpi);
	}
	public String getId_ques() {
		return ((String) getAttrVal("Id_ques"));
	}	
	public void setId_ques(String Id_ques) {
		setAttrVal("Id_ques", Id_ques);
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
		return "Id_nqm_improv_kpi_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_IMPROV_KPI_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmImprovKpiItmDODesc.class);
	}
	
}