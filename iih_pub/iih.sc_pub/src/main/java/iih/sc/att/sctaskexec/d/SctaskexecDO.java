package iih.sc.att.sctaskexec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.att.sctaskexec.d.desc.SctaskexecDODesc;
import java.math.BigDecimal;

/**
 * 考勤执行 DO数据 
 * 
 */
public class SctaskexecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TASKEXEC= "Id_taskexec";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_DEPT= "Id_dept";
	public static final String ID_PERIOD= "Id_period";
	public static final String ID_TASKPL= "Id_taskpl";
	public static final String D_B= "D_b";
	public static final String D_E= "D_e";
	public static final String ID_EMP_CREATOR= "Id_emp_creator";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_EMP_CHK= "Id_emp_chk";
	public static final String DT_CHK= "Dt_chk";
	public static final String EU_TASK_STATUS= "Eu_task_status";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ORG= "Name_org";
	public static final String CODE_ORG= "Code_org";
	public static final String NAME_DEPT= "Name_dept";
	public static final String D_PERIOD_B= "D_period_b";
	public static final String D_PERIOD_E= "D_period_e";
	public static final String NAME_PERIOD= "Name_period";
	public static final String NAME_TASKPL= "Name_taskpl";
	public static final String NAME_EMP_CREATE= "Name_emp_create";
	public static final String NAME_EMP_CHK= "Name_emp_chk";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_taskexec() {
		return ((String) getAttrVal("Id_taskexec"));
	}	
	public void setId_taskexec(String Id_taskexec) {
		setAttrVal("Id_taskexec", Id_taskexec);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	public String getId_period() {
		return ((String) getAttrVal("Id_period"));
	}	
	public void setId_period(String Id_period) {
		setAttrVal("Id_period", Id_period);
	}
	public String getId_taskpl() {
		return ((String) getAttrVal("Id_taskpl"));
	}	
	public void setId_taskpl(String Id_taskpl) {
		setAttrVal("Id_taskpl", Id_taskpl);
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
	public String getId_emp_creator() {
		return ((String) getAttrVal("Id_emp_creator"));
	}	
	public void setId_emp_creator(String Id_emp_creator) {
		setAttrVal("Id_emp_creator", Id_emp_creator);
	}
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	public String getId_emp_chk() {
		return ((String) getAttrVal("Id_emp_chk"));
	}	
	public void setId_emp_chk(String Id_emp_chk) {
		setAttrVal("Id_emp_chk", Id_emp_chk);
	}
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	public Integer getEu_task_status() {
		return ((Integer) getAttrVal("Eu_task_status"));
	}	
	public void setEu_task_status(Integer Eu_task_status) {
		setAttrVal("Eu_task_status", Eu_task_status);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public FDate getD_period_b() {
		return ((FDate) getAttrVal("D_period_b"));
	}	
	public void setD_period_b(FDate D_period_b) {
		setAttrVal("D_period_b", D_period_b);
	}
	public FDate getD_period_e() {
		return ((FDate) getAttrVal("D_period_e"));
	}	
	public void setD_period_e(FDate D_period_e) {
		setAttrVal("D_period_e", D_period_e);
	}
	public String getName_period() {
		return ((String) getAttrVal("Name_period"));
	}	
	public void setName_period(String Name_period) {
		setAttrVal("Name_period", Name_period);
	}
	public String getName_taskpl() {
		return ((String) getAttrVal("Name_taskpl"));
	}	
	public void setName_taskpl(String Name_taskpl) {
		setAttrVal("Name_taskpl", Name_taskpl);
	}
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}	
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	public String getName_emp_chk() {
		return ((String) getAttrVal("Name_emp_chk"));
	}	
	public void setName_emp_chk(String Name_emp_chk) {
		setAttrVal("Name_emp_chk", Name_emp_chk);
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
		return "Id_taskexec";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_task_exec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SctaskexecDODesc.class);
	}
	
}