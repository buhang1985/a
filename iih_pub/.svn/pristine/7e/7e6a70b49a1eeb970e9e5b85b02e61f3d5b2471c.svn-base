package iih.bd.srv.srvpkggrpitm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvpkggrpitm.d.desc.SrvPkgItmSrvContrastDODesc;
import java.math.BigDecimal;

/**
 * 服务包项目服务对照 DO数据 
 * 
 */
public class SrvPkgItmSrvContrastDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVPKGITMCOMP= "Id_srvpkgitmcomp";
	public static final String ID_SRVPKGITM= "Id_srvpkgitm";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_ROUTE= "Id_route";
	public static final String ID_FREQ= "Id_freq";
	public static final String ID_UNIT_MED= "Id_unit_med";
	public static final String QUAN_MED= "Quan_med";
	public static final String ID_PRIMODE= "Id_primode";
	public static final String SD_PRIMODE= "Sd_primode";
	public static final String DES= "Des";
	public static final String ID_OPENTP= "Id_opentp";
	public static final String SD_OPENTP= "Sd_opentp";
	public static final String DAYS_SRV= "Days_srv";
	public static final String QUAN_MIN= "Quan_min";
	public static final String QUAN_MAX= "Quan_max";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvpkgitmcomp() {
		return ((String) getAttrVal("Id_srvpkgitmcomp"));
	}	
	public void setId_srvpkgitmcomp(String Id_srvpkgitmcomp) {
		setAttrVal("Id_srvpkgitmcomp", Id_srvpkgitmcomp);
	}
	public String getId_srvpkgitm() {
		return ((String) getAttrVal("Id_srvpkgitm"));
	}	
	public void setId_srvpkgitm(String Id_srvpkgitm) {
		setAttrVal("Id_srvpkgitm", Id_srvpkgitm);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}	
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	public String getId_primode() {
		return ((String) getAttrVal("Id_primode"));
	}	
	public void setId_primode(String Id_primode) {
		setAttrVal("Id_primode", Id_primode);
	}
	public String getSd_primode() {
		return ((String) getAttrVal("Sd_primode"));
	}	
	public void setSd_primode(String Sd_primode) {
		setAttrVal("Sd_primode", Sd_primode);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public String getId_opentp() {
		return ((String) getAttrVal("Id_opentp"));
	}	
	public void setId_opentp(String Id_opentp) {
		setAttrVal("Id_opentp", Id_opentp);
	}
	public String getSd_opentp() {
		return ((String) getAttrVal("Sd_opentp"));
	}	
	public void setSd_opentp(String Sd_opentp) {
		setAttrVal("Sd_opentp", Sd_opentp);
	}
	public Integer getDays_srv() {
		return ((Integer) getAttrVal("Days_srv"));
	}	
	public void setDays_srv(Integer Days_srv) {
		setAttrVal("Days_srv", Days_srv);
	}
	public Integer getQuan_min() {
		return ((Integer) getAttrVal("Quan_min"));
	}	
	public void setQuan_min(Integer Quan_min) {
		setAttrVal("Quan_min", Quan_min);
	}
	public Integer getQuan_max() {
		return ((Integer) getAttrVal("Quan_max"));
	}	
	public void setQuan_max(Integer Quan_max) {
		setAttrVal("Quan_max", Quan_max);
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
		return "Id_srvpkgitmcomp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_pkg_itm_comp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvPkgItmSrvContrastDODesc.class);
	}
	
}