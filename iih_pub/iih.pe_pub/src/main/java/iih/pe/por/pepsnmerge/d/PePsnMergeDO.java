package iih.pe.por.pepsnmerge.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pepsnmerge.d.desc.PePsnMergeDODesc;
import java.math.BigDecimal;

/**
 * 体检客户资料合并 DO数据 
 * 
 */
public class PePsnMergeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPSNMERGE= "Id_pepsnmerge";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEPSNBINFO_FROM= "Id_pepsnbinfo_from";
	public static final String ID_PEPSNBINFO_TO= "Id_pepsnbinfo_to";
	public static final String DT_MERGE= "Dt_merge";
	public static final String MERGEREASON= "Mergereason";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_FROM= "Code_from";
	public static final String NAME_FROM= "Name_from";
	public static final String IDCODE_FROM= "Idcode_from";
	public static final String SD_SEX_FROM= "Sd_sex_from";
	public static final String MOB_FROM= "Mob_from";
	public static final String CODE_TO= "Code_to";
	public static final String NAME_TO= "Name_to";
	public static final String SD_SEX_TO= "Sd_sex_to";
	public static final String IDCODE_TO= "Idcode_to";
	public static final String MOB_TO= "Mob_to";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepsnmerge() {
		return ((String) getAttrVal("Id_pepsnmerge"));
	}	
	public void setId_pepsnmerge(String Id_pepsnmerge) {
		setAttrVal("Id_pepsnmerge", Id_pepsnmerge);
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
	public String getId_pepsnbinfo_from() {
		return ((String) getAttrVal("Id_pepsnbinfo_from"));
	}	
	public void setId_pepsnbinfo_from(String Id_pepsnbinfo_from) {
		setAttrVal("Id_pepsnbinfo_from", Id_pepsnbinfo_from);
	}
	public String getId_pepsnbinfo_to() {
		return ((String) getAttrVal("Id_pepsnbinfo_to"));
	}	
	public void setId_pepsnbinfo_to(String Id_pepsnbinfo_to) {
		setAttrVal("Id_pepsnbinfo_to", Id_pepsnbinfo_to);
	}
	public FDateTime getDt_merge() {
		return ((FDateTime) getAttrVal("Dt_merge"));
	}	
	public void setDt_merge(FDateTime Dt_merge) {
		setAttrVal("Dt_merge", Dt_merge);
	}
	public String getMergereason() {
		return ((String) getAttrVal("Mergereason"));
	}	
	public void setMergereason(String Mergereason) {
		setAttrVal("Mergereason", Mergereason);
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
	public String getCode_from() {
		return ((String) getAttrVal("Code_from"));
	}	
	public void setCode_from(String Code_from) {
		setAttrVal("Code_from", Code_from);
	}
	public String getName_from() {
		return ((String) getAttrVal("Name_from"));
	}	
	public void setName_from(String Name_from) {
		setAttrVal("Name_from", Name_from);
	}
	public String getIdcode_from() {
		return ((String) getAttrVal("Idcode_from"));
	}	
	public void setIdcode_from(String Idcode_from) {
		setAttrVal("Idcode_from", Idcode_from);
	}
	public String getSd_sex_from() {
		return ((String) getAttrVal("Sd_sex_from"));
	}	
	public void setSd_sex_from(String Sd_sex_from) {
		setAttrVal("Sd_sex_from", Sd_sex_from);
	}
	public String getMob_from() {
		return ((String) getAttrVal("Mob_from"));
	}	
	public void setMob_from(String Mob_from) {
		setAttrVal("Mob_from", Mob_from);
	}
	public String getCode_to() {
		return ((String) getAttrVal("Code_to"));
	}	
	public void setCode_to(String Code_to) {
		setAttrVal("Code_to", Code_to);
	}
	public String getName_to() {
		return ((String) getAttrVal("Name_to"));
	}	
	public void setName_to(String Name_to) {
		setAttrVal("Name_to", Name_to);
	}
	public String getSd_sex_to() {
		return ((String) getAttrVal("Sd_sex_to"));
	}	
	public void setSd_sex_to(String Sd_sex_to) {
		setAttrVal("Sd_sex_to", Sd_sex_to);
	}
	public String getIdcode_to() {
		return ((String) getAttrVal("Idcode_to"));
	}	
	public void setIdcode_to(String Idcode_to) {
		setAttrVal("Idcode_to", Idcode_to);
	}
	public String getMob_to() {
		return ((String) getAttrVal("Mob_to"));
	}	
	public void setMob_to(String Mob_to) {
		setAttrVal("Mob_to", Mob_to);
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
		return "Id_pepsnmerge";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_log_pepsnmerge";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnMergeDODesc.class);
	}
	
}