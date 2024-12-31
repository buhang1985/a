package iih.sc.apt.aptip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.aptip.d.desc.AptIpAttrDODesc;
import java.math.BigDecimal;

/**
 * 住院预约属性 DO数据 
 * 
 */
public class AptIpAttrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTIPATTR= "Id_aptipattr";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_APTIP= "Id_aptip";
	public static final String ID_BEDATTR_TP= "Id_bedattr_tp";
	public static final String SD_BEDATTR_TP= "Sd_bedattr_tp";
	public static final String VAL= "Val";
	public static final String NAME_VAL= "Name_val";
	public static final String ID_ATTRVAL= "Id_attrval";
	public static final String FG_OPTION= "Fg_option";
	public static final String NAME_BEDATTR= "Name_bedattr";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptipattr() {
		return ((String) getAttrVal("Id_aptipattr"));
	}	
	public void setId_aptipattr(String Id_aptipattr) {
		setAttrVal("Id_aptipattr", Id_aptipattr);
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
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}	
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	public String getId_bedattr_tp() {
		return ((String) getAttrVal("Id_bedattr_tp"));
	}	
	public void setId_bedattr_tp(String Id_bedattr_tp) {
		setAttrVal("Id_bedattr_tp", Id_bedattr_tp);
	}
	public String getSd_bedattr_tp() {
		return ((String) getAttrVal("Sd_bedattr_tp"));
	}	
	public void setSd_bedattr_tp(String Sd_bedattr_tp) {
		setAttrVal("Sd_bedattr_tp", Sd_bedattr_tp);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	public String getName_val() {
		return ((String) getAttrVal("Name_val"));
	}	
	public void setName_val(String Name_val) {
		setAttrVal("Name_val", Name_val);
	}
	public String getId_attrval() {
		return ((String) getAttrVal("Id_attrval"));
	}	
	public void setId_attrval(String Id_attrval) {
		setAttrVal("Id_attrval", Id_attrval);
	}
	public FBoolean getFg_option() {
		return ((FBoolean) getAttrVal("Fg_option"));
	}	
	public void setFg_option(FBoolean Fg_option) {
		setAttrVal("Fg_option", Fg_option);
	}
	public String getName_bedattr() {
		return ((String) getAttrVal("Name_bedattr"));
	}	
	public void setName_bedattr(String Name_bedattr) {
		setAttrVal("Name_bedattr", Name_bedattr);
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
		return "Id_aptipattr";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_ip_attr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AptIpAttrDODesc.class);
	}
	
}