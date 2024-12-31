package iih.bl.pay.blpayspcl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.blpayspcl.d.desc.BlPayItmSpclDODesc;
import java.math.BigDecimal;

/**
 * 收付款_明细_专用款 DO数据 
 * 
 */
public class BlPayItmSpclDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PAYITMSPCL= "Id_payitmspcl";
	public static final String ID_PAYSPCL= "Id_payspcl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String ID_PM= "Id_pm";
	public static final String SD_PM= "Sd_pm";
	public static final String AMT= "Amt";
	public static final String ID_BANK= "Id_bank";
	public static final String BANKNO= "Bankno";
	public static final String PAYMODENODE= "Paymodenode";
	public static final String ID_PAYPAT= "Id_paypat";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PM_CODE= "Pm_code";
	public static final String PM_NAME= "Pm_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_payitmspcl() {
		return ((String) getAttrVal("Id_payitmspcl"));
	}	
	public void setId_payitmspcl(String Id_payitmspcl) {
		setAttrVal("Id_payitmspcl", Id_payitmspcl);
	}
	public String getId_payspcl() {
		return ((String) getAttrVal("Id_payspcl"));
	}	
	public void setId_payspcl(String Id_payspcl) {
		setAttrVal("Id_payspcl", Id_payspcl);
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
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}	
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}	
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
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
	public String getPm_code() {
		return ((String) getAttrVal("Pm_code"));
	}	
	public void setPm_code(String Pm_code) {
		setAttrVal("Pm_code", Pm_code);
	}
	public String getPm_name() {
		return ((String) getAttrVal("Pm_name"));
	}	
	public void setPm_name(String Pm_name) {
		setAttrVal("Pm_name", Pm_name);
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
		return "Id_payitmspcl";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_pay_itm_spcl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPayItmSpclDODesc.class);
	}
	
}