package iih.ci.mrqc.cimroverapply.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrqc.cimroverapply.d.desc.CiMrOverApplyDODesc;
import java.math.BigDecimal;

/**
 * 病历超时申请 DO数据 
 * 
 */
public class CiMrOverApplyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CI_MR_OA= "Id_ci_mr_oa";
	public static final String ID_MRTASK= "Id_mrtask";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_EMP_OA= "Id_emp_oa";
	public static final String DT_OA= "Dt_oa";
	public static final String REASON= "Reason";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String OVERTIME= "Overtime";
	public static final String NORMALTIME= "Normaltime";
	public static final String ID_EMP_SUB= "Id_emp_sub";
	public static final String DT_SUB= "Dt_sub";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String EMP_OA_NAME= "Emp_oa_name";
	public static final String EMP_OA_CODE= "Emp_oa_code";
	public static final String EMP_SUB_NAME= "Emp_sub_name";
	public static final String EMP_SUB_CODE= "Emp_sub_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ci_mr_oa() {
		return ((String) getAttrVal("Id_ci_mr_oa"));
	}	
	public void setId_ci_mr_oa(String Id_ci_mr_oa) {
		setAttrVal("Id_ci_mr_oa", Id_ci_mr_oa);
	}
	public String getId_mrtask() {
		return ((String) getAttrVal("Id_mrtask"));
	}	
	public void setId_mrtask(String Id_mrtask) {
		setAttrVal("Id_mrtask", Id_mrtask);
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
	public String getId_emp_oa() {
		return ((String) getAttrVal("Id_emp_oa"));
	}	
	public void setId_emp_oa(String Id_emp_oa) {
		setAttrVal("Id_emp_oa", Id_emp_oa);
	}
	public FDateTime getDt_oa() {
		return ((FDateTime) getAttrVal("Dt_oa"));
	}	
	public void setDt_oa(FDateTime Dt_oa) {
		setAttrVal("Dt_oa", Dt_oa);
	}
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}	
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public String getOvertime() {
		return ((String) getAttrVal("Overtime"));
	}	
	public void setOvertime(String Overtime) {
		setAttrVal("Overtime", Overtime);
	}
	public String getNormaltime() {
		return ((String) getAttrVal("Normaltime"));
	}	
	public void setNormaltime(String Normaltime) {
		setAttrVal("Normaltime", Normaltime);
	}
	public String getId_emp_sub() {
		return ((String) getAttrVal("Id_emp_sub"));
	}	
	public void setId_emp_sub(String Id_emp_sub) {
		setAttrVal("Id_emp_sub", Id_emp_sub);
	}
	public FDateTime getDt_sub() {
		return ((FDateTime) getAttrVal("Dt_sub"));
	}	
	public void setDt_sub(FDateTime Dt_sub) {
		setAttrVal("Dt_sub", Dt_sub);
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
	public String getEmp_oa_name() {
		return ((String) getAttrVal("Emp_oa_name"));
	}	
	public void setEmp_oa_name(String Emp_oa_name) {
		setAttrVal("Emp_oa_name", Emp_oa_name);
	}
	public String getEmp_oa_code() {
		return ((String) getAttrVal("Emp_oa_code"));
	}	
	public void setEmp_oa_code(String Emp_oa_code) {
		setAttrVal("Emp_oa_code", Emp_oa_code);
	}
	public String getEmp_sub_name() {
		return ((String) getAttrVal("Emp_sub_name"));
	}	
	public void setEmp_sub_name(String Emp_sub_name) {
		setAttrVal("Emp_sub_name", Emp_sub_name);
	}
	public String getEmp_sub_code() {
		return ((String) getAttrVal("Emp_sub_code"));
	}	
	public void setEmp_sub_code(String Emp_sub_code) {
		setAttrVal("Emp_sub_code", Emp_sub_code);
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
		return "Id_ci_mr_oa";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_oa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrOverApplyDODesc.class);
	}
	
}