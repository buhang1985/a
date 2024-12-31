package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatDisaDODesc;
import java.math.BigDecimal;

/**
 * 残疾状况 DO数据 
 * 
 */
public class PiPatDisaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATDISA= "Id_patdisa";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String DT_ACT= "Dt_act";
	public static final String SD_YMD_ACT= "Sd_ymd_act";
	public static final String ID_YMD_ACT= "Id_ymd_act";
	public static final String SD_DISATP= "Sd_disatp";
	public static final String ID_DISATP= "Id_disatp";
	public static final String DES= "Des";
	public static final String ID_PAT= "Id_pat";
	public static final String DISATP_NAME= "Disatp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patdisa() {
		return ((String) getAttrVal("Id_patdisa"));
	}	
	public void setId_patdisa(String Id_patdisa) {
		setAttrVal("Id_patdisa", Id_patdisa);
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
	public String getSd_disatp() {
		return ((String) getAttrVal("Sd_disatp"));
	}	
	public void setSd_disatp(String Sd_disatp) {
		setAttrVal("Sd_disatp", Sd_disatp);
	}
	public String getId_disatp() {
		return ((String) getAttrVal("Id_disatp"));
	}	
	public void setId_disatp(String Id_disatp) {
		setAttrVal("Id_disatp", Id_disatp);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getDisatp_name() {
		return ((String) getAttrVal("Disatp_name"));
	}	
	public void setDisatp_name(String Disatp_name) {
		setAttrVal("Disatp_name", Disatp_name);
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
		return "Id_patdisa";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_disa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatDisaDODesc.class);
	}
	
}