package iih.bl.inc.blcpnin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blcpnin.d.desc.BlCpnDODesc;
import java.math.BigDecimal;

/**
 * 优惠卷 DO数据 
 * 
 */
public class BlCpnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CPN= "Id_cpn";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_CPNCA= "Id_cpnca";
	public static final String CODE= "Code";
	public static final String ID_CPNIN= "Id_cpnin";
	public static final String FG_ISS= "Fg_iss";
	public static final String DT_ISS= "Dt_iss";
	public static final String ID_EMP_ISS= "Id_emp_iss";
	public static final String ID_PAT_OWN= "Id_pat_own";
	public static final String FG_USED= "Fg_used";
	public static final String CODE_ORG= "Code_org";
	public static final String NAME_ORG= "Name_org";
	public static final String CODE_CPNCA= "Code_cpnca";
	public static final String NAME_CPNCA= "Name_cpnca";
	public static final String EU_CPNTP= "Eu_cpntp";
	public static final String CODERULE_CPN= "Coderule_cpn";
	public static final String CODE_CPNIN= "Code_cpnin";
	public static final String CODE_EMP_ISS= "Code_emp_iss";
	public static final String NAME_EMP_ISS= "Name_emp_iss";
	public static final String NAME_PAT_OWN= "Name_pat_own";
	public static final String CODE_PAT_OWN= "Code_pat_own";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cpn() {
		return ((String) getAttrVal("Id_cpn"));
	}	
	public void setId_cpn(String Id_cpn) {
		setAttrVal("Id_cpn", Id_cpn);
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
	public String getId_cpnca() {
		return ((String) getAttrVal("Id_cpnca"));
	}	
	public void setId_cpnca(String Id_cpnca) {
		setAttrVal("Id_cpnca", Id_cpnca);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_cpnin() {
		return ((String) getAttrVal("Id_cpnin"));
	}	
	public void setId_cpnin(String Id_cpnin) {
		setAttrVal("Id_cpnin", Id_cpnin);
	}
	public FBoolean getFg_iss() {
		return ((FBoolean) getAttrVal("Fg_iss"));
	}	
	public void setFg_iss(FBoolean Fg_iss) {
		setAttrVal("Fg_iss", Fg_iss);
	}
	public FDateTime getDt_iss() {
		return ((FDateTime) getAttrVal("Dt_iss"));
	}	
	public void setDt_iss(FDateTime Dt_iss) {
		setAttrVal("Dt_iss", Dt_iss);
	}
	public String getId_emp_iss() {
		return ((String) getAttrVal("Id_emp_iss"));
	}	
	public void setId_emp_iss(String Id_emp_iss) {
		setAttrVal("Id_emp_iss", Id_emp_iss);
	}
	public String getId_pat_own() {
		return ((String) getAttrVal("Id_pat_own"));
	}	
	public void setId_pat_own(String Id_pat_own) {
		setAttrVal("Id_pat_own", Id_pat_own);
	}
	public FBoolean getFg_used() {
		return ((FBoolean) getAttrVal("Fg_used"));
	}	
	public void setFg_used(FBoolean Fg_used) {
		setAttrVal("Fg_used", Fg_used);
	}
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getCode_cpnca() {
		return ((String) getAttrVal("Code_cpnca"));
	}	
	public void setCode_cpnca(String Code_cpnca) {
		setAttrVal("Code_cpnca", Code_cpnca);
	}
	public String getName_cpnca() {
		return ((String) getAttrVal("Name_cpnca"));
	}	
	public void setName_cpnca(String Name_cpnca) {
		setAttrVal("Name_cpnca", Name_cpnca);
	}
	public Integer getEu_cpntp() {
		return ((Integer) getAttrVal("Eu_cpntp"));
	}	
	public void setEu_cpntp(Integer Eu_cpntp) {
		setAttrVal("Eu_cpntp", Eu_cpntp);
	}
	public String getCoderule_cpn() {
		return ((String) getAttrVal("Coderule_cpn"));
	}	
	public void setCoderule_cpn(String Coderule_cpn) {
		setAttrVal("Coderule_cpn", Coderule_cpn);
	}
	public String getCode_cpnin() {
		return ((String) getAttrVal("Code_cpnin"));
	}	
	public void setCode_cpnin(String Code_cpnin) {
		setAttrVal("Code_cpnin", Code_cpnin);
	}
	public String getCode_emp_iss() {
		return ((String) getAttrVal("Code_emp_iss"));
	}	
	public void setCode_emp_iss(String Code_emp_iss) {
		setAttrVal("Code_emp_iss", Code_emp_iss);
	}
	public String getName_emp_iss() {
		return ((String) getAttrVal("Name_emp_iss"));
	}	
	public void setName_emp_iss(String Name_emp_iss) {
		setAttrVal("Name_emp_iss", Name_emp_iss);
	}
	public String getName_pat_own() {
		return ((String) getAttrVal("Name_pat_own"));
	}	
	public void setName_pat_own(String Name_pat_own) {
		setAttrVal("Name_pat_own", Name_pat_own);
	}
	public String getCode_pat_own() {
		return ((String) getAttrVal("Code_pat_own"));
	}	
	public void setCode_pat_own(String Code_pat_own) {
		setAttrVal("Code_pat_own", Code_pat_own);
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
		return "Id_cpn";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_cpn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlCpnDODesc.class);
	}
	
}