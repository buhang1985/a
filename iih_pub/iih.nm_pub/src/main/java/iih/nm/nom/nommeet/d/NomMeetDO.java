package iih.nm.nom.nommeet.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nommeet.d.desc.NomMeetDODesc;
import java.math.BigDecimal;

/**
 * 会议记录 DO数据 
 * 
 */
public class NomMeetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_MEET= "Id_nom_meet";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String DT_MEET= "Dt_meet";
	public static final String ADDRES= "Addres";
	public static final String CON_ABSTRACT= "Con_abstract";
	public static final String MAIN_CONTENT= "Main_content";
	public static final String ID_INPUT_PSN= "Id_input_psn";
	public static final String DT_INPUT= "Dt_input";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String ID_MEET_RECTP= "Id_meet_rectp";
	public static final String SD_MEET_RECTP= "Sd_meet_rectp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_TASK= "Id_task";
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	public static final String DT_AUDIT= "Dt_audit";
	public static final String APCOMMENTS= "Apcomments";
	public static final String ID_AUDIT_LVL= "Id_audit_lvl";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_INPUT_PSN= "Name_input_psn";
	public static final String NAME_STATUS= "Name_status";
	public static final String NAME_MEET_RECTP= "Name_meet_rectp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_meet() {
		return ((String) getAttrVal("Id_nom_meet"));
	}	
	public void setId_nom_meet(String Id_nom_meet) {
		setAttrVal("Id_nom_meet", Id_nom_meet);
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
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public FDateTime getDt_meet() {
		return ((FDateTime) getAttrVal("Dt_meet"));
	}	
	public void setDt_meet(FDateTime Dt_meet) {
		setAttrVal("Dt_meet", Dt_meet);
	}
	public String getAddres() {
		return ((String) getAttrVal("Addres"));
	}	
	public void setAddres(String Addres) {
		setAttrVal("Addres", Addres);
	}
	public String getCon_abstract() {
		return ((String) getAttrVal("Con_abstract"));
	}	
	public void setCon_abstract(String Con_abstract) {
		setAttrVal("Con_abstract", Con_abstract);
	}
	public String getMain_content() {
		return ((String) getAttrVal("Main_content"));
	}	
	public void setMain_content(String Main_content) {
		setAttrVal("Main_content", Main_content);
	}
	public String getId_input_psn() {
		return ((String) getAttrVal("Id_input_psn"));
	}	
	public void setId_input_psn(String Id_input_psn) {
		setAttrVal("Id_input_psn", Id_input_psn);
	}
	public FDateTime getDt_input() {
		return ((FDateTime) getAttrVal("Dt_input"));
	}	
	public void setDt_input(FDateTime Dt_input) {
		setAttrVal("Dt_input", Dt_input);
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
	public String getId_meet_rectp() {
		return ((String) getAttrVal("Id_meet_rectp"));
	}	
	public void setId_meet_rectp(String Id_meet_rectp) {
		setAttrVal("Id_meet_rectp", Id_meet_rectp);
	}
	public String getSd_meet_rectp() {
		return ((String) getAttrVal("Sd_meet_rectp"));
	}	
	public void setSd_meet_rectp(String Sd_meet_rectp) {
		setAttrVal("Sd_meet_rectp", Sd_meet_rectp);
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
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	public void setName_emp_audit(String Name_emp_audit) {
		setAttrVal("Name_emp_audit", Name_emp_audit);
	}
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	public String getApcomments() {
		return ((String) getAttrVal("Apcomments"));
	}	
	public void setApcomments(String Apcomments) {
		setAttrVal("Apcomments", Apcomments);
	}
	public String getId_audit_lvl() {
		return ((String) getAttrVal("Id_audit_lvl"));
	}	
	public void setId_audit_lvl(String Id_audit_lvl) {
		setAttrVal("Id_audit_lvl", Id_audit_lvl);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_input_psn() {
		return ((String) getAttrVal("Name_input_psn"));
	}	
	public void setName_input_psn(String Name_input_psn) {
		setAttrVal("Name_input_psn", Name_input_psn);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	public String getName_meet_rectp() {
		return ((String) getAttrVal("Name_meet_rectp"));
	}	
	public void setName_meet_rectp(String Name_meet_rectp) {
		setAttrVal("Name_meet_rectp", Name_meet_rectp);
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
		return "Id_nom_meet";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_MEET";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomMeetDODesc.class);
	}
	
}