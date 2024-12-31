package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemOrderPkgDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素_医嘱包 DO数据 
 * 
 */
public class HpCpElemOrderPkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱包ID
	public static final String ID_ELE_ORDERKPG= "Id_ele_orderkpg";
	//元素ID
	public static final String ID_ELE= "Id_ele";
	//医嘱类型
	public static final String ID_SRVTP= "Id_srvtp";
	//医嘱类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//包内医嘱关联关系
	public static final String EU_ORDER_REL= "Eu_order_rel";
	//长临标识
	public static final String FG_LONG= "Fg_long";
	//给药途径
	public static final String ID_ROUTE= "Id_route";
	//使用频次
	public static final String ID_FREQ= "Id_freq";
	//出院带药标识
	public static final String FG_PRES_OUTP= "Fg_pres_outp";
	//在院整领
	public static final String FG_WHOLEPACK= "Fg_wholepack";
	//成组药医嘱包标识
	public static final String FG_GROUP_PKG= "Fg_group_pkg";
	//领药方式ID
	public static final String ID_DRUG_DELIVERY_METHOD= "Id_drug_delivery_method";
	//领药方式SD
	public static final String SD_DRUG_DELIVERY_METHOD= "Sd_drug_delivery_method";
	//名称
	public static final String SRVTP_NAME= "Srvtp_name";
	//用法名称
	public static final String ID_ROUTE_NAME= "Id_route_name";
	//频次名称
	public static final String ID_FREQ_NAME= "Id_freq_name";
	//领药方式名称
	public static final String NAME_DRUG_DELIVERY_METHOD= "Name_drug_delivery_method";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱包ID
	 * @return String
	 */
	public String getId_ele_orderkpg() {
		return ((String) getAttrVal("Id_ele_orderkpg"));
	}	
	/**
	 * 医嘱包ID
	 * @param Id_ele_orderkpg
	 */
	public void setId_ele_orderkpg(String Id_ele_orderkpg) {
		setAttrVal("Id_ele_orderkpg", Id_ele_orderkpg);
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
	 * 医嘱类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 医嘱类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 包内医嘱关联关系
	 * @return Integer
	 */
	public Integer getEu_order_rel() {
		return ((Integer) getAttrVal("Eu_order_rel"));
	}	
	/**
	 * 包内医嘱关联关系
	 * @param Eu_order_rel
	 */
	public void setEu_order_rel(Integer Eu_order_rel) {
		setAttrVal("Eu_order_rel", Eu_order_rel);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 给药途径
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 给药途径
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 使用频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 使用频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
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
	 * 在院整领
	 * @return FBoolean
	 */
	public FBoolean getFg_wholepack() {
		return ((FBoolean) getAttrVal("Fg_wholepack"));
	}	
	/**
	 * 在院整领
	 * @param Fg_wholepack
	 */
	public void setFg_wholepack(FBoolean Fg_wholepack) {
		setAttrVal("Fg_wholepack", Fg_wholepack);
	}
	/**
	 * 成组药医嘱包标识
	 * @return FBoolean
	 */
	public FBoolean getFg_group_pkg() {
		return ((FBoolean) getAttrVal("Fg_group_pkg"));
	}	
	/**
	 * 成组药医嘱包标识
	 * @param Fg_group_pkg
	 */
	public void setFg_group_pkg(FBoolean Fg_group_pkg) {
		setAttrVal("Fg_group_pkg", Fg_group_pkg);
	}
	/**
	 * 领药方式ID
	 * @return String
	 */
	public String getId_drug_delivery_method() {
		return ((String) getAttrVal("Id_drug_delivery_method"));
	}	
	/**
	 * 领药方式ID
	 * @param Id_drug_delivery_method
	 */
	public void setId_drug_delivery_method(String Id_drug_delivery_method) {
		setAttrVal("Id_drug_delivery_method", Id_drug_delivery_method);
	}
	/**
	 * 领药方式SD
	 * @return String
	 */
	public String getSd_drug_delivery_method() {
		return ((String) getAttrVal("Sd_drug_delivery_method"));
	}	
	/**
	 * 领药方式SD
	 * @param Sd_drug_delivery_method
	 */
	public void setSd_drug_delivery_method(String Sd_drug_delivery_method) {
		setAttrVal("Sd_drug_delivery_method", Sd_drug_delivery_method);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	/**
	 * 名称
	 * @param Srvtp_name
	 */
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getId_route_name() {
		return ((String) getAttrVal("Id_route_name"));
	}	
	/**
	 * 用法名称
	 * @param Id_route_name
	 */
	public void setId_route_name(String Id_route_name) {
		setAttrVal("Id_route_name", Id_route_name);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getId_freq_name() {
		return ((String) getAttrVal("Id_freq_name"));
	}	
	/**
	 * 频次名称
	 * @param Id_freq_name
	 */
	public void setId_freq_name(String Id_freq_name) {
		setAttrVal("Id_freq_name", Id_freq_name);
	}
	/**
	 * 领药方式名称
	 * @return String
	 */
	public String getName_drug_delivery_method() {
		return ((String) getAttrVal("Name_drug_delivery_method"));
	}	
	/**
	 * 领药方式名称
	 * @param Name_drug_delivery_method
	 */
	public void setName_drug_delivery_method(String Name_drug_delivery_method) {
		setAttrVal("Name_drug_delivery_method", Name_drug_delivery_method);
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
		return "Id_ele_orderkpg";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ELE_ORDERPKG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemOrderPkgDODesc.class);
	}
	
}