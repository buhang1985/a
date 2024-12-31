package iih.mp.mpbd.syntest.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.syntest.d.desc.MpSdkTimesDODesc;
import java.math.BigDecimal;

/**
 * 护理任务执行时刻 DO数据 
 * 
 */
public class MpSdkTimesDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID= "Id";
	public static final String ID_KEY= "Id_key";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String DT_NOW= "Dt_now";
	public static final String AMT_PRI= "Amt_pri";
	public static final String DT_BIRTH= "Dt_birth";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}	
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
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
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
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
		return "Id";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_SDK_TIMES";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSdkTimesDODesc.class);
	}
	
}