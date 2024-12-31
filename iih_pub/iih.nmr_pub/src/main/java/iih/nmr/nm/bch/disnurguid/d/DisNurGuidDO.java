package iih.nmr.nm.bch.disnurguid.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.disnurguid.d.desc.DisNurGuidDODesc;
import java.math.BigDecimal;

/**
 * 出院护理指导记录单 DO数据 
 * 
 */
public class DisNurGuidDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DNG= "Id_dng";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String AGE= "Age";
	public static final String NAME_SEX= "Name_sex";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_NUR_DUTY= "Id_nur_duty";
	public static final String SD_NUR_DUTY= "Sd_nur_duty";
	public static final String DIS_STIATION= "Dis_stiation";
	public static final String LIVE_GUID_OTH= "Live_guid_oth";
	public static final String DIET_COND_OTH= "Diet_cond_oth";
	public static final String FUNC_EXE_OTH= "Func_exe_oth";
	public static final String EDU_CON= "Edu_con";
	public static final String RE_CONS_GUID= "Re_cons_guid";
	public static final String DT_DISCHARGE= "Dt_discharge";
	public static final String ID_DIS_WAY= "Id_dis_way";
	public static final String SD_DIS_WAY= "Sd_dis_way";
	public static final String ID_FOOD_GUID= "Id_food_guid";
	public static final String SD_FOOD_GUID= "Sd_food_guid";
	public static final String ID_LIVE_GUID= "Id_live_guid";
	public static final String SD_LIVE_GUID= "Sd_live_guid";
	public static final String ID_DIET_COND= "Id_diet_cond";
	public static final String SD_DIET_COND= "Sd_diet_cond";
	public static final String ID_FUNC_EXE= "Id_func_exe";
	public static final String SD_FUNC_EXE= "Sd_func_exe";
	public static final String ID_MED_GUID= "Id_med_guid";
	public static final String SD_MED_GUID= "Sd_med_guid";
	public static final String ID_CARE_ABI= "Id_care_abi";
	public static final String SD_CARE_ABI= "Sd_care_abi";
	public static final String ID_DIET= "Id_diet";
	public static final String SD_DIET= "Sd_diet";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR_DUTY= "Name_nur_duty";
	public static final String NAME_DIS_WAY= "Name_dis_way";
	public static final String NAME_FOOD_GUID= "Name_food_guid";
	public static final String NAME_LIVE_GUID= "Name_live_guid";
	public static final String NAME_DIET_COND= "Name_diet_cond";
	public static final String NAME_FUNC_EXE= "Name_func_exe";
	public static final String NAME_MED_GUID= "Name_med_guid";
	public static final String NAME_CARE_ABI= "Name_care_abi";
	public static final String NAME_DIET= "Name_diet";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dng() {
		return ((String) getAttrVal("Id_dng"));
	}	
	public void setId_dng(String Id_dng) {
		setAttrVal("Id_dng", Id_dng);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
	public String getId_nur_duty() {
		return ((String) getAttrVal("Id_nur_duty"));
	}	
	public void setId_nur_duty(String Id_nur_duty) {
		setAttrVal("Id_nur_duty", Id_nur_duty);
	}
	public String getSd_nur_duty() {
		return ((String) getAttrVal("Sd_nur_duty"));
	}	
	public void setSd_nur_duty(String Sd_nur_duty) {
		setAttrVal("Sd_nur_duty", Sd_nur_duty);
	}
	public String getDis_stiation() {
		return ((String) getAttrVal("Dis_stiation"));
	}	
	public void setDis_stiation(String Dis_stiation) {
		setAttrVal("Dis_stiation", Dis_stiation);
	}
	public String getLive_guid_oth() {
		return ((String) getAttrVal("Live_guid_oth"));
	}	
	public void setLive_guid_oth(String Live_guid_oth) {
		setAttrVal("Live_guid_oth", Live_guid_oth);
	}
	public String getDiet_cond_oth() {
		return ((String) getAttrVal("Diet_cond_oth"));
	}	
	public void setDiet_cond_oth(String Diet_cond_oth) {
		setAttrVal("Diet_cond_oth", Diet_cond_oth);
	}
	public String getFunc_exe_oth() {
		return ((String) getAttrVal("Func_exe_oth"));
	}	
	public void setFunc_exe_oth(String Func_exe_oth) {
		setAttrVal("Func_exe_oth", Func_exe_oth);
	}
	public String getEdu_con() {
		return ((String) getAttrVal("Edu_con"));
	}	
	public void setEdu_con(String Edu_con) {
		setAttrVal("Edu_con", Edu_con);
	}
	public String getRe_cons_guid() {
		return ((String) getAttrVal("Re_cons_guid"));
	}	
	public void setRe_cons_guid(String Re_cons_guid) {
		setAttrVal("Re_cons_guid", Re_cons_guid);
	}
	public FDateTime getDt_discharge() {
		return ((FDateTime) getAttrVal("Dt_discharge"));
	}	
	public void setDt_discharge(FDateTime Dt_discharge) {
		setAttrVal("Dt_discharge", Dt_discharge);
	}
	public String getId_dis_way() {
		return ((String) getAttrVal("Id_dis_way"));
	}	
	public void setId_dis_way(String Id_dis_way) {
		setAttrVal("Id_dis_way", Id_dis_way);
	}
	public String getSd_dis_way() {
		return ((String) getAttrVal("Sd_dis_way"));
	}	
	public void setSd_dis_way(String Sd_dis_way) {
		setAttrVal("Sd_dis_way", Sd_dis_way);
	}
	public String getId_food_guid() {
		return ((String) getAttrVal("Id_food_guid"));
	}	
	public void setId_food_guid(String Id_food_guid) {
		setAttrVal("Id_food_guid", Id_food_guid);
	}
	public String getSd_food_guid() {
		return ((String) getAttrVal("Sd_food_guid"));
	}	
	public void setSd_food_guid(String Sd_food_guid) {
		setAttrVal("Sd_food_guid", Sd_food_guid);
	}
	public String getId_live_guid() {
		return ((String) getAttrVal("Id_live_guid"));
	}	
	public void setId_live_guid(String Id_live_guid) {
		setAttrVal("Id_live_guid", Id_live_guid);
	}
	public String getSd_live_guid() {
		return ((String) getAttrVal("Sd_live_guid"));
	}	
	public void setSd_live_guid(String Sd_live_guid) {
		setAttrVal("Sd_live_guid", Sd_live_guid);
	}
	public String getId_diet_cond() {
		return ((String) getAttrVal("Id_diet_cond"));
	}	
	public void setId_diet_cond(String Id_diet_cond) {
		setAttrVal("Id_diet_cond", Id_diet_cond);
	}
	public String getSd_diet_cond() {
		return ((String) getAttrVal("Sd_diet_cond"));
	}	
	public void setSd_diet_cond(String Sd_diet_cond) {
		setAttrVal("Sd_diet_cond", Sd_diet_cond);
	}
	public String getId_func_exe() {
		return ((String) getAttrVal("Id_func_exe"));
	}	
	public void setId_func_exe(String Id_func_exe) {
		setAttrVal("Id_func_exe", Id_func_exe);
	}
	public String getSd_func_exe() {
		return ((String) getAttrVal("Sd_func_exe"));
	}	
	public void setSd_func_exe(String Sd_func_exe) {
		setAttrVal("Sd_func_exe", Sd_func_exe);
	}
	public String getId_med_guid() {
		return ((String) getAttrVal("Id_med_guid"));
	}	
	public void setId_med_guid(String Id_med_guid) {
		setAttrVal("Id_med_guid", Id_med_guid);
	}
	public String getSd_med_guid() {
		return ((String) getAttrVal("Sd_med_guid"));
	}	
	public void setSd_med_guid(String Sd_med_guid) {
		setAttrVal("Sd_med_guid", Sd_med_guid);
	}
	public String getId_care_abi() {
		return ((String) getAttrVal("Id_care_abi"));
	}	
	public void setId_care_abi(String Id_care_abi) {
		setAttrVal("Id_care_abi", Id_care_abi);
	}
	public String getSd_care_abi() {
		return ((String) getAttrVal("Sd_care_abi"));
	}	
	public void setSd_care_abi(String Sd_care_abi) {
		setAttrVal("Sd_care_abi", Sd_care_abi);
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
	public String getName_nur_duty() {
		return ((String) getAttrVal("Name_nur_duty"));
	}	
	public void setName_nur_duty(String Name_nur_duty) {
		setAttrVal("Name_nur_duty", Name_nur_duty);
	}
	public String getName_dis_way() {
		return ((String) getAttrVal("Name_dis_way"));
	}	
	public void setName_dis_way(String Name_dis_way) {
		setAttrVal("Name_dis_way", Name_dis_way);
	}
	public String getName_food_guid() {
		return ((String) getAttrVal("Name_food_guid"));
	}	
	public void setName_food_guid(String Name_food_guid) {
		setAttrVal("Name_food_guid", Name_food_guid);
	}
	public String getName_live_guid() {
		return ((String) getAttrVal("Name_live_guid"));
	}	
	public void setName_live_guid(String Name_live_guid) {
		setAttrVal("Name_live_guid", Name_live_guid);
	}
	public String getName_diet_cond() {
		return ((String) getAttrVal("Name_diet_cond"));
	}	
	public void setName_diet_cond(String Name_diet_cond) {
		setAttrVal("Name_diet_cond", Name_diet_cond);
	}
	public String getName_func_exe() {
		return ((String) getAttrVal("Name_func_exe"));
	}	
	public void setName_func_exe(String Name_func_exe) {
		setAttrVal("Name_func_exe", Name_func_exe);
	}
	public String getName_med_guid() {
		return ((String) getAttrVal("Name_med_guid"));
	}	
	public void setName_med_guid(String Name_med_guid) {
		setAttrVal("Name_med_guid", Name_med_guid);
	}
	public String getName_care_abi() {
		return ((String) getAttrVal("Name_care_abi"));
	}	
	public void setName_care_abi(String Name_care_abi) {
		setAttrVal("Name_care_abi", Name_care_abi);
	}
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
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
		return "Id_dng";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_NM_BCL_DNG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DisNurGuidDODesc.class);
	}
	
}