package iih.bd.mhi.hpadmstatusdircomp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.hpadmstatusdircomp.d.desc.HpAdmstatusDirCompDODesc;
import java.math.BigDecimal;

/**
 * 入院状态对照 DO数据 
 * 
 */
public class HpAdmstatusDirCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ADMSTATUSDIRCOMP= "Id_admstatusdircomp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_ADMSTATUS= "Id_admstatus";
	public static final String ID_LEVELDISE= "Id_leveldise";
	public static final String NAME_LEVELDISE= "Name_leveldise";
	public static final String CODE_LEVELDISE= "Code_leveldise";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String HP_NAME= "Hp_name";
	public static final String ADMSTATUS_NAME= "Admstatus_name";
	public static final String LEVELDISE_NAME= "Leveldise_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_admstatusdircomp() {
		return ((String) getAttrVal("Id_admstatusdircomp"));
	}	
	public void setId_admstatusdircomp(String Id_admstatusdircomp) {
		setAttrVal("Id_admstatusdircomp", Id_admstatusdircomp);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_admstatus() {
		return ((String) getAttrVal("Id_admstatus"));
	}	
	public void setId_admstatus(String Id_admstatus) {
		setAttrVal("Id_admstatus", Id_admstatus);
	}
	public String getId_leveldise() {
		return ((String) getAttrVal("Id_leveldise"));
	}	
	public void setId_leveldise(String Id_leveldise) {
		setAttrVal("Id_leveldise", Id_leveldise);
	}
	public String getName_leveldise() {
		return ((String) getAttrVal("Name_leveldise"));
	}	
	public void setName_leveldise(String Name_leveldise) {
		setAttrVal("Name_leveldise", Name_leveldise);
	}
	public String getCode_leveldise() {
		return ((String) getAttrVal("Code_leveldise"));
	}	
	public void setCode_leveldise(String Code_leveldise) {
		setAttrVal("Code_leveldise", Code_leveldise);
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
	public String getHp_name() {
		return ((String) getAttrVal("Hp_name"));
	}	
	public void setHp_name(String Hp_name) {
		setAttrVal("Hp_name", Hp_name);
	}
	public String getAdmstatus_name() {
		return ((String) getAttrVal("Admstatus_name"));
	}	
	public void setAdmstatus_name(String Admstatus_name) {
		setAttrVal("Admstatus_name", Admstatus_name);
	}
	public String getLeveldise_name() {
		return ((String) getAttrVal("Leveldise_name"));
	}	
	public void setLeveldise_name(String Leveldise_name) {
		setAttrVal("Leveldise_name", Leveldise_name);
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
		return "Id_admstatusdircomp";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_COMP_ADMSTATUS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpAdmstatusDirCompDODesc.class);
	}
	
}