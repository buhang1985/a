package iih.bd.srv.diagdef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.diagdef.d.desc.DiagAliasDODesc;
import java.math.BigDecimal;

/**
 * 诊断别名 DO数据 
 * 
 */
public class DiagAliasDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DIALS= "Id_dials";
	public static final String ID_DIDEF= "Id_didef";
	public static final String ALIAS= "Alias";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DI_CODE= "Di_code";
	public static final String DI_NAME= "Di_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dials() {
		return ((String) getAttrVal("Id_dials"));
	}	
	public void setId_dials(String Id_dials) {
		setAttrVal("Id_dials", Id_dials);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getAlias() {
		return ((String) getAttrVal("Alias"));
	}	
	public void setAlias(String Alias) {
		setAttrVal("Alias", Alias);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}	
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
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
		return "Id_dials";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_di_als";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DiagAliasDODesc.class);
	}
	
}