package iih.bd.srv.maintenancelog.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.maintenancelog.d.desc.MainTenanceLogDODesc;
import java.math.BigDecimal;

/**
 * 运维工具—管理日志 DO数据 
 * 
 */
public class MainTenanceLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BD_MTI_LOG= "Id_bd_mti_log";
	public static final String ID_BA_MTI= "Id_bd_mti";
	public static final String DT_OP= "Dt_op";
	public static final String ID_EMP_USE= "Id_emp_use";
	public static final String EMP_ACTIVE= "Emp_active";
	public static final String CODE_MTI= "Code_mti";
	public static final String NAME_MTI= "Name_mti";
	public static final String NAME_TYPE= "Name_type";
	public static final String NAME_DLL= "Name_dll";
	public static final String NAME_CLASS= "Name_class";
	public static final String NAME_PA= "Name_pa";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_bd_mti_log() {
		return ((String) getAttrVal("Id_bd_mti_log"));
	}	
	public void setId_bd_mti_log(String Id_bd_mti_log) {
		setAttrVal("Id_bd_mti_log", Id_bd_mti_log);
	}
	public String getId_bd_mti() {
		return ((String) getAttrVal("Id_bd_mti"));
	}	
	public void setId_bd_mti(String Id_bd_mti) {
		setAttrVal("Id_bd_mti", Id_bd_mti);
	}
	public FDateTime getDt_op() {
		return ((FDateTime) getAttrVal("Dt_op"));
	}	
	public void setDt_op(FDateTime Dt_op) {
		setAttrVal("Dt_op", Dt_op);
	}
	public String getId_emp_use() {
		return ((String) getAttrVal("Id_emp_use"));
	}	
	public void setId_emp_use(String Id_emp_use) {
		setAttrVal("Id_emp_use", Id_emp_use);
	}
	public String getEmp_active() {
		return ((String) getAttrVal("Emp_active"));
	}	
	public void setEmp_active(String Emp_active) {
		setAttrVal("Emp_active", Emp_active);
	}
	public String getCode_mti() {
		return ((String) getAttrVal("Code_mti"));
	}	
	public void setCode_mti(String Code_mti) {
		setAttrVal("Code_mti", Code_mti);
	}
	public String getName_mti() {
		return ((String) getAttrVal("Name_mti"));
	}	
	public void setName_mti(String Name_mti) {
		setAttrVal("Name_mti", Name_mti);
	}
	public String getName_type() {
		return ((String) getAttrVal("Name_type"));
	}	
	public void setName_type(String Name_type) {
		setAttrVal("Name_type", Name_type);
	}
	public String getName_dll() {
		return ((String) getAttrVal("Name_dll"));
	}	
	public void setName_dll(String Name_dll) {
		setAttrVal("Name_dll", Name_dll);
	}
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}	
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	public String getName_pa() {
		return ((String) getAttrVal("Name_pa"));
	}	
	public void setName_pa(String Name_pa) {
		setAttrVal("Name_pa", Name_pa);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
		return "Id_bd_mti_log";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mti_log";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MainTenanceLogDODesc.class);
	}
	
}