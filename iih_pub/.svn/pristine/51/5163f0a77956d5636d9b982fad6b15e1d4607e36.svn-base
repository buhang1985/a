package iih.nm.nit.nitpracpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpracpl.d.desc.NitPracPlDODesc;
import java.math.BigDecimal;

/**
 * 个人实习计划 DO数据 
 * 
 */
public class NitPracPlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PRAC_PL= "Id_prac_pl";
	public static final String ID_GROP= "Id_grop";
	public static final String ID_ORG= "Id_org";
	public static final String ID_NIT_PSNINOF= "Id_nit_psninof";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String COUNT_WEEK= "Count_week";
	public static final String DT_END= "Dt_end";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String ID_REG= "Id_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NIT_PSNINOF= "Name_nit_psninof";
	public static final String NAME_REG= "Name_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_prac_pl() {
		return ((String) getAttrVal("Id_prac_pl"));
	}	
	public void setId_prac_pl(String Id_prac_pl) {
		setAttrVal("Id_prac_pl", Id_prac_pl);
	}
	public String getId_grop() {
		return ((String) getAttrVal("Id_grop"));
	}	
	public void setId_grop(String Id_grop) {
		setAttrVal("Id_grop", Id_grop);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_nit_psninof() {
		return ((String) getAttrVal("Id_nit_psninof"));
	}	
	public void setId_nit_psninof(String Id_nit_psninof) {
		setAttrVal("Id_nit_psninof", Id_nit_psninof);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public Integer getCount_week() {
		return ((Integer) getAttrVal("Count_week"));
	}	
	public void setCount_week(Integer Count_week) {
		setAttrVal("Count_week", Count_week);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public String getId_reg() {
		return ((String) getAttrVal("Id_reg"));
	}	
	public void setId_reg(String Id_reg) {
		setAttrVal("Id_reg", Id_reg);
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
	public String getName_nit_psninof() {
		return ((String) getAttrVal("Name_nit_psninof"));
	}	
	public void setName_nit_psninof(String Name_nit_psninof) {
		setAttrVal("Name_nit_psninof", Name_nit_psninof);
	}
	public String getName_reg() {
		return ((String) getAttrVal("Name_reg"));
	}	
	public void setName_reg(String Name_reg) {
		setAttrVal("Name_reg", Name_reg);
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
		return "Id_prac_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRAC_PL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPracPlDODesc.class);
	}
	
}