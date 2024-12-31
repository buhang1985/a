package iih.nmr.pkuf.deliveryrec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.deliveryrec.d.desc.DeliveryrecDODesc;
import java.math.BigDecimal;

/**
 * 分娩记录单 DO数据 
 * 
 */
public class DeliveryrecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DELIVERYREC= "Id_deliveryrec";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_BED= "Name_bed";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_SIGN= "Id_sign";
	public static final String DT_CREATE= "Dt_create";
	public static final String DT_UC_B= "Dt_uc_b";
	public static final String DT_ORIFICE_UTERUS= "Dt_orifice_uterus";
	public static final String DT_MEMBRANES= "Dt_membranes";
	public static final String ID_R_MEMBRANES= "Id_r_membranes";
	public static final String SD_R_MEMBRANES= "Sd_r_membranes";
	public static final String NAME_MEMBRAN= "Name_membran";
	public static final String DT_OUT_INFANT= "Dt_out_infant";
	public static final String ID_WAY_INFANT= "Id_way_infant";
	public static final String SD_WAY_INFANT= "Sd_way_infant";
	public static final String NAME_WAY_INFANT= "Name_way_infant";
	public static final String DT_PLACENTA= "Dt_placenta";
	public static final String ID_WAY_PLACENTA= "Id_way_placenta";
	public static final String SD_WAY_PLACENTA= "Sd_way_placenta";
	public static final String NAME_WAY_PLACEN= "Name_way_placen";
	public static final String ID_CONDI_AMNIOTIC= "Id_condi_amniotic";
	public static final String SD_CONDI_AMNIOTIC= "Sd_condi_amniotic";
	public static final String NAME_CONDI_AMNIC= "Name_condi_amnic";
	public static final String ID_POSITATION= "Id_positation";
	public static final String SD_POSITATION= "Sd_positation";
	public static final String NAME_POSITATION= "Name_positation";
	public static final String LEN_PLACENTA= "Len_placenta";
	public static final String WIDTH_PLACENTA= "Width_placenta";
	public static final String HEIGHT_PLACENTA= "Height_placenta";
	public static final String ID_CHECK_PLACENTA= "Id_check_placenta";
	public static final String SD_CHECK_PLACENTA= "Sd_check_placenta";
	public static final String NAME_CHECK_PLACE= "Name_check_place";
	public static final String WEIGHT_PLACENTA= "Weight_placenta";
	public static final String SHAP_PLACENTA= "Shap_placenta";
	public static final String ID_ADHERE_UMBILI= "Id_adhere_umbili";
	public static final String SD_ADHERE_UMBILI= "Sd_adhere_umbili";
	public static final String NAME_ADHERE_UM= "Name_adhere_um";
	public static final String LEN_UMBILI= "Len_umbili";
	public static final String FIRST_LABOR_H= "First_labor_h";
	public static final String FIRST_LABOR_M= "First_labor_m";
	public static final String SECOND_LABOR_H= "Second_labor_h";
	public static final String SECOND_LABOR_M= "Second_labor_m";
	public static final String THIRD_LABOR_H= "Third_labor_h";
	public static final String THIRD_LABOR_M= "Third_labor_m";
	public static final String FOUTH_LABOR_H= "Fouth_labor_h";
	public static final String FOUTH_LABOR_M= "Fouth_labor_m";
	public static final String WHOLE_LABOR= "Whole_labor";
	public static final String ID_PERINEAL_RUPTURE= "Id_perineal_rupture";
	public static final String SD_PERINEAL_RUPTURE= "Sd_perineal_rupture";
	public static final String NAME_PERINEAL_RUP= "Name_perineal_rup";
	public static final String ID_PERINEAL_SUTURE= "Id_perineal_suture";
	public static final String SD_PERINEAL_SUTURE= "Sd_perineal_suture";
	public static final String NAME_PERINEAL_SUT= "Name_perineal_sut";
	public static final String PRO_DRUG= "Pro_drug";
	public static final String SYS_PRE_THIRTY= "Sys_pre_thirty";
	public static final String DIA_PRE= "Dia_pre";
	public static final String DIA_PRE_THIRTY= "Dia_pre_thirty";
	public static final String SYS_PRE= "Sys_pre";
	public static final String SYS_PRE_ONE= "Sys_pre_one";
	public static final String DIA_PRE_ONE= "Dia_pre_one";
	public static final String SYS_PRE_TWO= "Sys_pre_two";
	public static final String DIA_PRE_TWO= "Dia_pre_two";
	public static final String LOSE_BLOOD= "Lose_blood";
	public static final String LOSE_BLOOD_THIRTY= "Lose_blood_thirty";
	public static final String LOSE_BLOOD_ONE= "Lose_blood_one";
	public static final String LOSE_BLOOD_TWO= "Lose_blood_two";
	public static final String ID_PRO_UC= "Id_pro_uc";
	public static final String SD_PRO_UC= "Sd_pro_uc";
	public static final String NAME_PRO_UC= "Name_pro_uc";
	public static final String ID_DELIVERY_ANALGESIA= "Id_delivery_analgesia";
	public static final String SD_DELIVERY_ANALGESIA= "Sd_delivery_analgesia";
	public static final String NAME_DELIVERY_ANA= "Name_delivery_ana";
	public static final String INFANT_MALE= "Infant_male";
	public static final String INFANT_FEMALE= "Infant_female";
	public static final String INFANT_SEX= "Infant_sex";
	public static final String INFANT_LENGTH= "Infant_length";
	public static final String INFANT_WEIGHT= "Infant_weight";
	public static final String ID_INFANT_STIFLE= "Id_infant_stifle";
	public static final String SD_INFANT_STIFLE= "Sd_infant_stifle";
	public static final String NAME_INFANT_STIFLE= "Name_infant_stifle";
	public static final String INFANT_BRETH= "Infant_breth";
	public static final String INFANT_BRETH_FIVE= "Infant_breth_five";
	public static final String INFANT_HEARTBEAT= "Infant_heartbeat";
	public static final String INFANT_HEARTBEAT_FIVE= "Infant_heartbeat_five";
	public static final String INFANT_COLOR= "Infant_color";
	public static final String INFANT_COLOR_FIVE= "Infant_color_five";
	public static final String INFANT_STIMULATE= "Infant_stimulate";
	public static final String INFANT_STIMULATE_FIVE= "Infant_stimulate_five";
	public static final String INFANT_TENSION= "Infant_tension";
	public static final String INFANT_TENSION_FIVE= "Infant_tension_five";
	public static final String PUERPERA_CONDI= "Puerpera_condi";
	public static final String DT_PUERPERA_LAVE= "Dt_puerpera_lave";
	public static final String OTHER= "Other";
	public static final String ID_MIDWIFE= "Id_midwife";
	public static final String ID_SUPERVISOR= "Id_supervisor";
	public static final String CHECK_OTHER= "Check_other";
	public static final String SUTURE_OTHER= "Suture_other";
	public static final String DRUG_OTHER= "Drug_other";
	public static final String UC_OTHER= "Uc_other";
	public static final String ID_OPERATOR= "Id_operator";
	public static final String SD_OPERATOR= "Sd_operator";
	public static final String DIAGNOSIS= "Diagnosis";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_INFANT_SPECIAL= "Id_infant_special";
	public static final String SD_INFANT_SPECIAL= "Sd_infant_special";
	public static final String NAME_INFANT_SPECIAL_CONDI= "Name_infant_special_condi";
	public static final String MEMBRAN_NAME= "Membran_name";
	public static final String WAY_INFANT_NAME= "Way_infant_name";
	public static final String WAY_PLACEN_NAME= "Way_placen_name";
	public static final String CONDI_AMNIC_NAME= "Condi_amnic_name";
	public static final String POSITATION_NAME= "Positation_name";
	public static final String CHECK_PLACE_NAME= "Check_place_name";
	public static final String ADHERE_UM_NAME= "Adhere_um_name";
	public static final String PERINEAL_RUP_NAME= "Perineal_rup_name";
	public static final String PERINEAL_SUT_NAME= "Perineal_sut_name";
	public static final String PRO_UC_NAME= "Pro_uc_name";
	public static final String DELIVERY_ANA_NAME= "Delivery_ana_name";
	public static final String INFANT_STIFLE_NAME= "Infant_stifle_name";
	public static final String NAME_MIDWIFE= "Name_midwife";
	public static final String NAME_SUPERVISOR1= "Name_supervisor1";
	public static final String NAME_OPERATOR= "Name_operator";
	public static final String NAME_INFANT_SPECIAL= "Name_infant_special";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_deliveryrec() {
		return ((String) getAttrVal("Id_deliveryrec"));
	}	
	public void setId_deliveryrec(String Id_deliveryrec) {
		setAttrVal("Id_deliveryrec", Id_deliveryrec);
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
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	public FDateTime getDt_uc_b() {
		return ((FDateTime) getAttrVal("Dt_uc_b"));
	}	
	public void setDt_uc_b(FDateTime Dt_uc_b) {
		setAttrVal("Dt_uc_b", Dt_uc_b);
	}
	public FDateTime getDt_orifice_uterus() {
		return ((FDateTime) getAttrVal("Dt_orifice_uterus"));
	}	
	public void setDt_orifice_uterus(FDateTime Dt_orifice_uterus) {
		setAttrVal("Dt_orifice_uterus", Dt_orifice_uterus);
	}
	public FDateTime getDt_membranes() {
		return ((FDateTime) getAttrVal("Dt_membranes"));
	}	
	public void setDt_membranes(FDateTime Dt_membranes) {
		setAttrVal("Dt_membranes", Dt_membranes);
	}
	public String getId_r_membranes() {
		return ((String) getAttrVal("Id_r_membranes"));
	}	
	public void setId_r_membranes(String Id_r_membranes) {
		setAttrVal("Id_r_membranes", Id_r_membranes);
	}
	public String getSd_r_membranes() {
		return ((String) getAttrVal("Sd_r_membranes"));
	}	
	public void setSd_r_membranes(String Sd_r_membranes) {
		setAttrVal("Sd_r_membranes", Sd_r_membranes);
	}
	public String getName_membran() {
		return ((String) getAttrVal("Name_membran"));
	}	
	public void setName_membran(String Name_membran) {
		setAttrVal("Name_membran", Name_membran);
	}
	public FDateTime getDt_out_infant() {
		return ((FDateTime) getAttrVal("Dt_out_infant"));
	}	
	public void setDt_out_infant(FDateTime Dt_out_infant) {
		setAttrVal("Dt_out_infant", Dt_out_infant);
	}
	public String getId_way_infant() {
		return ((String) getAttrVal("Id_way_infant"));
	}	
	public void setId_way_infant(String Id_way_infant) {
		setAttrVal("Id_way_infant", Id_way_infant);
	}
	public String getSd_way_infant() {
		return ((String) getAttrVal("Sd_way_infant"));
	}	
	public void setSd_way_infant(String Sd_way_infant) {
		setAttrVal("Sd_way_infant", Sd_way_infant);
	}
	public String getName_way_infant() {
		return ((String) getAttrVal("Name_way_infant"));
	}	
	public void setName_way_infant(String Name_way_infant) {
		setAttrVal("Name_way_infant", Name_way_infant);
	}
	public FDateTime getDt_placenta() {
		return ((FDateTime) getAttrVal("Dt_placenta"));
	}	
	public void setDt_placenta(FDateTime Dt_placenta) {
		setAttrVal("Dt_placenta", Dt_placenta);
	}
	public String getId_way_placenta() {
		return ((String) getAttrVal("Id_way_placenta"));
	}	
	public void setId_way_placenta(String Id_way_placenta) {
		setAttrVal("Id_way_placenta", Id_way_placenta);
	}
	public String getSd_way_placenta() {
		return ((String) getAttrVal("Sd_way_placenta"));
	}	
	public void setSd_way_placenta(String Sd_way_placenta) {
		setAttrVal("Sd_way_placenta", Sd_way_placenta);
	}
	public String getName_way_placen() {
		return ((String) getAttrVal("Name_way_placen"));
	}	
	public void setName_way_placen(String Name_way_placen) {
		setAttrVal("Name_way_placen", Name_way_placen);
	}
	public String getId_condi_amniotic() {
		return ((String) getAttrVal("Id_condi_amniotic"));
	}	
	public void setId_condi_amniotic(String Id_condi_amniotic) {
		setAttrVal("Id_condi_amniotic", Id_condi_amniotic);
	}
	public String getSd_condi_amniotic() {
		return ((String) getAttrVal("Sd_condi_amniotic"));
	}	
	public void setSd_condi_amniotic(String Sd_condi_amniotic) {
		setAttrVal("Sd_condi_amniotic", Sd_condi_amniotic);
	}
	public String getName_condi_amnic() {
		return ((String) getAttrVal("Name_condi_amnic"));
	}	
	public void setName_condi_amnic(String Name_condi_amnic) {
		setAttrVal("Name_condi_amnic", Name_condi_amnic);
	}
	public String getId_positation() {
		return ((String) getAttrVal("Id_positation"));
	}	
	public void setId_positation(String Id_positation) {
		setAttrVal("Id_positation", Id_positation);
	}
	public String getSd_positation() {
		return ((String) getAttrVal("Sd_positation"));
	}	
	public void setSd_positation(String Sd_positation) {
		setAttrVal("Sd_positation", Sd_positation);
	}
	public String getName_positation() {
		return ((String) getAttrVal("Name_positation"));
	}	
	public void setName_positation(String Name_positation) {
		setAttrVal("Name_positation", Name_positation);
	}
	public FDouble getLen_placenta() {
		return ((FDouble) getAttrVal("Len_placenta"));
	}	
	public void setLen_placenta(FDouble Len_placenta) {
		setAttrVal("Len_placenta", Len_placenta);
	}
	public FDouble getWidth_placenta() {
		return ((FDouble) getAttrVal("Width_placenta"));
	}	
	public void setWidth_placenta(FDouble Width_placenta) {
		setAttrVal("Width_placenta", Width_placenta);
	}
	public FDouble getHeight_placenta() {
		return ((FDouble) getAttrVal("Height_placenta"));
	}	
	public void setHeight_placenta(FDouble Height_placenta) {
		setAttrVal("Height_placenta", Height_placenta);
	}
	public String getId_check_placenta() {
		return ((String) getAttrVal("Id_check_placenta"));
	}	
	public void setId_check_placenta(String Id_check_placenta) {
		setAttrVal("Id_check_placenta", Id_check_placenta);
	}
	public String getSd_check_placenta() {
		return ((String) getAttrVal("Sd_check_placenta"));
	}	
	public void setSd_check_placenta(String Sd_check_placenta) {
		setAttrVal("Sd_check_placenta", Sd_check_placenta);
	}
	public String getName_check_place() {
		return ((String) getAttrVal("Name_check_place"));
	}	
	public void setName_check_place(String Name_check_place) {
		setAttrVal("Name_check_place", Name_check_place);
	}
	public FDouble getWeight_placenta() {
		return ((FDouble) getAttrVal("Weight_placenta"));
	}	
	public void setWeight_placenta(FDouble Weight_placenta) {
		setAttrVal("Weight_placenta", Weight_placenta);
	}
	public String getShap_placenta() {
		return ((String) getAttrVal("Shap_placenta"));
	}	
	public void setShap_placenta(String Shap_placenta) {
		setAttrVal("Shap_placenta", Shap_placenta);
	}
	public String getId_adhere_umbili() {
		return ((String) getAttrVal("Id_adhere_umbili"));
	}	
	public void setId_adhere_umbili(String Id_adhere_umbili) {
		setAttrVal("Id_adhere_umbili", Id_adhere_umbili);
	}
	public String getSd_adhere_umbili() {
		return ((String) getAttrVal("Sd_adhere_umbili"));
	}	
	public void setSd_adhere_umbili(String Sd_adhere_umbili) {
		setAttrVal("Sd_adhere_umbili", Sd_adhere_umbili);
	}
	public String getName_adhere_um() {
		return ((String) getAttrVal("Name_adhere_um"));
	}	
	public void setName_adhere_um(String Name_adhere_um) {
		setAttrVal("Name_adhere_um", Name_adhere_um);
	}
	public FDouble getLen_umbili() {
		return ((FDouble) getAttrVal("Len_umbili"));
	}	
	public void setLen_umbili(FDouble Len_umbili) {
		setAttrVal("Len_umbili", Len_umbili);
	}
	public String getFirst_labor_h() {
		return ((String) getAttrVal("First_labor_h"));
	}	
	public void setFirst_labor_h(String First_labor_h) {
		setAttrVal("First_labor_h", First_labor_h);
	}
	public String getFirst_labor_m() {
		return ((String) getAttrVal("First_labor_m"));
	}	
	public void setFirst_labor_m(String First_labor_m) {
		setAttrVal("First_labor_m", First_labor_m);
	}
	public String getSecond_labor_h() {
		return ((String) getAttrVal("Second_labor_h"));
	}	
	public void setSecond_labor_h(String Second_labor_h) {
		setAttrVal("Second_labor_h", Second_labor_h);
	}
	public String getSecond_labor_m() {
		return ((String) getAttrVal("Second_labor_m"));
	}	
	public void setSecond_labor_m(String Second_labor_m) {
		setAttrVal("Second_labor_m", Second_labor_m);
	}
	public String getThird_labor_h() {
		return ((String) getAttrVal("Third_labor_h"));
	}	
	public void setThird_labor_h(String Third_labor_h) {
		setAttrVal("Third_labor_h", Third_labor_h);
	}
	public String getThird_labor_m() {
		return ((String) getAttrVal("Third_labor_m"));
	}	
	public void setThird_labor_m(String Third_labor_m) {
		setAttrVal("Third_labor_m", Third_labor_m);
	}
	public String getFouth_labor_h() {
		return ((String) getAttrVal("Fouth_labor_h"));
	}	
	public void setFouth_labor_h(String Fouth_labor_h) {
		setAttrVal("Fouth_labor_h", Fouth_labor_h);
	}
	public String getFouth_labor_m() {
		return ((String) getAttrVal("Fouth_labor_m"));
	}	
	public void setFouth_labor_m(String Fouth_labor_m) {
		setAttrVal("Fouth_labor_m", Fouth_labor_m);
	}
	public String getWhole_labor() {
		return ((String) getAttrVal("Whole_labor"));
	}	
	public void setWhole_labor(String Whole_labor) {
		setAttrVal("Whole_labor", Whole_labor);
	}
	public String getId_perineal_rupture() {
		return ((String) getAttrVal("Id_perineal_rupture"));
	}	
	public void setId_perineal_rupture(String Id_perineal_rupture) {
		setAttrVal("Id_perineal_rupture", Id_perineal_rupture);
	}
	public String getSd_perineal_rupture() {
		return ((String) getAttrVal("Sd_perineal_rupture"));
	}	
	public void setSd_perineal_rupture(String Sd_perineal_rupture) {
		setAttrVal("Sd_perineal_rupture", Sd_perineal_rupture);
	}
	public String getName_perineal_rup() {
		return ((String) getAttrVal("Name_perineal_rup"));
	}	
	public void setName_perineal_rup(String Name_perineal_rup) {
		setAttrVal("Name_perineal_rup", Name_perineal_rup);
	}
	public String getId_perineal_suture() {
		return ((String) getAttrVal("Id_perineal_suture"));
	}	
	public void setId_perineal_suture(String Id_perineal_suture) {
		setAttrVal("Id_perineal_suture", Id_perineal_suture);
	}
	public String getSd_perineal_suture() {
		return ((String) getAttrVal("Sd_perineal_suture"));
	}	
	public void setSd_perineal_suture(String Sd_perineal_suture) {
		setAttrVal("Sd_perineal_suture", Sd_perineal_suture);
	}
	public String getName_perineal_sut() {
		return ((String) getAttrVal("Name_perineal_sut"));
	}	
	public void setName_perineal_sut(String Name_perineal_sut) {
		setAttrVal("Name_perineal_sut", Name_perineal_sut);
	}
	public Integer getPro_drug() {
		return ((Integer) getAttrVal("Pro_drug"));
	}	
	public void setPro_drug(Integer Pro_drug) {
		setAttrVal("Pro_drug", Pro_drug);
	}
	public Integer getSys_pre_thirty() {
		return ((Integer) getAttrVal("Sys_pre_thirty"));
	}	
	public void setSys_pre_thirty(Integer Sys_pre_thirty) {
		setAttrVal("Sys_pre_thirty", Sys_pre_thirty);
	}
	public Integer getDia_pre() {
		return ((Integer) getAttrVal("Dia_pre"));
	}	
	public void setDia_pre(Integer Dia_pre) {
		setAttrVal("Dia_pre", Dia_pre);
	}
	public Integer getDia_pre_thirty() {
		return ((Integer) getAttrVal("Dia_pre_thirty"));
	}	
	public void setDia_pre_thirty(Integer Dia_pre_thirty) {
		setAttrVal("Dia_pre_thirty", Dia_pre_thirty);
	}
	public Integer getSys_pre() {
		return ((Integer) getAttrVal("Sys_pre"));
	}	
	public void setSys_pre(Integer Sys_pre) {
		setAttrVal("Sys_pre", Sys_pre);
	}
	public Integer getSys_pre_one() {
		return ((Integer) getAttrVal("Sys_pre_one"));
	}	
	public void setSys_pre_one(Integer Sys_pre_one) {
		setAttrVal("Sys_pre_one", Sys_pre_one);
	}
	public Integer getDia_pre_one() {
		return ((Integer) getAttrVal("Dia_pre_one"));
	}	
	public void setDia_pre_one(Integer Dia_pre_one) {
		setAttrVal("Dia_pre_one", Dia_pre_one);
	}
	public Integer getSys_pre_two() {
		return ((Integer) getAttrVal("Sys_pre_two"));
	}	
	public void setSys_pre_two(Integer Sys_pre_two) {
		setAttrVal("Sys_pre_two", Sys_pre_two);
	}
	public Integer getDia_pre_two() {
		return ((Integer) getAttrVal("Dia_pre_two"));
	}	
	public void setDia_pre_two(Integer Dia_pre_two) {
		setAttrVal("Dia_pre_two", Dia_pre_two);
	}
	public Integer getLose_blood() {
		return ((Integer) getAttrVal("Lose_blood"));
	}	
	public void setLose_blood(Integer Lose_blood) {
		setAttrVal("Lose_blood", Lose_blood);
	}
	public Integer getLose_blood_thirty() {
		return ((Integer) getAttrVal("Lose_blood_thirty"));
	}	
	public void setLose_blood_thirty(Integer Lose_blood_thirty) {
		setAttrVal("Lose_blood_thirty", Lose_blood_thirty);
	}
	public Integer getLose_blood_one() {
		return ((Integer) getAttrVal("Lose_blood_one"));
	}	
	public void setLose_blood_one(Integer Lose_blood_one) {
		setAttrVal("Lose_blood_one", Lose_blood_one);
	}
	public Integer getLose_blood_two() {
		return ((Integer) getAttrVal("Lose_blood_two"));
	}	
	public void setLose_blood_two(Integer Lose_blood_two) {
		setAttrVal("Lose_blood_two", Lose_blood_two);
	}
	public String getId_pro_uc() {
		return ((String) getAttrVal("Id_pro_uc"));
	}	
	public void setId_pro_uc(String Id_pro_uc) {
		setAttrVal("Id_pro_uc", Id_pro_uc);
	}
	public String getSd_pro_uc() {
		return ((String) getAttrVal("Sd_pro_uc"));
	}	
	public void setSd_pro_uc(String Sd_pro_uc) {
		setAttrVal("Sd_pro_uc", Sd_pro_uc);
	}
	public String getName_pro_uc() {
		return ((String) getAttrVal("Name_pro_uc"));
	}	
	public void setName_pro_uc(String Name_pro_uc) {
		setAttrVal("Name_pro_uc", Name_pro_uc);
	}
	public String getId_delivery_analgesia() {
		return ((String) getAttrVal("Id_delivery_analgesia"));
	}	
	public void setId_delivery_analgesia(String Id_delivery_analgesia) {
		setAttrVal("Id_delivery_analgesia", Id_delivery_analgesia);
	}
	public String getSd_delivery_analgesia() {
		return ((String) getAttrVal("Sd_delivery_analgesia"));
	}	
	public void setSd_delivery_analgesia(String Sd_delivery_analgesia) {
		setAttrVal("Sd_delivery_analgesia", Sd_delivery_analgesia);
	}
	public String getName_delivery_ana() {
		return ((String) getAttrVal("Name_delivery_ana"));
	}	
	public void setName_delivery_ana(String Name_delivery_ana) {
		setAttrVal("Name_delivery_ana", Name_delivery_ana);
	}
	public Integer getInfant_male() {
		return ((Integer) getAttrVal("Infant_male"));
	}	
	public void setInfant_male(Integer Infant_male) {
		setAttrVal("Infant_male", Infant_male);
	}
	public Integer getInfant_female() {
		return ((Integer) getAttrVal("Infant_female"));
	}	
	public void setInfant_female(Integer Infant_female) {
		setAttrVal("Infant_female", Infant_female);
	}
	public String getInfant_sex() {
		return ((String) getAttrVal("Infant_sex"));
	}	
	public void setInfant_sex(String Infant_sex) {
		setAttrVal("Infant_sex", Infant_sex);
	}
	public FDouble getInfant_length() {
		return ((FDouble) getAttrVal("Infant_length"));
	}	
	public void setInfant_length(FDouble Infant_length) {
		setAttrVal("Infant_length", Infant_length);
	}
	public FDouble getInfant_weight() {
		return ((FDouble) getAttrVal("Infant_weight"));
	}	
	public void setInfant_weight(FDouble Infant_weight) {
		setAttrVal("Infant_weight", Infant_weight);
	}
	public String getId_infant_stifle() {
		return ((String) getAttrVal("Id_infant_stifle"));
	}	
	public void setId_infant_stifle(String Id_infant_stifle) {
		setAttrVal("Id_infant_stifle", Id_infant_stifle);
	}
	public String getSd_infant_stifle() {
		return ((String) getAttrVal("Sd_infant_stifle"));
	}	
	public void setSd_infant_stifle(String Sd_infant_stifle) {
		setAttrVal("Sd_infant_stifle", Sd_infant_stifle);
	}
	public String getName_infant_stifle() {
		return ((String) getAttrVal("Name_infant_stifle"));
	}	
	public void setName_infant_stifle(String Name_infant_stifle) {
		setAttrVal("Name_infant_stifle", Name_infant_stifle);
	}
	public Integer getInfant_breth() {
		return ((Integer) getAttrVal("Infant_breth"));
	}	
	public void setInfant_breth(Integer Infant_breth) {
		setAttrVal("Infant_breth", Infant_breth);
	}
	public Integer getInfant_breth_five() {
		return ((Integer) getAttrVal("Infant_breth_five"));
	}	
	public void setInfant_breth_five(Integer Infant_breth_five) {
		setAttrVal("Infant_breth_five", Infant_breth_five);
	}
	public Integer getInfant_heartbeat() {
		return ((Integer) getAttrVal("Infant_heartbeat"));
	}	
	public void setInfant_heartbeat(Integer Infant_heartbeat) {
		setAttrVal("Infant_heartbeat", Infant_heartbeat);
	}
	public Integer getInfant_heartbeat_five() {
		return ((Integer) getAttrVal("Infant_heartbeat_five"));
	}	
	public void setInfant_heartbeat_five(Integer Infant_heartbeat_five) {
		setAttrVal("Infant_heartbeat_five", Infant_heartbeat_five);
	}
	public Integer getInfant_color() {
		return ((Integer) getAttrVal("Infant_color"));
	}	
	public void setInfant_color(Integer Infant_color) {
		setAttrVal("Infant_color", Infant_color);
	}
	public Integer getInfant_color_five() {
		return ((Integer) getAttrVal("Infant_color_five"));
	}	
	public void setInfant_color_five(Integer Infant_color_five) {
		setAttrVal("Infant_color_five", Infant_color_five);
	}
	public Integer getInfant_stimulate() {
		return ((Integer) getAttrVal("Infant_stimulate"));
	}	
	public void setInfant_stimulate(Integer Infant_stimulate) {
		setAttrVal("Infant_stimulate", Infant_stimulate);
	}
	public Integer getInfant_stimulate_five() {
		return ((Integer) getAttrVal("Infant_stimulate_five"));
	}	
	public void setInfant_stimulate_five(Integer Infant_stimulate_five) {
		setAttrVal("Infant_stimulate_five", Infant_stimulate_five);
	}
	public Integer getInfant_tension() {
		return ((Integer) getAttrVal("Infant_tension"));
	}	
	public void setInfant_tension(Integer Infant_tension) {
		setAttrVal("Infant_tension", Infant_tension);
	}
	public Integer getInfant_tension_five() {
		return ((Integer) getAttrVal("Infant_tension_five"));
	}	
	public void setInfant_tension_five(Integer Infant_tension_five) {
		setAttrVal("Infant_tension_five", Infant_tension_five);
	}
	public String getPuerpera_condi() {
		return ((String) getAttrVal("Puerpera_condi"));
	}	
	public void setPuerpera_condi(String Puerpera_condi) {
		setAttrVal("Puerpera_condi", Puerpera_condi);
	}
	public FTime getDt_puerpera_lave() {
		return ((FTime) getAttrVal("Dt_puerpera_lave"));
	}	
	public void setDt_puerpera_lave(FTime Dt_puerpera_lave) {
		setAttrVal("Dt_puerpera_lave", Dt_puerpera_lave);
	}
	public String getOther() {
		return ((String) getAttrVal("Other"));
	}	
	public void setOther(String Other) {
		setAttrVal("Other", Other);
	}
	public String getId_midwife() {
		return ((String) getAttrVal("Id_midwife"));
	}	
	public void setId_midwife(String Id_midwife) {
		setAttrVal("Id_midwife", Id_midwife);
	}
	public String getId_supervisor() {
		return ((String) getAttrVal("Id_supervisor"));
	}	
	public void setId_supervisor(String Id_supervisor) {
		setAttrVal("Id_supervisor", Id_supervisor);
	}
	public String getCheck_other() {
		return ((String) getAttrVal("Check_other"));
	}	
	public void setCheck_other(String Check_other) {
		setAttrVal("Check_other", Check_other);
	}
	public Integer getSuture_other() {
		return ((Integer) getAttrVal("Suture_other"));
	}	
	public void setSuture_other(Integer Suture_other) {
		setAttrVal("Suture_other", Suture_other);
	}
	public String getDrug_other() {
		return ((String) getAttrVal("Drug_other"));
	}	
	public void setDrug_other(String Drug_other) {
		setAttrVal("Drug_other", Drug_other);
	}
	public String getUc_other() {
		return ((String) getAttrVal("Uc_other"));
	}	
	public void setUc_other(String Uc_other) {
		setAttrVal("Uc_other", Uc_other);
	}
	public String getId_operator() {
		return ((String) getAttrVal("Id_operator"));
	}	
	public void setId_operator(String Id_operator) {
		setAttrVal("Id_operator", Id_operator);
	}
	public String getSd_operator() {
		return ((String) getAttrVal("Sd_operator"));
	}	
	public void setSd_operator(String Sd_operator) {
		setAttrVal("Sd_operator", Sd_operator);
	}
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}	
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
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
	public String getId_infant_special() {
		return ((String) getAttrVal("Id_infant_special"));
	}	
	public void setId_infant_special(String Id_infant_special) {
		setAttrVal("Id_infant_special", Id_infant_special);
	}
	public String getSd_infant_special() {
		return ((String) getAttrVal("Sd_infant_special"));
	}	
	public void setSd_infant_special(String Sd_infant_special) {
		setAttrVal("Sd_infant_special", Sd_infant_special);
	}
	public String getName_infant_special_condi() {
		return ((String) getAttrVal("Name_infant_special_condi"));
	}	
	public void setName_infant_special_condi(String Name_infant_special_condi) {
		setAttrVal("Name_infant_special_condi", Name_infant_special_condi);
	}
	public String getMembran_name() {
		return ((String) getAttrVal("Membran_name"));
	}	
	public void setMembran_name(String Membran_name) {
		setAttrVal("Membran_name", Membran_name);
	}
	public String getWay_infant_name() {
		return ((String) getAttrVal("Way_infant_name"));
	}	
	public void setWay_infant_name(String Way_infant_name) {
		setAttrVal("Way_infant_name", Way_infant_name);
	}
	public String getWay_placen_name() {
		return ((String) getAttrVal("Way_placen_name"));
	}	
	public void setWay_placen_name(String Way_placen_name) {
		setAttrVal("Way_placen_name", Way_placen_name);
	}
	public String getCondi_amnic_name() {
		return ((String) getAttrVal("Condi_amnic_name"));
	}	
	public void setCondi_amnic_name(String Condi_amnic_name) {
		setAttrVal("Condi_amnic_name", Condi_amnic_name);
	}
	public String getPositation_name() {
		return ((String) getAttrVal("Positation_name"));
	}	
	public void setPositation_name(String Positation_name) {
		setAttrVal("Positation_name", Positation_name);
	}
	public String getCheck_place_name() {
		return ((String) getAttrVal("Check_place_name"));
	}	
	public void setCheck_place_name(String Check_place_name) {
		setAttrVal("Check_place_name", Check_place_name);
	}
	public String getAdhere_um_name() {
		return ((String) getAttrVal("Adhere_um_name"));
	}	
	public void setAdhere_um_name(String Adhere_um_name) {
		setAttrVal("Adhere_um_name", Adhere_um_name);
	}
	public String getPerineal_rup_name() {
		return ((String) getAttrVal("Perineal_rup_name"));
	}	
	public void setPerineal_rup_name(String Perineal_rup_name) {
		setAttrVal("Perineal_rup_name", Perineal_rup_name);
	}
	public String getPerineal_sut_name() {
		return ((String) getAttrVal("Perineal_sut_name"));
	}	
	public void setPerineal_sut_name(String Perineal_sut_name) {
		setAttrVal("Perineal_sut_name", Perineal_sut_name);
	}
	public String getPro_uc_name() {
		return ((String) getAttrVal("Pro_uc_name"));
	}	
	public void setPro_uc_name(String Pro_uc_name) {
		setAttrVal("Pro_uc_name", Pro_uc_name);
	}
	public String getDelivery_ana_name() {
		return ((String) getAttrVal("Delivery_ana_name"));
	}	
	public void setDelivery_ana_name(String Delivery_ana_name) {
		setAttrVal("Delivery_ana_name", Delivery_ana_name);
	}
	public String getInfant_stifle_name() {
		return ((String) getAttrVal("Infant_stifle_name"));
	}	
	public void setInfant_stifle_name(String Infant_stifle_name) {
		setAttrVal("Infant_stifle_name", Infant_stifle_name);
	}
	public String getName_midwife() {
		return ((String) getAttrVal("Name_midwife"));
	}	
	public void setName_midwife(String Name_midwife) {
		setAttrVal("Name_midwife", Name_midwife);
	}
	public String getName_supervisor1() {
		return ((String) getAttrVal("Name_supervisor1"));
	}	
	public void setName_supervisor1(String Name_supervisor1) {
		setAttrVal("Name_supervisor1", Name_supervisor1);
	}
	public String getName_operator() {
		return ((String) getAttrVal("Name_operator"));
	}	
	public void setName_operator(String Name_operator) {
		setAttrVal("Name_operator", Name_operator);
	}
	public String getName_infant_special() {
		return ((String) getAttrVal("Name_infant_special"));
	}	
	public void setName_infant_special(String Name_infant_special) {
		setAttrVal("Name_infant_special", Name_infant_special);
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
		return "Id_deliveryrec";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_DELIVER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DeliveryrecDODesc.class);
	}
	
}