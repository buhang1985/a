package iih.bd.srv.srvrtctlcate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvrtctlcate.d.desc.SrvRtCtlCateDODesc;
import java.math.BigDecimal;

/**
 * 服务项目开立权限分类 DO数据 
 * 
 */
public class SrvRtCtlCateDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVRTCA= "Id_srvrtca";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRVRTTP= "Id_srvrttp";
	public static final String SD_SRVRTTP= "Sd_srvrttp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DES= "Des";
	public static final String EU_RTLIMIT= "Eu_rtlimit";
	public static final String CTRLSCOPE= "Ctrlscope";
	public static final String FG_RUCTR= "Fg_ructr";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String IDSRVTTPCODE= "Idsrvttpcode";
	public static final String IDSRVTTPNAME= "Idsrvttpname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvrtca() {
		return ((String) getAttrVal("Id_srvrtca"));
	}	
	public void setId_srvrtca(String Id_srvrtca) {
		setAttrVal("Id_srvrtca", Id_srvrtca);
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
	public String getId_srvrttp() {
		return ((String) getAttrVal("Id_srvrttp"));
	}	
	public void setId_srvrttp(String Id_srvrttp) {
		setAttrVal("Id_srvrttp", Id_srvrttp);
	}
	public String getSd_srvrttp() {
		return ((String) getAttrVal("Sd_srvrttp"));
	}	
	public void setSd_srvrttp(String Sd_srvrttp) {
		setAttrVal("Sd_srvrttp", Sd_srvrttp);
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
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public Integer getEu_rtlimit() {
		return ((Integer) getAttrVal("Eu_rtlimit"));
	}	
	public void setEu_rtlimit(Integer Eu_rtlimit) {
		setAttrVal("Eu_rtlimit", Eu_rtlimit);
	}
	public String getCtrlscope() {
		return ((String) getAttrVal("Ctrlscope"));
	}	
	public void setCtrlscope(String Ctrlscope) {
		setAttrVal("Ctrlscope", Ctrlscope);
	}
	public FBoolean getFg_ructr() {
		return ((FBoolean) getAttrVal("Fg_ructr"));
	}	
	public void setFg_ructr(FBoolean Fg_ructr) {
		setAttrVal("Fg_ructr", Fg_ructr);
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
	public String getIdsrvttpcode() {
		return ((String) getAttrVal("Idsrvttpcode"));
	}	
	public void setIdsrvttpcode(String Idsrvttpcode) {
		setAttrVal("Idsrvttpcode", Idsrvttpcode);
	}
	public String getIdsrvttpname() {
		return ((String) getAttrVal("Idsrvttpname"));
	}	
	public void setIdsrvttpname(String Idsrvttpname) {
		setAttrVal("Idsrvttpname", Idsrvttpname);
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
		return "Id_srvrtca";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_rtca";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvRtCtlCateDODesc.class);
	}
	
}