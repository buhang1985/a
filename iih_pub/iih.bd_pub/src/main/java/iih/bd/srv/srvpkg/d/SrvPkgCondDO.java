package iih.bd.srv.srvpkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvpkg.d.desc.SrvPkgCondDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务包条件 DO数据 
 * 
 */
public class SrvPkgCondDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVPKGCOND= "Id_srvpkgcond";
	public static final String ID_SRVPKG= "Id_srvpkg";
	public static final String ID_SRVPKGCONDTP= "Id_srvpkgcondtp";
	public static final String SD_SRVPKGCONDTP= "Sd_srvpkgcondtp";
	public static final String SORTNO= "Sortno";
	public static final String CONDSTR= "Condstr";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvpkgcond() {
		return ((String) getAttrVal("Id_srvpkgcond"));
	}	
	public void setId_srvpkgcond(String Id_srvpkgcond) {
		setAttrVal("Id_srvpkgcond", Id_srvpkgcond);
	}
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}	
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
	}
	public String getId_srvpkgcondtp() {
		return ((String) getAttrVal("Id_srvpkgcondtp"));
	}	
	public void setId_srvpkgcondtp(String Id_srvpkgcondtp) {
		setAttrVal("Id_srvpkgcondtp", Id_srvpkgcondtp);
	}
	public String getSd_srvpkgcondtp() {
		return ((String) getAttrVal("Sd_srvpkgcondtp"));
	}	
	public void setSd_srvpkgcondtp(String Sd_srvpkgcondtp) {
		setAttrVal("Sd_srvpkgcondtp", Sd_srvpkgcondtp);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getCondstr() {
		return ((String) getAttrVal("Condstr"));
	}	
	public void setCondstr(String Condstr) {
		setAttrVal("Condstr", Condstr);
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
		return "Id_srvpkgcond";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_pkg_cond";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvPkgCondDODesc.class);
	}
	
}