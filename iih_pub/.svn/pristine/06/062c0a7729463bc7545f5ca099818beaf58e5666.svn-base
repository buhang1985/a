package iih.nm.nqm.nqmqcgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmqcgrp.d.desc.NqmQcgrpPsnDesc;
import java.math.BigDecimal;

/**
 * 质控组成员 DO数据 
 * 
 */
public class NqmQcgrpPsn extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_QCGRP_PSN= "Id_nqm_qcgrp_psn";
	public static final String ID_NQM_QCGRP= "Id_nqm_qcgrp";
	public static final String ID_NUR= "Id_nur";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	public static final String ID_DUTY= "Id_duty";
	public static final String SD_DUTY= "Sd_duty";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR_QCGRP= "Name_nur_qcgrp";
	public static final String NAME_DUTY= "Name_duty";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_qcgrp_psn() {
		return ((String) getAttrVal("Id_nqm_qcgrp_psn"));
	}	
	public void setId_nqm_qcgrp_psn(String Id_nqm_qcgrp_psn) {
		setAttrVal("Id_nqm_qcgrp_psn", Id_nqm_qcgrp_psn);
	}
	public String getId_nqm_qcgrp() {
		return ((String) getAttrVal("Id_nqm_qcgrp"));
	}	
	public void setId_nqm_qcgrp(String Id_nqm_qcgrp) {
		setAttrVal("Id_nqm_qcgrp", Id_nqm_qcgrp);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
	}
	public String getId_duty() {
		return ((String) getAttrVal("Id_duty"));
	}	
	public void setId_duty(String Id_duty) {
		setAttrVal("Id_duty", Id_duty);
	}
	public String getSd_duty() {
		return ((String) getAttrVal("Sd_duty"));
	}	
	public void setSd_duty(String Sd_duty) {
		setAttrVal("Sd_duty", Sd_duty);
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
	public String getName_nur_qcgrp() {
		return ((String) getAttrVal("Name_nur_qcgrp"));
	}	
	public void setName_nur_qcgrp(String Name_nur_qcgrp) {
		setAttrVal("Name_nur_qcgrp", Name_nur_qcgrp);
	}
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
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
		return "Id_nqm_qcgrp_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_QCGRP_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmQcgrpPsnDesc.class);
	}
	
}