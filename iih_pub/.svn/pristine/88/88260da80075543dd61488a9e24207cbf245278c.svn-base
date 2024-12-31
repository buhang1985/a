package iih.bl.hp.hppatblacklist.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hppatblacklist.d.desc.HpPatBlackListDODesc;
import java.math.BigDecimal;

/**
 * 医保黑名单 DO数据 
 * 
 */
public class HpPatBlackListDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPBLACKLIST= "Id_hpblacklist";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String SOCIAL_NO= "Social_no";
	public static final String INSUR_NO= "Insur_no";
	public static final String NAME= "Name";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String EU_SRCTYPE= "Eu_srctype";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_HP= "Name_hp";
	public static final String NAME_SEX= "Name_sex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpblacklist() {
		return ((String) getAttrVal("Id_hpblacklist"));
	}	
	public void setId_hpblacklist(String Id_hpblacklist) {
		setAttrVal("Id_hpblacklist", Id_hpblacklist);
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
	public String getSocial_no() {
		return ((String) getAttrVal("Social_no"));
	}	
	public void setSocial_no(String Social_no) {
		setAttrVal("Social_no", Social_no);
	}
	public String getInsur_no() {
		return ((String) getAttrVal("Insur_no"));
	}	
	public void setInsur_no(String Insur_no) {
		setAttrVal("Insur_no", Insur_no);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getEu_srctype() {
		return ((String) getAttrVal("Eu_srctype"));
	}	
	public void setEu_srctype(String Eu_srctype) {
		setAttrVal("Eu_srctype", Eu_srctype);
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
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
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
		return "Id_hpblacklist";
	}
	
	@Override
	public String getTableName() {	  
		return "BL_HP_PAT_BLACKLIST";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpPatBlackListDODesc.class);
	}
	
}