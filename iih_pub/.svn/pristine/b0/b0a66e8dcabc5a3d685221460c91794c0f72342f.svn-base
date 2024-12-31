package iih.nm.nom.nomev.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomev.d.desc.NomEvPsnDODesc;
import java.math.BigDecimal;

/**
 * 护理部大事记参与人员 DO数据 
 * 
 */
public class NomEvPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_EV_PSN= "Id_nom_ev_psn";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String PSNNO= "Psnno";
	public static final String ID_NOM_EV= "Id_nom_ev";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PSN_NAME= "Psn_name";
	public static final String PSN_CODE= "Psn_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_ev_psn() {
		return ((String) getAttrVal("Id_nom_ev_psn"));
	}	
	public void setId_nom_ev_psn(String Id_nom_ev_psn) {
		setAttrVal("Id_nom_ev_psn", Id_nom_ev_psn);
	}
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public String getPsnno() {
		return ((String) getAttrVal("Psnno"));
	}	
	public void setPsnno(String Psnno) {
		setAttrVal("Psnno", Psnno);
	}
	public String getId_nom_ev() {
		return ((String) getAttrVal("Id_nom_ev"));
	}	
	public void setId_nom_ev(String Id_nom_ev) {
		setAttrVal("Id_nom_ev", Id_nom_ev);
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
	public String getPsn_name() {
		return ((String) getAttrVal("Psn_name"));
	}	
	public void setPsn_name(String Psn_name) {
		setAttrVal("Psn_name", Psn_name);
	}
	public String getPsn_code() {
		return ((String) getAttrVal("Psn_code"));
	}	
	public void setPsn_code(String Psn_code) {
		setAttrVal("Psn_code", Psn_code);
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
		return "Id_nom_ev_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_EV_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomEvPsnDODesc.class);
	}
	
}