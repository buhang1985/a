package iih.pe.papt.pepsncatsel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pepsncatsel.d.desc.PePsnapptCatDODesc;
import java.math.BigDecimal;

/**
 * 体检个人预约项目 DO数据 
 * 
 */
public class PePsnapptCatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检个人预约项目主键标识
	public static final String ID_PEPSNAPPTCAT= "Id_pepsnapptcat";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检团体预约分组ID
	public static final String ID_PECORPAPPTGRP= "Id_pecorpapptgrp";
	//所属科室
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	//体检项目
	public static final String ID_PESRVCATLOG= "Id_pesrvcatlog";
	//加项标识
	public static final String FG_ADD= "Fg_add";
	//自付标识
	public static final String FG_PAYSELF= "Fg_payself";
	//基础价格
	public static final String PRI_BASE= "Pri_base";
	//实收价格
	public static final String PRI_CAT= "Pri_cat";
	//折扣
	public static final String DIS_CAT= "Dis_cat";
	//数量
	public static final String QTY_CAT= "Qty_cat";
	//金额
	public static final String AMT_CAT= "Amt_cat";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//个人标识
	public static final String FG_PSN= "Fg_psn";
	//收费标识
	public static final String FG_PAID= "Fg_paid";
	//申请传输标识
	public static final String FG_TRANS= "Fg_trans";
	//申请单号
	public static final String NO_APPLY= "No_apply";
	//条码号打印标识
	public static final String FG_BARCODE= "Fg_barcode";
	//条码号
	public static final String NO_BARCODE= "No_barcode";
	//医嘱单号
	public static final String ID_OR= "Id_or";
	//门诊收费标识
	public static final String FG_BL_PAY= "Fg_bl_pay";
	//门诊收费时间
	public static final String DT_BL_PAY= "Dt_bl_pay";
	//体检项目状态
	public static final String PECATLOGSTATUS= "Pecatlogstatus";
	//退费标识
	public static final String FG_RETURN= "Fg_return";
	//体检唯一码
	public static final String PE_CODE= "Pe_code";
	//后付费体检标识
	public static final String FG_NOPAY= "Fg_nopay";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//VIP标识
	public static final String FG_VIP= "Fg_vip";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//体检科室编码
	public static final String CODE_DEP= "Code_dep";
	//体检科室名称
	public static final String NAME_DEP= "Name_dep";
	//体检项目编码
	public static final String CODE_SRVITM= "Code_srvitm";
	//体检项目名称
	public static final String NAME_SRVITM= "Name_srvitm";
	//所属目录
	public static final String CATLOG_SRVITM= "Catlog_srvitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检个人预约项目主键标识
	 * @return String
	 */
	public String getId_pepsnapptcat() {
		return ((String) getAttrVal("Id_pepsnapptcat"));
	}	
	/**
	 * 体检个人预约项目主键标识
	 * @param Id_pepsnapptcat
	 */
	public void setId_pepsnapptcat(String Id_pepsnapptcat) {
		setAttrVal("Id_pepsnapptcat", Id_pepsnapptcat);
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
	 * 所属科室
	 * @return String
	 */
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	/**
	 * 所属科室
	 * @param Id_pedeptset
	 */
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	/**
	 * 体检项目
	 * @return String
	 */
	public String getId_pesrvcatlog() {
		return ((String) getAttrVal("Id_pesrvcatlog"));
	}	
	/**
	 * 体检项目
	 * @param Id_pesrvcatlog
	 */
	public void setId_pesrvcatlog(String Id_pesrvcatlog) {
		setAttrVal("Id_pesrvcatlog", Id_pesrvcatlog);
	}
	/**
	 * 加项标识
	 * @return FBoolean
	 */
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}	
	/**
	 * 加项标识
	 * @param Fg_add
	 */
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	/**
	 * 自付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_payself() {
		return ((FBoolean) getAttrVal("Fg_payself"));
	}	
	/**
	 * 自付标识
	 * @param Fg_payself
	 */
	public void setFg_payself(FBoolean Fg_payself) {
		setAttrVal("Fg_payself", Fg_payself);
	}
	/**
	 * 基础价格
	 * @return FDouble
	 */
	public FDouble getPri_base() {
		return ((FDouble) getAttrVal("Pri_base"));
	}	
	/**
	 * 基础价格
	 * @param Pri_base
	 */
	public void setPri_base(FDouble Pri_base) {
		setAttrVal("Pri_base", Pri_base);
	}
	/**
	 * 实收价格
	 * @return FDouble
	 */
	public FDouble getPri_cat() {
		return ((FDouble) getAttrVal("Pri_cat"));
	}	
	/**
	 * 实收价格
	 * @param Pri_cat
	 */
	public void setPri_cat(FDouble Pri_cat) {
		setAttrVal("Pri_cat", Pri_cat);
	}
	/**
	 * 折扣
	 * @return FDouble
	 */
	public FDouble getDis_cat() {
		return ((FDouble) getAttrVal("Dis_cat"));
	}	
	/**
	 * 折扣
	 * @param Dis_cat
	 */
	public void setDis_cat(FDouble Dis_cat) {
		setAttrVal("Dis_cat", Dis_cat);
	}
	/**
	 * 数量
	 * @return FDouble
	 */
	public FDouble getQty_cat() {
		return ((FDouble) getAttrVal("Qty_cat"));
	}	
	/**
	 * 数量
	 * @param Qty_cat
	 */
	public void setQty_cat(FDouble Qty_cat) {
		setAttrVal("Qty_cat", Qty_cat);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt_cat() {
		return ((FDouble) getAttrVal("Amt_cat"));
	}	
	/**
	 * 金额
	 * @param Amt_cat
	 */
	public void setAmt_cat(FDouble Amt_cat) {
		setAttrVal("Amt_cat", Amt_cat);
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
	/**
	 * 个人标识
	 * @return FBoolean
	 */
	public FBoolean getFg_psn() {
		return ((FBoolean) getAttrVal("Fg_psn"));
	}	
	/**
	 * 个人标识
	 * @param Fg_psn
	 */
	public void setFg_psn(FBoolean Fg_psn) {
		setAttrVal("Fg_psn", Fg_psn);
	}
	/**
	 * 收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_paid() {
		return ((FBoolean) getAttrVal("Fg_paid"));
	}	
	/**
	 * 收费标识
	 * @param Fg_paid
	 */
	public void setFg_paid(FBoolean Fg_paid) {
		setAttrVal("Fg_paid", Fg_paid);
	}
	/**
	 * 申请传输标识
	 * @return FBoolean
	 */
	public FBoolean getFg_trans() {
		return ((FBoolean) getAttrVal("Fg_trans"));
	}	
	/**
	 * 申请传输标识
	 * @param Fg_trans
	 */
	public void setFg_trans(FBoolean Fg_trans) {
		setAttrVal("Fg_trans", Fg_trans);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_apply() {
		return ((String) getAttrVal("No_apply"));
	}	
	/**
	 * 申请单号
	 * @param No_apply
	 */
	public void setNo_apply(String No_apply) {
		setAttrVal("No_apply", No_apply);
	}
	/**
	 * 条码号打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_barcode() {
		return ((FBoolean) getAttrVal("Fg_barcode"));
	}	
	/**
	 * 条码号打印标识
	 * @param Fg_barcode
	 */
	public void setFg_barcode(FBoolean Fg_barcode) {
		setAttrVal("Fg_barcode", Fg_barcode);
	}
	/**
	 * 条码号
	 * @return String
	 */
	public String getNo_barcode() {
		return ((String) getAttrVal("No_barcode"));
	}	
	/**
	 * 条码号
	 * @param No_barcode
	 */
	public void setNo_barcode(String No_barcode) {
		setAttrVal("No_barcode", No_barcode);
	}
	/**
	 * 医嘱单号
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱单号
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 门诊收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl_pay() {
		return ((FBoolean) getAttrVal("Fg_bl_pay"));
	}	
	/**
	 * 门诊收费标识
	 * @param Fg_bl_pay
	 */
	public void setFg_bl_pay(FBoolean Fg_bl_pay) {
		setAttrVal("Fg_bl_pay", Fg_bl_pay);
	}
	/**
	 * 门诊收费时间
	 * @return FDateTime
	 */
	public FDateTime getDt_bl_pay() {
		return ((FDateTime) getAttrVal("Dt_bl_pay"));
	}	
	/**
	 * 门诊收费时间
	 * @param Dt_bl_pay
	 */
	public void setDt_bl_pay(FDateTime Dt_bl_pay) {
		setAttrVal("Dt_bl_pay", Dt_bl_pay);
	}
	/**
	 * 体检项目状态
	 * @return Integer
	 */
	public Integer getPecatlogstatus() {
		return ((Integer) getAttrVal("Pecatlogstatus"));
	}	
	/**
	 * 体检项目状态
	 * @param Pecatlogstatus
	 */
	public void setPecatlogstatus(Integer Pecatlogstatus) {
		setAttrVal("Pecatlogstatus", Pecatlogstatus);
	}
	/**
	 * 退费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_return() {
		return ((FBoolean) getAttrVal("Fg_return"));
	}	
	/**
	 * 退费标识
	 * @param Fg_return
	 */
	public void setFg_return(FBoolean Fg_return) {
		setAttrVal("Fg_return", Fg_return);
	}
	/**
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 后付费体检标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nopay() {
		return ((FBoolean) getAttrVal("Fg_nopay"));
	}	
	/**
	 * 后付费体检标识
	 * @param Fg_nopay
	 */
	public void setFg_nopay(FBoolean Fg_nopay) {
		setAttrVal("Fg_nopay", Fg_nopay);
	}
	/**
	 * 体检时间
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * VIP标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * VIP标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 体检流程号
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	/**
	 * 体检流程号
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	/**
	 * 体检科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 体检科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 体检科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 体检科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 体检项目编码
	 * @return String
	 */
	public String getCode_srvitm() {
		return ((String) getAttrVal("Code_srvitm"));
	}	
	/**
	 * 体检项目编码
	 * @param Code_srvitm
	 */
	public void setCode_srvitm(String Code_srvitm) {
		setAttrVal("Code_srvitm", Code_srvitm);
	}
	/**
	 * 体检项目名称
	 * @return String
	 */
	public String getName_srvitm() {
		return ((String) getAttrVal("Name_srvitm"));
	}	
	/**
	 * 体检项目名称
	 * @param Name_srvitm
	 */
	public void setName_srvitm(String Name_srvitm) {
		setAttrVal("Name_srvitm", Name_srvitm);
	}
	/**
	 * 所属目录
	 * @return Integer
	 */
	public Integer getCatlog_srvitm() {
		return ((Integer) getAttrVal("Catlog_srvitm"));
	}	
	/**
	 * 所属目录
	 * @param Catlog_srvitm
	 */
	public void setCatlog_srvitm(Integer Catlog_srvitm) {
		setAttrVal("Catlog_srvitm", Catlog_srvitm);
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
		return "Id_pepsnapptcat";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pepsnapptcat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnapptCatDODesc.class);
	}
	
}