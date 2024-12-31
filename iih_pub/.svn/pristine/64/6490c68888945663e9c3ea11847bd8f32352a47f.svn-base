package iih.pe.pitm.perstillness.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessDiDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病包含诊断 DO数据 
 * 
 */
public class PeRstIllnessDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERSTILLNESSDI= "Id_perstillnessdi";
	public static final String ID_PERSTILLNESS= "Id_perstillness";
	public static final String ID_PERSTDIDEF= "Id_perstdidef";
	public static final String SORTNO= "Sortno";
	public static final String CODE_DI= "Code_di";
	public static final String NAME_DI= "Name_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_perstillnessdi() {
		return ((String) getAttrVal("Id_perstillnessdi"));
	}	
	public void setId_perstillnessdi(String Id_perstillnessdi) {
		setAttrVal("Id_perstillnessdi", Id_perstillnessdi);
	}
	public String getId_perstillness() {
		return ((String) getAttrVal("Id_perstillness"));
	}	
	public void setId_perstillness(String Id_perstillness) {
		setAttrVal("Id_perstillness", Id_perstillness);
	}
	public String getId_perstdidef() {
		return ((String) getAttrVal("Id_perstdidef"));
	}	
	public void setId_perstdidef(String Id_perstdidef) {
		setAttrVal("Id_perstdidef", Id_perstdidef);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
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
		return "Id_perstillnessdi";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstillnessdi";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstIllnessDiDODesc.class);
	}
	
}