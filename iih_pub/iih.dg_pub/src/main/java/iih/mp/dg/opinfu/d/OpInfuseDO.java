package iih.mp.dg.opinfu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opinfu.d.desc.OpInfuseDODesc;
import java.math.BigDecimal;

/**
 * 门诊输液执行主表 DO数据 
 * 
 */
public class OpInfuseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGOEPINFU= "Id_dgoepinfu";
	public static final String ID_DGOEPDT= "Id_dgoepdt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DAY_PRES= "Day_pres";
	public static final String EXEC_ALL= "Exec_all";
	public static final String SU_REM= "Su_rem";
	public static final String FG_SELF= "Fg_self";
	public static final String ID_ORG_MP= "Id_org_mp";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_EXECTP= "Id_exectp";
	public static final String SD_EXECTP= "Sd_exectp";
	public static final String DT_CREA= "Dt_crea";
	public static final String ID_EMP_CREA= "Id_emp_crea";
	public static final String EU_SU_MP= "Eu_su_mp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgoepinfu() {
		return ((String) getAttrVal("Id_dgoepinfu"));
	}	
	public void setId_dgoepinfu(String Id_dgoepinfu) {
		setAttrVal("Id_dgoepinfu", Id_dgoepinfu);
	}
	public String getId_dgoepdt() {
		return ((String) getAttrVal("Id_dgoepdt"));
	}	
	public void setId_dgoepdt(String Id_dgoepdt) {
		setAttrVal("Id_dgoepdt", Id_dgoepdt);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public Integer getDay_pres() {
		return ((Integer) getAttrVal("Day_pres"));
	}	
	public void setDay_pres(Integer Day_pres) {
		setAttrVal("Day_pres", Day_pres);
	}
	public Integer getExec_all() {
		return ((Integer) getAttrVal("Exec_all"));
	}	
	public void setExec_all(Integer Exec_all) {
		setAttrVal("Exec_all", Exec_all);
	}
	public Integer getSu_rem() {
		return ((Integer) getAttrVal("Su_rem"));
	}	
	public void setSu_rem(Integer Su_rem) {
		setAttrVal("Su_rem", Su_rem);
	}
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getId_exectp() {
		return ((String) getAttrVal("Id_exectp"));
	}	
	public void setId_exectp(String Id_exectp) {
		setAttrVal("Id_exectp", Id_exectp);
	}
	public String getSd_exectp() {
		return ((String) getAttrVal("Sd_exectp"));
	}	
	public void setSd_exectp(String Sd_exectp) {
		setAttrVal("Sd_exectp", Sd_exectp);
	}
	public FDateTime getDt_crea() {
		return ((FDateTime) getAttrVal("Dt_crea"));
	}	
	public void setDt_crea(FDateTime Dt_crea) {
		setAttrVal("Dt_crea", Dt_crea);
	}
	public String getId_emp_crea() {
		return ((String) getAttrVal("Id_emp_crea"));
	}	
	public void setId_emp_crea(String Id_emp_crea) {
		setAttrVal("Id_emp_crea", Id_emp_crea);
	}
	public Integer getEu_su_mp() {
		return ((Integer) getAttrVal("Eu_su_mp"));
	}	
	public void setEu_su_mp(Integer Eu_su_mp) {
		setAttrVal("Eu_su_mp", Eu_su_mp);
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
		return "Id_dgoepinfu";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_oep_infu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OpInfuseDODesc.class);
	}
	
}