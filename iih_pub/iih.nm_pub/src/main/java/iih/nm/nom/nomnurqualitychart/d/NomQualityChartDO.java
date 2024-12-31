package iih.nm.nom.nomnurqualitychart.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomnurqualitychart.d.desc.NomQualityChartDODesc;
import java.math.BigDecimal;

/**
 * 护理质量监控图表 DO数据 
 * 
 */
public class NomQualityChartDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_QUALITYCHART= "Id_nom_qualitychart";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String FG_COMFIRM= "Fg_comfirm";
	public static final String DISPLAY_FG_COMFIRM= "Display_fg_comfirm";
	public static final String CHECK_MONTH= "Check_month";
	public static final String ICU_UNPLANED_NUM= "Icu_unplaned_num";
	public static final String ICU_TOTAL_NUM= "Icu_total_num";
	public static final String PRE_ULCERS_NUM= "Pre_ulcers_num";
	public static final String FALLS_NUM= "Falls_num";
	public static final String ADV_EVENT_NUM= "Adv_event_num";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_qualitychart() {
		return ((String) getAttrVal("Id_nom_qualitychart"));
	}	
	public void setId_nom_qualitychart(String Id_nom_qualitychart) {
		setAttrVal("Id_nom_qualitychart", Id_nom_qualitychart);
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
	public FBoolean getFg_comfirm() {
		return ((FBoolean) getAttrVal("Fg_comfirm"));
	}	
	public void setFg_comfirm(FBoolean Fg_comfirm) {
		setAttrVal("Fg_comfirm", Fg_comfirm);
	}
	public String getDisplay_fg_comfirm() {
		return ((String) getAttrVal("Display_fg_comfirm"));
	}	
	public void setDisplay_fg_comfirm(String Display_fg_comfirm) {
		setAttrVal("Display_fg_comfirm", Display_fg_comfirm);
	}
	public FDate getCheck_month() {
		return ((FDate) getAttrVal("Check_month"));
	}	
	public void setCheck_month(FDate Check_month) {
		setAttrVal("Check_month", Check_month);
	}
	public Integer getIcu_unplaned_num() {
		return ((Integer) getAttrVal("Icu_unplaned_num"));
	}	
	public void setIcu_unplaned_num(Integer Icu_unplaned_num) {
		setAttrVal("Icu_unplaned_num", Icu_unplaned_num);
	}
	public Integer getIcu_total_num() {
		return ((Integer) getAttrVal("Icu_total_num"));
	}	
	public void setIcu_total_num(Integer Icu_total_num) {
		setAttrVal("Icu_total_num", Icu_total_num);
	}
	public Integer getPre_ulcers_num() {
		return ((Integer) getAttrVal("Pre_ulcers_num"));
	}	
	public void setPre_ulcers_num(Integer Pre_ulcers_num) {
		setAttrVal("Pre_ulcers_num", Pre_ulcers_num);
	}
	public Integer getFalls_num() {
		return ((Integer) getAttrVal("Falls_num"));
	}	
	public void setFalls_num(Integer Falls_num) {
		setAttrVal("Falls_num", Falls_num);
	}
	public Integer getAdv_event_num() {
		return ((Integer) getAttrVal("Adv_event_num"));
	}	
	public void setAdv_event_num(Integer Adv_event_num) {
		setAttrVal("Adv_event_num", Adv_event_num);
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
		return "Id_nom_qualitychart";
	}
	
	@Override
	public String getTableName() {	  
		return "nom_nur_qualitychart";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomQualityChartDODesc.class);
	}
	
}