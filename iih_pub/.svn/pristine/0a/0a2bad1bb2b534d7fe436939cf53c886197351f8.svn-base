package iih.bl.hp.hptransactahip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.hptransactahip.d.desc.HpTransActItmAhIpDODesc;
import java.math.BigDecimal;

/**
 * 安徽住院医保交易明细 DO数据 
 * 
 */
public class HpTransActItmAhIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TRANSACTITMNEUSOFTAHIP= "Id_transactitmneusoftahip";
	public static final String ID_TRANSACTNEUSOFTAHIP= "Id_transactneusoftahip";
	public static final String ID_CGIP= "Id_cgip";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_transactitmneusoftahip() {
		return ((String) getAttrVal("Id_transactitmneusoftahip"));
	}	
	public void setId_transactitmneusoftahip(String Id_transactitmneusoftahip) {
		setAttrVal("Id_transactitmneusoftahip", Id_transactitmneusoftahip);
	}
	public String getId_transactneusoftahip() {
		return ((String) getAttrVal("Id_transactneusoftahip"));
	}	
	public void setId_transactneusoftahip(String Id_transactneusoftahip) {
		setAttrVal("Id_transactneusoftahip", Id_transactneusoftahip);
	}
	public String getId_cgip() {
		return ((String) getAttrVal("Id_cgip"));
	}	
	public void setId_cgip(String Id_cgip) {
		setAttrVal("Id_cgip", Id_cgip);
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
		return "Id_transactitmneusoftahip";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_transact_itm_neusoft_ahip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpTransActItmAhIpDODesc.class);
	}
	
}