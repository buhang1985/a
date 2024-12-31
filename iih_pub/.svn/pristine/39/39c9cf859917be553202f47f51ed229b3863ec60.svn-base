package iih.nm.nit.nitpractmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nitpractmpl.d.desc.NitPractmplDepDODesc;
import java.math.BigDecimal;

/**
 * 实习模板科室 DO数据 
 * 
 */
public class NitPractmplDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NIT_PRACTMPL_DEP= "Id_nit_practmpl_dep";
	public static final String ID_NIT_PRACTMPL= "Id_nit_practmpl";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String WEEK_COUNT= "Week_count";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NIT_PRACTMPL= "Name_nit_practmpl";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nit_practmpl_dep() {
		return ((String) getAttrVal("Id_nit_practmpl_dep"));
	}	
	public void setId_nit_practmpl_dep(String Id_nit_practmpl_dep) {
		setAttrVal("Id_nit_practmpl_dep", Id_nit_practmpl_dep);
	}
	public String getId_nit_practmpl() {
		return ((String) getAttrVal("Id_nit_practmpl"));
	}	
	public void setId_nit_practmpl(String Id_nit_practmpl) {
		setAttrVal("Id_nit_practmpl", Id_nit_practmpl);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public Integer getWeek_count() {
		return ((Integer) getAttrVal("Week_count"));
	}	
	public void setWeek_count(Integer Week_count) {
		setAttrVal("Week_count", Week_count);
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
	public String getName_nit_practmpl() {
		return ((String) getAttrVal("Name_nit_practmpl"));
	}	
	public void setName_nit_practmpl(String Name_nit_practmpl) {
		setAttrVal("Name_nit_practmpl", Name_nit_practmpl);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_nit_practmpl_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_PRACTMPL_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NitPractmplDepDODesc.class);
	}
	
}