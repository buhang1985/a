package iih.nm.nom.nomthgtmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomthgtmpl.d.desc.NomThgTmplDODesc;
import java.math.BigDecimal;

/**
 * 病区事物记录模板 DO数据 
 * 
 */
public class NomThgTmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_THGTMPL= "Id_nom_thgtmpl";
	public static final String ID_NOM_THGTMPL_CA= "Id_nom_thgtmpl_ca";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CONTENT= "Content";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DES= "Des";
	public static final String ID_CRT_PSN= "Id_crt_psn";
	public static final String DT_CRT= "Dt_crt";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_CRT_PSN= "Name_crt_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_thgtmpl() {
		return ((String) getAttrVal("Id_nom_thgtmpl"));
	}	
	public void setId_nom_thgtmpl(String Id_nom_thgtmpl) {
		setAttrVal("Id_nom_thgtmpl", Id_nom_thgtmpl);
	}
	public String getId_nom_thgtmpl_ca() {
		return ((String) getAttrVal("Id_nom_thgtmpl_ca"));
	}	
	public void setId_nom_thgtmpl_ca(String Id_nom_thgtmpl_ca) {
		setAttrVal("Id_nom_thgtmpl_ca", Id_nom_thgtmpl_ca);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}	
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_crt_psn() {
		return ((String) getAttrVal("Id_crt_psn"));
	}	
	public void setId_crt_psn(String Id_crt_psn) {
		setAttrVal("Id_crt_psn", Id_crt_psn);
	}
	public FDateTime getDt_crt() {
		return ((FDateTime) getAttrVal("Dt_crt"));
	}	
	public void setDt_crt(FDateTime Dt_crt) {
		setAttrVal("Dt_crt", Dt_crt);
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
	public String getName_crt_psn() {
		return ((String) getAttrVal("Name_crt_psn"));
	}	
	public void setName_crt_psn(String Name_crt_psn) {
		setAttrVal("Name_crt_psn", Name_crt_psn);
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
		return "Id_nom_thgtmpl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_THGTMPL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomThgTmplDODesc.class);
	}
	
}