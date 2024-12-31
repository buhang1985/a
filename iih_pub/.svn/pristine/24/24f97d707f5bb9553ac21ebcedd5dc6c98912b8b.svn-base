package iih.ci.mr.nu.pedadmcare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.pedadmcare.d.desc.PedadmcareDODesc;
import java.math.BigDecimal;

/**
 * 儿科入院护理评估记录单 DO数据 
 * 
 */
public class PedadmcareDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDADMCARE= "Id_pedadmcare";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String REPRESENTOR= "Representor";
	public static final String RELATIONSHIP= "Relationship";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String TODOCTORTIME= "Todoctortime";
	public static final String CONTACTADDRESS= "Contactaddress";
	public static final String LINKMAN= "Linkman";
	public static final String LINKMANTEL= "Linkmantel";
	public static final String ID_HOSPITALIZEWAY= "Id_hospitalizeway";
	public static final String SD_HOSPITALIZEWAY= "Sd_hospitalizeway";
	public static final String ID_NATION= "Id_nation";
	public static final String ID_EDUC= "Id_educ";
	public static final String FG_ALLERGY= "Fg_allergy";
	public static final String FG_PASTMEDIC= "Fg_pastmedic";
	public static final String OTHER_HOSPITALIZEWAY= "Other_hospitalizeway";
	public static final String REASONSADMISSION= "Reasonsadmission";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String TELEPHONE= "Telephone";
	public static final String ADDRESS= "Address";
	public static final String NAME_ALLERGY= "Name_allergy";
	public static final String NAME_PASTMEDIC= "Name_pastmedic";
	public static final String TEM= "Tem";
	public static final String PAULSE= "Paulse";
	public static final String BREATH= "Breath";
	public static final String WEIGHT= "Weight";
	public static final String SYS_PRE= "Sys_pre";
	public static final String DIA_PRE= "Dia_pre";
	public static final String ID_CONSCIOUSNESS= "Id_consciousness";
	public static final String SD_CONSCIOUSNESS= "Sd_consciousness";
	public static final String OTHER_CONSCIOUSNESS= "Other_consciousness";
	public static final String ID_EMOTIONALSTATUS= "Id_emotionalstatus";
	public static final String SD_EMOTIONALSTATUS= "Sd_emotionalstatus";
	public static final String OTHER_EMOTIONAL= "Other_emotional";
	public static final String ID_LANGUAGEABILITY= "Id_languageability";
	public static final String SD_LANGUAGEABILITY= "Sd_languageability";
	public static final String ID_FONTANELLE= "Id_fontanelle";
	public static final String SD_FONTANELLE= "Sd_fontanelle";
	public static final String ID_LIPS= "Id_lips";
	public static final String SD_LIPS= "Sd_lips";
	public static final String OTHER_LIPS= "Other_lips";
	public static final String ID_ORALMUCOSA= "Id_oralmucosa";
	public static final String SD_ORALMUCOSA= "Sd_oralmucosa";
	public static final String OTHER_ORALMUCOSA= "Other_oralmucosa";
	public static final String ID_SKIN= "Id_skin";
	public static final String SD_SKIN= "Sd_skin";
	public static final String OTHER_SKIN= "Other_skin";
	public static final String ID_LIMB= "Id_limb";
	public static final String SD_LIMB= "Sd_limb";
	public static final String ID_PEEEXCRETION= "Id_peeexcretion";
	public static final String SD_PEEEXCRETION= "Sd_peeexcretion";
	public static final String OTHER_PEEEXCRETION= "Other_peeexcretion";
	public static final String ID_SHITEXCRETION= "Id_shitexcretion";
	public static final String SD_SHITEXCRETION= "Sd_shitexcretion";
	public static final String OTHER_SHIT= "Other_shit";
	public static final String ADLSCORE= "Adlscore";
	public static final String BRADEN_QSCORE= "Braden_qscore";
	public static final String FALLBEDSCORE= "Fallbedscore";
	public static final String PIPESLIPPAGESTORE= "Pipeslippagestore";
	public static final String ID_SLEEPHABIT= "Id_sleephabit";
	public static final String SD_SLEEPHABIT= "Sd_sleephabit";
	public static final String OTHER_SLEEPHABIT= "Other_sleephabit";
	public static final String NAME_OTHER_TONGUE= "Name_other_tongue";
	public static final String NAME_OTHER_TONGUECOAT= "Name_other_tonguecoat";
	public static final String ID_TONGUE= "Id_tongue";
	public static final String SD_TONGUE= "Sd_tongue";
	public static final String ID_TONGUE_COAT= "Id_tongue_coat";
	public static final String SD_TONGUE_COAT= "Sd_tongue_coat";
	public static final String ID_EATHABIT= "Id_eathabit";
	public static final String SD_EATHABIT= "Sd_eathabit";
	public static final String OTHER_EAT= "Other_eat";
	public static final String ID_FAMILYATTITUDE= "Id_familyattitude";
	public static final String SD_FAMILYATTITUDE= "Sd_familyattitude";
	public static final String ID_HOSPITALEDUCATION= "Id_hospitaleducation";
	public static final String SD_HOSPITALEDUCATION= "Sd_hospitaleducation";
	public static final String OTHER_HOSPITALEDUCA= "Other_hospitaleduca";
	public static final String NURSINGPLAN= "Nursingplan";
	public static final String EVALUATIONTIME= "Evaluationtime";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_HOSPITALIZEWAY= "Name_hospitalizeway";
	public static final String NAME_NATION= "Name_nation";
	public static final String NAME_EDUC= "Name_educ";
	public static final String NAME_CONSCIOUSNESS= "Name_consciousness";
	public static final String NAME_EMOTIONALSTATUS= "Name_emotionalstatus";
	public static final String NAME_LANGUAGEABILITY= "Name_languageability";
	public static final String NAME_FONTANELLE= "Name_fontanelle";
	public static final String NAME_LIPS= "Name_lips";
	public static final String NAME_ORALMUCOSA= "Name_oralmucosa";
	public static final String NAME_SKIN= "Name_skin";
	public static final String NAME_LIMB= "Name_limb";
	public static final String NAME_PEEEXCRETION= "Name_peeexcretion";
	public static final String NAME_SHITEXCRETION= "Name_shitexcretion";
	public static final String NAME_SLEEPHABIT= "Name_sleephabit";
	public static final String NAME_TONGUE= "Name_tongue";
	public static final String NAME_TONGUE_COAT= "Name_tongue_coat";
	public static final String NAME_EATHABIT= "Name_eathabit";
	public static final String NAME_FAMILYATTITUDE= "Name_familyattitude";
	public static final String NAME_HOSPITALEDUCATION= "Name_hospitaleducation";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedadmcare() {
		return ((String) getAttrVal("Id_pedadmcare"));
	}	
	public void setId_pedadmcare(String Id_pedadmcare) {
		setAttrVal("Id_pedadmcare", Id_pedadmcare);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
	public String getRepresentor() {
		return ((String) getAttrVal("Representor"));
	}	
	public void setRepresentor(String Representor) {
		setAttrVal("Representor", Representor);
	}
	public String getRelationship() {
		return ((String) getAttrVal("Relationship"));
	}	
	public void setRelationship(String Relationship) {
		setAttrVal("Relationship", Relationship);
	}
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public FDateTime getTodoctortime() {
		return ((FDateTime) getAttrVal("Todoctortime"));
	}	
	public void setTodoctortime(FDateTime Todoctortime) {
		setAttrVal("Todoctortime", Todoctortime);
	}
	public String getContactaddress() {
		return ((String) getAttrVal("Contactaddress"));
	}	
	public void setContactaddress(String Contactaddress) {
		setAttrVal("Contactaddress", Contactaddress);
	}
	public String getLinkman() {
		return ((String) getAttrVal("Linkman"));
	}	
	public void setLinkman(String Linkman) {
		setAttrVal("Linkman", Linkman);
	}
	public String getLinkmantel() {
		return ((String) getAttrVal("Linkmantel"));
	}	
	public void setLinkmantel(String Linkmantel) {
		setAttrVal("Linkmantel", Linkmantel);
	}
	public String getId_hospitalizeway() {
		return ((String) getAttrVal("Id_hospitalizeway"));
	}	
	public void setId_hospitalizeway(String Id_hospitalizeway) {
		setAttrVal("Id_hospitalizeway", Id_hospitalizeway);
	}
	public String getSd_hospitalizeway() {
		return ((String) getAttrVal("Sd_hospitalizeway"));
	}	
	public void setSd_hospitalizeway(String Sd_hospitalizeway) {
		setAttrVal("Sd_hospitalizeway", Sd_hospitalizeway);
	}
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}	
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
	}
	public FBoolean getFg_allergy() {
		return ((FBoolean) getAttrVal("Fg_allergy"));
	}	
	public void setFg_allergy(FBoolean Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	public FBoolean getFg_pastmedic() {
		return ((FBoolean) getAttrVal("Fg_pastmedic"));
	}	
	public void setFg_pastmedic(FBoolean Fg_pastmedic) {
		setAttrVal("Fg_pastmedic", Fg_pastmedic);
	}
	public String getOther_hospitalizeway() {
		return ((String) getAttrVal("Other_hospitalizeway"));
	}	
	public void setOther_hospitalizeway(String Other_hospitalizeway) {
		setAttrVal("Other_hospitalizeway", Other_hospitalizeway);
	}
	public String getReasonsadmission() {
		return ((String) getAttrVal("Reasonsadmission"));
	}	
	public void setReasonsadmission(String Reasonsadmission) {
		setAttrVal("Reasonsadmission", Reasonsadmission);
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
	public String getTelephone() {
		return ((String) getAttrVal("Telephone"));
	}	
	public void setTelephone(String Telephone) {
		setAttrVal("Telephone", Telephone);
	}
	public String getAddress() {
		return ((String) getAttrVal("Address"));
	}	
	public void setAddress(String Address) {
		setAttrVal("Address", Address);
	}
	public String getName_allergy() {
		return ((String) getAttrVal("Name_allergy"));
	}	
	public void setName_allergy(String Name_allergy) {
		setAttrVal("Name_allergy", Name_allergy);
	}
	public String getName_pastmedic() {
		return ((String) getAttrVal("Name_pastmedic"));
	}	
	public void setName_pastmedic(String Name_pastmedic) {
		setAttrVal("Name_pastmedic", Name_pastmedic);
	}
	public FDouble getTem() {
		return ((FDouble) getAttrVal("Tem"));
	}	
	public void setTem(FDouble Tem) {
		setAttrVal("Tem", Tem);
	}
	public Integer getPaulse() {
		return ((Integer) getAttrVal("Paulse"));
	}	
	public void setPaulse(Integer Paulse) {
		setAttrVal("Paulse", Paulse);
	}
	public Integer getBreath() {
		return ((Integer) getAttrVal("Breath"));
	}	
	public void setBreath(Integer Breath) {
		setAttrVal("Breath", Breath);
	}
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public Integer getSys_pre() {
		return ((Integer) getAttrVal("Sys_pre"));
	}	
	public void setSys_pre(Integer Sys_pre) {
		setAttrVal("Sys_pre", Sys_pre);
	}
	public Integer getDia_pre() {
		return ((Integer) getAttrVal("Dia_pre"));
	}	
	public void setDia_pre(Integer Dia_pre) {
		setAttrVal("Dia_pre", Dia_pre);
	}
	public String getId_consciousness() {
		return ((String) getAttrVal("Id_consciousness"));
	}	
	public void setId_consciousness(String Id_consciousness) {
		setAttrVal("Id_consciousness", Id_consciousness);
	}
	public String getSd_consciousness() {
		return ((String) getAttrVal("Sd_consciousness"));
	}	
	public void setSd_consciousness(String Sd_consciousness) {
		setAttrVal("Sd_consciousness", Sd_consciousness);
	}
	public String getOther_consciousness() {
		return ((String) getAttrVal("Other_consciousness"));
	}	
	public void setOther_consciousness(String Other_consciousness) {
		setAttrVal("Other_consciousness", Other_consciousness);
	}
	public String getId_emotionalstatus() {
		return ((String) getAttrVal("Id_emotionalstatus"));
	}	
	public void setId_emotionalstatus(String Id_emotionalstatus) {
		setAttrVal("Id_emotionalstatus", Id_emotionalstatus);
	}
	public String getSd_emotionalstatus() {
		return ((String) getAttrVal("Sd_emotionalstatus"));
	}	
	public void setSd_emotionalstatus(String Sd_emotionalstatus) {
		setAttrVal("Sd_emotionalstatus", Sd_emotionalstatus);
	}
	public String getOther_emotional() {
		return ((String) getAttrVal("Other_emotional"));
	}	
	public void setOther_emotional(String Other_emotional) {
		setAttrVal("Other_emotional", Other_emotional);
	}
	public String getId_languageability() {
		return ((String) getAttrVal("Id_languageability"));
	}	
	public void setId_languageability(String Id_languageability) {
		setAttrVal("Id_languageability", Id_languageability);
	}
	public String getSd_languageability() {
		return ((String) getAttrVal("Sd_languageability"));
	}	
	public void setSd_languageability(String Sd_languageability) {
		setAttrVal("Sd_languageability", Sd_languageability);
	}
	public String getId_fontanelle() {
		return ((String) getAttrVal("Id_fontanelle"));
	}	
	public void setId_fontanelle(String Id_fontanelle) {
		setAttrVal("Id_fontanelle", Id_fontanelle);
	}
	public String getSd_fontanelle() {
		return ((String) getAttrVal("Sd_fontanelle"));
	}	
	public void setSd_fontanelle(String Sd_fontanelle) {
		setAttrVal("Sd_fontanelle", Sd_fontanelle);
	}
	public String getId_lips() {
		return ((String) getAttrVal("Id_lips"));
	}	
	public void setId_lips(String Id_lips) {
		setAttrVal("Id_lips", Id_lips);
	}
	public String getSd_lips() {
		return ((String) getAttrVal("Sd_lips"));
	}	
	public void setSd_lips(String Sd_lips) {
		setAttrVal("Sd_lips", Sd_lips);
	}
	public String getOther_lips() {
		return ((String) getAttrVal("Other_lips"));
	}	
	public void setOther_lips(String Other_lips) {
		setAttrVal("Other_lips", Other_lips);
	}
	public String getId_oralmucosa() {
		return ((String) getAttrVal("Id_oralmucosa"));
	}	
	public void setId_oralmucosa(String Id_oralmucosa) {
		setAttrVal("Id_oralmucosa", Id_oralmucosa);
	}
	public String getSd_oralmucosa() {
		return ((String) getAttrVal("Sd_oralmucosa"));
	}	
	public void setSd_oralmucosa(String Sd_oralmucosa) {
		setAttrVal("Sd_oralmucosa", Sd_oralmucosa);
	}
	public String getOther_oralmucosa() {
		return ((String) getAttrVal("Other_oralmucosa"));
	}	
	public void setOther_oralmucosa(String Other_oralmucosa) {
		setAttrVal("Other_oralmucosa", Other_oralmucosa);
	}
	public String getId_skin() {
		return ((String) getAttrVal("Id_skin"));
	}	
	public void setId_skin(String Id_skin) {
		setAttrVal("Id_skin", Id_skin);
	}
	public String getSd_skin() {
		return ((String) getAttrVal("Sd_skin"));
	}	
	public void setSd_skin(String Sd_skin) {
		setAttrVal("Sd_skin", Sd_skin);
	}
	public String getOther_skin() {
		return ((String) getAttrVal("Other_skin"));
	}	
	public void setOther_skin(String Other_skin) {
		setAttrVal("Other_skin", Other_skin);
	}
	public String getId_limb() {
		return ((String) getAttrVal("Id_limb"));
	}	
	public void setId_limb(String Id_limb) {
		setAttrVal("Id_limb", Id_limb);
	}
	public String getSd_limb() {
		return ((String) getAttrVal("Sd_limb"));
	}	
	public void setSd_limb(String Sd_limb) {
		setAttrVal("Sd_limb", Sd_limb);
	}
	public String getId_peeexcretion() {
		return ((String) getAttrVal("Id_peeexcretion"));
	}	
	public void setId_peeexcretion(String Id_peeexcretion) {
		setAttrVal("Id_peeexcretion", Id_peeexcretion);
	}
	public String getSd_peeexcretion() {
		return ((String) getAttrVal("Sd_peeexcretion"));
	}	
	public void setSd_peeexcretion(String Sd_peeexcretion) {
		setAttrVal("Sd_peeexcretion", Sd_peeexcretion);
	}
	public String getOther_peeexcretion() {
		return ((String) getAttrVal("Other_peeexcretion"));
	}	
	public void setOther_peeexcretion(String Other_peeexcretion) {
		setAttrVal("Other_peeexcretion", Other_peeexcretion);
	}
	public String getId_shitexcretion() {
		return ((String) getAttrVal("Id_shitexcretion"));
	}	
	public void setId_shitexcretion(String Id_shitexcretion) {
		setAttrVal("Id_shitexcretion", Id_shitexcretion);
	}
	public String getSd_shitexcretion() {
		return ((String) getAttrVal("Sd_shitexcretion"));
	}	
	public void setSd_shitexcretion(String Sd_shitexcretion) {
		setAttrVal("Sd_shitexcretion", Sd_shitexcretion);
	}
	public String getOther_shit() {
		return ((String) getAttrVal("Other_shit"));
	}	
	public void setOther_shit(String Other_shit) {
		setAttrVal("Other_shit", Other_shit);
	}
	public FDouble getAdlscore() {
		return ((FDouble) getAttrVal("Adlscore"));
	}	
	public void setAdlscore(FDouble Adlscore) {
		setAttrVal("Adlscore", Adlscore);
	}
	public FDouble getBraden_qscore() {
		return ((FDouble) getAttrVal("Braden_qscore"));
	}	
	public void setBraden_qscore(FDouble Braden_qscore) {
		setAttrVal("Braden_qscore", Braden_qscore);
	}
	public FDouble getFallbedscore() {
		return ((FDouble) getAttrVal("Fallbedscore"));
	}	
	public void setFallbedscore(FDouble Fallbedscore) {
		setAttrVal("Fallbedscore", Fallbedscore);
	}
	public FDouble getPipeslippagestore() {
		return ((FDouble) getAttrVal("Pipeslippagestore"));
	}	
	public void setPipeslippagestore(FDouble Pipeslippagestore) {
		setAttrVal("Pipeslippagestore", Pipeslippagestore);
	}
	public String getId_sleephabit() {
		return ((String) getAttrVal("Id_sleephabit"));
	}	
	public void setId_sleephabit(String Id_sleephabit) {
		setAttrVal("Id_sleephabit", Id_sleephabit);
	}
	public String getSd_sleephabit() {
		return ((String) getAttrVal("Sd_sleephabit"));
	}	
	public void setSd_sleephabit(String Sd_sleephabit) {
		setAttrVal("Sd_sleephabit", Sd_sleephabit);
	}
	public String getOther_sleephabit() {
		return ((String) getAttrVal("Other_sleephabit"));
	}	
	public void setOther_sleephabit(String Other_sleephabit) {
		setAttrVal("Other_sleephabit", Other_sleephabit);
	}
	public String getName_other_tongue() {
		return ((String) getAttrVal("Name_other_tongue"));
	}	
	public void setName_other_tongue(String Name_other_tongue) {
		setAttrVal("Name_other_tongue", Name_other_tongue);
	}
	public String getName_other_tonguecoat() {
		return ((String) getAttrVal("Name_other_tonguecoat"));
	}	
	public void setName_other_tonguecoat(String Name_other_tonguecoat) {
		setAttrVal("Name_other_tonguecoat", Name_other_tonguecoat);
	}
	public String getId_tongue() {
		return ((String) getAttrVal("Id_tongue"));
	}	
	public void setId_tongue(String Id_tongue) {
		setAttrVal("Id_tongue", Id_tongue);
	}
	public String getSd_tongue() {
		return ((String) getAttrVal("Sd_tongue"));
	}	
	public void setSd_tongue(String Sd_tongue) {
		setAttrVal("Sd_tongue", Sd_tongue);
	}
	public String getId_tongue_coat() {
		return ((String) getAttrVal("Id_tongue_coat"));
	}	
	public void setId_tongue_coat(String Id_tongue_coat) {
		setAttrVal("Id_tongue_coat", Id_tongue_coat);
	}
	public String getSd_tongue_coat() {
		return ((String) getAttrVal("Sd_tongue_coat"));
	}	
	public void setSd_tongue_coat(String Sd_tongue_coat) {
		setAttrVal("Sd_tongue_coat", Sd_tongue_coat);
	}
	public String getId_eathabit() {
		return ((String) getAttrVal("Id_eathabit"));
	}	
	public void setId_eathabit(String Id_eathabit) {
		setAttrVal("Id_eathabit", Id_eathabit);
	}
	public String getSd_eathabit() {
		return ((String) getAttrVal("Sd_eathabit"));
	}	
	public void setSd_eathabit(String Sd_eathabit) {
		setAttrVal("Sd_eathabit", Sd_eathabit);
	}
	public String getOther_eat() {
		return ((String) getAttrVal("Other_eat"));
	}	
	public void setOther_eat(String Other_eat) {
		setAttrVal("Other_eat", Other_eat);
	}
	public String getId_familyattitude() {
		return ((String) getAttrVal("Id_familyattitude"));
	}	
	public void setId_familyattitude(String Id_familyattitude) {
		setAttrVal("Id_familyattitude", Id_familyattitude);
	}
	public String getSd_familyattitude() {
		return ((String) getAttrVal("Sd_familyattitude"));
	}	
	public void setSd_familyattitude(String Sd_familyattitude) {
		setAttrVal("Sd_familyattitude", Sd_familyattitude);
	}
	public String getId_hospitaleducation() {
		return ((String) getAttrVal("Id_hospitaleducation"));
	}	
	public void setId_hospitaleducation(String Id_hospitaleducation) {
		setAttrVal("Id_hospitaleducation", Id_hospitaleducation);
	}
	public String getSd_hospitaleducation() {
		return ((String) getAttrVal("Sd_hospitaleducation"));
	}	
	public void setSd_hospitaleducation(String Sd_hospitaleducation) {
		setAttrVal("Sd_hospitaleducation", Sd_hospitaleducation);
	}
	public String getOther_hospitaleduca() {
		return ((String) getAttrVal("Other_hospitaleduca"));
	}	
	public void setOther_hospitaleduca(String Other_hospitaleduca) {
		setAttrVal("Other_hospitaleduca", Other_hospitaleduca);
	}
	public String getNursingplan() {
		return ((String) getAttrVal("Nursingplan"));
	}	
	public void setNursingplan(String Nursingplan) {
		setAttrVal("Nursingplan", Nursingplan);
	}
	public FDateTime getEvaluationtime() {
		return ((FDateTime) getAttrVal("Evaluationtime"));
	}	
	public void setEvaluationtime(FDateTime Evaluationtime) {
		setAttrVal("Evaluationtime", Evaluationtime);
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
	public String getName_hospitalizeway() {
		return ((String) getAttrVal("Name_hospitalizeway"));
	}	
	public void setName_hospitalizeway(String Name_hospitalizeway) {
		setAttrVal("Name_hospitalizeway", Name_hospitalizeway);
	}
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	public String getName_educ() {
		return ((String) getAttrVal("Name_educ"));
	}	
	public void setName_educ(String Name_educ) {
		setAttrVal("Name_educ", Name_educ);
	}
	public String getName_consciousness() {
		return ((String) getAttrVal("Name_consciousness"));
	}	
	public void setName_consciousness(String Name_consciousness) {
		setAttrVal("Name_consciousness", Name_consciousness);
	}
	public String getName_emotionalstatus() {
		return ((String) getAttrVal("Name_emotionalstatus"));
	}	
	public void setName_emotionalstatus(String Name_emotionalstatus) {
		setAttrVal("Name_emotionalstatus", Name_emotionalstatus);
	}
	public String getName_languageability() {
		return ((String) getAttrVal("Name_languageability"));
	}	
	public void setName_languageability(String Name_languageability) {
		setAttrVal("Name_languageability", Name_languageability);
	}
	public String getName_fontanelle() {
		return ((String) getAttrVal("Name_fontanelle"));
	}	
	public void setName_fontanelle(String Name_fontanelle) {
		setAttrVal("Name_fontanelle", Name_fontanelle);
	}
	public String getName_lips() {
		return ((String) getAttrVal("Name_lips"));
	}	
	public void setName_lips(String Name_lips) {
		setAttrVal("Name_lips", Name_lips);
	}
	public String getName_oralmucosa() {
		return ((String) getAttrVal("Name_oralmucosa"));
	}	
	public void setName_oralmucosa(String Name_oralmucosa) {
		setAttrVal("Name_oralmucosa", Name_oralmucosa);
	}
	public String getName_skin() {
		return ((String) getAttrVal("Name_skin"));
	}	
	public void setName_skin(String Name_skin) {
		setAttrVal("Name_skin", Name_skin);
	}
	public String getName_limb() {
		return ((String) getAttrVal("Name_limb"));
	}	
	public void setName_limb(String Name_limb) {
		setAttrVal("Name_limb", Name_limb);
	}
	public String getName_peeexcretion() {
		return ((String) getAttrVal("Name_peeexcretion"));
	}	
	public void setName_peeexcretion(String Name_peeexcretion) {
		setAttrVal("Name_peeexcretion", Name_peeexcretion);
	}
	public String getName_shitexcretion() {
		return ((String) getAttrVal("Name_shitexcretion"));
	}	
	public void setName_shitexcretion(String Name_shitexcretion) {
		setAttrVal("Name_shitexcretion", Name_shitexcretion);
	}
	public String getName_sleephabit() {
		return ((String) getAttrVal("Name_sleephabit"));
	}	
	public void setName_sleephabit(String Name_sleephabit) {
		setAttrVal("Name_sleephabit", Name_sleephabit);
	}
	public String getName_tongue() {
		return ((String) getAttrVal("Name_tongue"));
	}	
	public void setName_tongue(String Name_tongue) {
		setAttrVal("Name_tongue", Name_tongue);
	}
	public String getName_tongue_coat() {
		return ((String) getAttrVal("Name_tongue_coat"));
	}	
	public void setName_tongue_coat(String Name_tongue_coat) {
		setAttrVal("Name_tongue_coat", Name_tongue_coat);
	}
	public String getName_eathabit() {
		return ((String) getAttrVal("Name_eathabit"));
	}	
	public void setName_eathabit(String Name_eathabit) {
		setAttrVal("Name_eathabit", Name_eathabit);
	}
	public String getName_familyattitude() {
		return ((String) getAttrVal("Name_familyattitude"));
	}	
	public void setName_familyattitude(String Name_familyattitude) {
		setAttrVal("Name_familyattitude", Name_familyattitude);
	}
	public String getName_hospitaleducation() {
		return ((String) getAttrVal("Name_hospitaleducation"));
	}	
	public void setName_hospitaleducation(String Name_hospitaleducation) {
		setAttrVal("Name_hospitaleducation", Name_hospitaleducation);
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
		return "Id_pedadmcare";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_pedadmcare";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PedadmcareDODesc.class);
	}
	
}