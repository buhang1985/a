package iih.en.pv.entplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.entplan.d.desc.EntCpDODesc;
import java.math.BigDecimal;

/**
 * 患者就诊临床路径 DO数据 
 * 
 */
public class EntCpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTCP= "Id_entcp";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_CP= "Id_cp";
	public static final String CPNAME= "Cpname";
	public static final String DT_ENTER= "Dt_enter";
	public static final String DT_EXIT= "Dt_exit";
	public static final String SD_HALT_REASON= "Sd_halt_reason";
	public static final String REASON_DESC= "Reason_desc";
	public static final String SD_STATUS= "Sd_status";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entcp() {
		return ((String) getAttrVal("Id_entcp"));
	}	
	public void setId_entcp(String Id_entcp) {
		setAttrVal("Id_entcp", Id_entcp);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	public String getCpname() {
		return ((String) getAttrVal("Cpname"));
	}	
	public void setCpname(String Cpname) {
		setAttrVal("Cpname", Cpname);
	}
	public FDateTime getDt_enter() {
		return ((FDateTime) getAttrVal("Dt_enter"));
	}	
	public void setDt_enter(FDateTime Dt_enter) {
		setAttrVal("Dt_enter", Dt_enter);
	}
	public FDateTime getDt_exit() {
		return ((FDateTime) getAttrVal("Dt_exit"));
	}	
	public void setDt_exit(FDateTime Dt_exit) {
		setAttrVal("Dt_exit", Dt_exit);
	}
	public String getSd_halt_reason() {
		return ((String) getAttrVal("Sd_halt_reason"));
	}	
	public void setSd_halt_reason(String Sd_halt_reason) {
		setAttrVal("Sd_halt_reason", Sd_halt_reason);
	}
	public String getReason_desc() {
		return ((String) getAttrVal("Reason_desc"));
	}	
	public void setReason_desc(String Reason_desc) {
		setAttrVal("Reason_desc", Reason_desc);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
		return "Id_entcp";
	}
	
	@Override
	public String getTableName() {	  
		return "en_ent_cp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EntCpDODesc.class);
	}
	
}