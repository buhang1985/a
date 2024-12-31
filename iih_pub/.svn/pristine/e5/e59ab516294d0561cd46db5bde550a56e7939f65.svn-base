package iih.pe.pqn.peevalsubhealth.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalsubhealth.d.desc.PeEvalSubhealthDODesc;
import java.math.BigDecimal;

/**
 * 体检亚健康评估定义 DO数据 
 * 
 */
public class PeEvalSubhealthDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEEVALSUBHEALTH= "Id_peevalsubhealth";
	public static final String ID_PEEVALSUBHEALTH_PAR= "Id_peevalsubhealth_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String WEIGHT= "Weight";
	public static final String BASE_SCORE= "Base_score";
	public static final String SORTNO= "Sortno";
	public static final String FG_LEAF= "Fg_leaf";
	public static final String TIP= "Tip";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SUBHEALTH= "Code_subhealth";
	public static final String NAME_SUBHEALTH= "Name_subhealth";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peevalsubhealth() {
		return ((String) getAttrVal("Id_peevalsubhealth"));
	}	
	public void setId_peevalsubhealth(String Id_peevalsubhealth) {
		setAttrVal("Id_peevalsubhealth", Id_peevalsubhealth);
	}
	public String getId_peevalsubhealth_par() {
		return ((String) getAttrVal("Id_peevalsubhealth_par"));
	}	
	public void setId_peevalsubhealth_par(String Id_peevalsubhealth_par) {
		setAttrVal("Id_peevalsubhealth_par", Id_peevalsubhealth_par);
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
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public FDouble getBase_score() {
		return ((FDouble) getAttrVal("Base_score"));
	}	
	public void setBase_score(FDouble Base_score) {
		setAttrVal("Base_score", Base_score);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FBoolean getFg_leaf() {
		return ((FBoolean) getAttrVal("Fg_leaf"));
	}	
	public void setFg_leaf(FBoolean Fg_leaf) {
		setAttrVal("Fg_leaf", Fg_leaf);
	}
	public String getTip() {
		return ((String) getAttrVal("Tip"));
	}	
	public void setTip(String Tip) {
		setAttrVal("Tip", Tip);
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
	public String getCode_subhealth() {
		return ((String) getAttrVal("Code_subhealth"));
	}	
	public void setCode_subhealth(String Code_subhealth) {
		setAttrVal("Code_subhealth", Code_subhealth);
	}
	public String getName_subhealth() {
		return ((String) getAttrVal("Name_subhealth"));
	}	
	public void setName_subhealth(String Name_subhealth) {
		setAttrVal("Name_subhealth", Name_subhealth);
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
		return "Id_peevalsubhealth";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevalsubhealth";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalSubhealthDODesc.class);
	}
	
}