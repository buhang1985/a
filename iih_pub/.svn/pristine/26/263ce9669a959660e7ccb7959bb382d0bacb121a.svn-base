package iih.bd.mhi.hospmedinsur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hospmedinsur.d.desc.HpHospMedInsurDODesc;
import java.math.BigDecimal;

/**
 * 医疗保险_医院医保信息 DO数据 
 * 
 */
public class HpHospMedInsurDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HOSPMI= "Id_hospmi";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String DMI_CODE= "Dmi_code";
	public static final String DMI_NAME= "Dmi_name";
	public static final String DMI_REGION_CODE= "Dmi_region_code";
	public static final String ID_PATSOURCE= "Id_patsource";
	public static final String SD_PATSOURCE= "Sd_patsource";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_CODE= "Hp_code";
	public static final String HP_NAME= "Hp_name";
	public static final String PATSOURCE_NAME= "Patsource_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hospmi() {
		return ((String) getAttrVal("Id_hospmi"));
	}	
	public void setId_hospmi(String Id_hospmi) {
		setAttrVal("Id_hospmi", Id_hospmi);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getDmi_code() {
		return ((String) getAttrVal("Dmi_code"));
	}	
	public void setDmi_code(String Dmi_code) {
		setAttrVal("Dmi_code", Dmi_code);
	}
	public String getDmi_name() {
		return ((String) getAttrVal("Dmi_name"));
	}	
	public void setDmi_name(String Dmi_name) {
		setAttrVal("Dmi_name", Dmi_name);
	}
	public String getDmi_region_code() {
		return ((String) getAttrVal("Dmi_region_code"));
	}	
	public void setDmi_region_code(String Dmi_region_code) {
		setAttrVal("Dmi_region_code", Dmi_region_code);
	}
	public String getId_patsource() {
		return ((String) getAttrVal("Id_patsource"));
	}	
	public void setId_patsource(String Id_patsource) {
		setAttrVal("Id_patsource", Id_patsource);
	}
	public String getSd_patsource() {
		return ((String) getAttrVal("Sd_patsource"));
	}	
	public void setSd_patsource(String Sd_patsource) {
		setAttrVal("Sd_patsource", Sd_patsource);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getHp_code() {
		return ((String) getAttrVal("Hp_code"));
	}	
	public void setHp_code(String Hp_code) {
		setAttrVal("Hp_code", Hp_code);
	}
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	public String getPatsource_name() {
		return ((String) getAttrVal("Patsource_name"));
	}	
	public void setPatsource_name(String Patsource_name) {
		setAttrVal("Patsource_name", Patsource_name);
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
		return "Id_hospmi";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_PP_HOSPMI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpHospMedInsurDODesc.class);
	}
	
}