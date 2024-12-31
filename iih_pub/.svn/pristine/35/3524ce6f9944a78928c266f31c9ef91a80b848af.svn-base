package iih.sc.apt.aptoptemp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.aptoptemp.d.desc.ScAptOptEmpDODesc;
import java.math.BigDecimal;

/**
 * 手术人员 DO数据 
 * 
 */
public class ScAptOptEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTOPTEMP= "Id_aptoptemp";
	public static final String ID_APT= "Id_apt";
	public static final String ID_APTAPPL= "Id_aptappl";
	public static final String ID_ROLE= "Id_role";
	public static final String SD_ROLE= "Sd_role";
	public static final String ID_EMP= "Id_emp";
	public static final String NAME_ROLE= "Name_role";
	public static final String CODE_EMP= "Code_emp";
	public static final String NAME_EMP= "Name_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptoptemp() {
		return ((String) getAttrVal("Id_aptoptemp"));
	}	
	public void setId_aptoptemp(String Id_aptoptemp) {
		setAttrVal("Id_aptoptemp", Id_aptoptemp);
	}
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public String getId_aptappl() {
		return ((String) getAttrVal("Id_aptappl"));
	}	
	public void setId_aptappl(String Id_aptappl) {
		setAttrVal("Id_aptappl", Id_aptappl);
	}
	public String getId_role() {
		return ((String) getAttrVal("Id_role"));
	}	
	public void setId_role(String Id_role) {
		setAttrVal("Id_role", Id_role);
	}
	public String getSd_role() {
		return ((String) getAttrVal("Sd_role"));
	}	
	public void setSd_role(String Sd_role) {
		setAttrVal("Sd_role", Sd_role);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getName_role() {
		return ((String) getAttrVal("Name_role"));
	}	
	public void setName_role(String Name_role) {
		setAttrVal("Name_role", Name_role);
	}
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}	
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
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
		return "Id_aptoptemp";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_opt_emp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptOptEmpDODesc.class);
	}
	
}