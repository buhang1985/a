package iih.bd.res.deptb.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.deptb.d.desc.DeptBDODesc;
import java.math.BigDecimal;

/**
 * 部门 DO数据 
 * 
 */
public class DeptBDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEP= "Id_dep";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String INNERCODE= "Innercode";
	public static final String ID_PARENT= "Id_parent";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_DEPTTP= "Sd_depttp";
	public static final String SD_DEPTLEVEL= "Sd_deptlevel";
	public static final String CREATEDATE= "Createdate";
	public static final String SHORTNAME= "Shortname";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String DEPTCANCELDATE= "Deptcanceldate";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ACTIVESTATE= "Activestate";
	public static final String DISPLAYORDER= "Displayorder";
	public static final String PRINCIPAL= "Principal";
	public static final String TEL= "Tel";
	public static final String ID_PLC= "Id_plc";
	public static final String DES= "Des";
	public static final String ISLASTVERSION= "Islastversion";
	public static final String DEPTDUTY= "Deptduty";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String DEPT_CODE= "Dept_code";
	public static final String DEPT_NAME= "Dept_name";
	public static final String GRP_NAME= "Grp_name";
	public static final String GRP_CODE= "Grp_code";
	public static final String ORG_NAME= "Org_name";
	public static final String ORG_CODE= "Org_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
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
	
	public String getSd_depttp() {
		return ((String) getAttrVal("Sd_depttp"));
	}	
	public void setSd_depttp(String Sd_depttp) {
		setAttrVal("Sd_depttp", Sd_depttp);
	}
	
	public String getSd_deptlevel() {
		return ((String) getAttrVal("Sd_deptlevel"));
	}	
	public void setSd_deptlevel(String Sd_deptlevel) {
		setAttrVal("Sd_deptlevel", Sd_deptlevel);
	}
	
	public FDate getCreatedate() {
		return ((FDate) getAttrVal("Createdate"));
	}	
	public void setCreatedate(FDate Createdate) {
		setAttrVal("Createdate", Createdate);
	}
	
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	
	public FDateTime getDeptcanceldate() {
		return ((FDateTime) getAttrVal("Deptcanceldate"));
	}	
	public void setDeptcanceldate(FDateTime Deptcanceldate) {
		setAttrVal("Deptcanceldate", Deptcanceldate);
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
	
	public Integer getActivestate() {
		return ((Integer) getAttrVal("Activestate"));
	}	
	public void setActivestate(Integer Activestate) {
		setAttrVal("Activestate", Activestate);
	}
	
	public Integer getDisplayorder() {
		return ((Integer) getAttrVal("Displayorder"));
	}	
	public void setDisplayorder(Integer Displayorder) {
		setAttrVal("Displayorder", Displayorder);
	}
	
	public String getPrincipal() {
		return ((String) getAttrVal("Principal"));
	}	
	public void setPrincipal(String Principal) {
		setAttrVal("Principal", Principal);
	}
	
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	
	public String getId_plc() {
		return ((String) getAttrVal("Id_plc"));
	}	
	public void setId_plc(String Id_plc) {
		setAttrVal("Id_plc", Id_plc);
	}
	
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	
	public FBoolean getIslastversion() {
		return ((FBoolean) getAttrVal("Islastversion"));
	}	
	public void setIslastversion(FBoolean Islastversion) {
		setAttrVal("Islastversion", Islastversion);
	}
	
	public String getDeptduty() {
		return ((String) getAttrVal("Deptduty"));
	}	
	public void setDeptduty(String Deptduty) {
		setAttrVal("Deptduty", Deptduty);
	}
	
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
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
		return "Id_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dep";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(DeptBDODesc.class);
	}
	
}