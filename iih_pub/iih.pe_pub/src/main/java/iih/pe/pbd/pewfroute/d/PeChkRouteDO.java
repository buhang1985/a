package iih.pe.pbd.pewfroute.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pbd.pewfroute.d.desc.PeChkRouteDODesc;
import java.math.BigDecimal;

/**
 * 体检检查路线次序 DO数据 
 * 
 */
public class PeChkRouteDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECHKROUTE= "Id_pechkroute";
	public static final String ID_PEWFROUTEDEF= "Id_pewfroutedef";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String CHK_ORDER= "Chk_order";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEPT= "Name_dept";
	public static final String CODE_DEPT= "Code_dept";
	public static final String CHKDURATION= "Chkduration";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pechkroute() {
		return ((String) getAttrVal("Id_pechkroute"));
	}	
	public void setId_pechkroute(String Id_pechkroute) {
		setAttrVal("Id_pechkroute", Id_pechkroute);
	}
	public String getId_pewfroutedef() {
		return ((String) getAttrVal("Id_pewfroutedef"));
	}	
	public void setId_pewfroutedef(String Id_pewfroutedef) {
		setAttrVal("Id_pewfroutedef", Id_pewfroutedef);
	}
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	public Integer getChk_order() {
		return ((Integer) getAttrVal("Chk_order"));
	}	
	public void setChk_order(Integer Chk_order) {
		setAttrVal("Chk_order", Chk_order);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	public Integer getChkduration() {
		return ((Integer) getAttrVal("Chkduration"));
	}	
	public void setChkduration(Integer Chkduration) {
		setAttrVal("Chkduration", Chkduration);
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
		return "Id_pechkroute";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_bd_chkroute";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChkRouteDODesc.class);
	}
	
}