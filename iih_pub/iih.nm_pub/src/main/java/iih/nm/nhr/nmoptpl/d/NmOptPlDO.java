package iih.nm.nhr.nmoptpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmoptpl.d.desc.NmOptPlDODesc;
import java.math.BigDecimal;

/**
 * 实习计划 DO数据 
 * 
 */
public class NmOptPlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPT_PL= "Id_opt_pl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME= "Name";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String UNIT_WEEK= "Unit_week";
	public static final String TOTAL_WEEKS= "Total_weeks";
	public static final String ID_NM_GRP= "Id_nm_grp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String GRP_NAME= "Grp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opt_pl() {
		return ((String) getAttrVal("Id_opt_pl"));
	}	
	public void setId_opt_pl(String Id_opt_pl) {
		setAttrVal("Id_opt_pl", Id_opt_pl);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public Integer getUnit_week() {
		return ((Integer) getAttrVal("Unit_week"));
	}	
	public void setUnit_week(Integer Unit_week) {
		setAttrVal("Unit_week", Unit_week);
	}
	public Integer getTotal_weeks() {
		return ((Integer) getAttrVal("Total_weeks"));
	}	
	public void setTotal_weeks(Integer Total_weeks) {
		setAttrVal("Total_weeks", Total_weeks);
	}
	public String getId_nm_grp() {
		return ((String) getAttrVal("Id_nm_grp"));
	}	
	public void setId_nm_grp(String Id_nm_grp) {
		setAttrVal("Id_nm_grp", Id_nm_grp);
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
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
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
		return "Id_opt_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_OPT_PL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmOptPlDODesc.class);
	}
	
}