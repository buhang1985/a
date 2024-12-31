package iih.mp.mpbd.mpmbhfunca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mpmbhfunca.d.desc.MpMbhAppFunDODesc;

/**
 * 移动医疗app功能 DO数据 
 * 
 */
public class MpMbhAppFunDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MBH_APP_FUN= "Id_mbh_app_fun";
	public static final String ID_MBH_APP_FUNCA= "Id_mbh_app_funca";
	public static final String ID_FUN= "Id_fun";
	public static final String FUNCODE= "Funcode";
	public static final String NAME_FUN= "Name_fun";
	public static final String SNO= "Sno";
	public static final String ICON= "Icon";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FUNCA_NAME= "Funca_name";
	public static final String FUN_CODE= "Fun_code";
	public static final String FUN_NAME= "Fun_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mbh_app_fun() {
		return ((String) getAttrVal("Id_mbh_app_fun"));
	}	
	public void setId_mbh_app_fun(String Id_mbh_app_fun) {
		setAttrVal("Id_mbh_app_fun", Id_mbh_app_fun);
	}
	public String getId_mbh_app_funca() {
		return ((String) getAttrVal("Id_mbh_app_funca"));
	}	
	public void setId_mbh_app_funca(String Id_mbh_app_funca) {
		setAttrVal("Id_mbh_app_funca", Id_mbh_app_funca);
	}
	public String getId_fun() {
		return ((String) getAttrVal("Id_fun"));
	}	
	public void setId_fun(String Id_fun) {
		setAttrVal("Id_fun", Id_fun);
	}
	public String getFuncode() {
		return ((String) getAttrVal("Funcode"));
	}	
	public void setFuncode(String Funcode) {
		setAttrVal("Funcode", Funcode);
	}
	public String getName_fun() {
		return ((String) getAttrVal("Name_fun"));
	}	
	public void setName_fun(String Name_fun) {
		setAttrVal("Name_fun", Name_fun);
	}
	public String getSno() {
		return ((String) getAttrVal("Sno"));
	}	
	public void setSno(String Sno) {
		setAttrVal("Sno", Sno);
	}
	public String getIcon() {
		return ((String) getAttrVal("Icon"));
	}	
	public void setIcon(String Icon) {
		setAttrVal("Icon", Icon);
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
	public String getFunca_name() {
		return ((String) getAttrVal("Funca_name"));
	}	
	public void setFunca_name(String Funca_name) {
		setAttrVal("Funca_name", Funca_name);
	}
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}	
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	public String getFun_name() {
		return ((String) getAttrVal("Fun_name"));
	}	
	public void setFun_name(String Fun_name) {
		setAttrVal("Fun_name", Fun_name);
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
		return "Id_mbh_app_fun";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_mbh_app_fun";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpMbhAppFunDODesc.class);
	}
	
}