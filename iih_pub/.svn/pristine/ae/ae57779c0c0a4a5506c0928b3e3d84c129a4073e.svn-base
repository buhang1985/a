package iih.bl.hp.hpcheckaccount.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hpcheckaccount.d.desc.BlHpCheckAccountDODesc;
import java.math.BigDecimal;

/**
 * 医保统计查询对账 DO数据 
 * 
 */
public class BlHpCheckAccountDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPCHECK= "Id_hpcheck";
	public static final String CODE_BUSINESS= "Code_business";
	public static final String AMT_SUM= "Amt_sum";
	public static final String AMT_PSNACC= "Amt_psnacc";
	public static final String AMT_CASH= "Amt_cash";
	public static final String AMT_HP= "Amt_hp";
	public static final String AMT_SALVAGE= "Amt_salvage";
	public static final String AMT_CIVILSERVICE= "Amt_civilservice";
	public static final String AMT_ENTERPRISE= "Amt_enterprise";
	public static final String AMT_OTHER= "Amt_other";
	public static final String DT_CHECK= "Dt_check";
	public static final String FG_BALANCE= "Fg_balance";
	public static final String ID_EMP= "Id_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpcheck() {
		return ((String) getAttrVal("Id_hpcheck"));
	}	
	public void setId_hpcheck(String Id_hpcheck) {
		setAttrVal("Id_hpcheck", Id_hpcheck);
	}
	public String getCode_business() {
		return ((String) getAttrVal("Code_business"));
	}	
	public void setCode_business(String Code_business) {
		setAttrVal("Code_business", Code_business);
	}
	public FDouble getAmt_sum() {
		return ((FDouble) getAttrVal("Amt_sum"));
	}	
	public void setAmt_sum(FDouble Amt_sum) {
		setAttrVal("Amt_sum", Amt_sum);
	}
	public FDouble getAmt_psnacc() {
		return ((FDouble) getAttrVal("Amt_psnacc"));
	}	
	public void setAmt_psnacc(FDouble Amt_psnacc) {
		setAttrVal("Amt_psnacc", Amt_psnacc);
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
	public FDouble getAmt_salvage() {
		return ((FDouble) getAttrVal("Amt_salvage"));
	}	
	public void setAmt_salvage(FDouble Amt_salvage) {
		setAttrVal("Amt_salvage", Amt_salvage);
	}
	public FDouble getAmt_civilservice() {
		return ((FDouble) getAttrVal("Amt_civilservice"));
	}	
	public void setAmt_civilservice(FDouble Amt_civilservice) {
		setAttrVal("Amt_civilservice", Amt_civilservice);
	}
	public FDouble getAmt_enterprise() {
		return ((FDouble) getAttrVal("Amt_enterprise"));
	}	
	public void setAmt_enterprise(FDouble Amt_enterprise) {
		setAttrVal("Amt_enterprise", Amt_enterprise);
	}
	public FDouble getAmt_other() {
		return ((FDouble) getAttrVal("Amt_other"));
	}	
	public void setAmt_other(FDouble Amt_other) {
		setAttrVal("Amt_other", Amt_other);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	public FBoolean getFg_balance() {
		return ((FBoolean) getAttrVal("Fg_balance"));
	}	
	public void setFg_balance(FBoolean Fg_balance) {
		setAttrVal("Fg_balance", Fg_balance);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
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
		return "Id_hpcheck";
	}
	
	@Override
	public String getTableName() {	  
		return "BL_HP_CHECK_ACCOUNT_AH";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpCheckAccountDODesc.class);
	}
	
}