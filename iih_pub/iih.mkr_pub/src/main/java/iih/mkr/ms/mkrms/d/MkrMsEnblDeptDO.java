package iih.mkr.ms.mkrms.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mkr.ms.mkrms.d.desc.MkrMsEnblDeptDODesc;
import java.math.BigDecimal;

/**
 * 组套与适用科室关系 DO数据 
 * 
 */
public class MkrMsEnblDeptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MSDEPT= "Id_msdept";
	public static final String ID_MS= "Id_ms";
	public static final String ID_DEPT= "Id_dept";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_msdept() {
		return ((String) getAttrVal("Id_msdept"));
	}	
	public void setId_msdept(String Id_msdept) {
		setAttrVal("Id_msdept", Id_msdept);
	}
	public String getId_ms() {
		return ((String) getAttrVal("Id_ms"));
	}	
	public void setId_ms(String Id_ms) {
		setAttrVal("Id_ms", Id_ms);
	}
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
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
		return "Id_msdept";
	}
	
	@Override
	public String getTableName() {	  
		return "MKR_MS_ENBL_DEPT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MkrMsEnblDeptDODesc.class);
	}
	
}