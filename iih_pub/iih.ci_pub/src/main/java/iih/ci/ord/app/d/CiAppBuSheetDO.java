package iih.ci.ord.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.app.d.desc.CiAppBuSheetDODesc;
import java.math.BigDecimal;

/**
 * 用血打印申请单 DO数据 
 * 
 */
public class CiAppBuSheetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIAPPBUSHEET= "Id_ciappbusheet";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_EN= "Id_en";
	public static final String ID_OR= "Id_or";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_APBU= "Id_apbu";
	public static final String ID_APBT= "Id_apbt";
	public static final String CODE_APP_BU= "Code_app_bu";
	public static final String CODE_APP_BT= "Code_app_bt";
	public static final String ID_APP_BLOODTYPE= "Id_app_bloodtype";
	public static final String SD_APP_BLOODTYPE= "Sd_app_bloodtype";
	public static final String ID_APP_RHD= "Id_app_rhd";
	public static final String SD_APP_RHD= "Sd_app_rhd";
	public static final String ID_BLOOTP= "Id_blootp";
	public static final String SD_BLOOTP= "Sd_blootp";
	public static final String QUAN_MEDU_BU= "Quan_medu_bu";
	public static final String ID_MEDU_UNIT= "Id_medu_unit";
	public static final String DT_PL_BU= "Dt_pl_bu";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String ID_EMP_BU= "Id_emp_bu";
	public static final String APPLYDOCTORTEL= "Applydoctortel";
	public static final String DES_OR= "Des_or";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciappbusheet() {
		return ((String) getAttrVal("Id_ciappbusheet"));
	}	
	public void setId_ciappbusheet(String Id_ciappbusheet) {
		setAttrVal("Id_ciappbusheet", Id_ciappbusheet);
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
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_apbu() {
		return ((String) getAttrVal("Id_apbu"));
	}	
	public void setId_apbu(String Id_apbu) {
		setAttrVal("Id_apbu", Id_apbu);
	}
	public String getId_apbt() {
		return ((String) getAttrVal("Id_apbt"));
	}	
	public void setId_apbt(String Id_apbt) {
		setAttrVal("Id_apbt", Id_apbt);
	}
	public String getCode_app_bu() {
		return ((String) getAttrVal("Code_app_bu"));
	}	
	public void setCode_app_bu(String Code_app_bu) {
		setAttrVal("Code_app_bu", Code_app_bu);
	}
	public String getCode_app_bt() {
		return ((String) getAttrVal("Code_app_bt"));
	}	
	public void setCode_app_bt(String Code_app_bt) {
		setAttrVal("Code_app_bt", Code_app_bt);
	}
	public String getId_app_bloodtype() {
		return ((String) getAttrVal("Id_app_bloodtype"));
	}	
	public void setId_app_bloodtype(String Id_app_bloodtype) {
		setAttrVal("Id_app_bloodtype", Id_app_bloodtype);
	}
	public String getSd_app_bloodtype() {
		return ((String) getAttrVal("Sd_app_bloodtype"));
	}	
	public void setSd_app_bloodtype(String Sd_app_bloodtype) {
		setAttrVal("Sd_app_bloodtype", Sd_app_bloodtype);
	}
	public String getId_app_rhd() {
		return ((String) getAttrVal("Id_app_rhd"));
	}	
	public void setId_app_rhd(String Id_app_rhd) {
		setAttrVal("Id_app_rhd", Id_app_rhd);
	}
	public String getSd_app_rhd() {
		return ((String) getAttrVal("Sd_app_rhd"));
	}	
	public void setSd_app_rhd(String Sd_app_rhd) {
		setAttrVal("Sd_app_rhd", Sd_app_rhd);
	}
	public String getId_blootp() {
		return ((String) getAttrVal("Id_blootp"));
	}	
	public void setId_blootp(String Id_blootp) {
		setAttrVal("Id_blootp", Id_blootp);
	}
	public String getSd_blootp() {
		return ((String) getAttrVal("Sd_blootp"));
	}	
	public void setSd_blootp(String Sd_blootp) {
		setAttrVal("Sd_blootp", Sd_blootp);
	}
	public FDouble getQuan_medu_bu() {
		return ((FDouble) getAttrVal("Quan_medu_bu"));
	}	
	public void setQuan_medu_bu(FDouble Quan_medu_bu) {
		setAttrVal("Quan_medu_bu", Quan_medu_bu);
	}
	public String getId_medu_unit() {
		return ((String) getAttrVal("Id_medu_unit"));
	}	
	public void setId_medu_unit(String Id_medu_unit) {
		setAttrVal("Id_medu_unit", Id_medu_unit);
	}
	public FDateTime getDt_pl_bu() {
		return ((FDateTime) getAttrVal("Dt_pl_bu"));
	}	
	public void setDt_pl_bu(FDateTime Dt_pl_bu) {
		setAttrVal("Dt_pl_bu", Dt_pl_bu);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getId_emp_bu() {
		return ((String) getAttrVal("Id_emp_bu"));
	}	
	public void setId_emp_bu(String Id_emp_bu) {
		setAttrVal("Id_emp_bu", Id_emp_bu);
	}
	public String getApplydoctortel() {
		return ((String) getAttrVal("Applydoctortel"));
	}	
	public void setApplydoctortel(String Applydoctortel) {
		setAttrVal("Applydoctortel", Applydoctortel);
	}
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
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
		return "Id_ciappbusheet";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_app_bu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppBuSheetDODesc.class);
	}
	
}