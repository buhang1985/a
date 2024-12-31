package iih.pe.por.pepsncard.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.por.pepsncard.d.desc.PePsnCardDDODesc;
import java.math.BigDecimal;

/**
 * 体检客户会员卡 DO数据 
 * 
 */
public class PePsnCardDDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPSNCARD= "Id_pepsncard";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	public static final String NO_CARD= "No_card";
	public static final String FG_MASTER= "Fg_master";
	public static final String CARDST= "Cardst";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_PSN= "Code_psn";
	public static final String NAME_PSN= "Name_psn";
	public static final String IDCODE= "Idcode";
	public static final String MOB= "Mob";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepsncard() {
		return ((String) getAttrVal("Id_pepsncard"));
	}	
	public void setId_pepsncard(String Id_pepsncard) {
		setAttrVal("Id_pepsncard", Id_pepsncard);
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
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	public String getNo_card() {
		return ((String) getAttrVal("No_card"));
	}	
	public void setNo_card(String No_card) {
		setAttrVal("No_card", No_card);
	}
	public FBoolean getFg_master() {
		return ((FBoolean) getAttrVal("Fg_master"));
	}	
	public void setFg_master(FBoolean Fg_master) {
		setAttrVal("Fg_master", Fg_master);
	}
	public Integer getCardst() {
		return ((Integer) getAttrVal("Cardst"));
	}	
	public void setCardst(Integer Cardst) {
		setAttrVal("Cardst", Cardst);
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
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
	}
	public String getIdcode() {
		return ((String) getAttrVal("Idcode"));
	}	
	public void setIdcode(String Idcode) {
		setAttrVal("Idcode", Idcode);
	}
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
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
		return "Id_pepsncard";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_or_pepsncard";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnCardDDODesc.class);
	}
	
}