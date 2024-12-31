package iih.hp.cp.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.app.d.desc.HpCpAppDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划应用 DO数据 
 * 
 */
public class HpCpAppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CPAPP= "Id_cpapp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_CP= "Id_cp";
	public static final String CPNAME= "Cpname";
	public static final String CPCODE= "Cpcode";
	public static final String VERSION= "Version";
	public static final String DT_ENTER= "Dt_enter";
	public static final String ID_EMP_ENTER= "Id_emp_enter";
	public static final String ID_ELE_CURSTAGE= "Id_ele_curstage";
	public static final String FG_ALTER= "Fg_alter";
	public static final String DT_EXIT= "Dt_exit";
	public static final String ID_EMP_EXIT= "Id_emp_exit";
	public static final String ID_ELE_LASTOPER= "Id_ele_lastoper";
	public static final String DAYS_EXE= "Days_exe";
	public static final String TOTAL_CHARGE= "Total_charge";
	public static final String REASON_DESC= "Reason_desc";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String ID_HALT_RSN_TP= "Id_halt_rsn_tp";
	public static final String SD_HALT_RSN_TP= "Sd_halt_rsn_tp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String DT_ACPT= "Dt_acpt";
	public static final String CP_SD_STATUS= "Cp_sd_status";
	public static final String RSNTP_NAME= "Rsntp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cpapp() {
		return ((String) getAttrVal("Id_cpapp"));
	}	
	public void setId_cpapp(String Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	public String getCpname() {
		return ((String) getAttrVal("Cpname"));
	}	
	public void setCpname(String Cpname) {
		setAttrVal("Cpname", Cpname);
	}
	public String getCpcode() {
		return ((String) getAttrVal("Cpcode"));
	}	
	public void setCpcode(String Cpcode) {
		setAttrVal("Cpcode", Cpcode);
	}
	public String getVersion() {
		return ((String) getAttrVal("Version"));
	}	
	public void setVersion(String Version) {
		setAttrVal("Version", Version);
	}
	public FDateTime getDt_enter() {
		return ((FDateTime) getAttrVal("Dt_enter"));
	}	
	public void setDt_enter(FDateTime Dt_enter) {
		setAttrVal("Dt_enter", Dt_enter);
	}
	public String getId_emp_enter() {
		return ((String) getAttrVal("Id_emp_enter"));
	}	
	public void setId_emp_enter(String Id_emp_enter) {
		setAttrVal("Id_emp_enter", Id_emp_enter);
	}
	public String getId_ele_curstage() {
		return ((String) getAttrVal("Id_ele_curstage"));
	}	
	public void setId_ele_curstage(String Id_ele_curstage) {
		setAttrVal("Id_ele_curstage", Id_ele_curstage);
	}
	public FBoolean getFg_alter() {
		return ((FBoolean) getAttrVal("Fg_alter"));
	}	
	public void setFg_alter(FBoolean Fg_alter) {
		setAttrVal("Fg_alter", Fg_alter);
	}
	public FDateTime getDt_exit() {
		return ((FDateTime) getAttrVal("Dt_exit"));
	}	
	public void setDt_exit(FDateTime Dt_exit) {
		setAttrVal("Dt_exit", Dt_exit);
	}
	public String getId_emp_exit() {
		return ((String) getAttrVal("Id_emp_exit"));
	}	
	public void setId_emp_exit(String Id_emp_exit) {
		setAttrVal("Id_emp_exit", Id_emp_exit);
	}
	public String getId_ele_lastoper() {
		return ((String) getAttrVal("Id_ele_lastoper"));
	}	
	public void setId_ele_lastoper(String Id_ele_lastoper) {
		setAttrVal("Id_ele_lastoper", Id_ele_lastoper);
	}
	public Integer getDays_exe() {
		return ((Integer) getAttrVal("Days_exe"));
	}	
	public void setDays_exe(Integer Days_exe) {
		setAttrVal("Days_exe", Days_exe);
	}
	public FDouble getTotal_charge() {
		return ((FDouble) getAttrVal("Total_charge"));
	}	
	public void setTotal_charge(FDouble Total_charge) {
		setAttrVal("Total_charge", Total_charge);
	}
	public String getReason_desc() {
		return ((String) getAttrVal("Reason_desc"));
	}	
	public void setReason_desc(String Reason_desc) {
		setAttrVal("Reason_desc", Reason_desc);
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
	public String getId_halt_rsn_tp() {
		return ((String) getAttrVal("Id_halt_rsn_tp"));
	}	
	public void setId_halt_rsn_tp(String Id_halt_rsn_tp) {
		setAttrVal("Id_halt_rsn_tp", Id_halt_rsn_tp);
	}
	public String getSd_halt_rsn_tp() {
		return ((String) getAttrVal("Sd_halt_rsn_tp"));
	}	
	public void setSd_halt_rsn_tp(String Sd_halt_rsn_tp) {
		setAttrVal("Sd_halt_rsn_tp", Sd_halt_rsn_tp);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	public String getCp_sd_status() {
		return ((String) getAttrVal("Cp_sd_status"));
	}	
	public void setCp_sd_status(String Cp_sd_status) {
		setAttrVal("Cp_sd_status", Cp_sd_status);
	}
	public String getRsntp_name() {
		return ((String) getAttrVal("Rsntp_name"));
	}	
	public void setRsntp_name(String Rsntp_name) {
		setAttrVal("Rsntp_name", Rsntp_name);
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
		return "Id_cpapp";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppDODesc.class);
	}
	
}