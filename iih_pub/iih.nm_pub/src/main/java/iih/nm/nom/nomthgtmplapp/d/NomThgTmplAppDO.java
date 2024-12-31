package iih.nm.nom.nomthgtmplapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomthgtmplapp.d.desc.NomThgTmplAppDODesc;
import java.math.BigDecimal;

/**
 * 病区事物记录 DO数据 
 * 
 */
public class NomThgTmplAppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_THGTMPL_APP= "Id_nom_thgtmpl_app";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NOM_THGTMPL= "Id_nom_thgtmpl";
	public static final String CONTENT= "Content";
	public static final String NAME= "Name";
	public static final String DT_REC= "Dt_rec";
	public static final String ID_REC_PSN= "Id_rec_psn";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String DES= "Des";
	public static final String CTRL= "Ctrl";
	public static final String CTL2= "Ctl2";
	public static final String CTR3= "Ctr3";
	public static final String CTR4= "Ctr4";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_THGTMPL= "Name_thgtmpl";
	public static final String NAME_REC_PSN= "Name_rec_psn";
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_thgtmpl_app() {
		return ((String) getAttrVal("Id_nom_thgtmpl_app"));
	}	
	public void setId_nom_thgtmpl_app(String Id_nom_thgtmpl_app) {
		setAttrVal("Id_nom_thgtmpl_app", Id_nom_thgtmpl_app);
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
	public String getId_nom_thgtmpl() {
		return ((String) getAttrVal("Id_nom_thgtmpl"));
	}	
	public void setId_nom_thgtmpl(String Id_nom_thgtmpl) {
		setAttrVal("Id_nom_thgtmpl", Id_nom_thgtmpl);
	}
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}	
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public FDateTime getDt_rec() {
		return ((FDateTime) getAttrVal("Dt_rec"));
	}	
	public void setDt_rec(FDateTime Dt_rec) {
		setAttrVal("Dt_rec", Dt_rec);
	}
	public String getId_rec_psn() {
		return ((String) getAttrVal("Id_rec_psn"));
	}	
	public void setId_rec_psn(String Id_rec_psn) {
		setAttrVal("Id_rec_psn", Id_rec_psn);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getCtrl() {
		return ((String) getAttrVal("Ctrl"));
	}	
	public void setCtrl(String Ctrl) {
		setAttrVal("Ctrl", Ctrl);
	}
	public String getCtl2() {
		return ((String) getAttrVal("Ctl2"));
	}	
	public void setCtl2(String Ctl2) {
		setAttrVal("Ctl2", Ctl2);
	}
	public String getCtr3() {
		return ((String) getAttrVal("Ctr3"));
	}	
	public void setCtr3(String Ctr3) {
		setAttrVal("Ctr3", Ctr3);
	}
	public String getCtr4() {
		return ((String) getAttrVal("Ctr4"));
	}	
	public void setCtr4(String Ctr4) {
		setAttrVal("Ctr4", Ctr4);
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
	public String getName_thgtmpl() {
		return ((String) getAttrVal("Name_thgtmpl"));
	}	
	public void setName_thgtmpl(String Name_thgtmpl) {
		setAttrVal("Name_thgtmpl", Name_thgtmpl);
	}
	public String getName_rec_psn() {
		return ((String) getAttrVal("Name_rec_psn"));
	}	
	public void setName_rec_psn(String Name_rec_psn) {
		setAttrVal("Name_rec_psn", Name_rec_psn);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_nom_thgtmpl_app";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_THGTMPL_APP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomThgTmplAppDODesc.class);
	}
	
}