package iih.bl.st.blauditip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.st.blauditip.d.desc.BlAuditLogIpDesc;
import java.math.BigDecimal;

/**
 * 费用审核日志_住院 DO数据 
 * 
 */
public class BlAuditLogIp extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AUDITLOGIP= "Id_auditlogip";
	public static final String ID_AUDITIP= "Id_auditip";
	public static final String EU_ACT= "Eu_act";
	public static final String DT_ACT= "Dt_act";
	public static final String ID_EMP_ACT= "Id_emp_act";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_auditlogip() {
		return ((String) getAttrVal("Id_auditlogip"));
	}	
	public void setId_auditlogip(String Id_auditlogip) {
		setAttrVal("Id_auditlogip", Id_auditlogip);
	}
	public String getId_auditip() {
		return ((String) getAttrVal("Id_auditip"));
	}	
	public void setId_auditip(String Id_auditip) {
		setAttrVal("Id_auditip", Id_auditip);
	}
	public String getEu_act() {
		return ((String) getAttrVal("Eu_act"));
	}	
	public void setEu_act(String Eu_act) {
		setAttrVal("Eu_act", Eu_act);
	}
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	public String getId_emp_act() {
		return ((String) getAttrVal("Id_emp_act"));
	}	
	public void setId_emp_act(String Id_emp_act) {
		setAttrVal("Id_emp_act", Id_emp_act);
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
		return "Id_auditlogip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_audit_log_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlAuditLogIpDesc.class);
	}
	
}