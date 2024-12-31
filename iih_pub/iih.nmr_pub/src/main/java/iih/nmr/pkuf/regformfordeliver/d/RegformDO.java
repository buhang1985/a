package iih.nmr.pkuf.regformfordeliver.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.regformfordeliver.d.desc.RegformDODesc;
import java.math.BigDecimal;

/**
 * 分娩登记表 DO数据 
 * 
 */
public class RegformDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REGFORM= "Id_regform";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_BED= "Name_bed";
	public static final String ID_ENT= "Id_ent";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String DT_ENTRY= "Dt_entry";
	public static final String NUM_PREG= "Num_preg";
	public static final String NUM_PRODUCE= "Num_produce";
	public static final String NUM_ABORTION= "Num_abortion";
	public static final String NUM_MISCAR= "Num_miscar";
	public static final String OTHER_PREG= "Other_preg";
	public static final String NUM_CHECKBF= "Num_checkbf";
	public static final String DT_LASTMENSTRU= "Dt_lastmenstru";
	public static final String DT_DUECHILD= "Dt_duechild";
	public static final String ID_BLOODTP= "Id_bloodtp";
	public static final String SD_BLOODTP= "Sd_bloodtp";
	public static final String NUM_SON= "Num_son";
	public static final String NUM_DAUGHTER= "Num_daughter";
	public static final String DES_PREGPAST= "Des_pregpast";
	public static final String DT_BEGINMATS= "Dt_beginmats";
	public static final String DT_RUPBRAN= "Dt_rupbran";
	public static final String ID_RUPTP= "Id_ruptp";
	public static final String SD_RUPTP= "Sd_ruptp";
	public static final String DT_CERVCOMP= "Dt_cervcomp";
	public static final String DT_ORIENTFETINT= "Dt_orientfetint";
	public static final String ID_BIRTHCHILD_SITUAT= "Id_birthchild_situat";
	public static final String SD_BIRTHCHILD_SITUAT= "Sd_birthchild_situat";
	public static final String DT_ORIENTFETINTTWO= "Dt_orientfetinttwo";
	public static final String ID_BIRTHCHILD_SITUATTWO= "Id_birthchild_situattwo";
	public static final String SD_BIRTHCHILD_SITUATTWO= "Sd_birthchild_situattwo";
	public static final String DT_ORIENTFETINTTHREE= "Dt_orientfetintthree";
	public static final String ID_BIRTHCHILD_SITUATTHREE= "Id_birthchild_situatthree";
	public static final String SD_BIRTHCHILD_SITUATTHREE= "Sd_birthchild_situatthree";
	public static final String DT_PLACENTA= "Dt_placenta";
	public static final String ID_ORIENTFETINTWO= "Id_orientfetintwo";
	public static final String SD_ORIENTFETINTWO= "Sd_orientfetintwo";
	public static final String ID_PLA_STATUS= "Id_pla_status";
	public static final String SD_PLA_STATUS= "Sd_pla_status";
	public static final String ENUM_SEXCHILDONE= "Enum_sexchildone";
	public static final String WEIGHT_CHILDONE= "Weight_childone";
	public static final String HEIGHT_CHILDONE= "Height_childone";
	public static final String HDCIRCU_CHILDONE= "Hdcircu_childone";
	public static final String CHEST_CHILDONE= "Chest_childone";
	public static final String ID_CHESTSTATUONE= "Id_cheststatuone";
	public static final String SD_CHESTSTATUONE= "Sd_cheststatuone";
	public static final String ENUM_SEXCHILDTWO= "Enum_sexchildtwo";
	public static final String WEIGHT_CHILDTWO= "Weight_childtwo";
	public static final String HEIGHT_CHILDTWO= "Height_childtwo";
	public static final String HDCIRCU_CHILDTWO= "Hdcircu_childtwo";
	public static final String CHEST_CHILDTWO= "Chest_childtwo";
	public static final String ID_CHESTSTATUTWO= "Id_cheststatutwo";
	public static final String SD_CHESTSTATUTWO= "Sd_cheststatutwo";
	public static final String ENUM_SEXCHILDTHREE= "Enum_sexchildthree";
	public static final String WEIGHT_CHILDTHREE= "Weight_childthree";
	public static final String HEIGHT_CHILDTHREE= "Height_childthree";
	public static final String HDCIRCU_CHILDTHREE= "Hdcircu_childthree";
	public static final String CHEST_CHILDTHREE= "Chest_childthree";
	public static final String ID_CHESTSTATUTHREE= "Id_cheststatuthree";
	public static final String SD_CHESTSTATUTHREE= "Sd_cheststatuthree";
	public static final String TOTAL_LABOR= "Total_labor";
	public static final String FIRST_LABOR= "First_labor";
	public static final String SECOND_LABOR= "Second_labor";
	public static final String THIRD_LABOR= "Third_labor";
	public static final String NUM_BLDLOST= "Num_bldlost";
	public static final String NUM_BLDLOSTDUR= "Num_bldlostdur";
	public static final String NUM_BLDLOSTH= "Num_bldlosth";
	public static final String NUM_BLDTLOSTTH= "Num_bldtlostth";
	public static final String ID_REASONBDLOST= "Id_reasonbdlost";
	public static final String SD_REASONBDLOST= "Sd_reasonbdlost";
	public static final String REASONBDLOSTO= "Reasonbdlosto";
	public static final String POST_MEDIC= "Post_medic";
	public static final String ID_PERUPT= "Id_perupt";
	public static final String SD_PERUPT= "Sd_perupt";
	public static final String BDPRESS_HIGH= "Bdpress_high";
	public static final String BDPRESS_LOW= "Bdpress_low";
	public static final String ENUM_HEART= "Enum_heart";
	public static final String ENUM_BREATH= "Enum_breath";
	public static final String ENUM_TENSION= "Enum_tension";
	public static final String ENUM_THROAT= "Enum_throat";
	public static final String ENUM_SKINCOLOR= "Enum_skincolor";
	public static final String SCORE_TOTALCHILD= "Score_totalchild";
	public static final String CHILDBIRTH_SUMARY= "Childbirth_sumary";
	public static final String ID_DIAGDOC= "Id_diagdoc";
	public static final String HD_CONDITION= "Hd_condition";
	public static final String ID_NURSEONE= "Id_nurseone";
	public static final String ID_NURSETWO= "Id_nursetwo";
	public static final String PLA_LENGTH= "Pla_length";
	public static final String PLA_WIDTH= "Pla_width";
	public static final String PLA_HEIGHT= "Pla_height";
	public static final String ID_UMBCORD= "Id_umbcord";
	public static final String SD_UMBCORD= "Sd_umbcord";
	public static final String LENGTH_UMBCORD= "Length_umbcord";
	public static final String ID_NECKTWINING= "Id_necktwining";
	public static final String SD_NECKTWINING= "Sd_necktwining";
	public static final String ID_AMNIOTIC_FLUID= "Id_amniotic_fluid";
	public static final String SD_AMNIOTIC_FLUID= "Sd_amniotic_fluid";
	public static final String ID_NUMAMNFLUID= "Id_numamnfluid";
	public static final String SD_NUMAMNFLUID= "Sd_numamnfluid";
	public static final String COLOR_AMNFLUID= "Color_amnfluid";
	public static final String SMELL_AMNFLUID= "Smell_amnfluid";
	public static final String ID_SURGERY= "Id_surgery";
	public static final String SD_SURGERY= "Sd_surgery";
	public static final String ID_ANA= "Id_ana";
	public static final String SD_ANA= "Sd_ana";
	public static final String NAME_ANA= "Name_ana";
	public static final String NUM_NEEDLEOUT= "Num_needleout";
	public static final String INTRAP_MEDIC= "Intrap_medic";
	public static final String PREG_COMPLICAT= "Preg_complicat";
	public static final String BIRTH_COMPLICAT= "Birth_complicat";
	public static final String ENUMBRANECOMPLT= "Enumbranecomplt";
	public static final String ID_SIGNATURE= "Id_signature";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_BLOODTP= "Name_bloodtp";
	public static final String NAME_RUPTP= "Name_ruptp";
	public static final String NAME_BIRTH_SITUAT= "Name_birth_situat";
	public static final String NAME_BIRTHCHILD_SITUATTWO= "Name_birthchild_situattwo";
	public static final String NAME_BIRTHCHILD_SITUATTHREE= "Name_birthchild_situatthree";
	public static final String NAME_ORIENTFETINTWO= "Name_orientfetintwo";
	public static final String NAME_PLA_STATUS= "Name_pla_status";
	public static final String NAME_CHETSTATUONE= "Name_chetstatuone";
	public static final String NAME_CHETSTATUTWO= "Name_chetstatutwo";
	public static final String NAME_CHESTSTATUTHREE= "Name_cheststatuthree";
	public static final String NAME_REASONBDLOST= "Name_reasonbdlost";
	public static final String NAME_PERUPT= "Name_perupt";
	public static final String NAME_DIAGDOC= "Name_diagdoc";
	public static final String NAME_NURSEONE= "Name_nurseone";
	public static final String NAME_NURSETWO= "Name_nursetwo";
	public static final String NAME_UMBCORD= "Name_umbcord";
	public static final String NAME_NECKTWINING= "Name_necktwining";
	public static final String NAME_AMNIOTIC_FLUID= "Name_amniotic_fluid";
	public static final String NAME_NUMAMNFLUID= "Name_numamnfluid";
	public static final String NAME_SURGERY= "Name_surgery";
	public static final String NAME_SIGNATURE= "Name_signature";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_regform() {
		return ((String) getAttrVal("Id_regform"));
	}	
	public void setId_regform(String Id_regform) {
		setAttrVal("Id_regform", Id_regform);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	public Integer getNum_preg() {
		return ((Integer) getAttrVal("Num_preg"));
	}	
	public void setNum_preg(Integer Num_preg) {
		setAttrVal("Num_preg", Num_preg);
	}
	public Integer getNum_produce() {
		return ((Integer) getAttrVal("Num_produce"));
	}	
	public void setNum_produce(Integer Num_produce) {
		setAttrVal("Num_produce", Num_produce);
	}
	public Integer getNum_abortion() {
		return ((Integer) getAttrVal("Num_abortion"));
	}	
	public void setNum_abortion(Integer Num_abortion) {
		setAttrVal("Num_abortion", Num_abortion);
	}
	public Integer getNum_miscar() {
		return ((Integer) getAttrVal("Num_miscar"));
	}	
	public void setNum_miscar(Integer Num_miscar) {
		setAttrVal("Num_miscar", Num_miscar);
	}
	public String getOther_preg() {
		return ((String) getAttrVal("Other_preg"));
	}	
	public void setOther_preg(String Other_preg) {
		setAttrVal("Other_preg", Other_preg);
	}
	public Integer getNum_checkbf() {
		return ((Integer) getAttrVal("Num_checkbf"));
	}	
	public void setNum_checkbf(Integer Num_checkbf) {
		setAttrVal("Num_checkbf", Num_checkbf);
	}
	public FDate getDt_lastmenstru() {
		return ((FDate) getAttrVal("Dt_lastmenstru"));
	}	
	public void setDt_lastmenstru(FDate Dt_lastmenstru) {
		setAttrVal("Dt_lastmenstru", Dt_lastmenstru);
	}
	public FDate getDt_duechild() {
		return ((FDate) getAttrVal("Dt_duechild"));
	}	
	public void setDt_duechild(FDate Dt_duechild) {
		setAttrVal("Dt_duechild", Dt_duechild);
	}
	public String getId_bloodtp() {
		return ((String) getAttrVal("Id_bloodtp"));
	}	
	public void setId_bloodtp(String Id_bloodtp) {
		setAttrVal("Id_bloodtp", Id_bloodtp);
	}
	public String getSd_bloodtp() {
		return ((String) getAttrVal("Sd_bloodtp"));
	}	
	public void setSd_bloodtp(String Sd_bloodtp) {
		setAttrVal("Sd_bloodtp", Sd_bloodtp);
	}
	public Integer getNum_son() {
		return ((Integer) getAttrVal("Num_son"));
	}	
	public void setNum_son(Integer Num_son) {
		setAttrVal("Num_son", Num_son);
	}
	public Integer getNum_daughter() {
		return ((Integer) getAttrVal("Num_daughter"));
	}	
	public void setNum_daughter(Integer Num_daughter) {
		setAttrVal("Num_daughter", Num_daughter);
	}
	public String getDes_pregpast() {
		return ((String) getAttrVal("Des_pregpast"));
	}	
	public void setDes_pregpast(String Des_pregpast) {
		setAttrVal("Des_pregpast", Des_pregpast);
	}
	public FDateTime getDt_beginmats() {
		return ((FDateTime) getAttrVal("Dt_beginmats"));
	}	
	public void setDt_beginmats(FDateTime Dt_beginmats) {
		setAttrVal("Dt_beginmats", Dt_beginmats);
	}
	public FDateTime getDt_rupbran() {
		return ((FDateTime) getAttrVal("Dt_rupbran"));
	}	
	public void setDt_rupbran(FDateTime Dt_rupbran) {
		setAttrVal("Dt_rupbran", Dt_rupbran);
	}
	public String getId_ruptp() {
		return ((String) getAttrVal("Id_ruptp"));
	}	
	public void setId_ruptp(String Id_ruptp) {
		setAttrVal("Id_ruptp", Id_ruptp);
	}
	public String getSd_ruptp() {
		return ((String) getAttrVal("Sd_ruptp"));
	}	
	public void setSd_ruptp(String Sd_ruptp) {
		setAttrVal("Sd_ruptp", Sd_ruptp);
	}
	public FDateTime getDt_cervcomp() {
		return ((FDateTime) getAttrVal("Dt_cervcomp"));
	}	
	public void setDt_cervcomp(FDateTime Dt_cervcomp) {
		setAttrVal("Dt_cervcomp", Dt_cervcomp);
	}
	public FDateTime getDt_orientfetint() {
		return ((FDateTime) getAttrVal("Dt_orientfetint"));
	}	
	public void setDt_orientfetint(FDateTime Dt_orientfetint) {
		setAttrVal("Dt_orientfetint", Dt_orientfetint);
	}
	public String getId_birthchild_situat() {
		return ((String) getAttrVal("Id_birthchild_situat"));
	}	
	public void setId_birthchild_situat(String Id_birthchild_situat) {
		setAttrVal("Id_birthchild_situat", Id_birthchild_situat);
	}
	public String getSd_birthchild_situat() {
		return ((String) getAttrVal("Sd_birthchild_situat"));
	}	
	public void setSd_birthchild_situat(String Sd_birthchild_situat) {
		setAttrVal("Sd_birthchild_situat", Sd_birthchild_situat);
	}
	public FDateTime getDt_orientfetinttwo() {
		return ((FDateTime) getAttrVal("Dt_orientfetinttwo"));
	}	
	public void setDt_orientfetinttwo(FDateTime Dt_orientfetinttwo) {
		setAttrVal("Dt_orientfetinttwo", Dt_orientfetinttwo);
	}
	public String getId_birthchild_situattwo() {
		return ((String) getAttrVal("Id_birthchild_situattwo"));
	}	
	public void setId_birthchild_situattwo(String Id_birthchild_situattwo) {
		setAttrVal("Id_birthchild_situattwo", Id_birthchild_situattwo);
	}
	public String getSd_birthchild_situattwo() {
		return ((String) getAttrVal("Sd_birthchild_situattwo"));
	}	
	public void setSd_birthchild_situattwo(String Sd_birthchild_situattwo) {
		setAttrVal("Sd_birthchild_situattwo", Sd_birthchild_situattwo);
	}
	public FDateTime getDt_orientfetintthree() {
		return ((FDateTime) getAttrVal("Dt_orientfetintthree"));
	}	
	public void setDt_orientfetintthree(FDateTime Dt_orientfetintthree) {
		setAttrVal("Dt_orientfetintthree", Dt_orientfetintthree);
	}
	public String getId_birthchild_situatthree() {
		return ((String) getAttrVal("Id_birthchild_situatthree"));
	}	
	public void setId_birthchild_situatthree(String Id_birthchild_situatthree) {
		setAttrVal("Id_birthchild_situatthree", Id_birthchild_situatthree);
	}
	public String getSd_birthchild_situatthree() {
		return ((String) getAttrVal("Sd_birthchild_situatthree"));
	}	
	public void setSd_birthchild_situatthree(String Sd_birthchild_situatthree) {
		setAttrVal("Sd_birthchild_situatthree", Sd_birthchild_situatthree);
	}
	public FDateTime getDt_placenta() {
		return ((FDateTime) getAttrVal("Dt_placenta"));
	}	
	public void setDt_placenta(FDateTime Dt_placenta) {
		setAttrVal("Dt_placenta", Dt_placenta);
	}
	public String getId_orientfetintwo() {
		return ((String) getAttrVal("Id_orientfetintwo"));
	}	
	public void setId_orientfetintwo(String Id_orientfetintwo) {
		setAttrVal("Id_orientfetintwo", Id_orientfetintwo);
	}
	public String getSd_orientfetintwo() {
		return ((String) getAttrVal("Sd_orientfetintwo"));
	}	
	public void setSd_orientfetintwo(String Sd_orientfetintwo) {
		setAttrVal("Sd_orientfetintwo", Sd_orientfetintwo);
	}
	public String getId_pla_status() {
		return ((String) getAttrVal("Id_pla_status"));
	}	
	public void setId_pla_status(String Id_pla_status) {
		setAttrVal("Id_pla_status", Id_pla_status);
	}
	public String getSd_pla_status() {
		return ((String) getAttrVal("Sd_pla_status"));
	}	
	public void setSd_pla_status(String Sd_pla_status) {
		setAttrVal("Sd_pla_status", Sd_pla_status);
	}
	public Integer getEnum_sexchildone() {
		return ((Integer) getAttrVal("Enum_sexchildone"));
	}	
	public void setEnum_sexchildone(Integer Enum_sexchildone) {
		setAttrVal("Enum_sexchildone", Enum_sexchildone);
	}
	public FDouble getWeight_childone() {
		return ((FDouble) getAttrVal("Weight_childone"));
	}	
	public void setWeight_childone(FDouble Weight_childone) {
		setAttrVal("Weight_childone", Weight_childone);
	}
	public Integer getHeight_childone() {
		return ((Integer) getAttrVal("Height_childone"));
	}	
	public void setHeight_childone(Integer Height_childone) {
		setAttrVal("Height_childone", Height_childone);
	}
	public Integer getHdcircu_childone() {
		return ((Integer) getAttrVal("Hdcircu_childone"));
	}	
	public void setHdcircu_childone(Integer Hdcircu_childone) {
		setAttrVal("Hdcircu_childone", Hdcircu_childone);
	}
	public Integer getChest_childone() {
		return ((Integer) getAttrVal("Chest_childone"));
	}	
	public void setChest_childone(Integer Chest_childone) {
		setAttrVal("Chest_childone", Chest_childone);
	}
	public String getId_cheststatuone() {
		return ((String) getAttrVal("Id_cheststatuone"));
	}	
	public void setId_cheststatuone(String Id_cheststatuone) {
		setAttrVal("Id_cheststatuone", Id_cheststatuone);
	}
	public String getSd_cheststatuone() {
		return ((String) getAttrVal("Sd_cheststatuone"));
	}	
	public void setSd_cheststatuone(String Sd_cheststatuone) {
		setAttrVal("Sd_cheststatuone", Sd_cheststatuone);
	}
	public Integer getEnum_sexchildtwo() {
		return ((Integer) getAttrVal("Enum_sexchildtwo"));
	}	
	public void setEnum_sexchildtwo(Integer Enum_sexchildtwo) {
		setAttrVal("Enum_sexchildtwo", Enum_sexchildtwo);
	}
	public FDouble getWeight_childtwo() {
		return ((FDouble) getAttrVal("Weight_childtwo"));
	}	
	public void setWeight_childtwo(FDouble Weight_childtwo) {
		setAttrVal("Weight_childtwo", Weight_childtwo);
	}
	public Integer getHeight_childtwo() {
		return ((Integer) getAttrVal("Height_childtwo"));
	}	
	public void setHeight_childtwo(Integer Height_childtwo) {
		setAttrVal("Height_childtwo", Height_childtwo);
	}
	public Integer getHdcircu_childtwo() {
		return ((Integer) getAttrVal("Hdcircu_childtwo"));
	}	
	public void setHdcircu_childtwo(Integer Hdcircu_childtwo) {
		setAttrVal("Hdcircu_childtwo", Hdcircu_childtwo);
	}
	public Integer getChest_childtwo() {
		return ((Integer) getAttrVal("Chest_childtwo"));
	}	
	public void setChest_childtwo(Integer Chest_childtwo) {
		setAttrVal("Chest_childtwo", Chest_childtwo);
	}
	public String getId_cheststatutwo() {
		return ((String) getAttrVal("Id_cheststatutwo"));
	}	
	public void setId_cheststatutwo(String Id_cheststatutwo) {
		setAttrVal("Id_cheststatutwo", Id_cheststatutwo);
	}
	public String getSd_cheststatutwo() {
		return ((String) getAttrVal("Sd_cheststatutwo"));
	}	
	public void setSd_cheststatutwo(String Sd_cheststatutwo) {
		setAttrVal("Sd_cheststatutwo", Sd_cheststatutwo);
	}
	public Integer getEnum_sexchildthree() {
		return ((Integer) getAttrVal("Enum_sexchildthree"));
	}	
	public void setEnum_sexchildthree(Integer Enum_sexchildthree) {
		setAttrVal("Enum_sexchildthree", Enum_sexchildthree);
	}
	public FDouble getWeight_childthree() {
		return ((FDouble) getAttrVal("Weight_childthree"));
	}	
	public void setWeight_childthree(FDouble Weight_childthree) {
		setAttrVal("Weight_childthree", Weight_childthree);
	}
	public Integer getHeight_childthree() {
		return ((Integer) getAttrVal("Height_childthree"));
	}	
	public void setHeight_childthree(Integer Height_childthree) {
		setAttrVal("Height_childthree", Height_childthree);
	}
	public Integer getHdcircu_childthree() {
		return ((Integer) getAttrVal("Hdcircu_childthree"));
	}	
	public void setHdcircu_childthree(Integer Hdcircu_childthree) {
		setAttrVal("Hdcircu_childthree", Hdcircu_childthree);
	}
	public Integer getChest_childthree() {
		return ((Integer) getAttrVal("Chest_childthree"));
	}	
	public void setChest_childthree(Integer Chest_childthree) {
		setAttrVal("Chest_childthree", Chest_childthree);
	}
	public String getId_cheststatuthree() {
		return ((String) getAttrVal("Id_cheststatuthree"));
	}	
	public void setId_cheststatuthree(String Id_cheststatuthree) {
		setAttrVal("Id_cheststatuthree", Id_cheststatuthree);
	}
	public String getSd_cheststatuthree() {
		return ((String) getAttrVal("Sd_cheststatuthree"));
	}	
	public void setSd_cheststatuthree(String Sd_cheststatuthree) {
		setAttrVal("Sd_cheststatuthree", Sd_cheststatuthree);
	}
	public Integer getTotal_labor() {
		return ((Integer) getAttrVal("Total_labor"));
	}	
	public void setTotal_labor(Integer Total_labor) {
		setAttrVal("Total_labor", Total_labor);
	}
	public Integer getFirst_labor() {
		return ((Integer) getAttrVal("First_labor"));
	}	
	public void setFirst_labor(Integer First_labor) {
		setAttrVal("First_labor", First_labor);
	}
	public Integer getSecond_labor() {
		return ((Integer) getAttrVal("Second_labor"));
	}	
	public void setSecond_labor(Integer Second_labor) {
		setAttrVal("Second_labor", Second_labor);
	}
	public Integer getThird_labor() {
		return ((Integer) getAttrVal("Third_labor"));
	}	
	public void setThird_labor(Integer Third_labor) {
		setAttrVal("Third_labor", Third_labor);
	}
	public Integer getNum_bldlost() {
		return ((Integer) getAttrVal("Num_bldlost"));
	}	
	public void setNum_bldlost(Integer Num_bldlost) {
		setAttrVal("Num_bldlost", Num_bldlost);
	}
	public Integer getNum_bldlostdur() {
		return ((Integer) getAttrVal("Num_bldlostdur"));
	}	
	public void setNum_bldlostdur(Integer Num_bldlostdur) {
		setAttrVal("Num_bldlostdur", Num_bldlostdur);
	}
	public Integer getNum_bldlosth() {
		return ((Integer) getAttrVal("Num_bldlosth"));
	}	
	public void setNum_bldlosth(Integer Num_bldlosth) {
		setAttrVal("Num_bldlosth", Num_bldlosth);
	}
	public Integer getNum_bldtlostth() {
		return ((Integer) getAttrVal("Num_bldtlostth"));
	}	
	public void setNum_bldtlostth(Integer Num_bldtlostth) {
		setAttrVal("Num_bldtlostth", Num_bldtlostth);
	}
	public String getId_reasonbdlost() {
		return ((String) getAttrVal("Id_reasonbdlost"));
	}	
	public void setId_reasonbdlost(String Id_reasonbdlost) {
		setAttrVal("Id_reasonbdlost", Id_reasonbdlost);
	}
	public String getSd_reasonbdlost() {
		return ((String) getAttrVal("Sd_reasonbdlost"));
	}	
	public void setSd_reasonbdlost(String Sd_reasonbdlost) {
		setAttrVal("Sd_reasonbdlost", Sd_reasonbdlost);
	}
	public String getReasonbdlosto() {
		return ((String) getAttrVal("Reasonbdlosto"));
	}	
	public void setReasonbdlosto(String Reasonbdlosto) {
		setAttrVal("Reasonbdlosto", Reasonbdlosto);
	}
	public String getPost_medic() {
		return ((String) getAttrVal("Post_medic"));
	}	
	public void setPost_medic(String Post_medic) {
		setAttrVal("Post_medic", Post_medic);
	}
	public String getId_perupt() {
		return ((String) getAttrVal("Id_perupt"));
	}	
	public void setId_perupt(String Id_perupt) {
		setAttrVal("Id_perupt", Id_perupt);
	}
	public String getSd_perupt() {
		return ((String) getAttrVal("Sd_perupt"));
	}	
	public void setSd_perupt(String Sd_perupt) {
		setAttrVal("Sd_perupt", Sd_perupt);
	}
	public Integer getBdpress_high() {
		return ((Integer) getAttrVal("Bdpress_high"));
	}	
	public void setBdpress_high(Integer Bdpress_high) {
		setAttrVal("Bdpress_high", Bdpress_high);
	}
	public Integer getBdpress_low() {
		return ((Integer) getAttrVal("Bdpress_low"));
	}	
	public void setBdpress_low(Integer Bdpress_low) {
		setAttrVal("Bdpress_low", Bdpress_low);
	}
	public Integer getEnum_heart() {
		return ((Integer) getAttrVal("Enum_heart"));
	}	
	public void setEnum_heart(Integer Enum_heart) {
		setAttrVal("Enum_heart", Enum_heart);
	}
	public Integer getEnum_breath() {
		return ((Integer) getAttrVal("Enum_breath"));
	}	
	public void setEnum_breath(Integer Enum_breath) {
		setAttrVal("Enum_breath", Enum_breath);
	}
	public Integer getEnum_tension() {
		return ((Integer) getAttrVal("Enum_tension"));
	}	
	public void setEnum_tension(Integer Enum_tension) {
		setAttrVal("Enum_tension", Enum_tension);
	}
	public Integer getEnum_throat() {
		return ((Integer) getAttrVal("Enum_throat"));
	}	
	public void setEnum_throat(Integer Enum_throat) {
		setAttrVal("Enum_throat", Enum_throat);
	}
	public Integer getEnum_skincolor() {
		return ((Integer) getAttrVal("Enum_skincolor"));
	}	
	public void setEnum_skincolor(Integer Enum_skincolor) {
		setAttrVal("Enum_skincolor", Enum_skincolor);
	}
	public Integer getScore_totalchild() {
		return ((Integer) getAttrVal("Score_totalchild"));
	}	
	public void setScore_totalchild(Integer Score_totalchild) {
		setAttrVal("Score_totalchild", Score_totalchild);
	}
	public String getChildbirth_sumary() {
		return ((String) getAttrVal("Childbirth_sumary"));
	}	
	public void setChildbirth_sumary(String Childbirth_sumary) {
		setAttrVal("Childbirth_sumary", Childbirth_sumary);
	}
	public String getId_diagdoc() {
		return ((String) getAttrVal("Id_diagdoc"));
	}	
	public void setId_diagdoc(String Id_diagdoc) {
		setAttrVal("Id_diagdoc", Id_diagdoc);
	}
	public String getHd_condition() {
		return ((String) getAttrVal("Hd_condition"));
	}	
	public void setHd_condition(String Hd_condition) {
		setAttrVal("Hd_condition", Hd_condition);
	}
	public String getId_nurseone() {
		return ((String) getAttrVal("Id_nurseone"));
	}	
	public void setId_nurseone(String Id_nurseone) {
		setAttrVal("Id_nurseone", Id_nurseone);
	}
	public String getId_nursetwo() {
		return ((String) getAttrVal("Id_nursetwo"));
	}	
	public void setId_nursetwo(String Id_nursetwo) {
		setAttrVal("Id_nursetwo", Id_nursetwo);
	}
	public FDouble getPla_length() {
		return ((FDouble) getAttrVal("Pla_length"));
	}	
	public void setPla_length(FDouble Pla_length) {
		setAttrVal("Pla_length", Pla_length);
	}
	public FDouble getPla_width() {
		return ((FDouble) getAttrVal("Pla_width"));
	}	
	public void setPla_width(FDouble Pla_width) {
		setAttrVal("Pla_width", Pla_width);
	}
	public FDouble getPla_height() {
		return ((FDouble) getAttrVal("Pla_height"));
	}	
	public void setPla_height(FDouble Pla_height) {
		setAttrVal("Pla_height", Pla_height);
	}
	public String getId_umbcord() {
		return ((String) getAttrVal("Id_umbcord"));
	}	
	public void setId_umbcord(String Id_umbcord) {
		setAttrVal("Id_umbcord", Id_umbcord);
	}
	public String getSd_umbcord() {
		return ((String) getAttrVal("Sd_umbcord"));
	}	
	public void setSd_umbcord(String Sd_umbcord) {
		setAttrVal("Sd_umbcord", Sd_umbcord);
	}
	public Integer getLength_umbcord() {
		return ((Integer) getAttrVal("Length_umbcord"));
	}	
	public void setLength_umbcord(Integer Length_umbcord) {
		setAttrVal("Length_umbcord", Length_umbcord);
	}
	public String getId_necktwining() {
		return ((String) getAttrVal("Id_necktwining"));
	}	
	public void setId_necktwining(String Id_necktwining) {
		setAttrVal("Id_necktwining", Id_necktwining);
	}
	public String getSd_necktwining() {
		return ((String) getAttrVal("Sd_necktwining"));
	}	
	public void setSd_necktwining(String Sd_necktwining) {
		setAttrVal("Sd_necktwining", Sd_necktwining);
	}
	public String getId_amniotic_fluid() {
		return ((String) getAttrVal("Id_amniotic_fluid"));
	}	
	public void setId_amniotic_fluid(String Id_amniotic_fluid) {
		setAttrVal("Id_amniotic_fluid", Id_amniotic_fluid);
	}
	public String getSd_amniotic_fluid() {
		return ((String) getAttrVal("Sd_amniotic_fluid"));
	}	
	public void setSd_amniotic_fluid(String Sd_amniotic_fluid) {
		setAttrVal("Sd_amniotic_fluid", Sd_amniotic_fluid);
	}
	public String getId_numamnfluid() {
		return ((String) getAttrVal("Id_numamnfluid"));
	}	
	public void setId_numamnfluid(String Id_numamnfluid) {
		setAttrVal("Id_numamnfluid", Id_numamnfluid);
	}
	public String getSd_numamnfluid() {
		return ((String) getAttrVal("Sd_numamnfluid"));
	}	
	public void setSd_numamnfluid(String Sd_numamnfluid) {
		setAttrVal("Sd_numamnfluid", Sd_numamnfluid);
	}
	public String getColor_amnfluid() {
		return ((String) getAttrVal("Color_amnfluid"));
	}	
	public void setColor_amnfluid(String Color_amnfluid) {
		setAttrVal("Color_amnfluid", Color_amnfluid);
	}
	public String getSmell_amnfluid() {
		return ((String) getAttrVal("Smell_amnfluid"));
	}	
	public void setSmell_amnfluid(String Smell_amnfluid) {
		setAttrVal("Smell_amnfluid", Smell_amnfluid);
	}
	public String getId_surgery() {
		return ((String) getAttrVal("Id_surgery"));
	}	
	public void setId_surgery(String Id_surgery) {
		setAttrVal("Id_surgery", Id_surgery);
	}
	public String getSd_surgery() {
		return ((String) getAttrVal("Sd_surgery"));
	}	
	public void setSd_surgery(String Sd_surgery) {
		setAttrVal("Sd_surgery", Sd_surgery);
	}
	public String getId_ana() {
		return ((String) getAttrVal("Id_ana"));
	}	
	public void setId_ana(String Id_ana) {
		setAttrVal("Id_ana", Id_ana);
	}
	public String getSd_ana() {
		return ((String) getAttrVal("Sd_ana"));
	}	
	public void setSd_ana(String Sd_ana) {
		setAttrVal("Sd_ana", Sd_ana);
	}
	public String getName_ana() {
		return ((String) getAttrVal("Name_ana"));
	}	
	public void setName_ana(String Name_ana) {
		setAttrVal("Name_ana", Name_ana);
	}
	public Integer getNum_needleout() {
		return ((Integer) getAttrVal("Num_needleout"));
	}	
	public void setNum_needleout(Integer Num_needleout) {
		setAttrVal("Num_needleout", Num_needleout);
	}
	public String getIntrap_medic() {
		return ((String) getAttrVal("Intrap_medic"));
	}	
	public void setIntrap_medic(String Intrap_medic) {
		setAttrVal("Intrap_medic", Intrap_medic);
	}
	public String getPreg_complicat() {
		return ((String) getAttrVal("Preg_complicat"));
	}	
	public void setPreg_complicat(String Preg_complicat) {
		setAttrVal("Preg_complicat", Preg_complicat);
	}
	public String getBirth_complicat() {
		return ((String) getAttrVal("Birth_complicat"));
	}	
	public void setBirth_complicat(String Birth_complicat) {
		setAttrVal("Birth_complicat", Birth_complicat);
	}
	public Integer getEnumbranecomplt() {
		return ((Integer) getAttrVal("Enumbranecomplt"));
	}	
	public void setEnumbranecomplt(Integer Enumbranecomplt) {
		setAttrVal("Enumbranecomplt", Enumbranecomplt);
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
	public String getName_bloodtp() {
		return ((String) getAttrVal("Name_bloodtp"));
	}	
	public void setName_bloodtp(String Name_bloodtp) {
		setAttrVal("Name_bloodtp", Name_bloodtp);
	}
	public String getName_ruptp() {
		return ((String) getAttrVal("Name_ruptp"));
	}	
	public void setName_ruptp(String Name_ruptp) {
		setAttrVal("Name_ruptp", Name_ruptp);
	}
	public String getName_birth_situat() {
		return ((String) getAttrVal("Name_birth_situat"));
	}	
	public void setName_birth_situat(String Name_birth_situat) {
		setAttrVal("Name_birth_situat", Name_birth_situat);
	}
	public String getName_birthchild_situattwo() {
		return ((String) getAttrVal("Name_birthchild_situattwo"));
	}	
	public void setName_birthchild_situattwo(String Name_birthchild_situattwo) {
		setAttrVal("Name_birthchild_situattwo", Name_birthchild_situattwo);
	}
	public String getName_birthchild_situatthree() {
		return ((String) getAttrVal("Name_birthchild_situatthree"));
	}	
	public void setName_birthchild_situatthree(String Name_birthchild_situatthree) {
		setAttrVal("Name_birthchild_situatthree", Name_birthchild_situatthree);
	}
	public String getName_orientfetintwo() {
		return ((String) getAttrVal("Name_orientfetintwo"));
	}	
	public void setName_orientfetintwo(String Name_orientfetintwo) {
		setAttrVal("Name_orientfetintwo", Name_orientfetintwo);
	}
	public String getName_pla_status() {
		return ((String) getAttrVal("Name_pla_status"));
	}	
	public void setName_pla_status(String Name_pla_status) {
		setAttrVal("Name_pla_status", Name_pla_status);
	}
	public String getName_chetstatuone() {
		return ((String) getAttrVal("Name_chetstatuone"));
	}	
	public void setName_chetstatuone(String Name_chetstatuone) {
		setAttrVal("Name_chetstatuone", Name_chetstatuone);
	}
	public String getName_chetstatutwo() {
		return ((String) getAttrVal("Name_chetstatutwo"));
	}	
	public void setName_chetstatutwo(String Name_chetstatutwo) {
		setAttrVal("Name_chetstatutwo", Name_chetstatutwo);
	}
	public String getName_cheststatuthree() {
		return ((String) getAttrVal("Name_cheststatuthree"));
	}	
	public void setName_cheststatuthree(String Name_cheststatuthree) {
		setAttrVal("Name_cheststatuthree", Name_cheststatuthree);
	}
	public String getName_reasonbdlost() {
		return ((String) getAttrVal("Name_reasonbdlost"));
	}	
	public void setName_reasonbdlost(String Name_reasonbdlost) {
		setAttrVal("Name_reasonbdlost", Name_reasonbdlost);
	}
	public String getName_perupt() {
		return ((String) getAttrVal("Name_perupt"));
	}	
	public void setName_perupt(String Name_perupt) {
		setAttrVal("Name_perupt", Name_perupt);
	}
	public String getName_diagdoc() {
		return ((String) getAttrVal("Name_diagdoc"));
	}	
	public void setName_diagdoc(String Name_diagdoc) {
		setAttrVal("Name_diagdoc", Name_diagdoc);
	}
	public String getName_nurseone() {
		return ((String) getAttrVal("Name_nurseone"));
	}	
	public void setName_nurseone(String Name_nurseone) {
		setAttrVal("Name_nurseone", Name_nurseone);
	}
	public String getName_nursetwo() {
		return ((String) getAttrVal("Name_nursetwo"));
	}	
	public void setName_nursetwo(String Name_nursetwo) {
		setAttrVal("Name_nursetwo", Name_nursetwo);
	}
	public String getName_umbcord() {
		return ((String) getAttrVal("Name_umbcord"));
	}	
	public void setName_umbcord(String Name_umbcord) {
		setAttrVal("Name_umbcord", Name_umbcord);
	}
	public String getName_necktwining() {
		return ((String) getAttrVal("Name_necktwining"));
	}	
	public void setName_necktwining(String Name_necktwining) {
		setAttrVal("Name_necktwining", Name_necktwining);
	}
	public String getName_amniotic_fluid() {
		return ((String) getAttrVal("Name_amniotic_fluid"));
	}	
	public void setName_amniotic_fluid(String Name_amniotic_fluid) {
		setAttrVal("Name_amniotic_fluid", Name_amniotic_fluid);
	}
	public String getName_numamnfluid() {
		return ((String) getAttrVal("Name_numamnfluid"));
	}	
	public void setName_numamnfluid(String Name_numamnfluid) {
		setAttrVal("Name_numamnfluid", Name_numamnfluid);
	}
	public String getName_surgery() {
		return ((String) getAttrVal("Name_surgery"));
	}	
	public void setName_surgery(String Name_surgery) {
		setAttrVal("Name_surgery", Name_surgery);
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
		return "Id_regform";
	}
	
	@Override
	public String getTableName() {	  
		return "MMR_PKUF_REGFORM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RegformDODesc.class);
	}
	
}