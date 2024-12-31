package iih.mkr.ms.mkrms.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.ms.mkrms.d.desc.MkrMsDiDODesc;
import java.math.BigDecimal;

/**
 * 组套与疾病诊断关系 DO数据 
 * 
 */
public class MkrMsDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MSDI= "Id_msdi";
	public static final String ID_MS= "Id_ms";
	public static final String ID_DIDEF= "Id_didef";
	public static final String ID_PAR= "Id_par";
	public static final String ID_CDSYS= "Id_cdsys";
	public static final String SUPPLEMENT= "Supplement";
	public static final String FG_MAJDI= "Fg_majdi";
	public static final String DIDEF_NAME= "Didef_name";
	public static final String DIDEF_CODE= "Didef_code";
	public static final String DIDEF_DES= "Didef_des";
	public static final String FG_CHRONIC= "Fg_chronic";
	public static final String FG_SPECIAL= "Fg_special";
	public static final String ID_CDSYSTP= "Id_cdsystp";
	public static final String SD_CDSYSTP= "Sd_cdsystp";
	public static final String CDSYS_NAME= "Cdsys_name";
	public static final String CDSYS_CODE= "Cdsys_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_msdi() {
		return ((String) getAttrVal("Id_msdi"));
	}	
	public void setId_msdi(String Id_msdi) {
		setAttrVal("Id_msdi", Id_msdi);
	}
	public String getId_ms() {
		return ((String) getAttrVal("Id_ms"));
	}	
	public void setId_ms(String Id_ms) {
		setAttrVal("Id_ms", Id_ms);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	public String getId_cdsys() {
		return ((String) getAttrVal("Id_cdsys"));
	}	
	public void setId_cdsys(String Id_cdsys) {
		setAttrVal("Id_cdsys", Id_cdsys);
	}
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}	
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	public FBoolean getFg_majdi() {
		return ((FBoolean) getAttrVal("Fg_majdi"));
	}	
	public void setFg_majdi(FBoolean Fg_majdi) {
		setAttrVal("Fg_majdi", Fg_majdi);
	}
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}	
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
	}
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}	
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	public String getDidef_des() {
		return ((String) getAttrVal("Didef_des"));
	}	
	public void setDidef_des(String Didef_des) {
		setAttrVal("Didef_des", Didef_des);
	}
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}	
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}	
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
	public String getId_cdsystp() {
		return ((String) getAttrVal("Id_cdsystp"));
	}	
	public void setId_cdsystp(String Id_cdsystp) {
		setAttrVal("Id_cdsystp", Id_cdsystp);
	}
	public String getSd_cdsystp() {
		return ((String) getAttrVal("Sd_cdsystp"));
	}	
	public void setSd_cdsystp(String Sd_cdsystp) {
		setAttrVal("Sd_cdsystp", Sd_cdsystp);
	}
	public String getCdsys_name() {
		return ((String) getAttrVal("Cdsys_name"));
	}	
	public void setCdsys_name(String Cdsys_name) {
		setAttrVal("Cdsys_name", Cdsys_name);
	}
	public String getCdsys_code() {
		return ((String) getAttrVal("Cdsys_code"));
	}	
	public void setCdsys_code(String Cdsys_code) {
		setAttrVal("Cdsys_code", Cdsys_code);
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
		return "Id_msdi";
	}
	
	@Override
	public String getTableName() {	  
		return "MKR_MS_DI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MkrMsDiDODesc.class);
	}
	
}