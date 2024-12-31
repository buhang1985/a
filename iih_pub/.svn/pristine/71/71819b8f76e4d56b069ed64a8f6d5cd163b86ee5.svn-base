package iih.pe.pitm.pesetcopy.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pesetcopy.d.desc.PeSetCopyDODesc;
import java.math.BigDecimal;

/**
 * 体检套餐复制 DO数据 
 * 
 */
public class PeSetCopyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PESETCOPY= "Id_pesetcopy";
	public static final String ID_FROM= "Id_from";
	public static final String ID_TO= "Id_to";
	public static final String CODE_FROM= "Code_from";
	public static final String NAME_FROM= "Name_from";
	public static final String CODE_TO= "Code_to";
	public static final String NAME_TO= "Name_to";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pesetcopy() {
		return ((String) getAttrVal("Id_pesetcopy"));
	}	
	public void setId_pesetcopy(String Id_pesetcopy) {
		setAttrVal("Id_pesetcopy", Id_pesetcopy);
	}
	public String getId_from() {
		return ((String) getAttrVal("Id_from"));
	}	
	public void setId_from(String Id_from) {
		setAttrVal("Id_from", Id_from);
	}
	public String getId_to() {
		return ((String) getAttrVal("Id_to"));
	}	
	public void setId_to(String Id_to) {
		setAttrVal("Id_to", Id_to);
	}
	public String getCode_from() {
		return ((String) getAttrVal("Code_from"));
	}	
	public void setCode_from(String Code_from) {
		setAttrVal("Code_from", Code_from);
	}
	public String getName_from() {
		return ((String) getAttrVal("Name_from"));
	}	
	public void setName_from(String Name_from) {
		setAttrVal("Name_from", Name_from);
	}
	public String getCode_to() {
		return ((String) getAttrVal("Code_to"));
	}	
	public void setCode_to(String Code_to) {
		setAttrVal("Code_to", Code_to);
	}
	public String getName_to() {
		return ((String) getAttrVal("Name_to"));
	}	
	public void setName_to(String Name_to) {
		setAttrVal("Name_to", Name_to);
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
		return "Id_pesetcopy";
	}
	
	@Override
	public String getTableName() {	  
		return "";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeSetCopyDODesc.class);
	}
	
}