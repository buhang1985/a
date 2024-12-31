package iih.bd.srv.srvspecantiexpert.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.srvspecantiexpert.d.desc.SrvSpecAntiExpertDODesc;
import java.math.BigDecimal;

/**
 * 医疗服务_特殊使用级抗菌药专家 DO数据 
 * 
 */
public class SrvSpecAntiExpertDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVSPECANTIEXPERT= "Id_srvspecantiexpert";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String ID_EMPTITLE= "Id_emptitle";
	public static final String ID_EMPWKTP= "Id_empwktp";
	public static final String ID_DEP= "Id_dep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String SD_EMPTITLE= "Sd_emptitle";
	public static final String NAME_EMPTITLE= "Name_emptitle";
	public static final String SD_EMPWKTP= "Sd_empwktp";
	public static final String NAME_EMPWKTP= "Name_empwktp";
	public static final String SD_DEP= "Sd_dep";
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_srvspecantiexpert() {
		return ((String) getAttrVal("Id_srvspecantiexpert"));
	}	
	public void setId_srvspecantiexpert(String Id_srvspecantiexpert) {
		setAttrVal("Id_srvspecantiexpert", Id_srvspecantiexpert);
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
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
	public String getId_emptitle() {
		return ((String) getAttrVal("Id_emptitle"));
	}	
	public void setId_emptitle(String Id_emptitle) {
		setAttrVal("Id_emptitle", Id_emptitle);
	}
	public String getId_empwktp() {
		return ((String) getAttrVal("Id_empwktp"));
	}	
	public void setId_empwktp(String Id_empwktp) {
		setAttrVal("Id_empwktp", Id_empwktp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	public String getSd_emptitle() {
		return ((String) getAttrVal("Sd_emptitle"));
	}	
	public void setSd_emptitle(String Sd_emptitle) {
		setAttrVal("Sd_emptitle", Sd_emptitle);
	}
	public String getName_emptitle() {
		return ((String) getAttrVal("Name_emptitle"));
	}	
	public void setName_emptitle(String Name_emptitle) {
		setAttrVal("Name_emptitle", Name_emptitle);
	}
	public String getSd_empwktp() {
		return ((String) getAttrVal("Sd_empwktp"));
	}	
	public void setSd_empwktp(String Sd_empwktp) {
		setAttrVal("Sd_empwktp", Sd_empwktp);
	}
	public String getName_empwktp() {
		return ((String) getAttrVal("Name_empwktp"));
	}	
	public void setName_empwktp(String Name_empwktp) {
		setAttrVal("Name_empwktp", Name_empwktp);
	}
	public String getSd_dep() {
		return ((String) getAttrVal("Sd_dep"));
	}	
	public void setSd_dep(String Sd_dep) {
		setAttrVal("Sd_dep", Sd_dep);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_srvspecantiexpert";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_SRV_SPEC_ANTI_EXPERT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SrvSpecAntiExpertDODesc.class);
	}
	
}