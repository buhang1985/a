package iih.pe.pqn.peqadeptprompt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peqadeptprompt.d.desc.PeQaDeptPromptDODesc;
import java.math.BigDecimal;

/**
 * 体检科室重要提示定义 DO数据 
 * 
 */
public class PeQaDeptPromptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEQADEPTPROMPT= "Id_peqadeptprompt";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String ID_PEQACONTENTDEF= "Id_peqacontentdef";
	public static final String FG_POSIPROMPT= "Fg_posiprompt";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_DEPT= "Code_dept";
	public static final String NAME_DEPT= "Name_dept";
	public static final String CODE_QA= "Code_qa";
	public static final String NAME_QA= "Name_qa";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peqadeptprompt() {
		return ((String) getAttrVal("Id_peqadeptprompt"));
	}	
	public void setId_peqadeptprompt(String Id_peqadeptprompt) {
		setAttrVal("Id_peqadeptprompt", Id_peqadeptprompt);
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
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	public String getId_peqacontentdef() {
		return ((String) getAttrVal("Id_peqacontentdef"));
	}	
	public void setId_peqacontentdef(String Id_peqacontentdef) {
		setAttrVal("Id_peqacontentdef", Id_peqacontentdef);
	}
	public FBoolean getFg_posiprompt() {
		return ((FBoolean) getAttrVal("Fg_posiprompt"));
	}	
	public void setFg_posiprompt(FBoolean Fg_posiprompt) {
		setAttrVal("Fg_posiprompt", Fg_posiprompt);
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
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	public String getCode_qa() {
		return ((String) getAttrVal("Code_qa"));
	}	
	public void setCode_qa(String Code_qa) {
		setAttrVal("Code_qa", Code_qa);
	}
	public String getName_qa() {
		return ((String) getAttrVal("Name_qa"));
	}	
	public void setName_qa(String Name_qa) {
		setAttrVal("Name_qa", Name_qa);
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
		return "Id_peqadeptprompt";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peqadeptprompt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQaDeptPromptDODesc.class);
	}
	
}