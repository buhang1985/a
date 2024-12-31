package iih.bl.pay.prepayrefund.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.prepayrefund.d.desc.BlPrepayPatRefundDODesc;
import java.math.BigDecimal;

/**
 * 预交金_强制退费记录 DO数据 
 * 
 */
public class BlPrepayPatRefundDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PAYPATREFUND= "Id_paypatrefund";
	public static final String ID_PAYPAT= "Id_paypat";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DT_PAY= "Dt_pay";
	public static final String ID_DEP_PAY= "Id_dep_pay";
	public static final String ID_EMP_PAY= "Id_emp_pay";
	public static final String ID_REASON= "Id_reason";
	public static final String SD_REASON= "Sd_reason";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_UDIDOCLIST= "Id_udidoclist";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_paypatrefund() {
		return ((String) getAttrVal("Id_paypatrefund"));
	}	
	public void setId_paypatrefund(String Id_paypatrefund) {
		setAttrVal("Id_paypatrefund", Id_paypatrefund);
	}
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
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
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}	
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	public String getId_dep_pay() {
		return ((String) getAttrVal("Id_dep_pay"));
	}	
	public void setId_dep_pay(String Id_dep_pay) {
		setAttrVal("Id_dep_pay", Id_dep_pay);
	}
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}	
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	public String getId_reason() {
		return ((String) getAttrVal("Id_reason"));
	}	
	public void setId_reason(String Id_reason) {
		setAttrVal("Id_reason", Id_reason);
	}
	public String getSd_reason() {
		return ((String) getAttrVal("Sd_reason"));
	}	
	public void setSd_reason(String Sd_reason) {
		setAttrVal("Sd_reason", Sd_reason);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	public String getId_udidoclist() {
		return ((String) getAttrVal("Id_udidoclist"));
	}	
	public void setId_udidoclist(String Id_udidoclist) {
		setAttrVal("Id_udidoclist", Id_udidoclist);
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
		return "Id_paypatrefund";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prepay_pat_refund";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrepayPatRefundDODesc.class);
	}
	
}