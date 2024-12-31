package iih.bd.srv.nurcustomcaown.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.nurcustomcaown.d.desc.NuOwnDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录_护理文书所属 DO数据 
 * 
 */
public class NuOwnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_NU_OWN= "Id_mr_nu_own";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_OWETP= "Id_owetp";
	public static final String SD_OWETP= "Sd_owetp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CREATEDTIME= "Createdtime";
	public static final String NAME_OWETP= "Name_owetp";
	public static final String CODE_OWETP= "Code_owetp";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_EMP= "Name_emp";
	public static final String CODE_EMP= "Code_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public NuOwnDO () {
		super();
	}
	
	public String getId_mr_nu_own() {
		return ((String) getAttrVal("Id_mr_nu_own"));
	}	
	public void setId_mr_nu_own(String Id_mr_nu_own) {
		setAttrVal("Id_mr_nu_own", Id_mr_nu_own);
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
	public String getId_owetp() {
		return ((String) getAttrVal("Id_owetp"));
	}	
	public void setId_owetp(String Id_owetp) {
		setAttrVal("Id_owetp", Id_owetp);
	}
	public String getSd_owetp() {
		return ((String) getAttrVal("Sd_owetp"));
	}	
	public void setSd_owetp(String Sd_owetp) {
		setAttrVal("Sd_owetp", Sd_owetp);
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
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getName_owetp() {
		return ((String) getAttrVal("Name_owetp"));
	}	
	public void setName_owetp(String Name_owetp) {
		setAttrVal("Name_owetp", Name_owetp);
	}
	public String getCode_owetp() {
		return ((String) getAttrVal("Code_owetp"));
	}	
	public void setCode_owetp(String Code_owetp) {
		setAttrVal("Code_owetp", Code_owetp);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_mr_nu_own";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_OWN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NuOwnDODesc.class);
	}
	
}