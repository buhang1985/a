package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatDiDODesc;
import java.math.BigDecimal;

/**
 * 患者疾病史 DO数据 
 * 
 */
public class PiPatDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATDI= "Id_patdi";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_YMD_ACT= "Id_ymd_act";
	public static final String SD_YMD_ACT= "Sd_ymd_act";
	public static final String DT_ACT= "Dt_act";
	public static final String ID_DIDEF= "Id_didef";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ORGCD= "Orgcd";
	public static final String ORGNAME= "Orgname";
	public static final String ID_ORGLEVEL= "Id_orglevel";
	public static final String SD_ORGLEVEL= "Sd_orglevel";
	public static final String FG_RECOVER= "Fg_recover";
	public static final String DIDEF_CODE= "Didef_code";
	public static final String DIDEF_NAME= "Didef_name";
	public static final String ORGLEVEL_NAME= "Orglevel_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patdi() {
		return ((String) getAttrVal("Id_patdi"));
	}	
	public void setId_patdi(String Id_patdi) {
		setAttrVal("Id_patdi", Id_patdi);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_datasrc() {
		return ((String) getAttrVal("Id_datasrc"));
	}	
	public void setId_datasrc(String Id_datasrc) {
		setAttrVal("Id_datasrc", Id_datasrc);
	}
	public String getSd_datasrc() {
		return ((String) getAttrVal("Sd_datasrc"));
	}	
	public void setSd_datasrc(String Sd_datasrc) {
		setAttrVal("Sd_datasrc", Sd_datasrc);
	}
	public Integer getId_ymd_act() {
		return ((Integer) getAttrVal("Id_ymd_act"));
	}	
	public void setId_ymd_act(Integer Id_ymd_act) {
		setAttrVal("Id_ymd_act", Id_ymd_act);
	}
	public String getSd_ymd_act() {
		return ((String) getAttrVal("Sd_ymd_act"));
	}	
	public void setSd_ymd_act(String Sd_ymd_act) {
		setAttrVal("Sd_ymd_act", Sd_ymd_act);
	}
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
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
	public String getOrgcd() {
		return ((String) getAttrVal("Orgcd"));
	}	
	public void setOrgcd(String Orgcd) {
		setAttrVal("Orgcd", Orgcd);
	}
	public String getOrgname() {
		return ((String) getAttrVal("Orgname"));
	}	
	public void setOrgname(String Orgname) {
		setAttrVal("Orgname", Orgname);
	}
	public String getId_orglevel() {
		return ((String) getAttrVal("Id_orglevel"));
	}	
	public void setId_orglevel(String Id_orglevel) {
		setAttrVal("Id_orglevel", Id_orglevel);
	}
	public String getSd_orglevel() {
		return ((String) getAttrVal("Sd_orglevel"));
	}	
	public void setSd_orglevel(String Sd_orglevel) {
		setAttrVal("Sd_orglevel", Sd_orglevel);
	}
	public FBoolean getFg_recover() {
		return ((FBoolean) getAttrVal("Fg_recover"));
	}	
	public void setFg_recover(FBoolean Fg_recover) {
		setAttrVal("Fg_recover", Fg_recover);
	}
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}	
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}	
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
	}
	public String getOrglevel_name() {
		return ((String) getAttrVal("Orglevel_name"));
	}	
	public void setOrglevel_name(String Orglevel_name) {
		setAttrVal("Orglevel_name", Orglevel_name);
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
		return "Id_patdi";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatDiDODesc.class);
	}
	
}