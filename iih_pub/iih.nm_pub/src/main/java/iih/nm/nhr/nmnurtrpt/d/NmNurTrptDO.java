package iih.nm.nhr.nmnurtrpt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurtrpt.d.desc.NmNurTrptDODesc;
import java.math.BigDecimal;

/**
 * 人员调岗记录 DO数据 
 * 
 */
public class NmNurTrptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_TRPT= "Id_nur_trpt";
	public static final String ID_NUR= "Id_nur";
	public static final String ORG= "Org";
	public static final String GRP= "Grp";
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	public static final String SD_NUR_LVL= "Sd_nur_lvl";
	public static final String DT_EMYLVL= "Dt_emylvl";
	public static final String YEAR= "Year";
	public static final String DESPOST= "Despost";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_trpt() {
		return ((String) getAttrVal("Id_nur_trpt"));
	}	
	public void setId_nur_trpt(String Id_nur_trpt) {
		setAttrVal("Id_nur_trpt", Id_nur_trpt);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getOrg() {
		return ((String) getAttrVal("Org"));
	}	
	public void setOrg(String Org) {
		setAttrVal("Org", Org);
	}
	public String getGrp() {
		return ((String) getAttrVal("Grp"));
	}	
	public void setGrp(String Grp) {
		setAttrVal("Grp", Grp);
	}
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}	
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	public FDateTime getDt_emylvl() {
		return ((FDateTime) getAttrVal("Dt_emylvl"));
	}	
	public void setDt_emylvl(FDateTime Dt_emylvl) {
		setAttrVal("Dt_emylvl", Dt_emylvl);
	}
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	public String getDespost() {
		return ((String) getAttrVal("Despost"));
	}	
	public void setDespost(String Despost) {
		setAttrVal("Despost", Despost);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
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
		return "Id_nur_trpt";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_TRPT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurTrptDODesc.class);
	}
	
}