package iih.nm.nqm.nmnqmqcmt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmqcmt.d.desc.NmNqmqcmtPsnDODesc;
import java.math.BigDecimal;

/**
 * 质控会议参会人 DO数据 
 * 
 */
public class NmNqmqcmtPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_QCMT_PSN= "Id_nqm_qcmt_psn";
	public static final String ID_NQM_QCMT= "Id_nqm_qcmt";
	public static final String ID_NUR= "Id_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String JOB_NO_NUR= "Job_no_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_qcmt_psn() {
		return ((String) getAttrVal("Id_nqm_qcmt_psn"));
	}	
	public void setId_nqm_qcmt_psn(String Id_nqm_qcmt_psn) {
		setAttrVal("Id_nqm_qcmt_psn", Id_nqm_qcmt_psn);
	}
	public String getId_nqm_qcmt() {
		return ((String) getAttrVal("Id_nqm_qcmt"));
	}	
	public void setId_nqm_qcmt(String Id_nqm_qcmt) {
		setAttrVal("Id_nqm_qcmt", Id_nqm_qcmt);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	public String getJob_no_nur() {
		return ((String) getAttrVal("Job_no_nur"));
	}	
	public void setJob_no_nur(String Job_no_nur) {
		setAttrVal("Job_no_nur", Job_no_nur);
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
		return "Id_nqm_qcmt_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_QCMT_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmqcmtPsnDODesc.class);
	}
	
}