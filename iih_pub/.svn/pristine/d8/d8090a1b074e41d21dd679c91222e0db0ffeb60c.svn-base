package iih.pe.pitm.peitfitemsign.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.peitfitemsign.d.desc.PeItfItemSignDODesc;
import java.math.BigDecimal;

/**
 * 体检接口_体征 DO数据 
 * 
 */
public class PeItfItemSignDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEITFITEMSIGN= "Id_peitfitemsign";
	public static final String ITEM_CODE= "Item_code";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CODE_PARENT= "Code_parent";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peitfitemsign() {
		return ((String) getAttrVal("Id_peitfitemsign"));
	}	
	public void setId_peitfitemsign(String Id_peitfitemsign) {
		setAttrVal("Id_peitfitemsign", Id_peitfitemsign);
	}
	public String getItem_code() {
		return ((String) getAttrVal("Item_code"));
	}	
	public void setItem_code(String Item_code) {
		setAttrVal("Item_code", Item_code);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode_parent() {
		return ((String) getAttrVal("Code_parent"));
	}	
	public void setCode_parent(String Code_parent) {
		setAttrVal("Code_parent", Code_parent);
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
		return "Id_peitfitemsign";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peitfitemsign";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeItfItemSignDODesc.class);
	}
	
}