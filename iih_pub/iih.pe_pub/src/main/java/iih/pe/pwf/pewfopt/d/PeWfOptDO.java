package iih.pe.pwf.pewfopt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pewfopt.d.desc.PeWfOptDODesc;
import java.math.BigDecimal;

/**
 * 体检流程选项 DO数据 
 * 
 */
public class PeWfOptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEWFOPT= "Id_pewfopt";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String ID_PEWFOPTIONDEF= "Id_pewfoptiondef";
	public static final String RST_OPT= "Rst_opt";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_OPT= "Code_opt";
	public static final String NAME_OPT= "Name_opt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pewfopt() {
		return ((String) getAttrVal("Id_pewfopt"));
	}	
	public void setId_pewfopt(String Id_pewfopt) {
		setAttrVal("Id_pewfopt", Id_pewfopt);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	public String getId_pewfoptiondef() {
		return ((String) getAttrVal("Id_pewfoptiondef"));
	}	
	public void setId_pewfoptiondef(String Id_pewfoptiondef) {
		setAttrVal("Id_pewfoptiondef", Id_pewfoptiondef);
	}
	public FBoolean getRst_opt() {
		return ((FBoolean) getAttrVal("Rst_opt"));
	}	
	public void setRst_opt(FBoolean Rst_opt) {
		setAttrVal("Rst_opt", Rst_opt);
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
	public String getCode_opt() {
		return ((String) getAttrVal("Code_opt"));
	}	
	public void setCode_opt(String Code_opt) {
		setAttrVal("Code_opt", Code_opt);
	}
	public String getName_opt() {
		return ((String) getAttrVal("Name_opt"));
	}	
	public void setName_opt(String Name_opt) {
		setAttrVal("Name_opt", Name_opt);
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
		return "Id_pewfopt";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_pewfopt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeWfOptDODesc.class);
	}
	
}