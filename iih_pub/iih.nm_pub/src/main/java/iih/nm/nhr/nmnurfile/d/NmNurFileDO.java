package iih.nm.nhr.nmnurfile.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmnurfile.d.desc.NmNurFileDODesc;
import java.math.BigDecimal;

/**
 * 文件附件 DO数据 
 * 
 */
public class NmNurFileDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUR_FILE= "Id_nur_file";
	public static final String ID_FILE_APP= "Id_file_app";
	public static final String NAME_FILE= "Name_file";
	public static final String URL= "Url";
	public static final String DT_UPLOAD= "Dt_upload";
	public static final String ID_PSN_UPLOAD= "Id_psn_upload";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PSN_UPLOAD= "Name_psn_upload";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nur_file() {
		return ((String) getAttrVal("Id_nur_file"));
	}	
	public void setId_nur_file(String Id_nur_file) {
		setAttrVal("Id_nur_file", Id_nur_file);
	}
	public String getId_file_app() {
		return ((String) getAttrVal("Id_file_app"));
	}	
	public void setId_file_app(String Id_file_app) {
		setAttrVal("Id_file_app", Id_file_app);
	}
	public String getName_file() {
		return ((String) getAttrVal("Name_file"));
	}	
	public void setName_file(String Name_file) {
		setAttrVal("Name_file", Name_file);
	}
	public String getUrl() {
		return ((String) getAttrVal("Url"));
	}	
	public void setUrl(String Url) {
		setAttrVal("Url", Url);
	}
	public FDateTime getDt_upload() {
		return ((FDateTime) getAttrVal("Dt_upload"));
	}	
	public void setDt_upload(FDateTime Dt_upload) {
		setAttrVal("Dt_upload", Dt_upload);
	}
	public String getId_psn_upload() {
		return ((String) getAttrVal("Id_psn_upload"));
	}	
	public void setId_psn_upload(String Id_psn_upload) {
		setAttrVal("Id_psn_upload", Id_psn_upload);
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
	public String getName_psn_upload() {
		return ((String) getAttrVal("Name_psn_upload"));
	}	
	public void setName_psn_upload(String Name_psn_upload) {
		setAttrVal("Name_psn_upload", Name_psn_upload);
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
		return "Id_nur_file";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_NUR_FILE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNurFileDODesc.class);
	}
	
}