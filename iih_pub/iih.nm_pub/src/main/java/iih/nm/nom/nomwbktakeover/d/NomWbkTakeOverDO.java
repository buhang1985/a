package iih.nm.nom.nomwbktakeover.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomwbktakeover.d.desc.NomWbkTakeOverDODesc;
import java.math.BigDecimal;

/**
 * 护士长手册交接 DO数据 
 * 
 */
public class NomWbkTakeOverDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_WBK_TAKEOVER= "Id_nom_wbk_takeover";
	public static final String ID_NOM_WBK_APP= "Id_nom_wbk_app";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String YEAR= "Year";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_NUR_HEAD_OLD= "Id_nur_head_old";
	public static final String ID_NUR_HEAD_NEW= "Id_nur_head_new";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_STATUS= "Id_status";
	public static final String SD_STATUS= "Sd_status";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_WBK= "Name_wbk";
	public static final String DEPT_NAME= "Dept_name";
	public static final String HEAD_OLD_NAME= "Head_old_name";
	public static final String HEAD_NEW_NAME= "Head_new_name";
	public static final String STATUS_NAME= "Status_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_wbk_takeover() {
		return ((String) getAttrVal("Id_nom_wbk_takeover"));
	}	
	public void setId_nom_wbk_takeover(String Id_nom_wbk_takeover) {
		setAttrVal("Id_nom_wbk_takeover", Id_nom_wbk_takeover);
	}
	public String getId_nom_wbk_app() {
		return ((String) getAttrVal("Id_nom_wbk_app"));
	}	
	public void setId_nom_wbk_app(String Id_nom_wbk_app) {
		setAttrVal("Id_nom_wbk_app", Id_nom_wbk_app);
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
	public Integer getYear() {
		return ((Integer) getAttrVal("Year"));
	}	
	public void setYear(Integer Year) {
		setAttrVal("Year", Year);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_nur_head_old() {
		return ((String) getAttrVal("Id_nur_head_old"));
	}	
	public void setId_nur_head_old(String Id_nur_head_old) {
		setAttrVal("Id_nur_head_old", Id_nur_head_old);
	}
	public String getId_nur_head_new() {
		return ((String) getAttrVal("Id_nur_head_new"));
	}	
	public void setId_nur_head_new(String Id_nur_head_new) {
		setAttrVal("Id_nur_head_new", Id_nur_head_new);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
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
	public String getName_wbk() {
		return ((String) getAttrVal("Name_wbk"));
	}	
	public void setName_wbk(String Name_wbk) {
		setAttrVal("Name_wbk", Name_wbk);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	public String getHead_old_name() {
		return ((String) getAttrVal("Head_old_name"));
	}	
	public void setHead_old_name(String Head_old_name) {
		setAttrVal("Head_old_name", Head_old_name);
	}
	public String getHead_new_name() {
		return ((String) getAttrVal("Head_new_name"));
	}	
	public void setHead_new_name(String Head_new_name) {
		setAttrVal("Head_new_name", Head_new_name);
	}
	public String getStatus_name() {
		return ((String) getAttrVal("Status_name"));
	}	
	public void setStatus_name(String Status_name) {
		setAttrVal("Status_name", Status_name);
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
		return "Id_nom_wbk_takeover";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_WBK_TAKEOVER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomWbkTakeOverDODesc.class);
	}
	
}