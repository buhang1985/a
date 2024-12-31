package iih.nmr.nm.bch.patcarerecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.patcarerecord.d.desc.PatCareRecordDODesc;
import java.math.BigDecimal;

/**
 * 一般患者护理记录单_患者信息 DO数据 
 * 
 */
public class PatCareRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATCARE= "Id_patcare";
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
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String DT_DATETIME= "Dt_datetime";
	public static final String NV_T= "Nv_t";
	public static final String INT_PULSE= "Int_pulse";
	public static final String INT_BREATHING= "Int_breathing";
	public static final String INT_SBP= "Int_sbp";
	public static final String INT_DBP= "Int_dbp";
	public static final String ID_MIND= "Id_mind";
	public static final String SD_MIND= "Sd_mind";
	public static final String NV_SAO2= "Nv_sao2";
	public static final String FG_DAP= "Fg_dap";
	public static final String ID_DIET= "Id_diet";
	public static final String SD_DIET= "Sd_diet";
	public static final String ID_DIET_GUIDANCE= "Id_diet_guidance";
	public static final String SD_DIET_GUIDANCE= "Sd_diet_guidance";
	public static final String FG_MOUTH_CARE= "Fg_mouth_care";
	public static final String ID_PIPE_WAY= "Id_pipe_way";
	public static final String SD_PIPE_WAY= "Sd_pipe_way";
	public static final String FG_INPUT_ATOMIZA= "Fg_input_atomiza";
	public static final String FG_BLADDER_WASH= "Fg_bladder_wash";
	public static final String FG_PERINEAL_WASH= "Fg_perineal_wash";
	public static final String FG_SUCK= "Fg_suck";
	public static final String FG_OXYGEN_BREATH= "Fg_oxygen_breath";
	public static final String FG_NASAL_FEED= "Fg_nasal_feed";
	public static final String ID_PIPES= "Id_pipes";
	public static final String SD_PIPES= "Sd_pipes";
	public static final String FG_PIPE_CARE= "Fg_pipe_care";
	public static final String ID_POSITION_CARE= "Id_position_care";
	public static final String SD_POSITION_CARE= "Sd_position_care";
	public static final String FG_SKIN_CARE= "Fg_skin_care";
	public static final String FG_NUTRITION_CARE= "Fg_nutrition_care";
	public static final String ID_CONDITION_VISIT= "Id_condition_visit";
	public static final String SD_CONDITION_VISIT= "Sd_condition_visit";
	public static final String ID_TUBE_CARE= "Id_tube_care";
	public static final String SD_TUBE_CARE= "Sd_tube_care";
	public static final String ID_CARE_TYPE= "Id_care_type";
	public static final String SD_CARE_TYPE= "Sd_care_type";
	public static final String ID_TRACHEAL_CARE= "Id_tracheal_care";
	public static final String SD_TRACHEAL_CARE= "Sd_tracheal_care";
	public static final String ID_PSYCHO_CARE= "Id_psycho_care";
	public static final String SD_PSYCHO_CARE= "Sd_psycho_care";
	public static final String ID_SAFE_CARE= "Id_safe_care";
	public static final String SD_SAFE_CARE= "Sd_safe_care";
	public static final String ID_NURSING_ISOLATION= "Id_nursing_isolation";
	public static final String SD_NURSING_ISOLATION= "Sd_nursing_isolation";
	public static final String NAME_OCNM= "Name_ocnm";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MIND= "Name_mind";
	public static final String NAME_DIET= "Name_diet";
	public static final String NAME_DIET_GUIDANCE= "Name_diet_guidance";
	public static final String NAME_PIPE_WAY= "Name_pipe_way";
	public static final String NAME_PIPES= "Name_pipes";
	public static final String NAME_POSITION_CARE= "Name_position_care";
	public static final String NAME_CONDITION_VISIT= "Name_condition_visit";
	public static final String NAME_TUBE_CARE= "Name_tube_care";
	public static final String NAME_CARE_TYPE= "Name_care_type";
	public static final String NAME_TRACHEAL_CARE= "Name_tracheal_care";
	public static final String NAME_PSYCHO_CARE= "Name_psycho_care";
	public static final String NAME_SAFE_CARE= "Name_safe_care";
	public static final String NAME_NURSING_ISOLATION= "Name_nursing_isolation";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patcare() {
		return ((String) getAttrVal("Id_patcare"));
	}	
	public void setId_patcare(String Id_patcare) {
		setAttrVal("Id_patcare", Id_patcare);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public FDateTime getDt_datetime() {
		return ((FDateTime) getAttrVal("Dt_datetime"));
	}	
	public void setDt_datetime(FDateTime Dt_datetime) {
		setAttrVal("Dt_datetime", Dt_datetime);
	}
	public FDouble getNv_t() {
		return ((FDouble) getAttrVal("Nv_t"));
	}	
	public void setNv_t(FDouble Nv_t) {
		setAttrVal("Nv_t", Nv_t);
	}
	public Integer getInt_pulse() {
		return ((Integer) getAttrVal("Int_pulse"));
	}	
	public void setInt_pulse(Integer Int_pulse) {
		setAttrVal("Int_pulse", Int_pulse);
	}
	public Integer getInt_breathing() {
		return ((Integer) getAttrVal("Int_breathing"));
	}	
	public void setInt_breathing(Integer Int_breathing) {
		setAttrVal("Int_breathing", Int_breathing);
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
	public String getId_mind() {
		return ((String) getAttrVal("Id_mind"));
	}	
	public void setId_mind(String Id_mind) {
		setAttrVal("Id_mind", Id_mind);
	}
	public String getSd_mind() {
		return ((String) getAttrVal("Sd_mind"));
	}	
	public void setSd_mind(String Sd_mind) {
		setAttrVal("Sd_mind", Sd_mind);
	}
	public FDouble getNv_sao2() {
		return ((FDouble) getAttrVal("Nv_sao2"));
	}	
	public void setNv_sao2(FDouble Nv_sao2) {
		setAttrVal("Nv_sao2", Nv_sao2);
	}
	public FBoolean getFg_dap() {
		return ((FBoolean) getAttrVal("Fg_dap"));
	}	
	public void setFg_dap(FBoolean Fg_dap) {
		setAttrVal("Fg_dap", Fg_dap);
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
	public String getId_diet_guidance() {
		return ((String) getAttrVal("Id_diet_guidance"));
	}	
	public void setId_diet_guidance(String Id_diet_guidance) {
		setAttrVal("Id_diet_guidance", Id_diet_guidance);
	}
	public String getSd_diet_guidance() {
		return ((String) getAttrVal("Sd_diet_guidance"));
	}	
	public void setSd_diet_guidance(String Sd_diet_guidance) {
		setAttrVal("Sd_diet_guidance", Sd_diet_guidance);
	}
	public FBoolean getFg_mouth_care() {
		return ((FBoolean) getAttrVal("Fg_mouth_care"));
	}	
	public void setFg_mouth_care(FBoolean Fg_mouth_care) {
		setAttrVal("Fg_mouth_care", Fg_mouth_care);
	}
	public String getId_pipe_way() {
		return ((String) getAttrVal("Id_pipe_way"));
	}	
	public void setId_pipe_way(String Id_pipe_way) {
		setAttrVal("Id_pipe_way", Id_pipe_way);
	}
	public String getSd_pipe_way() {
		return ((String) getAttrVal("Sd_pipe_way"));
	}	
	public void setSd_pipe_way(String Sd_pipe_way) {
		setAttrVal("Sd_pipe_way", Sd_pipe_way);
	}
	public FBoolean getFg_input_atomiza() {
		return ((FBoolean) getAttrVal("Fg_input_atomiza"));
	}	
	public void setFg_input_atomiza(FBoolean Fg_input_atomiza) {
		setAttrVal("Fg_input_atomiza", Fg_input_atomiza);
	}
	public FBoolean getFg_bladder_wash() {
		return ((FBoolean) getAttrVal("Fg_bladder_wash"));
	}	
	public void setFg_bladder_wash(FBoolean Fg_bladder_wash) {
		setAttrVal("Fg_bladder_wash", Fg_bladder_wash);
	}
	public FBoolean getFg_perineal_wash() {
		return ((FBoolean) getAttrVal("Fg_perineal_wash"));
	}	
	public void setFg_perineal_wash(FBoolean Fg_perineal_wash) {
		setAttrVal("Fg_perineal_wash", Fg_perineal_wash);
	}
	public FBoolean getFg_suck() {
		return ((FBoolean) getAttrVal("Fg_suck"));
	}	
	public void setFg_suck(FBoolean Fg_suck) {
		setAttrVal("Fg_suck", Fg_suck);
	}
	public FBoolean getFg_oxygen_breath() {
		return ((FBoolean) getAttrVal("Fg_oxygen_breath"));
	}	
	public void setFg_oxygen_breath(FBoolean Fg_oxygen_breath) {
		setAttrVal("Fg_oxygen_breath", Fg_oxygen_breath);
	}
	public FBoolean getFg_nasal_feed() {
		return ((FBoolean) getAttrVal("Fg_nasal_feed"));
	}	
	public void setFg_nasal_feed(FBoolean Fg_nasal_feed) {
		setAttrVal("Fg_nasal_feed", Fg_nasal_feed);
	}
	public String getId_pipes() {
		return ((String) getAttrVal("Id_pipes"));
	}	
	public void setId_pipes(String Id_pipes) {
		setAttrVal("Id_pipes", Id_pipes);
	}
	public String getSd_pipes() {
		return ((String) getAttrVal("Sd_pipes"));
	}	
	public void setSd_pipes(String Sd_pipes) {
		setAttrVal("Sd_pipes", Sd_pipes);
	}
	public FBoolean getFg_pipe_care() {
		return ((FBoolean) getAttrVal("Fg_pipe_care"));
	}	
	public void setFg_pipe_care(FBoolean Fg_pipe_care) {
		setAttrVal("Fg_pipe_care", Fg_pipe_care);
	}
	public String getId_position_care() {
		return ((String) getAttrVal("Id_position_care"));
	}	
	public void setId_position_care(String Id_position_care) {
		setAttrVal("Id_position_care", Id_position_care);
	}
	public String getSd_position_care() {
		return ((String) getAttrVal("Sd_position_care"));
	}	
	public void setSd_position_care(String Sd_position_care) {
		setAttrVal("Sd_position_care", Sd_position_care);
	}
	public FBoolean getFg_skin_care() {
		return ((FBoolean) getAttrVal("Fg_skin_care"));
	}	
	public void setFg_skin_care(FBoolean Fg_skin_care) {
		setAttrVal("Fg_skin_care", Fg_skin_care);
	}
	public FBoolean getFg_nutrition_care() {
		return ((FBoolean) getAttrVal("Fg_nutrition_care"));
	}	
	public void setFg_nutrition_care(FBoolean Fg_nutrition_care) {
		setAttrVal("Fg_nutrition_care", Fg_nutrition_care);
	}
	public String getId_condition_visit() {
		return ((String) getAttrVal("Id_condition_visit"));
	}	
	public void setId_condition_visit(String Id_condition_visit) {
		setAttrVal("Id_condition_visit", Id_condition_visit);
	}
	public String getSd_condition_visit() {
		return ((String) getAttrVal("Sd_condition_visit"));
	}	
	public void setSd_condition_visit(String Sd_condition_visit) {
		setAttrVal("Sd_condition_visit", Sd_condition_visit);
	}
	public String getId_tube_care() {
		return ((String) getAttrVal("Id_tube_care"));
	}	
	public void setId_tube_care(String Id_tube_care) {
		setAttrVal("Id_tube_care", Id_tube_care);
	}
	public String getSd_tube_care() {
		return ((String) getAttrVal("Sd_tube_care"));
	}	
	public void setSd_tube_care(String Sd_tube_care) {
		setAttrVal("Sd_tube_care", Sd_tube_care);
	}
	public String getId_care_type() {
		return ((String) getAttrVal("Id_care_type"));
	}	
	public void setId_care_type(String Id_care_type) {
		setAttrVal("Id_care_type", Id_care_type);
	}
	public String getSd_care_type() {
		return ((String) getAttrVal("Sd_care_type"));
	}	
	public void setSd_care_type(String Sd_care_type) {
		setAttrVal("Sd_care_type", Sd_care_type);
	}
	public String getId_tracheal_care() {
		return ((String) getAttrVal("Id_tracheal_care"));
	}	
	public void setId_tracheal_care(String Id_tracheal_care) {
		setAttrVal("Id_tracheal_care", Id_tracheal_care);
	}
	public String getSd_tracheal_care() {
		return ((String) getAttrVal("Sd_tracheal_care"));
	}	
	public void setSd_tracheal_care(String Sd_tracheal_care) {
		setAttrVal("Sd_tracheal_care", Sd_tracheal_care);
	}
	public String getId_psycho_care() {
		return ((String) getAttrVal("Id_psycho_care"));
	}	
	public void setId_psycho_care(String Id_psycho_care) {
		setAttrVal("Id_psycho_care", Id_psycho_care);
	}
	public String getSd_psycho_care() {
		return ((String) getAttrVal("Sd_psycho_care"));
	}	
	public void setSd_psycho_care(String Sd_psycho_care) {
		setAttrVal("Sd_psycho_care", Sd_psycho_care);
	}
	public String getId_safe_care() {
		return ((String) getAttrVal("Id_safe_care"));
	}	
	public void setId_safe_care(String Id_safe_care) {
		setAttrVal("Id_safe_care", Id_safe_care);
	}
	public String getSd_safe_care() {
		return ((String) getAttrVal("Sd_safe_care"));
	}	
	public void setSd_safe_care(String Sd_safe_care) {
		setAttrVal("Sd_safe_care", Sd_safe_care);
	}
	public String getId_nursing_isolation() {
		return ((String) getAttrVal("Id_nursing_isolation"));
	}	
	public void setId_nursing_isolation(String Id_nursing_isolation) {
		setAttrVal("Id_nursing_isolation", Id_nursing_isolation);
	}
	public String getSd_nursing_isolation() {
		return ((String) getAttrVal("Sd_nursing_isolation"));
	}	
	public void setSd_nursing_isolation(String Sd_nursing_isolation) {
		setAttrVal("Sd_nursing_isolation", Sd_nursing_isolation);
	}
	public String getName_ocnm() {
		return ((String) getAttrVal("Name_ocnm"));
	}	
	public void setName_ocnm(String Name_ocnm) {
		setAttrVal("Name_ocnm", Name_ocnm);
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
	public String getName_mind() {
		return ((String) getAttrVal("Name_mind"));
	}	
	public void setName_mind(String Name_mind) {
		setAttrVal("Name_mind", Name_mind);
	}
	public String getName_diet() {
		return ((String) getAttrVal("Name_diet"));
	}	
	public void setName_diet(String Name_diet) {
		setAttrVal("Name_diet", Name_diet);
	}
	public String getName_diet_guidance() {
		return ((String) getAttrVal("Name_diet_guidance"));
	}	
	public void setName_diet_guidance(String Name_diet_guidance) {
		setAttrVal("Name_diet_guidance", Name_diet_guidance);
	}
	public String getName_pipe_way() {
		return ((String) getAttrVal("Name_pipe_way"));
	}	
	public void setName_pipe_way(String Name_pipe_way) {
		setAttrVal("Name_pipe_way", Name_pipe_way);
	}
	public String getName_pipes() {
		return ((String) getAttrVal("Name_pipes"));
	}	
	public void setName_pipes(String Name_pipes) {
		setAttrVal("Name_pipes", Name_pipes);
	}
	public String getName_position_care() {
		return ((String) getAttrVal("Name_position_care"));
	}	
	public void setName_position_care(String Name_position_care) {
		setAttrVal("Name_position_care", Name_position_care);
	}
	public String getName_condition_visit() {
		return ((String) getAttrVal("Name_condition_visit"));
	}	
	public void setName_condition_visit(String Name_condition_visit) {
		setAttrVal("Name_condition_visit", Name_condition_visit);
	}
	public String getName_tube_care() {
		return ((String) getAttrVal("Name_tube_care"));
	}	
	public void setName_tube_care(String Name_tube_care) {
		setAttrVal("Name_tube_care", Name_tube_care);
	}
	public String getName_care_type() {
		return ((String) getAttrVal("Name_care_type"));
	}	
	public void setName_care_type(String Name_care_type) {
		setAttrVal("Name_care_type", Name_care_type);
	}
	public String getName_tracheal_care() {
		return ((String) getAttrVal("Name_tracheal_care"));
	}	
	public void setName_tracheal_care(String Name_tracheal_care) {
		setAttrVal("Name_tracheal_care", Name_tracheal_care);
	}
	public String getName_psycho_care() {
		return ((String) getAttrVal("Name_psycho_care"));
	}	
	public void setName_psycho_care(String Name_psycho_care) {
		setAttrVal("Name_psycho_care", Name_psycho_care);
	}
	public String getName_safe_care() {
		return ((String) getAttrVal("Name_safe_care"));
	}	
	public void setName_safe_care(String Name_safe_care) {
		setAttrVal("Name_safe_care", Name_safe_care);
	}
	public String getName_nursing_isolation() {
		return ((String) getAttrVal("Name_nursing_isolation"));
	}	
	public void setName_nursing_isolation(String Name_nursing_isolation) {
		setAttrVal("Name_nursing_isolation", Name_nursing_isolation);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_patcare";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BCH_PATCARE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatCareRecordDODesc.class);
	}
	
}