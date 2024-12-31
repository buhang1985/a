package iih.hp.cp.appele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.appele.d.desc.HpCpAppElemOrderPkgDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划应用元素医嘱包 DO数据 
 * 
 */
public class HpCpAppElemOrderPkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//诊疗计划应用元素医嘱包ID
	public static final String ID_APPELE_ORDERPKG= "Id_appele_orderpkg";
	//诊疗计划应用元素ID
	public static final String ID_APPELE= "Id_appele";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//医嘱ID
	public static final String ID_OR= "Id_or";
	//医疗服务ID
	public static final String ID_SRV= "Id_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 诊疗计划应用元素医嘱包ID
	 * @return String
	 */
	public String getId_appele_orderpkg() {
		return ((String) getAttrVal("Id_appele_orderpkg"));
	}	
	/**
	 * 诊疗计划应用元素医嘱包ID
	 * @param Id_appele_orderpkg
	 */
	public void setId_appele_orderpkg(String Id_appele_orderpkg) {
		setAttrVal("Id_appele_orderpkg", Id_appele_orderpkg);
	}
	/**
	 * 诊疗计划应用元素ID
	 * @return String
	 */
	public String getId_appele() {
		return ((String) getAttrVal("Id_appele"));
	}	
	/**
	 * 诊疗计划应用元素ID
	 * @param Id_appele
	 */
	public void setId_appele(String Id_appele) {
		setAttrVal("Id_appele", Id_appele);
	}
	/**
	 * 元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医疗服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 医疗服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
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
		return "Id_appele_orderpkg";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP_ELE_ORDERPKG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppElemOrderPkgDODesc.class);
	}
	
}