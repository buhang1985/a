package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scapt.d.desc.ScAptDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约 DO数据 
 * 
 */
public class ScAptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APT= "Id_apt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_SCTP= "Sd_sctp";
	public static final String ID_SCTP= "Id_sctp";
	public static final String ID_SCCA= "Id_scca";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_SCH= "Id_sch";
	public static final String ID_DATESLOT= "Id_dateslot";
	public static final String ID_SCRES= "Id_scres";
	public static final String ID_SCSRV= "Id_scsrv";
	public static final String ID_TICK= "Id_tick";
	public static final String ID_TICKS= "Id_ticks";
	public static final String QUENO= "Queno";
	public static final String DT_APPT= "Dt_appt";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_SCCHL= "Id_scchl";
	public static final String ID_ORG_APPT= "Id_org_appt";
	public static final String ID_DEP_APPT= "Id_dep_appt";
	public static final String ID_EMP_APPT= "Id_emp_appt";
	public static final String SD_STATUS= "Sd_status";
	public static final String ID_STATUS= "Id_status";
	public static final String FG_PAYMENT= "Fg_payment";
	public static final String FG_NOTICE= "Fg_notice";
	public static final String FG_CANC= "Fg_canc";
	public static final String DT_CANC= "Dt_canc";
	public static final String ID_EMP_CANC= "Id_emp_canc";
	public static final String NOTE_CANC= "Note_canc";
	public static final String FG_CANC_NOTICE= "Fg_canc_notice";
	public static final String FG_BILL= "Fg_bill";
	public static final String ID_SCAPT_CANCTO= "Id_scapt_cancto";
	public static final String SUGEST_EXMINT= "Sugest_exmint";
	public static final String EU_ADD= "Eu_add";
	public static final String CODE_SCCHL= "Code_scchl";
	public static final String NAME_SCCHL= "Name_scchl";
	public static final String CODE_EMP_APPT= "Code_emp_appt";
	public static final String NAME_EMP_APPT= "Name_emp_appt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
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
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}	
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
	}
	public String getId_sctp() {
		return ((String) getAttrVal("Id_sctp"));
	}	
	public void setId_sctp(String Id_sctp) {
		setAttrVal("Id_sctp", Id_sctp);
	}
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	public String getId_dateslot() {
		return ((String) getAttrVal("Id_dateslot"));
	}	
	public void setId_dateslot(String Id_dateslot) {
		setAttrVal("Id_dateslot", Id_dateslot);
	}
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}	
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}	
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}	
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}	
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
	}
	public Integer getQueno() {
		return ((Integer) getAttrVal("Queno"));
	}	
	public void setQueno(Integer Queno) {
		setAttrVal("Queno", Queno);
	}
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}	
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_scchl() {
		return ((String) getAttrVal("Id_scchl"));
	}	
	public void setId_scchl(String Id_scchl) {
		setAttrVal("Id_scchl", Id_scchl);
	}
	public String getId_org_appt() {
		return ((String) getAttrVal("Id_org_appt"));
	}	
	public void setId_org_appt(String Id_org_appt) {
		setAttrVal("Id_org_appt", Id_org_appt);
	}
	public String getId_dep_appt() {
		return ((String) getAttrVal("Id_dep_appt"));
	}	
	public void setId_dep_appt(String Id_dep_appt) {
		setAttrVal("Id_dep_appt", Id_dep_appt);
	}
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}	
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public FBoolean getFg_payment() {
		return ((FBoolean) getAttrVal("Fg_payment"));
	}	
	public void setFg_payment(FBoolean Fg_payment) {
		setAttrVal("Fg_payment", Fg_payment);
	}
	public FBoolean getFg_notice() {
		return ((FBoolean) getAttrVal("Fg_notice"));
	}	
	public void setFg_notice(FBoolean Fg_notice) {
		setAttrVal("Fg_notice", Fg_notice);
	}
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	public String getNote_canc() {
		return ((String) getAttrVal("Note_canc"));
	}	
	public void setNote_canc(String Note_canc) {
		setAttrVal("Note_canc", Note_canc);
	}
	public FBoolean getFg_canc_notice() {
		return ((FBoolean) getAttrVal("Fg_canc_notice"));
	}	
	public void setFg_canc_notice(FBoolean Fg_canc_notice) {
		setAttrVal("Fg_canc_notice", Fg_canc_notice);
	}
	public FBoolean getFg_bill() {
		return ((FBoolean) getAttrVal("Fg_bill"));
	}	
	public void setFg_bill(FBoolean Fg_bill) {
		setAttrVal("Fg_bill", Fg_bill);
	}
	public String getId_scapt_cancto() {
		return ((String) getAttrVal("Id_scapt_cancto"));
	}	
	public void setId_scapt_cancto(String Id_scapt_cancto) {
		setAttrVal("Id_scapt_cancto", Id_scapt_cancto);
	}
	public Integer getSugest_exmint() {
		return ((Integer) getAttrVal("Sugest_exmint"));
	}	
	public void setSugest_exmint(Integer Sugest_exmint) {
		setAttrVal("Sugest_exmint", Sugest_exmint);
	}
	public Integer getEu_add() {
		return ((Integer) getAttrVal("Eu_add"));
	}	
	public void setEu_add(Integer Eu_add) {
		setAttrVal("Eu_add", Eu_add);
	}
	public String getCode_scchl() {
		return ((String) getAttrVal("Code_scchl"));
	}	
	public void setCode_scchl(String Code_scchl) {
		setAttrVal("Code_scchl", Code_scchl);
	}
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}	
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	public String getCode_emp_appt() {
		return ((String) getAttrVal("Code_emp_appt"));
	}	
	public void setCode_emp_appt(String Code_emp_appt) {
		setAttrVal("Code_emp_appt", Code_emp_appt);
	}
	public String getName_emp_appt() {
		return ((String) getAttrVal("Name_emp_appt"));
	}	
	public void setName_emp_appt(String Name_emp_appt) {
		setAttrVal("Name_emp_appt", Name_emp_appt);
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
		return "Id_apt";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptDODesc.class);
	}
	
}