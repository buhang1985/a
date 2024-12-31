package iih.pe.pds.pedsprodrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pds.pedsprodrel.d.desc.PeDsProdRelDtlDODesc;
import java.math.BigDecimal;

/**
 * 体检产品关联规则明细 DO数据 
 * 
 */
public class PeDsProdRelDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDSPRODRELDTL= "Id_pedsprodreldtl";
	public static final String ID_PEDSPRODRELDTL_PAR= "Id_pedsprodreldtl_par";
	public static final String ID_PEDSPRODREL= "Id_pedsprodrel";
	public static final String CORRELATIVE= "Correlative";
	public static final String CODE= "Code";
	public static final String VAL= "Val";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedsprodreldtl() {
		return ((String) getAttrVal("Id_pedsprodreldtl"));
	}	
	public void setId_pedsprodreldtl(String Id_pedsprodreldtl) {
		setAttrVal("Id_pedsprodreldtl", Id_pedsprodreldtl);
	}
	public String getId_pedsprodreldtl_par() {
		return ((String) getAttrVal("Id_pedsprodreldtl_par"));
	}	
	public void setId_pedsprodreldtl_par(String Id_pedsprodreldtl_par) {
		setAttrVal("Id_pedsprodreldtl_par", Id_pedsprodreldtl_par);
	}
	public String getId_pedsprodrel() {
		return ((String) getAttrVal("Id_pedsprodrel"));
	}	
	public void setId_pedsprodrel(String Id_pedsprodrel) {
		setAttrVal("Id_pedsprodrel", Id_pedsprodrel);
	}
	public FBoolean getCorrelative() {
		return ((FBoolean) getAttrVal("Correlative"));
	}	
	public void setCorrelative(FBoolean Correlative) {
		setAttrVal("Correlative", Correlative);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
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
		return "Id_pedsprodreldtl";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ds_pedsprodreldtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDsProdRelDtlDODesc.class);
	}
	
}