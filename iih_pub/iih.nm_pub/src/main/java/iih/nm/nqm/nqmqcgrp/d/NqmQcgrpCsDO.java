package iih.nm.nqm.nqmqcgrp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmqcgrp.d.desc.NqmQcgrpCsDODesc;
import java.math.BigDecimal;

/**
 * 负责质量标准 DO数据 
 * 
 */
public class NqmQcgrpCsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_QCGRP_CS= "Id_nqm_qcgrp_cs";
	public static final String ID_NQM_QCGRP= "Id_nqm_qcgrp";
	public static final String ID_NQM_CS= "Id_nqm_cs";
	public static final String CODE_NQM_CS= "Code_nqm_cs";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_qcgrp_cs() {
		return ((String) getAttrVal("Id_nqm_qcgrp_cs"));
	}	
	public void setId_nqm_qcgrp_cs(String Id_nqm_qcgrp_cs) {
		setAttrVal("Id_nqm_qcgrp_cs", Id_nqm_qcgrp_cs);
	}
	public String getId_nqm_qcgrp() {
		return ((String) getAttrVal("Id_nqm_qcgrp"));
	}	
	public void setId_nqm_qcgrp(String Id_nqm_qcgrp) {
		setAttrVal("Id_nqm_qcgrp", Id_nqm_qcgrp);
	}
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	public String getCode_nqm_cs() {
		return ((String) getAttrVal("Code_nqm_cs"));
	}	
	public void setCode_nqm_cs(String Code_nqm_cs) {
		setAttrVal("Code_nqm_cs", Code_nqm_cs);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_nqm_qcgrp_cs";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_QCGRP_CS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmQcgrpCsDODesc.class);
	}
	
}