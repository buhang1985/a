package iih.syn.common.biz.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.syn.common.biz.d.desc.MpSkdTimesDODesc;
import java.math.BigDecimal;

/**
 * 测试实体 DO数据 
 * 
 */
public class MpSkdTimesDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SDK_TIMES= "Id_sdk_times";
	public static final String ID_SDK= "Id_sdk";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String DT_NOW= "Dt_now";
	public static final String AMT_PRI= "Amt_pri";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_sdk_times() {
		return ((String) getAttrVal("Id_sdk_times"));
	}	
	public void setId_sdk_times(String Id_sdk_times) {
		setAttrVal("Id_sdk_times", Id_sdk_times);
	}
	public String getId_sdk() {
		return ((String) getAttrVal("Id_sdk"));
	}	
	public void setId_sdk(String Id_sdk) {
		setAttrVal("Id_sdk", Id_sdk);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public FDateTime getDt_now() {
		return ((FDateTime) getAttrVal("Dt_now"));
	}	
	public void setDt_now(FDateTime Dt_now) {
		setAttrVal("Dt_now", Dt_now);
	}
	public FDouble getAmt_pri() {
		return ((FDouble) getAttrVal("Amt_pri"));
	}	
	public void setAmt_pri(FDouble Amt_pri) {
		setAttrVal("Amt_pri", Amt_pri);
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
		return "Id_sdk_times";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_SDK_TIMES";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSkdTimesDODesc.class);
	}
	
}