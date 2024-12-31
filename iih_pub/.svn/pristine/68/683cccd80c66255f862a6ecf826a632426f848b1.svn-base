package iih.en.pv.enfee.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.en.pv.enfee.d.desc.EnPeCmpyACCDODesc;
import java.math.BigDecimal;

/**
 * 团检账户 DO数据 
 * 
 */
public class EnPeCmpyACCDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECMPYACC= "Id_pecmpyacc";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PECMPY= "Id_pecmpy";
	public static final String ID_CUST_CMPY= "Id_cust_cmpy";
	public static final String AMT_CRED= "Amt_cred";
	public static final String AMT_PREPAY= "Amt_prepay";
	public static final String AMT_UNCG= "Amt_uncg";
	public static final String AMT_OWELIMIT= "Amt_owelimit";
	public static final String DT_BACKCG= "Dt_backcg";
	public static final String DT_BACKCGLASTACT= "Dt_backcglastact";
	public static final String FG_FREEZE= "Fg_freeze";
	public static final String AMT_HP= "Amt_hp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pecmpyacc() {
		return ((String) getAttrVal("Id_pecmpyacc"));
	}	
	public void setId_pecmpyacc(String Id_pecmpyacc) {
		setAttrVal("Id_pecmpyacc", Id_pecmpyacc);
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
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}	
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	public String getId_cust_cmpy() {
		return ((String) getAttrVal("Id_cust_cmpy"));
	}	
	public void setId_cust_cmpy(String Id_cust_cmpy) {
		setAttrVal("Id_cust_cmpy", Id_cust_cmpy);
	}
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}	
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}	
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}	
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	public FDouble getAmt_owelimit() {
		return ((FDouble) getAttrVal("Amt_owelimit"));
	}	
	public void setAmt_owelimit(FDouble Amt_owelimit) {
		setAttrVal("Amt_owelimit", Amt_owelimit);
	}
	public FDateTime getDt_backcg() {
		return ((FDateTime) getAttrVal("Dt_backcg"));
	}	
	public void setDt_backcg(FDateTime Dt_backcg) {
		setAttrVal("Dt_backcg", Dt_backcg);
	}
	public FDateTime getDt_backcglastact() {
		return ((FDateTime) getAttrVal("Dt_backcglastact"));
	}	
	public void setDt_backcglastact(FDateTime Dt_backcglastact) {
		setAttrVal("Dt_backcglastact", Dt_backcglastact);
	}
	public FBoolean getFg_freeze() {
		return ((FBoolean) getAttrVal("Fg_freeze"));
	}	
	public void setFg_freeze(FBoolean Fg_freeze) {
		setAttrVal("Fg_freeze", Fg_freeze);
	}
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
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
		return "Id_pecmpyacc";
	}
	
	@Override
	public String getTableName() {	  
		return "en_pe_cmpy_acc";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EnPeCmpyACCDODesc.class);
	}
	
}