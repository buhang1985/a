package iih.pe.pqn.peevalsubhealth.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalsubhealth.d.desc.PeEvalSHRstDODesc;
import java.math.BigDecimal;

/**
 * 体检亚健康-检查结果 DO数据 
 * 
 */
public class PeEvalSHRstDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEEVALSHRST= "Id_peevalshrst";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEEVALSUBHEALTH= "Id_peevalsubhealth";
	public static final String ID_PERULEDEF= "Id_peruledef";
	public static final String SCORE= "Score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_RULE= "Code_rule";
	public static final String NAME_RULE= "Name_rule";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peevalshrst() {
		return ((String) getAttrVal("Id_peevalshrst"));
	}	
	public void setId_peevalshrst(String Id_peevalshrst) {
		setAttrVal("Id_peevalshrst", Id_peevalshrst);
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
	public String getId_peevalsubhealth() {
		return ((String) getAttrVal("Id_peevalsubhealth"));
	}	
	public void setId_peevalsubhealth(String Id_peevalsubhealth) {
		setAttrVal("Id_peevalsubhealth", Id_peevalsubhealth);
	}
	public String getId_peruledef() {
		return ((String) getAttrVal("Id_peruledef"));
	}	
	public void setId_peruledef(String Id_peruledef) {
		setAttrVal("Id_peruledef", Id_peruledef);
	}
	public FDouble getScore() {
		return ((FDouble) getAttrVal("Score"));
	}	
	public void setScore(FDouble Score) {
		setAttrVal("Score", Score);
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
	public String getCode_rule() {
		return ((String) getAttrVal("Code_rule"));
	}	
	public void setCode_rule(String Code_rule) {
		setAttrVal("Code_rule", Code_rule);
	}
	public String getName_rule() {
		return ((String) getAttrVal("Name_rule"));
	}	
	public void setName_rule(String Name_rule) {
		setAttrVal("Name_rule", Name_rule);
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
		return "Id_peevalshrst";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevalshrst";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalSHRstDODesc.class);
	}
	
}