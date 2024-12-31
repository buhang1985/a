package iih.nm.nhr.nhrscheditm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nhrscheditm.d.desc.NhrSchedItmDODesc;
import java.math.BigDecimal;

/**
 * 人员排班明细 DO数据 
 * 
 */
public class NhrSchedItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NHR_SCHED_ITM= "Id_nhr_sched_itm";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NHR_SCHED= "Id_nhr_sched";
	public static final String ID_NHR_SI= "Id_nhr_si";
	public static final String NAME_NHR_SI= "Name_nhr_si";
	public static final String DT_BEON= "Dt_beon";
	public static final String DT_OFF= "Dt_off";
	public static final String ID_CHK_CA= "Id_chk_ca";
	public static final String SD_CHK_CA= "Sd_chk_ca";
	public static final String DUR_CHK_CA= "Dur_chk_ca";
	public static final String ID_SICA= "Id_sica";
	public static final String SD_SICA= "Sd_sica";
	public static final String ID_SIPRO= "Id_sipro";
	public static final String SD_SIPRO= "Sd_sipro";
	public static final String DES= "Des";
	public static final String ID_CHK_STATUS= "Id_chk_status";
	public static final String SD_CHK_STATUS= "Sd_chk_status";
	public static final String FG_OVERTIME= "Fg_overtime";
	public static final String DUR_CHK_CA_ADD= "Dur_chk_ca_add";
	public static final String ID_CHK_CA_ADD= "Id_chk_ca_add";
	public static final String SD_CHK_CA_ADD= "Sd_chk_ca_add";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_CHK_CA= "Name_chk_ca";
	public static final String NAME_SICA= "Name_sica";
	public static final String NAME_SIPRO= "Name_sipro";
	public static final String NAME_CHK_STATUS= "Name_chk_status";
	public static final String NAME_CHK_CA_ADD= "Name_chk_ca_add";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nhr_sched_itm() {
		return ((String) getAttrVal("Id_nhr_sched_itm"));
	}	
	public void setId_nhr_sched_itm(String Id_nhr_sched_itm) {
		setAttrVal("Id_nhr_sched_itm", Id_nhr_sched_itm);
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
	public String getId_nhr_sched() {
		return ((String) getAttrVal("Id_nhr_sched"));
	}	
	public void setId_nhr_sched(String Id_nhr_sched) {
		setAttrVal("Id_nhr_sched", Id_nhr_sched);
	}
	public String getId_nhr_si() {
		return ((String) getAttrVal("Id_nhr_si"));
	}	
	public void setId_nhr_si(String Id_nhr_si) {
		setAttrVal("Id_nhr_si", Id_nhr_si);
	}
	public String getName_nhr_si() {
		return ((String) getAttrVal("Name_nhr_si"));
	}	
	public void setName_nhr_si(String Name_nhr_si) {
		setAttrVal("Name_nhr_si", Name_nhr_si);
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
		return "Id_nhr_sched_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_SCHED_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NhrSchedItmDODesc.class);
	}
	
}