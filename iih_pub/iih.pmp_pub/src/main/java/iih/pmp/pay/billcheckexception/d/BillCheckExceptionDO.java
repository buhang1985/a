package iih.pmp.pay.billcheckexception.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.billcheckexception.d.desc.BillCheckExceptionDODesc;
import java.math.BigDecimal;

/**
 * 对账异常 DO数据 
 * 
 */
public class BillCheckExceptionDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BILLCHECK_EXCEPTION= "Id_billcheck_exception";
	public static final String DT_REQ= "Dt_req";
	public static final String ID_TRADE= "Id_trade";
	public static final String ID_ORD= "Id_ord";
	public static final String ID_BILLITEM= "Id_billitem";
	public static final String CHECKRESULT= "Checkresult";
	public static final String ORD_NO= "Ord_no";
	public static final String TRADE_NO= "Trade_no";
	public static final String TRADE_TYPE= "Trade_type";
	public static final String IS_AMAOUT_CKECKED= "Is_amaout_ckecked";
	public static final String IS_STATUS_CHECKED= "Is_status_checked";
	public static final String FAILED_TABLE= "Failed_table";
	public static final String REFUND_TRADE_NO= "Refund_trade_no";
	public static final String ID_CHL= "Id_chl";
	public static final String SD_CHL= "Sd_chl";
	public static final String TRADETIME= "Tradetime";
	public static final String MCHNO= "Mchno";
	public static final String BILL_TYPE= "Bill_type";
	public static final String BANKTRADENO= "Banktradeno";
	public static final String CHL_NAME= "Chl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_billcheck_exception() {
		return ((String) getAttrVal("Id_billcheck_exception"));
	}	
	public void setId_billcheck_exception(String Id_billcheck_exception) {
		setAttrVal("Id_billcheck_exception", Id_billcheck_exception);
	}
	public FDateTime getDt_req() {
		return ((FDateTime) getAttrVal("Dt_req"));
	}	
	public void setDt_req(FDateTime Dt_req) {
		setAttrVal("Dt_req", Dt_req);
	}
	public String getId_trade() {
		return ((String) getAttrVal("Id_trade"));
	}	
	public void setId_trade(String Id_trade) {
		setAttrVal("Id_trade", Id_trade);
	}
	public String getId_ord() {
		return ((String) getAttrVal("Id_ord"));
	}	
	public void setId_ord(String Id_ord) {
		setAttrVal("Id_ord", Id_ord);
	}
	public String getId_billitem() {
		return ((String) getAttrVal("Id_billitem"));
	}	
	public void setId_billitem(String Id_billitem) {
		setAttrVal("Id_billitem", Id_billitem);
	}
	public Integer getCheckresult() {
		return ((Integer) getAttrVal("Checkresult"));
	}	
	public void setCheckresult(Integer Checkresult) {
		setAttrVal("Checkresult", Checkresult);
	}
	public String getOrd_no() {
		return ((String) getAttrVal("Ord_no"));
	}	
	public void setOrd_no(String Ord_no) {
		setAttrVal("Ord_no", Ord_no);
	}
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}	
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	public Integer getTrade_type() {
		return ((Integer) getAttrVal("Trade_type"));
	}	
	public void setTrade_type(Integer Trade_type) {
		setAttrVal("Trade_type", Trade_type);
	}
	public FBoolean getIs_amaout_ckecked() {
		return ((FBoolean) getAttrVal("Is_amaout_ckecked"));
	}	
	public void setIs_amaout_ckecked(FBoolean Is_amaout_ckecked) {
		setAttrVal("Is_amaout_ckecked", Is_amaout_ckecked);
	}
	public FBoolean getIs_status_checked() {
		return ((FBoolean) getAttrVal("Is_status_checked"));
	}	
	public void setIs_status_checked(FBoolean Is_status_checked) {
		setAttrVal("Is_status_checked", Is_status_checked);
	}
	public String getFailed_table() {
		return ((String) getAttrVal("Failed_table"));
	}	
	public void setFailed_table(String Failed_table) {
		setAttrVal("Failed_table", Failed_table);
	}
	public String getRefund_trade_no() {
		return ((String) getAttrVal("Refund_trade_no"));
	}	
	public void setRefund_trade_no(String Refund_trade_no) {
		setAttrVal("Refund_trade_no", Refund_trade_no);
	}
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}	
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}	
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	public FDateTime getTradetime() {
		return ((FDateTime) getAttrVal("Tradetime"));
	}	
	public void setTradetime(FDateTime Tradetime) {
		setAttrVal("Tradetime", Tradetime);
	}
	public String getMchno() {
		return ((String) getAttrVal("Mchno"));
	}	
	public void setMchno(String Mchno) {
		setAttrVal("Mchno", Mchno);
	}
	public String getBill_type() {
		return ((String) getAttrVal("Bill_type"));
	}	
	public void setBill_type(String Bill_type) {
		setAttrVal("Bill_type", Bill_type);
	}
	public String getBanktradeno() {
		return ((String) getAttrVal("Banktradeno"));
	}	
	public void setBanktradeno(String Banktradeno) {
		setAttrVal("Banktradeno", Banktradeno);
	}
	public String getChl_name() {
		return ((String) getAttrVal("Chl_name"));
	}	
	public void setChl_name(String Chl_name) {
		setAttrVal("Chl_name", Chl_name);
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
		return "Id_billcheck_exception";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_billcheck_exception";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BillCheckExceptionDODesc.class);
	}
	
}