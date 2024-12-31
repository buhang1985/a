package iih.pi.reg.pat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.reg.pat.d.desc.PiPatBiolDODesc;
import java.math.BigDecimal;

/**
 * 患者生物学信息 DO数据 
 * 
 */
public class PiPatBiolDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者生物学信息ID
	public static final String ID_PATBIOL= "Id_patbiol";
	//患者
	public static final String ID_PAT= "Id_pat";
	//血型
	public static final String ID_BLOOD_ABO= "Id_blood_abo";
	//血型编码
	public static final String SD_BLOOD_ABO= "Sd_blood_abo";
	//RH反应
	public static final String ID_BLOOD_RH= "Id_blood_rh";
	//RH反应编码
	public static final String SD_BLOOD_RH= "Sd_blood_rh";
	//名称
	public static final String BLOODABO_NAME= "Bloodabo_name";
	//名称
	public static final String BLOODRH_NAME= "Bloodrh_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者生物学信息ID
	 * @return String
	 */
	public String getId_patbiol() {
		return ((String) getAttrVal("Id_patbiol"));
	}	
	/**
	 * 患者生物学信息ID
	 * @param Id_patbiol
	 */
	public void setId_patbiol(String Id_patbiol) {
		setAttrVal("Id_patbiol", Id_patbiol);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getId_blood_abo() {
		return ((String) getAttrVal("Id_blood_abo"));
	}	
	/**
	 * 血型
	 * @param Id_blood_abo
	 */
	public void setId_blood_abo(String Id_blood_abo) {
		setAttrVal("Id_blood_abo", Id_blood_abo);
	}
	/**
	 * 血型编码
	 * @return String
	 */
	public String getSd_blood_abo() {
		return ((String) getAttrVal("Sd_blood_abo"));
	}	
	/**
	 * 血型编码
	 * @param Sd_blood_abo
	 */
	public void setSd_blood_abo(String Sd_blood_abo) {
		setAttrVal("Sd_blood_abo", Sd_blood_abo);
	}
	/**
	 * RH反应
	 * @return String
	 */
	public String getId_blood_rh() {
		return ((String) getAttrVal("Id_blood_rh"));
	}	
	/**
	 * RH反应
	 * @param Id_blood_rh
	 */
	public void setId_blood_rh(String Id_blood_rh) {
		setAttrVal("Id_blood_rh", Id_blood_rh);
	}
	/**
	 * RH反应编码
	 * @return String
	 */
	public String getSd_blood_rh() {
		return ((String) getAttrVal("Sd_blood_rh"));
	}	
	/**
	 * RH反应编码
	 * @param Sd_blood_rh
	 */
	public void setSd_blood_rh(String Sd_blood_rh) {
		setAttrVal("Sd_blood_rh", Sd_blood_rh);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBloodabo_name() {
		return ((String) getAttrVal("Bloodabo_name"));
	}	
	/**
	 * 名称
	 * @param Bloodabo_name
	 */
	public void setBloodabo_name(String Bloodabo_name) {
		setAttrVal("Bloodabo_name", Bloodabo_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBloodrh_name() {
		return ((String) getAttrVal("Bloodrh_name"));
	}	
	/**
	 * 名称
	 * @param Bloodrh_name
	 */
	public void setBloodrh_name(String Bloodrh_name) {
		setAttrVal("Bloodrh_name", Bloodrh_name);
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
		return "Id_patbiol";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_biol";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatBiolDODesc.class);
	}
	
}