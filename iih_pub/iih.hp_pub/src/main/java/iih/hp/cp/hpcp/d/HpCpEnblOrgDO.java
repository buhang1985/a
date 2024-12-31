package iih.hp.cp.hpcp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.hpcp.d.desc.HpCpEnblOrgDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划适用科室 DO数据 
 * 
 */
public class HpCpEnblOrgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CPORG= "Id_cporg";
	public static final String ID_CP= "Id_cp";
	public static final String ID_DEP= "Id_dep";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cporg() {
		return ((String) getAttrVal("Id_cporg"));
	}	
	public void setId_cporg(String Id_cporg) {
		setAttrVal("Id_cporg", Id_cporg);
	}
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
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
		return "Id_cporg";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_cp_enbl_org";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpEnblOrgDODesc.class);
	}
	
}