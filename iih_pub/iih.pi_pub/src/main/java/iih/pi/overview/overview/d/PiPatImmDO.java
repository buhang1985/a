package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatImmDODesc;
import java.math.BigDecimal;

/**
 * 患者免疫史 DO数据 
 * 
 */
public class PiPatImmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATIMM= "Id_patimm";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String DT_ACT= "Dt_act";
	public static final String SD_YMD_ACT= "Sd_ymd_act";
	public static final String ID_YMD_ACT= "Id_ymd_act";
	public static final String SD_IMMTP= "Sd_immtp";
	public static final String ID_IMMTP= "Id_immtp";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_PAT= "Id_pat";
	public static final String IMMTP_CODE= "Immtp_code";
	public static final String IMMTP_NAME= "Immtp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patimm() {
		return ((String) getAttrVal("Id_patimm"));
	}	
	public void setId_patimm(String Id_patimm) {
		setAttrVal("Id_patimm", Id_patimm);
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
	public String getSd_immtp() {
		return ((String) getAttrVal("Sd_immtp"));
	}	
	public void setSd_immtp(String Sd_immtp) {
		setAttrVal("Sd_immtp", Sd_immtp);
	}
	public String getId_immtp() {
		return ((String) getAttrVal("Id_immtp"));
	}	
	public void setId_immtp(String Id_immtp) {
		setAttrVal("Id_immtp", Id_immtp);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getImmtp_code() {
		return ((String) getAttrVal("Immtp_code"));
	}	
	public void setImmtp_code(String Immtp_code) {
		setAttrVal("Immtp_code", Immtp_code);
	}
	public String getImmtp_name() {
		return ((String) getAttrVal("Immtp_name"));
	}	
	public void setImmtp_name(String Immtp_name) {
		setAttrVal("Immtp_name", Immtp_name);
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
		return "Id_patimm";
	}
	
	@Override
	public String getTableName() {	  
		return "PI_PAT_IMM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatImmDODesc.class);
	}
	
}