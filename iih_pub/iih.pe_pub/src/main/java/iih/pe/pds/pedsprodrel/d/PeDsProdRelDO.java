package iih.pe.pds.pedsprodrel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pds.pedsprodrel.d.desc.PeDsProdRelDODesc;
import java.math.BigDecimal;

/**
 * 体检产品关联规则 DO数据 
 * 
 */
public class PeDsProdRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDSPRODREL= "Id_pedsprodrel";
	public static final String ID_PEDSPROD= "Id_pedsprod";
	public static final String CONFIDENCE= "Confidence";
	public static final String LIFT= "Lift";
	public static final String LEVERAGE= "Leverage";
	public static final String CONVICTION= "Conviction";
	public static final String SUPPORT= "Support";
	public static final String TRANSACTION= "Transaction";
	public static final String NOTE= "Note";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedsprodrel() {
		return ((String) getAttrVal("Id_pedsprodrel"));
	}	
	public void setId_pedsprodrel(String Id_pedsprodrel) {
		setAttrVal("Id_pedsprodrel", Id_pedsprodrel);
	}
	public String getId_pedsprod() {
		return ((String) getAttrVal("Id_pedsprod"));
	}	
	public void setId_pedsprod(String Id_pedsprod) {
		setAttrVal("Id_pedsprod", Id_pedsprod);
	}
	public FDouble getConfidence() {
		return ((FDouble) getAttrVal("Confidence"));
	}	
	public void setConfidence(FDouble Confidence) {
		setAttrVal("Confidence", Confidence);
	}
	public FDouble getLift() {
		return ((FDouble) getAttrVal("Lift"));
	}	
	public void setLift(FDouble Lift) {
		setAttrVal("Lift", Lift);
	}
	public FDouble getLeverage() {
		return ((FDouble) getAttrVal("Leverage"));
	}	
	public void setLeverage(FDouble Leverage) {
		setAttrVal("Leverage", Leverage);
	}
	public FDouble getConviction() {
		return ((FDouble) getAttrVal("Conviction"));
	}	
	public void setConviction(FDouble Conviction) {
		setAttrVal("Conviction", Conviction);
	}
	public FDouble getSupport() {
		return ((FDouble) getAttrVal("Support"));
	}	
	public void setSupport(FDouble Support) {
		setAttrVal("Support", Support);
	}
	public FDouble getTransaction() {
		return ((FDouble) getAttrVal("Transaction"));
	}	
	public void setTransaction(FDouble Transaction) {
		setAttrVal("Transaction", Transaction);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
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
		return "Id_pedsprodrel";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ds_pedsprodrel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDsProdRelDODesc.class);
	}
	
}