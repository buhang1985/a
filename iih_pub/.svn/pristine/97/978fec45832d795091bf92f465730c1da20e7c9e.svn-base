package iih.bd.pp.bddepcg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.bddepcg.d.desc.BdDepCgItmDODesc;
import java.math.BigDecimal;

/**
 * 科室补费策略_明细 DO数据 
 * 
 */
public class BdDepCgItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DEPCG_ITM= "Id_depcg_itm";
	public static final String ID_DEPCG= "Id_depcg";
	public static final String ID_SRV= "Id_srv";
	public static final String SRVCODE= "Srvcode";
	public static final String SRVNAME= "Srvname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_depcg_itm() {
		return ((String) getAttrVal("Id_depcg_itm"));
	}	
	public void setId_depcg_itm(String Id_depcg_itm) {
		setAttrVal("Id_depcg_itm", Id_depcg_itm);
	}
	public String getId_depcg() {
		return ((String) getAttrVal("Id_depcg"));
	}	
	public void setId_depcg(String Id_depcg) {
		setAttrVal("Id_depcg", Id_depcg);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}	
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}	
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
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
		return "Id_depcg_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_dep_cg_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdDepCgItmDODesc.class);
	}
	
}