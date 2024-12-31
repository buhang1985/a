package iih.mp.dg.opdginfu.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.opdginfu.d.desc.MpDgOpInfuDODesc;
import java.math.BigDecimal;

/**
 * 门诊输液登记表 DO数据 
 * 
 */
public class MpDgOpInfuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGINFU= "Id_dginfu";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String ID_OR= "Id_or";
	public static final String DT_MP_PLAN= "Dt_mp_plan";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ENT= "Id_ent";
	public static final String SORTNO= "Sortno";
	public static final String FG_SKINTEST= "Fg_skintest";
	public static final String SD_RST= "Sd_rst";
	public static final String ID_ORG_OR= "Id_org_or";
	public static final String ID_DEP_OR= "Id_dep_or";
	public static final String ID_EMP_OR= "Id_emp_or";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String SD_EXECTP= "Sd_exectp";
	public static final String DT_CREA= "Dt_crea";
	public static final String ID_EMP_CREA= "Id_emp_crea";
	public static final String EU_SU_MP= "Eu_su_mp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dginfu() {
		return ((String) getAttrVal("Id_dginfu"));
	}	
	public void setId_dginfu(String Id_dginfu) {
		setAttrVal("Id_dginfu", Id_dginfu);
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
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	public String getSd_rst() {
		return ((String) getAttrVal("Sd_rst"));
	}	
	public void setSd_rst(String Sd_rst) {
		setAttrVal("Sd_rst", Sd_rst);
	}
	public String getId_org_or() {
		return ((String) getAttrVal("Id_org_or"));
	}	
	public void setId_org_or(String Id_org_or) {
		setAttrVal("Id_org_or", Id_org_or);
	}
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}	
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public Integer getSd_exectp() {
		return ((Integer) getAttrVal("Sd_exectp"));
	}	
	public void setSd_exectp(Integer Sd_exectp) {
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
		return "Id_dginfu";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_infu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpDgOpInfuDODesc.class);
	}
	
}