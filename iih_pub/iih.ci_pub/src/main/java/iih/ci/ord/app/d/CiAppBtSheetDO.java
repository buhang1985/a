package iih.ci.ord.app.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.app.d.desc.CiAppBtSheetDODesc;
import java.math.BigDecimal;

/**
 * 备血打印申请单 DO数据 
 * 
 */
public class CiAppBtSheetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIAPPBTSHEET= "Id_ciappbtsheet";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_EN= "Id_en";
	public static final String STR_NAME_DI= "Str_name_di";
	public static final String ID_OR= "Id_or";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_APBT= "Id_apbt";
	public static final String CODE_APP_BT= "Code_app_bt";
	public static final String ID_APP_BLOODTYPE= "Id_app_bloodtype";
	public static final String SD_APP_BLOODTYPE= "Sd_app_bloodtype";
	public static final String ID_APP_RHD= "Id_app_rhd";
	public static final String SD_APP_RHD= "Sd_app_rhd";
	public static final String ID_HIS_BT= "Id_his_bt";
	public static final String SD_HIS_BT= "Sd_his_bt";
	public static final String QUAN_MEDU_BT= "Quan_medu_bt";
	public static final String ID_MEDU_UNIT= "Id_medu_unit";
	public static final String PREGNANT_NUM= "Pregnant_num";
	public static final String PARTURITION_CNT= "Parturition_cnt";
	public static final String ID_PPS_BT= "Id_pps_bt";
	public static final String SD_PPS_BT= "Sd_pps_bt";
	public static final String DES_PPS_BT= "Des_pps_bt";
	public static final String ID_MODE_BT= "Id_mode_bt";
	public static final String SD_MODE_BT= "Sd_mode_bt";
	public static final String DES_OR= "Des_or";
	public static final String DT_PL_BT= "Dt_pl_bt";
	public static final String STR_RPT= "Str_rpt";
	public static final String ID_EMP_CHIEF= "Id_emp_chief";
	public static final String ID_EMP_BT= "Id_emp_bt";
	public static final String ID_DEP_MP= "Id_dep_mp";
	public static final String DT_APP_BT= "Dt_app_bt";
	public static final String FG_PRN= "Fg_prn";
	public static final String CNT_PRN= "Cnt_prn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ciappbtsheet() {
		return ((String) getAttrVal("Id_ciappbtsheet"));
	}	
	public void setId_ciappbtsheet(String Id_ciappbtsheet) {
		setAttrVal("Id_ciappbtsheet", Id_ciappbtsheet);
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
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}	
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
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
	public String getId_apbt() {
		return ((String) getAttrVal("Id_apbt"));
	}	
	public void setId_apbt(String Id_apbt) {
		setAttrVal("Id_apbt", Id_apbt);
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
	public String getId_his_bt() {
		return ((String) getAttrVal("Id_his_bt"));
	}	
	public void setId_his_bt(String Id_his_bt) {
		setAttrVal("Id_his_bt", Id_his_bt);
	}
	public String getSd_his_bt() {
		return ((String) getAttrVal("Sd_his_bt"));
	}	
	public void setSd_his_bt(String Sd_his_bt) {
		setAttrVal("Sd_his_bt", Sd_his_bt);
	}
	public FDouble getQuan_medu_bt() {
		return ((FDouble) getAttrVal("Quan_medu_bt"));
	}	
	public void setQuan_medu_bt(FDouble Quan_medu_bt) {
		setAttrVal("Quan_medu_bt", Quan_medu_bt);
	}
	public String getId_medu_unit() {
		return ((String) getAttrVal("Id_medu_unit"));
	}	
	public void setId_medu_unit(String Id_medu_unit) {
		setAttrVal("Id_medu_unit", Id_medu_unit);
	}
	public Integer getPregnant_num() {
		return ((Integer) getAttrVal("Pregnant_num"));
	}	
	public void setPregnant_num(Integer Pregnant_num) {
		setAttrVal("Pregnant_num", Pregnant_num);
	}
	public Integer getParturition_cnt() {
		return ((Integer) getAttrVal("Parturition_cnt"));
	}	
	public void setParturition_cnt(Integer Parturition_cnt) {
		setAttrVal("Parturition_cnt", Parturition_cnt);
	}
	public String getId_pps_bt() {
		return ((String) getAttrVal("Id_pps_bt"));
	}	
	public void setId_pps_bt(String Id_pps_bt) {
		setAttrVal("Id_pps_bt", Id_pps_bt);
	}
	public String getSd_pps_bt() {
		return ((String) getAttrVal("Sd_pps_bt"));
	}	
	public void setSd_pps_bt(String Sd_pps_bt) {
		setAttrVal("Sd_pps_bt", Sd_pps_bt);
	}
	public String getDes_pps_bt() {
		return ((String) getAttrVal("Des_pps_bt"));
	}	
	public void setDes_pps_bt(String Des_pps_bt) {
		setAttrVal("Des_pps_bt", Des_pps_bt);
	}
	public String getId_mode_bt() {
		return ((String) getAttrVal("Id_mode_bt"));
	}	
	public void setId_mode_bt(String Id_mode_bt) {
		setAttrVal("Id_mode_bt", Id_mode_bt);
	}
	public String getSd_mode_bt() {
		return ((String) getAttrVal("Sd_mode_bt"));
	}	
	public void setSd_mode_bt(String Sd_mode_bt) {
		setAttrVal("Sd_mode_bt", Sd_mode_bt);
	}
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	public FDateTime getDt_pl_bt() {
		return ((FDateTime) getAttrVal("Dt_pl_bt"));
	}	
	public void setDt_pl_bt(FDateTime Dt_pl_bt) {
		setAttrVal("Dt_pl_bt", Dt_pl_bt);
	}
	public String getStr_rpt() {
		return ((String) getAttrVal("Str_rpt"));
	}	
	public void setStr_rpt(String Str_rpt) {
		setAttrVal("Str_rpt", Str_rpt);
	}
	public String getId_emp_chief() {
		return ((String) getAttrVal("Id_emp_chief"));
	}	
	public void setId_emp_chief(String Id_emp_chief) {
		setAttrVal("Id_emp_chief", Id_emp_chief);
	}
	public String getId_emp_bt() {
		return ((String) getAttrVal("Id_emp_bt"));
	}	
	public void setId_emp_bt(String Id_emp_bt) {
		setAttrVal("Id_emp_bt", Id_emp_bt);
	}
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	public String getDt_app_bt() {
		return ((String) getAttrVal("Dt_app_bt"));
	}	
	public void setDt_app_bt(String Dt_app_bt) {
		setAttrVal("Dt_app_bt", Dt_app_bt);
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
		return "Id_ciappbtsheet";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_app_bt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiAppBtSheetDODesc.class);
	}
	
}