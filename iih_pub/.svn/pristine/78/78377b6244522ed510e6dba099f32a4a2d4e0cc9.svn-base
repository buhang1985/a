package iih.nmr.nm.bch.opernur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.opernur.d.desc.OperNurDODesc;
import java.math.BigDecimal;

/**
 * 围手术期患者评估记录单 DO数据 
 * 
 */
public class OperNurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPERNUR= "Id_opernur";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String NAME_SEX= "Name_sex";
	public static final String NV_T_BEFORE= "Nv_t_before";
	public static final String INT_PULSE_BEFORE= "Int_pulse_before";
	public static final String INT_BREATH_BEFORE= "Int_breath_before";
	public static final String INT_SBP_BEFORE= "Int_sbp_before";
	public static final String INT_DBP_BEFORE= "Int_dbp_before";
	public static final String DT_EVAL_BEFORE= "Dt_eval_before";
	public static final String ID_MENTAL_STATE= "Id_mental_state";
	public static final String SD_MENTAL_STATE= "Sd_mental_state";
	public static final String ID_PAST_HISTORY= "Id_past_history";
	public static final String SD_PAST_HISTORY= "Sd_past_history";
	public static final String OTHER_PAST_HISTORY= "Other_past_history";
	public static final String ID_NUTRITION_STATUS= "Id_nutrition_status";
	public static final String SD_NUTRITION_STATUS= "Sd_nutrition_status";
	public static final String DT_FAST_BEGIN= "Dt_fast_begin";
	public static final String NAME_OPERATION= "Name_operation";
	public static final String DT_OPERATION= "Dt_operation";
	public static final String ID_ANESTHESIA= "Id_anesthesia";
	public static final String SD_ANESTHESIA= "Sd_anesthesia";
	public static final String OTHER_ANESTHESIA= "Other_anesthesia";
	public static final String EU_OPER_SITE= "Eu_oper_site";
	public static final String ID_SKIN_PREPARE= "Id_skin_prepare";
	public static final String SD_SKIN_PREPARE= "Sd_skin_prepare";
	public static final String ID_BLOOD_PREPARE= "Id_blood_prepare";
	public static final String SD_BLOOD_PREPARE= "Sd_blood_prepare";
	public static final String ID_PIPE= "Id_pipe";
	public static final String SD_PIPE= "Sd_pipe";
	public static final String OTHER_PIPE= "Other_pipe";
	public static final String ID_PRE_MEDIC= "Id_pre_medic";
	public static final String SD_PRE_MEDIC= "Sd_pre_medic";
	public static final String STABLE= "Stable";
	public static final String ALPRAZOLAM= "Alprazolam";
	public static final String OTHER_MEDIC= "Other_medic";
	public static final String DT_MEDIC= "Dt_medic";
	public static final String ID_SLEEP_STATE= "Id_sleep_state";
	public static final String SD_SLEEP_STATE= "Sd_sleep_state";
	public static final String ID_PRE_EDUCATION= "Id_pre_education";
	public static final String SD_PRE_EDUCATION= "Sd_pre_education";
	public static final String ID_SYMP_MANAGE= "Id_symp_manage";
	public static final String SD_SYMP_MANAGE= "Sd_symp_manage";
	public static final String ID_SELFCARE_ABILITY= "Id_selfcare_ability";
	public static final String SD_SELFCARE_ABILITY= "Sd_selfcare_ability";
	public static final String OTHER_RECORD= "Other_record";
	public static final String FG_ICU= "Fg_icu";
	public static final String NV_T_AFTER= "Nv_t_after";
	public static final String INT_PULSE_AFTER= "Int_pulse_after";
	public static final String INT_BREATH_AFTER= "Int_breath_after";
	public static final String INT_SBP_AFTER= "Int_sbp_after";
	public static final String INT_DBP_AFTER= "Int_dbp_after";
	public static final String DT_EVAL_AFTER= "Dt_eval_after";
	public static final String EU_VEIN_CHANNEL= "Eu_vein_channel";
	public static final String EU_UNOBSTRUCTED= "Eu_unobstructed";
	public static final String SITE= "Site";
	public static final String ID_AFTER_ANESTHESIA= "Id_after_anesthesia";
	public static final String SD_AFTER_ANESTHESIA= "Sd_after_anesthesia";
	public static final String OTHER_AFTER_ANESTHESIA= "Other_after_anesthesia";
	public static final String SURGICAL_WAY= "Surgical_way";
	public static final String ID_AWARENESS= "Id_awareness";
	public static final String SD_AWARENESS= "Sd_awareness";
	public static final String EU_LEFTEYE_REFLECT= "Eu_lefteye_reflect";
	public static final String EU_LEFTEYE_SIZE= "Eu_lefteye_size";
	public static final String EU_SKIN_STATE= "Eu_skin_state";
	public static final String LOCATION_AREA= "Location_area";
	public static final String EU_RIGHTEYE_REFLECT= "Eu_righteye_reflect";
	public static final String EU_RIGHTEYE_SIZE= "Eu_righteye_size";
	public static final String EU_EXUDATE= "Eu_exudate";
	public static final String EU_OOZING= "Eu_oozing";
	public static final String EU_SHEDDING= "Eu_shedding";
	public static final String ID_PRESSURE_LEVEL= "Id_pressure_level";
	public static final String SD_PRESSURE_LEVEL= "Sd_pressure_level";
	public static final String EU_URINARY_PATENCY= "Eu_urinary_patency";
	public static final String POSITION_DRAINAGE= "Position_drainage";
	public static final String NAME_DRAINAGE= "Name_drainage";
	public static final String EU_OBSTRUCTED= "Eu_obstructed";
	public static final String PROPERTIES_DRAINAGE= "Properties_drainage";
	public static final String ID_AFTER_EDUCATION= "Id_after_education";
	public static final String SD_AFTER_EDUCATION= "Sd_after_education";
	public static final String ID_SYMP_MANAGEAFTER= "Id_symp_manageafter";
	public static final String SD_SYMP_MANAGEAFTER= "Sd_symp_manageafter";
	public static final String ID_SELFCARE_ABILITYAFTER= "Id_selfcare_abilityafter";
	public static final String SD_SELFCARE_ABILITYAFTER= "Sd_selfcare_abilityafter";
	public static final String AFTER_OTHER_RECORD= "After_other_record";
	public static final String ID_SIGN= "Id_sign";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_EMP= "Id_emp";
	public static final String DT_CREATE= "Dt_create";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MENTAL_STATE= "Name_mental_state";
	public static final String NAME_PAST_HISTORY= "Name_past_history";
	public static final String NAME_NUTRITION_STATUS= "Name_nutrition_status";
	public static final String NAME_ANESTHESIA= "Name_anesthesia";
	public static final String NAME_SKIN_PREPARE= "Name_skin_prepare";
	public static final String NAME_BLOOD_PREPARE= "Name_blood_prepare";
	public static final String NAME_PIPE= "Name_pipe";
	public static final String NAME_PRE_MEDIC= "Name_pre_medic";
	public static final String NAME_SLEEP_STATE= "Name_sleep_state";
	public static final String NAME_PRE_EDUCATION= "Name_pre_education";
	public static final String NAME_SYMP_MANAGE= "Name_symp_manage";
	public static final String NAME_SELFCARE_ABILITY= "Name_selfcare_ability";
	public static final String NAME_AFTER_ANESTHESIA= "Name_after_anesthesia";
	public static final String NAME_AWARENESS= "Name_awareness";
	public static final String NAME_PRESSURE_LEVEL= "Name_pressure_level";
	public static final String NAME_AFTER_EDUCATION= "Name_after_education";
	public static final String NAME_SYMP_MANAGEAFTER= "Name_symp_manageafter";
	public static final String NAME_SELFCARE_ABILITYAFTER= "Name_selfcare_abilityafter";
	public static final String NAME_SIGN= "Name_sign";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_EMP= "Name_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opernur() {
		return ((String) getAttrVal("Id_opernur"));
	}	
	public void setId_opernur(String Id_opernur) {
		setAttrVal("Id_opernur", Id_opernur);
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
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_diagnosis() {
		return ((String) getAttrVal("Id_diagnosis"));
	}	
	public void setId_diagnosis(String Id_diagnosis) {
		setAttrVal("Id_diagnosis", Id_diagnosis);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public FDouble getNv_t_before() {
		return ((FDouble) getAttrVal("Nv_t_before"));
	}	
	public void setNv_t_before(FDouble Nv_t_before) {
		setAttrVal("Nv_t_before", Nv_t_before);
	}
	public Integer getInt_pulse_before() {
		return ((Integer) getAttrVal("Int_pulse_before"));
	}	
	public void setInt_pulse_before(Integer Int_pulse_before) {
		setAttrVal("Int_pulse_before", Int_pulse_before);
	}
	public Integer getInt_breath_before() {
		return ((Integer) getAttrVal("Int_breath_before"));
	}	
	public void setInt_breath_before(Integer Int_breath_before) {
		setAttrVal("Int_breath_before", Int_breath_before);
	}
	public Integer getInt_sbp_before() {
		return ((Integer) getAttrVal("Int_sbp_before"));
	}	
	public void setInt_sbp_before(Integer Int_sbp_before) {
		setAttrVal("Int_sbp_before", Int_sbp_before);
	}
	public Integer getInt_dbp_before() {
		return ((Integer) getAttrVal("Int_dbp_before"));
	}	
	public void setInt_dbp_before(Integer Int_dbp_before) {
		setAttrVal("Int_dbp_before", Int_dbp_before);
	}
	public FDateTime getDt_eval_before() {
		return ((FDateTime) getAttrVal("Dt_eval_before"));
	}	
	public void setDt_eval_before(FDateTime Dt_eval_before) {
		setAttrVal("Dt_eval_before", Dt_eval_before);
	}
	public String getId_mental_state() {
		return ((String) getAttrVal("Id_mental_state"));
	}	
	public void setId_mental_state(String Id_mental_state) {
		setAttrVal("Id_mental_state", Id_mental_state);
	}
	public String getSd_mental_state() {
		return ((String) getAttrVal("Sd_mental_state"));
	}	
	public void setSd_mental_state(String Sd_mental_state) {
		setAttrVal("Sd_mental_state", Sd_mental_state);
	}
	public String getId_past_history() {
		return ((String) getAttrVal("Id_past_history"));
	}	
	public void setId_past_history(String Id_past_history) {
		setAttrVal("Id_past_history", Id_past_history);
	}
	public String getSd_past_history() {
		return ((String) getAttrVal("Sd_past_history"));
	}	
	public void setSd_past_history(String Sd_past_history) {
		setAttrVal("Sd_past_history", Sd_past_history);
	}
	public String getOther_past_history() {
		return ((String) getAttrVal("Other_past_history"));
	}	
	public void setOther_past_history(String Other_past_history) {
		setAttrVal("Other_past_history", Other_past_history);
	}
	public String getId_nutrition_status() {
		return ((String) getAttrVal("Id_nutrition_status"));
	}	
	public void setId_nutrition_status(String Id_nutrition_status) {
		setAttrVal("Id_nutrition_status", Id_nutrition_status);
	}
	public String getSd_nutrition_status() {
		return ((String) getAttrVal("Sd_nutrition_status"));
	}	
	public void setSd_nutrition_status(String Sd_nutrition_status) {
		setAttrVal("Sd_nutrition_status", Sd_nutrition_status);
	}
	public FDateTime getDt_fast_begin() {
		return ((FDateTime) getAttrVal("Dt_fast_begin"));
	}	
	public void setDt_fast_begin(FDateTime Dt_fast_begin) {
		setAttrVal("Dt_fast_begin", Dt_fast_begin);
	}
	public String getName_operation() {
		return ((String) getAttrVal("Name_operation"));
	}	
	public void setName_operation(String Name_operation) {
		setAttrVal("Name_operation", Name_operation);
	}
	public FDateTime getDt_operation() {
		return ((FDateTime) getAttrVal("Dt_operation"));
	}	
	public void setDt_operation(FDateTime Dt_operation) {
		setAttrVal("Dt_operation", Dt_operation);
	}
	public String getId_anesthesia() {
		return ((String) getAttrVal("Id_anesthesia"));
	}	
	public void setId_anesthesia(String Id_anesthesia) {
		setAttrVal("Id_anesthesia", Id_anesthesia);
	}
	public String getSd_anesthesia() {
		return ((String) getAttrVal("Sd_anesthesia"));
	}	
	public void setSd_anesthesia(String Sd_anesthesia) {
		setAttrVal("Sd_anesthesia", Sd_anesthesia);
	}
	public String getOther_anesthesia() {
		return ((String) getAttrVal("Other_anesthesia"));
	}	
	public void setOther_anesthesia(String Other_anesthesia) {
		setAttrVal("Other_anesthesia", Other_anesthesia);
	}
	public Integer getEu_oper_site() {
		return ((Integer) getAttrVal("Eu_oper_site"));
	}	
	public void setEu_oper_site(Integer Eu_oper_site) {
		setAttrVal("Eu_oper_site", Eu_oper_site);
	}
	public String getId_skin_prepare() {
		return ((String) getAttrVal("Id_skin_prepare"));
	}	
	public void setId_skin_prepare(String Id_skin_prepare) {
		setAttrVal("Id_skin_prepare", Id_skin_prepare);
	}
	public String getSd_skin_prepare() {
		return ((String) getAttrVal("Sd_skin_prepare"));
	}	
	public void setSd_skin_prepare(String Sd_skin_prepare) {
		setAttrVal("Sd_skin_prepare", Sd_skin_prepare);
	}
	public String getId_blood_prepare() {
		return ((String) getAttrVal("Id_blood_prepare"));
	}	
	public void setId_blood_prepare(String Id_blood_prepare) {
		setAttrVal("Id_blood_prepare", Id_blood_prepare);
	}
	public String getSd_blood_prepare() {
		return ((String) getAttrVal("Sd_blood_prepare"));
	}	
	public void setSd_blood_prepare(String Sd_blood_prepare) {
		setAttrVal("Sd_blood_prepare", Sd_blood_prepare);
	}
	public String getId_pipe() {
		return ((String) getAttrVal("Id_pipe"));
	}	
	public void setId_pipe(String Id_pipe) {
		setAttrVal("Id_pipe", Id_pipe);
	}
	public String getSd_pipe() {
		return ((String) getAttrVal("Sd_pipe"));
	}	
	public void setSd_pipe(String Sd_pipe) {
		setAttrVal("Sd_pipe", Sd_pipe);
	}
	public String getOther_pipe() {
		return ((String) getAttrVal("Other_pipe"));
	}	
	public void setOther_pipe(String Other_pipe) {
		setAttrVal("Other_pipe", Other_pipe);
	}
	public String getId_pre_medic() {
		return ((String) getAttrVal("Id_pre_medic"));
	}	
	public void setId_pre_medic(String Id_pre_medic) {
		setAttrVal("Id_pre_medic", Id_pre_medic);
	}
	public String getSd_pre_medic() {
		return ((String) getAttrVal("Sd_pre_medic"));
	}	
	public void setSd_pre_medic(String Sd_pre_medic) {
		setAttrVal("Sd_pre_medic", Sd_pre_medic);
	}
	public Integer getStable() {
		return ((Integer) getAttrVal("Stable"));
	}	
	public void setStable(Integer Stable) {
		setAttrVal("Stable", Stable);
	}
	public Integer getAlprazolam() {
		return ((Integer) getAttrVal("Alprazolam"));
	}	
	public void setAlprazolam(Integer Alprazolam) {
		setAttrVal("Alprazolam", Alprazolam);
	}
	public String getOther_medic() {
		return ((String) getAttrVal("Other_medic"));
	}	
	public void setOther_medic(String Other_medic) {
		setAttrVal("Other_medic", Other_medic);
	}
	public FDateTime getDt_medic() {
		return ((FDateTime) getAttrVal("Dt_medic"));
	}	
	public void setDt_medic(FDateTime Dt_medic) {
		setAttrVal("Dt_medic", Dt_medic);
	}
	public String getId_sleep_state() {
		return ((String) getAttrVal("Id_sleep_state"));
	}	
	public void setId_sleep_state(String Id_sleep_state) {
		setAttrVal("Id_sleep_state", Id_sleep_state);
	}
	public String getSd_sleep_state() {
		return ((String) getAttrVal("Sd_sleep_state"));
	}	
	public void setSd_sleep_state(String Sd_sleep_state) {
		setAttrVal("Sd_sleep_state", Sd_sleep_state);
	}
	public String getId_pre_education() {
		return ((String) getAttrVal("Id_pre_education"));
	}	
	public void setId_pre_education(String Id_pre_education) {
		setAttrVal("Id_pre_education", Id_pre_education);
	}
	public String getSd_pre_education() {
		return ((String) getAttrVal("Sd_pre_education"));
	}	
	public void setSd_pre_education(String Sd_pre_education) {
		setAttrVal("Sd_pre_education", Sd_pre_education);
	}
	public String getId_symp_manage() {
		return ((String) getAttrVal("Id_symp_manage"));
	}	
	public void setId_symp_manage(String Id_symp_manage) {
		setAttrVal("Id_symp_manage", Id_symp_manage);
	}
	public String getSd_symp_manage() {
		return ((String) getAttrVal("Sd_symp_manage"));
	}	
	public void setSd_symp_manage(String Sd_symp_manage) {
		setAttrVal("Sd_symp_manage", Sd_symp_manage);
	}
	public String getId_selfcare_ability() {
		return ((String) getAttrVal("Id_selfcare_ability"));
	}	
	public void setId_selfcare_ability(String Id_selfcare_ability) {
		setAttrVal("Id_selfcare_ability", Id_selfcare_ability);
	}
	public String getSd_selfcare_ability() {
		return ((String) getAttrVal("Sd_selfcare_ability"));
	}	
	public void setSd_selfcare_ability(String Sd_selfcare_ability) {
		setAttrVal("Sd_selfcare_ability", Sd_selfcare_ability);
	}
	public String getOther_record() {
		return ((String) getAttrVal("Other_record"));
	}	
	public void setOther_record(String Other_record) {
		setAttrVal("Other_record", Other_record);
	}
	public FBoolean getFg_icu() {
		return ((FBoolean) getAttrVal("Fg_icu"));
	}	
	public void setFg_icu(FBoolean Fg_icu) {
		setAttrVal("Fg_icu", Fg_icu);
	}
	public FDouble getNv_t_after() {
		return ((FDouble) getAttrVal("Nv_t_after"));
	}	
	public void setNv_t_after(FDouble Nv_t_after) {
		setAttrVal("Nv_t_after", Nv_t_after);
	}
	public Integer getInt_pulse_after() {
		return ((Integer) getAttrVal("Int_pulse_after"));
	}	
	public void setInt_pulse_after(Integer Int_pulse_after) {
		setAttrVal("Int_pulse_after", Int_pulse_after);
	}
	public Integer getInt_breath_after() {
		return ((Integer) getAttrVal("Int_breath_after"));
	}	
	public void setInt_breath_after(Integer Int_breath_after) {
		setAttrVal("Int_breath_after", Int_breath_after);
	}
	public Integer getInt_sbp_after() {
		return ((Integer) getAttrVal("Int_sbp_after"));
	}	
	public void setInt_sbp_after(Integer Int_sbp_after) {
		setAttrVal("Int_sbp_after", Int_sbp_after);
	}
	public Integer getInt_dbp_after() {
		return ((Integer) getAttrVal("Int_dbp_after"));
	}	
	public void setInt_dbp_after(Integer Int_dbp_after) {
		setAttrVal("Int_dbp_after", Int_dbp_after);
	}
	public FDateTime getDt_eval_after() {
		return ((FDateTime) getAttrVal("Dt_eval_after"));
	}	
	public void setDt_eval_after(FDateTime Dt_eval_after) {
		setAttrVal("Dt_eval_after", Dt_eval_after);
	}
	public Integer getEu_vein_channel() {
		return ((Integer) getAttrVal("Eu_vein_channel"));
	}	
	public void setEu_vein_channel(Integer Eu_vein_channel) {
		setAttrVal("Eu_vein_channel", Eu_vein_channel);
	}
	public Integer getEu_unobstructed() {
		return ((Integer) getAttrVal("Eu_unobstructed"));
	}	
	public void setEu_unobstructed(Integer Eu_unobstructed) {
		setAttrVal("Eu_unobstructed", Eu_unobstructed);
	}
	public String getSite() {
		return ((String) getAttrVal("Site"));
	}	
	public void setSite(String Site) {
		setAttrVal("Site", Site);
	}
	public String getId_after_anesthesia() {
		return ((String) getAttrVal("Id_after_anesthesia"));
	}	
	public void setId_after_anesthesia(String Id_after_anesthesia) {
		setAttrVal("Id_after_anesthesia", Id_after_anesthesia);
	}
	public String getSd_after_anesthesia() {
		return ((String) getAttrVal("Sd_after_anesthesia"));
	}	
	public void setSd_after_anesthesia(String Sd_after_anesthesia) {
		setAttrVal("Sd_after_anesthesia", Sd_after_anesthesia);
	}
	public String getOther_after_anesthesia() {
		return ((String) getAttrVal("Other_after_anesthesia"));
	}	
	public void setOther_after_anesthesia(String Other_after_anesthesia) {
		setAttrVal("Other_after_anesthesia", Other_after_anesthesia);
	}
	public String getSurgical_way() {
		return ((String) getAttrVal("Surgical_way"));
	}	
	public void setSurgical_way(String Surgical_way) {
		setAttrVal("Surgical_way", Surgical_way);
	}
	public String getId_awareness() {
		return ((String) getAttrVal("Id_awareness"));
	}	
	public void setId_awareness(String Id_awareness) {
		setAttrVal("Id_awareness", Id_awareness);
	}
	public String getSd_awareness() {
		return ((String) getAttrVal("Sd_awareness"));
	}	
	public void setSd_awareness(String Sd_awareness) {
		setAttrVal("Sd_awareness", Sd_awareness);
	}
	public Integer getEu_lefteye_reflect() {
		return ((Integer) getAttrVal("Eu_lefteye_reflect"));
	}	
	public void setEu_lefteye_reflect(Integer Eu_lefteye_reflect) {
		setAttrVal("Eu_lefteye_reflect", Eu_lefteye_reflect);
	}
	public Integer getEu_lefteye_size() {
		return ((Integer) getAttrVal("Eu_lefteye_size"));
	}	
	public void setEu_lefteye_size(Integer Eu_lefteye_size) {
		setAttrVal("Eu_lefteye_size", Eu_lefteye_size);
	}
	public Integer getEu_skin_state() {
		return ((Integer) getAttrVal("Eu_skin_state"));
	}	
	public void setEu_skin_state(Integer Eu_skin_state) {
		setAttrVal("Eu_skin_state", Eu_skin_state);
	}
	public String getLocation_area() {
		return ((String) getAttrVal("Location_area"));
	}	
	public void setLocation_area(String Location_area) {
		setAttrVal("Location_area", Location_area);
	}
	public Integer getEu_righteye_reflect() {
		return ((Integer) getAttrVal("Eu_righteye_reflect"));
	}	
	public void setEu_righteye_reflect(Integer Eu_righteye_reflect) {
		setAttrVal("Eu_righteye_reflect", Eu_righteye_reflect);
	}
	public Integer getEu_righteye_size() {
		return ((Integer) getAttrVal("Eu_righteye_size"));
	}	
	public void setEu_righteye_size(Integer Eu_righteye_size) {
		setAttrVal("Eu_righteye_size", Eu_righteye_size);
	}
	public Integer getEu_exudate() {
		return ((Integer) getAttrVal("Eu_exudate"));
	}	
	public void setEu_exudate(Integer Eu_exudate) {
		setAttrVal("Eu_exudate", Eu_exudate);
	}
	public Integer getEu_oozing() {
		return ((Integer) getAttrVal("Eu_oozing"));
	}	
	public void setEu_oozing(Integer Eu_oozing) {
		setAttrVal("Eu_oozing", Eu_oozing);
	}
	public Integer getEu_shedding() {
		return ((Integer) getAttrVal("Eu_shedding"));
	}	
	public void setEu_shedding(Integer Eu_shedding) {
		setAttrVal("Eu_shedding", Eu_shedding);
	}
	public String getId_pressure_level() {
		return ((String) getAttrVal("Id_pressure_level"));
	}	
	public void setId_pressure_level(String Id_pressure_level) {
		setAttrVal("Id_pressure_level", Id_pressure_level);
	}
	public String getSd_pressure_level() {
		return ((String) getAttrVal("Sd_pressure_level"));
	}	
	public void setSd_pressure_level(String Sd_pressure_level) {
		setAttrVal("Sd_pressure_level", Sd_pressure_level);
	}
	public Integer getEu_urinary_patency() {
		return ((Integer) getAttrVal("Eu_urinary_patency"));
	}	
	public void setEu_urinary_patency(Integer Eu_urinary_patency) {
		setAttrVal("Eu_urinary_patency", Eu_urinary_patency);
	}
	public String getPosition_drainage() {
		return ((String) getAttrVal("Position_drainage"));
	}	
	public void setPosition_drainage(String Position_drainage) {
		setAttrVal("Position_drainage", Position_drainage);
	}
	public String getName_drainage() {
		return ((String) getAttrVal("Name_drainage"));
	}	
	public void setName_drainage(String Name_drainage) {
		setAttrVal("Name_drainage", Name_drainage);
	}
	public Integer getEu_obstructed() {
		return ((Integer) getAttrVal("Eu_obstructed"));
	}	
	public void setEu_obstructed(Integer Eu_obstructed) {
		setAttrVal("Eu_obstructed", Eu_obstructed);
	}
	public String getProperties_drainage() {
		return ((String) getAttrVal("Properties_drainage"));
	}	
	public void setProperties_drainage(String Properties_drainage) {
		setAttrVal("Properties_drainage", Properties_drainage);
	}
	public String getId_after_education() {
		return ((String) getAttrVal("Id_after_education"));
	}	
	public void setId_after_education(String Id_after_education) {
		setAttrVal("Id_after_education", Id_after_education);
	}
	public String getSd_after_education() {
		return ((String) getAttrVal("Sd_after_education"));
	}	
	public void setSd_after_education(String Sd_after_education) {
		setAttrVal("Sd_after_education", Sd_after_education);
	}
	public String getId_symp_manageafter() {
		return ((String) getAttrVal("Id_symp_manageafter"));
	}	
	public void setId_symp_manageafter(String Id_symp_manageafter) {
		setAttrVal("Id_symp_manageafter", Id_symp_manageafter);
	}
	public String getSd_symp_manageafter() {
		return ((String) getAttrVal("Sd_symp_manageafter"));
	}	
	public void setSd_symp_manageafter(String Sd_symp_manageafter) {
		setAttrVal("Sd_symp_manageafter", Sd_symp_manageafter);
	}
	public String getId_selfcare_abilityafter() {
		return ((String) getAttrVal("Id_selfcare_abilityafter"));
	}	
	public void setId_selfcare_abilityafter(String Id_selfcare_abilityafter) {
		setAttrVal("Id_selfcare_abilityafter", Id_selfcare_abilityafter);
	}
	public String getSd_selfcare_abilityafter() {
		return ((String) getAttrVal("Sd_selfcare_abilityafter"));
	}	
	public void setSd_selfcare_abilityafter(String Sd_selfcare_abilityafter) {
		setAttrVal("Sd_selfcare_abilityafter", Sd_selfcare_abilityafter);
	}
	public String getAfter_other_record() {
		return ((String) getAttrVal("After_other_record"));
	}	
	public void setAfter_other_record(String After_other_record) {
		setAttrVal("After_other_record", After_other_record);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	public String getName_mental_state() {
		return ((String) getAttrVal("Name_mental_state"));
	}	
	public void setName_mental_state(String Name_mental_state) {
		setAttrVal("Name_mental_state", Name_mental_state);
	}
	public String getName_past_history() {
		return ((String) getAttrVal("Name_past_history"));
	}	
	public void setName_past_history(String Name_past_history) {
		setAttrVal("Name_past_history", Name_past_history);
	}
	public String getName_nutrition_status() {
		return ((String) getAttrVal("Name_nutrition_status"));
	}	
	public void setName_nutrition_status(String Name_nutrition_status) {
		setAttrVal("Name_nutrition_status", Name_nutrition_status);
	}
	public String getName_anesthesia() {
		return ((String) getAttrVal("Name_anesthesia"));
	}	
	public void setName_anesthesia(String Name_anesthesia) {
		setAttrVal("Name_anesthesia", Name_anesthesia);
	}
	public String getName_skin_prepare() {
		return ((String) getAttrVal("Name_skin_prepare"));
	}	
	public void setName_skin_prepare(String Name_skin_prepare) {
		setAttrVal("Name_skin_prepare", Name_skin_prepare);
	}
	public String getName_blood_prepare() {
		return ((String) getAttrVal("Name_blood_prepare"));
	}	
	public void setName_blood_prepare(String Name_blood_prepare) {
		setAttrVal("Name_blood_prepare", Name_blood_prepare);
	}
	public String getName_pipe() {
		return ((String) getAttrVal("Name_pipe"));
	}	
	public void setName_pipe(String Name_pipe) {
		setAttrVal("Name_pipe", Name_pipe);
	}
	public String getName_pre_medic() {
		return ((String) getAttrVal("Name_pre_medic"));
	}	
	public void setName_pre_medic(String Name_pre_medic) {
		setAttrVal("Name_pre_medic", Name_pre_medic);
	}
	public String getName_sleep_state() {
		return ((String) getAttrVal("Name_sleep_state"));
	}	
	public void setName_sleep_state(String Name_sleep_state) {
		setAttrVal("Name_sleep_state", Name_sleep_state);
	}
	public String getName_pre_education() {
		return ((String) getAttrVal("Name_pre_education"));
	}	
	public void setName_pre_education(String Name_pre_education) {
		setAttrVal("Name_pre_education", Name_pre_education);
	}
	public String getName_symp_manage() {
		return ((String) getAttrVal("Name_symp_manage"));
	}	
	public void setName_symp_manage(String Name_symp_manage) {
		setAttrVal("Name_symp_manage", Name_symp_manage);
	}
	public String getName_selfcare_ability() {
		return ((String) getAttrVal("Name_selfcare_ability"));
	}	
	public void setName_selfcare_ability(String Name_selfcare_ability) {
		setAttrVal("Name_selfcare_ability", Name_selfcare_ability);
	}
	public String getName_after_anesthesia() {
		return ((String) getAttrVal("Name_after_anesthesia"));
	}	
	public void setName_after_anesthesia(String Name_after_anesthesia) {
		setAttrVal("Name_after_anesthesia", Name_after_anesthesia);
	}
	public String getName_awareness() {
		return ((String) getAttrVal("Name_awareness"));
	}	
	public void setName_awareness(String Name_awareness) {
		setAttrVal("Name_awareness", Name_awareness);
	}
	public String getName_pressure_level() {
		return ((String) getAttrVal("Name_pressure_level"));
	}	
	public void setName_pressure_level(String Name_pressure_level) {
		setAttrVal("Name_pressure_level", Name_pressure_level);
	}
	public String getName_after_education() {
		return ((String) getAttrVal("Name_after_education"));
	}	
	public void setName_after_education(String Name_after_education) {
		setAttrVal("Name_after_education", Name_after_education);
	}
	public String getName_symp_manageafter() {
		return ((String) getAttrVal("Name_symp_manageafter"));
	}	
	public void setName_symp_manageafter(String Name_symp_manageafter) {
		setAttrVal("Name_symp_manageafter", Name_symp_manageafter);
	}
	public String getName_selfcare_abilityafter() {
		return ((String) getAttrVal("Name_selfcare_abilityafter"));
	}	
	public void setName_selfcare_abilityafter(String Name_selfcare_abilityafter) {
		setAttrVal("Name_selfcare_abilityafter", Name_selfcare_abilityafter);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
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
		return "Id_opernur";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BCH_OPERNUR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperNurDODesc.class);
	}
	
}