package iih.nm.nhr.nhrschedweek.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nhrschedweek.d.desc.NhrSchedDODesc;
import java.math.BigDecimal;

/**
 * 人员排班 DO数据 
 * 
 */
public class NhrSchedDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NHR_SCHED= "Id_nhr_sched";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NHR_SCHED_WEEK= "Id_nhr_sched_week";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	public static final String SD_NUR_LVL= "Sd_nur_lvl";
	public static final String DT_SCHED_DATE= "Dt_sched_date";
	public static final String ID_NUR= "Id_nur";
	public static final String DT_SCHED_TIME= "Dt_sched_time";
	public static final String ID_NHR_SCHED_LV= "Id_nhr_sched_lv";
	public static final String ID_REG_PSN= "Id_reg_psn";
	public static final String DT_REG= "Dt_reg";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	public static final String NAME_NUR= "Name_nur";
	public static final String JOB_NO= "Job_no";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nhr_sched() {
		return ((String) getAttrVal("Id_nhr_sched"));
	}	
	public void setId_nhr_sched(String Id_nhr_sched) {
		setAttrVal("Id_nhr_sched", Id_nhr_sched);
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
	public String getId_nhr_sched_week() {
		return ((String) getAttrVal("Id_nhr_sched_week"));
	}	
	public void setId_nhr_sched_week(String Id_nhr_sched_week) {
		setAttrVal("Id_nhr_sched_week", Id_nhr_sched_week);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}	
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	public FDate getDt_sched_date() {
		return ((FDate) getAttrVal("Dt_sched_date"));
	}	
	public void setDt_sched_date(FDate Dt_sched_date) {
		setAttrVal("Dt_sched_date", Dt_sched_date);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public FDateTime getDt_sched_time() {
		return ((FDateTime) getAttrVal("Dt_sched_time"));
	}	
	public void setDt_sched_time(FDateTime Dt_sched_time) {
		setAttrVal("Dt_sched_time", Dt_sched_time);
	}
	public String getId_nhr_sched_lv() {
		return ((String) getAttrVal("Id_nhr_sched_lv"));
	}	
	public void setId_nhr_sched_lv(String Id_nhr_sched_lv) {
		setAttrVal("Id_nhr_sched_lv", Id_nhr_sched_lv);
	}
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getJob_no() {
		return ((String) getAttrVal("Job_no"));
	}	
	public void setJob_no(String Job_no) {
		setAttrVal("Job_no", Job_no);
	}
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_nhr_sched";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_SCHED";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NhrSchedDODesc.class);
	}
	
}