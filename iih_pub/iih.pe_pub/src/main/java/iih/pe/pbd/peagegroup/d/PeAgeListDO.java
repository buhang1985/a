package iih.pe.pbd.peagegroup.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.peagegroup.d.desc.PeAgeListDODesc;
import java.math.BigDecimal;

/**
 * 体检年龄分组明细 DO数据 
 * 
 */
public class PeAgeListDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEAGELIST= "Id_peagelist";
	public static final String ID_PEAGE= "Id_peage";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String AGE_BEGIN= "Age_begin";
	public static final String AGE_END= "Age_end";
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peagelist() {
		return ((String) getAttrVal("Id_peagelist"));
	}	
	public void setId_peagelist(String Id_peagelist) {
		setAttrVal("Id_peagelist", Id_peagelist);
	}
	public String getId_peage() {
		return ((String) getAttrVal("Id_peage"));
	}	
	public void setId_peage(String Id_peage) {
		setAttrVal("Id_peage", Id_peage);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getAge_begin() {
		return ((String) getAttrVal("Age_begin"));
	}	
	public void setAge_begin(String Age_begin) {
		setAttrVal("Age_begin", Age_begin);
	}
	public String getAge_end() {
		return ((String) getAttrVal("Age_end"));
	}	
	public void setAge_end(String Age_end) {
		setAttrVal("Age_end", Age_end);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_peagelist";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_peagelist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeAgeListDODesc.class);
	}
	
}