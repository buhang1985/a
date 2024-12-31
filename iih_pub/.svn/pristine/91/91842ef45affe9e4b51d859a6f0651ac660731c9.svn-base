package iih.nmr.ha.tcho.admissionnursing.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.ha.tcho.admissionnursing.d.desc.TchoAdmissionNursingDODesc;
import java.math.BigDecimal;

/**
 * 入院护理评估记录单 DO数据 
 * 
 */
public class TchoAdmissionNursingDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ANA= "Id_ana";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_SEX= "Name_sex";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NAME_DOCUMENT_TYPE= "Name_document_type";
	public static final String NAME_NATION= "Name_nation";
	public static final String ID_ROUTE_ADMISSION= "Id_route_admission";
	public static final String SD_ROUTE_ADMISSION= "Sd_route_admission";
	public static final String ID_WAY_ADMISSION= "Id_way_admission";
	public static final String SD_WAY_ADMISSION= "Sd_way_admission";
	public static final String PAIN_SCORE= "Pain_score";
	public static final String FG_PASTMEDIC= "Fg_pastmedic";
	public static final String ALLERGY_HISTORYED= "Allergy_historyed";
	public static final String FG_ALLERGY= "Fg_allergy";
	public static final String PAST_HISTORYED= "Past_historyed";
	public static final String ID_SOLAR_ILL= "Id_solar_ill";
	public static final String SD_SOLAR_ILL= "Sd_solar_ill";
	public static final String FG_UNOBSTRUCTED= "Fg_unobstructed";
	public static final String PIPESCARRYED= "Pipescarryed";
	public static final String FG_CARRY_PIPES= "Fg_carry_pipes";
	public static final String EAST_DIAGNOSIS= "East_diagnosis";
	public static final String WESTERN_DIAGNOSIS= "Western_diagnosis";
	public static final String ID_LOOK_STATES= "Id_look_states";
	public static final String SD_LOOK_STATES= "Sd_look_states";
	public static final String OTHER_LOOK_STATES= "Other_look_states";
	public static final String ID_COMPLEXION= "Id_complexion";
	public static final String SD_COMPLEXION= "Sd_complexion";
	public static final String OTHER_COMPLEXION= "Other_complexion";
	public static final String ID_SHAPE= "Id_shape";
	public static final String SD_SHAPE= "Sd_shape";
	public static final String OTHER_SHAPE= "Other_shape";
	public static final String ID_FORM= "Id_form";
	public static final String SD_FORM= "Sd_form";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String OTHER_SKIN= "Other_skin";
	public static final String ID_TONGUE= "Id_tongue";
	public static final String SD_TONGUE= "Sd_tongue";
	public static final String OTHER_TONGUE= "Other_tongue";
	public static final String ID_FURRED_TONGUE= "Id_furred_tongue";
	public static final String SD_FURRED_TONGUE= "Sd_furred_tongue";
	public static final String OTHER_FURRED_TONGUE= "Other_furred_tongue";
	public static final String ID_VOICE= "Id_voice";
	public static final String SD_VOICE= "Sd_voice";
	public static final String OTHER_VOICE= "Other_voice";
	public static final String ID_BREATHE= "Id_breathe";
	public static final String SD_BREATHE= "Sd_breathe";
	public static final String OTHER_BREATHE= "Other_breathe";
	public static final String ID_COUGH= "Id_cough";
	public static final String SD_COUGH= "Sd_cough";
	public static final String OTHER_COUGH= "Other_cough";
	public static final String ID_COLD_HEAT= "Id_cold_heat";
	public static final String SD_COLD_HEAT= "Sd_cold_heat";
	public static final String OTHER_COLD_HEAT= "Other_cold_heat";
	public static final String ID_SWEAT= "Id_sweat";
	public static final String SD_SWEAT= "Sd_sweat";
	public static final String OTHER_SWEAT= "Other_sweat";
	public static final String ID_DIET= "Id_diet";
	public static final String SD_DIET= "Sd_diet";
	public static final String OTHER_DIET= "Other_diet";
	public static final String ID_SLEEP= "Id_sleep";
	public static final String SD_SLEEP= "Sd_sleep";
	public static final String OTHER_SLEEP= "Other_sleep";
	public static final String ID_STOOL= "Id_stool";
	public static final String SD_STOOL= "Sd_stool";
	public static final String OTHER_STOOL= "Other_stool";
	public static final String ID_URINATE= "Id_urinate";
	public static final String SD_URINATE= "Sd_urinate";
	public static final String OTHER_URINATE= "Other_urinate";
	public static final String ID_HOBBY= "Id_hobby";
	public static final String SD_HOBBY= "Sd_hobby";
	public static final String OTHER_HOBBY= "Other_hobby";
	public static final String ID_PULSE= "Id_pulse";
	public static final String SD_PULSE= "Sd_pulse";
	public static final String OTHER_PULSE= "Other_pulse";
	public static final String ID_WRIST= "Id_wrist";
	public static final String SD_WRIST= "Sd_wrist";
	public static final String OTHER_WRIST= "Other_wrist";
	public static final String ID_SELT_CARE= "Id_selt_care";
	public static final String SD_SELT_CARE= "Sd_selt_care";
	public static final String ID_FAMILY_RELATION= "Id_family_relation";
	public static final String SD_FAMILY_RELATION= "Sd_family_relation";
	public static final String ID_SOCIAL_ADAPTABILITY= "Id_social_adaptability";
	public static final String SD_SOCIAL_ADAPTABILITY= "Sd_social_adaptability";
	public static final String ID_LEFT_LEG= "Id_left_leg";
	public static final String SD_LEFT_LEG= "Sd_left_leg";
	public static final String ID_RIGHT_LEG= "Id_right_leg";
	public static final String SD_RIGHT_LEG= "Sd_right_leg";
	public static final String ID_LEFT_HAND= "Id_left_hand";
	public static final String SD_LEFT_HAND= "Sd_left_hand";
	public static final String ID_RIGHT_HAND= "Id_right_hand";
	public static final String SD_RIGHT_HAND= "Sd_right_hand";
	public static final String ID_SPINE= "Id_spine";
	public static final String SD_SPINE= "Sd_spine";
	public static final String ID_ETIOLOGY= "Id_etiology";
	public static final String SD_ETIOLOGY= "Sd_etiology";
	public static final String OTHER_ETIOLOGY= "Other_etiology";
	public static final String ID_SICK_PLACE= "Id_sick_place";
	public static final String SD_SICK_PLACE= "Sd_sick_place";
	public static final String OTHER_SICK_PLACE= "Other_sick_place";
	public static final String ID_ADMISSION_MISSION= "Id_admission_mission";
	public static final String SD_ADMISSION_MISSION= "Sd_admission_mission";
	public static final String NURSE_PLAN= "Nurse_plan";
	public static final String ID_EMP_EVALUATION= "Id_emp_evaluation";
	public static final String DT_EVALUATION= "Dt_evaluation";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SYNDROMES= "Syndromes";
	public static final String NAME_ROUTE_ADMISSION= "Name_route_admission";
	public static final String NAME_WAY_ADMISSION= "Name_way_admission";
	public static final String NAME_SOLAR_ILL= "Name_solar_ill";
	public static final String NAME_LOOK_STATES= "Name_look_states";
	public static final String NAME_COMPLEXION= "Name_complexion";
	public static final String NAME_SHAPE= "Name_shape";
	public static final String NAME_FORM= "Name_form";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_TONGUE= "Name_tongue";
	public static final String NAME_FURRED_TONGUE= "Name_furred_tongue";
	public static final String NAME_VOICE= "Name_voice";
	public static final String NAME_BREATHE= "Name_breathe";
	public static final String NAME_COUGH= "Name_cough";
	public static final String NAME_COLD_HEAT= "Name_cold_heat";
	public static final String NAME_SWEAT= "Name_sweat";
	public static final String NAME_DIET= "Name_diet";
	public static final String NAME_SLEEP= "Name_sleep";
	public static final String NAME_STOOL= "Name_stool";
	public static final String NAME_URINATE= "Name_urinate";
	public static final String NAME_HOBBY= "Name_hobby";
	public static final String NAME_PULSE= "Name_pulse";
	public static final String NAME_WRIST= "Name_wrist";
	public static final String NAME_SELT_CARE= "Name_selt_care";
	public static final String NAME_FAMILY_RELATION= "Name_family_relation";
	public static final String NAME_SOCIAL_ADAPTABILITY= "Name_social_adaptability";
	public static final String NAME_LEFT_LEG= "Name_left_leg";
	public static final String NAME_RIGHT_LEG= "Name_right_leg";
	public static final String NAME_LEFT_HAND= "Name_left_hand";
	public static final String NAME_RIGHT_HAND= "Name_right_hand";
	public static final String NAME_SPINE= "Name_spine";
	public static final String NAME_ETIOLOGY= "Name_etiology";
	public static final String NAME_SICK_PLACE= "Name_sick_place";
	public static final String NAME_ADMISSION_MISSION= "Name_admission_mission";
	public static final String NAME_EMP_EVALUATION= "Name_emp_evaluation";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ana() {
		return ((String) getAttrVal("Id_ana"));
	}	
	public void setId_ana(String Id_ana) {
		setAttrVal("Id_ana", Id_ana);
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
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
	public String getName_document_type() {
		return ((String) getAttrVal("Name_document_type"));
	}	
	public void setName_document_type(String Name_document_type) {
		setAttrVal("Name_document_type", Name_document_type);
	}
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	public String getId_route_admission() {
		return ((String) getAttrVal("Id_route_admission"));
	}	
	public void setId_route_admission(String Id_route_admission) {
		setAttrVal("Id_route_admission", Id_route_admission);
	}
	public String getSd_route_admission() {
		return ((String) getAttrVal("Sd_route_admission"));
	}	
	public void setSd_route_admission(String Sd_route_admission) {
		setAttrVal("Sd_route_admission", Sd_route_admission);
	}
	public String getId_way_admission() {
		return ((String) getAttrVal("Id_way_admission"));
	}	
	public void setId_way_admission(String Id_way_admission) {
		setAttrVal("Id_way_admission", Id_way_admission);
	}
	public String getSd_way_admission() {
		return ((String) getAttrVal("Sd_way_admission"));
	}	
	public void setSd_way_admission(String Sd_way_admission) {
		setAttrVal("Sd_way_admission", Sd_way_admission);
	}
	public Integer getPain_score() {
		return ((Integer) getAttrVal("Pain_score"));
	}	
	public void setPain_score(Integer Pain_score) {
		setAttrVal("Pain_score", Pain_score);
	}
	public FBoolean getFg_pastmedic() {
		return ((FBoolean) getAttrVal("Fg_pastmedic"));
	}	
	public void setFg_pastmedic(FBoolean Fg_pastmedic) {
		setAttrVal("Fg_pastmedic", Fg_pastmedic);
	}
	public String getAllergy_historyed() {
		return ((String) getAttrVal("Allergy_historyed"));
	}	
	public void setAllergy_historyed(String Allergy_historyed) {
		setAttrVal("Allergy_historyed", Allergy_historyed);
	}
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	public String getPast_historyed() {
		return ((String) getAttrVal("Past_historyed"));
	}	
	public void setPast_historyed(String Past_historyed) {
		setAttrVal("Past_historyed", Past_historyed);
	}
	public String getId_solar_ill() {
		return ((String) getAttrVal("Id_solar_ill"));
	}	
	public void setId_solar_ill(String Id_solar_ill) {
		setAttrVal("Id_solar_ill", Id_solar_ill);
	}
	public String getSd_solar_ill() {
		return ((String) getAttrVal("Sd_solar_ill"));
	}	
	public void setSd_solar_ill(String Sd_solar_ill) {
		setAttrVal("Sd_solar_ill", Sd_solar_ill);
	}
	public FBoolean getFg_unobstructed() {
		return ((FBoolean) getAttrVal("Fg_unobstructed"));
	}	
	public void setFg_unobstructed(FBoolean Fg_unobstructed) {
		setAttrVal("Fg_unobstructed", Fg_unobstructed);
	}
	public String getPipescarryed() {
		return ((String) getAttrVal("Pipescarryed"));
	}	
	public void setPipescarryed(String Pipescarryed) {
		setAttrVal("Pipescarryed", Pipescarryed);
	}
	public FBoolean getFg_carry_pipes() {
		return ((FBoolean) getAttrVal("Fg_carry_pipes"));
	}	
	public void setFg_carry_pipes(FBoolean Fg_carry_pipes) {
		setAttrVal("Fg_carry_pipes", Fg_carry_pipes);
	}
	public String getEast_diagnosis() {
		return ((String) getAttrVal("East_diagnosis"));
	}	
	public void setEast_diagnosis(String East_diagnosis) {
		setAttrVal("East_diagnosis", East_diagnosis);
	}
	public String getWestern_diagnosis() {
		return ((String) getAttrVal("Western_diagnosis"));
	}	
	public void setWestern_diagnosis(String Western_diagnosis) {
		setAttrVal("Western_diagnosis", Western_diagnosis);
	}
	public String getId_look_states() {
		return ((String) getAttrVal("Id_look_states"));
	}	
	public void setId_look_states(String Id_look_states) {
		setAttrVal("Id_look_states", Id_look_states);
	}
	public String getSd_look_states() {
		return ((String) getAttrVal("Sd_look_states"));
	}	
	public void setSd_look_states(String Sd_look_states) {
		setAttrVal("Sd_look_states", Sd_look_states);
	}
	public String getOther_look_states() {
		return ((String) getAttrVal("Other_look_states"));
	}	
	public void setOther_look_states(String Other_look_states) {
		setAttrVal("Other_look_states", Other_look_states);
	}
	public String getId_complexion() {
		return ((String) getAttrVal("Id_complexion"));
	}	
	public void setId_complexion(String Id_complexion) {
		setAttrVal("Id_complexion", Id_complexion);
	}
	public String getSd_complexion() {
		return ((String) getAttrVal("Sd_complexion"));
	}	
	public void setSd_complexion(String Sd_complexion) {
		setAttrVal("Sd_complexion", Sd_complexion);
	}
	public String getOther_complexion() {
		return ((String) getAttrVal("Other_complexion"));
	}	
	public void setOther_complexion(String Other_complexion) {
		setAttrVal("Other_complexion", Other_complexion);
	}
	public String getId_shape() {
		return ((String) getAttrVal("Id_shape"));
	}	
	public void setId_shape(String Id_shape) {
		setAttrVal("Id_shape", Id_shape);
	}
	public String getSd_shape() {
		return ((String) getAttrVal("Sd_shape"));
	}	
	public void setSd_shape(String Sd_shape) {
		setAttrVal("Sd_shape", Sd_shape);
	}
	public String getOther_shape() {
		return ((String) getAttrVal("Other_shape"));
	}	
	public void setOther_shape(String Other_shape) {
		setAttrVal("Other_shape", Other_shape);
	}
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	public String getSd_form() {
		return ((String) getAttrVal("Sd_form"));
	}	
	public void setSd_form(String Sd_form) {
		setAttrVal("Sd_form", Sd_form);
	}
	public String getId_skin() {
		return ((String) getAttrVal("Id_skin"));
	}	
	public void setId_skin(String Id_skin) {
		setAttrVal("Id_skin", Id_skin);
	}
	public String getSd_skin() {
		return ((String) getAttrVal("Sd_skin"));
	}	
	public void setSd_skin(String Sd_skin) {
		setAttrVal("Sd_skin", Sd_skin);
	}
	public String getOther_skin() {
		return ((String) getAttrVal("Other_skin"));
	}	
	public void setOther_skin(String Other_skin) {
		setAttrVal("Other_skin", Other_skin);
	}
	public String getId_tongue() {
		return ((String) getAttrVal("Id_tongue"));
	}	
	public void setId_tongue(String Id_tongue) {
		setAttrVal("Id_tongue", Id_tongue);
	}
	public String getSd_tongue() {
		return ((String) getAttrVal("Sd_tongue"));
	}	
	public void setSd_tongue(String Sd_tongue) {
		setAttrVal("Sd_tongue", Sd_tongue);
	}
	public String getOther_tongue() {
		return ((String) getAttrVal("Other_tongue"));
	}	
	public void setOther_tongue(String Other_tongue) {
		setAttrVal("Other_tongue", Other_tongue);
	}
	public String getId_furred_tongue() {
		return ((String) getAttrVal("Id_furred_tongue"));
	}	
	public void setId_furred_tongue(String Id_furred_tongue) {
		setAttrVal("Id_furred_tongue", Id_furred_tongue);
	}
	public String getSd_furred_tongue() {
		return ((String) getAttrVal("Sd_furred_tongue"));
	}	
	public void setSd_furred_tongue(String Sd_furred_tongue) {
		setAttrVal("Sd_furred_tongue", Sd_furred_tongue);
	}
	public String getOther_furred_tongue() {
		return ((String) getAttrVal("Other_furred_tongue"));
	}	
	public void setOther_furred_tongue(String Other_furred_tongue) {
		setAttrVal("Other_furred_tongue", Other_furred_tongue);
	}
	public String getId_voice() {
		return ((String) getAttrVal("Id_voice"));
	}	
	public void setId_voice(String Id_voice) {
		setAttrVal("Id_voice", Id_voice);
	}
	public String getSd_voice() {
		return ((String) getAttrVal("Sd_voice"));
	}	
	public void setSd_voice(String Sd_voice) {
		setAttrVal("Sd_voice", Sd_voice);
	}
	public String getOther_voice() {
		return ((String) getAttrVal("Other_voice"));
	}	
	public void setOther_voice(String Other_voice) {
		setAttrVal("Other_voice", Other_voice);
	}
	public String getId_breathe() {
		return ((String) getAttrVal("Id_breathe"));
	}	
	public void setId_breathe(String Id_breathe) {
		setAttrVal("Id_breathe", Id_breathe);
	}
	public String getSd_breathe() {
		return ((String) getAttrVal("Sd_breathe"));
	}	
	public void setSd_breathe(String Sd_breathe) {
		setAttrVal("Sd_breathe", Sd_breathe);
	}
	public String getOther_breathe() {
		return ((String) getAttrVal("Other_breathe"));
	}	
	public void setOther_breathe(String Other_breathe) {
		setAttrVal("Other_breathe", Other_breathe);
	}
	public String getId_cough() {
		return ((String) getAttrVal("Id_cough"));
	}	
	public void setId_cough(String Id_cough) {
		setAttrVal("Id_cough", Id_cough);
	}
	public String getSd_cough() {
		return ((String) getAttrVal("Sd_cough"));
	}	
	public void setSd_cough(String Sd_cough) {
		setAttrVal("Sd_cough", Sd_cough);
	}
	public String getOther_cough() {
		return ((String) getAttrVal("Other_cough"));
	}	
	public void setOther_cough(String Other_cough) {
		setAttrVal("Other_cough", Other_cough);
	}
	public String getId_cold_heat() {
		return ((String) getAttrVal("Id_cold_heat"));
	}	
	public void setId_cold_heat(String Id_cold_heat) {
		setAttrVal("Id_cold_heat", Id_cold_heat);
	}
	public String getSd_cold_heat() {
		return ((String) getAttrVal("Sd_cold_heat"));
	}	
	public void setSd_cold_heat(String Sd_cold_heat) {
		setAttrVal("Sd_cold_heat", Sd_cold_heat);
	}
	public String getOther_cold_heat() {
		return ((String) getAttrVal("Other_cold_heat"));
	}	
	public void setOther_cold_heat(String Other_cold_heat) {
		setAttrVal("Other_cold_heat", Other_cold_heat);
	}
	public String getId_sweat() {
		return ((String) getAttrVal("Id_sweat"));
	}	
	public void setId_sweat(String Id_sweat) {
		setAttrVal("Id_sweat", Id_sweat);
	}
	public String getSd_sweat() {
		return ((String) getAttrVal("Sd_sweat"));
	}	
	public void setSd_sweat(String Sd_sweat) {
		setAttrVal("Sd_sweat", Sd_sweat);
	}
	public String getOther_sweat() {
		return ((String) getAttrVal("Other_sweat"));
	}	
	public void setOther_sweat(String Other_sweat) {
		setAttrVal("Other_sweat", Other_sweat);
	}
	public String getId_diet() {
		return ((String) getAttrVal("Id_diet"));
	}	
	public void setId_diet(String Id_diet) {
		setAttrVal("Id_diet", Id_diet);
	}
	public String getSd_diet() {
		return ((String) getAttrVal("Sd_diet"));
	}	
	public void setSd_diet(String Sd_diet) {
		setAttrVal("Sd_diet", Sd_diet);
	}
	public String getOther_diet() {
		return ((String) getAttrVal("Other_diet"));
	}	
	public void setOther_diet(String Other_diet) {
		setAttrVal("Other_diet", Other_diet);
	}
	public String getId_sleep() {
		return ((String) getAttrVal("Id_sleep"));
	}	
	public void setId_sleep(String Id_sleep) {
		setAttrVal("Id_sleep", Id_sleep);
	}
	public String getSd_sleep() {
		return ((String) getAttrVal("Sd_sleep"));
	}	
	public void setSd_sleep(String Sd_sleep) {
		setAttrVal("Sd_sleep", Sd_sleep);
	}
	public String getOther_sleep() {
		return ((String) getAttrVal("Other_sleep"));
	}	
	public void setOther_sleep(String Other_sleep) {
		setAttrVal("Other_sleep", Other_sleep);
	}
	public String getId_stool() {
		return ((String) getAttrVal("Id_stool"));
	}	
	public void setId_stool(String Id_stool) {
		setAttrVal("Id_stool", Id_stool);
	}
	public String getSd_stool() {
		return ((String) getAttrVal("Sd_stool"));
	}	
	public void setSd_stool(String Sd_stool) {
		setAttrVal("Sd_stool", Sd_stool);
	}
	public String getOther_stool() {
		return ((String) getAttrVal("Other_stool"));
	}	
	public void setOther_stool(String Other_stool) {
		setAttrVal("Other_stool", Other_stool);
	}
	public String getId_urinate() {
		return ((String) getAttrVal("Id_urinate"));
	}	
	public void setId_urinate(String Id_urinate) {
		setAttrVal("Id_urinate", Id_urinate);
	}
	public String getSd_urinate() {
		return ((String) getAttrVal("Sd_urinate"));
	}	
	public void setSd_urinate(String Sd_urinate) {
		setAttrVal("Sd_urinate", Sd_urinate);
	}
	public String getOther_urinate() {
		return ((String) getAttrVal("Other_urinate"));
	}	
	public void setOther_urinate(String Other_urinate) {
		setAttrVal("Other_urinate", Other_urinate);
	}
	public String getId_hobby() {
		return ((String) getAttrVal("Id_hobby"));
	}	
	public void setId_hobby(String Id_hobby) {
		setAttrVal("Id_hobby", Id_hobby);
	}
	public String getSd_hobby() {
		return ((String) getAttrVal("Sd_hobby"));
	}	
	public void setSd_hobby(String Sd_hobby) {
		setAttrVal("Sd_hobby", Sd_hobby);
	}
	public String getOther_hobby() {
		return ((String) getAttrVal("Other_hobby"));
	}	
	public void setOther_hobby(String Other_hobby) {
		setAttrVal("Other_hobby", Other_hobby);
	}
	public String getId_pulse() {
		return ((String) getAttrVal("Id_pulse"));
	}	
	public void setId_pulse(String Id_pulse) {
		setAttrVal("Id_pulse", Id_pulse);
	}
	public String getSd_pulse() {
		return ((String) getAttrVal("Sd_pulse"));
	}	
	public void setSd_pulse(String Sd_pulse) {
		setAttrVal("Sd_pulse", Sd_pulse);
	}
	public String getOther_pulse() {
		return ((String) getAttrVal("Other_pulse"));
	}	
	public void setOther_pulse(String Other_pulse) {
		setAttrVal("Other_pulse", Other_pulse);
	}
	public String getId_wrist() {
		return ((String) getAttrVal("Id_wrist"));
	}	
	public void setId_wrist(String Id_wrist) {
		setAttrVal("Id_wrist", Id_wrist);
	}
	public String getSd_wrist() {
		return ((String) getAttrVal("Sd_wrist"));
	}	
	public void setSd_wrist(String Sd_wrist) {
		setAttrVal("Sd_wrist", Sd_wrist);
	}
	public String getOther_wrist() {
		return ((String) getAttrVal("Other_wrist"));
	}	
	public void setOther_wrist(String Other_wrist) {
		setAttrVal("Other_wrist", Other_wrist);
	}
	public String getId_selt_care() {
		return ((String) getAttrVal("Id_selt_care"));
	}	
	public void setId_selt_care(String Id_selt_care) {
		setAttrVal("Id_selt_care", Id_selt_care);
	}
	public String getSd_selt_care() {
		return ((String) getAttrVal("Sd_selt_care"));
	}	
	public void setSd_selt_care(String Sd_selt_care) {
		setAttrVal("Sd_selt_care", Sd_selt_care);
	}
	public String getId_family_relation() {
		return ((String) getAttrVal("Id_family_relation"));
	}	
	public void setId_family_relation(String Id_family_relation) {
		setAttrVal("Id_family_relation", Id_family_relation);
	}
	public String getSd_family_relation() {
		return ((String) getAttrVal("Sd_family_relation"));
	}	
	public void setSd_family_relation(String Sd_family_relation) {
		setAttrVal("Sd_family_relation", Sd_family_relation);
	}
	public String getId_social_adaptability() {
		return ((String) getAttrVal("Id_social_adaptability"));
	}	
	public void setId_social_adaptability(String Id_social_adaptability) {
		setAttrVal("Id_social_adaptability", Id_social_adaptability);
	}
	public String getSd_social_adaptability() {
		return ((String) getAttrVal("Sd_social_adaptability"));
	}	
	public void setSd_social_adaptability(String Sd_social_adaptability) {
		setAttrVal("Sd_social_adaptability", Sd_social_adaptability);
	}
	public String getId_left_leg() {
		return ((String) getAttrVal("Id_left_leg"));
	}	
	public void setId_left_leg(String Id_left_leg) {
		setAttrVal("Id_left_leg", Id_left_leg);
	}
	public String getSd_left_leg() {
		return ((String) getAttrVal("Sd_left_leg"));
	}	
	public void setSd_left_leg(String Sd_left_leg) {
		setAttrVal("Sd_left_leg", Sd_left_leg);
	}
	public String getId_right_leg() {
		return ((String) getAttrVal("Id_right_leg"));
	}	
	public void setId_right_leg(String Id_right_leg) {
		setAttrVal("Id_right_leg", Id_right_leg);
	}
	public String getSd_right_leg() {
		return ((String) getAttrVal("Sd_right_leg"));
	}	
	public void setSd_right_leg(String Sd_right_leg) {
		setAttrVal("Sd_right_leg", Sd_right_leg);
	}
	public String getId_left_hand() {
		return ((String) getAttrVal("Id_left_hand"));
	}	
	public void setId_left_hand(String Id_left_hand) {
		setAttrVal("Id_left_hand", Id_left_hand);
	}
	public String getSd_left_hand() {
		return ((String) getAttrVal("Sd_left_hand"));
	}	
	public void setSd_left_hand(String Sd_left_hand) {
		setAttrVal("Sd_left_hand", Sd_left_hand);
	}
	public String getId_right_hand() {
		return ((String) getAttrVal("Id_right_hand"));
	}	
	public void setId_right_hand(String Id_right_hand) {
		setAttrVal("Id_right_hand", Id_right_hand);
	}
	public String getSd_right_hand() {
		return ((String) getAttrVal("Sd_right_hand"));
	}	
	public void setSd_right_hand(String Sd_right_hand) {
		setAttrVal("Sd_right_hand", Sd_right_hand);
	}
	public String getId_spine() {
		return ((String) getAttrVal("Id_spine"));
	}	
	public void setId_spine(String Id_spine) {
		setAttrVal("Id_spine", Id_spine);
	}
	public String getSd_spine() {
		return ((String) getAttrVal("Sd_spine"));
	}	
	public void setSd_spine(String Sd_spine) {
		setAttrVal("Sd_spine", Sd_spine);
	}
	public String getId_etiology() {
		return ((String) getAttrVal("Id_etiology"));
	}	
	public void setId_etiology(String Id_etiology) {
		setAttrVal("Id_etiology", Id_etiology);
	}
	public String getSd_etiology() {
		return ((String) getAttrVal("Sd_etiology"));
	}	
	public void setSd_etiology(String Sd_etiology) {
		setAttrVal("Sd_etiology", Sd_etiology);
	}
	public String getOther_etiology() {
		return ((String) getAttrVal("Other_etiology"));
	}	
	public void setOther_etiology(String Other_etiology) {
		setAttrVal("Other_etiology", Other_etiology);
	}
	public String getId_sick_place() {
		return ((String) getAttrVal("Id_sick_place"));
	}	
	public void setId_sick_place(String Id_sick_place) {
		setAttrVal("Id_sick_place", Id_sick_place);
	}
	public String getSd_sick_place() {
		return ((String) getAttrVal("Sd_sick_place"));
	}	
	public void setSd_sick_place(String Sd_sick_place) {
		setAttrVal("Sd_sick_place", Sd_sick_place);
	}
	public String getOther_sick_place() {
		return ((String) getAttrVal("Other_sick_place"));
	}	
	public void setOther_sick_place(String Other_sick_place) {
		setAttrVal("Other_sick_place", Other_sick_place);
	}
	public String getId_admission_mission() {
		return ((String) getAttrVal("Id_admission_mission"));
	}	
	public void setId_admission_mission(String Id_admission_mission) {
		setAttrVal("Id_admission_mission", Id_admission_mission);
	}
	public String getSd_admission_mission() {
		return ((String) getAttrVal("Sd_admission_mission"));
	}	
	public void setSd_admission_mission(String Sd_admission_mission) {
		setAttrVal("Sd_admission_mission", Sd_admission_mission);
	}
	public String getNurse_plan() {
		return ((String) getAttrVal("Nurse_plan"));
	}	
	public void setNurse_plan(String Nurse_plan) {
		setAttrVal("Nurse_plan", Nurse_plan);
	}
	public String getId_emp_evaluation() {
		return ((String) getAttrVal("Id_emp_evaluation"));
	}	
	public void setId_emp_evaluation(String Id_emp_evaluation) {
		setAttrVal("Id_emp_evaluation", Id_emp_evaluation);
	}
	public FDateTime getDt_evaluation() {
		return ((FDateTime) getAttrVal("Dt_evaluation"));
	}	
	public void setDt_evaluation(FDateTime Dt_evaluation) {
		setAttrVal("Dt_evaluation", Dt_evaluation);
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
	public String getSyndromes() {
		return ((String) getAttrVal("Syndromes"));
	}	
	public void setSyndromes(String Syndromes) {
		setAttrVal("Syndromes", Syndromes);
	}
	public String getName_route_admission() {
		return ((String) getAttrVal("Name_route_admission"));
	}	
	public void setName_route_admission(String Name_route_admission) {
		setAttrVal("Name_route_admission", Name_route_admission);
	}
	public String getName_way_admission() {
		return ((String) getAttrVal("Name_way_admission"));
	}	
	public void setName_way_admission(String Name_way_admission) {
		setAttrVal("Name_way_admission", Name_way_admission);
	}
	public String getName_solar_ill() {
		return ((String) getAttrVal("Name_solar_ill"));
	}	
	public void setName_solar_ill(String Name_solar_ill) {
		setAttrVal("Name_solar_ill", Name_solar_ill);
	}
	public String getName_look_states() {
		return ((String) getAttrVal("Name_look_states"));
	}	
	public void setName_look_states(String Name_look_states) {
		setAttrVal("Name_look_states", Name_look_states);
	}
	public String getName_complexion() {
		return ((String) getAttrVal("Name_complexion"));
	}	
	public void setName_complexion(String Name_complexion) {
		setAttrVal("Name_complexion", Name_complexion);
	}
	public String getName_shape() {
		return ((String) getAttrVal("Name_shape"));
	}	
	public void setName_shape(String Name_shape) {
		setAttrVal("Name_shape", Name_shape);
	}
	public String getName_form() {
		return ((String) getAttrVal("Name_form"));
	}	
	public void setName_form(String Name_form) {
		setAttrVal("Name_form", Name_form);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_tongue() {
		return ((String) getAttrVal("Name_tongue"));
	}	
	public void setName_tongue(String Name_tongue) {
		setAttrVal("Name_tongue", Name_tongue);
	}
	public String getName_furred_tongue() {
		return ((String) getAttrVal("Name_furred_tongue"));
	}	
	public void setName_furred_tongue(String Name_furred_tongue) {
		setAttrVal("Name_furred_tongue", Name_furred_tongue);
	}
	public String getName_voice() {
		return ((String) getAttrVal("Name_voice"));
	}	
	public void setName_voice(String Name_voice) {
		setAttrVal("Name_voice", Name_voice);
	}
	public String getName_breathe() {
		return ((String) getAttrVal("Name_breathe"));
	}	
	public void setName_breathe(String Name_breathe) {
		setAttrVal("Name_breathe", Name_breathe);
	}
	public String getName_cough() {
		return ((String) getAttrVal("Name_cough"));
	}	
	public void setName_cough(String Name_cough) {
		setAttrVal("Name_cough", Name_cough);
	}
	public String getName_cold_heat() {
		return ((String) getAttrVal("Name_cold_heat"));
	}	
	public void setName_cold_heat(String Name_cold_heat) {
		setAttrVal("Name_cold_heat", Name_cold_heat);
	}
	public String getName_sweat() {
		return ((String) getAttrVal("Name_sweat"));
	}	
	public void setName_sweat(String Name_sweat) {
		setAttrVal("Name_sweat", Name_sweat);
	}
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
	}
	public String getName_sleep() {
		return ((String) getAttrVal("Name_sleep"));
	}	
	public void setName_sleep(String Name_sleep) {
		setAttrVal("Name_sleep", Name_sleep);
	}
	public String getName_stool() {
		return ((String) getAttrVal("Name_stool"));
	}	
	public void setName_stool(String Name_stool) {
		setAttrVal("Name_stool", Name_stool);
	}
	public String getName_urinate() {
		return ((String) getAttrVal("Name_urinate"));
	}	
	public void setName_urinate(String Name_urinate) {
		setAttrVal("Name_urinate", Name_urinate);
	}
	public String getName_hobby() {
		return ((String) getAttrVal("Name_hobby"));
	}	
	public void setName_hobby(String Name_hobby) {
		setAttrVal("Name_hobby", Name_hobby);
	}
	public String getName_pulse() {
		return ((String) getAttrVal("Name_pulse"));
	}	
	public void setName_pulse(String Name_pulse) {
		setAttrVal("Name_pulse", Name_pulse);
	}
	public String getName_wrist() {
		return ((String) getAttrVal("Name_wrist"));
	}	
	public void setName_wrist(String Name_wrist) {
		setAttrVal("Name_wrist", Name_wrist);
	}
	public String getName_selt_care() {
		return ((String) getAttrVal("Name_selt_care"));
	}	
	public void setName_selt_care(String Name_selt_care) {
		setAttrVal("Name_selt_care", Name_selt_care);
	}
	public String getName_family_relation() {
		return ((String) getAttrVal("Name_family_relation"));
	}	
	public void setName_family_relation(String Name_family_relation) {
		setAttrVal("Name_family_relation", Name_family_relation);
	}
	public String getName_social_adaptability() {
		return ((String) getAttrVal("Name_social_adaptability"));
	}	
	public void setName_social_adaptability(String Name_social_adaptability) {
		setAttrVal("Name_social_adaptability", Name_social_adaptability);
	}
	public String getName_left_leg() {
		return ((String) getAttrVal("Name_left_leg"));
	}	
	public void setName_left_leg(String Name_left_leg) {
		setAttrVal("Name_left_leg", Name_left_leg);
	}
	public String getName_right_leg() {
		return ((String) getAttrVal("Name_right_leg"));
	}	
	public void setName_right_leg(String Name_right_leg) {
		setAttrVal("Name_right_leg", Name_right_leg);
	}
	public String getName_left_hand() {
		return ((String) getAttrVal("Name_left_hand"));
	}	
	public void setName_left_hand(String Name_left_hand) {
		setAttrVal("Name_left_hand", Name_left_hand);
	}
	public String getName_right_hand() {
		return ((String) getAttrVal("Name_right_hand"));
	}	
	public void setName_right_hand(String Name_right_hand) {
		setAttrVal("Name_right_hand", Name_right_hand);
	}
	public String getName_spine() {
		return ((String) getAttrVal("Name_spine"));
	}	
	public void setName_spine(String Name_spine) {
		setAttrVal("Name_spine", Name_spine);
	}
	public String getName_etiology() {
		return ((String) getAttrVal("Name_etiology"));
	}	
	public void setName_etiology(String Name_etiology) {
		setAttrVal("Name_etiology", Name_etiology);
	}
	public String getName_sick_place() {
		return ((String) getAttrVal("Name_sick_place"));
	}	
	public void setName_sick_place(String Name_sick_place) {
		setAttrVal("Name_sick_place", Name_sick_place);
	}
	public String getName_admission_mission() {
		return ((String) getAttrVal("Name_admission_mission"));
	}	
	public void setName_admission_mission(String Name_admission_mission) {
		setAttrVal("Name_admission_mission", Name_admission_mission);
	}
	public String getName_emp_evaluation() {
		return ((String) getAttrVal("Name_emp_evaluation"));
	}	
	public void setName_emp_evaluation(String Name_emp_evaluation) {
		setAttrVal("Name_emp_evaluation", Name_emp_evaluation);
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
		return "Id_ana";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_HA_TCHO_ADMISSIONNURSING";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TchoAdmissionNursingDODesc.class);
	}
	
}