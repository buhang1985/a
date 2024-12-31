package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemOrderPkgTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_医嘱包_模板 DO数据 
 * 
 */
public class HpCpElemOrderPkgTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_ORDERKPG_TPL= "Id_ele_orderkpg_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String EU_ORDER_REL= "Eu_order_rel";
	public static final String FG_LONG= "Fg_long";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_FREQ= "Id_freq";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_orderkpg_tpl() {
		return ((String) getAttrVal("Id_ele_orderkpg_tpl"));
	}	
	public void setId_ele_orderkpg_tpl(String Id_ele_orderkpg_tpl) {
		setAttrVal("Id_ele_orderkpg_tpl", Id_ele_orderkpg_tpl);
	}
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
	}
	public Integer getEu_order_rel() {
		return ((Integer) getAttrVal("Eu_order_rel"));
	}	
	public void setEu_order_rel(Integer Eu_order_rel) {
		setAttrVal("Eu_order_rel", Eu_order_rel);
	}
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
		return "Id_ele_orderkpg_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_ORDERPKG_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemOrderPkgTplDODesc.class);
	}
	
}