package iih.mp.dg.oepmanu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.oepmanu.d.desc.OepManuPrepDODesc;
import java.math.BigDecimal;

/**
 * 手工预摆药实体 DO数据 
 * 
 */
public class OepManuPrepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGOEPMANUPREP= "Id_dgoepmanuprep";
	public static final String ID_DGOEPDT= "Id_dgoepdt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DT_INSE= "Dt_inse";
	public static final String ID_EMP_INSE= "Id_emp_inse";
	public static final String ID_QUESITE_PL= "Id_quesite_pl";
	public static final String FG_PRIN= "Fg_prin";
	public static final String DT_PRIN= "Dt_prin";
	public static final String FG_BY= "Fg_by";
	public static final String DT_FIN= "Dt_fin";
	public static final String ID_EMP_FIN= "Id_emp_fin";
	public static final String ID_EMP_PRIN= "Id_emp_prin";
	public static final String ID_EMP_DP= "Id_emp_dp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgoepmanuprep() {
		return ((String) getAttrVal("Id_dgoepmanuprep"));
	}	
	public void setId_dgoepmanuprep(String Id_dgoepmanuprep) {
		setAttrVal("Id_dgoepmanuprep", Id_dgoepmanuprep);
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
	public FDateTime getDt_inse() {
		return ((FDateTime) getAttrVal("Dt_inse"));
	}	
	public void setDt_inse(FDateTime Dt_inse) {
		setAttrVal("Dt_inse", Dt_inse);
	}
	public String getId_emp_inse() {
		return ((String) getAttrVal("Id_emp_inse"));
	}	
	public void setId_emp_inse(String Id_emp_inse) {
		setAttrVal("Id_emp_inse", Id_emp_inse);
	}
	public String getId_quesite_pl() {
		return ((String) getAttrVal("Id_quesite_pl"));
	}	
	public void setId_quesite_pl(String Id_quesite_pl) {
		setAttrVal("Id_quesite_pl", Id_quesite_pl);
	}
	public FBoolean getFg_prin() {
		return ((FBoolean) getAttrVal("Fg_prin"));
	}	
	public void setFg_prin(FBoolean Fg_prin) {
		setAttrVal("Fg_prin", Fg_prin);
	}
	public FDateTime getDt_prin() {
		return ((FDateTime) getAttrVal("Dt_prin"));
	}	
	public void setDt_prin(FDateTime Dt_prin) {
		setAttrVal("Dt_prin", Dt_prin);
	}
	public FBoolean getFg_by() {
		return ((FBoolean) getAttrVal("Fg_by"));
	}	
	public void setFg_by(FBoolean Fg_by) {
		setAttrVal("Fg_by", Fg_by);
	}
	public FDateTime getDt_fin() {
		return ((FDateTime) getAttrVal("Dt_fin"));
	}	
	public void setDt_fin(FDateTime Dt_fin) {
		setAttrVal("Dt_fin", Dt_fin);
	}
	public String getId_emp_fin() {
		return ((String) getAttrVal("Id_emp_fin"));
	}	
	public void setId_emp_fin(String Id_emp_fin) {
		setAttrVal("Id_emp_fin", Id_emp_fin);
	}
	public String getId_emp_prin() {
		return ((String) getAttrVal("Id_emp_prin"));
	}	
	public void setId_emp_prin(String Id_emp_prin) {
		setAttrVal("Id_emp_prin", Id_emp_prin);
	}
	public String getId_emp_dp() {
		return ((String) getAttrVal("Id_emp_dp"));
	}	
	public void setId_emp_dp(String Id_emp_dp) {
		setAttrVal("Id_emp_dp", Id_emp_dp);
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
		return "Id_dgoepmanuprep";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_oep_manu_prep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OepManuPrepDODesc.class);
	}
	
}