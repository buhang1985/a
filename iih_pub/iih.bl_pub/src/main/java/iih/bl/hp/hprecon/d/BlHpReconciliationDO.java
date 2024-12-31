package iih.bl.hp.hprecon.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hprecon.d.desc.BlHpReconciliationDODesc;
import java.math.BigDecimal;

/**
 * 医保对账 DO数据 
 * 
 */
public class BlHpReconciliationDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RECON= "Id_recon";
	public static final String HOSCODE= "Hoscode";
	public static final String REGNO= "Regno";
	public static final String RCPT_NO= "Rcpt_no";
	public static final String ID_MEDKIND= "Id_medkind";
	public static final String ID_HPPATCA= "Id_hppatca";
	public static final String PERSONCODE= "Personcode";
	public static final String DT_ST= "Dt_st";
	public static final String SETTLE_TAG= "Settle_tag";
	public static final String AMT_ALL= "Amt_all";
	public static final String AMT_PSN= "Amt_psn";
	public static final String AMT_CASH= "Amt_cash";
	public static final String AMT_HP= "Amt_hp";
	public static final String AMT_SERIOUSILL= "Amt_seriousill";
	public static final String AMT_CIVILSERVICE= "Amt_civilservice";
	public static final String ID_EMP_OPR= "Id_emp_opr";
	public static final String DT_TRANSACT= "Dt_transact";
	public static final String BUSINESS_CODE= "Business_code";
	public static final String CODE_MEDKIND= "Code_medkind";
	public static final String NAME_MEDKIND= "Name_medkind";
	public static final String CODE_HPPATCA= "Code_hppatca";
	public static final String NAME_HPPATCA= "Name_hppatca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_recon() {
		return ((String) getAttrVal("Id_recon"));
	}	
	public void setId_recon(String Id_recon) {
		setAttrVal("Id_recon", Id_recon);
	}
	public String getHoscode() {
		return ((String) getAttrVal("Hoscode"));
	}	
	public void setHoscode(String Hoscode) {
		setAttrVal("Hoscode", Hoscode);
	}
	public String getRegno() {
		return ((String) getAttrVal("Regno"));
	}	
	public void setRegno(String Regno) {
		setAttrVal("Regno", Regno);
	}
	public String getRcpt_no() {
		return ((String) getAttrVal("Rcpt_no"));
	}	
	public void setRcpt_no(String Rcpt_no) {
		setAttrVal("Rcpt_no", Rcpt_no);
	}
	public String getId_medkind() {
		return ((String) getAttrVal("Id_medkind"));
	}	
	public void setId_medkind(String Id_medkind) {
		setAttrVal("Id_medkind", Id_medkind);
	}
	public String getId_hppatca() {
		return ((String) getAttrVal("Id_hppatca"));
	}	
	public void setId_hppatca(String Id_hppatca) {
		setAttrVal("Id_hppatca", Id_hppatca);
	}
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}	
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	public String getSettle_tag() {
		return ((String) getAttrVal("Settle_tag"));
	}	
	public void setSettle_tag(String Settle_tag) {
		setAttrVal("Settle_tag", Settle_tag);
	}
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}	
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}	
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}	
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	public FDouble getAmt_seriousill() {
		return ((FDouble) getAttrVal("Amt_seriousill"));
	}	
	public void setAmt_seriousill(FDouble Amt_seriousill) {
		setAttrVal("Amt_seriousill", Amt_seriousill);
	}
	public FDouble getAmt_civilservice() {
		return ((FDouble) getAttrVal("Amt_civilservice"));
	}	
	public void setAmt_civilservice(FDouble Amt_civilservice) {
		setAttrVal("Amt_civilservice", Amt_civilservice);
	}
	public String getId_emp_opr() {
		return ((String) getAttrVal("Id_emp_opr"));
	}	
	public void setId_emp_opr(String Id_emp_opr) {
		setAttrVal("Id_emp_opr", Id_emp_opr);
	}
	public FDateTime getDt_transact() {
		return ((FDateTime) getAttrVal("Dt_transact"));
	}	
	public void setDt_transact(FDateTime Dt_transact) {
		setAttrVal("Dt_transact", Dt_transact);
	}
	public String getBusiness_code() {
		return ((String) getAttrVal("Business_code"));
	}	
	public void setBusiness_code(String Business_code) {
		setAttrVal("Business_code", Business_code);
	}
	public String getCode_medkind() {
		return ((String) getAttrVal("Code_medkind"));
	}	
	public void setCode_medkind(String Code_medkind) {
		setAttrVal("Code_medkind", Code_medkind);
	}
	public String getName_medkind() {
		return ((String) getAttrVal("Name_medkind"));
	}	
	public void setName_medkind(String Name_medkind) {
		setAttrVal("Name_medkind", Name_medkind);
	}
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}	
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}	
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
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
		return "Id_recon";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_recon";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpReconciliationDODesc.class);
	}
	
}