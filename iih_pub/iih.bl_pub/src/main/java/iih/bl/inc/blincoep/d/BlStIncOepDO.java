package iih.bl.inc.blincoep.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.inc.blincoep.d.desc.BlStIncOepDODesc;
import java.math.BigDecimal;

/**
 * 门急诊结算与发票关系 DO数据 
 * 
 */
public class BlStIncOepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//结算与发票主键
	public static final String ID_STINCOEP= "Id_stincoep";
	//结算
	public static final String ID_STOEP= "Id_stoep";
	//发票
	public static final String ID_INCOEP= "Id_incoep";
	//有效标志
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 结算与发票主键
	 * @return String
	 */
	public String getId_stincoep() {
		return ((String) getAttrVal("Id_stincoep"));
	}	
	/**
	 * 结算与发票主键
	 * @param Id_stincoep
	 */
	public void setId_stincoep(String Id_stincoep) {
		setAttrVal("Id_stincoep", Id_stincoep);
	}
	/**
	 * 结算
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}	
	/**
	 * 结算
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 发票
	 * @return String
	 */
	public String getId_incoep() {
		return ((String) getAttrVal("Id_incoep"));
	}	
	/**
	 * 发票
	 * @param Id_incoep
	 */
	public void setId_incoep(String Id_incoep) {
		setAttrVal("Id_incoep", Id_incoep);
	}
	/**
	 * 有效标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 有效标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
		return "Id_stincoep";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_st_inc_oep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlStIncOepDODesc.class);
	}
	
}