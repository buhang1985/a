package iih.nmr.pkuf.childnurse.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.childnurse.d.desc.ChildNurseDODesc;
import java.math.BigDecimal;

/**
 * 儿童医院护理记录单 DO数据 
 * 
 */
public class ChildNurseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NURSE= "Id_nurse";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String DIAGNOSIS= "Diagnosis";
	public static final String NAME_PAT= "Name_pat";
	public static final String DT_DATETIME= "Dt_datetime";
	public static final String ID_NUR_LEVEL= "Id_nur_level";
	public static final String SD_NUR_LEVEL= "Sd_nur_level";
	public static final String ID_CONSCIOUS= "Id_conscious";
	public static final String SD_CONSCIOUS= "Sd_conscious";
	public static final String NV_T= "Nv_t";
	public static final String INT_PULSE= "Int_pulse";
	public static final String INT_BREATHING= "Int_breathing";
	public static final String INT_SBP= "Int_sbp";
	public static final String INT_DBP= "Int_dbp";
	public static final String CONSCIOUS= "Conscious";
	public static final String OXYGEN= "Oxygen";
	public static final String ID_SKIN_SITUA= "Id_skin_situa";
	public static final String SD_SKIN_SITUA= "Sd_skin_situa";
	public static final String INFU_AMOUNT= "Infu_amount";
	public static final String DIET= "Diet";
	public static final String DRINK= "Drink";
	public static final String STOOL= "Stool";
	public static final String PEE= "Pee";
	public static final String OTHERS_AMOUNT= "Others_amount";
	public static final String NURSING= "Nursing";
	public static final String ID_NUR= "Id_nur";
	public static final String NURS_SIGN= "Nurs_sign";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_CREATE= "Dt_create";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR_LEVEL= "Name_nur_level";
	public static final String NAME_CONSCIOUS= "Name_conscious";
	public static final String NAME_SKIN_SITUA= "Name_skin_situa";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nurse() {
		return ((String) getAttrVal("Id_nurse"));
	}	
	public void setId_nurse(String Id_nurse) {
		setAttrVal("Id_nurse", Id_nurse);
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
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}	
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public FDateTime getDt_datetime() {
		return ((FDateTime) getAttrVal("Dt_datetime"));
	}	
	public void setDt_datetime(FDateTime Dt_datetime) {
		setAttrVal("Dt_datetime", Dt_datetime);
	}
	public String getId_nur_level() {
		return ((String) getAttrVal("Id_nur_level"));
	}	
	public void setId_nur_level(String Id_nur_level) {
		setAttrVal("Id_nur_level", Id_nur_level);
	}
	public String getSd_nur_level() {
		return ((String) getAttrVal("Sd_nur_level"));
	}	
	public void setSd_nur_level(String Sd_nur_level) {
		setAttrVal("Sd_nur_level", Sd_nur_level);
	}
	public String getId_conscious() {
		return ((String) getAttrVal("Id_conscious"));
	}	
	public void setId_conscious(String Id_conscious) {
		setAttrVal("Id_conscious", Id_conscious);
	}
	public String getSd_conscious() {
		return ((String) getAttrVal("Sd_conscious"));
	}	
	public void setSd_conscious(String Sd_conscious) {
		setAttrVal("Sd_conscious", Sd_conscious);
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
	public FDouble getConscious() {
		return ((FDouble) getAttrVal("Conscious"));
	}	
	public void setConscious(FDouble Conscious) {
		setAttrVal("Conscious", Conscious);
	}
	public FDouble getOxygen() {
		return ((FDouble) getAttrVal("Oxygen"));
	}	
	public void setOxygen(FDouble Oxygen) {
		setAttrVal("Oxygen", Oxygen);
	}
	public String getId_skin_situa() {
		return ((String) getAttrVal("Id_skin_situa"));
	}	
	public void setId_skin_situa(String Id_skin_situa) {
		setAttrVal("Id_skin_situa", Id_skin_situa);
	}
	public String getSd_skin_situa() {
		return ((String) getAttrVal("Sd_skin_situa"));
	}	
	public void setSd_skin_situa(String Sd_skin_situa) {
		setAttrVal("Sd_skin_situa", Sd_skin_situa);
	}
	public Integer getInfu_amount() {
		return ((Integer) getAttrVal("Infu_amount"));
	}	
	public void setInfu_amount(Integer Infu_amount) {
		setAttrVal("Infu_amount", Infu_amount);
	}
	public Integer getDiet() {
		return ((Integer) getAttrVal("Diet"));
	}	
	public void setDiet(Integer Diet) {
		setAttrVal("Diet", Diet);
	}
	public Integer getDrink() {
		return ((Integer) getAttrVal("Drink"));
	}	
	public void setDrink(Integer Drink) {
		setAttrVal("Drink", Drink);
	}
	public Integer getStool() {
		return ((Integer) getAttrVal("Stool"));
	}	
	public void setStool(Integer Stool) {
		setAttrVal("Stool", Stool);
	}
	public Integer getPee() {
		return ((Integer) getAttrVal("Pee"));
	}	
	public void setPee(Integer Pee) {
		setAttrVal("Pee", Pee);
	}
	public Integer getOthers_amount() {
		return ((Integer) getAttrVal("Others_amount"));
	}	
	public void setOthers_amount(Integer Others_amount) {
		setAttrVal("Others_amount", Others_amount);
	}
	public String getNursing() {
		return ((String) getAttrVal("Nursing"));
	}	
	public void setNursing(String Nursing) {
		setAttrVal("Nursing", Nursing);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getNurs_sign() {
		return ((String) getAttrVal("Nurs_sign"));
	}	
	public void setNurs_sign(String Nurs_sign) {
		setAttrVal("Nurs_sign", Nurs_sign);
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
	public String getName_nur_level() {
		return ((String) getAttrVal("Name_nur_level"));
	}	
	public void setName_nur_level(String Name_nur_level) {
		setAttrVal("Name_nur_level", Name_nur_level);
	}
	public String getName_conscious() {
		return ((String) getAttrVal("Name_conscious"));
	}	
	public void setName_conscious(String Name_conscious) {
		setAttrVal("Name_conscious", Name_conscious);
	}
	public String getName_skin_situa() {
		return ((String) getAttrVal("Name_skin_situa"));
	}	
	public void setName_skin_situa(String Name_skin_situa) {
		setAttrVal("Name_skin_situa", Name_skin_situa);
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
		return "Id_nurse";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_CHILDNURSE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChildNurseDODesc.class);
	}
	
}