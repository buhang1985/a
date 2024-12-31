package iih.nm.nom.wkitmnurdep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.wkitmnurdep.d.desc.NomWkitmNurdepDODesc;
import java.math.BigDecimal;

/**
 * 护理工作量科室信息 DO数据 
 * 
 */
public class NomWkitmNurdepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOMWKITMNURDEP= "Id_nomwkitmnurdep";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP= "Id_dep";
	public static final String DISPLAY_ORDER= "Display_order";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ATTRI_DEPART= "Attri_depart";
	public static final String FG_SUM= "Fg_sum";
	public static final String CTR_1= "Ctr_1";
	public static final String CTR_2= "Ctr_2";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_ATTRIDEPART= "Name_attridepart";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nomwkitmnurdep() {
		return ((String) getAttrVal("Id_nomwkitmnurdep"));
	}	
	public void setId_nomwkitmnurdep(String Id_nomwkitmnurdep) {
		setAttrVal("Id_nomwkitmnurdep", Id_nomwkitmnurdep);
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
	public Integer getDisplay_order() {
		return ((Integer) getAttrVal("Display_order"));
	}	
	public void setDisplay_order(Integer Display_order) {
		setAttrVal("Display_order", Display_order);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getAttri_depart() {
		return ((String) getAttrVal("Attri_depart"));
	}	
	public void setAttri_depart(String Attri_depart) {
		setAttrVal("Attri_depart", Attri_depart);
	}
	public FBoolean getFg_sum() {
		return ((FBoolean) getAttrVal("Fg_sum"));
	}	
	public void setFg_sum(FBoolean Fg_sum) {
		setAttrVal("Fg_sum", Fg_sum);
	}
	public String getCtr_1() {
		return ((String) getAttrVal("Ctr_1"));
	}	
	public void setCtr_1(String Ctr_1) {
		setAttrVal("Ctr_1", Ctr_1);
	}
	public String getCtr_2() {
		return ((String) getAttrVal("Ctr_2"));
	}	
	public void setCtr_2(String Ctr_2) {
		setAttrVal("Ctr_2", Ctr_2);
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
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_attridepart() {
		return ((String) getAttrVal("Name_attridepart"));
	}	
	public void setName_attridepart(String Name_attridepart) {
		setAttrVal("Name_attridepart", Name_attridepart);
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
		return "Id_nomwkitmnurdep";
	}
	
	@Override
	public String getTableName() {	  
		return "nom_wkitm_nurdep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomWkitmNurdepDODesc.class);
	}
	
}