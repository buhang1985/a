package iih.mp.ot.deptmp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ot.deptmp.d.desc.MpOrPrTmpDODesc;
import java.math.BigDecimal;

/**
 * 通用医技科室模板 DO数据 
 * 
 */
public class MpOrPrTmpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORPRTMP= "Id_orprtmp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String EU_SCOP= "Eu_scop";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DNAME= "Dname";
	public static final String ENAME= "Ename";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orprtmp() {
		return ((String) getAttrVal("Id_orprtmp"));
	}	
	public void setId_orprtmp(String Id_orprtmp) {
		setAttrVal("Id_orprtmp", Id_orprtmp);
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
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
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
	public Integer getEu_scop() {
		return ((Integer) getAttrVal("Eu_scop"));
	}	
	public void setEu_scop(Integer Eu_scop) {
		setAttrVal("Eu_scop", Eu_scop);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getDname() {
		return ((String) getAttrVal("Dname"));
	}	
	public void setDname(String Dname) {
		setAttrVal("Dname", Dname);
	}
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
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
		return "Id_orprtmp";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_OR_PR_TMP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOrPrTmpDODesc.class);
	}
	
}