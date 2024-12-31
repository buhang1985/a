package iih.nm.nit.nitpsncyc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpsncyc.d.desc.NitPsnCycDODesc;
import java.math.BigDecimal;

/**
 * 科室轮转 DO数据 
 * 
 */
public class NitPsnCycDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PSN_CYC= "Id_psn_cyc";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PRACGRP_PL= "Id_pracgrp_pl";
	public static final String ID_PRAC_PL= "Id_prac_pl";
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	public static final String ID_PRACGRP= "Id_pracgrp";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String GRADE= "Grade";
	public static final String ID_GRD_LVL= "Id_grd_lvl";
	public static final String SD_GRD_LVL= "Sd_grd_lvl";
	public static final String ACT_GRADE= "Act_grade";
	public static final String ID_ACT_GRD_LVL= "Id_act_grd_lvl";
	public static final String SD_ACT_GRD_LVL= "Sd_act_grd_lvl";
	public static final String GPA= "Gpa";
	public static final String ID_APPRA= "Id_appra";
	public static final String SD_APPRA= "Sd_appra";
	public static final String SEL_ASS= "Sel_ass";
	public static final String DEP_ASS= "Dep_ass";
	public static final String PRA_CLUA= "Pra_clua";
	public static final String FG_PASS= "Fg_pass";
	public static final String ID_REG= "Id_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String COUNT_WEEK= "Count_week";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_NIT_PSNINFO= "Name_nit_psninfo";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_GRD_LVL= "Name_grd_lvl";
	public static final String NAME_ACT_GRADE= "Name_act_grade";
	public static final String NAME_APPRA= "Name_appra";
	public static final String NAME_REG= "Name_reg";
	public static final String NAME_STATUS= "Name_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_psn_cyc() {
		return ((String) getAttrVal("Id_psn_cyc"));
	}	
	public void setId_psn_cyc(String Id_psn_cyc) {
		setAttrVal("Id_psn_cyc", Id_psn_cyc);
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
	public String getId_pracgrp_pl() {
		return ((String) getAttrVal("Id_pracgrp_pl"));
	}	
	public void setId_pracgrp_pl(String Id_pracgrp_pl) {
		setAttrVal("Id_pracgrp_pl", Id_pracgrp_pl);
	}
	public String getId_prac_pl() {
		return ((String) getAttrVal("Id_prac_pl"));
	}	
	public void setId_prac_pl(String Id_prac_pl) {
		setAttrVal("Id_prac_pl", Id_prac_pl);
	}
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}	
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
	}
	public String getId_pracgrp() {
		return ((String) getAttrVal("Id_pracgrp"));
	}	
	public void setId_pracgrp(String Id_pracgrp) {
		setAttrVal("Id_pracgrp", Id_pracgrp);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FDouble getGrade() {
		return ((FDouble) getAttrVal("Grade"));
	}	
	public void setGrade(FDouble Grade) {
		setAttrVal("Grade", Grade);
	}
	public String getId_grd_lvl() {
		return ((String) getAttrVal("Id_grd_lvl"));
	}	
	public void setId_grd_lvl(String Id_grd_lvl) {
		setAttrVal("Id_grd_lvl", Id_grd_lvl);
	}
	public String getSd_grd_lvl() {
		return ((String) getAttrVal("Sd_grd_lvl"));
	}	
	public void setSd_grd_lvl(String Sd_grd_lvl) {
		setAttrVal("Sd_grd_lvl", Sd_grd_lvl);
	}
	public FDouble getAct_grade() {
		return ((FDouble) getAttrVal("Act_grade"));
	}	
	public void setAct_grade(FDouble Act_grade) {
		setAttrVal("Act_grade", Act_grade);
	}
	public String getId_act_grd_lvl() {
		return ((String) getAttrVal("Id_act_grd_lvl"));
	}	
	public void setId_act_grd_lvl(String Id_act_grd_lvl) {
		setAttrVal("Id_act_grd_lvl", Id_act_grd_lvl);
	}
	public String getSd_act_grd_lvl() {
		return ((String) getAttrVal("Sd_act_grd_lvl"));
	}	
	public void setSd_act_grd_lvl(String Sd_act_grd_lvl) {
		setAttrVal("Sd_act_grd_lvl", Sd_act_grd_lvl);
	}
	public FDouble getGpa() {
		return ((FDouble) getAttrVal("Gpa"));
	}	
	public void setGpa(FDouble Gpa) {
		setAttrVal("Gpa", Gpa);
	}
	public String getId_appra() {
		return ((String) getAttrVal("Id_appra"));
	}	
	public void setId_appra(String Id_appra) {
		setAttrVal("Id_appra", Id_appra);
	}
	public String getSd_appra() {
		return ((String) getAttrVal("Sd_appra"));
	}	
	public void setSd_appra(String Sd_appra) {
		setAttrVal("Sd_appra", Sd_appra);
	}
	public String getSel_ass() {
		return ((String) getAttrVal("Sel_ass"));
	}	
	public void setSel_ass(String Sel_ass) {
		setAttrVal("Sel_ass", Sel_ass);
	}
	public String getDep_ass() {
		return ((String) getAttrVal("Dep_ass"));
	}	
	public void setDep_ass(String Dep_ass) {
		setAttrVal("Dep_ass", Dep_ass);
	}
	public String getPra_clua() {
		return ((String) getAttrVal("Pra_clua"));
	}	
	public void setPra_clua(String Pra_clua) {
		setAttrVal("Pra_clua", Pra_clua);
	}
	public FBoolean getFg_pass() {
		return ((FBoolean) getAttrVal("Fg_pass"));
	}	
	public void setFg_pass(FBoolean Fg_pass) {
		setAttrVal("Fg_pass", Fg_pass);
	}
	public String getId_reg() {
		return ((String) getAttrVal("Id_reg"));
	}	
	public void setId_reg(String Id_reg) {
		setAttrVal("Id_reg", Id_reg);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public Integer getCount_week() {
		return ((Integer) getAttrVal("Count_week"));
	}	
	public void setCount_week(Integer Count_week) {
		setAttrVal("Count_week", Count_week);
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
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_nit_psninfo() {
		return ((String) getAttrVal("Name_nit_psninfo"));
	}	
	public void setName_nit_psninfo(String Name_nit_psninfo) {
		setAttrVal("Name_nit_psninfo", Name_nit_psninfo);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_grd_lvl() {
		return ((String) getAttrVal("Name_grd_lvl"));
	}	
	public void setName_grd_lvl(String Name_grd_lvl) {
		setAttrVal("Name_grd_lvl", Name_grd_lvl);
	}
	public String getName_act_grade() {
		return ((String) getAttrVal("Name_act_grade"));
	}	
	public void setName_act_grade(String Name_act_grade) {
		setAttrVal("Name_act_grade", Name_act_grade);
	}
	public String getName_appra() {
		return ((String) getAttrVal("Name_appra"));
	}	
	public void setName_appra(String Name_appra) {
		setAttrVal("Name_appra", Name_appra);
	}
	public String getName_reg() {
		return ((String) getAttrVal("Name_reg"));
	}	
	public void setName_reg(String Name_reg) {
		setAttrVal("Name_reg", Name_reg);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
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
		return "Id_psn_cyc";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PSN_CYC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPsnCycDODesc.class);
	}
	
}