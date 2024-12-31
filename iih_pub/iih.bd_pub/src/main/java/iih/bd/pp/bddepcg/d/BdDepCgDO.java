package iih.bd.pp.bddepcg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bddepcg.d.desc.BdDepCgDODesc;
import java.math.BigDecimal;

/**
 * 科室补费策略 DO数据 
 * 
 */
public class BdDepCgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEPCG= "Id_depcg";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP= "Id_dep";
	public static final String FG_BLACK= "Fg_black";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String DEPTCODE= "Deptcode";
	public static final String DEPTNAME= "Deptname";
	public static final String ENTPNAME= "Entpname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_depcg() {
		return ((String) getAttrVal("Id_depcg"));
	}	
	public void setId_depcg(String Id_depcg) {
		setAttrVal("Id_depcg", Id_depcg);
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
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FBoolean getFg_black() {
		return ((FBoolean) getAttrVal("Fg_black"));
	}	
	public void setFg_black(FBoolean Fg_black) {
		setAttrVal("Fg_black", Fg_black);
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
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getDeptcode() {
		return ((String) getAttrVal("Deptcode"));
	}	
	public void setDeptcode(String Deptcode) {
		setAttrVal("Deptcode", Deptcode);
	}
	public String getDeptname() {
		return ((String) getAttrVal("Deptname"));
	}	
	public void setDeptname(String Deptname) {
		setAttrVal("Deptname", Deptname);
	}
	public String getEntpname() {
		return ((String) getAttrVal("Entpname"));
	}	
	public void setEntpname(String Entpname) {
		setAttrVal("Entpname", Entpname);
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
		return "Id_depcg";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dep_cg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdDepCgDODesc.class);
	}
	
}