package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scapt.d.desc.AptOpOralDODesc;
import java.math.BigDecimal;

/**
 * 口腔门诊预约 DO数据 
 * 
 */
public class AptOpOralDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTOPORAL= "Id_aptoporal";
	public static final String ID_APT= "Id_apt";
	public static final String ID_APTOP= "Id_aptop";
	public static final String POSI_TEETH= "Posi_teeth";
	public static final String ID_PROC_ORAL= "Id_proc_oral";
	public static final String SD_PROC_ORAL= "Sd_proc_oral";
	public static final String NAME_PROC_ORAL= "Name_proc_oral";
	public static final String SVRSLOT= "Svrslot";
	public static final String NOTE= "Note";
	public static final String D_NEXT_APPT= "D_next_appt";
	public static final String NOTE_NEXT= "Note_next";
	public static final String ID_STATUSTAG= "Id_statustag";
	public static final String SD_STATUSTAG= "Sd_statustag";
	public static final String ID_EMP_LASTMDF= "Id_emp_lastmdf";
	public static final String DT_LASTMDF= "Dt_lastmdf";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptoporal() {
		return ((String) getAttrVal("Id_aptoporal"));
	}	
	public void setId_aptoporal(String Id_aptoporal) {
		setAttrVal("Id_aptoporal", Id_aptoporal);
	}
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public String getId_aptop() {
		return ((String) getAttrVal("Id_aptop"));
	}	
	public void setId_aptop(String Id_aptop) {
		setAttrVal("Id_aptop", Id_aptop);
	}
	public String getPosi_teeth() {
		return ((String) getAttrVal("Posi_teeth"));
	}	
	public void setPosi_teeth(String Posi_teeth) {
		setAttrVal("Posi_teeth", Posi_teeth);
	}
	public String getId_proc_oral() {
		return ((String) getAttrVal("Id_proc_oral"));
	}	
	public void setId_proc_oral(String Id_proc_oral) {
		setAttrVal("Id_proc_oral", Id_proc_oral);
	}
	public String getSd_proc_oral() {
		return ((String) getAttrVal("Sd_proc_oral"));
	}	
	public void setSd_proc_oral(String Sd_proc_oral) {
		setAttrVal("Sd_proc_oral", Sd_proc_oral);
	}
	public String getName_proc_oral() {
		return ((String) getAttrVal("Name_proc_oral"));
	}	
	public void setName_proc_oral(String Name_proc_oral) {
		setAttrVal("Name_proc_oral", Name_proc_oral);
	}
	public Integer getSvrslot() {
		return ((Integer) getAttrVal("Svrslot"));
	}	
	public void setSvrslot(Integer Svrslot) {
		setAttrVal("Svrslot", Svrslot);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public FDate getD_next_appt() {
		return ((FDate) getAttrVal("D_next_appt"));
	}	
	public void setD_next_appt(FDate D_next_appt) {
		setAttrVal("D_next_appt", D_next_appt);
	}
	public String getNote_next() {
		return ((String) getAttrVal("Note_next"));
	}	
	public void setNote_next(String Note_next) {
		setAttrVal("Note_next", Note_next);
	}
	public String getId_statustag() {
		return ((String) getAttrVal("Id_statustag"));
	}	
	public void setId_statustag(String Id_statustag) {
		setAttrVal("Id_statustag", Id_statustag);
	}
	public String getSd_statustag() {
		return ((String) getAttrVal("Sd_statustag"));
	}	
	public void setSd_statustag(String Sd_statustag) {
		setAttrVal("Sd_statustag", Sd_statustag);
	}
	public String getId_emp_lastmdf() {
		return ((String) getAttrVal("Id_emp_lastmdf"));
	}	
	public void setId_emp_lastmdf(String Id_emp_lastmdf) {
		setAttrVal("Id_emp_lastmdf", Id_emp_lastmdf);
	}
	public FDateTime getDt_lastmdf() {
		return ((FDateTime) getAttrVal("Dt_lastmdf"));
	}	
	public void setDt_lastmdf(FDateTime Dt_lastmdf) {
		setAttrVal("Dt_lastmdf", Dt_lastmdf);
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
		return "Id_aptoporal";
	}
	
	@Override
	public String getTableName() {	  
		return "SC_APT_OP_ORAL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AptOpOralDODesc.class);
	}
	
}