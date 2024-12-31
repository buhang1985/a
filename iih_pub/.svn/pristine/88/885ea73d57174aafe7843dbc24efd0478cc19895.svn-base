package iih.bd.srv.srvpkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvpkg.d.desc.SrvPkgContrDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务包合同模板 DO数据 
 * 
 */
public class SrvPkgContrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVPKGCONTR= "Id_srvpkgcontr";
	public static final String ID_SRVPKG= "Id_srvpkg";
	public static final String ID_CONTR= "Id_contr";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvpkgcontr() {
		return ((String) getAttrVal("Id_srvpkgcontr"));
	}	
	public void setId_srvpkgcontr(String Id_srvpkgcontr) {
		setAttrVal("Id_srvpkgcontr", Id_srvpkgcontr);
	}
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}	
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
	}
	public String getId_contr() {
		return ((String) getAttrVal("Id_contr"));
	}	
	public void setId_contr(String Id_contr) {
		setAttrVal("Id_contr", Id_contr);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
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
		return "Id_srvpkgcontr";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_pkg_contr";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvPkgContrDODesc.class);
	}
	
}