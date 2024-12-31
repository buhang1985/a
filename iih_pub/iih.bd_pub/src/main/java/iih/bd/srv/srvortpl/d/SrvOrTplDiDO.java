package iih.bd.srv.srvortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvortpl.d.desc.SrvOrTplDiDODesc;
import java.math.BigDecimal;

/**
 * 服务医嘱模板疾病 DO数据 
 * 
 */
public class SrvOrTplDiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVORTPLDI= "Id_srvortpldi";
	public static final String ID_DI= "Id_di";
	public static final String SORTNO= "Sortno";
	public static final String ID_SRVORTPL= "Id_srvortpl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvortpldi() {
		return ((String) getAttrVal("Id_srvortpldi"));
	}	
	public void setId_srvortpldi(String Id_srvortpldi) {
		setAttrVal("Id_srvortpldi", Id_srvortpldi);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_srvortpl() {
		return ((String) getAttrVal("Id_srvortpl"));
	}	
	public void setId_srvortpl(String Id_srvortpl) {
		setAttrVal("Id_srvortpl", Id_srvortpl);
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
		return "Id_srvortpldi";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_or_tpl_di";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvOrTplDiDODesc.class);
	}
	
}