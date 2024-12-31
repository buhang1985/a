package iih.nm.nom.nomwkitmapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomwkitmapp.d.desc.NomWkitmAppDODesc;
import java.math.BigDecimal;

/**
 * 护理工作项目数据录入 DO数据 
 * 
 */
public class NomWkitmAppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_WKITM_APP= "Id_nom_wkitm_app";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String DT_MONTH= "Dt_month";
	public static final String FG_COMFIRM= "Fg_comfirm";
	public static final String CTR1= "Ctr1";
	public static final String CTR2= "Ctr2";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_ORG= "Name_org";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_wkitm_app() {
		return ((String) getAttrVal("Id_nom_wkitm_app"));
	}	
	public void setId_nom_wkitm_app(String Id_nom_wkitm_app) {
		setAttrVal("Id_nom_wkitm_app", Id_nom_wkitm_app);
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
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public FDate getDt_month() {
		return ((FDate) getAttrVal("Dt_month"));
	}	
	public void setDt_month(FDate Dt_month) {
		setAttrVal("Dt_month", Dt_month);
	}
	public FBoolean getFg_comfirm() {
		return ((FBoolean) getAttrVal("Fg_comfirm"));
	}	
	public void setFg_comfirm(FBoolean Fg_comfirm) {
		setAttrVal("Fg_comfirm", Fg_comfirm);
	}
	public String getCtr1() {
		return ((String) getAttrVal("Ctr1"));
	}	
	public void setCtr1(String Ctr1) {
		setAttrVal("Ctr1", Ctr1);
	}
	public String getCtr2() {
		return ((String) getAttrVal("Ctr2"));
	}	
	public void setCtr2(String Ctr2) {
		setAttrVal("Ctr2", Ctr2);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_nom_wkitm_app";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_WKITM_APP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomWkitmAppDODesc.class);
	}
	
}