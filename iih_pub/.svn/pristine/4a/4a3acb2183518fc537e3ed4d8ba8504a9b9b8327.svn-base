package iih.pe.papt.pepsnitmsel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pepsnitmsel.d.desc.PePsnapptItmDODesc;
import java.math.BigDecimal;

/**
 * 体检个人预约项目 DO数据 
 * 
 */
public class PePsnapptItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPSNAPPTITM= "Id_pepsnapptitm";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String ID_PECORPAPPTGRP= "Id_pecorpapptgrp";
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	public static final String FG_ADD= "Fg_add";
	public static final String FG_PAYSELF= "Fg_payself";
	public static final String PRI_BASE= "Pri_base";
	public static final String PRI_ITM= "Pri_itm";
	public static final String DIS_ITM= "Dis_itm";
	public static final String QTY_ITM= "Qty_itm";
	public static final String AMT_ITM= "Amt_itm";
	public static final String CODE_SRVITM= "Code_srvitm";
	public static final String NAME_SRVITM= "Name_srvitm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepsnapptitm() {
		return ((String) getAttrVal("Id_pepsnapptitm"));
	}	
	public void setId_pepsnapptitm(String Id_pepsnapptitm) {
		setAttrVal("Id_pepsnapptitm", Id_pepsnapptitm);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}	
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
	}
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	public FBoolean getFg_add() {
		return ((FBoolean) getAttrVal("Fg_add"));
	}	
	public void setFg_add(FBoolean Fg_add) {
		setAttrVal("Fg_add", Fg_add);
	}
	public FBoolean getFg_payself() {
		return ((FBoolean) getAttrVal("Fg_payself"));
	}	
	public void setFg_payself(FBoolean Fg_payself) {
		setAttrVal("Fg_payself", Fg_payself);
	}
	public FDouble getPri_base() {
		return ((FDouble) getAttrVal("Pri_base"));
	}	
	public void setPri_base(FDouble Pri_base) {
		setAttrVal("Pri_base", Pri_base);
	}
	public FDouble getPri_itm() {
		return ((FDouble) getAttrVal("Pri_itm"));
	}	
	public void setPri_itm(FDouble Pri_itm) {
		setAttrVal("Pri_itm", Pri_itm);
	}
	public FDouble getDis_itm() {
		return ((FDouble) getAttrVal("Dis_itm"));
	}	
	public void setDis_itm(FDouble Dis_itm) {
		setAttrVal("Dis_itm", Dis_itm);
	}
	public FDouble getQty_itm() {
		return ((FDouble) getAttrVal("Qty_itm"));
	}	
	public void setQty_itm(FDouble Qty_itm) {
		setAttrVal("Qty_itm", Qty_itm);
	}
	public FDouble getAmt_itm() {
		return ((FDouble) getAttrVal("Amt_itm"));
	}	
	public void setAmt_itm(FDouble Amt_itm) {
		setAttrVal("Amt_itm", Amt_itm);
	}
	public String getCode_srvitm() {
		return ((String) getAttrVal("Code_srvitm"));
	}	
	public void setCode_srvitm(String Code_srvitm) {
		setAttrVal("Code_srvitm", Code_srvitm);
	}
	public String getName_srvitm() {
		return ((String) getAttrVal("Name_srvitm"));
	}	
	public void setName_srvitm(String Name_srvitm) {
		setAttrVal("Name_srvitm", Name_srvitm);
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
		return "Id_pepsnapptitm";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pepsnapptitm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsnapptItmDODesc.class);
	}
	
}