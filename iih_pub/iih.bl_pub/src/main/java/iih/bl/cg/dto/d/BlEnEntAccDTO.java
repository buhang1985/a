package iih.bl.cg.dto.d;

import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

public class BlEnEntAccDTO extends BaseDTO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String ID_ENT= "Id_ent";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String CODE= "Code";
	public static final String DES= "Des";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_SEX_PAT= "Id_sex_pat";
	public static final String SD_SEX_PAT= "Sd_sex_pat";
	public static final String ID_MARI_PAT= "Id_mari_pat";
	public static final String SD_MARI_PAT= "Sd_mari_pat";
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	public static final String TELNO_PAT= "Telno_pat";
	public static final String ADDR_PAT= "Addr_pat";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String FG_ACPTVALID= "Fg_acptvalid";
	public static final String DT_ACPT= "Dt_acpt";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_WG_PHY= "Id_wg_phy";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_EMP_PHY= "Id_emp_phy";
	public static final String ID_EMP_NUR= "Id_emp_nur";
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	public static final String ID_HP= "Id_hp";
	public static final String ID_PATCA= "Id_patca";
	public static final String ID_PRIPAT= "Id_pripat";
	public static final String ID_PATCRET= "Id_patcret";
	public static final String SD_STATUS= "Sd_status";
	public static final String FG_ST= "Fg_st";
	public static final String FG_IP= "Fg_ip";
	public static final String FG_FLUP= "Fg_flup";
	public static final String SD_STATUS_FLUP= "Sd_status_flup";
	public static final String FG_CANC= "Fg_canc";
	public static final String ID_EMP_CANC= "Id_emp_canc";
	public static final String DT_CANC= "Dt_canc";
	public static final String NOTE= "Note";
	public static final String FG_DATA_TRANSF= "Fg_data_transf";
	public static final String DT_END= "Dt_end";
	public static final String DT_INSERT= "Dt_insert";
	
	public static final String ID_ENTACC= "Id_entacc";
	public static final String AMT_CRED= "Amt_cred";
	public static final String AMT_PREPAY= "Amt_prepay";
	public static final String AMT_UNCG= "Amt_uncg";
	public static final String AMT_OWELIMIT= "Amt_owelimit";
	public static final String DT_BACKCG= "Dt_backcg";
	public static final String DT_BACKCGLASTACT= "Dt_backcglastact";
	
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}	
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}	
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	
	public String getId_mari_pat() {
		return ((String) getAttrVal("Id_mari_pat"));
	}	
	public void setId_mari_pat(String Id_mari_pat) {
		setAttrVal("Id_mari_pat", Id_mari_pat);
	}
	
	public String getSd_mari_pat() {
		return ((String) getAttrVal("Sd_mari_pat"));
	}	
	public void setSd_mari_pat(String Sd_mari_pat) {
		setAttrVal("Sd_mari_pat", Sd_mari_pat);
	}
	
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}	
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}	
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	
	public FBoolean getFg_acptvalid() {
		return ((FBoolean) getAttrVal("Fg_acptvalid"));
	}	
	public void setFg_acptvalid(FBoolean Fg_acptvalid) {
		setAttrVal("Fg_acptvalid", Fg_acptvalid);
	}
	
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
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
	
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}	
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}	
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	
	public FBoolean getFg_st() {
		return ((FBoolean) getAttrVal("Fg_st"));
	}	
	public void setFg_st(FBoolean Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}	
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	
	public FBoolean getFg_flup() {
		return ((FBoolean) getAttrVal("Fg_flup"));
	}	
	public void setFg_flup(FBoolean Fg_flup) {
		setAttrVal("Fg_flup", Fg_flup);
	}
	
	public String getSd_status_flup() {
		return ((String) getAttrVal("Sd_status_flup"));
	}	
	public void setSd_status_flup(String Sd_status_flup) {
		setAttrVal("Sd_status_flup", Sd_status_flup);
	}
	
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	
	public FBoolean getFg_data_transf() {
		return ((FBoolean) getAttrVal("Fg_data_transf"));
	}	
	public void setFg_data_transf(FBoolean Fg_data_transf) {
		setAttrVal("Fg_data_transf", Fg_data_transf);
	}
	
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
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
  
	@Override
	public String getPKFieldName() {
		return "Id_ent";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(PatiVisitDODesc.class);
	}
	

	public String getId_entacc() {
		return ((String) getAttrVal("Id_entacc"));
	}	
	public void setId_entacc(String Id_entacc) {
		setAttrVal("Id_entacc", Id_entacc);
	}
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}	
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}	
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}	
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	public FDouble getAmt_owelimit() {
		return ((FDouble) getAttrVal("Amt_owelimit"));
	}	
	public void setAmt_owelimit(FDouble Amt_owelimit) {
		setAttrVal("Amt_owelimit", Amt_owelimit);
	}
	public FDateTime getDt_backcg() {
		return ((FDateTime) getAttrVal("Dt_backcg"));
	}	
	public void setDt_backcg(FDateTime Dt_backcg) {
		setAttrVal("Dt_backcg", Dt_backcg);
	}
	public FDateTime getDt_backcglastact() {
		return ((FDateTime) getAttrVal("Dt_backcglastact"));
	}	
	public void setDt_backcglastact(FDateTime Dt_backcglastact) {
		setAttrVal("Dt_backcglastact", Dt_backcglastact);
	}
	
}
