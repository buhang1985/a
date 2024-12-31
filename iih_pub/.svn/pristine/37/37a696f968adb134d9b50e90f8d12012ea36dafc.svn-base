package iih.pe.pqn.peevalmeal.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peevalmeal.d.desc.PeEvalMealDODesc;
import java.math.BigDecimal;

/**
 * 体检饮食评估定义 DO数据 
 * 
 */
public class PeEvalMealDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEEVALMEAL= "Id_peevalmeal";
	public static final String ID_PEEVALMEAL_PAR= "Id_peevalmeal_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String SORTNO= "Sortno";
	public static final String INGEST_MIN= "Ingest_min";
	public static final String INGEST_MAX= "Ingest_max";
	public static final String DEFAULT_LEVEL= "Default_level";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peevalmeal() {
		return ((String) getAttrVal("Id_peevalmeal"));
	}	
	public void setId_peevalmeal(String Id_peevalmeal) {
		setAttrVal("Id_peevalmeal", Id_peevalmeal);
	}
	public String getId_peevalmeal_par() {
		return ((String) getAttrVal("Id_peevalmeal_par"));
	}	
	public void setId_peevalmeal_par(String Id_peevalmeal_par) {
		setAttrVal("Id_peevalmeal_par", Id_peevalmeal_par);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FDouble getIngest_min() {
		return ((FDouble) getAttrVal("Ingest_min"));
	}	
	public void setIngest_min(FDouble Ingest_min) {
		setAttrVal("Ingest_min", Ingest_min);
	}
	public FDouble getIngest_max() {
		return ((FDouble) getAttrVal("Ingest_max"));
	}	
	public void setIngest_max(FDouble Ingest_max) {
		setAttrVal("Ingest_max", Ingest_max);
	}
	public FDouble getDefault_level() {
		return ((FDouble) getAttrVal("Default_level"));
	}	
	public void setDefault_level(FDouble Default_level) {
		setAttrVal("Default_level", Default_level);
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
		return "Id_peevalmeal";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peevalmeal";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEvalMealDODesc.class);
	}
	
}