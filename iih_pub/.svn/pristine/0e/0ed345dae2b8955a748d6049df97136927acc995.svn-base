package iih.hp.cp.eletpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.eletpl.d.desc.HpCpElemOrderTplDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_医嘱_模板 DO数据 
 * 
 */
public class HpCpElemOrderTplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ELE_ORDER_TPL= "Id_ele_order_tpl";
	public static final String ID_ELE_TPL= "Id_ele_tpl";
	public static final String FG_LONG= "Fg_long";
	public static final String ID_ROUTE= "Id_route";
	public static final String DOSAGE= "Dosage";
	public static final String ID_CUR= "Id_cur";
	public static final String ID_FREQ= "Id_freq";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ele_order_tpl() {
		return ((String) getAttrVal("Id_ele_order_tpl"));
	}	
	public void setId_ele_order_tpl(String Id_ele_order_tpl) {
		setAttrVal("Id_ele_order_tpl", Id_ele_order_tpl);
	}
	public String getId_ele_tpl() {
		return ((String) getAttrVal("Id_ele_tpl"));
	}	
	public void setId_ele_tpl(String Id_ele_tpl) {
		setAttrVal("Id_ele_tpl", Id_ele_tpl);
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
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}	
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	public String getId_cur() {
		return ((String) getAttrVal("Id_cur"));
	}	
	public void setId_cur(String Id_cur) {
		setAttrVal("Id_cur", Id_cur);
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
		return "Id_ele_order_tpl";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_ORDER_TPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemOrderTplDODesc.class);
	}
	
}