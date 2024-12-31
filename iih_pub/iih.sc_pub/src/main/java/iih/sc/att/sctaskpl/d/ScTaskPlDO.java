package iih.sc.att.sctaskpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.att.sctaskpl.d.desc.ScTaskPlDODesc;
import java.math.BigDecimal;

/**
 * 考勤排班部门计划 DO数据 
 * 
 */
public class ScTaskPlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TASKPL= "Id_taskpl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_CAL= "Id_cal";
	public static final String ID_EMPTP= "Id_emptp";
	public static final String SD_EMPTP= "Sd_emptp";
	public static final String ID_DATESLOTCA= "Id_dateslotca";
	public static final String EU_RECIRCLETP= "Eu_recircletp";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String CODE_CAL= "Code_cal";
	public static final String NAME_CAL= "Name_cal";
	public static final String CODE_EMPTP= "Code_emptp";
	public static final String NAME_EMPTP= "Name_emptp";
	public static final String CODE_DATES= "Code_dates";
	public static final String NAME_DATES= "Name_dates";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_taskpl() {
		return ((String) getAttrVal("Id_taskpl"));
	}	
	public void setId_taskpl(String Id_taskpl) {
		setAttrVal("Id_taskpl", Id_taskpl);
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
	public String getId_cal() {
		return ((String) getAttrVal("Id_cal"));
	}	
	public void setId_cal(String Id_cal) {
		setAttrVal("Id_cal", Id_cal);
	}
	public String getId_emptp() {
		return ((String) getAttrVal("Id_emptp"));
	}	
	public void setId_emptp(String Id_emptp) {
		setAttrVal("Id_emptp", Id_emptp);
	}
	public String getSd_emptp() {
		return ((String) getAttrVal("Sd_emptp"));
	}	
	public void setSd_emptp(String Sd_emptp) {
		setAttrVal("Sd_emptp", Sd_emptp);
	}
	public String getId_dateslotca() {
		return ((String) getAttrVal("Id_dateslotca"));
	}	
	public void setId_dateslotca(String Id_dateslotca) {
		setAttrVal("Id_dateslotca", Id_dateslotca);
	}
	public Integer getEu_recircletp() {
		return ((Integer) getAttrVal("Eu_recircletp"));
	}	
	public void setEu_recircletp(Integer Eu_recircletp) {
		setAttrVal("Eu_recircletp", Eu_recircletp);
	}
	public Integer getFg_active() {
		return ((Integer) getAttrVal("Fg_active"));
	}	
	public void setFg_active(Integer Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getCode_cal() {
		return ((String) getAttrVal("Code_cal"));
	}	
	public void setCode_cal(String Code_cal) {
		setAttrVal("Code_cal", Code_cal);
	}
	public String getName_cal() {
		return ((String) getAttrVal("Name_cal"));
	}	
	public void setName_cal(String Name_cal) {
		setAttrVal("Name_cal", Name_cal);
	}
	public String getCode_emptp() {
		return ((String) getAttrVal("Code_emptp"));
	}	
	public void setCode_emptp(String Code_emptp) {
		setAttrVal("Code_emptp", Code_emptp);
	}
	public String getName_emptp() {
		return ((String) getAttrVal("Name_emptp"));
	}	
	public void setName_emptp(String Name_emptp) {
		setAttrVal("Name_emptp", Name_emptp);
	}
	public String getCode_dates() {
		return ((String) getAttrVal("Code_dates"));
	}	
	public void setCode_dates(String Code_dates) {
		setAttrVal("Code_dates", Code_dates);
	}
	public String getName_dates() {
		return ((String) getAttrVal("Name_dates"));
	}	
	public void setName_dates(String Name_dates) {
		setAttrVal("Name_dates", Name_dates);
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
		return "Id_taskpl";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_task_pl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScTaskPlDODesc.class);
	}
	
}