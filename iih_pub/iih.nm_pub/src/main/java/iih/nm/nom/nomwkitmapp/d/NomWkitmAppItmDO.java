package iih.nm.nom.nomwkitmapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomwkitmapp.d.desc.NomWkitmAppItmDODesc;
import java.math.BigDecimal;

/**
 * 项目工作量数据 DO数据 
 * 
 */
public class NomWkitmAppItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_WKITM_APP_ITM= "Id_nom_wkitm_app_itm";
	public static final String ID_NOM_WKITM_APP= "Id_nom_wkitm_app";
	public static final String ID_NOM_WKITM= "Id_nom_wkitm";
	public static final String COUNT= "Count";
	public static final String CTR1= "Ctr1";
	public static final String CTR2= "Ctr2";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NOM_WKITM= "Name_nom_wkitm";
	public static final String SORTNO= "Sortno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_wkitm_app_itm() {
		return ((String) getAttrVal("Id_nom_wkitm_app_itm"));
	}	
	public void setId_nom_wkitm_app_itm(String Id_nom_wkitm_app_itm) {
		setAttrVal("Id_nom_wkitm_app_itm", Id_nom_wkitm_app_itm);
	}
	public String getId_nom_wkitm_app() {
		return ((String) getAttrVal("Id_nom_wkitm_app"));
	}	
	public void setId_nom_wkitm_app(String Id_nom_wkitm_app) {
		setAttrVal("Id_nom_wkitm_app", Id_nom_wkitm_app);
	}
	public String getId_nom_wkitm() {
		return ((String) getAttrVal("Id_nom_wkitm"));
	}	
	public void setId_nom_wkitm(String Id_nom_wkitm) {
		setAttrVal("Id_nom_wkitm", Id_nom_wkitm);
	}
	public Integer getCount() {
		return ((Integer) getAttrVal("Count"));
	}	
	public void setCount(Integer Count) {
		setAttrVal("Count", Count);
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
	public String getName_nom_wkitm() {
		return ((String) getAttrVal("Name_nom_wkitm"));
	}	
	public void setName_nom_wkitm(String Name_nom_wkitm) {
		setAttrVal("Name_nom_wkitm", Name_nom_wkitm);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
		return "Id_nom_wkitm_app_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_WKITM_APP_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomWkitmAppItmDODesc.class);
	}
	
}