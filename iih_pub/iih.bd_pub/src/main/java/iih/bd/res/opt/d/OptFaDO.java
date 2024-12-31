package iih.bd.res.opt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.opt.d.desc.OptFaDODesc;
import java.math.BigDecimal;

/**
 * 手术台固定资产 DO数据 
 * 
 */
public class OptFaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPTFA= "Id_optfa";
	public static final String ID_OPT= "Id_opt";
	public static final String SORTNO= "Sortno";
	public static final String CODE_FA= "Code_fa";
	public static final String NAME_FA= "Name_fa";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_optfa() {
		return ((String) getAttrVal("Id_optfa"));
	}	
	public void setId_optfa(String Id_optfa) {
		setAttrVal("Id_optfa", Id_optfa);
	}
	public String getId_opt() {
		return ((String) getAttrVal("Id_opt"));
	}	
	public void setId_opt(String Id_opt) {
		setAttrVal("Id_opt", Id_opt);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCode_fa() {
		return ((String) getAttrVal("Code_fa"));
	}	
	public void setCode_fa(String Code_fa) {
		setAttrVal("Code_fa", Code_fa);
	}
	public String getName_fa() {
		return ((String) getAttrVal("Name_fa"));
	}	
	public void setName_fa(String Name_fa) {
		setAttrVal("Name_fa", Name_fa);
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
		return "Id_optfa";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_opt_fa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OptFaDODesc.class);
	}
	
}