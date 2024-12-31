package iih.pi.overview.overview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.overview.overview.d.desc.PiPatObsDODesc;
import java.math.BigDecimal;

/**
 * 患者关键检查报告 DO数据 
 * 
 */
public class PiPatObsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATOBS= "Id_patobs";
	public static final String SD_DATASRC= "Sd_datasrc";
	public static final String ID_DATASRC= "Id_datasrc";
	public static final String ID_SRV= "Id_srv";
	public static final String NAME= "Name";
	public static final String DES= "Des";
	public static final String DES_LAB= "Des_lab";
	public static final String ADDR_PIC= "Addr_pic";
	public static final String DT_ACT= "Dt_act";
	public static final String DT_RPT= "Dt_rpt";
	public static final String SD_YMD_OBS= "Sd_ymd_obs";
	public static final String ID_YMD_OBS= "Id_ymd_obs";
	public static final String ID_PAT= "Id_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patobs() {
		return ((String) getAttrVal("Id_patobs"));
	}	
	public void setId_patobs(String Id_patobs) {
		setAttrVal("Id_patobs", Id_patobs);
	}
	public String getSd_datasrc() {
		return ((String) getAttrVal("Sd_datasrc"));
	}	
	public void setSd_datasrc(String Sd_datasrc) {
		setAttrVal("Sd_datasrc", Sd_datasrc);
	}
	public String getId_datasrc() {
		return ((String) getAttrVal("Id_datasrc"));
	}	
	public void setId_datasrc(String Id_datasrc) {
		setAttrVal("Id_datasrc", Id_datasrc);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getDes_lab() {
		return ((String) getAttrVal("Des_lab"));
	}	
	public void setDes_lab(String Des_lab) {
		setAttrVal("Des_lab", Des_lab);
	}
	public String getAddr_pic() {
		return ((String) getAttrVal("Addr_pic"));
	}	
	public void setAddr_pic(String Addr_pic) {
		setAttrVal("Addr_pic", Addr_pic);
	}
	public FDateTime getDt_act() {
		return ((FDateTime) getAttrVal("Dt_act"));
	}	
	public void setDt_act(FDateTime Dt_act) {
		setAttrVal("Dt_act", Dt_act);
	}
	public FDateTime getDt_rpt() {
		return ((FDateTime) getAttrVal("Dt_rpt"));
	}	
	public void setDt_rpt(FDateTime Dt_rpt) {
		setAttrVal("Dt_rpt", Dt_rpt);
	}
	public String getSd_ymd_obs() {
		return ((String) getAttrVal("Sd_ymd_obs"));
	}	
	public void setSd_ymd_obs(String Sd_ymd_obs) {
		setAttrVal("Sd_ymd_obs", Sd_ymd_obs);
	}
	public Integer getId_ymd_obs() {
		return ((Integer) getAttrVal("Id_ymd_obs"));
	}	
	public void setId_ymd_obs(Integer Id_ymd_obs) {
		setAttrVal("Id_ymd_obs", Id_ymd_obs);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
		return "Id_patobs";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_obs";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatObsDODesc.class);
	}
	
}