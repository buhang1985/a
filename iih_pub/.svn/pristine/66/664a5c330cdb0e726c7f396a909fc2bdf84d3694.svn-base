package iih.pmp.pay.thirdpartyconfig.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.thirdpartyconfig.d.desc.ThirdPartyConfigDODesc;
import java.math.BigDecimal;

/**
 * 第三方对接配置 DO数据 
 * 
 */
public class ThirdPartyConfigDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_THIRD= "Id_third";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME_SDK= "Name_sdk";
	public static final String NAME_DATACONVERT= "Name_dataconvert";
	public static final String ID_PAYCHANNELS= "Id_paychannels";
	public static final String SD_PAYCHANNELS= "Sd_paychannels";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAYCHANNEL= "Name_paychannel";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_third() {
		return ((String) getAttrVal("Id_third"));
	}	
	public void setId_third(String Id_third) {
		setAttrVal("Id_third", Id_third);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName_sdk() {
		return ((String) getAttrVal("Name_sdk"));
	}	
	public void setName_sdk(String Name_sdk) {
		setAttrVal("Name_sdk", Name_sdk);
	}
	public String getName_dataconvert() {
		return ((String) getAttrVal("Name_dataconvert"));
	}	
	public void setName_dataconvert(String Name_dataconvert) {
		setAttrVal("Name_dataconvert", Name_dataconvert);
	}
	public String getId_paychannels() {
		return ((String) getAttrVal("Id_paychannels"));
	}	
	public void setId_paychannels(String Id_paychannels) {
		setAttrVal("Id_paychannels", Id_paychannels);
	}
	public String getSd_paychannels() {
		return ((String) getAttrVal("Sd_paychannels"));
	}	
	public void setSd_paychannels(String Sd_paychannels) {
		setAttrVal("Sd_paychannels", Sd_paychannels);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getName_paychannel() {
		return ((String) getAttrVal("Name_paychannel"));
	}	
	public void setName_paychannel(String Name_paychannel) {
		setAttrVal("Name_paychannel", Name_paychannel);
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
		return "Id_third";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_thirdconfig";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ThirdPartyConfigDODesc.class);
	}
	
}