package iih.mi.mibd.drug.d;

import iih.mi.mibd.drug.d.desc.DrugDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 药品 DO数据 
 * @author hexx
 */
public class DrugDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DRUG= "Id_drug";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MIS= "Id_mis";
	public static final String HOSPITAL_CODE= "Hospital_code";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String NAME_GENERIC= "Name_generic";
	public static final String NAME_ENGLISH= "Name_english";
	public static final String DRUG_TYPE= "Drug_type";
	public static final String CODE_CATE= "Code_cate";
	public static final String EU_FEELEVEL= "Eu_feelevel";
	public static final String PRICE= "Price";
	public static final String PRI_MAX= "Pri_max";
	public static final String DRUG_GRADE= "Drug_grade";
	public static final String APPNO= "Appno";
	public static final String FG_EFFECTIVE= "Fg_effective";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String DT_B= "Dt_b";
	public static final String DT_E= "Dt_e";
	public static final String LIMIT_FACTOR= "Limit_factor";
	public static final String PYCODE_GENERIC= "Pycode_generic";
	public static final String WBCODE_GENERIC= "Wbcode_generic";
	public static final String ZDYCODE_GENERIC= "Zdycode_generic";
	public static final String DOSE_UNIT= "Dose_unit";
	public static final String DOSAGE= "Dosage";
	public static final String SINGLE_DOSE= "Single_dose";
	public static final String FREQ= "Freq";
	public static final String USAGE= "Usage";
	public static final String SPEC= "Spec";
	public static final String UNIT= "Unit";
	public static final String AMT_PREPAY_MAX= "Amt_prepay_max";
	public static final String FG_PREP_SELF= "Fg_prep_self";
	public static final String FG_APPROVE= "Fg_approve";
	public static final String FG_OCT= "Fg_oct";
	public static final String MIN_HOSPITAL_RANK= "Min_hospital_rank";
	public static final String MIN_DOCTOR_RANK= "Min_doctor_rank";
	public static final String FG_ADD_INSUR= "Fg_add_insur";
	public static final String FG_ADD_INSUR_SAL= "Fg_add_insur_sal";
	public static final String FG_BIDDING_DRUG= "Fg_bidding_drug";
	public static final String PRICE_BIDDING= "Price_bidding";
	public static final String FG_SPEC_DRUG= "Fg_spec_drug";
	public static final String FG_TWO_INSURPAY= "Fg_two_insurpay";
	public static final String PHARM_FIRM_NAME= "Pharm_firm_name";
	public static final String EMP_HANDLE= "Emp_handle";
	public static final String DT_HANDLE= "Dt_handle";
	public static final String PRC_DIREC_CODE= "Prc_direc_code";
	public static final String REFERENCE_PRICE= "Reference_price";
	public static final String REFERENCE_HOSPITAL= "Reference_hospital";
	public static final String ORIGIN_PLACE= "Origin_place";
	public static final String FG_PRC_B_DRUGLIST= "Fg_prc_b_druglist";
	public static final String FG_RESIDENT_USE= "Fg_resident_use";
	public static final String SEX_LIMIT_PAY= "Sex_limit_pay";
	public static final String DISEASE_LIMIT_PAY= "Disease_limit_pay";
	public static final String FG_PRC_DRUGLIST= "Fg_prc_druglist";
	public static final String MAX_USE_DAYS= "Max_use_days";
	public static final String RETIRE_EY_PRI_MAX= "Retire_ey_pri_max";
	public static final String RATE_SELF_OEP= "Rate_self_oep";
	public static final String RATE_SELF_IP= "Rate_self_ip";
	public static final String RATE_RETIRE= "Rate_retire";
	public static final String RATE_INJURY= "Rate_injury";
	public static final String RATE_BIRTH= "Rate_birth";
	public static final String RATE_EY= "Rate_ey";
	public static final String RATE_UNIT= "Rate_unit";
	public static final String RATE_FAMILY= "Rate_family";
	public static final String RATE_IMPORT_DIFF= "Rate_import_diff";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MIS_NAME= "Mis_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_drug() {
		return ((String) getAttrVal("Id_drug"));
	}	
	public void setId_drug(String Id_drug) {
		setAttrVal("Id_drug", Id_drug);
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
	public String getId_mis() {
		return ((String) getAttrVal("Id_mis"));
	}	
	public void setId_mis(String Id_mis) {
		setAttrVal("Id_mis", Id_mis);
	}
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
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
	public String getName_generic() {
		return ((String) getAttrVal("Name_generic"));
	}	
	public void setName_generic(String Name_generic) {
		setAttrVal("Name_generic", Name_generic);
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
	public String getCode_cate() {
		return ((String) getAttrVal("Code_cate"));
	}	
	public void setCode_cate(String Code_cate) {
		setAttrVal("Code_cate", Code_cate);
	}
	public String getEu_feelevel() {
		return ((String) getAttrVal("Eu_feelevel"));
	}	
	public void setEu_feelevel(String Eu_feelevel) {
		setAttrVal("Eu_feelevel", Eu_feelevel);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}	
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	public String getDrug_grade() {
		return ((String) getAttrVal("Drug_grade"));
	}	
	public void setDrug_grade(String Drug_grade) {
		setAttrVal("Drug_grade", Drug_grade);
	}
	public String getAppno() {
		return ((String) getAttrVal("Appno"));
	}	
	public void setAppno(String Appno) {
		setAttrVal("Appno", Appno);
	}
	public String getFg_effective() {
		return ((String) getAttrVal("Fg_effective"));
	}	
	public void setFg_effective(String Fg_effective) {
		setAttrVal("Fg_effective", Fg_effective);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
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
	public String getLimit_factor() {
		return ((String) getAttrVal("Limit_factor"));
	}	
	public void setLimit_factor(String Limit_factor) {
		setAttrVal("Limit_factor", Limit_factor);
	}
	public String getPycode_generic() {
		return ((String) getAttrVal("Pycode_generic"));
	}	
	public void setPycode_generic(String Pycode_generic) {
		setAttrVal("Pycode_generic", Pycode_generic);
	}
	public String getWbcode_generic() {
		return ((String) getAttrVal("Wbcode_generic"));
	}	
	public void setWbcode_generic(String Wbcode_generic) {
		setAttrVal("Wbcode_generic", Wbcode_generic);
	}
	public String getZdycode_generic() {
		return ((String) getAttrVal("Zdycode_generic"));
	}	
	public void setZdycode_generic(String Zdycode_generic) {
		setAttrVal("Zdycode_generic", Zdycode_generic);
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
	public String getFg_prep_self() {
		return ((String) getAttrVal("Fg_prep_self"));
	}	
	public void setFg_prep_self(String Fg_prep_self) {
		setAttrVal("Fg_prep_self", Fg_prep_self);
	}
	public String getFg_approve() {
		return ((String) getAttrVal("Fg_approve"));
	}	
	public void setFg_approve(String Fg_approve) {
		setAttrVal("Fg_approve", Fg_approve);
	}
	public String getFg_oct() {
		return ((String) getAttrVal("Fg_oct"));
	}	
	public void setFg_oct(String Fg_oct) {
		setAttrVal("Fg_oct", Fg_oct);
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
	public String getFg_add_insur() {
		return ((String) getAttrVal("Fg_add_insur"));
	}	
	public void setFg_add_insur(String Fg_add_insur) {
		setAttrVal("Fg_add_insur", Fg_add_insur);
	}
	public String getFg_add_insur_sal() {
		return ((String) getAttrVal("Fg_add_insur_sal"));
	}	
	public void setFg_add_insur_sal(String Fg_add_insur_sal) {
		setAttrVal("Fg_add_insur_sal", Fg_add_insur_sal);
	}
	public String getFg_bidding_drug() {
		return ((String) getAttrVal("Fg_bidding_drug"));
	}	
	public void setFg_bidding_drug(String Fg_bidding_drug) {
		setAttrVal("Fg_bidding_drug", Fg_bidding_drug);
	}
	public FDouble getPrice_bidding() {
		return ((FDouble) getAttrVal("Price_bidding"));
	}	
	public void setPrice_bidding(FDouble Price_bidding) {
		setAttrVal("Price_bidding", Price_bidding);
	}
	public String getFg_spec_drug() {
		return ((String) getAttrVal("Fg_spec_drug"));
	}	
	public void setFg_spec_drug(String Fg_spec_drug) {
		setAttrVal("Fg_spec_drug", Fg_spec_drug);
	}
	public String getFg_two_insurpay() {
		return ((String) getAttrVal("Fg_two_insurpay"));
	}	
	public void setFg_two_insurpay(String Fg_two_insurpay) {
		setAttrVal("Fg_two_insurpay", Fg_two_insurpay);
	}
	public String getPharm_firm_name() {
		return ((String) getAttrVal("Pharm_firm_name"));
	}	
	public void setPharm_firm_name(String Pharm_firm_name) {
		setAttrVal("Pharm_firm_name", Pharm_firm_name);
	}
	public String getEmp_handle() {
		return ((String) getAttrVal("Emp_handle"));
	}	
	public void setEmp_handle(String Emp_handle) {
		setAttrVal("Emp_handle", Emp_handle);
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
	public FDouble getReference_price() {
		return ((FDouble) getAttrVal("Reference_price"));
	}	
	public void setReference_price(FDouble Reference_price) {
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
	public String getFg_prc_b_druglist() {
		return ((String) getAttrVal("Fg_prc_b_druglist"));
	}	
	public void setFg_prc_b_druglist(String Fg_prc_b_druglist) {
		setAttrVal("Fg_prc_b_druglist", Fg_prc_b_druglist);
	}
	public String getFg_resident_use() {
		return ((String) getAttrVal("Fg_resident_use"));
	}	
	public void setFg_resident_use(String Fg_resident_use) {
		setAttrVal("Fg_resident_use", Fg_resident_use);
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
	public String getFg_prc_druglist() {
		return ((String) getAttrVal("Fg_prc_druglist"));
	}	
	public void setFg_prc_druglist(String Fg_prc_druglist) {
		setAttrVal("Fg_prc_druglist", Fg_prc_druglist);
	}
	public String getMax_use_days() {
		return ((String) getAttrVal("Max_use_days"));
	}	
	public void setMax_use_days(String Max_use_days) {
		setAttrVal("Max_use_days", Max_use_days);
	}
	public FDouble getRetire_ey_pri_max() {
		return ((FDouble) getAttrVal("Retire_ey_pri_max"));
	}	
	public void setRetire_ey_pri_max(FDouble Retire_ey_pri_max) {
		setAttrVal("Retire_ey_pri_max", Retire_ey_pri_max);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getMis_name() {
		return ((String) getAttrVal("Mis_name"));
	}	
	public void setMis_name(String Mis_name) {
		setAttrVal("Mis_name", Mis_name);
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
		return "Id_drug";
	}
	
	@Override
	public String getTableName() {	  
		return "MI_BD_DRUG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DrugDODesc.class);
	}
	
}