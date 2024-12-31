package iih.bd.mm.departinfo.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.departinfo.d.desc.DepartInfoDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_与科室关系 DO数据 
 * 
 */
public class DepartInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMWH= "Id_mmwh";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_MM= "Id_mm";
	public static final String MAXSTNUM= "Maxstnum";
	public static final String MAXUINUM= "Maxuinum";
	public static final String ID_MMPKGU_UI= "Id_mmpkgu_ui";
	public static final String ID_WH_SRV= "Id_wh_srv";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String SUPPLYTIME= "Supplytime";
	public static final String DEP_NAME= "Dep_name";
	public static final String MM_CODE= "Mm_code";
	public static final String MM_SPEC= "Mm_spec";
	public static final String MM_NAME= "Mm_name";
	public static final String MMPKGUNAME= "Mmpkguname";
	public static final String LOC_NAME= "Loc_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmwh() {
		return ((String) getAttrVal("Id_mmwh"));
	}	
	public void setId_mmwh(String Id_mmwh) {
		setAttrVal("Id_mmwh", Id_mmwh);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public FDouble getMaxstnum() {
		return ((FDouble) getAttrVal("Maxstnum"));
	}	
	public void setMaxstnum(FDouble Maxstnum) {
		setAttrVal("Maxstnum", Maxstnum);
	}
	public FDouble getMaxuinum() {
		return ((FDouble) getAttrVal("Maxuinum"));
	}	
	public void setMaxuinum(FDouble Maxuinum) {
		setAttrVal("Maxuinum", Maxuinum);
	}
	public String getId_mmpkgu_ui() {
		return ((String) getAttrVal("Id_mmpkgu_ui"));
	}	
	public void setId_mmpkgu_ui(String Id_mmpkgu_ui) {
		setAttrVal("Id_mmpkgu_ui", Id_mmpkgu_ui);
	}
	public String getId_wh_srv() {
		return ((String) getAttrVal("Id_wh_srv"));
	}	
	public void setId_wh_srv(String Id_wh_srv) {
		setAttrVal("Id_wh_srv", Id_wh_srv);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FDateTime getSupplytime() {
		return ((FDateTime) getAttrVal("Supplytime"));
	}	
	public void setSupplytime(FDateTime Supplytime) {
		setAttrVal("Supplytime", Supplytime);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getMmpkguname() {
		return ((String) getAttrVal("Mmpkguname"));
	}	
	public void setMmpkguname(String Mmpkguname) {
		setAttrVal("Mmpkguname", Mmpkguname);
	}
	public String getLoc_name() {
		return ((String) getAttrVal("Loc_name"));
	}	
	public void setLoc_name(String Loc_name) {
		setAttrVal("Loc_name", Loc_name);
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
		return "Id_mmwh";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DepartInfoDODesc.class);
	}
	
}