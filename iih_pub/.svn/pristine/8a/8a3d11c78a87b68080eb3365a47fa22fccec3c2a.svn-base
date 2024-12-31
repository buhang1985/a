package iih.pe.pitm.pechrodisedef.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pitm.pechrodisedef.d.desc.PeChroDiseDefDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病定义 DO数据 
 * 
 */
public class PeChroDiseDefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PECHRODISEDEF= "Id_pechrodisedef";
	public static final String ID_PECHRODISEDEF_PAR= "Id_pechrodisedef_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DEF= "Def";
	public static final String RISKFACTOR= "Riskfactor";
	public static final String DIAG= "Diag";
	public static final String TREAT= "Treat";
	public static final String LIFESTYLE= "Lifestyle";
	public static final String TREATTCM= "Treattcm";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pechrodisedef() {
		return ((String) getAttrVal("Id_pechrodisedef"));
	}	
	public void setId_pechrodisedef(String Id_pechrodisedef) {
		setAttrVal("Id_pechrodisedef", Id_pechrodisedef);
	}
	public String getId_pechrodisedef_par() {
		return ((String) getAttrVal("Id_pechrodisedef_par"));
	}	
	public void setId_pechrodisedef_par(String Id_pechrodisedef_par) {
		setAttrVal("Id_pechrodisedef_par", Id_pechrodisedef_par);
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
	public String getDef() {
		return ((String) getAttrVal("Def"));
	}	
	public void setDef(String Def) {
		setAttrVal("Def", Def);
	}
	public String getRiskfactor() {
		return ((String) getAttrVal("Riskfactor"));
	}	
	public void setRiskfactor(String Riskfactor) {
		setAttrVal("Riskfactor", Riskfactor);
	}
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}	
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	public String getTreat() {
		return ((String) getAttrVal("Treat"));
	}	
	public void setTreat(String Treat) {
		setAttrVal("Treat", Treat);
	}
	public String getLifestyle() {
		return ((String) getAttrVal("Lifestyle"));
	}	
	public void setLifestyle(String Lifestyle) {
		setAttrVal("Lifestyle", Lifestyle);
	}
	public String getTreattcm() {
		return ((String) getAttrVal("Treattcm"));
	}	
	public void setTreattcm(String Treattcm) {
		setAttrVal("Treattcm", Treattcm);
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
		return "Id_pechrodisedef";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_itm_pechrodisedef";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDiseDefDODesc.class);
	}
	
}