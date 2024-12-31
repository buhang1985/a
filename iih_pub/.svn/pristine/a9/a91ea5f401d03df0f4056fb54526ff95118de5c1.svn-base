package iih.hp.cp.sdele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.sdele.d.desc.HpCpSdElemRulePkgDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划标准元素_规则包 DO数据 
 * 
 */
public class HpCpSdElemRulePkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SD_ELE_RULEPKG= "Id_sd_ele_rulepkg";
	public static final String ID_SD_ELE= "Id_sd_ele";
	public static final String ID_RULEPKG_TP= "Id_rulepkg_tp";
	public static final String SD_RULEPKG_TP= "Sd_rulepkg_tp";
	public static final String NAME_PKGTP= "Name_pkgtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_sd_ele_rulepkg() {
		return ((String) getAttrVal("Id_sd_ele_rulepkg"));
	}	
	public void setId_sd_ele_rulepkg(String Id_sd_ele_rulepkg) {
		setAttrVal("Id_sd_ele_rulepkg", Id_sd_ele_rulepkg);
	}
	public String getId_sd_ele() {
		return ((String) getAttrVal("Id_sd_ele"));
	}	
	public void setId_sd_ele(String Id_sd_ele) {
		setAttrVal("Id_sd_ele", Id_sd_ele);
	}
	public String getId_rulepkg_tp() {
		return ((String) getAttrVal("Id_rulepkg_tp"));
	}	
	public void setId_rulepkg_tp(String Id_rulepkg_tp) {
		setAttrVal("Id_rulepkg_tp", Id_rulepkg_tp);
	}
	public String getSd_rulepkg_tp() {
		return ((String) getAttrVal("Sd_rulepkg_tp"));
	}	
	public void setSd_rulepkg_tp(String Sd_rulepkg_tp) {
		setAttrVal("Sd_rulepkg_tp", Sd_rulepkg_tp);
	}
	public String getName_pkgtp() {
		return ((String) getAttrVal("Name_pkgtp"));
	}	
	public void setName_pkgtp(String Name_pkgtp) {
		setAttrVal("Name_pkgtp", Name_pkgtp);
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
		return "Id_sd_ele_rulepkg";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_SD_ELE_RULEPKG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpSdElemRulePkgDODesc.class);
	}
	
}