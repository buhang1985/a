package iih.bd.fc.querule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.querule.d.desc.QueRuleItmDODesc;
import java.math.BigDecimal;

/**
 * 队列规则明细 DO数据 
 * 
 */
public class QueRuleItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_QUERULEITM= "Id_queruleitm";
	public static final String ID_QUERULE= "Id_querule";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String LEVEL_PRI= "Level_pri";
	public static final String FG_CONT_PRIOR= "Fg_cont_prior";
	public static final String IDS_PATCA= "Ids_patca";
	public static final String IDS_LEVELDISE= "Ids_leveldise";
	public static final String CODES_LEVELDISE= "Codes_leveldise";
	public static final String IDS_SCSRV= "Ids_scsrv";
	public static final String EU_CTRLTP= "Eu_ctrltp";
	public static final String IDS_PRESTP= "Ids_prestp";
	public static final String SDS_PRESTP= "Sds_prestp";
	public static final String FG_PLANIP= "Fg_planip";
	public static final String AGE_MAX= "Age_max";
	public static final String AGE_MIN= "Age_min";
	public static final String FG_BASEDRUG= "Fg_basedrug";
	public static final String ID_SEX= "Id_sex";
	public static final String ID_TAGTP= "Id_tagtp";
	public static final String FG_VIP= "Fg_vip";
	public static final String PATCA_CODE= "Patca_code";
	public static final String PATCA_NAME= "Patca_name";
	public static final String DISE_CODE= "Dise_code";
	public static final String DISE_NAME= "Dise_name";
	public static final String SCSRV_CODE= "Scsrv_code";
	public static final String SCSRV_NAME= "Scsrv_name";
	public static final String PRES_CODE= "Pres_code";
	public static final String PRES_NAME= "Pres_name";
	public static final String SD_SEX= "Sd_sex";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_TAGTP= "Name_tagtp";
	public static final String SD_TP= "Sd_tp";
	public static final String CODE_TAGTP= "Code_tagtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_queruleitm() {
		return ((String) getAttrVal("Id_queruleitm"));
	}	
	public void setId_queruleitm(String Id_queruleitm) {
		setAttrVal("Id_queruleitm", Id_queruleitm);
	}
	public String getId_querule() {
		return ((String) getAttrVal("Id_querule"));
	}	
	public void setId_querule(String Id_querule) {
		setAttrVal("Id_querule", Id_querule);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}	
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	public FBoolean getFg_cont_prior() {
		return ((FBoolean) getAttrVal("Fg_cont_prior"));
	}	
	public void setFg_cont_prior(FBoolean Fg_cont_prior) {
		setAttrVal("Fg_cont_prior", Fg_cont_prior);
	}
	public String getIds_patca() {
		return ((String) getAttrVal("Ids_patca"));
	}	
	public void setIds_patca(String Ids_patca) {
		setAttrVal("Ids_patca", Ids_patca);
	}
	public String getIds_leveldise() {
		return ((String) getAttrVal("Ids_leveldise"));
	}	
	public void setIds_leveldise(String Ids_leveldise) {
		setAttrVal("Ids_leveldise", Ids_leveldise);
	}
	public String getCodes_leveldise() {
		return ((String) getAttrVal("Codes_leveldise"));
	}	
	public void setCodes_leveldise(String Codes_leveldise) {
		setAttrVal("Codes_leveldise", Codes_leveldise);
	}
	public String getIds_scsrv() {
		return ((String) getAttrVal("Ids_scsrv"));
	}	
	public void setIds_scsrv(String Ids_scsrv) {
		setAttrVal("Ids_scsrv", Ids_scsrv);
	}
	public Integer getEu_ctrltp() {
		return ((Integer) getAttrVal("Eu_ctrltp"));
	}	
	public void setEu_ctrltp(Integer Eu_ctrltp) {
		setAttrVal("Eu_ctrltp", Eu_ctrltp);
	}
	public String getIds_prestp() {
		return ((String) getAttrVal("Ids_prestp"));
	}	
	public void setIds_prestp(String Ids_prestp) {
		setAttrVal("Ids_prestp", Ids_prestp);
	}
	public String getSds_prestp() {
		return ((String) getAttrVal("Sds_prestp"));
	}	
	public void setSds_prestp(String Sds_prestp) {
		setAttrVal("Sds_prestp", Sds_prestp);
	}
	public FBoolean getFg_planip() {
		return ((FBoolean) getAttrVal("Fg_planip"));
	}	
	public void setFg_planip(FBoolean Fg_planip) {
		setAttrVal("Fg_planip", Fg_planip);
	}
	public Integer getAge_max() {
		return ((Integer) getAttrVal("Age_max"));
	}	
	public void setAge_max(Integer Age_max) {
		setAttrVal("Age_max", Age_max);
	}
	public Integer getAge_min() {
		return ((Integer) getAttrVal("Age_min"));
	}	
	public void setAge_min(Integer Age_min) {
		setAttrVal("Age_min", Age_min);
	}
	public FBoolean getFg_basedrug() {
		return ((FBoolean) getAttrVal("Fg_basedrug"));
	}	
	public void setFg_basedrug(FBoolean Fg_basedrug) {
		setAttrVal("Fg_basedrug", Fg_basedrug);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getId_tagtp() {
		return ((String) getAttrVal("Id_tagtp"));
	}	
	public void setId_tagtp(String Id_tagtp) {
		setAttrVal("Id_tagtp", Id_tagtp);
	}
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	public String getPatca_code() {
		return ((String) getAttrVal("Patca_code"));
	}	
	public void setPatca_code(String Patca_code) {
		setAttrVal("Patca_code", Patca_code);
	}
	public String getPatca_name() {
		return ((String) getAttrVal("Patca_name"));
	}	
	public void setPatca_name(String Patca_name) {
		setAttrVal("Patca_name", Patca_name);
	}
	public String getDise_code() {
		return ((String) getAttrVal("Dise_code"));
	}	
	public void setDise_code(String Dise_code) {
		setAttrVal("Dise_code", Dise_code);
	}
	public String getDise_name() {
		return ((String) getAttrVal("Dise_name"));
	}	
	public void setDise_name(String Dise_name) {
		setAttrVal("Dise_name", Dise_name);
	}
	public String getScsrv_code() {
		return ((String) getAttrVal("Scsrv_code"));
	}	
	public void setScsrv_code(String Scsrv_code) {
		setAttrVal("Scsrv_code", Scsrv_code);
	}
	public String getScsrv_name() {
		return ((String) getAttrVal("Scsrv_name"));
	}	
	public void setScsrv_name(String Scsrv_name) {
		setAttrVal("Scsrv_name", Scsrv_name);
	}
	public String getPres_code() {
		return ((String) getAttrVal("Pres_code"));
	}	
	public void setPres_code(String Pres_code) {
		setAttrVal("Pres_code", Pres_code);
	}
	public String getPres_name() {
		return ((String) getAttrVal("Pres_name"));
	}	
	public void setPres_name(String Pres_name) {
		setAttrVal("Pres_name", Pres_name);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_tagtp() {
		return ((String) getAttrVal("Name_tagtp"));
	}	
	public void setName_tagtp(String Name_tagtp) {
		setAttrVal("Name_tagtp", Name_tagtp);
	}
	public String getSd_tp() {
		return ((String) getAttrVal("Sd_tp"));
	}	
	public void setSd_tp(String Sd_tp) {
		setAttrVal("Sd_tp", Sd_tp);
	}
	public String getCode_tagtp() {
		return ((String) getAttrVal("Code_tagtp"));
	}	
	public void setCode_tagtp(String Code_tagtp) {
		setAttrVal("Code_tagtp", Code_tagtp);
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
		return "Id_queruleitm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_que_rule_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(QueRuleItmDODesc.class);
	}
	
}