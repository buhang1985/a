package iih.mm.st.settlement.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mm.st.settlement.d.desc.SettlementInRelDODesc;
import java.math.BigDecimal;

/**
 * 结算回冲关系表 DO数据 
 * 
 */
public class SettlementInRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INVINREL= "Id_invinrel";
	public static final String ID_BANLITM= "Id_banlitm";
	public static final String ID_INITM= "Id_initm";
	public static final String ID_IN= "Id_in";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_invinrel() {
		return ((String) getAttrVal("Id_invinrel"));
	}	
	public void setId_invinrel(String Id_invinrel) {
		setAttrVal("Id_invinrel", Id_invinrel);
	}
	public String getId_banlitm() {
		return ((String) getAttrVal("Id_banlitm"));
	}	
	public void setId_banlitm(String Id_banlitm) {
		setAttrVal("Id_banlitm", Id_banlitm);
	}
	public String getId_initm() {
		return ((String) getAttrVal("Id_initm"));
	}	
	public void setId_initm(String Id_initm) {
		setAttrVal("Id_initm", Id_initm);
	}
	public String getId_in() {
		return ((String) getAttrVal("Id_in"));
	}	
	public void setId_in(String Id_in) {
		setAttrVal("Id_in", Id_in);
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
		return "Id_invinrel";
	}
	
	@Override
	public String getTableName() {	  
		return "MM_BANL_IN_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SettlementInRelDODesc.class);
	}
	
}