package iih.pe.pqn.peevalmeal.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalmeal.d.desc.PeEvalMealQaDODesc;
import java.math.BigDecimal;

/**
 * 体检饮食评估-问卷 DO数据 
 * 
 */
public class PeEvalMealQaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEEVALSHQA= "Id_peevalshqa";
	public static final String ID_PEEVALMEAL= "Id_peevalmeal";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEQAKEYDEF= "Id_peqakeydef";
	public static final String SCORE= "Score";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peevalshqa() {
		return ((String) getAttrVal("Id_peevalshqa"));
	}	
	public void setId_peevalshqa(String Id_peevalshqa) {
		setAttrVal("Id_peevalshqa", Id_peevalshqa);
	}
	public String getId_peevalmeal() {
		return ((String) getAttrVal("Id_peevalmeal"));
	}	
	public void setId_peevalmeal(String Id_peevalmeal) {
		setAttrVal("Id_peevalmeal", Id_peevalmeal);
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
		return "pe_qn_peevalmealqa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalMealQaDODesc.class);
	}
	
}