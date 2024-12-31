package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemRulePkgTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_规则包_模板 DO数据 
 * 
 */
public class HpCpElemRulePkgTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_RULEPKG_TPL= "Id_ele_rulepkg_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String ID_RULEPKG_TP= "Id_rulepkg_tp";
	public static final String SD_RULEPKG_TP= "Sd_rulepkg_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_rulepkg_tpl() {
		return ((String) getAttrVal("Id_ele_rulepkg_tpl"));
	}	
	public void setId_ele_rulepkg_tpl(String Id_ele_rulepkg_tpl) {
		setAttrVal("Id_ele_rulepkg_tpl", Id_ele_rulepkg_tpl);
	}
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
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
		return "Id_ele_rulepkg_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_RULEPKG_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemRulePkgTplDODesc.class);
	}
	
}