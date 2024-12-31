package iih.pe.pitm.pedecisiontree.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pedecisiontree.d.desc.PeDecisionTreeDODesc;
import java.math.BigDecimal;

/**
 * 体检决策树定义 DO数据 
 * 
 */
public class PeDecisionTreeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDECISIONTREE= "Id_pedecisiontree";
	public static final String ID_PEDECISIONTREE_PAR= "Id_pedecisiontree_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedecisiontree() {
		return ((String) getAttrVal("Id_pedecisiontree"));
	}	
	public void setId_pedecisiontree(String Id_pedecisiontree) {
		setAttrVal("Id_pedecisiontree", Id_pedecisiontree);
	}
	public String getId_pedecisiontree_par() {
		return ((String) getAttrVal("Id_pedecisiontree_par"));
	}	
	public void setId_pedecisiontree_par(String Id_pedecisiontree_par) {
		setAttrVal("Id_pedecisiontree_par", Id_pedecisiontree_par);
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
		return "Id_pedecisiontree";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pedecisiontree";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDecisionTreeDODesc.class);
	}
	
}