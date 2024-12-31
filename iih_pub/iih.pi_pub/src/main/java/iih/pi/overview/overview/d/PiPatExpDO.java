package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatExpDODesc;
import java.math.BigDecimal;

/**
 * 患者暴露史 DO数据 
 * 
 */
public class PiPatExpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATEXP= "Id_patexp";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String DT_ACT= "Dt_act";
	public static final String SD_YMD_ACT= "Sd_ymd_act";
	public static final String ID_YMD_ACT= "Id_ymd_act";
	public static final String DES= "Des";
	public static final String SD_EXPTP= "Sd_exptp";
	public static final String ID_EXPTP= "Id_exptp";
	public static final String TIME_EXP= "Time_exp";
	public static final String UNITS= "Units";
	public static final String FG_OCCEXP= "Fg_occexp";
	public static final String OCC_EXP= "Occ_exp";
	public static final String ID_PAT= "Id_pat";
	public static final String EXPTP_CODE= "Exptp_code";
	public static final String EXPTP_NAME= "Exptp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patexp() {
		return ((String) getAttrVal("Id_patexp"));
	}	
	public void setId_patexp(String Id_patexp) {
		setAttrVal("Id_patexp", Id_patexp);
	}
	public String getSd_datasrc() {
		return ((String) getAttrVal("Sd_datasrc"));
	}	
	public void setSd_datasrc(String Sd_datasrc) {
		setAttrVal("Sd_datasrc", Sd_datasrc);
	}
	public String getId_datasrc() {
		return ((String) getAttrVal("Id_datasrc"));
	}	
	public void setId_datasrc(String Id_datasrc) {
		setAttrVal("Id_datasrc", Id_datasrc);
	}
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	public String getSd_ymd_act() {
		return ((String) getAttrVal("Sd_ymd_act"));
	}	
	public void setSd_ymd_act(String Sd_ymd_act) {
		setAttrVal("Sd_ymd_act", Sd_ymd_act);
	}
	public Integer getId_ymd_act() {
		return ((Integer) getAttrVal("Id_ymd_act"));
	}	
	public void setId_ymd_act(Integer Id_ymd_act) {
		setAttrVal("Id_ymd_act", Id_ymd_act);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getSd_exptp() {
		return ((String) getAttrVal("Sd_exptp"));
	}	
	public void setSd_exptp(String Sd_exptp) {
		setAttrVal("Sd_exptp", Sd_exptp);
	}
	public String getId_exptp() {
		return ((String) getAttrVal("Id_exptp"));
	}	
	public void setId_exptp(String Id_exptp) {
		setAttrVal("Id_exptp", Id_exptp);
	}
	public FDouble getTime_exp() {
		return ((FDouble) getAttrVal("Time_exp"));
	}	
	public void setTime_exp(FDouble Time_exp) {
		setAttrVal("Time_exp", Time_exp);
	}
	public Integer getUnits() {
		return ((Integer) getAttrVal("Units"));
	}	
	public void setUnits(Integer Units) {
		setAttrVal("Units", Units);
	}
	public FBoolean getFg_occexp() {
		return ((FBoolean) getAttrVal("Fg_occexp"));
	}	
	public void setFg_occexp(FBoolean Fg_occexp) {
		setAttrVal("Fg_occexp", Fg_occexp);
	}
	public String getOcc_exp() {
		return ((String) getAttrVal("Occ_exp"));
	}	
	public void setOcc_exp(String Occ_exp) {
		setAttrVal("Occ_exp", Occ_exp);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getExptp_code() {
		return ((String) getAttrVal("Exptp_code"));
	}	
	public void setExptp_code(String Exptp_code) {
		setAttrVal("Exptp_code", Exptp_code);
	}
	public String getExptp_name() {
		return ((String) getAttrVal("Exptp_name"));
	}	
	public void setExptp_name(String Exptp_name) {
		setAttrVal("Exptp_name", Exptp_name);
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
		return "Id_patexp";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_exp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatExpDODesc.class);
	}
	
}