package iih.nm.nit.nitpracgrppl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpracgrppl.d.desc.NitPracGrpPlPsnDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_小组成员 DO数据 
 * 
 */
public class NitPracGrpPlPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRACGRP_PL_PSN= "Id_pracgrp_pl_psn";
	public static final String ID_PRACGRP_PL= "Id_pracgrp_pl";
	public static final String ID_NIT_PSNINFO= "Id_nit_psninfo";
	public static final String FG_HEADER= "Fg_header";
	public static final String CREATEDBY= "Createdby";
	public static final String SORTNO= "Sortno";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PSNINFO= "Name_psninfo";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pracgrp_pl_psn() {
		return ((String) getAttrVal("Id_pracgrp_pl_psn"));
	}	
	public void setId_pracgrp_pl_psn(String Id_pracgrp_pl_psn) {
		setAttrVal("Id_pracgrp_pl_psn", Id_pracgrp_pl_psn);
	}
	public String getId_pracgrp_pl() {
		return ((String) getAttrVal("Id_pracgrp_pl"));
	}	
	public void setId_pracgrp_pl(String Id_pracgrp_pl) {
		setAttrVal("Id_pracgrp_pl", Id_pracgrp_pl);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_pracgrp_pl_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRACGRP_PL_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPracGrpPlPsnDODesc.class);
	}
	
}