package iih.nmr.nm.bch.fallbedasse.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.fallbedasse.d.desc.BchFallAssDODesc;
import java.math.BigDecimal;

/**
 * 住院患者跌倒（坠床）风险评估表 DO数据 
 * 
 */
public class BchFallAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_FBA= "Id_fba";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String NAME_SEX= "Name_sex";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String DT_DISCHARGE= "Dt_discharge";
	public static final String SC_AGE= "Sc_age";
	public static final String SC_ENUM_FALL= "Sc_enum_fall";
	public static final String SC_KNOW_STATUS= "Sc_know_status";
	public static final String SC_FEEL_OPTION= "Sc_feel_option";
	public static final String SC_ENGINERY= "Sc_enginery";
	public static final String SC_TREAD= "Sc_tread";
	public static final String SC_SELF_CATER= "Sc_self_cater";
	public static final String SC_EXCRET= "Sc_excret";
	public static final String SC_DRUGS_USE= "Sc_drugs_use";
	public static final String SC_SPEL_TREAM= "Sc_spel_tream";
	public static final String SC_ENVI= "Sc_envi";
	public static final String CTRL1= "Ctrl1";
	public static final String CTRL2= "Ctrl2";
	public static final String CTRL3= "Ctrl3";
	public static final String CTRL4= "Ctrl4";
	public static final String CTRL5= "Ctrl5";
	public static final String PREVENT_EFFECT= "Prevent_effect";
	public static final String ID_NURS_MEAS= "Id_nurs_meas";
	public static final String SD_NURS_MEAS= "Sd_nurs_meas";
	public static final String SCORE_CREATE= "Score_create";
	public static final String TOTALSCORE= "Totalscore";
	public static final String DT_DATETIME= "Dt_datetime";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_NUR_DUTY= "Id_nur_duty";
	public static final String ID_LEADER= "Id_leader";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_NURS_MEAS= "Name_nurs_meas";
	public static final String NAME_SIGN= "Name_sign";
	public static final String NAME_NUR_DUTY= "Name_nur_duty";
	public static final String NAME_LEADER= "Name_leader";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_fba() {
		return ((String) getAttrVal("Id_fba"));
	}	
	public void setId_fba(String Id_fba) {
		setAttrVal("Id_fba", Id_fba);
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
	public String getId_diagnosis() {
		return ((String) getAttrVal("Id_diagnosis"));
	}	
	public void setId_diagnosis(String Id_diagnosis) {
		setAttrVal("Id_diagnosis", Id_diagnosis);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	public FDateTime getDt_discharge() {
		return ((FDateTime) getAttrVal("Dt_discharge"));
	}	
	public void setDt_discharge(FDateTime Dt_discharge) {
		setAttrVal("Dt_discharge", Dt_discharge);
	}
	public Integer getSc_age() {
		return ((Integer) getAttrVal("Sc_age"));
	}	
	public void setSc_age(Integer Sc_age) {
		setAttrVal("Sc_age", Sc_age);
	}
	public Integer getSc_enum_fall() {
		return ((Integer) getAttrVal("Sc_enum_fall"));
	}	
	public void setSc_enum_fall(Integer Sc_enum_fall) {
		setAttrVal("Sc_enum_fall", Sc_enum_fall);
	}
	public Integer getSc_know_status() {
		return ((Integer) getAttrVal("Sc_know_status"));
	}	
	public void setSc_know_status(Integer Sc_know_status) {
		setAttrVal("Sc_know_status", Sc_know_status);
	}
	public Integer getSc_feel_option() {
		return ((Integer) getAttrVal("Sc_feel_option"));
	}	
	public void setSc_feel_option(Integer Sc_feel_option) {
		setAttrVal("Sc_feel_option", Sc_feel_option);
	}
	public Integer getSc_enginery() {
		return ((Integer) getAttrVal("Sc_enginery"));
	}	
	public void setSc_enginery(Integer Sc_enginery) {
		setAttrVal("Sc_enginery", Sc_enginery);
	}
	public Integer getSc_tread() {
		return ((Integer) getAttrVal("Sc_tread"));
	}	
	public void setSc_tread(Integer Sc_tread) {
		setAttrVal("Sc_tread", Sc_tread);
	}
	public Integer getSc_self_cater() {
		return ((Integer) getAttrVal("Sc_self_cater"));
	}	
	public void setSc_self_cater(Integer Sc_self_cater) {
		setAttrVal("Sc_self_cater", Sc_self_cater);
	}
	public Integer getSc_excret() {
		return ((Integer) getAttrVal("Sc_excret"));
	}	
	public void setSc_excret(Integer Sc_excret) {
		setAttrVal("Sc_excret", Sc_excret);
	}
	public Integer getSc_drugs_use() {
		return ((Integer) getAttrVal("Sc_drugs_use"));
	}	
	public void setSc_drugs_use(Integer Sc_drugs_use) {
		setAttrVal("Sc_drugs_use", Sc_drugs_use);
	}
	public Integer getSc_spel_tream() {
		return ((Integer) getAttrVal("Sc_spel_tream"));
	}	
	public void setSc_spel_tream(Integer Sc_spel_tream) {
		setAttrVal("Sc_spel_tream", Sc_spel_tream);
	}
	public Integer getSc_envi() {
		return ((Integer) getAttrVal("Sc_envi"));
	}	
	public void setSc_envi(Integer Sc_envi) {
		setAttrVal("Sc_envi", Sc_envi);
	}
	public Integer getCtrl1() {
		return ((Integer) getAttrVal("Ctrl1"));
	}	
	public void setCtrl1(Integer Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	public Integer getCtrl2() {
		return ((Integer) getAttrVal("Ctrl2"));
	}	
	public void setCtrl2(Integer Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	public Integer getCtrl3() {
		return ((Integer) getAttrVal("Ctrl3"));
	}	
	public void setCtrl3(Integer Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	public Integer getCtrl4() {
		return ((Integer) getAttrVal("Ctrl4"));
	}	
	public void setCtrl4(Integer Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
	}
	public Integer getPrevent_effect() {
		return ((Integer) getAttrVal("Prevent_effect"));
	}	
	public void setPrevent_effect(Integer Prevent_effect) {
		setAttrVal("Prevent_effect", Prevent_effect);
	}
	public String getId_nurs_meas() {
		return ((String) getAttrVal("Id_nurs_meas"));
	}	
	public void setId_nurs_meas(String Id_nurs_meas) {
		setAttrVal("Id_nurs_meas", Id_nurs_meas);
	}
	public String getSd_nurs_meas() {
		return ((String) getAttrVal("Sd_nurs_meas"));
	}	
	public void setSd_nurs_meas(String Sd_nurs_meas) {
		setAttrVal("Sd_nurs_meas", Sd_nurs_meas);
	}
	public FDouble getScore_create() {
		return ((FDouble) getAttrVal("Score_create"));
	}	
	public void setScore_create(FDouble Score_create) {
		setAttrVal("Score_create", Score_create);
	}
	public FDouble getTotalscore() {
		return ((FDouble) getAttrVal("Totalscore"));
	}	
	public void setTotalscore(FDouble Totalscore) {
		setAttrVal("Totalscore", Totalscore);
	}
	public FDateTime getDt_datetime() {
		return ((FDateTime) getAttrVal("Dt_datetime"));
	}	
	public void setDt_datetime(FDateTime Dt_datetime) {
		setAttrVal("Dt_datetime", Dt_datetime);
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
	public String getId_nur_duty() {
		return ((String) getAttrVal("Id_nur_duty"));
	}	
	public void setId_nur_duty(String Id_nur_duty) {
		setAttrVal("Id_nur_duty", Id_nur_duty);
	}
	public String getId_leader() {
		return ((String) getAttrVal("Id_leader"));
	}	
	public void setId_leader(String Id_leader) {
		setAttrVal("Id_leader", Id_leader);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_nurs_meas() {
		return ((String) getAttrVal("Name_nurs_meas"));
	}	
	public void setName_nurs_meas(String Name_nurs_meas) {
		setAttrVal("Name_nurs_meas", Name_nurs_meas);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	public String getName_nur_duty() {
		return ((String) getAttrVal("Name_nur_duty"));
	}	
	public void setName_nur_duty(String Name_nur_duty) {
		setAttrVal("Name_nur_duty", Name_nur_duty);
	}
	public String getName_leader() {
		return ((String) getAttrVal("Name_leader"));
	}	
	public void setName_leader(String Name_leader) {
		setAttrVal("Name_leader", Name_leader);
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
		return "Id_fba";
	}
	
	@Override
	public String getTableName() {	  
		return "nrm_nm_bch_fallass";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BchFallAssDODesc.class);
	}
	
}