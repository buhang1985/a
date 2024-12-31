package iih.bl.cg.blrecgoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.cg.blrecgoep.d.desc.BlRecgOepDODesc;
import java.math.BigDecimal;

/**
 * 重划价记录_门急体 DO数据 
 * 
 */
public class BlRecgOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RECG_OEP= "Id_recg_oep";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DT_RECG= "Dt_recg";
	public static final String ID_PRIPAT_FROM= "Id_pripat_from";
	public static final String ID_PRIPAT_TO= "Id_pripat_to";
	public static final String ID_EMP_RECG= "Id_emp_recg";
	public static final String ID_PRIPAT_NAME= "Id_pripat_name";
	public static final String PRIPAT_CODE= "Pripat_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_recg_oep() {
		return ((String) getAttrVal("Id_recg_oep"));
	}	
	public void setId_recg_oep(String Id_recg_oep) {
		setAttrVal("Id_recg_oep", Id_recg_oep);
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
	public FDateTime getDt_recg() {
		return ((FDateTime) getAttrVal("Dt_recg"));
	}	
	public void setDt_recg(FDateTime Dt_recg) {
		setAttrVal("Dt_recg", Dt_recg);
	}
	public String getId_pripat_from() {
		return ((String) getAttrVal("Id_pripat_from"));
	}	
	public void setId_pripat_from(String Id_pripat_from) {
		setAttrVal("Id_pripat_from", Id_pripat_from);
	}
	public String getId_pripat_to() {
		return ((String) getAttrVal("Id_pripat_to"));
	}	
	public void setId_pripat_to(String Id_pripat_to) {
		setAttrVal("Id_pripat_to", Id_pripat_to);
	}
	public String getId_emp_recg() {
		return ((String) getAttrVal("Id_emp_recg"));
	}	
	public void setId_emp_recg(String Id_emp_recg) {
		setAttrVal("Id_emp_recg", Id_emp_recg);
	}
	public String getId_pripat_name() {
		return ((String) getAttrVal("Id_pripat_name"));
	}	
	public void setId_pripat_name(String Id_pripat_name) {
		setAttrVal("Id_pripat_name", Id_pripat_name);
	}
	public String getPripat_code() {
		return ((String) getAttrVal("Pripat_code"));
	}	
	public void setPripat_code(String Pripat_code) {
		setAttrVal("Pripat_code", Pripat_code);
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
		return "Id_recg_oep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_recg_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlRecgOepDODesc.class);
	}
	
}