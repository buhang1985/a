package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApDietDODesc;
import java.math.BigDecimal;

/**
 * 膳食申请单 DO数据 
 * 
 */
public class OrdApDietDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APDIET= "Id_apdiet";
	public static final String ID_OR= "Id_or";
	public static final String NO_APPLYFORM= "No_applyform";
	public static final String ID_DIETINDEXS= "Id_dietindexs";
	public static final String SD_DIETINDEXS= "Sd_dietindexs";
	public static final String NAME_DIETINDEXS= "Name_dietindexs";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apdiet() {
		return ((String) getAttrVal("Id_apdiet"));
	}	
	public void setId_apdiet(String Id_apdiet) {
		setAttrVal("Id_apdiet", Id_apdiet);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	public String getId_dietindexs() {
		return ((String) getAttrVal("Id_dietindexs"));
	}	
	public void setId_dietindexs(String Id_dietindexs) {
		setAttrVal("Id_dietindexs", Id_dietindexs);
	}
	public String getSd_dietindexs() {
		return ((String) getAttrVal("Sd_dietindexs"));
	}	
	public void setSd_dietindexs(String Sd_dietindexs) {
		setAttrVal("Sd_dietindexs", Sd_dietindexs);
	}
	public String getName_dietindexs() {
		return ((String) getAttrVal("Name_dietindexs"));
	}	
	public void setName_dietindexs(String Name_dietindexs) {
		setAttrVal("Name_dietindexs", Name_dietindexs);
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
		return "Id_apdiet";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_diet";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApDietDODesc.class);
	}
	
}