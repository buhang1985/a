package iih.nm.nhr.nmnurspcev.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurspcev.d.desc.NmSpcEvDODesc;
import java.math.BigDecimal;

/**
 * 特殊事件 DO数据 
 * 
 */
public class NmSpcEvDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SPC_EV= "Id_spc_ev";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_NURTP= "Id_nurtp";
	public static final String SD_NURTP= "Sd_nurtp";
	public static final String ID_STU_ORG= "Id_stu_org";
	public static final String ID_STU_ORG_BAT= "Id_stu_org_bat";
	public static final String DT_HAP= "Dt_hap";
	public static final String REASON_HAP= "Reason_hap";
	public static final String DES= "Des";
	public static final String ID_REG= "Id_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String APPROVALOP= "Approvalop";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_TASK= "Id_task";
	public static final String NAME_EMP_AUDIT= "Name_emp_audit";
	public static final String DT_AUDIT= "Dt_audit";
	public static final String APCOMMENTS= "Apcomments";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_NURTP= "Name_nurtp";
	public static final String NAME_STU_ORG= "Name_stu_org";
	public static final String NAME_STU_ORG_BAT= "Name_stu_org_bat";
	public static final String NAME_REG= "Name_reg";
	public static final String NAME_STATUS= "Name_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_spc_ev() {
		return ((String) getAttrVal("Id_spc_ev"));
	}	
	public void setId_spc_ev(String Id_spc_ev) {
		setAttrVal("Id_spc_ev", Id_spc_ev);
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
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_nurtp() {
		return ((String) getAttrVal("Id_nurtp"));
	}	
	public void setId_nurtp(String Id_nurtp) {
		setAttrVal("Id_nurtp", Id_nurtp);
	}
	public String getSd_nurtp() {
		return ((String) getAttrVal("Sd_nurtp"));
	}	
	public void setSd_nurtp(String Sd_nurtp) {
		setAttrVal("Sd_nurtp", Sd_nurtp);
	}
	public String getId_stu_org() {
		return ((String) getAttrVal("Id_stu_org"));
	}	
	public void setId_stu_org(String Id_stu_org) {
		setAttrVal("Id_stu_org", Id_stu_org);
	}
	public String getId_stu_org_bat() {
		return ((String) getAttrVal("Id_stu_org_bat"));
	}	
	public void setId_stu_org_bat(String Id_stu_org_bat) {
		setAttrVal("Id_stu_org_bat", Id_stu_org_bat);
	}
	public FDateTime getDt_hap() {
		return ((FDateTime) getAttrVal("Dt_hap"));
	}	
	public void setDt_hap(FDateTime Dt_hap) {
		setAttrVal("Dt_hap", Dt_hap);
	}
	public String getReason_hap() {
		return ((String) getAttrVal("Reason_hap"));
	}	
	public void setReason_hap(String Reason_hap) {
		setAttrVal("Reason_hap", Reason_hap);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getApprovalop() {
		return ((String) getAttrVal("Approvalop"));
	}	
	public void setApprovalop(String Approvalop) {
		setAttrVal("Approvalop", Approvalop);
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
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	public String getName_emp_audit() {
		return ((String) getAttrVal("Name_emp_audit"));
	}	
	public void setName_emp_audit(String Name_emp_audit) {
		setAttrVal("Name_emp_audit", Name_emp_audit);
	}
	public FDateTime getDt_audit() {
		return ((FDateTime) getAttrVal("Dt_audit"));
	}	
	public void setDt_audit(FDateTime Dt_audit) {
		setAttrVal("Dt_audit", Dt_audit);
	}
	public String getApcomments() {
		return ((String) getAttrVal("Apcomments"));
	}	
	public void setApcomments(String Apcomments) {
		setAttrVal("Apcomments", Apcomments);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_nurtp() {
		return ((String) getAttrVal("Name_nurtp"));
	}	
	public void setName_nurtp(String Name_nurtp) {
		setAttrVal("Name_nurtp", Name_nurtp);
	}
	public String getName_stu_org() {
		return ((String) getAttrVal("Name_stu_org"));
	}	
	public void setName_stu_org(String Name_stu_org) {
		setAttrVal("Name_stu_org", Name_stu_org);
	}
	public String getName_stu_org_bat() {
		return ((String) getAttrVal("Name_stu_org_bat"));
	}	
	public void setName_stu_org_bat(String Name_stu_org_bat) {
		setAttrVal("Name_stu_org_bat", Name_stu_org_bat);
	}
	public String getName_reg() {
		return ((String) getAttrVal("Name_reg"));
	}	
	public void setName_reg(String Name_reg) {
		setAttrVal("Name_reg", Name_reg);
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
		return "Id_spc_ev";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_SPC_EV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmSpcEvDODesc.class);
	}
	
}