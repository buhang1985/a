package iih.bd.fc.mdwfor.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.mdwfor.d.desc.MdWfOrDODesc;
import java.math.BigDecimal;

/**
 * 医嘱流向开立参数 DO数据 
 * 
 */
public class MdWfOrDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_WFOR= "Id_wfor";
	public static final String ID_WF= "Id_wf";
	public static final String EU_WFTP= "Eu_wftp";
	public static final String SORTNO= "Sortno";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENTP= "Id_entp";
	public static final String EU_SRV_TP= "Eu_srv_tp";
	public static final String ID_SRVTP= "Id_srvtp";
	public static final String SD_SRVTP= "Sd_srvtp";
	public static final String ID_SRVCA= "Id_srvca";
	public static final String ID_SRV= "Id_srv";
	public static final String ID_USG= "Id_usg";
	public static final String ID_ORDRECURTP= "Id_ordrecurtp";
	public static final String TIME_B= "Time_b";
	public static final String TIME_E= "Time_e";
	public static final String WEEKS= "Weeks";
	public static final String ID_DEP_OR= "Id_dep_or";
	public static final String ID_DEP_CLINIC= "Id_dep_clinic";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String FG_MACRO= "Fg_macro";
	public static final String DEPTMACRO= "Deptmacro";
	public static final String ID_DEPT= "Id_dept";
	public static final String ID_WFDEP= "Id_wfdep";
	public static final String INNERCODE_SRVCA= "Innercode_srvca";
	public static final String MDWFITM_CODE= "Mdwfitm_code";
	public static final String MDWFITM_NAME= "Mdwfitm_name";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String ENTP_CODE= "Entp_code";
	public static final String ENTP_NAME= "Entp_name";
	public static final String SRVTP_CODE= "Srvtp_code";
	public static final String SRVTP_NAME= "Srvtp_name";
	public static final String SRVCA_CODE= "Srvca_code";
	public static final String SRVCA_NAME= "Srvca_name";
	public static final String SRV_CODE= "Srv_code";
	public static final String SRV_NAME= "Srv_name";
	public static final String USG_CODE= "Usg_code";
	public static final String USG_NAME= "Usg_name";
	public static final String ORDRECURTP_CODE= "Ordrecurtp_code";
	public static final String ORDRECURTP_NAME= "Ordrecurtp_name";
	public static final String DEPT_CODE= "Dept_code";
	public static final String DEPT_NAME= "Dept_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_wfor() {
		return ((String) getAttrVal("Id_wfor"));
	}	
	public void setId_wfor(String Id_wfor) {
		setAttrVal("Id_wfor", Id_wfor);
	}
	public String getId_wf() {
		return ((String) getAttrVal("Id_wf"));
	}	
	public void setId_wf(String Id_wf) {
		setAttrVal("Id_wf", Id_wf);
	}
	public Integer getEu_wftp() {
		return ((Integer) getAttrVal("Eu_wftp"));
	}	
	public void setEu_wftp(Integer Eu_wftp) {
		setAttrVal("Eu_wftp", Eu_wftp);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
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
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public Integer getEu_srv_tp() {
		return ((Integer) getAttrVal("Eu_srv_tp"));
	}	
	public void setEu_srv_tp(Integer Eu_srv_tp) {
		setAttrVal("Eu_srv_tp", Eu_srv_tp);
	}
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getId_usg() {
		return ((String) getAttrVal("Id_usg"));
	}	
	public void setId_usg(String Id_usg) {
		setAttrVal("Id_usg", Id_usg);
	}
	public String getId_ordrecurtp() {
		return ((String) getAttrVal("Id_ordrecurtp"));
	}	
	public void setId_ordrecurtp(String Id_ordrecurtp) {
		setAttrVal("Id_ordrecurtp", Id_ordrecurtp);
	}
	public FTime getTime_b() {
		return ((FTime) getAttrVal("Time_b"));
	}	
	public void setTime_b(FTime Time_b) {
		setAttrVal("Time_b", Time_b);
	}
	public FTime getTime_e() {
		return ((FTime) getAttrVal("Time_e"));
	}	
	public void setTime_e(FTime Time_e) {
		setAttrVal("Time_e", Time_e);
	}
	public String getWeeks() {
		return ((String) getAttrVal("Weeks"));
	}	
	public void setWeeks(String Weeks) {
		setAttrVal("Weeks", Weeks);
	}
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}	
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	public String getId_dep_clinic() {
		return ((String) getAttrVal("Id_dep_clinic"));
	}	
	public void setId_dep_clinic(String Id_dep_clinic) {
		setAttrVal("Id_dep_clinic", Id_dep_clinic);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public FBoolean getFg_macro() {
		return ((FBoolean) getAttrVal("Fg_macro"));
	}	
	public void setFg_macro(FBoolean Fg_macro) {
		setAttrVal("Fg_macro", Fg_macro);
	}
	public String getDeptmacro() {
		return ((String) getAttrVal("Deptmacro"));
	}	
	public void setDeptmacro(String Deptmacro) {
		setAttrVal("Deptmacro", Deptmacro);
	}
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	public String getId_wfdep() {
		return ((String) getAttrVal("Id_wfdep"));
	}	
	public void setId_wfdep(String Id_wfdep) {
		setAttrVal("Id_wfdep", Id_wfdep);
	}
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}	
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	public String getMdwfitm_code() {
		return ((String) getAttrVal("Mdwfitm_code"));
	}	
	public void setMdwfitm_code(String Mdwfitm_code) {
		setAttrVal("Mdwfitm_code", Mdwfitm_code);
	}
	public String getMdwfitm_name() {
		return ((String) getAttrVal("Mdwfitm_name"));
	}	
	public void setMdwfitm_name(String Mdwfitm_name) {
		setAttrVal("Mdwfitm_name", Mdwfitm_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getEntp_code() {
		return ((String) getAttrVal("Entp_code"));
	}	
	public void setEntp_code(String Entp_code) {
		setAttrVal("Entp_code", Entp_code);
	}
	public String getEntp_name() {
		return ((String) getAttrVal("Entp_name"));
	}	
	public void setEntp_name(String Entp_name) {
		setAttrVal("Entp_name", Entp_name);
	}
	public String getSrvtp_code() {
		return ((String) getAttrVal("Srvtp_code"));
	}	
	public void setSrvtp_code(String Srvtp_code) {
		setAttrVal("Srvtp_code", Srvtp_code);
	}
	public String getSrvtp_name() {
		return ((String) getAttrVal("Srvtp_name"));
	}	
	public void setSrvtp_name(String Srvtp_name) {
		setAttrVal("Srvtp_name", Srvtp_name);
	}
	public String getSrvca_code() {
		return ((String) getAttrVal("Srvca_code"));
	}	
	public void setSrvca_code(String Srvca_code) {
		setAttrVal("Srvca_code", Srvca_code);
	}
	public String getSrvca_name() {
		return ((String) getAttrVal("Srvca_name"));
	}	
	public void setSrvca_name(String Srvca_name) {
		setAttrVal("Srvca_name", Srvca_name);
	}
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}	
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}	
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	public String getUsg_code() {
		return ((String) getAttrVal("Usg_code"));
	}	
	public void setUsg_code(String Usg_code) {
		setAttrVal("Usg_code", Usg_code);
	}
	public String getUsg_name() {
		return ((String) getAttrVal("Usg_name"));
	}	
	public void setUsg_name(String Usg_name) {
		setAttrVal("Usg_name", Usg_name);
	}
	public String getOrdrecurtp_code() {
		return ((String) getAttrVal("Ordrecurtp_code"));
	}	
	public void setOrdrecurtp_code(String Ordrecurtp_code) {
		setAttrVal("Ordrecurtp_code", Ordrecurtp_code);
	}
	public String getOrdrecurtp_name() {
		return ((String) getAttrVal("Ordrecurtp_name"));
	}	
	public void setOrdrecurtp_name(String Ordrecurtp_name) {
		setAttrVal("Ordrecurtp_name", Ordrecurtp_name);
	}
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
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
		return "Id_wfor";
	}
	
	@Override
	public String getTableName() {	  
		return "md_wf_or";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MdWfOrDODesc.class);
	}
	
}