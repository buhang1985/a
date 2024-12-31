package iih.sc.att.sctaskplweek.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.att.sctaskplweek.d.desc.ScTaskPlWeekDODesc;
import java.math.BigDecimal;

/**
 * 考勤周计划 DO数据 
 * 
 */
public class ScTaskPlWeekDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TASKPLWEEK= "Id_taskplweek";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String WEEKNO= "Weekno";
	public static final String ID_DATESLOT= "Id_dateslot";
	public static final String ID_TASKPL= "Id_taskpl";
	public static final String ID_SCTASKCA= "Id_sctaskca";
	public static final String EU_TASKTP= "Eu_tasktp";
	public static final String NAME_SCTASKCA= "Name_sctaskca";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DATES= "Name_dates";
	public static final String CODE_DATES= "Code_dates";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_taskplweek() {
		return ((String) getAttrVal("Id_taskplweek"));
	}	
	public void setId_taskplweek(String Id_taskplweek) {
		setAttrVal("Id_taskplweek", Id_taskplweek);
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
	public Integer getWeekno() {
		return ((Integer) getAttrVal("Weekno"));
	}	
	public void setWeekno(Integer Weekno) {
		setAttrVal("Weekno", Weekno);
	}
	public String getId_dateslot() {
		return ((String) getAttrVal("Id_dateslot"));
	}	
	public void setId_dateslot(String Id_dateslot) {
		setAttrVal("Id_dateslot", Id_dateslot);
	}
	public String getId_taskpl() {
		return ((String) getAttrVal("Id_taskpl"));
	}	
	public void setId_taskpl(String Id_taskpl) {
		setAttrVal("Id_taskpl", Id_taskpl);
	}
	public String getId_sctaskca() {
		return ((String) getAttrVal("Id_sctaskca"));
	}	
	public void setId_sctaskca(String Id_sctaskca) {
		setAttrVal("Id_sctaskca", Id_sctaskca);
	}
	public Integer getEu_tasktp() {
		return ((Integer) getAttrVal("Eu_tasktp"));
	}	
	public void setEu_tasktp(Integer Eu_tasktp) {
		setAttrVal("Eu_tasktp", Eu_tasktp);
	}
	public String getName_sctaskca() {
		return ((String) getAttrVal("Name_sctaskca"));
	}	
	public void setName_sctaskca(String Name_sctaskca) {
		setAttrVal("Name_sctaskca", Name_sctaskca);
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
	public String getName_dates() {
		return ((String) getAttrVal("Name_dates"));
	}	
	public void setName_dates(String Name_dates) {
		setAttrVal("Name_dates", Name_dates);
	}
	public String getCode_dates() {
		return ((String) getAttrVal("Code_dates"));
	}	
	public void setCode_dates(String Code_dates) {
		setAttrVal("Code_dates", Code_dates);
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
		return "Id_taskplweek";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_task_pl_week";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScTaskPlWeekDODesc.class);
	}
	
}