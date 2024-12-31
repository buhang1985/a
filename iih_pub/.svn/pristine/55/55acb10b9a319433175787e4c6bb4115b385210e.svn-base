package iih.bd.srv.mrnurplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mrnurplan.d.desc.MrNurPlanDODesc;
import java.math.BigDecimal;

/**
 * 护理计划内容模板 DO数据 
 * 
 */
public class MrNurPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_NUR_PLAN= "Id_mr_nur_plan";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_DIDEF= "Id_didef";
	public static final String CONTENT= "Content";
	public static final String EU_OWNERTP= "Eu_ownertp";
	public static final String ID_OWNER_DEP= "Id_owner_dep";
	public static final String ID_OWNER_EMP= "Id_owner_emp";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DIDEF= "Name_didef";
	public static final String NAME_OWNER_DEP= "Name_owner_dep";
	public static final String NAME_OWNER_EMP= "Name_owner_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_nur_plan() {
		return ((String) getAttrVal("Id_mr_nur_plan"));
	}	
	public void setId_mr_nur_plan(String Id_mr_nur_plan) {
		setAttrVal("Id_mr_nur_plan", Id_mr_nur_plan);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public Integer getEu_ownertp() {
		return ((Integer) getAttrVal("Eu_ownertp"));
	}	
	public void setEu_ownertp(Integer Eu_ownertp) {
		setAttrVal("Eu_ownertp", Eu_ownertp);
	}
	public String getId_owner_dep() {
		return ((String) getAttrVal("Id_owner_dep"));
	}	
	public void setId_owner_dep(String Id_owner_dep) {
		setAttrVal("Id_owner_dep", Id_owner_dep);
	}
	public String getId_owner_emp() {
		return ((String) getAttrVal("Id_owner_emp"));
	}	
	public void setId_owner_emp(String Id_owner_emp) {
		setAttrVal("Id_owner_emp", Id_owner_emp);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}	
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	public String getName_owner_dep() {
		return ((String) getAttrVal("Name_owner_dep"));
	}	
	public void setName_owner_dep(String Name_owner_dep) {
		setAttrVal("Name_owner_dep", Name_owner_dep);
	}
	public String getName_owner_emp() {
		return ((String) getAttrVal("Name_owner_emp"));
	}	
	public void setName_owner_emp(String Name_owner_emp) {
		setAttrVal("Name_owner_emp", Name_owner_emp);
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
		return "Id_mr_nur_plan";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MR_NUR_PLAN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrNurPlanDODesc.class);
	}
	
}