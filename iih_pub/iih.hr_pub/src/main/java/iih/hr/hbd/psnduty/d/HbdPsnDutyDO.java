package iih.hr.hbd.psnduty.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hr.hbd.psnduty.d.desc.HbdPsnDutyDODesc;
import java.math.BigDecimal;

/**
 * 人员职务 DO数据 
 * 
 */
public class HbdPsnDutyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HBD_PSN_DUTY= "Id_hbd_psn_duty";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DUTY= "Id_duty";
	public static final String SD_DUTY= "Sd_duty";
	public static final String ID_ADMIN_DUTY= "Id_admin_duty";
	public static final String SD_ADMIN_DUTY= "Sd_admin_duty";
	public static final String DT_APT= "Dt_apt";
	public static final String APT_YEAR_LENTH= "Apt_year_lenth";
	public static final String ID_APT_GIST= "Id_apt_gist";
	public static final String SD_APT_GIST= "Sd_apt_gist";
	public static final String DES= "Des";
	public static final String ID_REG_PSN= "Id_reg_psn";
	public static final String DT_REG= "Dt_reg";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_DUTY= "Name_duty";
	public static final String NAME_ADMIN_DUTY= "Name_admin_duty";
	public static final String NAME_APT_GIST= "Name_apt_gist";
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hbd_psn_duty() {
		return ((String) getAttrVal("Id_hbd_psn_duty"));
	}	
	public void setId_hbd_psn_duty(String Id_hbd_psn_duty) {
		setAttrVal("Id_hbd_psn_duty", Id_hbd_psn_duty);
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
	public String getId_admin_duty() {
		return ((String) getAttrVal("Id_admin_duty"));
	}	
	public void setId_admin_duty(String Id_admin_duty) {
		setAttrVal("Id_admin_duty", Id_admin_duty);
	}
	public String getSd_admin_duty() {
		return ((String) getAttrVal("Sd_admin_duty"));
	}	
	public void setSd_admin_duty(String Sd_admin_duty) {
		setAttrVal("Sd_admin_duty", Sd_admin_duty);
	}
	public FDateTime getDt_apt() {
		return ((FDateTime) getAttrVal("Dt_apt"));
	}	
	public void setDt_apt(FDateTime Dt_apt) {
		setAttrVal("Dt_apt", Dt_apt);
	}
	public Integer getApt_year_lenth() {
		return ((Integer) getAttrVal("Apt_year_lenth"));
	}	
	public void setApt_year_lenth(Integer Apt_year_lenth) {
		setAttrVal("Apt_year_lenth", Apt_year_lenth);
	}
	public String getId_apt_gist() {
		return ((String) getAttrVal("Id_apt_gist"));
	}	
	public void setId_apt_gist(String Id_apt_gist) {
		setAttrVal("Id_apt_gist", Id_apt_gist);
	}
	public String getSd_apt_gist() {
		return ((String) getAttrVal("Sd_apt_gist"));
	}	
	public void setSd_apt_gist(String Sd_apt_gist) {
		setAttrVal("Sd_apt_gist", Sd_apt_gist);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
	}
	public String getName_admin_duty() {
		return ((String) getAttrVal("Name_admin_duty"));
	}	
	public void setName_admin_duty(String Name_admin_duty) {
		setAttrVal("Name_admin_duty", Name_admin_duty);
	}
	public String getName_apt_gist() {
		return ((String) getAttrVal("Name_apt_gist"));
	}	
	public void setName_apt_gist(String Name_apt_gist) {
		setAttrVal("Name_apt_gist", Name_apt_gist);
	}
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_hbd_psn_duty";
	}
	
	@Override
	public String getTableName() {	  
		return "HR_HBD_PSN_DUTY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HbdPsnDutyDODesc.class);
	}
	
}