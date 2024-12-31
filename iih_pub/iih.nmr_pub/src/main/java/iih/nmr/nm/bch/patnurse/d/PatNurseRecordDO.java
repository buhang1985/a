package iih.nmr.nm.bch.patnurse.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.patnurse.d.desc.PatNurseRecordDODesc;
import java.math.BigDecimal;

/**
 * 患者护理评估记录单 DO数据 
 * 
 */
public class PatNurseRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATNURSE= "Id_patnurse";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String AGE= "Age";
	public static final String NAME_SEX= "Name_sex";
	public static final String PAT_NATION= "Pat_nation";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String ID_DEVELOP_DGREE= "Id_develop_dgree";
	public static final String SD_DEVELOP_DGREE= "Sd_develop_dgree";
	public static final String IS_CONTAGION= "Is_contagion";
	public static final String EVALUATE_TIME= "Evaluate_time";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_ADMISSION_WAY= "Id_admission_way";
	public static final String SD_ADMISSION_WAY= "Sd_admission_way";
	public static final String ID_AWARENESS= "Id_awareness";
	public static final String SD_AWARENESS= "Sd_awareness";
	public static final String ID_LANGUAGE_FUNC= "Id_language_func";
	public static final String SD_LANGUAGE_FUNC= "Sd_language_func";
	public static final String ID_SELF_CONSCIOUSNESS= "Id_self_consciousness";
	public static final String SD_SELF_CONSCIOUSNESS= "Sd_self_consciousness";
	public static final String ZLYS_GRADE= "Zlys_grade";
	public static final String ID_SKIN_CONDITIONS= "Id_skin_conditions";
	public static final String SD_SKIN_CONDITIONS= "Sd_skin_conditions";
	public static final String ID_PRESS_ASSESS= "Id_press_assess";
	public static final String SD_PRESS_ASSESS= "Sd_press_assess";
	public static final String YCPG_GRADE= "Ycpg_grade";
	public static final String ID_PIPE_ASSESS= "Id_pipe_assess";
	public static final String SD_PIPE_ASSESS= "Sd_pipe_assess";
	public static final String ID_FALL_ASSESS= "Id_fall_assess";
	public static final String SD_FALL_ASSESS= "Sd_fall_assess";
	public static final String DDPG_GRADE= "Ddpg_grade";
	public static final String ID_URESIS_CONDITION= "Id_uresis_condition";
	public static final String SD_URESIS_CONDITION= "Sd_uresis_condition";
	public static final String ID_DEFECATE_CONDITION= "Id_defecate_condition";
	public static final String SD_DEFECATE_CONDITION= "Sd_defecate_condition";
	public static final String ID_SLEEP_CONDITION= "Id_sleep_condition";
	public static final String SD_SLEEP_CONDITION= "Sd_sleep_condition";
	public static final String ID_PAIN_GRADE= "Id_pain_grade";
	public static final String SD_PAIN_GRADE= "Sd_pain_grade";
	public static final String ID_NUTR_CONDITION= "Id_nutr_condition";
	public static final String SD_NUTR_CONDITION= "Sd_nutr_condition";
	public static final String ID_BITE_CONDITION= "Id_bite_condition";
	public static final String SD_BITE_CONDITION= "Sd_bite_condition";
	public static final String ID_FOURS_MUSCLE= "Id_fours_muscle";
	public static final String SD_FOURS_MUSCLE= "Sd_fours_muscle";
	public static final String ID_MENTALITY= "Id_mentality";
	public static final String SD_MENTALITY= "Sd_mentality";
	public static final String ID_ALLERGY= "Id_allergy";
	public static final String SD_ALLERGY= "Sd_allergy";
	public static final String ID_PREVIOUS= "Id_previous";
	public static final String SD_PREVIOUS= "Sd_previous";
	public static final String ID_DRINK= "Id_drink";
	public static final String SD_DRINK= "Sd_drink";
	public static final String ID_SMOKE= "Id_smoke";
	public static final String SD_SMOKE= "Sd_smoke";
	public static final String ID_SMOKE_CONDITION= "Id_smoke_condition";
	public static final String SD_SMOKE_CONDITION= "Sd_smoke_condition";
	public static final String SMOKE_AMOUNT= "Smoke_amount";
	public static final String SMOKE_STOP= "Smoke_stop";
	public static final String FAITH= "Faith";
	public static final String ZKHLPG= "Zkhlpg";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_CREATE= "Dt_create";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_DRINK_CONDITION= "Id_drink_condition";
	public static final String SD_DRINK_CONDITION= "Sd_drink_condition";
	public static final String SPIRIT_STATUS= "Spirit_status";
	public static final String NAME_DEVELOP_DGREE= "Name_develop_dgree";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_ADMI_WAY= "Name_admi_way";
	public static final String NAME_AWARENESS= "Name_awareness";
	public static final String NAME_LANGUAGE_FUNC= "Name_language_func";
	public static final String NAME_SELF_CONSCIOUSNESS= "Name_self_consciousness";
	public static final String NAME_SKIN_CONDITIONS= "Name_skin_conditions";
	public static final String NAME_PRESS_ASSESS= "Name_press_assess";
	public static final String NAME_PIPE_ASSESS= "Name_pipe_assess";
	public static final String NAME_FALL_ASSESS= "Name_fall_assess";
	public static final String NAME_URESIS_CONDITION= "Name_uresis_condition";
	public static final String NAME_DEFECATE_CONDITION= "Name_defecate_condition";
	public static final String NAME_SLEEP_CONDITION= "Name_sleep_condition";
	public static final String NAME_PAIN_GRADE= "Name_pain_grade";
	public static final String NAME_NUTR_CONDITION= "Name_nutr_condition";
	public static final String NAME_BITE_CONDITION= "Name_bite_condition";
	public static final String NAME_FOURS_MUSCLE= "Name_fours_muscle";
	public static final String NAME_MENTALITY= "Name_mentality";
	public static final String NAME_ALLERGY= "Name_allergy";
	public static final String NAME_PREVIOUS= "Name_previous";
	public static final String NAME_DRINK= "Name_drink";
	public static final String NAME_SMOKE= "Name_smoke";
	public static final String NAME_SMOKE_CONDITION= "Name_smoke_condition";
	public static final String NAME_SIGN= "Name_sign";
	public static final String NAME_DRINK_CONDITION= "Name_drink_condition";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patnurse() {
		return ((String) getAttrVal("Id_patnurse"));
	}	
	public void setId_patnurse(String Id_patnurse) {
		setAttrVal("Id_patnurse", Id_patnurse);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getPat_nation() {
		return ((String) getAttrVal("Pat_nation"));
	}	
	public void setPat_nation(String Pat_nation) {
		setAttrVal("Pat_nation", Pat_nation);
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
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getId_develop_dgree() {
		return ((String) getAttrVal("Id_develop_dgree"));
	}	
	public void setId_develop_dgree(String Id_develop_dgree) {
		setAttrVal("Id_develop_dgree", Id_develop_dgree);
	}
	public String getSd_develop_dgree() {
		return ((String) getAttrVal("Sd_develop_dgree"));
	}	
	public void setSd_develop_dgree(String Sd_develop_dgree) {
		setAttrVal("Sd_develop_dgree", Sd_develop_dgree);
	}
	public Integer getIs_contagion() {
		return ((Integer) getAttrVal("Is_contagion"));
	}	
	public void setIs_contagion(Integer Is_contagion) {
		setAttrVal("Is_contagion", Is_contagion);
	}
	public FDateTime getEvaluate_time() {
		return ((FDateTime) getAttrVal("Evaluate_time"));
	}	
	public void setEvaluate_time(FDateTime Evaluate_time) {
		setAttrVal("Evaluate_time", Evaluate_time);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_admission_way() {
		return ((String) getAttrVal("Id_admission_way"));
	}	
	public void setId_admission_way(String Id_admission_way) {
		setAttrVal("Id_admission_way", Id_admission_way);
	}
	public String getSd_admission_way() {
		return ((String) getAttrVal("Sd_admission_way"));
	}	
	public void setSd_admission_way(String Sd_admission_way) {
		setAttrVal("Sd_admission_way", Sd_admission_way);
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
	public String getId_language_func() {
		return ((String) getAttrVal("Id_language_func"));
	}	
	public void setId_language_func(String Id_language_func) {
		setAttrVal("Id_language_func", Id_language_func);
	}
	public String getSd_language_func() {
		return ((String) getAttrVal("Sd_language_func"));
	}	
	public void setSd_language_func(String Sd_language_func) {
		setAttrVal("Sd_language_func", Sd_language_func);
	}
	public String getId_self_consciousness() {
		return ((String) getAttrVal("Id_self_consciousness"));
	}	
	public void setId_self_consciousness(String Id_self_consciousness) {
		setAttrVal("Id_self_consciousness", Id_self_consciousness);
	}
	public String getSd_self_consciousness() {
		return ((String) getAttrVal("Sd_self_consciousness"));
	}	
	public void setSd_self_consciousness(String Sd_self_consciousness) {
		setAttrVal("Sd_self_consciousness", Sd_self_consciousness);
	}
	public String getZlys_grade() {
		return ((String) getAttrVal("Zlys_grade"));
	}	
	public void setZlys_grade(String Zlys_grade) {
		setAttrVal("Zlys_grade", Zlys_grade);
	}
	public String getId_skin_conditions() {
		return ((String) getAttrVal("Id_skin_conditions"));
	}	
	public void setId_skin_conditions(String Id_skin_conditions) {
		setAttrVal("Id_skin_conditions", Id_skin_conditions);
	}
	public String getSd_skin_conditions() {
		return ((String) getAttrVal("Sd_skin_conditions"));
	}	
	public void setSd_skin_conditions(String Sd_skin_conditions) {
		setAttrVal("Sd_skin_conditions", Sd_skin_conditions);
	}
	public String getId_press_assess() {
		return ((String) getAttrVal("Id_press_assess"));
	}	
	public void setId_press_assess(String Id_press_assess) {
		setAttrVal("Id_press_assess", Id_press_assess);
	}
	public String getSd_press_assess() {
		return ((String) getAttrVal("Sd_press_assess"));
	}	
	public void setSd_press_assess(String Sd_press_assess) {
		setAttrVal("Sd_press_assess", Sd_press_assess);
	}
	public String getYcpg_grade() {
		return ((String) getAttrVal("Ycpg_grade"));
	}	
	public void setYcpg_grade(String Ycpg_grade) {
		setAttrVal("Ycpg_grade", Ycpg_grade);
	}
	public String getId_pipe_assess() {
		return ((String) getAttrVal("Id_pipe_assess"));
	}	
	public void setId_pipe_assess(String Id_pipe_assess) {
		setAttrVal("Id_pipe_assess", Id_pipe_assess);
	}
	public String getSd_pipe_assess() {
		return ((String) getAttrVal("Sd_pipe_assess"));
	}	
	public void setSd_pipe_assess(String Sd_pipe_assess) {
		setAttrVal("Sd_pipe_assess", Sd_pipe_assess);
	}
	public String getId_fall_assess() {
		return ((String) getAttrVal("Id_fall_assess"));
	}	
	public void setId_fall_assess(String Id_fall_assess) {
		setAttrVal("Id_fall_assess", Id_fall_assess);
	}
	public String getSd_fall_assess() {
		return ((String) getAttrVal("Sd_fall_assess"));
	}	
	public void setSd_fall_assess(String Sd_fall_assess) {
		setAttrVal("Sd_fall_assess", Sd_fall_assess);
	}
	public String getDdpg_grade() {
		return ((String) getAttrVal("Ddpg_grade"));
	}	
	public void setDdpg_grade(String Ddpg_grade) {
		setAttrVal("Ddpg_grade", Ddpg_grade);
	}
	public String getId_uresis_condition() {
		return ((String) getAttrVal("Id_uresis_condition"));
	}	
	public void setId_uresis_condition(String Id_uresis_condition) {
		setAttrVal("Id_uresis_condition", Id_uresis_condition);
	}
	public String getSd_uresis_condition() {
		return ((String) getAttrVal("Sd_uresis_condition"));
	}	
	public void setSd_uresis_condition(String Sd_uresis_condition) {
		setAttrVal("Sd_uresis_condition", Sd_uresis_condition);
	}
	public String getId_defecate_condition() {
		return ((String) getAttrVal("Id_defecate_condition"));
	}	
	public void setId_defecate_condition(String Id_defecate_condition) {
		setAttrVal("Id_defecate_condition", Id_defecate_condition);
	}
	public String getSd_defecate_condition() {
		return ((String) getAttrVal("Sd_defecate_condition"));
	}	
	public void setSd_defecate_condition(String Sd_defecate_condition) {
		setAttrVal("Sd_defecate_condition", Sd_defecate_condition);
	}
	public String getId_sleep_condition() {
		return ((String) getAttrVal("Id_sleep_condition"));
	}	
	public void setId_sleep_condition(String Id_sleep_condition) {
		setAttrVal("Id_sleep_condition", Id_sleep_condition);
	}
	public String getSd_sleep_condition() {
		return ((String) getAttrVal("Sd_sleep_condition"));
	}	
	public void setSd_sleep_condition(String Sd_sleep_condition) {
		setAttrVal("Sd_sleep_condition", Sd_sleep_condition);
	}
	public String getId_pain_grade() {
		return ((String) getAttrVal("Id_pain_grade"));
	}	
	public void setId_pain_grade(String Id_pain_grade) {
		setAttrVal("Id_pain_grade", Id_pain_grade);
	}
	public String getSd_pain_grade() {
		return ((String) getAttrVal("Sd_pain_grade"));
	}	
	public void setSd_pain_grade(String Sd_pain_grade) {
		setAttrVal("Sd_pain_grade", Sd_pain_grade);
	}
	public String getId_nutr_condition() {
		return ((String) getAttrVal("Id_nutr_condition"));
	}	
	public void setId_nutr_condition(String Id_nutr_condition) {
		setAttrVal("Id_nutr_condition", Id_nutr_condition);
	}
	public String getSd_nutr_condition() {
		return ((String) getAttrVal("Sd_nutr_condition"));
	}	
	public void setSd_nutr_condition(String Sd_nutr_condition) {
		setAttrVal("Sd_nutr_condition", Sd_nutr_condition);
	}
	public String getId_bite_condition() {
		return ((String) getAttrVal("Id_bite_condition"));
	}	
	public void setId_bite_condition(String Id_bite_condition) {
		setAttrVal("Id_bite_condition", Id_bite_condition);
	}
	public String getSd_bite_condition() {
		return ((String) getAttrVal("Sd_bite_condition"));
	}	
	public void setSd_bite_condition(String Sd_bite_condition) {
		setAttrVal("Sd_bite_condition", Sd_bite_condition);
	}
	public String getId_fours_muscle() {
		return ((String) getAttrVal("Id_fours_muscle"));
	}	
	public void setId_fours_muscle(String Id_fours_muscle) {
		setAttrVal("Id_fours_muscle", Id_fours_muscle);
	}
	public String getSd_fours_muscle() {
		return ((String) getAttrVal("Sd_fours_muscle"));
	}	
	public void setSd_fours_muscle(String Sd_fours_muscle) {
		setAttrVal("Sd_fours_muscle", Sd_fours_muscle);
	}
	public String getId_mentality() {
		return ((String) getAttrVal("Id_mentality"));
	}	
	public void setId_mentality(String Id_mentality) {
		setAttrVal("Id_mentality", Id_mentality);
	}
	public String getSd_mentality() {
		return ((String) getAttrVal("Sd_mentality"));
	}	
	public void setSd_mentality(String Sd_mentality) {
		setAttrVal("Sd_mentality", Sd_mentality);
	}
	public String getId_allergy() {
		return ((String) getAttrVal("Id_allergy"));
	}	
	public void setId_allergy(String Id_allergy) {
		setAttrVal("Id_allergy", Id_allergy);
	}
	public String getSd_allergy() {
		return ((String) getAttrVal("Sd_allergy"));
	}	
	public void setSd_allergy(String Sd_allergy) {
		setAttrVal("Sd_allergy", Sd_allergy);
	}
	public String getId_previous() {
		return ((String) getAttrVal("Id_previous"));
	}	
	public void setId_previous(String Id_previous) {
		setAttrVal("Id_previous", Id_previous);
	}
	public String getSd_previous() {
		return ((String) getAttrVal("Sd_previous"));
	}	
	public void setSd_previous(String Sd_previous) {
		setAttrVal("Sd_previous", Sd_previous);
	}
	public String getId_drink() {
		return ((String) getAttrVal("Id_drink"));
	}	
	public void setId_drink(String Id_drink) {
		setAttrVal("Id_drink", Id_drink);
	}
	public String getSd_drink() {
		return ((String) getAttrVal("Sd_drink"));
	}	
	public void setSd_drink(String Sd_drink) {
		setAttrVal("Sd_drink", Sd_drink);
	}
	public String getId_smoke() {
		return ((String) getAttrVal("Id_smoke"));
	}	
	public void setId_smoke(String Id_smoke) {
		setAttrVal("Id_smoke", Id_smoke);
	}
	public String getSd_smoke() {
		return ((String) getAttrVal("Sd_smoke"));
	}	
	public void setSd_smoke(String Sd_smoke) {
		setAttrVal("Sd_smoke", Sd_smoke);
	}
	public String getId_smoke_condition() {
		return ((String) getAttrVal("Id_smoke_condition"));
	}	
	public void setId_smoke_condition(String Id_smoke_condition) {
		setAttrVal("Id_smoke_condition", Id_smoke_condition);
	}
	public String getSd_smoke_condition() {
		return ((String) getAttrVal("Sd_smoke_condition"));
	}	
	public void setSd_smoke_condition(String Sd_smoke_condition) {
		setAttrVal("Sd_smoke_condition", Sd_smoke_condition);
	}
	public Integer getSmoke_amount() {
		return ((Integer) getAttrVal("Smoke_amount"));
	}	
	public void setSmoke_amount(Integer Smoke_amount) {
		setAttrVal("Smoke_amount", Smoke_amount);
	}
	public Integer getSmoke_stop() {
		return ((Integer) getAttrVal("Smoke_stop"));
	}	
	public void setSmoke_stop(Integer Smoke_stop) {
		setAttrVal("Smoke_stop", Smoke_stop);
	}
	public Integer getFaith() {
		return ((Integer) getAttrVal("Faith"));
	}	
	public void setFaith(Integer Faith) {
		setAttrVal("Faith", Faith);
	}
	public String getZkhlpg() {
		return ((String) getAttrVal("Zkhlpg"));
	}	
	public void setZkhlpg(String Zkhlpg) {
		setAttrVal("Zkhlpg", Zkhlpg);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
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
	public String getId_drink_condition() {
		return ((String) getAttrVal("Id_drink_condition"));
	}	
	public void setId_drink_condition(String Id_drink_condition) {
		setAttrVal("Id_drink_condition", Id_drink_condition);
	}
	public String getSd_drink_condition() {
		return ((String) getAttrVal("Sd_drink_condition"));
	}	
	public void setSd_drink_condition(String Sd_drink_condition) {
		setAttrVal("Sd_drink_condition", Sd_drink_condition);
	}
	public Integer getSpirit_status() {
		return ((Integer) getAttrVal("Spirit_status"));
	}	
	public void setSpirit_status(Integer Spirit_status) {
		setAttrVal("Spirit_status", Spirit_status);
	}
	public String getName_develop_dgree() {
		return ((String) getAttrVal("Name_develop_dgree"));
	}	
	public void setName_develop_dgree(String Name_develop_dgree) {
		setAttrVal("Name_develop_dgree", Name_develop_dgree);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_admi_way() {
		return ((String) getAttrVal("Name_admi_way"));
	}	
	public void setName_admi_way(String Name_admi_way) {
		setAttrVal("Name_admi_way", Name_admi_way);
	}
	public String getName_awareness() {
		return ((String) getAttrVal("Name_awareness"));
	}	
	public void setName_awareness(String Name_awareness) {
		setAttrVal("Name_awareness", Name_awareness);
	}
	public String getName_language_func() {
		return ((String) getAttrVal("Name_language_func"));
	}	
	public void setName_language_func(String Name_language_func) {
		setAttrVal("Name_language_func", Name_language_func);
	}
	public String getName_self_consciousness() {
		return ((String) getAttrVal("Name_self_consciousness"));
	}	
	public void setName_self_consciousness(String Name_self_consciousness) {
		setAttrVal("Name_self_consciousness", Name_self_consciousness);
	}
	public String getName_skin_conditions() {
		return ((String) getAttrVal("Name_skin_conditions"));
	}	
	public void setName_skin_conditions(String Name_skin_conditions) {
		setAttrVal("Name_skin_conditions", Name_skin_conditions);
	}
	public String getName_press_assess() {
		return ((String) getAttrVal("Name_press_assess"));
	}	
	public void setName_press_assess(String Name_press_assess) {
		setAttrVal("Name_press_assess", Name_press_assess);
	}
	public String getName_pipe_assess() {
		return ((String) getAttrVal("Name_pipe_assess"));
	}	
	public void setName_pipe_assess(String Name_pipe_assess) {
		setAttrVal("Name_pipe_assess", Name_pipe_assess);
	}
	public String getName_fall_assess() {
		return ((String) getAttrVal("Name_fall_assess"));
	}	
	public void setName_fall_assess(String Name_fall_assess) {
		setAttrVal("Name_fall_assess", Name_fall_assess);
	}
	public String getName_uresis_condition() {
		return ((String) getAttrVal("Name_uresis_condition"));
	}	
	public void setName_uresis_condition(String Name_uresis_condition) {
		setAttrVal("Name_uresis_condition", Name_uresis_condition);
	}
	public String getName_defecate_condition() {
		return ((String) getAttrVal("Name_defecate_condition"));
	}	
	public void setName_defecate_condition(String Name_defecate_condition) {
		setAttrVal("Name_defecate_condition", Name_defecate_condition);
	}
	public String getName_sleep_condition() {
		return ((String) getAttrVal("Name_sleep_condition"));
	}	
	public void setName_sleep_condition(String Name_sleep_condition) {
		setAttrVal("Name_sleep_condition", Name_sleep_condition);
	}
	public String getName_pain_grade() {
		return ((String) getAttrVal("Name_pain_grade"));
	}	
	public void setName_pain_grade(String Name_pain_grade) {
		setAttrVal("Name_pain_grade", Name_pain_grade);
	}
	public String getName_nutr_condition() {
		return ((String) getAttrVal("Name_nutr_condition"));
	}	
	public void setName_nutr_condition(String Name_nutr_condition) {
		setAttrVal("Name_nutr_condition", Name_nutr_condition);
	}
	public String getName_bite_condition() {
		return ((String) getAttrVal("Name_bite_condition"));
	}	
	public void setName_bite_condition(String Name_bite_condition) {
		setAttrVal("Name_bite_condition", Name_bite_condition);
	}
	public String getName_fours_muscle() {
		return ((String) getAttrVal("Name_fours_muscle"));
	}	
	public void setName_fours_muscle(String Name_fours_muscle) {
		setAttrVal("Name_fours_muscle", Name_fours_muscle);
	}
	public String getName_mentality() {
		return ((String) getAttrVal("Name_mentality"));
	}	
	public void setName_mentality(String Name_mentality) {
		setAttrVal("Name_mentality", Name_mentality);
	}
	public String getName_allergy() {
		return ((String) getAttrVal("Name_allergy"));
	}	
	public void setName_allergy(String Name_allergy) {
		setAttrVal("Name_allergy", Name_allergy);
	}
	public String getName_previous() {
		return ((String) getAttrVal("Name_previous"));
	}	
	public void setName_previous(String Name_previous) {
		setAttrVal("Name_previous", Name_previous);
	}
	public String getName_drink() {
		return ((String) getAttrVal("Name_drink"));
	}	
	public void setName_drink(String Name_drink) {
		setAttrVal("Name_drink", Name_drink);
	}
	public String getName_smoke() {
		return ((String) getAttrVal("Name_smoke"));
	}	
	public void setName_smoke(String Name_smoke) {
		setAttrVal("Name_smoke", Name_smoke);
	}
	public String getName_smoke_condition() {
		return ((String) getAttrVal("Name_smoke_condition"));
	}	
	public void setName_smoke_condition(String Name_smoke_condition) {
		setAttrVal("Name_smoke_condition", Name_smoke_condition);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	public String getName_drink_condition() {
		return ((String) getAttrVal("Name_drink_condition"));
	}	
	public void setName_drink_condition(String Name_drink_condition) {
		setAttrVal("Name_drink_condition", Name_drink_condition);
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
		return "Id_patnurse";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BCH_PATNUR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatNurseRecordDODesc.class);
	}
	
}