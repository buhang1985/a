package iih.mp.mb.patrol.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mb.patrol.d.desc.PatrolDODesc;
import java.math.BigDecimal;

/**
 * 护理巡房 DO数据 
 * 
 */
public class PatrolDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATROL= "Id_patrol";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_BED= "Name_bed";
	public static final String NAME_PAT= "Name_pat";
	public static final String NUM_VISIT= "Num_visit";
	public static final String NOTE= "Note";
	public static final String ID_EMP_NUR= "Id_emp_nur";
	public static final String ID_DEP= "Id_dep";
	public static final String DT_PATROL= "Dt_patrol";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_PATROL_TYPE= "Id_patrol_type";
	public static final String SD_PATROL_TYPE= "Sd_patrol_type";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_PATROL_TYPE= "Name_patrol_type";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patrol() {
		return ((String) getAttrVal("Id_patrol"));
	}	
	public void setId_patrol(String Id_patrol) {
		setAttrVal("Id_patrol", Id_patrol);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public Integer getNum_visit() {
		return ((Integer) getAttrVal("Num_visit"));
	}	
	public void setNum_visit(Integer Num_visit) {
		setAttrVal("Num_visit", Num_visit);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FDateTime getDt_patrol() {
		return ((FDateTime) getAttrVal("Dt_patrol"));
	}	
	public void setDt_patrol(FDateTime Dt_patrol) {
		setAttrVal("Dt_patrol", Dt_patrol);
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
	public String getId_patrol_type() {
		return ((String) getAttrVal("Id_patrol_type"));
	}	
	public void setId_patrol_type(String Id_patrol_type) {
		setAttrVal("Id_patrol_type", Id_patrol_type);
	}
	public String getSd_patrol_type() {
		return ((String) getAttrVal("Sd_patrol_type"));
	}	
	public void setSd_patrol_type(String Sd_patrol_type) {
		setAttrVal("Sd_patrol_type", Sd_patrol_type);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_patrol_type() {
		return ((String) getAttrVal("Name_patrol_type"));
	}	
	public void setName_patrol_type(String Name_patrol_type) {
		setAttrVal("Name_patrol_type", Name_patrol_type);
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
		return "Id_patrol";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mb_patrol";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatrolDODesc.class);
	}
	
}