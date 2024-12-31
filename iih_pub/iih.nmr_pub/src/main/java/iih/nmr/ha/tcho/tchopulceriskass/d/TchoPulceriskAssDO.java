package iih.nmr.ha.tcho.tchopulceriskass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.ha.tcho.tchopulceriskass.d.desc.TchoPulceriskAssDODesc;
import java.math.BigDecimal;

/**
 * 压疮风险评分单DO DO数据 
 * 
 */
public class TchoPulceriskAssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PULCERISKASS= "Id_pulceriskass";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String CHINESE_DIAGNOSE= "Chinese_diagnose";
	public static final String WESTERN_DIAGNOSE= "Western_diagnose";
	public static final String TOTAL_GRADE= "Total_grade";
	public static final String BASIC_SICK= "Basic_sick";
	public static final String OTHERS= "Others";
	public static final String FILL_PEOPLE= "Fill_people";
	public static final String SC_FEEL= "Sc_feel";
	public static final String SC_DAMP= "Sc_damp";
	public static final String SC_ACTIVITY= "Sc_activity";
	public static final String SC_CTRLPOWER= "Sc_ctrlpower";
	public static final String SC_NUTRITION= "Sc_nutrition";
	public static final String SC_FHPOWER= "Sc_fhpower";
	public static final String ID_FEEL= "Id_feel";
	public static final String SD_FEEL= "Sd_feel";
	public static final String ID_DAMP= "Id_damp";
	public static final String SD_DAMP= "Sd_damp";
	public static final String ID_ACTIVITY= "Id_activity";
	public static final String SD_ACTIVITY= "Sd_activity";
	public static final String ID_MOVE= "Id_move";
	public static final String SD_MOVE= "Sd_move";
	public static final String ID_NUTRITION= "Id_nutrition";
	public static final String SD_NUTRITION= "Sd_nutrition";
	public static final String ID_FHPOWER= "Id_fhpower";
	public static final String SD_FHPOWER= "Sd_fhpower";
	public static final String ID_NURSMEASURE= "Id_nursmeasure";
	public static final String SD_NURSMEASURE= "Sd_nursmeasure";
	public static final String ID_PREVENTIVE_EFFECT= "Id_preventive_effect";
	public static final String SD_PREVENTIVE_EFFECT= "Sd_preventive_effect";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String FILL_TIME= "Fill_time";
	public static final String EU_ISHAPPEN= "Eu_ishappen";
	public static final String EU_ISOBEY= "Eu_isobey";
	public static final String ID_ULCERPOSITION= "Id_ulcerposition";
	public static final String SD_ULCERPOSITION= "Sd_ulcerposition";
	public static final String ID_ULCERLEVEL= "Id_ulcerlevel";
	public static final String SD_ULCERLEVEL= "Sd_ulcerlevel";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PEOPLE= "Name_people";
	public static final String NAME_FEEL= "Name_feel";
	public static final String NAME_DAMP= "Name_damp";
	public static final String NAME_ACTIVITY= "Name_activity";
	public static final String NAME_MOVE= "Name_move";
	public static final String NAME_NUTRITION= "Name_nutrition";
	public static final String NAME_FHPOWER= "Name_fhpower";
	public static final String NAME_NURSMEASURE= "Name_nursmeasure";
	public static final String NAME_PREVENTIVE_EFFECT= "Name_preventive_effect";
	public static final String NAME_ULCERPOSITION= "Name_ulcerposition";
	public static final String NAME_ULCERLEVEL= "Name_ulcerlevel";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pulceriskass() {
		return ((String) getAttrVal("Id_pulceriskass"));
	}	
	public void setId_pulceriskass(String Id_pulceriskass) {
		setAttrVal("Id_pulceriskass", Id_pulceriskass);
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
	public String getChinese_diagnose() {
		return ((String) getAttrVal("Chinese_diagnose"));
	}	
	public void setChinese_diagnose(String Chinese_diagnose) {
		setAttrVal("Chinese_diagnose", Chinese_diagnose);
	}
	public String getWestern_diagnose() {
		return ((String) getAttrVal("Western_diagnose"));
	}	
	public void setWestern_diagnose(String Western_diagnose) {
		setAttrVal("Western_diagnose", Western_diagnose);
	}
	public FDouble getTotal_grade() {
		return ((FDouble) getAttrVal("Total_grade"));
	}	
	public void setTotal_grade(FDouble Total_grade) {
		setAttrVal("Total_grade", Total_grade);
	}
	public String getBasic_sick() {
		return ((String) getAttrVal("Basic_sick"));
	}	
	public void setBasic_sick(String Basic_sick) {
		setAttrVal("Basic_sick", Basic_sick);
	}
	public String getOthers() {
		return ((String) getAttrVal("Others"));
	}	
	public void setOthers(String Others) {
		setAttrVal("Others", Others);
	}
	public String getFill_people() {
		return ((String) getAttrVal("Fill_people"));
	}	
	public void setFill_people(String Fill_people) {
		setAttrVal("Fill_people", Fill_people);
	}
	public FDouble getSc_feel() {
		return ((FDouble) getAttrVal("Sc_feel"));
	}	
	public void setSc_feel(FDouble Sc_feel) {
		setAttrVal("Sc_feel", Sc_feel);
	}
	public FDouble getSc_damp() {
		return ((FDouble) getAttrVal("Sc_damp"));
	}	
	public void setSc_damp(FDouble Sc_damp) {
		setAttrVal("Sc_damp", Sc_damp);
	}
	public FDouble getSc_activity() {
		return ((FDouble) getAttrVal("Sc_activity"));
	}	
	public void setSc_activity(FDouble Sc_activity) {
		setAttrVal("Sc_activity", Sc_activity);
	}
	public FDouble getSc_ctrlpower() {
		return ((FDouble) getAttrVal("Sc_ctrlpower"));
	}	
	public void setSc_ctrlpower(FDouble Sc_ctrlpower) {
		setAttrVal("Sc_ctrlpower", Sc_ctrlpower);
	}
	public FDouble getSc_nutrition() {
		return ((FDouble) getAttrVal("Sc_nutrition"));
	}	
	public void setSc_nutrition(FDouble Sc_nutrition) {
		setAttrVal("Sc_nutrition", Sc_nutrition);
	}
	public FDouble getSc_fhpower() {
		return ((FDouble) getAttrVal("Sc_fhpower"));
	}	
	public void setSc_fhpower(FDouble Sc_fhpower) {
		setAttrVal("Sc_fhpower", Sc_fhpower);
	}
	public String getId_feel() {
		return ((String) getAttrVal("Id_feel"));
	}	
	public void setId_feel(String Id_feel) {
		setAttrVal("Id_feel", Id_feel);
	}
	public String getSd_feel() {
		return ((String) getAttrVal("Sd_feel"));
	}	
	public void setSd_feel(String Sd_feel) {
		setAttrVal("Sd_feel", Sd_feel);
	}
	public String getId_damp() {
		return ((String) getAttrVal("Id_damp"));
	}	
	public void setId_damp(String Id_damp) {
		setAttrVal("Id_damp", Id_damp);
	}
	public String getSd_damp() {
		return ((String) getAttrVal("Sd_damp"));
	}	
	public void setSd_damp(String Sd_damp) {
		setAttrVal("Sd_damp", Sd_damp);
	}
	public String getId_activity() {
		return ((String) getAttrVal("Id_activity"));
	}	
	public void setId_activity(String Id_activity) {
		setAttrVal("Id_activity", Id_activity);
	}
	public String getSd_activity() {
		return ((String) getAttrVal("Sd_activity"));
	}	
	public void setSd_activity(String Sd_activity) {
		setAttrVal("Sd_activity", Sd_activity);
	}
	public String getId_move() {
		return ((String) getAttrVal("Id_move"));
	}	
	public void setId_move(String Id_move) {
		setAttrVal("Id_move", Id_move);
	}
	public String getSd_move() {
		return ((String) getAttrVal("Sd_move"));
	}	
	public void setSd_move(String Sd_move) {
		setAttrVal("Sd_move", Sd_move);
	}
	public String getId_nutrition() {
		return ((String) getAttrVal("Id_nutrition"));
	}	
	public void setId_nutrition(String Id_nutrition) {
		setAttrVal("Id_nutrition", Id_nutrition);
	}
	public String getSd_nutrition() {
		return ((String) getAttrVal("Sd_nutrition"));
	}	
	public void setSd_nutrition(String Sd_nutrition) {
		setAttrVal("Sd_nutrition", Sd_nutrition);
	}
	public String getId_fhpower() {
		return ((String) getAttrVal("Id_fhpower"));
	}	
	public void setId_fhpower(String Id_fhpower) {
		setAttrVal("Id_fhpower", Id_fhpower);
	}
	public String getSd_fhpower() {
		return ((String) getAttrVal("Sd_fhpower"));
	}	
	public void setSd_fhpower(String Sd_fhpower) {
		setAttrVal("Sd_fhpower", Sd_fhpower);
	}
	public String getId_nursmeasure() {
		return ((String) getAttrVal("Id_nursmeasure"));
	}	
	public void setId_nursmeasure(String Id_nursmeasure) {
		setAttrVal("Id_nursmeasure", Id_nursmeasure);
	}
	public String getSd_nursmeasure() {
		return ((String) getAttrVal("Sd_nursmeasure"));
	}	
	public void setSd_nursmeasure(String Sd_nursmeasure) {
		setAttrVal("Sd_nursmeasure", Sd_nursmeasure);
	}
	public String getId_preventive_effect() {
		return ((String) getAttrVal("Id_preventive_effect"));
	}	
	public void setId_preventive_effect(String Id_preventive_effect) {
		setAttrVal("Id_preventive_effect", Id_preventive_effect);
	}
	public String getSd_preventive_effect() {
		return ((String) getAttrVal("Sd_preventive_effect"));
	}	
	public void setSd_preventive_effect(String Sd_preventive_effect) {
		setAttrVal("Sd_preventive_effect", Sd_preventive_effect);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public FDateTime getFill_time() {
		return ((FDateTime) getAttrVal("Fill_time"));
	}	
	public void setFill_time(FDateTime Fill_time) {
		setAttrVal("Fill_time", Fill_time);
	}
	public Integer getEu_ishappen() {
		return ((Integer) getAttrVal("Eu_ishappen"));
	}	
	public void setEu_ishappen(Integer Eu_ishappen) {
		setAttrVal("Eu_ishappen", Eu_ishappen);
	}
	public Integer getEu_isobey() {
		return ((Integer) getAttrVal("Eu_isobey"));
	}	
	public void setEu_isobey(Integer Eu_isobey) {
		setAttrVal("Eu_isobey", Eu_isobey);
	}
	public String getId_ulcerposition() {
		return ((String) getAttrVal("Id_ulcerposition"));
	}	
	public void setId_ulcerposition(String Id_ulcerposition) {
		setAttrVal("Id_ulcerposition", Id_ulcerposition);
	}
	public String getSd_ulcerposition() {
		return ((String) getAttrVal("Sd_ulcerposition"));
	}	
	public void setSd_ulcerposition(String Sd_ulcerposition) {
		setAttrVal("Sd_ulcerposition", Sd_ulcerposition);
	}
	public String getId_ulcerlevel() {
		return ((String) getAttrVal("Id_ulcerlevel"));
	}	
	public void setId_ulcerlevel(String Id_ulcerlevel) {
		setAttrVal("Id_ulcerlevel", Id_ulcerlevel);
	}
	public String getSd_ulcerlevel() {
		return ((String) getAttrVal("Sd_ulcerlevel"));
	}	
	public void setSd_ulcerlevel(String Sd_ulcerlevel) {
		setAttrVal("Sd_ulcerlevel", Sd_ulcerlevel);
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
	public String getName_people() {
		return ((String) getAttrVal("Name_people"));
	}	
	public void setName_people(String Name_people) {
		setAttrVal("Name_people", Name_people);
	}
	public String getName_feel() {
		return ((String) getAttrVal("Name_feel"));
	}	
	public void setName_feel(String Name_feel) {
		setAttrVal("Name_feel", Name_feel);
	}
	public String getName_damp() {
		return ((String) getAttrVal("Name_damp"));
	}	
	public void setName_damp(String Name_damp) {
		setAttrVal("Name_damp", Name_damp);
	}
	public String getName_activity() {
		return ((String) getAttrVal("Name_activity"));
	}	
	public void setName_activity(String Name_activity) {
		setAttrVal("Name_activity", Name_activity);
	}
	public String getName_move() {
		return ((String) getAttrVal("Name_move"));
	}	
	public void setName_move(String Name_move) {
		setAttrVal("Name_move", Name_move);
	}
	public String getName_nutrition() {
		return ((String) getAttrVal("Name_nutrition"));
	}	
	public void setName_nutrition(String Name_nutrition) {
		setAttrVal("Name_nutrition", Name_nutrition);
	}
	public String getName_fhpower() {
		return ((String) getAttrVal("Name_fhpower"));
	}	
	public void setName_fhpower(String Name_fhpower) {
		setAttrVal("Name_fhpower", Name_fhpower);
	}
	public String getName_nursmeasure() {
		return ((String) getAttrVal("Name_nursmeasure"));
	}	
	public void setName_nursmeasure(String Name_nursmeasure) {
		setAttrVal("Name_nursmeasure", Name_nursmeasure);
	}
	public String getName_preventive_effect() {
		return ((String) getAttrVal("Name_preventive_effect"));
	}	
	public void setName_preventive_effect(String Name_preventive_effect) {
		setAttrVal("Name_preventive_effect", Name_preventive_effect);
	}
	public String getName_ulcerposition() {
		return ((String) getAttrVal("Name_ulcerposition"));
	}	
	public void setName_ulcerposition(String Name_ulcerposition) {
		setAttrVal("Name_ulcerposition", Name_ulcerposition);
	}
	public String getName_ulcerlevel() {
		return ((String) getAttrVal("Name_ulcerlevel"));
	}	
	public void setName_ulcerlevel(String Name_ulcerlevel) {
		setAttrVal("Name_ulcerlevel", Name_ulcerlevel);
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
		return "Id_pulceriskass";
	}
	
	@Override
	public String getTableName() {	  
		return "nmr_ha_tcho_pulceriskass";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TchoPulceriskAssDODesc.class);
	}
	
}