package iih.mp.nr.infugrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.infugrp.d.desc.MpInfuGrpDODesc;
import java.math.BigDecimal;

/**
 * 输液分组信息 DO数据 
 * 
 */
public class MpInfuGrpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INFU_GRP= "Id_infu_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String NO_GRP= "No_grp";
	public static final String SORTNO= "Sortno";
	public static final String ID_EMP_GRP= "Id_emp_grp";
	public static final String ID_DEP_GRP= "Id_dep_grp";
	public static final String DT_GRP= "Dt_grp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_infu_grp() {
		return ((String) getAttrVal("Id_infu_grp"));
	}	
	public void setId_infu_grp(String Id_infu_grp) {
		setAttrVal("Id_infu_grp", Id_infu_grp);
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
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public String getNo_grp() {
		return ((String) getAttrVal("No_grp"));
	}	
	public void setNo_grp(String No_grp) {
		setAttrVal("No_grp", No_grp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_emp_grp() {
		return ((String) getAttrVal("Id_emp_grp"));
	}	
	public void setId_emp_grp(String Id_emp_grp) {
		setAttrVal("Id_emp_grp", Id_emp_grp);
	}
	public String getId_dep_grp() {
		return ((String) getAttrVal("Id_dep_grp"));
	}	
	public void setId_dep_grp(String Id_dep_grp) {
		setAttrVal("Id_dep_grp", Id_dep_grp);
	}
	public FDateTime getDt_grp() {
		return ((FDateTime) getAttrVal("Dt_grp"));
	}	
	public void setDt_grp(FDateTime Dt_grp) {
		setAttrVal("Dt_grp", Dt_grp);
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
		return "Id_infu_grp";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_infu_grp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpInfuGrpDODesc.class);
	}
	
}