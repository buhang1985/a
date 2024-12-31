package iih.hp.cp.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.app.d.desc.HpCpAppAlterLogDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划操作日志_变异 DO数据 
 * 
 */
public class HpCpAppAlterLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ALTER_LOG= "Id_alter_log";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CPAPP= "Id_cpapp";
	public static final String ID_CP= "Id_cp";
	public static final String ID_LOG= "Id_log";
	public static final String ID_ALTER_TP= "Id_alter_tp";
	public static final String SD_ALTER_TP= "Sd_alter_tp";
	public static final String ID_ALTER_RSN_TP= "Id_alter_rsn_tp";
	public static final String SD_ALTER_RSN_TP= "Sd_alter_rsn_tp";
	public static final String ALTER_DESC= "Alter_desc";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_alter_log() {
		return ((String) getAttrVal("Id_alter_log"));
	}	
	public void setId_alter_log(String Id_alter_log) {
		setAttrVal("Id_alter_log", Id_alter_log);
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
	public String getId_cpapp() {
		return ((String) getAttrVal("Id_cpapp"));
	}	
	public void setId_cpapp(String Id_cpapp) {
		setAttrVal("Id_cpapp", Id_cpapp);
	}
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	public String getId_log() {
		return ((String) getAttrVal("Id_log"));
	}	
	public void setId_log(String Id_log) {
		setAttrVal("Id_log", Id_log);
	}
	public String getId_alter_tp() {
		return ((String) getAttrVal("Id_alter_tp"));
	}	
	public void setId_alter_tp(String Id_alter_tp) {
		setAttrVal("Id_alter_tp", Id_alter_tp);
	}
	public String getSd_alter_tp() {
		return ((String) getAttrVal("Sd_alter_tp"));
	}	
	public void setSd_alter_tp(String Sd_alter_tp) {
		setAttrVal("Sd_alter_tp", Sd_alter_tp);
	}
	public String getId_alter_rsn_tp() {
		return ((String) getAttrVal("Id_alter_rsn_tp"));
	}	
	public void setId_alter_rsn_tp(String Id_alter_rsn_tp) {
		setAttrVal("Id_alter_rsn_tp", Id_alter_rsn_tp);
	}
	public String getSd_alter_rsn_tp() {
		return ((String) getAttrVal("Sd_alter_rsn_tp"));
	}	
	public void setSd_alter_rsn_tp(String Sd_alter_rsn_tp) {
		setAttrVal("Sd_alter_rsn_tp", Sd_alter_rsn_tp);
	}
	public String getAlter_desc() {
		return ((String) getAttrVal("Alter_desc"));
	}	
	public void setAlter_desc(String Alter_desc) {
		setAttrVal("Alter_desc", Alter_desc);
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
		return "Id_alter_log";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP_ALTER_LOG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppAlterLogDODesc.class);
	}
	
}