package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hp.d.desc.BdHpPatcaDODesc;
import java.math.BigDecimal;

/**
 * 医保计划_医保身份 DO数据 
 * 
 */
public class BdHpPatcaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPPATCA= "Id_hppatca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_HP= "Id_hp";
	public static final String CODE_HPPATCA= "Code_hppatca";
	public static final String NAME_HPPATCA= "Name_hppatca";
	public static final String FG_ALLINHP= "Fg_allinhp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hppatca() {
		return ((String) getAttrVal("Id_hppatca"));
	}	
	public void setId_hppatca(String Id_hppatca) {
		setAttrVal("Id_hppatca", Id_hppatca);
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
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}	
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}	
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
	}
	public FBoolean getFg_allinhp() {
		return ((FBoolean) getAttrVal("Fg_allinhp"));
	}	
	public void setFg_allinhp(FBoolean Fg_allinhp) {
		setAttrVal("Fg_allinhp", Fg_allinhp);
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
		return "Id_hppatca";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_PATCA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdHpPatcaDODesc.class);
	}
	
}