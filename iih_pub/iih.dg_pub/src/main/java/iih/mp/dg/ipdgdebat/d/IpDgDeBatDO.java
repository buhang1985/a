package iih.mp.dg.ipdgdebat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.ipdgdebat.d.desc.IpDgDeBatDODesc;
import java.math.BigDecimal;

/**
 * 住院药品批量发放 DO数据 
 * 
 */
public class IpDgDeBatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGIPDEBAT= "Id_dgipdebat";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_DGIPAP= "Code_dgipap";
	public static final String ID_DEP_AP= "Id_dep_ap";
	public static final String ID_DEP_WH= "Id_dep_wh";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_EMP_DP= "Id_emp_dp";
	public static final String DT_DP= "Dt_dp";
	public static final String EN_CHECK= "En_check";
	public static final String ID_EMP_CHECK= "Id_emp_check";
	public static final String DT_CHECK= "Dt_check";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgipdebat() {
		return ((String) getAttrVal("Id_dgipdebat"));
	}	
	public void setId_dgipdebat(String Id_dgipdebat) {
		setAttrVal("Id_dgipdebat", Id_dgipdebat);
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
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}	
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}	
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getId_emp_dp() {
		return ((String) getAttrVal("Id_emp_dp"));
	}	
	public void setId_emp_dp(String Id_emp_dp) {
		setAttrVal("Id_emp_dp", Id_emp_dp);
	}
	public FDateTime getDt_dp() {
		return ((FDateTime) getAttrVal("Dt_dp"));
	}	
	public void setDt_dp(FDateTime Dt_dp) {
		setAttrVal("Dt_dp", Dt_dp);
	}
	public Integer getEn_check() {
		return ((Integer) getAttrVal("En_check"));
	}	
	public void setEn_check(Integer En_check) {
		setAttrVal("En_check", En_check);
	}
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
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
		return "Id_dgipdebat";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_ip_debat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IpDgDeBatDODesc.class);
	}
	
}