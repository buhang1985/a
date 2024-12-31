package iih.pe.pitm.peitfdiags.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.peitfdiags.d.desc.PeItfDiagsDODesc;
import java.math.BigDecimal;

/**
 * 体检接口_诊断 DO数据 
 * 
 */
public class PeItfDiagsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEITFDIAGS= "Id_peitfdiags";
	public static final String ITEM_CODE= "Item_code";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peitfdiags() {
		return ((String) getAttrVal("Id_peitfdiags"));
	}	
	public void setId_peitfdiags(String Id_peitfdiags) {
		setAttrVal("Id_peitfdiags", Id_peitfdiags);
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
		return "Id_peitfdiags";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_peitfdiags";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeItfDiagsDODesc.class);
	}
	
}