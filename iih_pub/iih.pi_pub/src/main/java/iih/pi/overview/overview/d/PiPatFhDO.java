package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatFhDODesc;
import java.math.BigDecimal;

/**
 * 患者家族史 DO数据 
 * 
 */
public class PiPatFhDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATFH= "Id_patfh";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String DT_ACT= "Dt_act";
	public static final String ID_YMD_ACT= "Id_ymd_act";
	public static final String SD_YMD_ACT= "Sd_ymd_act";
	public static final String ID_BLDREL= "Id_bldrel";
	public static final String SD_BLDREL= "Sd_bldrel";
	public static final String NAME_BLDREL= "Name_bldrel";
	public static final String ID_DIDEF= "Id_didef";
	public static final String ID_SRV= "Id_srv";
	public static final String DES= "Des";
	public static final String BLDREL_NAME= "Bldrel_name";
	public static final String DIDEF_CODE= "Didef_code";
	public static final String DIDEF_NAME= "Didef_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patfh() {
		return ((String) getAttrVal("Id_patfh"));
	}	
	public void setId_patfh(String Id_patfh) {
		setAttrVal("Id_patfh", Id_patfh);
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
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
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
	public String getId_bldrel() {
		return ((String) getAttrVal("Id_bldrel"));
	}	
	public void setId_bldrel(String Id_bldrel) {
		setAttrVal("Id_bldrel", Id_bldrel);
	}
	public String getSd_bldrel() {
		return ((String) getAttrVal("Sd_bldrel"));
	}	
	public void setSd_bldrel(String Sd_bldrel) {
		setAttrVal("Sd_bldrel", Sd_bldrel);
	}
	public String getName_bldrel() {
		return ((String) getAttrVal("Name_bldrel"));
	}	
	public void setName_bldrel(String Name_bldrel) {
		setAttrVal("Name_bldrel", Name_bldrel);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getBldrel_name() {
		return ((String) getAttrVal("Bldrel_name"));
	}	
	public void setBldrel_name(String Bldrel_name) {
		setAttrVal("Bldrel_name", Bldrel_name);
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
		return "Id_patfh";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_fh";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatFhDODesc.class);
	}
	
}