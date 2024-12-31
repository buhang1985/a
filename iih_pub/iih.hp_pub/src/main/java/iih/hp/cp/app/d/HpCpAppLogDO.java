package iih.hp.cp.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.app.d.desc.HpCpAppLogDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划操作日志 DO数据 
 * 
 */
public class HpCpAppLogDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_LOG= "Id_log";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CPAPP= "Id_cpapp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_CP= "Id_cp";
	public static final String DT_OPER= "Dt_oper";
	public static final String ID_OPER_TP= "Id_oper_tp";
	public static final String SD_OPER_TP= "Sd_oper_tp";
	public static final String CONTENT= "Content";
	public static final String ID_EMP= "Id_emp";
	public static final String FG_ALTER= "Fg_alter";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OPER_TP= "Name_oper_tp";
	public static final String NAME_PSN= "Name_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_log() {
		return ((String) getAttrVal("Id_log"));
	}	
	public void setId_log(String Id_log) {
		setAttrVal("Id_log", Id_log);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	public String getId_oper_tp() {
		return ((String) getAttrVal("Id_oper_tp"));
	}	
	public void setId_oper_tp(String Id_oper_tp) {
		setAttrVal("Id_oper_tp", Id_oper_tp);
	}
	public String getSd_oper_tp() {
		return ((String) getAttrVal("Sd_oper_tp"));
	}	
	public void setSd_oper_tp(String Sd_oper_tp) {
		setAttrVal("Sd_oper_tp", Sd_oper_tp);
	}
	public String getContent() {
		return ((String) getAttrVal("Content"));
	}	
	public void setContent(String Content) {
		setAttrVal("Content", Content);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public FBoolean getFg_alter() {
		return ((FBoolean) getAttrVal("Fg_alter"));
	}	
	public void setFg_alter(FBoolean Fg_alter) {
		setAttrVal("Fg_alter", Fg_alter);
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
	public String getName_oper_tp() {
		return ((String) getAttrVal("Name_oper_tp"));
	}	
	public void setName_oper_tp(String Name_oper_tp) {
		setAttrVal("Name_oper_tp", Name_oper_tp);
	}
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
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
		return "Id_log";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP_LOG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppLogDODesc.class);
	}
	
}