package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.desc.OrTplItmSetDODesc;
import java.math.BigDecimal;

/**
 * 医嘱模板项目套明细 DO数据 
 * 
 */
public class OrTplItmSetDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVORTPLORSET= "Id_srvortplorset";
	public static final String ID_SRVORTPLOR= "Id_srvortplor";
	public static final String ID_SRV= "Id_srv";
	public static final String CODE_SRV= "Code_srv";
	public static final String NAME_SRV= "Name_srv";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvortplorset() {
		return ((String) getAttrVal("Id_srvortplorset"));
	}	
	public void setId_srvortplorset(String Id_srvortplorset) {
		setAttrVal("Id_srvortplorset", Id_srvortplorset);
	}
	public String getId_srvortplor() {
		return ((String) getAttrVal("Id_srvortplor"));
	}	
	public void setId_srvortplor(String Id_srvortplor) {
		setAttrVal("Id_srvortplor", Id_srvortplor);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
		return "Id_srvortplorset";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_ortpl_or_set";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrTplItmSetDODesc.class);
	}
	
}