package iih.bd.srv.emrterm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrterm.d.desc.EmrTermDODesc;
import java.math.BigDecimal;

/**
 * 病历术语 DO数据 
 * 
 */
public class EmrTermDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRATERM= "Id_mraterm";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MRTERMSYS= "Id_mrtermsys";
	public static final String SD_MRTERMSYS= "Sd_mrtermsys";
	public static final String ID_MRATERMCA= "Id_mratermca";
	public static final String ID_MRATERMGRP= "Id_mratermgrp";
	public static final String SORTNO= "Sortno";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_EMRTERMREFTP= "Id_emrtermreftp";
	public static final String SD_EMRTERMREFTP= "Sd_emrtermreftp";
	public static final String ELECONT= "Elecont";
	public static final String ID_LEVEL_MRTERM= "Id_level_mrterm";
	public static final String SD_LEVEL_MRTERM= "Sd_level_mrterm";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_IMG= "Id_img";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MR_GRP_NAME= "Mr_grp_name";
	public static final String MR_GRP_CODE= "Mr_grp_code";
	public static final String MR_ORG_CODE= "Mr_org_code";
	public static final String MR_ORG_NAME= "Mr_org_name";
	public static final String MR_SYS_NAME= "Mr_sys_name";
	public static final String MR_CA_NAME= "Mr_ca_name";
	public static final String MR_CA_CODE= "Mr_ca_code";
	public static final String MRA_GRP_NAME= "Mra_grp_name";
	public static final String MRA_GRP_SORTNO= "Mra_grp_sortno";
	public static final String MRA_GRP_CODE= "Mra_grp_code";
	public static final String MR_REFTP_NAME= "Mr_reftp_name";
	public static final String MR_LEVEL_NAME= "Mr_level_name";
	public static final String MR_CREATE_CODE= "Mr_create_code";
	public static final String MR_CREATE_NAME= "Mr_create_name";
	public static final String MR_MODIF_NAME= "Mr_modif_name";
	public static final String MR_MODIF_CODE= "Mr_modif_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mraterm() {
		return ((String) getAttrVal("Id_mraterm"));
	}	
	public void setId_mraterm(String Id_mraterm) {
		setAttrVal("Id_mraterm", Id_mraterm);
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
	public String getId_mratermgrp() {
		return ((String) getAttrVal("Id_mratermgrp"));
	}	
	public void setId_mratermgrp(String Id_mratermgrp) {
		setAttrVal("Id_mratermgrp", Id_mratermgrp);
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
	public String getId_emrtermreftp() {
		return ((String) getAttrVal("Id_emrtermreftp"));
	}	
	public void setId_emrtermreftp(String Id_emrtermreftp) {
		setAttrVal("Id_emrtermreftp", Id_emrtermreftp);
	}
	public String getSd_emrtermreftp() {
		return ((String) getAttrVal("Sd_emrtermreftp"));
	}	
	public void setSd_emrtermreftp(String Sd_emrtermreftp) {
		setAttrVal("Sd_emrtermreftp", Sd_emrtermreftp);
	}
	public String getElecont() {
		return ((String) getAttrVal("Elecont"));
	}	
	public void setElecont(String Elecont) {
		setAttrVal("Elecont", Elecont);
	}
	public String getId_level_mrterm() {
		return ((String) getAttrVal("Id_level_mrterm"));
	}	
	public void setId_level_mrterm(String Id_level_mrterm) {
		setAttrVal("Id_level_mrterm", Id_level_mrterm);
	}
	public String getSd_level_mrterm() {
		return ((String) getAttrVal("Sd_level_mrterm"));
	}	
	public void setSd_level_mrterm(String Sd_level_mrterm) {
		setAttrVal("Sd_level_mrterm", Sd_level_mrterm);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getId_img() {
		return ((String) getAttrVal("Id_img"));
	}	
	public void setId_img(String Id_img) {
		setAttrVal("Id_img", Id_img);
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
	public String getMr_grp_name() {
		return ((String) getAttrVal("Mr_grp_name"));
	}	
	public void setMr_grp_name(String Mr_grp_name) {
		setAttrVal("Mr_grp_name", Mr_grp_name);
	}
	public String getMr_grp_code() {
		return ((String) getAttrVal("Mr_grp_code"));
	}	
	public void setMr_grp_code(String Mr_grp_code) {
		setAttrVal("Mr_grp_code", Mr_grp_code);
	}
	public String getMr_org_code() {
		return ((String) getAttrVal("Mr_org_code"));
	}	
	public void setMr_org_code(String Mr_org_code) {
		setAttrVal("Mr_org_code", Mr_org_code);
	}
	public String getMr_org_name() {
		return ((String) getAttrVal("Mr_org_name"));
	}	
	public void setMr_org_name(String Mr_org_name) {
		setAttrVal("Mr_org_name", Mr_org_name);
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
	public String getMra_grp_name() {
		return ((String) getAttrVal("Mra_grp_name"));
	}	
	public void setMra_grp_name(String Mra_grp_name) {
		setAttrVal("Mra_grp_name", Mra_grp_name);
	}
	public Integer getMra_grp_sortno() {
		return ((Integer) getAttrVal("Mra_grp_sortno"));
	}	
	public void setMra_grp_sortno(Integer Mra_grp_sortno) {
		setAttrVal("Mra_grp_sortno", Mra_grp_sortno);
	}
	public String getMra_grp_code() {
		return ((String) getAttrVal("Mra_grp_code"));
	}	
	public void setMra_grp_code(String Mra_grp_code) {
		setAttrVal("Mra_grp_code", Mra_grp_code);
	}
	public String getMr_reftp_name() {
		return ((String) getAttrVal("Mr_reftp_name"));
	}	
	public void setMr_reftp_name(String Mr_reftp_name) {
		setAttrVal("Mr_reftp_name", Mr_reftp_name);
	}
	public String getMr_level_name() {
		return ((String) getAttrVal("Mr_level_name"));
	}	
	public void setMr_level_name(String Mr_level_name) {
		setAttrVal("Mr_level_name", Mr_level_name);
	}
	public String getMr_create_code() {
		return ((String) getAttrVal("Mr_create_code"));
	}	
	public void setMr_create_code(String Mr_create_code) {
		setAttrVal("Mr_create_code", Mr_create_code);
	}
	public String getMr_create_name() {
		return ((String) getAttrVal("Mr_create_name"));
	}	
	public void setMr_create_name(String Mr_create_name) {
		setAttrVal("Mr_create_name", Mr_create_name);
	}
	public String getMr_modif_name() {
		return ((String) getAttrVal("Mr_modif_name"));
	}	
	public void setMr_modif_name(String Mr_modif_name) {
		setAttrVal("Mr_modif_name", Mr_modif_name);
	}
	public String getMr_modif_code() {
		return ((String) getAttrVal("Mr_modif_code"));
	}	
	public void setMr_modif_code(String Mr_modif_code) {
		setAttrVal("Mr_modif_code", Mr_modif_code);
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
		return "Id_mraterm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mra_term";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmrTermDODesc.class);
	}
	
}