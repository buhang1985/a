package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.desc.RegularOrCaDODesc;
import java.math.BigDecimal;

/**
 * 常规医嘱分类 DO数据 
 * 
 */
public class RegularOrCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REGULARORCA= "Id_regularorca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PARENT= "Name_parent";
	public static final String CODE_PARENT= "Code_parent";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_regularorca() {
		return ((String) getAttrVal("Id_regularorca"));
	}	
	public void setId_regularorca(String Id_regularorca) {
		setAttrVal("Id_regularorca", Id_regularorca);
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
	public String getName_parent() {
		return ((String) getAttrVal("Name_parent"));
	}	
	public void setName_parent(String Name_parent) {
		setAttrVal("Name_parent", Name_parent);
	}
	public String getCode_parent() {
		return ((String) getAttrVal("Code_parent"));
	}	
	public void setCode_parent(String Code_parent) {
		setAttrVal("Code_parent", Code_parent);
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
		return "Id_regularorca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_regularor_ca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RegularOrCaDODesc.class);
	}
	
}