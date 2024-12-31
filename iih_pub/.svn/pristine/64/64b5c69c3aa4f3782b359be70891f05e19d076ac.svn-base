package iih.hr.hbd.psnfiles.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hr.hbd.psnfiles.d.desc.HbdPsnFilesDODesc;
import java.math.BigDecimal;

/**
 * 人员文件 DO数据 
 * 
 */
public class HbdPsnFilesDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PSN_FILE= "Id_psn_file";
	public static final String ID_FILE_APP= "Id_file_app";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NAME_FILE= "Name_file";
	public static final String URL= "Url";
	public static final String DT_UPLOAD= "Dt_upload";
	public static final String ID_PSN_UPLOAD= "Id_psn_upload";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_psn_file() {
		return ((String) getAttrVal("Id_psn_file"));
	}	
	public void setId_psn_file(String Id_psn_file) {
		setAttrVal("Id_psn_file", Id_psn_file);
	}
	public String getId_file_app() {
		return ((String) getAttrVal("Id_file_app"));
	}	
	public void setId_file_app(String Id_file_app) {
		setAttrVal("Id_file_app", Id_file_app);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
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
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_psn_file";
	}
	
	@Override
	public String getTableName() {	  
		return "HR_HBD_PSN_FILES";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HbdPsnFilesDODesc.class);
	}
	
}