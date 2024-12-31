package iih.hp.cp.appele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.appele.d.desc.HpCpAppDiagRuleDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划应用元素_诊断规则 DO数据 
 * 
 */
public class HpCpAppDiagRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//应用元素诊断规则ID
	public static final String ID_APPDIAGRULE= "Id_appdiagrule";
	//应用元素ID
	public static final String ID_APPELE= "Id_appele";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//匹配结果
	public static final String EU_RSLT= "Eu_rslt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 应用元素诊断规则ID
	 * @return String
	 */
	public String getId_appdiagrule() {
		return ((String) getAttrVal("Id_appdiagrule"));
	}	
	/**
	 * 应用元素诊断规则ID
	 * @param Id_appdiagrule
	 */
	public void setId_appdiagrule(String Id_appdiagrule) {
		setAttrVal("Id_appdiagrule", Id_appdiagrule);
	}
	/**
	 * 应用元素ID
	 * @return String
	 */
	public String getId_appele() {
		return ((String) getAttrVal("Id_appele"));
	}	
	/**
	 * 应用元素ID
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
	 * 匹配结果
	 * @return Integer
	 */
	public Integer getEu_rslt() {
		return ((Integer) getAttrVal("Eu_rslt"));
	}	
	/**
	 * 匹配结果
	 * @param Eu_rslt
	 */
	public void setEu_rslt(Integer Eu_rslt) {
		setAttrVal("Eu_rslt", Eu_rslt);
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
		return "Id_appdiagrule";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_APP_ELE_RULE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpAppDiagRuleDODesc.class);
	}
	
}