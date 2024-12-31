package iih.bd.pp.medinsurrecdiff.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurSrvFacRecDiffDODesc;
import java.math.BigDecimal;

/**
 * 医保服务设施记录差异 DO数据 
 * 
 */
public class MedInsurSrvFacRecDiffDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SRVFACDIFF= "Id_srvfacdiff";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DIFF= "Id_diff";
	public static final String EU_DIFFTYPE= "Eu_difftype";
	public static final String ID_DOWN= "Id_down";
	public static final String STR_EFFECTIVE= "Str_effective";
	public static final String HOSPITAL_RANK= "Hospital_rank";
	public static final String HOSPITAL_BED_RANK= "Hospital_bed_rank";
	public static final String FWSS_PAY_STANDARD= "Fwss_pay_standard";
	public static final String ID_EMP_HANDLE= "Id_emp_handle";
	public static final String DT_HANDLE= "Dt_handle";
	public static final String PY_CODE= "Py_code";
	public static final String WB_CODE= "Wb_code";
	public static final String ZDY_CODE= "Zdy_code";
	public static final String STR_PRC_DRUG_LIST= "Str_prc_drug_list";
	public static final String STR_PRC_B_DRUG_LIST= "Str_prc_b_drug_list";
	public static final String STR_RESIDENT_USE= "Str_resident_use";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String CODE_CA= "Code_ca";
	public static final String NAME_CA= "Name_ca";
	public static final String SD_HPSRVTP= "Sd_hpsrvtp";
	public static final String PRI_MAX= "Pri_max";
	public static final String RETIRE_EY_PRI_MAX= "Retire_ey_pri_max";
	public static final String DES= "Des";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String HOSPITAL_CODE= "Hospital_code";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public MedInsurSrvFacRecDiffDO () {
		super();
	}
	
	public String getId_srvfacdiff() {
		return ((String) getAttrVal("Id_srvfacdiff"));
	}	
	public void setId_srvfacdiff(String Id_srvfacdiff) {
		setAttrVal("Id_srvfacdiff", Id_srvfacdiff);
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
	public String getId_diff() {
		return ((String) getAttrVal("Id_diff"));
	}	
	public void setId_diff(String Id_diff) {
		setAttrVal("Id_diff", Id_diff);
	}
	public Integer getEu_difftype() {
		return ((Integer) getAttrVal("Eu_difftype"));
	}	
	public void setEu_difftype(Integer Eu_difftype) {
		setAttrVal("Eu_difftype", Eu_difftype);
	}
	public String getId_down() {
		return ((String) getAttrVal("Id_down"));
	}	
	public void setId_down(String Id_down) {
		setAttrVal("Id_down", Id_down);
	}
	public String getStr_effective() {
		return ((String) getAttrVal("Str_effective"));
	}	
	public void setStr_effective(String Str_effective) {
		setAttrVal("Str_effective", Str_effective);
	}
	public FDouble getHospital_rank() {
		return ((FDouble) getAttrVal("Hospital_rank"));
	}	
	public void setHospital_rank(FDouble Hospital_rank) {
		setAttrVal("Hospital_rank", Hospital_rank);
	}
	public String getHospital_bed_rank() {
		return ((String) getAttrVal("Hospital_bed_rank"));
	}	
	public void setHospital_bed_rank(String Hospital_bed_rank) {
		setAttrVal("Hospital_bed_rank", Hospital_bed_rank);
	}
	public String getFwss_pay_standard() {
		return ((String) getAttrVal("Fwss_pay_standard"));
	}	
	public void setFwss_pay_standard(String Fwss_pay_standard) {
		setAttrVal("Fwss_pay_standard", Fwss_pay_standard);
	}
	public String getId_emp_handle() {
		return ((String) getAttrVal("Id_emp_handle"));
	}	
	public void setId_emp_handle(String Id_emp_handle) {
		setAttrVal("Id_emp_handle", Id_emp_handle);
	}
	public FDateTime getDt_handle() {
		return ((FDateTime) getAttrVal("Dt_handle"));
	}	
	public void setDt_handle(FDateTime Dt_handle) {
		setAttrVal("Dt_handle", Dt_handle);
	}
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}	
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	public String getWb_code() {
		return ((String) getAttrVal("Wb_code"));
	}	
	public void setWb_code(String Wb_code) {
		setAttrVal("Wb_code", Wb_code);
	}
	public String getZdy_code() {
		return ((String) getAttrVal("Zdy_code"));
	}	
	public void setZdy_code(String Zdy_code) {
		setAttrVal("Zdy_code", Zdy_code);
	}
	public String getStr_prc_drug_list() {
		return ((String) getAttrVal("Str_prc_drug_list"));
	}	
	public void setStr_prc_drug_list(String Str_prc_drug_list) {
		setAttrVal("Str_prc_drug_list", Str_prc_drug_list);
	}
	public String getStr_prc_b_drug_list() {
		return ((String) getAttrVal("Str_prc_b_drug_list"));
	}	
	public void setStr_prc_b_drug_list(String Str_prc_b_drug_list) {
		setAttrVal("Str_prc_b_drug_list", Str_prc_b_drug_list);
	}
	public String getStr_resident_use() {
		return ((String) getAttrVal("Str_resident_use"));
	}	
	public void setStr_resident_use(String Str_resident_use) {
		setAttrVal("Str_resident_use", Str_resident_use);
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
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}	
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}	
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}	
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}	
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	public FDouble getRetire_ey_pri_max() {
		return ((FDouble) getAttrVal("Retire_ey_pri_max"));
	}	
	public void setRetire_ey_pri_max(FDouble Retire_ey_pri_max) {
		setAttrVal("Retire_ey_pri_max", Retire_ey_pri_max);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
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
		return "Id_srvfacdiff";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_AHMEDIDIFF_SRVFAC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedInsurSrvFacRecDiffDODesc.class);
	}
	
}