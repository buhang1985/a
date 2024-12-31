package iih.ci.rcm.conpastreport.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.conpastreport.d.desc.ConPastReportDODesc;
import java.math.BigDecimal;

/**
 * 既往已报 DO数据 
 * 
 */
public class ConPastReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MR_CON_PA= "Id_mr_con_pa";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_EMP_SUBMIT= "Id_emp_submit";
	public static final String DT_SUBMIT= "Dt_submit";
	public static final String ID_EMP_PASS= "Id_emp_pass";
	public static final String DT_PASS= "Dt_pass";
	public static final String ID_EMP_REJECT= "Id_emp_reject";
	public static final String DT_REJECT= "Dt_reject";
	public static final String REASON_REJECT= "Reason_reject";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_GRP= "Code_grp";
	public static final String NAME_GRP= "Name_grp";
	public static final String CODE_ORG= "Code_org";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_SUBMIT= "Name_submit";
	public static final String CODE_SUBMIT= "Code_submit";
	public static final String NAME_PASS= "Name_pass";
	public static final String CODE_PASS= "Code_pass";
	public static final String NAME_REJECT= "Name_reject";
	public static final String CODE_REJECT= "Code_reject";
	public static final String CODE_STATUS= "Code_status";
	public static final String NAME_STATUS= "Name_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mr_con_pa() {
		return ((String) getAttrVal("Id_mr_con_pa"));
	}	
	public void setId_mr_con_pa(String Id_mr_con_pa) {
		setAttrVal("Id_mr_con_pa", Id_mr_con_pa);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_emp_submit() {
		return ((String) getAttrVal("Id_emp_submit"));
	}	
	public void setId_emp_submit(String Id_emp_submit) {
		setAttrVal("Id_emp_submit", Id_emp_submit);
	}
	public FDateTime getDt_submit() {
		return ((FDateTime) getAttrVal("Dt_submit"));
	}	
	public void setDt_submit(FDateTime Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
	public String getId_emp_pass() {
		return ((String) getAttrVal("Id_emp_pass"));
	}	
	public void setId_emp_pass(String Id_emp_pass) {
		setAttrVal("Id_emp_pass", Id_emp_pass);
	}
	public FDateTime getDt_pass() {
		return ((FDateTime) getAttrVal("Dt_pass"));
	}	
	public void setDt_pass(FDateTime Dt_pass) {
		setAttrVal("Dt_pass", Dt_pass);
	}
	public String getId_emp_reject() {
		return ((String) getAttrVal("Id_emp_reject"));
	}	
	public void setId_emp_reject(String Id_emp_reject) {
		setAttrVal("Id_emp_reject", Id_emp_reject);
	}
	public FDateTime getDt_reject() {
		return ((FDateTime) getAttrVal("Dt_reject"));
	}	
	public void setDt_reject(FDateTime Dt_reject) {
		setAttrVal("Dt_reject", Dt_reject);
	}
	public String getReason_reject() {
		return ((String) getAttrVal("Reason_reject"));
	}	
	public void setReason_reject(String Reason_reject) {
		setAttrVal("Reason_reject", Reason_reject);
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
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_submit() {
		return ((String) getAttrVal("Name_submit"));
	}	
	public void setName_submit(String Name_submit) {
		setAttrVal("Name_submit", Name_submit);
	}
	public String getCode_submit() {
		return ((String) getAttrVal("Code_submit"));
	}	
	public void setCode_submit(String Code_submit) {
		setAttrVal("Code_submit", Code_submit);
	}
	public String getName_pass() {
		return ((String) getAttrVal("Name_pass"));
	}	
	public void setName_pass(String Name_pass) {
		setAttrVal("Name_pass", Name_pass);
	}
	public String getCode_pass() {
		return ((String) getAttrVal("Code_pass"));
	}	
	public void setCode_pass(String Code_pass) {
		setAttrVal("Code_pass", Code_pass);
	}
	public String getName_reject() {
		return ((String) getAttrVal("Name_reject"));
	}	
	public void setName_reject(String Name_reject) {
		setAttrVal("Name_reject", Name_reject);
	}
	public String getCode_reject() {
		return ((String) getAttrVal("Code_reject"));
	}	
	public void setCode_reject(String Code_reject) {
		setAttrVal("Code_reject", Code_reject);
	}
	public String getCode_status() {
		return ((String) getAttrVal("Code_status"));
	}	
	public void setCode_status(String Code_status) {
		setAttrVal("Code_status", Code_status);
	}
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
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
		return "Id_mr_con_pa";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_PA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ConPastReportDODesc.class);
	}
	
}