package iih.mp.orm.surgappconfirm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.orm.surgappconfirm.d.desc.SurgAppEmpConfDODesc;
import java.math.BigDecimal;

/**
 * 手术申请单人员安排确认 DO数据 
 * 
 */
public class SurgAppEmpConfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOPEMPCF= "Id_apopempcf";
	public static final String ID_APOPCF= "Id_apopcf";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_ROLE= "Id_role";
	public static final String NO_SORT= "No_sort";
	public static final String LONG_WKOT= "Long_wkot";
	public static final String EMP_CODE= "Emp_code";
	public static final String EMP_NAME= "Emp_name";
	public static final String ROLE_CODE= "Role_code";
	public static final String ROLE_NAME= "Role_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apopempcf() {
		return ((String) getAttrVal("Id_apopempcf"));
	}	
	public void setId_apopempcf(String Id_apopempcf) {
		setAttrVal("Id_apopempcf", Id_apopempcf);
	}
	public String getId_apopcf() {
		return ((String) getAttrVal("Id_apopcf"));
	}	
	public void setId_apopcf(String Id_apopcf) {
		setAttrVal("Id_apopcf", Id_apopcf);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_role() {
		return ((String) getAttrVal("Id_role"));
	}	
	public void setId_role(String Id_role) {
		setAttrVal("Id_role", Id_role);
	}
	public Integer getNo_sort() {
		return ((Integer) getAttrVal("No_sort"));
	}	
	public void setNo_sort(Integer No_sort) {
		setAttrVal("No_sort", No_sort);
	}
	public Integer getLong_wkot() {
		return ((Integer) getAttrVal("Long_wkot"));
	}	
	public void setLong_wkot(Integer Long_wkot) {
		setAttrVal("Long_wkot", Long_wkot);
	}
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	public String getRole_code() {
		return ((String) getAttrVal("Role_code"));
	}	
	public void setRole_code(String Role_code) {
		setAttrVal("Role_code", Role_code);
	}
	public String getRole_name() {
		return ((String) getAttrVal("Role_name"));
	}	
	public void setRole_name(String Role_name) {
		setAttrVal("Role_name", Role_name);
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
		return "Id_apopempcf";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_orm_sug_emp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SurgAppEmpConfDODesc.class);
	}
	
}