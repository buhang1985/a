package iih.bd.srv.maintenanceexeclog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.maintenanceexeclog.d.desc.MainTenanceExecLogDODesc;
import java.math.BigDecimal;

/**
 * 运维工具-运行日志 DO数据 
 * 
 */
public class MainTenanceExecLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BD_MTI_EXE_LOG= "Id_bd_mti_exe_log";
	public static final String ID_BD_MTI= "Id_bd_mti";
	public static final String DT_EXEC= "Dt_exec";
	public static final String ID_EXEC_USE= "Id_exec_use";
	public static final String RESULT_EXEC= "Result_exec";
	public static final String FILE_LOG= "File_log";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bd_mti_exe_log() {
		return ((String) getAttrVal("Id_bd_mti_exe_log"));
	}	
	public void setId_bd_mti_exe_log(String Id_bd_mti_exe_log) {
		setAttrVal("Id_bd_mti_exe_log", Id_bd_mti_exe_log);
	}
	public String getId_bd_mti() {
		return ((String) getAttrVal("Id_bd_mti"));
	}	
	public void setId_bd_mti(String Id_bd_mti) {
		setAttrVal("Id_bd_mti", Id_bd_mti);
	}
	public FDateTime getDt_exec() {
		return ((FDateTime) getAttrVal("Dt_exec"));
	}	
	public void setDt_exec(FDateTime Dt_exec) {
		setAttrVal("Dt_exec", Dt_exec);
	}
	public String getId_exec_use() {
		return ((String) getAttrVal("Id_exec_use"));
	}	
	public void setId_exec_use(String Id_exec_use) {
		setAttrVal("Id_exec_use", Id_exec_use);
	}
	public String getResult_exec() {
		return ((String) getAttrVal("Result_exec"));
	}	
	public void setResult_exec(String Result_exec) {
		setAttrVal("Result_exec", Result_exec);
	}
	public String getFile_log() {
		return ((String) getAttrVal("File_log"));
	}	
	public void setFile_log(String File_log) {
		setAttrVal("File_log", File_log);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
		return "Id_bd_mti_exe_log";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mti_exec_log";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MainTenanceExecLogDODesc.class);
	}
	
}