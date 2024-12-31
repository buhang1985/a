package iih.mp.mpbd.mpmbhfunca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mpmbhfunca.d.desc.MpMbhAppCaDODesc;

/**
 * 移动医疗app功能分类 DO数据 
 * 
 */
public class MpMbhAppCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MBH_APP_FUNCA= "Id_mbh_app_funca";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String SNO= "Sno";
	public static final String ID_MBH_APP= "Id_mbh_app";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String APP_NAME= "App_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mbh_app_funca() {
		return ((String) getAttrVal("Id_mbh_app_funca"));
	}	
	public void setId_mbh_app_funca(String Id_mbh_app_funca) {
		setAttrVal("Id_mbh_app_funca", Id_mbh_app_funca);
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
	public String getSno() {
		return ((String) getAttrVal("Sno"));
	}	
	public void setSno(String Sno) {
		setAttrVal("Sno", Sno);
	}
	public String getId_mbh_app() {
		return ((String) getAttrVal("Id_mbh_app"));
	}	
	public void setId_mbh_app(String Id_mbh_app) {
		setAttrVal("Id_mbh_app", Id_mbh_app);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
	public String getApp_name() {
		return ((String) getAttrVal("App_name"));
	}	
	public void setApp_name(String App_name) {
		setAttrVal("App_name", App_name);
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
		return "Id_mbh_app_funca";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mbh_app_ca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpMbhAppCaDODesc.class);
	}
	
}