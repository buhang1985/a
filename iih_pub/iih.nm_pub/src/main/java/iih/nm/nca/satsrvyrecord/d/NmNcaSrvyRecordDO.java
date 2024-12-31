package iih.nm.nca.satsrvyrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nca.satsrvyrecord.d.desc.NmNcaSrvyRecordDODesc;
import java.math.BigDecimal;

/**
 * 满意度调查记录 DO数据 
 * 
 */
public class NmNcaSrvyRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NCA_SRVY= "Id_nca_srvy";
	public static final String ID_NCA_TMPL= "Id_nca_tmpl";
	public static final String ID_NCA_TMPLCA= "Id_nca_tmplca";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP_SRVY= "Id_dep_srvy";
	public static final String ID_WHO_SRVY= "Id_who_srvy";
	public static final String SD_WHO_SRVY= "Sd_who_srvy";
	public static final String BED_CODE= "Bed_code";
	public static final String ID_NUR_SAT= "Id_nur_sat";
	public static final String ID_NUR_NOTSAT= "Id_nur_notsat";
	public static final String SCORE= "Score";
	public static final String DT_SRVY= "Dt_srvy";
	public static final String ID_PSN_SRVY= "Id_psn_srvy";
	public static final String OPINION= "Opinion";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_SRVY= "Name_dep_srvy";
	public static final String NAME_WHO_SRVY= "Name_who_srvy";
	public static final String NAME_NUR_SAT= "Name_nur_sat";
	public static final String NAME_NUR_NOTSAT= "Name_nur_notsat";
	public static final String NAME_PSN_SRVY= "Name_psn_srvy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nca_srvy() {
		return ((String) getAttrVal("Id_nca_srvy"));
	}	
	public void setId_nca_srvy(String Id_nca_srvy) {
		setAttrVal("Id_nca_srvy", Id_nca_srvy);
	}
	public String getId_nca_tmpl() {
		return ((String) getAttrVal("Id_nca_tmpl"));
	}	
	public void setId_nca_tmpl(String Id_nca_tmpl) {
		setAttrVal("Id_nca_tmpl", Id_nca_tmpl);
	}
	public String getId_nca_tmplca() {
		return ((String) getAttrVal("Id_nca_tmplca"));
	}	
	public void setId_nca_tmplca(String Id_nca_tmplca) {
		setAttrVal("Id_nca_tmplca", Id_nca_tmplca);
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
	public String getId_dep_srvy() {
		return ((String) getAttrVal("Id_dep_srvy"));
	}	
	public void setId_dep_srvy(String Id_dep_srvy) {
		setAttrVal("Id_dep_srvy", Id_dep_srvy);
	}
	public String getId_who_srvy() {
		return ((String) getAttrVal("Id_who_srvy"));
	}	
	public void setId_who_srvy(String Id_who_srvy) {
		setAttrVal("Id_who_srvy", Id_who_srvy);
	}
	public String getSd_who_srvy() {
		return ((String) getAttrVal("Sd_who_srvy"));
	}	
	public void setSd_who_srvy(String Sd_who_srvy) {
		setAttrVal("Sd_who_srvy", Sd_who_srvy);
	}
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}	
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	public String getId_nur_sat() {
		return ((String) getAttrVal("Id_nur_sat"));
	}	
	public void setId_nur_sat(String Id_nur_sat) {
		setAttrVal("Id_nur_sat", Id_nur_sat);
	}
	public String getId_nur_notsat() {
		return ((String) getAttrVal("Id_nur_notsat"));
	}	
	public void setId_nur_notsat(String Id_nur_notsat) {
		setAttrVal("Id_nur_notsat", Id_nur_notsat);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
	}
	public FDate getDt_srvy() {
		return ((FDate) getAttrVal("Dt_srvy"));
	}	
	public void setDt_srvy(FDate Dt_srvy) {
		setAttrVal("Dt_srvy", Dt_srvy);
	}
	public String getId_psn_srvy() {
		return ((String) getAttrVal("Id_psn_srvy"));
	}	
	public void setId_psn_srvy(String Id_psn_srvy) {
		setAttrVal("Id_psn_srvy", Id_psn_srvy);
	}
	public String getOpinion() {
		return ((String) getAttrVal("Opinion"));
	}	
	public void setOpinion(String Opinion) {
		setAttrVal("Opinion", Opinion);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_dep_srvy() {
		return ((String) getAttrVal("Name_dep_srvy"));
	}	
	public void setName_dep_srvy(String Name_dep_srvy) {
		setAttrVal("Name_dep_srvy", Name_dep_srvy);
	}
	public String getName_who_srvy() {
		return ((String) getAttrVal("Name_who_srvy"));
	}	
	public void setName_who_srvy(String Name_who_srvy) {
		setAttrVal("Name_who_srvy", Name_who_srvy);
	}
	public String getName_nur_sat() {
		return ((String) getAttrVal("Name_nur_sat"));
	}	
	public void setName_nur_sat(String Name_nur_sat) {
		setAttrVal("Name_nur_sat", Name_nur_sat);
	}
	public String getName_nur_notsat() {
		return ((String) getAttrVal("Name_nur_notsat"));
	}	
	public void setName_nur_notsat(String Name_nur_notsat) {
		setAttrVal("Name_nur_notsat", Name_nur_notsat);
	}
	public String getName_psn_srvy() {
		return ((String) getAttrVal("Name_psn_srvy"));
	}	
	public void setName_psn_srvy(String Name_psn_srvy) {
		setAttrVal("Name_psn_srvy", Name_psn_srvy);
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
		return "Id_nca_srvy";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NCA_SRVY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNcaSrvyRecordDODesc.class);
	}
	
}