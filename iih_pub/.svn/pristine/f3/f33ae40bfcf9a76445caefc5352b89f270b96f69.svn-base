package iih.mp.ne.transfusion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.ne.transfusion.d.desc.NeBtrReaDODesc;
import java.math.BigDecimal;

/**
 * 输血记录输血反应 DO数据 
 * 
 */
public class NeBtrReaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NEBTRREA= "Id_nebtrrea";
	public static final String ID_NEBTR= "Id_nebtr";
	public static final String ID_REA_CODE= "Id_rea_code";
	public static final String SD_REA_CODE= "Sd_rea_code";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nebtrrea() {
		return ((String) getAttrVal("Id_nebtrrea"));
	}	
	public void setId_nebtrrea(String Id_nebtrrea) {
		setAttrVal("Id_nebtrrea", Id_nebtrrea);
	}
	public String getId_nebtr() {
		return ((String) getAttrVal("Id_nebtr"));
	}	
	public void setId_nebtr(String Id_nebtr) {
		setAttrVal("Id_nebtr", Id_nebtr);
	}
	public String getId_rea_code() {
		return ((String) getAttrVal("Id_rea_code"));
	}	
	public void setId_rea_code(String Id_rea_code) {
		setAttrVal("Id_rea_code", Id_rea_code);
	}
	public String getSd_rea_code() {
		return ((String) getAttrVal("Sd_rea_code"));
	}	
	public void setSd_rea_code(String Sd_rea_code) {
		setAttrVal("Sd_rea_code", Sd_rea_code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
		return "Id_nebtrrea";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NE_BTR_REA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NeBtrReaDODesc.class);
	}
	
}