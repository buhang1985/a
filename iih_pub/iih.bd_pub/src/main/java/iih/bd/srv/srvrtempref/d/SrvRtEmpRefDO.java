package iih.bd.srv.srvrtempref.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvrtempref.d.desc.SrvRtEmpRefDODesc;
import java.math.BigDecimal;

/**
 * 服务开立权限与医生关系 DO数据 
 * 
 */
public class SrvRtEmpRefDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVRTEMPREF= "Id_srvrtempref";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SRVRT= "Id_srvrt";
	public static final String ID_EMP_PHY= "Id_emp_phy";
	public static final String ID_EMPTITLE= "Id_emptitle";
	public static final String SD_EMPTITLE= "Sd_emptitle";
	public static final String ID_HUMANTYPE= "Id_humantype";
	public static final String SD_HUMANTYPE= "Sd_humantype";
	public static final String CODE= "Code";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_GRP= "Name_grp";
	public static final String NAME_ORG= "Name_org";
	public static final String RULES= "Rules";
	public static final String EMP_PHY_CODE= "Emp_phy_code";
	public static final String EMP_PHY_NAME= "Emp_phy_name";
	public static final String ID_TITLE= "Id_title";
	public static final String SD_TITLE= "Sd_title";
	public static final String HUMANTYPE= "Humantype";
	public static final String SD_HTYPE= "Sd_htype";
	public static final String PYCODE= "Pycode";
	public static final String ID_DEP= "Id_dep";
	public static final String TITLE_NAME= "Title_name";
	public static final String TITLE_CODE= "Title_code";
	public static final String HUMANTYPE_NAME= "Humantype_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvrtempref() {
		return ((String) getAttrVal("Id_srvrtempref"));
	}	
	public void setId_srvrtempref(String Id_srvrtempref) {
		setAttrVal("Id_srvrtempref", Id_srvrtempref);
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
	public String getId_srvrt() {
		return ((String) getAttrVal("Id_srvrt"));
	}	
	public void setId_srvrt(String Id_srvrt) {
		setAttrVal("Id_srvrt", Id_srvrt);
	}
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}	
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}	
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	public String getId_humantype() {
		return ((String) getAttrVal("Id_humantype"));
	}	
	public void setId_humantype(String Id_humantype) {
		setAttrVal("Id_humantype", Id_humantype);
	}
	public String getSd_humantype() {
		return ((String) getAttrVal("Sd_humantype"));
	}	
	public void setSd_humantype(String Sd_humantype) {
		setAttrVal("Sd_humantype", Sd_humantype);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	public String getRules() {
		return ((String) getAttrVal("Rules"));
	}	
	public void setRules(String Rules) {
		setAttrVal("Rules", Rules);
	}
	public String getEmp_phy_code() {
		return ((String) getAttrVal("Emp_phy_code"));
	}	
	public void setEmp_phy_code(String Emp_phy_code) {
		setAttrVal("Emp_phy_code", Emp_phy_code);
	}
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}	
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
	}
	public String getId_title() {
		return ((String) getAttrVal("Id_title"));
	}	
	public void setId_title(String Id_title) {
		setAttrVal("Id_title", Id_title);
	}
	public String getSd_title() {
		return ((String) getAttrVal("Sd_title"));
	}	
	public void setSd_title(String Sd_title) {
		setAttrVal("Sd_title", Sd_title);
	}
	public String getHumantype() {
		return ((String) getAttrVal("Humantype"));
	}	
	public void setHumantype(String Humantype) {
		setAttrVal("Humantype", Humantype);
	}
	public String getSd_htype() {
		return ((String) getAttrVal("Sd_htype"));
	}	
	public void setSd_htype(String Sd_htype) {
		setAttrVal("Sd_htype", Sd_htype);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getTitle_name() {
		return ((String) getAttrVal("Title_name"));
	}	
	public void setTitle_name(String Title_name) {
		setAttrVal("Title_name", Title_name);
	}
	public String getTitle_code() {
		return ((String) getAttrVal("Title_code"));
	}	
	public void setTitle_code(String Title_code) {
		setAttrVal("Title_code", Title_code);
	}
	public String getHumantype_name() {
		return ((String) getAttrVal("Humantype_name"));
	}	
	public void setHumantype_name(String Humantype_name) {
		setAttrVal("Humantype_name", Humantype_name);
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
		return "Id_srvrtempref";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_srv_rt_emp_ref";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvRtEmpRefDODesc.class);
	}
	
}