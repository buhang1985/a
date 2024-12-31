package iih.hr.hsc.hscschedweek.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hr.hsc.hscschedweek.d.desc.HscSchedDODesc;
import java.math.BigDecimal;

/**
 * 排班表 DO数据 
 * 
 */
public class HscSchedDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HSC_SCHED= "Id_hsc_sched";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_HSC_SCHED_WEEK= "Id_hsc_sched_week";
	public static final String ID_DEP= "Id_dep";
	public static final String DT_SCHED_DATE= "Dt_sched_date";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String DT_SCHED_TIME= "Dt_sched_time";
	public static final String ID_HSC_SCHED_LV= "Id_hsc_sched_lv";
	public static final String ID_REG_PSN= "Id_reg_psn";
	public static final String DT_REG= "Dt_reg";
	public static final String ID_HSC_SI= "Id_hsc_si";
	public static final String NAME_HSC_SI= "Name_hsc_si";
	public static final String DT_BEON= "Dt_beon";
	public static final String DT_OFF= "Dt_off";
	public static final String ID_CHK_CA= "Id_chk_ca";
	public static final String SD_CHK_CA= "Sd_chk_ca";
	public static final String DUR_CHK_CA= "Dur_chk_ca";
	public static final String ID_SICA= "Id_sica";
	public static final String SD_SICA= "Sd_sica";
	public static final String ID_SIPRO= "Id_sipro";
	public static final String SD_SIPRO= "Sd_sipro";
	public static final String SORTNO_DAY= "Sortno_day";
	public static final String DES= "Des";
	public static final String ID_CHK_STATUS= "Id_chk_status";
	public static final String SD_CHK_STATUS= "Sd_chk_status";
	public static final String FG_OVERTIME= "Fg_overtime";
	public static final String DUR_CHK_CA_ADD= "Dur_chk_ca_add";
	public static final String ID_CHK_CA_ADD= "Id_chk_ca_add";
	public static final String SD_CHK_CA_ADD= "Sd_chk_ca_add";
	public static final String DT_BEON2= "Dt_beon2";
	public static final String DT_OFF2= "Dt_off2";
	public static final String CTRL1= "Ctrl1";
	public static final String CTRL2= "Ctrl2";
	public static final String CTRL3= "Ctrl3";
	public static final String CTRL4= "Ctrl4";
	public static final String CTRL5= "Ctrl5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String NAME_PSNDOC= "Name_psndoc";
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String NAME_HSCSI= "Name_hscsi";
	public static final String NAME_CHK_CA= "Name_chk_ca";
	public static final String NAME_SICA= "Name_sica";
	public static final String NAME_SIPRO= "Name_sipro";
	public static final String NAME_CHK_STATUS= "Name_chk_status";
	public static final String NAME_CHK_CA_ADD= "Name_chk_ca_add";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hsc_sched() {
		return ((String) getAttrVal("Id_hsc_sched"));
	}	
	public void setId_hsc_sched(String Id_hsc_sched) {
		setAttrVal("Id_hsc_sched", Id_hsc_sched);
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
	public String getId_hsc_sched_week() {
		return ((String) getAttrVal("Id_hsc_sched_week"));
	}	
	public void setId_hsc_sched_week(String Id_hsc_sched_week) {
		setAttrVal("Id_hsc_sched_week", Id_hsc_sched_week);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FDate getDt_sched_date() {
		return ((FDate) getAttrVal("Dt_sched_date"));
	}	
	public void setDt_sched_date(FDate Dt_sched_date) {
		setAttrVal("Dt_sched_date", Dt_sched_date);
	}
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public FDateTime getDt_sched_time() {
		return ((FDateTime) getAttrVal("Dt_sched_time"));
	}	
	public void setDt_sched_time(FDateTime Dt_sched_time) {
		setAttrVal("Dt_sched_time", Dt_sched_time);
	}
	public String getId_hsc_sched_lv() {
		return ((String) getAttrVal("Id_hsc_sched_lv"));
	}	
	public void setId_hsc_sched_lv(String Id_hsc_sched_lv) {
		setAttrVal("Id_hsc_sched_lv", Id_hsc_sched_lv);
	}
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	public String getId_hsc_si() {
		return ((String) getAttrVal("Id_hsc_si"));
	}	
	public void setId_hsc_si(String Id_hsc_si) {
		setAttrVal("Id_hsc_si", Id_hsc_si);
	}
	public String getName_hsc_si() {
		return ((String) getAttrVal("Name_hsc_si"));
	}	
	public void setName_hsc_si(String Name_hsc_si) {
		setAttrVal("Name_hsc_si", Name_hsc_si);
	}
	public FDateTime getDt_beon() {
		return ((FDateTime) getAttrVal("Dt_beon"));
	}	
	public void setDt_beon(FDateTime Dt_beon) {
		setAttrVal("Dt_beon", Dt_beon);
	}
	public FDateTime getDt_off() {
		return ((FDateTime) getAttrVal("Dt_off"));
	}	
	public void setDt_off(FDateTime Dt_off) {
		setAttrVal("Dt_off", Dt_off);
	}
	public String getId_chk_ca() {
		return ((String) getAttrVal("Id_chk_ca"));
	}	
	public void setId_chk_ca(String Id_chk_ca) {
		setAttrVal("Id_chk_ca", Id_chk_ca);
	}
	public String getSd_chk_ca() {
		return ((String) getAttrVal("Sd_chk_ca"));
	}	
	public void setSd_chk_ca(String Sd_chk_ca) {
		setAttrVal("Sd_chk_ca", Sd_chk_ca);
	}
	public FDouble getDur_chk_ca() {
		return ((FDouble) getAttrVal("Dur_chk_ca"));
	}	
	public void setDur_chk_ca(FDouble Dur_chk_ca) {
		setAttrVal("Dur_chk_ca", Dur_chk_ca);
	}
	public String getId_sica() {
		return ((String) getAttrVal("Id_sica"));
	}	
	public void setId_sica(String Id_sica) {
		setAttrVal("Id_sica", Id_sica);
	}
	public String getSd_sica() {
		return ((String) getAttrVal("Sd_sica"));
	}	
	public void setSd_sica(String Sd_sica) {
		setAttrVal("Sd_sica", Sd_sica);
	}
	public String getId_sipro() {
		return ((String) getAttrVal("Id_sipro"));
	}	
	public void setId_sipro(String Id_sipro) {
		setAttrVal("Id_sipro", Id_sipro);
	}
	public String getSd_sipro() {
		return ((String) getAttrVal("Sd_sipro"));
	}	
	public void setSd_sipro(String Sd_sipro) {
		setAttrVal("Sd_sipro", Sd_sipro);
	}
	public Integer getSortno_day() {
		return ((Integer) getAttrVal("Sortno_day"));
	}	
	public void setSortno_day(Integer Sortno_day) {
		setAttrVal("Sortno_day", Sortno_day);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_chk_status() {
		return ((String) getAttrVal("Id_chk_status"));
	}	
	public void setId_chk_status(String Id_chk_status) {
		setAttrVal("Id_chk_status", Id_chk_status);
	}
	public String getSd_chk_status() {
		return ((String) getAttrVal("Sd_chk_status"));
	}	
	public void setSd_chk_status(String Sd_chk_status) {
		setAttrVal("Sd_chk_status", Sd_chk_status);
	}
	public FBoolean getFg_overtime() {
		return ((FBoolean) getAttrVal("Fg_overtime"));
	}	
	public void setFg_overtime(FBoolean Fg_overtime) {
		setAttrVal("Fg_overtime", Fg_overtime);
	}
	public FDouble getDur_chk_ca_add() {
		return ((FDouble) getAttrVal("Dur_chk_ca_add"));
	}	
	public void setDur_chk_ca_add(FDouble Dur_chk_ca_add) {
		setAttrVal("Dur_chk_ca_add", Dur_chk_ca_add);
	}
	public String getId_chk_ca_add() {
		return ((String) getAttrVal("Id_chk_ca_add"));
	}	
	public void setId_chk_ca_add(String Id_chk_ca_add) {
		setAttrVal("Id_chk_ca_add", Id_chk_ca_add);
	}
	public String getSd_chk_ca_add() {
		return ((String) getAttrVal("Sd_chk_ca_add"));
	}	
	public void setSd_chk_ca_add(String Sd_chk_ca_add) {
		setAttrVal("Sd_chk_ca_add", Sd_chk_ca_add);
	}
	public FDateTime getDt_beon2() {
		return ((FDateTime) getAttrVal("Dt_beon2"));
	}	
	public void setDt_beon2(FDateTime Dt_beon2) {
		setAttrVal("Dt_beon2", Dt_beon2);
	}
	public FDateTime getDt_off2() {
		return ((FDateTime) getAttrVal("Dt_off2"));
	}	
	public void setDt_off2(FDateTime Dt_off2) {
		setAttrVal("Dt_off2", Dt_off2);
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
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}	
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
	}
	public String getName_hscsi() {
		return ((String) getAttrVal("Name_hscsi"));
	}	
	public void setName_hscsi(String Name_hscsi) {
		setAttrVal("Name_hscsi", Name_hscsi);
	}
	public String getName_chk_ca() {
		return ((String) getAttrVal("Name_chk_ca"));
	}	
	public void setName_chk_ca(String Name_chk_ca) {
		setAttrVal("Name_chk_ca", Name_chk_ca);
	}
	public String getName_sica() {
		return ((String) getAttrVal("Name_sica"));
	}	
	public void setName_sica(String Name_sica) {
		setAttrVal("Name_sica", Name_sica);
	}
	public String getName_sipro() {
		return ((String) getAttrVal("Name_sipro"));
	}	
	public void setName_sipro(String Name_sipro) {
		setAttrVal("Name_sipro", Name_sipro);
	}
	public String getName_chk_status() {
		return ((String) getAttrVal("Name_chk_status"));
	}	
	public void setName_chk_status(String Name_chk_status) {
		setAttrVal("Name_chk_status", Name_chk_status);
	}
	public String getName_chk_ca_add() {
		return ((String) getAttrVal("Name_chk_ca_add"));
	}	
	public void setName_chk_ca_add(String Name_chk_ca_add) {
		setAttrVal("Name_chk_ca_add", Name_chk_ca_add);
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
		return "Id_hsc_sched";
	}
	
	@Override
	public String getTableName() {	  
		return "HR_HSC_SCHED";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HscSchedDODesc.class);
	}
	
}