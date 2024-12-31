package iih.ci.mr.nu.intervopre.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.intervopre.d.desc.InterObjPreDODesc;
import java.math.BigDecimal;

/**
 * 物品准备 DO数据 
 * 
 */
public class InterObjPreDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OBJ_PRE= "Id_obj_pre";
	public static final String ID_PATINFO= "Id_patinfo";
	public static final String ID_INTER_MATERIAL= "Id_inter_material";
	public static final String SD_INTER_MATERIAL= "Sd_inter_material";
	public static final String INTER_MATERIAL= "Inter_material";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_INTER_MATERIAL= "Name_inter_material";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_obj_pre() {
		return ((String) getAttrVal("Id_obj_pre"));
	}	
	public void setId_obj_pre(String Id_obj_pre) {
		setAttrVal("Id_obj_pre", Id_obj_pre);
	}
	public String getId_patinfo() {
		return ((String) getAttrVal("Id_patinfo"));
	}	
	public void setId_patinfo(String Id_patinfo) {
		setAttrVal("Id_patinfo", Id_patinfo);
	}
	public String getId_inter_material() {
		return ((String) getAttrVal("Id_inter_material"));
	}	
	public void setId_inter_material(String Id_inter_material) {
		setAttrVal("Id_inter_material", Id_inter_material);
	}
	public String getSd_inter_material() {
		return ((String) getAttrVal("Sd_inter_material"));
	}	
	public void setSd_inter_material(String Sd_inter_material) {
		setAttrVal("Sd_inter_material", Sd_inter_material);
	}
	public Integer getInter_material() {
		return ((Integer) getAttrVal("Inter_material"));
	}	
	public void setInter_material(Integer Inter_material) {
		setAttrVal("Inter_material", Inter_material);
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
	public String getName_inter_material() {
		return ((String) getAttrVal("Name_inter_material"));
	}	
	public void setName_inter_material(String Name_inter_material) {
		setAttrVal("Name_inter_material", Name_inter_material);
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
		return "Id_obj_pre";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_INTEROBJPRE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InterObjPreDODesc.class);
	}
	
}