package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrterm.d.desc.EmrNormWordCaDODesc;
import java.math.BigDecimal;

/**
 * 病历常用词分类 DO数据 
 * 
 */
public class EmrNormWordCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRACWCA= "Id_mracwca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_CWTP= "Id_cwtp";
	public static final String SD_CWTP= "Sd_cwtp";
	public static final String SORTNO= "Sortno";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_SCOPETP= "Id_scopetp";
	public static final String SD_SCOPETP= "Sd_scopetp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String FG_ENTP_OP= "Fg_entp_op";
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	public static final String FG_ENTP_ER= "Fg_entp_er";
	public static final String FG_USE_ER1= "Fg_use_er1";
	public static final String FG_USE_ER2= "Fg_use_er2";
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	public static final String EMRNORMWORDS= "Emrnormwords";
	public static final String CREATEDTIME= "Createdtime";
	public static final String CREATEDBY= "Createdby";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MR_GRP_CODE= "Mr_grp_code";
	public static final String MR_GRP_NAME= "Mr_grp_name";
	public static final String MR_ORG_CODE= "Mr_org_code";
	public static final String MR_ORG_NAME= "Mr_org_name";
	public static final String MR_CWTP_NAME= "Mr_cwtp_name";
	public static final String MR_SCOPETP_NAME= "Mr_scopetp_name";
	public static final String MR_DEP_CODE= "Mr_dep_code";
	public static final String MR_DEP_NAME= "Mr_dep_name";
	public static final String MR_EMP_CODE= "Mr_emp_code";
	public static final String MR_EMP_NAME= "Mr_emp_name";
	public static final String MR_CREAT_NAME= "Mr_creat_name";
	public static final String MR_CREAT_CODE= "Mr_creat_code";
	public static final String MR_MODIFY_NAME= "Mr_modify_name";
	public static final String MR_MODIFY_CODE= "Mr_modify_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mracwca() {
		return ((String) getAttrVal("Id_mracwca"));
	}	
	public void setId_mracwca(String Id_mracwca) {
		setAttrVal("Id_mracwca", Id_mracwca);
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
	public String getId_cwtp() {
		return ((String) getAttrVal("Id_cwtp"));
	}	
	public void setId_cwtp(String Id_cwtp) {
		setAttrVal("Id_cwtp", Id_cwtp);
	}
	public String getSd_cwtp() {
		return ((String) getAttrVal("Sd_cwtp"));
	}	
	public void setSd_cwtp(String Sd_cwtp) {
		setAttrVal("Sd_cwtp", Sd_cwtp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_scopetp() {
		return ((String) getAttrVal("Id_scopetp"));
	}	
	public void setId_scopetp(String Id_scopetp) {
		setAttrVal("Id_scopetp", Id_scopetp);
	}
	public String getSd_scopetp() {
		return ((String) getAttrVal("Sd_scopetp"));
	}	
	public void setSd_scopetp(String Sd_scopetp) {
		setAttrVal("Sd_scopetp", Sd_scopetp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public FBoolean getFg_entp_op() {
		return ((FBoolean) getAttrVal("Fg_entp_op"));
	}	
	public void setFg_entp_op(FBoolean Fg_entp_op) {
		setAttrVal("Fg_entp_op", Fg_entp_op);
	}
	public FBoolean getFg_entp_ip() {
		return ((FBoolean) getAttrVal("Fg_entp_ip"));
	}	
	public void setFg_entp_ip(FBoolean Fg_entp_ip) {
		setAttrVal("Fg_entp_ip", Fg_entp_ip);
	}
	public FBoolean getFg_entp_er() {
		return ((FBoolean) getAttrVal("Fg_entp_er"));
	}	
	public void setFg_entp_er(FBoolean Fg_entp_er) {
		setAttrVal("Fg_entp_er", Fg_entp_er);
	}
	public FBoolean getFg_use_er1() {
		return ((FBoolean) getAttrVal("Fg_use_er1"));
	}	
	public void setFg_use_er1(FBoolean Fg_use_er1) {
		setAttrVal("Fg_use_er1", Fg_use_er1);
	}
	public FBoolean getFg_use_er2() {
		return ((FBoolean) getAttrVal("Fg_use_er2"));
	}	
	public void setFg_use_er2(FBoolean Fg_use_er2) {
		setAttrVal("Fg_use_er2", Fg_use_er2);
	}
	public FBoolean getFg_entp_fm() {
		return ((FBoolean) getAttrVal("Fg_entp_fm"));
	}	
	public void setFg_entp_fm(FBoolean Fg_entp_fm) {
		setAttrVal("Fg_entp_fm", Fg_entp_fm);
	}
	public FBoolean getFg_entp_pe() {
		return ((FBoolean) getAttrVal("Fg_entp_pe"));
	}	
	public void setFg_entp_pe(FBoolean Fg_entp_pe) {
		setAttrVal("Fg_entp_pe", Fg_entp_pe);
	}
	public String getEmrnormwords() {
		return ((String) getAttrVal("Emrnormwords"));
	}	
	public void setEmrnormwords(String Emrnormwords) {
		setAttrVal("Emrnormwords", Emrnormwords);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
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
	public String getMr_grp_code() {
		return ((String) getAttrVal("Mr_grp_code"));
	}	
	public void setMr_grp_code(String Mr_grp_code) {
		setAttrVal("Mr_grp_code", Mr_grp_code);
	}
	public String getMr_grp_name() {
		return ((String) getAttrVal("Mr_grp_name"));
	}	
	public void setMr_grp_name(String Mr_grp_name) {
		setAttrVal("Mr_grp_name", Mr_grp_name);
	}
	public String getMr_org_code() {
		return ((String) getAttrVal("Mr_org_code"));
	}	
	public void setMr_org_code(String Mr_org_code) {
		setAttrVal("Mr_org_code", Mr_org_code);
	}
	public String getMr_org_name() {
		return ((String) getAttrVal("Mr_org_name"));
	}	
	public void setMr_org_name(String Mr_org_name) {
		setAttrVal("Mr_org_name", Mr_org_name);
	}
	public String getMr_cwtp_name() {
		return ((String) getAttrVal("Mr_cwtp_name"));
	}	
	public void setMr_cwtp_name(String Mr_cwtp_name) {
		setAttrVal("Mr_cwtp_name", Mr_cwtp_name);
	}
	public String getMr_scopetp_name() {
		return ((String) getAttrVal("Mr_scopetp_name"));
	}	
	public void setMr_scopetp_name(String Mr_scopetp_name) {
		setAttrVal("Mr_scopetp_name", Mr_scopetp_name);
	}
	public String getMr_dep_code() {
		return ((String) getAttrVal("Mr_dep_code"));
	}	
	public void setMr_dep_code(String Mr_dep_code) {
		setAttrVal("Mr_dep_code", Mr_dep_code);
	}
	public String getMr_dep_name() {
		return ((String) getAttrVal("Mr_dep_name"));
	}	
	public void setMr_dep_name(String Mr_dep_name) {
		setAttrVal("Mr_dep_name", Mr_dep_name);
	}
	public String getMr_emp_code() {
		return ((String) getAttrVal("Mr_emp_code"));
	}	
	public void setMr_emp_code(String Mr_emp_code) {
		setAttrVal("Mr_emp_code", Mr_emp_code);
	}
	public String getMr_emp_name() {
		return ((String) getAttrVal("Mr_emp_name"));
	}	
	public void setMr_emp_name(String Mr_emp_name) {
		setAttrVal("Mr_emp_name", Mr_emp_name);
	}
	public String getMr_creat_name() {
		return ((String) getAttrVal("Mr_creat_name"));
	}	
	public void setMr_creat_name(String Mr_creat_name) {
		setAttrVal("Mr_creat_name", Mr_creat_name);
	}
	public String getMr_creat_code() {
		return ((String) getAttrVal("Mr_creat_code"));
	}	
	public void setMr_creat_code(String Mr_creat_code) {
		setAttrVal("Mr_creat_code", Mr_creat_code);
	}
	public String getMr_modify_name() {
		return ((String) getAttrVal("Mr_modify_name"));
	}	
	public void setMr_modify_name(String Mr_modify_name) {
		setAttrVal("Mr_modify_name", Mr_modify_name);
	}
	public String getMr_modify_code() {
		return ((String) getAttrVal("Mr_modify_code"));
	}	
	public void setMr_modify_code(String Mr_modify_code) {
		setAttrVal("Mr_modify_code", Mr_modify_code);
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
		return "Id_mracwca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mra_cwca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrNormWordCaDODesc.class);
	}
	
}