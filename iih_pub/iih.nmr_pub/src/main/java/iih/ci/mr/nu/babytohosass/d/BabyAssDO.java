package iih.ci.mr.nu.babytohosass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.babytohosass.d.desc.BabyAssDODesc;
import java.math.BigDecimal;

/**
 * 新生儿基本信息 DO数据 
 * 
 */
public class BabyAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BABY= "Id_baby";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_PARENT= "Name_parent";
	public static final String NAME_MEDHISPRE= "Name_medhispre";
	public static final String PRE_RELAT= "Pre_relat";
	public static final String TEL= "Tel";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String DT_COLLECTDATA= "Dt_collectdata";
	public static final String HOSP_REASON= "Hosp_reason";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_PRODUCT_MODE= "Id_product_mode";
	public static final String SD_PRODUCT_MODE= "Sd_product_mode";
	public static final String PRODUCT_MODE_OTHER= "Product_mode_other";
	public static final String ID_FEED_MODE= "Id_feed_mode";
	public static final String SD_FEED_MODE= "Sd_feed_mode";
	public static final String BIRTH_ORDER= "Birth_order";
	public static final String LY_IN= "Ly_in";
	public static final String ID_FETAL_AGE= "Id_fetal_age";
	public static final String SD_FETAL_AGE= "Sd_fetal_age";
	public static final String PRETERM_BIRTH_WEEK= "Preterm_birth_week";
	public static final String TWINS= "Twins";
	public static final String TEMP= "Temp";
	public static final String PULSE= "Pulse";
	public static final String BREATH= "Breath";
	public static final String WEIGHT= "Weight";
	public static final String HEADSIZE= "Headsize";
	public static final String HEIGHT= "Height";
	public static final String ID_MIND_STATES= "Id_mind_states";
	public static final String SD_MIND_STATES= "Sd_mind_states";
	public static final String ID_CRY= "Id_cry";
	public static final String SD_CRY= "Sd_cry";
	public static final String ID_LIMB_EXER= "Id_limb_exer";
	public static final String SD_LIMB_EXER= "Sd_limb_exer";
	public static final String ID_MUSCLE_TONE= "Id_muscle_tone";
	public static final String SD_MUSCLE_TONE= "Sd_muscle_tone";
	public static final String ID_REFLEX_ACTION= "Id_reflex_action";
	public static final String SD_REFLEX_ACTION= "Sd_reflex_action";
	public static final String ID_FACE_COLOR= "Id_face_color";
	public static final String SD_FACE_COLOR= "Sd_face_color";
	public static final String FACE_COLOR_OTHER= "Face_color_other";
	public static final String ID_MOUTH_MUCOSA= "Id_mouth_mucosa";
	public static final String SD_MOUTH_MUCOSA= "Sd_mouth_mucosa";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String ID_BREATH_STATES= "Id_breath_states";
	public static final String SD_BREATH_STATES= "Sd_breath_states";
	public static final String BREATH_STATES_OTHER= "Breath_states_other";
	public static final String ID_DIGESTIVE_SYSTEM= "Id_digestive_system";
	public static final String SD_DIGESTIVE_SYSTEM= "Sd_digestive_system";
	public static final String ID_FUNICLE= "Id_funicle";
	public static final String SD_FUNICLE= "Sd_funicle";
	public static final String ID_PERI_UMBILICUS= "Id_peri_umbilicus";
	public static final String SD_PERI_UMBILICUS= "Sd_peri_umbilicus";
	public static final String PERI_UMBILICUS_OTHER= "Peri_umbilicus_other";
	public static final String SUBJECT_SITUAT= "Subject_situat";
	public static final String NUR_MANAGE= "Nur_manage";
	public static final String NAME_NUR_PSN1= "Name_nur_psn1";
	public static final String ID_NUR_PSN1= "Id_nur_psn1";
	public static final String NAME_NUR_PSN2= "Name_nur_psn2";
	public static final String ID_NUR_PSN2= "Id_nur_psn2";
	public static final String DT_ASS= "Dt_ass";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_PSN_SIGN= "Id_psn_sign";
	public static final String NAME_PRODUCT_MODE= "Name_product_mode";
	public static final String NAME_FEED_MODE= "Name_feed_mode";
	public static final String NAME_FETAL_AGE= "Name_fetal_age";
	public static final String NAME_MIND_STATES= "Name_mind_states";
	public static final String NAME_CRY= "Name_cry";
	public static final String NAME_LIMB_EXER= "Name_limb_exer";
	public static final String NAME_MUSCLE_TONE= "Name_muscle_tone";
	public static final String NAME_REFLEX_ACTION= "Name_reflex_action";
	public static final String NAME_FACE_COLOR= "Name_face_color";
	public static final String NAME_MOUTH_MUCOSA= "Name_mouth_mucosa";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_BREATH_STATES= "Name_breath_states";
	public static final String NAME_DIGESTIVE_SYSTEM= "Name_digestive_system";
	public static final String NAME_FUNICLE= "Name_funicle";
	public static final String NAME_PERI_UMBILICUS= "Name_peri_umbilicus";
	public static final String NAME_PSN_SIGN= "Name_psn_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_baby() {
		return ((String) getAttrVal("Id_baby"));
	}	
	public void setId_baby(String Id_baby) {
		setAttrVal("Id_baby", Id_baby);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
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
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getName_parent() {
		return ((String) getAttrVal("Name_parent"));
	}	
	public void setName_parent(String Name_parent) {
		setAttrVal("Name_parent", Name_parent);
	}
	public String getName_medhispre() {
		return ((String) getAttrVal("Name_medhispre"));
	}	
	public void setName_medhispre(String Name_medhispre) {
		setAttrVal("Name_medhispre", Name_medhispre);
	}
	public String getPre_relat() {
		return ((String) getAttrVal("Pre_relat"));
	}	
	public void setPre_relat(String Pre_relat) {
		setAttrVal("Pre_relat", Pre_relat);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public FDateTime getDt_collectdata() {
		return ((FDateTime) getAttrVal("Dt_collectdata"));
	}	
	public void setDt_collectdata(FDateTime Dt_collectdata) {
		setAttrVal("Dt_collectdata", Dt_collectdata);
	}
	public String getHosp_reason() {
		return ((String) getAttrVal("Hosp_reason"));
	}	
	public void setHosp_reason(String Hosp_reason) {
		setAttrVal("Hosp_reason", Hosp_reason);
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
	public String getId_product_mode() {
		return ((String) getAttrVal("Id_product_mode"));
	}	
	public void setId_product_mode(String Id_product_mode) {
		setAttrVal("Id_product_mode", Id_product_mode);
	}
	public String getSd_product_mode() {
		return ((String) getAttrVal("Sd_product_mode"));
	}	
	public void setSd_product_mode(String Sd_product_mode) {
		setAttrVal("Sd_product_mode", Sd_product_mode);
	}
	public String getProduct_mode_other() {
		return ((String) getAttrVal("Product_mode_other"));
	}	
	public void setProduct_mode_other(String Product_mode_other) {
		setAttrVal("Product_mode_other", Product_mode_other);
	}
	public String getId_feed_mode() {
		return ((String) getAttrVal("Id_feed_mode"));
	}	
	public void setId_feed_mode(String Id_feed_mode) {
		setAttrVal("Id_feed_mode", Id_feed_mode);
	}
	public String getSd_feed_mode() {
		return ((String) getAttrVal("Sd_feed_mode"));
	}	
	public void setSd_feed_mode(String Sd_feed_mode) {
		setAttrVal("Sd_feed_mode", Sd_feed_mode);
	}
	public Integer getBirth_order() {
		return ((Integer) getAttrVal("Birth_order"));
	}	
	public void setBirth_order(Integer Birth_order) {
		setAttrVal("Birth_order", Birth_order);
	}
	public Integer getLy_in() {
		return ((Integer) getAttrVal("Ly_in"));
	}	
	public void setLy_in(Integer Ly_in) {
		setAttrVal("Ly_in", Ly_in);
	}
	public String getId_fetal_age() {
		return ((String) getAttrVal("Id_fetal_age"));
	}	
	public void setId_fetal_age(String Id_fetal_age) {
		setAttrVal("Id_fetal_age", Id_fetal_age);
	}
	public String getSd_fetal_age() {
		return ((String) getAttrVal("Sd_fetal_age"));
	}	
	public void setSd_fetal_age(String Sd_fetal_age) {
		setAttrVal("Sd_fetal_age", Sd_fetal_age);
	}
	public Integer getPreterm_birth_week() {
		return ((Integer) getAttrVal("Preterm_birth_week"));
	}	
	public void setPreterm_birth_week(Integer Preterm_birth_week) {
		setAttrVal("Preterm_birth_week", Preterm_birth_week);
	}
	public FBoolean getTwins() {
		return ((FBoolean) getAttrVal("Twins"));
	}	
	public void setTwins(FBoolean Twins) {
		setAttrVal("Twins", Twins);
	}
	public FDouble getTemp() {
		return ((FDouble) getAttrVal("Temp"));
	}	
	public void setTemp(FDouble Temp) {
		setAttrVal("Temp", Temp);
	}
	public Integer getPulse() {
		return ((Integer) getAttrVal("Pulse"));
	}	
	public void setPulse(Integer Pulse) {
		setAttrVal("Pulse", Pulse);
	}
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public FDouble getHeadsize() {
		return ((FDouble) getAttrVal("Headsize"));
	}	
	public void setHeadsize(FDouble Headsize) {
		setAttrVal("Headsize", Headsize);
	}
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}	
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	public String getId_mind_states() {
		return ((String) getAttrVal("Id_mind_states"));
	}	
	public void setId_mind_states(String Id_mind_states) {
		setAttrVal("Id_mind_states", Id_mind_states);
	}
	public String getSd_mind_states() {
		return ((String) getAttrVal("Sd_mind_states"));
	}	
	public void setSd_mind_states(String Sd_mind_states) {
		setAttrVal("Sd_mind_states", Sd_mind_states);
	}
	public String getId_cry() {
		return ((String) getAttrVal("Id_cry"));
	}	
	public void setId_cry(String Id_cry) {
		setAttrVal("Id_cry", Id_cry);
	}
	public String getSd_cry() {
		return ((String) getAttrVal("Sd_cry"));
	}	
	public void setSd_cry(String Sd_cry) {
		setAttrVal("Sd_cry", Sd_cry);
	}
	public String getId_limb_exer() {
		return ((String) getAttrVal("Id_limb_exer"));
	}	
	public void setId_limb_exer(String Id_limb_exer) {
		setAttrVal("Id_limb_exer", Id_limb_exer);
	}
	public String getSd_limb_exer() {
		return ((String) getAttrVal("Sd_limb_exer"));
	}	
	public void setSd_limb_exer(String Sd_limb_exer) {
		setAttrVal("Sd_limb_exer", Sd_limb_exer);
	}
	public String getId_muscle_tone() {
		return ((String) getAttrVal("Id_muscle_tone"));
	}	
	public void setId_muscle_tone(String Id_muscle_tone) {
		setAttrVal("Id_muscle_tone", Id_muscle_tone);
	}
	public String getSd_muscle_tone() {
		return ((String) getAttrVal("Sd_muscle_tone"));
	}	
	public void setSd_muscle_tone(String Sd_muscle_tone) {
		setAttrVal("Sd_muscle_tone", Sd_muscle_tone);
	}
	public String getId_reflex_action() {
		return ((String) getAttrVal("Id_reflex_action"));
	}	
	public void setId_reflex_action(String Id_reflex_action) {
		setAttrVal("Id_reflex_action", Id_reflex_action);
	}
	public String getSd_reflex_action() {
		return ((String) getAttrVal("Sd_reflex_action"));
	}	
	public void setSd_reflex_action(String Sd_reflex_action) {
		setAttrVal("Sd_reflex_action", Sd_reflex_action);
	}
	public String getId_face_color() {
		return ((String) getAttrVal("Id_face_color"));
	}	
	public void setId_face_color(String Id_face_color) {
		setAttrVal("Id_face_color", Id_face_color);
	}
	public String getSd_face_color() {
		return ((String) getAttrVal("Sd_face_color"));
	}	
	public void setSd_face_color(String Sd_face_color) {
		setAttrVal("Sd_face_color", Sd_face_color);
	}
	public String getFace_color_other() {
		return ((String) getAttrVal("Face_color_other"));
	}	
	public void setFace_color_other(String Face_color_other) {
		setAttrVal("Face_color_other", Face_color_other);
	}
	public String getId_mouth_mucosa() {
		return ((String) getAttrVal("Id_mouth_mucosa"));
	}	
	public void setId_mouth_mucosa(String Id_mouth_mucosa) {
		setAttrVal("Id_mouth_mucosa", Id_mouth_mucosa);
	}
	public String getSd_mouth_mucosa() {
		return ((String) getAttrVal("Sd_mouth_mucosa"));
	}	
	public void setSd_mouth_mucosa(String Sd_mouth_mucosa) {
		setAttrVal("Sd_mouth_mucosa", Sd_mouth_mucosa);
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
	public String getId_breath_states() {
		return ((String) getAttrVal("Id_breath_states"));
	}	
	public void setId_breath_states(String Id_breath_states) {
		setAttrVal("Id_breath_states", Id_breath_states);
	}
	public String getSd_breath_states() {
		return ((String) getAttrVal("Sd_breath_states"));
	}	
	public void setSd_breath_states(String Sd_breath_states) {
		setAttrVal("Sd_breath_states", Sd_breath_states);
	}
	public String getBreath_states_other() {
		return ((String) getAttrVal("Breath_states_other"));
	}	
	public void setBreath_states_other(String Breath_states_other) {
		setAttrVal("Breath_states_other", Breath_states_other);
	}
	public String getId_digestive_system() {
		return ((String) getAttrVal("Id_digestive_system"));
	}	
	public void setId_digestive_system(String Id_digestive_system) {
		setAttrVal("Id_digestive_system", Id_digestive_system);
	}
	public String getSd_digestive_system() {
		return ((String) getAttrVal("Sd_digestive_system"));
	}	
	public void setSd_digestive_system(String Sd_digestive_system) {
		setAttrVal("Sd_digestive_system", Sd_digestive_system);
	}
	public String getId_funicle() {
		return ((String) getAttrVal("Id_funicle"));
	}	
	public void setId_funicle(String Id_funicle) {
		setAttrVal("Id_funicle", Id_funicle);
	}
	public String getSd_funicle() {
		return ((String) getAttrVal("Sd_funicle"));
	}	
	public void setSd_funicle(String Sd_funicle) {
		setAttrVal("Sd_funicle", Sd_funicle);
	}
	public String getId_peri_umbilicus() {
		return ((String) getAttrVal("Id_peri_umbilicus"));
	}	
	public void setId_peri_umbilicus(String Id_peri_umbilicus) {
		setAttrVal("Id_peri_umbilicus", Id_peri_umbilicus);
	}
	public String getSd_peri_umbilicus() {
		return ((String) getAttrVal("Sd_peri_umbilicus"));
	}	
	public void setSd_peri_umbilicus(String Sd_peri_umbilicus) {
		setAttrVal("Sd_peri_umbilicus", Sd_peri_umbilicus);
	}
	public String getPeri_umbilicus_other() {
		return ((String) getAttrVal("Peri_umbilicus_other"));
	}	
	public void setPeri_umbilicus_other(String Peri_umbilicus_other) {
		setAttrVal("Peri_umbilicus_other", Peri_umbilicus_other);
	}
	public String getSubject_situat() {
		return ((String) getAttrVal("Subject_situat"));
	}	
	public void setSubject_situat(String Subject_situat) {
		setAttrVal("Subject_situat", Subject_situat);
	}
	public String getNur_manage() {
		return ((String) getAttrVal("Nur_manage"));
	}	
	public void setNur_manage(String Nur_manage) {
		setAttrVal("Nur_manage", Nur_manage);
	}
	public String getName_nur_psn1() {
		return ((String) getAttrVal("Name_nur_psn1"));
	}	
	public void setName_nur_psn1(String Name_nur_psn1) {
		setAttrVal("Name_nur_psn1", Name_nur_psn1);
	}
	public String getId_nur_psn1() {
		return ((String) getAttrVal("Id_nur_psn1"));
	}	
	public void setId_nur_psn1(String Id_nur_psn1) {
		setAttrVal("Id_nur_psn1", Id_nur_psn1);
	}
	public String getName_nur_psn2() {
		return ((String) getAttrVal("Name_nur_psn2"));
	}	
	public void setName_nur_psn2(String Name_nur_psn2) {
		setAttrVal("Name_nur_psn2", Name_nur_psn2);
	}
	public String getId_nur_psn2() {
		return ((String) getAttrVal("Id_nur_psn2"));
	}	
	public void setId_nur_psn2(String Id_nur_psn2) {
		setAttrVal("Id_nur_psn2", Id_nur_psn2);
	}
	public FDate getDt_ass() {
		return ((FDate) getAttrVal("Dt_ass"));
	}	
	public void setDt_ass(FDate Dt_ass) {
		setAttrVal("Dt_ass", Dt_ass);
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
	public String getId_psn_sign() {
		return ((String) getAttrVal("Id_psn_sign"));
	}	
	public void setId_psn_sign(String Id_psn_sign) {
		setAttrVal("Id_psn_sign", Id_psn_sign);
	}
	public String getName_product_mode() {
		return ((String) getAttrVal("Name_product_mode"));
	}	
	public void setName_product_mode(String Name_product_mode) {
		setAttrVal("Name_product_mode", Name_product_mode);
	}
	public String getName_feed_mode() {
		return ((String) getAttrVal("Name_feed_mode"));
	}	
	public void setName_feed_mode(String Name_feed_mode) {
		setAttrVal("Name_feed_mode", Name_feed_mode);
	}
	public String getName_fetal_age() {
		return ((String) getAttrVal("Name_fetal_age"));
	}	
	public void setName_fetal_age(String Name_fetal_age) {
		setAttrVal("Name_fetal_age", Name_fetal_age);
	}
	public String getName_mind_states() {
		return ((String) getAttrVal("Name_mind_states"));
	}	
	public void setName_mind_states(String Name_mind_states) {
		setAttrVal("Name_mind_states", Name_mind_states);
	}
	public String getName_cry() {
		return ((String) getAttrVal("Name_cry"));
	}	
	public void setName_cry(String Name_cry) {
		setAttrVal("Name_cry", Name_cry);
	}
	public String getName_limb_exer() {
		return ((String) getAttrVal("Name_limb_exer"));
	}	
	public void setName_limb_exer(String Name_limb_exer) {
		setAttrVal("Name_limb_exer", Name_limb_exer);
	}
	public String getName_muscle_tone() {
		return ((String) getAttrVal("Name_muscle_tone"));
	}	
	public void setName_muscle_tone(String Name_muscle_tone) {
		setAttrVal("Name_muscle_tone", Name_muscle_tone);
	}
	public String getName_reflex_action() {
		return ((String) getAttrVal("Name_reflex_action"));
	}	
	public void setName_reflex_action(String Name_reflex_action) {
		setAttrVal("Name_reflex_action", Name_reflex_action);
	}
	public String getName_face_color() {
		return ((String) getAttrVal("Name_face_color"));
	}	
	public void setName_face_color(String Name_face_color) {
		setAttrVal("Name_face_color", Name_face_color);
	}
	public String getName_mouth_mucosa() {
		return ((String) getAttrVal("Name_mouth_mucosa"));
	}	
	public void setName_mouth_mucosa(String Name_mouth_mucosa) {
		setAttrVal("Name_mouth_mucosa", Name_mouth_mucosa);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_breath_states() {
		return ((String) getAttrVal("Name_breath_states"));
	}	
	public void setName_breath_states(String Name_breath_states) {
		setAttrVal("Name_breath_states", Name_breath_states);
	}
	public String getName_digestive_system() {
		return ((String) getAttrVal("Name_digestive_system"));
	}	
	public void setName_digestive_system(String Name_digestive_system) {
		setAttrVal("Name_digestive_system", Name_digestive_system);
	}
	public String getName_funicle() {
		return ((String) getAttrVal("Name_funicle"));
	}	
	public void setName_funicle(String Name_funicle) {
		setAttrVal("Name_funicle", Name_funicle);
	}
	public String getName_peri_umbilicus() {
		return ((String) getAttrVal("Name_peri_umbilicus"));
	}	
	public void setName_peri_umbilicus(String Name_peri_umbilicus) {
		setAttrVal("Name_peri_umbilicus", Name_peri_umbilicus);
	}
	public String getName_psn_sign() {
		return ((String) getAttrVal("Name_psn_sign"));
	}	
	public void setName_psn_sign(String Name_psn_sign) {
		setAttrVal("Name_psn_sign", Name_psn_sign);
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
		return "Id_baby";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_BABYASS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BabyAssDODesc.class);
	}
	
}