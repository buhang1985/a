package iih.bd.fc.wf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.wf.d.desc.WfDODesc;
import java.math.BigDecimal;

/**
 * 医嘱流向 DO数据 
 * 
 */
public class WfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WF= "Id_wf";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String EU_WFTP= "Eu_wftp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String WF_CODE= "Wf_code";
	public static final String WF_NAME= "Wf_name";
	public static final String CODE_SRVTP= "Code_srvtp";
	public static final String NAME_SRVTP= "Name_srvtp";
	public static final String NAME_CTREATE= "Name_ctreate";
	public static final String CODE_CREATE= "Code_create";
	public static final String NAME_MODIFY= "Name_modify";
	public static final String CODE_MODIFY= "Code_modify";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}	
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
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
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}	
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
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
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
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
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
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
	public String getWf_code() {
		return ((String) getAttrVal("Wf_code"));
	}	
	public void setWf_code(String Wf_code) {
		setAttrVal("Wf_code", Wf_code);
	}
	public String getWf_name() {
		return ((String) getAttrVal("Wf_name"));
	}	
	public void setWf_name(String Wf_name) {
		setAttrVal("Wf_name", Wf_name);
	}
	public String getCode_srvtp() {
		return ((String) getAttrVal("Code_srvtp"));
	}	
	public void setCode_srvtp(String Code_srvtp) {
		setAttrVal("Code_srvtp", Code_srvtp);
	}
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}	
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	public String getName_ctreate() {
		return ((String) getAttrVal("Name_ctreate"));
	}	
	public void setName_ctreate(String Name_ctreate) {
		setAttrVal("Name_ctreate", Name_ctreate);
	}
	public String getCode_create() {
		return ((String) getAttrVal("Code_create"));
	}	
	public void setCode_create(String Code_create) {
		setAttrVal("Code_create", Code_create);
	}
	public String getName_modify() {
		return ((String) getAttrVal("Name_modify"));
	}	
	public void setName_modify(String Name_modify) {
		setAttrVal("Name_modify", Name_modify);
	}
	public String getCode_modify() {
		return ((String) getAttrVal("Code_modify"));
	}	
	public void setCode_modify(String Code_modify) {
		setAttrVal("Code_modify", Code_modify);
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
		return "BD_WF";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(WfDODesc.class);
	}
	
}