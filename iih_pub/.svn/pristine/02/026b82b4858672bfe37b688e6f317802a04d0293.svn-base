package iih.pe.pitm.pesrvrptgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesrvrptgrp.d.desc.PeSrvrPtGrpDODesc;
import java.math.BigDecimal;

/**
 * 体检结果报告分组 DO数据 
 * 
 */
public class PeSrvrPtGrpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESRVRPTGRP= "Id_pesrvrptgrp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ENAME= "Ename";
	public static final String REPORT_PART= "Report_part";
	public static final String SORTNO= "Sortno";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DEPT= "Code_dept";
	public static final String NAME_DEPT= "Name_dept";
	public static final String CODE_RPT= "Code_rpt";
	public static final String NAME_RPT= "Name_rpt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesrvrptgrp() {
		return ((String) getAttrVal("Id_pesrvrptgrp"));
	}	
	public void setId_pesrvrptgrp(String Id_pesrvrptgrp) {
		setAttrVal("Id_pesrvrptgrp", Id_pesrvrptgrp);
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
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
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
	public String getEname() {
		return ((String) getAttrVal("Ename"));
	}	
	public void setEname(String Ename) {
		setAttrVal("Ename", Ename);
	}
	public String getReport_part() {
		return ((String) getAttrVal("Report_part"));
	}	
	public void setReport_part(String Report_part) {
		setAttrVal("Report_part", Report_part);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getCode_rpt() {
		return ((String) getAttrVal("Code_rpt"));
	}	
	public void setCode_rpt(String Code_rpt) {
		setAttrVal("Code_rpt", Code_rpt);
	}
	public String getName_rpt() {
		return ((String) getAttrVal("Name_rpt"));
	}	
	public void setName_rpt(String Name_rpt) {
		setAttrVal("Name_rpt", Name_rpt);
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
		return "Id_pesrvrptgrp";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pesrvptgrp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSrvrPtGrpDODesc.class);
	}
	
}