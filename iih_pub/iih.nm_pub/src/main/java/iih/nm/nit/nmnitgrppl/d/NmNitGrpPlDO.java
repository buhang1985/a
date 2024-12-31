package iih.nm.nit.nmnitgrppl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nmnitgrppl.d.desc.NmNitGrpPlDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_实习小组计划 DO数据 
 * 
 */
public class NmNitGrpPlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NIT_GRPPL= "Id_nit_grppl";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NIT_GRP= "Id_nit_grp";
	public static final String NAME= "Name";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String UNIT_WEEK= "Unit_week";
	public static final String TOTAL_WEEKS= "Total_weeks";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String COUNT_GRPPSN= "Count_grppsn";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nit_grppl() {
		return ((String) getAttrVal("Id_nit_grppl"));
	}	
	public void setId_nit_grppl(String Id_nit_grppl) {
		setAttrVal("Id_nit_grppl", Id_nit_grppl);
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
	public String getId_nit_grp() {
		return ((String) getAttrVal("Id_nit_grp"));
	}	
	public void setId_nit_grp(String Id_nit_grp) {
		setAttrVal("Id_nit_grp", Id_nit_grp);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public Integer getUnit_week() {
		return ((Integer) getAttrVal("Unit_week"));
	}	
	public void setUnit_week(Integer Unit_week) {
		setAttrVal("Unit_week", Unit_week);
	}
	public Integer getTotal_weeks() {
		return ((Integer) getAttrVal("Total_weeks"));
	}	
	public void setTotal_weeks(Integer Total_weeks) {
		setAttrVal("Total_weeks", Total_weeks);
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
	public Integer getCount_grppsn() {
		return ((Integer) getAttrVal("Count_grppsn"));
	}	
	public void setCount_grppsn(Integer Count_grppsn) {
		setAttrVal("Count_grppsn", Count_grppsn);
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
		return "Id_nit_grppl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_GRPPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNitGrpPlDODesc.class);
	}
	
}