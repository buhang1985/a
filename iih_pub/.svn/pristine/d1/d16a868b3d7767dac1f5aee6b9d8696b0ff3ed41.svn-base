package iih.bd.fc.triageres.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.triageres.d.desc.TriageResDODesc;
import java.math.BigDecimal;

/**
 * 检伤判定 DO数据 
 * 
 */
public class TriageResDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_TRIAGERES= "Id_triageres";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String ID_TRIAGCMPT= "Id_triagcmpt";
	public static final String ID_SCALE= "Id_scale";
	public static final String SD_SCALE= "Sd_scale";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String TRIAGCMPT_NAME= "Triagcmpt_name";
	public static final String SCALE_NAME= "Scale_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_triageres() {
		return ((String) getAttrVal("Id_triageres"));
	}	
	public void setId_triageres(String Id_triageres) {
		setAttrVal("Id_triageres", Id_triageres);
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
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getId_triagcmpt() {
		return ((String) getAttrVal("Id_triagcmpt"));
	}	
	public void setId_triagcmpt(String Id_triagcmpt) {
		setAttrVal("Id_triagcmpt", Id_triagcmpt);
	}
	public String getId_scale() {
		return ((String) getAttrVal("Id_scale"));
	}	
	public void setId_scale(String Id_scale) {
		setAttrVal("Id_scale", Id_scale);
	}
	public String getSd_scale() {
		return ((String) getAttrVal("Sd_scale"));
	}	
	public void setSd_scale(String Sd_scale) {
		setAttrVal("Sd_scale", Sd_scale);
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
	public String getTriagcmpt_name() {
		return ((String) getAttrVal("Triagcmpt_name"));
	}	
	public void setTriagcmpt_name(String Triagcmpt_name) {
		setAttrVal("Triagcmpt_name", Triagcmpt_name);
	}
	public String getScale_name() {
		return ((String) getAttrVal("Scale_name"));
	}	
	public void setScale_name(String Scale_name) {
		setAttrVal("Scale_name", Scale_name);
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
		return "Id_triageres";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_TRIAGE_RES";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TriageResDODesc.class);
	}
	
}