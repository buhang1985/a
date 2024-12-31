package iih.bl.inc.blinccgip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blinccgip.d.desc.BlIncCgIpDODesc;
import java.math.BigDecimal;

/**
 * 住院发票费用明细 DO数据 
 * 
 */
public class BlIncCgIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_INCCGIP= "Id_inccgip";
	public static final String ID_INCIP= "Id_incip";
	public static final String ID_CGIP= "Id_cgip";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_inccgip() {
		return ((String) getAttrVal("Id_inccgip"));
	}	
	public void setId_inccgip(String Id_inccgip) {
		setAttrVal("Id_inccgip", Id_inccgip);
	}
	public String getId_incip() {
		return ((String) getAttrVal("Id_incip"));
	}	
	public void setId_incip(String Id_incip) {
		setAttrVal("Id_incip", Id_incip);
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
		return "Id_inccgip";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_inc_cg_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlIncCgIpDODesc.class);
	}
	
}