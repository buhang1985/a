package iih.pmp.pay.billcheckrst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.billcheckrst.d.desc.BillCheckRstDODesc;
import java.math.BigDecimal;

/**
 * 对账结果 DO数据 
 * 
 */
public class BillCheckRstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BILLCHECK= "Id_billcheck";
	public static final String BILL_TYPE= "Bill_type";
	public static final String SD_CHL= "Sd_chl";
	public static final String ID_CHL= "Id_chl";
	public static final String FEE_PAID= "Fee_paid";
	public static final String FEE_REFUND= "Fee_refund";
	public static final String TOTAL_FEE= "Total_fee";
	public static final String DT_BILL= "Dt_bill";
	public static final String CHL_FEE_PAID= "Chl_fee_paid";
	public static final String CHL_FEE_REFUND= "Chl_fee_refund";
	public static final String CHL_TOTAL_FEE= "Chl_total_fee";
	public static final String NUM_PAID= "Num_paid";
	public static final String NUM_REFUND= "Num_refund";
	public static final String CHL_NUM_PAID= "Chl_num_paid";
	public static final String CHL_NUM_REFUND= "Chl_num_refund";
	public static final String NAME_CHL= "Name_chl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_billcheck() {
		return ((String) getAttrVal("Id_billcheck"));
	}	
	public void setId_billcheck(String Id_billcheck) {
		setAttrVal("Id_billcheck", Id_billcheck);
	}
	public String getBill_type() {
		return ((String) getAttrVal("Bill_type"));
	}	
	public void setBill_type(String Bill_type) {
		setAttrVal("Bill_type", Bill_type);
	}
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}	
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}	
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	public FDouble getFee_paid() {
		return ((FDouble) getAttrVal("Fee_paid"));
	}	
	public void setFee_paid(FDouble Fee_paid) {
		setAttrVal("Fee_paid", Fee_paid);
	}
	public FDouble getFee_refund() {
		return ((FDouble) getAttrVal("Fee_refund"));
	}	
	public void setFee_refund(FDouble Fee_refund) {
		setAttrVal("Fee_refund", Fee_refund);
	}
	public FDouble getTotal_fee() {
		return ((FDouble) getAttrVal("Total_fee"));
	}	
	public void setTotal_fee(FDouble Total_fee) {
		setAttrVal("Total_fee", Total_fee);
	}
	public FDate getDt_bill() {
		return ((FDate) getAttrVal("Dt_bill"));
	}	
	public void setDt_bill(FDate Dt_bill) {
		setAttrVal("Dt_bill", Dt_bill);
	}
	public FDouble getChl_fee_paid() {
		return ((FDouble) getAttrVal("Chl_fee_paid"));
	}	
	public void setChl_fee_paid(FDouble Chl_fee_paid) {
		setAttrVal("Chl_fee_paid", Chl_fee_paid);
	}
	public FDouble getChl_fee_refund() {
		return ((FDouble) getAttrVal("Chl_fee_refund"));
	}	
	public void setChl_fee_refund(FDouble Chl_fee_refund) {
		setAttrVal("Chl_fee_refund", Chl_fee_refund);
	}
	public FDouble getChl_total_fee() {
		return ((FDouble) getAttrVal("Chl_total_fee"));
	}	
	public void setChl_total_fee(FDouble Chl_total_fee) {
		setAttrVal("Chl_total_fee", Chl_total_fee);
	}
	public FDouble getNum_paid() {
		return ((FDouble) getAttrVal("Num_paid"));
	}	
	public void setNum_paid(FDouble Num_paid) {
		setAttrVal("Num_paid", Num_paid);
	}
	public FDouble getNum_refund() {
		return ((FDouble) getAttrVal("Num_refund"));
	}	
	public void setNum_refund(FDouble Num_refund) {
		setAttrVal("Num_refund", Num_refund);
	}
	public FDouble getChl_num_paid() {
		return ((FDouble) getAttrVal("Chl_num_paid"));
	}	
	public void setChl_num_paid(FDouble Chl_num_paid) {
		setAttrVal("Chl_num_paid", Chl_num_paid);
	}
	public FDouble getChl_num_refund() {
		return ((FDouble) getAttrVal("Chl_num_refund"));
	}	
	public void setChl_num_refund(FDouble Chl_num_refund) {
		setAttrVal("Chl_num_refund", Chl_num_refund);
	}
	public String getName_chl() {
		return ((String) getAttrVal("Name_chl"));
	}	
	public void setName_chl(String Name_chl) {
		setAttrVal("Name_chl", Name_chl);
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
		return "Id_billcheck";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_billcheck";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BillCheckRstDODesc.class);
	}
	
}