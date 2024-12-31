package iih.nm.nqm.nmnqmspcs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmspcs.d.desc.NmNqmSpcsKpiDoDesc;
import java.math.BigDecimal;

/**
 * 专科护理质量指标 DO数据 
 * 
 */
public class NmNqmSpcsKpiDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NQM_SPCS_KPI= "Id_nqm_spcs_kpi";
	public static final String ID_NQM_SPCS= "Id_nqm_spcs";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_KPI_CA= "Id_kpi_ca";
	public static final String SD_KPI_CA= "Sd_kpi_ca";
	public static final String ID_KPI_LVL= "Id_kpi_lvl";
	public static final String SD_KPI_LVL= "Sd_kpi_lvl";
	public static final String ID_GOAL= "Id_goal";
	public static final String SD_GOAL= "Sd_goal";
	public static final String CHKNUMBNAME= "Chknumbname";
	public static final String CHKDENORNAME= "Chkdenorname";
	public static final String NUMCAP= "Numcap";
	public static final String NUMFLOOR= "Numfloor";
	public static final String NUMOVER= "Numover";
	public static final String ID_PER_UNIT= "Id_per_unit";
	public static final String SD_PER_UNIT= "Sd_per_unit";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DES= "Des";
	public static final String CTRL1= "Ctrl1";
	public static final String CTRL2= "Ctrl2";
	public static final String CTRL3= "Ctrl3";
	public static final String CTRL4= "Ctrl4";
	public static final String CTRL5= "Ctrl5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SPCS= "Name_spcs";
	public static final String NAME_KPI_CA= "Name_kpi_ca";
	public static final String NAME_KPI_LVL= "Name_kpi_lvl";
	public static final String NAME_GOAL= "Name_goal";
	public static final String NAME_PER_UNIT= "Name_per_unit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nqm_spcs_kpi() {
		return ((String) getAttrVal("Id_nqm_spcs_kpi"));
	}	
	public void setId_nqm_spcs_kpi(String Id_nqm_spcs_kpi) {
		setAttrVal("Id_nqm_spcs_kpi", Id_nqm_spcs_kpi);
	}
	public String getId_nqm_spcs() {
		return ((String) getAttrVal("Id_nqm_spcs"));
	}	
	public void setId_nqm_spcs(String Id_nqm_spcs) {
		setAttrVal("Id_nqm_spcs", Id_nqm_spcs);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_kpi_ca() {
		return ((String) getAttrVal("Id_kpi_ca"));
	}	
	public void setId_kpi_ca(String Id_kpi_ca) {
		setAttrVal("Id_kpi_ca", Id_kpi_ca);
	}
	public String getSd_kpi_ca() {
		return ((String) getAttrVal("Sd_kpi_ca"));
	}	
	public void setSd_kpi_ca(String Sd_kpi_ca) {
		setAttrVal("Sd_kpi_ca", Sd_kpi_ca);
	}
	public String getId_kpi_lvl() {
		return ((String) getAttrVal("Id_kpi_lvl"));
	}	
	public void setId_kpi_lvl(String Id_kpi_lvl) {
		setAttrVal("Id_kpi_lvl", Id_kpi_lvl);
	}
	public String getSd_kpi_lvl() {
		return ((String) getAttrVal("Sd_kpi_lvl"));
	}	
	public void setSd_kpi_lvl(String Sd_kpi_lvl) {
		setAttrVal("Sd_kpi_lvl", Sd_kpi_lvl);
	}
	public String getId_goal() {
		return ((String) getAttrVal("Id_goal"));
	}	
	public void setId_goal(String Id_goal) {
		setAttrVal("Id_goal", Id_goal);
	}
	public String getSd_goal() {
		return ((String) getAttrVal("Sd_goal"));
	}	
	public void setSd_goal(String Sd_goal) {
		setAttrVal("Sd_goal", Sd_goal);
	}
	public String getChknumbname() {
		return ((String) getAttrVal("Chknumbname"));
	}	
	public void setChknumbname(String Chknumbname) {
		setAttrVal("Chknumbname", Chknumbname);
	}
	public String getChkdenorname() {
		return ((String) getAttrVal("Chkdenorname"));
	}	
	public void setChkdenorname(String Chkdenorname) {
		setAttrVal("Chkdenorname", Chkdenorname);
	}
	public FDouble getNumcap() {
		return ((FDouble) getAttrVal("Numcap"));
	}	
	public void setNumcap(FDouble Numcap) {
		setAttrVal("Numcap", Numcap);
	}
	public FDouble getNumfloor() {
		return ((FDouble) getAttrVal("Numfloor"));
	}	
	public void setNumfloor(FDouble Numfloor) {
		setAttrVal("Numfloor", Numfloor);
	}
	public FDouble getNumover() {
		return ((FDouble) getAttrVal("Numover"));
	}	
	public void setNumover(FDouble Numover) {
		setAttrVal("Numover", Numover);
	}
	public String getId_per_unit() {
		return ((String) getAttrVal("Id_per_unit"));
	}	
	public void setId_per_unit(String Id_per_unit) {
		setAttrVal("Id_per_unit", Id_per_unit);
	}
	public String getSd_per_unit() {
		return ((String) getAttrVal("Sd_per_unit"));
	}	
	public void setSd_per_unit(String Sd_per_unit) {
		setAttrVal("Sd_per_unit", Sd_per_unit);
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
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
	}
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
	public String getName_spcs() {
		return ((String) getAttrVal("Name_spcs"));
	}	
	public void setName_spcs(String Name_spcs) {
		setAttrVal("Name_spcs", Name_spcs);
	}
	public String getName_kpi_ca() {
		return ((String) getAttrVal("Name_kpi_ca"));
	}	
	public void setName_kpi_ca(String Name_kpi_ca) {
		setAttrVal("Name_kpi_ca", Name_kpi_ca);
	}
	public String getName_kpi_lvl() {
		return ((String) getAttrVal("Name_kpi_lvl"));
	}	
	public void setName_kpi_lvl(String Name_kpi_lvl) {
		setAttrVal("Name_kpi_lvl", Name_kpi_lvl);
	}
	public String getName_goal() {
		return ((String) getAttrVal("Name_goal"));
	}	
	public void setName_goal(String Name_goal) {
		setAttrVal("Name_goal", Name_goal);
	}
	public String getName_per_unit() {
		return ((String) getAttrVal("Name_per_unit"));
	}	
	public void setName_per_unit(String Name_per_unit) {
		setAttrVal("Name_per_unit", Name_per_unit);
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
		return "Id_nqm_spcs_kpi";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_SPCS_KPI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmSpcsKpiDoDesc.class);
	}
	
}