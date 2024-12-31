package iih.bd.srv.ortpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.ortpl.d.desc.OrTmplCaRelDODesc;
import java.math.BigDecimal;

/**
 * 医嘱模板与分类关系 DO数据 
 * 
 */
public class OrTmplCaRelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORTMPLCAREL= "Id_ortmplcarel";
	public static final String ID_ORTMPLCA= "Id_ortmplca";
	public static final String ID_ORTMPL= "Id_ortmpl";
	public static final String FG_SYNC= "Fg_sync";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ortmplcarel() {
		return ((String) getAttrVal("Id_ortmplcarel"));
	}	
	public void setId_ortmplcarel(String Id_ortmplcarel) {
		setAttrVal("Id_ortmplcarel", Id_ortmplcarel);
	}
	public String getId_ortmplca() {
		return ((String) getAttrVal("Id_ortmplca"));
	}	
	public void setId_ortmplca(String Id_ortmplca) {
		setAttrVal("Id_ortmplca", Id_ortmplca);
	}
	public String getId_ortmpl() {
		return ((String) getAttrVal("Id_ortmpl"));
	}	
	public void setId_ortmpl(String Id_ortmpl) {
		setAttrVal("Id_ortmpl", Id_ortmpl);
	}
	public FBoolean getFg_sync() {
		return ((FBoolean) getAttrVal("Fg_sync"));
	}	
	public void setFg_sync(FBoolean Fg_sync) {
		setAttrVal("Fg_sync", Fg_sync);
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
		return "Id_ortmplcarel";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_ortmpl_ca_rel";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrTmplCaRelDODesc.class);
	}
	
}