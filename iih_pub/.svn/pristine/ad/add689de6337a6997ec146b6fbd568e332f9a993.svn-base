package iih.ci.mr.nu.obsadmcareass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obsadmcareass.d.desc.ObsadmcareassDODesc;
import java.math.BigDecimal;

/**
 * 入院护理评估记录单 DO数据 
 * 
 */
public class ObsadmcareassDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OBSADMCAREASS= "Id_obsadmcareass";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String AGE= "Age";
	public static final String NAME_SEX= "Name_sex";
	public static final String ID_HOSPITALIZEWAY= "Id_hospitalizeway";
	public static final String SD_HOSPITALIZEWAY= "Sd_hospitalizeway";
	public static final String OTHER_HOSPITALIZEWAY= "Other_hospitalizeway";
	public static final String ID_EDUC= "Id_educ";
	public static final String ID_MARRY= "Id_marry";
	public static final String PATCONT= "Patcont";
	public static final String MOB= "Mob";
	public static final String PHONE= "Phone";
	public static final String PATADDR= "Pataddr";
	public static final String NAME_CHINESE_MEDICINE= "Name_chinese_medicine";
	public static final String NAME_MEDICINE= "Name_medicine";
	public static final String FG_PASTMEDIC= "Fg_pastmedic";
	public static final String NAME_PASTMEDIC= "Name_pastmedic";
	public static final String FG_ALLERGY= "Fg_allergy";
	public static final String NAME_ALLERGY= "Name_allergy";
	public static final String PAULSE= "Paulse";
	public static final String BREATH= "Breath";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String TEM= "Tem";
	public static final String SCORE_HELPME= "Score_helpme";
	public static final String SCORE_PRESSURESORE= "Score_pressuresore";
	public static final String SCORE_FALLDOWN= "Score_falldown";
	public static final String SCORE_PAIN= "Score_pain";
	public static final String SCORE_PIPE_SLIPPAGE= "Score_pipe_slippage";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String EU_MUCOSA= "Eu_mucosa";
	public static final String EU_DEN_TOOTH= "Eu_den_tooth";
	public static final String EU_EAT= "Eu_eat";
	public static final String EU_COUGH= "Eu_cough";
	public static final String EU_HOBBY= "Eu_hobby";
	public static final String ID_TONGUE= "Id_tongue";
	public static final String SD_TONGUE= "Sd_tongue";
	public static final String NAME_OTHER_TONGUE= "Name_other_tongue";
	public static final String NAME_SPECIALTY= "Name_specialty";
	public static final String NAME_NURSING= "Name_nursing";
	public static final String ID_SOLAR_ILL= "Id_solar_ill";
	public static final String SD_SOLAR_ILL= "Sd_solar_ill";
	public static final String ID_TONGUE_COAT= "Id_tongue_coat";
	public static final String SD_TONGUE_COAT= "Sd_tongue_coat";
	public static final String NAME_OTHER_TONGUECOAT= "Name_other_tonguecoat";
	public static final String ID_EMOTION= "Id_emotion";
	public static final String SD_EMOTION= "Sd_emotion";
	public static final String NAME_OTHER_EMOTION= "Name_other_emotion";
	public static final String ID_COMPLEXION= "Id_complexion";
	public static final String SD_COMPLEXION= "Sd_complexion";
	public static final String NAME_OTHER_COMPLEXION= "Name_other_complexion";
	public static final String ID_MORP= "Id_morp";
	public static final String SD_MORP= "Sd_morp";
	public static final String ID_SKIN_DAMAGE= "Id_skin_damage";
	public static final String SD_SKIN_DAMAGE= "Sd_skin_damage";
	public static final String NAME_DAMAGED= "Name_damaged";
	public static final String NAME_PRESSURE_SORE= "Name_pressure_sore";
	public static final String ID_SKIN_COLOR= "Id_skin_color";
	public static final String SD_SKIN_COLOR= "Sd_skin_color";
	public static final String NAME_OTHER_SKINCOLOR= "Name_other_skincolor";
	public static final String ID_LANGUAGE= "Id_language";
	public static final String SD_LANGUAGE= "Sd_language";
	public static final String NAME_OTHER_LANGUAGE= "Name_other_language";
	public static final String ID_BREATH= "Id_breath";
	public static final String SD_BREATH= "Sd_breath";
	public static final String NAME_OTHER_BREATH= "Name_other_breath";
	public static final String ID_COUGH= "Id_cough";
	public static final String SD_COUGH= "Sd_cough";
	public static final String NAME_OTHER_EAT= "Name_other_eat";
	public static final String ID_HOBBY= "Id_hobby";
	public static final String SD_HOBBY= "Sd_hobby";
	public static final String NAME_OTHER_HOBBY= "Name_other_hobby";
	public static final String ID_EAT_HABITS= "Id_eat_habits";
	public static final String SD_EAT_HABITS= "Sd_eat_habits";
	public static final String NAME_OTHER_EATHAB= "Name_other_eathab";
	public static final String ID_THIRSTY= "Id_thirsty";
	public static final String SD_THIRSTY= "Sd_thirsty";
	public static final String ID_RIGHT_EAR= "Id_right_ear";
	public static final String SD_RIGHT_EAR= "Sd_right_ear";
	public static final String ID_LEFT_EAR= "Id_left_ear";
	public static final String SD_LEFT_EAR= "Sd_left_ear";
	public static final String ID_RIGHT_EYE= "Id_right_eye";
	public static final String SD_RIGHT_EYE= "Sd_right_eye";
	public static final String ID_LEFT_EYE= "Id_left_eye";
	public static final String SD_LEFT_EYE= "Sd_left_eye";
	public static final String ID_SLEEP= "Id_sleep";
	public static final String SD_SLEEP= "Sd_sleep";
	public static final String NAME_OTHER_SLEEP= "Name_other_sleep";
	public static final String ID_PULSE_CONDITION= "Id_pulse_condition";
	public static final String SD_PULSE_CONDITION= "Sd_pulse_condition";
	public static final String NAME_OTHER_PULSECON= "Name_other_pulsecon";
	public static final String ID_CONSCIOUSNESS= "Id_consciousness";
	public static final String SD_CONSCIOUSNESS= "Sd_consciousness";
	public static final String NAME_OTHER_CONSCIOUSNESS= "Name_other_consciousness";
	public static final String ID_SHIT= "Id_shit";
	public static final String SD_SHIT= "Sd_shit";
	public static final String NAME_OTHER_SHIT= "Name_other_shit";
	public static final String ID_URINE= "Id_urine";
	public static final String SD_URINE= "Sd_urine";
	public static final String NAME_OTHER_URINE= "Name_other_urine";
	public static final String ID_HOSPITALEDUCATION= "Id_hospitaleducation";
	public static final String SD_HOSPITALEDUCATION= "Sd_hospitaleducation";
	public static final String OTHER_HOSPITALEDUCA= "Other_hospitaleduca";
	public static final String NURSINGPLAN= "Nursingplan";
	public static final String DT_EVALUATION= "Dt_evaluation";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_HOSPITALIZEWAY= "Name_hospitalizeway";
	public static final String NAME_EDUC= "Name_educ";
	public static final String NAME_MARRY= "Name_marry";
	public static final String NAME_TONGUE= "Name_tongue";
	public static final String NAME_SOLAR_ILL= "Name_solar_ill";
	public static final String NAME_TONGUE_COAT= "Name_tongue_coat";
	public static final String NAME_EMOTION= "Name_emotion";
	public static final String NAME_COMPLEXION= "Name_complexion";
	public static final String NAME_MORP= "Name_morp";
	public static final String NAME_SKIN_DAMAGE= "Name_skin_damage";
	public static final String NAME_SKIN_COLOR= "Name_skin_color";
	public static final String NAME_LANGUAGE= "Name_language";
	public static final String NAME_BREATH= "Name_breath";
	public static final String NAME_COUGH= "Name_cough";
	public static final String NAME_HOBBY= "Name_hobby";
	public static final String NAME_EAT_HABITS= "Name_eat_habits";
	public static final String NAME_THIRSTY= "Name_thirsty";
	public static final String NAME_RIGHT_EAR= "Name_right_ear";
	public static final String NAME_LEFT_EAR= "Name_left_ear";
	public static final String NAME_RIGHT_EYE= "Name_right_eye";
	public static final String NAME_LEFT_EYE= "Name_left_eye";
	public static final String NAME_SLEEP= "Name_sleep";
	public static final String NAME_PULSE_CONDITION= "Name_pulse_condition";
	public static final String NAME_CONSCIOUSNESS= "Name_consciousness";
	public static final String NAME_SHIT= "Name_shit";
	public static final String NAME_URINE= "Name_urine";
	public static final String NAME_HOSPITALEDUCATION= "Name_hospitaleducation";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public ObsadmcareassDO () {
		super();
	}
	
	public String getId_obsadmcareass() {
		return ((String) getAttrVal("Id_obsadmcareass"));
	}	
	public void setId_obsadmcareass(String Id_obsadmcareass) {
		setAttrVal("Id_obsadmcareass", Id_obsadmcareass);
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
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	public String getId_hospitalizeway() {
		return ((String) getAttrVal("Id_hospitalizeway"));
	}	
	public void setId_hospitalizeway(String Id_hospitalizeway) {
		setAttrVal("Id_hospitalizeway", Id_hospitalizeway);
	}
	public String getSd_hospitalizeway() {
		return ((String) getAttrVal("Sd_hospitalizeway"));
	}	
	public void setSd_hospitalizeway(String Sd_hospitalizeway) {
		setAttrVal("Sd_hospitalizeway", Sd_hospitalizeway);
	}
	public String getOther_hospitalizeway() {
		return ((String) getAttrVal("Other_hospitalizeway"));
	}	
	public void setOther_hospitalizeway(String Other_hospitalizeway) {
		setAttrVal("Other_hospitalizeway", Other_hospitalizeway);
	}
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}	
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
	}
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	public String getPatcont() {
		return ((String) getAttrVal("Patcont"));
	}	
	public void setPatcont(String Patcont) {
		setAttrVal("Patcont", Patcont);
	}
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	public String getPhone() {
		return ((String) getAttrVal("Phone"));
	}	
	public void setPhone(String Phone) {
		setAttrVal("Phone", Phone);
	}
	public String getPataddr() {
		return ((String) getAttrVal("Pataddr"));
	}	
	public void setPataddr(String Pataddr) {
		setAttrVal("Pataddr", Pataddr);
	}
	public String getName_chinese_medicine() {
		return ((String) getAttrVal("Name_chinese_medicine"));
	}	
	public void setName_chinese_medicine(String Name_chinese_medicine) {
		setAttrVal("Name_chinese_medicine", Name_chinese_medicine);
	}
	public String getName_medicine() {
		return ((String) getAttrVal("Name_medicine"));
	}	
	public void setName_medicine(String Name_medicine) {
		setAttrVal("Name_medicine", Name_medicine);
	}
	public FBoolean getFg_pastmedic() {
		return ((FBoolean) getAttrVal("Fg_pastmedic"));
	}	
	public void setFg_pastmedic(FBoolean Fg_pastmedic) {
		setAttrVal("Fg_pastmedic", Fg_pastmedic);
	}
	public String getName_pastmedic() {
		return ((String) getAttrVal("Name_pastmedic"));
	}	
	public void setName_pastmedic(String Name_pastmedic) {
		setAttrVal("Name_pastmedic", Name_pastmedic);
	}
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	public String getName_allergy() {
		return ((String) getAttrVal("Name_allergy"));
	}	
	public void setName_allergy(String Name_allergy) {
		setAttrVal("Name_allergy", Name_allergy);
	}
	public Integer getPaulse() {
		return ((Integer) getAttrVal("Paulse"));
	}	
	public void setPaulse(Integer Paulse) {
		setAttrVal("Paulse", Paulse);
	}
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public Integer getSys_pre() {
		return ((Integer) getAttrVal("Sys_pre"));
	}	
	public void setSys_pre(Integer Sys_pre) {
		setAttrVal("Sys_pre", Sys_pre);
	}
	public Integer getDia_pre() {
		return ((Integer) getAttrVal("Dia_pre"));
	}	
	public void setDia_pre(Integer Dia_pre) {
		setAttrVal("Dia_pre", Dia_pre);
	}
	public FDouble getTem() {
		return ((FDouble) getAttrVal("Tem"));
	}	
	public void setTem(FDouble Tem) {
		setAttrVal("Tem", Tem);
	}
	public FDouble getScore_helpme() {
		return ((FDouble) getAttrVal("Score_helpme"));
	}	
	public void setScore_helpme(FDouble Score_helpme) {
		setAttrVal("Score_helpme", Score_helpme);
	}
	public FDouble getScore_pressuresore() {
		return ((FDouble) getAttrVal("Score_pressuresore"));
	}	
	public void setScore_pressuresore(FDouble Score_pressuresore) {
		setAttrVal("Score_pressuresore", Score_pressuresore);
	}
	public FDouble getScore_falldown() {
		return ((FDouble) getAttrVal("Score_falldown"));
	}	
	public void setScore_falldown(FDouble Score_falldown) {
		setAttrVal("Score_falldown", Score_falldown);
	}
	public FDouble getScore_pain() {
		return ((FDouble) getAttrVal("Score_pain"));
	}	
	public void setScore_pain(FDouble Score_pain) {
		setAttrVal("Score_pain", Score_pain);
	}
	public FDouble getScore_pipe_slippage() {
		return ((FDouble) getAttrVal("Score_pipe_slippage"));
	}	
	public void setScore_pipe_slippage(FDouble Score_pipe_slippage) {
		setAttrVal("Score_pipe_slippage", Score_pipe_slippage);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public Integer getEu_mucosa() {
		return ((Integer) getAttrVal("Eu_mucosa"));
	}	
	public void setEu_mucosa(Integer Eu_mucosa) {
		setAttrVal("Eu_mucosa", Eu_mucosa);
	}
	public Integer getEu_den_tooth() {
		return ((Integer) getAttrVal("Eu_den_tooth"));
	}	
	public void setEu_den_tooth(Integer Eu_den_tooth) {
		setAttrVal("Eu_den_tooth", Eu_den_tooth);
	}
	public Integer getEu_eat() {
		return ((Integer) getAttrVal("Eu_eat"));
	}	
	public void setEu_eat(Integer Eu_eat) {
		setAttrVal("Eu_eat", Eu_eat);
	}
	public Integer getEu_cough() {
		return ((Integer) getAttrVal("Eu_cough"));
	}	
	public void setEu_cough(Integer Eu_cough) {
		setAttrVal("Eu_cough", Eu_cough);
	}
	public Integer getEu_hobby() {
		return ((Integer) getAttrVal("Eu_hobby"));
	}	
	public void setEu_hobby(Integer Eu_hobby) {
		setAttrVal("Eu_hobby", Eu_hobby);
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
	public String getName_other_tongue() {
		return ((String) getAttrVal("Name_other_tongue"));
	}	
	public void setName_other_tongue(String Name_other_tongue) {
		setAttrVal("Name_other_tongue", Name_other_tongue);
	}
	public String getName_specialty() {
		return ((String) getAttrVal("Name_specialty"));
	}	
	public void setName_specialty(String Name_specialty) {
		setAttrVal("Name_specialty", Name_specialty);
	}
	public String getName_nursing() {
		return ((String) getAttrVal("Name_nursing"));
	}	
	public void setName_nursing(String Name_nursing) {
		setAttrVal("Name_nursing", Name_nursing);
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
	public String getId_tongue_coat() {
		return ((String) getAttrVal("Id_tongue_coat"));
	}	
	public void setId_tongue_coat(String Id_tongue_coat) {
		setAttrVal("Id_tongue_coat", Id_tongue_coat);
	}
	public String getSd_tongue_coat() {
		return ((String) getAttrVal("Sd_tongue_coat"));
	}	
	public void setSd_tongue_coat(String Sd_tongue_coat) {
		setAttrVal("Sd_tongue_coat", Sd_tongue_coat);
	}
	public String getName_other_tonguecoat() {
		return ((String) getAttrVal("Name_other_tonguecoat"));
	}	
	public void setName_other_tonguecoat(String Name_other_tonguecoat) {
		setAttrVal("Name_other_tonguecoat", Name_other_tonguecoat);
	}
	public String getId_emotion() {
		return ((String) getAttrVal("Id_emotion"));
	}	
	public void setId_emotion(String Id_emotion) {
		setAttrVal("Id_emotion", Id_emotion);
	}
	public String getSd_emotion() {
		return ((String) getAttrVal("Sd_emotion"));
	}	
	public void setSd_emotion(String Sd_emotion) {
		setAttrVal("Sd_emotion", Sd_emotion);
	}
	public String getName_other_emotion() {
		return ((String) getAttrVal("Name_other_emotion"));
	}	
	public void setName_other_emotion(String Name_other_emotion) {
		setAttrVal("Name_other_emotion", Name_other_emotion);
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
	public String getName_other_complexion() {
		return ((String) getAttrVal("Name_other_complexion"));
	}	
	public void setName_other_complexion(String Name_other_complexion) {
		setAttrVal("Name_other_complexion", Name_other_complexion);
	}
	public String getId_morp() {
		return ((String) getAttrVal("Id_morp"));
	}	
	public void setId_morp(String Id_morp) {
		setAttrVal("Id_morp", Id_morp);
	}
	public String getSd_morp() {
		return ((String) getAttrVal("Sd_morp"));
	}	
	public void setSd_morp(String Sd_morp) {
		setAttrVal("Sd_morp", Sd_morp);
	}
	public String getId_skin_damage() {
		return ((String) getAttrVal("Id_skin_damage"));
	}	
	public void setId_skin_damage(String Id_skin_damage) {
		setAttrVal("Id_skin_damage", Id_skin_damage);
	}
	public String getSd_skin_damage() {
		return ((String) getAttrVal("Sd_skin_damage"));
	}	
	public void setSd_skin_damage(String Sd_skin_damage) {
		setAttrVal("Sd_skin_damage", Sd_skin_damage);
	}
	public String getName_damaged() {
		return ((String) getAttrVal("Name_damaged"));
	}	
	public void setName_damaged(String Name_damaged) {
		setAttrVal("Name_damaged", Name_damaged);
	}
	public String getName_pressure_sore() {
		return ((String) getAttrVal("Name_pressure_sore"));
	}	
	public void setName_pressure_sore(String Name_pressure_sore) {
		setAttrVal("Name_pressure_sore", Name_pressure_sore);
	}
	public String getId_skin_color() {
		return ((String) getAttrVal("Id_skin_color"));
	}	
	public void setId_skin_color(String Id_skin_color) {
		setAttrVal("Id_skin_color", Id_skin_color);
	}
	public String getSd_skin_color() {
		return ((String) getAttrVal("Sd_skin_color"));
	}	
	public void setSd_skin_color(String Sd_skin_color) {
		setAttrVal("Sd_skin_color", Sd_skin_color);
	}
	public String getName_other_skincolor() {
		return ((String) getAttrVal("Name_other_skincolor"));
	}	
	public void setName_other_skincolor(String Name_other_skincolor) {
		setAttrVal("Name_other_skincolor", Name_other_skincolor);
	}
	public String getId_language() {
		return ((String) getAttrVal("Id_language"));
	}	
	public void setId_language(String Id_language) {
		setAttrVal("Id_language", Id_language);
	}
	public String getSd_language() {
		return ((String) getAttrVal("Sd_language"));
	}	
	public void setSd_language(String Sd_language) {
		setAttrVal("Sd_language", Sd_language);
	}
	public String getName_other_language() {
		return ((String) getAttrVal("Name_other_language"));
	}	
	public void setName_other_language(String Name_other_language) {
		setAttrVal("Name_other_language", Name_other_language);
	}
	public String getId_breath() {
		return ((String) getAttrVal("Id_breath"));
	}	
	public void setId_breath(String Id_breath) {
		setAttrVal("Id_breath", Id_breath);
	}
	public String getSd_breath() {
		return ((String) getAttrVal("Sd_breath"));
	}	
	public void setSd_breath(String Sd_breath) {
		setAttrVal("Sd_breath", Sd_breath);
	}
	public String getName_other_breath() {
		return ((String) getAttrVal("Name_other_breath"));
	}	
	public void setName_other_breath(String Name_other_breath) {
		setAttrVal("Name_other_breath", Name_other_breath);
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
	public String getName_other_eat() {
		return ((String) getAttrVal("Name_other_eat"));
	}	
	public void setName_other_eat(String Name_other_eat) {
		setAttrVal("Name_other_eat", Name_other_eat);
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
	public String getName_other_hobby() {
		return ((String) getAttrVal("Name_other_hobby"));
	}	
	public void setName_other_hobby(String Name_other_hobby) {
		setAttrVal("Name_other_hobby", Name_other_hobby);
	}
	public String getId_eat_habits() {
		return ((String) getAttrVal("Id_eat_habits"));
	}	
	public void setId_eat_habits(String Id_eat_habits) {
		setAttrVal("Id_eat_habits", Id_eat_habits);
	}
	public String getSd_eat_habits() {
		return ((String) getAttrVal("Sd_eat_habits"));
	}	
	public void setSd_eat_habits(String Sd_eat_habits) {
		setAttrVal("Sd_eat_habits", Sd_eat_habits);
	}
	public String getName_other_eathab() {
		return ((String) getAttrVal("Name_other_eathab"));
	}	
	public void setName_other_eathab(String Name_other_eathab) {
		setAttrVal("Name_other_eathab", Name_other_eathab);
	}
	public String getId_thirsty() {
		return ((String) getAttrVal("Id_thirsty"));
	}	
	public void setId_thirsty(String Id_thirsty) {
		setAttrVal("Id_thirsty", Id_thirsty);
	}
	public String getSd_thirsty() {
		return ((String) getAttrVal("Sd_thirsty"));
	}	
	public void setSd_thirsty(String Sd_thirsty) {
		setAttrVal("Sd_thirsty", Sd_thirsty);
	}
	public String getId_right_ear() {
		return ((String) getAttrVal("Id_right_ear"));
	}	
	public void setId_right_ear(String Id_right_ear) {
		setAttrVal("Id_right_ear", Id_right_ear);
	}
	public String getSd_right_ear() {
		return ((String) getAttrVal("Sd_right_ear"));
	}	
	public void setSd_right_ear(String Sd_right_ear) {
		setAttrVal("Sd_right_ear", Sd_right_ear);
	}
	public String getId_left_ear() {
		return ((String) getAttrVal("Id_left_ear"));
	}	
	public void setId_left_ear(String Id_left_ear) {
		setAttrVal("Id_left_ear", Id_left_ear);
	}
	public String getSd_left_ear() {
		return ((String) getAttrVal("Sd_left_ear"));
	}	
	public void setSd_left_ear(String Sd_left_ear) {
		setAttrVal("Sd_left_ear", Sd_left_ear);
	}
	public String getId_right_eye() {
		return ((String) getAttrVal("Id_right_eye"));
	}	
	public void setId_right_eye(String Id_right_eye) {
		setAttrVal("Id_right_eye", Id_right_eye);
	}
	public String getSd_right_eye() {
		return ((String) getAttrVal("Sd_right_eye"));
	}	
	public void setSd_right_eye(String Sd_right_eye) {
		setAttrVal("Sd_right_eye", Sd_right_eye);
	}
	public String getId_left_eye() {
		return ((String) getAttrVal("Id_left_eye"));
	}	
	public void setId_left_eye(String Id_left_eye) {
		setAttrVal("Id_left_eye", Id_left_eye);
	}
	public String getSd_left_eye() {
		return ((String) getAttrVal("Sd_left_eye"));
	}	
	public void setSd_left_eye(String Sd_left_eye) {
		setAttrVal("Sd_left_eye", Sd_left_eye);
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
	public String getName_other_sleep() {
		return ((String) getAttrVal("Name_other_sleep"));
	}	
	public void setName_other_sleep(String Name_other_sleep) {
		setAttrVal("Name_other_sleep", Name_other_sleep);
	}
	public String getId_pulse_condition() {
		return ((String) getAttrVal("Id_pulse_condition"));
	}	
	public void setId_pulse_condition(String Id_pulse_condition) {
		setAttrVal("Id_pulse_condition", Id_pulse_condition);
	}
	public String getSd_pulse_condition() {
		return ((String) getAttrVal("Sd_pulse_condition"));
	}	
	public void setSd_pulse_condition(String Sd_pulse_condition) {
		setAttrVal("Sd_pulse_condition", Sd_pulse_condition);
	}
	public String getName_other_pulsecon() {
		return ((String) getAttrVal("Name_other_pulsecon"));
	}	
	public void setName_other_pulsecon(String Name_other_pulsecon) {
		setAttrVal("Name_other_pulsecon", Name_other_pulsecon);
	}
	public String getId_consciousness() {
		return ((String) getAttrVal("Id_consciousness"));
	}	
	public void setId_consciousness(String Id_consciousness) {
		setAttrVal("Id_consciousness", Id_consciousness);
	}
	public String getSd_consciousness() {
		return ((String) getAttrVal("Sd_consciousness"));
	}	
	public void setSd_consciousness(String Sd_consciousness) {
		setAttrVal("Sd_consciousness", Sd_consciousness);
	}
	public String getName_other_consciousness() {
		return ((String) getAttrVal("Name_other_consciousness"));
	}	
	public void setName_other_consciousness(String Name_other_consciousness) {
		setAttrVal("Name_other_consciousness", Name_other_consciousness);
	}
	public String getId_shit() {
		return ((String) getAttrVal("Id_shit"));
	}	
	public void setId_shit(String Id_shit) {
		setAttrVal("Id_shit", Id_shit);
	}
	public String getSd_shit() {
		return ((String) getAttrVal("Sd_shit"));
	}	
	public void setSd_shit(String Sd_shit) {
		setAttrVal("Sd_shit", Sd_shit);
	}
	public String getName_other_shit() {
		return ((String) getAttrVal("Name_other_shit"));
	}	
	public void setName_other_shit(String Name_other_shit) {
		setAttrVal("Name_other_shit", Name_other_shit);
	}
	public String getId_urine() {
		return ((String) getAttrVal("Id_urine"));
	}	
	public void setId_urine(String Id_urine) {
		setAttrVal("Id_urine", Id_urine);
	}
	public String getSd_urine() {
		return ((String) getAttrVal("Sd_urine"));
	}	
	public void setSd_urine(String Sd_urine) {
		setAttrVal("Sd_urine", Sd_urine);
	}
	public String getName_other_urine() {
		return ((String) getAttrVal("Name_other_urine"));
	}	
	public void setName_other_urine(String Name_other_urine) {
		setAttrVal("Name_other_urine", Name_other_urine);
	}
	public String getId_hospitaleducation() {
		return ((String) getAttrVal("Id_hospitaleducation"));
	}	
	public void setId_hospitaleducation(String Id_hospitaleducation) {
		setAttrVal("Id_hospitaleducation", Id_hospitaleducation);
	}
	public String getSd_hospitaleducation() {
		return ((String) getAttrVal("Sd_hospitaleducation"));
	}	
	public void setSd_hospitaleducation(String Sd_hospitaleducation) {
		setAttrVal("Sd_hospitaleducation", Sd_hospitaleducation);
	}
	public String getOther_hospitaleduca() {
		return ((String) getAttrVal("Other_hospitaleduca"));
	}	
	public void setOther_hospitaleduca(String Other_hospitaleduca) {
		setAttrVal("Other_hospitaleduca", Other_hospitaleduca);
	}
	public String getNursingplan() {
		return ((String) getAttrVal("Nursingplan"));
	}	
	public void setNursingplan(String Nursingplan) {
		setAttrVal("Nursingplan", Nursingplan);
	}
	public FDateTime getDt_evaluation() {
		return ((FDateTime) getAttrVal("Dt_evaluation"));
	}	
	public void setDt_evaluation(FDateTime Dt_evaluation) {
		setAttrVal("Dt_evaluation", Dt_evaluation);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
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
	public String getName_hospitalizeway() {
		return ((String) getAttrVal("Name_hospitalizeway"));
	}	
	public void setName_hospitalizeway(String Name_hospitalizeway) {
		setAttrVal("Name_hospitalizeway", Name_hospitalizeway);
	}
	public String getName_educ() {
		return ((String) getAttrVal("Name_educ"));
	}	
	public void setName_educ(String Name_educ) {
		setAttrVal("Name_educ", Name_educ);
	}
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	public String getName_tongue() {
		return ((String) getAttrVal("Name_tongue"));
	}	
	public void setName_tongue(String Name_tongue) {
		setAttrVal("Name_tongue", Name_tongue);
	}
	public String getName_solar_ill() {
		return ((String) getAttrVal("Name_solar_ill"));
	}	
	public void setName_solar_ill(String Name_solar_ill) {
		setAttrVal("Name_solar_ill", Name_solar_ill);
	}
	public String getName_tongue_coat() {
		return ((String) getAttrVal("Name_tongue_coat"));
	}	
	public void setName_tongue_coat(String Name_tongue_coat) {
		setAttrVal("Name_tongue_coat", Name_tongue_coat);
	}
	public String getName_emotion() {
		return ((String) getAttrVal("Name_emotion"));
	}	
	public void setName_emotion(String Name_emotion) {
		setAttrVal("Name_emotion", Name_emotion);
	}
	public String getName_complexion() {
		return ((String) getAttrVal("Name_complexion"));
	}	
	public void setName_complexion(String Name_complexion) {
		setAttrVal("Name_complexion", Name_complexion);
	}
	public String getName_morp() {
		return ((String) getAttrVal("Name_morp"));
	}	
	public void setName_morp(String Name_morp) {
		setAttrVal("Name_morp", Name_morp);
	}
	public String getName_skin_damage() {
		return ((String) getAttrVal("Name_skin_damage"));
	}	
	public void setName_skin_damage(String Name_skin_damage) {
		setAttrVal("Name_skin_damage", Name_skin_damage);
	}
	public String getName_skin_color() {
		return ((String) getAttrVal("Name_skin_color"));
	}	
	public void setName_skin_color(String Name_skin_color) {
		setAttrVal("Name_skin_color", Name_skin_color);
	}
	public String getName_language() {
		return ((String) getAttrVal("Name_language"));
	}	
	public void setName_language(String Name_language) {
		setAttrVal("Name_language", Name_language);
	}
	public String getName_breath() {
		return ((String) getAttrVal("Name_breath"));
	}	
	public void setName_breath(String Name_breath) {
		setAttrVal("Name_breath", Name_breath);
	}
	public String getName_cough() {
		return ((String) getAttrVal("Name_cough"));
	}	
	public void setName_cough(String Name_cough) {
		setAttrVal("Name_cough", Name_cough);
	}
	public String getName_hobby() {
		return ((String) getAttrVal("Name_hobby"));
	}	
	public void setName_hobby(String Name_hobby) {
		setAttrVal("Name_hobby", Name_hobby);
	}
	public String getName_eat_habits() {
		return ((String) getAttrVal("Name_eat_habits"));
	}	
	public void setName_eat_habits(String Name_eat_habits) {
		setAttrVal("Name_eat_habits", Name_eat_habits);
	}
	public String getName_thirsty() {
		return ((String) getAttrVal("Name_thirsty"));
	}	
	public void setName_thirsty(String Name_thirsty) {
		setAttrVal("Name_thirsty", Name_thirsty);
	}
	public String getName_right_ear() {
		return ((String) getAttrVal("Name_right_ear"));
	}	
	public void setName_right_ear(String Name_right_ear) {
		setAttrVal("Name_right_ear", Name_right_ear);
	}
	public String getName_left_ear() {
		return ((String) getAttrVal("Name_left_ear"));
	}	
	public void setName_left_ear(String Name_left_ear) {
		setAttrVal("Name_left_ear", Name_left_ear);
	}
	public String getName_right_eye() {
		return ((String) getAttrVal("Name_right_eye"));
	}	
	public void setName_right_eye(String Name_right_eye) {
		setAttrVal("Name_right_eye", Name_right_eye);
	}
	public String getName_left_eye() {
		return ((String) getAttrVal("Name_left_eye"));
	}	
	public void setName_left_eye(String Name_left_eye) {
		setAttrVal("Name_left_eye", Name_left_eye);
	}
	public String getName_sleep() {
		return ((String) getAttrVal("Name_sleep"));
	}	
	public void setName_sleep(String Name_sleep) {
		setAttrVal("Name_sleep", Name_sleep);
	}
	public String getName_pulse_condition() {
		return ((String) getAttrVal("Name_pulse_condition"));
	}	
	public void setName_pulse_condition(String Name_pulse_condition) {
		setAttrVal("Name_pulse_condition", Name_pulse_condition);
	}
	public String getName_consciousness() {
		return ((String) getAttrVal("Name_consciousness"));
	}	
	public void setName_consciousness(String Name_consciousness) {
		setAttrVal("Name_consciousness", Name_consciousness);
	}
	public String getName_shit() {
		return ((String) getAttrVal("Name_shit"));
	}	
	public void setName_shit(String Name_shit) {
		setAttrVal("Name_shit", Name_shit);
	}
	public String getName_urine() {
		return ((String) getAttrVal("Name_urine"));
	}	
	public void setName_urine(String Name_urine) {
		setAttrVal("Name_urine", Name_urine);
	}
	public String getName_hospitaleducation() {
		return ((String) getAttrVal("Name_hospitaleducation"));
	}	
	public void setName_hospitaleducation(String Name_hospitaleducation) {
		setAttrVal("Name_hospitaleducation", Name_hospitaleducation);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_obsadmcareass";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_obsadmcareass";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ObsadmcareassDODesc.class);
	}
	
}