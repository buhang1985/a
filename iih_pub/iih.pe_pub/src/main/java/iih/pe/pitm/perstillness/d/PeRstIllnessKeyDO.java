package iih.pe.pitm.perstillness.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessKeyDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病定义关键字 DO数据 
 * 
 */
public class PeRstIllnessKeyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERSTILLNESSKEY= "Id_perstillnesskey";
	public static final String ID_PERSTILLNESS= "Id_perstillness";
	public static final String INCKEYWORD= "Inckeyword";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_perstillnesskey() {
		return ((String) getAttrVal("Id_perstillnesskey"));
	}	
	public void setId_perstillnesskey(String Id_perstillnesskey) {
		setAttrVal("Id_perstillnesskey", Id_perstillnesskey);
	}
	public String getId_perstillness() {
		return ((String) getAttrVal("Id_perstillness"));
	}	
	public void setId_perstillness(String Id_perstillness) {
		setAttrVal("Id_perstillness", Id_perstillness);
	}
	public String getInckeyword() {
		return ((String) getAttrVal("Inckeyword"));
	}	
	public void setInckeyword(String Inckeyword) {
		setAttrVal("Inckeyword", Inckeyword);
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
		return "Id_perstillnesskey";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstillnesskey";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstIllnessKeyDODesc.class);
	}
	
}