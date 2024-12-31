package iih.ci.ord.specanti.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.specanti.d.desc.SpecAntiConsDODesc;
import java.math.BigDecimal;

/**
 * 特殊使用级抗菌药物会诊申请 DO数据 
 * 
 */
public class SpecAntiConsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APSPECANTICONS= "Id_apspecanticons";
	public static final String ID_OR= "Id_or";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_EN= "Id_en";
	public static final String CODE_ENTP= "Code_entp";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SEX_PAT= "Id_sex_pat";
	public static final String ID_DIDEF= "Id_didef";
	public static final String NAME_DIDEF= "Name_didef";
	public static final String ID_DIITM= "Id_diitm";
	public static final String STR_ID_DIITM= "Str_id_diitm";
	public static final String STR_CODE_DIITM= "Str_code_diitm";
	public static final String STR_NAME_DIITM= "Str_name_diitm";
	public static final String DES_SYMPSIGN= "Des_sympsign";
	public static final String FG_MICROBEINSPECTION= "Fg_microbeinspection";
	public static final String MICROBEINSPECTION= "Microbeinspection";
	public static final String ALLERHYHISTORY= "Allerhyhistory";
	public static final String DES_PPS= "Des_pps";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_EMP_TITLE= "Id_emp_title";
	public static final String NAME_EMP_TITLE= "Name_emp_title";
	public static final String FG_SIGN= "Fg_sign";
	public static final String ID_SU_SPECCONS= "Id_su_speccons";
	public static final String EU_RECORD= "Eu_record";
	public static final String ID_CONSMD= "Id_consmd";
	public static final String SD_CONSMD= "Sd_consmd";
	public static final String ADVICE= "Advice";
	public static final String ID_EMP_RECORD= "Id_emp_record";
	public static final String DT_CONS_APP= "Dt_cons_app";
	public static final String DT_RECORD= "Dt_record";
	public static final String DT_CONS= "Dt_cons";
	public static final String ID_APPROVE_EMP= "Id_approve_emp";
	public static final String SD_APPROVE_EMP= "Sd_approve_emp";
	public static final String FG_SIGN_RECORD= "Fg_sign_record";
	public static final String FG_APPROVE_CLIDEP= "Fg_approve_clidep";
	public static final String ID_APPROVE_CLIDEP= "Id_approve_clidep";
	public static final String SD_APPROVE_CLIDEP= "Sd_approve_clidep";
	public static final String FG_APPROVE_MEDDEP= "Fg_approve_meddep";
	public static final String ID_APPROVE_MEDDEP= "Id_approve_meddep";
	public static final String SD_APPROVE_MEDDEP= "Sd_approve_meddep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_WG_PHY= "Name_wg_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String BED_NO= "Bed_no";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_WG_PHY= "Id_wg_phy";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NAME_PAT= "Name_pat";
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	public static final String SD_SEX_PAT= "Sd_sex_pat";
	public static final String NAME_SEX_PAT= "Name_sex_pat";
	public static final String NAME_EMP= "Name_emp";
	public static final String SD_SU_SPECCONS= "Sd_su_speccons";
	public static final String NAME_SU_SPECCONS= "Name_su_speccons";
	public static final String NAME_CONSMD= "Name_consmd";
	public static final String NAME_EMP_RECORD= "Name_emp_record";
	public static final String NAME_APPROVE_EMP= "Name_approve_emp";
	public static final String NAME_APPROVE_CLIDEP= "Name_approve_clidep";
	public static final String NAME_APPROVE_MEDDEP= "Name_approve_meddep";
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apspecanticons() {
		return ((String) getAttrVal("Id_apspecanticons"));
	}	
	public void setId_apspecanticons(String Id_apspecanticons) {
		setAttrVal("Id_apspecanticons", Id_apspecanticons);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}	
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getName_didef() {
		return ((String) getAttrVal("Name_didef"));
	}	
	public void setName_didef(String Name_didef) {
		setAttrVal("Name_didef", Name_didef);
	}
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}	
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	public String getStr_code_diitm() {
		return ((String) getAttrVal("Str_code_diitm"));
	}	
	public void setStr_code_diitm(String Str_code_diitm) {
		setAttrVal("Str_code_diitm", Str_code_diitm);
	}
	public String getStr_name_diitm() {
		return ((String) getAttrVal("Str_name_diitm"));
	}	
	public void setStr_name_diitm(String Str_name_diitm) {
		setAttrVal("Str_name_diitm", Str_name_diitm);
	}
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}	
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	public FBoolean getFg_microbeinspection() {
		return ((FBoolean) getAttrVal("Fg_microbeinspection"));
	}	
	public void setFg_microbeinspection(FBoolean Fg_microbeinspection) {
		setAttrVal("Fg_microbeinspection", Fg_microbeinspection);
	}
	public String getMicrobeinspection() {
		return ((String) getAttrVal("Microbeinspection"));
	}	
	public void setMicrobeinspection(String Microbeinspection) {
		setAttrVal("Microbeinspection", Microbeinspection);
	}
	public String getAllerhyhistory() {
		return ((String) getAttrVal("Allerhyhistory"));
	}	
	public void setAllerhyhistory(String Allerhyhistory) {
		setAttrVal("Allerhyhistory", Allerhyhistory);
	}
	public String getDes_pps() {
		return ((String) getAttrVal("Des_pps"));
	}	
	public void setDes_pps(String Des_pps) {
		setAttrVal("Des_pps", Des_pps);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_emp_title() {
		return ((String) getAttrVal("Id_emp_title"));
	}	
	public void setId_emp_title(String Id_emp_title) {
		setAttrVal("Id_emp_title", Id_emp_title);
	}
	public String getName_emp_title() {
		return ((String) getAttrVal("Name_emp_title"));
	}	
	public void setName_emp_title(String Name_emp_title) {
		setAttrVal("Name_emp_title", Name_emp_title);
	}
	public FBoolean getFg_sign() {
		return ((FBoolean) getAttrVal("Fg_sign"));
	}	
	public void setFg_sign(FBoolean Fg_sign) {
		setAttrVal("Fg_sign", Fg_sign);
	}
	public String getId_su_speccons() {
		return ((String) getAttrVal("Id_su_speccons"));
	}	
	public void setId_su_speccons(String Id_su_speccons) {
		setAttrVal("Id_su_speccons", Id_su_speccons);
	}
	public Integer getEu_record() {
		return ((Integer) getAttrVal("Eu_record"));
	}	
	public void setEu_record(Integer Eu_record) {
		setAttrVal("Eu_record", Eu_record);
	}
	public String getId_consmd() {
		return ((String) getAttrVal("Id_consmd"));
	}	
	public void setId_consmd(String Id_consmd) {
		setAttrVal("Id_consmd", Id_consmd);
	}
	public String getSd_consmd() {
		return ((String) getAttrVal("Sd_consmd"));
	}	
	public void setSd_consmd(String Sd_consmd) {
		setAttrVal("Sd_consmd", Sd_consmd);
	}
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}	
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	public String getId_emp_record() {
		return ((String) getAttrVal("Id_emp_record"));
	}	
	public void setId_emp_record(String Id_emp_record) {
		setAttrVal("Id_emp_record", Id_emp_record);
	}
	public FDateTime getDt_cons_app() {
		return ((FDateTime) getAttrVal("Dt_cons_app"));
	}	
	public void setDt_cons_app(FDateTime Dt_cons_app) {
		setAttrVal("Dt_cons_app", Dt_cons_app);
	}
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}	
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	public FDateTime getDt_cons() {
		return ((FDateTime) getAttrVal("Dt_cons"));
	}	
	public void setDt_cons(FDateTime Dt_cons) {
		setAttrVal("Dt_cons", Dt_cons);
	}
	public String getId_approve_emp() {
		return ((String) getAttrVal("Id_approve_emp"));
	}	
	public void setId_approve_emp(String Id_approve_emp) {
		setAttrVal("Id_approve_emp", Id_approve_emp);
	}
	public String getSd_approve_emp() {
		return ((String) getAttrVal("Sd_approve_emp"));
	}	
	public void setSd_approve_emp(String Sd_approve_emp) {
		setAttrVal("Sd_approve_emp", Sd_approve_emp);
	}
	public FBoolean getFg_sign_record() {
		return ((FBoolean) getAttrVal("Fg_sign_record"));
	}	
	public void setFg_sign_record(FBoolean Fg_sign_record) {
		setAttrVal("Fg_sign_record", Fg_sign_record);
	}
	public FBoolean getFg_approve_clidep() {
		return ((FBoolean) getAttrVal("Fg_approve_clidep"));
	}	
	public void setFg_approve_clidep(FBoolean Fg_approve_clidep) {
		setAttrVal("Fg_approve_clidep", Fg_approve_clidep);
	}
	public String getId_approve_clidep() {
		return ((String) getAttrVal("Id_approve_clidep"));
	}	
	public void setId_approve_clidep(String Id_approve_clidep) {
		setAttrVal("Id_approve_clidep", Id_approve_clidep);
	}
	public String getSd_approve_clidep() {
		return ((String) getAttrVal("Sd_approve_clidep"));
	}	
	public void setSd_approve_clidep(String Sd_approve_clidep) {
		setAttrVal("Sd_approve_clidep", Sd_approve_clidep);
	}
	public FBoolean getFg_approve_meddep() {
		return ((FBoolean) getAttrVal("Fg_approve_meddep"));
	}	
	public void setFg_approve_meddep(FBoolean Fg_approve_meddep) {
		setAttrVal("Fg_approve_meddep", Fg_approve_meddep);
	}
	public String getId_approve_meddep() {
		return ((String) getAttrVal("Id_approve_meddep"));
	}	
	public void setId_approve_meddep(String Id_approve_meddep) {
		setAttrVal("Id_approve_meddep", Id_approve_meddep);
	}
	public String getSd_approve_meddep() {
		return ((String) getAttrVal("Sd_approve_meddep"));
	}	
	public void setSd_approve_meddep(String Sd_approve_meddep) {
		setAttrVal("Sd_approve_meddep", Sd_approve_meddep);
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
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_wg_phy() {
		return ((String) getAttrVal("Name_wg_phy"));
	}	
	public void setName_wg_phy(String Name_wg_phy) {
		setAttrVal("Name_wg_phy", Name_wg_phy);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}	
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getId_wg_phy() {
		return ((String) getAttrVal("Id_wg_phy"));
	}	
	public void setId_wg_phy(String Id_wg_phy) {
		setAttrVal("Id_wg_phy", Id_wg_phy);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}	
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	public String getName_sex_pat() {
		return ((String) getAttrVal("Name_sex_pat"));
	}	
	public void setName_sex_pat(String Name_sex_pat) {
		setAttrVal("Name_sex_pat", Name_sex_pat);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getSd_su_speccons() {
		return ((String) getAttrVal("Sd_su_speccons"));
	}	
	public void setSd_su_speccons(String Sd_su_speccons) {
		setAttrVal("Sd_su_speccons", Sd_su_speccons);
	}
	public String getName_su_speccons() {
		return ((String) getAttrVal("Name_su_speccons"));
	}	
	public void setName_su_speccons(String Name_su_speccons) {
		setAttrVal("Name_su_speccons", Name_su_speccons);
	}
	public String getName_consmd() {
		return ((String) getAttrVal("Name_consmd"));
	}	
	public void setName_consmd(String Name_consmd) {
		setAttrVal("Name_consmd", Name_consmd);
	}
	public String getName_emp_record() {
		return ((String) getAttrVal("Name_emp_record"));
	}	
	public void setName_emp_record(String Name_emp_record) {
		setAttrVal("Name_emp_record", Name_emp_record);
	}
	public String getName_approve_emp() {
		return ((String) getAttrVal("Name_approve_emp"));
	}	
	public void setName_approve_emp(String Name_approve_emp) {
		setAttrVal("Name_approve_emp", Name_approve_emp);
	}
	public String getName_approve_clidep() {
		return ((String) getAttrVal("Name_approve_clidep"));
	}	
	public void setName_approve_clidep(String Name_approve_clidep) {
		setAttrVal("Name_approve_clidep", Name_approve_clidep);
	}
	public String getName_approve_meddep() {
		return ((String) getAttrVal("Name_approve_meddep"));
	}	
	public void setName_approve_meddep(String Name_approve_meddep) {
		setAttrVal("Name_approve_meddep", Name_approve_meddep);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
		return "Id_apspecanticons";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_spec_anti_cons";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SpecAntiConsDODesc.class);
	}
	
}