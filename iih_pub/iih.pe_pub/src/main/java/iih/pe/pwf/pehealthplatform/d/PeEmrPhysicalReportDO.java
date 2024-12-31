package iih.pe.pwf.pehealthplatform.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.pehealthplatform.d.desc.PeEmrPhysicalReportDODesc;
import java.math.BigDecimal;

/**
 * 体检平台健康体检表 DO数据 
 * 
 */
public class PeEmrPhysicalReportDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID= "Id";
	public static final String PATIENT_ID= "Patient_id";
	public static final String HEALTH_EXAM_NO= "Health_exam_no";
	public static final String NAME= "Name";
	public static final String ID_NUM= "Id_num";
	public static final String SEX_CODE= "Sex_code";
	public static final String BORN_DATE= "Born_date";
	public static final String AGE= "Age";
	public static final String WORKING_ORG= "Working_org";
	public static final String BORN_PLACE= "Born_place";
	public static final String PROVINCE= "Province";
	public static final String CITY= "City";
	public static final String COUNTY= "County";
	public static final String TOWN= "Town";
	public static final String VILLAGE= "Village";
	public static final String HOUSE_NUM= "House_num";
	public static final String PHONE= "Phone";
	public static final String MARITAL_STATUS_CODE= "Marital_status_code";
	public static final String MARITAL_STATUS_NAME= "Marital_status_name";
	public static final String OCCUPATION_CODE= "Occupation_code";
	public static final String OCCUPATION_NAME= "Occupation_name";
	public static final String SMOKE= "Smoke";
	public static final String SMOKE_YEAR= "Smoke_year";
	public static final String DRINK= "Drink";
	public static final String DRINK_YEAR= "Drink_year";
	public static final String HABBIT= "Habbit";
	public static final String NATION_CODE= "Nation_code";
	public static final String NATION_NAME= "Nation_name";
	public static final String BLOOD_TYPE= "Blood_type";
	public static final String HEIGHT= "Height";
	public static final String WEIGHT= "Weight";
	public static final String DIA_CODE= "Dia_code";
	public static final String DIA_NAME= "Dia_name";
	public static final String START_DTIME= "Start_dtime";
	public static final String END_DTIME= "End_dtime";
	public static final String EXAM_SUMMARY= "Exam_summary";
	public static final String EXAM_TYPE= "Exam_type";
	public static final String EXAM_NAME= "Exam_name";
	public static final String EXAM_RESULT_CODE= "Exam_result_code";
	public static final String EXAM_RESULT_NAME= "Exam_result_name";
	public static final String ZJ_DOC_ID_NUM= "Zj_doc_id_num";
	public static final String ZJ_DOC_NAME= "Zj_doc_name";
	public static final String DIAG_EXPLAN= "Diag_explan";
	public static final String FOOD_GUIDANCE= "Food_guidance";
	public static final String SUMMARIZE_TIME= "Summarize_time";
	public static final String NOTES= "Notes";
	public static final String CHECK_DOCTOR_IDCARD= "Check_doctor_idcard";
	public static final String CHECK_DOCTOR= "Check_doctor";
	public static final String CHECK_TIME= "Check_time";
	public static final String PRINT_TIME= "Print_time";
	public static final String TOTAL_AMOUNT= "Total_amount";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String DISTRICT_CODE= "District_code";
	public static final String EXCHANGE_TYPE= "Exchange_type";
	public static final String SYSTEM_TIME= "System_time";
	
	public String getId() {
		return ((String) getAttrVal("Id"));
	}	
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}	
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	public String getHealth_exam_no() {
		return ((String) getAttrVal("Health_exam_no"));
	}	
	public void setHealth_exam_no(String Health_exam_no) {
		setAttrVal("Health_exam_no", Health_exam_no);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_num() {
		return ((String) getAttrVal("Id_num"));
	}	
	public void setId_num(String Id_num) {
		setAttrVal("Id_num", Id_num);
	}
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	public String getBorn_date() {
		return ((String) getAttrVal("Born_date"));
	}	
	public void setBorn_date(String Born_date) {
		setAttrVal("Born_date", Born_date);
	}
	public FDouble getAge() {
		return ((FDouble) getAttrVal("Age"));
	}	
	public void setAge(FDouble Age) {
		setAttrVal("Age", Age);
	}
	public String getWorking_org() {
		return ((String) getAttrVal("Working_org"));
	}	
	public void setWorking_org(String Working_org) {
		setAttrVal("Working_org", Working_org);
	}
	public String getBorn_place() {
		return ((String) getAttrVal("Born_place"));
	}	
	public void setBorn_place(String Born_place) {
		setAttrVal("Born_place", Born_place);
	}
	public String getProvince() {
		return ((String) getAttrVal("Province"));
	}	
	public void setProvince(String Province) {
		setAttrVal("Province", Province);
	}
	public String getCity() {
		return ((String) getAttrVal("City"));
	}	
	public void setCity(String City) {
		setAttrVal("City", City);
	}
	public String getCounty() {
		return ((String) getAttrVal("County"));
	}	
	public void setCounty(String County) {
		setAttrVal("County", County);
	}
	public String getTown() {
		return ((String) getAttrVal("Town"));
	}	
	public void setTown(String Town) {
		setAttrVal("Town", Town);
	}
	public String getVillage() {
		return ((String) getAttrVal("Village"));
	}	
	public void setVillage(String Village) {
		setAttrVal("Village", Village);
	}
	public String getHouse_num() {
		return ((String) getAttrVal("House_num"));
	}	
	public void setHouse_num(String House_num) {
		setAttrVal("House_num", House_num);
	}
	public String getPhone() {
		return ((String) getAttrVal("Phone"));
	}	
	public void setPhone(String Phone) {
		setAttrVal("Phone", Phone);
	}
	public String getMarital_status_code() {
		return ((String) getAttrVal("Marital_status_code"));
	}	
	public void setMarital_status_code(String Marital_status_code) {
		setAttrVal("Marital_status_code", Marital_status_code);
	}
	public String getMarital_status_name() {
		return ((String) getAttrVal("Marital_status_name"));
	}	
	public void setMarital_status_name(String Marital_status_name) {
		setAttrVal("Marital_status_name", Marital_status_name);
	}
	public String getOccupation_code() {
		return ((String) getAttrVal("Occupation_code"));
	}	
	public void setOccupation_code(String Occupation_code) {
		setAttrVal("Occupation_code", Occupation_code);
	}
	public String getOccupation_name() {
		return ((String) getAttrVal("Occupation_name"));
	}	
	public void setOccupation_name(String Occupation_name) {
		setAttrVal("Occupation_name", Occupation_name);
	}
	public String getSmoke() {
		return ((String) getAttrVal("Smoke"));
	}	
	public void setSmoke(String Smoke) {
		setAttrVal("Smoke", Smoke);
	}
	public String getSmoke_year() {
		return ((String) getAttrVal("Smoke_year"));
	}	
	public void setSmoke_year(String Smoke_year) {
		setAttrVal("Smoke_year", Smoke_year);
	}
	public String getDrink() {
		return ((String) getAttrVal("Drink"));
	}	
	public void setDrink(String Drink) {
		setAttrVal("Drink", Drink);
	}
	public String getDrink_year() {
		return ((String) getAttrVal("Drink_year"));
	}	
	public void setDrink_year(String Drink_year) {
		setAttrVal("Drink_year", Drink_year);
	}
	public String getHabbit() {
		return ((String) getAttrVal("Habbit"));
	}	
	public void setHabbit(String Habbit) {
		setAttrVal("Habbit", Habbit);
	}
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	public String getNation_name() {
		return ((String) getAttrVal("Nation_name"));
	}	
	public void setNation_name(String Nation_name) {
		setAttrVal("Nation_name", Nation_name);
	}
	public String getBlood_type() {
		return ((String) getAttrVal("Blood_type"));
	}	
	public void setBlood_type(String Blood_type) {
		setAttrVal("Blood_type", Blood_type);
	}
	public FDouble getHeight() {
		return ((FDouble) getAttrVal("Height"));
	}	
	public void setHeight(FDouble Height) {
		setAttrVal("Height", Height);
	}
	public FDouble getWeight() {
		return ((FDouble) getAttrVal("Weight"));
	}	
	public void setWeight(FDouble Weight) {
		setAttrVal("Weight", Weight);
	}
	public String getDia_code() {
		return ((String) getAttrVal("Dia_code"));
	}	
	public void setDia_code(String Dia_code) {
		setAttrVal("Dia_code", Dia_code);
	}
	public String getDia_name() {
		return ((String) getAttrVal("Dia_name"));
	}	
	public void setDia_name(String Dia_name) {
		setAttrVal("Dia_name", Dia_name);
	}
	public String getStart_dtime() {
		return ((String) getAttrVal("Start_dtime"));
	}	
	public void setStart_dtime(String Start_dtime) {
		setAttrVal("Start_dtime", Start_dtime);
	}
	public String getEnd_dtime() {
		return ((String) getAttrVal("End_dtime"));
	}	
	public void setEnd_dtime(String End_dtime) {
		setAttrVal("End_dtime", End_dtime);
	}
	public String getExam_summary() {
		return ((String) getAttrVal("Exam_summary"));
	}	
	public void setExam_summary(String Exam_summary) {
		setAttrVal("Exam_summary", Exam_summary);
	}
	public String getExam_type() {
		return ((String) getAttrVal("Exam_type"));
	}	
	public void setExam_type(String Exam_type) {
		setAttrVal("Exam_type", Exam_type);
	}
	public String getExam_name() {
		return ((String) getAttrVal("Exam_name"));
	}	
	public void setExam_name(String Exam_name) {
		setAttrVal("Exam_name", Exam_name);
	}
	public String getExam_result_code() {
		return ((String) getAttrVal("Exam_result_code"));
	}	
	public void setExam_result_code(String Exam_result_code) {
		setAttrVal("Exam_result_code", Exam_result_code);
	}
	public String getExam_result_name() {
		return ((String) getAttrVal("Exam_result_name"));
	}	
	public void setExam_result_name(String Exam_result_name) {
		setAttrVal("Exam_result_name", Exam_result_name);
	}
	public String getZj_doc_id_num() {
		return ((String) getAttrVal("Zj_doc_id_num"));
	}	
	public void setZj_doc_id_num(String Zj_doc_id_num) {
		setAttrVal("Zj_doc_id_num", Zj_doc_id_num);
	}
	public String getZj_doc_name() {
		return ((String) getAttrVal("Zj_doc_name"));
	}	
	public void setZj_doc_name(String Zj_doc_name) {
		setAttrVal("Zj_doc_name", Zj_doc_name);
	}
	public String getDiag_explan() {
		return ((String) getAttrVal("Diag_explan"));
	}	
	public void setDiag_explan(String Diag_explan) {
		setAttrVal("Diag_explan", Diag_explan);
	}
	public String getFood_guidance() {
		return ((String) getAttrVal("Food_guidance"));
	}	
	public void setFood_guidance(String Food_guidance) {
		setAttrVal("Food_guidance", Food_guidance);
	}
	public String getSummarize_time() {
		return ((String) getAttrVal("Summarize_time"));
	}	
	public void setSummarize_time(String Summarize_time) {
		setAttrVal("Summarize_time", Summarize_time);
	}
	public String getNotes() {
		return ((String) getAttrVal("Notes"));
	}	
	public void setNotes(String Notes) {
		setAttrVal("Notes", Notes);
	}
	public String getCheck_doctor_idcard() {
		return ((String) getAttrVal("Check_doctor_idcard"));
	}	
	public void setCheck_doctor_idcard(String Check_doctor_idcard) {
		setAttrVal("Check_doctor_idcard", Check_doctor_idcard);
	}
	public String getCheck_doctor() {
		return ((String) getAttrVal("Check_doctor"));
	}	
	public void setCheck_doctor(String Check_doctor) {
		setAttrVal("Check_doctor", Check_doctor);
	}
	public String getCheck_time() {
		return ((String) getAttrVal("Check_time"));
	}	
	public void setCheck_time(String Check_time) {
		setAttrVal("Check_time", Check_time);
	}
	public String getPrint_time() {
		return ((String) getAttrVal("Print_time"));
	}	
	public void setPrint_time(String Print_time) {
		setAttrVal("Print_time", Print_time);
	}
	public FDouble getTotal_amount() {
		return ((FDouble) getAttrVal("Total_amount"));
	}	
	public void setTotal_amount(FDouble Total_amount) {
		setAttrVal("Total_amount", Total_amount);
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
	public String getDistrict_code() {
		return ((String) getAttrVal("District_code"));
	}	
	public void setDistrict_code(String District_code) {
		setAttrVal("District_code", District_code);
	}
	public String getExchange_type() {
		return ((String) getAttrVal("Exchange_type"));
	}	
	public void setExchange_type(String Exchange_type) {
		setAttrVal("Exchange_type", Exchange_type);
	}
	public String getSystem_time() {
		return ((String) getAttrVal("System_time"));
	}	
	public void setSystem_time(String System_time) {
		setAttrVal("System_time", System_time);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id";
	}
	
	@Override
	public String getTableName() {	  
		return "emr_physical_report";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeEmrPhysicalReportDODesc.class);
	}
	
}