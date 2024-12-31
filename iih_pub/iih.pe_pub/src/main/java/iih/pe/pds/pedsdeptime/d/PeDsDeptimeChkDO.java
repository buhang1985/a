package iih.pe.pds.pedsdeptime.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pds.pedsdeptime.d.desc.PeDsDeptimeChkDODesc;
import java.math.BigDecimal;

/**
 * 体检科室检查时间优化推荐 DO数据 
 * 
 */
public class PeDsDeptimeChkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEDSDEPTIMECHK= "Id_pedsdeptimechk";
	public static final String ID_PEDSDEPTIME= "Id_pedsdeptime";
	public static final String ID_PEDEPTSET= "Id_pedeptset";
	public static final String CHKDURATIONOPT= "Chkdurationopt";
	public static final String AVGTIME= "Avgtime";
	public static final String CODE_DEP= "Code_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String CHKDURATIONTP= "Chkdurationtp";
	public static final String CHKDURATION= "Chkduration";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pedsdeptimechk() {
		return ((String) getAttrVal("Id_pedsdeptimechk"));
	}	
	public void setId_pedsdeptimechk(String Id_pedsdeptimechk) {
		setAttrVal("Id_pedsdeptimechk", Id_pedsdeptimechk);
	}
	public String getId_pedsdeptime() {
		return ((String) getAttrVal("Id_pedsdeptime"));
	}	
	public void setId_pedsdeptime(String Id_pedsdeptime) {
		setAttrVal("Id_pedsdeptime", Id_pedsdeptime);
	}
	public String getId_pedeptset() {
		return ((String) getAttrVal("Id_pedeptset"));
	}	
	public void setId_pedeptset(String Id_pedeptset) {
		setAttrVal("Id_pedeptset", Id_pedeptset);
	}
	public Integer getChkdurationopt() {
		return ((Integer) getAttrVal("Chkdurationopt"));
	}	
	public void setChkdurationopt(Integer Chkdurationopt) {
		setAttrVal("Chkdurationopt", Chkdurationopt);
	}
	public FDouble getAvgtime() {
		return ((FDouble) getAttrVal("Avgtime"));
	}	
	public void setAvgtime(FDouble Avgtime) {
		setAttrVal("Avgtime", Avgtime);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public Integer getChkdurationtp() {
		return ((Integer) getAttrVal("Chkdurationtp"));
	}	
	public void setChkdurationtp(Integer Chkdurationtp) {
		setAttrVal("Chkdurationtp", Chkdurationtp);
	}
	public Integer getChkduration() {
		return ((Integer) getAttrVal("Chkduration"));
	}	
	public void setChkduration(Integer Chkduration) {
		setAttrVal("Chkduration", Chkduration);
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
		return "Id_pedsdeptimechk";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ds_pedsdeptimechkdu";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeDsDeptimeChkDODesc.class);
	}
	
}