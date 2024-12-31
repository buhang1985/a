package iih.mp.dg.manuprep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.manuprep.d.desc.MpDgPrepDODesc;
import java.math.BigDecimal;

/**
 * 药品_门诊摆药单 DO数据 
 * 
 */
public class MpDgPrepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGOPDISP= "Id_dgopdisp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_ENT= "Id_ent";
	public static final String SD_PRESTP= "Sd_prestp";
	public static final String ID_PRES= "Id_pres";
	public static final String CODE_PRES= "Code_pres";
	public static final String NAME_PRES= "Name_pres";
	public static final String FG_PRIN= "Fg_prin";
	public static final String DT_PRIN= "Dt_prin";
	public static final String ID_EMP_PRIN= "Id_emp_prin";
	public static final String EN_DISP= "En_disp";
	public static final String DT_DISP= "Dt_disp";
	public static final String ID_EMP_DISP= "Id_emp_disp";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgopdisp() {
		return ((String) getAttrVal("Id_dgopdisp"));
	}	
	public void setId_dgopdisp(String Id_dgopdisp) {
		setAttrVal("Id_dgopdisp", Id_dgopdisp);
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
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}	
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}	
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
	}
	public String getName_pres() {
		return ((String) getAttrVal("Name_pres"));
	}	
	public void setName_pres(String Name_pres) {
		setAttrVal("Name_pres", Name_pres);
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
	public String getId_emp_prin() {
		return ((String) getAttrVal("Id_emp_prin"));
	}	
	public void setId_emp_prin(String Id_emp_prin) {
		setAttrVal("Id_emp_prin", Id_emp_prin);
	}
	public Integer getEn_disp() {
		return ((Integer) getAttrVal("En_disp"));
	}	
	public void setEn_disp(Integer En_disp) {
		setAttrVal("En_disp", En_disp);
	}
	public FDateTime getDt_disp() {
		return ((FDateTime) getAttrVal("Dt_disp"));
	}	
	public void setDt_disp(FDateTime Dt_disp) {
		setAttrVal("Dt_disp", Dt_disp);
	}
	public String getId_emp_disp() {
		return ((String) getAttrVal("Id_emp_disp"));
	}	
	public void setId_emp_disp(String Id_emp_disp) {
		setAttrVal("Id_emp_disp", Id_emp_disp);
	}
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
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
		return "Id_dgopdisp";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_DG_OPDISP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpDgPrepDODesc.class);
	}
	
}