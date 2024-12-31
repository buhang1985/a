package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatPsnDODesc;
import java.math.BigDecimal;

/**
 * 患者个人史 DO数据 
 * 
 */
public class PiPatPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATPSN= "Id_patpsn";
	public static final String ID_PAT= "Id_pat";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_SMOKSTA= "Id_smoksta";
	public static final String SD_SMOKSTA= "Sd_smoksta";
	public static final String SMOKFREQ= "Smokfreq";
	public static final String SMOKSTARTAGE= "Smokstartage";
	public static final String FG_SMOKOUT= "Fg_smokout";
	public static final String SMOKOUTAGE= "Smokoutage";
	public static final String ID_DRINKSTA= "Id_drinksta";
	public static final String SD_DRINKSTA= "Sd_drinksta";
	public static final String DRINKFREQ= "Drinkfreq";
	public static final String DRINKSTARTAGE= "Drinkstartage";
	public static final String FG_DRINKOUT= "Fg_drinkout";
	public static final String DRINKOUTAGE= "Drinkoutage";
	public static final String SMOKESTA_NAME= "Smokesta_name";
	public static final String DRINKSTA_NAME= "Drinksta_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patpsn() {
		return ((String) getAttrVal("Id_patpsn"));
	}	
	public void setId_patpsn(String Id_patpsn) {
		setAttrVal("Id_patpsn", Id_patpsn);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getSd_datasrc() {
		return ((String) getAttrVal("Sd_datasrc"));
	}	
	public void setSd_datasrc(String Sd_datasrc) {
		setAttrVal("Sd_datasrc", Sd_datasrc);
	}
	public String getId_smoksta() {
		return ((String) getAttrVal("Id_smoksta"));
	}	
	public void setId_smoksta(String Id_smoksta) {
		setAttrVal("Id_smoksta", Id_smoksta);
	}
	public String getSd_smoksta() {
		return ((String) getAttrVal("Sd_smoksta"));
	}	
	public void setSd_smoksta(String Sd_smoksta) {
		setAttrVal("Sd_smoksta", Sd_smoksta);
	}
	public String getSmokfreq() {
		return ((String) getAttrVal("Smokfreq"));
	}	
	public void setSmokfreq(String Smokfreq) {
		setAttrVal("Smokfreq", Smokfreq);
	}
	public String getSmokstartage() {
		return ((String) getAttrVal("Smokstartage"));
	}	
	public void setSmokstartage(String Smokstartage) {
		setAttrVal("Smokstartage", Smokstartage);
	}
	public FBoolean getFg_smokout() {
		return ((FBoolean) getAttrVal("Fg_smokout"));
	}	
	public void setFg_smokout(FBoolean Fg_smokout) {
		setAttrVal("Fg_smokout", Fg_smokout);
	}
	public String getSmokoutage() {
		return ((String) getAttrVal("Smokoutage"));
	}	
	public void setSmokoutage(String Smokoutage) {
		setAttrVal("Smokoutage", Smokoutage);
	}
	public String getId_drinksta() {
		return ((String) getAttrVal("Id_drinksta"));
	}	
	public void setId_drinksta(String Id_drinksta) {
		setAttrVal("Id_drinksta", Id_drinksta);
	}
	public String getSd_drinksta() {
		return ((String) getAttrVal("Sd_drinksta"));
	}	
	public void setSd_drinksta(String Sd_drinksta) {
		setAttrVal("Sd_drinksta", Sd_drinksta);
	}
	public String getDrinkfreq() {
		return ((String) getAttrVal("Drinkfreq"));
	}	
	public void setDrinkfreq(String Drinkfreq) {
		setAttrVal("Drinkfreq", Drinkfreq);
	}
	public String getDrinkstartage() {
		return ((String) getAttrVal("Drinkstartage"));
	}	
	public void setDrinkstartage(String Drinkstartage) {
		setAttrVal("Drinkstartage", Drinkstartage);
	}
	public FBoolean getFg_drinkout() {
		return ((FBoolean) getAttrVal("Fg_drinkout"));
	}	
	public void setFg_drinkout(FBoolean Fg_drinkout) {
		setAttrVal("Fg_drinkout", Fg_drinkout);
	}
	public String getDrinkoutage() {
		return ((String) getAttrVal("Drinkoutage"));
	}	
	public void setDrinkoutage(String Drinkoutage) {
		setAttrVal("Drinkoutage", Drinkoutage);
	}
	public String getSmokesta_name() {
		return ((String) getAttrVal("Smokesta_name"));
	}	
	public void setSmokesta_name(String Smokesta_name) {
		setAttrVal("Smokesta_name", Smokesta_name);
	}
	public String getDrinksta_name() {
		return ((String) getAttrVal("Drinksta_name"));
	}	
	public void setDrinksta_name(String Drinksta_name) {
		setAttrVal("Drinksta_name", Drinksta_name);
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
		return "Id_patpsn";
	}
	
	@Override
	public String getTableName() {	  
		return "PI_PAT_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatPsnDODesc.class);
	}
	
}