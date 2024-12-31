package iih.pe.pitm.pedishes.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pedishes.d.desc.PeDishesItmDODesc;
import java.math.BigDecimal;

/**
 * 体检食物菜单内容定义 DO数据 
 * 
 */
public class PeDishesItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDISHESITM= "Id_pedishesitm";
	public static final String ID_PEDISHES= "Id_pedishes";
	public static final String ID_PEFOODCOMP= "Id_pefoodcomp";
	public static final String QTY= "Qty";
	public static final String SORTNO= "Sortno";
	public static final String CODE_COMP= "Code_comp";
	public static final String NAME_COMP= "Name_comp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedishesitm() {
		return ((String) getAttrVal("Id_pedishesitm"));
	}	
	public void setId_pedishesitm(String Id_pedishesitm) {
		setAttrVal("Id_pedishesitm", Id_pedishesitm);
	}
	public String getId_pedishes() {
		return ((String) getAttrVal("Id_pedishes"));
	}	
	public void setId_pedishes(String Id_pedishes) {
		setAttrVal("Id_pedishes", Id_pedishes);
	}
	public String getId_pefoodcomp() {
		return ((String) getAttrVal("Id_pefoodcomp"));
	}	
	public void setId_pefoodcomp(String Id_pefoodcomp) {
		setAttrVal("Id_pefoodcomp", Id_pefoodcomp);
	}
	public FDouble getQty() {
		return ((FDouble) getAttrVal("Qty"));
	}	
	public void setQty(FDouble Qty) {
		setAttrVal("Qty", Qty);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode_comp() {
		return ((String) getAttrVal("Code_comp"));
	}	
	public void setCode_comp(String Code_comp) {
		setAttrVal("Code_comp", Code_comp);
	}
	public String getName_comp() {
		return ((String) getAttrVal("Name_comp"));
	}	
	public void setName_comp(String Name_comp) {
		setAttrVal("Name_comp", Name_comp);
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
		return "Id_pedishesitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pedishesitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDishesItmDODesc.class);
	}
	
}