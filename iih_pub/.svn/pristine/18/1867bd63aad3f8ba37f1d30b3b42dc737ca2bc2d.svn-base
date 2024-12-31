package iih.pmp.pay.channelbill.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.channelbill.d.desc.ChannelBillDODesc;
import java.math.BigDecimal;

/**
 * 渠道账单 DO数据 
 * 
 */
public class ChannelBillDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CHANNEL_BILL= "Id_channel_bill";
	public static final String ID_CHL= "Id_chl";
	public static final String DT_BILL= "Dt_bill";
	public static final String BILL_FEATURE= "Bill_feature";
	public static final String BILL_CONTENT= "Bill_content";
	public static final String BILL_TYPE= "Bill_type";
	public static final String DT_CREATETIME= "Dt_createtime";
	public static final String IS_CHECKED= "Is_checked";
	public static final String DT_CHECK= "Dt_check";
	public static final String SD_CHL= "Sd_chl";
	public static final String CHL_NAME= "Chl_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_channel_bill() {
		return ((String) getAttrVal("Id_channel_bill"));
	}	
	public void setId_channel_bill(String Id_channel_bill) {
		setAttrVal("Id_channel_bill", Id_channel_bill);
	}
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}	
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	public FDate getDt_bill() {
		return ((FDate) getAttrVal("Dt_bill"));
	}	
	public void setDt_bill(FDate Dt_bill) {
		setAttrVal("Dt_bill", Dt_bill);
	}
	public String getBill_feature() {
		return ((String) getAttrVal("Bill_feature"));
	}	
	public void setBill_feature(String Bill_feature) {
		setAttrVal("Bill_feature", Bill_feature);
	}
	public String getBill_content() {
		return ((String) getAttrVal("Bill_content"));
	}	
	public void setBill_content(String Bill_content) {
		setAttrVal("Bill_content", Bill_content);
	}
	public String getBill_type() {
		return ((String) getAttrVal("Bill_type"));
	}	
	public void setBill_type(String Bill_type) {
		setAttrVal("Bill_type", Bill_type);
	}
	public FDateTime getDt_createtime() {
		return ((FDateTime) getAttrVal("Dt_createtime"));
	}	
	public void setDt_createtime(FDateTime Dt_createtime) {
		setAttrVal("Dt_createtime", Dt_createtime);
	}
	public FBoolean getIs_checked() {
		return ((FBoolean) getAttrVal("Is_checked"));
	}	
	public void setIs_checked(FBoolean Is_checked) {
		setAttrVal("Is_checked", Is_checked);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}	
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
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
		return "Id_channel_bill";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_channel_bill";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ChannelBillDODesc.class);
	}
	
}