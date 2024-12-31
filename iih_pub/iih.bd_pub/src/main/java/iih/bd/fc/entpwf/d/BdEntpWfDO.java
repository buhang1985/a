package iih.bd.fc.entpwf.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.entpwf.d.desc.BdEntpWfDODesc;
import java.math.BigDecimal;

/**
 * 就诊流程定义 DO数据 
 * 
 */
public class BdEntpWfDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ENTPWF= "Id_entpwf";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENTP= "Id_entp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String SORTNO= "Sortno";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String DES= "Des";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String ENTY_CODE= "Enty_code";
	public static final String ENTY_NAME= "Enty_name";
	public static final String ENTPWF_CODE= "Entpwf_code";
	public static final String ENTPWF_NAME= "Entpwf_name";
	public static final String C_NAME= "C_name";
	public static final String C_CODE= "C_code";
	public static final String M_CODE= "M_code";
	public static final String M_NAME= "M_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_entpwf() {
		return ((String) getAttrVal("Id_entpwf"));
	}	
	public void setId_entpwf(String Id_entpwf) {
		setAttrVal("Id_entpwf", Id_entpwf);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getEnty_code() {
		return ((String) getAttrVal("Enty_code"));
	}	
	public void setEnty_code(String Enty_code) {
		setAttrVal("Enty_code", Enty_code);
	}
	public String getEnty_name() {
		return ((String) getAttrVal("Enty_name"));
	}	
	public void setEnty_name(String Enty_name) {
		setAttrVal("Enty_name", Enty_name);
	}
	public String getEntpwf_code() {
		return ((String) getAttrVal("Entpwf_code"));
	}	
	public void setEntpwf_code(String Entpwf_code) {
		setAttrVal("Entpwf_code", Entpwf_code);
	}
	public String getEntpwf_name() {
		return ((String) getAttrVal("Entpwf_name"));
	}	
	public void setEntpwf_name(String Entpwf_name) {
		setAttrVal("Entpwf_name", Entpwf_name);
	}
	public String getC_name() {
		return ((String) getAttrVal("C_name"));
	}	
	public void setC_name(String C_name) {
		setAttrVal("C_name", C_name);
	}
	public String getC_code() {
		return ((String) getAttrVal("C_code"));
	}	
	public void setC_code(String C_code) {
		setAttrVal("C_code", C_code);
	}
	public String getM_code() {
		return ((String) getAttrVal("M_code"));
	}	
	public void setM_code(String M_code) {
		setAttrVal("M_code", M_code);
	}
	public String getM_name() {
		return ((String) getAttrVal("M_name"));
	}	
	public void setM_name(String M_name) {
		setAttrVal("M_name", M_name);
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
		return "Id_entpwf";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_entp_wf";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdEntpWfDODesc.class);
	}
	
}