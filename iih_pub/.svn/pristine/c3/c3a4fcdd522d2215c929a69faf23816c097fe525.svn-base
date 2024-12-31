package iih.ci.mr.nu.hemodialycare.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.hemodialycare.d.desc.HemodialycareinfoDODesc;
import java.math.BigDecimal;

/**
 * 血液透析护理记录单 DO数据 
 * 
 */
public class HemodialycareinfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HEMODIALYCARE= "Id_hemodialycare";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String DT_HEMODIALYDAY= "Dt_hemodialyday";
	public static final String NUM_HEMODIALYSIS= "Num_hemodialysis";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String NUM_WEIGHT_DRY= "Num_weight_dry";
	public static final String DT_SETHEMODIALY= "Dt_sethemodialy";
	public static final String DT_RELHEMODIALY= "Dt_relhemodialy";
	public static final String NUM_PRIMEDOSE= "Num_primedose";
	public static final String NUM_MAINTENDOSE= "Num_maintendose";
	public static final String ID_METHOD_ANTICOAGUL= "Id_method_anticoagul";
	public static final String SD_METHOD_ANTICOAGUL= "Sd_method_anticoagul";
	public static final String NUM_WT_PREHEMODIAL= "Num_wt_prehemodial";
	public static final String NUM_WT_AFTHEMODIAL= "Num_wt_afthemodial";
	public static final String NUM_SETDEHYDRA= "Num_setdehydra";
	public static final String NUM_RELDEHYDRA= "Num_reldehydra";
	public static final String NUM_PEE= "Num_pee";
	public static final String EU_EDEMA= "Eu_edema";
	public static final String EU_HEARTFAILURE= "Eu_heartfailure";
	public static final String EU_BLEEDINGTEND= "Eu_bleedingtend";
	public static final String DES_OTH_BLEEDINGTEND= "Des_oth_bleedingtend";
	public static final String NO_DIALYMACHINE= "No_dialymachine";
	public static final String SNO_DIALYMACHINE= "Sno_dialymachine";
	public static final String EU_DIALYZINTACT= "Eu_dialyzintact";
	public static final String EU_DIALYZUSEFUL= "Eu_dialyzuseful";
	public static final String ID_SIGN_DOCTOR= "Id_sign_doctor";
	public static final String NUM_NA= "Num_na";
	public static final String NUM_CA= "Num_ca";
	public static final String NUM_HCO3= "Num_hco3";
	public static final String NUM_FLOW= "Num_flow";
	public static final String ID_VASCULARACCESS= "Id_vascularaccess";
	public static final String SD_VASCULARACCESS= "Sd_vascularaccess";
	public static final String ID_DIALYSISWAY= "Id_dialysisway";
	public static final String SD_DIALYSISWAY= "Sd_dialysisway";
	public static final String DES_OTH_DIALYSISWAY= "Des_oth_dialysisway";
	public static final String NUM_PREREPLACE= "Num_prereplace";
	public static final String NUM_AFTREPLACE= "Num_aftreplace";
	public static final String EU_INTERFISTSMOOTH= "Eu_interfistsmooth";
	public static final String ID_INTERFISTCAUSE= "Id_interfistcause";
	public static final String SD_INTERFISTCAUSE= "Sd_interfistcause";
	public static final String EU_INTERFISTDEFFLOW= "Eu_interfistdefflow";
	public static final String EU_INTERFISTHEMAT= "Eu_interfisthemat";
	public static final String NUM_INTERFISTHEMATLEN= "Num_interfisthematlen";
	public static final String NUM_INTERFISTHEMATWID= "Num_interfisthematwid";
	public static final String NUM_ARTERIOPUNCTURE= "Num_arteriopuncture";
	public static final String NUM_VENIPUNCTURE= "Num_venipuncture";
	public static final String ID_SIGN_IMPALER= "Id_sign_impaler";
	public static final String EU_PULLNEEDLESMOOTH= "Eu_pullneedlesmooth";
	public static final String ID_PULLNEEDLECAUSE= "Id_pullneedlecause";
	public static final String SD_PULLNEEDLECAUSE= "Sd_pullneedlecause";
	public static final String EU_PULLNEEDLERRHYSIS= "Eu_pullneedlerrhysis";
	public static final String EU_PULLNEEDLEHEMAT= "Eu_pullneedlehemat";
	public static final String NUM_PULLNEEDLEMATLEN= "Num_pullneedlematlen";
	public static final String NUM_PULLNEEDLEMATWID= "Num_pullneedlematwid";
	public static final String EU_FISTULATREMOR= "Eu_fistulatremor";
	public static final String EU_NOISE= "Eu_noise";
	public static final String ID_SIGN_UNDERMACHINE= "Id_sign_undermachine";
	public static final String EU_MACHSTOPPAGE= "Eu_machstoppage";
	public static final String SNO_MACHINE= "Sno_machine";
	public static final String ID_TYPE_MACHINE= "Id_type_machine";
	public static final String SD_TYPE_MACHINE= "Sd_type_machine";
	public static final String NAME_OTH_MACHINE= "Name_oth_machine";
	public static final String CAUSE_FAILURE= "Cause_failure";
	public static final String ID_SIGNATURE= "Id_signature";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_METHOD_ANTICOAGUL= "Name_method_anticoagul";
	public static final String NAME_DOCTOR= "Name_doctor";
	public static final String NAME_VASCULARACCESS= "Name_vascularaccess";
	public static final String NAME_DIALYSISWAY= "Name_dialysisway";
	public static final String NAME_INTERFISTCAUSE= "Name_interfistcause";
	public static final String NAME_IMPALER= "Name_impaler";
	public static final String NAME_PULLNEEDLECAUSE= "Name_pullneedlecause";
	public static final String NAME_UNDERMACHINE= "Name_undermachine";
	public static final String NAME_TYPE_MACHINE= "Name_type_machine";
	public static final String NAME_SIGNATURE= "Name_signature";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hemodialycare() {
		return ((String) getAttrVal("Id_hemodialycare"));
	}	
	public void setId_hemodialycare(String Id_hemodialycare) {
		setAttrVal("Id_hemodialycare", Id_hemodialycare);
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
	public FDate getDt_hemodialyday() {
		return ((FDate) getAttrVal("Dt_hemodialyday"));
	}	
	public void setDt_hemodialyday(FDate Dt_hemodialyday) {
		setAttrVal("Dt_hemodialyday", Dt_hemodialyday);
	}
	public Integer getNum_hemodialysis() {
		return ((Integer) getAttrVal("Num_hemodialysis"));
	}	
	public void setNum_hemodialysis(Integer Num_hemodialysis) {
		setAttrVal("Num_hemodialysis", Num_hemodialysis);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
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
	public FDouble getNum_weight_dry() {
		return ((FDouble) getAttrVal("Num_weight_dry"));
	}	
	public void setNum_weight_dry(FDouble Num_weight_dry) {
		setAttrVal("Num_weight_dry", Num_weight_dry);
	}
	public FDouble getDt_sethemodialy() {
		return ((FDouble) getAttrVal("Dt_sethemodialy"));
	}	
	public void setDt_sethemodialy(FDouble Dt_sethemodialy) {
		setAttrVal("Dt_sethemodialy", Dt_sethemodialy);
	}
	public FDouble getDt_relhemodialy() {
		return ((FDouble) getAttrVal("Dt_relhemodialy"));
	}	
	public void setDt_relhemodialy(FDouble Dt_relhemodialy) {
		setAttrVal("Dt_relhemodialy", Dt_relhemodialy);
	}
	public FDouble getNum_primedose() {
		return ((FDouble) getAttrVal("Num_primedose"));
	}	
	public void setNum_primedose(FDouble Num_primedose) {
		setAttrVal("Num_primedose", Num_primedose);
	}
	public FDouble getNum_maintendose() {
		return ((FDouble) getAttrVal("Num_maintendose"));
	}	
	public void setNum_maintendose(FDouble Num_maintendose) {
		setAttrVal("Num_maintendose", Num_maintendose);
	}
	public String getId_method_anticoagul() {
		return ((String) getAttrVal("Id_method_anticoagul"));
	}	
	public void setId_method_anticoagul(String Id_method_anticoagul) {
		setAttrVal("Id_method_anticoagul", Id_method_anticoagul);
	}
	public String getSd_method_anticoagul() {
		return ((String) getAttrVal("Sd_method_anticoagul"));
	}	
	public void setSd_method_anticoagul(String Sd_method_anticoagul) {
		setAttrVal("Sd_method_anticoagul", Sd_method_anticoagul);
	}
	public FDouble getNum_wt_prehemodial() {
		return ((FDouble) getAttrVal("Num_wt_prehemodial"));
	}	
	public void setNum_wt_prehemodial(FDouble Num_wt_prehemodial) {
		setAttrVal("Num_wt_prehemodial", Num_wt_prehemodial);
	}
	public FDouble getNum_wt_afthemodial() {
		return ((FDouble) getAttrVal("Num_wt_afthemodial"));
	}	
	public void setNum_wt_afthemodial(FDouble Num_wt_afthemodial) {
		setAttrVal("Num_wt_afthemodial", Num_wt_afthemodial);
	}
	public FDouble getNum_setdehydra() {
		return ((FDouble) getAttrVal("Num_setdehydra"));
	}	
	public void setNum_setdehydra(FDouble Num_setdehydra) {
		setAttrVal("Num_setdehydra", Num_setdehydra);
	}
	public FDouble getNum_reldehydra() {
		return ((FDouble) getAttrVal("Num_reldehydra"));
	}	
	public void setNum_reldehydra(FDouble Num_reldehydra) {
		setAttrVal("Num_reldehydra", Num_reldehydra);
	}
	public FDouble getNum_pee() {
		return ((FDouble) getAttrVal("Num_pee"));
	}	
	public void setNum_pee(FDouble Num_pee) {
		setAttrVal("Num_pee", Num_pee);
	}
	public Integer getEu_edema() {
		return ((Integer) getAttrVal("Eu_edema"));
	}	
	public void setEu_edema(Integer Eu_edema) {
		setAttrVal("Eu_edema", Eu_edema);
	}
	public Integer getEu_heartfailure() {
		return ((Integer) getAttrVal("Eu_heartfailure"));
	}	
	public void setEu_heartfailure(Integer Eu_heartfailure) {
		setAttrVal("Eu_heartfailure", Eu_heartfailure);
	}
	public Integer getEu_bleedingtend() {
		return ((Integer) getAttrVal("Eu_bleedingtend"));
	}	
	public void setEu_bleedingtend(Integer Eu_bleedingtend) {
		setAttrVal("Eu_bleedingtend", Eu_bleedingtend);
	}
	public String getDes_oth_bleedingtend() {
		return ((String) getAttrVal("Des_oth_bleedingtend"));
	}	
	public void setDes_oth_bleedingtend(String Des_oth_bleedingtend) {
		setAttrVal("Des_oth_bleedingtend", Des_oth_bleedingtend);
	}
	public String getNo_dialymachine() {
		return ((String) getAttrVal("No_dialymachine"));
	}	
	public void setNo_dialymachine(String No_dialymachine) {
		setAttrVal("No_dialymachine", No_dialymachine);
	}
	public Integer getSno_dialymachine() {
		return ((Integer) getAttrVal("Sno_dialymachine"));
	}	
	public void setSno_dialymachine(Integer Sno_dialymachine) {
		setAttrVal("Sno_dialymachine", Sno_dialymachine);
	}
	public Integer getEu_dialyzintact() {
		return ((Integer) getAttrVal("Eu_dialyzintact"));
	}	
	public void setEu_dialyzintact(Integer Eu_dialyzintact) {
		setAttrVal("Eu_dialyzintact", Eu_dialyzintact);
	}
	public Integer getEu_dialyzuseful() {
		return ((Integer) getAttrVal("Eu_dialyzuseful"));
	}	
	public void setEu_dialyzuseful(Integer Eu_dialyzuseful) {
		setAttrVal("Eu_dialyzuseful", Eu_dialyzuseful);
	}
	public String getId_sign_doctor() {
		return ((String) getAttrVal("Id_sign_doctor"));
	}	
	public void setId_sign_doctor(String Id_sign_doctor) {
		setAttrVal("Id_sign_doctor", Id_sign_doctor);
	}
	public FDouble getNum_na() {
		return ((FDouble) getAttrVal("Num_na"));
	}	
	public void setNum_na(FDouble Num_na) {
		setAttrVal("Num_na", Num_na);
	}
	public FDouble getNum_ca() {
		return ((FDouble) getAttrVal("Num_ca"));
	}	
	public void setNum_ca(FDouble Num_ca) {
		setAttrVal("Num_ca", Num_ca);
	}
	public FDouble getNum_hco3() {
		return ((FDouble) getAttrVal("Num_hco3"));
	}	
	public void setNum_hco3(FDouble Num_hco3) {
		setAttrVal("Num_hco3", Num_hco3);
	}
	public FDouble getNum_flow() {
		return ((FDouble) getAttrVal("Num_flow"));
	}	
	public void setNum_flow(FDouble Num_flow) {
		setAttrVal("Num_flow", Num_flow);
	}
	public String getId_vascularaccess() {
		return ((String) getAttrVal("Id_vascularaccess"));
	}	
	public void setId_vascularaccess(String Id_vascularaccess) {
		setAttrVal("Id_vascularaccess", Id_vascularaccess);
	}
	public String getSd_vascularaccess() {
		return ((String) getAttrVal("Sd_vascularaccess"));
	}	
	public void setSd_vascularaccess(String Sd_vascularaccess) {
		setAttrVal("Sd_vascularaccess", Sd_vascularaccess);
	}
	public String getId_dialysisway() {
		return ((String) getAttrVal("Id_dialysisway"));
	}	
	public void setId_dialysisway(String Id_dialysisway) {
		setAttrVal("Id_dialysisway", Id_dialysisway);
	}
	public String getSd_dialysisway() {
		return ((String) getAttrVal("Sd_dialysisway"));
	}	
	public void setSd_dialysisway(String Sd_dialysisway) {
		setAttrVal("Sd_dialysisway", Sd_dialysisway);
	}
	public String getDes_oth_dialysisway() {
		return ((String) getAttrVal("Des_oth_dialysisway"));
	}	
	public void setDes_oth_dialysisway(String Des_oth_dialysisway) {
		setAttrVal("Des_oth_dialysisway", Des_oth_dialysisway);
	}
	public FDouble getNum_prereplace() {
		return ((FDouble) getAttrVal("Num_prereplace"));
	}	
	public void setNum_prereplace(FDouble Num_prereplace) {
		setAttrVal("Num_prereplace", Num_prereplace);
	}
	public FDouble getNum_aftreplace() {
		return ((FDouble) getAttrVal("Num_aftreplace"));
	}	
	public void setNum_aftreplace(FDouble Num_aftreplace) {
		setAttrVal("Num_aftreplace", Num_aftreplace);
	}
	public Integer getEu_interfistsmooth() {
		return ((Integer) getAttrVal("Eu_interfistsmooth"));
	}	
	public void setEu_interfistsmooth(Integer Eu_interfistsmooth) {
		setAttrVal("Eu_interfistsmooth", Eu_interfistsmooth);
	}
	public String getId_interfistcause() {
		return ((String) getAttrVal("Id_interfistcause"));
	}	
	public void setId_interfistcause(String Id_interfistcause) {
		setAttrVal("Id_interfistcause", Id_interfistcause);
	}
	public String getSd_interfistcause() {
		return ((String) getAttrVal("Sd_interfistcause"));
	}	
	public void setSd_interfistcause(String Sd_interfistcause) {
		setAttrVal("Sd_interfistcause", Sd_interfistcause);
	}
	public Integer getEu_interfistdefflow() {
		return ((Integer) getAttrVal("Eu_interfistdefflow"));
	}	
	public void setEu_interfistdefflow(Integer Eu_interfistdefflow) {
		setAttrVal("Eu_interfistdefflow", Eu_interfistdefflow);
	}
	public Integer getEu_interfisthemat() {
		return ((Integer) getAttrVal("Eu_interfisthemat"));
	}	
	public void setEu_interfisthemat(Integer Eu_interfisthemat) {
		setAttrVal("Eu_interfisthemat", Eu_interfisthemat);
	}
	public FDouble getNum_interfisthematlen() {
		return ((FDouble) getAttrVal("Num_interfisthematlen"));
	}	
	public void setNum_interfisthematlen(FDouble Num_interfisthematlen) {
		setAttrVal("Num_interfisthematlen", Num_interfisthematlen);
	}
	public FDouble getNum_interfisthematwid() {
		return ((FDouble) getAttrVal("Num_interfisthematwid"));
	}	
	public void setNum_interfisthematwid(FDouble Num_interfisthematwid) {
		setAttrVal("Num_interfisthematwid", Num_interfisthematwid);
	}
	public Integer getNum_arteriopuncture() {
		return ((Integer) getAttrVal("Num_arteriopuncture"));
	}	
	public void setNum_arteriopuncture(Integer Num_arteriopuncture) {
		setAttrVal("Num_arteriopuncture", Num_arteriopuncture);
	}
	public Integer getNum_venipuncture() {
		return ((Integer) getAttrVal("Num_venipuncture"));
	}	
	public void setNum_venipuncture(Integer Num_venipuncture) {
		setAttrVal("Num_venipuncture", Num_venipuncture);
	}
	public String getId_sign_impaler() {
		return ((String) getAttrVal("Id_sign_impaler"));
	}	
	public void setId_sign_impaler(String Id_sign_impaler) {
		setAttrVal("Id_sign_impaler", Id_sign_impaler);
	}
	public Integer getEu_pullneedlesmooth() {
		return ((Integer) getAttrVal("Eu_pullneedlesmooth"));
	}	
	public void setEu_pullneedlesmooth(Integer Eu_pullneedlesmooth) {
		setAttrVal("Eu_pullneedlesmooth", Eu_pullneedlesmooth);
	}
	public String getId_pullneedlecause() {
		return ((String) getAttrVal("Id_pullneedlecause"));
	}	
	public void setId_pullneedlecause(String Id_pullneedlecause) {
		setAttrVal("Id_pullneedlecause", Id_pullneedlecause);
	}
	public String getSd_pullneedlecause() {
		return ((String) getAttrVal("Sd_pullneedlecause"));
	}	
	public void setSd_pullneedlecause(String Sd_pullneedlecause) {
		setAttrVal("Sd_pullneedlecause", Sd_pullneedlecause);
	}
	public Integer getEu_pullneedlerrhysis() {
		return ((Integer) getAttrVal("Eu_pullneedlerrhysis"));
	}	
	public void setEu_pullneedlerrhysis(Integer Eu_pullneedlerrhysis) {
		setAttrVal("Eu_pullneedlerrhysis", Eu_pullneedlerrhysis);
	}
	public Integer getEu_pullneedlehemat() {
		return ((Integer) getAttrVal("Eu_pullneedlehemat"));
	}	
	public void setEu_pullneedlehemat(Integer Eu_pullneedlehemat) {
		setAttrVal("Eu_pullneedlehemat", Eu_pullneedlehemat);
	}
	public FDouble getNum_pullneedlematlen() {
		return ((FDouble) getAttrVal("Num_pullneedlematlen"));
	}	
	public void setNum_pullneedlematlen(FDouble Num_pullneedlematlen) {
		setAttrVal("Num_pullneedlematlen", Num_pullneedlematlen);
	}
	public FDouble getNum_pullneedlematwid() {
		return ((FDouble) getAttrVal("Num_pullneedlematwid"));
	}	
	public void setNum_pullneedlematwid(FDouble Num_pullneedlematwid) {
		setAttrVal("Num_pullneedlematwid", Num_pullneedlematwid);
	}
	public Integer getEu_fistulatremor() {
		return ((Integer) getAttrVal("Eu_fistulatremor"));
	}	
	public void setEu_fistulatremor(Integer Eu_fistulatremor) {
		setAttrVal("Eu_fistulatremor", Eu_fistulatremor);
	}
	public Integer getEu_noise() {
		return ((Integer) getAttrVal("Eu_noise"));
	}	
	public void setEu_noise(Integer Eu_noise) {
		setAttrVal("Eu_noise", Eu_noise);
	}
	public String getId_sign_undermachine() {
		return ((String) getAttrVal("Id_sign_undermachine"));
	}	
	public void setId_sign_undermachine(String Id_sign_undermachine) {
		setAttrVal("Id_sign_undermachine", Id_sign_undermachine);
	}
	public Integer getEu_machstoppage() {
		return ((Integer) getAttrVal("Eu_machstoppage"));
	}	
	public void setEu_machstoppage(Integer Eu_machstoppage) {
		setAttrVal("Eu_machstoppage", Eu_machstoppage);
	}
	public Integer getSno_machine() {
		return ((Integer) getAttrVal("Sno_machine"));
	}	
	public void setSno_machine(Integer Sno_machine) {
		setAttrVal("Sno_machine", Sno_machine);
	}
	public String getId_type_machine() {
		return ((String) getAttrVal("Id_type_machine"));
	}	
	public void setId_type_machine(String Id_type_machine) {
		setAttrVal("Id_type_machine", Id_type_machine);
	}
	public String getSd_type_machine() {
		return ((String) getAttrVal("Sd_type_machine"));
	}	
	public void setSd_type_machine(String Sd_type_machine) {
		setAttrVal("Sd_type_machine", Sd_type_machine);
	}
	public String getName_oth_machine() {
		return ((String) getAttrVal("Name_oth_machine"));
	}	
	public void setName_oth_machine(String Name_oth_machine) {
		setAttrVal("Name_oth_machine", Name_oth_machine);
	}
	public String getCause_failure() {
		return ((String) getAttrVal("Cause_failure"));
	}	
	public void setCause_failure(String Cause_failure) {
		setAttrVal("Cause_failure", Cause_failure);
	}
	public String getId_signature() {
		return ((String) getAttrVal("Id_signature"));
	}	
	public void setId_signature(String Id_signature) {
		setAttrVal("Id_signature", Id_signature);
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
	public String getName_method_anticoagul() {
		return ((String) getAttrVal("Name_method_anticoagul"));
	}	
	public void setName_method_anticoagul(String Name_method_anticoagul) {
		setAttrVal("Name_method_anticoagul", Name_method_anticoagul);
	}
	public String getName_doctor() {
		return ((String) getAttrVal("Name_doctor"));
	}	
	public void setName_doctor(String Name_doctor) {
		setAttrVal("Name_doctor", Name_doctor);
	}
	public String getName_vascularaccess() {
		return ((String) getAttrVal("Name_vascularaccess"));
	}	
	public void setName_vascularaccess(String Name_vascularaccess) {
		setAttrVal("Name_vascularaccess", Name_vascularaccess);
	}
	public String getName_dialysisway() {
		return ((String) getAttrVal("Name_dialysisway"));
	}	
	public void setName_dialysisway(String Name_dialysisway) {
		setAttrVal("Name_dialysisway", Name_dialysisway);
	}
	public String getName_interfistcause() {
		return ((String) getAttrVal("Name_interfistcause"));
	}	
	public void setName_interfistcause(String Name_interfistcause) {
		setAttrVal("Name_interfistcause", Name_interfistcause);
	}
	public String getName_impaler() {
		return ((String) getAttrVal("Name_impaler"));
	}	
	public void setName_impaler(String Name_impaler) {
		setAttrVal("Name_impaler", Name_impaler);
	}
	public String getName_pullneedlecause() {
		return ((String) getAttrVal("Name_pullneedlecause"));
	}	
	public void setName_pullneedlecause(String Name_pullneedlecause) {
		setAttrVal("Name_pullneedlecause", Name_pullneedlecause);
	}
	public String getName_undermachine() {
		return ((String) getAttrVal("Name_undermachine"));
	}	
	public void setName_undermachine(String Name_undermachine) {
		setAttrVal("Name_undermachine", Name_undermachine);
	}
	public String getName_type_machine() {
		return ((String) getAttrVal("Name_type_machine"));
	}	
	public void setName_type_machine(String Name_type_machine) {
		setAttrVal("Name_type_machine", Name_type_machine);
	}
	public String getName_signature() {
		return ((String) getAttrVal("Name_signature"));
	}	
	public void setName_signature(String Name_signature) {
		setAttrVal("Name_signature", Name_signature);
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
		return "Id_hemodialycare";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_nu_hemcareinfo";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HemodialycareinfoDODesc.class);
	}
	
}