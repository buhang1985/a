package iih.pi.card.iss.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.card.iss.d.desc.PiCardIssDODesc;
import java.math.BigDecimal;

/**
 * 就诊卡发放 DO数据 
 * 
 */
public class PiCardIssDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CARDISS= "Id_cardiss";
	public static final String EU_DIRECT= "Eu_direct";
	public static final String QUAN= "Quan";
	public static final String ID_EMP_GET= "Id_emp_get";
	public static final String ID_EMP_ISS= "Id_emp_iss";
	public static final String DT_ISS= "Dt_iss";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cardiss() {
		return ((String) getAttrVal("Id_cardiss"));
	}	
	public void setId_cardiss(String Id_cardiss) {
		setAttrVal("Id_cardiss", Id_cardiss);
	}
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	public Integer getQuan() {
		return ((Integer) getAttrVal("Quan"));
	}	
	public void setQuan(Integer Quan) {
		setAttrVal("Quan", Quan);
	}
	public String getId_emp_get() {
		return ((String) getAttrVal("Id_emp_get"));
	}	
	public void setId_emp_get(String Id_emp_get) {
		setAttrVal("Id_emp_get", Id_emp_get);
	}
	public String getId_emp_iss() {
		return ((String) getAttrVal("Id_emp_iss"));
	}	
	public void setId_emp_iss(String Id_emp_iss) {
		setAttrVal("Id_emp_iss", Id_emp_iss);
	}
	public FDateTime getDt_iss() {
		return ((FDateTime) getAttrVal("Dt_iss"));
	}	
	public void setDt_iss(FDateTime Dt_iss) {
		setAttrVal("Dt_iss", Dt_iss);
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
		return "Id_cardiss";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_card_iss";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiCardIssDODesc.class);
	}
	
}