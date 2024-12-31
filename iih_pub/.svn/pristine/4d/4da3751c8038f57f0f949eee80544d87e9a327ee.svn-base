package iih.sc.apt.scapt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.scapt.d.desc.ScAptIpDODesc;
import java.math.BigDecimal;

/**
 * 计划排班_预约_住院 DO数据 
 * 
 */
public class ScAptIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APTIP= "Id_aptip";
	public static final String ID_APT= "Id_apt";
	public static final String SD_APPT_IP= "Sd_appt_ip";
	public static final String ID_APPT_IP= "Id_appt_ip";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_DEP_NU= "Id_dep_nu";
	public static final String SD_BEDTP= "Sd_bedtp";
	public static final String ID_BEDTP= "Id_bedtp";
	public static final String ID_BED= "Id_bed";
	public static final String FG_EN= "Fg_en";
	public static final String DT_EN= "Dt_en";
	public static final String ID_EN= "Id_en";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}	
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	public String getSd_appt_ip() {
		return ((String) getAttrVal("Sd_appt_ip"));
	}	
	public void setSd_appt_ip(String Sd_appt_ip) {
		setAttrVal("Sd_appt_ip", Sd_appt_ip);
	}
	public String getId_appt_ip() {
		return ((String) getAttrVal("Id_appt_ip"));
	}	
	public void setId_appt_ip(String Id_appt_ip) {
		setAttrVal("Id_appt_ip", Id_appt_ip);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getId_dep_nu() {
		return ((String) getAttrVal("Id_dep_nu"));
	}	
	public void setId_dep_nu(String Id_dep_nu) {
		setAttrVal("Id_dep_nu", Id_dep_nu);
	}
	public String getSd_bedtp() {
		return ((String) getAttrVal("Sd_bedtp"));
	}	
	public void setSd_bedtp(String Sd_bedtp) {
		setAttrVal("Sd_bedtp", Sd_bedtp);
	}
	public String getId_bedtp() {
		return ((String) getAttrVal("Id_bedtp"));
	}	
	public void setId_bedtp(String Id_bedtp) {
		setAttrVal("Id_bedtp", Id_bedtp);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public FBoolean getFg_en() {
		return ((FBoolean) getAttrVal("Fg_en"));
	}	
	public void setFg_en(FBoolean Fg_en) {
		setAttrVal("Fg_en", Fg_en);
	}
	public FDateTime getDt_en() {
		return ((FDateTime) getAttrVal("Dt_en"));
	}	
	public void setDt_en(FDateTime Dt_en) {
		setAttrVal("Dt_en", Dt_en);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
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
		return "Id_aptip";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_scaptip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ScAptIpDODesc.class);
	}
	
}