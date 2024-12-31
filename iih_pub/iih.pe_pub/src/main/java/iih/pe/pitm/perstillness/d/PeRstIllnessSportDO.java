package iih.pe.pitm.perstillness.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.perstillness.d.desc.PeRstIllnessSportDODesc;
import java.math.BigDecimal;

/**
 * 体检疾病关联运动处方 DO数据 
 * 
 */
public class PeRstIllnessSportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PERSTILLNESSSPORT= "Id_perstillnesssport";
	public static final String ID_PERSTILLNESS= "Id_perstillness";
	public static final String ID_PENSC= "Id_pensc";
	public static final String SORTNO= "Sortno";
	public static final String CODE_SPORT= "Code_sport";
	public static final String NAME_SPORT= "Name_sport";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_perstillnesssport() {
		return ((String) getAttrVal("Id_perstillnesssport"));
	}	
	public void setId_perstillnesssport(String Id_perstillnesssport) {
		setAttrVal("Id_perstillnesssport", Id_perstillnesssport);
	}
	public String getId_perstillness() {
		return ((String) getAttrVal("Id_perstillness"));
	}	
	public void setId_perstillness(String Id_perstillness) {
		setAttrVal("Id_perstillness", Id_perstillness);
	}
	public String getId_pensc() {
		return ((String) getAttrVal("Id_pensc"));
	}	
	public void setId_pensc(String Id_pensc) {
		setAttrVal("Id_pensc", Id_pensc);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode_sport() {
		return ((String) getAttrVal("Code_sport"));
	}	
	public void setCode_sport(String Code_sport) {
		setAttrVal("Code_sport", Code_sport);
	}
	public String getName_sport() {
		return ((String) getAttrVal("Name_sport"));
	}	
	public void setName_sport(String Name_sport) {
		setAttrVal("Name_sport", Name_sport);
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
		return "Id_perstillnesssport";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_perstillnesssport";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstIllnessSportDODesc.class);
	}
	
}