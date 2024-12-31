package iih.hr.hbd.psnrewards.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hr.hbd.psnrewards.d.desc.HbdPsnRewardsDODesc;
import java.math.BigDecimal;

/**
 * 人员奖惩 DO数据 
 * 
 */
public class HbdPsnRewardsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HBD_PSN_REWARDS= "Id_hbd_psn_rewards";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String YEAR= "Year";
	public static final String ID_HONORTP= "Id_honortp";
	public static final String SD_HONORTP= "Sd_honortp";
	public static final String NAME_HONOR= "Name_honor";
	public static final String DT_HONOR= "Dt_honor";
	public static final String ID_HONOR_LEVEL= "Id_honor_level";
	public static final String SD_HONOR_LEVEL= "Sd_honor_level";
	public static final String ID_HONOR_SRC= "Id_honor_src";
	public static final String SD_HONOR_SRC= "Sd_honor_src";
	public static final String NAME_ORG= "Name_org";
	public static final String ID_JOBTITLE= "Id_jobtitle";
	public static final String SD_JOBTITLE= "Sd_jobtitle";
	public static final String ID_DUTY= "Id_duty";
	public static final String SD_DUTY= "Sd_duty";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	public static final String DT_AUDIT= "Dt_audit";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_HONORTP= "Name_honortp";
	public static final String NAME_HONOR_LEVEL= "Name_honor_level";
	public static final String NAME_HONOR_SRC= "Name_honor_src";
	public static final String NAME_JOBTITLE= "Name_jobtitle";
	public static final String NAME_DUTY= "Name_duty";
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hbd_psn_rewards() {
		return ((String) getAttrVal("Id_hbd_psn_rewards"));
	}	
	public void setId_hbd_psn_rewards(String Id_hbd_psn_rewards) {
		setAttrVal("Id_hbd_psn_rewards", Id_hbd_psn_rewards);
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
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public FDate getYear() {
		return ((FDate) getAttrVal("Year"));
	}	
	public void setYear(FDate Year) {
		setAttrVal("Year", Year);
	}
	public String getId_honortp() {
		return ((String) getAttrVal("Id_honortp"));
	}	
	public void setId_honortp(String Id_honortp) {
		setAttrVal("Id_honortp", Id_honortp);
	}
	public String getSd_honortp() {
		return ((String) getAttrVal("Sd_honortp"));
	}	
	public void setSd_honortp(String Sd_honortp) {
		setAttrVal("Sd_honortp", Sd_honortp);
	}
	public String getName_honor() {
		return ((String) getAttrVal("Name_honor"));
	}	
	public void setName_honor(String Name_honor) {
		setAttrVal("Name_honor", Name_honor);
	}
	public FDate getDt_honor() {
		return ((FDate) getAttrVal("Dt_honor"));
	}	
	public void setDt_honor(FDate Dt_honor) {
		setAttrVal("Dt_honor", Dt_honor);
	}
	public String getId_honor_level() {
		return ((String) getAttrVal("Id_honor_level"));
	}	
	public void setId_honor_level(String Id_honor_level) {
		setAttrVal("Id_honor_level", Id_honor_level);
	}
	public String getSd_honor_level() {
		return ((String) getAttrVal("Sd_honor_level"));
	}	
	public void setSd_honor_level(String Sd_honor_level) {
		setAttrVal("Sd_honor_level", Sd_honor_level);
	}
	public String getId_honor_src() {
		return ((String) getAttrVal("Id_honor_src"));
	}	
	public void setId_honor_src(String Id_honor_src) {
		setAttrVal("Id_honor_src", Id_honor_src);
	}
	public String getSd_honor_src() {
		return ((String) getAttrVal("Sd_honor_src"));
	}	
	public void setSd_honor_src(String Sd_honor_src) {
		setAttrVal("Sd_honor_src", Sd_honor_src);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getId_jobtitle() {
		return ((String) getAttrVal("Id_jobtitle"));
	}	
	public void setId_jobtitle(String Id_jobtitle) {
		setAttrVal("Id_jobtitle", Id_jobtitle);
	}
	public String getSd_jobtitle() {
		return ((String) getAttrVal("Sd_jobtitle"));
	}	
	public void setSd_jobtitle(String Sd_jobtitle) {
		setAttrVal("Sd_jobtitle", Sd_jobtitle);
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
	public String getId_emp_reg() {
		return ((String) getAttrVal("Id_emp_reg"));
	}	
	public void setId_emp_reg(String Id_emp_reg) {
		setAttrVal("Id_emp_reg", Id_emp_reg);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getId_emp_audit() {
		return ((String) getAttrVal("Id_emp_audit"));
	}	
	public void setId_emp_audit(String Id_emp_audit) {
		setAttrVal("Id_emp_audit", Id_emp_audit);
	}
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
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
	public String getName_honortp() {
		return ((String) getAttrVal("Name_honortp"));
	}	
	public void setName_honortp(String Name_honortp) {
		setAttrVal("Name_honortp", Name_honortp);
	}
	public String getName_honor_level() {
		return ((String) getAttrVal("Name_honor_level"));
	}	
	public void setName_honor_level(String Name_honor_level) {
		setAttrVal("Name_honor_level", Name_honor_level);
	}
	public String getName_honor_src() {
		return ((String) getAttrVal("Name_honor_src"));
	}	
	public void setName_honor_src(String Name_honor_src) {
		setAttrVal("Name_honor_src", Name_honor_src);
	}
	public String getName_jobtitle() {
		return ((String) getAttrVal("Name_jobtitle"));
	}	
	public void setName_jobtitle(String Name_jobtitle) {
		setAttrVal("Name_jobtitle", Name_jobtitle);
	}
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
	}
	public String getName_emp_reg() {
		return ((String) getAttrVal("Name_emp_reg"));
	}	
	public void setName_emp_reg(String Name_emp_reg) {
		setAttrVal("Name_emp_reg", Name_emp_reg);
	}
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	public void setName_emp_audit(String Name_emp_audit) {
		setAttrVal("Name_emp_audit", Name_emp_audit);
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
		return "Id_hbd_psn_rewards";
	}
	
	@Override
	public String getTableName() {	  
		return "HR_HBD_PSN_REWARDS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HbdPsnRewardsDODesc.class);
	}
	
}