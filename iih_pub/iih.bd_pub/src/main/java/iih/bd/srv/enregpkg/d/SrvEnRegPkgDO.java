package iih.bd.srv.enregpkg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.enregpkg.d.desc.SrvEnRegPkgDODesc;
import java.math.BigDecimal;

/**
 * 服务就诊登记包 DO数据 
 * 
 */
public class SrvEnRegPkgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVENREGPKG= "Id_srvenregpkg";
	public static final String ID_ENTP= "Id_entp";
	public static final String SD_ENTP= "Sd_entp";
	public static final String ID_SRV= "Id_srv";
	public static final String FG_EDIT= "Fg_edit";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvenregpkg() {
		return ((String) getAttrVal("Id_srvenregpkg"));
	}	
	public void setId_srvenregpkg(String Id_srvenregpkg) {
		setAttrVal("Id_srvenregpkg", Id_srvenregpkg);
	}
	
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}	
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
	}
	
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	public FBoolean getFg_edit() {
		return ((FBoolean) getAttrVal("Fg_edit"));
	}	
	public void setFg_edit(FBoolean Fg_edit) {
		setAttrVal("Fg_edit", Fg_edit);
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
		return "Id_srvenregpkg";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_enreg_pkg";
	}
	
	@Override
	public IDODesc getDODesc() {		
		return DescManager.getInstance().getDODesc(SrvEnRegPkgDODesc.class);
	}
	
}