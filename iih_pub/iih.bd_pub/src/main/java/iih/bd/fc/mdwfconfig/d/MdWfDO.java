package iih.bd.fc.mdwfconfig.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.mdwfconfig.d.desc.MdWfDODesc;
import java.math.BigDecimal;

/**
 * 医嘱流向 DO数据 
 * 
 */
public class MdWfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WF= "Id_wf";
	public static final String ID_WFCA= "Id_wfca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SD_WFTP= "Sd_wftp";
	public static final String ID_WFTP= "Id_wftp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WFCA_NAME= "Wfca_name";
	public static final String WFCA_CODE= "Wfca_code";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String WFTP_CODE= "Wftp_code";
	public static final String WFTP_NAME= "Wftp_name";
	public static final String CREATE_NAME= "Create_name";
	public static final String CREATE_CODE= "Create_code";
	public static final String MODI_NAME= "Modi_name";
	public static final String MODI_CODE= "Modi_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}	
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
	}
	public String getId_wfca() {
		return ((String) getAttrVal("Id_wfca"));
	}	
	public void setId_wfca(String Id_wfca) {
		setAttrVal("Id_wfca", Id_wfca);
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
	public String getSd_wftp() {
		return ((String) getAttrVal("Sd_wftp"));
	}	
	public void setSd_wftp(String Sd_wftp) {
		setAttrVal("Sd_wftp", Sd_wftp);
	}
	public String getId_wftp() {
		return ((String) getAttrVal("Id_wftp"));
	}	
	public void setId_wftp(String Id_wftp) {
		setAttrVal("Id_wftp", Id_wftp);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	public String getWfca_name() {
		return ((String) getAttrVal("Wfca_name"));
	}	
	public void setWfca_name(String Wfca_name) {
		setAttrVal("Wfca_name", Wfca_name);
	}
	public String getWfca_code() {
		return ((String) getAttrVal("Wfca_code"));
	}	
	public void setWfca_code(String Wfca_code) {
		setAttrVal("Wfca_code", Wfca_code);
	}
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getWftp_code() {
		return ((String) getAttrVal("Wftp_code"));
	}	
	public void setWftp_code(String Wftp_code) {
		setAttrVal("Wftp_code", Wftp_code);
	}
	public String getWftp_name() {
		return ((String) getAttrVal("Wftp_name"));
	}	
	public void setWftp_name(String Wftp_name) {
		setAttrVal("Wftp_name", Wftp_name);
	}
	public String getCreate_name() {
		return ((String) getAttrVal("Create_name"));
	}	
	public void setCreate_name(String Create_name) {
		setAttrVal("Create_name", Create_name);
	}
	public String getCreate_code() {
		return ((String) getAttrVal("Create_code"));
	}	
	public void setCreate_code(String Create_code) {
		setAttrVal("Create_code", Create_code);
	}
	public String getModi_name() {
		return ((String) getAttrVal("Modi_name"));
	}	
	public void setModi_name(String Modi_name) {
		setAttrVal("Modi_name", Modi_name);
	}
	public String getModi_code() {
		return ((String) getAttrVal("Modi_code"));
	}	
	public void setModi_code(String Modi_code) {
		setAttrVal("Modi_code", Modi_code);
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
		return "Id_wf";
	}
	
	@Override
	public String getTableName() {	  
		return "md_wf";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MdWfDODesc.class);
	}
	
}