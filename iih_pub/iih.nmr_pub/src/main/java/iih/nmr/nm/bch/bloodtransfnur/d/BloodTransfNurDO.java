package iih.nmr.nm.bch.bloodtransfnur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.nm.bch.bloodtransfnur.d.desc.BloodTransfNurDODesc;
import java.math.BigDecimal;

/**
 * 临床输血护理记录单 DO数据 
 * 
 */
public class BloodTransfNurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BLOOD_TRANSF= "Id_blood_transf";
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
	public static final String FG_RECORD_BAG= "Fg_record_bag";
	public static final String ID_EMP_DUTY= "Id_emp_duty";
	public static final String ID_BLOOD_INFO= "Id_blood_info";
	public static final String SD_BLOOD_INFO= "Sd_blood_info";
	public static final String ID_EMP_BLOCHECK= "Id_emp_blocheck";
	public static final String FG_PAT_RECORD= "Fg_pat_record";
	public static final String ID_EMP_RECORD= "Id_emp_record";
	public static final String FG_RECORD_BLOODTP= "Fg_record_bloodtp";
	public static final String ID_EMP_BLDCHECK= "Id_emp_bldcheck";
	public static final String ID_BLOOD_TYPE= "Id_blood_type";
	public static final String SD_BLOOD_TYPE= "Sd_blood_type";
	public static final String ID_RHD= "Id_rhd";
	public static final String SD_RHD= "Sd_rhd";
	public static final String BLOOD_COMPONENT= "Blood_component";
	public static final String BLOOD_VOLUME= "Blood_volume";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String DT_RECORD= "Dt_record";
	public static final String NV_T= "Nv_t";
	public static final String INT_PULSE= "Int_pulse";
	public static final String INT_BREATHING= "Int_breathing";
	public static final String INT_SBP= "Int_sbp";
	public static final String INT_DBP= "Int_dbp";
	public static final String NAME_OCNM= "Name_ocnm";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_CREATE= "Dt_create";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_EMP_DUTY= "Name_emp_duty";
	public static final String NAME_BLOOD_INFO= "Name_blood_info";
	public static final String NAME_EMP_BLOCHECK= "Name_emp_blocheck";
	public static final String NAME_EMP_BLDCHECK= "Name_emp_bldcheck";
	public static final String NAME_BLOOD_TYPE= "Name_blood_type";
	public static final String NAME_RHD= "Name_rhd";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_blood_transf() {
		return ((String) getAttrVal("Id_blood_transf"));
	}	
	public void setId_blood_transf(String Id_blood_transf) {
		setAttrVal("Id_blood_transf", Id_blood_transf);
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
	public FBoolean getFg_record_bag() {
		return ((FBoolean) getAttrVal("Fg_record_bag"));
	}	
	public void setFg_record_bag(FBoolean Fg_record_bag) {
		setAttrVal("Fg_record_bag", Fg_record_bag);
	}
	public String getId_emp_duty() {
		return ((String) getAttrVal("Id_emp_duty"));
	}	
	public void setId_emp_duty(String Id_emp_duty) {
		setAttrVal("Id_emp_duty", Id_emp_duty);
	}
	public String getId_blood_info() {
		return ((String) getAttrVal("Id_blood_info"));
	}	
	public void setId_blood_info(String Id_blood_info) {
		setAttrVal("Id_blood_info", Id_blood_info);
	}
	public String getSd_blood_info() {
		return ((String) getAttrVal("Sd_blood_info"));
	}	
	public void setSd_blood_info(String Sd_blood_info) {
		setAttrVal("Sd_blood_info", Sd_blood_info);
	}
	public String getId_emp_blocheck() {
		return ((String) getAttrVal("Id_emp_blocheck"));
	}	
	public void setId_emp_blocheck(String Id_emp_blocheck) {
		setAttrVal("Id_emp_blocheck", Id_emp_blocheck);
	}
	public FBoolean getFg_pat_record() {
		return ((FBoolean) getAttrVal("Fg_pat_record"));
	}	
	public void setFg_pat_record(FBoolean Fg_pat_record) {
		setAttrVal("Fg_pat_record", Fg_pat_record);
	}
	public String getId_emp_record() {
		return ((String) getAttrVal("Id_emp_record"));
	}	
	public void setId_emp_record(String Id_emp_record) {
		setAttrVal("Id_emp_record", Id_emp_record);
	}
	public FBoolean getFg_record_bloodtp() {
		return ((FBoolean) getAttrVal("Fg_record_bloodtp"));
	}	
	public void setFg_record_bloodtp(FBoolean Fg_record_bloodtp) {
		setAttrVal("Fg_record_bloodtp", Fg_record_bloodtp);
	}
	public String getId_emp_bldcheck() {
		return ((String) getAttrVal("Id_emp_bldcheck"));
	}	
	public void setId_emp_bldcheck(String Id_emp_bldcheck) {
		setAttrVal("Id_emp_bldcheck", Id_emp_bldcheck);
	}
	public String getId_blood_type() {
		return ((String) getAttrVal("Id_blood_type"));
	}	
	public void setId_blood_type(String Id_blood_type) {
		setAttrVal("Id_blood_type", Id_blood_type);
	}
	public String getSd_blood_type() {
		return ((String) getAttrVal("Sd_blood_type"));
	}	
	public void setSd_blood_type(String Sd_blood_type) {
		setAttrVal("Sd_blood_type", Sd_blood_type);
	}
	public String getId_rhd() {
		return ((String) getAttrVal("Id_rhd"));
	}	
	public void setId_rhd(String Id_rhd) {
		setAttrVal("Id_rhd", Id_rhd);
	}
	public String getSd_rhd() {
		return ((String) getAttrVal("Sd_rhd"));
	}	
	public void setSd_rhd(String Sd_rhd) {
		setAttrVal("Sd_rhd", Sd_rhd);
	}
	public String getBlood_component() {
		return ((String) getAttrVal("Blood_component"));
	}	
	public void setBlood_component(String Blood_component) {
		setAttrVal("Blood_component", Blood_component);
	}
	public Integer getBlood_volume() {
		return ((Integer) getAttrVal("Blood_volume"));
	}	
	public void setBlood_volume(Integer Blood_volume) {
		setAttrVal("Blood_volume", Blood_volume);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}	
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
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
	public String getName_emp_duty() {
		return ((String) getAttrVal("Name_emp_duty"));
	}	
	public void setName_emp_duty(String Name_emp_duty) {
		setAttrVal("Name_emp_duty", Name_emp_duty);
	}
	public String getName_blood_info() {
		return ((String) getAttrVal("Name_blood_info"));
	}	
	public void setName_blood_info(String Name_blood_info) {
		setAttrVal("Name_blood_info", Name_blood_info);
	}
	public String getName_emp_blocheck() {
		return ((String) getAttrVal("Name_emp_blocheck"));
	}	
	public void setName_emp_blocheck(String Name_emp_blocheck) {
		setAttrVal("Name_emp_blocheck", Name_emp_blocheck);
	}
	public String getName_emp_bldcheck() {
		return ((String) getAttrVal("Name_emp_bldcheck"));
	}	
	public void setName_emp_bldcheck(String Name_emp_bldcheck) {
		setAttrVal("Name_emp_bldcheck", Name_emp_bldcheck);
	}
	public String getName_blood_type() {
		return ((String) getAttrVal("Name_blood_type"));
	}	
	public void setName_blood_type(String Name_blood_type) {
		setAttrVal("Name_blood_type", Name_blood_type);
	}
	public String getName_rhd() {
		return ((String) getAttrVal("Name_rhd"));
	}	
	public void setName_rhd(String Name_rhd) {
		setAttrVal("Name_rhd", Name_rhd);
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
		return "Id_blood_transf";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BCN_BLOODTRANSF";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BloodTransfNurDODesc.class);
	}
	
}