package iih.bd.srv.srvrtctl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvrtctl.d.desc.SrvRtTitleRefDODesc;
import java.math.BigDecimal;

/**
 * 服务开立控制与职称关系 DO数据 
 * 
 */
public class SrvRtTitleRefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVRTTITLEREF= "Id_srvrttitleref";
	public static final String ID_SRVRT= "Id_srvrt";
	public static final String ID_EMP_TITLE= "Id_emp_title";
	public static final String SD_EMP_TITLE= "Sd_emp_title";
	public static final String TITLEREFSRVRTCODE= "Titlerefsrvrtcode";
	public static final String TITLEREFSRVRTNAME= "Titlerefsrvrtname";
	public static final String IDEMPTITLECODE= "Idemptitlecode";
	public static final String IDEMPTITLENAME= "Idemptitlename";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvrttitleref() {
		return ((String) getAttrVal("Id_srvrttitleref"));
	}	
	public void setId_srvrttitleref(String Id_srvrttitleref) {
		setAttrVal("Id_srvrttitleref", Id_srvrttitleref);
	}
	public String getId_srvrt() {
		return ((String) getAttrVal("Id_srvrt"));
	}	
	public void setId_srvrt(String Id_srvrt) {
		setAttrVal("Id_srvrt", Id_srvrt);
	}
	public String getId_emp_title() {
		return ((String) getAttrVal("Id_emp_title"));
	}	
	public void setId_emp_title(String Id_emp_title) {
		setAttrVal("Id_emp_title", Id_emp_title);
	}
	public String getSd_emp_title() {
		return ((String) getAttrVal("Sd_emp_title"));
	}	
	public void setSd_emp_title(String Sd_emp_title) {
		setAttrVal("Sd_emp_title", Sd_emp_title);
	}
	public String getTitlerefsrvrtcode() {
		return ((String) getAttrVal("Titlerefsrvrtcode"));
	}	
	public void setTitlerefsrvrtcode(String Titlerefsrvrtcode) {
		setAttrVal("Titlerefsrvrtcode", Titlerefsrvrtcode);
	}
	public String getTitlerefsrvrtname() {
		return ((String) getAttrVal("Titlerefsrvrtname"));
	}	
	public void setTitlerefsrvrtname(String Titlerefsrvrtname) {
		setAttrVal("Titlerefsrvrtname", Titlerefsrvrtname);
	}
	public String getIdemptitlecode() {
		return ((String) getAttrVal("Idemptitlecode"));
	}	
	public void setIdemptitlecode(String Idemptitlecode) {
		setAttrVal("Idemptitlecode", Idemptitlecode);
	}
	public String getIdemptitlename() {
		return ((String) getAttrVal("Idemptitlename"));
	}	
	public void setIdemptitlename(String Idemptitlename) {
		setAttrVal("Idemptitlename", Idemptitlename);
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
		return "Id_srvrttitleref";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_rt_title_ref";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvRtTitleRefDODesc.class);
	}
	
}