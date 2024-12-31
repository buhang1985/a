package iih.bd.mhi.operatorupload.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mhi.operatorupload.d.desc.OperatorUploadDODesc;
import java.math.BigDecimal;

/**
 * 操作员上传 DO数据 
 * 
 */
public class OperatorUploadDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPERATORUPLOAD= "Id_operatorupload";
	public static final String ID_GROUP= "Id_group";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String DRID= "Drid";
	public static final String FG_UPLOAD= "Fg_upload";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID= "Id";
	public static final String SEX= "Sex";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_operatorupload() {
		return ((String) getAttrVal("Id_operatorupload"));
	}	
	public void setId_operatorupload(String Id_operatorupload) {
		setAttrVal("Id_operatorupload", Id_operatorupload);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public String getDrid() {
		return ((String) getAttrVal("Drid"));
	}	
	public void setDrid(String Drid) {
		setAttrVal("Drid", Drid);
	}
	public FBoolean getFg_upload() {
		return ((FBoolean) getAttrVal("Fg_upload"));
	}	
	public void setFg_upload(FBoolean Fg_upload) {
		setAttrVal("Fg_upload", Fg_upload);
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
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
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
		return "Id_operatorupload";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_PSNUP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperatorUploadDODesc.class);
	}
	
}