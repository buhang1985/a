package iih.pi.patsrvpkg.pipatsrvpkgitem.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pi.patsrvpkg.pipatsrvpkgitem.d.desc.PiPatSrvPkgItemCompDODesc;
import java.math.BigDecimal;

/**
 * 患者服务包服务项目对照 DO数据 
 * 
 */
public class PiPatSrvPkgItemCompDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PATSRVPKGSRV= "Id_patsrvpkgsrv";
	public static final String ID_PATSRVPKGITM= "Id_patsrvpkgitm";
	public static final String ID_SRVPKGITMCOMP= "Id_srvpkgitmcomp";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_USAGE= "Id_usage";
	public static final String ID_FREG= "Id_freg";
	public static final String QUAN_MED= "Quan_med";
	public static final String ID_UNIT= "Id_unit";
	public static final String NOTE= "Note";
	public static final String ID_OPENTP= "Id_opentp";
	public static final String SD_OPENTP= "Sd_opentp";
	public static final String DAYS_SRV= "Days_srv";
	public static final String QUAN_MIN= "Quan_min";
	public static final String QUAN_MAX= "Quan_max";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_patsrvpkgsrv() {
		return ((String) getAttrVal("Id_patsrvpkgsrv"));
	}	
	public void setId_patsrvpkgsrv(String Id_patsrvpkgsrv) {
		setAttrVal("Id_patsrvpkgsrv", Id_patsrvpkgsrv);
	}
	public String getId_patsrvpkgitm() {
		return ((String) getAttrVal("Id_patsrvpkgitm"));
	}	
	public void setId_patsrvpkgitm(String Id_patsrvpkgitm) {
		setAttrVal("Id_patsrvpkgitm", Id_patsrvpkgitm);
	}
	public String getId_srvpkgitmcomp() {
		return ((String) getAttrVal("Id_srvpkgitmcomp"));
	}	
	public void setId_srvpkgitmcomp(String Id_srvpkgitmcomp) {
		setAttrVal("Id_srvpkgitmcomp", Id_srvpkgitmcomp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_usage() {
		return ((String) getAttrVal("Id_usage"));
	}	
	public void setId_usage(String Id_usage) {
		setAttrVal("Id_usage", Id_usage);
	}
	public String getId_freg() {
		return ((String) getAttrVal("Id_freg"));
	}	
	public void setId_freg(String Id_freg) {
		setAttrVal("Id_freg", Id_freg);
	}
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}	
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_patsrvpkgsrv";
	}
	
	@Override
	public String getTableName() {	  
		return "pi_pat_srv_pkg_itm_comp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PiPatSrvPkgItemCompDODesc.class);
	}
	
}