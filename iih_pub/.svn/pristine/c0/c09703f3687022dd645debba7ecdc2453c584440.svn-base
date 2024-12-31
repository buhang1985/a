package iih.pis.phk.phkemp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.phk.phkemp.d.desc.PhkEmpDODesc;
import java.math.BigDecimal;

/**
 * 患者管家人员信息 DO数据 
 * 
 */
public class PhkEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PHKEMP= "Id_phkemp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_EMP= "Id_emp";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DT_ACTIVE= "Dt_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String EMP_CODE= "Emp_code";
	public static final String EMP_NAME= "Emp_name";
	public static final String EMP_ID= "Emp_id";
	public static final String BIRTHDAY= "Birthday";
	public static final String MOBILE= "Mobile";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_phkemp() {
		return ((String) getAttrVal("Id_phkemp"));
	}	
	public void setId_phkemp(String Id_phkemp) {
		setAttrVal("Id_phkemp", Id_phkemp);
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
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FDateTime getDt_active() {
		return ((FDateTime) getAttrVal("Dt_active"));
	}	
	public void setDt_active(FDateTime Dt_active) {
		setAttrVal("Dt_active", Dt_active);
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
	public String getEmp_id() {
		return ((String) getAttrVal("Emp_id"));
	}	
	public void setEmp_id(String Emp_id) {
		setAttrVal("Emp_id", Emp_id);
	}
	public FDate getBirthday() {
		return ((FDate) getAttrVal("Birthday"));
	}	
	public void setBirthday(FDate Birthday) {
		setAttrVal("Birthday", Birthday);
	}
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}	
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
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
		return "Id_phkemp";
	}
	
	@Override
	public String getTableName() {	  
		return "PIS_PHK_EMP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PhkEmpDODesc.class);
	}
	
}