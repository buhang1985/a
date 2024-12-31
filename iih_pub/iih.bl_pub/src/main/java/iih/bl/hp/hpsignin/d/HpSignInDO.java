package iih.bl.hp.hpsignin.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hpsignin.d.desc.HpSignInDODesc;
import java.math.BigDecimal;

/**
 * 医保签到 DO数据 
 * 
 */
public class HpSignInDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPSIGNIN= "Id_hpsignin";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_EMP= "Id_emp";
	public static final String CODE_BUSINESS= "Code_business";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String MAC= "Mac";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PSN_CODE= "Psn_code";
	public static final String PSN_NAME= "Psn_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpsignin() {
		return ((String) getAttrVal("Id_hpsignin"));
	}	
	public void setId_hpsignin(String Id_hpsignin) {
		setAttrVal("Id_hpsignin", Id_hpsignin);
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
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getCode_business() {
		return ((String) getAttrVal("Code_business"));
	}	
	public void setCode_business(String Code_business) {
		setAttrVal("Code_business", Code_business);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	public String getMac() {
		return ((String) getAttrVal("Mac"));
	}	
	public void setMac(String Mac) {
		setAttrVal("Mac", Mac);
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
	public String getPsn_code() {
		return ((String) getAttrVal("Psn_code"));
	}	
	public void setPsn_code(String Psn_code) {
		setAttrVal("Psn_code", Psn_code);
	}
	public String getPsn_name() {
		return ((String) getAttrVal("Psn_name"));
	}	
	public void setPsn_name(String Psn_name) {
		setAttrVal("Psn_name", Psn_name);
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
		return "Id_hpsignin";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_sign_in";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpSignInDODesc.class);
	}
	
}