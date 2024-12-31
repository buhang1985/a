package iih.mc.st.mcstockaplrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.st.mcstockaplrel.d.desc.McStockAplRelDODesc;
import java.math.BigDecimal;

/**
 * 耗材出库申请关联 DO数据 
 * 
 */
public class McStockAplRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DAREL= "Id_darel";
	public static final String ID_OUT= "Id_out";
	public static final String ID_DA= "Id_da";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_darel() {
		return ((String) getAttrVal("Id_darel"));
	}	
	public void setId_darel(String Id_darel) {
		setAttrVal("Id_darel", Id_darel);
	}
	public String getId_out() {
		return ((String) getAttrVal("Id_out"));
	}	
	public void setId_out(String Id_out) {
		setAttrVal("Id_out", Id_out);
	}
	public String getId_da() {
		return ((String) getAttrVal("Id_da"));
	}	
	public void setId_da(String Id_da) {
		setAttrVal("Id_da", Id_da);
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
		return "Id_darel";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_DA_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockAplRelDODesc.class);
	}
	
}