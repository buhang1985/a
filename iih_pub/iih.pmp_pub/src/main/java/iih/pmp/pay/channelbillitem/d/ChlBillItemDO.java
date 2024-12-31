package iih.pmp.pay.channelbillitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.channelbillitem.d.desc.ChlBillItemDODesc;
import java.math.BigDecimal;

/**
 * 渠道账单明细 DO数据 
 * 
 */
public class ChlBillItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CHANNEL_BILL_ITEM= "Id_channel_bill_item";
	public static final String ID_CHANNEL_BILL= "Id_channel_bill";
	public static final String TRADETIME= "Tradetime";
	public static final String APPID= "Appid";
	public static final String MCHID= "Mchid";
	public static final String CMCHID= "Cmchid";
	public static final String DEVICENO= "Deviceno";
	public static final String CHANNELTRADENO= "Channeltradeno";
	public static final String MCH_TRADE_NO= "Mch_trade_no";
	public static final String USER_IDENTIFY= "User_identify";
	public static final String TRADE_TYPE= "Trade_type";
	public static final String TRADE_STATUS= "Trade_status";
	public static final String BANK= "Bank";
	public static final String CURRENCY_TYPE= "Currency_type";
	public static final String TOTAL_FEE= "Total_fee";
	public static final String VOUCHERS_FEE= "Vouchers_fee";
	public static final String CHANNEL_REFUND_NO= "Channel_refund_no";
	public static final String MCH_REFUND_NO= "Mch_refund_no";
	public static final String REFUND_FEE= "Refund_fee";
	public static final String REFUND_TYPE= "Refund_type";
	public static final String REFUND_STATUS= "Refund_status";
	public static final String PRODUCT_NAME= "Product_name";
	public static final String MCH_DATA= "Mch_data";
	public static final String POUNDAGE= "Poundage";
	public static final String RATE= "Rate";
	public static final String CHALEL_NAME= "Chalel_name";
	public static final String ID_CHL= "Id_chl";
	public static final String CHECK_RST= "Check_rst";
	public static final String SD_CHL= "Sd_chl";
	public static final String BANKTRADENO= "Banktradeno";
	public static final String BILL_TYPE= "Bill_type";
	public static final String CHL_NAME= "Chl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_channel_bill_item() {
		return ((String) getAttrVal("Id_channel_bill_item"));
	}	
	public void setId_channel_bill_item(String Id_channel_bill_item) {
		setAttrVal("Id_channel_bill_item", Id_channel_bill_item);
	}
	public String getId_channel_bill() {
		return ((String) getAttrVal("Id_channel_bill"));
	}	
	public void setId_channel_bill(String Id_channel_bill) {
		setAttrVal("Id_channel_bill", Id_channel_bill);
	}
	public FDateTime getTradetime() {
		return ((FDateTime) getAttrVal("Tradetime"));
	}	
	public void setTradetime(FDateTime Tradetime) {
		setAttrVal("Tradetime", Tradetime);
	}
	public String getAppid() {
		return ((String) getAttrVal("Appid"));
	}	
	public void setAppid(String Appid) {
		setAttrVal("Appid", Appid);
	}
	public String getMchid() {
		return ((String) getAttrVal("Mchid"));
	}	
	public void setMchid(String Mchid) {
		setAttrVal("Mchid", Mchid);
	}
	public String getCmchid() {
		return ((String) getAttrVal("Cmchid"));
	}	
	public void setCmchid(String Cmchid) {
		setAttrVal("Cmchid", Cmchid);
	}
	public String getDeviceno() {
		return ((String) getAttrVal("Deviceno"));
	}	
	public void setDeviceno(String Deviceno) {
		setAttrVal("Deviceno", Deviceno);
	}
	public String getChanneltradeno() {
		return ((String) getAttrVal("Channeltradeno"));
	}	
	public void setChanneltradeno(String Channeltradeno) {
		setAttrVal("Channeltradeno", Channeltradeno);
	}
	public String getMch_trade_no() {
		return ((String) getAttrVal("Mch_trade_no"));
	}	
	public void setMch_trade_no(String Mch_trade_no) {
		setAttrVal("Mch_trade_no", Mch_trade_no);
	}
	public String getUser_identify() {
		return ((String) getAttrVal("User_identify"));
	}	
	public void setUser_identify(String User_identify) {
		setAttrVal("User_identify", User_identify);
	}
	public String getTrade_type() {
		return ((String) getAttrVal("Trade_type"));
	}	
	public void setTrade_type(String Trade_type) {
		setAttrVal("Trade_type", Trade_type);
	}
	public String getTrade_status() {
		return ((String) getAttrVal("Trade_status"));
	}	
	public void setTrade_status(String Trade_status) {
		setAttrVal("Trade_status", Trade_status);
	}
	public String getBank() {
		return ((String) getAttrVal("Bank"));
	}	
	public void setBank(String Bank) {
		setAttrVal("Bank", Bank);
	}
	public String getCurrency_type() {
		return ((String) getAttrVal("Currency_type"));
	}	
	public void setCurrency_type(String Currency_type) {
		setAttrVal("Currency_type", Currency_type);
	}
	public FDouble getTotal_fee() {
		return ((FDouble) getAttrVal("Total_fee"));
	}	
	public void setTotal_fee(FDouble Total_fee) {
		setAttrVal("Total_fee", Total_fee);
	}
	public String getVouchers_fee() {
		return ((String) getAttrVal("Vouchers_fee"));
	}	
	public void setVouchers_fee(String Vouchers_fee) {
		setAttrVal("Vouchers_fee", Vouchers_fee);
	}
	public String getChannel_refund_no() {
		return ((String) getAttrVal("Channel_refund_no"));
	}	
	public void setChannel_refund_no(String Channel_refund_no) {
		setAttrVal("Channel_refund_no", Channel_refund_no);
	}
	public String getMch_refund_no() {
		return ((String) getAttrVal("Mch_refund_no"));
	}	
	public void setMch_refund_no(String Mch_refund_no) {
		setAttrVal("Mch_refund_no", Mch_refund_no);
	}
	public FDouble getRefund_fee() {
		return ((FDouble) getAttrVal("Refund_fee"));
	}	
	public void setRefund_fee(FDouble Refund_fee) {
		setAttrVal("Refund_fee", Refund_fee);
	}
	public String getRefund_type() {
		return ((String) getAttrVal("Refund_type"));
	}	
	public void setRefund_type(String Refund_type) {
		setAttrVal("Refund_type", Refund_type);
	}
	public String getRefund_status() {
		return ((String) getAttrVal("Refund_status"));
	}	
	public void setRefund_status(String Refund_status) {
		setAttrVal("Refund_status", Refund_status);
	}
	public String getProduct_name() {
		return ((String) getAttrVal("Product_name"));
	}	
	public void setProduct_name(String Product_name) {
		setAttrVal("Product_name", Product_name);
	}
	public String getMch_data() {
		return ((String) getAttrVal("Mch_data"));
	}	
	public void setMch_data(String Mch_data) {
		setAttrVal("Mch_data", Mch_data);
	}
	public String getPoundage() {
		return ((String) getAttrVal("Poundage"));
	}	
	public void setPoundage(String Poundage) {
		setAttrVal("Poundage", Poundage);
	}
	public String getRate() {
		return ((String) getAttrVal("Rate"));
	}	
	public void setRate(String Rate) {
		setAttrVal("Rate", Rate);
	}
	public String getChalel_name() {
		return ((String) getAttrVal("Chalel_name"));
	}	
	public void setChalel_name(String Chalel_name) {
		setAttrVal("Chalel_name", Chalel_name);
	}
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}	
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	public Integer getCheck_rst() {
		return ((Integer) getAttrVal("Check_rst"));
	}	
	public void setCheck_rst(Integer Check_rst) {
		setAttrVal("Check_rst", Check_rst);
	}
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}	
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	public String getBanktradeno() {
		return ((String) getAttrVal("Banktradeno"));
	}	
	public void setBanktradeno(String Banktradeno) {
		setAttrVal("Banktradeno", Banktradeno);
	}
	public String getBill_type() {
		return ((String) getAttrVal("Bill_type"));
	}	
	public void setBill_type(String Bill_type) {
		setAttrVal("Bill_type", Bill_type);
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
		return "Id_channel_bill_item";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_chlbillitem";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChlBillItemDODesc.class);
	}
	
}