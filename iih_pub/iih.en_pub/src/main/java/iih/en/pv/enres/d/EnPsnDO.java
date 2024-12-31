package iih.en.pv.enres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enres.d.desc.EnPsnDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊_人员 DO数据 
 * 
 */
public class EnPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTEMP= "Id_entemp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_EMPROLE= "Id_emprole";
	public static final String SD_EMPROLE= "Sd_emprole";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String NAME_PSNDOC= "Name_psndoc";
	public static final String SD_PSNDOC= "Sd_psndoc";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entemp() {
		return ((String) getAttrVal("Id_entemp"));
	}	
	public void setId_entemp(String Id_entemp) {
		setAttrVal("Id_entemp", Id_entemp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_emprole() {
		return ((String) getAttrVal("Id_emprole"));
	}	
	public void setId_emprole(String Id_emprole) {
		setAttrVal("Id_emprole", Id_emprole);
	}
	public String getSd_emprole() {
		return ((String) getAttrVal("Sd_emprole"));
	}	
	public void setSd_emprole(String Sd_emprole) {
		setAttrVal("Sd_emprole", Sd_emprole);
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
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	public String getSd_psndoc() {
		return ((String) getAttrVal("Sd_psndoc"));
	}	
	public void setSd_psndoc(String Sd_psndoc) {
		setAttrVal("Sd_psndoc", Sd_psndoc);
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
		return "Id_entemp";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_emp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnPsnDODesc.class);
	}
	
}