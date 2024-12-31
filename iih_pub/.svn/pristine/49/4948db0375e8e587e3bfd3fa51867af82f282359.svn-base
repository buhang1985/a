package iih.bd.srv.medvalidate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.medvalidate.d.desc.BDErrorInfoItemDODesc;
import java.math.BigDecimal;

/**
 * 基础数据错误信息物品表 DO数据 
 * 
 */
public class BDErrorInfoItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ERRORINFO_ITEM= "Id_errorinfo_item";
	public static final String ID_ERRORINFO= "Id_errorinfo";
	public static final String ID_ITEM= "Id_item";
	public static final String NAME_ITEM= "Name_item";
	public static final String ERROR_INFO= "Error_info";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_errorinfo_item() {
		return ((String) getAttrVal("Id_errorinfo_item"));
	}	
	public void setId_errorinfo_item(String Id_errorinfo_item) {
		setAttrVal("Id_errorinfo_item", Id_errorinfo_item);
	}
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
		return "Id_errorinfo_item";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_errorinfo_item";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BDErrorInfoItemDODesc.class);
	}
	
}