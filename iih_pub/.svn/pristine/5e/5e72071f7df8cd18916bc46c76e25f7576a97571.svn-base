package iih.nm.nhr.nmoptpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmoptpl.d.desc.NmOptPlDepDODesc;
import java.math.BigDecimal;

/**
 * 实习计划_轮转科室 DO数据 
 * 
 */
public class NmOptPlDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPT_PL_DEP= "Id_opt_pl_dep";
	public static final String ID_OPT_PL= "Id_opt_pl";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String PL_NAME= "Pl_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opt_pl_dep() {
		return ((String) getAttrVal("Id_opt_pl_dep"));
	}	
	public void setId_opt_pl_dep(String Id_opt_pl_dep) {
		setAttrVal("Id_opt_pl_dep", Id_opt_pl_dep);
	}
	public String getId_opt_pl() {
		return ((String) getAttrVal("Id_opt_pl"));
	}	
	public void setId_opt_pl(String Id_opt_pl) {
		setAttrVal("Id_opt_pl", Id_opt_pl);
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
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getPl_name() {
		return ((String) getAttrVal("Pl_name"));
	}	
	public void setPl_name(String Pl_name) {
		setAttrVal("Pl_name", Pl_name);
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
		return "Id_opt_pl_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_OPT_PL_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmOptPlDepDODesc.class);
	}
	
}