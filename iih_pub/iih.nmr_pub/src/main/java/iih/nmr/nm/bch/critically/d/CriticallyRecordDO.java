package iih.nmr.nm.bch.critically.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.critically.d.desc.CriticallyRecordDODesc;
import java.math.BigDecimal;

/**
 * 病危患者护理记录 DO数据 
 * 
 */
public class CriticallyRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CRITICALLY= "Id_critically";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_BED= "Name_bed";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String AGE= "Age";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String DT_DATE= "Dt_date";
	public static final String NV_T= "Nv_t";
	public static final String INT_PULSE= "Int_pulse";
	public static final String INT_BREATHING= "Int_breathing";
	public static final String INT_SBP= "Int_sbp";
	public static final String INT_DBP= "Int_dbp";
	public static final String NV_SAO2= "Nv_sao2";
	public static final String INT_OXYIN= "Int_oxyin";
	public static final String ID_SPIRITS= "Id_spirits";
	public static final String SD_SPIRITS= "Sd_spirits";
	public static final String INT_PUPIL_LEFT= "Int_pupil_left";
	public static final String INT_PUPIL_RIGHT= "Int_pupil_right";
	public static final String ID_SD_REFLEX_LEFT= "Id_sd_reflex_left";
	public static final String SD_SD_REFLEX_LEFT= "Sd_sd_reflex_left";
	public static final String ID_SD_REFLEX_RIGHT= "Id_sd_reflex_right";
	public static final String SD_SD_REFLEX_RIGHT= "Sd_sd_reflex_right";
	public static final String ID_SD_SKIN_COLOR= "Id_sd_skin_color";
	public static final String SD_SD_SKIN_COLOR= "Sd_sd_skin_color";
	public static final String NAME_IN= "Name_in";
	public static final String NAME_OUT= "Name_out";
	public static final String URIOUT= "Uriout";
	public static final String NAME_OCNM= "Name_ocnm";
	public static final String ID_NUR= "Id_nur";
	public static final String TEMPFILENAME= "Tempfilename";
	public static final String VEIN= "Vein";
	public static final String ORALLY= "Orally";
	public static final String RL_OTHER= "Rl_other";
	public static final String EMESIS_COUNT= "Emesis_count";
	public static final String CL_OTHER= "Cl_other";
	public static final String ID_SD_WOUND= "Id_sd_wound";
	public static final String SD_SD_WOUND= "Sd_sd_wound";
	public static final String ID_LEVEL= "Id_level";
	public static final String SD_LEVEL= "Sd_level";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_CREATE= "Dt_create";
	public static final String ID_SD_PIPE= "Id_sd_pipe";
	public static final String SD_SD_PIPE= "Sd_sd_pipe";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_SD_BASENUR= "Id_sd_basenur";
	public static final String SD_SD_BASENUR= "Sd_sd_basenur";
	public static final String NAME_SPIRITS= "Name_spirits";
	public static final String NAME_REFLEX_LEFT= "Name_reflex_left";
	public static final String NAME_REFLEX_RIGHT= "Name_reflex_right";
	public static final String NAME_SKIN_COLOR= "Name_skin_color";
	public static final String NAME_WOUND= "Name_wound";
	public static final String NAME_LEVEL= "Name_level";
	public static final String NAME_PIPE= "Name_pipe";
	public static final String NAME_BASENUR= "Name_basenur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_critically() {
		return ((String) getAttrVal("Id_critically"));
	}	
	public void setId_critically(String Id_critically) {
		setAttrVal("Id_critically", Id_critically);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
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
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
	public FDate getDt_date() {
		return ((FDate) getAttrVal("Dt_date"));
	}	
	public void setDt_date(FDate Dt_date) {
		setAttrVal("Dt_date", Dt_date);
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
	public FDouble getNv_sao2() {
		return ((FDouble) getAttrVal("Nv_sao2"));
	}	
	public void setNv_sao2(FDouble Nv_sao2) {
		setAttrVal("Nv_sao2", Nv_sao2);
	}
	public FDouble getInt_oxyin() {
		return ((FDouble) getAttrVal("Int_oxyin"));
	}	
	public void setInt_oxyin(FDouble Int_oxyin) {
		setAttrVal("Int_oxyin", Int_oxyin);
	}
	public String getId_spirits() {
		return ((String) getAttrVal("Id_spirits"));
	}	
	public void setId_spirits(String Id_spirits) {
		setAttrVal("Id_spirits", Id_spirits);
	}
	public String getSd_spirits() {
		return ((String) getAttrVal("Sd_spirits"));
	}	
	public void setSd_spirits(String Sd_spirits) {
		setAttrVal("Sd_spirits", Sd_spirits);
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
	public String getId_sd_reflex_left() {
		return ((String) getAttrVal("Id_sd_reflex_left"));
	}	
	public void setId_sd_reflex_left(String Id_sd_reflex_left) {
		setAttrVal("Id_sd_reflex_left", Id_sd_reflex_left);
	}
	public String getSd_sd_reflex_left() {
		return ((String) getAttrVal("Sd_sd_reflex_left"));
	}	
	public void setSd_sd_reflex_left(String Sd_sd_reflex_left) {
		setAttrVal("Sd_sd_reflex_left", Sd_sd_reflex_left);
	}
	public String getId_sd_reflex_right() {
		return ((String) getAttrVal("Id_sd_reflex_right"));
	}	
	public void setId_sd_reflex_right(String Id_sd_reflex_right) {
		setAttrVal("Id_sd_reflex_right", Id_sd_reflex_right);
	}
	public String getSd_sd_reflex_right() {
		return ((String) getAttrVal("Sd_sd_reflex_right"));
	}	
	public void setSd_sd_reflex_right(String Sd_sd_reflex_right) {
		setAttrVal("Sd_sd_reflex_right", Sd_sd_reflex_right);
	}
	public String getId_sd_skin_color() {
		return ((String) getAttrVal("Id_sd_skin_color"));
	}	
	public void setId_sd_skin_color(String Id_sd_skin_color) {
		setAttrVal("Id_sd_skin_color", Id_sd_skin_color);
	}
	public String getSd_sd_skin_color() {
		return ((String) getAttrVal("Sd_sd_skin_color"));
	}	
	public void setSd_sd_skin_color(String Sd_sd_skin_color) {
		setAttrVal("Sd_sd_skin_color", Sd_sd_skin_color);
	}
	public String getName_in() {
		return ((String) getAttrVal("Name_in"));
	}	
	public void setName_in(String Name_in) {
		setAttrVal("Name_in", Name_in);
	}
	public String getName_out() {
		return ((String) getAttrVal("Name_out"));
	}	
	public void setName_out(String Name_out) {
		setAttrVal("Name_out", Name_out);
	}
	public FDouble getUriout() {
		return ((FDouble) getAttrVal("Uriout"));
	}	
	public void setUriout(FDouble Uriout) {
		setAttrVal("Uriout", Uriout);
	}
	public String getName_ocnm() {
		return ((String) getAttrVal("Name_ocnm"));
	}	
	public void setName_ocnm(String Name_ocnm) {
		setAttrVal("Name_ocnm", Name_ocnm);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public Integer getTempfilename() {
		return ((Integer) getAttrVal("Tempfilename"));
	}	
	public void setTempfilename(Integer Tempfilename) {
		setAttrVal("Tempfilename", Tempfilename);
	}
	public FDouble getVein() {
		return ((FDouble) getAttrVal("Vein"));
	}	
	public void setVein(FDouble Vein) {
		setAttrVal("Vein", Vein);
	}
	public FDouble getOrally() {
		return ((FDouble) getAttrVal("Orally"));
	}	
	public void setOrally(FDouble Orally) {
		setAttrVal("Orally", Orally);
	}
	public FDouble getRl_other() {
		return ((FDouble) getAttrVal("Rl_other"));
	}	
	public void setRl_other(FDouble Rl_other) {
		setAttrVal("Rl_other", Rl_other);
	}
	public FDouble getEmesis_count() {
		return ((FDouble) getAttrVal("Emesis_count"));
	}	
	public void setEmesis_count(FDouble Emesis_count) {
		setAttrVal("Emesis_count", Emesis_count);
	}
	public FDouble getCl_other() {
		return ((FDouble) getAttrVal("Cl_other"));
	}	
	public void setCl_other(FDouble Cl_other) {
		setAttrVal("Cl_other", Cl_other);
	}
	public String getId_sd_wound() {
		return ((String) getAttrVal("Id_sd_wound"));
	}	
	public void setId_sd_wound(String Id_sd_wound) {
		setAttrVal("Id_sd_wound", Id_sd_wound);
	}
	public String getSd_sd_wound() {
		return ((String) getAttrVal("Sd_sd_wound"));
	}	
	public void setSd_sd_wound(String Sd_sd_wound) {
		setAttrVal("Sd_sd_wound", Sd_sd_wound);
	}
	public String getId_level() {
		return ((String) getAttrVal("Id_level"));
	}	
	public void setId_level(String Id_level) {
		setAttrVal("Id_level", Id_level);
	}
	public String getSd_level() {
		return ((String) getAttrVal("Sd_level"));
	}	
	public void setSd_level(String Sd_level) {
		setAttrVal("Sd_level", Sd_level);
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
	public String getId_sd_pipe() {
		return ((String) getAttrVal("Id_sd_pipe"));
	}	
	public void setId_sd_pipe(String Id_sd_pipe) {
		setAttrVal("Id_sd_pipe", Id_sd_pipe);
	}
	public String getSd_sd_pipe() {
		return ((String) getAttrVal("Sd_sd_pipe"));
	}	
	public void setSd_sd_pipe(String Sd_sd_pipe) {
		setAttrVal("Sd_sd_pipe", Sd_sd_pipe);
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
	public String getId_sd_basenur() {
		return ((String) getAttrVal("Id_sd_basenur"));
	}	
	public void setId_sd_basenur(String Id_sd_basenur) {
		setAttrVal("Id_sd_basenur", Id_sd_basenur);
	}
	public String getSd_sd_basenur() {
		return ((String) getAttrVal("Sd_sd_basenur"));
	}	
	public void setSd_sd_basenur(String Sd_sd_basenur) {
		setAttrVal("Sd_sd_basenur", Sd_sd_basenur);
	}
	public String getName_spirits() {
		return ((String) getAttrVal("Name_spirits"));
	}	
	public void setName_spirits(String Name_spirits) {
		setAttrVal("Name_spirits", Name_spirits);
	}
	public String getName_reflex_left() {
		return ((String) getAttrVal("Name_reflex_left"));
	}	
	public void setName_reflex_left(String Name_reflex_left) {
		setAttrVal("Name_reflex_left", Name_reflex_left);
	}
	public String getName_reflex_right() {
		return ((String) getAttrVal("Name_reflex_right"));
	}	
	public void setName_reflex_right(String Name_reflex_right) {
		setAttrVal("Name_reflex_right", Name_reflex_right);
	}
	public String getName_skin_color() {
		return ((String) getAttrVal("Name_skin_color"));
	}	
	public void setName_skin_color(String Name_skin_color) {
		setAttrVal("Name_skin_color", Name_skin_color);
	}
	public String getName_wound() {
		return ((String) getAttrVal("Name_wound"));
	}	
	public void setName_wound(String Name_wound) {
		setAttrVal("Name_wound", Name_wound);
	}
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}	
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
	}
	public String getName_pipe() {
		return ((String) getAttrVal("Name_pipe"));
	}	
	public void setName_pipe(String Name_pipe) {
		setAttrVal("Name_pipe", Name_pipe);
	}
	public String getName_basenur() {
		return ((String) getAttrVal("Name_basenur"));
	}	
	public void setName_basenur(String Name_basenur) {
		setAttrVal("Name_basenur", Name_basenur);
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
		return "Id_critically";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BCH_CRITIC_REC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CriticallyRecordDODesc.class);
	}
	
}