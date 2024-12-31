package iih.bd.srv.srvpkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvpkg.d.desc.SrvPkgDepDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务包适用科室 DO数据 
 * 
 */
public class SrvPkgDepDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVPKGDEP= "Id_srvpkgdep";
	public static final String ID_SRVPKG= "Id_srvpkg";
	public static final String ID_DEP= "Id_dep";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvpkgdep() {
		return ((String) getAttrVal("Id_srvpkgdep"));
	}	
	public void setId_srvpkgdep(String Id_srvpkgdep) {
		setAttrVal("Id_srvpkgdep", Id_srvpkgdep);
	}
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}	
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
		return "Id_srvpkgdep";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_pkg_dep";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvPkgDepDODesc.class);
	}
	
}