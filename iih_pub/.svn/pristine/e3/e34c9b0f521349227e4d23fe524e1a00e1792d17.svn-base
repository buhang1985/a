package iih.mp.nr.mpnuhandoverrpt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mpnuhandoverrpt.d.desc.MpNuHsWardDODesc;
import java.math.BigDecimal;

/**
 * 护理交接班病区汇总信息 DO数据 
 * 
 */
public class MpNuHsWardDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUHSWARD= "Id_nuhsward";
	public static final String ID_NUHS= "Id_nuhs";
	public static final String ID_NUHSWARDITEM= "Id_nuhswarditem";
	public static final String SD_NUHSWARDITEM= "Sd_nuhswarditem";
	public static final String VAL= "Val";
	public static final String NAME_NUHSWARDITEM= "Name_nuhswarditem";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nuhsward() {
		return ((String) getAttrVal("Id_nuhsward"));
	}	
	public void setId_nuhsward(String Id_nuhsward) {
		setAttrVal("Id_nuhsward", Id_nuhsward);
	}
	public String getId_nuhs() {
		return ((String) getAttrVal("Id_nuhs"));
	}	
	public void setId_nuhs(String Id_nuhs) {
		setAttrVal("Id_nuhs", Id_nuhs);
	}
	public String getId_nuhswarditem() {
		return ((String) getAttrVal("Id_nuhswarditem"));
	}	
	public void setId_nuhswarditem(String Id_nuhswarditem) {
		setAttrVal("Id_nuhswarditem", Id_nuhswarditem);
	}
	public String getSd_nuhswarditem() {
		return ((String) getAttrVal("Sd_nuhswarditem"));
	}	
	public void setSd_nuhswarditem(String Sd_nuhswarditem) {
		setAttrVal("Sd_nuhswarditem", Sd_nuhswarditem);
	}
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}	
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	public String getName_nuhswarditem() {
		return ((String) getAttrVal("Name_nuhswarditem"));
	}	
	public void setName_nuhswarditem(String Name_nuhswarditem) {
		setAttrVal("Name_nuhswarditem", Name_nuhswarditem);
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
		return "Id_nuhsward";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NU_HS_WARD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpNuHsWardDODesc.class);
	}
	
}