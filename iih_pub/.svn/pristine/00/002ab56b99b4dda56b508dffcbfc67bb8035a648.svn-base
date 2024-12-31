package iih.bd.res.empdep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.empdep.d.desc.EmpDepDODesc;
import java.math.BigDecimal;

/**
 * 科室员工关系 DO数据 
 * 
 */
public class EmpDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_EMPDEP= "Id_empdep";
	public static final String ID_EMP= "Id_emp";
	public static final String SORTNO= "Sortno";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMPDUTY= "Id_empduty";
	public static final String D_B= "D_b";
	public static final String D_E= "D_e";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_EMP= "Code_emp";
	public static final String NAME_EMP= "Name_emp";
	public static final String CODE_DEPT= "Code_dept";
	public static final String NAME_DEPT= "Name_dept";
	public static final String CODE_JOBTYPE= "Code_jobtype";
	public static final String NAME_JOBTYPE= "Name_jobtype";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_empdep() {
		return ((String) getAttrVal("Id_empdep"));
	}	
	public void setId_empdep(String Id_empdep) {
		setAttrVal("Id_empdep", Id_empdep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_empduty() {
		return ((String) getAttrVal("Id_empduty"));
	}	
	public void setId_empduty(String Id_empduty) {
		setAttrVal("Id_empduty", Id_empduty);
	}
	public FDate getD_b() {
		return ((FDate) getAttrVal("D_b"));
	}	
	public void setD_b(FDate D_b) {
		setAttrVal("D_b", D_b);
	}
	public FDate getD_e() {
		return ((FDate) getAttrVal("D_e"));
	}	
	public void setD_e(FDate D_e) {
		setAttrVal("D_e", D_e);
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
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getCode_jobtype() {
		return ((String) getAttrVal("Code_jobtype"));
	}	
	public void setCode_jobtype(String Code_jobtype) {
		setAttrVal("Code_jobtype", Code_jobtype);
	}
	public String getName_jobtype() {
		return ((String) getAttrVal("Name_jobtype"));
	}	
	public void setName_jobtype(String Name_jobtype) {
		setAttrVal("Name_jobtype", Name_jobtype);
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
		return "Id_empdep";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_EMP_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmpDepDODesc.class);
	}
	
}