package iih.nm.nit.nitpracgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpracgrp.d.desc.NitPracGrpPsnDODesc;
import java.math.BigDecimal;

/**
 * 大队实习成员 DO数据 
 * 
 */
public class NitPracGrpPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRACGRP_PSN= "Id_pracgrp_psn";
	public static final String ID_PRACGRP= "Id_pracgrp";
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	public static final String FG_HEADER= "Fg_header";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PSNINFO= "Name_psninfo";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pracgrp_psn() {
		return ((String) getAttrVal("Id_pracgrp_psn"));
	}	
	public void setId_pracgrp_psn(String Id_pracgrp_psn) {
		setAttrVal("Id_pracgrp_psn", Id_pracgrp_psn);
	}
	public String getId_pracgrp() {
		return ((String) getAttrVal("Id_pracgrp"));
	}	
	public void setId_pracgrp(String Id_pracgrp) {
		setAttrVal("Id_pracgrp", Id_pracgrp);
	}
	public String getId_nit_psninfo() {
		return ((String) getAttrVal("Id_nit_psninfo"));
	}	
	public void setId_nit_psninfo(String Id_nit_psninfo) {
		setAttrVal("Id_nit_psninfo", Id_nit_psninfo);
	}
	public FBoolean getFg_header() {
		return ((FBoolean) getAttrVal("Fg_header"));
	}	
	public void setFg_header(FBoolean Fg_header) {
		setAttrVal("Fg_header", Fg_header);
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
	public String getName_psninfo() {
		return ((String) getAttrVal("Name_psninfo"));
	}	
	public void setName_psninfo(String Name_psninfo) {
		setAttrVal("Name_psninfo", Name_psninfo);
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
		return "Id_pracgrp_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRACGRP_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPracGrpPsnDODesc.class);
	}
	
}