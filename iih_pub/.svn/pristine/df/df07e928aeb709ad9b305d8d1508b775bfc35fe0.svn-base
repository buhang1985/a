package iih.bd.srv.deptstd2diag.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.deptstd2diag.d.desc.DeptStdDiagDODesc;
import java.math.BigDecimal;

/**
 * 科室常用诊断 DO数据 
 * 
 */
public class DeptStdDiagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DIDEP= "Id_didep";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DICADEP= "Id_dicadep";
	public static final String ID_DEP= "Id_dep";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_DIDEF= "Id_didef";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DICADEP= "Code_dicadep";
	public static final String NAME_DICADEP= "Name_dicadep";
	public static final String NAME_DIDEF= "Name_didef";
	public static final String ID_CDSYS= "Id_cdsys";
	public static final String ID_DISTDCA= "Id_distdca";
	public static final String ID_CDSYSTP= "Id_cdsystp";
	public static final String SD_CDSYSTP= "Sd_cdsystp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_didep() {
		return ((String) getAttrVal("Id_didep"));
	}	
	public void setId_didep(String Id_didep) {
		setAttrVal("Id_didep", Id_didep);
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
	public String getId_dicadep() {
		return ((String) getAttrVal("Id_dicadep"));
	}	
	public void setId_dicadep(String Id_dicadep) {
		setAttrVal("Id_dicadep", Id_dicadep);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	public String getCode_dicadep() {
		return ((String) getAttrVal("Code_dicadep"));
	}	
	public void setCode_dicadep(String Code_dicadep) {
		setAttrVal("Code_dicadep", Code_dicadep);
	}
	public String getName_dicadep() {
		return ((String) getAttrVal("Name_dicadep"));
	}	
	public void setName_dicadep(String Name_dicadep) {
		setAttrVal("Name_dicadep", Name_dicadep);
	}
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}	
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	public String getId_cdsys() {
		return ((String) getAttrVal("Id_cdsys"));
	}	
	public void setId_cdsys(String Id_cdsys) {
		setAttrVal("Id_cdsys", Id_cdsys);
	}
	public String getId_distdca() {
		return ((String) getAttrVal("Id_distdca"));
	}	
	public void setId_distdca(String Id_distdca) {
		setAttrVal("Id_distdca", Id_distdca);
	}
	public String getId_cdsystp() {
		return ((String) getAttrVal("Id_cdsystp"));
	}	
	public void setId_cdsystp(String Id_cdsystp) {
		setAttrVal("Id_cdsystp", Id_cdsystp);
	}
	public String getSd_cdsystp() {
		return ((String) getAttrVal("Sd_cdsystp"));
	}	
	public void setSd_cdsystp(String Sd_cdsystp) {
		setAttrVal("Sd_cdsystp", Sd_cdsystp);
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
		return "Id_didep";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_di_dep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DeptStdDiagDODesc.class);
	}
	
}