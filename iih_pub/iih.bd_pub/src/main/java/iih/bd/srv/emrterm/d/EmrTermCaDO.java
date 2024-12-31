package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrterm.d.desc.EmrTermCaDODesc;
import java.math.BigDecimal;

/**
 * 病历术语分类 DO数据 
 * 
 */
public class EmrTermCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRATERMCA= "Id_mratermca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SORTNO= "Sortno";
	public static final String ID_MRTERMSYS= "Id_mrtermsys";
	public static final String SD_MRTERMSYS= "Sd_mrtermsys";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String ID_SCOPETP= "Id_scopetp";
	public static final String SD_SCOPETP= "Sd_scopetp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP= "Id_emp";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_MRSHOWMODE= "Id_mrshowmode";
	public static final String SD_MRSHOWMODE= "Sd_mrshowmode";
	public static final String FG_ENTP_OP= "Fg_entp_op";
	public static final String FG_ENTP_IP= "Fg_entp_ip";
	public static final String FG_ENTP_ER= "Fg_entp_er";
	public static final String FG_USE_ER1= "Fg_use_er1";
	public static final String FG_USE_ER2= "Fg_use_er2";
	public static final String FG_ENTP_FM= "Fg_entp_fm";
	public static final String FG_ENTP_PE= "Fg_entp_pe";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MR_GRP_CODE= "Mr_grp_code";
	public static final String MR_GRP_NAME= "Mr_grp_name";
	public static final String MR_ORG_CODE= "Mr_org_code";
	public static final String MR_ORG_NAME= "Mr_org_name";
	public static final String MR_SYS_NAME= "Mr_sys_name";
	public static final String NAME_PARENT= "Name_parent";
	public static final String MR_SCOPETP_NAME= "Mr_scopetp_name";
	public static final String MR_DEP_NAME= "Mr_dep_name";
	public static final String MR_DEP_CODE= "Mr_dep_code";
	public static final String MR_EMP_CODE= "Mr_emp_code";
	public static final String MR_EMP_NAME= "Mr_emp_name";
	public static final String MR_SHOWMODE_NAME= "Mr_showmode_name";
	public static final String MR_CREATE_CODE= "Mr_create_code";
	public static final String MR_CREATE_NAME= "Mr_create_name";
	public static final String MR_MODIF_NAME= "Mr_modif_name";
	public static final String MR_MODIF_CODE= "Mr_modif_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mratermca() {
		return ((String) getAttrVal("Id_mratermca"));
	}	
	public void setId_mratermca(String Id_mratermca) {
		setAttrVal("Id_mratermca", Id_mratermca);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_mrtermsys() {
		return ((String) getAttrVal("Id_mrtermsys"));
	}	
	public void setId_mrtermsys(String Id_mrtermsys) {
		setAttrVal("Id_mrtermsys", Id_mrtermsys);
	}
	public String getSd_mrtermsys() {
		return ((String) getAttrVal("Sd_mrtermsys"));
	}	
	public void setSd_mrtermsys(String Sd_mrtermsys) {
		setAttrVal("Sd_mrtermsys", Sd_mrtermsys);
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
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getId_mrshowmode() {
		return ((String) getAttrVal("Id_mrshowmode"));
	}	
	public void setId_mrshowmode(String Id_mrshowmode) {
		setAttrVal("Id_mrshowmode", Id_mrshowmode);
	}
	public String getSd_mrshowmode() {
		return ((String) getAttrVal("Sd_mrshowmode"));
	}	
	public void setSd_mrshowmode(String Sd_mrshowmode) {
		setAttrVal("Sd_mrshowmode", Sd_mrshowmode);
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
	public String getMr_sys_name() {
		return ((String) getAttrVal("Mr_sys_name"));
	}	
	public void setMr_sys_name(String Mr_sys_name) {
		setAttrVal("Mr_sys_name", Mr_sys_name);
	}
	public String getName_parent() {
		return ((String) getAttrVal("Name_parent"));
	}	
	public void setName_parent(String Name_parent) {
		setAttrVal("Name_parent", Name_parent);
	}
	public String getMr_scopetp_name() {
		return ((String) getAttrVal("Mr_scopetp_name"));
	}	
	public void setMr_scopetp_name(String Mr_scopetp_name) {
		setAttrVal("Mr_scopetp_name", Mr_scopetp_name);
	}
	public String getMr_dep_name() {
		return ((String) getAttrVal("Mr_dep_name"));
	}	
	public void setMr_dep_name(String Mr_dep_name) {
		setAttrVal("Mr_dep_name", Mr_dep_name);
	}
	public String getMr_dep_code() {
		return ((String) getAttrVal("Mr_dep_code"));
	}	
	public void setMr_dep_code(String Mr_dep_code) {
		setAttrVal("Mr_dep_code", Mr_dep_code);
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
	public String getMr_showmode_name() {
		return ((String) getAttrVal("Mr_showmode_name"));
	}	
	public void setMr_showmode_name(String Mr_showmode_name) {
		setAttrVal("Mr_showmode_name", Mr_showmode_name);
	}
	public String getMr_create_code() {
		return ((String) getAttrVal("Mr_create_code"));
	}	
	public void setMr_create_code(String Mr_create_code) {
		setAttrVal("Mr_create_code", Mr_create_code);
	}
	public String getMr_create_name() {
		return ((String) getAttrVal("Mr_create_name"));
	}	
	public void setMr_create_name(String Mr_create_name) {
		setAttrVal("Mr_create_name", Mr_create_name);
	}
	public String getMr_modif_name() {
		return ((String) getAttrVal("Mr_modif_name"));
	}	
	public void setMr_modif_name(String Mr_modif_name) {
		setAttrVal("Mr_modif_name", Mr_modif_name);
	}
	public String getMr_modif_code() {
		return ((String) getAttrVal("Mr_modif_code"));
	}	
	public void setMr_modif_code(String Mr_modif_code) {
		setAttrVal("Mr_modif_code", Mr_modif_code);
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
		return "Id_mratermca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mra_termca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrTermCaDODesc.class);
	}
	
}