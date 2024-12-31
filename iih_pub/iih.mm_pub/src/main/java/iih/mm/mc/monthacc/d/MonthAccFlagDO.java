package iih.mm.mc.monthacc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.mc.monthacc.d.desc.MonthAccFlagDODesc;
import java.math.BigDecimal;

/**
 * 仓库月结标志表 DO数据 
 * 
 */
public class MonthAccFlagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MCST= "Id_mcst";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_WH= "Id_wh";
	public static final String ID_ACCPERIODMONTH= "Id_accperiodmonth";
	public static final String YEAR_MONTH= "Year_month";
	public static final String ID_MC= "Id_mc";
	public static final String SD_MC= "Sd_mc";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String DT_ST= "Dt_st";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ORG_NAME= "Org_name";
	public static final String WH_NAME= "Wh_name";
	public static final String WH_CODE= "Wh_code";
	public static final String YEARMONTH= "Yearmonth";
	public static final String MC_NAME= "Mc_name";
	public static final String EMP_NAME= "Emp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mcst() {
		return ((String) getAttrVal("Id_mcst"));
	}	
	public void setId_mcst(String Id_mcst) {
		setAttrVal("Id_mcst", Id_mcst);
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
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	public String getId_accperiodmonth() {
		return ((String) getAttrVal("Id_accperiodmonth"));
	}	
	public void setId_accperiodmonth(String Id_accperiodmonth) {
		setAttrVal("Id_accperiodmonth", Id_accperiodmonth);
	}
	public String getYear_month() {
		return ((String) getAttrVal("Year_month"));
	}	
	public void setYear_month(String Year_month) {
		setAttrVal("Year_month", Year_month);
	}
	public String getId_mc() {
		return ((String) getAttrVal("Id_mc"));
	}	
	public void setId_mc(String Id_mc) {
		setAttrVal("Id_mc", Id_mc);
	}
	public String getSd_mc() {
		return ((String) getAttrVal("Sd_mc"));
	}	
	public void setSd_mc(String Sd_mc) {
		setAttrVal("Sd_mc", Sd_mc);
	}
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
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
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	public String getWh_code() {
		return ((String) getAttrVal("Wh_code"));
	}	
	public void setWh_code(String Wh_code) {
		setAttrVal("Wh_code", Wh_code);
	}
	public String getYearmonth() {
		return ((String) getAttrVal("Yearmonth"));
	}	
	public void setYearmonth(String Yearmonth) {
		setAttrVal("Yearmonth", Yearmonth);
	}
	public String getMc_name() {
		return ((String) getAttrVal("Mc_name"));
	}	
	public void setMc_name(String Mc_name) {
		setAttrVal("Mc_name", Mc_name);
	}
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
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
		return "Id_mcst";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_MCST";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MonthAccFlagDODesc.class);
	}
	
}