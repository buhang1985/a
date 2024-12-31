package iih.bd.pp.medinsurrecdiff.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.medinsurrecdiff.d.desc.MedInsurDrugRecDiffDODesc;
import java.math.BigDecimal;

/**
 * 医保药品记录差异 DO数据 
 * 
 */
public class MedInsurDrugRecDiffDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DRUGDIFF= "Id_drugdiff";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DIFF= "Id_diff";
	public static final String EU_DIFFTYPE= "Eu_difftype";
	public static final String ID_DOWN= "Id_down";
	public static final String NAME_ENGLISH= "Name_english";
	public static final String DRUG_TYPE= "Drug_type";
	public static final String STR_OCT= "Str_oct";
	public static final String DRUG_GRADE= "Drug_grade";
	public static final String DOSE_UNIT= "Dose_unit";
	public static final String DOSAGE= "Dosage";
	public static final String SINGLE_DOSE= "Single_dose";
	public static final String FREQ= "Freq";
	public static final String USAGE= "Usage";
	public static final String SPEC= "Spec";
	public static final String UNIT= "Unit";
	public static final String AMT_PREPAY_MAX= "Amt_prepay_max";
	public static final String STR_PREP_SELF= "Str_prep_self";
	public static final String HOSPITAL_CODE= "Hospital_code";
	public static final String STR_APPROVE= "Str_approve";
	public static final String MIN_HOSPITAL_RANK= "Min_hospital_rank";
	public static final String MIN_DOCTOR_RANK= "Min_doctor_rank";
	public static final String STR_ADD_INSUR= "Str_add_insur";
	public static final String STR_ADD_INSUR_SAL= "Str_add_insur_sal";
	public static final String STR_BIDDING_DRUG= "Str_bidding_drug";
	public static final String BIDDING_PRICE= "Bidding_price";
	public static final String STR_SPEC_DRUG= "Str_spec_drug";
	public static final String STR_TWO_INSURPAY= "Str_two_insurpay";
	public static final String DRUG_NAME= "Drug_name";
	public static final String DRUG_NAME_PRICE= "Drug_name_price";
	public static final String DRUG_NAME_PYCODE= "Drug_name_pycode";
	public static final String DRUG_NAME_WBCODE= "Drug_name_wbcode";
	public static final String PHARM_FIRM_NAME= "Pharm_firm_name";
	public static final String PRC_DRUG_CERTI= "Prc_drug_certi";
	public static final String ID_EMP_HANDLE= "Id_emp_handle";
	public static final String DT_HANDLE= "Dt_handle";
	public static final String PRC_DIREC_CODE= "Prc_direc_code";
	public static final String REFERENCE_PRICE= "Reference_price";
	public static final String REFERENCE_HOSPITAL= "Reference_hospital";
	public static final String ORIGIN_PLACE= "Origin_place";
	public static final String STR_EFFECTIVE= "Str_effective";
	public static final String STR_PRC_B_DRUGLIST= "Str_prc_b_druglist";
	public static final String STR_RESIDENT_USE= "Str_resident_use";
	public static final String SEX_LIMIT_PAY= "Sex_limit_pay";
	public static final String DISEASE_LIMIT_PAY= "Disease_limit_pay";
	public static final String PY_CODE= "Py_code";
	public static final String WB_CODE= "Wb_code";
	public static final String ZDY_CODE= "Zdy_code";
	public static final String STR_PRC_DRUGLIST= "Str_prc_druglist";
	public static final String MAX_USE_DAYS= "Max_use_days";
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
	public static final String RATE_SELF_OEP= "Rate_self_oep";
	public static final String RATE_SELF_IP= "Rate_self_ip";
	public static final String RATE_RETIRE= "Rate_retire";
	public static final String RATE_INJURY= "Rate_injury";
	public static final String RATE_BIRTH= "Rate_birth";
	public static final String RATE_EY= "Rate_ey";
	public static final String RATE_UNIT= "Rate_unit";
	public static final String RATE_FAMILY= "Rate_family";
	public static final String RATE_IMPORT_DIFF= "Rate_import_diff";
	public static final String NOTE= "Note";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public MedInsurDrugRecDiffDO () {
		super();
	}
	
	public String getId_drugdiff() {
		return ((String) getAttrVal("Id_drugdiff"));
	}	
	public void setId_drugdiff(String Id_drugdiff) {
		setAttrVal("Id_drugdiff", Id_drugdiff);
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
	public String getName_english() {
		return ((String) getAttrVal("Name_english"));
	}	
	public void setName_english(String Name_english) {
		setAttrVal("Name_english", Name_english);
	}
	public String getDrug_type() {
		return ((String) getAttrVal("Drug_type"));
	}	
	public void setDrug_type(String Drug_type) {
		setAttrVal("Drug_type", Drug_type);
	}
	public String getStr_oct() {
		return ((String) getAttrVal("Str_oct"));
	}	
	public void setStr_oct(String Str_oct) {
		setAttrVal("Str_oct", Str_oct);
	}
	public String getDrug_grade() {
		return ((String) getAttrVal("Drug_grade"));
	}	
	public void setDrug_grade(String Drug_grade) {
		setAttrVal("Drug_grade", Drug_grade);
	}
	public String getDose_unit() {
		return ((String) getAttrVal("Dose_unit"));
	}	
	public void setDose_unit(String Dose_unit) {
		setAttrVal("Dose_unit", Dose_unit);
	}
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}	
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	public FDouble getSingle_dose() {
		return ((FDouble) getAttrVal("Single_dose"));
	}	
	public void setSingle_dose(FDouble Single_dose) {
		setAttrVal("Single_dose", Single_dose);
	}
	public String getFreq() {
		return ((String) getAttrVal("Freq"));
	}	
	public void setFreq(String Freq) {
		setAttrVal("Freq", Freq);
	}
	public String getUsage() {
		return ((String) getAttrVal("Usage"));
	}	
	public void setUsage(String Usage) {
		setAttrVal("Usage", Usage);
	}
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}	
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	public FDouble getAmt_prepay_max() {
		return ((FDouble) getAttrVal("Amt_prepay_max"));
	}	
	public void setAmt_prepay_max(FDouble Amt_prepay_max) {
		setAttrVal("Amt_prepay_max", Amt_prepay_max);
	}
	public String getStr_prep_self() {
		return ((String) getAttrVal("Str_prep_self"));
	}	
	public void setStr_prep_self(String Str_prep_self) {
		setAttrVal("Str_prep_self", Str_prep_self);
	}
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	public String getStr_approve() {
		return ((String) getAttrVal("Str_approve"));
	}	
	public void setStr_approve(String Str_approve) {
		setAttrVal("Str_approve", Str_approve);
	}
	public String getMin_hospital_rank() {
		return ((String) getAttrVal("Min_hospital_rank"));
	}	
	public void setMin_hospital_rank(String Min_hospital_rank) {
		setAttrVal("Min_hospital_rank", Min_hospital_rank);
	}
	public String getMin_doctor_rank() {
		return ((String) getAttrVal("Min_doctor_rank"));
	}	
	public void setMin_doctor_rank(String Min_doctor_rank) {
		setAttrVal("Min_doctor_rank", Min_doctor_rank);
	}
	public String getStr_add_insur() {
		return ((String) getAttrVal("Str_add_insur"));
	}	
	public void setStr_add_insur(String Str_add_insur) {
		setAttrVal("Str_add_insur", Str_add_insur);
	}
	public String getStr_add_insur_sal() {
		return ((String) getAttrVal("Str_add_insur_sal"));
	}	
	public void setStr_add_insur_sal(String Str_add_insur_sal) {
		setAttrVal("Str_add_insur_sal", Str_add_insur_sal);
	}
	public String getStr_bidding_drug() {
		return ((String) getAttrVal("Str_bidding_drug"));
	}	
	public void setStr_bidding_drug(String Str_bidding_drug) {
		setAttrVal("Str_bidding_drug", Str_bidding_drug);
	}
	public FDouble getBidding_price() {
		return ((FDouble) getAttrVal("Bidding_price"));
	}	
	public void setBidding_price(FDouble Bidding_price) {
		setAttrVal("Bidding_price", Bidding_price);
	}
	public String getStr_spec_drug() {
		return ((String) getAttrVal("Str_spec_drug"));
	}	
	public void setStr_spec_drug(String Str_spec_drug) {
		setAttrVal("Str_spec_drug", Str_spec_drug);
	}
	public String getStr_two_insurpay() {
		return ((String) getAttrVal("Str_two_insurpay"));
	}	
	public void setStr_two_insurpay(String Str_two_insurpay) {
		setAttrVal("Str_two_insurpay", Str_two_insurpay);
	}
	public String getDrug_name() {
		return ((String) getAttrVal("Drug_name"));
	}	
	public void setDrug_name(String Drug_name) {
		setAttrVal("Drug_name", Drug_name);
	}
	public FDouble getDrug_name_price() {
		return ((FDouble) getAttrVal("Drug_name_price"));
	}	
	public void setDrug_name_price(FDouble Drug_name_price) {
		setAttrVal("Drug_name_price", Drug_name_price);
	}
	public String getDrug_name_pycode() {
		return ((String) getAttrVal("Drug_name_pycode"));
	}	
	public void setDrug_name_pycode(String Drug_name_pycode) {
		setAttrVal("Drug_name_pycode", Drug_name_pycode);
	}
	public String getDrug_name_wbcode() {
		return ((String) getAttrVal("Drug_name_wbcode"));
	}	
	public void setDrug_name_wbcode(String Drug_name_wbcode) {
		setAttrVal("Drug_name_wbcode", Drug_name_wbcode);
	}
	public String getPharm_firm_name() {
		return ((String) getAttrVal("Pharm_firm_name"));
	}	
	public void setPharm_firm_name(String Pharm_firm_name) {
		setAttrVal("Pharm_firm_name", Pharm_firm_name);
	}
	public String getPrc_drug_certi() {
		return ((String) getAttrVal("Prc_drug_certi"));
	}	
	public void setPrc_drug_certi(String Prc_drug_certi) {
		setAttrVal("Prc_drug_certi", Prc_drug_certi);
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
	public String getPrc_direc_code() {
		return ((String) getAttrVal("Prc_direc_code"));
	}	
	public void setPrc_direc_code(String Prc_direc_code) {
		setAttrVal("Prc_direc_code", Prc_direc_code);
	}
	public String getReference_price() {
		return ((String) getAttrVal("Reference_price"));
	}	
	public void setReference_price(String Reference_price) {
		setAttrVal("Reference_price", Reference_price);
	}
	public String getReference_hospital() {
		return ((String) getAttrVal("Reference_hospital"));
	}	
	public void setReference_hospital(String Reference_hospital) {
		setAttrVal("Reference_hospital", Reference_hospital);
	}
	public String getOrigin_place() {
		return ((String) getAttrVal("Origin_place"));
	}	
	public void setOrigin_place(String Origin_place) {
		setAttrVal("Origin_place", Origin_place);
	}
	public String getStr_effective() {
		return ((String) getAttrVal("Str_effective"));
	}	
	public void setStr_effective(String Str_effective) {
		setAttrVal("Str_effective", Str_effective);
	}
	public String getStr_prc_b_druglist() {
		return ((String) getAttrVal("Str_prc_b_druglist"));
	}	
	public void setStr_prc_b_druglist(String Str_prc_b_druglist) {
		setAttrVal("Str_prc_b_druglist", Str_prc_b_druglist);
	}
	public String getStr_resident_use() {
		return ((String) getAttrVal("Str_resident_use"));
	}	
	public void setStr_resident_use(String Str_resident_use) {
		setAttrVal("Str_resident_use", Str_resident_use);
	}
	public String getSex_limit_pay() {
		return ((String) getAttrVal("Sex_limit_pay"));
	}	
	public void setSex_limit_pay(String Sex_limit_pay) {
		setAttrVal("Sex_limit_pay", Sex_limit_pay);
	}
	public String getDisease_limit_pay() {
		return ((String) getAttrVal("Disease_limit_pay"));
	}	
	public void setDisease_limit_pay(String Disease_limit_pay) {
		setAttrVal("Disease_limit_pay", Disease_limit_pay);
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
	public String getStr_prc_druglist() {
		return ((String) getAttrVal("Str_prc_druglist"));
	}	
	public void setStr_prc_druglist(String Str_prc_druglist) {
		setAttrVal("Str_prc_druglist", Str_prc_druglist);
	}
	public String getMax_use_days() {
		return ((String) getAttrVal("Max_use_days"));
	}	
	public void setMax_use_days(String Max_use_days) {
		setAttrVal("Max_use_days", Max_use_days);
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
	public FDouble getRate_self_oep() {
		return ((FDouble) getAttrVal("Rate_self_oep"));
	}	
	public void setRate_self_oep(FDouble Rate_self_oep) {
		setAttrVal("Rate_self_oep", Rate_self_oep);
	}
	public FDouble getRate_self_ip() {
		return ((FDouble) getAttrVal("Rate_self_ip"));
	}	
	public void setRate_self_ip(FDouble Rate_self_ip) {
		setAttrVal("Rate_self_ip", Rate_self_ip);
	}
	public FDouble getRate_retire() {
		return ((FDouble) getAttrVal("Rate_retire"));
	}	
	public void setRate_retire(FDouble Rate_retire) {
		setAttrVal("Rate_retire", Rate_retire);
	}
	public FDouble getRate_injury() {
		return ((FDouble) getAttrVal("Rate_injury"));
	}	
	public void setRate_injury(FDouble Rate_injury) {
		setAttrVal("Rate_injury", Rate_injury);
	}
	public FDouble getRate_birth() {
		return ((FDouble) getAttrVal("Rate_birth"));
	}	
	public void setRate_birth(FDouble Rate_birth) {
		setAttrVal("Rate_birth", Rate_birth);
	}
	public FDouble getRate_ey() {
		return ((FDouble) getAttrVal("Rate_ey"));
	}	
	public void setRate_ey(FDouble Rate_ey) {
		setAttrVal("Rate_ey", Rate_ey);
	}
	public FDouble getRate_unit() {
		return ((FDouble) getAttrVal("Rate_unit"));
	}	
	public void setRate_unit(FDouble Rate_unit) {
		setAttrVal("Rate_unit", Rate_unit);
	}
	public FDouble getRate_family() {
		return ((FDouble) getAttrVal("Rate_family"));
	}	
	public void setRate_family(FDouble Rate_family) {
		setAttrVal("Rate_family", Rate_family);
	}
	public FDouble getRate_import_diff() {
		return ((FDouble) getAttrVal("Rate_import_diff"));
	}	
	public void setRate_import_diff(FDouble Rate_import_diff) {
		setAttrVal("Rate_import_diff", Rate_import_diff);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_drugdiff";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_AHMEDIDIFF_DRUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedInsurDrugRecDiffDODesc.class);
	}
	
}