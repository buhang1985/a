package iih.pe.pitm.perstillness.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessItemDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病包含项目 DO数据 
 * 
 */
public class PeRstIllnessItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERSTILLNESSITEM= "Id_perstillnessitem";
	public static final String ID_PERSTILLNESS= "Id_perstillness";
	public static final String ID_PESRVITEM= "Id_pesrvitem";
	public static final String SORTNO= "Sortno";
	public static final String CODE_ITM= "Code_itm";
	public static final String NAME_ITM= "Name_itm";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_perstillnessitem() {
		return ((String) getAttrVal("Id_perstillnessitem"));
	}	
	public void setId_perstillnessitem(String Id_perstillnessitem) {
		setAttrVal("Id_perstillnessitem", Id_perstillnessitem);
	}
	public String getId_perstillness() {
		return ((String) getAttrVal("Id_perstillness"));
	}	
	public void setId_perstillness(String Id_perstillness) {
		setAttrVal("Id_perstillness", Id_perstillness);
	}
	public String getId_pesrvitem() {
		return ((String) getAttrVal("Id_pesrvitem"));
	}	
	public void setId_pesrvitem(String Id_pesrvitem) {
		setAttrVal("Id_pesrvitem", Id_pesrvitem);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode_itm() {
		return ((String) getAttrVal("Code_itm"));
	}	
	public void setCode_itm(String Code_itm) {
		setAttrVal("Code_itm", Code_itm);
	}
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}	
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
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
		return "Id_perstillnessitem";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstillnessitem";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstIllnessItemDODesc.class);
	}
	
}