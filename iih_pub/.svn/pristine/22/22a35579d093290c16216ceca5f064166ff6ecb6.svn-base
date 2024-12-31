package iih.pe.pqn.peevalsubhealth.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalsubhealth.d.desc.PeEvalSHQaDODesc;
import java.math.BigDecimal;

/**
 * 体检亚健康-问卷 DO数据 
 * 
 */
public class PeEvalSHQaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEEVALSHQA= "Id_peevalshqa";
	public static final String ID_PEEVALSUBHEALTH= "Id_peevalsubhealth";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	public static final String SCORE= "Score";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peevalshqa() {
		return ((String) getAttrVal("Id_peevalshqa"));
	}	
	public void setId_peevalshqa(String Id_peevalshqa) {
		setAttrVal("Id_peevalshqa", Id_peevalshqa);
	}
	public String getId_peevalsubhealth() {
		return ((String) getAttrVal("Id_peevalsubhealth"));
	}	
	public void setId_peevalsubhealth(String Id_peevalsubhealth) {
		setAttrVal("Id_peevalsubhealth", Id_peevalsubhealth);
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
	public String getId_peqakeydef() {
		return ((String) getAttrVal("Id_peqakeydef"));
	}	
	public void setId_peqakeydef(String Id_peqakeydef) {
		setAttrVal("Id_peqakeydef", Id_peqakeydef);
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
		return "Id_peevalshqa";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevalshqa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalSHQaDODesc.class);
	}
	
}