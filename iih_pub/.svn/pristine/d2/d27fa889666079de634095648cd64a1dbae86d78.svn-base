package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemRulePkgDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_规则包 DO数据 
 * 
 */
public class HpCpElemRulePkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//规则包ID
	public static final String ID_ELE_RULEPKG= "Id_ele_rulepkg";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//规则包类型ID
	public static final String ID_RULEPKG_TP= "Id_rulepkg_tp";
	//规则包类型编码
	public static final String SD_RULEPKG_TP= "Sd_rulepkg_tp";
	//名称
	public static final String NAME_RULEPKG_TP= "Name_rulepkg_tp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 规则包ID
	 * @return String
	 */
	public String getId_ele_rulepkg() {
		return ((String) getAttrVal("Id_ele_rulepkg"));
	}	
	/**
	 * 规则包ID
	 * @param Id_ele_rulepkg
	 */
	public void setId_ele_rulepkg(String Id_ele_rulepkg) {
		setAttrVal("Id_ele_rulepkg", Id_ele_rulepkg);
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
	 * 规则包类型ID
	 * @return String
	 */
	public String getId_rulepkg_tp() {
		return ((String) getAttrVal("Id_rulepkg_tp"));
	}	
	/**
	 * 规则包类型ID
	 * @param Id_rulepkg_tp
	 */
	public void setId_rulepkg_tp(String Id_rulepkg_tp) {
		setAttrVal("Id_rulepkg_tp", Id_rulepkg_tp);
	}
	/**
	 * 规则包类型编码
	 * @return String
	 */
	public String getSd_rulepkg_tp() {
		return ((String) getAttrVal("Sd_rulepkg_tp"));
	}	
	/**
	 * 规则包类型编码
	 * @param Sd_rulepkg_tp
	 */
	public void setSd_rulepkg_tp(String Sd_rulepkg_tp) {
		setAttrVal("Sd_rulepkg_tp", Sd_rulepkg_tp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_rulepkg_tp() {
		return ((String) getAttrVal("Name_rulepkg_tp"));
	}	
	/**
	 * 名称
	 * @param Name_rulepkg_tp
	 */
	public void setName_rulepkg_tp(String Name_rulepkg_tp) {
		setAttrVal("Name_rulepkg_tp", Name_rulepkg_tp);
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
		return "Id_ele_rulepkg";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_cp_ele_rulepkg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemRulePkgDODesc.class);
	}
	
}