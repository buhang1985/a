package iih.pe.pqn.peqaca.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pqn.peqaca.d.desc.PeQaCaDODesc;
import java.math.BigDecimal;

/**
 * 体检问卷组套 DO数据 
 * 
 */
public class PeQaCaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEQACA= "Id_peqaca";
	public static final String ID_PEQACA_PAR= "Id_peqaca_par";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PEQATPDEF= "Id_peqatpdef";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SORTNO= "Sortno";
	public static final String DOCAST= "Docast";
	public static final String CODE_PAR= "Code_par";
	public static final String NAME_PAR= "Name_par";
	public static final String NAME_QATP= "Name_qatp";
	public static final String CODE_QATP= "Code_qatp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_peqaca() {
		return ((String) getAttrVal("Id_peqaca"));
	}	
	public void setId_peqaca(String Id_peqaca) {
		setAttrVal("Id_peqaca", Id_peqaca);
	}
	public String getId_peqaca_par() {
		return ((String) getAttrVal("Id_peqaca_par"));
	}	
	public void setId_peqaca_par(String Id_peqaca_par) {
		setAttrVal("Id_peqaca_par", Id_peqaca_par);
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
	public String getId_peqatpdef() {
		return ((String) getAttrVal("Id_peqatpdef"));
	}	
	public void setId_peqatpdef(String Id_peqatpdef) {
		setAttrVal("Id_peqatpdef", Id_peqatpdef);
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
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getDocast() {
		return ((String) getAttrVal("Docast"));
	}	
	public void setDocast(String Docast) {
		setAttrVal("Docast", Docast);
	}
	public String getCode_par() {
		return ((String) getAttrVal("Code_par"));
	}	
	public void setCode_par(String Code_par) {
		setAttrVal("Code_par", Code_par);
	}
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
	}
	public String getName_qatp() {
		return ((String) getAttrVal("Name_qatp"));
	}	
	public void setName_qatp(String Name_qatp) {
		setAttrVal("Name_qatp", Name_qatp);
	}
	public String getCode_qatp() {
		return ((String) getAttrVal("Code_qatp"));
	}	
	public void setCode_qatp(String Code_qatp) {
		setAttrVal("Code_qatp", Code_qatp);
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
		return "Id_peqaca";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_qn_peqaca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeQaCaDODesc.class);
	}
	
}