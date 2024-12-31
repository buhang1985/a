package iih.bl.pay.blspclpat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.blspclpat.d.desc.BlSpclItmPatDODesc;
import java.math.BigDecimal;

/**
 * 患者专用款明细 DO数据 
 * 
 */
public class BlSpclItmPatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SPCLITMPAT= "Id_spclitmpat";
	public static final String ID_SPCLPAT= "Id_spclpat";
	public static final String ID_PATSRVPKGITM= "Id_patsrvpkgitm";
	public static final String ID_SRV= "Id_srv";
	public static final String PRICE= "Price";
	public static final String QUAN= "Quan";
	public static final String SRVU= "Srvu";
	public static final String AMT= "Amt";
	public static final String QUAN_USE= "Quan_use";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_spclitmpat() {
		return ((String) getAttrVal("Id_spclitmpat"));
	}	
	public void setId_spclitmpat(String Id_spclitmpat) {
		setAttrVal("Id_spclitmpat", Id_spclitmpat);
	}
	public String getId_spclpat() {
		return ((String) getAttrVal("Id_spclpat"));
	}	
	public void setId_spclpat(String Id_spclpat) {
		setAttrVal("Id_spclpat", Id_spclpat);
	}
	public String getId_patsrvpkgitm() {
		return ((String) getAttrVal("Id_patsrvpkgitm"));
	}	
	public void setId_patsrvpkgitm(String Id_patsrvpkgitm) {
		setAttrVal("Id_patsrvpkgitm", Id_patsrvpkgitm);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	public FDouble getQuan() {
		return ((FDouble) getAttrVal("Quan"));
	}	
	public void setQuan(FDouble Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}	
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	public FDouble getQuan_use() {
		return ((FDouble) getAttrVal("Quan_use"));
	}	
	public void setQuan_use(FDouble Quan_use) {
		setAttrVal("Quan_use", Quan_use);
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
		return "Id_spclitmpat";
	}
	
	@Override
	public String getTableName() {	  
		return "BL_SPCL_ITM_PAT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlSpclItmPatDODesc.class);
	}
	
}