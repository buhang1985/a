package iih.pe.papt.pepsnapptset.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pepsnapptset.d.desc.PePsnApptSetDODesc;
import java.math.BigDecimal;

/**
 * 体检个人预约套餐 DO数据 
 * 
 */
public class PePsnApptSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检预约套餐主键标识
	public static final String ID_PEPSNAPPTSET= "Id_pepsnapptset";
	//体检预约套餐父ID
	public static final String ID_PEPSNAPPTSET_PAR= "Id_pepsnapptset_par";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检团体预约分组ID
	public static final String ID_PECORPAPPTGRP= "Id_pecorpapptgrp";
	//体检套餐定义ID
	public static final String ID_PESRVSETDEF= "Id_pesrvsetdef";
	//体检项目ID
	public static final String ID_PESRVBCATLOG= "Id_pesrvbcatlog";
	//所属套餐ID
	public static final String ID_PESRVSETDEF_OWNER= "Id_pesrvsetdef_owner";
	//体检套餐项目区分标识
	public static final String FG_SETITEM= "Fg_setitem";
	//新增删除标识
	public static final String FG_OPER= "Fg_oper";
	//个人支付标识
	public static final String FG_PAYSELF= "Fg_payself";
	//个人团体标识
	public static final String FG_PSN= "Fg_psn";
	//折扣
	public static final String DISCOUNT= "Discount";
	//价格
	public static final String PRICE= "Price";
	//套餐项目类型
	public static final String ITEMTP= "Itemtp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检预约套餐主键标识
	 * @return String
	 */
	public String getId_pepsnapptset() {
		return ((String) getAttrVal("Id_pepsnapptset"));
	}	
	/**
	 * 体检预约套餐主键标识
	 * @param Id_pepsnapptset
	 */
	public void setId_pepsnapptset(String Id_pepsnapptset) {
		setAttrVal("Id_pepsnapptset", Id_pepsnapptset);
	}
	/**
	 * 体检预约套餐父ID
	 * @return String
	 */
	public String getId_pepsnapptset_par() {
		return ((String) getAttrVal("Id_pepsnapptset_par"));
	}	
	/**
	 * 体检预约套餐父ID
	 * @param Id_pepsnapptset_par
	 */
	public void setId_pepsnapptset_par(String Id_pepsnapptset_par) {
		setAttrVal("Id_pepsnapptset_par", Id_pepsnapptset_par);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检团体预约分组ID
	 * @return String
	 */
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}	
	/**
	 * 体检团体预约分组ID
	 * @param Id_pecorpapptgrp
	 */
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
	}
	/**
	 * 体检套餐定义ID
	 * @return String
	 */
	public String getId_pesrvsetdef() {
		return ((String) getAttrVal("Id_pesrvsetdef"));
	}	
	/**
	 * 体检套餐定义ID
	 * @param Id_pesrvsetdef
	 */
	public void setId_pesrvsetdef(String Id_pesrvsetdef) {
		setAttrVal("Id_pesrvsetdef", Id_pesrvsetdef);
	}
	/**
	 * 体检项目ID
	 * @return String
	 */
	public String getId_pesrvbcatlog() {
		return ((String) getAttrVal("Id_pesrvbcatlog"));
	}	
	/**
	 * 体检项目ID
	 * @param Id_pesrvbcatlog
	 */
	public void setId_pesrvbcatlog(String Id_pesrvbcatlog) {
		setAttrVal("Id_pesrvbcatlog", Id_pesrvbcatlog);
	}
	/**
	 * 所属套餐ID
	 * @return String
	 */
	public String getId_pesrvsetdef_owner() {
		return ((String) getAttrVal("Id_pesrvsetdef_owner"));
	}	
	/**
	 * 所属套餐ID
	 * @param Id_pesrvsetdef_owner
	 */
	public void setId_pesrvsetdef_owner(String Id_pesrvsetdef_owner) {
		setAttrVal("Id_pesrvsetdef_owner", Id_pesrvsetdef_owner);
	}
	/**
	 * 体检套餐项目区分标识
	 * @return FBoolean
	 */
	public FBoolean getFg_setitem() {
		return ((FBoolean) getAttrVal("Fg_setitem"));
	}	
	/**
	 * 体检套餐项目区分标识
	 * @param Fg_setitem
	 */
	public void setFg_setitem(FBoolean Fg_setitem) {
		setAttrVal("Fg_setitem", Fg_setitem);
	}
	/**
	 * 新增删除标识
	 * @return FBoolean
	 */
	public FBoolean getFg_oper() {
		return ((FBoolean) getAttrVal("Fg_oper"));
	}	
	/**
	 * 新增删除标识
	 * @param Fg_oper
	 */
	public void setFg_oper(FBoolean Fg_oper) {
		setAttrVal("Fg_oper", Fg_oper);
	}
	/**
	 * 个人支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_payself() {
		return ((FBoolean) getAttrVal("Fg_payself"));
	}	
	/**
	 * 个人支付标识
	 * @param Fg_payself
	 */
	public void setFg_payself(FBoolean Fg_payself) {
		setAttrVal("Fg_payself", Fg_payself);
	}
	/**
	 * 个人团体标识
	 * @return FBoolean
	 */
	public FBoolean getFg_psn() {
		return ((FBoolean) getAttrVal("Fg_psn"));
	}	
	/**
	 * 个人团体标识
	 * @param Fg_psn
	 */
	public void setFg_psn(FBoolean Fg_psn) {
		setAttrVal("Fg_psn", Fg_psn);
	}
	/**
	 * 折扣
	 * @return FDouble
	 */
	public FDouble getDiscount() {
		return ((FDouble) getAttrVal("Discount"));
	}	
	/**
	 * 折扣
	 * @param Discount
	 */
	public void setDiscount(FDouble Discount) {
		setAttrVal("Discount", Discount);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 套餐项目类型
	 * @return Integer
	 */
	public Integer getItemtp() {
		return ((Integer) getAttrVal("Itemtp"));
	}	
	/**
	 * 套餐项目类型
	 * @param Itemtp
	 */
	public void setItemtp(Integer Itemtp) {
		setAttrVal("Itemtp", Itemtp);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
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
		return "Id_pepsnapptset";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pepsnapptset";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnApptSetDODesc.class);
	}
	
}