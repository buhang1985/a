package iih.nm.nhr.nmnuratc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnuratc.d.desc.NmNurAtcDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_人员论文专著 DO数据 
 * 
 */
public class NmNurAtcDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_ATC= "Id_nur_atc";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_NUR= "Id_nur";
	public static final String NAME_ATC= "Name_atc";
	public static final String DT_PUB= "Dt_pub";
	public static final String NAME_JOURNAL= "Name_journal";
	public static final String NO_JOURNAL= "No_journal";
	public static final String ID_JOURNAL_LEVEL= "Id_journal_level";
	public static final String SD_JOURNAL_LEVEL= "Sd_journal_level";
	public static final String ID_AUTHOR_LVL= "Id_author_lvl";
	public static final String SD_AUTHOR_LVL= "Sd_author_lvl";
	public static final String ID_NUR_LEVEL= "Id_nur_level";
	public static final String SD_NUR_LEVEL= "Sd_nur_level";
	public static final String DESC_DESC= "Desc_desc";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	public static final String DT_AUDIT= "Dt_audit";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_JOURNAL_LEVEL= "Name_journal_level";
	public static final String NAME_AUTHER_LVL= "Name_auther_lvl";
	public static final String NAME_NUR_LEVEL= "Name_nur_level";
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_atc() {
		return ((String) getAttrVal("Id_nur_atc"));
	}	
	public void setId_nur_atc(String Id_nur_atc) {
		setAttrVal("Id_nur_atc", Id_nur_atc);
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
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getName_atc() {
		return ((String) getAttrVal("Name_atc"));
	}	
	public void setName_atc(String Name_atc) {
		setAttrVal("Name_atc", Name_atc);
	}
	public FDate getDt_pub() {
		return ((FDate) getAttrVal("Dt_pub"));
	}	
	public void setDt_pub(FDate Dt_pub) {
		setAttrVal("Dt_pub", Dt_pub);
	}
	public String getName_journal() {
		return ((String) getAttrVal("Name_journal"));
	}	
	public void setName_journal(String Name_journal) {
		setAttrVal("Name_journal", Name_journal);
	}
	public String getNo_journal() {
		return ((String) getAttrVal("No_journal"));
	}	
	public void setNo_journal(String No_journal) {
		setAttrVal("No_journal", No_journal);
	}
	public String getId_journal_level() {
		return ((String) getAttrVal("Id_journal_level"));
	}	
	public void setId_journal_level(String Id_journal_level) {
		setAttrVal("Id_journal_level", Id_journal_level);
	}
	public String getSd_journal_level() {
		return ((String) getAttrVal("Sd_journal_level"));
	}	
	public void setSd_journal_level(String Sd_journal_level) {
		setAttrVal("Sd_journal_level", Sd_journal_level);
	}
	public String getId_author_lvl() {
		return ((String) getAttrVal("Id_author_lvl"));
	}	
	public void setId_author_lvl(String Id_author_lvl) {
		setAttrVal("Id_author_lvl", Id_author_lvl);
	}
	public String getSd_author_lvl() {
		return ((String) getAttrVal("Sd_author_lvl"));
	}	
	public void setSd_author_lvl(String Sd_author_lvl) {
		setAttrVal("Sd_author_lvl", Sd_author_lvl);
	}
	public String getId_nur_level() {
		return ((String) getAttrVal("Id_nur_level"));
	}	
	public void setId_nur_level(String Id_nur_level) {
		setAttrVal("Id_nur_level", Id_nur_level);
	}
	public String getSd_nur_level() {
		return ((String) getAttrVal("Sd_nur_level"));
	}	
	public void setSd_nur_level(String Sd_nur_level) {
		setAttrVal("Sd_nur_level", Sd_nur_level);
	}
	public String getDesc_desc() {
		return ((String) getAttrVal("Desc_desc"));
	}	
	public void setDesc_desc(String Desc_desc) {
		setAttrVal("Desc_desc", Desc_desc);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_journal_level() {
		return ((String) getAttrVal("Name_journal_level"));
	}	
	public void setName_journal_level(String Name_journal_level) {
		setAttrVal("Name_journal_level", Name_journal_level);
	}
	public String getName_auther_lvl() {
		return ((String) getAttrVal("Name_auther_lvl"));
	}	
	public void setName_auther_lvl(String Name_auther_lvl) {
		setAttrVal("Name_auther_lvl", Name_auther_lvl);
	}
	public String getName_nur_level() {
		return ((String) getAttrVal("Name_nur_level"));
	}	
	public void setName_nur_level(String Name_nur_level) {
		setAttrVal("Name_nur_level", Name_nur_level);
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
		return "Id_nur_atc";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NUR_ATC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurAtcDODesc.class);
	}
	
}