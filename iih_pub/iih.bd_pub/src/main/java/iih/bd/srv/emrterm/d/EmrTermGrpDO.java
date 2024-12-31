package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrterm.d.desc.EmrTermGrpDODesc;
import java.math.BigDecimal;

/**
 * 病历术语分组 DO数据 
 * 
 */
public class EmrTermGrpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRATERMGRP= "Id_mratermgrp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SORTNO= "Sortno";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_MRTERMSYS= "Id_mrtermsys";
	public static final String SD_MRTERMSYS= "Sd_mrtermsys";
	public static final String ID_MRATERMCA= "Id_mratermca";
	public static final String ID_MRTERMSYS_APP= "Id_mrtermsys_app";
	public static final String SD_MRTERMSYS_APP= "Sd_mrtermsys_app";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MR_SYS_NAME= "Mr_sys_name";
	public static final String MR_CA_NAME= "Mr_ca_name";
	public static final String MR_CA_CODE= "Mr_ca_code";
	public static final String MR_SYS_APP_NAME= "Mr_sys_app_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mratermgrp() {
		return ((String) getAttrVal("Id_mratermgrp"));
	}	
	public void setId_mratermgrp(String Id_mratermgrp) {
		setAttrVal("Id_mratermgrp", Id_mratermgrp);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getId_mrtermsys() {
		return ((String) getAttrVal("Id_mrtermsys"));
	}	
	public void setId_mrtermsys(String Id_mrtermsys) {
		setAttrVal("Id_mrtermsys", Id_mrtermsys);
	}
	public String getSd_mrtermsys() {
		return ((String) getAttrVal("Sd_mrtermsys"));
	}	
	public void setSd_mrtermsys(String Sd_mrtermsys) {
		setAttrVal("Sd_mrtermsys", Sd_mrtermsys);
	}
	public String getId_mratermca() {
		return ((String) getAttrVal("Id_mratermca"));
	}	
	public void setId_mratermca(String Id_mratermca) {
		setAttrVal("Id_mratermca", Id_mratermca);
	}
	public String getId_mrtermsys_app() {
		return ((String) getAttrVal("Id_mrtermsys_app"));
	}	
	public void setId_mrtermsys_app(String Id_mrtermsys_app) {
		setAttrVal("Id_mrtermsys_app", Id_mrtermsys_app);
	}
	public String getSd_mrtermsys_app() {
		return ((String) getAttrVal("Sd_mrtermsys_app"));
	}	
	public void setSd_mrtermsys_app(String Sd_mrtermsys_app) {
		setAttrVal("Sd_mrtermsys_app", Sd_mrtermsys_app);
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
	public String getMr_sys_name() {
		return ((String) getAttrVal("Mr_sys_name"));
	}	
	public void setMr_sys_name(String Mr_sys_name) {
		setAttrVal("Mr_sys_name", Mr_sys_name);
	}
	public String getMr_ca_name() {
		return ((String) getAttrVal("Mr_ca_name"));
	}	
	public void setMr_ca_name(String Mr_ca_name) {
		setAttrVal("Mr_ca_name", Mr_ca_name);
	}
	public String getMr_ca_code() {
		return ((String) getAttrVal("Mr_ca_code"));
	}	
	public void setMr_ca_code(String Mr_ca_code) {
		setAttrVal("Mr_ca_code", Mr_ca_code);
	}
	public String getMr_sys_app_name() {
		return ((String) getAttrVal("Mr_sys_app_name"));
	}	
	public void setMr_sys_app_name(String Mr_sys_app_name) {
		setAttrVal("Mr_sys_app_name", Mr_sys_app_name);
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
		return "Id_mratermgrp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mra_termgrp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrTermGrpDODesc.class);
	}
	
}