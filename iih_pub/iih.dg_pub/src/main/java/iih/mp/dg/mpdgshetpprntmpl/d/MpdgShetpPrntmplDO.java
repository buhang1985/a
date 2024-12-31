package iih.mp.dg.mpdgshetpprntmpl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.mpdgshetpprntmpl.d.desc.MpdgShetpPrntmplDODesc;
import java.math.BigDecimal;

/**
 * 药单打印模板 DO数据 
 * 
 */
public class MpdgShetpPrntmplDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGSHETP_PRNTMPL= "Id_dgshetp_prntmpl";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String SHORTNAME= "Shortname";
	public static final String TMPLURL= "Tmplurl";
	public static final String ID_SRVORRT= "Id_srvorrt";
	public static final String SD_SRVORRT= "Sd_srvorrt";
	public static final String ID_DEPT= "Id_dept";
	public static final String PRINTINGTIME= "Printingtime";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String FG_THERMAL= "Fg_thermal";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SRV_NAME= "Srv_name";
	public static final String DEPART_NAME= "Depart_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgshetp_prntmpl() {
		return ((String) getAttrVal("Id_dgshetp_prntmpl"));
	}	
	public void setId_dgshetp_prntmpl(String Id_dgshetp_prntmpl) {
		setAttrVal("Id_dgshetp_prntmpl", Id_dgshetp_prntmpl);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}	
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	public String getTmplurl() {
		return ((String) getAttrVal("Tmplurl"));
	}	
	public void setTmplurl(String Tmplurl) {
		setAttrVal("Tmplurl", Tmplurl);
	}
	public String getId_srvorrt() {
		return ((String) getAttrVal("Id_srvorrt"));
	}	
	public void setId_srvorrt(String Id_srvorrt) {
		setAttrVal("Id_srvorrt", Id_srvorrt);
	}
	public String getSd_srvorrt() {
		return ((String) getAttrVal("Sd_srvorrt"));
	}	
	public void setSd_srvorrt(String Sd_srvorrt) {
		setAttrVal("Sd_srvorrt", Sd_srvorrt);
	}
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	public Integer getPrintingtime() {
		return ((Integer) getAttrVal("Printingtime"));
	}	
	public void setPrintingtime(Integer Printingtime) {
		setAttrVal("Printingtime", Printingtime);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FBoolean getFg_thermal() {
		return ((FBoolean) getAttrVal("Fg_thermal"));
	}	
	public void setFg_thermal(FBoolean Fg_thermal) {
		setAttrVal("Fg_thermal", Fg_thermal);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getDepart_name() {
		return ((String) getAttrVal("Depart_name"));
	}	
	public void setDepart_name(String Depart_name) {
		setAttrVal("Depart_name", Depart_name);
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
		return "Id_dgshetp_prntmpl";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_shetp_prntmpl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpdgShetpPrntmplDODesc.class);
	}
	
}