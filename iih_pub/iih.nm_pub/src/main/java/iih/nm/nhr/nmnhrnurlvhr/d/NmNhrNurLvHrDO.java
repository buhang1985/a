package iih.nm.nhr.nmnhrnurlvhr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnhrnurlvhr.d.desc.NmNhrNurLvHrDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_请假工时明细表 DO数据 
 * 
 */
public class NmNhrNurLvHrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NHR_NUR_LVHR= "Id_nhr_nur_lvhr";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NHR_SCHED_LV= "Id_nhr_sched_lv";
	public static final String YEAR= "Year";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_NUR= "Id_nur";
	public static final String YEAR_HR= "Year_hr";
	public static final String EXTRA_HR= "Extra_hr";
	public static final String HOLIDAY_HR= "Holiday_hr";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_NUR= "Name_nur";
	public static final String JOB_NO= "Job_no";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nhr_nur_lvhr() {
		return ((String) getAttrVal("Id_nhr_nur_lvhr"));
	}	
	public void setId_nhr_nur_lvhr(String Id_nhr_nur_lvhr) {
		setAttrVal("Id_nhr_nur_lvhr", Id_nhr_nur_lvhr);
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
	public String getId_nhr_sched_lv() {
		return ((String) getAttrVal("Id_nhr_sched_lv"));
	}	
	public void setId_nhr_sched_lv(String Id_nhr_sched_lv) {
		setAttrVal("Id_nhr_sched_lv", Id_nhr_sched_lv);
	}
	public FDate getYear() {
		return ((FDate) getAttrVal("Year"));
	}	
	public void setYear(FDate Year) {
		setAttrVal("Year", Year);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public FDouble getYear_hr() {
		return ((FDouble) getAttrVal("Year_hr"));
	}	
	public void setYear_hr(FDouble Year_hr) {
		setAttrVal("Year_hr", Year_hr);
	}
	public FDouble getExtra_hr() {
		return ((FDouble) getAttrVal("Extra_hr"));
	}	
	public void setExtra_hr(FDouble Extra_hr) {
		setAttrVal("Extra_hr", Extra_hr);
	}
	public FDouble getHoliday_hr() {
		return ((FDouble) getAttrVal("Holiday_hr"));
	}	
	public void setHoliday_hr(FDouble Holiday_hr) {
		setAttrVal("Holiday_hr", Holiday_hr);
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
		return "Id_nhr_nur_lvhr";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_LVHR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNhrNurLvHrDODesc.class);
	}
	
}