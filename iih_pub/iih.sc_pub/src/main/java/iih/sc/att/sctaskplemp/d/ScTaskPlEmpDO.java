package iih.sc.att.sctaskplemp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.att.sctaskplemp.d.desc.ScTaskPlEmpDODesc;
import java.math.BigDecimal;

/**
 * 考勤计划人员 DO数据 
 * 
 */
public class ScTaskPlEmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TASKPLEMP= "Id_taskplemp";
	public static final String ID_TASKPL= "Id_taskpl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String D_B= "D_b";
	public static final String D_E= "D_e";
	public static final String EU_SIGNTP= "Eu_signtp";
	public static final String CARDID= "Cardid";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_DATESLOTCA= "Id_dateslotca";
	public static final String NAME_EMP= "Name_emp";
	public static final String CODE_EMP= "Code_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_taskplemp() {
		return ((String) getAttrVal("Id_taskplemp"));
	}	
	public void setId_taskplemp(String Id_taskplemp) {
		setAttrVal("Id_taskplemp", Id_taskplemp);
	}
	public String getId_taskpl() {
		return ((String) getAttrVal("Id_taskpl"));
	}	
	public void setId_taskpl(String Id_taskpl) {
		setAttrVal("Id_taskpl", Id_taskpl);
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
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
	public Integer getEu_signtp() {
		return ((Integer) getAttrVal("Eu_signtp"));
	}	
	public void setEu_signtp(Integer Eu_signtp) {
		setAttrVal("Eu_signtp", Eu_signtp);
	}
	public String getCardid() {
		return ((String) getAttrVal("Cardid"));
	}	
	public void setCardid(String Cardid) {
		setAttrVal("Cardid", Cardid);
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
	public String getId_dateslotca() {
		return ((String) getAttrVal("Id_dateslotca"));
	}	
	public void setId_dateslotca(String Id_dateslotca) {
		setAttrVal("Id_dateslotca", Id_dateslotca);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}	
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
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
		return "Id_taskplemp";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_task_pl_emp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScTaskPlEmpDODesc.class);
	}
	
}