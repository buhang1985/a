package iih.bd.res.opt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.opt.d.desc.OptDepDODesc;
import java.math.BigDecimal;

/**
 * 手术台与科室关系 DO数据 
 * 
 */
public class OptDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPTDEP= "Id_optdep";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_OPT= "Id_opt";
	public static final String ID_DEP= "Id_dep";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_NAME= "Org_name";
	public static final String OPT_NAME= "Opt_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DEP_CODE= "Dep_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_optdep() {
		return ((String) getAttrVal("Id_optdep"));
	}	
	public void setId_optdep(String Id_optdep) {
		setAttrVal("Id_optdep", Id_optdep);
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
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}	
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getOpt_name() {
		return ((String) getAttrVal("Opt_name"));
	}	
	public void setOpt_name(String Opt_name) {
		setAttrVal("Opt_name", Opt_name);
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
		return "Id_optdep";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_opt_dep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OptDepDODesc.class);
	}
	
}