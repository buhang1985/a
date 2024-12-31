package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemVitalDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_患者生命体征 DO数据 
 * 
 */
public class HpCpElemVitalDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//生命体征ID
	public static final String ID_ELE_VT= "Id_ele_vt";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//患者生命体征类型ID
	public static final String ID_VT_TP= "Id_vt_tp";
	//患者生命体征类型编码
	public static final String SD_VT_TP= "Sd_vt_tp";
	//公共数据元
	public static final String ID_DE= "Id_de";
	//数据元名称
	public static final String ID_DE_NAME= "Id_de_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 生命体征ID
	 * @return String
	 */
	public String getId_ele_vt() {
		return ((String) getAttrVal("Id_ele_vt"));
	}	
	/**
	 * 生命体征ID
	 * @param Id_ele_vt
	 */
	public void setId_ele_vt(String Id_ele_vt) {
		setAttrVal("Id_ele_vt", Id_ele_vt);
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
	 * 患者生命体征类型ID
	 * @return String
	 */
	public String getId_vt_tp() {
		return ((String) getAttrVal("Id_vt_tp"));
	}	
	/**
	 * 患者生命体征类型ID
	 * @param Id_vt_tp
	 */
	public void setId_vt_tp(String Id_vt_tp) {
		setAttrVal("Id_vt_tp", Id_vt_tp);
	}
	/**
	 * 患者生命体征类型编码
	 * @return String
	 */
	public String getSd_vt_tp() {
		return ((String) getAttrVal("Sd_vt_tp"));
	}	
	/**
	 * 患者生命体征类型编码
	 * @param Sd_vt_tp
	 */
	public void setSd_vt_tp(String Sd_vt_tp) {
		setAttrVal("Sd_vt_tp", Sd_vt_tp);
	}
	/**
	 * 公共数据元
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}	
	/**
	 * 公共数据元
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 数据元名称
	 * @return String
	 */
	public String getId_de_name() {
		return ((String) getAttrVal("Id_de_name"));
	}	
	/**
	 * 数据元名称
	 * @param Id_de_name
	 */
	public void setId_de_name(String Id_de_name) {
		setAttrVal("Id_de_name", Id_de_name);
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
		return "Id_ele_vt";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_VT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemVitalDODesc.class);
	}
	
}