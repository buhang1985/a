package iih.pe.pitm.perstillness.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessFoodDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病关联饮食处方 DO数据 
 * 
 */
public class PeRstIllnessFoodDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERSTILLNESSFOOD= "Id_perstillnessfood";
	public static final String ID_PERSTILLNESS= "Id_perstillness";
	public static final String NAME5= "Name5";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_perstillnessfood() {
		return ((String) getAttrVal("Id_perstillnessfood"));
	}	
	public void setId_perstillnessfood(String Id_perstillnessfood) {
		setAttrVal("Id_perstillnessfood", Id_perstillnessfood);
	}
	public String getId_perstillness() {
		return ((String) getAttrVal("Id_perstillness"));
	}	
	public void setId_perstillness(String Id_perstillness) {
		setAttrVal("Id_perstillness", Id_perstillness);
	}
	public String getName5() {
		return ((String) getAttrVal("Name5"));
	}	
	public void setName5(String Name5) {
		setAttrVal("Name5", Name5);
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
		return "Id_perstillnessfood";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstillnessfood";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstIllnessFoodDODesc.class);
	}
	
}