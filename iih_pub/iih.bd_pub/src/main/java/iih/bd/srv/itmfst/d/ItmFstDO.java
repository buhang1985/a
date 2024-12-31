package iih.bd.srv.itmfst.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.itmfst.d.desc.ItmFstDODesc;
import java.math.BigDecimal;

/**
 * 质控项目一级分类 DO数据 
 * 
 */
public class ItmFstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_FST= "Id_fst";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String SCORE= "Score";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String ID_ENTP= "Id_entp";
	public static final String DOCORNUR= "Docornur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String GRP_CODE= "Grp_code";
	public static final String GRP_NAME= "Grp_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String ENTP_NAME= "Entp_name";
	public static final String ENTP_CODE= "Entp_code";
	public static final String CREATEBY_NAME= "Createby_name";
	public static final String CREATEBY_CODE= "Createby_code";
	public static final String MODIFIEDBY_NAME= "Modifiedby_name";
	public static final String MODIFIEDBY_CODE= "Modifiedby_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_fst() {
		return ((String) getAttrVal("Id_fst"));
	}	
	public void setId_fst(String Id_fst) {
		setAttrVal("Id_fst", Id_fst);
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
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
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
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public Integer getDocornur() {
		return ((Integer) getAttrVal("Docornur"));
	}	
	public void setDocornur(Integer Docornur) {
		setAttrVal("Docornur", Docornur);
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
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	public String getCreateby_name() {
		return ((String) getAttrVal("Createby_name"));
	}	
	public void setCreateby_name(String Createby_name) {
		setAttrVal("Createby_name", Createby_name);
	}
	public String getCreateby_code() {
		return ((String) getAttrVal("Createby_code"));
	}	
	public void setCreateby_code(String Createby_code) {
		setAttrVal("Createby_code", Createby_code);
	}
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}	
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	public String getModifiedby_code() {
		return ((String) getAttrVal("Modifiedby_code"));
	}	
	public void setModifiedby_code(String Modifiedby_code) {
		setAttrVal("Modifiedby_code", Modifiedby_code);
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
		return "Id_fst";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_qa_itm_fst";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ItmFstDODesc.class);
	}
	
}