package iih.mp.dg.adr.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.adr.d.desc.MpDgAdrDODesc;
import java.math.BigDecimal;

/**
 * 药品不良反应 DO数据 
 * 
 */
public class MpDgAdrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MPDGADR= "Id_mpdgadr";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String TEL= "Tel";
	public static final String WEIGHT= "Weight";
	public static final String ID_OR= "Id_or";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String DT_MP_PLAN= "Dt_mp_plan";
	public static final String DT_MP_ATCSTART= "Dt_mp_atcstart";
	public static final String DT_MP_ATCEND= "Dt_mp_atcend";
	public static final String ID_DGADRTP= "Id_dgadrtp";
	public static final String SD_DGADRTP= "Sd_dgadrtp";
	public static final String ADR_DES= "Adr_des";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String DT_CREA= "Dt_crea";
	public static final String ID_EMP_CREA= "Id_emp_crea";
	public static final String EN_CONF= "En_conf";
	public static final String DT_CONF= "Dt_conf";
	public static final String ID_EMP_CONF= "Id_emp_conf";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_PAT= "Code_pat";
	public static final String NAME_SEX= "Name_sex";
	public static final String CONTENT_OR= "Content_or";
	public static final String NAME_DGADRTP= "Name_dgadrtp";
	public static final String NAME_DEP_MP= "Name_dep_mp";
	public static final String NAME_CREA= "Name_crea";
	public static final String NAME_CONF= "Name_conf";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mpdgadr() {
		return ((String) getAttrVal("Id_mpdgadr"));
	}	
	public void setId_mpdgadr(String Id_mpdgadr) {
		setAttrVal("Id_mpdgadr", Id_mpdgadr);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	public FDateTime getDt_mp_atcstart() {
		return ((FDateTime) getAttrVal("Dt_mp_atcstart"));
	}	
	public void setDt_mp_atcstart(FDateTime Dt_mp_atcstart) {
		setAttrVal("Dt_mp_atcstart", Dt_mp_atcstart);
	}
	public FDateTime getDt_mp_atcend() {
		return ((FDateTime) getAttrVal("Dt_mp_atcend"));
	}	
	public void setDt_mp_atcend(FDateTime Dt_mp_atcend) {
		setAttrVal("Dt_mp_atcend", Dt_mp_atcend);
	}
	public String getId_dgadrtp() {
		return ((String) getAttrVal("Id_dgadrtp"));
	}	
	public void setId_dgadrtp(String Id_dgadrtp) {
		setAttrVal("Id_dgadrtp", Id_dgadrtp);
	}
	public String getSd_dgadrtp() {
		return ((String) getAttrVal("Sd_dgadrtp"));
	}	
	public void setSd_dgadrtp(String Sd_dgadrtp) {
		setAttrVal("Sd_dgadrtp", Sd_dgadrtp);
	}
	public String getAdr_des() {
		return ((String) getAttrVal("Adr_des"));
	}	
	public void setAdr_des(String Adr_des) {
		setAttrVal("Adr_des", Adr_des);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public FDateTime getDt_crea() {
		return ((FDateTime) getAttrVal("Dt_crea"));
	}	
	public void setDt_crea(FDateTime Dt_crea) {
		setAttrVal("Dt_crea", Dt_crea);
	}
	public String getId_emp_crea() {
		return ((String) getAttrVal("Id_emp_crea"));
	}	
	public void setId_emp_crea(String Id_emp_crea) {
		setAttrVal("Id_emp_crea", Id_emp_crea);
	}
	public Integer getEn_conf() {
		return ((Integer) getAttrVal("En_conf"));
	}	
	public void setEn_conf(Integer En_conf) {
		setAttrVal("En_conf", En_conf);
	}
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	public String getId_emp_conf() {
		return ((String) getAttrVal("Id_emp_conf"));
	}	
	public void setId_emp_conf(String Id_emp_conf) {
		setAttrVal("Id_emp_conf", Id_emp_conf);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	public String getName_dgadrtp() {
		return ((String) getAttrVal("Name_dgadrtp"));
	}	
	public void setName_dgadrtp(String Name_dgadrtp) {
		setAttrVal("Name_dgadrtp", Name_dgadrtp);
	}
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	public String getName_crea() {
		return ((String) getAttrVal("Name_crea"));
	}	
	public void setName_crea(String Name_crea) {
		setAttrVal("Name_crea", Name_crea);
	}
	public String getName_conf() {
		return ((String) getAttrVal("Name_conf"));
	}	
	public void setName_conf(String Name_conf) {
		setAttrVal("Name_conf", Name_conf);
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
		return "Id_mpdgadr";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_adr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpDgAdrDODesc.class);
	}
	
}