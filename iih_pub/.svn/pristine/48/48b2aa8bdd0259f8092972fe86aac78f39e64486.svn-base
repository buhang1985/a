package iih.hp.cp.appele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.appele.d.desc.HpCpAppElemMrDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划应用元素病历 DO数据 
 * 
 */
public class HpCpAppElemMrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//诊疗计划应用元素病历ID
	public static final String ID_APPELE_MR= "Id_appele_mr";
	//诊疗计划应用元素ID
	public static final String ID_APPELE= "Id_appele";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//医疗记录ID
	public static final String ID_MR= "Id_mr";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 诊疗计划应用元素病历ID
	 * @return String
	 */
	public String getId_appele_mr() {
		return ((String) getAttrVal("Id_appele_mr"));
	}	
	/**
	 * 诊疗计划应用元素病历ID
	 * @param Id_appele_mr
	 */
	public void setId_appele_mr(String Id_appele_mr) {
		setAttrVal("Id_appele_mr", Id_appele_mr);
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
	 * 医疗记录ID
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 医疗记录ID
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
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
		return "Id_appele_mr";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP_ELE_MR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppElemMrDODesc.class);
	}
	
}