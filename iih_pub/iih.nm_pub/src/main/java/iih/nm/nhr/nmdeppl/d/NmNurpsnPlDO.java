package iih.nm.nhr.nmdeppl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmdeppl.d.desc.NmNurpsnPlDODesc;
import java.math.BigDecimal;

/**
 * 实习人员计划 DO数据 
 * 
 */
public class NmNurpsnPlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NURPSN_PL= "Id_nurpsn_pl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_TCH_PSN= "Id_tch_psn";
	public static final String GRADE= "Grade";
	public static final String ID_GRD_LVL= "Id_grd_lvl";
	public static final String SD_GRD_LVL= "Sd_grd_lvl";
	public static final String ACT_GRADE= "Act_grade";
	public static final String ID_ACT_GRD_LVL= "Id_act_grd_lvl";
	public static final String SD_ACT_GRD_LVL= "Sd_act_grd_lvl";
	public static final String ID_APPRA= "Id_appra";
	public static final String SD_APPRA= "Sd_appra";
	public static final String DT_REG= "Dt_reg";
	public static final String DES= "Des";
	public static final String ID_DEP_PL= "Id_dep_pl";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String NUR_NAME= "Nur_name";
	public static final String TEC_NAME= "Tec_name";
	public static final String GRADE_NAME= "Grade_name";
	public static final String DOGRADE_NAME= "Dograde_name";
	public static final String EVA_NAME= "Eva_name";
	public static final String PLAN_NAME= "Plan_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nurpsn_pl() {
		return ((String) getAttrVal("Id_nurpsn_pl"));
	}	
	public void setId_nurpsn_pl(String Id_nurpsn_pl) {
		setAttrVal("Id_nurpsn_pl", Id_nurpsn_pl);
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
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_tch_psn() {
		return ((String) getAttrVal("Id_tch_psn"));
	}	
	public void setId_tch_psn(String Id_tch_psn) {
		setAttrVal("Id_tch_psn", Id_tch_psn);
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
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_dep_pl() {
		return ((String) getAttrVal("Id_dep_pl"));
	}	
	public void setId_dep_pl(String Id_dep_pl) {
		setAttrVal("Id_dep_pl", Id_dep_pl);
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
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getNur_name() {
		return ((String) getAttrVal("Nur_name"));
	}	
	public void setNur_name(String Nur_name) {
		setAttrVal("Nur_name", Nur_name);
	}
	public String getTec_name() {
		return ((String) getAttrVal("Tec_name"));
	}	
	public void setTec_name(String Tec_name) {
		setAttrVal("Tec_name", Tec_name);
	}
	public String getGrade_name() {
		return ((String) getAttrVal("Grade_name"));
	}	
	public void setGrade_name(String Grade_name) {
		setAttrVal("Grade_name", Grade_name);
	}
	public String getDograde_name() {
		return ((String) getAttrVal("Dograde_name"));
	}	
	public void setDograde_name(String Dograde_name) {
		setAttrVal("Dograde_name", Dograde_name);
	}
	public String getEva_name() {
		return ((String) getAttrVal("Eva_name"));
	}	
	public void setEva_name(String Eva_name) {
		setAttrVal("Eva_name", Eva_name);
	}
	public String getPlan_name() {
		return ((String) getAttrVal("Plan_name"));
	}	
	public void setPlan_name(String Plan_name) {
		setAttrVal("Plan_name", Plan_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
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
		return "Id_nurpsn_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NURPSN_PL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurpsnPlDODesc.class);
	}
	
}