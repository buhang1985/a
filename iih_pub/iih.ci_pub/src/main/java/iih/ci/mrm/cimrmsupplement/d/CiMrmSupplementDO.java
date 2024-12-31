package iih.ci.mrm.cimrmsupplement.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrm.cimrmsupplement.d.desc.CiMrmSupplementDODesc;
import java.math.BigDecimal;

/**
 * 病案补充记录 DO数据 
 * 
 */
public class CiMrmSupplementDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CI_MRM_SU= "Id_ci_mrm_su";
	public static final String ID_CI_AMR= "Id_ci_amr";
	public static final String ID_BD_MRM_TP= "Id_bd_mrm_tp";
	public static final String ID_CI_MRM_FI= "Id_ci_mrm_fi";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_BD_MRM_TP= "Name_bd_mrm_tp";
	public static final String CODE_BD_MRM_TP= "Code_bd_mrm_tp";
	public static final String NAME_CI_MRM_FI= "Name_ci_mrm_fi";
	public static final String SORTNO_CI_MRM_FI= "Sortno_ci_mrm_fi";
	public static final String CODE_FILE_CI_MRM_FI= "Code_file_ci_mrm_fi";
	public static final String DSC_SU_CI_MRM_FI= "Dsc_su_ci_mrm_fi";
	public static final String ID_PSN_SU_CI_MRM_FI= "Id_psn_su_ci_mrm_fi";
	public static final String DT_PSN_SU_CI_MRM_FI= "Dt_psn_su_ci_mrm_fi";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ci_mrm_su() {
		return ((String) getAttrVal("Id_ci_mrm_su"));
	}	
	public void setId_ci_mrm_su(String Id_ci_mrm_su) {
		setAttrVal("Id_ci_mrm_su", Id_ci_mrm_su);
	}
	public String getId_ci_amr() {
		return ((String) getAttrVal("Id_ci_amr"));
	}	
	public void setId_ci_amr(String Id_ci_amr) {
		setAttrVal("Id_ci_amr", Id_ci_amr);
	}
	public String getId_bd_mrm_tp() {
		return ((String) getAttrVal("Id_bd_mrm_tp"));
	}	
	public void setId_bd_mrm_tp(String Id_bd_mrm_tp) {
		setAttrVal("Id_bd_mrm_tp", Id_bd_mrm_tp);
	}
	public String getId_ci_mrm_fi() {
		return ((String) getAttrVal("Id_ci_mrm_fi"));
	}	
	public void setId_ci_mrm_fi(String Id_ci_mrm_fi) {
		setAttrVal("Id_ci_mrm_fi", Id_ci_mrm_fi);
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
	public String getName_bd_mrm_tp() {
		return ((String) getAttrVal("Name_bd_mrm_tp"));
	}	
	public void setName_bd_mrm_tp(String Name_bd_mrm_tp) {
		setAttrVal("Name_bd_mrm_tp", Name_bd_mrm_tp);
	}
	public String getCode_bd_mrm_tp() {
		return ((String) getAttrVal("Code_bd_mrm_tp"));
	}	
	public void setCode_bd_mrm_tp(String Code_bd_mrm_tp) {
		setAttrVal("Code_bd_mrm_tp", Code_bd_mrm_tp);
	}
	public String getName_ci_mrm_fi() {
		return ((String) getAttrVal("Name_ci_mrm_fi"));
	}	
	public void setName_ci_mrm_fi(String Name_ci_mrm_fi) {
		setAttrVal("Name_ci_mrm_fi", Name_ci_mrm_fi);
	}
	public Integer getSortno_ci_mrm_fi() {
		return ((Integer) getAttrVal("Sortno_ci_mrm_fi"));
	}	
	public void setSortno_ci_mrm_fi(Integer Sortno_ci_mrm_fi) {
		setAttrVal("Sortno_ci_mrm_fi", Sortno_ci_mrm_fi);
	}
	public String getCode_file_ci_mrm_fi() {
		return ((String) getAttrVal("Code_file_ci_mrm_fi"));
	}	
	public void setCode_file_ci_mrm_fi(String Code_file_ci_mrm_fi) {
		setAttrVal("Code_file_ci_mrm_fi", Code_file_ci_mrm_fi);
	}
	public String getDsc_su_ci_mrm_fi() {
		return ((String) getAttrVal("Dsc_su_ci_mrm_fi"));
	}	
	public void setDsc_su_ci_mrm_fi(String Dsc_su_ci_mrm_fi) {
		setAttrVal("Dsc_su_ci_mrm_fi", Dsc_su_ci_mrm_fi);
	}
	public String getId_psn_su_ci_mrm_fi() {
		return ((String) getAttrVal("Id_psn_su_ci_mrm_fi"));
	}	
	public void setId_psn_su_ci_mrm_fi(String Id_psn_su_ci_mrm_fi) {
		setAttrVal("Id_psn_su_ci_mrm_fi", Id_psn_su_ci_mrm_fi);
	}
	public FDateTime getDt_psn_su_ci_mrm_fi() {
		return ((FDateTime) getAttrVal("Dt_psn_su_ci_mrm_fi"));
	}	
	public void setDt_psn_su_ci_mrm_fi(FDateTime Dt_psn_su_ci_mrm_fi) {
		setAttrVal("Dt_psn_su_ci_mrm_fi", Dt_psn_su_ci_mrm_fi);
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
		return "Id_ci_mrm_su";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_su";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrmSupplementDODesc.class);
	}
	
}