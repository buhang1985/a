package iih.nm.nbd.nmnbdadtlvl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nbd.nmnbdadtlvl.d.desc.NmNbdAdtLvlDODesc;
import java.math.BigDecimal;

/**
 * 审核级别配置 DO数据 
 * 
 */
public class NmNbdAdtLvlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NBD_ADT_LVL= "Id_nbd_adt_lvl";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_ADUIT_LVL= "Id_aduit_lvl";
	public static final String SD_ADUIT_LVL= "Sd_aduit_lvl";
	public static final String FG_SYS= "Fg_sys";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ADUIT_LVL= "Name_aduit_lvl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nbd_adt_lvl() {
		return ((String) getAttrVal("Id_nbd_adt_lvl"));
	}	
	public void setId_nbd_adt_lvl(String Id_nbd_adt_lvl) {
		setAttrVal("Id_nbd_adt_lvl", Id_nbd_adt_lvl);
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
	public String getId_aduit_lvl() {
		return ((String) getAttrVal("Id_aduit_lvl"));
	}	
	public void setId_aduit_lvl(String Id_aduit_lvl) {
		setAttrVal("Id_aduit_lvl", Id_aduit_lvl);
	}
	public String getSd_aduit_lvl() {
		return ((String) getAttrVal("Sd_aduit_lvl"));
	}	
	public void setSd_aduit_lvl(String Sd_aduit_lvl) {
		setAttrVal("Sd_aduit_lvl", Sd_aduit_lvl);
	}
	public FBoolean getFg_sys() {
		return ((FBoolean) getAttrVal("Fg_sys"));
	}	
	public void setFg_sys(FBoolean Fg_sys) {
		setAttrVal("Fg_sys", Fg_sys);
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
	public String getName_aduit_lvl() {
		return ((String) getAttrVal("Name_aduit_lvl"));
	}	
	public void setName_aduit_lvl(String Name_aduit_lvl) {
		setAttrVal("Name_aduit_lvl", Name_aduit_lvl);
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
		return "Id_nbd_adt_lvl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NBD_ADT_LVL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNbdAdtLvlDODesc.class);
	}
	
}