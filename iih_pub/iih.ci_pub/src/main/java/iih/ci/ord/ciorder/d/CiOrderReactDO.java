package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ciorder.d.desc.CiOrderReactDODesc;
import java.math.BigDecimal;

/**
 * 医嘱互斥记录表 DO数据 
 * 
 */
public class CiOrderReactDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OR_REACT= "Id_or_react";
	public static final String ID_OR= "Id_or";
	public static final String ID_OR_REACT_ITM= "Id_or_react_itm";
	public static final String SORTNO= "Sortno";
	public static final String DT_BEGIN= "Dt_begin";
	public static final String DT_END= "Dt_end";
	public static final String ISREADONLY= "Isreadonly";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GROUP= "Id_group";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DT_LAST_MP= "Dt_last_mp";
	public static final String SD_SU_OR= "Sd_su_or";
	public static final String SD_SU_MP= "Sd_su_mp";
	public static final String FG_STOP= "Fg_stop";
	public static final String ORD_COLLIGATE= "Ord_colligate";
	public static final String NAME_OR= "Name_or";
	public static final String NAME_OR_REACT= "Name_or_react";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_or_react() {
		return ((String) getAttrVal("Id_or_react"));
	}	
	public void setId_or_react(String Id_or_react) {
		setAttrVal("Id_or_react", Id_or_react);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_or_react_itm() {
		return ((String) getAttrVal("Id_or_react_itm"));
	}	
	public void setId_or_react_itm(String Id_or_react_itm) {
		setAttrVal("Id_or_react_itm", Id_or_react_itm);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public FBoolean getIsreadonly() {
		return ((FBoolean) getAttrVal("Isreadonly"));
	}	
	public void setIsreadonly(FBoolean Isreadonly) {
		setAttrVal("Isreadonly", Isreadonly);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_group() {
		return ((String) getAttrVal("Id_group"));
	}	
	public void setId_group(String Id_group) {
		setAttrVal("Id_group", Id_group);
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
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}	
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	public String getSd_su_mp() {
		return ((String) getAttrVal("Sd_su_mp"));
	}	
	public void setSd_su_mp(String Sd_su_mp) {
		setAttrVal("Sd_su_mp", Sd_su_mp);
	}
	public FBoolean getFg_stop() {
		return ((FBoolean) getAttrVal("Fg_stop"));
	}	
	public void setFg_stop(FBoolean Fg_stop) {
		setAttrVal("Fg_stop", Fg_stop);
	}
	public String getOrd_colligate() {
		return ((String) getAttrVal("Ord_colligate"));
	}	
	public void setOrd_colligate(String Ord_colligate) {
		setAttrVal("Ord_colligate", Ord_colligate);
	}
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	public String getName_or_react() {
		return ((String) getAttrVal("Name_or_react"));
	}	
	public void setName_or_react(String Name_or_react) {
		setAttrVal("Name_or_react", Name_or_react);
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
		return "Id_or_react";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_react";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiOrderReactDODesc.class);
	}
	
}