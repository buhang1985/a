package iih.pe.papt.pebarcode.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pebarcode.d.desc.PeBarcodeDODesc;
import java.math.BigDecimal;

/**
 * 体检接口_LIS团体条码 DO数据 
 * 
 */
public class PeBarcodeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BARCODE= "Id_barcode";
	public static final String FG_PSN= "Fg_psn";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String ID_PECORPBINFO= "Id_pecorpbinfo";
	public static final String ID_PECORPAPPT= "Id_pecorpappt";
	public static final String ID_PECORPAPPTGRP= "Id_pecorpapptgrp";
	public static final String PE_CODE= "Pe_code";
	public static final String DEPT_CODE= "Dept_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_barcode() {
		return ((String) getAttrVal("Id_barcode"));
	}	
	public void setId_barcode(String Id_barcode) {
		setAttrVal("Id_barcode", Id_barcode);
	}
	public FBoolean getFg_psn() {
		return ((FBoolean) getAttrVal("Fg_psn"));
	}	
	public void setFg_psn(FBoolean Fg_psn) {
		setAttrVal("Fg_psn", Fg_psn);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	public String getId_pecorpbinfo() {
		return ((String) getAttrVal("Id_pecorpbinfo"));
	}	
	public void setId_pecorpbinfo(String Id_pecorpbinfo) {
		setAttrVal("Id_pecorpbinfo", Id_pecorpbinfo);
	}
	public String getId_pecorpappt() {
		return ((String) getAttrVal("Id_pecorpappt"));
	}	
	public void setId_pecorpappt(String Id_pecorpappt) {
		setAttrVal("Id_pecorpappt", Id_pecorpappt);
	}
	public String getId_pecorpapptgrp() {
		return ((String) getAttrVal("Id_pecorpapptgrp"));
	}	
	public void setId_pecorpapptgrp(String Id_pecorpapptgrp) {
		setAttrVal("Id_pecorpapptgrp", Id_pecorpapptgrp);
	}
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
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
		return "Id_barcode";
	}
	
	@Override
	public String getTableName() {	  
		return "PE_APT_PEBARCODE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeBarcodeDODesc.class);
	}
	
}