package iih.nm.nit.nmnitgrppl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nit.nmnitgrppl.d.desc.NmNitGrpPlDepDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_实习小组计划_轮转科室 DO数据 
 * 
 */
public class NmNitGrpPlDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPT_PL_DEP= "Id_opt_pl_dep";
	public static final String ID_NIT_GRPPL= "Id_nit_grppl";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_DEP= "Id_dep";
	public static final String COUNT_WEEK= "Count_week";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SORTNO= "Sortno";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opt_pl_dep() {
		return ((String) getAttrVal("Id_opt_pl_dep"));
	}	
	public void setId_opt_pl_dep(String Id_opt_pl_dep) {
		setAttrVal("Id_opt_pl_dep", Id_opt_pl_dep);
	}
	public String getId_nit_grppl() {
		return ((String) getAttrVal("Id_nit_grppl"));
	}	
	public void setId_nit_grppl(String Id_nit_grppl) {
		setAttrVal("Id_nit_grppl", Id_nit_grppl);
	}
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public Integer getCount_week() {
		return ((Integer) getAttrVal("Count_week"));
	}	
	public void setCount_week(Integer Count_week) {
		setAttrVal("Count_week", Count_week);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_opt_pl_dep";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NIT_GRPPL_DEP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNitGrpPlDepDODesc.class);
	}
	
}