package iih.bd.srv.medvalidate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medvalidate.d.desc.BDErrorInfoDODesc;
import java.math.BigDecimal;

/**
 * 基础数据校验服务表 DO数据 
 * 
 */
public class BDErrorInfoDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ERRORINFO= "Id_errorinfo";
	public static final String ID_ITEM= "Id_item";
	public static final String TYPE= "Type";
	public static final String NAME_ITEM= "Name_item";
	public static final String ERROR_INFO= "Error_info";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_errorinfo() {
		return ((String) getAttrVal("Id_errorinfo"));
	}	
	public void setId_errorinfo(String Id_errorinfo) {
		setAttrVal("Id_errorinfo", Id_errorinfo);
	}
	public String getId_item() {
		return ((String) getAttrVal("Id_item"));
	}	
	public void setId_item(String Id_item) {
		setAttrVal("Id_item", Id_item);
	}
	public String getType() {
		return ((String) getAttrVal("Type"));
	}	
	public void setType(String Type) {
		setAttrVal("Type", Type);
	}
	public String getName_item() {
		return ((String) getAttrVal("Name_item"));
	}	
	public void setName_item(String Name_item) {
		setAttrVal("Name_item", Name_item);
	}
	public String getError_info() {
		return ((String) getAttrVal("Error_info"));
	}	
	public void setError_info(String Error_info) {
		setAttrVal("Error_info", Error_info);
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
		return "Id_errorinfo";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_errorinfo";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BDErrorInfoDODesc.class);
	}
	
}