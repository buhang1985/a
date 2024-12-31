package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnMedGrpDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_医疗组 DO数据 
 * 
 */
public class EnMedGrpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTWG= "Id_entwg";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_WG= "Id_wg";
	public static final String ID_ENWGROLE= "Id_enwgrole";
	public static final String SD_ENWGROLE= "Sd_enwgrole";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String FG_PSN= "Fg_psn";
	public static final String NAME_WG= "Name_wg";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entwg() {
		return ((String) getAttrVal("Id_entwg"));
	}	
	public void setId_entwg(String Id_entwg) {
		setAttrVal("Id_entwg", Id_entwg);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_wg() {
		return ((String) getAttrVal("Id_wg"));
	}	
	public void setId_wg(String Id_wg) {
		setAttrVal("Id_wg", Id_wg);
	}
	public String getId_enwgrole() {
		return ((String) getAttrVal("Id_enwgrole"));
	}	
	public void setId_enwgrole(String Id_enwgrole) {
		setAttrVal("Id_enwgrole", Id_enwgrole);
	}
	public String getSd_enwgrole() {
		return ((String) getAttrVal("Sd_enwgrole"));
	}	
	public void setSd_enwgrole(String Sd_enwgrole) {
		setAttrVal("Sd_enwgrole", Sd_enwgrole);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	public FBoolean getFg_psn() {
		return ((FBoolean) getAttrVal("Fg_psn"));
	}	
	public void setFg_psn(FBoolean Fg_psn) {
		setAttrVal("Fg_psn", Fg_psn);
	}
	public String getName_wg() {
		return ((String) getAttrVal("Name_wg"));
	}	
	public void setName_wg(String Name_wg) {
		setAttrVal("Name_wg", Name_wg);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_entwg";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_wg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnMedGrpDODesc.class);
	}
	
}