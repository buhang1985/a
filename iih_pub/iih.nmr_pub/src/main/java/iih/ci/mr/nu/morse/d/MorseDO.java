package iih.ci.mr.nu.morse.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.morse.d.desc.MorseDODesc;
import java.math.BigDecimal;

/**
 * Morse跌倒/坠床风险评估单 DO数据 
 * 
 */
public class MorseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MORSE= "Id_morse";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String NAME_PAT= "Name_pat";
	public static final String AGE= "Age";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String NAME_SEX= "Name_sex";
	public static final String ID_NURS_MEAS= "Id_nurs_meas";
	public static final String SD_NURS_MEAS= "Sd_nurs_meas";
	public static final String ID_TREAD= "Id_tread";
	public static final String SD_TREAD= "Sd_tread";
	public static final String ID_KNOW_STATUS= "Id_know_status";
	public static final String SD_KNOW_STATUS= "Sd_know_status";
	public static final String ID_ENUM_FALL= "Id_enum_fall";
	public static final String SD_ENUM_FALL= "Sd_enum_fall";
	public static final String ID_MEDI_DIAG= "Id_medi_diag";
	public static final String SD_MEDI_DIAG= "Sd_medi_diag";
	public static final String ID_INTR_DRIP_INJE= "Id_intr_drip_inje";
	public static final String SD_INTR_DRIP_INJE= "Sd_intr_drip_inje";
	public static final String ID_WALK_AUXI= "Id_walk_auxi";
	public static final String SD_WALK_AUXI= "Sd_walk_auxi";
	public static final String ID_DRUG_REAC= "Id_drug_reac";
	public static final String SD_DRUG_REAC= "Sd_drug_reac";
	public static final String ID_ENVI_FACT= "Id_envi_fact";
	public static final String SD_ENVI_FACT= "Sd_envi_fact";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String REMARK= "Remark";
	public static final String MORSE_SCORE= "Morse_score";
	public static final String SC_WALK_AUXI= "Sc_walk_auxi";
	public static final String SC_FALLL= "Sc_falll";
	public static final String SC_MEDI_DIAG= "Sc_medi_diag";
	public static final String SC_INTR_DRIP_INJE= "Sc_intr_drip_inje";
	public static final String SC_TREAD= "Sc_tread";
	public static final String SC_KNOW_STATUS= "Sc_know_status";
	public static final String SC_ENVI_FACT= "Sc_envi_fact";
	public static final String SC_DRUG_REAC= "Sc_drug_reac";
	public static final String REPORT_DATE= "Report_date";
	public static final String ID_SIGN_NURSE= "Id_sign_nurse";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NURS_MEAS= "Name_nurs_meas";
	public static final String NAME_TREAD= "Name_tread";
	public static final String NAME_KNOW_STATUS= "Name_know_status";
	public static final String NAME_ENUM_FALL= "Name_enum_fall";
	public static final String NAME_MEDI_DIAG= "Name_medi_diag";
	public static final String NAME_INTR_DRIP_INJE= "Name_intr_drip_inje";
	public static final String NAME_WALK_AUXI= "Name_walk_auxi";
	public static final String NAME_DRUG_REAC= "Name_drug_reac";
	public static final String NAME_ENVI_FACT= "Name_envi_fact";
	public static final String NAME_SIGN_NURSE= "Name_sign_nurse";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_morse() {
		return ((String) getAttrVal("Id_morse"));
	}	
	public void setId_morse(String Id_morse) {
		setAttrVal("Id_morse", Id_morse);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
	public String getId_tread() {
		return ((String) getAttrVal("Id_tread"));
	}	
	public void setId_tread(String Id_tread) {
		setAttrVal("Id_tread", Id_tread);
	}
	public String getSd_tread() {
		return ((String) getAttrVal("Sd_tread"));
	}	
	public void setSd_tread(String Sd_tread) {
		setAttrVal("Sd_tread", Sd_tread);
	}
	public String getId_know_status() {
		return ((String) getAttrVal("Id_know_status"));
	}	
	public void setId_know_status(String Id_know_status) {
		setAttrVal("Id_know_status", Id_know_status);
	}
	public String getSd_know_status() {
		return ((String) getAttrVal("Sd_know_status"));
	}	
	public void setSd_know_status(String Sd_know_status) {
		setAttrVal("Sd_know_status", Sd_know_status);
	}
	public String getId_enum_fall() {
		return ((String) getAttrVal("Id_enum_fall"));
	}	
	public void setId_enum_fall(String Id_enum_fall) {
		setAttrVal("Id_enum_fall", Id_enum_fall);
	}
	public String getSd_enum_fall() {
		return ((String) getAttrVal("Sd_enum_fall"));
	}	
	public void setSd_enum_fall(String Sd_enum_fall) {
		setAttrVal("Sd_enum_fall", Sd_enum_fall);
	}
	public String getId_medi_diag() {
		return ((String) getAttrVal("Id_medi_diag"));
	}	
	public void setId_medi_diag(String Id_medi_diag) {
		setAttrVal("Id_medi_diag", Id_medi_diag);
	}
	public String getSd_medi_diag() {
		return ((String) getAttrVal("Sd_medi_diag"));
	}	
	public void setSd_medi_diag(String Sd_medi_diag) {
		setAttrVal("Sd_medi_diag", Sd_medi_diag);
	}
	public String getId_intr_drip_inje() {
		return ((String) getAttrVal("Id_intr_drip_inje"));
	}	
	public void setId_intr_drip_inje(String Id_intr_drip_inje) {
		setAttrVal("Id_intr_drip_inje", Id_intr_drip_inje);
	}
	public String getSd_intr_drip_inje() {
		return ((String) getAttrVal("Sd_intr_drip_inje"));
	}	
	public void setSd_intr_drip_inje(String Sd_intr_drip_inje) {
		setAttrVal("Sd_intr_drip_inje", Sd_intr_drip_inje);
	}
	public String getId_walk_auxi() {
		return ((String) getAttrVal("Id_walk_auxi"));
	}	
	public void setId_walk_auxi(String Id_walk_auxi) {
		setAttrVal("Id_walk_auxi", Id_walk_auxi);
	}
	public String getSd_walk_auxi() {
		return ((String) getAttrVal("Sd_walk_auxi"));
	}	
	public void setSd_walk_auxi(String Sd_walk_auxi) {
		setAttrVal("Sd_walk_auxi", Sd_walk_auxi);
	}
	public String getId_drug_reac() {
		return ((String) getAttrVal("Id_drug_reac"));
	}	
	public void setId_drug_reac(String Id_drug_reac) {
		setAttrVal("Id_drug_reac", Id_drug_reac);
	}
	public String getSd_drug_reac() {
		return ((String) getAttrVal("Sd_drug_reac"));
	}	
	public void setSd_drug_reac(String Sd_drug_reac) {
		setAttrVal("Sd_drug_reac", Sd_drug_reac);
	}
	public String getId_envi_fact() {
		return ((String) getAttrVal("Id_envi_fact"));
	}	
	public void setId_envi_fact(String Id_envi_fact) {
		setAttrVal("Id_envi_fact", Id_envi_fact);
	}
	public String getSd_envi_fact() {
		return ((String) getAttrVal("Sd_envi_fact"));
	}	
	public void setSd_envi_fact(String Sd_envi_fact) {
		setAttrVal("Sd_envi_fact", Sd_envi_fact);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getRemark() {
		return ((String) getAttrVal("Remark"));
	}	
	public void setRemark(String Remark) {
		setAttrVal("Remark", Remark);
	}
	public FDouble getMorse_score() {
		return ((FDouble) getAttrVal("Morse_score"));
	}	
	public void setMorse_score(FDouble Morse_score) {
		setAttrVal("Morse_score", Morse_score);
	}
	public FDouble getSc_walk_auxi() {
		return ((FDouble) getAttrVal("Sc_walk_auxi"));
	}	
	public void setSc_walk_auxi(FDouble Sc_walk_auxi) {
		setAttrVal("Sc_walk_auxi", Sc_walk_auxi);
	}
	public FDouble getSc_falll() {
		return ((FDouble) getAttrVal("Sc_falll"));
	}	
	public void setSc_falll(FDouble Sc_falll) {
		setAttrVal("Sc_falll", Sc_falll);
	}
	public FDouble getSc_medi_diag() {
		return ((FDouble) getAttrVal("Sc_medi_diag"));
	}	
	public void setSc_medi_diag(FDouble Sc_medi_diag) {
		setAttrVal("Sc_medi_diag", Sc_medi_diag);
	}
	public FDouble getSc_intr_drip_inje() {
		return ((FDouble) getAttrVal("Sc_intr_drip_inje"));
	}	
	public void setSc_intr_drip_inje(FDouble Sc_intr_drip_inje) {
		setAttrVal("Sc_intr_drip_inje", Sc_intr_drip_inje);
	}
	public FDouble getSc_tread() {
		return ((FDouble) getAttrVal("Sc_tread"));
	}	
	public void setSc_tread(FDouble Sc_tread) {
		setAttrVal("Sc_tread", Sc_tread);
	}
	public FDouble getSc_know_status() {
		return ((FDouble) getAttrVal("Sc_know_status"));
	}	
	public void setSc_know_status(FDouble Sc_know_status) {
		setAttrVal("Sc_know_status", Sc_know_status);
	}
	public FDouble getSc_envi_fact() {
		return ((FDouble) getAttrVal("Sc_envi_fact"));
	}	
	public void setSc_envi_fact(FDouble Sc_envi_fact) {
		setAttrVal("Sc_envi_fact", Sc_envi_fact);
	}
	public FDouble getSc_drug_reac() {
		return ((FDouble) getAttrVal("Sc_drug_reac"));
	}	
	public void setSc_drug_reac(FDouble Sc_drug_reac) {
		setAttrVal("Sc_drug_reac", Sc_drug_reac);
	}
	public FDateTime getReport_date() {
		return ((FDateTime) getAttrVal("Report_date"));
	}	
	public void setReport_date(FDateTime Report_date) {
		setAttrVal("Report_date", Report_date);
	}
	public String getId_sign_nurse() {
		return ((String) getAttrVal("Id_sign_nurse"));
	}	
	public void setId_sign_nurse(String Id_sign_nurse) {
		setAttrVal("Id_sign_nurse", Id_sign_nurse);
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
	public String getName_nurs_meas() {
		return ((String) getAttrVal("Name_nurs_meas"));
	}	
	public void setName_nurs_meas(String Name_nurs_meas) {
		setAttrVal("Name_nurs_meas", Name_nurs_meas);
	}
	public String getName_tread() {
		return ((String) getAttrVal("Name_tread"));
	}	
	public void setName_tread(String Name_tread) {
		setAttrVal("Name_tread", Name_tread);
	}
	public String getName_know_status() {
		return ((String) getAttrVal("Name_know_status"));
	}	
	public void setName_know_status(String Name_know_status) {
		setAttrVal("Name_know_status", Name_know_status);
	}
	public String getName_enum_fall() {
		return ((String) getAttrVal("Name_enum_fall"));
	}	
	public void setName_enum_fall(String Name_enum_fall) {
		setAttrVal("Name_enum_fall", Name_enum_fall);
	}
	public String getName_medi_diag() {
		return ((String) getAttrVal("Name_medi_diag"));
	}	
	public void setName_medi_diag(String Name_medi_diag) {
		setAttrVal("Name_medi_diag", Name_medi_diag);
	}
	public String getName_intr_drip_inje() {
		return ((String) getAttrVal("Name_intr_drip_inje"));
	}	
	public void setName_intr_drip_inje(String Name_intr_drip_inje) {
		setAttrVal("Name_intr_drip_inje", Name_intr_drip_inje);
	}
	public String getName_walk_auxi() {
		return ((String) getAttrVal("Name_walk_auxi"));
	}	
	public void setName_walk_auxi(String Name_walk_auxi) {
		setAttrVal("Name_walk_auxi", Name_walk_auxi);
	}
	public String getName_drug_reac() {
		return ((String) getAttrVal("Name_drug_reac"));
	}	
	public void setName_drug_reac(String Name_drug_reac) {
		setAttrVal("Name_drug_reac", Name_drug_reac);
	}
	public String getName_envi_fact() {
		return ((String) getAttrVal("Name_envi_fact"));
	}	
	public void setName_envi_fact(String Name_envi_fact) {
		setAttrVal("Name_envi_fact", Name_envi_fact);
	}
	public String getName_sign_nurse() {
		return ((String) getAttrVal("Name_sign_nurse"));
	}	
	public void setName_sign_nurse(String Name_sign_nurse) {
		setAttrVal("Name_sign_nurse", Name_sign_nurse);
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
		return "Id_morse";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_morse";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MorseDODesc.class);
	}
	
}