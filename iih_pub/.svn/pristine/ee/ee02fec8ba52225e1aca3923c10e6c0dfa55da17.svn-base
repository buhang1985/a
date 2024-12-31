package iih.hp.cp.appele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.appele.d.desc.HpCpAppElemOrderDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划应用元素医嘱 DO数据 
 * 
 */
public class HpCpAppElemOrderDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//诊疗计划应用元素医嘱ID
	public static final String ID_APPELE_ORDER= "Id_appele_order";
	//诊疗计划应用元素ID
	public static final String ID_APPELE= "Id_appele";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//医嘱ID
	public static final String ID_OR= "Id_or";
	//医疗服务ID
	public static final String ID_SRV= "Id_srv";
	//医疗服务编码
	public static final String CODE_SRV= "Code_srv";
	//医疗服务名称
	public static final String NAME_SRV= "Name_srv";
	//医疗物品ID
	public static final String ID_MM= "Id_mm";
	//医疗物品编码
	public static final String CODE_MM= "Code_mm";
	//医疗物品名称
	public static final String NAME_MM= "Name_mm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 诊疗计划应用元素医嘱ID
	 * @return String
	 */
	public String getId_appele_order() {
		return ((String) getAttrVal("Id_appele_order"));
	}	
	/**
	 * 诊疗计划应用元素医嘱ID
	 * @param Id_appele_order
	 */
	public void setId_appele_order(String Id_appele_order) {
		setAttrVal("Id_appele_order", Id_appele_order);
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
	/**
	 * 医疗服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 医疗服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医疗物品ID
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	/**
	 * 医疗物品ID
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 医疗物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	/**
	 * 医疗物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 医疗物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	/**
	 * 医疗物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
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
		return "Id_appele_order";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP_ELE_ORDER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppElemOrderDODesc.class);
	}
	
}