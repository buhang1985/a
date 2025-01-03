package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.OrdDrugDODesc;
import java.math.BigDecimal;

/**
 * 医嘱药品属性 DO数据 
 * 
 */
public class OrdDrugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱药品属性主键标识
	public static final String ID_ORDRUG= "Id_ordrug";
	//医嘱
	public static final String ID_OR= "Id_or";
	//皮试标识
	public static final String FG_SKINTEST= "Fg_skintest";
	//皮试类型
	public static final String ID_SKINTEST= "Id_skintest";
	//皮试类型编码
	public static final String SD_SKINTEST= "Sd_skintest";
	//代煎标识
	public static final String FG_BOIL= "Fg_boil";
	//代煎付数
	public static final String ORDERS_BOIL= "Orders_boil";
	//自备药标识
	public static final String FG_SELF= "Fg_self";
	//出院带药标识
	public static final String FG_PRES_OUTP= "Fg_pres_outp";
	//预防用药标识
	public static final String FG_PROPC= "Fg_propc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱药品属性主键标识
	 * @return String
	 */
	public String getId_ordrug() {
		return ((String) getAttrVal("Id_ordrug"));
	}	
	/**
	 * 医嘱药品属性主键标识
	 * @param Id_ordrug
	 */
	public void setId_ordrug(String Id_ordrug) {
		setAttrVal("Id_ordrug", Id_ordrug);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 皮试类型
	 * @return String
	 */
	public String getId_skintest() {
		return ((String) getAttrVal("Id_skintest"));
	}	
	/**
	 * 皮试类型
	 * @param Id_skintest
	 */
	public void setId_skintest(String Id_skintest) {
		setAttrVal("Id_skintest", Id_skintest);
	}
	/**
	 * 皮试类型编码
	 * @return String
	 */
	public String getSd_skintest() {
		return ((String) getAttrVal("Sd_skintest"));
	}	
	/**
	 * 皮试类型编码
	 * @param Sd_skintest
	 */
	public void setSd_skintest(String Sd_skintest) {
		setAttrVal("Sd_skintest", Sd_skintest);
	}
	/**
	 * 代煎标识
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 代煎标识
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 代煎付数
	 * @return FDouble
	 */
	public FDouble getOrders_boil() {
		return ((FDouble) getAttrVal("Orders_boil"));
	}	
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(FDouble Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	/**
	 * 自备药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	/**
	 * 自备药标识
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
	}
	/**
	 * 预防用药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_propc() {
		return ((FBoolean) getAttrVal("Fg_propc"));
	}	
	/**
	 * 预防用药标识
	 * @param Fg_propc
	 */
	public void setFg_propc(FBoolean Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
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
		return "Id_ordrug";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_drug";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdDrugDODesc.class);
	}
	
}