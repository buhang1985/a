package iih.hp.cp.sd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.sd.d.desc.HpCpStandardDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划标准 DO数据 
 * 
 */
public class HpCpStandardDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SD= "Id_sd";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String DES= "Des";
	public static final String EU_APPLY_TP= "Eu_apply_tp";
	public static final String ID_ELETP= "Id_eletp";
	public static final String VERSION= "Version";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String FG_LOCK_CHILD= "Fg_lock_child";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ELETP= "Name_eletp";
	public static final String NAME_STATUS= "Name_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_sd() {
		return ((String) getAttrVal("Id_sd"));
	}	
	public void setId_sd(String Id_sd) {
		setAttrVal("Id_sd", Id_sd);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getEu_apply_tp() {
		return ((Integer) getAttrVal("Eu_apply_tp"));
	}	
	public void setEu_apply_tp(Integer Eu_apply_tp) {
		setAttrVal("Eu_apply_tp", Eu_apply_tp);
	}
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	public String getVersion() {
		return ((String) getAttrVal("Version"));
	}	
	public void setVersion(String Version) {
		setAttrVal("Version", Version);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FBoolean getFg_lock_child() {
		return ((FBoolean) getAttrVal("Fg_lock_child"));
	}	
	public void setFg_lock_child(FBoolean Fg_lock_child) {
		setAttrVal("Fg_lock_child", Fg_lock_child);
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
	public String getName_eletp() {
		return ((String) getAttrVal("Name_eletp"));
	}	
	public void setName_eletp(String Name_eletp) {
		setAttrVal("Name_eletp", Name_eletp);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
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
		return "Id_sd";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_SD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpStandardDODesc.class);
	}
	
}