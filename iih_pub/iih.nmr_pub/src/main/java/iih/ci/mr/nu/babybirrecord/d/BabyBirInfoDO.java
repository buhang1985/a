package iih.ci.mr.nu.babybirrecord.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.babybirrecord.d.desc.BabyBirInfoDODesc;
import java.math.BigDecimal;

/**
 * 婴儿信息 DO数据 
 * 
 */
public class BabyBirInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BABYINFO= "Id_babyinfo";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String AGE= "Age";
	public static final String HEIGHT= "Height";
	public static final String GENITALS= "Genitals";
	public static final String ANUS= "Anus";
	public static final String LIMB= "Limb";
	public static final String DES_REMARKS= "Des_remarks";
	public static final String DES_BABY_ENTRY= "Des_baby_entry";
	public static final String MIDWIFE= "Midwife";
	public static final String ID_SIGNATURE= "Id_signature";
	public static final String PARITY= "Parity";
	public static final String PREGNANT= "Pregnant";
	public static final String WEIGHT= "Weight";
	public static final String BUST= "Bust";
	public static final String HEAD_CIR= "Head_cir";
	public static final String ENUMDEFORMITY= "Enumdeformity";
	public static final String ENUMDEOBJHISTORY= "Enumdeobjhistory";
	public static final String MONTHS= "Months";
	public static final String ENUMDEFAMHISTORY= "Enumdefamhistory";
	public static final String ENUMPER_CARD= "Enumper_card";
	public static final String ID_UMB_CORD= "Id_umb_cord";
	public static final String SD_UMB_CORD= "Sd_umb_cord";
	public static final String NAME_MOM= "Name_mom";
	public static final String NAME_SEX= "Name_sex";
	public static final String DT_CHILD_BIRTH= "Dt_child_birth";
	public static final String ID_OWNERSHIP_TYPE= "Id_ownership_type";
	public static final String SD_OWNERSHIP_TYPE= "Sd_ownership_type";
	public static final String ID_PRO_SIT= "Id_pro_sit";
	public static final String SD_PRO_SIT= "Sd_pro_sit";
	public static final String ID_BLOOD_CIR= "Id_blood_cir";
	public static final String SD_BLOOD_CIR= "Sd_blood_cir";
	public static final String ID_ASPHYXIA= "Id_asphyxia";
	public static final String SD_ASPHYXIA= "Sd_asphyxia";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MIDWIFE= "Name_midwife";
	public static final String NAME_SIGNATURE= "Name_signature";
	public static final String NAME_UMB_CORD= "Name_umb_cord";
	public static final String NAME_OWNERSHIP_TYPE= "Name_ownership_type";
	public static final String NAME_PRO_SIT= "Name_pro_sit";
	public static final String NAME_BLOOD_CIR= "Name_blood_cir";
	public static final String NAME_ASPHYXIA= "Name_asphyxia";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_babyinfo() {
		return ((String) getAttrVal("Id_babyinfo"));
	}	
	public void setId_babyinfo(String Id_babyinfo) {
		setAttrVal("Id_babyinfo", Id_babyinfo);
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
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}	
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	public String getGenitals() {
		return ((String) getAttrVal("Genitals"));
	}	
	public void setGenitals(String Genitals) {
		setAttrVal("Genitals", Genitals);
	}
	public String getAnus() {
		return ((String) getAttrVal("Anus"));
	}	
	public void setAnus(String Anus) {
		setAttrVal("Anus", Anus);
	}
	public String getLimb() {
		return ((String) getAttrVal("Limb"));
	}	
	public void setLimb(String Limb) {
		setAttrVal("Limb", Limb);
	}
	public String getDes_remarks() {
		return ((String) getAttrVal("Des_remarks"));
	}	
	public void setDes_remarks(String Des_remarks) {
		setAttrVal("Des_remarks", Des_remarks);
	}
	public String getDes_baby_entry() {
		return ((String) getAttrVal("Des_baby_entry"));
	}	
	public void setDes_baby_entry(String Des_baby_entry) {
		setAttrVal("Des_baby_entry", Des_baby_entry);
	}
	public String getMidwife() {
		return ((String) getAttrVal("Midwife"));
	}	
	public void setMidwife(String Midwife) {
		setAttrVal("Midwife", Midwife);
	}
	public String getId_signature() {
		return ((String) getAttrVal("Id_signature"));
	}	
	public void setId_signature(String Id_signature) {
		setAttrVal("Id_signature", Id_signature);
	}
	public Integer getParity() {
		return ((Integer) getAttrVal("Parity"));
	}	
	public void setParity(Integer Parity) {
		setAttrVal("Parity", Parity);
	}
	public Integer getPregnant() {
		return ((Integer) getAttrVal("Pregnant"));
	}	
	public void setPregnant(Integer Pregnant) {
		setAttrVal("Pregnant", Pregnant);
	}
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public FDouble getBust() {
		return ((FDouble) getAttrVal("Bust"));
	}	
	public void setBust(FDouble Bust) {
		setAttrVal("Bust", Bust);
	}
	public FDouble getHead_cir() {
		return ((FDouble) getAttrVal("Head_cir"));
	}	
	public void setHead_cir(FDouble Head_cir) {
		setAttrVal("Head_cir", Head_cir);
	}
	public Integer getEnumdeformity() {
		return ((Integer) getAttrVal("Enumdeformity"));
	}	
	public void setEnumdeformity(Integer Enumdeformity) {
		setAttrVal("Enumdeformity", Enumdeformity);
	}
	public Integer getEnumdeobjhistory() {
		return ((Integer) getAttrVal("Enumdeobjhistory"));
	}	
	public void setEnumdeobjhistory(Integer Enumdeobjhistory) {
		setAttrVal("Enumdeobjhistory", Enumdeobjhistory);
	}
	public Integer getMonths() {
		return ((Integer) getAttrVal("Months"));
	}	
	public void setMonths(Integer Months) {
		setAttrVal("Months", Months);
	}
	public Integer getEnumdefamhistory() {
		return ((Integer) getAttrVal("Enumdefamhistory"));
	}	
	public void setEnumdefamhistory(Integer Enumdefamhistory) {
		setAttrVal("Enumdefamhistory", Enumdefamhistory);
	}
	public Integer getEnumper_card() {
		return ((Integer) getAttrVal("Enumper_card"));
	}	
	public void setEnumper_card(Integer Enumper_card) {
		setAttrVal("Enumper_card", Enumper_card);
	}
	public String getId_umb_cord() {
		return ((String) getAttrVal("Id_umb_cord"));
	}	
	public void setId_umb_cord(String Id_umb_cord) {
		setAttrVal("Id_umb_cord", Id_umb_cord);
	}
	public String getSd_umb_cord() {
		return ((String) getAttrVal("Sd_umb_cord"));
	}	
	public void setSd_umb_cord(String Sd_umb_cord) {
		setAttrVal("Sd_umb_cord", Sd_umb_cord);
	}
	public String getName_mom() {
		return ((String) getAttrVal("Name_mom"));
	}	
	public void setName_mom(String Name_mom) {
		setAttrVal("Name_mom", Name_mom);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public FDateTime getDt_child_birth() {
		return ((FDateTime) getAttrVal("Dt_child_birth"));
	}	
	public void setDt_child_birth(FDateTime Dt_child_birth) {
		setAttrVal("Dt_child_birth", Dt_child_birth);
	}
	public String getId_ownership_type() {
		return ((String) getAttrVal("Id_ownership_type"));
	}	
	public void setId_ownership_type(String Id_ownership_type) {
		setAttrVal("Id_ownership_type", Id_ownership_type);
	}
	public String getSd_ownership_type() {
		return ((String) getAttrVal("Sd_ownership_type"));
	}	
	public void setSd_ownership_type(String Sd_ownership_type) {
		setAttrVal("Sd_ownership_type", Sd_ownership_type);
	}
	public String getId_pro_sit() {
		return ((String) getAttrVal("Id_pro_sit"));
	}	
	public void setId_pro_sit(String Id_pro_sit) {
		setAttrVal("Id_pro_sit", Id_pro_sit);
	}
	public String getSd_pro_sit() {
		return ((String) getAttrVal("Sd_pro_sit"));
	}	
	public void setSd_pro_sit(String Sd_pro_sit) {
		setAttrVal("Sd_pro_sit", Sd_pro_sit);
	}
	public String getId_blood_cir() {
		return ((String) getAttrVal("Id_blood_cir"));
	}	
	public void setId_blood_cir(String Id_blood_cir) {
		setAttrVal("Id_blood_cir", Id_blood_cir);
	}
	public String getSd_blood_cir() {
		return ((String) getAttrVal("Sd_blood_cir"));
	}	
	public void setSd_blood_cir(String Sd_blood_cir) {
		setAttrVal("Sd_blood_cir", Sd_blood_cir);
	}
	public String getId_asphyxia() {
		return ((String) getAttrVal("Id_asphyxia"));
	}	
	public void setId_asphyxia(String Id_asphyxia) {
		setAttrVal("Id_asphyxia", Id_asphyxia);
	}
	public String getSd_asphyxia() {
		return ((String) getAttrVal("Sd_asphyxia"));
	}	
	public void setSd_asphyxia(String Sd_asphyxia) {
		setAttrVal("Sd_asphyxia", Sd_asphyxia);
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
	public String getName_midwife() {
		return ((String) getAttrVal("Name_midwife"));
	}	
	public void setName_midwife(String Name_midwife) {
		setAttrVal("Name_midwife", Name_midwife);
	}
	public String getName_signature() {
		return ((String) getAttrVal("Name_signature"));
	}	
	public void setName_signature(String Name_signature) {
		setAttrVal("Name_signature", Name_signature);
	}
	public String getName_umb_cord() {
		return ((String) getAttrVal("Name_umb_cord"));
	}	
	public void setName_umb_cord(String Name_umb_cord) {
		setAttrVal("Name_umb_cord", Name_umb_cord);
	}
	public String getName_ownership_type() {
		return ((String) getAttrVal("Name_ownership_type"));
	}	
	public void setName_ownership_type(String Name_ownership_type) {
		setAttrVal("Name_ownership_type", Name_ownership_type);
	}
	public String getName_pro_sit() {
		return ((String) getAttrVal("Name_pro_sit"));
	}	
	public void setName_pro_sit(String Name_pro_sit) {
		setAttrVal("Name_pro_sit", Name_pro_sit);
	}
	public String getName_blood_cir() {
		return ((String) getAttrVal("Name_blood_cir"));
	}	
	public void setName_blood_cir(String Name_blood_cir) {
		setAttrVal("Name_blood_cir", Name_blood_cir);
	}
	public String getName_asphyxia() {
		return ((String) getAttrVal("Name_asphyxia"));
	}	
	public void setName_asphyxia(String Name_asphyxia) {
		setAttrVal("Name_asphyxia", Name_asphyxia);
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
		return "Id_babyinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_babybirinfo";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BabyBirInfoDODesc.class);
	}
	
}