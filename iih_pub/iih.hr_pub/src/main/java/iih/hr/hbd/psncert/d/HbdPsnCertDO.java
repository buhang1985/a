package iih.hr.hbd.psncert.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hr.hbd.psncert.d.desc.HbdPsnCertDODesc;
import java.math.BigDecimal;

/**
 * 人员证书 DO数据 
 * 
 */
public class HbdPsnCertDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HBD_PSN_CERT= "Id_hbd_psn_cert";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_CERTCA= "Id_certca";
	public static final String SD_CERTCA= "Sd_certca";
	public static final String ID_CERTTP= "Id_certtp";
	public static final String SD_CERTTP= "Sd_certtp";
	public static final String ID_MAJOR= "Id_major";
	public static final String SD_MAJOR= "Sd_major";
	public static final String ID_CERT_LEVEL= "Id_cert_level";
	public static final String SD_CERT_LEVEL= "Sd_cert_level";
	public static final String DT_CERT= "Dt_cert";
	public static final String DT_GAIN= "Dt_gain";
	public static final String DT_DUE= "Dt_due";
	public static final String NAME_CERT_ORG= "Name_cert_org";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_AUDIT= "Id_audit";
	public static final String DT_AUDIT= "Dt_audit";
	public static final String ID_PSN_REG= "Id_psn_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PSNDOC= "Name_psndoc";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_CERTCA= "Name_certca";
	public static final String NAME_CERTTP= "Name_certtp";
	public static final String NAME_MAJOR= "Name_major";
	public static final String NAME_CERT_LEVEL= "Name_cert_level";
	public static final String NAME_AUDIT= "Name_audit";
	public static final String NAME_PSN_REG= "Name_psn_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hbd_psn_cert() {
		return ((String) getAttrVal("Id_hbd_psn_cert"));
	}	
	public void setId_hbd_psn_cert(String Id_hbd_psn_cert) {
		setAttrVal("Id_hbd_psn_cert", Id_hbd_psn_cert);
	}
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	public String getId_certca() {
		return ((String) getAttrVal("Id_certca"));
	}	
	public void setId_certca(String Id_certca) {
		setAttrVal("Id_certca", Id_certca);
	}
	public String getSd_certca() {
		return ((String) getAttrVal("Sd_certca"));
	}	
	public void setSd_certca(String Sd_certca) {
		setAttrVal("Sd_certca", Sd_certca);
	}
	public String getId_certtp() {
		return ((String) getAttrVal("Id_certtp"));
	}	
	public void setId_certtp(String Id_certtp) {
		setAttrVal("Id_certtp", Id_certtp);
	}
	public String getSd_certtp() {
		return ((String) getAttrVal("Sd_certtp"));
	}	
	public void setSd_certtp(String Sd_certtp) {
		setAttrVal("Sd_certtp", Sd_certtp);
	}
	public String getId_major() {
		return ((String) getAttrVal("Id_major"));
	}	
	public void setId_major(String Id_major) {
		setAttrVal("Id_major", Id_major);
	}
	public String getSd_major() {
		return ((String) getAttrVal("Sd_major"));
	}	
	public void setSd_major(String Sd_major) {
		setAttrVal("Sd_major", Sd_major);
	}
	public String getId_cert_level() {
		return ((String) getAttrVal("Id_cert_level"));
	}	
	public void setId_cert_level(String Id_cert_level) {
		setAttrVal("Id_cert_level", Id_cert_level);
	}
	public String getSd_cert_level() {
		return ((String) getAttrVal("Sd_cert_level"));
	}	
	public void setSd_cert_level(String Sd_cert_level) {
		setAttrVal("Sd_cert_level", Sd_cert_level);
	}
	public FDateTime getDt_cert() {
		return ((FDateTime) getAttrVal("Dt_cert"));
	}	
	public void setDt_cert(FDateTime Dt_cert) {
		setAttrVal("Dt_cert", Dt_cert);
	}
	public FDateTime getDt_gain() {
		return ((FDateTime) getAttrVal("Dt_gain"));
	}	
	public void setDt_gain(FDateTime Dt_gain) {
		setAttrVal("Dt_gain", Dt_gain);
	}
	public FDateTime getDt_due() {
		return ((FDateTime) getAttrVal("Dt_due"));
	}	
	public void setDt_due(FDateTime Dt_due) {
		setAttrVal("Dt_due", Dt_due);
	}
	public String getName_cert_org() {
		return ((String) getAttrVal("Name_cert_org"));
	}	
	public void setName_cert_org(String Name_cert_org) {
		setAttrVal("Name_cert_org", Name_cert_org);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getId_audit() {
		return ((String) getAttrVal("Id_audit"));
	}	
	public void setId_audit(String Id_audit) {
		setAttrVal("Id_audit", Id_audit);
	}
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	public String getId_psn_reg() {
		return ((String) getAttrVal("Id_psn_reg"));
	}	
	public void setId_psn_reg(String Id_psn_reg) {
		setAttrVal("Id_psn_reg", Id_psn_reg);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_certca() {
		return ((String) getAttrVal("Name_certca"));
	}	
	public void setName_certca(String Name_certca) {
		setAttrVal("Name_certca", Name_certca);
	}
	public String getName_certtp() {
		return ((String) getAttrVal("Name_certtp"));
	}	
	public void setName_certtp(String Name_certtp) {
		setAttrVal("Name_certtp", Name_certtp);
	}
	public String getName_major() {
		return ((String) getAttrVal("Name_major"));
	}	
	public void setName_major(String Name_major) {
		setAttrVal("Name_major", Name_major);
	}
	public String getName_cert_level() {
		return ((String) getAttrVal("Name_cert_level"));
	}	
	public void setName_cert_level(String Name_cert_level) {
		setAttrVal("Name_cert_level", Name_cert_level);
	}
	public String getName_audit() {
		return ((String) getAttrVal("Name_audit"));
	}	
	public void setName_audit(String Name_audit) {
		setAttrVal("Name_audit", Name_audit);
	}
	public String getName_psn_reg() {
		return ((String) getAttrVal("Name_psn_reg"));
	}	
	public void setName_psn_reg(String Name_psn_reg) {
		setAttrVal("Name_psn_reg", Name_psn_reg);
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
		return "Id_hbd_psn_cert";
	}
	
	@Override
	public String getTableName() {	  
		return "HR_HBD_PSN_CERT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HbdPsnCertDODesc.class);
	}
	
}