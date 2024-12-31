package iih.hr.hbd.psnplc.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hr.hbd.psnplc.d.desc.HbdPsnPlcDODesc;
import java.math.BigDecimal;

/**
 * 人员政治面貌 DO数据 
 * 
 */
public class HbdPsnPlcDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HBD_PSN_PLC= "Id_hbd_psn_plc";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String ID_STA_BEFOR= "Id_sta_befor";
	public static final String SD_STA_BEFOR= "Sd_sta_befor";
	public static final String ID_STA_AFTER= "Id_sta_after";
	public static final String SD_STA_AFTER= "Sd_sta_after";
	public static final String DT_CHANGE= "Dt_change";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_PSN_REG= "Id_psn_reg";
	public static final String DT_REG= "Dt_reg";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String NAME_BEFOR= "Name_befor";
	public static final String NAME_STA_AFTER= "Name_sta_after";
	public static final String NAME_PSN_REG= "Name_psn_reg";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hbd_psn_plc() {
		return ((String) getAttrVal("Id_hbd_psn_plc"));
	}	
	public void setId_hbd_psn_plc(String Id_hbd_psn_plc) {
		setAttrVal("Id_hbd_psn_plc", Id_hbd_psn_plc);
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
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public String getId_sta_befor() {
		return ((String) getAttrVal("Id_sta_befor"));
	}	
	public void setId_sta_befor(String Id_sta_befor) {
		setAttrVal("Id_sta_befor", Id_sta_befor);
	}
	public String getSd_sta_befor() {
		return ((String) getAttrVal("Sd_sta_befor"));
	}	
	public void setSd_sta_befor(String Sd_sta_befor) {
		setAttrVal("Sd_sta_befor", Sd_sta_befor);
	}
	public String getId_sta_after() {
		return ((String) getAttrVal("Id_sta_after"));
	}	
	public void setId_sta_after(String Id_sta_after) {
		setAttrVal("Id_sta_after", Id_sta_after);
	}
	public String getSd_sta_after() {
		return ((String) getAttrVal("Sd_sta_after"));
	}	
	public void setSd_sta_after(String Sd_sta_after) {
		setAttrVal("Sd_sta_after", Sd_sta_after);
	}
	public FDate getDt_change() {
		return ((FDate) getAttrVal("Dt_change"));
	}	
	public void setDt_change(FDate Dt_change) {
		setAttrVal("Dt_change", Dt_change);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getId_psn_reg() {
		return ((String) getAttrVal("Id_psn_reg"));
	}	
	public void setId_psn_reg(String Id_psn_reg) {
		setAttrVal("Id_psn_reg", Id_psn_reg);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getName_befor() {
		return ((String) getAttrVal("Name_befor"));
	}	
	public void setName_befor(String Name_befor) {
		setAttrVal("Name_befor", Name_befor);
	}
	public String getName_sta_after() {
		return ((String) getAttrVal("Name_sta_after"));
	}	
	public void setName_sta_after(String Name_sta_after) {
		setAttrVal("Name_sta_after", Name_sta_after);
	}
	public String getName_psn_reg() {
		return ((String) getAttrVal("Name_psn_reg"));
	}	
	public void setName_psn_reg(String Name_psn_reg) {
		setAttrVal("Name_psn_reg", Name_psn_reg);
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
		return "Id_hbd_psn_plc";
	}
	
	@Override
	public String getTableName() {	  
		return "HR_HBD_PSN_PLC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HbdPsnPlcDODesc.class);
	}
	
}