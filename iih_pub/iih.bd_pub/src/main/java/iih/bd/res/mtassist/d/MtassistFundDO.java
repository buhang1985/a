package iih.bd.res.mtassist.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.res.mtassist.d.desc.MtassistFundDODesc;
import java.math.BigDecimal;

/**
 * 医技辅固定资产对应 DO数据 
 * 
 */
public class MtassistFundDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MTFA= "Id_mtfa";
	public static final String ID_MT= "Id_mt";
	public static final String SORTNO= "Sortno";
	public static final String CODE_FA= "Code_fa";
	public static final String NAME_FA= "Name_fa";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mtfa() {
		return ((String) getAttrVal("Id_mtfa"));
	}	
	public void setId_mtfa(String Id_mtfa) {
		setAttrVal("Id_mtfa", Id_mtfa);
	}
	public String getId_mt() {
		return ((String) getAttrVal("Id_mt"));
	}	
	public void setId_mt(String Id_mt) {
		setAttrVal("Id_mt", Id_mt);
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
		return "Id_mtfa";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mt_fa";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MtassistFundDODesc.class);
	}
	
}