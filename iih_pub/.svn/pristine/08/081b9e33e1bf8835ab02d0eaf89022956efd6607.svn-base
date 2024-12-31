package iih.nmr.ha.tcho.nachsorge.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.ha.tcho.nachsorge.d.desc.TchoNachsorgeDODesc;
import java.math.BigDecimal;

/**
 * 出院护理评估单 DO数据 
 * 
 */
public class TchoNachsorgeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NACHSORGE= "Id_nachsorge";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String DT_DISCHARGE= "Dt_discharge";
	public static final String ID_OPERATION= "Id_operation";
	public static final String SD_OPERATION= "Sd_operation";
	public static final String DT_OPERATION= "Dt_operation";
	public static final String NAME_OPERATION= "Name_operation";
	public static final String CHINESE_DIAGNOSE= "Chinese_diagnose";
	public static final String NAME_DOCUMENT_TYPE= "Name_document_type";
	public static final String WESTERN_DIAGNOSE= "Western_diagnose";
	public static final String ID_DISEASE_PROGNOSIS= "Id_disease_prognosis";
	public static final String SD_DISEASE_PROGNOSIS= "Sd_disease_prognosis";
	public static final String NAME_DISEASE_PROGNOSIS= "Name_disease_prognosis";
	public static final String ID_DISEASE_PERCEIVE_DEGREE= "Id_disease_perceive_degree";
	public static final String SD_DISEASE_PERCEIVE_DEGREE= "Sd_disease_perceive_degree";
	public static final String NAME_DISEASE_PERCEIVE_DEGREE= "Name_disease_perceive_degree";
	public static final String ID_EMOTIONS_STATUS= "Id_emotions_status";
	public static final String SD_EMOTIONS_STATUS= "Sd_emotions_status";
	public static final String NAME_EMOTIONS_STATUS= "Name_emotions_status";
	public static final String ID_SELF_CARE_ABILITY= "Id_self_care_ability";
	public static final String SD_SELF_CARE_ABILITY= "Sd_self_care_ability";
	public static final String NAME_SELF_CARE_ABILITY= "Name_self_care_ability";
	public static final String ID_ADMINISTRATION_BEHAVIOR= "Id_administration_behavior";
	public static final String SD_ADMINISTRATION_BEHAVIOR= "Sd_administration_behavior";
	public static final String NAME_ADMINISTRATION_BEHAVIOR= "Name_administration_behavior";
	public static final String ID_TEACH_CONTENT= "Id_teach_content";
	public static final String SD_TEACH_CONTENT= "Sd_teach_content";
	public static final String NAME_TEACH_CONTENT= "Name_teach_content";
	public static final String ID_TEACH_WAY= "Id_teach_way";
	public static final String SD_TEACH_WAY= "Sd_teach_way";
	public static final String NAME_TEACH_WAY= "Name_teach_way";
	public static final String ID_TEACH_COMPREHEND_DEGREE= "Id_teach_comprehend_degree";
	public static final String SD_TEACH_COMPREHEND_DEGREE= "Sd_teach_comprehend_degree";
	public static final String NAME_TEACH_COMPREHEND_DEGREE= "Name_teach_comprehend_degree";
	public static final String ID_COMPLICATION= "Id_complication";
	public static final String SD_COMPLICATION= "Sd_complication";
	public static final String NAME_COMPLICATION= "Name_complication";
	public static final String OTHER_ASSESS= "Other_assess";
	public static final String ID_MEDICATION_GUIDE= "Id_medication_guide";
	public static final String SD_MEDICATION_GUIDE= "Sd_medication_guide";
	public static final String NAME_MEDICATION_GUIDE= "Name_medication_guide";
	public static final String SPECIAL_MEDICATION_GUIDE= "Special_medication_guide";
	public static final String ID_HEALTH_GUIDE= "Id_health_guide";
	public static final String SD_HEALTH_GUIDE= "Sd_health_guide";
	public static final String NAME_HEALTH_GUIDE= "Name_health_guide";
	public static final String OTHER_HEALTH_GUIDE= "Other_health_guide";
	public static final String SPECIAL_GUIDE= "Special_guide";
	public static final String FILL_DATE= "Fill_date";
	public static final String ID_PRIMARY_NURSE= "Id_primary_nurse";
	public static final String ID_DISCHARGE_WAY= "Id_discharge_way";
	public static final String SD_DISCHARGE_WAY= "Sd_discharge_way";
	public static final String ID_EMP_NUR= "Id_emp_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String BACKUP_FIELD1= "Backup_field1";
	public static final String BACKUP_FIELD2= "Backup_field2";
	public static final String BACKUP_FIELD3= "Backup_field3";
	public static final String BACKUP_FIELD4= "Backup_field4";
	public static final String BACKUP_FIELD5= "Backup_field5";
	public static final String OPERATION_NAME= "Operation_name";
	public static final String OPERATION_CODE= "Operation_code";
	public static final String DISEASE_PRO_CODE= "Disease_pro_code";
	public static final String DISEASE_PRO_NAME= "Disease_pro_name";
	public static final String DISEASE_PER_CODE= "Disease_per_code";
	public static final String DISEASE_PER_NAME= "Disease_per_name";
	public static final String EMOTIONS_STATUS_CODE= "Emotions_status_code";
	public static final String EMOTIONS_STATUS_NAME= "Emotions_status_name";
	public static final String SELF_CARE_CODE= "Self_care_code";
	public static final String SELF_CARE_NAME= "Self_care_name";
	public static final String ADM_BEH_CODE= "Adm_beh_code";
	public static final String ADM_BEH_NAME= "Adm_beh_name";
	public static final String TEACH_CON_CODE= "Teach_con_code";
	public static final String TEACH_CON_NAME= "Teach_con_name";
	public static final String TEACH_WAY_CODE= "Teach_way_code";
	public static final String TEACH_WAY_NAME= "Teach_way_name";
	public static final String TEACH_COM_CODE= "Teach_com_code";
	public static final String TEACH_COM_NAME= "Teach_com_name";
	public static final String COMPLICATION_CODE= "Complication_code";
	public static final String COMPLICATION_NAME= "Complication_name";
	public static final String MEDICATION_GUIDE_CODE= "Medication_guide_code";
	public static final String MEDICATION_GUIDE_NAME= "Medication_guide_name";
	public static final String HEALTH_GUIDE_CODE= "Health_guide_code";
	public static final String HEALTH_GUIDE_NAME= "Health_guide_name";
	public static final String NAME_PRIMARY_NURSE= "Name_primary_nurse";
	public static final String NAME_DISCHARGE_WAY= "Name_discharge_way";
	public static final String NAME_EMP_NUR= "Name_emp_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nachsorge() {
		return ((String) getAttrVal("Id_nachsorge"));
	}	
	public void setId_nachsorge(String Id_nachsorge) {
		setAttrVal("Id_nachsorge", Id_nachsorge);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public FDateTime getDt_discharge() {
		return ((FDateTime) getAttrVal("Dt_discharge"));
	}	
	public void setDt_discharge(FDateTime Dt_discharge) {
		setAttrVal("Dt_discharge", Dt_discharge);
	}
	public String getId_operation() {
		return ((String) getAttrVal("Id_operation"));
	}	
	public void setId_operation(String Id_operation) {
		setAttrVal("Id_operation", Id_operation);
	}
	public String getSd_operation() {
		return ((String) getAttrVal("Sd_operation"));
	}	
	public void setSd_operation(String Sd_operation) {
		setAttrVal("Sd_operation", Sd_operation);
	}
	public FDate getDt_operation() {
		return ((FDate) getAttrVal("Dt_operation"));
	}	
	public void setDt_operation(FDate Dt_operation) {
		setAttrVal("Dt_operation", Dt_operation);
	}
	public String getName_operation() {
		return ((String) getAttrVal("Name_operation"));
	}	
	public void setName_operation(String Name_operation) {
		setAttrVal("Name_operation", Name_operation);
	}
	public String getChinese_diagnose() {
		return ((String) getAttrVal("Chinese_diagnose"));
	}	
	public void setChinese_diagnose(String Chinese_diagnose) {
		setAttrVal("Chinese_diagnose", Chinese_diagnose);
	}
	public String getName_document_type() {
		return ((String) getAttrVal("Name_document_type"));
	}	
	public void setName_document_type(String Name_document_type) {
		setAttrVal("Name_document_type", Name_document_type);
	}
	public String getWestern_diagnose() {
		return ((String) getAttrVal("Western_diagnose"));
	}	
	public void setWestern_diagnose(String Western_diagnose) {
		setAttrVal("Western_diagnose", Western_diagnose);
	}
	public String getId_disease_prognosis() {
		return ((String) getAttrVal("Id_disease_prognosis"));
	}	
	public void setId_disease_prognosis(String Id_disease_prognosis) {
		setAttrVal("Id_disease_prognosis", Id_disease_prognosis);
	}
	public String getSd_disease_prognosis() {
		return ((String) getAttrVal("Sd_disease_prognosis"));
	}	
	public void setSd_disease_prognosis(String Sd_disease_prognosis) {
		setAttrVal("Sd_disease_prognosis", Sd_disease_prognosis);
	}
	public String getName_disease_prognosis() {
		return ((String) getAttrVal("Name_disease_prognosis"));
	}	
	public void setName_disease_prognosis(String Name_disease_prognosis) {
		setAttrVal("Name_disease_prognosis", Name_disease_prognosis);
	}
	public String getId_disease_perceive_degree() {
		return ((String) getAttrVal("Id_disease_perceive_degree"));
	}	
	public void setId_disease_perceive_degree(String Id_disease_perceive_degree) {
		setAttrVal("Id_disease_perceive_degree", Id_disease_perceive_degree);
	}
	public String getSd_disease_perceive_degree() {
		return ((String) getAttrVal("Sd_disease_perceive_degree"));
	}	
	public void setSd_disease_perceive_degree(String Sd_disease_perceive_degree) {
		setAttrVal("Sd_disease_perceive_degree", Sd_disease_perceive_degree);
	}
	public String getName_disease_perceive_degree() {
		return ((String) getAttrVal("Name_disease_perceive_degree"));
	}	
	public void setName_disease_perceive_degree(String Name_disease_perceive_degree) {
		setAttrVal("Name_disease_perceive_degree", Name_disease_perceive_degree);
	}
	public String getId_emotions_status() {
		return ((String) getAttrVal("Id_emotions_status"));
	}	
	public void setId_emotions_status(String Id_emotions_status) {
		setAttrVal("Id_emotions_status", Id_emotions_status);
	}
	public String getSd_emotions_status() {
		return ((String) getAttrVal("Sd_emotions_status"));
	}	
	public void setSd_emotions_status(String Sd_emotions_status) {
		setAttrVal("Sd_emotions_status", Sd_emotions_status);
	}
	public String getName_emotions_status() {
		return ((String) getAttrVal("Name_emotions_status"));
	}	
	public void setName_emotions_status(String Name_emotions_status) {
		setAttrVal("Name_emotions_status", Name_emotions_status);
	}
	public String getId_self_care_ability() {
		return ((String) getAttrVal("Id_self_care_ability"));
	}	
	public void setId_self_care_ability(String Id_self_care_ability) {
		setAttrVal("Id_self_care_ability", Id_self_care_ability);
	}
	public String getSd_self_care_ability() {
		return ((String) getAttrVal("Sd_self_care_ability"));
	}	
	public void setSd_self_care_ability(String Sd_self_care_ability) {
		setAttrVal("Sd_self_care_ability", Sd_self_care_ability);
	}
	public String getName_self_care_ability() {
		return ((String) getAttrVal("Name_self_care_ability"));
	}	
	public void setName_self_care_ability(String Name_self_care_ability) {
		setAttrVal("Name_self_care_ability", Name_self_care_ability);
	}
	public String getId_administration_behavior() {
		return ((String) getAttrVal("Id_administration_behavior"));
	}	
	public void setId_administration_behavior(String Id_administration_behavior) {
		setAttrVal("Id_administration_behavior", Id_administration_behavior);
	}
	public String getSd_administration_behavior() {
		return ((String) getAttrVal("Sd_administration_behavior"));
	}	
	public void setSd_administration_behavior(String Sd_administration_behavior) {
		setAttrVal("Sd_administration_behavior", Sd_administration_behavior);
	}
	public String getName_administration_behavior() {
		return ((String) getAttrVal("Name_administration_behavior"));
	}	
	public void setName_administration_behavior(String Name_administration_behavior) {
		setAttrVal("Name_administration_behavior", Name_administration_behavior);
	}
	public String getId_teach_content() {
		return ((String) getAttrVal("Id_teach_content"));
	}	
	public void setId_teach_content(String Id_teach_content) {
		setAttrVal("Id_teach_content", Id_teach_content);
	}
	public String getSd_teach_content() {
		return ((String) getAttrVal("Sd_teach_content"));
	}	
	public void setSd_teach_content(String Sd_teach_content) {
		setAttrVal("Sd_teach_content", Sd_teach_content);
	}
	public String getName_teach_content() {
		return ((String) getAttrVal("Name_teach_content"));
	}	
	public void setName_teach_content(String Name_teach_content) {
		setAttrVal("Name_teach_content", Name_teach_content);
	}
	public String getId_teach_way() {
		return ((String) getAttrVal("Id_teach_way"));
	}	
	public void setId_teach_way(String Id_teach_way) {
		setAttrVal("Id_teach_way", Id_teach_way);
	}
	public String getSd_teach_way() {
		return ((String) getAttrVal("Sd_teach_way"));
	}	
	public void setSd_teach_way(String Sd_teach_way) {
		setAttrVal("Sd_teach_way", Sd_teach_way);
	}
	public String getName_teach_way() {
		return ((String) getAttrVal("Name_teach_way"));
	}	
	public void setName_teach_way(String Name_teach_way) {
		setAttrVal("Name_teach_way", Name_teach_way);
	}
	public String getId_teach_comprehend_degree() {
		return ((String) getAttrVal("Id_teach_comprehend_degree"));
	}	
	public void setId_teach_comprehend_degree(String Id_teach_comprehend_degree) {
		setAttrVal("Id_teach_comprehend_degree", Id_teach_comprehend_degree);
	}
	public String getSd_teach_comprehend_degree() {
		return ((String) getAttrVal("Sd_teach_comprehend_degree"));
	}	
	public void setSd_teach_comprehend_degree(String Sd_teach_comprehend_degree) {
		setAttrVal("Sd_teach_comprehend_degree", Sd_teach_comprehend_degree);
	}
	public String getName_teach_comprehend_degree() {
		return ((String) getAttrVal("Name_teach_comprehend_degree"));
	}	
	public void setName_teach_comprehend_degree(String Name_teach_comprehend_degree) {
		setAttrVal("Name_teach_comprehend_degree", Name_teach_comprehend_degree);
	}
	public String getId_complication() {
		return ((String) getAttrVal("Id_complication"));
	}	
	public void setId_complication(String Id_complication) {
		setAttrVal("Id_complication", Id_complication);
	}
	public String getSd_complication() {
		return ((String) getAttrVal("Sd_complication"));
	}	
	public void setSd_complication(String Sd_complication) {
		setAttrVal("Sd_complication", Sd_complication);
	}
	public String getName_complication() {
		return ((String) getAttrVal("Name_complication"));
	}	
	public void setName_complication(String Name_complication) {
		setAttrVal("Name_complication", Name_complication);
	}
	public String getOther_assess() {
		return ((String) getAttrVal("Other_assess"));
	}	
	public void setOther_assess(String Other_assess) {
		setAttrVal("Other_assess", Other_assess);
	}
	public String getId_medication_guide() {
		return ((String) getAttrVal("Id_medication_guide"));
	}	
	public void setId_medication_guide(String Id_medication_guide) {
		setAttrVal("Id_medication_guide", Id_medication_guide);
	}
	public String getSd_medication_guide() {
		return ((String) getAttrVal("Sd_medication_guide"));
	}	
	public void setSd_medication_guide(String Sd_medication_guide) {
		setAttrVal("Sd_medication_guide", Sd_medication_guide);
	}
	public String getName_medication_guide() {
		return ((String) getAttrVal("Name_medication_guide"));
	}	
	public void setName_medication_guide(String Name_medication_guide) {
		setAttrVal("Name_medication_guide", Name_medication_guide);
	}
	public String getSpecial_medication_guide() {
		return ((String) getAttrVal("Special_medication_guide"));
	}	
	public void setSpecial_medication_guide(String Special_medication_guide) {
		setAttrVal("Special_medication_guide", Special_medication_guide);
	}
	public String getId_health_guide() {
		return ((String) getAttrVal("Id_health_guide"));
	}	
	public void setId_health_guide(String Id_health_guide) {
		setAttrVal("Id_health_guide", Id_health_guide);
	}
	public String getSd_health_guide() {
		return ((String) getAttrVal("Sd_health_guide"));
	}	
	public void setSd_health_guide(String Sd_health_guide) {
		setAttrVal("Sd_health_guide", Sd_health_guide);
	}
	public String getName_health_guide() {
		return ((String) getAttrVal("Name_health_guide"));
	}	
	public void setName_health_guide(String Name_health_guide) {
		setAttrVal("Name_health_guide", Name_health_guide);
	}
	public String getOther_health_guide() {
		return ((String) getAttrVal("Other_health_guide"));
	}	
	public void setOther_health_guide(String Other_health_guide) {
		setAttrVal("Other_health_guide", Other_health_guide);
	}
	public String getSpecial_guide() {
		return ((String) getAttrVal("Special_guide"));
	}	
	public void setSpecial_guide(String Special_guide) {
		setAttrVal("Special_guide", Special_guide);
	}
	public FDate getFill_date() {
		return ((FDate) getAttrVal("Fill_date"));
	}	
	public void setFill_date(FDate Fill_date) {
		setAttrVal("Fill_date", Fill_date);
	}
	public String getId_primary_nurse() {
		return ((String) getAttrVal("Id_primary_nurse"));
	}	
	public void setId_primary_nurse(String Id_primary_nurse) {
		setAttrVal("Id_primary_nurse", Id_primary_nurse);
	}
	public String getId_discharge_way() {
		return ((String) getAttrVal("Id_discharge_way"));
	}	
	public void setId_discharge_way(String Id_discharge_way) {
		setAttrVal("Id_discharge_way", Id_discharge_way);
	}
	public String getSd_discharge_way() {
		return ((String) getAttrVal("Sd_discharge_way"));
	}	
	public void setSd_discharge_way(String Sd_discharge_way) {
		setAttrVal("Sd_discharge_way", Sd_discharge_way);
	}
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
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
	public String getBackup_field1() {
		return ((String) getAttrVal("Backup_field1"));
	}	
	public void setBackup_field1(String Backup_field1) {
		setAttrVal("Backup_field1", Backup_field1);
	}
	public String getBackup_field2() {
		return ((String) getAttrVal("Backup_field2"));
	}	
	public void setBackup_field2(String Backup_field2) {
		setAttrVal("Backup_field2", Backup_field2);
	}
	public String getBackup_field3() {
		return ((String) getAttrVal("Backup_field3"));
	}	
	public void setBackup_field3(String Backup_field3) {
		setAttrVal("Backup_field3", Backup_field3);
	}
	public String getBackup_field4() {
		return ((String) getAttrVal("Backup_field4"));
	}	
	public void setBackup_field4(String Backup_field4) {
		setAttrVal("Backup_field4", Backup_field4);
	}
	public String getBackup_field5() {
		return ((String) getAttrVal("Backup_field5"));
	}	
	public void setBackup_field5(String Backup_field5) {
		setAttrVal("Backup_field5", Backup_field5);
	}
	public String getOperation_name() {
		return ((String) getAttrVal("Operation_name"));
	}	
	public void setOperation_name(String Operation_name) {
		setAttrVal("Operation_name", Operation_name);
	}
	public String getOperation_code() {
		return ((String) getAttrVal("Operation_code"));
	}	
	public void setOperation_code(String Operation_code) {
		setAttrVal("Operation_code", Operation_code);
	}
	public String getDisease_pro_code() {
		return ((String) getAttrVal("Disease_pro_code"));
	}	
	public void setDisease_pro_code(String Disease_pro_code) {
		setAttrVal("Disease_pro_code", Disease_pro_code);
	}
	public String getDisease_pro_name() {
		return ((String) getAttrVal("Disease_pro_name"));
	}	
	public void setDisease_pro_name(String Disease_pro_name) {
		setAttrVal("Disease_pro_name", Disease_pro_name);
	}
	public String getDisease_per_code() {
		return ((String) getAttrVal("Disease_per_code"));
	}	
	public void setDisease_per_code(String Disease_per_code) {
		setAttrVal("Disease_per_code", Disease_per_code);
	}
	public String getDisease_per_name() {
		return ((String) getAttrVal("Disease_per_name"));
	}	
	public void setDisease_per_name(String Disease_per_name) {
		setAttrVal("Disease_per_name", Disease_per_name);
	}
	public String getEmotions_status_code() {
		return ((String) getAttrVal("Emotions_status_code"));
	}	
	public void setEmotions_status_code(String Emotions_status_code) {
		setAttrVal("Emotions_status_code", Emotions_status_code);
	}
	public String getEmotions_status_name() {
		return ((String) getAttrVal("Emotions_status_name"));
	}	
	public void setEmotions_status_name(String Emotions_status_name) {
		setAttrVal("Emotions_status_name", Emotions_status_name);
	}
	public String getSelf_care_code() {
		return ((String) getAttrVal("Self_care_code"));
	}	
	public void setSelf_care_code(String Self_care_code) {
		setAttrVal("Self_care_code", Self_care_code);
	}
	public String getSelf_care_name() {
		return ((String) getAttrVal("Self_care_name"));
	}	
	public void setSelf_care_name(String Self_care_name) {
		setAttrVal("Self_care_name", Self_care_name);
	}
	public String getAdm_beh_code() {
		return ((String) getAttrVal("Adm_beh_code"));
	}	
	public void setAdm_beh_code(String Adm_beh_code) {
		setAttrVal("Adm_beh_code", Adm_beh_code);
	}
	public String getAdm_beh_name() {
		return ((String) getAttrVal("Adm_beh_name"));
	}	
	public void setAdm_beh_name(String Adm_beh_name) {
		setAttrVal("Adm_beh_name", Adm_beh_name);
	}
	public String getTeach_con_code() {
		return ((String) getAttrVal("Teach_con_code"));
	}	
	public void setTeach_con_code(String Teach_con_code) {
		setAttrVal("Teach_con_code", Teach_con_code);
	}
	public String getTeach_con_name() {
		return ((String) getAttrVal("Teach_con_name"));
	}	
	public void setTeach_con_name(String Teach_con_name) {
		setAttrVal("Teach_con_name", Teach_con_name);
	}
	public String getTeach_way_code() {
		return ((String) getAttrVal("Teach_way_code"));
	}	
	public void setTeach_way_code(String Teach_way_code) {
		setAttrVal("Teach_way_code", Teach_way_code);
	}
	public String getTeach_way_name() {
		return ((String) getAttrVal("Teach_way_name"));
	}	
	public void setTeach_way_name(String Teach_way_name) {
		setAttrVal("Teach_way_name", Teach_way_name);
	}
	public String getTeach_com_code() {
		return ((String) getAttrVal("Teach_com_code"));
	}	
	public void setTeach_com_code(String Teach_com_code) {
		setAttrVal("Teach_com_code", Teach_com_code);
	}
	public String getTeach_com_name() {
		return ((String) getAttrVal("Teach_com_name"));
	}	
	public void setTeach_com_name(String Teach_com_name) {
		setAttrVal("Teach_com_name", Teach_com_name);
	}
	public String getComplication_code() {
		return ((String) getAttrVal("Complication_code"));
	}	
	public void setComplication_code(String Complication_code) {
		setAttrVal("Complication_code", Complication_code);
	}
	public String getComplication_name() {
		return ((String) getAttrVal("Complication_name"));
	}	
	public void setComplication_name(String Complication_name) {
		setAttrVal("Complication_name", Complication_name);
	}
	public String getMedication_guide_code() {
		return ((String) getAttrVal("Medication_guide_code"));
	}	
	public void setMedication_guide_code(String Medication_guide_code) {
		setAttrVal("Medication_guide_code", Medication_guide_code);
	}
	public String getMedication_guide_name() {
		return ((String) getAttrVal("Medication_guide_name"));
	}	
	public void setMedication_guide_name(String Medication_guide_name) {
		setAttrVal("Medication_guide_name", Medication_guide_name);
	}
	public String getHealth_guide_code() {
		return ((String) getAttrVal("Health_guide_code"));
	}	
	public void setHealth_guide_code(String Health_guide_code) {
		setAttrVal("Health_guide_code", Health_guide_code);
	}
	public String getHealth_guide_name() {
		return ((String) getAttrVal("Health_guide_name"));
	}	
	public void setHealth_guide_name(String Health_guide_name) {
		setAttrVal("Health_guide_name", Health_guide_name);
	}
	public String getName_primary_nurse() {
		return ((String) getAttrVal("Name_primary_nurse"));
	}	
	public void setName_primary_nurse(String Name_primary_nurse) {
		setAttrVal("Name_primary_nurse", Name_primary_nurse);
	}
	public String getName_discharge_way() {
		return ((String) getAttrVal("Name_discharge_way"));
	}	
	public void setName_discharge_way(String Name_discharge_way) {
		setAttrVal("Name_discharge_way", Name_discharge_way);
	}
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}	
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
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
		return "Id_nachsorge";
	}
	
	@Override
	public String getTableName() {	  
		return "nmr_ha_tcho_nachsorge";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TchoNachsorgeDODesc.class);
	}
	
}