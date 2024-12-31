package iih.nmr.nm.bch.riskhoato.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.riskhoato.d.desc.RiskhoatoRecordDODesc;
import java.math.BigDecimal;

/**
 * 急危重患者交接记录 DO数据 
 * 
 */
public class RiskhoatoRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RISKHOATO= "Id_riskhoato";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_DATETIME= "Dt_datetime";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_INHOSP_WAY= "Id_inhosp_way";
	public static final String SD_INHOSP_WAY= "Sd_inhosp_way";
	public static final String ID_TRANSIN_WAY= "Id_transin_way";
	public static final String SD_TRANSIN_WAY= "Sd_transin_way";
	public static final String ID_AWARENESS= "Id_awareness";
	public static final String SD_AWARENESS= "Sd_awareness";
	public static final String PRESS= "Press";
	public static final String REFLEX= "Reflex";
	public static final String EMERGENCY_CHECK_OTHER= "Emergency_check_other";
	public static final String FIRST_AID_OTHER= "First_aid_other";
	public static final String PIPELINE_OTHER= "Pipeline_other";
	public static final String ID_EMERGENCY_CHECK= "Id_emergency_check";
	public static final String SD_EMERGENCY_CHECK= "Sd_emergency_check";
	public static final String ID_FIRST_AID= "Id_first_aid";
	public static final String SD_FIRST_AID= "Sd_first_aid";
	public static final String ID_LIEN= "Id_lien";
	public static final String SD_LIEN= "Sd_lien";
	public static final String ID_PIPELINE= "Id_pipeline";
	public static final String SD_PIPELINE= "Sd_pipeline";
	public static final String ID_SKIN_CONDITION= "Id_skin_condition";
	public static final String SD_SKIN_CONDITION= "Sd_skin_condition";
	public static final String ID_SKINYC_CONDITION= "Id_skinyc_condition";
	public static final String SD_SKINYC_CONDITION= "Sd_skinyc_condition";
	public static final String ID_NOTCH= "Id_notch";
	public static final String SD_NOTCH= "Sd_notch";
	public static final String PIPE_OTHER= "Pipe_other";
	public static final String PARTAREA= "Partarea";
	public static final String DRUG= "Drug";
	public static final String OUT_DEP= "Out_dep";
	public static final String IN_DEP= "In_dep";
	public static final String OUT_NUR= "Out_nur";
	public static final String IN_NUR= "In_nur";
	public static final String DROPNUM= "Dropnum";
	public static final String DROP_RATE= "Drop_rate";
	public static final String NV_T= "Nv_t";
	public static final String IN_TIME= "In_time";
	public static final String OUT_TIME= "Out_time";
	public static final String INT_PULSE= "Int_pulse";
	public static final String INT_BREATHING= "Int_breathing";
	public static final String INT_PUPIL_LEFT= "Int_pupil_left";
	public static final String INT_PUPIL_RIGHT= "Int_pupil_right";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_INHOSP_WAY= "Name_inhosp_way";
	public static final String NAME_TRANSIN_WAY= "Name_transin_way";
	public static final String NAME_AWARENESS= "Name_awareness";
	public static final String NAME_EMERGENCY_CHECK= "Name_emergency_check";
	public static final String NAME_FIRST_AID= "Name_first_aid";
	public static final String NAME_LIEN= "Name_lien";
	public static final String NAME_PIPELINE= "Name_pipeline";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_SKINYC_CONDITION= "Name_skinyc_condition";
	public static final String NAME_NOTCH= "Name_notch";
	public static final String NAME_OUT_DEP= "Name_out_dep";
	public static final String NAME_IN_DEP= "Name_in_dep";
	public static final String NAME_OUT_NUR= "Name_out_nur";
	public static final String NAME_IN_NUR= "Name_in_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_riskhoato() {
		return ((String) getAttrVal("Id_riskhoato"));
	}	
	public void setId_riskhoato(String Id_riskhoato) {
		setAttrVal("Id_riskhoato", Id_riskhoato);
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
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	public FDateTime getDt_datetime() {
		return ((FDateTime) getAttrVal("Dt_datetime"));
	}	
	public void setDt_datetime(FDateTime Dt_datetime) {
		setAttrVal("Dt_datetime", Dt_datetime);
	}
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	public String getId_inhosp_way() {
		return ((String) getAttrVal("Id_inhosp_way"));
	}	
	public void setId_inhosp_way(String Id_inhosp_way) {
		setAttrVal("Id_inhosp_way", Id_inhosp_way);
	}
	public String getSd_inhosp_way() {
		return ((String) getAttrVal("Sd_inhosp_way"));
	}	
	public void setSd_inhosp_way(String Sd_inhosp_way) {
		setAttrVal("Sd_inhosp_way", Sd_inhosp_way);
	}
	public String getId_transin_way() {
		return ((String) getAttrVal("Id_transin_way"));
	}	
	public void setId_transin_way(String Id_transin_way) {
		setAttrVal("Id_transin_way", Id_transin_way);
	}
	public String getSd_transin_way() {
		return ((String) getAttrVal("Sd_transin_way"));
	}	
	public void setSd_transin_way(String Sd_transin_way) {
		setAttrVal("Sd_transin_way", Sd_transin_way);
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
	public String getPress() {
		return ((String) getAttrVal("Press"));
	}	
	public void setPress(String Press) {
		setAttrVal("Press", Press);
	}
	public String getReflex() {
		return ((String) getAttrVal("Reflex"));
	}	
	public void setReflex(String Reflex) {
		setAttrVal("Reflex", Reflex);
	}
	public String getEmergency_check_other() {
		return ((String) getAttrVal("Emergency_check_other"));
	}	
	public void setEmergency_check_other(String Emergency_check_other) {
		setAttrVal("Emergency_check_other", Emergency_check_other);
	}
	public String getFirst_aid_other() {
		return ((String) getAttrVal("First_aid_other"));
	}	
	public void setFirst_aid_other(String First_aid_other) {
		setAttrVal("First_aid_other", First_aid_other);
	}
	public String getPipeline_other() {
		return ((String) getAttrVal("Pipeline_other"));
	}	
	public void setPipeline_other(String Pipeline_other) {
		setAttrVal("Pipeline_other", Pipeline_other);
	}
	public String getId_emergency_check() {
		return ((String) getAttrVal("Id_emergency_check"));
	}	
	public void setId_emergency_check(String Id_emergency_check) {
		setAttrVal("Id_emergency_check", Id_emergency_check);
	}
	public String getSd_emergency_check() {
		return ((String) getAttrVal("Sd_emergency_check"));
	}	
	public void setSd_emergency_check(String Sd_emergency_check) {
		setAttrVal("Sd_emergency_check", Sd_emergency_check);
	}
	public String getId_first_aid() {
		return ((String) getAttrVal("Id_first_aid"));
	}	
	public void setId_first_aid(String Id_first_aid) {
		setAttrVal("Id_first_aid", Id_first_aid);
	}
	public String getSd_first_aid() {
		return ((String) getAttrVal("Sd_first_aid"));
	}	
	public void setSd_first_aid(String Sd_first_aid) {
		setAttrVal("Sd_first_aid", Sd_first_aid);
	}
	public String getId_lien() {
		return ((String) getAttrVal("Id_lien"));
	}	
	public void setId_lien(String Id_lien) {
		setAttrVal("Id_lien", Id_lien);
	}
	public String getSd_lien() {
		return ((String) getAttrVal("Sd_lien"));
	}	
	public void setSd_lien(String Sd_lien) {
		setAttrVal("Sd_lien", Sd_lien);
	}
	public String getId_pipeline() {
		return ((String) getAttrVal("Id_pipeline"));
	}	
	public void setId_pipeline(String Id_pipeline) {
		setAttrVal("Id_pipeline", Id_pipeline);
	}
	public String getSd_pipeline() {
		return ((String) getAttrVal("Sd_pipeline"));
	}	
	public void setSd_pipeline(String Sd_pipeline) {
		setAttrVal("Sd_pipeline", Sd_pipeline);
	}
	public String getId_skin_condition() {
		return ((String) getAttrVal("Id_skin_condition"));
	}	
	public void setId_skin_condition(String Id_skin_condition) {
		setAttrVal("Id_skin_condition", Id_skin_condition);
	}
	public String getSd_skin_condition() {
		return ((String) getAttrVal("Sd_skin_condition"));
	}	
	public void setSd_skin_condition(String Sd_skin_condition) {
		setAttrVal("Sd_skin_condition", Sd_skin_condition);
	}
	public String getId_skinyc_condition() {
		return ((String) getAttrVal("Id_skinyc_condition"));
	}	
	public void setId_skinyc_condition(String Id_skinyc_condition) {
		setAttrVal("Id_skinyc_condition", Id_skinyc_condition);
	}
	public String getSd_skinyc_condition() {
		return ((String) getAttrVal("Sd_skinyc_condition"));
	}	
	public void setSd_skinyc_condition(String Sd_skinyc_condition) {
		setAttrVal("Sd_skinyc_condition", Sd_skinyc_condition);
	}
	public String getId_notch() {
		return ((String) getAttrVal("Id_notch"));
	}	
	public void setId_notch(String Id_notch) {
		setAttrVal("Id_notch", Id_notch);
	}
	public String getSd_notch() {
		return ((String) getAttrVal("Sd_notch"));
	}	
	public void setSd_notch(String Sd_notch) {
		setAttrVal("Sd_notch", Sd_notch);
	}
	public String getPipe_other() {
		return ((String) getAttrVal("Pipe_other"));
	}	
	public void setPipe_other(String Pipe_other) {
		setAttrVal("Pipe_other", Pipe_other);
	}
	public String getPartarea() {
		return ((String) getAttrVal("Partarea"));
	}	
	public void setPartarea(String Partarea) {
		setAttrVal("Partarea", Partarea);
	}
	public String getDrug() {
		return ((String) getAttrVal("Drug"));
	}	
	public void setDrug(String Drug) {
		setAttrVal("Drug", Drug);
	}
	public String getOut_dep() {
		return ((String) getAttrVal("Out_dep"));
	}	
	public void setOut_dep(String Out_dep) {
		setAttrVal("Out_dep", Out_dep);
	}
	public String getIn_dep() {
		return ((String) getAttrVal("In_dep"));
	}	
	public void setIn_dep(String In_dep) {
		setAttrVal("In_dep", In_dep);
	}
	public String getOut_nur() {
		return ((String) getAttrVal("Out_nur"));
	}	
	public void setOut_nur(String Out_nur) {
		setAttrVal("Out_nur", Out_nur);
	}
	public String getIn_nur() {
		return ((String) getAttrVal("In_nur"));
	}	
	public void setIn_nur(String In_nur) {
		setAttrVal("In_nur", In_nur);
	}
	public FDouble getDropnum() {
		return ((FDouble) getAttrVal("Dropnum"));
	}	
	public void setDropnum(FDouble Dropnum) {
		setAttrVal("Dropnum", Dropnum);
	}
	public FDouble getDrop_rate() {
		return ((FDouble) getAttrVal("Drop_rate"));
	}	
	public void setDrop_rate(FDouble Drop_rate) {
		setAttrVal("Drop_rate", Drop_rate);
	}
	public FDouble getNv_t() {
		return ((FDouble) getAttrVal("Nv_t"));
	}	
	public void setNv_t(FDouble Nv_t) {
		setAttrVal("Nv_t", Nv_t);
	}
	public FDateTime getIn_time() {
		return ((FDateTime) getAttrVal("In_time"));
	}	
	public void setIn_time(FDateTime In_time) {
		setAttrVal("In_time", In_time);
	}
	public FDateTime getOut_time() {
		return ((FDateTime) getAttrVal("Out_time"));
	}	
	public void setOut_time(FDateTime Out_time) {
		setAttrVal("Out_time", Out_time);
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
	public Integer getInt_pupil_left() {
		return ((Integer) getAttrVal("Int_pupil_left"));
	}	
	public void setInt_pupil_left(Integer Int_pupil_left) {
		setAttrVal("Int_pupil_left", Int_pupil_left);
	}
	public Integer getInt_pupil_right() {
		return ((Integer) getAttrVal("Int_pupil_right"));
	}	
	public void setInt_pupil_right(Integer Int_pupil_right) {
		setAttrVal("Int_pupil_right", Int_pupil_right);
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
	public String getName_inhosp_way() {
		return ((String) getAttrVal("Name_inhosp_way"));
	}	
	public void setName_inhosp_way(String Name_inhosp_way) {
		setAttrVal("Name_inhosp_way", Name_inhosp_way);
	}
	public String getName_transin_way() {
		return ((String) getAttrVal("Name_transin_way"));
	}	
	public void setName_transin_way(String Name_transin_way) {
		setAttrVal("Name_transin_way", Name_transin_way);
	}
	public String getName_awareness() {
		return ((String) getAttrVal("Name_awareness"));
	}	
	public void setName_awareness(String Name_awareness) {
		setAttrVal("Name_awareness", Name_awareness);
	}
	public String getName_emergency_check() {
		return ((String) getAttrVal("Name_emergency_check"));
	}	
	public void setName_emergency_check(String Name_emergency_check) {
		setAttrVal("Name_emergency_check", Name_emergency_check);
	}
	public String getName_first_aid() {
		return ((String) getAttrVal("Name_first_aid"));
	}	
	public void setName_first_aid(String Name_first_aid) {
		setAttrVal("Name_first_aid", Name_first_aid);
	}
	public String getName_lien() {
		return ((String) getAttrVal("Name_lien"));
	}	
	public void setName_lien(String Name_lien) {
		setAttrVal("Name_lien", Name_lien);
	}
	public String getName_pipeline() {
		return ((String) getAttrVal("Name_pipeline"));
	}	
	public void setName_pipeline(String Name_pipeline) {
		setAttrVal("Name_pipeline", Name_pipeline);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_skinyc_condition() {
		return ((String) getAttrVal("Name_skinyc_condition"));
	}	
	public void setName_skinyc_condition(String Name_skinyc_condition) {
		setAttrVal("Name_skinyc_condition", Name_skinyc_condition);
	}
	public String getName_notch() {
		return ((String) getAttrVal("Name_notch"));
	}	
	public void setName_notch(String Name_notch) {
		setAttrVal("Name_notch", Name_notch);
	}
	public String getName_out_dep() {
		return ((String) getAttrVal("Name_out_dep"));
	}	
	public void setName_out_dep(String Name_out_dep) {
		setAttrVal("Name_out_dep", Name_out_dep);
	}
	public String getName_in_dep() {
		return ((String) getAttrVal("Name_in_dep"));
	}	
	public void setName_in_dep(String Name_in_dep) {
		setAttrVal("Name_in_dep", Name_in_dep);
	}
	public String getName_out_nur() {
		return ((String) getAttrVal("Name_out_nur"));
	}	
	public void setName_out_nur(String Name_out_nur) {
		setAttrVal("Name_out_nur", Name_out_nur);
	}
	public String getName_in_nur() {
		return ((String) getAttrVal("Name_in_nur"));
	}	
	public void setName_in_nur(String Name_in_nur) {
		setAttrVal("Name_in_nur", Name_in_nur);
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
		return "Id_riskhoato";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BCH_RISK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RiskhoatoRecordDODesc.class);
	}
	
}