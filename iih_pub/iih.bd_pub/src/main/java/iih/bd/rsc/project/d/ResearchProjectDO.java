package iih.bd.rsc.project.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.rsc.project.d.desc.ResearchProjectDODesc;
import java.math.BigDecimal;

/**
 * 科研项目 DO数据 
 * 
 */
public class ResearchProjectDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RESEARCHPROJECT= "Id_researchproject";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String SD_RSCPROJTP= "Sd_rscprojtp";
	public static final String ID_RSCPROJTP= "Id_rscprojtp";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_EMP_MGR= "Id_emp_mgr";
	public static final String PROECTSRC= "Proectsrc";
	public static final String DES= "Des";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DT_INPUT= "Dt_input";
	public static final String ID_EMP_INPUT= "Id_emp_input";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String RSCPROJTP_NAME= "Rscprojtp_name";
	public static final String DEP_NAME= "Dep_name";
	public static final String EMP_MGR_NAME= "Emp_mgr_name";
	public static final String EMP_INPUT_NAME= "Emp_input_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_researchproject() {
		return ((String) getAttrVal("Id_researchproject"));
	}	
	public void setId_researchproject(String Id_researchproject) {
		setAttrVal("Id_researchproject", Id_researchproject);
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
	public String getSd_rscprojtp() {
		return ((String) getAttrVal("Sd_rscprojtp"));
	}	
	public void setSd_rscprojtp(String Sd_rscprojtp) {
		setAttrVal("Sd_rscprojtp", Sd_rscprojtp);
	}
	public String getId_rscprojtp() {
		return ((String) getAttrVal("Id_rscprojtp"));
	}	
	public void setId_rscprojtp(String Id_rscprojtp) {
		setAttrVal("Id_rscprojtp", Id_rscprojtp);
	}
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}	
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}	
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_emp_mgr() {
		return ((String) getAttrVal("Id_emp_mgr"));
	}	
	public void setId_emp_mgr(String Id_emp_mgr) {
		setAttrVal("Id_emp_mgr", Id_emp_mgr);
	}
	public String getProectsrc() {
		return ((String) getAttrVal("Proectsrc"));
	}	
	public void setProectsrc(String Proectsrc) {
		setAttrVal("Proectsrc", Proectsrc);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public FDateTime getDt_input() {
		return ((FDateTime) getAttrVal("Dt_input"));
	}	
	public void setDt_input(FDateTime Dt_input) {
		setAttrVal("Dt_input", Dt_input);
	}
	public String getId_emp_input() {
		return ((String) getAttrVal("Id_emp_input"));
	}	
	public void setId_emp_input(String Id_emp_input) {
		setAttrVal("Id_emp_input", Id_emp_input);
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
	public String getRscprojtp_name() {
		return ((String) getAttrVal("Rscprojtp_name"));
	}	
	public void setRscprojtp_name(String Rscprojtp_name) {
		setAttrVal("Rscprojtp_name", Rscprojtp_name);
	}
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	public String getEmp_mgr_name() {
		return ((String) getAttrVal("Emp_mgr_name"));
	}	
	public void setEmp_mgr_name(String Emp_mgr_name) {
		setAttrVal("Emp_mgr_name", Emp_mgr_name);
	}
	public String getEmp_input_name() {
		return ((String) getAttrVal("Emp_input_name"));
	}	
	public void setEmp_input_name(String Emp_input_name) {
		setAttrVal("Emp_input_name", Emp_input_name);
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
		return "Id_researchproject";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_RSC_PROJECT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ResearchProjectDODesc.class);
	}
	
}