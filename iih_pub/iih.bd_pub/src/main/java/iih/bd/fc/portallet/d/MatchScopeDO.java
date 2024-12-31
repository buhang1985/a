package iih.bd.fc.portallet.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.portallet.d.desc.MatchScopeDODesc;
import java.math.BigDecimal;

/**
 * 仪表板使用范围 DO数据 
 * 
 */
public class MatchScopeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MTHSCP= "Id_mthscp";
	public static final String ID_PORTALLET= "Id_portallet";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP= "Id_dep";
	public static final String EU_PSNTP= "Eu_psntp";
	public static final String ID_BASEDOC= "Id_basedoc";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_DI= "Id_di";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CREATE_NAME= "Create_name";
	public static final String MODIFY_NAME= "Modify_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mthscp() {
		return ((String) getAttrVal("Id_mthscp"));
	}	
	public void setId_mthscp(String Id_mthscp) {
		setAttrVal("Id_mthscp", Id_mthscp);
	}
	public String getId_portallet() {
		return ((String) getAttrVal("Id_portallet"));
	}	
	public void setId_portallet(String Id_portallet) {
		setAttrVal("Id_portallet", Id_portallet);
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
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public Integer getEu_psntp() {
		return ((Integer) getAttrVal("Eu_psntp"));
	}	
	public void setEu_psntp(Integer Eu_psntp) {
		setAttrVal("Eu_psntp", Eu_psntp);
	}
	public String getId_basedoc() {
		return ((String) getAttrVal("Id_basedoc"));
	}	
	public void setId_basedoc(String Id_basedoc) {
		setAttrVal("Id_basedoc", Id_basedoc);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
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
	public String getCreate_name() {
		return ((String) getAttrVal("Create_name"));
	}	
	public void setCreate_name(String Create_name) {
		setAttrVal("Create_name", Create_name);
	}
	public String getModify_name() {
		return ((String) getAttrVal("Modify_name"));
	}	
	public void setModify_name(String Modify_name) {
		setAttrVal("Modify_name", Modify_name);
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
		return "Id_mthscp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_matscope";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MatchScopeDODesc.class);
	}
	
}