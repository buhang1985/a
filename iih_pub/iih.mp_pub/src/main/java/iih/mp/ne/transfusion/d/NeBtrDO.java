package iih.mp.ne.transfusion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ne.transfusion.d.desc.NeBtrDODesc;
import java.math.BigDecimal;

/**
 * 输血记录 DO数据 
 * 
 */
public class NeBtrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NEBTR= "Id_nebtr";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_OR= "Id_or";
	public static final String FG_NS= "Fg_ns";
	public static final String FG_ENS= "Fg_ens";
	public static final String DT_B_ACTUAL= "Dt_b_actual";
	public static final String DT_E_ACTUAL= "Dt_e_actual";
	public static final String QUAN_BT_ACTUAL= "Quan_bt_actual";
	public static final String ID_U_BT= "Id_u_bt";
	public static final String SD_U_BT= "Sd_u_bt";
	public static final String DES_BT_NOT= "Des_bt_not";
	public static final String FG_BT_HAD= "Fg_bt_had";
	public static final String RSTBT_TIME= "Rstbt_time";
	public static final String DES_RSTBT= "Des_rstbt";
	public static final String ID_EMP_EE_NUR= "Id_emp_ee_nur";
	public static final String ID_EMP_RE_NUR= "Id_emp_re_nur";
	public static final String ID_EMP_EB_NUR= "Id_emp_eb_nur";
	public static final String ID_EMP_RB_NUR= "Id_emp_rb_nur";
	public static final String DT_EB_NUR= "Dt_eb_nur";
	public static final String DT_RB_NUR= "Dt_rb_nur";
	public static final String DT_EE_NUR= "Dt_ee_nur";
	public static final String DT_RE_NUR= "Dt_re_nur";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String CODE_ENTP= "Code_entp";
	public static final String FG_INVALID= "Fg_invalid";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String NAME_EE= "Name_ee";
	public static final String NAME_RE= "Name_re";
	public static final String NAME_EB= "Name_eb";
	public static final String NAME_RB= "Name_rb";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nebtr() {
		return ((String) getAttrVal("Id_nebtr"));
	}	
	public void setId_nebtr(String Id_nebtr) {
		setAttrVal("Id_nebtr", Id_nebtr);
	}
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
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
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public FBoolean getFg_ns() {
		return ((FBoolean) getAttrVal("Fg_ns"));
	}	
	public void setFg_ns(FBoolean Fg_ns) {
		setAttrVal("Fg_ns", Fg_ns);
	}
	public FBoolean getFg_ens() {
		return ((FBoolean) getAttrVal("Fg_ens"));
	}	
	public void setFg_ens(FBoolean Fg_ens) {
		setAttrVal("Fg_ens", Fg_ens);
	}
	public FDateTime getDt_b_actual() {
		return ((FDateTime) getAttrVal("Dt_b_actual"));
	}	
	public void setDt_b_actual(FDateTime Dt_b_actual) {
		setAttrVal("Dt_b_actual", Dt_b_actual);
	}
	public FDateTime getDt_e_actual() {
		return ((FDateTime) getAttrVal("Dt_e_actual"));
	}	
	public void setDt_e_actual(FDateTime Dt_e_actual) {
		setAttrVal("Dt_e_actual", Dt_e_actual);
	}
	public String getQuan_bt_actual() {
		return ((String) getAttrVal("Quan_bt_actual"));
	}	
	public void setQuan_bt_actual(String Quan_bt_actual) {
		setAttrVal("Quan_bt_actual", Quan_bt_actual);
	}
	public String getId_u_bt() {
		return ((String) getAttrVal("Id_u_bt"));
	}	
	public void setId_u_bt(String Id_u_bt) {
		setAttrVal("Id_u_bt", Id_u_bt);
	}
	public String getSd_u_bt() {
		return ((String) getAttrVal("Sd_u_bt"));
	}	
	public void setSd_u_bt(String Sd_u_bt) {
		setAttrVal("Sd_u_bt", Sd_u_bt);
	}
	public String getDes_bt_not() {
		return ((String) getAttrVal("Des_bt_not"));
	}	
	public void setDes_bt_not(String Des_bt_not) {
		setAttrVal("Des_bt_not", Des_bt_not);
	}
	public FBoolean getFg_bt_had() {
		return ((FBoolean) getAttrVal("Fg_bt_had"));
	}	
	public void setFg_bt_had(FBoolean Fg_bt_had) {
		setAttrVal("Fg_bt_had", Fg_bt_had);
	}
	public FDateTime getRstbt_time() {
		return ((FDateTime) getAttrVal("Rstbt_time"));
	}	
	public void setRstbt_time(FDateTime Rstbt_time) {
		setAttrVal("Rstbt_time", Rstbt_time);
	}
	public String getDes_rstbt() {
		return ((String) getAttrVal("Des_rstbt"));
	}	
	public void setDes_rstbt(String Des_rstbt) {
		setAttrVal("Des_rstbt", Des_rstbt);
	}
	public String getId_emp_ee_nur() {
		return ((String) getAttrVal("Id_emp_ee_nur"));
	}	
	public void setId_emp_ee_nur(String Id_emp_ee_nur) {
		setAttrVal("Id_emp_ee_nur", Id_emp_ee_nur);
	}
	public String getId_emp_re_nur() {
		return ((String) getAttrVal("Id_emp_re_nur"));
	}	
	public void setId_emp_re_nur(String Id_emp_re_nur) {
		setAttrVal("Id_emp_re_nur", Id_emp_re_nur);
	}
	public String getId_emp_eb_nur() {
		return ((String) getAttrVal("Id_emp_eb_nur"));
	}	
	public void setId_emp_eb_nur(String Id_emp_eb_nur) {
		setAttrVal("Id_emp_eb_nur", Id_emp_eb_nur);
	}
	public String getId_emp_rb_nur() {
		return ((String) getAttrVal("Id_emp_rb_nur"));
	}	
	public void setId_emp_rb_nur(String Id_emp_rb_nur) {
		setAttrVal("Id_emp_rb_nur", Id_emp_rb_nur);
	}
	public FDateTime getDt_eb_nur() {
		return ((FDateTime) getAttrVal("Dt_eb_nur"));
	}	
	public void setDt_eb_nur(FDateTime Dt_eb_nur) {
		setAttrVal("Dt_eb_nur", Dt_eb_nur);
	}
	public FDateTime getDt_rb_nur() {
		return ((FDateTime) getAttrVal("Dt_rb_nur"));
	}	
	public void setDt_rb_nur(FDateTime Dt_rb_nur) {
		setAttrVal("Dt_rb_nur", Dt_rb_nur);
	}
	public FDateTime getDt_ee_nur() {
		return ((FDateTime) getAttrVal("Dt_ee_nur"));
	}	
	public void setDt_ee_nur(FDateTime Dt_ee_nur) {
		setAttrVal("Dt_ee_nur", Dt_ee_nur);
	}
	public FDateTime getDt_re_nur() {
		return ((FDateTime) getAttrVal("Dt_re_nur"));
	}	
	public void setDt_re_nur(FDateTime Dt_re_nur) {
		setAttrVal("Dt_re_nur", Dt_re_nur);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public FBoolean getFg_invalid() {
		return ((FBoolean) getAttrVal("Fg_invalid"));
	}	
	public void setFg_invalid(FBoolean Fg_invalid) {
		setAttrVal("Fg_invalid", Fg_invalid);
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
	public String getName_ee() {
		return ((String) getAttrVal("Name_ee"));
	}	
	public void setName_ee(String Name_ee) {
		setAttrVal("Name_ee", Name_ee);
	}
	public String getName_re() {
		return ((String) getAttrVal("Name_re"));
	}	
	public void setName_re(String Name_re) {
		setAttrVal("Name_re", Name_re);
	}
	public String getName_eb() {
		return ((String) getAttrVal("Name_eb"));
	}	
	public void setName_eb(String Name_eb) {
		setAttrVal("Name_eb", Name_eb);
	}
	public String getName_rb() {
		return ((String) getAttrVal("Name_rb"));
	}	
	public void setName_rb(String Name_rb) {
		setAttrVal("Name_rb", Name_rb);
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
		return "Id_nebtr";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NE_BTR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NeBtrDODesc.class);
	}
	
}