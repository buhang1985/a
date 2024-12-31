package iih.nmr.pkuf.admnur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.admnur.d.desc.AdmNurDODesc;
import java.math.BigDecimal;

/**
 * 患者入院护理评估单 DO数据 
 * 
 */
public class AdmNurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ADMNUR= "Id_admnur";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String DIAGNOSIS= "Diagnosis";
	public static final String VOCATION= "Vocation";
	public static final String NATION= "Nation";
	public static final String NAME_EDUC= "Name_educ";
	public static final String TEL= "Tel";
	public static final String FAM_TEL= "Fam_tel";
	public static final String ID_MAR_STAT= "Id_mar_stat";
	public static final String SD_MAR_STAT= "Sd_mar_stat";
	public static final String MAR_STAT_OTHER= "Mar_stat_other";
	public static final String ID_CUR_CHILD= "Id_cur_child";
	public static final String SD_CUR_CHILD= "Sd_cur_child";
	public static final String SON_NUM= "Son_num";
	public static final String DAUGHTER_NUM= "Daughter_num";
	public static final String ID_FAITH= "Id_faith";
	public static final String SD_FAITH= "Sd_faith";
	public static final String FAITH_STAT= "Faith_stat";
	public static final String ID_ALLERHIS= "Id_allerhis";
	public static final String SD_ALLERHIS= "Sd_allerhis";
	public static final String FOOD_ALLERHIS= "Food_allerhis";
	public static final String MED_ALLERHIS= "Med_allerhis";
	public static final String OTH_ALLERHIS= "Oth_allerhis";
	public static final String ID_ENTRY_WAY= "Id_entry_way";
	public static final String SD_ENTRY_WAY= "Sd_entry_way";
	public static final String WEIGHT= "Weight";
	public static final String HEIGHT= "Height";
	public static final String NURT= "Nurt";
	public static final String NURP= "Nurp";
	public static final String NURR= "Nurr";
	public static final String NURBP= "Nurbp";
	public static final String INT_SBP= "Int_sbp";
	public static final String INT_DBP= "Int_dbp";
	public static final String ID_AWARENESS= "Id_awareness";
	public static final String SD_AWARENESS= "Sd_awareness";
	public static final String ID_BREATH= "Id_breath";
	public static final String SD_BREATH= "Sd_breath";
	public static final String ID_BITE= "Id_bite";
	public static final String SD_BITE= "Sd_bite";
	public static final String SPE_BITE= "Spe_bite";
	public static final String DIET= "Diet";
	public static final String OUTSIDE_BITE= "Outside_bite";
	public static final String ID_NUTRI_STAT= "Id_nutri_stat";
	public static final String SD_NUTRI_STAT= "Sd_nutri_stat";
	public static final String HABITTIME= "Habittime";
	public static final String ID_SIESTA= "Id_siesta";
	public static final String SD_SIESTA= "Sd_siesta";
	public static final String SIESTATIME= "Siestatime";
	public static final String ID_AUXILIARY= "Id_auxiliary";
	public static final String SD_AUXILIARY= "Sd_auxiliary";
	public static final String MED_AUXI= "Med_auxi";
	public static final String ID_CACATION= "Id_cacation";
	public static final String SD_CACATION= "Sd_cacation";
	public static final String ID_EMICTION= "Id_emiction";
	public static final String SD_EMICTION= "Sd_emiction";
	public static final String ID_DRAINAGE= "Id_drainage";
	public static final String SD_DRAINAGE= "Sd_drainage";
	public static final String DRAINAGE_TYPE= "Drainage_type";
	public static final String DRAIN_SHAPE= "Drain_shape";
	public static final String DRAINAGE_OUT= "Drainage_out";
	public static final String ID_POSITION= "Id_position";
	public static final String SD_POSITION= "Sd_position";
	public static final String ID_EMOTION= "Id_emotion";
	public static final String SD_EMOTION= "Sd_emotion";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String SKIN_UNUSUAL= "Skin_unusual";
	public static final String ID_RISK= "Id_risk";
	public static final String SD_RISK= "Sd_risk";
	public static final String SCORE_RISK= "Score_risk";
	public static final String ID_SELT_CARE= "Id_selt_care";
	public static final String SD_SELT_CARE= "Sd_selt_care";
	public static final String ID_PAIN= "Id_pain";
	public static final String SD_PAIN= "Sd_pain";
	public static final String SCORE_PAIN= "Score_pain";
	public static final String ID_DIS_UNDER= "Id_dis_under";
	public static final String SD_DIS_UNDER= "Sd_dis_under";
	public static final String ID_DIS_FAMIUNDER= "Id_dis_famiunder";
	public static final String SD_DIS_FAMIUNDER= "Sd_dis_famiunder";
	public static final String ID_INFUSION= "Id_infusion";
	public static final String SD_INFUSION= "Sd_infusion";
	public static final String ID_SUPERFICIAL= "Id_superficial";
	public static final String SD_SUPERFICIAL= "Sd_superficial";
	public static final String SUPERFICIAL_SIT= "Superficial_sit";
	public static final String ID_DEEP= "Id_deep";
	public static final String SD_DEEP= "Sd_deep";
	public static final String DEEP_SITU= "Deep_situ";
	public static final String EVALUATE= "Evaluate";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SIGN= "Name_sign";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_MAR_STAT= "Name_mar_stat";
	public static final String NAME_CUR_CHILD= "Name_cur_child";
	public static final String NAME_FAITH= "Name_faith";
	public static final String NAME_ALLERHIS= "Name_allerhis";
	public static final String NAME_ENTRY_WAY= "Name_entry_way";
	public static final String NAME_AWARENESS= "Name_awareness";
	public static final String NAME_BREATH= "Name_breath";
	public static final String NAME_BITE= "Name_bite";
	public static final String NAME_NUTRI_STAT= "Name_nutri_stat";
	public static final String NAME_SIESTA= "Name_siesta";
	public static final String NAME_AUXILIARY= "Name_auxiliary";
	public static final String NAME_CACATION= "Name_cacation";
	public static final String NAME_EMICTION= "Name_emiction";
	public static final String NAME_DRAINAGE= "Name_drainage";
	public static final String NAME_POSITION= "Name_position";
	public static final String NAME_EMOTION= "Name_emotion";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_RISK= "Name_risk";
	public static final String NAME_SELT_CARE= "Name_selt_care";
	public static final String NAME_PAIN= "Name_pain";
	public static final String NAME_DIS_UNDER= "Name_dis_under";
	public static final String NAME_DIS_FAMIUNDER= "Name_dis_famiunder";
	public static final String NAME_INFUSION= "Name_infusion";
	public static final String NAME_SUPERFICIAL= "Name_superficial";
	public static final String NAME_DEEP= "Name_deep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_admnur() {
		return ((String) getAttrVal("Id_admnur"));
	}	
	public void setId_admnur(String Id_admnur) {
		setAttrVal("Id_admnur", Id_admnur);
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
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}	
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
	}
	public String getVocation() {
		return ((String) getAttrVal("Vocation"));
	}	
	public void setVocation(String Vocation) {
		setAttrVal("Vocation", Vocation);
	}
	public String getNation() {
		return ((String) getAttrVal("Nation"));
	}	
	public void setNation(String Nation) {
		setAttrVal("Nation", Nation);
	}
	public String getName_educ() {
		return ((String) getAttrVal("Name_educ"));
	}	
	public void setName_educ(String Name_educ) {
		setAttrVal("Name_educ", Name_educ);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public String getFam_tel() {
		return ((String) getAttrVal("Fam_tel"));
	}	
	public void setFam_tel(String Fam_tel) {
		setAttrVal("Fam_tel", Fam_tel);
	}
	public String getId_mar_stat() {
		return ((String) getAttrVal("Id_mar_stat"));
	}	
	public void setId_mar_stat(String Id_mar_stat) {
		setAttrVal("Id_mar_stat", Id_mar_stat);
	}
	public String getSd_mar_stat() {
		return ((String) getAttrVal("Sd_mar_stat"));
	}	
	public void setSd_mar_stat(String Sd_mar_stat) {
		setAttrVal("Sd_mar_stat", Sd_mar_stat);
	}
	public String getMar_stat_other() {
		return ((String) getAttrVal("Mar_stat_other"));
	}	
	public void setMar_stat_other(String Mar_stat_other) {
		setAttrVal("Mar_stat_other", Mar_stat_other);
	}
	public String getId_cur_child() {
		return ((String) getAttrVal("Id_cur_child"));
	}	
	public void setId_cur_child(String Id_cur_child) {
		setAttrVal("Id_cur_child", Id_cur_child);
	}
	public String getSd_cur_child() {
		return ((String) getAttrVal("Sd_cur_child"));
	}	
	public void setSd_cur_child(String Sd_cur_child) {
		setAttrVal("Sd_cur_child", Sd_cur_child);
	}
	public Integer getSon_num() {
		return ((Integer) getAttrVal("Son_num"));
	}	
	public void setSon_num(Integer Son_num) {
		setAttrVal("Son_num", Son_num);
	}
	public Integer getDaughter_num() {
		return ((Integer) getAttrVal("Daughter_num"));
	}	
	public void setDaughter_num(Integer Daughter_num) {
		setAttrVal("Daughter_num", Daughter_num);
	}
	public String getId_faith() {
		return ((String) getAttrVal("Id_faith"));
	}	
	public void setId_faith(String Id_faith) {
		setAttrVal("Id_faith", Id_faith);
	}
	public String getSd_faith() {
		return ((String) getAttrVal("Sd_faith"));
	}	
	public void setSd_faith(String Sd_faith) {
		setAttrVal("Sd_faith", Sd_faith);
	}
	public String getFaith_stat() {
		return ((String) getAttrVal("Faith_stat"));
	}	
	public void setFaith_stat(String Faith_stat) {
		setAttrVal("Faith_stat", Faith_stat);
	}
	public String getId_allerhis() {
		return ((String) getAttrVal("Id_allerhis"));
	}	
	public void setId_allerhis(String Id_allerhis) {
		setAttrVal("Id_allerhis", Id_allerhis);
	}
	public String getSd_allerhis() {
		return ((String) getAttrVal("Sd_allerhis"));
	}	
	public void setSd_allerhis(String Sd_allerhis) {
		setAttrVal("Sd_allerhis", Sd_allerhis);
	}
	public String getFood_allerhis() {
		return ((String) getAttrVal("Food_allerhis"));
	}	
	public void setFood_allerhis(String Food_allerhis) {
		setAttrVal("Food_allerhis", Food_allerhis);
	}
	public String getMed_allerhis() {
		return ((String) getAttrVal("Med_allerhis"));
	}	
	public void setMed_allerhis(String Med_allerhis) {
		setAttrVal("Med_allerhis", Med_allerhis);
	}
	public String getOth_allerhis() {
		return ((String) getAttrVal("Oth_allerhis"));
	}	
	public void setOth_allerhis(String Oth_allerhis) {
		setAttrVal("Oth_allerhis", Oth_allerhis);
	}
	public String getId_entry_way() {
		return ((String) getAttrVal("Id_entry_way"));
	}	
	public void setId_entry_way(String Id_entry_way) {
		setAttrVal("Id_entry_way", Id_entry_way);
	}
	public String getSd_entry_way() {
		return ((String) getAttrVal("Sd_entry_way"));
	}	
	public void setSd_entry_way(String Sd_entry_way) {
		setAttrVal("Sd_entry_way", Sd_entry_way);
	}
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}	
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	public FDouble getNurt() {
		return ((FDouble) getAttrVal("Nurt"));
	}	
	public void setNurt(FDouble Nurt) {
		setAttrVal("Nurt", Nurt);
	}
	public Integer getNurp() {
		return ((Integer) getAttrVal("Nurp"));
	}	
	public void setNurp(Integer Nurp) {
		setAttrVal("Nurp", Nurp);
	}
	public Integer getNurr() {
		return ((Integer) getAttrVal("Nurr"));
	}	
	public void setNurr(Integer Nurr) {
		setAttrVal("Nurr", Nurr);
	}
	public FDouble getNurbp() {
		return ((FDouble) getAttrVal("Nurbp"));
	}	
	public void setNurbp(FDouble Nurbp) {
		setAttrVal("Nurbp", Nurbp);
	}
	public Integer getInt_sbp() {
		return ((Integer) getAttrVal("Int_sbp"));
	}	
	public void setInt_sbp(Integer Int_sbp) {
		setAttrVal("Int_sbp", Int_sbp);
	}
	public Integer getInt_dbp() {
		return ((Integer) getAttrVal("Int_dbp"));
	}	
	public void setInt_dbp(Integer Int_dbp) {
		setAttrVal("Int_dbp", Int_dbp);
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
	public String getId_bite() {
		return ((String) getAttrVal("Id_bite"));
	}	
	public void setId_bite(String Id_bite) {
		setAttrVal("Id_bite", Id_bite);
	}
	public String getSd_bite() {
		return ((String) getAttrVal("Sd_bite"));
	}	
	public void setSd_bite(String Sd_bite) {
		setAttrVal("Sd_bite", Sd_bite);
	}
	public String getSpe_bite() {
		return ((String) getAttrVal("Spe_bite"));
	}	
	public void setSpe_bite(String Spe_bite) {
		setAttrVal("Spe_bite", Spe_bite);
	}
	public String getDiet() {
		return ((String) getAttrVal("Diet"));
	}	
	public void setDiet(String Diet) {
		setAttrVal("Diet", Diet);
	}
	public String getOutside_bite() {
		return ((String) getAttrVal("Outside_bite"));
	}	
	public void setOutside_bite(String Outside_bite) {
		setAttrVal("Outside_bite", Outside_bite);
	}
	public String getId_nutri_stat() {
		return ((String) getAttrVal("Id_nutri_stat"));
	}	
	public void setId_nutri_stat(String Id_nutri_stat) {
		setAttrVal("Id_nutri_stat", Id_nutri_stat);
	}
	public String getSd_nutri_stat() {
		return ((String) getAttrVal("Sd_nutri_stat"));
	}	
	public void setSd_nutri_stat(String Sd_nutri_stat) {
		setAttrVal("Sd_nutri_stat", Sd_nutri_stat);
	}
	public FDouble getHabittime() {
		return ((FDouble) getAttrVal("Habittime"));
	}	
	public void setHabittime(FDouble Habittime) {
		setAttrVal("Habittime", Habittime);
	}
	public String getId_siesta() {
		return ((String) getAttrVal("Id_siesta"));
	}	
	public void setId_siesta(String Id_siesta) {
		setAttrVal("Id_siesta", Id_siesta);
	}
	public String getSd_siesta() {
		return ((String) getAttrVal("Sd_siesta"));
	}	
	public void setSd_siesta(String Sd_siesta) {
		setAttrVal("Sd_siesta", Sd_siesta);
	}
	public FDouble getSiestatime() {
		return ((FDouble) getAttrVal("Siestatime"));
	}	
	public void setSiestatime(FDouble Siestatime) {
		setAttrVal("Siestatime", Siestatime);
	}
	public String getId_auxiliary() {
		return ((String) getAttrVal("Id_auxiliary"));
	}	
	public void setId_auxiliary(String Id_auxiliary) {
		setAttrVal("Id_auxiliary", Id_auxiliary);
	}
	public String getSd_auxiliary() {
		return ((String) getAttrVal("Sd_auxiliary"));
	}	
	public void setSd_auxiliary(String Sd_auxiliary) {
		setAttrVal("Sd_auxiliary", Sd_auxiliary);
	}
	public String getMed_auxi() {
		return ((String) getAttrVal("Med_auxi"));
	}	
	public void setMed_auxi(String Med_auxi) {
		setAttrVal("Med_auxi", Med_auxi);
	}
	public String getId_cacation() {
		return ((String) getAttrVal("Id_cacation"));
	}	
	public void setId_cacation(String Id_cacation) {
		setAttrVal("Id_cacation", Id_cacation);
	}
	public String getSd_cacation() {
		return ((String) getAttrVal("Sd_cacation"));
	}	
	public void setSd_cacation(String Sd_cacation) {
		setAttrVal("Sd_cacation", Sd_cacation);
	}
	public String getId_emiction() {
		return ((String) getAttrVal("Id_emiction"));
	}	
	public void setId_emiction(String Id_emiction) {
		setAttrVal("Id_emiction", Id_emiction);
	}
	public String getSd_emiction() {
		return ((String) getAttrVal("Sd_emiction"));
	}	
	public void setSd_emiction(String Sd_emiction) {
		setAttrVal("Sd_emiction", Sd_emiction);
	}
	public String getId_drainage() {
		return ((String) getAttrVal("Id_drainage"));
	}	
	public void setId_drainage(String Id_drainage) {
		setAttrVal("Id_drainage", Id_drainage);
	}
	public String getSd_drainage() {
		return ((String) getAttrVal("Sd_drainage"));
	}	
	public void setSd_drainage(String Sd_drainage) {
		setAttrVal("Sd_drainage", Sd_drainage);
	}
	public String getDrainage_type() {
		return ((String) getAttrVal("Drainage_type"));
	}	
	public void setDrainage_type(String Drainage_type) {
		setAttrVal("Drainage_type", Drainage_type);
	}
	public String getDrain_shape() {
		return ((String) getAttrVal("Drain_shape"));
	}	
	public void setDrain_shape(String Drain_shape) {
		setAttrVal("Drain_shape", Drain_shape);
	}
	public FDouble getDrainage_out() {
		return ((FDouble) getAttrVal("Drainage_out"));
	}	
	public void setDrainage_out(FDouble Drainage_out) {
		setAttrVal("Drainage_out", Drainage_out);
	}
	public String getId_position() {
		return ((String) getAttrVal("Id_position"));
	}	
	public void setId_position(String Id_position) {
		setAttrVal("Id_position", Id_position);
	}
	public String getSd_position() {
		return ((String) getAttrVal("Sd_position"));
	}	
	public void setSd_position(String Sd_position) {
		setAttrVal("Sd_position", Sd_position);
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
	public String getSkin_unusual() {
		return ((String) getAttrVal("Skin_unusual"));
	}	
	public void setSkin_unusual(String Skin_unusual) {
		setAttrVal("Skin_unusual", Skin_unusual);
	}
	public String getId_risk() {
		return ((String) getAttrVal("Id_risk"));
	}	
	public void setId_risk(String Id_risk) {
		setAttrVal("Id_risk", Id_risk);
	}
	public String getSd_risk() {
		return ((String) getAttrVal("Sd_risk"));
	}	
	public void setSd_risk(String Sd_risk) {
		setAttrVal("Sd_risk", Sd_risk);
	}
	public Integer getScore_risk() {
		return ((Integer) getAttrVal("Score_risk"));
	}	
	public void setScore_risk(Integer Score_risk) {
		setAttrVal("Score_risk", Score_risk);
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
	public String getId_pain() {
		return ((String) getAttrVal("Id_pain"));
	}	
	public void setId_pain(String Id_pain) {
		setAttrVal("Id_pain", Id_pain);
	}
	public String getSd_pain() {
		return ((String) getAttrVal("Sd_pain"));
	}	
	public void setSd_pain(String Sd_pain) {
		setAttrVal("Sd_pain", Sd_pain);
	}
	public Integer getScore_pain() {
		return ((Integer) getAttrVal("Score_pain"));
	}	
	public void setScore_pain(Integer Score_pain) {
		setAttrVal("Score_pain", Score_pain);
	}
	public String getId_dis_under() {
		return ((String) getAttrVal("Id_dis_under"));
	}	
	public void setId_dis_under(String Id_dis_under) {
		setAttrVal("Id_dis_under", Id_dis_under);
	}
	public String getSd_dis_under() {
		return ((String) getAttrVal("Sd_dis_under"));
	}	
	public void setSd_dis_under(String Sd_dis_under) {
		setAttrVal("Sd_dis_under", Sd_dis_under);
	}
	public String getId_dis_famiunder() {
		return ((String) getAttrVal("Id_dis_famiunder"));
	}	
	public void setId_dis_famiunder(String Id_dis_famiunder) {
		setAttrVal("Id_dis_famiunder", Id_dis_famiunder);
	}
	public String getSd_dis_famiunder() {
		return ((String) getAttrVal("Sd_dis_famiunder"));
	}	
	public void setSd_dis_famiunder(String Sd_dis_famiunder) {
		setAttrVal("Sd_dis_famiunder", Sd_dis_famiunder);
	}
	public String getId_infusion() {
		return ((String) getAttrVal("Id_infusion"));
	}	
	public void setId_infusion(String Id_infusion) {
		setAttrVal("Id_infusion", Id_infusion);
	}
	public String getSd_infusion() {
		return ((String) getAttrVal("Sd_infusion"));
	}	
	public void setSd_infusion(String Sd_infusion) {
		setAttrVal("Sd_infusion", Sd_infusion);
	}
	public String getId_superficial() {
		return ((String) getAttrVal("Id_superficial"));
	}	
	public void setId_superficial(String Id_superficial) {
		setAttrVal("Id_superficial", Id_superficial);
	}
	public String getSd_superficial() {
		return ((String) getAttrVal("Sd_superficial"));
	}	
	public void setSd_superficial(String Sd_superficial) {
		setAttrVal("Sd_superficial", Sd_superficial);
	}
	public String getSuperficial_sit() {
		return ((String) getAttrVal("Superficial_sit"));
	}	
	public void setSuperficial_sit(String Superficial_sit) {
		setAttrVal("Superficial_sit", Superficial_sit);
	}
	public String getId_deep() {
		return ((String) getAttrVal("Id_deep"));
	}	
	public void setId_deep(String Id_deep) {
		setAttrVal("Id_deep", Id_deep);
	}
	public String getSd_deep() {
		return ((String) getAttrVal("Sd_deep"));
	}	
	public void setSd_deep(String Sd_deep) {
		setAttrVal("Sd_deep", Sd_deep);
	}
	public String getDeep_situ() {
		return ((String) getAttrVal("Deep_situ"));
	}	
	public void setDeep_situ(String Deep_situ) {
		setAttrVal("Deep_situ", Deep_situ);
	}
	public String getEvaluate() {
		return ((String) getAttrVal("Evaluate"));
	}	
	public void setEvaluate(String Evaluate) {
		setAttrVal("Evaluate", Evaluate);
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
	public String getName_mar_stat() {
		return ((String) getAttrVal("Name_mar_stat"));
	}	
	public void setName_mar_stat(String Name_mar_stat) {
		setAttrVal("Name_mar_stat", Name_mar_stat);
	}
	public String getName_cur_child() {
		return ((String) getAttrVal("Name_cur_child"));
	}	
	public void setName_cur_child(String Name_cur_child) {
		setAttrVal("Name_cur_child", Name_cur_child);
	}
	public String getName_faith() {
		return ((String) getAttrVal("Name_faith"));
	}	
	public void setName_faith(String Name_faith) {
		setAttrVal("Name_faith", Name_faith);
	}
	public String getName_allerhis() {
		return ((String) getAttrVal("Name_allerhis"));
	}	
	public void setName_allerhis(String Name_allerhis) {
		setAttrVal("Name_allerhis", Name_allerhis);
	}
	public String getName_entry_way() {
		return ((String) getAttrVal("Name_entry_way"));
	}	
	public void setName_entry_way(String Name_entry_way) {
		setAttrVal("Name_entry_way", Name_entry_way);
	}
	public String getName_awareness() {
		return ((String) getAttrVal("Name_awareness"));
	}	
	public void setName_awareness(String Name_awareness) {
		setAttrVal("Name_awareness", Name_awareness);
	}
	public String getName_breath() {
		return ((String) getAttrVal("Name_breath"));
	}	
	public void setName_breath(String Name_breath) {
		setAttrVal("Name_breath", Name_breath);
	}
	public String getName_bite() {
		return ((String) getAttrVal("Name_bite"));
	}	
	public void setName_bite(String Name_bite) {
		setAttrVal("Name_bite", Name_bite);
	}
	public String getName_nutri_stat() {
		return ((String) getAttrVal("Name_nutri_stat"));
	}	
	public void setName_nutri_stat(String Name_nutri_stat) {
		setAttrVal("Name_nutri_stat", Name_nutri_stat);
	}
	public String getName_siesta() {
		return ((String) getAttrVal("Name_siesta"));
	}	
	public void setName_siesta(String Name_siesta) {
		setAttrVal("Name_siesta", Name_siesta);
	}
	public String getName_auxiliary() {
		return ((String) getAttrVal("Name_auxiliary"));
	}	
	public void setName_auxiliary(String Name_auxiliary) {
		setAttrVal("Name_auxiliary", Name_auxiliary);
	}
	public String getName_cacation() {
		return ((String) getAttrVal("Name_cacation"));
	}	
	public void setName_cacation(String Name_cacation) {
		setAttrVal("Name_cacation", Name_cacation);
	}
	public String getName_emiction() {
		return ((String) getAttrVal("Name_emiction"));
	}	
	public void setName_emiction(String Name_emiction) {
		setAttrVal("Name_emiction", Name_emiction);
	}
	public String getName_drainage() {
		return ((String) getAttrVal("Name_drainage"));
	}	
	public void setName_drainage(String Name_drainage) {
		setAttrVal("Name_drainage", Name_drainage);
	}
	public String getName_position() {
		return ((String) getAttrVal("Name_position"));
	}	
	public void setName_position(String Name_position) {
		setAttrVal("Name_position", Name_position);
	}
	public String getName_emotion() {
		return ((String) getAttrVal("Name_emotion"));
	}	
	public void setName_emotion(String Name_emotion) {
		setAttrVal("Name_emotion", Name_emotion);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_risk() {
		return ((String) getAttrVal("Name_risk"));
	}	
	public void setName_risk(String Name_risk) {
		setAttrVal("Name_risk", Name_risk);
	}
	public String getName_selt_care() {
		return ((String) getAttrVal("Name_selt_care"));
	}	
	public void setName_selt_care(String Name_selt_care) {
		setAttrVal("Name_selt_care", Name_selt_care);
	}
	public String getName_pain() {
		return ((String) getAttrVal("Name_pain"));
	}	
	public void setName_pain(String Name_pain) {
		setAttrVal("Name_pain", Name_pain);
	}
	public String getName_dis_under() {
		return ((String) getAttrVal("Name_dis_under"));
	}	
	public void setName_dis_under(String Name_dis_under) {
		setAttrVal("Name_dis_under", Name_dis_under);
	}
	public String getName_dis_famiunder() {
		return ((String) getAttrVal("Name_dis_famiunder"));
	}	
	public void setName_dis_famiunder(String Name_dis_famiunder) {
		setAttrVal("Name_dis_famiunder", Name_dis_famiunder);
	}
	public String getName_infusion() {
		return ((String) getAttrVal("Name_infusion"));
	}	
	public void setName_infusion(String Name_infusion) {
		setAttrVal("Name_infusion", Name_infusion);
	}
	public String getName_superficial() {
		return ((String) getAttrVal("Name_superficial"));
	}	
	public void setName_superficial(String Name_superficial) {
		setAttrVal("Name_superficial", Name_superficial);
	}
	public String getName_deep() {
		return ((String) getAttrVal("Name_deep"));
	}	
	public void setName_deep(String Name_deep) {
		setAttrVal("Name_deep", Name_deep);
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
		return "Id_admnur";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_ADMNUR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AdmNurDODesc.class);
	}
	
}