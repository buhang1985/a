package iih.ci.mr.nu.intervopre.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.intervopre.d.desc.InterPatInfoDODesc;
import java.math.BigDecimal;

/**
 * 介入手术患者信息 DO数据 
 * 
 */
public class InterPatInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATINFO= "Id_patinfo";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String AGE= "Age";
	public static final String ID_DIAGNOSIS= "Id_diagnosis";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String OPER_NAME= "Oper_name";
	public static final String OPER_DR= "Oper_dr";
	public static final String OPER_NURSE= "Oper_nurse";
	public static final String ID_SIG_WARDNURSE= "Id_sig_wardnurse";
	public static final String ID_SIG_ITVN= "Id_sig_itvn";
	public static final String SUPPLEMENT= "Supplement";
	public static final String TEMP= "Temp";
	public static final String HUMIDITY= "Humidity";
	public static final String D_OPER= "D_oper";
	public static final String T_RTN_WARD= "T_rtn_ward";
	public static final String ID_DISINFECT_OBJ= "Id_disinfect_obj";
	public static final String SD_DISINFECT_OBJ= "Sd_disinfect_obj";
	public static final String ID_PAT_PRE= "Id_pat_pre";
	public static final String SD_PAT_PRE= "Sd_pat_pre";
	public static final String ID_OPER_POS= "Id_oper_pos";
	public static final String SD_OPER_POS= "Sd_oper_pos";
	public static final String ID_ANA_TP= "Id_ana_tp";
	public static final String SD_ANA_TP= "Sd_ana_tp";
	public static final String ID_PUNC_POS= "Id_punc_pos";
	public static final String SD_PUNC_POS= "Sd_punc_pos";
	public static final String ENUM_OBJ_COND= "Enum_obj_cond";
	public static final String ENUM_MENTAL_COND= "Enum_mental_cond";
	public static final String ENUM_COOP_ABILITY= "Enum_coop_ability";
	public static final String ENUM_COOP_TRAIN= "Enum_coop_train";
	public static final String ENUM_PULSE_COND= "Enum_pulse_cond";
	public static final String ID_SIGNATURE= "Id_signature";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OPER= "Name_oper";
	public static final String NAME_OPER_DR= "Name_oper_dr";
	public static final String NAME_OPER_NURSE= "Name_oper_nurse";
	public static final String NAME_SIG_WARDNURSE= "Name_sig_wardnurse";
	public static final String NAME_SIG_ITVN= "Name_sig_itvn";
	public static final String NAME_DISINFECT_OBJ= "Name_disinfect_obj";
	public static final String NAME_PAT_PRE= "Name_pat_pre";
	public static final String NAME_OPER_POS= "Name_oper_pos";
	public static final String NAME_ANA_TP= "Name_ana_tp";
	public static final String NAME_PUNC_POS= "Name_punc_pos";
	public static final String NAME_SIGNATURE= "Name_signature";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patinfo() {
		return ((String) getAttrVal("Id_patinfo"));
	}	
	public void setId_patinfo(String Id_patinfo) {
		setAttrVal("Id_patinfo", Id_patinfo);
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
	public String getOper_name() {
		return ((String) getAttrVal("Oper_name"));
	}	
	public void setOper_name(String Oper_name) {
		setAttrVal("Oper_name", Oper_name);
	}
	public String getOper_dr() {
		return ((String) getAttrVal("Oper_dr"));
	}	
	public void setOper_dr(String Oper_dr) {
		setAttrVal("Oper_dr", Oper_dr);
	}
	public String getOper_nurse() {
		return ((String) getAttrVal("Oper_nurse"));
	}	
	public void setOper_nurse(String Oper_nurse) {
		setAttrVal("Oper_nurse", Oper_nurse);
	}
	public String getId_sig_wardnurse() {
		return ((String) getAttrVal("Id_sig_wardnurse"));
	}	
	public void setId_sig_wardnurse(String Id_sig_wardnurse) {
		setAttrVal("Id_sig_wardnurse", Id_sig_wardnurse);
	}
	public String getId_sig_itvn() {
		return ((String) getAttrVal("Id_sig_itvn"));
	}	
	public void setId_sig_itvn(String Id_sig_itvn) {
		setAttrVal("Id_sig_itvn", Id_sig_itvn);
	}
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}	
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	public FDouble getTemp() {
		return ((FDouble) getAttrVal("Temp"));
	}	
	public void setTemp(FDouble Temp) {
		setAttrVal("Temp", Temp);
	}
	public FDouble getHumidity() {
		return ((FDouble) getAttrVal("Humidity"));
	}	
	public void setHumidity(FDouble Humidity) {
		setAttrVal("Humidity", Humidity);
	}
	public FDate getD_oper() {
		return ((FDate) getAttrVal("D_oper"));
	}	
	public void setD_oper(FDate D_oper) {
		setAttrVal("D_oper", D_oper);
	}
	public FTime getT_rtn_ward() {
		return ((FTime) getAttrVal("T_rtn_ward"));
	}	
	public void setT_rtn_ward(FTime T_rtn_ward) {
		setAttrVal("T_rtn_ward", T_rtn_ward);
	}
	public String getId_disinfect_obj() {
		return ((String) getAttrVal("Id_disinfect_obj"));
	}	
	public void setId_disinfect_obj(String Id_disinfect_obj) {
		setAttrVal("Id_disinfect_obj", Id_disinfect_obj);
	}
	public String getSd_disinfect_obj() {
		return ((String) getAttrVal("Sd_disinfect_obj"));
	}	
	public void setSd_disinfect_obj(String Sd_disinfect_obj) {
		setAttrVal("Sd_disinfect_obj", Sd_disinfect_obj);
	}
	public String getId_pat_pre() {
		return ((String) getAttrVal("Id_pat_pre"));
	}	
	public void setId_pat_pre(String Id_pat_pre) {
		setAttrVal("Id_pat_pre", Id_pat_pre);
	}
	public String getSd_pat_pre() {
		return ((String) getAttrVal("Sd_pat_pre"));
	}	
	public void setSd_pat_pre(String Sd_pat_pre) {
		setAttrVal("Sd_pat_pre", Sd_pat_pre);
	}
	public String getId_oper_pos() {
		return ((String) getAttrVal("Id_oper_pos"));
	}	
	public void setId_oper_pos(String Id_oper_pos) {
		setAttrVal("Id_oper_pos", Id_oper_pos);
	}
	public String getSd_oper_pos() {
		return ((String) getAttrVal("Sd_oper_pos"));
	}	
	public void setSd_oper_pos(String Sd_oper_pos) {
		setAttrVal("Sd_oper_pos", Sd_oper_pos);
	}
	public String getId_ana_tp() {
		return ((String) getAttrVal("Id_ana_tp"));
	}	
	public void setId_ana_tp(String Id_ana_tp) {
		setAttrVal("Id_ana_tp", Id_ana_tp);
	}
	public String getSd_ana_tp() {
		return ((String) getAttrVal("Sd_ana_tp"));
	}	
	public void setSd_ana_tp(String Sd_ana_tp) {
		setAttrVal("Sd_ana_tp", Sd_ana_tp);
	}
	public String getId_punc_pos() {
		return ((String) getAttrVal("Id_punc_pos"));
	}	
	public void setId_punc_pos(String Id_punc_pos) {
		setAttrVal("Id_punc_pos", Id_punc_pos);
	}
	public String getSd_punc_pos() {
		return ((String) getAttrVal("Sd_punc_pos"));
	}	
	public void setSd_punc_pos(String Sd_punc_pos) {
		setAttrVal("Sd_punc_pos", Sd_punc_pos);
	}
	public Integer getEnum_obj_cond() {
		return ((Integer) getAttrVal("Enum_obj_cond"));
	}	
	public void setEnum_obj_cond(Integer Enum_obj_cond) {
		setAttrVal("Enum_obj_cond", Enum_obj_cond);
	}
	public Integer getEnum_mental_cond() {
		return ((Integer) getAttrVal("Enum_mental_cond"));
	}	
	public void setEnum_mental_cond(Integer Enum_mental_cond) {
		setAttrVal("Enum_mental_cond", Enum_mental_cond);
	}
	public Integer getEnum_coop_ability() {
		return ((Integer) getAttrVal("Enum_coop_ability"));
	}	
	public void setEnum_coop_ability(Integer Enum_coop_ability) {
		setAttrVal("Enum_coop_ability", Enum_coop_ability);
	}
	public Integer getEnum_coop_train() {
		return ((Integer) getAttrVal("Enum_coop_train"));
	}	
	public void setEnum_coop_train(Integer Enum_coop_train) {
		setAttrVal("Enum_coop_train", Enum_coop_train);
	}
	public Integer getEnum_pulse_cond() {
		return ((Integer) getAttrVal("Enum_pulse_cond"));
	}	
	public void setEnum_pulse_cond(Integer Enum_pulse_cond) {
		setAttrVal("Enum_pulse_cond", Enum_pulse_cond);
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
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	public String getName_oper_dr() {
		return ((String) getAttrVal("Name_oper_dr"));
	}	
	public void setName_oper_dr(String Name_oper_dr) {
		setAttrVal("Name_oper_dr", Name_oper_dr);
	}
	public String getName_oper_nurse() {
		return ((String) getAttrVal("Name_oper_nurse"));
	}	
	public void setName_oper_nurse(String Name_oper_nurse) {
		setAttrVal("Name_oper_nurse", Name_oper_nurse);
	}
	public String getName_sig_wardnurse() {
		return ((String) getAttrVal("Name_sig_wardnurse"));
	}	
	public void setName_sig_wardnurse(String Name_sig_wardnurse) {
		setAttrVal("Name_sig_wardnurse", Name_sig_wardnurse);
	}
	public String getName_sig_itvn() {
		return ((String) getAttrVal("Name_sig_itvn"));
	}	
	public void setName_sig_itvn(String Name_sig_itvn) {
		setAttrVal("Name_sig_itvn", Name_sig_itvn);
	}
	public String getName_disinfect_obj() {
		return ((String) getAttrVal("Name_disinfect_obj"));
	}	
	public void setName_disinfect_obj(String Name_disinfect_obj) {
		setAttrVal("Name_disinfect_obj", Name_disinfect_obj);
	}
	public String getName_pat_pre() {
		return ((String) getAttrVal("Name_pat_pre"));
	}	
	public void setName_pat_pre(String Name_pat_pre) {
		setAttrVal("Name_pat_pre", Name_pat_pre);
	}
	public String getName_oper_pos() {
		return ((String) getAttrVal("Name_oper_pos"));
	}	
	public void setName_oper_pos(String Name_oper_pos) {
		setAttrVal("Name_oper_pos", Name_oper_pos);
	}
	public String getName_ana_tp() {
		return ((String) getAttrVal("Name_ana_tp"));
	}	
	public void setName_ana_tp(String Name_ana_tp) {
		setAttrVal("Name_ana_tp", Name_ana_tp);
	}
	public String getName_punc_pos() {
		return ((String) getAttrVal("Name_punc_pos"));
	}	
	public void setName_punc_pos(String Name_punc_pos) {
		setAttrVal("Name_punc_pos", Name_punc_pos);
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
		return "Id_patinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_INTERPATINFO";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InterPatInfoDODesc.class);
	}
	
}