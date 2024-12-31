package iih.mc.mc.monthaccflag.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.mc.monthaccflag.d.desc.McMonthAccFlagDODesc;
import java.math.BigDecimal;

/**
 * 仓库月结标志表 DO数据 
 * 
 */
public class McMonthAccFlagDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MC= "Id_mc";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_WH= "Id_wh";
	public static final String ID_ACCPERIODMONTH= "Id_accperiodmonth";
	public static final String YEAR_MONTH= "Year_month";
	public static final String ID_MC_ST= "Id_mc_st";
	public static final String SD_MC_ST= "Sd_mc_st";
	public static final String ID_EMP_ST= "Id_emp_st";
	public static final String DT_ST= "Dt_st";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WH_NAME= "Wh_name";
	public static final String WH_CODE= "Wh_code";
	public static final String ACC_YEARMONTH= "Acc_yearmonth";
	public static final String ID_ACCPERIOD= "Id_accperiod";
	public static final String MCST_NAME= "Mcst_name";
	public static final String MCST_CODE= "Mcst_code";
	public static final String EMPST_NAME= "Empst_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mc() {
		return ((String) getAttrVal("Id_mc"));
	}	
	public void setId_mc(String Id_mc) {
		setAttrVal("Id_mc", Id_mc);
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
	public String getId_mc_st() {
		return ((String) getAttrVal("Id_mc_st"));
	}	
	public void setId_mc_st(String Id_mc_st) {
		setAttrVal("Id_mc_st", Id_mc_st);
	}
	public String getSd_mc_st() {
		return ((String) getAttrVal("Sd_mc_st"));
	}	
	public void setSd_mc_st(String Sd_mc_st) {
		setAttrVal("Sd_mc_st", Sd_mc_st);
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
	public String getAcc_yearmonth() {
		return ((String) getAttrVal("Acc_yearmonth"));
	}	
	public void setAcc_yearmonth(String Acc_yearmonth) {
		setAttrVal("Acc_yearmonth", Acc_yearmonth);
	}
	public String getId_accperiod() {
		return ((String) getAttrVal("Id_accperiod"));
	}	
	public void setId_accperiod(String Id_accperiod) {
		setAttrVal("Id_accperiod", Id_accperiod);
	}
	public String getMcst_name() {
		return ((String) getAttrVal("Mcst_name"));
	}	
	public void setMcst_name(String Mcst_name) {
		setAttrVal("Mcst_name", Mcst_name);
	}
	public String getMcst_code() {
		return ((String) getAttrVal("Mcst_code"));
	}	
	public void setMcst_code(String Mcst_code) {
		setAttrVal("Mcst_code", Mcst_code);
	}
	public String getEmpst_name() {
		return ((String) getAttrVal("Empst_name"));
	}	
	public void setEmpst_name(String Empst_name) {
		setAttrVal("Empst_name", Empst_name);
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
		return "Id_mc";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_MC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McMonthAccFlagDODesc.class);
	}
	
}