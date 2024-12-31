package iih.mi.bd.miudidocuse.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.bd.miudidocuse.d.desc.MiUdidoclistUseDODesc;
import java.math.BigDecimal;

/**
 * 医保档案类型使用 DO数据 
 * 
 */
public class MiUdidoclistUseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MIUDIDOCUSE= "Id_miudidocuse";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String ID_MIUDIDOCLIST= "Id_miudidoclist";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_HP= "Name_hp";
	public static final String CODE_HP= "Code_hp";
	public static final String CODE_MIUDIDOCLIST= "Code_miudidoclist";
	public static final String NAME_MIUDIDOCLIST= "Name_miudidoclist";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_miudidocuse() {
		return ((String) getAttrVal("Id_miudidocuse"));
	}	
	public void setId_miudidocuse(String Id_miudidocuse) {
		setAttrVal("Id_miudidocuse", Id_miudidocuse);
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
	public String getId_miudidoclist() {
		return ((String) getAttrVal("Id_miudidoclist"));
	}	
	public void setId_miudidoclist(String Id_miudidoclist) {
		setAttrVal("Id_miudidoclist", Id_miudidoclist);
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
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public String getCode_miudidoclist() {
		return ((String) getAttrVal("Code_miudidoclist"));
	}	
	public void setCode_miudidoclist(String Code_miudidoclist) {
		setAttrVal("Code_miudidoclist", Code_miudidoclist);
	}
	public String getName_miudidoclist() {
		return ((String) getAttrVal("Name_miudidoclist"));
	}	
	public void setName_miudidoclist(String Name_miudidoclist) {
		setAttrVal("Name_miudidoclist", Name_miudidoclist);
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
		return "Id_miudidocuse";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_udidoclist_use";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiUdidoclistUseDODesc.class);
	}
	
}