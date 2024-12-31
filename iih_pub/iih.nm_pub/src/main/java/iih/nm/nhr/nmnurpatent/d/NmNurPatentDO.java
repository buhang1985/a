package iih.nm.nhr.nmnurpatent.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurpatent.d.desc.NmNurPatentDODesc;
import java.math.BigDecimal;

/**
 * 护理人员_专利登记 DO数据 
 * 
 */
public class NmNurPatentDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_PATENT= "Id_nur_patent";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_NUR= "Id_nur";
	public static final String NAME_APPLY= "Name_apply";
	public static final String NO_APPLY= "No_apply";
	public static final String DT_APPLY= "Dt_apply";
	public static final String NO_PATENT= "No_patent";
	public static final String DT_PATENT= "Dt_patent";
	public static final String NAME_PATENT= "Name_patent";
	public static final String ID_PATENTTP= "Id_patenttp";
	public static final String SD_PATENTTP= "Sd_patenttp";
	public static final String NAME_INVENTOR= "Name_inventor";
	public static final String ID_INVENTOR_LVL= "Id_inventor_lvl";
	public static final String SD_INVENTOR_LVL= "Sd_inventor_lvl";
	public static final String DESC_ABSTRACT= "Desc_abstract";
	public static final String ID_EMP_REG= "Id_emp_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_EMP_AUDIT= "Id_emp_audit";
	public static final String DT_AUDIT= "Dt_audit";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_PATENTTP= "Name_patenttp";
	public static final String NAME_INVENTOR_LVL= "Name_inventor_lvl";
	public static final String NAME_EMP_REG= "Name_emp_reg";
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_patent() {
		return ((String) getAttrVal("Id_nur_patent"));
	}	
	public void setId_nur_patent(String Id_nur_patent) {
		setAttrVal("Id_nur_patent", Id_nur_patent);
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
	public String getName_apply() {
		return ((String) getAttrVal("Name_apply"));
	}	
	public void setName_apply(String Name_apply) {
		setAttrVal("Name_apply", Name_apply);
	}
	public String getNo_apply() {
		return ((String) getAttrVal("No_apply"));
	}	
	public void setNo_apply(String No_apply) {
		setAttrVal("No_apply", No_apply);
	}
	public FDate getDt_apply() {
		return ((FDate) getAttrVal("Dt_apply"));
	}	
	public void setDt_apply(FDate Dt_apply) {
		setAttrVal("Dt_apply", Dt_apply);
	}
	public String getNo_patent() {
		return ((String) getAttrVal("No_patent"));
	}	
	public void setNo_patent(String No_patent) {
		setAttrVal("No_patent", No_patent);
	}
	public FDate getDt_patent() {
		return ((FDate) getAttrVal("Dt_patent"));
	}	
	public void setDt_patent(FDate Dt_patent) {
		setAttrVal("Dt_patent", Dt_patent);
	}
	public String getName_patent() {
		return ((String) getAttrVal("Name_patent"));
	}	
	public void setName_patent(String Name_patent) {
		setAttrVal("Name_patent", Name_patent);
	}
	public String getId_patenttp() {
		return ((String) getAttrVal("Id_patenttp"));
	}	
	public void setId_patenttp(String Id_patenttp) {
		setAttrVal("Id_patenttp", Id_patenttp);
	}
	public String getSd_patenttp() {
		return ((String) getAttrVal("Sd_patenttp"));
	}	
	public void setSd_patenttp(String Sd_patenttp) {
		setAttrVal("Sd_patenttp", Sd_patenttp);
	}
	public String getName_inventor() {
		return ((String) getAttrVal("Name_inventor"));
	}	
	public void setName_inventor(String Name_inventor) {
		setAttrVal("Name_inventor", Name_inventor);
	}
	public String getId_inventor_lvl() {
		return ((String) getAttrVal("Id_inventor_lvl"));
	}	
	public void setId_inventor_lvl(String Id_inventor_lvl) {
		setAttrVal("Id_inventor_lvl", Id_inventor_lvl);
	}
	public String getSd_inventor_lvl() {
		return ((String) getAttrVal("Sd_inventor_lvl"));
	}	
	public void setSd_inventor_lvl(String Sd_inventor_lvl) {
		setAttrVal("Sd_inventor_lvl", Sd_inventor_lvl);
	}
	public String getDesc_abstract() {
		return ((String) getAttrVal("Desc_abstract"));
	}	
	public void setDesc_abstract(String Desc_abstract) {
		setAttrVal("Desc_abstract", Desc_abstract);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_patenttp() {
		return ((String) getAttrVal("Name_patenttp"));
	}	
	public void setName_patenttp(String Name_patenttp) {
		setAttrVal("Name_patenttp", Name_patenttp);
	}
	public String getName_inventor_lvl() {
		return ((String) getAttrVal("Name_inventor_lvl"));
	}	
	public void setName_inventor_lvl(String Name_inventor_lvl) {
		setAttrVal("Name_inventor_lvl", Name_inventor_lvl);
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
		return "Id_nur_patent";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NUR_PATENT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurPatentDODesc.class);
	}
	
}