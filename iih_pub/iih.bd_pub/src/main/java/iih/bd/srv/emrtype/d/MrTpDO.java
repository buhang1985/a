package iih.bd.srv.emrtype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.emrtype.d.desc.MrTpDODesc;
import java.math.BigDecimal;

/**
 * 医疗记录类型 DO数据 
 * 
 */
public class MrTpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRTP= "Id_mrtp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CD_STD= "Cd_std";
	public static final String ID_DATA_SET= "Id_data_set";
	public static final String MR_SIGN_LVL_CD= "Mr_sign_lvl_cd";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DES= "Des";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String DEF_FUNC_EDTOR_ARGU= "Def_func_edtor_argu";
	public static final String ID_MRED= "Id_mred";
	public static final String ID_MRFMTP= "Id_mrfmtp";
	public static final String SD_MRFMTP= "Sd_mrfmtp";
	public static final String ID_MRTPLSTMD= "Id_mrtplstmd";
	public static final String SD_MRTPLSTMD= "Sd_mrtplstmd";
	public static final String FG_SYSTEM= "Fg_system";
	public static final String FG_ONLY= "Fg_only";
	public static final String FG_NEW_PAGE= "Fg_new_page";
	public static final String SORTNO= "Sortno";
	public static final String ID_OWNERTP= "Id_ownertp";
	public static final String SD_OWNERTP= "Sd_ownertp";
	public static final String ID_MR_ENTP= "Id_mr_entp";
	public static final String SD_MR_ENTP= "Sd_mr_entp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_SET= "Code_set";
	public static final String NAME_SET= "Name_set";
	public static final String SIGN_CODE= "Sign_code";
	public static final String SIGN_NAME= "Sign_name";
	public static final String SIGN_FLOWTYPE= "Sign_flowtype";
	public static final String EMRTP_CODE= "Emrtp_code";
	public static final String EMRTP_NAME= "Emrtp_name";
	public static final String EDITOR_CODE= "Editor_code";
	public static final String EDITOR_NAME= "Editor_name";
	public static final String EMR_DLLPATH= "Emr_dllpath";
	public static final String EMR_FUNCEDITOR= "Emr_funceditor";
	public static final String EMR_NAMECLASS= "Emr_nameclass";
	public static final String MRF_CODE= "Mrf_code";
	public static final String MRF_NAME= "Mrf_name";
	public static final String TPL_CODE= "Tpl_code";
	public static final String TPL_NAME= "Tpl_name";
	public static final String MR_ENTP_NAME= "Mr_entp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}	
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
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
	public String getCd_std() {
		return ((String) getAttrVal("Cd_std"));
	}	
	public void setCd_std(String Cd_std) {
		setAttrVal("Cd_std", Cd_std);
	}
	public String getId_data_set() {
		return ((String) getAttrVal("Id_data_set"));
	}	
	public void setId_data_set(String Id_data_set) {
		setAttrVal("Id_data_set", Id_data_set);
	}
	public String getMr_sign_lvl_cd() {
		return ((String) getAttrVal("Mr_sign_lvl_cd"));
	}	
	public void setMr_sign_lvl_cd(String Mr_sign_lvl_cd) {
		setAttrVal("Mr_sign_lvl_cd", Mr_sign_lvl_cd);
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
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	public String getDef_func_edtor_argu() {
		return ((String) getAttrVal("Def_func_edtor_argu"));
	}	
	public void setDef_func_edtor_argu(String Def_func_edtor_argu) {
		setAttrVal("Def_func_edtor_argu", Def_func_edtor_argu);
	}
	public String getId_mred() {
		return ((String) getAttrVal("Id_mred"));
	}	
	public void setId_mred(String Id_mred) {
		setAttrVal("Id_mred", Id_mred);
	}
	public String getId_mrfmtp() {
		return ((String) getAttrVal("Id_mrfmtp"));
	}	
	public void setId_mrfmtp(String Id_mrfmtp) {
		setAttrVal("Id_mrfmtp", Id_mrfmtp);
	}
	public String getSd_mrfmtp() {
		return ((String) getAttrVal("Sd_mrfmtp"));
	}	
	public void setSd_mrfmtp(String Sd_mrfmtp) {
		setAttrVal("Sd_mrfmtp", Sd_mrfmtp);
	}
	public String getId_mrtplstmd() {
		return ((String) getAttrVal("Id_mrtplstmd"));
	}	
	public void setId_mrtplstmd(String Id_mrtplstmd) {
		setAttrVal("Id_mrtplstmd", Id_mrtplstmd);
	}
	public String getSd_mrtplstmd() {
		return ((String) getAttrVal("Sd_mrtplstmd"));
	}	
	public void setSd_mrtplstmd(String Sd_mrtplstmd) {
		setAttrVal("Sd_mrtplstmd", Sd_mrtplstmd);
	}
	public FBoolean getFg_system() {
		return ((FBoolean) getAttrVal("Fg_system"));
	}	
	public void setFg_system(FBoolean Fg_system) {
		setAttrVal("Fg_system", Fg_system);
	}
	public FBoolean getFg_only() {
		return ((FBoolean) getAttrVal("Fg_only"));
	}	
	public void setFg_only(FBoolean Fg_only) {
		setAttrVal("Fg_only", Fg_only);
	}
	public FBoolean getFg_new_page() {
		return ((FBoolean) getAttrVal("Fg_new_page"));
	}	
	public void setFg_new_page(FBoolean Fg_new_page) {
		setAttrVal("Fg_new_page", Fg_new_page);
	}
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_ownertp() {
		return ((String) getAttrVal("Id_ownertp"));
	}	
	public void setId_ownertp(String Id_ownertp) {
		setAttrVal("Id_ownertp", Id_ownertp);
	}
	public String getSd_ownertp() {
		return ((String) getAttrVal("Sd_ownertp"));
	}	
	public void setSd_ownertp(String Sd_ownertp) {
		setAttrVal("Sd_ownertp", Sd_ownertp);
	}
	public String getId_mr_entp() {
		return ((String) getAttrVal("Id_mr_entp"));
	}	
	public void setId_mr_entp(String Id_mr_entp) {
		setAttrVal("Id_mr_entp", Id_mr_entp);
	}
	public String getSd_mr_entp() {
		return ((String) getAttrVal("Sd_mr_entp"));
	}	
	public void setSd_mr_entp(String Sd_mr_entp) {
		setAttrVal("Sd_mr_entp", Sd_mr_entp);
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
	public String getCode_set() {
		return ((String) getAttrVal("Code_set"));
	}	
	public void setCode_set(String Code_set) {
		setAttrVal("Code_set", Code_set);
	}
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}	
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
	}
	public String getSign_code() {
		return ((String) getAttrVal("Sign_code"));
	}	
	public void setSign_code(String Sign_code) {
		setAttrVal("Sign_code", Sign_code);
	}
	public String getSign_name() {
		return ((String) getAttrVal("Sign_name"));
	}	
	public void setSign_name(String Sign_name) {
		setAttrVal("Sign_name", Sign_name);
	}
	public String getSign_flowtype() {
		return ((String) getAttrVal("Sign_flowtype"));
	}	
	public void setSign_flowtype(String Sign_flowtype) {
		setAttrVal("Sign_flowtype", Sign_flowtype);
	}
	public String getEmrtp_code() {
		return ((String) getAttrVal("Emrtp_code"));
	}	
	public void setEmrtp_code(String Emrtp_code) {
		setAttrVal("Emrtp_code", Emrtp_code);
	}
	public String getEmrtp_name() {
		return ((String) getAttrVal("Emrtp_name"));
	}	
	public void setEmrtp_name(String Emrtp_name) {
		setAttrVal("Emrtp_name", Emrtp_name);
	}
	public String getEditor_code() {
		return ((String) getAttrVal("Editor_code"));
	}	
	public void setEditor_code(String Editor_code) {
		setAttrVal("Editor_code", Editor_code);
	}
	public String getEditor_name() {
		return ((String) getAttrVal("Editor_name"));
	}	
	public void setEditor_name(String Editor_name) {
		setAttrVal("Editor_name", Editor_name);
	}
	public String getEmr_dllpath() {
		return ((String) getAttrVal("Emr_dllpath"));
	}	
	public void setEmr_dllpath(String Emr_dllpath) {
		setAttrVal("Emr_dllpath", Emr_dllpath);
	}
	public String getEmr_funceditor() {
		return ((String) getAttrVal("Emr_funceditor"));
	}	
	public void setEmr_funceditor(String Emr_funceditor) {
		setAttrVal("Emr_funceditor", Emr_funceditor);
	}
	public String getEmr_nameclass() {
		return ((String) getAttrVal("Emr_nameclass"));
	}	
	public void setEmr_nameclass(String Emr_nameclass) {
		setAttrVal("Emr_nameclass", Emr_nameclass);
	}
	public String getMrf_code() {
		return ((String) getAttrVal("Mrf_code"));
	}	
	public void setMrf_code(String Mrf_code) {
		setAttrVal("Mrf_code", Mrf_code);
	}
	public String getMrf_name() {
		return ((String) getAttrVal("Mrf_name"));
	}	
	public void setMrf_name(String Mrf_name) {
		setAttrVal("Mrf_name", Mrf_name);
	}
	public String getTpl_code() {
		return ((String) getAttrVal("Tpl_code"));
	}	
	public void setTpl_code(String Tpl_code) {
		setAttrVal("Tpl_code", Tpl_code);
	}
	public String getTpl_name() {
		return ((String) getAttrVal("Tpl_name"));
	}	
	public void setTpl_name(String Tpl_name) {
		setAttrVal("Tpl_name", Tpl_name);
	}
	public String getMr_entp_name() {
		return ((String) getAttrVal("Mr_entp_name"));
	}	
	public void setMr_entp_name(String Mr_entp_name) {
		setAttrVal("Mr_entp_name", Mr_entp_name);
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
		return "Id_mrtp";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mrtp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrTpDODesc.class);
	}
	
}