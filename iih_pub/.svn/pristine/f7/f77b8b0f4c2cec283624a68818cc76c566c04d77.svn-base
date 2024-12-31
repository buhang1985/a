package iih.nm.nqm.nmnqmqcmt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmqcmt.d.desc.NmNqmQcmtIsuDODesc;
import java.math.BigDecimal;

/**
 * 质控会议问题源 DO数据 
 * 
 */
public class NmNqmQcmtIsuDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_QCMT_ISU= "Id_nqm_qcmt_isu";
	public static final String ID_NQM_QCMT= "Id_nqm_qcmt";
	public static final String ID_NQM_CS= "Id_nqm_cs";
	public static final String FPY= "Fpy";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NQM_CS_NAME= "Nqm_cs_name";
	public static final String NQM_CS_CODE= "Nqm_cs_code";
	public static final String NQM_CS_DEP= "Nqm_cs_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_qcmt_isu() {
		return ((String) getAttrVal("Id_nqm_qcmt_isu"));
	}	
	public void setId_nqm_qcmt_isu(String Id_nqm_qcmt_isu) {
		setAttrVal("Id_nqm_qcmt_isu", Id_nqm_qcmt_isu);
	}
	public String getId_nqm_qcmt() {
		return ((String) getAttrVal("Id_nqm_qcmt"));
	}	
	public void setId_nqm_qcmt(String Id_nqm_qcmt) {
		setAttrVal("Id_nqm_qcmt", Id_nqm_qcmt);
	}
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	public FDouble getFpy() {
		return ((FDouble) getAttrVal("Fpy"));
	}	
	public void setFpy(FDouble Fpy) {
		setAttrVal("Fpy", Fpy);
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
	public String getNqm_cs_name() {
		return ((String) getAttrVal("Nqm_cs_name"));
	}	
	public void setNqm_cs_name(String Nqm_cs_name) {
		setAttrVal("Nqm_cs_name", Nqm_cs_name);
	}
	public String getNqm_cs_code() {
		return ((String) getAttrVal("Nqm_cs_code"));
	}	
	public void setNqm_cs_code(String Nqm_cs_code) {
		setAttrVal("Nqm_cs_code", Nqm_cs_code);
	}
	public String getNqm_cs_dep() {
		return ((String) getAttrVal("Nqm_cs_dep"));
	}	
	public void setNqm_cs_dep(String Nqm_cs_dep) {
		setAttrVal("Nqm_cs_dep", Nqm_cs_dep);
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
		return "Id_nqm_qcmt_isu";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_QCMT_ISU";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmQcmtIsuDODesc.class);
	}
	
}