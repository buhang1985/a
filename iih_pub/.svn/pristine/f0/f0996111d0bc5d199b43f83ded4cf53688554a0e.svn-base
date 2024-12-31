package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemBioDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_患者生物属性 DO数据 
 * 
 */
public class HpCpElemBioDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//生物属性ID
	public static final String ID_ELE_BIOL= "Id_ele_biol";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//公共数据源
	public static final String ID_DE= "Id_de";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 生物属性ID
	 * @return String
	 */
	public String getId_ele_biol() {
		return ((String) getAttrVal("Id_ele_biol"));
	}	
	/**
	 * 生物属性ID
	 * @param Id_ele_biol
	 */
	public void setId_ele_biol(String Id_ele_biol) {
		setAttrVal("Id_ele_biol", Id_ele_biol);
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
	 * 公共数据源
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 公共数据源
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
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
		return "Id_ele_biol";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_BIOL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemBioDODesc.class);
	}
	
}