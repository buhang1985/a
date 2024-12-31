package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatMhDODesc;
import java.math.BigDecimal;

/**
 * 患者月经史 DO数据 
 * 
 */
public class PiPatMhDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATMH= "Id_patmh";
	public static final String ID_PAT= "Id_pat";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String AGE_1ST= "Age_1st";
	public static final String PERI= "Peri";
	public static final String CYCLE= "Cycle";
	public static final String AGE_MP= "Age_mp";
	public static final String FG_MP= "Fg_mp";
	public static final String FG_SURGMP= "Fg_surgmp";
	public static final String SD_BLEEDTP= "Sd_bleedtp";
	public static final String FG_DYS= "Fg_dys";
	public static final String ID_DEGDYS= "Id_degdys";
	public static final String SD_DEGDYS= "Sd_degdys";
	public static final String FG_DISO= "Fg_diso";
	public static final String ID_BLEEDTP= "Id_bleedtp";
	public static final String DEGDYS_CODE= "Degdys_code";
	public static final String DEGDYS_NAME= "Degdys_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patmh() {
		return ((String) getAttrVal("Id_patmh"));
	}	
	public void setId_patmh(String Id_patmh) {
		setAttrVal("Id_patmh", Id_patmh);
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
	public String getId_datasrc() {
		return ((String) getAttrVal("Id_datasrc"));
	}	
	public void setId_datasrc(String Id_datasrc) {
		setAttrVal("Id_datasrc", Id_datasrc);
	}
	public Integer getAge_1st() {
		return ((Integer) getAttrVal("Age_1st"));
	}	
	public void setAge_1st(Integer Age_1st) {
		setAttrVal("Age_1st", Age_1st);
	}
	public String getPeri() {
		return ((String) getAttrVal("Peri"));
	}	
	public void setPeri(String Peri) {
		setAttrVal("Peri", Peri);
	}
	public String getCycle() {
		return ((String) getAttrVal("Cycle"));
	}	
	public void setCycle(String Cycle) {
		setAttrVal("Cycle", Cycle);
	}
	public Integer getAge_mp() {
		return ((Integer) getAttrVal("Age_mp"));
	}	
	public void setAge_mp(Integer Age_mp) {
		setAttrVal("Age_mp", Age_mp);
	}
	public FBoolean getFg_mp() {
		return ((FBoolean) getAttrVal("Fg_mp"));
	}	
	public void setFg_mp(FBoolean Fg_mp) {
		setAttrVal("Fg_mp", Fg_mp);
	}
	public FBoolean getFg_surgmp() {
		return ((FBoolean) getAttrVal("Fg_surgmp"));
	}	
	public void setFg_surgmp(FBoolean Fg_surgmp) {
		setAttrVal("Fg_surgmp", Fg_surgmp);
	}
	public String getSd_bleedtp() {
		return ((String) getAttrVal("Sd_bleedtp"));
	}	
	public void setSd_bleedtp(String Sd_bleedtp) {
		setAttrVal("Sd_bleedtp", Sd_bleedtp);
	}
	public FBoolean getFg_dys() {
		return ((FBoolean) getAttrVal("Fg_dys"));
	}	
	public void setFg_dys(FBoolean Fg_dys) {
		setAttrVal("Fg_dys", Fg_dys);
	}
	public String getId_degdys() {
		return ((String) getAttrVal("Id_degdys"));
	}	
	public void setId_degdys(String Id_degdys) {
		setAttrVal("Id_degdys", Id_degdys);
	}
	public String getSd_degdys() {
		return ((String) getAttrVal("Sd_degdys"));
	}	
	public void setSd_degdys(String Sd_degdys) {
		setAttrVal("Sd_degdys", Sd_degdys);
	}
	public FBoolean getFg_diso() {
		return ((FBoolean) getAttrVal("Fg_diso"));
	}	
	public void setFg_diso(FBoolean Fg_diso) {
		setAttrVal("Fg_diso", Fg_diso);
	}
	public String getId_bleedtp() {
		return ((String) getAttrVal("Id_bleedtp"));
	}	
	public void setId_bleedtp(String Id_bleedtp) {
		setAttrVal("Id_bleedtp", Id_bleedtp);
	}
	public String getDegdys_code() {
		return ((String) getAttrVal("Degdys_code"));
	}	
	public void setDegdys_code(String Degdys_code) {
		setAttrVal("Degdys_code", Degdys_code);
	}
	public String getDegdys_name() {
		return ((String) getAttrVal("Degdys_name"));
	}	
	public void setDegdys_name(String Degdys_name) {
		setAttrVal("Degdys_name", Degdys_name);
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
		return "Id_patmh";
	}
	
	@Override
	public String getTableName() {	  
		return "PI_PAT_MH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatMhDODesc.class);
	}
	
}